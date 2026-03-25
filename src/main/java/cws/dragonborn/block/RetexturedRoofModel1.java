package cws.dragonborn.block;

import cws.dragonborn.Dragonborn;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.*;

class RetexturedRoofModel1 implements BakedModel {
    private final BakedModel baseModel;
    private final ResourceLocation textureLocation;
    private TextureAtlasSprite cachedSprite;
    private boolean spriteLoaded = false;
    // ВАЖЛИВО: НЕ кешуємо quad'и, бо BlockState може змінитися!

    public RetexturedRoofModel1(BakedModel baseModel, ResourceLocation textureLocation) {
        this.baseModel = baseModel;
        this.textureLocation = textureLocation;
    }

    private TextureAtlasSprite getOrLoadSprite() {
        if (!spriteLoaded) {
            Dragonborn.LOGGER.info("=== Loading sprite for texture: {} ===", textureLocation);
            try {
                TextureAtlas atlas = Minecraft.getInstance()
                        .getModelManager()
                        .getAtlas(InventoryMenu.BLOCK_ATLAS);

                cachedSprite = atlas.getSprite(textureLocation);

                if (cachedSprite == null) {
                    Dragonborn.LOGGER.error("Sprite is NULL for: {}", textureLocation);
                    cachedSprite = baseModel.getParticleIcon();
                } else if (cachedSprite.contents().name().equals(MissingTextureAtlasSprite.getLocation())) {
                    Dragonborn.LOGGER.error("Missing texture sprite for: {}", textureLocation);
                    Dragonborn.LOGGER.error("Sprite name: {}", cachedSprite.contents().name());
                    cachedSprite = baseModel.getParticleIcon();
                } else {
                    Dragonborn.LOGGER.info("✓ Successfully loaded sprite: {}", cachedSprite.contents().name());
                    Dragonborn.LOGGER.info("  Texture location: {}", textureLocation);
                }
            } catch (Exception e) {
                Dragonborn.LOGGER.error("Exception loading sprite: {}", e.getMessage());
                e.printStackTrace();
                cachedSprite = baseModel.getParticleIcon();
            }
            spriteLoaded = true;
        }
        return cachedSprite;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, RandomSource rand) {
        TextureAtlasSprite newSprite = getOrLoadSprite();

        if (newSprite == null) {
            Dragonborn.LOGGER.warn("getQuads called but sprite is null! Returning base model quads");
            return baseModel.getQuads(state, side, rand);
        }

        // НЕ кешуємо - завжди генеруємо нові quad'и
        List<BakedQuad> originalQuads = baseModel.getQuads(state, side, rand);

        if (originalQuads.isEmpty()) {
            return originalQuads;
        }

        // Завжди створюємо нові quad'и з новою текстурою
        return retextureQuads(originalQuads, newSprite);
    }

    private List<BakedQuad> retextureQuads(List<BakedQuad> originalQuads, TextureAtlasSprite newSprite) {
        if (originalQuads.isEmpty()) {
            return originalQuads;
        }

        List<BakedQuad> newQuads = new ArrayList<>(originalQuads.size());

        // Визначаємо які текстури потрібно замінити
        // Можеш додати кілька текстур які хочеш замінити
        Set<ResourceLocation> texturesToReplace = new HashSet<>();
        texturesToReplace.add(new ResourceLocation("dragonborn", "block/air")); // base текстура

        for (BakedQuad quad : originalQuads) {
            TextureAtlasSprite oldSprite = quad.getSprite();

            // Перевіряємо чи потрібно замінити цю текстуру
            if (texturesToReplace.contains(oldSprite.contents().name())) {
                // Заміняємо тільки цю текстуру
                BakedQuad newQuad = remapQuadUVs(quad, oldSprite, newSprite);
                newQuads.add(newQuad);
            } else {
                // Інші текстури залишаємо як є
                newQuads.add(quad);
            }
        }

        return newQuads;
    }

    // Перераховує UV координати з одного sprite на інший
    private BakedQuad remapQuadUVs(BakedQuad quad, TextureAtlasSprite oldSprite, TextureAtlasSprite newSprite) {
        int[] oldVertices = quad.getVertices();
        int[] newVertices = oldVertices.clone();

        // Формат вершини: 8 int'ів на вершину
        // [0] = x, [1] = y, [2] = z, [3] = color, [4] = u, [5] = v, [6] = normal, [7] = padding

        for (int vertex = 0; vertex < 4; vertex++) {
            int offset = vertex * 8;

            // Отримуємо старі UV координати
            float oldU = Float.intBitsToFloat(oldVertices[offset + 4]);
            float oldV = Float.intBitsToFloat(oldVertices[offset + 5]);

            // Нормалізуємо UV [0,1]
            float normalizedU = (oldU - oldSprite.getU0()) / (oldSprite.getU1() - oldSprite.getU0());
            float normalizedV = (oldV - oldSprite.getV0()) / (oldSprite.getV1() - oldSprite.getV0());

            // Перераховуємо для нового sprite
            float newU = newSprite.getU0() + normalizedU * (newSprite.getU1() - newSprite.getU0());
            float newV = newSprite.getV0() + normalizedV * (newSprite.getV1() - newSprite.getV0());

            // Записуємо нові UV
            newVertices[offset + 4] = Float.floatToRawIntBits(newU);
            newVertices[offset + 5] = Float.floatToRawIntBits(newV);
        }

        return new BakedQuad(
                newVertices,
                quad.getTintIndex(),
                quad.getDirection(),
                newSprite,
                quad.isShade()
        );
    }

    @Override
    public boolean useAmbientOcclusion() {
        return baseModel.useAmbientOcclusion();
    }

    @Override
    public boolean isGui3d() {
        return baseModel.isGui3d();
    }

    @Override
    public boolean usesBlockLight() {
        return baseModel.usesBlockLight();
    }

    @Override
    public boolean isCustomRenderer() {
        return baseModel.isCustomRenderer();
    }

    @Override
    public TextureAtlasSprite getParticleIcon() {
        TextureAtlasSprite sprite = getOrLoadSprite();
        return sprite != null ? sprite : baseModel.getParticleIcon();
    }

    @Override
    public ItemTransforms getTransforms() {
        return baseModel.getTransforms();
    }

    @Override
    public ItemOverrides getOverrides() {
        return baseModel.getOverrides();
    }
}