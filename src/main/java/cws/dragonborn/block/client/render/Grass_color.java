package cws.dragonborn.block.client.render;


import cws.dragonborn.block.ModBlocks;
import cws.dragonborn.block.client.blockgradient.NordicStoneColorMap;
import cws.dragonborn.block.client.blockgradient.Nordic_StoneGradient;
import cws.dragonborn.block.client.blockgradient.SimplexNoiseGenerator;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.util.Mth;
import net.minecraft.world.level.GrassColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Grass_color {
    private static final SimplexNoiseGenerator NOISE1 =
            new SimplexNoiseGenerator(12345L);
    @SubscribeEvent
    public static void onRegisterBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register(
                (state, reader, pos, tintIndex) -> {
                    return reader != null && pos != null
                            ? BiomeColors.getAverageGrassColor(reader, pos)
                            : GrassColor.get(0.5D, 1.0D);
                },
                ModBlocks.GRASS_BLOCK.get(),
                ModBlocks.GRASS_BLOCK_FULL.get(),
                ModBlocks.GRASS_BLOCK_FULL_FLOWERS.get()
        );
        event.register(
                (state, level, pos, tintIndex) -> {
                    if (level == null || pos == null) {
                        return 0xFFFFFFFF;
                    }
                    double scale = 0.02;
                    double n = NOISE1.noise(
                            pos.getX() -0.5,
                            pos.getY() -0.5,
                            pos.getZ() -0.5
                    );
                    return getColorFromNoise(n*0.75);
                },
                ModBlocks.NORDIC_STONE_SMOOTH.get(),
                ModBlocks.NORDIC_STONE_SMOOTH_HORIZONTAL_SLAB.get(),
                ModBlocks.NORDIC_STONE_SMOOTH_BORDER.get(),
                ModBlocks.NORDIC_STONE_SMOOTH_BORDER_HORIZONTAL_SLAB.get()
        );
    }
    public static int getColorFromNoise(double n) {
        if (n < -0.25) return 0xedeef5;
        if (n <  0.00) return 0xeff2f9;
        if (n <  0.25) return 0xe7e7f9;
        return 0xfdfdfc;
    }
    @SubscribeEvent
    public static void onRegisterItemColors(RegisterColorHandlersEvent.Item event) {
        event.register(
                (stack, tintIndex) -> GrassColor.get(0.5D, 1.0D),
                ModBlocks.GRASS_BLOCK.get(),
                ModBlocks.GRASS_BLOCK_FULL.get(),
                ModBlocks.GRASS_BLOCK_FULL_FLOWERS.get()
        );
    }
}