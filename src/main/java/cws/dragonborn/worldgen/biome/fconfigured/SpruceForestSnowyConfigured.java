package cws.dragonborn.worldgen.biome.fconfigured;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.block.custom.exclusive.Lavender;
import cws.dragonborn.block.custom.exclusive.Snowberries_bush;
import cws.dragonborn.worldgen.biome.DragonbornFeatures;
import cws.dragonborn.worldgen.biome.customfeatures.GrassPatchConfiguration;
import cws.dragonborn.worldgen.biome.customfeatures.NBTBlockCheckConfiguration;
import cws.dragonborn.worldgen.biome.customfeatures.NBTConfiguration;
import cws.dragonborn.worldgen.biome.customfeatures.SpawnFeatureInRadiusConfiguration;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import static cws.dragonborn.worldgen.biome.DragonbornFeatures.FEATURE_RADIUS;
import static cws.dragonborn.worldgen.biome.DragonbornFeatures.GRASS_PATCH;

public class SpruceForestSnowyConfigured {

    public static final ResourceKey<ConfiguredFeature<?, ?>> SNOWY_SPRUCE_KEY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "snowy_spruce_key"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> SNOWY_SPRUCE_STUMP_KEY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "snowy_spruce_stump_key"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> SNOWY_GRASS_DRY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "snowy_grass_dry"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> GRASS_DRY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "grass_dry_small"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> SNOWY_BUSH_DRY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "snowy_bush_dry"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> SNOWY_SNOWBERRIES_BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "snowy_snowberries_bush"));


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        Feature<GrassPatchConfiguration> GrassPatchFeature = GRASS_PATCH.get();
        Feature<NBTConfiguration> nbtStructureFeature = DragonbornFeatures.NBT_STRUCTURE.get();
        Feature<NBTBlockCheckConfiguration> nbtBlockCheckFeature = DragonbornFeatures.NBT_BLOCK_CHECK.get();

        RuleTest dry_grass_place = new BlockMatchTest(Blocks.SNOW_BLOCK);

        register(context, SNOWY_SPRUCE_KEY,
                nbtBlockCheckFeature,
                new NBTBlockCheckConfiguration(
                        java.util.List.of(
                                new ResourceLocation(Dragonborn.MOD_ID, "trees/spruce_tree_snowy1"),
                                new ResourceLocation(Dragonborn.MOD_ID, "trees/spruce_tree_snowy2"),
                                new ResourceLocation(Dragonborn.MOD_ID, "trees/spruce_tree_snowy3"),
                                new ResourceLocation(Dragonborn.MOD_ID, "trees/spruce_tree_snowy4"),
                                new ResourceLocation(Dragonborn.MOD_ID, "trees/spruce_tree_snowy5")
                        ),
                        new net.minecraft.core.BlockPos(-2, 0, -2),
                        dry_grass_place));
        register(context, SNOWY_SPRUCE_STUMP_KEY,
                nbtBlockCheckFeature,
                new NBTBlockCheckConfiguration(java.util.List.of(
                        new ResourceLocation(Dragonborn.MOD_ID, "trees/stump_snowy_spruce")),
                        new net.minecraft.core.BlockPos(0, 0, 0),
                        dry_grass_place));
        register(context, SNOWY_GRASS_DRY, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.SNOWY_GRASS_DRY.get()),
                        5,
                        20,
                        dry_grass_place));
        register(context, GRASS_DRY, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.GRASS_DRY.get()),
                        10,
                        10,
                        dry_grass_place));
        register(context, SNOWY_BUSH_DRY, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.SNOWY_BUSH_DRY.get()),
                        10,
                        4,
                        dry_grass_place));
        register(context, SNOWY_SNOWBERRIES_BUSH, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.SNOWBERRIES_BUSH.get().defaultBlockState().setValue(Snowberries_bush.AGE, 3).setValue(Snowberries_bush.SNOWY, true)),
                        4,
                        3,
                        dry_grass_place));
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
