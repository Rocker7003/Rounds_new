package net.mcreator.roundsnew.procedures;

import javax.annotation.Nullable;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerLeaveProcedure {
   @SubscribeEvent
   public static void onPlayerLoggedOut(PlayerLoggedOutEvent event) {
      execute(event);
   }

   public static void execute() {
      execute(null);
   }

   private static void execute(@Nullable Event event) {
   }
}
