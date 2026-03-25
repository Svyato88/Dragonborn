package cws.dragonborn.block.entity.client;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.entity.blockentities.WhiterunBannerBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WhiterunBannerModel extends GeoModel<WhiterunBannerBlockEntity> {
    @Override
    public ResourceLocation getModelResource(WhiterunBannerBlockEntity geoBlockEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"geo/whiterun_banner.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WhiterunBannerBlockEntity geoBlockEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"textures/block/whiterun_banner.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WhiterunBannerBlockEntity geoBlockEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"animations/whiterun_banner.animation.json");
    }
}
