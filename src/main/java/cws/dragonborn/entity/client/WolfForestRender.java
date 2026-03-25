package cws.dragonborn.entity.client;

import cws.dragonborn.entity.custom.ButterflyEntity;
import cws.dragonborn.entity.custom.WolfForestEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WolfForestRender extends GeoEntityRenderer<WolfForestEntity> {
    public WolfForestRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WolfForestModel());
    }
}


