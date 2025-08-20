package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class HpProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 1.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 1"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 2.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 2"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 3.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 3"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 4.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 4"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 5.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 5"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 6.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 6"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 7.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 7"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 8.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 8"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 9.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 9"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 10.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 10"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 11.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 11"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 12.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 12"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 13.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 13"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 14.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 14"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 15.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 14"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 16.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 16"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 17.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 17"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 18.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 18"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 19.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 19"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 20.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 20"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 21.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 21"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 22.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 22"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 23.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 23"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 24.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 24"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 25.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 25"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 26.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 26"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 27.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 27"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 28.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 28"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 29.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 29"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 30.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 30"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 31.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 31"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 32.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 32"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 33.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 33"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 34.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 34"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 35.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 35"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 36.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 36"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 37.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 37"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 38.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 38"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 39.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 39"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 40.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 40"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 41.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 41"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 42.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 42"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 43.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 43"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 44.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 44"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 45.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 45"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 46.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 46"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 47.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 47"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 48.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 48"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 49.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 49"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 50.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 50"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 51.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 51"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 52.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 52"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 53.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 53"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 54.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 54"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 55.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 55"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 56.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 56"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 57.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 57"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 58.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 58"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 59.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 59"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 60.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 60"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 61.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 61"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 62.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 62"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 63.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 63"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 64.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 64"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 65.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 65"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 66.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 66"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 67.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 67"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 68.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 68"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 69.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 69"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 70.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 70"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 71.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 71"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 72.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 72"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 73.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 73"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 74.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 74"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 75.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 75"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 76.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 76"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 77.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 77"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 78.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 78"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 79.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 79"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 80.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 80"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 81.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 81"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 82.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 82"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 83.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 83"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 84.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 84"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 85.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 85"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 86.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 86"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 87.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 87"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 88.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 88"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 89.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 89"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 90.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 90"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 91.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 91"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 92.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 92"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 93.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 93"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 94.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 94"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 95.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 95"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 96.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 96"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 97.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 97"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 98.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 98"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               == 99.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 99"
               );
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .hp
               >= 100.0
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "/attribute @s minecraft:generic.max_health base set 100"
               );
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.setHealth(9999.0F);
         }
      }
   }
}
