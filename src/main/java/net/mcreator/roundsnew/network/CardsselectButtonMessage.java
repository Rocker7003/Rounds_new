package net.mcreator.roundsnew.network;

import java.util.HashMap;
import java.util.function.Supplier;
import net.mcreator.roundsnew.RoundsNewMod;
import net.mcreator.roundsnew.procedures.Butt1Procedure;
import net.mcreator.roundsnew.procedures.Butt2Procedure;
import net.mcreator.roundsnew.procedures.Butt3Procedure;
import net.mcreator.roundsnew.procedures.Butt4Procedure;
import net.mcreator.roundsnew.procedures.Butt5Procedure;
import net.mcreator.roundsnew.world.inventory.CardsselectMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent.Context;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class CardsselectButtonMessage {
   private final int buttonID;
   private final int x;
   private final int y;
   private final int z;

   public CardsselectButtonMessage(FriendlyByteBuf buffer) {
      this.buttonID = buffer.readInt();
      this.x = buffer.readInt();
      this.y = buffer.readInt();
      this.z = buffer.readInt();
   }

   public CardsselectButtonMessage(int buttonID, int x, int y, int z) {
      this.buttonID = buttonID;
      this.x = x;
      this.y = y;
      this.z = z;
   }

   public static void buffer(CardsselectButtonMessage message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.buttonID);
      buffer.writeInt(message.x);
      buffer.writeInt(message.y);
      buffer.writeInt(message.z);
   }

   public static void handler(CardsselectButtonMessage message, Supplier<Context> contextSupplier) {
      Context context = contextSupplier.get();
      context.enqueueWork(() -> {
         Player entity = context.getSender();
         int buttonID = message.buttonID;
         int x = message.x;
         int y = message.y;
         int z = message.z;
         handleButtonAction(entity, buttonID, x, y, z);
      });
      context.setPacketHandled(true);
   }

   public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
      Level world = entity.level();
      HashMap guistate = CardsselectMenu.guistate;
      if (world.hasChunkAt(new BlockPos(x, y, z))) {
         if (buttonID == 0) {
            Butt1Procedure.execute(world, entity);
         }

         if (buttonID == 1) {
            Butt2Procedure.execute(world, entity);
         }

         if (buttonID == 2) {
            Butt3Procedure.execute(world, entity);
         }

         if (buttonID == 3) {
            Butt4Procedure.execute(world, entity);
         }

         if (buttonID == 4) {
            Butt5Procedure.execute(world, entity);
         }
      }
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      RoundsNewMod.addNetworkMessage(
         CardsselectButtonMessage.class, CardsselectButtonMessage::buffer, CardsselectButtonMessage::new, CardsselectButtonMessage::handler
      );
   }
}
