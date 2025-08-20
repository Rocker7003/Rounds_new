package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.init.RoundsNewModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class Phenixparticle2Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double s = 0.0;
         double tech_yaw_y = 0.0;
         double tech_yaw_z = 0.0;
         double tech_yaw_x = 0.0;
         entity.getPersistentData().putDouble("yawes", (double)entity.getYRot());

         for (int index0 = 0; index0 < 60; index0++) {
            entity.setYRot(entity.getYRot() + 6.0F);
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
                  entity.getX() + entity.getLookAngle().x * 2.0,
                  entity.getY() + 1.5 + entity.getLookAngle().y * 2.0,
                  entity.getZ() + entity.getLookAngle().z * 2.0,
                  3,
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
   }
}
