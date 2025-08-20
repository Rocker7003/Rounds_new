package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class WorldloadProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel _level) {
            _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                            new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                                    .withSuppressedOutput(),
                            "/team leave @a"
                    );
        }

        // Get map variables once and update all values before syncing.
        RoundsNewModVariables.MapVariables mapVars = RoundsNewModVariables.MapVariables.get(world);
        mapVars.red = 0.0;
        mapVars.green = 0.0;
        mapVars.yellow = 0.0;
        mapVars.blue = 0.0;
        mapVars.red_pl = 0.0;
        mapVars.green_pl = 0.0;
        mapVars.yellow_pl = 0.0;
        mapVars.blue_pl = 0.0;
        mapVars.card_red = 0.0;
        mapVars.card_yellow = 0.0;
        mapVars.card_blue = 0.0;
        mapVars.card_green = 0.0;
        mapVars.syncData(world);

        // Iterate directly over the list of players provided by the world object.
        for (Entity entityiterator : world.players()) {
            entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.team = 0.0;
                capability.syncPlayerVariables(entityiterator);
            });
        }
    }
}