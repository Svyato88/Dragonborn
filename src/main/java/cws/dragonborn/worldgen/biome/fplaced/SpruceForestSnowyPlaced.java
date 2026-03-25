package cws.dragonborn.worldgen.biome.fplaced;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.worldgen.biome.fconfigured.ModConfiguredFeatures;
import cws.dragonborn.worldgen.biome.fconfigured.PlainsFeaturesConfigured;
import cws.dragonborn.worldgen.biome.fconfigured.SpruceForestFeaturesConfigured;
import cws.dragonborn.worldgen.biome.fconfigured.SpruceForestSnowyConfigured;
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
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class SpruceForestSnowyPlaced {

    public static final ResourceKey<PlacedFeature> SNOWY_SPRUCE_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Dragonborn.MOD_ID, "snowy_spruce_key"));

    public static final ResourceKey<PlacedFeature> SNOWY_SPRUCE_STUMP_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Dragonborn.MOD_ID, "snowy_stump_key"));


    public static final ResourceKey<PlacedFeature> SNOWY_GRASS_DRY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Dragonborn.MOD_ID, "snowy_grass_dry"));

    public static final ResourceKey<PlacedFeature> GRASS_DRY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Dragonborn.MOD_ID, "grass_dry_small"));

    public static final ResourceKey<PlacedFeature> SNOWY_BUSH_DRY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Dragonborn.MOD_ID, "snowy_bush_dry"));

    public static final ResourceKey<PlacedFeature> SNOWY_SNOWBERRIES_BUSH =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "snowy_snowberries_bush"));


    public static void bootstrap(BootstapContext<PlacedFeature> context) {

        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, SNOWY_SPRUCE_KEY, configuredFeatures.getOrThrow(SpruceForestSnowyConfigured.SNOWY_SPRUCE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.1f, 2),
                        ModBlocks.PAVEMENT.get()));
        register(context, SNOWY_SPRUCE_STUMP_KEY, configuredFeatures.getOrThrow(SpruceForestSnowyConfigured.SNOWY_SPRUCE_STUMP_KEY), List.of(
                RarityFilter.onAverageOnceEvery(7),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, SNOWY_GRASS_DRY, configuredFeatures.getOrThrow(SpruceForestSnowyConfigured.SNOWY_GRASS_DRY), List.of(
                RarityFilter.onAverageOnceEvery(3),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, GRASS_DRY, configuredFeatures.getOrThrow(SpruceForestSnowyConfigured.GRASS_DRY), List.of(
                RarityFilter.onAverageOnceEvery(5),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, SNOWY_BUSH_DRY, configuredFeatures.getOrThrow(SpruceForestSnowyConfigured.SNOWY_BUSH_DRY), List.of(
                RarityFilter.onAverageOnceEvery(2),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, SNOWY_SNOWBERRIES_BUSH, configuredFeatures.getOrThrow(SpruceForestSnowyConfigured.SNOWY_SNOWBERRIES_BUSH), List.of(
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
