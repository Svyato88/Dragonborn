package cws.dragonborn.block.client.blockgradient;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;


@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NordicStoneColorMap {
    private static int[] PIXELS = new int[65536];

    //nordic_stone_gradient

    public static void init(NativeImage image) {
        PIXELS = new int[image.getWidth() * image.getHeight()];
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                PIXELS[y * image.getWidth() + x] = image.getPixelRGBA(x, y);
            }
        }
    }

    public static int[] loadColormap(ResourceLocation location) {
        try {
            // Отримуємо ресурс через Minecraft ResourceManager
            Optional<Resource> resource = Minecraft.getInstance().getResourceManager().getResource(location);
            try (InputStream stream = resource.get().open()) {
                // Читаємо PNG у NativeImage
                NativeImage image = NativeImage.read(stream);
                int width = image.getWidth();
                int height = image.getHeight();
                int[] pixels = new int[width * height];
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        pixels[y * width + x] = image.getPixelRGBA(x, y);
                    }
                }
                return pixels;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new int[65536]; // fallback
        }
    }
    public static int get(double u, double v) {
        v *= u;
        int x = (int)(((double) 1.0F - u)*(double) 255.0F);
        int y = (int)(((double) 1.0F - v)*(double) 255.0F);
        int index = (y << 8) | x;
        if (index >= PIXELS.length) return 0xFFFF00FF; // fallback
        return PIXELS[index];
    }
}
