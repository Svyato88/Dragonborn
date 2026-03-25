package cws.dragonborn.worldgen.biome.fconfigured;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.block.custom.exclusive.Lavender;
import cws.dragonborn.tags.ModTags;
import cws.dragonborn.worldgen.biome.DragonbornFeatures;
import cws.dragonborn.worldgen.biome.customfeatures.GrassPatchConfiguration;
import cws.dragonborn.worldgen.biome.customfeatures.NBTConfiguration;
import cws.dragonborn.worldgen.biome.customfeatures.SpawnFeatureInRadiusConfiguration;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import static cws.dragonborn.worldgen.biome.DragonbornFeatures.FEATURE_RADIUS;
import static cws.dragonborn.worldgen.biome.DragonbornFeatures.GRASS_PATCH;


public class SpruceForestFeaturesConfigured {
    // Створення ключа для ConfiguredFeature
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRASS_FOREST = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "grass_forest"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> GRASS_FOREST_FLOWERS = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "grass_forest_flowers"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> GRASS_DRY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "grass_dry"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> ASARUM = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "asamrum"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> ASARUM_DRY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "asamrum_dry"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_SPRUCE_BRANCH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "fallen_spruce_branch"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> FERN = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "fern"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> FERN_PATCH_BIG = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "fern_patch_big"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> FERN_BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "fern_bush"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> FERN_BUSH_DRY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "fern_bush_dry"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> PRICKLY_PLANT = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "prickly_plant"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> THISTLE_BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "thistle_bush"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> MOUNTAIN_FLOWER = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "mountain_flower"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> SNOWBERRIES_BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "snowberries_bush"));


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        Feature<GrassPatchConfiguration> GrassPatchFeature = GRASS_PATCH.get();
        Feature<SpawnFeatureInRadiusConfiguration> FeatureInRadius = FEATURE_RADIUS.get();
        Feature<NBTConfiguration> nbtStructureFeature = DragonbornFeatures.NBT_STRUCTURE.get();

        RuleTest grass_forest_place = new BlockMatchTest(ModBlocks.GRASS_BLOCK_FULL_FLOWERS.get());

        RuleTest grass_dry_place = new TagMatchTest(ModTags.Blocks.PODZOL_BLOCKS);

        register(context, GRASS_FOREST, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.GRASS_FOREST.get()),
                        10,
                        150,
                        grass_forest_place));
        register(context, GRASS_FOREST_FLOWERS, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.GRASS_FOREST_FLOWERS.get()),
                        10,
                        50,
                        grass_forest_place));
        register(context, GRASS_DRY, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.GRASS_DRY.get()),
                        10,
                        50,
                        grass_dry_place));
        register(context, ASARUM, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.ASARUM.get()),
                        10,
                        100,
                        grass_dry_place));
        register(context, ASARUM_DRY, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.ASARUM_DRY.get()),
                        10,
                        30,
                        grass_dry_place));
        register(context, FALLEN_SPRUCE_BRANCH, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.FALLEN_SPRUCE_BRANCH.get()),
                        2,
                        6,
                        grass_dry_place));
        register(context, FERN, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.FERN.get()),
                        4,
                        4,
                        grass_dry_place));
        register(context, FERN_PATCH_BIG, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.FERN.get()),
                        7,
                        200,
                        grass_dry_place));
        register(context, FERN_BUSH, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.FERN_BUSH.get()),
                        2,
                        4,
                        grass_dry_place));
        register(context, FERN_BUSH_DRY, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.FERN_BUSH_DRY.get()),
                        2,
                        4,
                        grass_dry_place));
        register(context, PRICKLY_PLANT, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.PRICKLY_PLANT.get()),
                        2,
                        2,
                        grass_dry_place));
        register(context, THISTLE_BUSH, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.THISTLE_BUSH.get().defaultBlockState().setValue(Lavender.AGE, 3)),
                        5,
                        3,
                        grass_forest_place));
        register(context, MOUNTAIN_FLOWER, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.MOUNTAIN_FLOWER.get().defaultBlockState().setValue(Lavender.AGE, 3)),
                        4,
                        2,
                        grass_forest_place));
        register(context, SNOWBERRIES_BUSH, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.SNOWBERRIES_BUSH.get().defaultBlockState().setValue(Lavender.AGE, 3)),
                        4,
                        3,
                        grass_dry_place));
    }
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Dragonborn.MOD_ID, name));
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
