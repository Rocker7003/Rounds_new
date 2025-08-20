package net.mcreator.roundsnew.init;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RoundsNewModParticleTypes {
   public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, "rounds_new");
   public static final RegistryObject<SimpleParticleType> S = REGISTRY.register("s", () -> new SimpleParticleType(false));
   public static final RegistryObject<SimpleParticleType> D = REGISTRY.register("d", () -> new SimpleParticleType(false));
   public static final RegistryObject<SimpleParticleType> A = REGISTRY.register("a", () -> new SimpleParticleType(false));
   public static final RegistryObject<SimpleParticleType> W = REGISTRY.register("w", () -> new SimpleParticleType(false));
}
