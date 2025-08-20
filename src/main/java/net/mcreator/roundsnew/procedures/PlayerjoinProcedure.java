package net.mcreator.roundsnew.procedures;

import javax.annotation.Nullable;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerjoinProcedure {
    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerLoggedInEvent event) {
        execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }

        if (entity instanceof ServerPlayer _player) {
            _player.setGameMode(GameType.ADVENTURE);
        }

        if (RoundsNewModVariables.MapVariables.get(world).game_start) {
            RoundsNewModVariables.MapVariables.get(world).game_start = false;
            RoundsNewModVariables.MapVariables.get(world).pause = true;
            RoundsNewModVariables.MapVariables.get(world).syncData(world);
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

        WorldloadProcedure.execute(world, x, y, z);
        entity.teleportTo(1.5, -46.0, 6.5);
        if (entity instanceof ServerPlayer _serverPlayer) {
            _serverPlayer.connection.teleport(1.5, -46.0, 6.5, entity.getYRot(), entity.getXRot());
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

        // Simplified and corrected player count logic
        double playerCount = world.players().size();
        entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.player_use = playerCount;
            capability.syncPlayerVariables(entity);
        });

        // Logic specific to the first player joining
        if (playerCount == 1) {
            RoundsNewModVariables.MapVariables.get(world).rounds = 5.0;
            RoundsNewModVariables.MapVariables.get(world).syncData(world);
            if (!world.isClientSide() && world.getServer() != null) {
                world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Настроить колличество раундов - /rounds (1-20)"), false);
            }
            if (world instanceof ServerLevel _level) {
                _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                                        .withSuppressedOutput(),
                                "/setblock 5 -52 2 rounds_new:blockjoinyellow"
                        );
                _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                                        .withSuppressedOutput(),
                                "/setblock 5 -52 10 rounds_new:blockjoinred"
                        );
                _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                                        .withSuppressedOutput(),
                                "/setblock -3 -52 10 rounds_new:blockjoingreen"
                        );
                _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                                        .withSuppressedOutput(),
                                "/setblock -3 -52 2 rounds_new:blockjoinblue"
                        );
                _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                                        .withSuppressedOutput(),
                                "/setblock 1 -53 6 rounds_new:blockjoin_white"
                        );
            }
        }

        // Special messages for specific players
        String displayName = entity.getDisplayName().getString();
        if (displayName.equals("Lololowka")) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
                _player.displayClientMessage(Component.literal("Даров, Ром. Чекни это видео. Постарайся его досмотреть, всего 5 минут =)"), false);
            }
            if (!entity.level().isClientSide() && entity.getServer() != null) {
                entity.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.getServer(), entity),
                        "/tellraw @s {\"text\":\"(Кликни)\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://youtu.be/bnNSJLtUSkA\"}}"
                );
            }
        } else if (displayName.equals("F1xPlay")) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
                _player.displayClientMessage(Component.literal("Даров, Фикс. Я тебя особо не знаю, но кинь это видео Роме. В краци, я очень сильно хочу с вами поговорить"), false);
            }
            if (!entity.level().isClientSide() && entity.getServer() != null) {
                entity.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.getServer(), entity),
                        "/tellraw @s {\"text\":\"(Кликни)\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://youtu.be/bnNSJLtUSkA\"}}"
                );
            }
        } else if (displayName.equals("KabanYT")) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
                _player.displayClientMessage(Component.literal("Привет Кабан! Как дела? Кароче я тебя почти не знаю, максимум ты прошел мой табс в майнкрафт. Кинь это видео Роме. Я хочу с вами поговорить"), false);
            }
            if (!entity.level().isClientSide() && entity.getServer() != null) {
                entity.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.getServer(), entity),
                        "/tellraw @s {\"text\":\"(Кликни)\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://youtu.be/bnNSJLtUSkA\"}}"
                );
            }
        } else if (displayName.equals("Unikrol")) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
                _player.displayClientMessage(Component.literal("Юни!! Привет, я тебя почти не знаю. Но попрошу кинуть этот ролик Роме. Хочу поговорить с вами :p "), false);
            }
            if (!entity.level().isClientSide() && entity.getServer() != null) {
                entity.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.getServer(), entity),
                        "/tellraw @s {\"text\":\"(Кликни)\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://youtu.be/bnNSJLtUSkA\"}}"
                );
            }
        }
    }
}