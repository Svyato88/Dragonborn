package cws.dragonborn.block.client.blockgradient;

import java.util.Random;

public class SimplexNoiseGenerator {

    private static final int PERMUTATION_SIZE = 256;
    private final int[] perm = new int[PERMUTATION_SIZE * 2];

    public SimplexNoiseGenerator(long seed) {
        Random random = new Random(seed);
        int[] p = new int[PERMUTATION_SIZE];
        for (int i = 0; i < PERMUTATION_SIZE; i++) p[i] = i;

        // Перемішування
        for (int i = PERMUTATION_SIZE - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int tmp = p[i];
            p[i] = p[j];
            p[j] = tmp;
        }

        for (int i = 0; i < PERMUTATION_SIZE * 2; i++) {
            perm[i] = p[i % PERMUTATION_SIZE];
        }
    }

    // 2D Simplex Noise (можна розширити на 3D)
    public double noise(double x, double y, double z) {
        int xi = fastfloor(x) & 255;
        int yi = fastfloor(y) & 255;
        int zi = fastfloor(z) & 255;

        double xf = x - fastfloor(x);
        double yf = y - fastfloor(y);
        double zf = z - fastfloor(z);

        double u = fade(xf);
        double v = fade(yf);
        double w = fade(zf);

        int aaa = perm[perm[perm[xi] + yi] + zi];
        int aba = perm[perm[perm[xi] + yi + 1] + zi];
        int aab = perm[perm[perm[xi] + yi] + zi + 1];
        int abb = perm[perm[perm[xi] + yi + 1] + zi + 1];

        int baa = perm[perm[perm[xi + 1] + yi] + zi];
        int bba = perm[perm[perm[xi + 1] + yi + 1] + zi];
        int bab = perm[perm[perm[xi + 1] + yi] + zi + 1];
        int bbb = perm[perm[perm[xi + 1] + yi + 1] + zi + 1];

        double x1 = lerp(
                grad(aaa, xf, yf, zf),
                grad(baa, xf - 1, yf, zf),
                u
        );
        double x2 = lerp(
                grad(aba, xf, yf - 1, zf),
                grad(bba, xf - 1, yf - 1, zf),
                u
        );
        double y1 = lerp(x1, x2, v);

        double x3 = lerp(
                grad(aab, xf, yf, zf - 1),
                grad(bab, xf - 1, yf, zf - 1),
                u
        );
        double x4 = lerp(
                grad(abb, xf, yf - 1, zf - 1),
                grad(bbb, xf - 1, yf - 1, zf - 1),
                u
        );
        double y2 = lerp(x3, x4, v);

        return lerp(y1, y2, w); // ≈ [-1; 1]
    }


    private int fastfloor(double x) {
        return x > 0 ? (int)x : (int)x - 1;
    }

    private double fade(double t) {
        return t * t * t * (t * (t * 6 - 15) + 10);
    }

    private double lerp(double a, double b, double t) {
        return a + t * (b - a);
    }

    private double grad(int hash, double x, double y, double z) {
        int h = hash & 15;
        double u = h < 8 ? x : y;
        double v = h < 4 ? y : (h == 12 || h == 14 ? x : z);
        return ((h & 1) == 0 ? u : -u) + ((h & 2) == 0 ? v : -v);
    }

}
