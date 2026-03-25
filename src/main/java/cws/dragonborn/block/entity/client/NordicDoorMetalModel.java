package cws.dragonborn.block.entity.client;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.entity.blockentities.NordicDoorMetalBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NordicDoorMetalModel extends GeoModel<NordicDoorMetalBlockEntity> {
    @Override
    public ResourceLocation getModelResource(NordicDoorMetalBlockEntity geoBlockEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"geo/nordic_door_metal.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NordicDoorMetalBlockEntity geoBlockEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"textures/block/blockentities/nordic_door_metal.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NordicDoorMetalBlockEntity geoBlockEntity) {
        return new ResourceLocation(Dragonborn.MOD_ID,"animations/nordic_door_metal.animation.json");
    }
}
