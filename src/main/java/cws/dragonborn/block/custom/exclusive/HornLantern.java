package cws.dragonborn.block.custom.exclusive;

import cws.dragonborn.block.custom.ModFacingLanternsBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class HornLantern extends ModFacingLanternsBlock {
    public static final BooleanProperty VERTICAL = BooleanProperty.create("vertical");

    public HornLantern(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ON, FACING, VERTICAL);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction face = context.getClickedFace();

        boolean onWall = face != Direction.UP;

        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(VERTICAL, onWall);
    }
}
