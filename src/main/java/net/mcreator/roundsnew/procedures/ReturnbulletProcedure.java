package net.mcreator.roundsnew.procedures;

import java.text.DecimalFormat;
import net.minecraft.world.entity.Entity;

public class ReturnbulletProcedure {
   public static String execute(Entity entity) {
      return entity == null ? "" : new DecimalFormat("##.##").format(entity.getPersistentData().getDouble("ammo"));
   }
}
