package net.mcreator.roundsnew.procedures;

import javax.annotation.Nullable;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerrespawnProcedure {
   @SubscribeEvent
   public static void onPlayerRespawned(PlayerRespawnEvent event) {
      execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String _setval = entity.getDisplayName().getString();
         entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.player_name = _setval;
            capability.syncPlayerVariables(entity);
         });
         if (RoundsNewModVariables.MapVariables.get(world).game_start
            && !RoundsNewModVariables.MapVariables.get(world).pause
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
               .checkGamemode(entity)) {
            if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .team
               == 1.0) {
               RoundsNewModVariables.MapVariables.get(world).red--;
               RoundsNewModVariables.MapVariables.get(world).syncData(world);
               if (entity instanceof ServerPlayer _player) {
                  _player.setGameMode(GameType.SPECTATOR);
               }
            }

            if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .team
               == 2.0) {
               RoundsNewModVariables.MapVariables.get(world).green--;
               RoundsNewModVariables.MapVariables.get(world).syncData(world);
               if (entity instanceof ServerPlayer _player) {
                  _player.setGameMode(GameType.SPECTATOR);
               }
            }

            if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .team
               == 3.0) {
               RoundsNewModVariables.MapVariables.get(world).yellow--;
               RoundsNewModVariables.MapVariables.get(world).syncData(world);
               if (entity instanceof ServerPlayer _player) {
                  _player.setGameMode(GameType.SPECTATOR);
               }
            }

            if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .team
               == 4.0) {
               RoundsNewModVariables.MapVariables.get(world).blue--;
               RoundsNewModVariables.MapVariables.get(world).syncData(world);
               if (entity instanceof ServerPlayer _player) {
                  _player.setGameMode(GameType.SPECTATOR);
               }
            }

            if (RoundsNewModVariables.MapVariables.get(world).map == 1.0) {
               entity.teleportTo(-2.0, -49.0, 41.5);
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(-2.0, -49.0, 41.5, entity.getYRot(), entity.getXRot());
               }
            }

            if (RoundsNewModVariables.MapVariables.get(world).map == 2.0) {
               entity.teleportTo(-56.0, -49.0, 50.0);
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(-56.0, -49.0, 50.0, entity.getYRot(), entity.getXRot());
               }
            }

            if (RoundsNewModVariables.MapVariables.get(world).map == 3.0) {
               entity.teleportTo(51.5, -49.0, 26.5);
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(51.5, -49.0, 26.5, entity.getYRot(), entity.getXRot());
               }
            }

            if (RoundsNewModVariables.MapVariables.get(world).map == 4.0) {
               entity.teleportTo(2.5, -49.0, 87.5);
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(2.5, -49.0, 87.5, entity.getYRot(), entity.getXRot());
               }
            }

            if (RoundsNewModVariables.MapVariables.get(world).map == 5.0) {
               entity.teleportTo(6.0, -49.0, -63.0);
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(6.0, -49.0, -63.0, entity.getYRot(), entity.getXRot());
               }
            }

            if (RoundsNewModVariables.MapVariables.get(world).map == 6.0) {
               entity.teleportTo(70.0, -55.0, -63.0);
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(70.0, -55.0, -63.0, entity.getYRot(), entity.getXRot());
               }
            }

            if (RoundsNewModVariables.MapVariables.get(world).map == 7.0) {
               entity.teleportTo(-38.0, -49.0, -14.0);
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(-38.0, -49.0, -14.0, entity.getYRot(), entity.getXRot());
               }
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles(ParticleTypes.END_ROD, x, y, z, 45, 0.5, 1.0, 0.5, 0.0);
            }
         }
      }
   }
}
