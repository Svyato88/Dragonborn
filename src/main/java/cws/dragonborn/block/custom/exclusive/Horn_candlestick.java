package cws.dragonborn.block.custom.exclusive;

import cws.dragonborn.block.entity.blockentities.HornCandlestickBlockEntity;
import cws.dragonborn.block.entity.blockentities.SkyrimBannerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class Horn_candlestick extends BaseEntityBlock {
    public static final BooleanProperty ON = BooleanProperty.create("on");

    public Horn_candlestick(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(ON, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ON);
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

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState state) {
        return new HornCandlestickBlockEntity(blockPos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

}


