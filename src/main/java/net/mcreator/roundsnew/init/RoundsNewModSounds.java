package net.mcreator.roundsnew.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RoundsNewModSounds {
   public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "rounds_new");
   public static final RegistryObject<SoundEvent> SHOOT = REGISTRY.register(
      "shoot", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("rounds_new", "shoot"))
   );
   public static final RegistryObject<SoundEvent> HEAL = REGISTRY.register(
      "heal", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("rounds_new", "heal"))
   );
   public static final RegistryObject<SoundEvent> SHOOT_RECLIPSE = REGISTRY.register(
      "shoot_reclipse", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("rounds_new", "shoot_reclipse"))
   );
   public static final RegistryObject<SoundEvent> SOUND1 = REGISTRY.register(
      "sound1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("rounds_new", "sound1"))
   );
   public static final RegistryObject<SoundEvent> SOUND2 = REGISTRY.register(
      "sound2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("rounds_new", "sound2"))
   );
   public static final RegistryObject<SoundEvent> SOUND3 = REGISTRY.register(
      "sound3", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("rounds_new", "sound3"))
   );
   public static final RegistryObject<SoundEvent> SOUND4 = REGISTRY.register(
      "sound4", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("rounds_new", "sound4"))
   );
   public static final RegistryObject<SoundEvent> SOUND5 = REGISTRY.register(
      "sound5", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("rounds_new", "sound5"))
   );
}
