package net.mcreator.roundsnew.procedures;

import java.util.Comparator;
import net.mcreator.roundsnew.entity.BulletEntity;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BulletOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.0), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiterator instanceof Player) {
               entity.getPersistentData()
                  .putDouble(
                     "barage",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .barage
                  );
               entity.teleportTo(
                  entityiterator.getX() + entityiterator.getLookAngle().x, entityiterator.getY() + 1.5, entityiterator.getZ() + entityiterator.getLookAngle().z
               );
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection
                     .teleport(
                        entityiterator.getX() + entityiterator.getLookAngle().x,
                        entityiterator.getY() + 1.5,
                        entityiterator.getZ() + entityiterator.getLookAngle().z,
                        entity.getYRot(),
                        entity.getXRot()
                     );
               }

               entity.setYRot(entityiterator.getYRot());
               entity.setXRot(entityiterator.getXRot());
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity _entity) {
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               entity.getPersistentData()
                  .putDouble(
                     "pl",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .player_use
                  );
               entity.getPersistentData()
                  .putDouble(
                     "dmg",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .dmg
                  );
               entity.getPersistentData()
                  .putDouble(
                     "bullet_speed",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .bullet_speed
                  );
               entity.getPersistentData()
                  .putDouble(
                     "big_bullet",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .big_bullet
                  );
               entity.getPersistentData()
                  .putDouble(
                     "duzzle",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .duzzle
                  );
               entity.getPersistentData()
                  .putDouble(
                     "scavenger",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .scavenger
                  );
               entity.getPersistentData()
                  .putDouble(
                     "cold",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .cold
                  );
               entity.getPersistentData()
                  .putDouble(
                     "pois",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .poison
                  );
               entity.getPersistentData()
                  .putDouble(
                     "parazit",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .parazit
                  );
               entity.getPersistentData()
                  .putDouble(
                     "card41",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .card41
                  );
               entity.getPersistentData()
                  .putDouble(
                     "tg_b",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .tg_bounce
                  );
               entity.getPersistentData()
                  .putDouble(
                     "toxic",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .toxic
                  );
               entity.getPersistentData()
                  .putDouble(
                     "grow",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .grow
                  );
               entity.getPersistentData()
                  .putDouble(
                     "brawler",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .brawler
                  );
               entity.getPersistentData()
                  .putDouble(
                     "truster",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .truster
                  );
               entity.getPersistentData()
                  .putDouble(
                     "leech_player",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .leech_player
                  );
               entity.getPersistentData()
                  .putDouble(
                     "bomb_bullet",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .bomb_bullet
                  );
               entity.getPersistentData()
                  .putDouble(
                     "trickster",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .card37
                  );
               entity.getPersistentData()
                  .putDouble(
                     "explode_bullets",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .explode_bullets
                  );
               entity.getPersistentData()
                  .putDouble(
                     "homing",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .homing
                  );
               if (entity.getPersistentData().getDouble("barage") >= 1.0) {
                  if (Math.random() < 0.5) {
                     entity.getPersistentData().putDouble("barage", Math.random() * 10.0);
                  } else {
                     entity.getPersistentData().putDouble("barage", Math.random() * -10.0);
                  }

                  entity.setYRot((float)((double)entityiterator.getYRot() + entity.getPersistentData().getDouble("barage")));
                  entity.setXRot((float)((double)entityiterator.getXRot() + entity.getPersistentData().getDouble("barage")));
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               }

               if (((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new RoundsNewModVariables.PlayerVariables()))
                     .empower_charge
                  >= 1.0) {
                  entity.getPersistentData()
                     .putDouble(
                        "dmg",
                        ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new RoundsNewModVariables.PlayerVariables()))
                              .dmg
                           * (
                              ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new RoundsNewModVariables.PlayerVariables()))
                                    .empower_charge
                                 + 1.0
                           )
                     );
                  entity.getPersistentData()
                     .putDouble(
                        "bullet_speed",
                        ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new RoundsNewModVariables.PlayerVariables()))
                              .bullet_speed
                           * 1.0
                     );
                  entity.getPersistentData()
                     .putDouble(
                        "empower",
                        ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new RoundsNewModVariables.PlayerVariables()))
                           .empower_charge
                     );
                  double _setval = 0.0;
                  entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.empower_charge = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
               }

               if (((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new RoundsNewModVariables.PlayerVariables()))
                     .bounce_pl
                  >= 1.0) {
                  entity.getPersistentData()
                     .putDouble(
                        "bounce",
                        ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new RoundsNewModVariables.PlayerVariables()))
                           .bounce_pl
                     );
                  entity.getPersistentData().putDouble("bounce_d", 0.0);
               }

               entity.getPersistentData()
                  .putDouble(
                     "atkr",
                     ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new RoundsNewModVariables.PlayerVariables()))
                        .atkr
                  );
               entity.getPersistentData().putDouble("yaw", (double)entityiterator.getYRot() + entity.getPersistentData().getDouble("barage"));
               entity.getPersistentData().putDouble("pitch", (double)entityiterator.getXRot());
               entity.getPersistentData().putDouble("ready", 1.0);
               if ((entity.getPersistentData().getDouble("pois") >= 1.0 || entity.getPersistentData().getDouble("toxic") >= 1.0)
                  && entity instanceof BulletEntity animatable) {
                  animatable.setTexture("poison");
               }

               if (entity.getPersistentData().getDouble("cold") >= 1.0 && entity instanceof BulletEntity animatable) {
                  animatable.setTexture("cold");
               }

               if (entity.getPersistentData().getDouble("duzzle") >= 1.0 && entity instanceof BulletEntity animatable) {
                  animatable.setTexture("duzle");
               }

               if (entity.getPersistentData().getDouble("cold") >= 1.0
                  && (entity.getPersistentData().getDouble("pois") >= 1.0 || entity.getPersistentData().getDouble("toxic") >= 1.0)
                  && entity instanceof BulletEntity animatable) {
                  animatable.setTexture("cold_green");
               }

               if (entity.getPersistentData().getDouble("parazit") >= 1.0 && entity instanceof BulletEntity animatable) {
                  animatable.setTexture("parazit");
               }

               if (entity.getPersistentData().getDouble("empower") >= 1.0 && entity instanceof BulletEntity animatable) {
                  animatable.setTexture("white");
               }
               break;
            }
         }
      }
   }
}
