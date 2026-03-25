package cws.dragonborn.entity.client;

import cws.dragonborn.entity.custom.ButterflyEntity;
import cws.dragonborn.entity.custom.FireflyEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class FireflyRender extends GeoEntityRenderer<FireflyEntity> {
    public FireflyRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FireflyModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}


