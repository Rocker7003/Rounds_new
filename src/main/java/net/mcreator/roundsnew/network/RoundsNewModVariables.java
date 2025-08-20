package net.mcreator.roundsnew.network;

import java.util.ArrayList;
import java.util.function.Supplier;
import net.mcreator.roundsnew.RoundsNewMod;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.Clone;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent.Context;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class RoundsNewModVariables {
   public static final Capability<RoundsNewModVariables.PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(
      new CapabilityToken<RoundsNewModVariables.PlayerVariables>() {
      }
   );

   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      RoundsNewMod.addNetworkMessage(
         RoundsNewModVariables.SavedDataSyncMessage.class,
         RoundsNewModVariables.SavedDataSyncMessage::buffer,
         RoundsNewModVariables.SavedDataSyncMessage::new,
         RoundsNewModVariables.SavedDataSyncMessage::handler
      );
      RoundsNewMod.addNetworkMessage(
         RoundsNewModVariables.PlayerVariablesSyncMessage.class,
         RoundsNewModVariables.PlayerVariablesSyncMessage::buffer,
         RoundsNewModVariables.PlayerVariablesSyncMessage::new,
         RoundsNewModVariables.PlayerVariablesSyncMessage::handler
      );
   }

   @SubscribeEvent
   public static void init(RegisterCapabilitiesEvent event) {
      event.register(RoundsNewModVariables.PlayerVariables.class);
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      RoundsNewMod.addNetworkMessage(
         RoundsNewModVariables.PlayerVariablesSyncMessage.class,
         RoundsNewModVariables.PlayerVariablesSyncMessage::buffer,
         RoundsNewModVariables.PlayerVariablesSyncMessage::new,
         RoundsNewModVariables.PlayerVariablesSyncMessage::handler
      );
   }

   @EventBusSubscriber
   public static class EventBusVariableHandlers {
      @SubscribeEvent
      public static void onPlayerLoggedInSyncPlayerVariables(PlayerLoggedInEvent event) {
         if (!event.getEntity().level().isClientSide()) {
             for (Entity entityiterator : event.getEntity().level().players()) {
               ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .syncPlayerVariables(entityiterator);
            }
         }
      }

      @SubscribeEvent
      public static void onPlayerRespawnedSyncPlayerVariables(PlayerRespawnEvent event) {
         if (!event.getEntity().level().isClientSide()) {
             for (Entity entityiterator : event.getEntity().level().players()) {
               ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .syncPlayerVariables(entityiterator);
            }
         }
      }

      @SubscribeEvent
      public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerChangedDimensionEvent event) {
         if (!event.getEntity().level().isClientSide()) {
             for (Entity entityiterator : event.getEntity().level().players()) {
               ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .syncPlayerVariables(entityiterator);
            }
         }
      }

      @SubscribeEvent
      public static void clonePlayer(Clone event) {
         event.getOriginal().revive();
         RoundsNewModVariables.PlayerVariables original = (RoundsNewModVariables.PlayerVariables)event.getOriginal()
            .getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
            .orElse(new RoundsNewModVariables.PlayerVariables());
         RoundsNewModVariables.PlayerVariables clone = (RoundsNewModVariables.PlayerVariables)event.getEntity()
            .getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
            .orElse(new RoundsNewModVariables.PlayerVariables());
         clone.player_use = original.player_use;
         clone.player_name = original.player_name;
         clone.card_1 = original.card_1;
         clone.card_2 = original.card_2;
         clone.card_3 = original.card_3;
         clone.card_4 = original.card_4;
         clone.card_5 = original.card_5;
         clone.card_6 = original.card_6;
         clone.card_7 = original.card_7;
         clone.card_8 = original.card_8;
         clone.card_9 = original.card_9;
         clone.card_10 = original.card_10;
         clone.card_11 = original.card_11;
         clone.card_12 = original.card_12;
         clone.card_13 = original.card_13;
         clone.card_14 = original.card_14;
         clone.card_15 = original.card_15;
         clone.card_16 = original.card_16;
         clone.card_17 = original.card_17;
         clone.card_18 = original.card_18;
         clone.card_19 = original.card_19;
         clone.card_20 = original.card_20;
         clone.card_21 = original.card_21;
         clone.card_22 = original.card_22;
         clone.card_23 = original.card_23;
         clone.card_24 = original.card_24;
         clone.card_25 = original.card_25;
         clone.card_26 = original.card_26;
         clone.card_27 = original.card_27;
         clone.card_28 = original.card_28;
         clone.card_29 = original.card_29;
         clone.card_30 = original.card_30;
         clone.card_31 = original.card_31;
         clone.card_32 = original.card_32;
         clone.card_33 = original.card_33;
         clone.card_34 = original.card_34;
         clone.card_35 = original.card_35;
         clone.card_select_1 = original.card_select_1;
         clone.card_select_2 = original.card_select_2;
         clone.card_select_3 = original.card_select_3;
         clone.card_select_4 = original.card_select_4;
         clone.card_select_5 = original.card_select_5;
         clone.card_uses = original.card_uses;
         clone.rare_card = original.rare_card;
         clone.cards = original.cards;
         clone.card_36 = original.card_36;
         clone.card_37 = original.card_37;
         clone.card_38 = original.card_38;
         clone.card_39 = original.card_39;
         clone.card_40 = original.card_40;
         clone.card_41 = original.card_41;
         clone.card_42 = original.card_42;
         clone.card_43 = original.card_43;
         clone.dmg_player = original.dmg_player;
         clone.atks_player = original.atks_player;
         clone.atkr_player = original.atkr_player;
         clone.bounce_player = original.bounce_player;
         clone.dmg = original.dmg;
         clone.atkr = original.atkr;
         clone.bounce_pl = original.bounce_pl;
         clone.ammo = original.ammo;
         clone.atks = original.atks;
         clone.atks_reload = original.atks_reload;
         clone.pistol_anim = original.pistol_anim;
         clone.bullets = original.bullets;
         clone.cold = original.cold;
         clone.poison = original.poison;
         clone.leech = original.leech;
         clone.tg_bounce = original.tg_bounce;
         clone.homing = original.homing;
         clone.poison_lvl = original.poison_lvl;
         clone.cold_lvl = original.cold_lvl;
         clone.parazit_lvl = original.parazit_lvl;
         clone.parazit = original.parazit;
         clone.hp = original.hp;
         clone.shield_cooldawn = original.shield_cooldawn;
         clone.bomb_bullet = original.bomb_bullet;
         clone.explode_bullets = original.explode_bullets;
         clone.card20 = original.card20;
         clone.bullet_speed = original.bullet_speed;
         clone.empower = original.empower;
         clone.empower_charge = original.empower_charge;
         clone.dark_streng = original.dark_streng;
         clone.x = original.x;
         clone.z = original.z;
         clone.y = original.y;
         clone.card_4s = original.card_4s;
         clone.dark = original.dark;
         clone.card37 = original.card37;
         clone.card35 = original.card35;
         clone.card34 = original.card34;
         clone.card13 = original.card13;
         clone.card17 = original.card17;
         clone.grow = original.grow;
         clone.barage = original.barage;
         clone.leech_player = original.leech_player;
         clone.big_bullet = original.big_bullet;
         clone.card30 = original.card30;
         clone.truster_lvl = original.truster_lvl;
         clone.truster = original.truster;
         clone.phenix_tick = original.phenix_tick;
         clone.phenix = original.phenix;
         clone.phenix_lv = original.phenix_lv;
         clone.card9 = original.card9;
         clone.brawler = original.brawler;
         clone.brawler_i = original.brawler_i;
         clone.card41 = original.card41;
         clone.Super_nova_tick = original.Super_nova_tick;
         clone.Super_nova = original.Super_nova;
         clone.toxic = original.toxic;
         clone.team = original.team;
         clone.duzzle = original.duzzle;
         clone.Implode = original.Implode;
         clone.OverPower = original.OverPower;
         clone.RadarShot = original.RadarShot;
         clone.scavenger = original.scavenger;
         clone.shock_wave = original.shock_wave;
         clone.card_44 = original.card_44;
         clone.card_45 = original.card_45;
         clone.card_46 = original.card_46;
         clone.card_47 = original.card_47;
         clone.card_48 = original.card_48;
         clone.card_49 = original.card_49;
         clone.duzzle_lvl = original.duzzle_lvl;
         clone.num = original.num;
         clone.card_open = original.card_open;
         clone.blue_w = original.blue_w;
         clone.green_w = original.green_w;
         clone.red_w = original.red_w;
         clone.yellow_w = original.yellow_w;
         clone.selected = original.selected;
         if (!event.isWasDeath()) {
         }

         if (!event.getEntity().level().isClientSide()) {
             for (Entity entityiterator : event.getEntity().level().players()) {
               ((RoundsNewModVariables.PlayerVariables)entityiterator.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables()))
                  .syncPlayerVariables(entityiterator);
            }
         }
      }

      @SubscribeEvent
      public static void onPlayerLoggedIn(PlayerLoggedInEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            SavedData mapdata = RoundsNewModVariables.MapVariables.get(event.getEntity().level());
            SavedData worlddata = RoundsNewModVariables.WorldVariables.get(event.getEntity().level());
            if (mapdata != null) {
               RoundsNewMod.PACKET_HANDLER
                  .send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()), new RoundsNewModVariables.SavedDataSyncMessage(0, mapdata));
            }

            if (worlddata != null) {
               RoundsNewMod.PACKET_HANDLER
                  .send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()), new RoundsNewModVariables.SavedDataSyncMessage(1, worlddata));
            }
         }
      }

      @SubscribeEvent
      public static void onPlayerChangedDimension(PlayerChangedDimensionEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            SavedData worlddata = RoundsNewModVariables.WorldVariables.get(event.getEntity().level());
            if (worlddata != null) {
               RoundsNewMod.PACKET_HANDLER
                  .send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()), new RoundsNewModVariables.SavedDataSyncMessage(1, worlddata));
            }
         }
      }
   }

   public static class MapVariables extends SavedData {
      public static final String DATA_NAME = "rounds_new_mapvars";
      public double players = 0.0;
      public double world_lock = 0.0;
      public double plw = 0.0;
      public boolean game_start = false;
      public double card_red = 0.0;
      public double card_yellow = 0.0;
      public double card_blue = 0.0;
      public double card_green = 0.0;
      public boolean pause = false;
      public double red = 0.0;
      public double green = 0.0;
      public double yellow = 0.0;
      public double blue = 0.0;
      public double red_pl = 0.0;
      public double green_pl = 0.0;
      public double yellow_pl = 0.0;
      public double blue_pl = 0.0;
      public double pl_ready = 0.0;
      public boolean card_start_give = false;
      public double music = 0.0;
      public double music_tick = 0.0;
      public double map = 0.0;
      public double rounds = 0.0;
      static RoundsNewModVariables.MapVariables clientSide = new RoundsNewModVariables.MapVariables();

      public static RoundsNewModVariables.MapVariables load(CompoundTag tag) {
         RoundsNewModVariables.MapVariables data = new RoundsNewModVariables.MapVariables();
         data.read(tag);
         return data;
      }

      public void read(CompoundTag nbt) {
         if (nbt == null) {
            nbt = this.save(new CompoundTag());
         }

         this.players = nbt.getDouble("players");
         this.world_lock = nbt.getDouble("world_lock");
         this.plw = nbt.getDouble("plw");
         this.game_start = nbt.getBoolean("game_start");
         this.card_red = nbt.getDouble("card_red");
         this.card_yellow = nbt.getDouble("card_yellow");
         this.card_blue = nbt.getDouble("card_blue");
         this.card_green = nbt.getDouble("card_green");
         this.pause = nbt.getBoolean("pause");
         this.red = nbt.getDouble("red");
         this.green = nbt.getDouble("green");
         this.yellow = nbt.getDouble("yellow");
         this.blue = nbt.getDouble("blue");
         this.red_pl = nbt.getDouble("red_pl");
         this.green_pl = nbt.getDouble("green_pl");
         this.yellow_pl = nbt.getDouble("yellow_pl");
         this.blue_pl = nbt.getDouble("blue_pl");
         this.pl_ready = nbt.getDouble("pl_ready");
         this.card_start_give = nbt.getBoolean("card_start_give");
         this.music = nbt.getDouble("music");
         this.music_tick = nbt.getDouble("music_tick");
         this.map = nbt.getDouble("map");
         this.rounds = nbt.getDouble("rounds");
      }

      public CompoundTag save(CompoundTag nbt) {
         nbt.putDouble("players", this.players);
         nbt.putDouble("world_lock", this.world_lock);
         nbt.putDouble("plw", this.plw);
         nbt.putBoolean("game_start", this.game_start);
         nbt.putDouble("card_red", this.card_red);
         nbt.putDouble("card_yellow", this.card_yellow);
         nbt.putDouble("card_blue", this.card_blue);
         nbt.putDouble("card_green", this.card_green);
         nbt.putBoolean("pause", this.pause);
         nbt.putDouble("red", this.red);
         nbt.putDouble("green", this.green);
         nbt.putDouble("yellow", this.yellow);
         nbt.putDouble("blue", this.blue);
         nbt.putDouble("red_pl", this.red_pl);
         nbt.putDouble("green_pl", this.green_pl);
         nbt.putDouble("yellow_pl", this.yellow_pl);
         nbt.putDouble("blue_pl", this.blue_pl);
         nbt.putDouble("pl_ready", this.pl_ready);
         nbt.putBoolean("card_start_give", this.card_start_give);
         nbt.putDouble("music", this.music);
         nbt.putDouble("music_tick", this.music_tick);
         nbt.putDouble("map", this.map);
         nbt.putDouble("rounds", this.rounds);
         return nbt;
      }

      public void syncData(LevelAccessor world) {
         this.setDirty();
         if (world instanceof Level && !world.isClientSide()) {
            RoundsNewMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new RoundsNewModVariables.SavedDataSyncMessage(0, this));
         }
      }

      public static RoundsNewModVariables.MapVariables get(LevelAccessor world) {
         return world instanceof ServerLevelAccessor serverLevelAcc
            ? (RoundsNewModVariables.MapVariables)serverLevelAcc.getLevel()
               .getServer()
               .getLevel(Level.OVERWORLD)
               .getDataStorage()
               .computeIfAbsent(e -> load(e), RoundsNewModVariables.MapVariables::new, "rounds_new_mapvars")
            : clientSide;
      }
   }

   public static class PlayerVariables {
      public double player_use = 0.0;
      public String player_name = "\"\"";
      public boolean card_1 = false;
      public boolean card_2 = false;
      public boolean card_3 = false;
      public boolean card_4 = false;
      public boolean card_5 = false;
      public boolean card_6 = false;
      public boolean card_7 = false;
      public boolean card_8 = false;
      public boolean card_9 = false;
      public boolean card_10 = false;
      public boolean card_11 = false;
      public boolean card_12 = false;
      public boolean card_13 = false;
      public boolean card_14 = false;
      public boolean card_15 = false;
      public boolean card_16 = false;
      public boolean card_17 = false;
      public boolean card_18 = false;
      public boolean card_19 = false;
      public boolean card_20 = false;
      public boolean card_21 = false;
      public boolean card_22 = false;
      public boolean card_23 = false;
      public boolean card_24 = false;
      public boolean card_25 = false;
      public boolean card_26 = false;
      public boolean card_27 = false;
      public boolean card_28 = false;
      public boolean card_29 = false;
      public boolean card_30 = false;
      public boolean card_31 = false;
      public boolean card_32 = false;
      public boolean card_33 = false;
      public boolean card_34 = false;
      public boolean card_35 = false;
      public double card_select_1 = 0.0;
      public double card_select_2 = 0.0;
      public double card_select_3 = 0.0;
      public double card_select_4 = 0.0;
      public double card_select_5 = 0.0;
      public double card_uses = 0.0;
      public double rare_card = 0.0;
      public double cards = 0.0;
      public boolean card_36 = false;
      public boolean card_37 = false;
      public boolean card_38 = false;
      public boolean card_39 = false;
      public boolean card_40 = false;
      public boolean card_41 = false;
      public boolean card_42 = false;
      public boolean card_43 = false;
      public double dmg_player = 0.0;
      public double atks_player = 0.0;
      public double atkr_player = 0.0;
      public double bounce_player = 0.0;
      public double dmg = 8.0;
      public double atkr = 10.0;
      public double bounce_pl = 0.0;
      public double ammo = 0.0;
      public double atks = 0.0;
      public double atks_reload = 0.0;
      public double pistol_anim = 0.0;
      public double bullets = 0.0;
      public double cold = 0.0;
      public double poison = 0.0;
      public double leech = 0.0;
      public double tg_bounce = 0.0;
      public double homing = 0.0;
      public double poison_lvl = 0.0;
      public double cold_lvl = 0.0;
      public double parazit_lvl = 0.0;
      public double parazit = 0.0;
      public double hp = 0.0;
      public double shield_cooldawn = 0.0;
      public double bomb_bullet = 0.0;
      public double explode_bullets = 0.0;
      public double card20 = 0.0;
      public double bullet_speed = 0.0;
      public double empower = 0.0;
      public double empower_charge = 0.0;
      public double dark_streng = 0.0;
      public double x = 0.0;
      public double z = 0.0;
      public double y = 0.0;
      public double card_4s = 0.0;
      public double dark = 0.0;
      public double card37 = 0.0;
      public double card35 = 0.0;
      public double card34 = 0.0;
      public double card13 = 0.0;
      public double card17 = 0.0;
      public double grow = 0.0;
      public double barage = 0.0;
      public double leech_player = 0.0;
      public double big_bullet = 0.0;
      public double card30 = 0.0;
      public double truster_lvl = 0.0;
      public double truster = 0.0;
      public double phenix_tick = 0.0;
      public double phenix = 0.0;
      public double phenix_lv = 0.0;
      public double card9 = 0.0;
      public double brawler = 0.0;
      public double brawler_i = 0.0;
      public double card41 = 0.0;
      public double Super_nova_tick = 0.0;
      public double Super_nova = 0.0;
      public double toxic = 0.0;
      public double team = 0.0;
      public double duzzle = 0.0;
      public double Implode = 0.0;
      public double OverPower = 0.0;
      public double RadarShot = 0.0;
      public double scavenger = 0.0;
      public double shock_wave = 0.0;
      public boolean card_44 = false;
      public boolean card_45 = false;
      public boolean card_46 = false;
      public boolean card_47 = false;
      public boolean card_48 = false;
      public boolean card_49 = false;
      public double duzzle_lvl = 0.0;
      public double num = 0.0;
      public double card_open = 0.0;
      public double blue_w = 0.0;
      public double green_w = 0.0;
      public double red_w = 0.0;
      public double yellow_w = 0.0;
      public boolean selected = false;

      public void syncPlayerVariables(Entity entity) {
         if (entity instanceof ServerPlayer serverPlayer) {
            RoundsNewMod.PACKET_HANDLER
               .send(PacketDistributor.DIMENSION.with(entity.level()::dimension), new RoundsNewModVariables.PlayerVariablesSyncMessage(this, entity.getId()));
         }
      }

      public Tag writeNBT() {
         CompoundTag nbt = new CompoundTag();
         nbt.putDouble("player_use", this.player_use);
         nbt.putString("player_name", this.player_name);
         nbt.putBoolean("card_1", this.card_1);
         nbt.putBoolean("card_2", this.card_2);
         nbt.putBoolean("card_3", this.card_3);
         nbt.putBoolean("card_4", this.card_4);
         nbt.putBoolean("card_5", this.card_5);
         nbt.putBoolean("card_6", this.card_6);
         nbt.putBoolean("card_7", this.card_7);
         nbt.putBoolean("card_8", this.card_8);
         nbt.putBoolean("card_9", this.card_9);
         nbt.putBoolean("card_10", this.card_10);
         nbt.putBoolean("card_11", this.card_11);
         nbt.putBoolean("card_12", this.card_12);
         nbt.putBoolean("card_13", this.card_13);
         nbt.putBoolean("card_14", this.card_14);
         nbt.putBoolean("card_15", this.card_15);
         nbt.putBoolean("card_16", this.card_16);
         nbt.putBoolean("card_17", this.card_17);
         nbt.putBoolean("card_18", this.card_18);
         nbt.putBoolean("card_19", this.card_19);
         nbt.putBoolean("card_20", this.card_20);
         nbt.putBoolean("card_21", this.card_21);
         nbt.putBoolean("card_22", this.card_22);
         nbt.putBoolean("card_23", this.card_23);
         nbt.putBoolean("card_24", this.card_24);
         nbt.putBoolean("card_25", this.card_25);
         nbt.putBoolean("card_26", this.card_26);
         nbt.putBoolean("card_27", this.card_27);
         nbt.putBoolean("card_28", this.card_28);
         nbt.putBoolean("card_29", this.card_29);
         nbt.putBoolean("card_30", this.card_30);
         nbt.putBoolean("card_31", this.card_31);
         nbt.putBoolean("card_32", this.card_32);
         nbt.putBoolean("card_33", this.card_33);
         nbt.putBoolean("card_34", this.card_34);
         nbt.putBoolean("card_35", this.card_35);
         nbt.putDouble("card_select_1", this.card_select_1);
         nbt.putDouble("card_select_2", this.card_select_2);
         nbt.putDouble("card_select_3", this.card_select_3);
         nbt.putDouble("card_select_4", this.card_select_4);
         nbt.putDouble("card_select_5", this.card_select_5);
         nbt.putDouble("card_uses", this.card_uses);
         nbt.putDouble("rare_card", this.rare_card);
         nbt.putDouble("cards", this.cards);
         nbt.putBoolean("card_36", this.card_36);
         nbt.putBoolean("card_37", this.card_37);
         nbt.putBoolean("card_38", this.card_38);
         nbt.putBoolean("card_39", this.card_39);
         nbt.putBoolean("card_40", this.card_40);
         nbt.putBoolean("card_41", this.card_41);
         nbt.putBoolean("card_42", this.card_42);
         nbt.putBoolean("card_43", this.card_43);
         nbt.putDouble("dmg_player", this.dmg_player);
         nbt.putDouble("atks_player", this.atks_player);
         nbt.putDouble("atkr_player", this.atkr_player);
         nbt.putDouble("bounce_player", this.bounce_player);
         nbt.putDouble("dmg", this.dmg);
         nbt.putDouble("atkr", this.atkr);
         nbt.putDouble("bounce_pl", this.bounce_pl);
         nbt.putDouble("ammo", this.ammo);
         nbt.putDouble("atks", this.atks);
         nbt.putDouble("atks_reload", this.atks_reload);
         nbt.putDouble("pistol_anim", this.pistol_anim);
         nbt.putDouble("bullets", this.bullets);
         nbt.putDouble("cold", this.cold);
         nbt.putDouble("poison", this.poison);
         nbt.putDouble("leech", this.leech);
         nbt.putDouble("tg_bounce", this.tg_bounce);
         nbt.putDouble("homing", this.homing);
         nbt.putDouble("poison_lvl", this.poison_lvl);
         nbt.putDouble("cold_lvl", this.cold_lvl);
         nbt.putDouble("parazit_lvl", this.parazit_lvl);
         nbt.putDouble("parazit", this.parazit);
         nbt.putDouble("hp", this.hp);
         nbt.putDouble("shield_cooldawn", this.shield_cooldawn);
         nbt.putDouble("bomb_bullet", this.bomb_bullet);
         nbt.putDouble("explode_bullets", this.explode_bullets);
         nbt.putDouble("card20", this.card20);
         nbt.putDouble("bullet_speed", this.bullet_speed);
         nbt.putDouble("empower", this.empower);
         nbt.putDouble("empower_charge", this.empower_charge);
         nbt.putDouble("dark_streng", this.dark_streng);
         nbt.putDouble("x", this.x);
         nbt.putDouble("z", this.z);
         nbt.putDouble("y", this.y);
         nbt.putDouble("card_4s", this.card_4s);
         nbt.putDouble("dark", this.dark);
         nbt.putDouble("card37", this.card37);
         nbt.putDouble("card35", this.card35);
         nbt.putDouble("card34", this.card34);
         nbt.putDouble("card13", this.card13);
         nbt.putDouble("card17", this.card17);
         nbt.putDouble("grow", this.grow);
         nbt.putDouble("barage", this.barage);
         nbt.putDouble("leech_player", this.leech_player);
         nbt.putDouble("big_bullet", this.big_bullet);
         nbt.putDouble("card30", this.card30);
         nbt.putDouble("truster_lvl", this.truster_lvl);
         nbt.putDouble("truster", this.truster);
         nbt.putDouble("phenix_tick", this.phenix_tick);
         nbt.putDouble("phenix", this.phenix);
         nbt.putDouble("phenix_lv", this.phenix_lv);
         nbt.putDouble("card9", this.card9);
         nbt.putDouble("brawler", this.brawler);
         nbt.putDouble("brawler_i", this.brawler_i);
         nbt.putDouble("card41", this.card41);
         nbt.putDouble("Super_nova_tick", this.Super_nova_tick);
         nbt.putDouble("Super_nova", this.Super_nova);
         nbt.putDouble("toxic", this.toxic);
         nbt.putDouble("team", this.team);
         nbt.putDouble("duzzle", this.duzzle);
         nbt.putDouble("Implode", this.Implode);
         nbt.putDouble("OverPower", this.OverPower);
         nbt.putDouble("RadarShot", this.RadarShot);
         nbt.putDouble("scavenger", this.scavenger);
         nbt.putDouble("shock_wave", this.shock_wave);
         nbt.putBoolean("card_44", this.card_44);
         nbt.putBoolean("card_45", this.card_45);
         nbt.putBoolean("card_46", this.card_46);
         nbt.putBoolean("card_47", this.card_47);
         nbt.putBoolean("card_48", this.card_48);
         nbt.putBoolean("card_49", this.card_49);
         nbt.putDouble("duzzle_lvl", this.duzzle_lvl);
         nbt.putDouble("num", this.num);
         nbt.putDouble("card_open", this.card_open);
         nbt.putDouble("blue_w", this.blue_w);
         nbt.putDouble("green_w", this.green_w);
         nbt.putDouble("red_w", this.red_w);
         nbt.putDouble("yellow_w", this.yellow_w);
         nbt.putBoolean("selected", this.selected);
         return nbt;
      }

      public void readNBT(Tag tag) {
         if (tag == null) {
            tag = this.writeNBT();
         }

         CompoundTag nbt = (CompoundTag)tag;
         if (nbt == null) {
            nbt = (CompoundTag)this.writeNBT();
         }

         this.player_use = nbt.getDouble("player_use");
         this.player_name = nbt.getString("player_name");
         this.card_1 = nbt.getBoolean("card_1");
         this.card_2 = nbt.getBoolean("card_2");
         this.card_3 = nbt.getBoolean("card_3");
         this.card_4 = nbt.getBoolean("card_4");
         this.card_5 = nbt.getBoolean("card_5");
         this.card_6 = nbt.getBoolean("card_6");
         this.card_7 = nbt.getBoolean("card_7");
         this.card_8 = nbt.getBoolean("card_8");
         this.card_9 = nbt.getBoolean("card_9");
         this.card_10 = nbt.getBoolean("card_10");
         this.card_11 = nbt.getBoolean("card_11");
         this.card_12 = nbt.getBoolean("card_12");
         this.card_13 = nbt.getBoolean("card_13");
         this.card_14 = nbt.getBoolean("card_14");
         this.card_15 = nbt.getBoolean("card_15");
         this.card_16 = nbt.getBoolean("card_16");
         this.card_17 = nbt.getBoolean("card_17");
         this.card_18 = nbt.getBoolean("card_18");
         this.card_19 = nbt.getBoolean("card_19");
         this.card_20 = nbt.getBoolean("card_20");
         this.card_21 = nbt.getBoolean("card_21");
         this.card_22 = nbt.getBoolean("card_22");
         this.card_23 = nbt.getBoolean("card_23");
         this.card_24 = nbt.getBoolean("card_24");
         this.card_25 = nbt.getBoolean("card_25");
         this.card_26 = nbt.getBoolean("card_26");
         this.card_27 = nbt.getBoolean("card_27");
         this.card_28 = nbt.getBoolean("card_28");
         this.card_29 = nbt.getBoolean("card_29");
         this.card_30 = nbt.getBoolean("card_30");
         this.card_31 = nbt.getBoolean("card_31");
         this.card_32 = nbt.getBoolean("card_32");
         this.card_33 = nbt.getBoolean("card_33");
         this.card_34 = nbt.getBoolean("card_34");
         this.card_35 = nbt.getBoolean("card_35");
         this.card_select_1 = nbt.getDouble("card_select_1");
         this.card_select_2 = nbt.getDouble("card_select_2");
         this.card_select_3 = nbt.getDouble("card_select_3");
         this.card_select_4 = nbt.getDouble("card_select_4");
         this.card_select_5 = nbt.getDouble("card_select_5");
         this.card_uses = nbt.getDouble("card_uses");
         this.rare_card = nbt.getDouble("rare_card");
         this.cards = nbt.getDouble("cards");
         this.card_36 = nbt.getBoolean("card_36");
         this.card_37 = nbt.getBoolean("card_37");
         this.card_38 = nbt.getBoolean("card_38");
         this.card_39 = nbt.getBoolean("card_39");
         this.card_40 = nbt.getBoolean("card_40");
         this.card_41 = nbt.getBoolean("card_41");
         this.card_42 = nbt.getBoolean("card_42");
         this.card_43 = nbt.getBoolean("card_43");
         this.dmg_player = nbt.getDouble("dmg_player");
         this.atks_player = nbt.getDouble("atks_player");
         this.atkr_player = nbt.getDouble("atkr_player");
         this.bounce_player = nbt.getDouble("bounce_player");
         this.dmg = nbt.getDouble("dmg");
         this.atkr = nbt.getDouble("atkr");
         this.bounce_pl = nbt.getDouble("bounce_pl");
         this.ammo = nbt.getDouble("ammo");
         this.atks = nbt.getDouble("atks");
         this.atks_reload = nbt.getDouble("atks_reload");
         this.pistol_anim = nbt.getDouble("pistol_anim");
         this.bullets = nbt.getDouble("bullets");
         this.cold = nbt.getDouble("cold");
         this.poison = nbt.getDouble("poison");
         this.leech = nbt.getDouble("leech");
         this.tg_bounce = nbt.getDouble("tg_bounce");
         this.homing = nbt.getDouble("homing");
         this.poison_lvl = nbt.getDouble("poison_lvl");
         this.cold_lvl = nbt.getDouble("cold_lvl");
         this.parazit_lvl = nbt.getDouble("parazit_lvl");
         this.parazit = nbt.getDouble("parazit");
         this.hp = nbt.getDouble("hp");
         this.shield_cooldawn = nbt.getDouble("shield_cooldawn");
         this.bomb_bullet = nbt.getDouble("bomb_bullet");
         this.explode_bullets = nbt.getDouble("explode_bullets");
         this.card20 = nbt.getDouble("card20");
         this.bullet_speed = nbt.getDouble("bullet_speed");
         this.empower = nbt.getDouble("empower");
         this.empower_charge = nbt.getDouble("empower_charge");
         this.dark_streng = nbt.getDouble("dark_streng");
         this.x = nbt.getDouble("x");
         this.z = nbt.getDouble("z");
         this.y = nbt.getDouble("y");
         this.card_4s = nbt.getDouble("card_4s");
         this.dark = nbt.getDouble("dark");
         this.card37 = nbt.getDouble("card37");
         this.card35 = nbt.getDouble("card35");
         this.card34 = nbt.getDouble("card34");
         this.card13 = nbt.getDouble("card13");
         this.card17 = nbt.getDouble("card17");
         this.grow = nbt.getDouble("grow");
         this.barage = nbt.getDouble("barage");
         this.leech_player = nbt.getDouble("leech_player");
         this.big_bullet = nbt.getDouble("big_bullet");
         this.card30 = nbt.getDouble("card30");
         this.truster_lvl = nbt.getDouble("truster_lvl");
         this.truster = nbt.getDouble("truster");
         this.phenix_tick = nbt.getDouble("phenix_tick");
         this.phenix = nbt.getDouble("phenix");
         this.phenix_lv = nbt.getDouble("phenix_lv");
         this.card9 = nbt.getDouble("card9");
         this.brawler = nbt.getDouble("brawler");
         this.brawler_i = nbt.getDouble("brawler_i");
         this.card41 = nbt.getDouble("card41");
         this.Super_nova_tick = nbt.getDouble("Super_nova_tick");
         this.Super_nova = nbt.getDouble("Super_nova");
         this.toxic = nbt.getDouble("toxic");
         this.team = nbt.getDouble("team");
         this.duzzle = nbt.getDouble("duzzle");
         this.Implode = nbt.getDouble("Implode");
         this.OverPower = nbt.getDouble("OverPower");
         this.RadarShot = nbt.getDouble("RadarShot");
         this.scavenger = nbt.getDouble("scavenger");
         this.shock_wave = nbt.getDouble("shock_wave");
         this.card_44 = nbt.getBoolean("card_44");
         this.card_45 = nbt.getBoolean("card_45");
         this.card_46 = nbt.getBoolean("card_46");
         this.card_47 = nbt.getBoolean("card_47");
         this.card_48 = nbt.getBoolean("card_48");
         this.card_49 = nbt.getBoolean("card_49");
         this.duzzle_lvl = nbt.getDouble("duzzle_lvl");
         this.num = nbt.getDouble("num");
         this.card_open = nbt.getDouble("card_open");
         this.blue_w = nbt.getDouble("blue_w");
         this.green_w = nbt.getDouble("green_w");
         this.red_w = nbt.getDouble("red_w");
         this.yellow_w = nbt.getDouble("yellow_w");
         this.selected = nbt.getBoolean("selected");
      }
   }

   @EventBusSubscriber
   private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
      private final RoundsNewModVariables.PlayerVariables playerVariables = new RoundsNewModVariables.PlayerVariables();
      private final LazyOptional<RoundsNewModVariables.PlayerVariables> instance = LazyOptional.of(() -> this.playerVariables);

      @SubscribeEvent
      public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
         if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer)) {
            event.addCapability(ResourceLocation.fromNamespaceAndPath("rounds_new", "player_variables"), new RoundsNewModVariables.PlayerVariablesProvider());
         }
      }

      public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
         return cap == RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY ? this.instance.cast() : LazyOptional.empty();
      }

      public Tag serializeNBT() {
         return this.playerVariables.writeNBT();
      }

      public void deserializeNBT(Tag nbt) {
         this.playerVariables.readNBT(nbt);
      }
   }

   public static class PlayerVariablesSyncMessage {
      private final int target;
      private final RoundsNewModVariables.PlayerVariables data;

      public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
         this.data = new RoundsNewModVariables.PlayerVariables();
         this.data.readNBT(buffer.readNbt());
         this.target = buffer.readInt();
      }

      public PlayerVariablesSyncMessage(RoundsNewModVariables.PlayerVariables data, int entityid) {
         this.data = data;
         this.target = entityid;
      }

      public static void buffer(RoundsNewModVariables.PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
         buffer.writeNbt((CompoundTag)message.data.writeNBT());
         buffer.writeInt(message.target);
      }

      public static void handler(RoundsNewModVariables.PlayerVariablesSyncMessage message, Supplier<Context> contextSupplier) {
         Context context = contextSupplier.get();
         context.enqueueWork(
            () -> {
               if (!context.getDirection().getReceptionSide().isServer()) {
                  RoundsNewModVariables.PlayerVariables variables = (RoundsNewModVariables.PlayerVariables)Minecraft.getInstance()
                     .player
                     .level()
                     .getEntity(message.target)
                     .getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new RoundsNewModVariables.PlayerVariables());
                  variables.player_use = message.data.player_use;
                  variables.player_name = message.data.player_name;
                  variables.card_1 = message.data.card_1;
                  variables.card_2 = message.data.card_2;
                  variables.card_3 = message.data.card_3;
                  variables.card_4 = message.data.card_4;
                  variables.card_5 = message.data.card_5;
                  variables.card_6 = message.data.card_6;
                  variables.card_7 = message.data.card_7;
                  variables.card_8 = message.data.card_8;
                  variables.card_9 = message.data.card_9;
                  variables.card_10 = message.data.card_10;
                  variables.card_11 = message.data.card_11;
                  variables.card_12 = message.data.card_12;
                  variables.card_13 = message.data.card_13;
                  variables.card_14 = message.data.card_14;
                  variables.card_15 = message.data.card_15;
                  variables.card_16 = message.data.card_16;
                  variables.card_17 = message.data.card_17;
                  variables.card_18 = message.data.card_18;
                  variables.card_19 = message.data.card_19;
                  variables.card_20 = message.data.card_20;
                  variables.card_21 = message.data.card_21;
                  variables.card_22 = message.data.card_22;
                  variables.card_23 = message.data.card_23;
                  variables.card_24 = message.data.card_24;
                  variables.card_25 = message.data.card_25;
                  variables.card_26 = message.data.card_26;
                  variables.card_27 = message.data.card_27;
                  variables.card_28 = message.data.card_28;
                  variables.card_29 = message.data.card_29;
                  variables.card_30 = message.data.card_30;
                  variables.card_31 = message.data.card_31;
                  variables.card_32 = message.data.card_32;
                  variables.card_33 = message.data.card_33;
                  variables.card_34 = message.data.card_34;
                  variables.card_35 = message.data.card_35;
                  variables.card_select_1 = message.data.card_select_1;
                  variables.card_select_2 = message.data.card_select_2;
                  variables.card_select_3 = message.data.card_select_3;
                  variables.card_select_4 = message.data.card_select_4;
                  variables.card_select_5 = message.data.card_select_5;
                  variables.card_uses = message.data.card_uses;
                  variables.rare_card = message.data.rare_card;
                  variables.cards = message.data.cards;
                  variables.card_36 = message.data.card_36;
                  variables.card_37 = message.data.card_37;
                  variables.card_38 = message.data.card_38;
                  variables.card_39 = message.data.card_39;
                  variables.card_40 = message.data.card_40;
                  variables.card_41 = message.data.card_41;
                  variables.card_42 = message.data.card_42;
                  variables.card_43 = message.data.card_43;
                  variables.dmg_player = message.data.dmg_player;
                  variables.atks_player = message.data.atks_player;
                  variables.atkr_player = message.data.atkr_player;
                  variables.bounce_player = message.data.bounce_player;
                  variables.dmg = message.data.dmg;
                  variables.atkr = message.data.atkr;
                  variables.bounce_pl = message.data.bounce_pl;
                  variables.ammo = message.data.ammo;
                  variables.atks = message.data.atks;
                  variables.atks_reload = message.data.atks_reload;
                  variables.pistol_anim = message.data.pistol_anim;
                  variables.bullets = message.data.bullets;
                  variables.cold = message.data.cold;
                  variables.poison = message.data.poison;
                  variables.leech = message.data.leech;
                  variables.tg_bounce = message.data.tg_bounce;
                  variables.homing = message.data.homing;
                  variables.poison_lvl = message.data.poison_lvl;
                  variables.cold_lvl = message.data.cold_lvl;
                  variables.parazit_lvl = message.data.parazit_lvl;
                  variables.parazit = message.data.parazit;
                  variables.hp = message.data.hp;
                  variables.shield_cooldawn = message.data.shield_cooldawn;
                  variables.bomb_bullet = message.data.bomb_bullet;
                  variables.explode_bullets = message.data.explode_bullets;
                  variables.card20 = message.data.card20;
                  variables.bullet_speed = message.data.bullet_speed;
                  variables.empower = message.data.empower;
                  variables.empower_charge = message.data.empower_charge;
                  variables.dark_streng = message.data.dark_streng;
                  variables.x = message.data.x;
                  variables.z = message.data.z;
                  variables.y = message.data.y;
                  variables.card_4s = message.data.card_4s;
                  variables.dark = message.data.dark;
                  variables.card37 = message.data.card37;
                  variables.card35 = message.data.card35;
                  variables.card34 = message.data.card34;
                  variables.card13 = message.data.card13;
                  variables.card17 = message.data.card17;
                  variables.grow = message.data.grow;
                  variables.barage = message.data.barage;
                  variables.leech_player = message.data.leech_player;
                  variables.big_bullet = message.data.big_bullet;
                  variables.card30 = message.data.card30;
                  variables.truster_lvl = message.data.truster_lvl;
                  variables.truster = message.data.truster;
                  variables.phenix_tick = message.data.phenix_tick;
                  variables.phenix = message.data.phenix;
                  variables.phenix_lv = message.data.phenix_lv;
                  variables.card9 = message.data.card9;
                  variables.brawler = message.data.brawler;
                  variables.brawler_i = message.data.brawler_i;
                  variables.card41 = message.data.card41;
                  variables.Super_nova_tick = message.data.Super_nova_tick;
                  variables.Super_nova = message.data.Super_nova;
                  variables.toxic = message.data.toxic;
                  variables.team = message.data.team;
                  variables.duzzle = message.data.duzzle;
                  variables.Implode = message.data.Implode;
                  variables.OverPower = message.data.OverPower;
                  variables.RadarShot = message.data.RadarShot;
                  variables.scavenger = message.data.scavenger;
                  variables.shock_wave = message.data.shock_wave;
                  variables.card_44 = message.data.card_44;
                  variables.card_45 = message.data.card_45;
                  variables.card_46 = message.data.card_46;
                  variables.card_47 = message.data.card_47;
                  variables.card_48 = message.data.card_48;
                  variables.card_49 = message.data.card_49;
                  variables.duzzle_lvl = message.data.duzzle_lvl;
                  variables.num = message.data.num;
                  variables.card_open = message.data.card_open;
                  variables.blue_w = message.data.blue_w;
                  variables.green_w = message.data.green_w;
                  variables.red_w = message.data.red_w;
                  variables.yellow_w = message.data.yellow_w;
                  variables.selected = message.data.selected;
               }
            }
         );
         context.setPacketHandled(true);
      }
   }

   public static class SavedDataSyncMessage {
      private final int type;
      private SavedData data;

      public SavedDataSyncMessage(FriendlyByteBuf buffer) {
         this.type = buffer.readInt();
         CompoundTag nbt = buffer.readNbt();
         if (nbt != null) {
            this.data = (SavedData)(this.type == 0 ? new RoundsNewModVariables.MapVariables() : new RoundsNewModVariables.WorldVariables());
            if (this.data instanceof RoundsNewModVariables.MapVariables mapVariables) {
               mapVariables.read(nbt);
            } else if (this.data instanceof RoundsNewModVariables.WorldVariables worldVariables) {
               worldVariables.read(nbt);
            }
         }
      }

      public SavedDataSyncMessage(int type, SavedData data) {
         this.type = type;
         this.data = data;
      }

      public static void buffer(RoundsNewModVariables.SavedDataSyncMessage message, FriendlyByteBuf buffer) {
         buffer.writeInt(message.type);
         if (message.data != null) {
            buffer.writeNbt(message.data.save(new CompoundTag()));
         }
      }

      public static void handler(RoundsNewModVariables.SavedDataSyncMessage message, Supplier<Context> contextSupplier) {
         Context context = contextSupplier.get();
         context.enqueueWork(() -> {
            if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
               if (message.type == 0) {
                  RoundsNewModVariables.MapVariables.clientSide = (RoundsNewModVariables.MapVariables)message.data;
               } else {
                  RoundsNewModVariables.WorldVariables.clientSide = (RoundsNewModVariables.WorldVariables)message.data;
               }
            }
         });
         context.setPacketHandled(true);
      }
   }

   public static class WorldVariables extends SavedData {
      public static final String DATA_NAME = "rounds_new_worldvars";
      static RoundsNewModVariables.WorldVariables clientSide = new RoundsNewModVariables.WorldVariables();

      public static RoundsNewModVariables.WorldVariables load(CompoundTag tag) {
         RoundsNewModVariables.WorldVariables data = new RoundsNewModVariables.WorldVariables();
         data.read(tag);
         return data;
      }

      public void read(CompoundTag nbt) {
      }

      public CompoundTag save(CompoundTag nbt) {
         return nbt;
      }

      public void syncData(LevelAccessor world) {
         this.setDirty();
         if (world instanceof Level level && !level.isClientSide()) {
            RoundsNewMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new RoundsNewModVariables.SavedDataSyncMessage(1, this));
         }
      }

      public static RoundsNewModVariables.WorldVariables get(LevelAccessor world) {
         return world instanceof ServerLevel level
            ? (RoundsNewModVariables.WorldVariables)level.getDataStorage()
               .computeIfAbsent(e -> load(e), RoundsNewModVariables.WorldVariables::new, "rounds_new_worldvars")
            : clientSide;
      }
   }
}
