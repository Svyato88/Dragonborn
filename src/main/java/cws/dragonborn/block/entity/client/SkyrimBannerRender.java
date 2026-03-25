package cws.dragonborn.block.entity.client;

import cws.dragonborn.block.entity.blockentities.SkyrimBannerBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class SkyrimBannerRender extends GeoBlockRenderer<SkyrimBannerBlockEntity> {
    public SkyrimBannerRender(BlockEntityRendererProvider.Context context) {
        super(new SkyrimBannerModel());
    }
}


