package net.mcreator.roundsnew.procedures;

import net.mcreator.roundsnew.network.RoundsNewModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ClearplayerProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getCapability(RoundsNewModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.dmg = 8.0;
                capability.atkr = 10.0;
                capability.bounce_pl = 0.0;
                capability.ammo = 3.0;
                capability.bullet_speed = 2.0;
                capability.atks = 15.0;
                capability.hp = 20.0;
                capability.atks_reload = 90.0;
                capability.pistol_anim = 0.0;
                capability.bullets = 0.0;
                capability.card37 = 0.0;
                capability.duzzle = 0.0;
                capability.Implode = 0.0;
                capability.OverPower = 0.0;
                capability.RadarShot = 0.0;
                capability.scavenger = 0.0;
                capability.shock_wave = 0.0;
                capability.cold = 0.0;
                capability.grow = 0.0;
                capability.poison = 0.0;
                capability.leech = 0.0;
                capability.bomb_bullet = 0.0;
                capability.tg_bounce = 0.0;
                capability.homing = 0.0;
                capability.parazit = 0.0;
                capability.parazit_lvl = 0.0;
                capability.cold_lvl = 0.0;
                capability.poison_lvl = 0.0;
                capability.explode_bullets = 0.0;
                capability.card20 = 0.0;
                capability.shield_cooldawn = 180.0;
                capability.empower = 0.0;
                capability.dark_streng = 0.0;
                capability.empower_charge = 0.0;
                capability.card_4s = 0.0;
                capability.card35 = 0.0;
                capability.card34 = 0.0;
                capability.card13 = 0.0;
                capability.card17 = 0.0;
                capability.barage = 0.0;
                capability.leech_player = 0.0;
                capability.big_bullet = 0.0;
                capability.card30 = 0.0;
                capability.truster_lvl = 0.0;
                capability.truster = 0.0;
                capability.phenix_tick = 0.0;
                capability.phenix = 0.0;
                capability.phenix_lv = 0.0;
                capability.Super_nova = 0.0;
                capability.Super_nova_tick = 0.0;
                capability.toxic = 0.0;
                capability.card41 = 0.0;
                capability.brawler = 0.0;
                capability.card9 = 0.0;
                capability.syncPlayerVariables(entity);
            });
            entity.getPersistentData().putDouble("shield", 0.0);
            entity.getPersistentData().putDouble("shield_d", 0.0);
            HpProcedure.execute(entity);
            if (entity instanceof LivingEntity _entity) {
                _entity.setHealth(999.0F);
            }
        }
    }
}