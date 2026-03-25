package cws.dragonborn.worldgen.biome.customfeatures;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class NBTBlockCheckConfiguration implements FeatureConfiguration {
    public static final Codec<NBTBlockCheckConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.listOf().fieldOf("structure_list").forGetter(cfg -> cfg.structureList),
            BlockPos.CODEC.fieldOf("offset").forGetter(cfg -> cfg.offset),
            RuleTest.CODEC.fieldOf("valid_blocks").forGetter(cfg -> cfg.validBlocks)
    ).apply(instance, NBTBlockCheckConfiguration::new));

    public final List<ResourceLocation> structureList;
    public final BlockPos offset;
    public final RuleTest validBlocks;

    public NBTBlockCheckConfiguration(List<ResourceLocation> structureList, BlockPos offset, RuleTest validBlocks) {
        this.structureList = structureList;
        this.offset = offset;
        this.validBlocks = validBlocks;
    }
}
