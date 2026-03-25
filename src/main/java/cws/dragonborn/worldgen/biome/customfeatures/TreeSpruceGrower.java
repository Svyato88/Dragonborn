package cws.dragonborn.worldgen.biome.customfeatures;

import com.mojang.serialization.Codec;
import cws.dragonborn.block.custom.exclusive.SpruceSapling;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class TreeSpruceGrower extends Feature<NoneFeatureConfiguration> implements FeatureConfiguration {

    public static final Codec<NoneFeatureConfiguration> CODEC = NoneFeatureConfiguration.CODEC;
    private final AbstractTreeGrower grower = new SpruceSapling();

    public TreeSpruceGrower(Codec<NoneFeatureConfiguration> codec) {
        super(NoneFeatureConfiguration.CODEC); // ✅ тут готовий Codec
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {

        if (!(context.level() instanceof ServerLevel level)) return false;

        return grower.growTree(
                level,
                context.chunkGenerator(),
                context.origin(),
                Blocks.AIR.defaultBlockState(),
                context.random()
        );
    }
}