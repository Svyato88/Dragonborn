package cws.dragonborn.worldgen.biome.customfeatures;

import com.mojang.serialization.Codec;
import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class SnowPlaceFeature extends Feature<SnowPlaceConfigured> {

    public SnowPlaceFeature(Codec<SnowPlaceConfigured> p_65786_) {
        super(p_65786_);
    }

    private boolean hasHorizontalSnow(WorldGenLevel level, BlockPos pos) {
        return level.getBlockState(pos.north()).is(Blocks.SNOW_BLOCK)
                || level.getBlockState(pos.south()).is(Blocks.SNOW_BLOCK)
                || level.getBlockState(pos.west()).is(Blocks.SNOW_BLOCK)
                || level.getBlockState(pos.east()).is(Blocks.SNOW_BLOCK);
    }
    private boolean hasHorizontalSnowLayer(WorldGenLevel level, BlockPos pos) {
        return (level.getBlockState(pos.north()).is(Blocks.SNOW) && level.getBlockState(pos.north()).getValue(SnowLayerBlock.LAYERS) == 5)
                || (level.getBlockState(pos.south()).is(Blocks.SNOW) && level.getBlockState(pos.south()).getValue(SnowLayerBlock.LAYERS) == 5)
                || (level.getBlockState(pos.west()).is(Blocks.SNOW) && level.getBlockState(pos.west()).getValue(SnowLayerBlock.LAYERS) == 5)
                || (level.getBlockState(pos.east()).is(Blocks.SNOW) && level.getBlockState(pos.east()).getValue(SnowLayerBlock.LAYERS) == 5);
    }
    @Override
    public boolean place(FeaturePlaceContext<SnowPlaceConfigured> context) {
        WorldGenLevel level = context.level();
        ChunkPos chunkPos = new ChunkPos(context.origin());

        for (int dx = 0; dx < 16; dx++) {
            for (int dz = 0; dz < 16; dz++) {

                int x = chunkPos.getMinBlockX() + dx;
                int z = chunkPos.getMinBlockZ() + dz;
                int y = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z);

                BlockPos pos = new BlockPos(x, y, z);
                BlockState stateBelow = level.getBlockState(pos.below());

                if (hasHorizontalSnow(level, pos) && stateBelow.is(Blocks.SNOW_BLOCK)) {
                    level.setBlock(pos, Blocks.SNOW.defaultBlockState().setValue(SnowLayerBlock.LAYERS,5), 2);
                }
                else if (hasHorizontalSnowLayer(level, pos) && stateBelow.is(Blocks.SNOW_BLOCK)) {
                    level.setBlock(pos, Blocks.SNOW.defaultBlockState().setValue(SnowLayerBlock.LAYERS,2), 2);
                }
            }
        }
        return true;
    }
}