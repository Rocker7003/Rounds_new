package net.mcreator.roundsnew.procedures;

import java.util.Comparator;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ExplodeeasyProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      Vec3 _center = new Vec3(x, y, z);

      for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.0), e -> true)
         .stream()
         .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
         .toList()) {
         if (entityiterator instanceof Player && entityiterator.isAlive()) {
            if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) <= 4.0F) {
               entityiterator.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 99999.0F
               );
            } else {
               if (entityiterator instanceof LivingEntity _entity) {
                  _entity.setHealth((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) - 4.0F);
               }

               entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 0.1F);
            }
         }
      }
   }
}
