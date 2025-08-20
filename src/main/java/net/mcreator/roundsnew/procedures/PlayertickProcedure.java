package net.mcreator.roundsnew.procedures;

import io.netty.buffer.Unpooled;
import java.util.Comparator;
import javax.annotation.Nullable;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.mcreator.roundsnew.world.inventory.CardsselectMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class PlayertickProcedure {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent event) {
        if (event.phase == Phase.END) {
            execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }

        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 5, 10, false, false));
            _entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 5, 10, false, false));
        }

        RoundsNewModVariables.PlayerVariables playerVars = entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new RoundsNewModVariables.PlayerVariables());

        if (playerVars.card_open == 1.0 && (!(entity instanceof Player _plr) || !(_plr.containerMenu instanceof CardsselectMenu)) && entity instanceof ServerPlayer _ent) {
            final BlockPos _bpos = BlockPos.containing(x, y, z);
            NetworkHooks.openScreen(_ent, new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.literal("Cardsselect");
                }

                @Override
                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                    return new CardsselectMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                }
            }, _bpos);
        }

        if (playerVars.player_use == 1.0) {
            UltmProcedure.execute(world, x, y, z);
            MusictickProcedure.execute(world, x, y, z);
        }

        RoundsNewModVariables.MapVariables mapVars = RoundsNewModVariables.MapVariables.get(world);
        if (mapVars.game_start) {
            entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.blue_w = mapVars.blue_pl;
                capability.green_w = mapVars.green_pl;
                capability.red_w = mapVars.red_pl;
                capability.yellow_w = mapVars.yellow_pl;
                capability.syncPlayerVariables(entity);
            });
        }

        boolean isAdventureMode = (new Object() {
            public boolean checkGamemode(Entity _ent) {
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                    return Minecraft.getInstance().getConnection() != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                            && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
                }
                return false;
            }
        }).checkGamemode(entity);

        if (isAdventureMode) {
            if (mapVars.pause) {
                entity.getPersistentData().putDouble("shield_d", 0.0);
            }

            if (entity.getPersistentData().getDouble("shield_d") > 0.0) {
                entity.getPersistentData().putDouble("shield_d", entity.getPersistentData().getDouble("shield_d") - 1.0);
                if (entity.getPersistentData().getDouble("shield_d") == 0.0) {
                    ShieldupsProcedure.execute(world, entity);
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.respawn_anchor.deplete")), SoundSource.PLAYERS, 1.0F, 2.0F);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.respawn_anchor.deplete")), SoundSource.PLAYERS, 1.0F, 2.0F, false);
                        }
                    }
                }
            }
        }

        if (mapVars.game_start) {
            if (mapVars.pause) {
                if (entity instanceof LivingEntity _entity) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 60, 99, false, false));
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 3, false, false));
                }
                entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.dark = 0.0;
                    capability.poison_lvl = 0.0;
                    capability.duzzle_lvl = 0.0;
                    capability.cold_lvl = 0.0;
                    capability.parazit_lvl = 0.0;
                    capability.phenix_lv = capability.phenix;
                    capability.truster_lvl = 0.0;
                    capability.phenix_tick = 0.0;
                    capability.Super_nova_tick = 0.0;
                    capability.syncPlayerVariables(entity);
                });
            } else if (isAdventureMode) {
                BurstloadProcedure.execute(world, x, y, z, entity);
                RelapseProcedure.execute();
                DarkstrengProcedure.execute(world, x, y, z, entity);
                Card9tickProcedure.execute(world, x, y, z, entity);

                if (playerVars.hp < 1.0) {
                    entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.hp = 1.0;
                        capability.syncPlayerVariables(entity);
                    });
                }

                if (entity.getPersistentData().getDouble("shield") > 0.0) {
                    ShieldworkProcedure.execute(world, entity);
                    entity.getPersistentData().putDouble("shield", entity.getPersistentData().getDouble("shield") - 1.0);
                }

                if (entity.getPersistentData().getDouble("dark_charge") > 0.0) {
                    entity.getPersistentData().putDouble("dark_charge", entity.getPersistentData().getDouble("dark_charge") - 1.0);
                    if (entity.getPersistentData().getDouble("dark_charges") >= 10.0) {
                        TabuseProcedure.execute(world, x, y, z, entity);
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.respawn_anchor.deplete")), SoundSource.PLAYERS, 1.0F, 2.0F);
                            } else {
                                _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.respawn_anchor.deplete")), SoundSource.PLAYERS, 1.0F, 2.0F, false);
                            }
                        }
                        entity.getPersistentData().putDouble("shield", 10.0);
                        entity.getPersistentData().putDouble("dark_charges", 0.0);
                    } else {
                        entity.getPersistentData().putDouble("dark_charges", entity.getPersistentData().getDouble("dark_charges") + 1.0);
                    }
                }

                if (entity.getPersistentData().getDouble("crd17") > 0.0) entity.getPersistentData().putDouble("crd17", entity.getPersistentData().getDouble("crd17") - 1.0);
                if (entity.getPersistentData().getDouble("nova") > 0.0) entity.getPersistentData().putDouble("nova", entity.getPersistentData().getDouble("nova") - 1.0);
                if (entity.getPersistentData().getDouble("powerover") > 0.0) entity.getPersistentData().putDouble("powerover", entity.getPersistentData().getDouble("powerover") - 1.0);
                if (entity.getPersistentData().getDouble("shock") > 0.0) entity.getPersistentData().putDouble("shock", entity.getPersistentData().getDouble("shock") - 1.0);
                if (entity.getPersistentData().getDouble("crd9") > 0.0) entity.getPersistentData().putDouble("crd9", entity.getPersistentData().getDouble("crd9") - 1.0);
                if (entity.getPersistentData().getDouble("diss") > 0.0) entity.getPersistentData().putDouble("diss", entity.getPersistentData().getDouble("diss") - 1.0);
                if (entity.getPersistentData().getDouble("refr") > 0.0) entity.getPersistentData().putDouble("refr", entity.getPersistentData().getDouble("refr") - 1.0);

                if (playerVars.poison_lvl > 0.0) {
                    if (entity.getPersistentData().getDouble("poisd") >= 15.0) {
                        entity.getPersistentData().putDouble("poisd", 0.0);
                        if (entity.isAlive()) {
                            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SLIME_BLOCK.defaultBlockState()));
                            if ((entity instanceof LivingEntity lv ? lv.getHealth() : -1.0F) <= playerVars.poison_lvl) {
                                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 99999.0F);
                            } else {
                                if (entity instanceof LivingEntity lv) lv.setHealth(lv.getHealth() - (float)playerVars.poison_lvl);
                                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 0.1F);
                            }
                        }
                        entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.poison_lvl -= 1.0;
                            capability.syncPlayerVariables(entity);
                        });
                    } else {
                        entity.getPersistentData().putDouble("poisd", entity.getPersistentData().getDouble("poisd") + 1.0);
                    }
                    double poisd = entity.getPersistentData().getDouble("poisd");
                    if ((poisd == 0.0 || poisd == 5.0 || poisd == 10.0 || poisd == 15.0) && entity instanceof LivingEntity _entity) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.POISON, 5, 0, false, true));
                    }
                }

                if (playerVars.truster_lvl > 0.0) {
                    for (int i = 0; i < (int)playerVars.truster_lvl; i++) {
                        if (world instanceof ServerLevel _level) {
                            _level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, (int)playerVars.truster_lvl, 0.2, 0.2, 0.2, 0.0);
                        }
                        entity.setDeltaMovement(entity.getDeltaMovement().add(entity.getLookAngle().scale(-0.04).x, entity.getLookAngle().scale(-0.06).y, entity.getLookAngle().scale(-0.04).z));
                    }
                    if (entity.getPersistentData().getDouble("trusd") >= 15.0) {
                        entity.getPersistentData().putDouble("trusd", 0.0);
                        entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.truster_lvl -= 1.0;
                            capability.syncPlayerVariables(entity);
                        });
                    } else {
                        entity.getPersistentData().putDouble("trusd", entity.getPersistentData().getDouble("trusd") + 1.0);
                    }
                }

                if (playerVars.Super_nova_tick > 0.0) {
                    if (playerVars.Super_nova_tick == 60.0 && world instanceof Level _level) {
                        if (!_level.isClientSide()) _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.warden.sonic_charge")), SoundSource.PLAYERS, 3.0F, 0.0F);
                        else _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.warden.sonic_charge")), SoundSource.PLAYERS, 3.0F, 0.0F, false);
                    }
                    if (playerVars.Super_nova_tick == 1.0) {
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.warden.sonic_boom")), SoundSource.PLAYERS, 2.0F, 1.0F);
                            else _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.warden.sonic_boom")), SoundSource.PLAYERS, 2.0F, 1.0F, false);
                        }
                        ExplodeNovaProcedure.execute(world, entity);
                    }
                    SupernovatickProcedure.execute();
                    Supernovatick2Procedure.execute(world, entity);
                    entity.getPersistentData().putDouble("h_b", entity.getPersistentData().getDouble("h_b") - 0.1);
                    entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.Super_nova_tick -= 1.0;
                        capability.syncPlayerVariables(entity);
                    });
                }

                if (playerVars.phenix_tick > 0.0) {
                    if (playerVars.phenix_tick == 20.0 && world instanceof Level _level) {
                        if (!_level.isClientSide()) _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("item.totem.use")), SoundSource.PLAYERS, 1.0F, 0.8F);
                        else _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("item.totem.use")), SoundSource.PLAYERS, 1.0F, 0.8F, false);
                    }
                    PhenixparticleProcedure.execute(world, entity);
                    Phenixparticle2Procedure.execute(world, entity);
                    entity.getPersistentData().putDouble("h_ph", entity.getPersistentData().getDouble("h_ph") + 9.0);
                    entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.phenix_tick -= 1.0;
                        capability.syncPlayerVariables(entity);
                    });
                }

                if (playerVars.brawler_i > 0.0) {
                    if (playerVars.brawler_i == 60.0 && entity instanceof LivingEntity _entity) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 60, 1, false, false));
                        _entity.setHealth(_entity.getHealth() + 4.0F);
                    }
                    BrawlerprProcedure.execute(world, entity);
                    entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.brawler_i -= 1.0;
                        capability.syncPlayerVariables(entity);
                    });
                }

                if (playerVars.cold_lvl > 0.0) {
                    if (entity instanceof LivingEntity _entity) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, (int)playerVars.cold_lvl, false, true));
                    }
                    entity.setTicksFrozen((int)playerVars.cold_lvl);
                    if (entity.getPersistentData().getDouble("coldd") >= 15.0) {
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.ICE.defaultBlockState()));
                        entity.getPersistentData().putDouble("coldd", 0.0);
                        entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.cold_lvl -= 1.0;
                            capability.syncPlayerVariables(entity);
                        });
                    } else {
                        entity.getPersistentData().putDouble("coldd", entity.getPersistentData().getDouble("coldd") + 1.0);
                    }
                }

                if (playerVars.parazit_lvl > 0.0) {
                    if (entity.getPersistentData().getDouble("parazitd") >= 10.0) {
                        entity.getPersistentData().putDouble("parazitd", 0.0);
                        if (entity.isAlive()) {
                            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.AMETHYST_BLOCK.defaultBlockState()));
                            Vec3 _center = new Vec3(x, y, z);
                            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32.0), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
                                RoundsNewModVariables.PlayerVariables iterVars = entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RoundsNewModVariables.PlayerVariables());
                                if (entity.getPersistentData().getDouble("parazit_l") == iterVars.player_use && entityiterator instanceof LivingEntity _entity) {
                                    _entity.setHealth(_entity.getHealth() + (float)(playerVars.parazit_lvl / 2.0));
                                }
                            }
                            if ((entity instanceof LivingEntity lv ? lv.getHealth() : -1.0F) <= playerVars.parazit_lvl) {
                                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 99999.0F);
                            } else {
                                if (entity instanceof LivingEntity lv) lv.setHealth(lv.getHealth() - (float)playerVars.parazit_lvl);
                                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 0.1F);
                            }
                        }
                        entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.parazit_lvl -= 1.0;
                            capability.syncPlayerVariables(entity);
                        });
                    } else {
                        entity.getPersistentData().putDouble("parazitd", entity.getPersistentData().getDouble("parazitd") + 1.0);
                    }
                }
            }
        }
    }
}