package net.mcreator.roundsnew.procedures;

import java.util.Comparator;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SdProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (IfplayerreadyProcedure.execute(world)) {
         ClearcardsradiusProcedure.execute(world);
         StartgameProcedure.execute(world, x, y, z);
         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "clear @a"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "give @a rounds_new:gun"
               );
         }

         RoundsNewModVariables.MapVariables.get(world).card_start_give = true;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
      } else {
         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16.0), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiterator instanceof Player) {
               Player _player = (Player)entityiterator;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("Не хватает игроков"), true);
               }
            }
         }
      }
   }
}
