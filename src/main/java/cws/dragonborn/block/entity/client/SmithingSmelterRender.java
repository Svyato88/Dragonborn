package cws.dragonborn.block.entity.client;

import cws.dragonborn.block.entity.blockentities.NordicDoorMetalBlockEntity;
import cws.dragonborn.block.entity.blockentities.SmithingSmelterBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class SmithingSmelterRender extends GeoBlockRenderer<SmithingSmelterBlockEntity> {
    public SmithingSmelterRender(BlockEntityRendererProvider.Context context) {
        super(new SmithingSmelterModel());
    }
}


