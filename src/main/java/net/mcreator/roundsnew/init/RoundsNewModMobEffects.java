package net.mcreator.roundsnew.init;

import net.mcreator.roundsnew.potion.CardMobEffect;
import net.mcreator.roundsnew.potion.ReloadMobEffect;
import net.mcreator.roundsnew.potion.StartMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RoundsNewModMobEffects {
   public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "rounds_new");
   public static final RegistryObject<MobEffect> RELOAD = REGISTRY.register("reload", () -> new ReloadMobEffect());
   public static final RegistryObject<MobEffect> START = REGISTRY.register("start", () -> new StartMobEffect());
   public static final RegistryObject<MobEffect> CARD = REGISTRY.register("card", () -> new CardMobEffect());
}
