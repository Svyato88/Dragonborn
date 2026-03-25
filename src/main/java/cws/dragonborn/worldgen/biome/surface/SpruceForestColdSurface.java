package cws.dragonborn.worldgen.biome.surface;


import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.worldgen.biome.biomes.Spruce_forest;
import cws.dragonborn.worldgen.biome.biomes.Spruce_forest_cold;
import cws.dragonborn.worldgen.biome.surface.noises.ModNoises;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class SpruceForestColdSurface {
    private static final SurfaceRules.RuleSource PODZOL = makeStateRule(ModBlocks.PODZOL.get());
    private static final SurfaceRules.RuleSource PODZOL_LUSH = makeStateRule(ModBlocks.PODZOL_LUSH.get());
    private static final SurfaceRules.RuleSource GRAY_DIRT = makeStateRule(ModBlocks.GRAY_DIRT.get());
    private static final SurfaceRules.RuleSource STONE = makeStateRule(ModBlocks.STONE.get());

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Spruce_forest_cold.SPRUCE_FOREST_COLD),
                        SurfaceRules.sequence(
                                //on river floor
                                SurfaceRules.ifTrue(
                                        SurfaceRules.not(isAtOrAboveWaterLevel),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.UNDER_FLOOR, makeStateRule(ModBlocks.DARK_DIRT.get()))),
                                //on normal surface
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(ModNoises.WHITE_DIRT, 0.2D, 0.8D),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.ON_FLOOR,
                                                makeStateRule(ModBlocks.PODZOL.get())
                                        )
                                ),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, PODZOL_LUSH),
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
