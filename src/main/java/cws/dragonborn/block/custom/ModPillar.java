package cws.dragonborn.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;

public class ModPillar extends HorizontalDirectionalBlock {
    public static final BooleanProperty HINGE = BooleanProperty.create("hinge");
    public static final BooleanProperty HIGHER = BooleanProperty.create("higher");
    public static final EnumProperty<HingeType> TYPE = EnumProperty.create("type", HingeType.class);



    public ModPillar(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HINGE, false)
                .setValue(HIGHER, false)
                .setValue(TYPE, HingeType.NONE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HINGE, HIGHER, TYPE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = context.getHorizontalDirection().getOpposite();
        boolean hinge = context.getClickLocation().x - context.getClickedPos().getX() > 0.5;
        return this.defaultBlockState().setValue(FACING, facing).setValue(HINGE, hinge);
    }
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (!world.isClientSide && heldItem.is(Items.STICK)) {
            player.sendSystemMessage(Component.literal("higher work"));
            if (player.isShiftKeyDown()) {
                player.sendSystemMessage(Component.literal("Tall work"));
                HingeType currentType = state.getValue(TYPE);
                HingeType newType;

                switch (currentType) {
                    case NONE -> newType = HingeType.DOWN;
                    case DOWN -> newType = HingeType.TOP;
                    case TOP -> newType = HingeType.NONE;
                    default -> newType = HingeType.NONE;
                }

                world.setBlock(pos, state.setValue(TYPE, newType), 3);
                return InteractionResult.SUCCESS;
            } else {

                boolean newState = !state.getValue(HIGHER);
                world.setBlock(pos, state.setValue(HIGHER, newState), 3);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    public enum HingeType implements StringRepresentable {
        NONE("none"),
        DOWN("down"),
        TOP("top");

        private final String name;

        HingeType(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }


}
