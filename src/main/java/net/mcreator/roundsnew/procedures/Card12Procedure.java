package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class Card12Procedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            if (entity instanceof Player _player) {
                _player.closeContainer();
            }

            if (entity instanceof Player _player && !_player.level().isClientSide()) {
                _player.displayClientMessage(Component.literal("12"), false);
            }

            if (!((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new RoundsNewModVariables.PlayerVariables()))
                    .selected) {
                entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.hp += (double)Math.round(capability.hp * 0.3);
                    double new_cooldown = capability.shield_cooldawn - capability.shield_cooldawn * 0.3;
                    if (new_cooldown > 0.0) {
                        capability.shield_cooldawn = new_cooldown;
                    }
                    capability.syncPlayerVariables(entity);
                });
                SelectedProcedure.execute(world, entity);
            }
        }
    }
}