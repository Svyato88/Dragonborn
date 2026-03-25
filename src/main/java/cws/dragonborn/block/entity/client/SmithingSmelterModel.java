package cws.dragonborn.block.entity.client;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.entity.blockentities.NordicDoorMetalBlockEntity;
import cws.dragonborn.block.entity.blockentities.SmithingSmelterBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SmithingSmelterModel extends GeoModel<SmithingSmelterBlockEntity> {
    @Override
    public ResourceLocation getModelResource(SmithingSmelterBlockEntity geoBlockEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"geo/smithing_smelter.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SmithingSmelterBlockEntity geoBlockEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"textures/block/blockentities/smithing_smelter.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SmithingSmelterBlockEntity geoBlockEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"animations/smithing_smelter.animation.json");
    }
}
