package net.mcreator.roundsnew.procedures;

import java.util.Comparator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ExplodebulletProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
               _level.playSound(
                  null,
                  BlockPos.containing(x, y, z),
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.generic.explode")),
                  SoundSource.PLAYERS,
                  1.0F,
                  1.0F
               );
            } else {
               _level.playLocalSound(
                  x,
                  y,
                  z,
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.generic.explode")),
                  SoundSource.PLAYERS,
                  1.0F,
                  1.0F,
                  false
               );
            }
         }

         if (world instanceof ServerLevel _levelx) {
            _levelx.sendParticles(
               ParticleTypes.POOF,
               x,
               y,
               z,
               (int)(30.0 * entity.getPersistentData().getDouble("explode_bullets")),
               1.0 * entity.getPersistentData().getDouble("explode_bullets"),
               1.0 * entity.getPersistentData().getDouble("explode_bullets"),
               1.0 * entity.getPersistentData().getDouble("explode_bullets"),
               0.0
            );
         }

         Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

         for (Entity entityiterator : world.getEntitiesOfClass(
               Entity.class, new AABB(_center, _center).inflate((entity.getPersistentData().getDouble("explode_bullets") + 1.5) / 2.0), e -> true
            )
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiterator instanceof Player && entityiterator.isAlive()) {
               entityiterator.setDeltaMovement(
                  new Vec3(
                     (entity.getDeltaMovement().x() - entityiterator.getLookAngle().x) * entity.getPersistentData().getDouble("explode_bullets") * 0.2,
                     (entity.getDeltaMovement().y() - entityiterator.getLookAngle().y) * entity.getPersistentData().getDouble("explode_bullets") * 0.2,
                     (entity.getDeltaMovement().z() - entityiterator.getLookAngle().z) * entity.getPersistentData().getDouble("explode_bullets") * 0.2
                  )
               );
               if ((double)(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) <= entity.getPersistentData().getDouble("dmg") / 2.0) {
                  entityiterator.hurt(
                     new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 99999.0F
                  );
               } else {
                  if (entityiterator instanceof LivingEntity _entity) {
                     _entity.setHealth(
                        (float)(
                           (double)(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)
                              - entity.getPersistentData().getDouble("dmg") / 2.0
                        )
                     );
                  }

                  entityiterator.hurt(
                     new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 0.1F
                  );
               }
            }
         }
      }
   }
}
