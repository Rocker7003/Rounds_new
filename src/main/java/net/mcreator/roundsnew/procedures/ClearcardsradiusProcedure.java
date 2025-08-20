package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.init.RoundsNewModMobEffects;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class ClearcardsradiusProcedure {
    public static void execute(LevelAccessor world) {
        RoundsNewModVariables.MapVariables.get(world).plw = 0.0;
        RoundsNewModVariables.MapVariables.get(world).syncData(world);

        // Iterate directly over the list of players provided by the world object.
        for (Entity entityiterator : world.players()) {
            if (entityiterator instanceof LivingEntity _entity) {
                if (!_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance((MobEffect)RoundsNewModMobEffects.RELOAD.get(), 1, 1, false, false));
                }
            }
        }
    }
}