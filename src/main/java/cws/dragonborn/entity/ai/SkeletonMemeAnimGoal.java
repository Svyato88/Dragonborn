package cws.dragonborn.entity.ai;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.entity.custom.SkeletonEntity;
import cws.dragonborn.sound.ModSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

public class SkeletonMemeAnimGoal extends Goal {

    private final SkeletonEntity mob;

    public SkeletonMemeAnimGoal(SkeletonEntity mob) {
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        //Dragonborn.LOGGER.info("Trying to do goal");
        LivingEntity target = mob.getTarget();
        if (target == null) return false;
        //Dragonborn.LOGGER.info("Target not null");

        if (mob.abilityCooldown > 0) return false;
        //Dragonborn.LOGGER.info("Cooldown is 0");

        if ((mob.distanceTo(target) < 7.0F) || (mob.distanceTo(target) > 10.0F)) return false;
        //Dragonborn.LOGGER.info("Distance is {}", mob.distanceTo(target));

        return isLookingAtMe(target);
    }

    @Override
    public void start() {
        mob.isUsingAbility = true;
        mob.abilityTicks = 120;

        mob.triggerAnim("skeleton", "meme");
        //Dragonborn.LOGGER.info("==Trying to play ANIM==");

        mob.level().playSound(null, mob.blockPosition(), ModSounds.SKELETON_YELL.get(),
                SoundSource.HOSTILE, 1.0F, 1.0F
        );

        mob.restartCooldown();
    }

    private boolean isLookingAtMe(LivingEntity target) {
        Vec3 lookVec = target.getViewVector(1.0F).normalize();
        Vec3 dirToMob = mob.position().subtract(target.position()).normalize();

        double dot = lookVec.dot(dirToMob);

        return dot > 0.95;
    }
}