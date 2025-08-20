package net.mcreator.roundsnew.procedures;

import java.util.Comparator;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class RingtoxicOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().getDouble("ghd") > 0.0) {
            if (entity.getPersistentData().getDouble("dmgs") != 10.0) {
               entity.getPersistentData().putDouble("dmgs", entity.getPersistentData().getDouble("dmgs") + 1.0);
            } else {
               entity.getPersistentData().putDouble("yawes", (double)entity.getYRot());
               entity.getPersistentData().putDouble("pithcss", (double)entity.getXRot());
               entity.getPersistentData().putDouble("h_tx", 2.5);
               entity.setYRot(entity.getYRot());
               entity.setXRot(entity.getXRot() - 180.0F);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity _entity) {
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               for (int index0 = 0; index0 < 12; index0++) {
                  entity.setYRot(entity.getYRot());
                  entity.setXRot(entity.getXRot() + 15.0F);
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  for (int index1 = 0; index1 < 6; index1++) {
                     entity.setYRot(entity.getYRot() + 60.0F);
                     entity.setXRot(entity.getXRot());
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity _entity) {
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles(
                           ParticleTypes.HAPPY_VILLAGER,
                           entity.getX() + entity.getLookAngle().x * entity.getPersistentData().getDouble("h_tx"),
                           entity.getY() + 0.0 + entity.getLookAngle().y * entity.getPersistentData().getDouble("h_tx"),
                           entity.getZ() + entity.getLookAngle().z * entity.getPersistentData().getDouble("h_tx"),
                           1,
                           0.001,
                           0.001,
                           0.001,
                           0.0
                        );
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles(
                           ParticleTypes.ITEM_SLIME,
                           entity.getX() + entity.getLookAngle().x * entity.getPersistentData().getDouble("h_tx"),
                           entity.getY() + 0.0 + entity.getLookAngle().y * entity.getPersistentData().getDouble("h_tx"),
                           entity.getZ() + entity.getLookAngle().z * entity.getPersistentData().getDouble("h_tx"),
                           1,
                           0.001,
                           0.001,
                           0.001,
                           0.0
                        );
                     }
                  }

                  entity.setYRot((float)entity.getPersistentData().getDouble("yawes"));
                  entity.setXRot(entity.getXRot());
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               }

               entity.getPersistentData().putDouble("dmgs", 0.0);
               Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof Player && entityiterator.isAlive()) {
                     world.levelEvent(
                        2001,
                        BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                        Block.getId(Blocks.SLIME_BLOCK.defaultBlockState())
                     );
                     double _setval = ((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new RoundsNewModVariables.PlayerVariables()))
                           .cold_lvl
                        + 1.0;
                     entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.cold_lvl = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) <= 2.0F) {
                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 99999.0F
                        );
                     } else {
                        if (entityiterator instanceof LivingEntity _entity) {
                           _entity.setHealth((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) - 2.0F);
                        }

                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 0.1F
                        );
                     }
                  }
               }
            }

            entity.setYRot((float)entity.getPersistentData().getDouble("yawes"));
            entity.setXRot((float)entity.getPersistentData().getDouble("pithcss"));
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity _entity) {
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            entity.getPersistentData().putDouble("ghd", entity.getPersistentData().getDouble("ghd") - 1.0);
            if (entity.getPersistentData().getDouble("ghd") < 10.0) {
               entity.getPersistentData().putDouble("h_tx", entity.getPersistentData().getDouble("h_tx") - 0.1);
            }

            if (entity.getPersistentData().getDouble("ghd") == 0.0 && !entity.level().isClientSide()) {
               entity.discard();
            }
         }
      }
   }
}
