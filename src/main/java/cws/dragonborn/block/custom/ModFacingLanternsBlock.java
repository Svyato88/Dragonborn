package cws.dragonborn.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class ModFacingLanternsBlock extends HorizontalDirectionalBlock {
    public static final BooleanProperty ON = BooleanProperty.create("on");

    public ModFacingLanternsBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(ON, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ON, FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (!level.isClientSide) {
            if (heldItem.is(Items.FLINT_AND_STEEL)) {
                boolean newState = !state.getValue(ON);
                level.setBlock(pos, state.setValue(ON, newState), 3);
                return InteractionResult.SUCCESS;
            } else if ((heldItem.is(Items.AIR)) || (heldItem.getItem() instanceof ShovelItem)) {
                boolean newState = state.getValue(ON);
                level.setBlock(pos, state.setValue(ON, newState), 3);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
}
