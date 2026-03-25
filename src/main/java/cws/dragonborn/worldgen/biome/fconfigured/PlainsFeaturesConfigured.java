package cws.dragonborn.worldgen.biome.fconfigured;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.block.custom.exclusive.Lavender;
import cws.dragonborn.worldgen.biome.DragonbornFeatures;
import cws.dragonborn.worldgen.biome.customfeatures.*;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import static cws.dragonborn.worldgen.biome.DragonbornFeatures.*;


public class PlainsFeaturesConfigured {
    // Створення ключа для ConfiguredFeature
    public static final ResourceKey<ConfiguredFeature<?, ?>> STONE_PILE_MOSSY_KEY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "stone_pile_mossy"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> DRY_TREE_KEY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "dry_tree"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> GROUND_CLIFF_KEY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "ground_cliff"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_BONES_KEY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "big_bones"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_SKULL_KEY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "big_skull"));




    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_PATCH_SMALL_KEY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "spruce_patch_small"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_PATCH_MEDIUM_KEY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "spruce_patch_medium"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_PATCH_BIG_KEY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "spruce_patch_big"));


    public static final ResourceKey<ConfiguredFeature<?, ?>> BUSH_ORANGE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "orange_bush"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> BUSH_ORANGE_TALL = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "orange_bush_tall"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> BUSH_YELLOW = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "bush_yellow"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> BUSH_GRAY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "bush_gray"));


    public static final ResourceKey<ConfiguredFeature<?, ?>> MOUNTAIN_FLOWER_ORANGE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "mountain_flower_orange"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> LAVENDER = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "lavender"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> COTTON = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "cotton"));


    public static final ResourceKey<ConfiguredFeature<?, ?>> LITTLE_ROCKS = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, new ResourceLocation("dragonborn", "little_rocks"));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        Feature<GrassPatchConfiguration> GrassPatchFeature = GRASS_PATCH.get();
        Feature<SpawnFeatureInRadiusConfiguration> FeatureInRadius = FEATURE_RADIUS.get();
        Feature<NBTConfiguration> nbtStructureFeature = DragonbornFeatures.NBT_STRUCTURE.get();
        Feature<NBTBlockCheckConfiguration> nbtBlockCheck = NBT_BLOCK_CHECK.get();

        HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> spruceTree = configured.getOrThrow(ModConfiguredFeatures.SPRUCE_TREE_KEY);

        RuleTest bush_gray_place = new BlockMatchTest(ModBlocks.DARK_DIRT.get());
        RuleTest bush_orange_place = new BlockMatchTest(ModBlocks.GRASS_BLOCK_FULL.get());
        RuleTest little_rocks_place = new BlockMatchTest(ModBlocks.GRAY_DIRT_LITTLE_ROCKS.get());

        register(context, STONE_PILE_MOSSY_KEY, nbtStructureFeature,
                new NBTConfiguration(
                        java.util.List.of(
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_rock_mossy1"),
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_rock_mossy2"),
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_rock_mossy3"),
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_rock_mossy4")
                        ),
                        new net.minecraft.core.BlockPos(-4, -2, -4)));
        register(context, GROUND_CLIFF_KEY, nbtStructureFeature,
                new NBTConfiguration(
                        java.util.List.of(
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_plate1"),
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_plate2"),
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_plate3"),
                                new ResourceLocation(Dragonborn.MOD_ID, "rocks/plains_plate4")
                        ),
                        new net.minecraft.core.BlockPos(-3, -2, -4)));
        register(context, DRY_TREE_KEY, nbtBlockCheck,
                new NBTBlockCheckConfiguration(
                        java.util.List.of(
                                new ResourceLocation(Dragonborn.MOD_ID, "trees/dry_tree1"),
                                new ResourceLocation(Dragonborn.MOD_ID, "trees/dry_tree2"),
                                new ResourceLocation(Dragonborn.MOD_ID, "trees/dry_tree3")
                        ),
                        new net.minecraft.core.BlockPos(-1, 0, -2),
                        bush_orange_place));
        register(context, BIG_BONES_KEY, nbtStructureFeature,
                new NBTConfiguration(
                        java.util.List.of(
                                new ResourceLocation(Dragonborn.MOD_ID, "other/big_bones"),
                                new ResourceLocation(Dragonborn.MOD_ID, "other/big_bones1")
                        ),
                        new net.minecraft.core.BlockPos(-1, 0, -2)));
        register(context, BIG_SKULL_KEY, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.BIG_SKULL.get()),
                        3,
                        1,
                        bush_orange_place));
        register(context, SPRUCE_PATCH_SMALL_KEY, FeatureInRadius,
                new SpawnFeatureInRadiusConfiguration(
                        spruceTree,
                        7,
                        2,
                        bush_orange_place));
        register(context, SPRUCE_PATCH_MEDIUM_KEY, FeatureInRadius,
                new SpawnFeatureInRadiusConfiguration(
                        spruceTree,
                        12,
                        5,
                        bush_orange_place));
        register(context, SPRUCE_PATCH_BIG_KEY, FeatureInRadius,
                new SpawnFeatureInRadiusConfiguration(
                        spruceTree,
                        17,
                        7,
                        bush_orange_place));
        register(context, BUSH_ORANGE, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.GRASS_BUSH_ORANGE.get()),
                        10,
                        80,
                        bush_orange_place));
        register(context, BUSH_ORANGE_TALL, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.GRASS_BUSH_ORANGE_TALL.get()),
                        10,
                        40,
                        bush_orange_place));
        register(context, BUSH_YELLOW, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.GRASS_BUSH_YELLOW.get()),
                        10,
                        50,
                        bush_orange_place));
        register(context, BUSH_GRAY, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.GRASS_BUSH_GRAY.get()),
                        16,
                        200,
                        bush_gray_place));
        register(context, LAVENDER, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(
                                ModBlocks.LAVENDER.get().defaultBlockState().setValue(Lavender.AGE, 3)
                        ),
                        10,
                        3,
                        bush_orange_place));
        register(context, COTTON, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(
                                ModBlocks.COTTON.get().defaultBlockState().setValue(Lavender.AGE, 3)
                        ),
                        10,
                        3,
                        bush_orange_place));
        register(context, MOUNTAIN_FLOWER_ORANGE, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(
                                ModBlocks.MOUNTAIN_FLOWER_ORANGE.get().defaultBlockState().setValue(Lavender.AGE, 3)),
                        5,
                        3,
                        bush_orange_place));
        register(context, LITTLE_ROCKS, GrassPatchFeature,
                new GrassPatchConfiguration(
                        BlockStateProvider.simple(ModBlocks.LITTLE_ROCKS.get()),
                        10,
                        100,
                        little_rocks_place));
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
