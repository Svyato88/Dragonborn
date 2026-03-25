package cws.dragonborn.worldgen.biome.regions;

import com.mojang.datafixers.util.Pair;
import cws.dragonborn.worldgen.biome.biomes.Spruce_forest_cold;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class SpruceForestColdRegion extends Region {
    public SpruceForestColdRegion(ResourceLocation name, int weight)
    {
        super(name, RegionType.OVERWORLD, weight);
    }
    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            builder.replaceBiome(Biomes.TAIGA, Spruce_forest_cold.SPRUCE_FOREST_COLD);
        });
    }
}