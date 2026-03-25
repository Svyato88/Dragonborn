package cws.dragonborn.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.phys.BlockHitResult;

public class ModRoofBorder extends HorizontalDirectionalBlock {
    public static final BooleanProperty HINGE = BooleanProperty.create("hinge");
    public static final BooleanProperty LATEST = BooleanProperty.create("latest");


    public ModRoofBorder(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HINGE, false)
                .setValue(LATEST, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HINGE, LATEST);
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
            boolean newState = !state.getValue(LATEST);
            world.setBlock(pos, state.setValue(LATEST, newState), 3);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }



}
