package cws.dragonborn.worldgen.biome.regions;

import com.mojang.datafixers.util.Pair;
import cws.dragonborn.worldgen.biome.biomes.Spruce_forest_cold;
import cws.dragonborn.worldgen.biome.biomes.Spruce_forest_snowy;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class SpruceForestSnowyRegion extends Region {
    public SpruceForestSnowyRegion(ResourceLocation name, int weight)
    {
        super(name, RegionType.OVERWORLD, weight);
    }
    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            builder.replaceBiome(Biomes.SNOWY_TAIGA, Spruce_forest_snowy.SNOWY_SPRUCE_FOREST);
            builder.replaceBiome(Biomes.GROVE, Spruce_forest_snowy.SNOWY_SPRUCE_FOREST);
        });
    }
}