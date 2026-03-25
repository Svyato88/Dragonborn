package cws.dragonborn.block.entity;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.block.entity.blockentities.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Dragonborn.MOD_ID);

    public static final RegistryObject<BlockEntityType<WhiterunBannerBlockEntity>> WHITERUN_BANNER_BLOCK_ENTITY=
            BLOCK_ENTITIES.register("whiterun_banner", () ->
                    BlockEntityType.Builder.of(WhiterunBannerBlockEntity::new,
                            ModBlocks.WHITERUN_BANNER.get()).build(null));

    public static final RegistryObject<BlockEntityType<SkyrimBannerBlockEntity>> SKYRIM_BANNER_BLOCK_ENTITY=
            BLOCK_ENTITIES.register("skyrim_banner", () ->
                    BlockEntityType.Builder.of(SkyrimBannerBlockEntity::new,
                            ModBlocks.SKYRIM_BANNER.get()).build(null));



    public static final RegistryObject<BlockEntityType<NordicDoorMetalBlockEntity>> NORDIC_DOOR_METAL_BLOCK_ENTITY=
            BLOCK_ENTITIES.register("nordic_door_metal", () ->
                    BlockEntityType.Builder.of(NordicDoorMetalBlockEntity::new,
                            ModBlocks.NORDIC_DOOR_METAL.get()).build(null));



    public static final RegistryObject<BlockEntityType<SmithingSmelterBlockEntity>> SMITHING_SMELTER_BLOCK_ENTITY=
            BLOCK_ENTITIES.register("smithing_smelter", () ->
                    BlockEntityType.Builder.of(SmithingSmelterBlockEntity::new,
                            ModBlocks.SMITHING_SMELTER.get()).build(null));


    public static final RegistryObject<BlockEntityType<TargetEntity>> TARGET_ENTITY =
            BLOCK_ENTITIES.register("target",
                    () -> BlockEntityType.Builder.of(TargetEntity::new, ModBlocks.TARGET.get())
                            .build(null));

    public static final RegistryObject<BlockEntityType<HornCandlestickBlockEntity>> HORN_CANDLESTICK_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("horn_candlestick",
                    () -> BlockEntityType.Builder.of(HornCandlestickBlockEntity::new, ModBlocks.HORN_CANDLESTICK.get())
                            .build(null));



    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
