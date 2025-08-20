package net.mcreator.roundsnew.procedures;

import java.text.DecimalFormat;
import net.minecraft.world.entity.Entity;

public class ReturntickshieldProcedure {
   public static String execute(Entity entity) {
      return entity == null ? "" : new DecimalFormat("##.##").format(Math.round(entity.getPersistentData().getDouble("shield_d") / 20.0));
   }
}
