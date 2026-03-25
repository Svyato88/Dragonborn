package cws.dragonborn.block.custom.exclusive;

import cws.dragonborn.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.Set;

public class Pavement_border extends Block {
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty WEST = BooleanProperty.create("west");

    public Pavement_border(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        return this.defaultBlockState()
                .setValue(NORTH, canConnectTo(level.getBlockState(pos.north())))
                .setValue(EAST, canConnectTo(level.getBlockState(pos.east())))
                .setValue(SOUTH, canConnectTo(level.getBlockState(pos.south())))
                .setValue(WEST, canConnectTo(level.getBlockState(pos.west())));
    }

    @Override
    public BlockState updateShape(BlockState state, Direction dir, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (dir == Direction.NORTH) return state.setValue(NORTH, canConnectTo(neighborState));
        if (dir == Direction.EAST) return state.setValue(EAST, canConnectTo(neighborState));
        if (dir == Direction.SOUTH) return state.setValue(SOUTH, canConnectTo(neighborState));
        if (dir == Direction.WEST) return state.setValue(WEST, canConnectTo(neighborState));
        return state;
    }

    private boolean canConnectTo(BlockState neighborState) {
        return neighborState.getBlock() instanceof Pavement_border;
    }
}

