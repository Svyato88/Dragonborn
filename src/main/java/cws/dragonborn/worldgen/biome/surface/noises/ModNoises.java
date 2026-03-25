package cws.dragonborn.worldgen.biome.surface.noises;

import it.unimi.dsi.fastutil.doubles.DoubleList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class ModNoises {
    public static final ResourceKey<NormalNoise.NoiseParameters> WHITE_DIRT =
            ResourceKey.create(Registries.NOISE, new ResourceLocation("dragonborn", "white_dirt"));

    public static final ResourceKey<NormalNoise.NoiseParameters> GRAY_DIRT_LITTLE_ROCKS =
            ResourceKey.create(Registries.NOISE, new ResourceLocation("dragonborn", "gray_dirt_little_rocks"));


    public static void bootstrap(BootstapContext<NormalNoise.NoiseParameters> ctx) {
        ctx.register(
                WHITE_DIRT,
                new NormalNoise.NoiseParameters(-4, // розмір плям
                        DoubleList.of(new double[]{1.0, 1.0, 0.1})) // амплітуди
        );
        ctx.register(
                GRAY_DIRT_LITTLE_ROCKS,
                new NormalNoise.NoiseParameters(-4, // розмір плям
                        DoubleList.of(new double[]{1.1, 1.0, 0.1})) // амплітуди
        );
    }
}
//https://misode.github.io/worldgen/noise noise generator