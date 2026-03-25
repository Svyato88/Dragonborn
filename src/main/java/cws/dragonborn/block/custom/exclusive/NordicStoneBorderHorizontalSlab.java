package cws.dragonborn.block.custom.exclusive;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class NordicStoneBorderHorizontalSlab extends Block {
    public static final BooleanProperty TOP = BooleanProperty.create("top");
    public static final BooleanProperty DOWN = BooleanProperty.create("down");
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public NordicStoneBorderHorizontalSlab(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(TOP, false)
                .setValue(DOWN, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TOP, DOWN, FACING);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        return this.defaultBlockState()
                .setValue(TOP, canConnectTo(level.getBlockState(pos.north())))
                .setValue(DOWN, canConnectTo(level.getBlockState(pos.east())))
                .setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction dir, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (dir == Direction.UP) return state.setValue(TOP, canConnectTo(neighborState));
        if (dir == Direction.DOWN) return state.setValue(DOWN, canConnectTo(neighborState));
        return state;
    }

    private boolean canConnectTo(BlockState neighborState) {
        return neighborState.getBlock() instanceof NordicStoneBorderHorizontalSlab;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
}

