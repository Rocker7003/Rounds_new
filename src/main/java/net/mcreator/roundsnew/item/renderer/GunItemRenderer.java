package net.mcreator.roundsnew.item.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.HashSet;
import java.util.Set;
import net.mcreator.roundsnew.item.GunItem;
import net.mcreator.roundsnew.item.model.GunItemModel;
import net.mcreator.roundsnew.utils.AnimUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.util.RenderUtils;

public class GunItemRenderer extends GeoItemRenderer<GunItem> {
   private static final float SCALE_RECIPROCAL = 0.0625F;
   protected boolean renderArms = false;
   protected MultiBufferSource currentBuffer;
   protected RenderType renderType;
   public ItemDisplayContext transformType;
   protected GunItem animatable;
   private final Set<String> hiddenBones = new HashSet<>();
   private final Set<String> suppressedBones = new HashSet<>();

   public GunItemRenderer() {
      super(new GunItemModel());
   }

   public RenderType getRenderType(GunItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void renderByItem(
      ItemStack stack, ItemDisplayContext transformType, PoseStack matrixStack, MultiBufferSource bufferIn, int combinedLightIn, int p_239207_6_
   ) {
      this.transformType = transformType;
      if (this.animatable != null) {
         this.animatable.getTransformType(transformType);
      }

      super.renderByItem(stack, transformType, matrixStack, bufferIn, combinedLightIn, p_239207_6_);
   }

   public void actuallyRender(
      PoseStack matrixStackIn,
      GunItem animatable,
      BakedGeoModel model,
      RenderType type,
      MultiBufferSource renderTypeBuffer,
      VertexConsumer vertexBuilder,
      boolean isRenderer,
      float partialTicks,
      int packedLightIn,
      int packedOverlayIn,
      float red,
      float green,
      float blue,
      float alpha
   ) {
      this.currentBuffer = renderTypeBuffer;
      this.renderType = type;
      this.animatable = animatable;
      super.actuallyRender(
         matrixStackIn,
         animatable,
         model,
         type,
         renderTypeBuffer,
         vertexBuilder,
         isRenderer,
         partialTicks,
         packedLightIn,
         packedOverlayIn,
         red,
         green,
         blue,
         alpha
      );
      if (this.renderArms) {
         this.renderArms = false;
      }
   }

   public void renderRecursively(
      PoseStack stack,
      GunItem animatable,
      GeoBone bone,
      RenderType type,
      MultiBufferSource buffer,
      VertexConsumer bufferIn,
      boolean isReRender,
      float partialTick,
      int packedLightIn,
      int packedOverlayIn,
      float red,
      float green,
      float blue,
      float alpha
   ) {
      Minecraft mc = Minecraft.getInstance();
      String name = bone.getName();
      boolean renderingArms = false;
      if (!name.equals("LeftArm") && !name.equals("RightArm")) {
         bone.setHidden(this.hiddenBones.contains(name));
      } else {
         bone.setHidden(true);
         renderingArms = true;
      }

      if (this.transformType.firstPerson() && renderingArms) {
         AbstractClientPlayer player = mc.player;
         float armsAlpha = player.isInvisible() ? 0.15F : 1.0F;
         PlayerRenderer playerRenderer = (PlayerRenderer)mc.getEntityRenderDispatcher().getRenderer(player);
         PlayerModel<AbstractClientPlayer> model = (PlayerModel<AbstractClientPlayer>)playerRenderer.getModel();
         stack.pushPose();
         RenderUtils.translateMatrixToBone(stack, bone);
         RenderUtils.translateToPivotPoint(stack, bone);
         RenderUtils.rotateMatrixAroundBone(stack, bone);
         RenderUtils.scaleMatrixForBone(stack, bone);
         RenderUtils.translateAwayFromPivotPoint(stack, bone);
         ResourceLocation loc = player.getSkinTextureLocation();
         VertexConsumer armBuilder = this.currentBuffer.getBuffer(RenderType.entitySolid(loc));
         VertexConsumer sleeveBuilder = this.currentBuffer.getBuffer(RenderType.entityTranslucent(loc));
         if (name.equals("LeftArm")) {
            stack.translate(-0.0625F, 0.125F, 0.0F);
            AnimUtils.renderPartOverBone(model.leftArm, bone, stack, armBuilder, packedLightIn, OverlayTexture.NO_OVERLAY, armsAlpha);
            AnimUtils.renderPartOverBone(model.leftSleeve, bone, stack, sleeveBuilder, packedLightIn, OverlayTexture.NO_OVERLAY, armsAlpha);
         } else if (name.equals("RightArm")) {
            stack.translate(0.0625F, 0.125F, 0.0F);
            AnimUtils.renderPartOverBone(model.rightArm, bone, stack, armBuilder, packedLightIn, OverlayTexture.NO_OVERLAY, armsAlpha);
            AnimUtils.renderPartOverBone(model.rightSleeve, bone, stack, sleeveBuilder, packedLightIn, OverlayTexture.NO_OVERLAY, armsAlpha);
         }

         this.currentBuffer.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(this.animatable)));
         stack.popPose();
      }

      super.renderRecursively(stack, animatable, bone, type, buffer, bufferIn, isReRender, partialTick, packedLightIn, packedOverlayIn, red, green, blue, alpha);
   }

   public ResourceLocation getTextureLocation(GunItem instance) {
      return super.getTextureLocation(instance);
   }
}
