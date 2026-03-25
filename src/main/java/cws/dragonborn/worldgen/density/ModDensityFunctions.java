package cws.dragonborn.worldgen.density;

import cws.dragonborn.Dragonborn;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class ModDensityFunctions {

    public static final ResourceKey<DensityFunction> CLIFF =
            ResourceKey.create(
                    Registries.DENSITY_FUNCTION,
                    new ResourceLocation(Dragonborn.MOD_ID, "cliff")
            );

    public static void bootstrap(BootstapContext<DensityFunction> context) {
        context.register(CLIFF, makeCliff(context));
    }

    private static DensityFunction makeCliff(BootstapContext<DensityFunction> context) {

        Holder<NormalNoise.NoiseParameters> continentalness =
                context.lookup(Registries.NOISE)
                        .getOrThrow(Noises.CONTINENTALNESS);

        DensityFunction height =
                DensityFunctions.noise(continentalness);

        DensityFunction hX =
                DensityFunctions.shiftedNoise2d(
                        DensityFunctions.constant(1),
                        DensityFunctions.zero(),
                        1.0,
                        continentalness
                );

        DensityFunction hZ =
                DensityFunctions.shiftedNoise2d(
                        DensityFunctions.zero(),
                        DensityFunctions.constant(1),
                        1.0,
                        continentalness
                );

        DensityFunction max =
                DensityFunctions.max(height, DensityFunctions.max(hX, hZ));

        DensityFunction min =
                DensityFunctions.min(height, DensityFunctions.min(hX, hZ));

        DensityFunction result = DensityFunctions.add(max, DensityFunctions.mul(DensityFunctions.constant(-1), min));


        return result;
    }

}
