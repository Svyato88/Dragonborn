package cws.dragonborn.worldgen.biome.customfeatures;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class SpawnFeatureInRadiusConfiguration implements FeatureConfiguration {

    public final Holder<ConfiguredFeature<?, ?>> feature;

    public final int radius;
    public final int count;
    public final RuleTest validBlocks;

    public SpawnFeatureInRadiusConfiguration(Holder<ConfiguredFeature<?, ?>> feature, int radius, int count, RuleTest validBlocks) {
        this.feature = feature;
        this.radius = radius;
        this.count = count;
        this.validBlocks = validBlocks;
    }

    public static final Codec<SpawnFeatureInRadiusConfiguration> CODEC =
            RecordCodecBuilder.create(instance -> instance.group(
                    ConfiguredFeature.CODEC.fieldOf("feature").forGetter(c -> c.feature),
                    Codec.INT.fieldOf("radius").forGetter(c -> c.radius),
                    Codec.INT.fieldOf("count").forGetter(c -> c.count),
                    RuleTest.CODEC.fieldOf("valid_blocks").forGetter(cfg -> cfg.validBlocks)
            ).apply(instance, SpawnFeatureInRadiusConfiguration::new));
}