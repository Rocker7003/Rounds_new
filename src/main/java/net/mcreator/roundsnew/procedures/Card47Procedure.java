package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class Card47Procedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            if (entity instanceof Player _player) {
                _player.closeContainer();
            }

            if (entity instanceof Player _player && !_player.level().isClientSide()) {
                _player.displayClientMessage(Component.literal("47"), false);
            }

            if (!((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new RoundsNewModVariables.PlayerVariables()))
                    .selected) {
                entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.RadarShot += 1.0;
                    capability.hp += (double)Math.round(capability.hp * 0.3);
                    capability.shield_cooldawn += 10.0;
                    capability.syncPlayerVariables(entity);
                });
                SelectedProcedure.execute(world, entity);
            }
        }
    }
}