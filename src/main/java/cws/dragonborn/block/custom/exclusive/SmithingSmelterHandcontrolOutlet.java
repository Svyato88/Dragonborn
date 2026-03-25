package cws.dragonborn.block.custom.exclusive;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.multiblock.MultiblockChecker;
import cws.dragonborn.multiblock.MultiblockSchema;
import cws.dragonborn.multiblock.SchemaEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.Tags;

import java.util.List;

public class SmithingSmelterHandcontrolOutlet extends HorizontalDirectionalBlock {
    public SmithingSmelterHandcontrolOutlet(Properties p_54120_) {
        super(p_54120_);
    }

    private static final List<ResourceLocation> SCHEMAS = List.of(
            new ResourceLocation(Dragonborn.MOD_ID, "smithing_smelter")
    );

    private static final BlockPos OFFSET = new BlockPos(-1, 0, 1);

    private static final BlockPos CORE_OFFSET = new BlockPos(0, 0, 2);

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide()) return InteractionResult.SUCCESS;

        Direction facing = state.getValue(HorizontalDirectionalBlock.FACING);

        MultiblockSchema matched = MultiblockChecker.checkMultiblock((ServerLevel) level, pos, facing, OFFSET, SCHEMAS);

        if (matched != null) {
            player.sendSystemMessage(Component.literal("✅ Мультиблок зібрано!"));
            Dragonborn.LOGGER.warn("Multiblock placed in {} {} {} {}", pos, facing, OFFSET, SCHEMAS);
        } else {
            player.sendSystemMessage(Component.literal("❌ Неправильна структура"));
            Dragonborn.LOGGER.warn("Multiblock NOT placed in {} {} {} {}", pos, facing, OFFSET, SCHEMAS);
        }
        level.setBlock(pos.offset(MultiblockChecker.rotatePos(CORE_OFFSET, facing)),ModBlocks.SMITHING_SMELTER.get().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, facing),3);

        return InteractionResult.CONSUME;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
}