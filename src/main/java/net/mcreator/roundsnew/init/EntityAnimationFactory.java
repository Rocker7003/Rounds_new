package net.mcreator.roundsnew.init;

import net.mcreator.roundsnew.entity.BombEntity;
import net.mcreator.roundsnew.entity.BombshieldEntity;
import net.mcreator.roundsnew.entity.BulletEntity;
import net.mcreator.roundsnew.entity.RinghealEntity;
import net.mcreator.roundsnew.entity.RingtoxicEntity;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class EntityAnimationFactory {
   @SubscribeEvent
   public static void onEntityTick(LivingTickEvent event) {
      if (event != null && event.getEntity() != null) {
         if (event.getEntity() instanceof BulletEntity syncable) {
            String animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         if (event.getEntity() instanceof BombEntity syncablex) {
            String animation = syncablex.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncablex.setAnimation("undefined");
               syncablex.animationprocedure = animation;
            }
         }

         if (event.getEntity() instanceof RinghealEntity syncablexx) {
            String animation = syncablexx.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncablexx.setAnimation("undefined");
               syncablexx.animationprocedure = animation;
            }
         }

         if (event.getEntity() instanceof BombshieldEntity syncablexxx) {
            String animation = syncablexxx.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncablexxx.setAnimation("undefined");
               syncablexxx.animationprocedure = animation;
            }
         }

         if (event.getEntity() instanceof RingtoxicEntity syncablexxxx) {
            String animation = syncablexxxx.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncablexxxx.setAnimation("undefined");
               syncablexxxx.animationprocedure = animation;
            }
         }
      }
   }
}
