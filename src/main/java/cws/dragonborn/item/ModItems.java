package cws.dragonborn.item;

import cws.dragonborn.Dragonborn;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Dragonborn.MOD_ID);

    public static final RegistryObject<Item> SWEET_ROLL = ITEMS.register("sweet_roll",
            () -> new Item(new Item.Properties().food(ModFood.SWEET_ROLL)));

    public static final RegistryObject<Item> GLASS_SWORD = ITEMS.register("glass_sword",
            () -> new SwordItem(Tiers.NETHERITE,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> GLASS_AXE = ITEMS.register("glass_axe",
            () -> new SwordItem(Tiers.NETHERITE,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> DAWNGUARD_HELMET = ITEMS.register("dawnguard_helmet",
            () -> new ModArmor(ModArmorMaterial.DAWNGUARD,ArmorItem.Type.HELMET,new Item.Properties()));



    public static final RegistryObject<Item> IRON_BATTLEAXE = ITEMS.register("iron_battleaxe",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> IRON_DAGGER = ITEMS.register("iron_dagger",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> IRON_GREATSWORD = ITEMS.register("iron_greatsword",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> IRON_MACE = ITEMS.register("iron_mace",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> IRON_SWORD = ITEMS.register("iron_sword",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> IRON_WAR_AXE = ITEMS.register("iron_war_axe",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> IRON_WARHAMMER = ITEMS.register("iron_warhammer",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));



    public static final RegistryObject<Item> STEEL_BATTLEAXE = ITEMS.register("steel_battleaxe",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_DAGGER = ITEMS.register("steel_dagger",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_GREATSWORD = ITEMS.register("steel_greatsword",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_MACE = ITEMS.register("steel_mace",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_WARAXE = ITEMS.register("steel_waraxe",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_WARHAMMER = ITEMS.register("steel_warhammer",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));



    public static final RegistryObject<Item> ORCISH_BATTLEAXE = ITEMS.register("orcish_battleaxe",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> ORCISH_DAGGER = ITEMS.register("orcish_dagger",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> ORCISH_GREATSWORD = ITEMS.register("orcish_greatsword",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> ORCISH_MACE = ITEMS.register("orcish_mace",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> ORCISH_SWORD = ITEMS.register("orcish_sword",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> ORCISH_WARAXE = ITEMS.register("orcish_waraxe",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> ORCISH_WARHAMMER = ITEMS.register("orcish_warhammer",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));



    public static final RegistryObject<Item> ELVEN_BATTLEAXE = ITEMS.register("elven_battleaxe",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> ELVEN_DAGGER = ITEMS.register("elven_dagger",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> ELVEN_GREATSWORD = ITEMS.register("elven_greatsword",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> ELVEN_MACE = ITEMS.register("elven_mace",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> ELVEN_SWORD = ITEMS.register("elven_sword",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> ELVEN_WARAXE = ITEMS.register("elven_waraxe",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> ELVEN_WARHAMMER = ITEMS.register("elven_warhammer",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));



    public static final RegistryObject<Item> EBONY_BATTLEAXE = ITEMS.register("ebony_battleaxe",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> EBONY_DAGGER = ITEMS.register("ebony_dagger",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> EBONY_GREATSWORD = ITEMS.register("ebony_greatsword",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> EBONY_MACE = ITEMS.register("ebony_mace",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> EBONY_SWORD = ITEMS.register("ebony_sword",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> EBONY_WARAXE = ITEMS.register("ebony_waraxe",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> EBONY_WARHAMMER = ITEMS.register("ebony_warhammer",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));



    public static final RegistryObject<Item> DWARVEN_BATTLEAXE = ITEMS.register("dwarven_battleaxe",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> DWARVEN_DAGGER = ITEMS.register("dwarven_dagger",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> DWARVEN_GREATSWORD = ITEMS.register("dwarven_greatsword",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> DWARVEN_MACE = ITEMS.register("dwarven_mace",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> DWARVEN_SWORD = ITEMS.register("dwarven_sword",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> DWARVEN_WARAXE = ITEMS.register("dwarven_waraxe",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));

    public static final RegistryObject<Item> DWARVEN_WARHAMMER = ITEMS.register("dwarven_warhammer",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));



    public static final RegistryObject<Item> IMPERIAL_SWORD = ITEMS.register("imperial_sword",
            () -> new SwordItem(Tiers.IRON,1, 1, new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}