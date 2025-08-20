package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class MusictickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (RoundsNewModVariables.MapVariables.get(world).game_start) {
         if (RoundsNewModVariables.MapVariables.get(world).music_tick == 0.0) {
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "/stopsound @a weather"
                  );
            }

            if (Math.random() < 0.3) {
               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "/playsound rounds_new:sound1 weather @a -1.30 -42.00 57.86 1 1 1"
                     );
               }

               RoundsNewModVariables.MapVariables.get(world).music_tick = 6570.0;
               RoundsNewModVariables.MapVariables.get(world).syncData(world);
            } else if (Math.random() < 0.3) {
               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "/playsound rounds_new:sound2 weather @a -1.30 -42.00 57.86 1 1 1"
                     );
               }

               RoundsNewModVariables.MapVariables.get(world).music_tick = 3200.0;
               RoundsNewModVariables.MapVariables.get(world).syncData(world);
            } else if (Math.random() < 0.3) {
               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "/playsound rounds_new:sound4 weather @a -1.30 -42.00 57.86 1 1 1"
                     );
               }

               RoundsNewModVariables.MapVariables.get(world).music_tick = 5670.0;
               RoundsNewModVariables.MapVariables.get(world).syncData(world);
            } else {
               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "/playsound rounds_new:sound5 weather @a -1.30 -42.00 57.86 1 1 1"
                     );
               }

               RoundsNewModVariables.MapVariables.get(world).music_tick = 6200.0;
               RoundsNewModVariables.MapVariables.get(world).syncData(world);
            }
         } else {
            RoundsNewModVariables.MapVariables.get(world).music_tick--;
            RoundsNewModVariables.MapVariables.get(world).syncData(world);
         }
      }
   }
}
