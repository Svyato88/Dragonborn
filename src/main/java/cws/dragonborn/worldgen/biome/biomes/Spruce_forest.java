package cws.dragonborn.worldgen.biome.biomes;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.entity.ModEntities;
import cws.dragonborn.worldgen.biome.fconfigured.SpruceForestFeaturesConfigured;
import cws.dragonborn.worldgen.biome.fplaced.ModPlacedFeatures;
import cws.dragonborn.worldgen.biome.fplaced.PlainsFeaturesPlaced;
import cws.dragonborn.worldgen.biome.fplaced.SpruceForestFeaturesPlaced;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class Spruce_forest {
    public static final ResourceKey<Biome> SPRUCE_FOREST = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Dragonborn.MOD_ID,"spruce_forest"));

    public static void boostrap(BootstapContext<Biome> context){
        context.register(SPRUCE_FOREST, spruce_forest(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
    }

    public static Biome spruce_forest(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        // 1 це шанс, 2 це мін в групі, 3 це макс в групі
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 1, 1, 3));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.BUTTERFLY.get(), 1, 1, 2));

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(
                        context.lookup(Registries.PLACED_FEATURE),
                        context.lookup(Registries.CONFIGURED_CARVER));
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
        //globalOverworldGeneration(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacedFeatures.STONE_PILE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SPRUCE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SPRUCE_STUMP_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SpruceForestFeaturesPlaced.GRASS_FOREST);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SpruceForestFeaturesPlaced.GRASS_FOREST_FLOWERS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SpruceForestFeaturesPlaced.GRASS_DRY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SpruceForestFeaturesPlaced.TREE_BUSH_PATCH_SF);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SpruceForestFeaturesPlaced.ASARUM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SpruceForestFeaturesPlaced.FALLEN_SPRUCE_BRANCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SpruceForestFeaturesPlaced.FERN);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SpruceForestFeaturesPlaced.FERN_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SpruceForestFeaturesPlaced.FERN_BUSH_DRY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SpruceForestFeaturesPlaced.THISTLE_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SpruceForestFeaturesPlaced.MOUNTAIN_FLOWER);
        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, ModPlacedFeatures.STONE_HILLS);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.7f)
                .downfall(0.8f)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x45857a)
                        .waterFogColor(0x475494)
                        .skyColor(0x4c89c1)
                        .grassColorOverride(0x70b749)
                        .foliageColorOverride(0x41783c)
                        .fogColor(0x91c6e3)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
}