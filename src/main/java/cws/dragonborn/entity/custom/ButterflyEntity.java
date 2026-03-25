package cws.dragonborn.entity.custom;

import cws.dragonborn.entity.ai.ButterflyLandOnBlockGoal;
import cws.dragonborn.entity.ai.ButterflyRandomFlyingGoal;
import cws.dragonborn.entity.variant.ButterflyVariant;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ButterflyEntity extends Animal implements FlyingAnimal, GeoEntity {
    protected static final RawAnimation FLY_ANIM = RawAnimation.begin().thenLoop("idlefly");
    protected static final RawAnimation IDLE_ANIM = RawAnimation.begin().thenLoop("idle");

    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(ButterflyEntity.class, EntityDataSerializers.INT);

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public ButterflyEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new FlyingMoveControl(this, 20, true);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.0D)
                .add(Attributes.FLYING_SPEED, 0.6D);
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Flying", 5, this::flyAnimController));
    }
    protected <E extends ButterflyEntity> PlayState flyAnimController(final AnimationState<E> event) {
        E entity = event.getAnimatable();
        if (entity.isFlying())
            return event.setAndContinue(FLY_ANIM);
        else {
            return event.setAndContinue(IDLE_ANIM);
        }
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }
    @Override
    protected PathNavigation createNavigation(Level level) {
        FlyingPathNavigation navigation = new FlyingPathNavigation(this, level);
        navigation.setCanOpenDoors(false);
        navigation.setCanFloat(true);
        navigation.setCanPassDoors(false);
        return navigation;
    }
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new ButterflyRandomFlyingGoal(this, 1.0));
        this.goalSelector.addGoal(2, new ButterflyLandOnBlockGoal(this));
    }
    @Override
    public boolean causeFallDamage(float fallDistance, float damageMultiplier, DamageSource source) {
        return false;
    }
    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        double maxDistance = 64.0D;
        return distance < maxDistance * maxDistance;
    }
    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }
    @Override
    public boolean isFlying() {
        return true;
    }
    public void setVariant(ButterflyVariant variant) {
        this.entityData.set(VARIANT, variant.getId());
    }

    public ButterflyVariant getVariant() {
        return ButterflyVariant.byId(this.entityData.get(VARIANT));
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getVariant().getId());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("Variant")) {
            this.setVariant(ButterflyVariant.byId(tag.getInt("Variant")));
        }
    }
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
        ButterflyVariant randomVariant = ButterflyVariant.values()[this.random.nextInt(ButterflyVariant.values().length)];
        this.setVariant(randomVariant);

        return super.finalizeSpawn(level, difficulty, reason, spawnData, dataTag);
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
    }
}
