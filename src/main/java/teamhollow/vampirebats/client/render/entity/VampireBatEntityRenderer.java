package teamhollow.direbats.client.render.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import teamhollow.direbats.client.render.entity.layer.DirebatHeldItemLayer;
import teamhollow.direbats.client.render.entity.model.DirebatModel;
import teamhollow.direbats.entity.mob.DirebatEntity;

public class DirebatEntityRenderer extends MobRenderer<DirebatEntity, DirebatModel> {
    public DirebatEntityRenderer(EntityRendererManager entityRenderDispatcher) {
        super(entityRenderDispatcher, new DirebatModel(), 0.5f);
        this.addLayer(new DirebatHeldItemLayer(this));
    }

    @Override
    public ResourceLocation getEntityTexture(DirebatEntity entity) {
        return new ResourceLocation("direbats", "textures/entity/direbat.png");
    }

    @Override
    protected void preRenderCallback(DirebatEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.translate(0.0D, 0.40000000149011612D, 0.0D);

        super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
    }

    @Override
    protected void applyRotations(DirebatEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        if (entityLiving.isHanging()) {
            matrixStackIn.rotate(Vector3f.XP.rotationDegrees(180F));
            matrixStackIn.translate(0.0D, (double) -0.35F, 0.0D);

        } else {
            matrixStackIn.translate(0.0D, (double) (MathHelper.cos(ageInTicks * 0.3F) * 0.1F), 0.0D);
        }

        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
    }
}
