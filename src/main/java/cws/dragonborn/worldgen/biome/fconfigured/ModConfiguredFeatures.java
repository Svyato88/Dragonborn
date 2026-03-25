package cws.dragonborn.worldgen.biome.fconfigured;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.worldgen.biome.DragonbornFeatures;
import cws.dragonborn.worldgen.biome.customfeatures.*;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;

import static cws.dragonborn.worldgen.biome.DragonbornFeatures.FEATURE_RADIUS;
import static cws.dragonborn.worldgen.biome.DragonbornFeatures.GRASS_PATCH;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> STONE_PILE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Dragonborn.MOD_ID, "stone_pile"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_TREE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Dragonborn.MOD_ID, "spruce_tree"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_STUMP_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Dragonborn.MOD_ID, "spruce_stump"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_BUSH_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Dragonborn.MOD_ID, "tree_bush"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_BUSH_PATCH_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Dragonborn.MOD_ID, "tree_bush_patch"));


    public static final ResourceKey<ConfiguredFeature<?, ?>> SNOW_LAYER =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Dragonborn.MOD_ID, "snow_layer"));


    public static final ResourceKey<ConfiguredFeature<?, ?>> STONE_HILLS =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Dragonborn.MOD_ID, "stone_hills"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> BUSH_DRY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "bush_dry"));


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        PlainsFeaturesConfigured.bootstrap(context);
        SpruceForestFeaturesConfigured.bootstrap(context);
        SpruceForestSnowyConfigured.bootstrap(context);

        Feature<NBTConfiguration> nbtStructureFeature = DragonbornFeatures.NBT_STRUCTURE.get();
        Feature<SnowPlaceConfigured> snowPlaceFeature = DragonbornFeatures.SNOW_PLACE.get();
        Feature<HillsFeaturePlaceConfigured> hillFeaturePlace = DragonbornFeatures.HILL_FEATURES_PLACE.get();
        Feature<GrassPatchConfiguration> GrassPatchFeature = GRASS_PATCH.get();
        Feature<SpawnFeatureInRadiusConfiguration> FeatureInRadius = FEATURE_RADIUS.get();
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        RuleTest bush_dry_place = new TagMatchTest(BlockTags.DIRT);

        Holder<ConfiguredFeature<?, ?>> treeBush = configuredFeatures.getOrThrow(ModConfiguredFeatures.TREE_BUSH_KEY);


        register(context, STONE_PILE_KEY,
                nbtStructureFeature,
                new NBTConfiguration(
                        java.util.List.of(
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_rock1"),
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_rock2"),
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_rock3"),
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_rock4"),
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_rock5"),
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_rock6"),
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_rock7"),
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_rock8"),
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_rock9"),
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_rock10")),
                        new net.minecraft.core.BlockPos(-4, -2, -4)));
        register(context, SPRUCE_TREE_KEY,
                nbtStructureFeature,
                new NBTConfiguration(java.util.List.of(
                                new ResourceLocation(Dragonborn.MOD_ID, "trees/spruce_tree1"),
                                new ResourceLocation(Dragonborn.MOD_ID, "trees/spruce_tree2"),
                                new ResourceLocation(Dragonborn.MOD_ID, "trees/spruce_tree3"),
                                new ResourceLocation(Dragonborn.MOD_ID, "trees/spruce_tree4"),
                                new ResourceLocation(Dragonborn.MOD_ID, "trees/spruce_tree5")),
                        new net.minecraft.core.BlockPos(-2, 0, -2)));
        register(context, SPRUCE_STUMP_KEY,
                nbtStructureFeature,
                new NBTConfiguration(java.util.List.of(
                        new ResourceLocation(Dragonborn.MOD_ID, "trees/stump_spruce")),
                        new net.minecraft.core.BlockPos(0, 0, 0)));
        register(context, TREE_BUSH_KEY,
                nbtStructureFeature,
                new NBTConfiguration(java.util.List.of(
                        new ResourceLocation(Dragonborn.MOD_ID, "trees/tree_bush1"),
                        new ResourceLocation(Dragonborn.MOD_ID, "trees/tree_bush2"),
                        new ResourceLocation(Dragonborn.MOD_ID, "trees/tree_bush3")),
                        new net.minecraft.core.BlockPos(0, 0, 0)));
        register(context, TREE_BUSH_PATCH_KEY, FeatureInRadius,
                new SpawnFeatureInRadiusConfiguration(
                        treeBush,
                        1,
                        5,
                        bush_dry_place));
        register(context, STONE_HILLS,
                hillFeaturePlace,
                new HillsFeaturePlaceConfigured(
                        3));
        register(context, SNOW_LAYER,
                snowPlaceFeature,
                new SnowPlaceConfigured(
                        3));
        register(context, BUSH_DRY,
                GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(
                                ModBlocks.BUSH_DRY.get()),
                        7,
                        3,
                        bush_dry_place));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key,
            F feature,
            FC configuration
    ) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
