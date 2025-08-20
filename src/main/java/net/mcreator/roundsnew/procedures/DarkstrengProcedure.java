package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class DarkstrengProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }

        if ((new Object() {
            public boolean checkGamemode(Entity _ent) {
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                } else {
                    return _ent.level().isClientSide() && _ent instanceof Player _player
                            ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                            && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE
                            : false;
                }
            }
        }).checkGamemode(entity) && ((RoundsNewModVariables.PlayerVariables) entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new RoundsNewModVariables.PlayerVariables())).dark_streng > 0.0) {

            RoundsNewModVariables.PlayerVariables playerVars = entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new RoundsNewModVariables.PlayerVariables());

            boolean isStationary = entity.getX() == playerVars.x && entity.getY() == playerVars.y && entity.getZ() == playerVars.z;

            if (isStationary && entity.getPersistentData().getDouble("shield") == 0.0) {
                if (playerVars.dark >= 180.0) {
                    entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.dark = 0.0;
                        capability.syncPlayerVariables(entity);
                    });
                    entity.getPersistentData().putDouble("dark_charge", 200.0);
                } else {
                    entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.dark += 1.0;
                        capability.syncPlayerVariables(entity);
                    });
                    RelDarkProcedure.execute(world, entity);
                    if (entity.getPersistentData().getDouble("darks") >= 20.0) {
                        if (world instanceof Level _level && !_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z),
                                    ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.experience_orb.pickup")),
                                    SoundSource.PLAYERS, 0.5F, 1.0F);
                        } else {
                            if (world instanceof Level _level) {
                                _level.playLocalSound(x, y, z,
                                        ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.experience_orb.pickup")),
                                        SoundSource.PLAYERS, 0.5F, 1.0F, false);
                            }
                        }
                        entity.getPersistentData().putDouble("darks", 0.0);
                    } else {
                        entity.getPersistentData().putDouble("darks", entity.getPersistentData().getDouble("darks") + 1.0);
                    }
                }
            } else if (entity.getPersistentData().getDouble("dark_charge") == 0.0) {
                if (entity.getPersistentData().getDouble("darkss") >= 20.0) {
                    entity.getPersistentData().putDouble("darkss", 0.0);
                } else {
                    entity.getPersistentData().putDouble("darkss", entity.getPersistentData().getDouble("darkss") + 1.0);
                }
                entity.getPersistentData().putDouble("darks", 0.0);

                entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.dark = 0.0;
                    capability.x = entity.getX();
                    capability.y = entity.getY();
                    capability.z = entity.getZ();
                    capability.syncPlayerVariables(entity);
                });
            }
        }
    }
}