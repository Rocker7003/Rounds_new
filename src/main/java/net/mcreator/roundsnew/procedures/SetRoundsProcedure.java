package net.mcreator.roundsnew.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.text.DecimalFormat;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelAccessor;

public class SetRoundsProcedure {
   public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
      if (!world.isClientSide() && world.getServer() != null) {
         world.getServer()
            .getPlayerList()
            .broadcastSystemMessage(Component.literal(new DecimalFormat("Раунды- ##.##").format(DoubleArgumentType.getDouble(arguments, "amount"))), false);
      }

      RoundsNewModVariables.MapVariables.get(world).rounds = DoubleArgumentType.getDouble(arguments, "amount");
      RoundsNewModVariables.MapVariables.get(world).syncData(world);
   }
}
