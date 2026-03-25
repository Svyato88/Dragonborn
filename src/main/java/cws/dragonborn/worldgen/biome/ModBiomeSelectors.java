package cws.dragonborn.worldgen.biome;

import cws.dragonborn.worldgen.biome.biomes.Whiterun_plains;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

public class ModBiomeSelectors {

    // 2D масив: [temperature][humidity]
    // Розмір повинен бути як у ваніли (5x5)
    public static final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{
            {Biomes.PLAINS, Biomes.PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.FOREST},
            {Biomes.PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.FOREST, Biomes.DARK_FOREST},
            {Biomes.PLAINS, Biomes.FOREST, Whiterun_plains.WHITERUN_PLAINS, Biomes.FOREST, Biomes.DARK_FOREST},
            {Biomes.FOREST, Biomes.FOREST, Biomes.FOREST, Biomes.DARK_FOREST, Biomes.DARK_FOREST},
            {Biomes.TAIGA, Biomes.TAIGA, Biomes.TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA}
    };

    public static final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
            {Biomes.MEADOW, Biomes.MEADOW, Whiterun_plains.WHITERUN_PLAINS, Biomes.MEADOW, Biomes.MEADOW},
            {Biomes.MEADOW, Whiterun_plains.WHITERUN_PLAINS, Whiterun_plains.WHITERUN_PLAINS, Whiterun_plains.WHITERUN_PLAINS, Biomes.MEADOW},
            {Biomes.MEADOW, Whiterun_plains.WHITERUN_PLAINS, Whiterun_plains.WHITERUN_PLAINS, Whiterun_plains.WHITERUN_PLAINS, Biomes.MEADOW},
            {Biomes.MEADOW, Whiterun_plains.WHITERUN_PLAINS, Whiterun_plains.WHITERUN_PLAINS, Whiterun_plains.WHITERUN_PLAINS, Biomes.MEADOW},
            {Biomes.GROVE, Biomes.GROVE, Biomes.GROVE, Biomes.GROVE, Biomes.GROVE}
    };
}
