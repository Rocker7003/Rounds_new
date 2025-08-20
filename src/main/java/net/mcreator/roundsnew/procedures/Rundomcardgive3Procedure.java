package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.world.entity.Entity;

public class Rundomcardgive3Procedure {

    /**
     * Main execution method. Tries to give a random card from this set.
     * If all random checks fail, it proceeds to the next procedure.
     */
    public static void execute(Entity entity) {
        if (entity == null) {
            return;
        }

        // Chain of attempts to give a card. If one succeeds, the chain stops.
        if (Math.random() < 0.01) {
            tryGiveCard(entity, 21);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 22);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 23);
        } else if (Math.random() < 0.008) {
            tryGiveCard(entity, 24);
        } else if (Math.random() < 0.003) {
            tryGiveCard(entity, 25);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 26);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 27);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 28);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 29);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 30);
        } else {
            // If no card from this procedure was given, try the next set.
            Rundomcardgive4Procedure.execute(entity);
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
                case 21: alreadyHasCard = capability.card_21; break;
                case 22: alreadyHasCard = capability.card_22; break;
                case 23: alreadyHasCard = capability.card_23; break;
                case 24: alreadyHasCard = capability.card_24; break;
                case 25: alreadyHasCard = capability.card_25; break;
                case 26: alreadyHasCard = capability.card_26; break;
                case 27: alreadyHasCard = capability.card_27; break;
                case 28: alreadyHasCard = capability.card_28; break;
                case 29: alreadyHasCard = capability.card_29; break;
                case 30: alreadyHasCard = capability.card_30; break;
            }

            if (alreadyHasCard) {
                // If the player already has this card, try giving a different one from the first set.
                RundomcardgiveProcedure.execute(entity);
            } else {
                // Grant the new card.
                capability.cards += 1.0;
                capability.card_uses = 0.0;

                // Set the boolean flag for the new card.
                switch (cardId) {
                    case 21: capability.card_21 = true; break;
                    case 22: capability.card_22 = true; break;
                    case 23: capability.card_23 = true; break;
                    case 24: capability.card_24 = true; break;
                    case 25: capability.card_25 = true; break;
                    case 26: capability.card_26 = true; break;
                    case 27: capability.card_27 = true; break;
                    case 28: capability.card_28 = true; break;
                    case 29: capability.card_29 = true; break;
                    case 30: capability.card_30 = true; break;
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