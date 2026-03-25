package cws.dragonborn.entity.client;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.entity.custom.ButterflyEntity;
import cws.dragonborn.entity.custom.WolfForestEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WolfForestModel extends GeoModel<WolfForestEntity> {
    @Override
    public ResourceLocation getModelResource(WolfForestEntity geoEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"geo/mobs/forest_wolf.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WolfForestEntity entity) {
        return new ResourceLocation(Dragonborn.MOD_ID, "textures/entity/forest_wolf.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WolfForestEntity geoEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"animations/mobs/wolf_forest.animation.json");
    }
}
