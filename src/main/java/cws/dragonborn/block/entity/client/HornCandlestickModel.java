package cws.dragonborn.block.entity.client;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.entity.blockentities.HornCandlestickBlockEntity;
import cws.dragonborn.block.entity.blockentities.WhiterunBannerBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HornCandlestickModel extends GeoModel<HornCandlestickBlockEntity> {
    @Override
    public ResourceLocation getModelResource(HornCandlestickBlockEntity geoBlockEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"geo/horn_candlestick.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HornCandlestickBlockEntity geoBlockEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"textures/block/horn_candlestick.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HornCandlestickBlockEntity geoBlockEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"animations/whiterun_banner.animation.json");
    }
}
