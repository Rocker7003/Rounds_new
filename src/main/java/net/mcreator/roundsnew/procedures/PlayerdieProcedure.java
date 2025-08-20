package net.mcreator.roundsnew.procedures;

import javax.annotation.Nullable;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerdieProcedure {
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }

        RoundsNewModVariables.PlayerVariables playerVars = entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new RoundsNewModVariables.PlayerVariables());

        if (playerVars.phenix > 0.0 && playerVars.phenix_lv > 0.0) {
            // Cancel the death event to prevent the player from dying
            if (event != null && event.isCancelable()) {
                event.setCanceled(true);
            }

            if (entity instanceof LivingEntity _entity) {
                // Restore health after preventing death
                _entity.setHealth(9999.0F);
            }

            entity.getPersistentData().putDouble("shield_d", 0.0);

            // Consolidate all capability changes into a single block
            entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.phenix_tick = 20.0;
                capability.phenix_lv -= 1.0;
                capability.syncPlayerVariables(entity);
            });

            BlocktabOnKeyPressedProcedure.execute(world, x, y, z, entity);
        }
    }
}