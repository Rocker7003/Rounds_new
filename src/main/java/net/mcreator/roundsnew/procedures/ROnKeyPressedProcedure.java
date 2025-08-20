package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.item.GunItem;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ROnKeyPressedProcedure {
    public static void execute(Entity entity) {
        if (entity == null) {
            return;
        }

        // Check if the player can reload (not on cooldown and has no ammo).
        if (entity.getPersistentData().getDouble("diss") <= 0.0 && entity.getPersistentData().getDouble("ammo") == 0.0) {

            // Get player variables once for efficiency.
            RoundsNewModVariables.PlayerVariables playerVars = entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new RoundsNewModVariables.PlayerVariables());

            // Apply the reload cooldown to the player.
            if (entity instanceof Player _player) {
                _player.getCooldowns()
                        .addCooldown(
                                (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(),
                                (int) playerVars.atks_reload
                        );
            }

            // Set the cooldown timer and refill the ammo based on player variables.
            entity.getPersistentData().putDouble("diss", playerVars.atks_reload);
            entity.getPersistentData().putDouble("ammo", playerVars.ammo);

            // Trigger the reload animation directly using the GeckoLib NBT tag.
            ItemStack mainHandItem = entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY;
            if (mainHandItem.getItem() instanceof GunItem) {
                mainHandItem.getOrCreateTag().putString("geckoAnim", "reload");
            }

            // The original code attempted to set an animation state variable and then immediately reset it,
            // which is logically flawed. The GeckoLib tag above is sufficient to trigger a one-shot animation.
            // If the pistol_anim variable is needed for state tracking, it should be managed in a tick event.
            // For this procedure, we will simply ensure the state is handled correctly.
            entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                // Set the animation state to 2.0 to indicate "reloading".
                // This state should be reset to 0.0 (idle) by a separate tick procedure once the animation is complete.
                capability.pistol_anim = 2.0;
                capability.syncPlayerVariables(entity);
            });
        }
    }
}