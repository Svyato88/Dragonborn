package cws.dragonborn.block.custom.exclusive;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import java.util.Map;

public class SpruceSapling extends AbstractTreeGrower {

    private static final ResourceLocation[] TREE_VARIANTS = new ResourceLocation[]{
            new ResourceLocation("dragonborn", "trees/spruce_tree1"),
            new ResourceLocation("dragonborn", "trees/spruce_tree2"),
            new ResourceLocation("dragonborn", "trees/spruce_tree3"),
            new ResourceLocation("dragonborn", "trees/spruce_tree4"),
            new ResourceLocation("dragonborn", "trees/spruce_tree5")
    };

    Map<String, BlockPos> treeOffsets = Map.of(
            "spruce_tree1", new BlockPos(2, 1, 2),
            "spruce_tree2", new BlockPos(3, 1, 2),
            "spruce_tree3", new BlockPos(2, 1, 2),
            "spruce_tree4", new BlockPos(2, 1, 2),
            "spruce_tree5", new BlockPos(2, 1, 2)
    );

    @Override
    public boolean growTree(ServerLevel level, ChunkGenerator generator, BlockPos pos, BlockState state, RandomSource random) {
        StructureTemplateManager manager = level.getStructureManager();

        // Випадкове дерево
        int index = random.nextInt(TREE_VARIANTS.length);
        ResourceLocation chosenTree = TREE_VARIANTS[index];

        // Можливі зміщення для дерев
        BlockPos[] OFFSETS = {
                new BlockPos(2, 1, 2),
                new BlockPos(3, 1, 2),
                new BlockPos(2, 1, 2),
                new BlockPos(2, 1, 2),
                new BlockPos(2, 1, 2),
                // тощо, залежно від TREE_VARIANTS.length
        };

        StructureTemplate template = manager.getOrCreate(chosenTree);
        if (template == null) {
            System.err.println("❌ Не вдалося завантажити структуру: " + chosenTree);
            return false;
        }

        BlockPos offset = OFFSETS[index];
        BlockPos placeAt = pos.above().subtract(offset); // центр + зміщення

        boolean placed = template.placeInWorld(
                level,
                placeAt,
                placeAt,
                new StructurePlaceSettings(),
                random,
                2
        );

        if (placed) {
            System.out.println("✅ Структура " + chosenTree + " згенерована в " + placeAt);
        } else {
            System.err.println("⚠️ Структура " + chosenTree + " не змогла згенеруватись.");
        }

        return placed;
    }
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bees) {
        return null; // Ми не використовуємо ConfiguredFeature, бо працюємо зі структурами
    }

}