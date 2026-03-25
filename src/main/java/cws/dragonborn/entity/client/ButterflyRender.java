package cws.dragonborn.entity.client;

import cws.dragonborn.entity.custom.ButterflyEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class ButterflyRender extends GeoEntityRenderer<ButterflyEntity> {
    public ButterflyRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ButterflyModel());
    }
}


