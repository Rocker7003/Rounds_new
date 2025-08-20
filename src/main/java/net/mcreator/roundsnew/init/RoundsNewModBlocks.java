package net.mcreator.roundsnew.init;

import net.mcreator.roundsnew.block.BlackBlock;
import net.mcreator.roundsnew.block.BlockjoinblueBlock;
import net.mcreator.roundsnew.block.BlockjoingreenBlock;
import net.mcreator.roundsnew.block.BlockjoinredBlock;
import net.mcreator.roundsnew.block.BlockjoinyellowBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RoundsNewModBlocks {
   public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, "rounds_new");
   public static final RegistryObject<Block> BLOCKJOINBLUE = REGISTRY.register("blockjoinblue", () -> new BlockjoinblueBlock());
   public static final RegistryObject<Block> BLOCKJOINRED = REGISTRY.register("blockjoinred", () -> new BlockjoinredBlock());
   public static final RegistryObject<Block> BLOCKJOINYELLOW = REGISTRY.register("blockjoinyellow", () -> new BlockjoinyellowBlock());
   public static final RegistryObject<Block> BLOCKJOINGREEN = REGISTRY.register("blockjoingreen", () -> new BlockjoingreenBlock());
   public static final RegistryObject<Block> BLACK = REGISTRY.register("black", () -> new BlackBlock());
}
