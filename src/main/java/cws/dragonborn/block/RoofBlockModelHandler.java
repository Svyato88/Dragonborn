package cws.dragonborn.block;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.custom.ModRoof;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Mod.EventBusSubscriber(modid = Dragonborn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RoofBlockModelHandler {
    @SubscribeEvent
    public static void onModifyBakingResult(ModelEvent.ModifyBakingResult event) {
        Map<ResourceLocation, BakedModel> modelRegistry = event.getModels();
        ResourceLocation blockId = new ResourceLocation(Dragonborn.MOD_ID, "hay_roof");
        Block block = BuiltInRegistries.BLOCK.get(blockId);

        if (block == Blocks.AIR) return;

        Dragonborn.LOGGER.info("========== Installing Roof Block Retexture Models ==========");

        int replacedCount = 0;
        int failedCount = 0;
        StateDefinition<Block, BlockState> stateDefinition = block.getStateDefinition();

        for (BlockState state : stateDefinition.getPossibleStates()) {
            ModelResourceLocation modelLocation = BlockModelShaper.stateToModelLocation(state);
            BakedModel originalModel = modelRegistry.get(modelLocation);

            if (originalModel == null) {
                failedCount++;
                Dragonborn.LOGGER.warn("No model found for: {}", modelLocation);
                continue;
            }

            // Отримуємо тип блоку з state
            RoofBlocksList roofBlock = state.getValue(ModRoof.BLOCK);

            Dragonborn.LOGGER.info("Installing retexture for state: block={}, facing={}, shape={}, latest={}",
                    roofBlock.getSerializedName(),
                    state.getValue(ModRoof.FACING).getSerializedName(),
                    state.getValue(ModRoof.SHAPE).getSerializedName(),
                    state.getValue(ModRoof.LATEST));
            Dragonborn.LOGGER.info("  Texture path: {}", roofBlock.getTexture());

            // Створюємо модель що замінює всі текстури
            //BakedModel retexturedModel = new RetexturedRoofModel(originalModel, roofBlock.getTexture());
            BakedModel retexturedModel = new RetexturedRoofModel1(originalModel, roofBlock.getTexture());

            modelRegistry.put(modelLocation, retexturedModel);
            replacedCount++;
        }

        Dragonborn.LOGGER.info("========== Installation Complete ==========");
        Dragonborn.LOGGER.info("Installed: {} models", replacedCount);
        Dragonborn.LOGGER.info("Failed: {} models", failedCount);
    }
}
