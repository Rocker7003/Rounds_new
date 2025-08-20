package net.mcreator.roundsnew.init;

import net.mcreator.roundsnew.client.renderer.BombRenderer;
import net.mcreator.roundsnew.client.renderer.BombshieldRenderer;
import net.mcreator.roundsnew.client.renderer.BulletRenderer;
import net.mcreator.roundsnew.client.renderer.RinghealRenderer;
import net.mcreator.roundsnew.client.renderer.RingtoxicRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class RoundsNewModEntityRenderers {
   @SubscribeEvent
   public static void registerEntityRenderers(RegisterRenderers event) {
      event.registerEntityRenderer((EntityType)RoundsNewModEntities.BULLET.get(), BulletRenderer::new);
      event.registerEntityRenderer((EntityType)RoundsNewModEntities.BOMB.get(), BombRenderer::new);
      event.registerEntityRenderer((EntityType)RoundsNewModEntities.RINGHEAL.get(), RinghealRenderer::new);
      event.registerEntityRenderer((EntityType)RoundsNewModEntities.BOMBSHIELD.get(), BombshieldRenderer::new);
      event.registerEntityRenderer((EntityType)RoundsNewModEntities.RINGTOXIC.get(), RingtoxicRenderer::new);
   }
}
