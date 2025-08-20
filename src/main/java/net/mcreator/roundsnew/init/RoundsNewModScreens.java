package net.mcreator.roundsnew.init;

import net.mcreator.roundsnew.client.gui.CardsselectScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class RoundsNewModScreens {
   @SubscribeEvent
   public static void clientLoad(FMLClientSetupEvent event) {
      event.enqueueWork(() -> MenuScreens.register((MenuType)RoundsNewModMenus.CARDSSELECT.get(), CardsselectScreen::new));
   }
}
