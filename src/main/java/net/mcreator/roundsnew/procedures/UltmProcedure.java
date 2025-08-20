package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.init.RoundsNewModMobEffects;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class UltmProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        RoundsNewModVariables.MapVariables mapVars = RoundsNewModVariables.MapVariables.get(world);

        if (mapVars.game_start && mapVars.pause && mapVars.pl_ready == 0.0) {
            StartgameProcedure.execute(world, x, y, z);
            if (world instanceof ServerLevel _level) {
                _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                                        .withSuppressedOutput(),
                                "/gamemode adventure @a"
                        );
            }
        }

        if (!mapVars.card_start_give && mapVars.game_start) {
            mapVars.card_start_give = true;
            mapVars.syncData(world);

            for (Entity entityiterator : world.players()) {
                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(RoundsNewModMobEffects.CARD.get(), 60, 1, false, false));
                }
                mapVars.pl_ready++;
            }
            mapVars.syncData(world);
        }

        if (mapVars.game_start && !mapVars.pause) {
            // Red team wins
            if (mapVars.red > 0.0 && mapVars.green == 0.0 && mapVars.yellow == 0.0 && mapVars.blue == 0.0) {
                handleRoundEnd(world, x, y, z, "Красные выйграли", "red", 1);
                mapVars.red_pl++;
                mapVars.syncData(world);
            }
            // Green team wins
            else if (mapVars.red == 0.0 && mapVars.green > 0.0 && mapVars.yellow == 0.0 && mapVars.blue == 0.0) {
                handleRoundEnd(world, x, y, z, "Зелёные выйграли", "green", 2);
                mapVars.green_pl++;
                mapVars.syncData(world);
            }
            // Yellow team wins
            else if (mapVars.red == 0.0 && mapVars.green == 0.0 && mapVars.yellow > 0.0 && mapVars.blue == 0.0) {
                handleRoundEnd(world, x, y, z, "Жёлтые выйграли", "yellow", 3);
                mapVars.yellow_pl++;
                mapVars.syncData(world);
            }
            // Blue team wins
            else if (mapVars.red == 0.0 && mapVars.green == 0.0 && mapVars.yellow == 0.0 && mapVars.blue > 0.0) {
                handleRoundEnd(world, x, y, z, "Синие выйграли", "blue", 4);
                mapVars.blue_pl++;
                mapVars.syncData(world);
            }
            // Draw condition
            else if (mapVars.red == 0.0 && mapVars.green == 0.0 && mapVars.yellow == 0.0 && mapVars.blue == 0.0) {
                handleRoundEnd(world, x, y, z, "Ничья?", "gold", 0); // Team 0 for draw
            }
        }
    }

    private static void handleRoundEnd(LevelAccessor world, double x, double y, double z, String message, String color, int winningTeam) {
        if (world instanceof ServerLevel _level) {
            _level.getServer().getCommands().performPrefixedCommand(
                    new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                    "/title @a actionbar {\"text\":\"" + message + "\",\"color\":\"" + color + "\"}"
            );
            _level.getServer().getCommands().performPrefixedCommand(
                    new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                    "/playsound minecraft:entity.player.levelup block @a ~ ~ ~ 10 0.7 1"
            );
        }

        RoundsNewModVariables.MapVariables mapVars = RoundsNewModVariables.MapVariables.get(world);
        for (Entity playerEntity : world.players()) {
            double playerTeam = ((RoundsNewModVariables.PlayerVariables) playerEntity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new RoundsNewModVariables.PlayerVariables())).team;

            // Give cards to losing teams, or all teams in a draw
            if (winningTeam == 0 || playerTeam != winningTeam) {
                if (playerEntity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(RoundsNewModMobEffects.CARD.get(), 60, 1, false, false));
                }
                mapVars.pl_ready++;
            }
        }

        mapVars.pause = true;
        mapVars.syncData(world);
    }
}