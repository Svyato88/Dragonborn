package cws.dragonborn.worldgen.biome.biomes;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.entity.ModEntities;
import cws.dragonborn.worldgen.biome.fplaced.ModPlacedFeatures;
import cws.dragonborn.worldgen.biome.fplaced.PlainsFeaturesPlaced;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class Whiterun_plains {
    public static final ResourceKey<Biome> WHITERUN_PLAINS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Dragonborn.MOD_ID,"whiterun_plains"));

    public static void boostrap(BootstapContext<Biome> context){
        context.register(WHITERUN_PLAINS, whiterun_plains(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
    }

    public static Biome whiterun_plains(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        // 1 це шанс, 2 це мін в групі, 3 це макс в групі
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 1, 1, 3));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.BUTTERFLY.get(), 2, 1, 2));


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(
                        context.lookup(Registries.PLACED_FEATURE),
                        context.lookup(Registries.CONFIGURED_CARVER));
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
        //globalOverworldGeneration(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacedFeatures.STONE_PILE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, PlainsFeaturesPlaced.STONE_PILE_MOSSY_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, PlainsFeaturesPlaced.SPRUCE_PATCH_SMALL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, PlainsFeaturesPlaced.SPRUCE_PATCH_MEDIUM_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, PlainsFeaturesPlaced.SPRUCE_PATCH_BIG_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, PlainsFeaturesPlaced.SPRUCE_STUMP_WP);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, PlainsFeaturesPlaced.DRY_TREE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, PlainsFeaturesPlaced.BIG_BONES_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, PlainsFeaturesPlaced.BIG_SKULL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, PlainsFeaturesPlaced.GROUND_CLIFF_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlainsFeaturesPlaced.LITTLE_ROCKS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlainsFeaturesPlaced.BUSH_ORANGE_TALL);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlainsFeaturesPlaced.BUSH_ORANGE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlainsFeaturesPlaced.BUSH_YELLOW);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlainsFeaturesPlaced.BUSH_GRAY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.BUSH_DRY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlainsFeaturesPlaced.TREE_BUSH_PATCH_WP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlainsFeaturesPlaced.LAVENDER);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlainsFeaturesPlaced.COTTON);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlainsFeaturesPlaced.MOUNTAIN_FLOWER_ORANGE);
        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, ModPlacedFeatures.STONE_HILLS);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.7f)
                .downfall(0.8f)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x475494)
                        .waterFogColor(0x475494)
                        .skyColor(0x4c89c1)
                        .grassColorOverride(0xc2a45a)
                        .foliageColorOverride(0x619447)
                        .fogColor(0x91c6e3)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
}

