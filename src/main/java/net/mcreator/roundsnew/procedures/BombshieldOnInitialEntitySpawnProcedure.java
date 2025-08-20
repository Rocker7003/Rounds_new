package net.mcreator.roundsnew.procedures;

import net.minecraft.world.entity.Entity;

public class BombshieldOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("tick_boom", 20.0);
      }
   }
}
