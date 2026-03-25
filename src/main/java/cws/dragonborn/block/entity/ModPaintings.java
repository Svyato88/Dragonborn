package cws.dragonborn.block.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTINGS =
            DeferredRegister.create(Registries.PAINTING_VARIANT, "dragonborn");

    public static final RegistryObject<PaintingVariant> CUSTOM_PAINTING = PAINTINGS.register("tom_howard",
            () -> new PaintingVariant(112, 64)); // Розмір у пікселях

    public static void register(IEventBus eventBus) {
        PAINTINGS.register(eventBus);
    }
}
