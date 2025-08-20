package net.mcreator.roundsnew.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class PhenixparticleProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double s = 0.0;
         double tech_yaw_y = 0.0;
         double tech_yaw_z = 0.0;
         double tech_yaw_x = 0.0;
         entity.getPersistentData().putDouble("yawes", (double)entity.getYRot());
         entity.getPersistentData().putDouble("pithcss", (double)entity.getXRot());
         entity.setYRot(entity.getYRot());
         entity.setXRot((float)((double)entity.getXRot() - entity.getPersistentData().getDouble("h_ph")));
         entity.setYBodyRot(entity.getYRot());
         entity.setYHeadRot(entity.getYRot());
         entity.yRotO = entity.getYRot();
         entity.xRotO = entity.getXRot();
         if (entity instanceof LivingEntity _entity) {
            _entity.yBodyRotO = _entity.getYRot();
            _entity.yHeadRotO = _entity.getYRot();
         }

         for (int index0 = 0; index0 < 15; index0++) {
            entity.setYRot(entity.getYRot());
            entity.setXRot(entity.getXRot() + 12.0F);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity _entity) {
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            for (int index1 = 0; index1 < 20; index1++) {
               entity.setYRot(entity.getYRot() + 18.0F);
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
                     entity.getX() + entity.getLookAngle().x * 1.5,
                     entity.getY() + 1.5 + entity.getLookAngle().y * 1.5,
                     entity.getZ() + entity.getLookAngle().z * 1.5,
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
      }
   }
}
