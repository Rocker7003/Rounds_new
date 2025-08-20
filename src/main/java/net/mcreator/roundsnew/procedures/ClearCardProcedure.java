package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.world.entity.Entity;

public class ClearCardProcedure {
    public static void execute(Entity entity) {
        if (entity == null) {
            return;
        }

        // Consolidate all capability changes into a single, efficient block.
        entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            // Reset numeric card counters
            capability.cards = 0.0;
            capability.card_uses = 0.0;

            // Reset all boolean card flags to false
            capability.card_1 = false;
            capability.card_2 = false;
            capability.card_3 = false;
            capability.card_4 = false;
            capability.card_5 = false;
            capability.card_6 = false;
            capability.card_7 = false;
            capability.card_8 = false;
            capability.card_9 = false;
            capability.card_10 = false;
            capability.card_11 = false;
            capability.card_12 = false;
            capability.card_13 = false;
            capability.card_14 = false;
            capability.card_15 = false;
            capability.card_16 = false;
            capability.card_17 = false;
            capability.card_18 = false;
            capability.card_19 = false;
            capability.card_20 = false;
            capability.card_21 = false;
            capability.card_22 = false;
            capability.card_23 = false;
            capability.card_24 = false;
            capability.card_25 = false;
            capability.card_26 = false;
            capability.card_27 = false;
            capability.card_28 = false;
            capability.card_29 = false;
            capability.card_30 = false;
            capability.card_31 = false;
            capability.card_32 = false;
            capability.card_33 = false;
            capability.card_34 = false;
            capability.card_35 = false;
            capability.card_36 = false;
            capability.card_37 = false;
            capability.card_38 = false;
            capability.card_39 = false;
            capability.card_40 = false;
            capability.card_41 = false;
            capability.card_42 = false;
            capability.card_43 = false;
            capability.card_44 = false;
            capability.card_45 = false;
            capability.card_46 = false;
            capability.card_47 = false;
            capability.card_48 = false;
            capability.card_49 = false;

            // Sync all the changes to the client at once.
            capability.syncPlayerVariables(entity);
        });
    }
}