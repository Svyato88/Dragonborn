package cws.dragonborn.block.custom.exclusive;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;


public class NordicBookcase extends HorizontalDirectionalBlock {
    public static final BooleanProperty TOP = BooleanProperty.create("top");

    public NordicBookcase(Properties p_54120_) {
        super(p_54120_);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(TOP, true));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING,TOP);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        boolean isTop = true;

        BlockState stateAbove = level.getBlockState(pos.above());
        if (stateAbove.is(this)) {
            isTop = false;
        }

        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(TOP, isTop);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction dir, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        BlockState stateAbove = level.getBlockState(pos.above());
        if (stateAbove.is(this)) {
            return state.setValue(TOP, false);
        }
        else {
            return state.setValue(TOP, true);
        }
    }

        @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (!world.isClientSide && heldItem.is(Items.STICK)) {
            boolean newState = !state.getValue(TOP);
            world.setBlock(pos, state.setValue(TOP, newState), 3);
            return InteractionResult.SUCCESS;

        }
        return InteractionResult.PASS;
    }
}
