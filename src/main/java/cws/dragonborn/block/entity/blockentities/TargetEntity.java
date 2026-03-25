package cws.dragonborn.block.entity.blockentities;

import cws.dragonborn.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TargetEntity extends BlockEntity {
    public TargetEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TARGET_ENTITY.get(), pos, state);
        System.out.println("[DEBUG] TargetBlockEntity created at " + pos);
    }

}
