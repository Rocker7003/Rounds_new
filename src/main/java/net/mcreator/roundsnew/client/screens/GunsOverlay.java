package net.mcreator.roundsnew.client.screens;

import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import net.mcreator.roundsnew.procedures.ReturnbulletProcedure;
import net.mcreator.roundsnew.procedures.ReturntickshieldProcedure;
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
public class GunsOverlay {
   @SubscribeEvent(
      priority = EventPriority.NORMAL
   )
   public static void eventHandler(Pre event) {
      int w = event.getWindow().getGuiScaledWidth();
      int h = event.getWindow().getGuiScaledHeight();
      int posX = 0;
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
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/bullet.png"), posX + 3, h + -18, 0.0F, 0.0F, 32, 16, 32, 16);
      event.getGuiGraphics().blit(ResourceLocation.parse("rounds_new:textures/screens/sh.png"), posX + 0, h + -37, 0.0F, 0.0F, 20, 20, 20, 20);
      event.getGuiGraphics().drawString(Minecraft.getInstance().font, ReturnbulletProcedure.execute(entity), posX + 23, h + -14, -1, false);
      event.getGuiGraphics().drawString(Minecraft.getInstance().font, ReturntickshieldProcedure.execute(entity), posX + 7, h + -33, -1, false);
      RenderSystem.depthMask(true);
      RenderSystem.defaultBlendFunc();
      RenderSystem.enableDepthTest();
      RenderSystem.disableBlend();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
   }
}
