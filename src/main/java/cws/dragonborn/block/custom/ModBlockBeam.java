package cws.dragonborn.block.custom;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class ModBlockBeam extends StairBlock {
    public ModBlockBeam(Supplier<BlockState> state, Properties properties) {
        super(state, properties.noOcclusion());
    }
}
