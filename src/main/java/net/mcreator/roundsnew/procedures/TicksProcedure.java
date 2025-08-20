package net.mcreator.roundsnew.procedures;

import java.util.Comparator;
import net.mcreator.roundsnew.init.RoundsNewModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TicksProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double s = 0.0;
         double tech_yaw_y = 0.0;
         double tech_yaw_z = 0.0;
         double tech_yaw_x = 0.0;
         double f_h = 0.0;
         if (entity.getPersistentData().getDouble("fh") == 0.8) {
            entity.getPersistentData().putDouble("yawes", (double)entity.getYRot());
            entity.getPersistentData().putDouble("pithcss", (double)entity.getXRot());
            entity.setYRot(entity.getYRot());
            entity.setXRot(entity.getXRot() - 90.0F);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity _entity) {
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            for (int index0 = 0; index0 < 30; index0++) {
               entity.setYRot(entity.getYRot());
               entity.setXRot(entity.getXRot() + 6.0F);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity _entity) {
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               for (int index1 = 0; index1 < 10; index1++) {
                  entity.setYRot(entity.getYRot() + 36.0F);
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
                        (SimpleParticleType)RoundsNewModParticleTypes.D.get(),
                        entity.getX() + entity.getLookAngle().x * entity.getPersistentData().getDouble("fh"),
                        entity.getY() + entity.getLookAngle().y * entity.getPersistentData().getDouble("fh"),
                        entity.getZ() + entity.getLookAngle().z * entity.getPersistentData().getDouble("fh"),
                        1,
                        0.001,
                        0.001,
                        0.001,
                        1.0
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

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.5), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof Player && entityiterator instanceof LivingEntity _entity) {
                  _entity.setHealth((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) + 6.0F);
               }
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

         if (entity.getPersistentData().getDouble("ticks") == 5.0) {
            entity.getPersistentData().putDouble("ticks", 0.0);
            entity.getPersistentData().putDouble("fh", entity.getPersistentData().getDouble("fh") + 0.2);
            entity.getPersistentData().putDouble("yawes", (double)entity.getYRot());
            entity.getPersistentData().putDouble("pithcss", (double)entity.getXRot());
            entity.setYRot(entity.getYRot());
            entity.setXRot(entity.getXRot() - 90.0F);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity _entity) {
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            for (int index2 = 0; index2 < 30; index2++) {
               entity.setYRot(entity.getYRot());
               entity.setXRot(entity.getXRot() + 6.0F);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity _entity) {
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               for (int index3 = 0; index3 < 10; index3++) {
                  entity.setYRot(entity.getYRot() + 36.0F);
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
                        (SimpleParticleType)RoundsNewModParticleTypes.D.get(),
                        entity.getX() + entity.getLookAngle().x * entity.getPersistentData().getDouble("fh"),
                        entity.getY() + entity.getLookAngle().y * entity.getPersistentData().getDouble("fh"),
                        entity.getZ() + entity.getLookAngle().z * entity.getPersistentData().getDouble("fh"),
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
         } else {
            entity.getPersistentData().putDouble("ticks", entity.getPersistentData().getDouble("ticks") + 1.0);
         }
      }
   }
}
