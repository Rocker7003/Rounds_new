package net.mcreator.roundsnew.procedures;

import io.netty.buffer.Unpooled;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.mcreator.roundsnew.world.inventory.CardsselectMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.network.NetworkHooks;

public class RundomcardsProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }

        // Consolidate all initial capability changes into a single block.
        entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.card_select_1 = 0.0;
            // Corrected a duplicate line that was also setting card_select_1 to 0.
            capability.card_select_2 = 0.0;
            capability.card_select_3 = 0.0;
            capability.card_select_4 = 0.0;
            capability.card_select_5 = 0.0;
            capability.card_open = 1.0;
            capability.selected = false;
            capability.syncPlayerVariables(entity);
        });

        ClearCardProcedure.execute(entity);

        // Loop to attempt giving 5 random cards.
        for (int i = 0; i < 5; i++) {
            // Set the flag to allow a card to be given.
            entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.card_uses = 1.0;
                capability.syncPlayerVariables(entity);
            });
            // Call the procedure that handles the random card logic.
            RundomcardgiveProcedure.execute(entity);
        }

        // Open the card selection screen for the player.
        if (entity instanceof ServerPlayer _ent) {
            final BlockPos _bpos = BlockPos.containing(x, y, z);
            NetworkHooks.openScreen(_ent, new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.literal("Cardsselect");
                }

                @Override
                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                    return new CardsselectMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                }
            }, _bpos);
        }
    }
}