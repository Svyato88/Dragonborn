package cws.dragonborn.block.custom.exclusive;

import cws.dragonborn.block.custom.ModHorizontalSlab;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class WoodenBeamHorizontal extends HorizontalDirectionalBlock {
    public static final BooleanProperty FIRST = BooleanProperty.create("first");
    public static final BooleanProperty LATEST = BooleanProperty.create("latest");

    public WoodenBeamHorizontal(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FIRST, false)
                .setValue(LATEST, false)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FIRST, LATEST, FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        BlockState state = this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite());

        return updateConnections(level, pos, state
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
        );
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return updateConnections(level, pos, state);
    }

    private BlockState updateConnections(LevelAccessor level, BlockPos pos, BlockState state) {
        Direction facing = state.getValue(FACING);

        Direction left = facing.getCounterClockWise();
        Direction right = facing.getClockWise();

        boolean first = canConnect((Level) level, pos.relative(left), facing);
        boolean latest = canConnect((Level) level, pos.relative(right), facing);

        return state
                .setValue(FIRST, first)
                .setValue(LATEST, latest);
    }

    private boolean canConnect(Level level, BlockPos pos, Direction facing) {
        BlockState neighbor = level.getBlockState(pos);

        if (!(neighbor.getBlock() instanceof WoodenBeamHorizontal)) return false;

        Direction neighborFacing = neighbor.getValue(FACING);

        return neighborFacing == facing
                || neighborFacing == facing.getOpposite();
    }
}