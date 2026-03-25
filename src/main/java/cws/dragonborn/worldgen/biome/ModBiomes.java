package cws.dragonborn.worldgen.biome;

import cws.dragonborn.worldgen.biome.biomes.Spruce_forest;
import cws.dragonborn.worldgen.biome.biomes.Spruce_forest_cold;
import cws.dragonborn.worldgen.biome.biomes.Spruce_forest_snowy;
import cws.dragonborn.worldgen.biome.biomes.Whiterun_plains;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

import static cws.dragonborn.Dragonborn.MOD_ID;

public class ModBiomes {
    public static void bootstrap(BootstapContext<Biome>context) {
        context.register(
                Spruce_forest_snowy.SNOWY_SPRUCE_FOREST,
                Spruce_forest_snowy.spruce_forest_snowy(context)
        );
        context.register(
                Spruce_forest_cold.SPRUCE_FOREST_COLD,
                Spruce_forest_cold.spruce_forest_cold(context)
        );
        context.register(
                Spruce_forest.SPRUCE_FOREST,
                Spruce_forest.spruce_forest(context)
        );
        context.register(
                Whiterun_plains.WHITERUN_PLAINS,
                Whiterun_plains.whiterun_plains(context)
        );
    }
}
