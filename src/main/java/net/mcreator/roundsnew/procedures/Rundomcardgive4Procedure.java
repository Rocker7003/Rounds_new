package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.world.entity.Entity;

public class Rundomcardgive4Procedure {

    /**
     * Main execution method. Tries to give a random card from this set.
     * If all random checks fail, it falls back to the first procedure.
     */
    public static void execute(Entity entity) {
        if (entity == null) {
            return;
        }

        // Chain of attempts to give a card. If one succeeds, the chain stops.
        if (Math.random() < 0.01) {
            tryGiveCard(entity, 31);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 32);
        } else if (Math.random() < 0.005) {
            tryGiveCard(entity, 33);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 34);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 35);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 36);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 37);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 38);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 39);
        } else if (Math.random() < 0.007) {
            tryGiveCard(entity, 40);
        } else if (Math.random() < 0.01) {
            tryGiveCard(entity, 41);
        } else if (Math.random() < 0.005) {
            tryGiveCard(entity, 42);
        } else if (Math.random() < 0.008) {
            tryGiveCard(entity, 43);
        } else {
            // If no card from this procedure was given, try the first set again as a fallback.
            RundomcardgiveProcedure.execute(entity);
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
                case 31: alreadyHasCard = capability.card_31; break;
                case 32: alreadyHasCard = capability.card_32; break;
                case 33: alreadyHasCard = capability.card_33; break;
                case 34: alreadyHasCard = capability.card_34; break;
                case 35: alreadyHasCard = capability.card_35; break;
                case 36: alreadyHasCard = capability.card_36; break;
                case 37: alreadyHasCard = capability.card_37; break;
                case 38: alreadyHasCard = capability.card_38; break;
                case 39: alreadyHasCard = capability.card_39; break;
                case 40: alreadyHasCard = capability.card_40; break;
                case 41: alreadyHasCard = capability.card_41; break;
                case 42: alreadyHasCard = capability.card_42; break;
                case 43: alreadyHasCard = capability.card_43; break;
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
                    case 31: capability.card_31 = true; break;
                    case 32: capability.card_32 = true; break;
                    case 33: capability.card_33 = true; break;
                    case 34: capability.card_34 = true; break;
                    case 35: capability.card_35 = true; break;
                    case 36: capability.card_36 = true; break;
                    case 37: capability.card_37 = true; break;
                    case 38: capability.card_38 = true; break;
                    case 39: capability.card_39 = true; break;
                    case 40: capability.card_40 = true; break;
                    case 41: capability.card_41 = true; break;
                    case 42: capability.card_42 = true; break;
                    case 43: capability.card_43 = true; break;
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