package cws.dragonborn.worldgen.biome.customfeatures;

import com.mojang.serialization.Codec;
import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class HillsFeaturePlace extends Feature<HillsFeaturePlaceConfigured> {

    public HillsFeaturePlace(Codec<HillsFeaturePlaceConfigured> p_65786_) {
        super(p_65786_);
    }

    private boolean hasHorizontalAir(WorldGenLevel level, BlockPos pos) {
        return level.getBlockState(pos.north()).isAir()
                || level.getBlockState(pos.south()).isAir()
                || level.getBlockState(pos.west()).isAir()
                || level.getBlockState(pos.east()).isAir();
    }

    private boolean hasValidNeighborSurface(WorldGenLevel level, int x, int z) {
        return isValidSurface(level, x + 1, z)
                || isValidSurface(level, x - 1, z)
                || isValidSurface(level, x, z + 1)
                || isValidSurface(level, x, z - 1);
    }

    private boolean isValidSurface(WorldGenLevel level, int x, int z) {
        int y = level.getHeight(
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                x, z
        );

        BlockState state = level.getBlockState(new BlockPos(x, y - 1, z));

        return state.is(ModTags.Blocks.HILLS_FEATURE_PLACE);
    }

    private void replaceDown(WorldGenLevel level, BlockPos startPos, int depth) {
        BlockPos.MutableBlockPos mutable = startPos.mutable();

        for (int i = 0; i < depth; i++) {
            if (level.isEmptyBlock(mutable)) {
                break;
            }
            level.setBlock(
                    mutable,
                    ModBlocks.STONE.get().defaultBlockState(),
                    2
            );
            mutable.move(Direction.DOWN);
        }
    }

    @Override
    public boolean place(FeaturePlaceContext<HillsFeaturePlaceConfigured> context) {

        WorldGenLevel level = context.level();
        ChunkPos chunkPos = new ChunkPos(context.origin());

        HillsFeaturePlaceConfigured config = context.config();

        for (int dx = 0; dx < 16; dx++) {
            for (int dz = 0; dz < 16; dz++) {

                int x = chunkPos.getMinBlockX() + dx;
                int z = chunkPos.getMinBlockZ() + dz;

                int center = level.getHeight(
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z
                );

                int h1 = level.getHeight(
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x + 1, z
                );
                int h2 = level.getHeight(
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x - 1, z
                );
                int h3 = level.getHeight(
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z + 1
                );
                int h4 = level.getHeight(
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z - 1
                );

                int max = Math.max(
                        Math.max(h1, h2),
                        Math.max(h3, h4)
                );
                int min = Math.min(
                        Math.min(h1, h2),
                        Math.min(h3, h4)
                );

                if (max - min < config.threshold()) continue;

                BlockPos pos = new BlockPos(x, center - 1, z);
                BlockState state = level.getBlockState(pos);

                if (state.is(ModTags.Blocks.HILLS_FEATURE_PLACE)
                        && hasHorizontalAir(level, pos)
                        && hasValidNeighborSurface(level, x, z)
                ) {
                    replaceDown(level, pos, 7);
                }
            }
        }
        return true;
    }
}