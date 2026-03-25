package cws.dragonborn.block.entity.client;

import cws.dragonborn.block.entity.blockentities.NordicDoorMetalBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class NordicDoorMetalRender extends GeoBlockRenderer<NordicDoorMetalBlockEntity> {
    public NordicDoorMetalRender(BlockEntityRendererProvider.Context context) {
        super(new NordicDoorMetalModel());
    }
}


