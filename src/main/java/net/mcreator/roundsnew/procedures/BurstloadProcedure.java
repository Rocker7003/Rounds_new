package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.init.RoundsNewModEntities;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class BurstloadProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().getDouble("bullets") > 0.0) {
            entity.getPersistentData().putDouble("bullets", entity.getPersistentData().getDouble("bullets") - 1.0);
            if (entity.getPersistentData().getDouble("ammo") > 0.0) {
               if (world instanceof ServerLevel _level) {
                  Entity entityToSpawn = ((EntityType)RoundsNewModEntities.BULLET.get()).spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (world instanceof Level _levelx) {
                  if (!_levelx.isClientSide()) {
                     _levelx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("rounds_new:shoot")),
                        SoundSource.PLAYERS,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("rounds_new:shoot")),
                        SoundSource.PLAYERS,
                        1.0F,
                        1.0F,
                        false
                     );
                  }
               }

               entity.getPersistentData().putDouble("ammo", entity.getPersistentData().getDouble("ammo") - 1.0);
               entity.getPersistentData()
                  .putDouble(
                     "diss",
                     ((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .atks
                  );
               if (entity.getPersistentData().getDouble("ammo") == 0.0
                  && ((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .card35
                     > 0.0) {
                  entity.getPersistentData().putDouble("shield_d", 0.0);
                  BlocktabOnKeyPressedProcedure.execute(world, x, y, z, entity);
               }
            }
         }
      }
   }
}
