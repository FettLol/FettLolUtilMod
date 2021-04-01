package net.fettlol.entities.render;

import net.fettlol.entities.WanderingHeadHunterEntity;
import net.fettlol.entities.render.feature.WanderingHeadHunterFeatureRenderer;
import net.fettlol.util.RegistryHelper;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeadFeatureRenderer;
import net.minecraft.client.render.entity.feature.VillagerHeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.VillagerResemblingModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class WanderingHeadHunterRender extends MobEntityRenderer<WanderingHeadHunterEntity, VillagerResemblingModel<WanderingHeadHunterEntity>> {

    private static final Identifier TEXTURE = RegistryHelper.makeId("textures/entity/headhunter.png");

    public WanderingHeadHunterRender(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new VillagerResemblingModel<>(0.0F), 0.5F);
        this.addFeature(new HeadFeatureRenderer<>(this));
        this.addFeature(new VillagerHeldItemFeatureRenderer<>(this));
        this.addFeature(new WanderingHeadHunterFeatureRenderer<>(this));
    }

    @Override
    protected int getBlockLight(WanderingHeadHunterEntity headHunter, BlockPos blockPos) {
        return 15;
    }

    public Identifier getTexture(WanderingHeadHunterEntity headHunter) {
        return TEXTURE;
    }

    protected void scale(WanderingHeadHunterEntity headHunter, MatrixStack matrixStack, float f) {
        float g = 0.94F;
        matrixStack.scale(0.94F, 0.94F, 0.94F);
    }

}
