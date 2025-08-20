package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.init.RoundsNewModBlocks;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class TeleportProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double tech_yaw_y = 0.0;
         double tech_yaw_z = 0.0;
         double tech_yaw_x = 0.0;
         tech_yaw_x = x;
         tech_yaw_y = y + 1.0;
         tech_yaw_z = z;
         if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
               _level.playSound(
                  null,
                  BlockPos.containing(x, y, z),
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.enderman.teleport")),
                  SoundSource.PLAYERS,
                  1.0F,
                  1.0F
               );
            } else {
               _level.playLocalSound(
                  x,
                  y,
                  z,
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.enderman.teleport")),
                  SoundSource.PLAYERS,
                  1.0F,
                  1.0F,
                  false
               );
            }
         }

         if (world instanceof ServerLevel _levelx) {
            _levelx.sendParticles(ParticleTypes.POOF, x, tech_yaw_y - 0.0, z, 15, 0.2, 0.2, 0.2, 0.0);
         }

         for (int index0 = 0;
            index0
                  < (int)(
                     7.0
                        * ((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new RoundsNewModVariables.PlayerVariables()))
                           .card34
                  )
               && Blocks.BLACK_CONCRETE != world.getBlockState(BlockPos.containing(tech_yaw_x, tech_yaw_y, tech_yaw_z)).getBlock()
               && RoundsNewModBlocks.BLACK.get() != world.getBlockState(BlockPos.containing(tech_yaw_x, tech_yaw_y, tech_yaw_z)).getBlock()
               && Blocks.BARRIER != world.getBlockState(BlockPos.containing(tech_yaw_x, tech_yaw_y, tech_yaw_z)).getBlock();
            index0++
         ) {
            tech_yaw_x += entity.getLookAngle().x;
            tech_yaw_y += entity.getLookAngle().y;
            tech_yaw_z += entity.getLookAngle().z;
            entity.teleportTo(tech_yaw_x, tech_yaw_y, tech_yaw_z);
            if (entity instanceof ServerPlayer _serverPlayer) {
               _serverPlayer.connection.teleport(tech_yaw_x, tech_yaw_y, tech_yaw_z, entity.getYRot(), entity.getXRot());
            }
         }
      }
   }
}
