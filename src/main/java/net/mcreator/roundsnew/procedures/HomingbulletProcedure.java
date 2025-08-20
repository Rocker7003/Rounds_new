package net.mcreator.roundsnew.procedures;

import java.util.Comparator;
import net.mcreator.roundsnew.init.RoundsNewModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class HomingbulletProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double tech_yaw_y = 0.0;
         double tech_yaw_z = 0.0;
         double tech_yaw_x = 0.0;
         double s = 0.0;
         s = 0.0;
         entity.getPersistentData().putDouble("yawes", (double)entity.getYRot());

         for (int index0 = 0; index0 < 25; index0++) {
            entity.setYRot((float)((double)entity.getYRot() - entity.getPersistentData().getDouble("homing")));
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

         for (int index1 = 0; index1 < 50; index1++) {
            entity.setYRot((float)((double)entity.getYRot() + entity.getPersistentData().getDouble("homing")));
            entity.setXRot(entity.getXRot());
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity _entity) {
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            s++;
            tech_yaw_x = entity.getX();
            tech_yaw_y = entity.getY();
            tech_yaw_z = entity.getZ();

            for (int index2 = 0; index2 < 20; index2++) {
               tech_yaw_x += entity.getLookAngle().x / 1.0;
               tech_yaw_y += entity.getLookAngle().y / 1.0;
               tech_yaw_z += entity.getLookAngle().z / 1.0;
               if ((s == 1.0 || s == 45.0) && world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)RoundsNewModParticleTypes.S.get(), tech_yaw_x, tech_yaw_y, tech_yaw_z, 1, 0.001, 0.001, 0.001, 0.0);
               }

               Vec3 _center = new Vec3(tech_yaw_x, tech_yaw_y, tech_yaw_z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof Player
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
                        .checkGamemode(entityiterator)) {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles(
                           (SimpleParticleType)RoundsNewModParticleTypes.S.get(), tech_yaw_x, tech_yaw_y, tech_yaw_z, 1, 0.001, 0.001, 0.001, 0.0
                        );
                     }

                     entity.getPersistentData().putDouble("pl", 0.0);
                     entity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY() + 1.0, entityiterator.getZ()));
                     entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
                     entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
                     entity.getPersistentData().putDouble("drop", 0.0);
                  }
               }
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
   }
}
