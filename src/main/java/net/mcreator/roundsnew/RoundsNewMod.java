package net.mcreator.roundsnew;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.mcreator.roundsnew.init.RoundsNewModBlockEntities;
import net.mcreator.roundsnew.init.RoundsNewModBlocks;
import net.mcreator.roundsnew.init.RoundsNewModEntities;
import net.mcreator.roundsnew.init.RoundsNewModItems;
import net.mcreator.roundsnew.init.RoundsNewModMenus;
import net.mcreator.roundsnew.init.RoundsNewModMobEffects;
import net.mcreator.roundsnew.init.RoundsNewModParticleTypes;
import net.mcreator.roundsnew.init.RoundsNewModSounds;
import net.mcreator.roundsnew.init.RoundsNewModTabs;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.ServerTickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent.Context;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("rounds_new")
public class RoundsNewMod {
   public static final Logger LOGGER = LogManager.getLogger(RoundsNewMod.class);
   public static final String MODID = "rounds_new";
   private static final String PROTOCOL_VERSION = "1";
   public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(
      ResourceLocation.fromNamespaceAndPath("rounds_new", "rounds_new"), () -> "1", "1"::equals, "1"::equals
   );
   private static int messageID = 0;
   private static final Collection<SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

   public RoundsNewMod() {
      MinecraftForge.EVENT_BUS.register(this);
      IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
      RoundsNewModSounds.REGISTRY.register(bus);
      RoundsNewModBlocks.REGISTRY.register(bus);
      RoundsNewModBlockEntities.REGISTRY.register(bus);
      RoundsNewModItems.REGISTRY.register(bus);
      RoundsNewModEntities.REGISTRY.register(bus);
      RoundsNewModTabs.REGISTRY.register(bus);
      RoundsNewModMobEffects.REGISTRY.register(bus);
      RoundsNewModParticleTypes.REGISTRY.register(bus);
      RoundsNewModMenus.REGISTRY.register(bus);
   }

   public static <T> void addNetworkMessage(
      Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<Context>> messageConsumer
   ) {
      PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
      messageID++;
   }

   public static void queueServerWork(int tick, Runnable action) {
      workQueue.add(new SimpleEntry<>(action, tick));
   }

   @SubscribeEvent
   public void tick(ServerTickEvent event) {
      if (event.phase == Phase.END) {
         List<SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
         workQueue.forEach(work -> {
            work.setValue(work.getValue() - 1);
            if (work.getValue() == 0) {
               actions.add((SimpleEntry<Runnable, Integer>)work);
            }
         });
         actions.forEach(e -> e.getKey().run());
         workQueue.removeAll(actions);
      }
   }
}
