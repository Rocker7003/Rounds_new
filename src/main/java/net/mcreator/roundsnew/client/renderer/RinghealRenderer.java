package net.mcreator.roundsnew.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.roundsnew.entity.RinghealEntity;
import net.mcreator.roundsnew.entity.model.RinghealModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RinghealRenderer extends GeoEntityRenderer<RinghealEntity> {
   public RinghealRenderer(Context renderManager) {
      super(renderManager, new RinghealModel());
      this.shadowRadius = 0.0F;
   }

   public RenderType getRenderType(RinghealEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      RinghealEntity entity,
      BakedGeoModel model,
      MultiBufferSource bufferSource,
      VertexConsumer buffer,
      boolean isReRender,
      float partialTick,
      int packedLight,
      int packedOverlay,
      float red,
      float green,
      float blue,
      float alpha
   ) {
      float scale = 0.5F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(RinghealEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
