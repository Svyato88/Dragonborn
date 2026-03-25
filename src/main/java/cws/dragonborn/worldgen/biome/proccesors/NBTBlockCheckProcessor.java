package cws.dragonborn.worldgen.biome.proccesors;

import com.mojang.serialization.Codec;
import cws.dragonborn.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.Nullable;
import java.util.Set;

public class NBTBlockCheckProcessor extends StructureProcessor {
    public static final Codec<NBTBlockCheckProcessor> CODEC = Codec.unit(NBTBlockCheckProcessor::new);

    private static final Set<Block> TARGET_BLOCKS = Set.of(
            ModBlocks.MOSS_YELLOW.get(),
            ModBlocks.STONE_SLAB.get(),
            ModBlocks.STONE_STAIRS.get(),
            ModBlocks.MOSSY_STONE_SLAB.get(),
            ModBlocks.MOSSY_STONE_STAIRS.get()
    );

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(
            LevelReader levelReader,
            BlockPos pos,
            BlockPos pivot,
            StructureTemplate.StructureBlockInfo original,
            StructureTemplate.StructureBlockInfo current,
            StructurePlaceSettings settings) {

        if (TARGET_BLOCKS.contains(current.state().getBlock())) {
            if (!levelReader.getBlockState(current.pos()).isAir()) {
                return null; // не вставляємо блок
            }
        }
        return current;
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return ModProcessors.NBT_BLOCK_CHECK_PROCESSOR.get();
    }
}