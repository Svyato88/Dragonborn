package cws.dragonborn.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

public record SchemaEntry(StructureTemplate template, BlockPos offset) {

    public static SchemaEntry load(ServerLevel level, String modId, String name, BlockPos offset) {
        ResourceLocation rl = new ResourceLocation(modId, name);

        StructureTemplateManager manager = level.getStructureManager();
        StructureTemplate template = manager.getOrCreate(rl);

        return new SchemaEntry(template, offset);
    }
}