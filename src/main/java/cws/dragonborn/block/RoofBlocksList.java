package cws.dragonborn.block;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public enum RoofBlocksList implements StringRepresentable {
    AIR("air", Blocks.AIR, "dragonborn:block/air"),
    PLANKS_WALL("planks_wall", Blocks.OAK_PLANKS, "dragonborn:block/planks_wall_for_roof"),
    STONE("stone",Blocks.STONE, "dragonborn:block/stone"),
    BRICKS("bricks", Blocks.STONE_BRICKS, "dragonborn:block/stone_wall"),
    WOODEN_WALL("wooden_wall", Blocks.SPRUCE_PLANKS, "dragonborn:block/wooden_wall"),
    DRY_LOG("dry_log", Blocks.SPRUCE_LOG, "dragonborn:block/trees/dry_log");

    private final String id;
    private final Block block;
    private final ResourceLocation texture;
    private final String texturePath;

    RoofBlocksList(String id, Block block, String texturePath) {
        this.id = id;
        this.block = block;
        this.texturePath = texturePath;
        this.texture = new ResourceLocation(texturePath);
    }

    public ResourceLocation getTexture() {
        String[] parts = texturePath.split(":");
        return new ResourceLocation(parts[0], parts[1]);
    }

    @Override
    public String getSerializedName() {
        return id;
    }

    public Block getBlock() {
        return block;
    }

    public static @Nullable RoofBlocksList fromBlock(Block block) {
        for (RoofBlocksList type : values()) {
            if (type.block == block) return type;
        }
        return null;
    }
}

