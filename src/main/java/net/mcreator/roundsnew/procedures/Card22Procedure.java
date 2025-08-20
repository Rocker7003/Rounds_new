package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class Card22Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal("22"), false);
         }

         if (!((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .orElse(new RoundsNewModVariables.PlayerVariables()))
            .selected) {
            double _setval = ((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               + (double)Math.round(
                  ((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .hp
                     * 0.8
               );
            entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.hp = _setval;
               capability.syncPlayerVariables(entity);
            });
            SelectedProcedure.execute(world, entity);
         }
      }
   }
}
