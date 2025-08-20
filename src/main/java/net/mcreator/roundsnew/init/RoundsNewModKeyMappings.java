package net.mcreator.roundsnew.init;

import net.mcreator.roundsnew.RoundsNewMod;
import net.mcreator.roundsnew.network.BlocktabMessage;
import net.mcreator.roundsnew.network.RMessage;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class RoundsNewModKeyMappings {
   public static final KeyMapping R = new KeyMapping("key.rounds_new.r", 82, "key.categories.misc") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            RoundsNewMod.PACKET_HANDLER.sendToServer(new RMessage(0, 0));
            RMessage.pressAction(Minecraft.getInstance().player, 0, 0);
         }

         this.isDownOld = isDown;
      }
   };
   public static final KeyMapping BLOCKTAB = new KeyMapping("key.rounds_new.blocktab", 258, "key.categories.misc") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            RoundsNewMod.PACKET_HANDLER.sendToServer(new BlocktabMessage(0, 0));
            BlocktabMessage.pressAction(Minecraft.getInstance().player, 0, 0);
         }

         this.isDownOld = isDown;
      }
   };

   @SubscribeEvent
   public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
      event.register(R);
      event.register(BLOCKTAB);
   }

   @EventBusSubscriber({Dist.CLIENT})
   public static class KeyEventListener {
      @SubscribeEvent
      public static void onClientTick(ClientTickEvent event) {
         if (Minecraft.getInstance().screen == null) {
            RoundsNewModKeyMappings.R.consumeClick();
            RoundsNewModKeyMappings.BLOCKTAB.consumeClick();
         }
      }
   }
}
