package cws.dragonborn.block.entity.client;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.entity.blockentities.SkyrimBannerBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SkyrimBannerModel extends GeoModel<SkyrimBannerBlockEntity> {
    @Override
    public ResourceLocation getModelResource(SkyrimBannerBlockEntity geoBlockEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"geo/skyrim_banner.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SkyrimBannerBlockEntity geoBlockEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"textures/block/skyrim_banner.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SkyrimBannerBlockEntity geoBlockEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"animations/skyrim_banner.animation.json");
    }
}
