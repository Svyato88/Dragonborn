package cws.dragonborn.block.custom.exclusive;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;

public class ModBorder extends HorizontalDirectionalBlock {
    public static final EnumProperty<StairsShape> SHAPE = BlockStateProperties.STAIRS_SHAPE;

    public ModBorder(Properties p_54120_) {
        super(p_54120_);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(SHAPE, StairsShape.STRAIGHT));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING,SHAPE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction facing = context.getHorizontalDirection().getOpposite();

        BlockState state = this.defaultBlockState()
                .setValue(FACING, facing); // або інше за замовчуванням

        return state.setValue(SHAPE, getShapeProperty(state, level, pos));
    }






    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override //оновлення сусідніх блоків при встановлення
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        System.out.println("Оновлення блоку на позиції: " + pos + ", напрямок: " + direction);
        return state.setValue(SHAPE, getShapeProperty(state, level, pos));
    }


    private static StairsShape getShapeProperty(BlockState state, BlockGetter level, BlockPos pos) {
        Direction facing = state.getValue(FACING);

        BlockState front = level.getBlockState(pos.relative(facing));
        BlockState back = level.getBlockState(pos.relative(facing.getOpposite()));

        boolean isFrontSame = front.getBlock() instanceof ModBorder &&
                front.getValue(FACING) != facing && front.getValue(FACING).getAxis() != facing.getAxis();

        boolean isBackSame = back.getBlock() instanceof ModBorder &&
                back.getValue(FACING) != facing && back.getValue(FACING).getAxis() != facing.getAxis();

        if (isFrontSame) {
            Direction frontDir = front.getValue(FACING);
            return frontDir == facing.getCounterClockWise() ? StairsShape.INNER_LEFT : StairsShape.INNER_RIGHT;
        }

        if (isBackSame) {
            Direction backDir = back.getValue(FACING);
            return backDir == facing.getCounterClockWise() ? StairsShape.OUTER_LEFT : StairsShape.OUTER_RIGHT;
        }

        return StairsShape.STRAIGHT;
    }
}
