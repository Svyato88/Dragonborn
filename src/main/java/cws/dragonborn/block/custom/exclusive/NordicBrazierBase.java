package cws.dragonborn.block.custom.exclusive;

import cws.dragonborn.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class NordicBrazierBase extends Block{
    public NordicBrazierBase(Properties p_54120_) {
        super(p_54120_);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(hand);
        Block heldBlock = Block.byItem(heldItem.getItem());

        if (!level.isClientSide) {
            if (heldItem.is(ItemTags.COALS)) {
                level.setBlock(pos, ModBlocks.STONE.get().defaultBlockState(),3);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
}
