package cws.dragonborn.entity.ai;

import cws.dragonborn.entity.custom.ButterflyEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.state.BlockState;

import java.util.EnumSet;

public class ButterflyLandOnBlockGoal extends Goal {
    private final ButterflyEntity butterfly;
    private BlockPos targetPos;

    public ButterflyLandOnBlockGoal(ButterflyEntity butterfly) {
        this.butterfly = butterfly;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }
    @Override
    public boolean canUse() {
        if (butterfly.getRandom().nextInt(40) != 0) return false;

        BlockPos pos = butterfly.blockPosition().below();
        BlockState state = butterfly.level().getBlockState(pos);

        return state.is(BlockTags.FLOWERS);
    }
    @Override
    public void start() {
        targetPos = butterfly.blockPosition().below();
        butterfly.getNavigation().moveTo(
                targetPos.getX() + 0.5,
                targetPos.getY() + 1,
                targetPos.getZ() + 0.5,
                1.0
        );
    }
    @Override
    public boolean canContinueToUse() {
        return false;
    }
}