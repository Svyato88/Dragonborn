package cws.dragonborn.worldgen.biome.customfeatures;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record SnowPlaceConfigured(int threshold) implements FeatureConfiguration {
    public static final Codec<SnowPlaceConfigured> CODEC =
            Codec.INT.fieldOf("threshold")
                    .xmap(SnowPlaceConfigured::new, SnowPlaceConfigured::threshold)
                    .codec();
}


