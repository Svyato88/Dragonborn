package cws.dragonborn.worldgen.biome.surface;


import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.worldgen.biome.biomes.Spruce_forest;
import cws.dragonborn.worldgen.biome.biomes.Whiterun_plains;
import cws.dragonborn.worldgen.biome.surface.noises.ModNoises;
import cws.dragonborn.worldgen.density.ModDensityFunctions;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {

    public static SurfaceRules.RuleSource makeRules() {
        return SurfaceRules.sequence(
                WhiterunPlainsSurface.makeRules(),

                SpruceForestSurface.makeRules(),

                SpruceForestColdSurface.makeRules(),

                SpruceForestSnowySurface.makeRules()
        );
    }
}
