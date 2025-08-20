package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.world.entity.Entity;

public class Cardg318Procedure {
   public static boolean execute(Entity entity) {
      return entity == null
         ? false
         : ((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_3
            == 18.0;
   }
}
