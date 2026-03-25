package cws.dragonborn.worldgen.biome.fplaced;

import cws.dragonborn.worldgen.biome.fconfigured.ModConfiguredFeatures;
import cws.dragonborn.worldgen.biome.fconfigured.PlainsFeaturesConfigured;
import cws.dragonborn.worldgen.biome.fconfigured.SpruceForestFeaturesConfigured;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static cws.dragonborn.worldgen.biome.fconfigured.PlainsFeaturesConfigured.*;


public class SpruceForestFeaturesPlaced {
    // Підключення PlacedFeature
    public static final ResourceKey<PlacedFeature> SPRUCE_STUMP_SF = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "spruce_stump_sf"));

    public static final ResourceKey<PlacedFeature> GRASS_FOREST = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "grass_forest"));

    public static final ResourceKey<PlacedFeature> GRASS_FOREST_FLOWERS = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "grass_forest_flowers"));

    public static final ResourceKey<PlacedFeature> GRASS_DRY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "grass_dry"));

    public static final ResourceKey<PlacedFeature> ASARUM = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "asarum"));

    public static final ResourceKey<PlacedFeature> ASARUM_DRY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "asarum_dry"));

    public static final ResourceKey<PlacedFeature> FALLEN_SPRUCE_BRANCH = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "fallen_spruce_branch"));

    public static final ResourceKey<PlacedFeature> FERN = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "fern"));

    public static final ResourceKey<PlacedFeature> FERN_PATCH_BIG = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "fern_patch_big"));

    public static final ResourceKey<PlacedFeature> FERN_BUSH = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "fern_bush"));

    public static final ResourceKey<PlacedFeature> FERN_BUSH_DRY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "fern_bush_dry"));

    public static final ResourceKey<PlacedFeature> FERN_BUSH_BIG = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "fern_bush_big"));

    public static final ResourceKey<PlacedFeature> FERN_BUSH_DRY_BIG = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "fern_bush_dry_big"));

    public static final ResourceKey<PlacedFeature> PRICKLY_PLANT = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "prickly_plant"));

    public static final ResourceKey<PlacedFeature> TREE_BUSH_PATCH_SF = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "tree_bush_patch_sf"));

    public static final ResourceKey<PlacedFeature> TREE_BUSH_PATCH_SSF = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "tree_bush_patch_ssf"));



    public static final ResourceKey<PlacedFeature> THISTLE_BUSH = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "thistle_bush"));

    public static final ResourceKey<PlacedFeature> MOUNTAIN_FLOWER = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "mountain_flower"));

    public static final ResourceKey<PlacedFeature> SNOWBERRIES_BUSH =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "snowberries_bush"));


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        //Holder<ConfiguredFeature<?, ?>> stonePileConfigured = configuredFeatures.getOrThrow(PlainsFeaturesConfigured.STONE_PILE_MOSSY_KEY);

        register(context, SPRUCE_STUMP_SF, configuredFeatures.getOrThrow(ModConfiguredFeatures.SPRUCE_STUMP_KEY), List.of(
                RarityFilter.onAverageOnceEvery(7),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, GRASS_FOREST, configuredFeatures.getOrThrow(SpruceForestFeaturesConfigured.GRASS_FOREST), List.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, GRASS_FOREST_FLOWERS, configuredFeatures.getOrThrow(SpruceForestFeaturesConfigured.GRASS_FOREST_FLOWERS), List.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, GRASS_DRY, configuredFeatures.getOrThrow(SpruceForestFeaturesConfigured.GRASS_DRY), List.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, ASARUM, configuredFeatures.getOrThrow(SpruceForestFeaturesConfigured.ASARUM), List.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, ASARUM_DRY, configuredFeatures.getOrThrow(SpruceForestFeaturesConfigured.ASARUM_DRY), List.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, FALLEN_SPRUCE_BRANCH, configuredFeatures.getOrThrow(SpruceForestFeaturesConfigured.FALLEN_SPRUCE_BRANCH), List.of(
                RarityFilter.onAverageOnceEvery(5),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, FERN, configuredFeatures.getOrThrow(SpruceForestFeaturesConfigured.FERN), List.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, FERN_PATCH_BIG, configuredFeatures.getOrThrow(SpruceForestFeaturesConfigured.FERN_PATCH_BIG), List.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, FERN_BUSH, configuredFeatures.getOrThrow(SpruceForestFeaturesConfigured.FERN_BUSH), List.of(
                RarityFilter.onAverageOnceEvery(5),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, FERN_BUSH_DRY, configuredFeatures.getOrThrow(SpruceForestFeaturesConfigured.FERN_BUSH_DRY), List.of(
                RarityFilter.onAverageOnceEvery(5),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, FERN_BUSH_BIG, configuredFeatures.getOrThrow(SpruceForestFeaturesConfigured.FERN_BUSH), List.of(
                RarityFilter.onAverageOnceEvery(5),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, FERN_BUSH_DRY_BIG, configuredFeatures.getOrThrow(SpruceForestFeaturesConfigured.FERN_BUSH_DRY), List.of(
                RarityFilter.onAverageOnceEvery(5),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, PRICKLY_PLANT, configuredFeatures.getOrThrow(SpruceForestFeaturesConfigured.PRICKLY_PLANT), List.of(
                RarityFilter.onAverageOnceEvery(5),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, TREE_BUSH_PATCH_SF, configuredFeatures.getOrThrow(ModConfiguredFeatures.TREE_BUSH_PATCH_KEY), List.of(
                RarityFilter.onAverageOnceEvery(7),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, TREE_BUSH_PATCH_SSF, configuredFeatures.getOrThrow(ModConfiguredFeatures.TREE_BUSH_PATCH_KEY), List.of(
                RarityFilter.onAverageOnceEvery(10),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));


        register(context, THISTLE_BUSH, configuredFeatures.getOrThrow(SpruceForestFeaturesConfigured.THISTLE_BUSH), List.of(
                RarityFilter.onAverageOnceEvery(7),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, MOUNTAIN_FLOWER, configuredFeatures.getOrThrow(SpruceForestFeaturesConfigured.MOUNTAIN_FLOWER), List.of(
                RarityFilter.onAverageOnceEvery(5),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, SNOWBERRIES_BUSH, configuredFeatures.getOrThrow(SpruceForestFeaturesConfigured.SNOWBERRIES_BUSH), List.of(
                RarityFilter.onAverageOnceEvery(7),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
