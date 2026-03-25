package cws.dragonborn.item.client;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.item.ModArmor;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModArmorModel extends GeoModel<ModArmor> {
    @Override
    public ResourceLocation getModelResource(ModArmor modArmor) {
        return new ResourceLocation(Dragonborn.MOD_ID,"geo/dawnguard_helmet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ModArmor modArmor) {
        return new ResourceLocation(Dragonborn.MOD_ID,"textures/armor/dawnguard_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ModArmor modArmor) {
        return new ResourceLocation(Dragonborn.MOD_ID,"animations/dawnguard_helmet.animation.json");
    }
}
