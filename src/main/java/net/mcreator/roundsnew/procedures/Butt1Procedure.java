package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class Butt1Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity instanceof Player _player) {
            _player.closeContainer();
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 1.0) {
            Card1Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 2.0) {
            Card2Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 3.0) {
            Card3Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 4.0) {
            Card4Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 5.0) {
            Card5Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 6.0) {
            Card6Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 7.0) {
            Card7Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 8.0) {
            Card8Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 9.0) {
            Card9Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 10.0) {
            Card10Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 11.0) {
            Card11Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 12.0) {
            Card12Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 13.0) {
            Card13Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 14.0) {
            Card14Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 15.0) {
            Card15Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 16.0) {
            Card16Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 17.0) {
            Card17Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 18.0) {
            Card18Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 19.0) {
            Card19Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 20.0) {
            Card20Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 21.0) {
            Card21Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 22.0) {
            Card22Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 23.0) {
            Card23Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 24.0) {
            Card24Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 25.0) {
            Card25Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 26.0) {
            Card26Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 27.0) {
            Card27Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 28.0) {
            Card28Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 29.0) {
            Card29Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 30.0) {
            Card30Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 31.0) {
            Card31Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 32.0) {
            Card32Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 33.0) {
            Card33Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 34.0) {
            Card34Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 35.0) {
            Card35Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 36.0) {
            Card36Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 37.0) {
            Card37Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 38.0) {
            Card38Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 39.0) {
            Card39Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 40.0) {
            Card40Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 41.0) {
            Card41Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 42.0) {
            Card42Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 43.0) {
            Card43Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 44.0) {
            Card44Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 45.0) {
            Card45Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 46.0) {
            Card46Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 47.0) {
            Card47Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 48.0) {
            Card48Procedure.execute(world, entity);
         }

         if (((RoundsNewModVariables.PlayerVariables)entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new RoundsNewModVariables.PlayerVariables()))
               .card_select_1
            == 49.0) {
            Card49Procedure.execute(world, entity);
         }
      }
   }
}
