package cws.dragonborn.worldgen.biome.customfeatures;

import com.mojang.serialization.Codec;
import cws.dragonborn.Dragonborn;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.logging.Logger;

public class SpawnFeatureInRadius extends Feature<SpawnFeatureInRadiusConfiguration> {

    public SpawnFeatureInRadius(Codec<SpawnFeatureInRadiusConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SpawnFeatureInRadiusConfiguration> context) {

        BlockPos origin = context.origin();
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        SpawnFeatureInRadiusConfiguration config = context.config();

        for (int i = 0; i < config.count; i++) {

            int dx = origin.getX() + random.nextInt(config.radius * 2 + 1) - config.radius;
            int dz = origin.getZ() + random.nextInt(config.radius * 2 + 1) - config.radius;
            int y = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, dx, dz);

            BlockPos pos = new BlockPos(dx, y, dz);
            BlockPos below = pos.below();
            BlockState belowState = level.getBlockState(below);

            if (config.validBlocks.test(belowState, random)) {
                config.feature.value().place(
                        level,
                        context.chunkGenerator(),
                        random,
                        pos
                );
                Dragonborn.LOGGER.info("[FeaturePatch] Placing at: {}, feature: {}", pos, config);
            }
        }
        return true;
    }
}