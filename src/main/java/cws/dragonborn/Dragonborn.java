package cws.dragonborn;

import com.mojang.logging.LogUtils;
import cws.dragonborn.block.ClientSetup;
import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.block.entity.ModBlockEntities;
import cws.dragonborn.block.entity.ModPaintings;
import cws.dragonborn.block.entity.client.*;
import cws.dragonborn.entity.ModEntities;
import cws.dragonborn.entity.client.ButterflyRender;
import cws.dragonborn.entity.client.FireflyRender;
import cws.dragonborn.entity.client.SkeletonRender;
import cws.dragonborn.entity.client.WolfForestRender;
import cws.dragonborn.entity.custom.ButterflyEntity;
import cws.dragonborn.item.ModCreativeModTabs;
import cws.dragonborn.item.ModItems;
import cws.dragonborn.particle.ModParticles;
import cws.dragonborn.sound.ModSounds;
import cws.dragonborn.worldgen.biome.*;
import cws.dragonborn.worldgen.biome.proccesors.ModProcessors;
import cws.dragonborn.worldgen.biome.surface.ModSurfaceRules;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Dragonborn.MOD_ID)
public class Dragonborn {
    public static final String MOD_ID = "dragonborn";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Dragonborn() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DragonbornFeatures.register(modEventBus);

        ModCreativeModTabs.register(modEventBus);

        ModSounds.register(modEventBus);

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModEntities.register(modEventBus);

        ModParticles.register(modEventBus);

        ModProcessors.register(modEventBus);

        ModPaintings.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        modEventBus.addListener(ClientSetup::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        ModTerrablender.registerBiomes();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.SWEET_ROLL);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

   @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            BlockEntityRenderers.register(ModBlockEntities.WHITERUN_BANNER_BLOCK_ENTITY.get(), WhiterunBannerRender::new);

            BlockEntityRenderers.register(ModBlockEntities.SKYRIM_BANNER_BLOCK_ENTITY.get(), SkyrimBannerRender::new);

            BlockEntityRenderers.register(ModBlockEntities.NORDIC_DOOR_METAL_BLOCK_ENTITY.get(), NordicDoorMetalRender::new);

            BlockEntityRenderers.register(ModBlockEntities.SMITHING_SMELTER_BLOCK_ENTITY.get(), SmithingSmelterRender::new);

            BlockEntityRenderers.register(ModBlockEntities.HORN_CANDLESTICK_BLOCK_ENTITY.get(), HornCandlestickRender::new);

            EntityRenderers.register(ModEntities.BUTTERFLY.get(), ButterflyRender::new);
            EntityRenderers.register(ModEntities.FIREFLY.get(), FireflyRender::new);

            EntityRenderers.register(ModEntities.WOLF_FOREST.get(), WolfForestRender::new);

            EntityRenderers.register(ModEntities.SKELETON.get(), SkeletonRender::new);
        }
    }
}