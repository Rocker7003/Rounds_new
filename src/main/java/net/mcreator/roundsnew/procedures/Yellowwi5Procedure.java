package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.world.entity.Entity;

public class Yellowwi5Procedure {
   public static boolean execute(Entity entity) {
      return entity == null
         ? false
         : ((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .yellow_w
            >= 5.0;
   }
}
