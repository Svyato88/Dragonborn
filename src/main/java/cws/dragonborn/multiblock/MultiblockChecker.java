package cws.dragonborn.multiblock;

import cws.dragonborn.Dragonborn;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Optional;

public class MultiblockChecker {

    public static MultiblockSchema checkMultiblock(ServerLevel level, BlockPos pos, Direction facing, BlockPos offset, List<ResourceLocation> schemas) {
        for (ResourceLocation rl : schemas) {
            MultiblockSchema schema = MultiblockSchema.load(rl);

            if (matchesSchema(level, pos, facing, offset, schema)) {
                return schema;
            }
        }
        return null;
    }

    private static boolean matchesSchema(ServerLevel level, BlockPos origin, Direction facing, BlockPos offset, MultiblockSchema schema) {
        for (MultiblockSchema.BlockEntry entry : schema.getBlocks()) {
            BlockPos rotated = rotatePos(entry.pos().offset(offset), facing);
            //BlockPos worldPos = origin.offset(offset).offset(rotated);
            BlockPos worldPos = origin.offset(rotated);

            BlockState expected = entry.state();
            BlockState actual = level.getBlockState(worldPos);

            if (!actual.is(expected.getBlock())) {
                Dragonborn.LOGGER.info("11Facing block NOT matches {} ", actual);

                Dragonborn.LOGGER.info("22Facing block NOT matches {} ", expected);

                Dragonborn.LOGGER.info("33Facing block NOT matches {} ", worldPos);

                level.setBlock(worldPos, Blocks.STONE.defaultBlockState(), 3);
                Dragonborn.LOGGER.info("Place debug block in {}",worldPos);
                return false;
            };

            //Dragonborn.LOGGER.info("Multiblock facing {}", facing);

            //Dragonborn.LOGGER.info("We have a matches block {}", actual);

            for (Property<?> prop : expected.getProperties()) {
                //Dragonborn.LOGGER.info("We have block with properties {}", actual);

                if (!actual.getValue(prop).equals(expected.getValue(prop)) && !actual.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
                    //Dragonborn.LOGGER.info("Block NOT prop {}", actual);
                    return false;
                }

                if (actual.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
                    //Dragonborn.LOGGER.info("We have facing block {}", actual);
                        if (!(actual.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.NORTH)) {
                            //Dragonborn.LOGGER.info("Block NOT faced to NORTH {}", actual);
                            if (!checkBlockFacing(actual, facing).getValue(prop).equals(expected.getValue(prop))) {
                                //Dragonborn.LOGGER.info("Facing block NOT matches {} {} {}", actual, expected, worldPos);

                                Dragonborn.LOGGER.info("1Facing block NOT matches {} ", checkBlockFacing(actual, facing));

                                Dragonborn.LOGGER.info("2Facing block NOT matches {} ", expected);

                                Dragonborn.LOGGER.info("3Facing block NOT matches {} ", worldPos);
                                return false;
                            }
                            //Dragonborn.LOGGER.info("1Facing block IS matches {} ", checkBlockFacing(actual, facing));

                            //Dragonborn.LOGGER.info("2Facing block IS matches {} ", expected);

                            Dragonborn.LOGGER.info("3Facing block IS matches {} ", worldPos);
                        }
                    }
            }
        }
        return true;
    }
    private static BlockState checkBlockFacing(BlockState actual, Direction facing){
        Direction actualDir = actual.getValue(BlockStateProperties.HORIZONTAL_FACING);
        BlockState rotatedState = actual;

        if (facing == Direction.SOUTH) {
        switch (actualDir) {
            case NORTH -> rotatedState = actual.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH);
            case SOUTH -> rotatedState = actual.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH);
            case WEST -> rotatedState = actual.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST);
            case EAST -> rotatedState = actual.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST);
            }
        }
        if (facing == Direction.WEST) {
            switch (actualDir) {
                case NORTH -> rotatedState = actual.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST);
                case SOUTH -> rotatedState = actual.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST);
                case WEST -> rotatedState = actual.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH);
                case EAST -> rotatedState = actual.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH);
            }
        }
        if (facing == Direction.EAST) {
            switch (actualDir) {
                case NORTH -> rotatedState = actual.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST);
                case SOUTH -> rotatedState = actual.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST);
                case WEST -> rotatedState = actual.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH);
                case EAST -> rotatedState = actual.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH);
            }
        }
        return rotatedState;
    }

    public static BlockPos rotatePos(BlockPos pos, Direction facing) {
        int x = pos.getX(), y = pos.getY(), z = pos.getZ();
        Dragonborn.LOGGER.info("Pos to rotate {} {} ", pos, facing);
        return pos.rotate(
                switch (facing) {
                    case SOUTH -> Rotation.CLOCKWISE_180;
                    case EAST  -> Rotation.CLOCKWISE_90;
                    case WEST  -> Rotation.COUNTERCLOCKWISE_90;
                    default    -> Rotation.NONE;
                }
        );
    }
}