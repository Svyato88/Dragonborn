package cws.dragonborn.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;


public class ModPlatform extends HorizontalDirectionalBlock {
    public static final EnumProperty<ModPlatform.HingeType> TYPE = EnumProperty.create("type", ModPlatform.HingeType.class);

    public ModPlatform(Properties p_54120_) {
        super(p_54120_);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(TYPE, ModPlatform.HingeType.NONE));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPE);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    public enum HingeType implements StringRepresentable {
        NONE("none"),
        BACK("back"),
        FRONT("front"),
        TWO("two");

        private final String name;

        HingeType(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(hand);
        if (player.isShiftKeyDown()) {
            player.sendSystemMessage(Component.literal("Platform work"));
            ModPlatform.HingeType currentType = state.getValue(TYPE);
            ModPlatform.HingeType newType;

            switch (currentType) {
                case NONE -> newType = ModPlatform.HingeType.BACK;
                case BACK -> newType = ModPlatform.HingeType.FRONT;
                case FRONT -> newType = ModPlatform.HingeType.TWO;
                case TWO -> newType = ModPlatform.HingeType.NONE;
                default -> newType = ModPlatform.HingeType.NONE;
            }
            world.setBlock(pos, state.setValue(TYPE, newType), 3);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}