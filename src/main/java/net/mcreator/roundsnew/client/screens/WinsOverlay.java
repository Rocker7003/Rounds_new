package net.mcreator.roundsnew.client.screens;

import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import net.mcreator.roundsnew.procedures.Bluewi1Procedure;
import net.mcreator.roundsnew.procedures.Bluewi2Procedure;
import net.mcreator.roundsnew.procedures.Bluewi3Procedure;
import net.mcreator.roundsnew.procedures.Bluewi4Procedure;
import net.mcreator.roundsnew.procedures.Bluewi5Procedure;
import net.mcreator.roundsnew.procedures.Bluewi6Procedure;
import net.mcreator.roundsnew.procedures.Greenwi1Procedure;
import net.mcreator.roundsnew.procedures.Greenwi2Procedure;
import net.mcreator.roundsnew.procedures.Greenwi3Procedure;
import net.mcreator.roundsnew.procedures.Greenwi4Procedure;
import net.mcreator.roundsnew.procedures.Greenwi5Procedure;
import net.mcreator.roundsnew.procedures.Greenwi6Procedure;
import net.mcreator.roundsnew.procedures.Redwi1Procedure;
import net.mcreator.roundsnew.procedures.Redwi2Procedure;
import net.mcreator.roundsnew.procedures.Redwi3Procedure;
import net.mcreator.roundsnew.procedures.Redwi4Procedure;
import net.mcreator.roundsnew.procedures.Redwi5Procedure;
import net.mcreator.roundsnew.procedures.Redwi6Procedure;
import net.mcreator.roundsnew.procedures.Yellowwi1Procedure;
import net.mcreator.roundsnew.procedures.Yellowwi2Procedure;
import net.mcreator.roundsnew.procedures.Yellowwi3Procedure;
import net.mcreator.roundsnew.procedures.Yellowwi4Procedure;
import net.mcreator.roundsnew.procedures.Yellowwi5Procedure;
import net.mcreator.roundsnew.procedures.Yellowwi6Procedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent.Pre;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class WinsOverlay {
   @SubscribeEvent(
      priority = EventPriority.NORMAL
   )
   public static void eventHandler(Pre event) {
      int w = event.getWindow().getGuiScaledWidth();
      int h = event.getWindow().getGuiScaledHeight();
      int posX = 0;
      int posY = 0;
      Level world = null;
      double x = 0.0;
      double y = 0.0;
      double z = 0.0;
      Player entity = Minecraft.getInstance().player;
      if (entity != null) {
         world = entity.level();
         x = entity.getX();
         y = entity.getY();
         z = entity.getZ();
      }

      RenderSystem.disableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.enableBlend();
      RenderSystem.setShader(GameRenderer::getPositionTexShader);
      RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 9, posY + 5, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 36, posY + 32, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 9, posY + 23, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 9, posY + 32, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 18, posY + 5, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 18, posY + 14, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 18, posY + 23, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 18, posY + 32, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 27, posY + 5, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 27, posY + 14, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 27, posY + 23, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 27, posY + 32, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 36, posY + 5, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 36, posY + 14, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 36, posY + 23, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 9, posY + 14, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 45, posY + 5, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 45, posY + 14, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 45, posY + 23, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 45, posY + 32, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 54, posY + 5, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 54, posY + 14, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 54, posY + 23, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cld.png"), posX + 54, posY + 32, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl.png"), posX + 0, posY + 5, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl2.png"), posX + 0, posY + 14, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl3.png"), posX + 0, posY + 23, 0.0F, 0.0F, 8, 8, 8, 8);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl4.png"), posX + 0, posY + 32, 0.0F, 0.0F, 8, 8, 8, 8);
      if (Redwi1Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl.png"), posX + 9, posY + 5, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Redwi2Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl.png"), posX + 18, posY + 5, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Redwi3Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl.png"), posX + 27, posY + 5, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Redwi4Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl.png"), posX + 36, posY + 5, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Redwi5Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl.png"), posX + 45, posY + 5, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Redwi6Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl.png"), posX + 54, posY + 5, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Redwi6Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl.png"), posX + 54, posY + 14, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Redwi6Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl.png"), posX + 54, posY + 23, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Redwi6Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl.png"), posX + 54, posY + 32, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Greenwi1Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl2.png"), posX + 9, posY + 14, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Greenwi2Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl2.png"), posX + 18, posY + 14, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Greenwi3Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl2.png"), posX + 27, posY + 14, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Greenwi4Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl2.png"), posX + 36, posY + 14, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Greenwi5Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl2.png"), posX + 45, posY + 14, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Greenwi6Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl2.png"), posX + 54, posY + 14, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Greenwi6Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl2.png"), posX + 54, posY + 5, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Greenwi6Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl2.png"), posX + 54, posY + 23, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Greenwi6Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl2.png"), posX + 54, posY + 32, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Yellowwi1Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl3.png"), posX + 9, posY + 23, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Yellowwi2Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl3.png"), posX + 18, posY + 23, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Yellowwi3Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl3.png"), posX + 27, posY + 23, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Yellowwi4Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl3.png"), posX + 36, posY + 23, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Yellowwi5Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl3.png"), posX + 45, posY + 23, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Yellowwi6Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl3.png"), posX + 54, posY + 23, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Yellowwi6Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl3.png"), posX + 54, posY + 5, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Yellowwi6Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl3.png"), posX + 54, posY + 14, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Yellowwi6Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl3.png"), posX + 54, posY + 32, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Bluewi1Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl4.png"), posX + 9, posY + 32, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Bluewi2Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl4.png"), posX + 18, posY + 32, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Bluewi3Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl4.png"), posX + 27, posY + 32, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Bluewi4Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl4.png"), posX + 36, posY + 32, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Bluewi5Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl4.png"), posX + 45, posY + 32, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Bluewi6Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl4.png"), posX + 54, posY + 32, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Bluewi6Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl4.png"), posX + 54, posY + 5, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Bluewi6Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl4.png"), posX + 54, posY + 14, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      if (Bluewi6Procedure.execute(entity)) {
         event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/cl4.png"), posX + 54, posY + 23, 0.0F, 0.0F, 8, 8, 8, 8);
      }

      RenderSystem.depthMask(true);
      RenderSystem.defaultBlendFunc();
      RenderSystem.enableDepthTest();
      RenderSystem.disableBlend();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
   }
}
