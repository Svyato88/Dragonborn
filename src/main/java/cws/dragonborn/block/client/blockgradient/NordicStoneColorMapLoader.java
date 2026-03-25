package cws.dragonborn.block.client.blockgradient;

import com.mojang.blaze3d.platform.NativeImage;
import cws.dragonborn.Dragonborn;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static cws.dragonborn.block.client.blockgradient.NordicStoneColorMap.loadColormap;


@Mod.EventBusSubscriber(modid = Dragonborn.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NordicStoneColorMapLoader {

    @SubscribeEvent
    public static void onRegisterReloadListeners(RegisterClientReloadListenersEvent event) {

        event.registerReloadListener(new PreparableReloadListener() {

            @Override
            public @NotNull CompletableFuture<Void> reload(
                    PreparationBarrier barrier,
                    ResourceManager resourceManager,
                    ProfilerFiller prepareProfiler,
                    ProfilerFiller applyProfiler,
                    Executor prepareExecutor,
                    Executor applyExecutor) {

                // 1. PREPARE — фонова підготовка
                CompletableFuture<Void> prepareFuture = CompletableFuture.runAsync(() -> {
                    ResourceLocation loc = new ResourceLocation(
                            Dragonborn.MOD_ID,
                            "textures/colormap/nordic_stone_gradient.png"
                    );

                    try {
                        Optional<Resource> optional = resourceManager.getResource(loc);
                        if (optional.isEmpty()) {
                            System.err.println("Colormap NOT FOUND: " + loc);
                            return;
                        }

                        try (InputStream stream = optional.get().open()) {
                            NativeImage image = NativeImage.read(stream);
                            NordicStoneColorMap.init(image);
                            System.err.println("Colormap WAS FOUND");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, prepareExecutor);

                // 2. BARRIER — ОБОВʼЯЗКОВО
                return prepareFuture
                        .thenCompose(barrier::wait)
                        // 3. APPLY — головний потік
                        .thenRunAsync(() -> {
                            // нічого не потрібно
                        }, applyExecutor);
            }
        });
    }
}



