package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.init.RoundsNewModParticleTypes;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class BlocktabOnKeyPressedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double s = 0.0;
         double tech_yaw_y = 0.0;
         double tech_yaw_z = 0.0;
         double tech_yaw_x = 0.0;
         if (!RoundsNewModVariables.MapVariables.get(world).pause
            && (new Object() {
                  public boolean checkGamemode(Entity _ent) {
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                     } else {
                        return _ent.level().isClientSide() && _ent instanceof Player _player
                           ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                              && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE
                           : false;
                     }
                  }
               })
               .checkGamemode(entity)
            && entity.getPersistentData().getDouble("shield_d") <= 0.0) {
            entity.getPersistentData().putDouble("shield", 20.0);
            entity.getPersistentData()
               .putDouble(
                  "shield_d",
                  ((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new RoundsNewModVariables.PlayerVariables()))
                     .shield_cooldawn
               );
            entity.getPersistentData().putDouble("yawes", (double)entity.getYRot());
            entity.getPersistentData().putDouble("pithcss", (double)entity.getXRot());
            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.respawn_anchor.deplete")),
                     SoundSource.PLAYERS,
                     1.0F,
                     1.5F
                  );
               } else {
                  _level.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.respawn_anchor.deplete")),
                     SoundSource.PLAYERS,
                     1.0F,
                     1.5F,
                     false
                  );
               }
            }

            entity.setYRot(entity.getYRot());
            entity.setXRot(entity.getXRot() - 90.0F);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity _entity) {
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            for (int index0 = 0; index0 < 30; index0++) {
               entity.setYRot(entity.getYRot());
               entity.setXRot(entity.getXRot() + 6.0F);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity _entity) {
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               for (int index1 = 0; index1 < 10; index1++) {
                  entity.setYRot(entity.getYRot() + 36.0F);
                  entity.setXRot(entity.getXRot());
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  if (world instanceof ServerLevel _levelx) {
                     _levelx.sendParticles(
                        (SimpleParticleType)RoundsNewModParticleTypes.W.get(),
                        entity.getX() + entity.getLookAngle().x * 1.5,
                        entity.getY() + 1.5 + entity.getLookAngle().y * 1.5,
                        entity.getZ() + entity.getLookAngle().z * 1.5,
                        1,
                        0.001,
                        0.001,
                        0.001,
                        0.0
                     );
                  }
               }

               entity.setYRot((float)entity.getPersistentData().getDouble("yawes"));
               entity.setXRot(entity.getXRot());
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity _entity) {
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }
            }

            entity.setYRot((float)entity.getPersistentData().getDouble("yawes"));
            entity.setXRot((float)entity.getPersistentData().getDouble("pithcss"));
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity _entity) {
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            TabuseProcedure.execute(world, x, y, z, entity);
         }
      }
   }
}
