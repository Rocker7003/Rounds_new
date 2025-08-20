package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SelectedProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            HpProcedure.execute(entity);
            if (!world.isClientSide() && world.getServer() != null) {
                world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(entity.getDisplayName().getString() + " Выбрал Карту"), false);
            }

            // Consolidate all capability changes into a single, efficient block.
            entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.card_open = 0.0;
                capability.phenix_lv = capability.phenix; // Use the capability's own value directly.
                capability.selected = true; // Set the boolean value directly.
                capability.syncPlayerVariables(entity);
            });

            // Update map variables after capability changes.
            RoundsNewModVariables.MapVariables.get(world).pl_ready--;
            RoundsNewModVariables.MapVariables.get(world).syncData(world);
        }
    }
}