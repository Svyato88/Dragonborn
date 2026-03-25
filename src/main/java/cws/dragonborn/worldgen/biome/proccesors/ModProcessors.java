package cws.dragonborn.worldgen.biome.proccesors;

import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModProcessors {
    public static final DeferredRegister<StructureProcessorType<?>> PROCESSORS =
            DeferredRegister.create(Registries.STRUCTURE_PROCESSOR, "dragonborn");

    public static final Codec<NBTBlockCheckProcessor> CODEC = Codec.unit(NBTBlockCheckProcessor::new);


    public static final RegistryObject<StructureProcessorType<NBTBlockCheckProcessor>> NBT_BLOCK_CHECK_PROCESSOR =
            PROCESSORS.register("nbt_block_check_processor",
                    () -> new StructureProcessorType<NBTBlockCheckProcessor>() {
                        @Override
                        public Codec<NBTBlockCheckProcessor> codec() {
                            return NBTBlockCheckProcessor.CODEC;
                        }
                    });

    public static void register(IEventBus bus) {
        PROCESSORS.register(bus);
    }

    //NBTBlockCheckProcessor.CODEC){}
}