package cws.dragonborn.multiblock;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import cws.dragonborn.Dragonborn;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class MultiblockSchema {

    public record BlockEntry(BlockPos pos, BlockState state) {}

    private final List<BlockEntry> blocks;

    private MultiblockSchema(List<BlockEntry> blocks) {
        this.blocks = blocks;
    }

    public List<BlockEntry> getBlocks() { return blocks; }

    // --- Завантаження з JSON ---

    public static MultiblockSchema load(ResourceLocation rl) {
        String path = "/data/" + rl.getNamespace() + "/multiblocks/" + rl.getPath() + ".json";

        try (InputStream stream = MultiblockSchema.class.getResourceAsStream(path)) {
            if (stream == null) throw new RuntimeException("Multiblock file not found: " + path);

            JsonObject root = GsonHelper.parse(new InputStreamReader(stream));
            return parse(root);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load multiblock: " + path, e);
        }
    }

    private static MultiblockSchema parse(JsonObject root) {
        // 1. Парсимо палітру
        JsonArray paletteJson = root.getAsJsonArray("palette");
        List<BlockState> palette = new ArrayList<>();

        for (JsonElement entry : paletteJson) {
            palette.add(parseBlockState(entry));
        }

        // 2. Парсимо блоки
        JsonArray blocksJson = root.getAsJsonArray("blocks");
        List<BlockEntry> blocks = new ArrayList<>();

        for (JsonElement element : blocksJson) {
            JsonObject obj = element.getAsJsonObject();

            JsonArray posArr = obj.getAsJsonArray("pos");
            BlockPos pos = new BlockPos(
                    posArr.get(0).getAsInt(),
                    posArr.get(1).getAsInt(),
                    posArr.get(2).getAsInt()
            );

            int stateIndex = obj.get("state").getAsInt();
            BlockState state = palette.get(stateIndex);

            blocks.add(new BlockEntry(pos, state));
        }

        return new MultiblockSchema(blocks);
    }

    private static BlockState parseBlockState(JsonElement element) {
        String blockId;
        Map<String, String> properties = new HashMap<>();

        if (element.isJsonPrimitive()) {
            // просто "minecraft:iron_block"
            blockId = element.getAsString();
        } else {
            JsonObject obj = element.getAsJsonObject();
            blockId = obj.get("block").getAsString();

            if (obj.has("properties")) {
                obj.getAsJsonObject("properties").entrySet()
                        .forEach(e -> properties.put(e.getKey(), e.getValue().getAsString()));
            }
        }

        Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(blockId));
        if (block == null) throw new RuntimeException("Unknown block: " + blockId);

        BlockState state = block.defaultBlockState();

        for (Map.Entry<String, String> prop : properties.entrySet()) {
            state = applyProperty(state, prop.getKey(), prop.getValue());
        }

        return state;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static BlockState applyProperty(BlockState state, String key, String value) {
        for (Property<?> property : state.getProperties()) {
            if (property.getName().equals(key)) {
                Optional<?> parsed = property.getValue(value);
                if (parsed.isPresent()) {
                    return state.setValue((Property) property, (Comparable) parsed.get());
                }
            }
        }
        Dragonborn.LOGGER.warn("Unknown property '{}' for block {}", key, state.getBlock());
        return state;
    }
}