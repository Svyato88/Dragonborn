package cws.dragonborn.block;

import cws.dragonborn.block.client.render.TargetModel;
import cws.dragonborn.block.entity.ModBlockEntities;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MULTIPART_BLOCK.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PLANKS_ROOF.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HAY_ROOF.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COLD_HAY_ROOF.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAW_PLANKS_PLATFORM.get(), RenderType.cutoutMipped());


        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PAVEMENT_BORDER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PAVEMENT_SLAB_BORDER.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.NORDIC_STONE_SMOOTH.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.NORDIC_STONE_SMOOTH_BORDER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.NORDIC_STONE_SMOOTH_BORDER_HORIZONTAL_SLAB.get(), RenderType.translucent());



        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARPET_BROWN.get(), RenderType.translucent());



        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRASS_BLOCK.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRASS_BLOCK_FULL.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRASS_BLOCK_FULL_FLOWERS.get(), RenderType.cutoutMipped());


        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SPRUCE_LEAVES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SPRUCE_BRANCH.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SPRUCE_BRANCH_MEDIUM.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SPRUCE_ROOTS.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SPRUCE_STUMP_TOP.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SPRUCE_SAPLING.get(), RenderType.cutoutMipped());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SNOWY_SPRUCE_LEAVES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SNOWY_SPRUCE_BRANCH.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SNOWY_SPRUCE_BRANCH_MEDIUM.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SNOWY_SPRUCE_ROOTS.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SNOWY_SPRUCE_STUMP_TOP.get(), RenderType.cutoutMipped());


        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DRY_BRANCH_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DRY_TREE_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DRY_TREE_BRANCH_MEDIUM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DRY_TREE_ROOTS_SMALL.get(), RenderType.cutout());


        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRASS_BUSH_GRAY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRASS_BUSH_ORANGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRASS_BUSH_ORANGE_TALL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRASS_BUSH_YELLOW.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRASS_FOREST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRASS_FOREST_FLOWERS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRASS_DRY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TREE_BUSH.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ASARUM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ASARUM_DRY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FALLEN_SPRUCE_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FERN_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FERN_BUSH_DRY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SNOWY_GRASS_DRY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PRICKLY_PLANT.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SNOWY_BUSH_DRY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BUSH_DRY.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MOSS_YELLOW.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MOSS_WALL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DRY_ROOTS_FLOOR.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LAVENDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COTTON.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MOUNTAIN_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MOUNTAIN_FLOWER_ORANGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.THISTLE_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SNOWBERRIES_BUSH.get(), RenderType.cutout());


        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BIG_SKULL.get(), RenderType.cutoutMipped());


        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HAY_BLOCK.get(), RenderType.cutoutMipped());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WOODEN_WINDOWS.get(), RenderType.translucent());


        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRAZIER.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.NORDIC_BRAZIER_BASE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LATERN1.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HORN_CHANDELIER.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TORCH_STAND.get(), RenderType.cutoutMipped());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CAGE.get(), RenderType.cutoutMipped());
    }
}
