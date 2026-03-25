package cws.dragonborn.worldgen.biome.fplaced;

import cws.dragonborn.worldgen.biome.fconfigured.ModConfiguredFeatures;
import cws.dragonborn.worldgen.biome.fconfigured.PlainsFeaturesConfigured;
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


public class PlainsFeaturesPlaced {
    // Підключення PlacedFeature
    public static final ResourceKey<PlacedFeature> STONE_PILE_MOSSY_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "stone_pile_mossy"));

    public static final ResourceKey<PlacedFeature> DRY_TREE_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "dry_tree"));

    public static final ResourceKey<PlacedFeature> SPRUCE_STUMP_WP = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "spruce_stump_wp"));

    public static final ResourceKey<PlacedFeature> GROUND_CLIFF_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "ground_cliff"));

    public static final ResourceKey<PlacedFeature> BIG_BONES_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "big_bones"));

    public static final ResourceKey<PlacedFeature> BIG_SKULL_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "big_skull"));


    public static final ResourceKey<PlacedFeature> SPRUCE_PATCH_SMALL_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "spruce_patch_small"));

    public static final ResourceKey<PlacedFeature> SPRUCE_PATCH_MEDIUM_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "spruce_patch_medium"));

    public static final ResourceKey<PlacedFeature> SPRUCE_PATCH_BIG_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "spruce_patch_big"));


    public static final ResourceKey<PlacedFeature> BUSH_ORANGE = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "orange_bush"));

    public static final ResourceKey<PlacedFeature> BUSH_ORANGE_TALL = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "orange_bush_tall"));

    public static final ResourceKey<PlacedFeature> BUSH_YELLOW = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "bush_yellow"));

    public static final ResourceKey<PlacedFeature> BUSH_GRAY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "bush_gray"));

    public static final ResourceKey<PlacedFeature> TREE_BUSH_PATCH_WP = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "tree_bush_patch_wp"));


    public static final ResourceKey<PlacedFeature> LAVENDER = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "lavender"));

    public static final ResourceKey<PlacedFeature> COTTON = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "cotton"));

    public static final ResourceKey<PlacedFeature> MOUNTAIN_FLOWER_ORANGE = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "mountain_flower_orange"));

    public static final ResourceKey<PlacedFeature> LITTLE_ROCKS = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation("dragonborn", "little_rocks"));

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?, ?>> stonePileConfigured = configuredFeatures.getOrThrow(PlainsFeaturesConfigured.STONE_PILE_MOSSY_KEY);
        Holder<ConfiguredFeature<?, ?>> dryTreeConfigured = configuredFeatures.getOrThrow(DRY_TREE_KEY);
        Holder<ConfiguredFeature<?, ?>> bigBonesConfigured = configuredFeatures.getOrThrow(BIG_BONES_KEY);
        Holder<ConfiguredFeature<?, ?>> groundCliffConfigured = configuredFeatures.getOrThrow(GROUND_CLIFF_KEY);

        context.register(STONE_PILE_MOSSY_PLACED_KEY,
                new PlacedFeature(
                        stonePileConfigured,
                        List.of(
                                RarityFilter.onAverageOnceEvery(4),
                                InSquarePlacement.spread(),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES),
                                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                                BiomeFilter.biome())));
        context.register(DRY_TREE_PLACED_KEY,
                new PlacedFeature(
                        dryTreeConfigured,
                        List.of(
                                RarityFilter.onAverageOnceEvery(15),
                                InSquarePlacement.spread(),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES),
                                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                                BiomeFilter.biome())));
        context.register(GROUND_CLIFF_PLACED_KEY,
                new PlacedFeature(
                        groundCliffConfigured,
                        List.of(
                                RarityFilter.onAverageOnceEvery(4),
                                InSquarePlacement.spread(),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES),
                                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                                BiomeFilter.biome())));
        context.register(BIG_BONES_PLACED_KEY,
                new PlacedFeature(
                        bigBonesConfigured,
                        List.of(
                                RarityFilter.onAverageOnceEvery(50),
                                InSquarePlacement.spread(),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES),
                                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                                BiomeFilter.biome())));
        register(context, BIG_SKULL_PLACED_KEY, configuredFeatures.getOrThrow(PlainsFeaturesConfigured.BIG_SKULL_KEY), List.of(
                RarityFilter.onAverageOnceEvery(40),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context,SPRUCE_STUMP_WP, configuredFeatures.getOrThrow(ModConfiguredFeatures.SPRUCE_STUMP_KEY), List.of(
                RarityFilter.onAverageOnceEvery(100),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, SPRUCE_PATCH_SMALL_PLACED_KEY, configuredFeatures.getOrThrow(SPRUCE_PATCH_SMALL_KEY), List.of(
                RarityFilter.onAverageOnceEvery(100),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, SPRUCE_PATCH_MEDIUM_PLACED_KEY, configuredFeatures.getOrThrow(SPRUCE_PATCH_MEDIUM_KEY), List.of(
                RarityFilter.onAverageOnceEvery(200),   
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, SPRUCE_PATCH_BIG_PLACED_KEY, configuredFeatures.getOrThrow(SPRUCE_PATCH_BIG_KEY), List.of(
                RarityFilter.onAverageOnceEvery(300),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));


        register(context, BUSH_ORANGE, configuredFeatures.getOrThrow(PlainsFeaturesConfigured.BUSH_ORANGE), List.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, BUSH_ORANGE_TALL, configuredFeatures.getOrThrow(PlainsFeaturesConfigured.BUSH_ORANGE_TALL), List.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, BUSH_YELLOW, configuredFeatures.getOrThrow(PlainsFeaturesConfigured.BUSH_YELLOW), List.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, BUSH_GRAY, configuredFeatures.getOrThrow(PlainsFeaturesConfigured.BUSH_GRAY), List.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));
        register(context, TREE_BUSH_PATCH_WP, configuredFeatures.getOrThrow(ModConfiguredFeatures.TREE_BUSH_PATCH_KEY), List.of(
                RarityFilter.onAverageOnceEvery(100),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));


        register(context, LAVENDER, configuredFeatures.getOrThrow(PlainsFeaturesConfigured.LAVENDER), List.of(
                RarityFilter.onAverageOnceEvery(10),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));

        register(context, COTTON, configuredFeatures.getOrThrow(PlainsFeaturesConfigured.COTTON), List.of(
                RarityFilter.onAverageOnceEvery(10),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));

        register(context, MOUNTAIN_FLOWER_ORANGE, configuredFeatures.getOrThrow(PlainsFeaturesConfigured.MOUNTAIN_FLOWER_ORANGE), List.of(
                RarityFilter.onAverageOnceEvery(50),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        ));

        register(context, LITTLE_ROCKS, configuredFeatures.getOrThrow(PlainsFeaturesConfigured.LITTLE_ROCKS), List.of(
                RarityFilter.onAverageOnceEvery(1),
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
