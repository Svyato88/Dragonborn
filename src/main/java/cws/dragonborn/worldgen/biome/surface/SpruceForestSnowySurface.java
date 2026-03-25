package cws.dragonborn.worldgen.biome.surface;


import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.worldgen.biome.biomes.Spruce_forest_cold;
import cws.dragonborn.worldgen.biome.biomes.Spruce_forest_snowy;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class SpruceForestSnowySurface {
    private static final SurfaceRules.RuleSource SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final SurfaceRules.RuleSource WHITE_DIRT = makeStateRule(ModBlocks.WHITE_DIRT.get());
    private static final SurfaceRules.RuleSource STONE = makeStateRule(ModBlocks.STONE.get());

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Spruce_forest_snowy.SNOWY_SPRUCE_FOREST),
                        SurfaceRules.sequence(
                                //on river floor
                                SurfaceRules.ifTrue(
                                        SurfaceRules.not(isAtOrAboveWaterLevel),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.UNDER_FLOOR,
                                                makeStateRule(ModBlocks.DARK_DIRT.get()))),
                                //on normal surface
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SNOW_BLOCK),
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, WHITE_DIRT),
                                SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, STONE)
                        )
                )
        );
    }
    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
