package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.world.level.LevelAccessor;

public class CleacomProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      RoundsNewModVariables.MapVariables.get(world).plw = 0.0;
      RoundsNewModVariables.MapVariables.get(world).syncData(world);
      RoundsNewModVariables.MapVariables.get(world).red = RoundsNewModVariables.MapVariables.get(world).card_red;
      RoundsNewModVariables.MapVariables.get(world).syncData(world);
      RoundsNewModVariables.MapVariables.get(world).green = RoundsNewModVariables.MapVariables.get(world).card_green;
      RoundsNewModVariables.MapVariables.get(world).syncData(world);
      RoundsNewModVariables.MapVariables.get(world).yellow = RoundsNewModVariables.MapVariables.get(world).card_yellow;
      RoundsNewModVariables.MapVariables.get(world).syncData(world);
      RoundsNewModVariables.MapVariables.get(world).blue = RoundsNewModVariables.MapVariables.get(world).card_blue;
      RoundsNewModVariables.MapVariables.get(world).syncData(world);
      RundomspawnmapProcedure.execute(world, x, y, z);
   }
}
