package cws.dragonborn.worldgen.biome.customfeatures;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class GrassPatchConfiguration implements FeatureConfiguration {
    public final BlockStateProvider stateProvider;
    public final int radius;
    public final int count;
    public final RuleTest validBlocks;

    public GrassPatchConfiguration(BlockStateProvider stateProvider, int radius, int count, RuleTest validBlocks) {
        this.stateProvider = stateProvider;
        this.radius = radius;
        this.count = count;
        this.validBlocks = validBlocks;
    }

    public static final Codec<GrassPatchConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockStateProvider.CODEC.fieldOf("state_provider").forGetter(cfg -> cfg.stateProvider),
            Codec.INT.fieldOf("radius").forGetter(cfg -> cfg.radius),
            Codec.INT.fieldOf("count").forGetter(cfg -> cfg.count),
            RuleTest.CODEC.fieldOf("valid_blocks").forGetter(cfg -> cfg.validBlocks)
    ).apply(instance, GrassPatchConfiguration::new));
}