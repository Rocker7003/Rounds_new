package net.mcreator.roundsnew.procedures;

import java.util.Comparator;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class LeechProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }

        if (entity.getPersistentData().getDouble("leech_player") > 0.0) {
            Vec3 _center = new Vec3(x, y, z);
            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                if (entity.getPersistentData().getDouble("pl")
                        == ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .player_use
                        && entityiterator instanceof LivingEntity _entity) {
                    _entity.setHealth(
                            (float)(
                                    (_entity.getHealth())
                                            + entity.getPersistentData().getDouble("dmg") * entity.getPersistentData().getDouble("leech_player")
                            )
                    );
                }
            }
        }

        if (entity.getPersistentData().getDouble("scavenger") > 0.0) {
            Vec3 _center = new Vec3(x, y, z);
            for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                if (entity.getPersistentData().getDouble("pl")
                        == ((RoundsNewModVariables.PlayerVariables)entityiteratorx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .player_use) {
                    entityiteratorx.getPersistentData().putDouble("diss", 1.0);
                    entityiteratorx.getPersistentData()
                            .putDouble(
                                    "ammo",
                                    ((RoundsNewModVariables.PlayerVariables)entityiteratorx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                            .orElse(new RoundsNewModVariables.PlayerVariables()))
                                            .ammo
                            );
                }
            }
        }

        if (entity.getPersistentData().getDouble("brawler") > 0.0) {
            Vec3 _center = new Vec3(x, y, z);
            for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                if (entity.getPersistentData().getDouble("pl")
                        == ((RoundsNewModVariables.PlayerVariables)entityiteratorxx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .player_use
                        && ((RoundsNewModVariables.PlayerVariables)entityiteratorxx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .brawler_i
                        == 0.0) {
                    entityiteratorxx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.brawler_i = 60.0;
                        // Corrected variable from 'entityiterator' to 'entityiteratorxx'
                        capability.syncPlayerVariables(entityiteratorxx);
                    });
                }
            }
        }

        if (entity.getPersistentData().getDouble("card41") > 0.0) {
            Vec3 _center = new Vec3(x, y, z);
            for (Entity entityiteratorxxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                if (entity.getPersistentData().getDouble("pl")
                        == ((RoundsNewModVariables.PlayerVariables)entityiteratorxxx.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .player_use) {
                    entityiteratorxxx.getPersistentData().putDouble("shield_d", 20.0);
                }
            }
        }
    }
}