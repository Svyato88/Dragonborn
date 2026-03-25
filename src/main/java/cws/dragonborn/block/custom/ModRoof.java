package cws.dragonborn.block.custom;

import cws.dragonborn.block.RoofBlocksList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.phys.BlockHitResult;

public class ModRoof extends HorizontalDirectionalBlock {
    public static final EnumProperty<StairsShape> SHAPE = BlockStateProperties.STAIRS_SHAPE;
    public static final BooleanProperty LATEST = BooleanProperty.create("latest");
    public static final EnumProperty<RoofBlocksList> BLOCK = EnumProperty.create("block", RoofBlocksList.class);

    public ModRoof(Properties p_54120_) {
        super(p_54120_);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(LATEST, false)
                .setValue(BLOCK, RoofBlocksList.AIR)
                .setValue(SHAPE, StairsShape.STRAIGHT));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING,LATEST,BLOCK,SHAPE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction facing = context.getHorizontalDirection().getOpposite();

        BlockState state = this.defaultBlockState()
                .setValue(FACING, facing)
                .setValue(LATEST, false);
        return state.setValue(SHAPE, getShapeProperty(state, level, pos));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(hand);
        Block heldBlock = Block.byItem(heldItem.getItem());

        if (!level.isClientSide) {
            if (heldItem.is(Items.STICK)) {
                boolean newState = !state.getValue(LATEST);
                level.setBlock(pos, state.setValue(LATEST, newState), 3);
                return InteractionResult.SUCCESS;
            }

            RoofBlocksList type = RoofBlocksList.fromBlock(heldBlock);
            if (type != null && state.getValue(BLOCK) != type) {
                level.setBlock(pos, state.setValue(BLOCK, type), 3);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return state.setValue(SHAPE, getShapeProperty(state, level, pos));
    }

    private static StairsShape getShapeProperty(BlockState state, BlockGetter level, BlockPos pos) {
        Direction facing = state.getValue(FACING);

        BlockState front = level.getBlockState(pos.relative(facing));
        BlockState back = level.getBlockState(pos.relative(facing.getOpposite()));

        boolean isFrontSame = front.getBlock() instanceof ModRoof &&
                front.getValue(FACING) != facing && front.getValue(FACING).getAxis() != facing.getAxis();

        boolean isBackSame = back.getBlock() instanceof ModRoof &&
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
