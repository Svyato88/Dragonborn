package cws.dragonborn.entity.client;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.entity.custom.ButterflyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ButterflyModel extends GeoModel<ButterflyEntity> {
    @Override
    public ResourceLocation getModelResource(ButterflyEntity geoEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"geo/mobs/butterfly.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ButterflyEntity entity) {

        return switch (entity.getVariant()) {
            case BLUE -> new ResourceLocation(Dragonborn.MOD_ID, "textures/entity/butterfly.png");
            case ORANGE -> new ResourceLocation(Dragonborn.MOD_ID, "textures/entity/butterfly_orange.png");
      };
    }

    @Override
    public ResourceLocation getAnimationResource(ButterflyEntity geoEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"animations/mobs/butterfly.animation.json");
    }
}
