package net.mcreator.roundsnew.init;

import net.mcreator.roundsnew.client.particle.AParticle;
import net.mcreator.roundsnew.client.particle.DParticle;
import net.mcreator.roundsnew.client.particle.SParticle;
import net.mcreator.roundsnew.client.particle.WParticle;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class RoundsNewModParticles {
   @SubscribeEvent
   public static void registerParticles(RegisterParticleProvidersEvent event) {
      event.registerSpriteSet((ParticleType)RoundsNewModParticleTypes.S.get(), SParticle::provider);
      event.registerSpriteSet((ParticleType)RoundsNewModParticleTypes.D.get(), DParticle::provider);
      event.registerSpriteSet((ParticleType)RoundsNewModParticleTypes.A.get(), AParticle::provider);
      event.registerSpriteSet((ParticleType)RoundsNewModParticleTypes.W.get(), WParticle::provider);
   }
}
