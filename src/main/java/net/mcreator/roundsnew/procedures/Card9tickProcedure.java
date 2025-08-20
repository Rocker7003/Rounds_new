package net.mcreator.roundsnew.procedures;

import java.util.Comparator;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Card9tickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .card9
               > 0.0
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
            if (entity.getPersistentData().getDouble("fr_c") == 20.0) {
               entity.getPersistentData().putDouble("fr_c", 0.0);
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles(ParticleTypes.SNOWFLAKE, x, y, z, 60, 3.0, 3.0, 3.0, 0.0);
               }

               entity.getPersistentData().putDouble("crd9", 1.0);
               Vec3 _center = new Vec3(entity.getX(), entity.getY() + 1.0, entity.getZ());

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof Player && entityiterator.getPersistentData().getDouble("crd9") == 0.0) {
                     double _setval = 2.0
                        * ((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new RoundsNewModVariables.PlayerVariables()))
                           .card9;
                     entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.cold_lvl = _setval;
                        capability.syncPlayerVariables(entityiterator);
                     });
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles(ParticleTypes.ITEM_SNOWBALL, entity.getX(), entity.getY() + 1.0, entity.getZ(), 40, 0.2, 0.0, 0.2, 0.0);
                     }
                  }
               }

               entity.getPersistentData().putDouble("crd9", 0.0);
            } else {
               entity.getPersistentData().putDouble("fr_c", entity.getPersistentData().getDouble("fr_c") + 1.0);
            }
         }
      }
   }
}
