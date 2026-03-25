package cws.dragonborn.entity.ai;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class ButterflyRandomFlyingGoal extends Goal {
    private final PathfinderMob mob;
    private final double speed;

    public ButterflyRandomFlyingGoal(PathfinderMob mob, double speed) {
        this.mob = mob;
        this.speed = speed;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return mob.getRandom().nextInt(10) == 0;
    }

    @Override
    public void start() {
        Vec3 pos = getRandomLocation();
        if (pos != null) {
            mob.getNavigation().moveTo(pos.x, pos.y, pos.z, speed);
        }
    }

    private Vec3 getRandomLocation() {
        RandomSource random = mob.getRandom();
        double x = mob.getX() + (random.nextDouble() - 0.5) * 8;
        double y = mob.getY() + (random.nextDouble() - 0.5) * 4;
        double z = mob.getZ() + (random.nextDouble() - 0.5) * 8;
        return new Vec3(x, y, z);
    }
}