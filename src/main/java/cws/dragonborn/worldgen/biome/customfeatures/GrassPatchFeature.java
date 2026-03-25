package cws.dragonborn.worldgen.biome.customfeatures;

import com.mojang.serialization.Codec;
import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class GrassPatchFeature extends Feature<GrassPatchConfiguration> {
    public GrassPatchFeature(Codec<GrassPatchConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<GrassPatchConfiguration> context) {
        BlockPos origin = context.origin();
        LevelAccessor level = context.level();
        GrassPatchConfiguration config = context.config();
        RandomSource random = context.random();


        for (int i = 0; i < config.count; i++) {
            int dx = origin.getX() + random.nextInt(config.radius * 2 + 1) - config.radius;
            int dz = origin.getZ() + random.nextInt(config.radius * 2 + 1) - config.radius;
            int y = level.getHeight(Heightmap.Types.WORLD_SURFACE, dx, dz);

            BlockPos pos = new BlockPos(dx, y, dz);
            BlockPos below = pos.below();
            BlockState belowState = level.getBlockState(below);
            BlockState atState    = level.getBlockState(pos);

            if (atState.isAir()){
                if (config.validBlocks.test(belowState, random)) {
                    level.setBlock(pos, config.stateProvider.getState(random, pos), 2);
                }
            }
        }
            return true;
    }
}
//level.setBlock(pos, config.stateProvider.getState(random, pos), 2);
