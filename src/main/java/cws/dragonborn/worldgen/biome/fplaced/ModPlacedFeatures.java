package cws.dragonborn.worldgen.biome.fplaced;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.worldgen.biome.customfeatures.SpawnFeatureInRadiusConfiguration;
import cws.dragonborn.worldgen.biome.fconfigured.ModConfiguredFeatures;
import cws.dragonborn.worldgen.biome.fconfigured.PlainsFeaturesConfigured;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

import static cws.dragonborn.worldgen.biome.DragonbornFeatures.FEATURE_RADIUS;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> STONE_PILE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Dragonborn.MOD_ID, "stone_pile"));

    public static final ResourceKey<PlacedFeature> SPRUCE_PLACED_KEY = registerKey("spruce_tree");

    public static final ResourceKey<PlacedFeature> SPRUCE_STUMP_PLACED_KEY = registerKey("spruce_stump");

    public static final ResourceKey<PlacedFeature> SNOW_LAYER = registerKey("snow_layer");

    public static final ResourceKey<PlacedFeature> STONE_HILLS = registerKey("stone_hills");

    public static final ResourceKey<PlacedFeature> BUSH_DRY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "bush_dry"));

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        PlainsFeaturesPlaced.bootstrap(context);
        SpruceForestFeaturesPlaced.bootstrap(context);
        SpruceForestSnowyPlaced.bootstrap(context);

        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?, ?>> stonePileConfigured = configuredFeatures.getOrThrow(ModConfiguredFeatures.STONE_PILE_KEY);
        Holder<ConfiguredFeature<?, ?>> snowPlaceConfigured = configuredFeatures.getOrThrow(ModConfiguredFeatures.SNOW_LAYER);
        Holder<ConfiguredFeature<?, ?>> stoneHillsConfigured = configuredFeatures.getOrThrow(ModConfiguredFeatures.STONE_HILLS);

        context.register(STONE_PILE_PLACED_KEY,
                new PlacedFeature(
                        stonePileConfigured,
                        List.of(
                                RarityFilter.onAverageOnceEvery(2),
                                InSquarePlacement.spread(),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES),
                                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                                BiomeFilter.biome())));
        register(context, SPRUCE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SPRUCE_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.1f, 2),
                        ModBlocks.SPRUCE_SAPLING.get()));
        register(context, SPRUCE_STUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SPRUCE_STUMP_KEY), List.of(
                RarityFilter.onAverageOnceEvery(7),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()));
        context.register(SNOW_LAYER,
                new PlacedFeature(
                        snowPlaceConfigured,
                        List.of(PlacementUtils.HEIGHTMAP_WORLD_SURFACE)));
        context.register(STONE_HILLS,
                new PlacedFeature(
                        stoneHillsConfigured,
                        List.of(PlacementUtils.HEIGHTMAP_WORLD_SURFACE)));
        register(context, BUSH_DRY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BUSH_DRY), List.of(
                RarityFilter.onAverageOnceEvery(5),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()));
    }
    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Dragonborn.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
