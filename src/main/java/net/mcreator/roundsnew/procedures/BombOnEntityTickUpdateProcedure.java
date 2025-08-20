package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.entity.BombEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class BombOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().getDouble("tick_boom") == 20.0) {
            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.experience_orb.pickup")),
                     SoundSource.PLAYERS,
                     0.3F,
                     1.0F
                  );
               } else {
                  _level.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.experience_orb.pickup")),
                     SoundSource.PLAYERS,
                     0.3F,
                     1.0F,
                     false
                  );
               }
            }

            if (entity instanceof BombEntity animatable) {
               animatable.setTexture("red");
            }
         }

         if (entity.getPersistentData().getDouble("tick_boom") == 10.0) {
            if (world instanceof Level _levelx) {
               if (!_levelx.isClientSide()) {
                  _levelx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.experience_orb.pickup")),
                     SoundSource.PLAYERS,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.experience_orb.pickup")),
                     SoundSource.PLAYERS,
                     0.3F,
                     1.0F,
                     false
                  );
               }
            }

            if (entity instanceof BombEntity animatable) {
               animatable.setTexture("texturebullet");
            }
         }

         if (entity.getPersistentData().getDouble("tick_boom") == 5.0) {
            if (world instanceof Level _levelxx) {
               if (!_levelxx.isClientSide()) {
                  _levelxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.experience_orb.pickup")),
                     SoundSource.PLAYERS,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.experience_orb.pickup")),
                     SoundSource.PLAYERS,
                     0.3F,
                     1.0F,
                     false
                  );
               }
            }

            if (entity instanceof BombEntity animatable) {
               animatable.setTexture("red");
            }
         }

         if (entity.getPersistentData().getDouble("tick_boom") == 1.0) {
            if (world instanceof Level _levelxxx) {
               if (!_levelxxx.isClientSide()) {
                  _levelxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.generic.explode")),
                     SoundSource.PLAYERS,
                     0.6F,
                     1.4F
                  );
               } else {
                  _levelxxx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.generic.explode")),
                     SoundSource.PLAYERS,
                     0.6F,
                     1.4F,
                     false
                  );
               }
            }

            if (world instanceof ServerLevel _levelxxxx) {
               _levelxxxx.sendParticles(ParticleTypes.ASH, entity.getX(), entity.getY(), entity.getZ(), 30, 0.4, 0.4, 0.4, 0.0);
            }

            if (entity instanceof BombEntity animatable) {
               animatable.setTexture("texturebullet");
            }

            ExplodeeasyProcedure.execute(world, x, y, z);
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

         if (entity.getPersistentData().getDouble("tick_boom") > 0.0) {
            entity.getPersistentData().putDouble("tick_boom", entity.getPersistentData().getDouble("tick_boom") - 1.0);
         }
      }
   }
}
