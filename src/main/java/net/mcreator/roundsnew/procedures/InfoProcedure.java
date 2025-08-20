package net.mcreator.roundsnew.procedures;

import java.text.DecimalFormat;
import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class InfoProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(
               Component.literal(new DecimalFormat("pl_ready ##.##").format(RoundsNewModVariables.MapVariables.get(world).pl_ready)), false
            );
         }

         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal(new DecimalFormat("r ##.##").format(RoundsNewModVariables.MapVariables.get(world).red)), false);
         }

         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal(new DecimalFormat("g ##.##").format(RoundsNewModVariables.MapVariables.get(world).green)), false);
         }

         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal(new DecimalFormat("y ##.##").format(RoundsNewModVariables.MapVariables.get(world).yellow)), false);
         }

         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal(new DecimalFormat("b ##.##").format(RoundsNewModVariables.MapVariables.get(world).blue)), false);
         }

         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal("-------"), false);
         }

         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(
               Component.literal(new DecimalFormat("r_win ##.##").format(RoundsNewModVariables.MapVariables.get(world).red_pl)), false
            );
         }

         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(
               Component.literal(new DecimalFormat("g_win ##.##").format(RoundsNewModVariables.MapVariables.get(world).green_pl)), false
            );
         }

         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(
               Component.literal(new DecimalFormat("y_win ##.##").format(RoundsNewModVariables.MapVariables.get(world).yellow_pl)), false
            );
         }

         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(
               Component.literal(new DecimalFormat("b_win ##.##").format(RoundsNewModVariables.MapVariables.get(world).yellow_pl)), false
            );
         }

         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal("-------"), false);
         }

         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(
               Component.literal(new DecimalFormat("h_red ##.##").format(RoundsNewModVariables.MapVariables.get(world).card_red)), false
            );
         }

         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(
               Component.literal(new DecimalFormat("h_green ##.##").format(RoundsNewModVariables.MapVariables.get(world).card_green)), false
            );
         }

         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(
               Component.literal(new DecimalFormat("h_yellow ##.##").format(RoundsNewModVariables.MapVariables.get(world).card_yellow)), false
            );
         }

         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(
               Component.literal(new DecimalFormat("h_blue ##.##").format(RoundsNewModVariables.MapVariables.get(world).card_blue)), false
            );
         }
      }
   }
}
