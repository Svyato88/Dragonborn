package cws.dragonborn.block.custom.exclusive;

import cws.dragonborn.block.custom.ModPlatform;
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


public class LimestoneWallBeam extends HorizontalDirectionalBlock {
    public static final EnumProperty<LimestoneWallBeam.HingeType> TYPE = EnumProperty.create("type", LimestoneWallBeam.HingeType.class);
    
    public LimestoneWallBeam(Properties p_54120_) {
        super(p_54120_);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(TYPE, HingeType.DEFAULT));
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING,TYPE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public enum HingeType implements StringRepresentable {
        DEFAULT("default"),
        INCLINED_HALF("inclined_half"),
        INCLINED("inclined"),
        INCLINED_HALF_HORIZONTAL("inclined_half_horizontal"),
        INCLINED_HORIZONTAL("inclined_horizontal");

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
            LimestoneWallBeam.HingeType currentType = state.getValue(TYPE);
            LimestoneWallBeam.HingeType newType;

            switch (currentType) {
                case DEFAULT -> newType = LimestoneWallBeam.HingeType.INCLINED_HALF;
                case INCLINED_HALF -> newType = LimestoneWallBeam.HingeType.INCLINED;
                case INCLINED -> newType = LimestoneWallBeam.HingeType.INCLINED_HALF_HORIZONTAL;
                case INCLINED_HALF_HORIZONTAL -> newType = LimestoneWallBeam.HingeType.INCLINED_HORIZONTAL;
                case INCLINED_HORIZONTAL -> newType = LimestoneWallBeam.HingeType.DEFAULT;
                default -> newType = LimestoneWallBeam.HingeType.DEFAULT;
            }
            world.setBlock(pos, state.setValue(TYPE, newType), 3);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
