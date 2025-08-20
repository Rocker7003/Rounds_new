package net.mcreator.roundsnew.procedures;

import java.util.Comparator;
import net.mcreator.roundsnew.entity.RinghealEntity;
import net.mcreator.roundsnew.init.RoundsNewModEntities;
import net.mcreator.roundsnew.init.RoundsNewModItems;
import net.mcreator.roundsnew.item.GunItem;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TabuseProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }

        RoundsNewModVariables.PlayerVariables playerVars = entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new RoundsNewModVariables.PlayerVariables());

        if (playerVars.card20 > 0.0) {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("rounds_new:heal")), SoundSource.PLAYERS, 2.0F, 0.9F);
                } else {
                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("rounds_new:heal")), SoundSource.PLAYERS, 2.0F, 0.9F, false);
                }
            }
            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = RoundsNewModEntities.RINGHEAL.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1.5, entity.getZ()), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                }
            }
            Vec3 _center = new Vec3(x, y, z);
            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.0), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
                if (entityiterator instanceof RinghealEntity) {
                    entityiterator.teleportTo(entity.getX(), entity.getY() + 1.5, entity.getZ());
                    if (entityiterator instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection.teleport(entity.getX(), entity.getY() + 1.5, entity.getZ(), entityiterator.getYRot(), entityiterator.getXRot());
                    }
                }
            }
        }

        if (playerVars.Super_nova > 0.0) {
            entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.Super_nova_tick = 60.0;
                capability.syncPlayerVariables(entity);
            });
            entity.getPersistentData().putDouble("h_b", 6.0);
        }

        if (playerVars.empower > 0.0) {
            entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.empower_charge = playerVars.empower;
                capability.syncPlayerVariables(entity);
            });
            ShieldupsProcedure.execute(world, entity);
        }

        if (playerVars.card34 > 0.0) {
            TeleportProcedure.execute(world, x, y, z, entity);
        }

        if (playerVars.card17 > 0.0) {
            entity.getPersistentData().putDouble("crd17", 1.0);
            Vec3 _center = new Vec3(entity.getX(), entity.getY() + 1.0, entity.getZ());
            for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.5), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
                if (entityiteratorx instanceof Player && entityiteratorx.getPersistentData().getDouble("crd17") == 0.0) {
                    final double coldLevel = 3.0 * playerVars.card17;
                    entityiteratorx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.cold_lvl = coldLevel;
                        capability.syncPlayerVariables(entityiteratorx); // Corrected variable
                    });
                    if (world instanceof ServerLevel _level) {
                        _level.sendParticles(ParticleTypes.ITEM_SNOWBALL, entity.getX(), entity.getY() + 1.0, entity.getZ(), 90, 1.0, 0.0, 1.0, 0.0);
                    }
                }
            }
        }

        if (playerVars.card_4s > 0.0) {
            entity.setDeltaMovement(new Vec3(0.0, 1.0, 0.0));
            for (int i = 0; i < (int) playerVars.card_4s; i++) {
                for (int j = 0; j < 5; j++) {
                    if (world instanceof ServerLevel _level) {
                        RoundsNewModEntities.BOMBSHIELD.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1.5, entity.getZ()), MobSpawnType.MOB_SUMMONED);
                    }
                }
            }
        }

        if (playerVars.card30 > 0.0 && (entity instanceof LivingEntity lv ? lv.getMainHandItem() : ItemStack.EMPTY).getItem() == RoundsNewModItems.GUN.get()) {
            if (entity instanceof Player _player) {
                _player.getCooldowns().addCooldown((entity instanceof LivingEntity lv ? lv.getMainHandItem() : ItemStack.EMPTY).getItem(), 1);
            }
            entity.getPersistentData().putDouble("diss", 1.0);
            entity.getPersistentData().putDouble("ammo", playerVars.ammo);

            entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.pistol_anim = 2.0;
                capability.syncPlayerVariables(entity);
            });

            ItemStack mainHandItem = entity instanceof LivingEntity lv ? lv.getMainHandItem() : ItemStack.EMPTY;
            if (mainHandItem.getItem() instanceof GunItem) {
                mainHandItem.getOrCreateTag().putString("geckoAnim", "animation.piwpaw3.reload");
            }

            entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.pistol_anim = 0.0;
                capability.syncPlayerVariables(entity);
            });
        }

        if (playerVars.Implode > 0.0) {
            if (world instanceof ServerLevel _level) {
                _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 150, 3.0, 1.0, 3.0, 1.0);
            }
            entity.getPersistentData().putDouble("implod", 1.0);
            Vec3 _center = new Vec3(entity.getX(), entity.getY() + 1.0, entity.getZ());
            for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.5), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
                if (entityiteratorxx instanceof Player && entityiteratorxx.getPersistentData().getDouble("implod") == 0.0) {
                    entityiteratorxx.getPersistentData().putDouble("dd", (double) entityiteratorxx.getYRot());
                    entityiteratorxx.getPersistentData().putDouble("ff", (double) entityiteratorxx.getXRot());
                    entityiteratorxx.lookAt(Anchor.EYES, new Vec3(x, y + 1.5, z));
                    if (world instanceof ServerLevel _level) {
                        _level.sendParticles(ParticleTypes.GLOW_SQUID_INK, entityiteratorxx.getX(), entityiteratorxx.getY() + 1.0, entityiteratorxx.getZ(), 90, 1.0, 0.0, 1.0, 0.0);
                    }
                    entityiteratorxx.setDeltaMovement(entityiteratorxx.getDeltaMovement().add(entityiteratorxx.getLookAngle()));
                    entityiteratorxx.setYRot((float) entityiteratorxx.getPersistentData().getDouble("dd"));
                    entityiteratorxx.setXRot((float) entityiteratorxx.getPersistentData().getDouble("ff"));
                    if (entityiteratorxx instanceof LivingEntity _living) {
                        _living.yBodyRot = _living.getYRot();
                        _living.yHeadRot = _living.getYRot();
                    }
                }
            }
        }
    }
}