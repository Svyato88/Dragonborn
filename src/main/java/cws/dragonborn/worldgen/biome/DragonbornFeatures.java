package cws.dragonborn.worldgen.biome;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.worldgen.biome.customfeatures.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DragonbornFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, Dragonborn.MOD_ID);

    public static final RegistryObject<Feature<NBTConfiguration>> NBT_STRUCTURE =
            FEATURES.register("nbt_structure", () -> new NBTStructureFeature(NBTConfiguration.CODEC));

    public static final RegistryObject<Feature<NBTBlockCheckConfiguration>> NBT_BLOCK_CHECK =
            FEATURES.register("nbt_block_check", () -> new NBTBlockCheckFeature(NBTBlockCheckConfiguration.CODEC));

    public static final RegistryObject<Feature<GrassPatchConfiguration>> GRASS_PATCH =
            FEATURES.register("grass_patch", () -> new GrassPatchFeature(GrassPatchConfiguration.CODEC));

    public static final RegistryObject<Feature<SpawnFeatureInRadiusConfiguration>> FEATURE_RADIUS =
            FEATURES.register("feature_radius", () -> new SpawnFeatureInRadius(SpawnFeatureInRadiusConfiguration.CODEC));

    public static final RegistryObject<TreeSpruceGrower> TREE_SPRUCE_GROWER =
            FEATURES.register("tree_spruce_grower", () -> new TreeSpruceGrower(TreeSpruceGrower.CODEC));

    public static final RegistryObject<Feature<SnowPlaceConfigured>> SNOW_PLACE =
            FEATURES.register("snow_place", () -> new SnowPlaceFeature(SnowPlaceConfigured.CODEC));

    public static final RegistryObject<Feature<HillsFeaturePlaceConfigured>> HILL_FEATURES_PLACE =
            FEATURES.register("hill_features_place", () -> new HillsFeaturePlace(HillsFeaturePlaceConfigured.CODEC));

    public static void register(IEventBus modEventBus) {
        FEATURES.register(modEventBus);
    }
}