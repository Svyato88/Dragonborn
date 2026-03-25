package cws.dragonborn.block.custom.exclusive;

import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.block.custom.MultiPartBlock;
import cws.dragonborn.block.entity.blockentities.SkyrimBannerBlockEntity;
import cws.dragonborn.block.entity.blockentities.SmithingSmelterBlockEntity;
import cws.dragonborn.multiblock.MultiblockChecker;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SmithingSmelter extends BaseEntityBlock {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public SmithingSmelter(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState state) {
        return new SmithingSmelterBlockEntity(blockPos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.block();
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (level.isClientSide) return;
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        BlockState coreState = level.getBlockState(pos);

        for (int x = -1; x <= 1; x++) {
            for (int y = 0; y <= 2; y++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos setPos = pos.offset(x, y, z);
                    BlockState setState = level.getBlockState(setPos);
                    if (!(setState == coreState))
                    {
                        level.setBlock(setPos, ModBlocks.MULTIPART_BLOCK.get().defaultBlockState(),3);
                    }
                }
            }
        }
        Direction coreFacing = coreState.getValue(HorizontalDirectionalBlock.FACING);

        level.setBlock(pos.offset(MultiblockChecker.rotatePos(
                        new BlockPos(0, 0,-2),coreFacing))
                , ModBlocks.MULTIPART_BLOCK.get().defaultBlockState()
                        .setValue(MultiPartBlock.SHAPE, MultiPartBlock.ShapeType.SHAPE2)
                        .setValue(HorizontalDirectionalBlock.FACING,coreFacing),3);
    }
    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean moved) {
        BlockState removeState = ModBlocks.MULTIPART_BLOCK.get().defaultBlockState();

        for (int x = -1; x <= 1; x++) {
            for (int y = 0; y <= 2; y++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos setPos = pos.offset(x, y, z);
                    BlockState setState = level.getBlockState(setPos);
                    Direction coreFacing = state.getValue(HorizontalDirectionalBlock.FACING);
                    if (setState == removeState)
                    {
                        level.removeBlock(setPos, true);
                    }
                    level.removeBlock(pos.offset(MultiblockChecker.rotatePos(
                                    new BlockPos(0, 0,-2),coreFacing)), true);

                    level.removeBlock(pos, true);
                }
            }
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {

            for (Direction dir : Direction.values()) {
                BlockPos targetPos = pos.relative(dir);
                BlockState targetState = level.getBlockState(targetPos);
                // Перевіряємо що це НЕ повітря
                if (!targetState.isAir()) {
                    // Можеш додати додаткову перевірку
                    // наприклад тільки камінь
                    if (targetState.is(Blocks.STONE)) {
                        level.setBlock(targetPos, Blocks.AIR.defaultBlockState(), 3);
                    }}}}
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}