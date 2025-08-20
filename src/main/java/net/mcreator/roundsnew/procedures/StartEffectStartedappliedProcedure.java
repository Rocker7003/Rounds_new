package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class StartEffectStartedappliedProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            HpProcedure.execute(entity);

            // Consolidate all capability changes into a single block.
            entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.Super_nova_tick = 0.0;
                capability.phenix_lv = 0.0;
                capability.syncPlayerVariables(entity);
            });

            // Update map variables and sync them once at the end.
            RoundsNewModVariables.MapVariables mapVars = RoundsNewModVariables.MapVariables.get(world);
            mapVars.red = mapVars.card_red;
            mapVars.green = mapVars.card_green;
            mapVars.yellow = mapVars.card_yellow;
            mapVars.blue = mapVars.card_blue;
            mapVars.syncData(world);
        }
    }
}