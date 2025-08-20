package net.mcreator.roundsnew.init;

import net.mcreator.roundsnew.block.entity.BlackBlockEntity;
import net.mcreator.roundsnew.block.entity.BlockjoinblueBlockEntity;
import net.mcreator.roundsnew.block.entity.BlockjoingreenBlockEntity;
import net.mcreator.roundsnew.block.entity.BlockjoinredBlockEntity;
import net.mcreator.roundsnew.block.entity.BlockjoinyellowBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RoundsNewModBlockEntities {
   public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "rounds_new");
   public static final RegistryObject<BlockEntityType<?>> BLOCKJOINBLUE = register(
      "blockjoinblue", RoundsNewModBlocks.BLOCKJOINBLUE, BlockjoinblueBlockEntity::new
   );
   public static final RegistryObject<BlockEntityType<?>> BLOCKJOINRED = register("blockjoinred", RoundsNewModBlocks.BLOCKJOINRED, BlockjoinredBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> BLOCKJOINYELLOW = register(
      "blockjoinyellow", RoundsNewModBlocks.BLOCKJOINYELLOW, BlockjoinyellowBlockEntity::new
   );
   public static final RegistryObject<BlockEntityType<?>> BLOCKJOINGREEN = register(
      "blockjoingreen", RoundsNewModBlocks.BLOCKJOINGREEN, BlockjoingreenBlockEntity::new
   );
   public static final RegistryObject<BlockEntityType<?>> BLACK = register("black", RoundsNewModBlocks.BLACK, BlackBlockEntity::new);

   private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntitySupplier<?> supplier) {
      return REGISTRY.register(registryname, () -> Builder.of(supplier, new Block[]{(Block)block.get()}).build(null));
   }
}
