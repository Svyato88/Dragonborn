package cws.dragonborn.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import cws.dragonborn.entity.custom.FireflyEntity;
import cws.dragonborn.entity.custom.SkeletonEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;
import software.bernie.geckolib.util.RenderUtils;

import javax.annotation.Nullable;

public class SkeletonRender extends GeoEntityRenderer<SkeletonEntity> {
    public SkeletonRender(EntityRendererProvider.Context ctx) {
        super(ctx, new SkeletonModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
        addRenderLayer(new BlockAndItemGeoLayer<>(this) {
            @Override
            protected ItemStack getStackForBone(GeoBone bone, SkeletonEntity entity) {
                // Перевір назву точно так, як у Blockbench
                if (bone.getName().equals("left_hand")) {
                    return entity.getOffhandItem();
                }
                if (bone.getName().equals("right_hand")) {
                    return entity.getMainHandItem();
                }
                return super.getStackForBone(bone, entity);
            }

            @Override
            protected void renderStackForBone(PoseStack poseStack, GeoBone bone, ItemStack stack, SkeletonEntity entity,
                                              MultiBufferSource bufferSource, float partialTick, int packedLight, int packedOverlay) {
                poseStack.pushPose();

                RenderUtils.translateAndRotateMatrixForBone(poseStack, bone);

                //poseStack.translate(0.0f, 0.0f, -0.5f);
                //poseStack.scale(2.0f, 2.0f, 2.0f);
                //Quaternionf base = new Quaternionf(0,0,0,0);

                //poseStack.rotateAround(base,0,0,0);

                poseStack.mulPose(Axis.YP.rotationDegrees(180f));

                poseStack.mulPose(Axis.XP.rotationDegrees(90f));

                Minecraft.getInstance().getItemRenderer().renderStatic(
                        entity, stack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, false, poseStack,
                        bufferSource, entity.level(), packedLight, packedOverlay, entity.getId()
                );

                poseStack.popPose();
            }

            @Override
            protected ItemDisplayContext getTransformTypeForStack(GeoBone bone, ItemStack stack, SkeletonEntity entity) {
                return ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
            }
        });
    }
/*
    @Override
    public void renderRecursively(PoseStack poseStack, SkeletonEntity animatable,
                                  GeoBone bone, RenderType renderType,
                                  MultiBufferSource bufferSource, VertexConsumer buffer,
                                  boolean isReRender, float partialTick, int packedLight,
                                  int packedOverlay, float red, float green, float blue, float alpha) {

        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource,
                buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);

        // GeckoLib зберігає світові координати напряму в GeoBone
        animatable.locatorPositions.put(bone.getName(), new Vec3(
                bone.getWorldPosition().x(),
                bone.getWorldPosition().y(),
                bone.getWorldPosition().z()
        ));
    }
 */
}


