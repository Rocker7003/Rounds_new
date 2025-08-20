package net.mcreator.roundsnew.procedures;

import java.text.DecimalFormat;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class ReloadEffectStartedappliedProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         RoundsNewModVariables.MapVariables.get(world).plw++;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         double _setval = RoundsNewModVariables.MapVariables.get(world).plw;
         entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.player_use = _setval;
            capability.syncPlayerVariables(entity);
         });
         ClearplayerProcedure.execute(entity);
         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(
               Component.literal(
                  new DecimalFormat("Вы ##.##")
                     .format(
                        ((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new RoundsNewModVariables.PlayerVariables()))
                           .player_use
                     )
               ),
               false
            );
         }
      }
   }
}
