package cws.dragonborn.datagen;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.worldgen.biome.ModBiomes;
import cws.dragonborn.worldgen.biome.biomes.Spruce_forest;
import cws.dragonborn.worldgen.biome.biomes.Whiterun_plains;
import cws.dragonborn.worldgen.biome.fconfigured.ModConfiguredFeatures;
import cws.dragonborn.worldgen.biome.fplaced.ModPlacedFeatures;
import cws.dragonborn.worldgen.biome.surface.noises.ModNoises;
import cws.dragonborn.worldgen.density.ModDensityFunctions;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            //.add(Registries.DENSITY_FUNCTION, ModDensityFunctions::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(Registries.NOISE, ModNoises::bootstrap)
            .add(Registries.BIOME, ModBiomes::bootstrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Dragonborn.MOD_ID));
    }
}