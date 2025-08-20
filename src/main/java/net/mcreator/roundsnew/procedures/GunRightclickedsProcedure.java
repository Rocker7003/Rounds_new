package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.init.RoundsNewModEntities;
import net.mcreator.roundsnew.init.RoundsNewModParticleTypes;
import net.mcreator.roundsnew.item.GunItem;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class GunRightclickedsProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null) {
            return;
        }

        RoundsNewModVariables.PlayerVariables playerVars = entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new RoundsNewModVariables.PlayerVariables());

        if (entity.getPersistentData().getDouble("diss") <= 0.0 || playerVars.card13 > 0.0) {
            if (entity.getPersistentData().getDouble("ammo") > 0.0) {
                if (entity instanceof Player _player) {
                    _player.getCooldowns().addCooldown(itemstack.getItem(), (int) playerVars.atks);
                }

                entity.getPersistentData().putDouble("diss", playerVars.atks);

                if (playerVars.card13 > 0.0) {
                    if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType) RoundsNewModParticleTypes.A.get(), entity.getX(), entity.getY(), entity.getZ(), 45, 1.0, 2.0, 1.0, 1.0);
                    }

                    if (entity instanceof Player _player) {
                        _player.getCooldowns().addCooldown(itemstack.getItem(), 1);
                    }

                    entity.getPersistentData().putDouble("diss", 1.0);
                    if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > playerVars.card13) {
                        if (entity instanceof LivingEntity _entity) {
                            _entity.setHealth((float) ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F) - playerVars.card13));
                        }
                        entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 0.1F);
                    }
                }

                entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.pistol_anim = 1.0;
                    capability.syncPlayerVariables(entity);
                });

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = ((EntityType) RoundsNewModEntities.BULLET.get()).spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                if (world instanceof Level _levelx) {
                    if (!_levelx.isClientSide()) {
                        _levelx.playSound(null, BlockPos.containing(x, y, z),
                                ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("rounds_new:shoot")), SoundSource.PLAYERS, 1.0F, 1.0F);
                    } else {
                        _levelx.playLocalSound(x, y, z,
                                ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("rounds_new:shoot")), SoundSource.PLAYERS, 1.0F, 1.0F, false);
                    }
                }

                entity.getPersistentData().putDouble("ammo", entity.getPersistentData().getDouble("ammo") - 1.0);
                if (playerVars.bullets > 0.0) {
                    entity.getPersistentData().putDouble("bullets", playerVars.bullets);
                }

                if (entity.getPersistentData().getDouble("ammo") == 0.0 && playerVars.card35 > 0.0) {
                    entity.getPersistentData().putDouble("shield_d", 0.0);
                    BlocktabOnKeyPressedProcedure.execute(world, x, y, z, entity);
                }
            } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
                _player.displayClientMessage(Component.literal("R"), true);
            }
        }

        RoundsNewModVariables.PlayerVariables updatedPlayerVars = entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new RoundsNewModVariables.PlayerVariables());

        if (updatedPlayerVars.pistol_anim == 1.0) {
            if (itemstack.getItem() instanceof GunItem) {
                itemstack.getOrCreateTag().putString("geckoAnim", "fire");
            }

            entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.pistol_anim = 0.0;
                capability.syncPlayerVariables(entity);
            });
        }
    }
}