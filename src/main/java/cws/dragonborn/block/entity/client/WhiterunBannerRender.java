package cws.dragonborn.block.entity.client;

import cws.dragonborn.block.entity.blockentities.WhiterunBannerBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class WhiterunBannerRender extends GeoBlockRenderer<WhiterunBannerBlockEntity> {
    public WhiterunBannerRender(BlockEntityRendererProvider.Context context) {
        super(new WhiterunBannerModel());
    }
}


