package cws.dragonborn.entity.custom;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.entity.ai.SkeletonMemeAnimGoal;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SkeletonEntity extends Monster implements GeoEntity, NeutralMob {
    protected static final RawAnimation IDLE_ANIM = RawAnimation.begin().thenLoop("idle");
    protected static final RawAnimation WALK_ANIM = RawAnimation.begin().thenLoop("walk");
    protected static final RawAnimation RUN_ANIM = RawAnimation.begin().thenLoop("run");
    protected static final RawAnimation MEME = RawAnimation.begin().thenPlayXTimes("meme", 1);

    public int abilityCooldown = 0;
    public boolean isUsingAbility = false;
    public int abilityTicks = 0;

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public final Map<String, Vec3> locatorPositions = new HashMap<>();

    public SkeletonEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(6, new SkeletonMemeAnimGoal(this));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, (double)1.0F, true));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, (double)1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[0]));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, true));
}

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2D)
                .add(Attributes.ATTACK_DAMAGE, 4.0D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    @Override
    public void tick() {
        super.tick();
        if (abilityCooldown > 0)
            abilityCooldown--;

        if (abilityTicks > 0) {
            abilityTicks--;
            if (abilityTicks == 0) {
                isUsingAbility = false;
            }
        }
    }

    @Override
    public void travel(Vec3 vec) {
        if (isUsingAbility) {
            super.travel(Vec3.ZERO);
            return;
        }
        super.travel(vec);
    }

    public void restartCooldown() {
        abilityCooldown = 500;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

        AnimationController<SkeletonEntity> controller =
                new AnimationController<>(this, "skeleton", 5, this::skeletonAnimController)
                        .triggerableAnim("meme", MEME);
/*
        controller.setParticleKeyframeHandler(event -> {
            Dragonborn.LOGGER.info("=== PARTICLE KEYFRAME TRIGGERED ===");

            SkeletonEntity mob = event.getAnimatable();
            Dragonborn.LOGGER.info("isClientSide: {}", mob.level().isClientSide);

            if (!mob.level().isClientSide) return;

            String effectName = event.getKeyframeData().getEffect();
            String locator = event.getKeyframeData().getLocator();
            Dragonborn.LOGGER.info("effectName: {}", effectName);
            Dragonborn.LOGGER.info("locator: {}", locator);
            Dragonborn.LOGGER.info("locatorPositions keys: {}", mob.locatorPositions.keySet());

            spawnParticleAtLocator(mob, effectName, locator);
        });
 */

        controllers.add(controller);
    }
/*
    private void spawnParticleAtLocator(SkeletonEntity mob, String effectName, String locator) {
        Vec3 pos = mob.locatorPositions.get(locator);
        Dragonborn.LOGGER.info("Looking for locator: {}", locator);
        Dragonborn.LOGGER.info("Available locators: {}", mob.locatorPositions.keySet());

        if (pos == null) {
            Dragonborn.LOGGER.info("ERROR: locator not found!");
            return;
        }
        Dragonborn.LOGGER.info("Position found: {}", pos);

        ResourceLocation particleId = new ResourceLocation(effectName);
        ParticleType<?> type = ForgeRegistries.PARTICLE_TYPES.getValue(particleId);
        Dragonborn.LOGGER.info("ParticleType for {} {}", effectName, type);

        if (type == null) {
            Dragonborn.LOGGER.info("ERROR: particle type not found!");
            return;
        }

        Minecraft.getInstance().level.addParticle(
                (ParticleOptions) type, pos.x, pos.y, pos.z, 0, 0, 0
        );
        Dragonborn.LOGGER.info("Particle spawned at: {}", pos);
    }
 */

    protected <E extends SkeletonEntity> PlayState skeletonAnimController(final AnimationState<E> event) {
        E entity = event.getAnimatable();
        /*
            if (entity.isUsingAbility) {
                Dragonborn.LOGGER.info("ANIM IS PLAYING FROM CONTROLLER");
                return event.setAndContinue(MEME);

         */
        if (event.getController().isPlayingTriggeredAnimation()) {
            return PlayState.CONTINUE;
        }

            if (getDeltaMovement().horizontalDistance() >= 0.02F) {
                return event.setAndContinue(RUN_ANIM);
            } else if (getDeltaMovement().horizontalDistance() >= 0.3F){
                return event.setAndContinue(WALK_ANIM);
            }
            return event.setAndContinue(IDLE_ANIM);
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return 0;
    }

    @Override
    public void setRemainingPersistentAngerTime(int i) {
    }

    @Override
    public @Nullable UUID getPersistentAngerTarget() {
        return null;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID uuid) {

    }

    @Override
    public void startPersistentAngerTimer() {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_33579_) {
        return SoundEvents.SKELETON_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SKELETON_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.SKELETON_STEP;
    }
}
