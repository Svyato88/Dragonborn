package cws.dragonborn.entity;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.entity.custom.ButterflyEntity;
import cws.dragonborn.entity.custom.FireflyEntity;
import cws.dragonborn.entity.custom.SkeletonEntity;
import cws.dragonborn.entity.custom.WolfForestEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Dragonborn.MOD_ID);

    public static final RegistryObject<EntityType<ButterflyEntity>> BUTTERFLY =
            ENTITY_TYPES.register("butterfly", () -> EntityType.Builder.of(ButterflyEntity::new, MobCategory.CREATURE)
                    .sized(0.1f, 0.1f).build("butterfly"));

    public static final RegistryObject<EntityType<FireflyEntity>> FIREFLY =
            ENTITY_TYPES.register("firefly", () -> EntityType.Builder.of(FireflyEntity::new, MobCategory.CREATURE)
                    .sized(0.1f, 0.1f).build("firefly"));

    public static final RegistryObject<EntityType<WolfForestEntity>> WOLF_FOREST =
            ENTITY_TYPES.register("wolf_forest", () -> EntityType.Builder.of(WolfForestEntity::new, MobCategory.CREATURE)
                    .sized(0.7f, 0.7f).build("wolf_forest"));

    public static final RegistryObject<EntityType<SkeletonEntity>> SKELETON =
            ENTITY_TYPES.register("skeleton", () -> EntityType.Builder.of(SkeletonEntity::new, MobCategory.CREATURE)
                    .sized(0.7f, 1.7f).build("skeleton"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}