package cws.dragonborn.worldgen.biome.surface;

import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.worldgen.biome.biomes.Spruce_forest;
import cws.dragonborn.worldgen.biome.biomes.Whiterun_plains;
import cws.dragonborn.worldgen.biome.surface.noises.ModNoises;
import cws.dragonborn.worldgen.density.ModDensityFunctions;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class WhiterunPlainsSurface {
    private static final SurfaceRules.RuleSource GRASS_BLOCK_FULL = makeStateRule(ModBlocks.GRASS_BLOCK_FULL.get());
    private static final SurfaceRules.RuleSource GRAY_DIRT = makeStateRule(ModBlocks.GRAY_DIRT.get());
    private static final SurfaceRules.RuleSource STONE = makeStateRule(ModBlocks.STONE.get());

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Whiterun_plains.WHITERUN_PLAINS),
                        SurfaceRules.sequence(
                                //on river floor
                                SurfaceRules.ifTrue(
                                        SurfaceRules.not(isAtOrAboveWaterLevel),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.UNDER_FLOOR,
                                                makeStateRule(ModBlocks.DARK_DIRT.get()))),
                                //on normal surface
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(ModNoises.GRAY_DIRT_LITTLE_ROCKS, 0.6D, 1.0D),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.ON_FLOOR,
                                                makeStateRule(ModBlocks.GRAY_DIRT_LITTLE_ROCKS.get()))),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(ModNoises.WHITE_DIRT, 0.4D, 0.8D),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.ON_FLOOR,
                                                makeStateRule(ModBlocks.DARK_DIRT.get()))),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRASS_BLOCK_FULL),
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, GRAY_DIRT),
                                SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, STONE)

                        )
                )
        );
    }
    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
