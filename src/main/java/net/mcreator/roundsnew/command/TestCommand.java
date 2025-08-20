package net.mcreator.roundsnew.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.mcreator.roundsnew.procedures.RundomcardsProcedure;
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
public class TestCommand {
   @SubscribeEvent
   public static void registerCommand(RegisterCommandsEvent event) {
      event.getDispatcher()
         .register((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.literal("test").requires(s -> s.hasPermission(2))).executes(arguments -> {
            ServerLevel world = ((CommandSourceStack)arguments.getSource()).getLevel();
            double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
            double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
            double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
            Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
            if (entity == null) {
               entity = FakePlayerFactory.getMinecraft(world);
            }

            Direction direction = entity.getDirection();
            RundomcardsProcedure.execute(world, x, y, z, entity);
            return 0;
         }));
   }
}
