package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class Card26Procedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
                _player.displayClientMessage(Component.literal("26"), false);
            }

            if (entity instanceof Player _player) {
                _player.closeContainer();
            }

            if (!((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new RoundsNewModVariables.PlayerVariables()))
                    .selected) {
                entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    if (capability.ammo > 1.0) {
                        capability.ammo -= 1.0;
                    } else {
                        capability.atks_reload += 10.0;
                        capability.atks += 10.0;
                    }

                    capability.atks_reload -= 5.0;
                    capability.poison += 3.0;
                    capability.syncPlayerVariables(entity);
                });
                SelectedProcedure.execute(world, entity);
            }
        }
    }
}