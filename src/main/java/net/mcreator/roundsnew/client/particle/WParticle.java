package net.mcreator.roundsnew.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;
   private float angularVelocity;
   private float angularAcceleration;

   public static WParticle.WParticleProvider provider(SpriteSet spriteSet) {
      return new WParticle.WParticleProvider(spriteSet);
   }

   protected WParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.setSize(0.2F, 0.2F);
      this.quadSize *= 0.5F;
      this.lifetime = 4;
      this.gravity = 0.0F;
      this.hasPhysics = true;
      this.xd = vx * 1.0;
      this.yd = vy * 1.0;
      this.zd = vz * 1.0;
      this.angularVelocity = 1.0F;
      this.angularAcceleration = 0.0F;
      this.setSpriteFromAge(spriteSet);
   }

   public ParticleRenderType getRenderType() {
      return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
   }

   public void tick() {
      super.tick();
      this.oRoll = this.roll;
      this.roll = this.roll + this.angularVelocity;
      this.angularVelocity = this.angularVelocity + this.angularAcceleration;
      if (!this.removed) {
         this.setSprite(this.spriteSet.get(this.age / 1 % 1 + 1, 1));
      }
   }

   public static class WParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public WParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         return new WParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
      }
   }
}
