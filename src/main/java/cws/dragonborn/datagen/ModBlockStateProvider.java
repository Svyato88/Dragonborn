package cws.dragonborn.datagen;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Dragonborn.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        stairsBlock(((StairBlock) ModBlocks.STONE_STAIRS.get()), blockTexture(ModBlocks.STONE.get()));
        slabBlock(((SlabBlock) ModBlocks.STONE_SLAB.get()), blockTexture(ModBlocks.STONE.get()), blockTexture(ModBlocks.STONE.get()));

        stairsBlock(((StairBlock) ModBlocks.MOSSY_STONE_STAIRS.get()), blockTexture(ModBlocks.MOSSY_STONE.get()));
        slabBlock(((SlabBlock) ModBlocks.MOSSY_STONE_SLAB.get()), blockTexture(ModBlocks.MOSSY_STONE.get()), blockTexture(ModBlocks.MOSSY_STONE.get()));


        slabBlock(((SlabBlock) ModBlocks.PAVEMENT_SLAB.get()), blockTexture(ModBlocks.PAVEMENT.get()), blockTexture(ModBlocks.PAVEMENT.get()));


        stairsBlock(((StairBlock) ModBlocks.COBBLESTONE_WALL_STAIRS.get()), blockTexture(ModBlocks.COBBLESTONE_WALL.get()));
        slabBlock(((SlabBlock) ModBlocks.COBBLESTONE_WALL_SLAB.get()), blockTexture(ModBlocks.COBBLESTONE_WALL.get()), blockTexture(ModBlocks.COBBLESTONE_WALL.get()));
        wallBlock(((WallBlock) ModBlocks.COBBLESTONE_WALL_WALL.get()), blockTexture(ModBlocks.COBBLESTONE_WALL.get()));

        stairsBlock(((StairBlock) ModBlocks.MOSSY_COBBLESTONE_WALL_STAIRS.get()), blockTexture(ModBlocks.MOSSY_COBBLESTONE_WALL.get()));
        slabBlock(((SlabBlock) ModBlocks.MOSSY_COBBLESTONE_WALL_SLAB.get()), blockTexture(ModBlocks.MOSSY_COBBLESTONE_WALL.get()), blockTexture(ModBlocks.MOSSY_COBBLESTONE_WALL.get()));
        wallBlock(((WallBlock) ModBlocks.MOSSY_COBBLESTONE_WALL_WALL.get()), blockTexture(ModBlocks.MOSSY_COBBLESTONE_WALL.get()));


        stairsBlock(((StairBlock) ModBlocks.NORDIC_STONE_BRICKS_STAIRS.get()), blockTexture(ModBlocks.NORDIC_STONE_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.NORDIC_STONE_BRICKS_SLAB.get()), blockTexture(ModBlocks.NORDIC_STONE_BRICKS.get()), blockTexture(ModBlocks.NORDIC_STONE_BRICKS.get()));
        verticalSlabBlock(ModBlocks.NORDIC_STONE_BRICKS_HORIZONTAL_SLAB.get(), blockTexture(ModBlocks.NORDIC_STONE_BRICKS.get()));
        beamBlock(ModBlocks.NORDIC_STONE_BRICKS_BEAM.get(), blockTexture(ModBlocks.NORDIC_STONE_BRICKS.get()));
        beamHorizontalBlock(ModBlocks.NORDIC_STONE_BEAM_HORIZONTAL.get(), blockTexture(ModBlocks.NORDIC_STONE_BRICKS.get()));

        verticalSlabBlock(ModBlocks.NORDIC_STONE_SMOOTH_HORIZONTAL_SLAB.get(), blockTexture(ModBlocks.NORDIC_STONE_SMOOTH.get()));


        stairsBlock(((StairBlock) ModBlocks.COBBLED_LIMESTONE_STAIRS.get()), blockTexture(ModBlocks.COBBLED_LIMESTONE.get()));
        slabBlock(((SlabBlock) ModBlocks.COBBLED_LIMESTONE_SLAB.get()), blockTexture(ModBlocks.COBBLED_LIMESTONE.get()), blockTexture(ModBlocks.COBBLED_LIMESTONE.get()));
        verticalSlabBlock(ModBlocks.COBBLED_LIMESTONE_HORIZONTAL_SLAB.get(), blockTexture(ModBlocks.COBBLED_LIMESTONE.get()));
        beamBlock(ModBlocks.COBBLED_LIMESTONE_BEAM.get(), blockTexture(ModBlocks.COBBLED_LIMESTONE.get()));



        stairsBlock(((StairBlock) ModBlocks.SMOOTH_LIMESTONE_STAIRS.get()), blockTexture(ModBlocks.SMOOTH_LIMESTONE.get()));
        slabBlock(((SlabBlock) ModBlocks.SMOOTH_LIMESTONE_SLAB.get()), blockTexture(ModBlocks.SMOOTH_LIMESTONE.get()), blockTexture(ModBlocks.SMOOTH_LIMESTONE.get()));
        verticalSlabBlock(ModBlocks.SMOOTH_LIMESTONE_HORIZONTAL_SLAB.get(), blockTexture(ModBlocks.SMOOTH_LIMESTONE.get()));
        beamBlock(ModBlocks.SMOOTH_LIMESTONE_BEAM.get(), blockTexture(ModBlocks.SMOOTH_LIMESTONE.get()));


        stairsBlock(((StairBlock) ModBlocks.MOSSY_SMOOTH_LIMESTONE_STAIRS.get()), blockTexture(ModBlocks.MOSSY_SMOOTH_LIMESTONE.get()));
        slabBlock(((SlabBlock) ModBlocks.MOSSY_SMOOTH_LIMESTONE_SLAB.get()), blockTexture(ModBlocks.MOSSY_SMOOTH_LIMESTONE.get()), blockTexture(ModBlocks.MOSSY_SMOOTH_LIMESTONE.get()));
        verticalSlabBlock(ModBlocks.MOSSY_SMOOTH_LIMESTONE_HORIZONTAL_SLAB.get(), blockTexture(ModBlocks.MOSSY_SMOOTH_LIMESTONE.get()));
        beamBlock(ModBlocks.MOSSY_SMOOTH_LIMESTONE_BEAM.get(), blockTexture(ModBlocks.MOSSY_SMOOTH_LIMESTONE.get()));


        stairsBlock(((StairBlock) ModBlocks.LIMESTONE_PILLAR_STAIRS.get()), blockTexture(ModBlocks.LIMESTONE_PILLAR.get()));
        slabBlock(((SlabBlock) ModBlocks.LIMESTONE_PILLAR_SLAB.get()), blockTexture(ModBlocks.LIMESTONE_PILLAR_SOLID.get()), blockTexture(ModBlocks.LIMESTONE_PILLAR.get()));
        verticalSlabBlock(ModBlocks.LIMESTONE_PILLAR_HORIZONTAL_SLAB.get(), blockTexture(ModBlocks.LIMESTONE_PILLAR.get()));
        beamBlock(ModBlocks.LIMESTONE_PILLAR_BEAM.get(), blockTexture(ModBlocks.LIMESTONE_PILLAR_SOLID.get()));




        stairsBlock(((StairBlock) ModBlocks.TOWER_WALL_STAIRS.get()), blockTexture(ModBlocks.TOWER_WALL.get()));
        slabBlock(((SlabBlock) ModBlocks.TOWER_WALL_SLAB.get()), blockTexture(ModBlocks.TOWER_WALL.get()), blockTexture(ModBlocks.TOWER_WALL.get()));

        stairsBlock(((StairBlock) ModBlocks.MOSSY_TOWER_WALL_STAIRS.get()), blockTexture(ModBlocks.MOSSY_TOWER_WALL.get()));
        slabBlock(((SlabBlock) ModBlocks.MOSSY_TOWER_WALL_SLAB.get()), blockTexture(ModBlocks.MOSSY_TOWER_WALL.get()), blockTexture(ModBlocks.MOSSY_TOWER_WALL.get()));

        stairsBlock(((StairBlock) ModBlocks.STONE_BORDER_BLOCK_STAIRS.get()), blockTexture(ModBlocks.STONE_BORDER_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.STONE_BORDER_BLOCK_SLAB.get()), blockTexture(ModBlocks.STONE_BORDER_BLOCK.get()), blockTexture(ModBlocks.STONE_BORDER_BLOCK.get()));

        stairsBlock(((StairBlock) ModBlocks.TOWER_FLOR_STAIRS.get()), blockTexture(ModBlocks.TOWER_FLOR.get()));
        slabBlock(((SlabBlock) ModBlocks.TOWER_FLOR_SLAB.get()), blockTexture(ModBlocks.TOWER_FLOR.get()), blockTexture(ModBlocks.TOWER_FLOR.get()));


        stairsBlock(((StairBlock) ModBlocks.TOWER_FLOOR_STAIRS.get()), blockTexture(ModBlocks.TOWER_FLOOR.get()));
        slabBlock(((SlabBlock) ModBlocks.TOWER_FLOOR_SLAB.get()), blockTexture(ModBlocks.TOWER_FLOOR.get()), blockTexture(ModBlocks.TOWER_FLOR.get()));


        stairsBlock(((StairBlock) ModBlocks.STONE_WALL_STAIRS.get()), blockTexture(ModBlocks.STONE_WALL.get()));
        slabBlock(((SlabBlock) ModBlocks.STONE_WALL_SLAB.get()), blockTexture(ModBlocks.STONE_WALL.get()), blockTexture(ModBlocks.STONE_WALL.get()));


        stairsBlock(((StairBlock) ModBlocks.TOWER_PILLAR_STONE_STAIRS.get()), blockTexture(ModBlocks.TOWER_PILLAR_STONE.get()));
        slabBlock(((SlabBlock) ModBlocks.TOWER_PILLAR_STONE_SLAB.get()), blockTexture(ModBlocks.TOWER_PILLAR_STONE.get()), blockTexture(ModBlocks.TOWER_PILLAR_STONE.get()));


    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    protected void verticalSlabBlock(Block block, ResourceLocation texture) {
        ResourceLocation id = BuiltInRegistries.BLOCK.getKey(block);
        String name = id.getPath();
        ModelFile model = models()
                .withExistingParent(name, mcLoc("dragonborn:block/base/vertical_slab_base"))
                .texture("bottom", texture)
                .texture("top", texture)
                .texture("side", texture);

        getVariantBuilder(block)
                .forAllStates(state -> {
                    Direction dir = state.getValue(BlockStateProperties.HORIZONTAL_FACING);

                    return ConfiguredModel.builder()
                            .modelFile(model)
                            .rotationY((int) dir.toYRot())
                            .build();
                });
    }
    protected void beamBlock(Block block, ResourceLocation texture) {
        ModelFile straight = beamStraight(block, texture);
        ModelFile inner = beamInner(block, texture);
        ModelFile outer = beamOuter(block, texture);

        this.getVariantBuilder(block).forAllStatesExcept((state) -> {
            Direction facing = (Direction)state.getValue(StairBlock.FACING);
            Half half = (Half)state.getValue(StairBlock.HALF);
            StairsShape shape = (StairsShape)state.getValue(StairBlock.SHAPE);
            int yRot = (int)facing.getClockWise().toYRot();
            if (shape == StairsShape.INNER_LEFT || shape == StairsShape.OUTER_LEFT) {
                yRot += 270;
            }

            if (shape != StairsShape.STRAIGHT && half == Half.TOP) {
                yRot += 90;
            }

            yRot %= 360;
            boolean uvlock = yRot != 0 || half == Half.TOP;
            return ConfiguredModel.builder().modelFile(shape == StairsShape.STRAIGHT ? straight : (shape != StairsShape.INNER_LEFT && shape != StairsShape.INNER_RIGHT ? outer : inner)).rotationX(half == Half.BOTTOM ? 0 : 180).rotationY(yRot).uvLock(uvlock).build();
        }, new Property[]{StairBlock.WATERLOGGED});
    }
    protected ModelFile beamStraight(Block block, ResourceLocation texture) {
        return models()
                .withExistingParent(
                        getBlockName(block) + "_straight",
                        modLoc("block/base/block_beam_base")
                )
                .texture("side", texture)
                .texture("top", texture)
                .texture("bottom", texture);
    }
    protected ModelFile beamInner(Block block, ResourceLocation texture) {
        return models()
                .withExistingParent(
                        getBlockName(block) + "_inner",
                        modLoc("block/base/block_beam_inner_base")
                )
                .texture("side", texture)
                .texture("top", texture)
                .texture("bottom", texture);
    }
    protected ModelFile beamOuter(Block block, ResourceLocation texture) {
        return models()
                .withExistingParent(
                        getBlockName(block) + "_outer",
                        modLoc("block/base/block_beam_outer_base")
                )
                .texture("side", texture)
                .texture("top", texture)
                .texture("bottom", texture);
    }





    protected void beamHorizontalBlock(Block block, ResourceLocation texture) {
        ModelFile straight = beamHorizontalStraight(block, texture);

        this.getVariantBuilder(block).forAllStatesExcept((state) -> {
            Direction facing = (Direction)state.getValue(StairBlock.FACING);
            int yRot = (int)facing.getClockWise().toYRot();

                yRot += 90;

            yRot %= 360;
            boolean uvlock = yRot != 0;
            return ConfiguredModel.builder().modelFile(straight).rotationY(yRot).uvLock(uvlock).build();
        }, new Property[]{StairBlock.WATERLOGGED});
    }
    protected ModelFile beamHorizontalStraight(Block block, ResourceLocation texture) {
        return models()
                .withExistingParent(
                        getBlockName(block) + "_straight",
                        modLoc("block/base/block_beam_horizontal_base")
                )
                .texture("side", texture)
                .texture("top", texture)
                .texture("bottom", texture);
    }


    protected String getBlockName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }
}
