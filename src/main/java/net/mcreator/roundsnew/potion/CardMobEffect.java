package net.mcreator.roundsnew.potion;

import net.mcreator.roundsnew.procedures.RundomcardsProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class CardMobEffect extends MobEffect {
   public CardMobEffect() {
      super(MobEffectCategory.NEUTRAL, -1);
   }

   public String getDescriptionId() {
      return "effect.rounds_new.card";
   }

   public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      RundomcardsProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
