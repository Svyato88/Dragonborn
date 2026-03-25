package cws.dragonborn.worldgen.biome.biomes;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.worldgen.biome.fconfigured.SpruceForestSnowyConfigured;
import cws.dragonborn.worldgen.biome.fplaced.ModPlacedFeatures;
import cws.dragonborn.worldgen.biome.fplaced.SpruceForestFeaturesPlaced;
import cws.dragonborn.worldgen.biome.fplaced.SpruceForestSnowyPlaced;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class Spruce_forest_snowy {
    public static final ResourceKey<Biome> SNOWY_SPRUCE_FOREST = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Dragonborn.MOD_ID,"snowy_spruce_forest"));

    public static void boostrap(BootstapContext<Biome> context){
        context.register(SNOWY_SPRUCE_FOREST, spruce_forest_snowy(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
    }

    public static Biome spruce_forest_snowy(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        //spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(
                        context.lookup(Registries.PLACED_FEATURE),
                        context.lookup(Registries.CONFIGURED_CARVER)
                );
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
        //globalOverworldGeneration(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacedFeatures.STONE_PILE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, SpruceForestSnowyPlaced.SNOWY_SPRUCE_STUMP_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SpruceForestSnowyPlaced.SNOWY_SPRUCE_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SpruceForestSnowyPlaced.SNOWY_GRASS_DRY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SpruceForestSnowyPlaced.GRASS_DRY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SpruceForestSnowyPlaced.SNOWY_BUSH_DRY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SpruceForestSnowyPlaced.SNOWY_SNOWBERRIES_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, ModPlacedFeatures.SNOW_LAYER);
        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, ModPlacedFeatures.STONE_HILLS);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.0f)
                .downfall(0.8f)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x3d60c1)
                        .waterFogColor(0x3d60c1)
                        .skyColor(0x68bce2)
                        .grassColorOverride(0xffffff)
                        .foliageColorOverride(0xffffff)
                        .fogColor(0xdbdbdb)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
}