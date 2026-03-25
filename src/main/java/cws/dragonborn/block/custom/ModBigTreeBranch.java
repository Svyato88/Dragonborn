package cws.dragonborn.block.custom;

import cws.dragonborn.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.Set;

public class ModBigTreeBranch extends Block {
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    public static final BooleanProperty TOP = BooleanProperty.create("top");
    public static final BooleanProperty BOTTOM = BooleanProperty.create("bottom");

    public ModBigTreeBranch(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, false)
                .setValue(SOUTH, false)
                .setValue(EAST, false)
                .setValue(WEST, false)
                .setValue(TOP, false)
                .setValue(BOTTOM, false)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, SOUTH, EAST, WEST, TOP, BOTTOM);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        return updateConnections(level, pos, this.defaultBlockState());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return updateConnections(level, pos, state);
    }

    private BlockState updateConnections(LevelAccessor level, BlockPos pos, BlockState state) {
        BlockState north = level.getBlockState(pos.north());
        BlockState south = level.getBlockState(pos.south());
        BlockState east = level.getBlockState(pos.east());
        BlockState west = level.getBlockState(pos.west());
        BlockState up = level.getBlockState(pos.above());
        BlockState down = level.getBlockState(pos.below());

        return state
                .setValue(NORTH, canConnectTo(north))
                .setValue(SOUTH, canConnectTo(south))
                .setValue(EAST, canConnectTo(east))
                .setValue(WEST, canConnectTo(west))
                .setValue(TOP, canConnectTo(up))
                .setValue(BOTTOM, canConnectTo(down));
    }

    private static final Set<Block> CONNECTABLE = Set.of(
            ModBlocks.DRY_LOG_MINI.get(),
            ModBlocks.DRY_LOG_SMALL.get(),
            Blocks.GRASS_BLOCK
    );

    private boolean canConnectTo(BlockState state) {
        return state.is(this) || state.is((Block) CONNECTABLE);
    }
}