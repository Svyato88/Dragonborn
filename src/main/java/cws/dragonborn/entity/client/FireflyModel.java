package cws.dragonborn.entity.client;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.entity.custom.ButterflyEntity;
import cws.dragonborn.entity.custom.FireflyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FireflyModel extends GeoModel<FireflyEntity> {
    @Override
    public ResourceLocation getModelResource(FireflyEntity geoEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"geo/mobs/firefly.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FireflyEntity entity) {
        return new ResourceLocation(Dragonborn.MOD_ID, "textures/entity/firefly.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FireflyEntity geoEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"animations/mobs/butterfly.animation.json");
    }
}
