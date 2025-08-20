package net.mcreator.roundsnew.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class RoundsNewModTabs {
   public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "rounds_new");

   @SubscribeEvent
   public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
      if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
         tabData.accept((ItemLike)RoundsNewModItems.BULLET_SPAWN_EGG.get());
         tabData.accept((ItemLike)RoundsNewModItems.GUN.get());
         tabData.accept((ItemLike)RoundsNewModItems.BOMB_SPAWN_EGG.get());
         tabData.accept((ItemLike)RoundsNewModItems.RINGHEAL_SPAWN_EGG.get());
         tabData.accept((ItemLike)RoundsNewModItems.BOMBSHIELD_SPAWN_EGG.get());
         tabData.accept((ItemLike)RoundsNewModItems.RINGTOXIC_SPAWN_EGG.get());
      }
   }
}
