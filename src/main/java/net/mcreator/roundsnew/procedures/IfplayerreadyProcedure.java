package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.world.level.LevelAccessor;

public class IfplayerreadyProcedure {
   public static boolean execute(LevelAccessor world) {
      return RoundsNewModVariables.MapVariables.get(world).card_green > 0.0
            && (
               RoundsNewModVariables.MapVariables.get(world).card_red > 0.0
                  || RoundsNewModVariables.MapVariables.get(world).card_yellow > 0.0
                  || RoundsNewModVariables.MapVariables.get(world).card_blue > 0.0
            )
         || RoundsNewModVariables.MapVariables.get(world).card_blue > 0.0
            && (
               RoundsNewModVariables.MapVariables.get(world).card_red > 0.0
                  || RoundsNewModVariables.MapVariables.get(world).card_yellow > 0.0
                  || RoundsNewModVariables.MapVariables.get(world).card_green > 0.0
            )
         || RoundsNewModVariables.MapVariables.get(world).card_yellow > 0.0
            && (
               RoundsNewModVariables.MapVariables.get(world).card_red > 0.0
                  || RoundsNewModVariables.MapVariables.get(world).card_blue > 0.0
                  || RoundsNewModVariables.MapVariables.get(world).card_green > 0.0
            )
         || RoundsNewModVariables.MapVariables.get(world).card_red > 0.0
            && (
               RoundsNewModVariables.MapVariables.get(world).card_yellow > 0.0
                  || RoundsNewModVariables.MapVariables.get(world).card_blue > 0.0
                  || RoundsNewModVariables.MapVariables.get(world).card_green > 0.0
            );
   }
}
