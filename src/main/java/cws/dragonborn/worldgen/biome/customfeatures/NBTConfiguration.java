package cws.dragonborn.worldgen.biome.customfeatures;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import java.util.List;

public class NBTConfiguration implements FeatureConfiguration {
    public static final Codec<NBTConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.listOf().fieldOf("structure_list").forGetter(cfg -> cfg.structureList),
            BlockPos.CODEC.fieldOf("offset").forGetter(cfg -> cfg.offset)
    ).apply(instance, NBTConfiguration::new));

    public final List<ResourceLocation> structureList;
    public final BlockPos offset;

    public NBTConfiguration(List<ResourceLocation> structureList, BlockPos offset) {
        this.structureList = structureList;
        this.offset = offset;
    }
}
