package net.mcreator.roundsnew.procedures;

import java.util.Comparator;
import net.mcreator.roundsnew.init.RoundsNewModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class HominglcProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double tech_yaw_y = 0.0;
         double tech_yaw_z = 0.0;
         double tech_yaw_x = 0.0;
         tech_yaw_x = entity.getX();
         tech_yaw_y = entity.getY();
         tech_yaw_z = entity.getZ();

         for (int index0 = 0; index0 < 60; index0++) {
            tech_yaw_x += entity.getLookAngle().x / 3.0;
            tech_yaw_y += entity.getLookAngle().y / 3.0;
            tech_yaw_z += entity.getLookAngle().z / 3.0;
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)RoundsNewModParticleTypes.S.get(), tech_yaw_x, tech_yaw_y, tech_yaw_z, 1, 0.001, 0.001, 0.001, 0.0);
            }

            Vec3 _center = new Vec3(tech_yaw_x, tech_yaw_y, tech_yaw_z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof Player) {
                  break;
               }
            }
         }
      }
   }
}
