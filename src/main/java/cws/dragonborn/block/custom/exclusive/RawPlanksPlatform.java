package cws.dragonborn.block.custom.exclusive;

import cws.dragonborn.block.RoofBlocksList;
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
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;


public class RawPlanksPlatform extends HorizontalDirectionalBlock {
    public static final EnumProperty<RawPlanksPlatform.HingeType> TYPE = EnumProperty.create("type", RawPlanksPlatform.HingeType.class);
    public static final EnumProperty<RoofBlocksList> BLOCK = EnumProperty.create("block", RoofBlocksList.class);

    public RawPlanksPlatform(Properties p_54120_) {
        super(p_54120_);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(BLOCK, RoofBlocksList.AIR)
                .setValue(TYPE, HingeType.DEFAULT));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPE, BLOCK);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    public enum HingeType implements StringRepresentable {
        DEFAULT("default"),
        BRAKED("braked"),
        END("end");

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
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(hand);
        Block heldBlock = Block.byItem(heldItem.getItem());

        if (!level.isClientSide) {
            if (heldItem.is(Items.STICK)) {
                RawPlanksPlatform.HingeType currentType = state.getValue(TYPE);
                RawPlanksPlatform.HingeType newType;

                switch (currentType) {
                    case DEFAULT -> newType = RawPlanksPlatform.HingeType.BRAKED;
                    case BRAKED -> newType = RawPlanksPlatform.HingeType.END;
                    case END -> newType = RawPlanksPlatform.HingeType.DEFAULT;
                    default -> newType = RawPlanksPlatform.HingeType.DEFAULT;
                }
                level.setBlock(pos, state.setValue(TYPE, newType), 3);
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
}