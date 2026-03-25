package cws.dragonborn.tags;

import cws.dragonborn.Dragonborn;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> HILLS_FEATURE_PLACE = tag("hills_feature_place");

        public static final TagKey<Block> SNOW_FEATURE_PLACE = tag("snow_feature_place");

        public static final TagKey<Block> PODZOL_BLOCKS = tag("podzol_blocks");

        public static final TagKey<Block> MULTIBLOCK_CORE = tag("multiblock_core");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Dragonborn.MOD_ID, name));
        }
    }
}
