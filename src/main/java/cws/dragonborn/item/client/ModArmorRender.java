package cws.dragonborn.item.client;

import cws.dragonborn.item.ModArmor;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ModArmorRender extends GeoArmorRenderer<ModArmor> {
    public ModArmorRender() {
        super(new ModArmorModel());
    }
}
