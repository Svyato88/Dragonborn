package cws.dragonborn.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import javax.annotation.Nullable;

public class ModLogs extends RotatedPillarBlock {
    public static final BooleanProperty MOSSY = BooleanProperty.create("mossy");
    public ModLogs(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(MOSSY, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(MOSSY,AXIS);
    }
// обробка пкм сокирою
    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (toolAction == ToolActions.AXE_STRIP) {
            ResourceLocation currentId = BuiltInRegistries.BLOCK.getKey(state.getBlock());

            if (currentId != null) {
                ResourceLocation strippedId = new ResourceLocation(
                        currentId.getNamespace(),
                        "stripped_" + currentId.getPath()
                );

                Block strippedBlock = BuiltInRegistries.BLOCK.get(strippedId);
                if (strippedBlock != Blocks.AIR) {
                    return strippedBlock.defaultBlockState()
                            .setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
                }
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
//обробка пкм кістяною мукою
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (!world.isClientSide && heldItem.is(Items.BONE_MEAL)) {
            boolean newState = !state.getValue(MOSSY);
            world.setBlock(pos, state.setValue(MOSSY, newState), 3);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }


}
