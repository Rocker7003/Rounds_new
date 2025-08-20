package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.entity.RingtoxicEntity;
import net.minecraft.world.entity.Entity;

public class BombOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.setNoGravity(true);
         entity.getPersistentData().putDouble("tick_boom", 20.0);
         if (entity instanceof RingtoxicEntity) {
            entity.getPersistentData().putDouble("ghd", 100.0);
         }
      }
   }
}
