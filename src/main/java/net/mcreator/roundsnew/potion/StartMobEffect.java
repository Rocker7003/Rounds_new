package net.mcreator.roundsnew.potion;

import net.mcreator.roundsnew.procedures.StartEffectStartedappliedProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class StartMobEffect extends MobEffect {
   public StartMobEffect() {
      super(MobEffectCategory.NEUTRAL, -1);
   }

   public String getDescriptionId() {
      return "effect.rounds_new.start";
   }

   public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      StartEffectStartedappliedProcedure.execute(entity.level(), entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
