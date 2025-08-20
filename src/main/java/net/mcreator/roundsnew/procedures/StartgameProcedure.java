package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class StartgameProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      CleacomProcedure.execute(world, x, y, z);
      RoundsNewModVariables.MapVariables.get(world).pause = false;
      RoundsNewModVariables.MapVariables.get(world).syncData(world);
      RoundsNewModVariables.MapVariables.get(world).game_start = true;
      RoundsNewModVariables.MapVariables.get(world).syncData(world);
      RoundsNewModVariables.MapVariables.get(world).pl_ready = 0.0;
      RoundsNewModVariables.MapVariables.get(world).syncData(world);
      RoundsNewModVariables.MapVariables.get(world).music_tick = 0.0;
      RoundsNewModVariables.MapVariables.get(world).syncData(world);
      if (RoundsNewModVariables.MapVariables.get(world).red_pl > RoundsNewModVariables.MapVariables.get(world).rounds) {
         RoundsNewModVariables.MapVariables.get(world).game_start = false;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).pause = true;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).red_pl = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).green_pl = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).yellow_pl = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).blue_pl = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).music_tick = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "/title @a actionbar {\"text\":\"Красные выйграли\",\"color\":\"red\"}"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                        CommandSource.NULL,
                        new Vec3(x, y, RoundsNewModVariables.MapVariables.get(world).rounds),
                        Vec2.ZERO,
                        _level,
                        4,
                        "",
                        Component.literal(""),
                        _level.getServer(),
                        null
                     )
                     .withSuppressedOutput(),
                  "/playsound minecraft:entity.player.levelup block @a ~ ~ ~ 10 0.7 1"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "/tp @a 1.46 -46.88 6.53"
               );
         }

         ClearcardsradiusProcedure.execute(world);
      }

      if (RoundsNewModVariables.MapVariables.get(world).green_pl > RoundsNewModVariables.MapVariables.get(world).rounds) {
         RoundsNewModVariables.MapVariables.get(world).game_start = false;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).pause = true;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).red_pl = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).green_pl = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).yellow_pl = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).blue_pl = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).music_tick = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "/title @a actionbar {\"text\":\"Зелёные выйграли\",\"color\":\"green\"}"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "/playsound minecraft:entity.player.levelup block @a ~ ~ ~ 10 0.7 1"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "/tp @a 1.46 -46.88 6.53"
               );
         }

         ClearcardsradiusProcedure.execute(world);
      }

      if (RoundsNewModVariables.MapVariables.get(world).yellow_pl > RoundsNewModVariables.MapVariables.get(world).rounds) {
         RoundsNewModVariables.MapVariables.get(world).game_start = false;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).pause = true;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).red_pl = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).green_pl = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).yellow_pl = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).blue_pl = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).music_tick = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "/title @a actionbar {\"text\":\"Жёлтые выйграли\",\"color\":\"yellow\"}"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "/playsound minecraft:entity.player.levelup block @a ~ ~ ~ 10 0.7 1"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "/tp @a 1.46 -46.88 6.53"
               );
         }

         ClearcardsradiusProcedure.execute(world);
      }

      if (RoundsNewModVariables.MapVariables.get(world).blue_pl > RoundsNewModVariables.MapVariables.get(world).rounds) {
         RoundsNewModVariables.MapVariables.get(world).game_start = false;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).pause = true;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).red_pl = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).green_pl = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).yellow_pl = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).blue_pl = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         RoundsNewModVariables.MapVariables.get(world).music_tick = 0.0;
         RoundsNewModVariables.MapVariables.get(world).syncData(world);
         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "/title @a actionbar {\"text\":\"Синие выйграли\",\"color\":\"blue\"}"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "/playsound minecraft:entity.player.levelup block @a ~ ~ ~ 10 0.7 1"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "/tp @a 1.46 -46.88 6.53"
               );
         }

         ClearcardsradiusProcedure.execute(world);
      }
   }
}
