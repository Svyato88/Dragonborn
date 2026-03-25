package cws.dragonborn.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.awt.*;

public class ModGrassBlockWithVariants extends Block {
    public ModGrassBlockWithVariants(Properties p_49795_) {
        super(p_49795_);
    }

    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 9);

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(VARIANT);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState()
                .setValue(VARIANT, ctx.getLevel().getRandom().nextInt(10));
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(VARIANT) == 0;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level,
                           BlockPos pos, RandomSource random) {

        if (state.getValue(VARIANT) == 0) {
            int v = 1 + random.nextInt(8);
            level.setBlock(pos, state.setValue(VARIANT, v), 2);
        }
    }
}
