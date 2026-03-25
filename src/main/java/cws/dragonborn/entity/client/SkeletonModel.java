package cws.dragonborn.entity.client;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.entity.custom.FireflyEntity;
import cws.dragonborn.entity.custom.SkeletonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;

public class SkeletonModel extends DefaultedEntityGeoModel<SkeletonEntity> {
    public SkeletonModel() {
        super(new ResourceLocation(Dragonborn.MOD_ID, "skeleton"), true);
    }

    @Override
    public ResourceLocation getModelResource(SkeletonEntity geoEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"geo/mobs/skeleton.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SkeletonEntity entity) {
        return new ResourceLocation(Dragonborn.MOD_ID, "textures/entity/skeleton.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SkeletonEntity geoEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"animations/mobs/skeleton.animation.json");
    }
}
