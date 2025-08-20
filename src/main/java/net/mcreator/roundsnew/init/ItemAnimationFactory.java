package net.mcreator.roundsnew.init;

import java.lang.reflect.Field;
import net.mcreator.roundsnew.item.GunItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.world.item.ArmorItem;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import software.bernie.geckolib.animatable.GeoItem;

@EventBusSubscriber
public class ItemAnimationFactory {
   public static void disableUseAnim() {
      try {
         ItemInHandRenderer renderer = Minecraft.getInstance().gameRenderer.itemInHandRenderer;
         float rot = 1.0F;
         if (renderer != null) {
            Field field = ItemInHandRenderer.class.getDeclaredField("mainHandHeight");
            field.setAccessible(true);
            field.setFloat(renderer, rot);
            Field field1 = ItemInHandRenderer.class.getDeclaredField("oMainHandHeight");
            field1.setAccessible(true);
            field1.setFloat(renderer, rot);
            Field field2 = ItemInHandRenderer.class.getDeclaredField("offHandHeight");
            field2.setAccessible(true);
            field2.setFloat(renderer, rot);
            Field field3 = ItemInHandRenderer.class.getDeclaredField("oOffHandHeight");
            field3.setAccessible(true);
            field3.setFloat(renderer, rot);
         }
      } catch (Exception var6) {
         var6.printStackTrace();
      }
   }

   @SubscribeEvent
   public static void animatedItems(PlayerTickEvent event) {
      String animation = "";
      if (event.phase == Phase.START
         && (event.player.getMainHandItem().getItem() instanceof GeoItem || event.player.getOffhandItem().getItem() instanceof GeoItem)) {
         if (!event.player.getMainHandItem().getOrCreateTag().getString("geckoAnim").equals("")
            && !(event.player.getMainHandItem().getItem() instanceof ArmorItem)) {
            animation = event.player.getMainHandItem().getOrCreateTag().getString("geckoAnim");
            event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
            if (event.player.getMainHandItem().getItem() instanceof GunItem animatable && event.player.level().isClientSide()) {
               animatable.animationprocedure = animation;
               disableUseAnim();
            }
         }

         if (!event.player.getOffhandItem().getOrCreateTag().getString("geckoAnim").equals("")
            && !(event.player.getOffhandItem().getItem() instanceof ArmorItem)) {
            animation = event.player.getOffhandItem().getOrCreateTag().getString("geckoAnim");
            event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
            if (event.player.getOffhandItem().getItem() instanceof GunItem animatable && event.player.level().isClientSide()) {
               animatable.animationprocedure = animation;
               disableUseAnim();
            }
         }
      }
   }
}
