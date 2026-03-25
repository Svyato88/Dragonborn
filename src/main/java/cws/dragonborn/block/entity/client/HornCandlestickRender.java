package cws.dragonborn.block.entity.client;

import cws.dragonborn.block.entity.blockentities.HornCandlestickBlockEntity;
import cws.dragonborn.block.entity.blockentities.WhiterunBannerBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class HornCandlestickRender extends GeoBlockRenderer<HornCandlestickBlockEntity> {
    public HornCandlestickRender(BlockEntityRendererProvider.Context context) {
        super(new HornCandlestickModel());
    }
}


