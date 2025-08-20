package net.mcreator.roundsnew.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;

public class BlackEntityCollidesInTheBlockProcedure {
   public static void execute(final LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
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
            .checkGamemode(entity)) {
            entity.getPersistentData().putDouble("yaws", (double)entity.getYRot());
            entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
            if (entity.getPersistentData().getDouble("shield") > 0.0) {
               if ((new Object() {
                        public Direction getDirection(BlockPos pos) {
                           BlockState _bs = world.getBlockState(pos);
                           Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (property != null) {
                              Comparable var5 = _bs.getValue(property);
                              if (var5 instanceof Direction) {
                                 return (Direction)var5;
                              }
                           }

                           if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                              return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                           } else {
                              return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                 ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                 : Direction.NORTH;
                           }
                        }
                     })
                     .getDirection(BlockPos.containing(x, y, z))
                  == Direction.NORTH) {
                  entity.setYRot(180.0F);
                  entity.setXRot(entity.getXRot());
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               } else if ((new Object() {
                        public Direction getDirection(BlockPos pos) {
                           BlockState _bs = world.getBlockState(pos);
                           Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (property != null) {
                              Comparable var5 = _bs.getValue(property);
                              if (var5 instanceof Direction) {
                                 return (Direction)var5;
                              }
                           }

                           if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                              return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                           } else {
                              return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                 ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                 : Direction.NORTH;
                           }
                        }
                     })
                     .getDirection(BlockPos.containing(x, y, z))
                  == Direction.EAST) {
                  entity.setYRot(-90.0F);
                  entity.setXRot(entity.getXRot());
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               } else if ((new Object() {
                        public Direction getDirection(BlockPos pos) {
                           BlockState _bs = world.getBlockState(pos);
                           Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (property != null) {
                              Comparable var5 = _bs.getValue(property);
                              if (var5 instanceof Direction) {
                                 return (Direction)var5;
                              }
                           }

                           if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                              return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                           } else {
                              return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                 ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                 : Direction.NORTH;
                           }
                        }
                     })
                     .getDirection(BlockPos.containing(x, y, z))
                  == Direction.SOUTH) {
                  entity.setYRot(1.0F);
                  entity.setXRot(entity.getXRot());
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               } else if ((new Object() {
                        public Direction getDirection(BlockPos pos) {
                           BlockState _bs = world.getBlockState(pos);
                           Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (property != null) {
                              Comparable var5 = _bs.getValue(property);
                              if (var5 instanceof Direction) {
                                 return (Direction)var5;
                              }
                           }

                           if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                              return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                           } else {
                              return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                 ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                 : Direction.NORTH;
                           }
                        }
                     })
                     .getDirection(BlockPos.containing(x, y, z))
                  == Direction.WEST) {
                  entity.setYRot(90.0F);
                  entity.setXRot(entity.getXRot());
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               } else if ((new Object() {
                        public Direction getDirection(BlockPos pos) {
                           BlockState _bs = world.getBlockState(pos);
                           Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (property != null) {
                              Comparable var5 = _bs.getValue(property);
                              if (var5 instanceof Direction) {
                                 return (Direction)var5;
                              }
                           }

                           if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                              return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                           } else {
                              return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                 ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                 : Direction.NORTH;
                           }
                        }
                     })
                     .getDirection(BlockPos.containing(x, y, z))
                  == Direction.DOWN) {
                  entity.setYRot(entity.getYRot());
                  entity.setXRot(90.0F);
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               } else if ((new Object() {
                        public Direction getDirection(BlockPos pos) {
                           BlockState _bs = world.getBlockState(pos);
                           Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (property != null) {
                              Comparable var5 = _bs.getValue(property);
                              if (var5 instanceof Direction) {
                                 return (Direction)var5;
                              }
                           }

                           if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                              return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                           } else {
                              return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                 ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                 : Direction.NORTH;
                           }
                        }
                     })
                     .getDirection(BlockPos.containing(x, y, z))
                  == Direction.UP) {
                  entity.setYRot(entity.getYRot());
                  entity.setXRot(-90.0F);
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               }

               entity.setDeltaMovement(
                  new Vec3(
                     entity.getDeltaMovement().x() + entity.getLookAngle().x * 1.0,
                     entity.getDeltaMovement().y() + entity.getLookAngle().y * 1.0,
                     entity.getDeltaMovement().z() + entity.getLookAngle().z * 1.0
                  )
               );
            } else {
               entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 8.0F);
               world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Block.getId(Blocks.CRIMSON_HYPHAE.defaultBlockState()));
               if ((new Object() {
                        public Direction getDirection(BlockPos pos) {
                           BlockState _bs = world.getBlockState(pos);
                           Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (property != null) {
                              Comparable var5 = _bs.getValue(property);
                              if (var5 instanceof Direction) {
                                 return (Direction)var5;
                              }
                           }

                           if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                              return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                           } else {
                              return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                 ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                 : Direction.NORTH;
                           }
                        }
                     })
                     .getDirection(BlockPos.containing(x, y, z))
                  == Direction.NORTH) {
                  entity.setYRot(180.0F);
                  entity.setXRot(entity.getXRot());
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               } else if ((new Object() {
                        public Direction getDirection(BlockPos pos) {
                           BlockState _bs = world.getBlockState(pos);
                           Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (property != null) {
                              Comparable var5 = _bs.getValue(property);
                              if (var5 instanceof Direction) {
                                 return (Direction)var5;
                              }
                           }

                           if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                              return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                           } else {
                              return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                 ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                 : Direction.NORTH;
                           }
                        }
                     })
                     .getDirection(BlockPos.containing(x, y, z))
                  == Direction.EAST) {
                  entity.setYRot(-90.0F);
                  entity.setXRot(entity.getXRot());
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               } else if ((new Object() {
                        public Direction getDirection(BlockPos pos) {
                           BlockState _bs = world.getBlockState(pos);
                           Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (property != null) {
                              Comparable var5 = _bs.getValue(property);
                              if (var5 instanceof Direction) {
                                 return (Direction)var5;
                              }
                           }

                           if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                              return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                           } else {
                              return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                 ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                 : Direction.NORTH;
                           }
                        }
                     })
                     .getDirection(BlockPos.containing(x, y, z))
                  == Direction.SOUTH) {
                  entity.setYRot(1.0F);
                  entity.setXRot(entity.getXRot());
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               } else if ((new Object() {
                        public Direction getDirection(BlockPos pos) {
                           BlockState _bs = world.getBlockState(pos);
                           Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (property != null) {
                              Comparable var5 = _bs.getValue(property);
                              if (var5 instanceof Direction) {
                                 return (Direction)var5;
                              }
                           }

                           if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                              return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                           } else {
                              return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                 ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                 : Direction.NORTH;
                           }
                        }
                     })
                     .getDirection(BlockPos.containing(x, y, z))
                  == Direction.WEST) {
                  entity.setYRot(90.0F);
                  entity.setXRot(entity.getXRot());
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               } else if ((new Object() {
                        public Direction getDirection(BlockPos pos) {
                           BlockState _bs = world.getBlockState(pos);
                           Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (property != null) {
                              Comparable var5 = _bs.getValue(property);
                              if (var5 instanceof Direction) {
                                 return (Direction)var5;
                              }
                           }

                           if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                              return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                           } else {
                              return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                 ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                 : Direction.NORTH;
                           }
                        }
                     })
                     .getDirection(BlockPos.containing(x, y, z))
                  == Direction.DOWN) {
                  entity.setYRot(entity.getYRot());
                  entity.setXRot(90.0F);
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               } else if ((new Object() {
                        public Direction getDirection(BlockPos pos) {
                           BlockState _bs = world.getBlockState(pos);
                           Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (property != null) {
                              Comparable var5 = _bs.getValue(property);
                              if (var5 instanceof Direction) {
                                 return (Direction)var5;
                              }
                           }

                           if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                              return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                           } else {
                              return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                 ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                 : Direction.NORTH;
                           }
                        }
                     })
                     .getDirection(BlockPos.containing(x, y, z))
                  == Direction.UP) {
                  entity.setYRot(entity.getYRot());
                  entity.setXRot(-90.0F);
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               }

               entity.setDeltaMovement(
                  new Vec3(
                     entity.getDeltaMovement().x() + entity.getLookAngle().x * 0.5,
                     entity.getDeltaMovement().y() + entity.getLookAngle().y * 0.5,
                     entity.getDeltaMovement().z() + entity.getLookAngle().z * 0.5
                  )
               );
            }

            entity.setYRot((float)entity.getPersistentData().getDouble("yaws"));
            entity.setXRot((float)entity.getPersistentData().getDouble("pitch"));
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity _entity) {
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }
         }
      }
   }
}
