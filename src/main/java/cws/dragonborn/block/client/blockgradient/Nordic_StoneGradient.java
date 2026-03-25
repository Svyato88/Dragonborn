package cws.dragonborn.block.client.blockgradient;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import javax.annotation.Nullable;

public class Nordic_StoneGradient {

    private static final int COLOR_A = 0xf2f2f0;
    private static final int COLOR_B = 0xdce3f3;
    private static final int COLOR_C = 0xdee1f2;

    private static final SimplexNoise NOISE = new SimplexNoise(1234L);

    public static int getColor(
            net.minecraft.world.level.block.state.BlockState state,
            @Nullable BlockAndTintGetter level,
            @Nullable BlockPos pos,
            int tintIndex
    ) {
        if (level == null || pos == null) {
            return 0xFFFFFFFF;
        }

        double noise = smoothNoise(pos);
        float t = (float) ((noise + 1.0) * 0.5);

        return lerp3(COLOR_A, COLOR_B, COLOR_C, t);
    }

    /* ---------- noise ---------- */

    private static double smoothNoise(BlockPos pos) {
        double scale = 0.02;
        double sum = 0.0;
        int samples = 0;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                sum += NOISE.getValue(
                        (pos.getX() + dx) * scale,
                        pos.getY() * scale,
                        (pos.getZ() + dz) * scale
                );
                samples++;
            }
        }
        return sum / samples;
    }

    /* ---------- color lerp ---------- */

    private static int lerp3(int c1, int c2, int c3, float t) {
        if (t < 0.5f) {
            return lerpColor(c1, c2, t * 2.0f);
        } else {
            return lerpColor(c2, c3, (t - 0.5f) * 2.0f);
        }
    }

    private static int lerpColor(int a, int b, float t) {
        int ar = (a >> 16) & 255;
        int ag = (a >> 8) & 255;
        int ab = a & 255;

        int br = (b >> 16) & 255;
        int bg = (b >> 8) & 255;
        int bb = b & 255;

        int r = (int) Mth.lerp(t, ar, br);
        int g = (int) Mth.lerp(t, ag, bg);
        int bl = (int) Mth.lerp(t, ab, bb);

        return 0xFF000000 | (r << 16) | (g << 8) | bl;
    }

    /* ---------- tiny noise ---------- */

    private static class SimplexNoise {
        private final int seed;

        SimplexNoise(long seed) {
            this.seed = (int) seed;
        }

        double getValue(double x, double y, double z) {
            long i =
                    Double.doubleToLongBits(x * 1619 +
                            y * 31337 +
                            z * 6971 +
                            seed * 1013);

            i = (i << 13) ^ i;
            return 1.0 - ((i * (i * i * 15731L + 789221L)
                    + 1376312589L) & 0x7fffffff)
                    / 1073741824.0;
        }
    }
}