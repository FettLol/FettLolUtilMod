package net.brekitomasson.fettlol.entities.render.feature;

import net.brekitomasson.fettlol.entities.WanderingHeadHunterEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.VillagerResemblingModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;

public class WanderingHeadHunterFeatureRenderer<T extends WanderingHeadHunterEntity> extends FeatureRenderer<T, VillagerResemblingModel<T>> {

    public WanderingHeadHunterFeatureRenderer(FeatureRendererContext<T, VillagerResemblingModel<T>> feature) {
        super(feature);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (!entity.isBaby() && !entity.isInvisible()) {
            BlockRenderManager blockRenderManager = MinecraftClient.getInstance().getBlockRenderManager();
            BlockState zombieHead = Blocks.ZOMBIE_HEAD.getDefaultState();

            int overlay = LivingEntityRenderer.getOverlay(entity, 0.0F);

            matrices.push();
            this.getContextModel().getHead().rotate(matrices);
            matrices.translate(0.0D, -1, 0);
            matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-80));
            matrices.scale(-1.0F, -1.0F, 1.0F);
            matrices.translate(-0.5D, -0.5D, -0.5D);
            blockRenderManager.renderBlockAsEntity(zombieHead, matrices, vertexConsumers, light, overlay);
            matrices.pop();

            matrices.push();
            this.getContextModel().getHead().rotate(matrices);
            matrices.translate(-0.5D, -0.25D, -0.5D);
            matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(75));
            matrices.multiply(Vector3f.NEGATIVE_Z.getDegreesQuaternion(25));
            matrices.scale(-1.0F, -1.0F, 1.0F);
            matrices.translate(-0.5D, -0.5D, -0.5D);
            blockRenderManager.renderBlockAsEntity(zombieHead, matrices, vertexConsumers, light, overlay);
            matrices.pop();
        }
    }

}
