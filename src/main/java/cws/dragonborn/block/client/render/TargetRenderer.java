package cws.dragonborn.block.client.render;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import cws.dragonborn.block.entity.blockentities.TargetEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class TargetRenderer implements BlockEntityRenderer<TargetEntity> {

    private final cws.dragonborn.block.client.render.TargetModel model;
    private static final ResourceLocation TEXTURE = new ResourceLocation("dragonborn", "textures/block/target.png");

    public TargetRenderer(BlockEntityRendererProvider.Context context) {
        ModelPart root = context.bakeLayer(cws.dragonborn.block.client.render.TargetModel.LAYER_LOCATION);
        this.model = new cws.dragonborn.block.client.render.TargetModel(root);
    }

    @Override
    public void render(TargetEntity blockEntity, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();


        poseStack.scale(1.0F, -1.0F, -1.0F); // Важливо: перевертає модель правильно

        VertexConsumer buffer = bufferSource.getBuffer(RenderType.entityCutout(TEXTURE));
        model.renderToBuffer(poseStack, buffer, packedLight, packedOverlay, 1, 1, 1, 1);

        poseStack.popPose();
    }

}