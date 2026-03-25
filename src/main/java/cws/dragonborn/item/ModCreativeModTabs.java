package cws.dragonborn.item;

import cws.dragonborn.Dragonborn;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Dragonborn.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DRAGONBORNITEM_TAB = CREATIVE_MODE_TABS.register("dragonborniten_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SWEET_ROLL.get()))
                    .title(Component.translatable("creativetab.dragonborniten_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SWEET_ROLL.get());





                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}