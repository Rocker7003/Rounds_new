package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.world.entity.Entity;

public class Rundomcardgive2Procedure {

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
            tryGiveCard(entity, 11);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 12);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 13);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 14);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 15);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 16);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 17);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 18);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 19);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 20);
        } else {
            // If no card from this procedure was given, try the next set.
            Rundomcardgive3Procedure.execute(entity);
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
                case 11: alreadyHasCard = capability.card_11; break;
                case 12: alreadyHasCard = capability.card_12; break;
                case 13: alreadyHasCard = capability.card_13; break;
                case 14: alreadyHasCard = capability.card_14; break;
                case 15: alreadyHasCard = capability.card_15; break;
                case 16: alreadyHasCard = capability.card_16; break;
                case 17: alreadyHasCard = capability.card_17; break;
                case 18: alreadyHasCard = capability.card_18; break;
                case 19: alreadyHasCard = capability.card_19; break;
                case 20: alreadyHasCard = capability.card_20; break;
            }

            if (alreadyHasCard) {
                // If the player already has this card, try giving a different one.
                RundomcardgiveProcedure.execute(entity);
            } else {
                // Grant the new card.
                capability.cards += 1.0;
                capability.card_uses = 0.0;

                // Set the boolean flag for the new card.
                switch (cardId) {
                    case 11: capability.card_11 = true; break;
                    case 12: capability.card_12 = true; break;
                    case 13: capability.card_13 = true; break;
                    case 14: capability.card_14 = true; break;
                    case 15: capability.card_15 = true; break;
                    case 16: capability.card_16 = true; break;
                    case 17: capability.card_17 = true; break;
                    case 18: capability.card_18 = true; break;
                    case 19: capability.card_19 = true; break;
                    case 20: capability.card_20 = true; break;
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