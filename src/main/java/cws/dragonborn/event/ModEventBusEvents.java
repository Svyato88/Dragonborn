package cws.dragonborn.event;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.entity.ModEntities;
import cws.dragonborn.entity.custom.ButterflyEntity;
import cws.dragonborn.entity.custom.SkeletonEntity;
import cws.dragonborn.entity.custom.WolfForestEntity;
import cws.dragonborn.particle.ModParticles;
import cws.dragonborn.particle.custom.SkeletonEyesWhiteParticle;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Dragonborn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.BUTTERFLY.get(), ButterflyEntity.createAttributes().build());
        event.put(ModEntities.FIREFLY.get(), ButterflyEntity.createAttributes().build());

        event.put(ModEntities.WOLF_FOREST.get(), WolfForestEntity.createAttributes().build());

        event.put(ModEntities.SKELETON.get(), SkeletonEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.SKELETON_EYES_WHITE.get(),
                SkeletonEyesWhiteParticle.Provider::new);
    }
}