package cws.dragonborn.worldgen.biome;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.worldgen.biome.regions.SpruceForestColdRegion;
import cws.dragonborn.worldgen.biome.regions.SpruceForestRegion;
import cws.dragonborn.worldgen.biome.regions.SpruceForestSnowyRegion;
import cws.dragonborn.worldgen.biome.regions.WhiterunPlainsRegion;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new WhiterunPlainsRegion(new ResourceLocation(Dragonborn.MOD_ID, "overworld"), 1));

        Regions.register(new SpruceForestRegion(new ResourceLocation(Dragonborn.MOD_ID, "overworld1"), 1));

        Regions.register(new SpruceForestColdRegion(new ResourceLocation(Dragonborn.MOD_ID, "overworld2"), 1));

        Regions.register(new SpruceForestSnowyRegion(new ResourceLocation(Dragonborn.MOD_ID, "overworld3"), 2));
    }
}