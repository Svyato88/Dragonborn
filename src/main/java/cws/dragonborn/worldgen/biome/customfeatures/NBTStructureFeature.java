package cws.dragonborn.worldgen.biome.customfeatures;

import com.mojang.serialization.Codec;
import cws.dragonborn.Dragonborn;
import cws.dragonborn.worldgen.biome.proccesors.ModProcessors;
import cws.dragonborn.worldgen.biome.proccesors.NBTBlockCheckProcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import java.util.List;
import java.util.Optional;

import static net.minecraft.world.level.block.Rotation.*;

public class NBTStructureFeature extends Feature<NBTConfiguration> {
    public NBTStructureFeature(Codec<NBTConfiguration> codec) {
        super(codec);
    }


    private static BlockPos rotateOffset(BlockPos offset, Rotation rotation) {
        return switch (rotation) {
            case NONE -> offset;
            case CLOCKWISE_90 -> new BlockPos(-offset.getZ(), offset.getY(), offset.getX());
            case CLOCKWISE_180 -> new BlockPos(-offset.getX(), offset.getY(), -offset.getZ());
            case COUNTERCLOCKWISE_90 -> new BlockPos(offset.getZ(), offset.getY(), -offset.getX());
        };
    }

    @Override
    public boolean place(FeaturePlaceContext<NBTConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        NBTConfiguration config = context.config();


        Dragonborn.LOGGER.info("[NBTStructureFeature] Trying to generate at {}, config: {}", origin, config);

        MinecraftServer server = level.getLevel().getServer();
        if (server == null) {
            Dragonborn.LOGGER.error("[NBTStructureFeature] Server is null!");
            return false;
        }

        List<ResourceLocation> structures = config.structureList;
        if (structures == null || structures.isEmpty()) {
            Dragonborn.LOGGER.warn("[NBTStructureFeature] Structure list is empty or null!");
            return false;
        }

        ResourceLocation structureRL = structures.get(random.nextInt(structures.size()));
        Dragonborn.LOGGER.info("[NBTStructureFeature] Selected structure: {}", structureRL);

        String nbtPath = "/data/" + structureRL.getNamespace() + "/structures/" + structureRL.getPath() + ".nbt";
        Dragonborn.LOGGER.info("[NBTStructureFeature] Expected .nbt path: {}", nbtPath);

        StructureTemplateManager templateManager = server.getStructureManager();
        Optional<StructureTemplate> templateOptional = templateManager.get(structureRL);
        if (templateOptional.isEmpty()) {
            Dragonborn.LOGGER.error("[NBTStructureFeature] Failed to load structure: {}", structureRL);
            return false;
        }

        StructureTemplate template = templateOptional.get();

        Rotation rotation = Rotation.values()[random.nextInt(Rotation.values().length)];
        Mirror mirror = Mirror.NONE;

        BlockPos offset = config.offset;

        BlockPos rotatedOffset = rotateOffset(offset, rotation);
        BlockPos finalPos = origin.offset(rotatedOffset);


        Dragonborn.LOGGER.info("[NBTStructureFeature] Placing at: {}, rotation: {}", finalPos, rotation);

        boolean success = template.placeInWorld(
                level,
                finalPos,
                finalPos,
                new StructurePlaceSettings()
                        .setRotation(rotation)
                        .setMirror(mirror)
                        .setIgnoreEntities(false)
                        .addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK)
                        .addProcessor(new NBTBlockCheckProcessor()),
                random,
                2
        );

        if (success) {
            Dragonborn.LOGGER.info("[NBTStructureFeature] Structure placed successfully at {}", finalPos);
        } else {
            Dragonborn.LOGGER.warn("[NBTStructureFeature] Structure failed to place at {}", finalPos);
        }

        return success;
    }
}
