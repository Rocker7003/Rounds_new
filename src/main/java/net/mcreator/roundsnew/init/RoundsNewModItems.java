package net.mcreator.roundsnew.init;

import net.mcreator.roundsnew.item.GunItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RoundsNewModItems {
   public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, "rounds_new");
   public static final RegistryObject<Item> BULLET_SPAWN_EGG = REGISTRY.register(
      "bullet_spawn_egg", () -> new ForgeSpawnEggItem(RoundsNewModEntities.BULLET, -3355648, -1, new Properties())
   );
   public static final RegistryObject<Item> GUN = REGISTRY.register("gun", () -> new GunItem());
   public static final RegistryObject<Item> BOMB_SPAWN_EGG = REGISTRY.register(
      "bomb_spawn_egg", () -> new ForgeSpawnEggItem(RoundsNewModEntities.BOMB, -3355648, -1, new Properties())
   );
   public static final RegistryObject<Item> RINGHEAL_SPAWN_EGG = REGISTRY.register(
      "ringheal_spawn_egg", () -> new ForgeSpawnEggItem(RoundsNewModEntities.RINGHEAL, -3355648, -1, new Properties())
   );
   public static final RegistryObject<Item> BOMBSHIELD_SPAWN_EGG = REGISTRY.register(
      "bombshield_spawn_egg", () -> new ForgeSpawnEggItem(RoundsNewModEntities.BOMBSHIELD, -3355648, -1, new Properties())
   );
   public static final RegistryObject<Item> RINGTOXIC_SPAWN_EGG = REGISTRY.register(
      "ringtoxic_spawn_egg", () -> new ForgeSpawnEggItem(RoundsNewModEntities.RINGTOXIC, -3355648, -1, new Properties())
   );
   public static final RegistryObject<Item> BLOCKJOINBLUE = block(RoundsNewModBlocks.BLOCKJOINBLUE);
   public static final RegistryObject<Item> BLOCKJOINRED = block(RoundsNewModBlocks.BLOCKJOINRED);
   public static final RegistryObject<Item> BLOCKJOINYELLOW = block(RoundsNewModBlocks.BLOCKJOINYELLOW);
   public static final RegistryObject<Item> BLOCKJOINGREEN = block(RoundsNewModBlocks.BLOCKJOINGREEN);
   public static final RegistryObject<Item> BLACK = block(RoundsNewModBlocks.BLACK);

   private static RegistryObject<Item> block(RegistryObject<Block> block) {
      return REGISTRY.register(block.getId().getPath(), () -> new BlockItem((Block)block.get(), new Properties()));
   }
}
