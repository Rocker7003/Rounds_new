package net.mcreator.roundsnew.procedures;

import java.util.Comparator;
import net.mcreator.roundsnew.init.RoundsNewModParticleTypes;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ExplodeNovaProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles(ParticleTypes.POOF, entity.getX(), entity.getY(), entity.getZ(), 380, 3.0, 3.0, 3.0, 0.0);
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)RoundsNewModParticleTypes.S.get(), entity.getX(), entity.getY(), entity.getZ(), 50, 0.0, 0.0, 0.0, 1.0);
         }

         entity.getPersistentData().putDouble("nova", 1.0);
         Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4.0), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiterator instanceof Player && entityiterator.isAlive() && entityiterator.getPersistentData().getDouble("nova") == 0.0) {
               entityiterator.setDeltaMovement(
                  new Vec3(
                     (entity.getDeltaMovement().x() - entityiterator.getLookAngle().x) * 2.0,
                     (entity.getDeltaMovement().y() - entityiterator.getLookAngle().y) * 2.0,
                     (entity.getDeltaMovement().z() - entityiterator.getLookAngle().z) * 2.0
                  )
               );
               double _setval = ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new RoundsNewModVariables.PlayerVariables()))
                     .cold_lvl
                  + 4.0
                     * ((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .Super_nova;
               entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.cold_lvl = _setval;
                  capability.syncPlayerVariables(entityiterator);
               });
               if ((double)(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)
                  <= ((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .dmg
                     * 2.0
                     * ((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .Super_nova) {
                  entityiterator.hurt(
                     new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 99999.0F
                  );
               } else {
                  if (entityiterator instanceof LivingEntity _entity) {
                     _entity.setHealth(
                        (float)(
                           (double)(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)
                              - ((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new RoundsNewModVariables.PlayerVariables()))
                                    .dmg
                                 * 2.0
                                 * ((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new RoundsNewModVariables.PlayerVariables()))
                                    .Super_nova
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
