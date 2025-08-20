package net.mcreator.roundsnew.procedures;

import java.util.Comparator;
import net.mcreator.roundsnew.init.RoundsNewModBlocks;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BlockjoinredUpdateTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if ((new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
         }
      }).getValue(world, BlockPos.containing(x, y, z), "t") == 20.0) {
         if (!world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putDouble("t", 0.0);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.5), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if ((new Object() {
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
               .checkGamemode(entityiterator)) {
               if (((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .team
                     == 1.0
                  || ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .team
                     == 2.0
                  || ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .team
                     == 3.0
                  || ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .team
                     == 4.0) {
                  if (((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .team
                     == 1.0) {
                     RoundsNewModVariables.MapVariables.get(world).card_red--;
                     RoundsNewModVariables.MapVariables.get(world).syncData(world);
                     double _setval = 0.0;
                     entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.team = _setval;
                        capability.syncPlayerVariables(entityiterator);
                     });
                  }

                  if (((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .team
                     == 2.0) {
                     RoundsNewModVariables.MapVariables.get(world).card_green--;
                     RoundsNewModVariables.MapVariables.get(world).syncData(world);
                     double _setval = 0.0;
                     entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.team = _setval;
                        capability.syncPlayerVariables(entityiterator);
                     });
                  }

                  if (((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .team
                     == 3.0) {
                     RoundsNewModVariables.MapVariables.get(world).card_yellow--;
                     RoundsNewModVariables.MapVariables.get(world).syncData(world);
                     double _setval = 0.0;
                     entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.team = _setval;
                        capability.syncPlayerVariables(entityiterator);
                     });
                  }

                  if (((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .team
                     == 4.0) {
                     RoundsNewModVariables.MapVariables.get(world).card_blue--;
                     RoundsNewModVariables.MapVariables.get(world).syncData(world);
                     double _setval = 0.0;
                     entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.team = _setval;
                        capability.syncPlayerVariables(entityiterator);
                     });
                  }
               }

               if (RoundsNewModBlocks.BLOCKJOINRED.get() == world.getBlockState(BlockPos.containing(x, y, z)).getBlock()
                  && ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .team
                     == 0.0) {
                  double _setval = 1.0;
                  entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.team = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
                  RoundsNewModVariables.MapVariables.get(world).card_red++;
                  RoundsNewModVariables.MapVariables.get(world).syncData(world);
                  if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                     entityiterator.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                              CommandSource.NULL,
                              entityiterator.position(),
                              entityiterator.getRotationVector(),
                              entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null,
                              4,
                              entityiterator.getName().getString(),
                              entityiterator.getDisplayName(),
                              entityiterator.level().getServer(),
                              entityiterator
                           ),
                           "/team join 1 @s"
                        );
                  }
               }

               if (RoundsNewModBlocks.BLOCKJOINGREEN.get() == world.getBlockState(BlockPos.containing(x, y, z)).getBlock()
                  && ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .team
                     == 0.0) {
                  double _setval = 2.0;
                  entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.team = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
                  RoundsNewModVariables.MapVariables.get(world).card_green++;
                  RoundsNewModVariables.MapVariables.get(world).syncData(world);
                  if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                     entityiterator.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                              CommandSource.NULL,
                              entityiterator.position(),
                              entityiterator.getRotationVector(),
                              entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null,
                              4,
                              entityiterator.getName().getString(),
                              entityiterator.getDisplayName(),
                              entityiterator.level().getServer(),
                              entityiterator
                           ),
                           "/team join 2 @s"
                        );
                  }
               }

               if (RoundsNewModBlocks.BLOCKJOINYELLOW.get() == world.getBlockState(BlockPos.containing(x, y, z)).getBlock()
                  && ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .team
                     == 0.0) {
                  double _setval = 3.0;
                  entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.team = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
                  RoundsNewModVariables.MapVariables.get(world).card_yellow++;
                  RoundsNewModVariables.MapVariables.get(world).syncData(world);
                  if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                     entityiterator.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                              CommandSource.NULL,
                              entityiterator.position(),
                              entityiterator.getRotationVector(),
                              entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null,
                              4,
                              entityiterator.getName().getString(),
                              entityiterator.getDisplayName(),
                              entityiterator.level().getServer(),
                              entityiterator
                           ),
                           "/team join 3 @s"
                        );
                  }
               }

               if (RoundsNewModBlocks.BLOCKJOINBLUE.get() == world.getBlockState(BlockPos.containing(x, y, z)).getBlock()
                  && ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .team
                     == 0.0) {
                  double _setval = 4.0;
                  entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.team = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
                  RoundsNewModVariables.MapVariables.get(world).card_blue++;
                  RoundsNewModVariables.MapVariables.get(world).syncData(world);
                  if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                     entityiterator.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                              CommandSource.NULL,
                              entityiterator.position(),
                              entityiterator.getRotationVector(),
                              entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null,
                              4,
                              entityiterator.getName().getString(),
                              entityiterator.getDisplayName(),
                              entityiterator.level().getServer(),
                              entityiterator
                           ),
                           "/team join 4 @s"
                        );
                  }
               }
            } else if (entityiterator instanceof ServerPlayer _player) {
               _player.setGameMode(GameType.ADVENTURE);
            }
         }
      } else if (!world.isClientSide()) {
         BlockPos _bpx = BlockPos.containing(x, y, z);
         BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
         BlockState _bsx = world.getBlockState(_bpx);
         if (_blockEntityx != null) {
            _blockEntityx.getPersistentData().putDouble("t", (new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
               }
            }).getValue(world, BlockPos.containing(x, y, z), "t") + 1.0);
         }

         if (world instanceof Level _level) {
            _level.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
         }
      }
   }
}
