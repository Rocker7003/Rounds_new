package net.mcreator.roundsnew.command;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.mcreator.roundsnew.procedures.SetRoundsProcedure;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class RoundsCommand {
   @SubscribeEvent
   public static void registerCommand(RegisterCommandsEvent event) {
      event.getDispatcher()
         .register(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.literal("rounds").requires(s -> s.hasPermission(2)))
               .then(Commands.argument("amount", DoubleArgumentType.doubleArg(1.0, 20.0)).executes(arguments -> {
                  ServerLevel world = ((CommandSourceStack)arguments.getSource()).getLevel();
                  double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
                  double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
                  double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
                  Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
                  if (entity == null) {
                     entity = FakePlayerFactory.getMinecraft(world);
                  }

                  Direction direction = entity.getDirection();
                  SetRoundsProcedure.execute(world, arguments);
                  return 0;
               }))
         );
   }
}
