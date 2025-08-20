package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.world.entity.Entity;

public class RundomcardgiveProcedure {

    /**
     * Main execution method. Tries to give a random card from this set.
     * If all random checks fail, it proceeds to the next procedure.
     */
    public static void execute(Entity entity) {
        if (entity == null) {
            return;
        }

        RoundsNewModVariables.PlayerVariables playerVars = entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new RoundsNewModVariables.PlayerVariables());

        // Only attempt to give a card if the 'card_uses' flag is set.
        if (playerVars.card_uses == 1.0) {
            // Chain of attempts to give a card. If one succeeds, the chain stops.
            if (Math.random() < 0.01) {
                tryGiveCard(entity, 1);
            } else if (Math.random() < 0.01) {
                tryGiveCard(entity, 2);
            } else if (Math.random() < 0.01) {
                tryGiveCard(entity, 3);
            } else if (Math.random() < 0.01) {
                tryGiveCard(entity, 4);
            } else if (Math.random() < 0.01) {
                tryGiveCard(entity, 5);
            } else if (Math.random() < 0.01) {
                tryGiveCard(entity, 6);
            } else if (Math.random() < 0.01) {
                tryGiveCard(entity, 7);
            } else if (Math.random() < 0.01) {
                tryGiveCard(entity, 8);
            } else if (Math.random() < 0.01) {
                tryGiveCard(entity, 9);
            } else if (Math.random() < 0.01) {
                tryGiveCard(entity, 10);
            } else {
                // If no card from this procedure was given, try the next set.
                Rundomcardgive2Procedure.execute(entity);
            }
        }
    }

    /**
     * Helper method to give a specific card to a player.
     * This encapsulates the logic to prevent code duplication and fix scope issues.
     * @param entity The player entity.
     * @param cardId The ID of the card to give.
     */
    private static void tryGiveCard(Entity entity, int cardId) {
        entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            boolean alreadyHasCard = false;
            // Check if the player already has the card we're trying to give.
            switch (cardId) {
                case 1:  alreadyHasCard = capability.card_1;  break;
                case 2:  alreadyHasCard = capability.card_2;  break;
                case 3:  alreadyHasCard = capability.card_3;  break;
                case 4:  alreadyHasCard = capability.card_4;  break;
                case 5:  alreadyHasCard = capability.card_5;  break;
                case 6:  alreadyHasCard = capability.card_6;  break;
                case 7:  alreadyHasCard = capability.card_7;  break;
                case 8:  alreadyHasCard = capability.card_8;  break;
                case 9:  alreadyHasCard = capability.card_9;  break;
                case 10: alreadyHasCard = capability.card_10; break;
            }

            if (alreadyHasCard) {
                // If the player already has this card, re-run the procedure to try for a different card.
                // This preserves the original logic but can be risky (potential for StackOverflowError).
                execute(entity);
            } else {
                // Grant the new card.
                capability.cards += 1.0;
                capability.card_uses = 0.0;

                // Set the boolean flag for the new card.
                switch (cardId) {
                    case 1:  capability.card_1 = true;  break;
                    case 2:  capability.card_2 = true;  break;
                    case 3:  capability.card_3 = true;  break;
                    case 4:  capability.card_4 = true;  break;
                    case 5:  capability.card_5 = true;  break;
                    case 6:  capability.card_6 = true;  break;
                    case 7:  capability.card_7 = true;  break;
                    case 8:  capability.card_8 = true;  break;
                    case 9:  capability.card_9 = true;  break;
                    case 10: capability.card_10 = true; break;
                }

                // Assign the card ID to the correct selection slot.
                switch ((int) capability.cards) {
                    case 1: capability.card_select_1 = cardId; break;
                    case 2: capability.card_select_2 = cardId; break;
                    case 3: capability.card_select_3 = cardId; break;
                    case 4: capability.card_select_4 = cardId; break;
                    case 5: capability.card_select_5 = cardId; break;
                }

                // Sync all changes at once.
                capability.syncPlayerVariables(entity);
            }
        });
    }
}