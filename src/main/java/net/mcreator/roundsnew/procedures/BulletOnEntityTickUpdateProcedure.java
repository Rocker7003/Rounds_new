package net.mcreator.roundsnew.procedures;

import java.util.Comparator;
import net.mcreator.roundsnew.init.RoundsNewModEntities;
import net.mcreator.roundsnew.init.RoundsNewModParticleTypes;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BulletOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double xxd = 0.0;
            double zzd = 0.0;
            double yyd = 0.0;
            double s = 0.0;
            double tech_yaw_y = 0.0;
            double tech_yaw_z = 0.0;
            double tech_yaw_x = 0.0;
            if (world instanceof ServerLevel _level) {
                _level.sendParticles((SimpleParticleType)RoundsNewModParticleTypes.W.get(), entity.getX(), entity.getY(), entity.getZ(), 1, 0.0, 0.0, 0.0, 0.0);
            }

            if (RoundsNewModVariables.MapVariables.get(world).pause && !entity.level().isClientSide()) {
                entity.discard();
            }

            if (entity.getPersistentData().getDouble("grow") > 0.0) {
                for (int index0 = 0; index0 < (int)entity.getPersistentData().getDouble("grow"); index0++) {
                    entity.getPersistentData().putDouble("dmg", entity.getPersistentData().getDouble("dmg") + entity.getPersistentData().getDouble("dmg") * 0.05);
                }

                if (world instanceof ServerLevel _level) {
                    _level.sendParticles(ParticleTypes.END_ROD, entity.getX(), entity.getY(), entity.getZ(), 7, 0.2, 0.2, 0.2, 0.0);
                }
            }

            if (entity.getPersistentData().getDouble("moow") == 0.0) {
                entity.getPersistentData().putDouble("moow", 2.0);
                entity.setYRot((float)entity.getPersistentData().getDouble("yaw"));
                entity.setXRot((float)entity.getPersistentData().getDouble("pitch"));
                entity.setYBodyRot(entity.getYRot());
                entity.setYHeadRot(entity.getYRot());
                entity.yRotO = entity.getYRot();
                entity.xRotO = entity.getXRot();
                if (entity instanceof LivingEntity _entity) {
                    _entity.yBodyRotO = _entity.getYRot();
                    _entity.yHeadRotO = _entity.getYRot();
                }

                entity.setDeltaMovement(
                        new Vec3(
                                entity.getLookAngle().x * entity.getPersistentData().getDouble("bullet_speed"),
                                entity.getLookAngle().y * entity.getPersistentData().getDouble("bullet_speed"),
                                entity.getLookAngle().z * entity.getPersistentData().getDouble("bullet_speed")
                        )
                );
            }

            if (entity.getPersistentData().getDouble("drop") == entity.getPersistentData().getDouble("atkr")) {
                entity.setNoGravity(false);
                entity.getPersistentData().putDouble("moow", 60.0);
            } else {
                entity.getPersistentData().putDouble("drop", entity.getPersistentData().getDouble("drop") + 1.0);
            }

            if (entity.getPersistentData().getDouble("homing") > 0.0
                    && entity.getPersistentData().getDouble("homings") == 2.0
                    && entity.getPersistentData().getDouble("ready") == 1.0) {
                HomingbulletProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().getDouble("homings") < 2.0) {
                entity.getPersistentData().putDouble("homings", entity.getPersistentData().getDouble("homings") + 1.0);
            }

            if (entity.getPersistentData().getDouble("moow") > 0.0) {
                entity.getPersistentData().putDouble("moow", entity.getPersistentData().getDouble("moow") - 1.0);
            }

            if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 0.3)).canOcclude()
                    || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 0.3)).canOcclude()
                    || world.getBlockState(BlockPos.containing(entity.getX() + 0.3, entity.getY(), entity.getZ())).canOcclude()
                    || world.getBlockState(BlockPos.containing(entity.getX() - 0.3, entity.getY(), entity.getZ())).canOcclude()
                    || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 0.1, entity.getZ())).canOcclude()
                    || Blocks.BARRIER == world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 0.1, entity.getZ())).getBlock()
                    || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.1, entity.getZ())).canOcclude()) {
                if (entity.getPersistentData().getDouble("bomb_bullet") > 0.0 && world instanceof ServerLevel _level) {
                    Entity entityToSpawn = ((EntityType)RoundsNewModEntities.BOMB.get())
                            .spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                if (entity.getPersistentData().getDouble("toxic") > 0.0 && world instanceof ServerLevel _levelx) {
                    Entity entityToSpawn = ((EntityType)RoundsNewModEntities.RINGTOXIC.get())
                            .spawn(_levelx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                if (entity.getPersistentData().getDouble("bounce") >= 1.0) {
                    if (entity.getPersistentData().getDouble("bounce_d") >= entity.getPersistentData().getDouble("bounce")) {
                        if (!entity.level().isClientSide()) {
                            entity.discard();
                        }
                    } else {
                        entity.getPersistentData().putDouble("bounces", 1.0);
                        if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 0.3)).canOcclude()
                                && entity.getPersistentData().getDouble("bounces") == 1.0) {
                            entity.getPersistentData().putDouble("bounces", 0.0);
                            entity.getPersistentData().putDouble("yaw", (double)(entity.getYRot() * -1.0F + 180.0F));
                        }

                        if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 0.3)).canOcclude()
                                && entity.getPersistentData().getDouble("bounces") == 1.0) {
                            entity.getPersistentData().putDouble("bounces", 0.0);
                            entity.getPersistentData().putDouble("yaw", (double)(entity.getYRot() * -1.0F + 180.0F));
                        }

                        if (world.getBlockState(BlockPos.containing(entity.getX() + 0.3, entity.getY(), entity.getZ())).canOcclude()
                                && entity.getPersistentData().getDouble("bounces") == 1.0) {
                            entity.getPersistentData().putDouble("bounces", 0.0);
                            entity.getPersistentData().putDouble("yaw", (double)(entity.getYRot() * -1.0F));
                        }

                        if (world.getBlockState(BlockPos.containing(entity.getX() - 0.3, entity.getY(), entity.getZ())).canOcclude()
                                && entity.getPersistentData().getDouble("bounces") == 1.0) {
                            entity.getPersistentData().putDouble("bounces", 0.0);
                            entity.getPersistentData().putDouble("yaw", (double)(entity.getYRot() * -1.0F));
                        }

                        if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.1, entity.getZ())).canOcclude()
                                && entity.getPersistentData().getDouble("bounces") == 1.0) {
                            entity.getPersistentData().putDouble("bounces", 0.0);
                            entity.getPersistentData().putDouble("pitch", (double)(entity.getXRot() * -1.0F));
                            entity.getPersistentData().putDouble("moow", 5.0);
                        }

                        if ((
                                world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 0.1, entity.getZ())).canOcclude()
                                        || Blocks.BARRIER == world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 0.1, entity.getZ())).getBlock()
                        )
                                && entity.getPersistentData().getDouble("bounces") == 1.0) {
                            entity.getPersistentData().putDouble("bounces", 0.0);
                            entity.getPersistentData().putDouble("pitch", (double)(entity.getXRot() * -1.0F));
                            entity.getPersistentData().putDouble("moow", 5.0);
                        }

                        entity.setYRot((float)entity.getPersistentData().getDouble("yaw"));
                        entity.setXRot((float)entity.getPersistentData().getDouble("pitch"));
                        entity.setYBodyRot(entity.getYRot());
                        entity.setYHeadRot(entity.getYRot());
                        entity.yRotO = entity.getYRot();
                        entity.xRotO = entity.getXRot();
                        if (entity instanceof LivingEntity _entity) {
                            _entity.yBodyRotO = _entity.getYRot();
                            _entity.yHeadRotO = _entity.getYRot();
                        }

                        if (entity.getPersistentData().getDouble("tg_b") > 0.0) {
                            Vec3 _center = new Vec3(x, y, z);

                            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32.0), e -> true)
                                    .stream()
                                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                    .toList()) {
                                if (entityiterator instanceof Player) {
                                    entity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY() + 1.5, entityiterator.getZ()));
                                    entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
                                    entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
                                    entity.getPersistentData().putDouble("drop", 0.0);
                                    HominglcProcedure.execute(world, entity);
                                    entity.getPersistentData().putDouble("pl", 0.0);
                                    entity.setDeltaMovement(
                                            new Vec3(
                                                    entity.getLookAngle().x * (entity.getPersistentData().getDouble("bullet_speed") + 1.0),
                                                    entity.getLookAngle().y * (entity.getPersistentData().getDouble("bullet_speed") + 1.0),
                                                    entity.getLookAngle().z * (entity.getPersistentData().getDouble("bullet_speed") + 1.0)
                                            )
                                    );
                                    break;
                                }
                            }
                        }

                        if (entity.getPersistentData().getDouble("trickster") > 0.0) {
                            entity.getPersistentData()
                                    .putDouble("dmg", entity.getPersistentData().getDouble("dmg") + entity.getPersistentData().getDouble("dmg") * 0.8);
                            if (world instanceof ServerLevel _levelxx) {
                                _levelxx.sendParticles(ParticleTypes.END_ROD, entity.getX(), entity.getY(), entity.getZ(), 15, 0.5, 0.5, 0.5, 0.0);
                            }
                        }

                        entity.getPersistentData().putDouble("pl", 0.0);
                        entity.setDeltaMovement(
                                new Vec3(
                                        entity.getLookAngle().x * entity.getPersistentData().getDouble("bullet_speed"),
                                        entity.getLookAngle().y * entity.getPersistentData().getDouble("bullet_speed"),
                                        entity.getLookAngle().z * entity.getPersistentData().getDouble("bullet_speed")
                                )
                        );
                        entity.getPersistentData().putDouble("bounce_d", entity.getPersistentData().getDouble("bounce_d") + 1.0);
                    }
                } else {
                    if (entity.getPersistentData().getDouble("explode_bullets") > 0.0) {
                        ExplodebulletProcedure.execute(world, x, y, z, entity);
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }
                }
            }

            if (entity.getPersistentData().getDouble("bullet_speed") > 2.0) {
                xxd = entity.getX();
                yyd = entity.getY();
                zzd = entity.getZ();

                for (int index1 = 0; index1 < (int)entity.getPersistentData().getDouble("bullet_speed"); index1++) {
                    xxd += entity.getLookAngle().x / 1.0;
                    yyd += entity.getLookAngle().y / 1.0;
                    zzd += entity.getLookAngle().z / 1.0;
                    if (entity.isAlive()) {
                        Vec3 _center = new Vec3(xxd, yyd, zzd);

                        for (Entity entityiteratorx : world.getEntitiesOfClass(
                                        Entity.class, new AABB(_center, _center).inflate((entity.getPersistentData().getDouble("big_bullet") + 1.0) / 2.0), e -> true
                                )
                                .stream()
                                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                .toList()) {
                            if (entityiteratorx instanceof Player
                                    && (new Object() {
                                public boolean checkGamemode(Entity _ent) {
                                    if (_ent instanceof ServerPlayer _serverPlayer) {
                                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                                    } else {
                                        return _ent.level().isClientSide() && _ent instanceof Player _player
                                                ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                                && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                == GameType.ADVENTURE
                                                : false;
                                    }
                                }
                            })
                                    .checkGamemode(entityiteratorx)
                                    && entity.getPersistentData().getDouble("ready") == 1.0
                                    && entity.getPersistentData().getDouble("pl")
                                    != ((RoundsNewModVariables.PlayerVariables)entityiteratorx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new RoundsNewModVariables.PlayerVariables()))
                                    .player_use) {
                                if (entityiteratorx.getPersistentData().getDouble("shield") > 0.0) {
                                    entity.lookAt(
                                            Anchor.EYES,
                                            new Vec3(
                                                    entity.getX() - entity.getLookAngle().x, entity.getY() - entity.getLookAngle().y, entity.getZ() - entity.getLookAngle().z
                                            )
                                    );
                                    entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
                                    entity.getPersistentData().putDouble("drop", 0.0);
                                    entityiteratorx.getPersistentData().putDouble("shield", 10.0);
                                    world.levelEvent(
                                            2001,
                                            BlockPos.containing(entityiteratorx.getX(), entityiteratorx.getY(), entityiteratorx.getZ()),
                                            Block.getId(Blocks.GLASS.defaultBlockState())
                                    );
                                    entity.setDeltaMovement(
                                            new Vec3(
                                                    entity.getLookAngle().x * entity.getPersistentData().getDouble("bullet_speed"),
                                                    entity.getLookAngle().y * entity.getPersistentData().getDouble("bullet_speed"),
                                                    entity.getLookAngle().z * entity.getPersistentData().getDouble("bullet_speed")
                                            )
                                    );
                                } else if (entityiteratorx.isAlive()) {
                                    world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.CRIMSON_HYPHAE.defaultBlockState()));
                                    if (entity.getPersistentData().getDouble("bomb_bullet") > 0.0 && world instanceof ServerLevel) {
                                        ServerLevel _levelxx = (ServerLevel)world;
                                        Entity entityToSpawn = ((EntityType)RoundsNewModEntities.BOMB.get())
                                                .spawn(_levelxx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                                        if (entityToSpawn != null) {
                                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                        }
                                    }

                                    if (entity.getPersistentData().getDouble("toxic") > 0.0 && world instanceof ServerLevel) {
                                        ServerLevel _levelxx = (ServerLevel)world;
                                        Entity entityToSpawn = ((EntityType)RoundsNewModEntities.RINGTOXIC.get())
                                                .spawn(_levelxx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                                        if (entityToSpawn != null) {
                                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                        }
                                    }

                                    if (entity.getPersistentData().getDouble("parazit") >= 1.0) {
                                        double _setval = ((RoundsNewModVariables.PlayerVariables)entityiteratorx.getCapability(
                                                        RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                )
                                                .orElse(new RoundsNewModVariables.PlayerVariables()))
                                                .parazit_lvl
                                                + entity.getPersistentData().getDouble("parazit");
                                        entityiteratorx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                            capability.parazit_lvl = _setval;
                                            capability.syncPlayerVariables(entityiteratorx);
                                        });
                                        entityiteratorx.getPersistentData().putDouble("parazit_l", entity.getPersistentData().getDouble("pl"));
                                    }

                                    if (entity.getPersistentData().getDouble("duzzle") >= 1.0) {
                                        double _setval = ((RoundsNewModVariables.PlayerVariables)entityiteratorx.getCapability(
                                                        RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                )
                                                .orElse(new RoundsNewModVariables.PlayerVariables()))
                                                .duzzle_lvl
                                                + entity.getPersistentData().getDouble("duzzle");
                                        entityiteratorx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                            capability.duzzle_lvl = _setval;
                                            capability.syncPlayerVariables(entityiteratorx);
                                        });
                                    }

                                    if (entity.getPersistentData().getDouble("cold") >= 1.0) {
                                        double _setval = ((RoundsNewModVariables.PlayerVariables)entityiteratorx.getCapability(
                                                        RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                )
                                                .orElse(new RoundsNewModVariables.PlayerVariables()))
                                                .cold_lvl
                                                + entity.getPersistentData().getDouble("cold");
                                        entityiteratorx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                            capability.cold_lvl = _setval;
                                            capability.syncPlayerVariables(entityiteratorx);
                                        });
                                    }

                                    if (entity.getPersistentData().getDouble("truster") >= 1.0) {
                                        double _setval = ((RoundsNewModVariables.PlayerVariables)entityiteratorx.getCapability(
                                                        RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                )
                                                .orElse(new RoundsNewModVariables.PlayerVariables()))
                                                .truster_lvl
                                                + (double)Math.round(entity.getPersistentData().getDouble("truster") + entity.getPersistentData().getDouble("dmg") * 0.1);
                                        entityiteratorx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                            capability.truster_lvl = _setval;
                                            capability.syncPlayerVariables(entityiteratorx);
                                        });
                                    }

                                    if (entity.getPersistentData().getDouble("pois") >= 1.0) {
                                        double _setval = ((RoundsNewModVariables.PlayerVariables)entityiteratorx.getCapability(
                                                        RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                )
                                                .orElse(new RoundsNewModVariables.PlayerVariables()))
                                                .poison_lvl
                                                + entity.getPersistentData().getDouble("pois");
                                        entityiteratorx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                            capability.poison_lvl = _setval;
                                            capability.syncPlayerVariables(entityiteratorx);
                                        });
                                    }

                                    LeechProcedure.execute(world, x, y, z, entity);
                                    if ((double)(entityiteratorx instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)
                                            <= entity.getPersistentData().getDouble("dmg")) {
                                        entityiteratorx.hurt(
                                                new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
                                                99999.0F
                                        );
                                    } else {
                                        if (entityiteratorx instanceof LivingEntity _entity) {
                                            _entity.setHealth(
                                                    (float)(
                                                            (double)(entityiteratorx instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)
                                                                    - entity.getPersistentData().getDouble("dmg")
                                                    )
                                            );
                                        }

                                        entityiteratorx.hurt(
                                                new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 0.1F
                                        );
                                    }

                                    if (entity.getPersistentData().getDouble("explode_bullets") > 0.0) {
                                        ExplodebulletProcedure.execute(world, x, y, z, entity);
                                    }

                                    if (!entity.level().isClientSide()) {
                                        entity.discard();
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiteratorxx : world.getEntitiesOfClass(
                            Entity.class, new AABB(_center, _center).inflate((entity.getPersistentData().getDouble("big_bullet") + 1.0) / 2.0), e -> true
                    )
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                if (entityiteratorxx instanceof Player
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
                        .checkGamemode(entityiteratorxx)
                        && entity.getPersistentData().getDouble("ready") == 1.0
                        && entity.getPersistentData().getDouble("pl")
                        != ((RoundsNewModVariables.PlayerVariables)entityiteratorxx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .player_use) {
                    if (entityiteratorxx.getPersistentData().getDouble("shield") > 0.0) {
                        entity.lookAt(
                                Anchor.EYES,
                                new Vec3(entity.getX() - entity.getLookAngle().x, entity.getY() - entity.getLookAngle().y, entity.getZ() - entity.getLookAngle().z)
                        );
                        entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
                        entity.getPersistentData().putDouble("drop", 0.0);
                        entityiteratorxx.getPersistentData().putDouble("shield", 10.0);
                        world.levelEvent(
                                2001,
                                BlockPos.containing(entityiteratorxx.getX(), entityiteratorxx.getY(), entityiteratorxx.getZ()),
                                Block.getId(Blocks.GLASS.defaultBlockState())
                        );
                        entity.setDeltaMovement(
                                new Vec3(
                                        entity.getLookAngle().x * entity.getPersistentData().getDouble("bullet_speed"),
                                        entity.getLookAngle().y * entity.getPersistentData().getDouble("bullet_speed"),
                                        entity.getLookAngle().z * entity.getPersistentData().getDouble("bullet_speed")
                                )
                        );
                    } else if (entityiteratorxx.isAlive()) {
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.CRIMSON_HYPHAE.defaultBlockState()));
                        if (entity.getPersistentData().getDouble("bomb_bullet") > 0.0 && world instanceof ServerLevel) {
                            ServerLevel _levelxx = (ServerLevel)world;
                            Entity entityToSpawn = ((EntityType)RoundsNewModEntities.BOMB.get())
                                    .spawn(_levelxx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                            if (entityToSpawn != null) {
                                entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                            }
                        }

                        if (entity.getPersistentData().getDouble("toxic") > 0.0 && world instanceof ServerLevel) {
                            ServerLevel _levelxx = (ServerLevel)world;
                            Entity entityToSpawn = ((EntityType)RoundsNewModEntities.RINGTOXIC.get())
                                    .spawn(_levelxx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                            if (entityToSpawn != null) {
                                entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                            }
                        }

                        if (entity.getPersistentData().getDouble("parazit") >= 1.0) {
                            double _setval = ((RoundsNewModVariables.PlayerVariables)entityiteratorxx.getCapability(
                                            RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                    )
                                    .orElse(new RoundsNewModVariables.PlayerVariables()))
                                    .parazit_lvl
                                    + entity.getPersistentData().getDouble("parazit");
                            entityiteratorxx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.parazit_lvl = _setval;
                                capability.syncPlayerVariables(entityiteratorxx);
                            });
                            entityiteratorxx.getPersistentData().putDouble("parazit_l", entity.getPersistentData().getDouble("pl"));
                        }

                        if (entity.getPersistentData().getDouble("duzzle") >= 1.0) {
                            double _setval = ((RoundsNewModVariables.PlayerVariables)entityiteratorxx.getCapability(
                                            RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                    )
                                    .orElse(new RoundsNewModVariables.PlayerVariables()))
                                    .duzzle_lvl
                                    + entity.getPersistentData().getDouble("duzzle");
                            entityiteratorxx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.duzzle_lvl = _setval;
                                capability.syncPlayerVariables(entityiteratorxx);
                            });
                        }

                        if (entity.getPersistentData().getDouble("cold") >= 1.0) {
                            double _setval = ((RoundsNewModVariables.PlayerVariables)entityiteratorxx.getCapability(
                                            RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                    )
                                    .orElse(new RoundsNewModVariables.PlayerVariables()))
                                    .cold_lvl
                                    + entity.getPersistentData().getDouble("cold");
                            entityiteratorxx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.cold_lvl = _setval;
                                capability.syncPlayerVariables(entityiteratorxx);
                            });
                        }

                        if (entity.getPersistentData().getDouble("truster") >= 1.0) {
                            double _setval = ((RoundsNewModVariables.PlayerVariables)entityiteratorxx.getCapability(
                                            RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                    )
                                    .orElse(new RoundsNewModVariables.PlayerVariables()))
                                    .truster_lvl
                                    + (double)Math.round(entity.getPersistentData().getDouble("truster") + entity.getPersistentData().getDouble("dmg") * 0.1);
                            entityiteratorxx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.truster_lvl = _setval;
                                capability.syncPlayerVariables(entityiteratorxx);
                            });
                        }

                        if (entity.getPersistentData().getDouble("pois") >= 1.0) {
                            double _setval = ((RoundsNewModVariables.PlayerVariables)entityiteratorxx.getCapability(
                                            RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                    )
                                    .orElse(new RoundsNewModVariables.PlayerVariables()))
                                    .poison_lvl
                                    + entity.getPersistentData().getDouble("pois");
                            entityiteratorxx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.poison_lvl = _setval;
                                capability.syncPlayerVariables(entityiteratorxx);
                            });
                        }

                        LeechProcedure.execute(world, x, y, z, entity);
                        if ((double)(entityiteratorxx instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) <= entity.getPersistentData().getDouble("dmg")) {
                            entityiteratorxx.hurt(
                                    new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 99999.0F
                            );
                        } else {
                            if (entityiteratorxx instanceof LivingEntity _entity) {
                                _entity.setHealth(
                                        (float)(
                                                (double)(entityiteratorxx instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)
                                                        - entity.getPersistentData().getDouble("dmg")
                                        )
                                );
                            }

                            entityiteratorxx.hurt(
                                    new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 0.1F
                            );
                        }

                        if (entity.getPersistentData().getDouble("explode_bullets") > 0.0) {
                            ExplodebulletProcedure.execute(world, x, y, z, entity);
                        }

                        if (!entity.level().isClientSide()) {
                            entity.discard();
                        }
                    }
                }
            }
        }
    }
}