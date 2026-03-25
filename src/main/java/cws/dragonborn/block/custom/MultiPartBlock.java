package cws.dragonborn.block.custom;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.*;

public class MultiPartBlock extends HorizontalDirectionalBlock {

    public static final EnumProperty<ShapeType> SHAPE = EnumProperty.create("shape", ShapeType.class);

    public static final IntegerProperty OFFSET_X = IntegerProperty.create("ox", 0, 3);
    public static final IntegerProperty OFFSET_Y = IntegerProperty.create("oy", 0, 4);
    public static final IntegerProperty OFFSET_Z = IntegerProperty.create("oz", 0, 3);

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public MultiPartBlock(Properties props) {
        super(props);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(SHAPE, ShapeType.SHAPE1)
                .setValue(OFFSET_X, 2)
                .setValue(OFFSET_Y, 4)
                .setValue(OFFSET_Z, 2)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SHAPE, OFFSET_X, OFFSET_Y, OFFSET_Z, FACING);
    }

    public enum ShapeType implements StringRepresentable {
        SHAPE1("shape1"),
        SHAPE2("shape2"),
        SHAPE3("shape3"),
        SHAPE4("shape4"),
        SHAPE5("shape5");
        private final String name;
        ShapeType(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }

    public static Vec3i rotateOffset(Vec3i v, Direction facing) {
        return switch (facing) {
            case NORTH -> v;
            case SOUTH -> new Vec3i(-v.getX(), v.getY(), -v.getZ());
            case WEST  -> new Vec3i(v.getZ(), v.getY(), -v.getX());
            case EAST  -> new Vec3i(-v.getZ(), v.getY(), v.getX());
            default -> v;
        };
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean moved) {
        int radius = 10;

        BlockPos corePos = findTaggedBlock(level, pos, radius);

        if (corePos != null) {
            Dragonborn.LOGGER.info("CorePos Brake {}", corePos);
            BlockState coreState = level.getBlockState(corePos);
            coreState.onRemove(level,corePos,Blocks.AIR.defaultBlockState(),false);
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        }
    }

    private static final VoxelShape SHAPE_1 = Block.box(0, 0, 0, 16, 16, 16);
    private static final VoxelShape SHAPE_2 = Shapes.or(
            Block.box(0, 0, 0, 16, 5, 16),
            Block.box(0, 5, 0, 2, 16, 12),
            Block.box(14, 5, 0, 16, 16, 12));
    private static final VoxelShape SHAPE_3 = Block.box(0, 0, 0, 16, 16, 16);
    private static final VoxelShape SHAPE_4 = Block.box(0, 0, 0, 16, 16, 16);
    private static final VoxelShape SHAPE_5 = Block.box(0, 0, 0, 16, 16, 16);


    private static final Map<ShapeType, VoxelShape> SHAPES = Map.of(
            ShapeType.SHAPE1, SHAPE_1,
            ShapeType.SHAPE2, SHAPE_2,
            ShapeType.SHAPE3, SHAPE_3,
            ShapeType.SHAPE4, SHAPE_4,
            ShapeType.SHAPE5, SHAPE_5
    );

    private static VoxelShape rotateShape(VoxelShape shape, Direction direction) {
        VoxelShape[] buffer = new VoxelShape[]{shape};

        int rotations = switch (direction) {
            case SOUTH -> 0;
            case WEST -> 1;
            case EAST -> 3;
            default -> 2;
        };

        VoxelShape current = shape;
        for (int i = 0; i < rotations; i++) {
            VoxelShape rotated = Shapes.empty();
            for (AABB bb : current.toAabbs()) {
                rotated = Shapes.or(rotated, Shapes.create(new AABB(
                        1 - bb.maxZ, bb.minY, bb.minX,
                        1 - bb.minZ, bb.maxY, bb.maxX
                )));
            }
            current = rotated;
        }
        return current;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        ShapeType type = state.getValue(SHAPE);
        Direction dir = state.getValue(FACING);

        VoxelShape base = SHAPES.get(type);
        return rotateShape(base, dir);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        int radius = 10;

        BlockPos corePos = findTaggedBlock(level, pos, radius);
        BlockState coreState = level.getBlockState(corePos);

        if (corePos != null) {
            if (level.isClientSide) return InteractionResult.SUCCESS;
            Dragonborn.LOGGER.info("CorePos  {}", corePos);
            return coreState.use(level, player, hand, hit.withPosition(corePos));
        } else {
            level.setBlock(pos, Blocks.AIR.getStateDefinition().any(), 3);
        }
        return InteractionResult.CONSUME;
    }

    private BlockPos findTaggedBlock(Level level, BlockPos center, int radius) {
        for (BlockPos pos : BlockPos.betweenClosed(
                center.offset(-radius, -radius, -radius),
                center.offset(radius, radius, radius))) {

            BlockState state = level.getBlockState(pos);

            if (state.is(ModTags.Blocks.MULTIBLOCK_CORE)) {
                if (isConnected(level, center, pos)) {
                    return pos.immutable();
                }
            }
        }
        return null;
    }
    private boolean isConnected(Level level, BlockPos start, BlockPos target) {
        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            BlockPos current = queue.poll();
            if (current.equals(target)) {
                return true;
            }
            for (Direction dir : Direction.values()) {
                BlockPos next = current.relative(dir);

                if (visited.contains(next)) continue;

                BlockState nextState = level.getBlockState(next);
                // Перевіряємо що це такий самий блок як стартовий
                if (nextState.is(this)) {
                    visited.add(next);
                    queue.add(next);
                }
                // Дозволяємо дійти до target навіть якщо він не такий самий
                if (next.equals(target)) {
                    return true;
                }
            }
        }
        return false;
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
    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.BLOCK;
    }
}