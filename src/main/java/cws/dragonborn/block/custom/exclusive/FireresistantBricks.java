package cws.dragonborn.block.custom.exclusive;

import cws.dragonborn.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class FireresistantBricks extends Block {

    public static final IntegerProperty BRICKS = IntegerProperty.create("bricks", 1, 38);

    public FireresistantBricks(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BRICKS, 1));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BRICKS);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }
        ItemStack stack = player.getItemInHand(hand);
        int current = state.getValue(BRICKS);
        if (current < 38){
            if (stack.is(Items.CLAY_BALL) && (current == 9 || current == 18 || current == 27 || current == 36 || current == 37)) {
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
                level.setBlock(pos, state.setValue(BRICKS, current + 1), 3);
                return InteractionResult.CONSUME;
            } else if (stack.is(Items.BRICK) && !(current == 9 || current == 18 || current == 27 || current == 36)) {
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
                level.setBlock(pos, state.setValue(BRICKS, current + 1), 3);
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (isFireNearby(level,pos)) {
            level.setBlock(pos, ModBlocks.SMITHING_SMELTER_WALL.get().defaultBlockState(), 3);
        }
    }

    public static boolean isFireNearby(Level level, BlockPos center) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        int radius = 2;

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    mutablePos.set(
                            center.getX() + x,
                            center.getY() + y,
                            center.getZ() + z
                    );
                    if (level.getBlockState(mutablePos).is(Blocks.FIRE)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}