package cws.dragonborn.worldgen.biome.customfeatures;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

    public record HillsFeaturePlaceConfigured(int threshold) implements FeatureConfiguration {
        public static final Codec<HillsFeaturePlaceConfigured> CODEC =
                Codec.INT.fieldOf("threshold")
                        .xmap(HillsFeaturePlaceConfigured::new, HillsFeaturePlaceConfigured::threshold)
                        .codec();
    }


