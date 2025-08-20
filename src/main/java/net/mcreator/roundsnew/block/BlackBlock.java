package net.mcreator.roundsnew.block;

import java.util.Collections;
import java.util.List;
import net.mcreator.roundsnew.block.entity.BlackBlockEntity;
import net.mcreator.roundsnew.procedures.BlackEntityCollidesInTheBlockProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;

public class BlackBlock extends Block implements EntityBlock {
   public static final DirectionProperty FACING = DirectionalBlock.FACING;

   public BlackBlock() {
      super(Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.EMPTY).strength(1.0F, 10.0F).noCollission());
      this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
   }

   public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      builder.add(new Property[]{FACING});
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      return (BlockState)this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
   }

   public BlockState rotate(BlockState state, Rotation rot) {
      return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
   }

   public BlockState mirror(BlockState state, Mirror mirrorIn) {
      return state.rotate(mirrorIn.getRotation((Direction)state.getValue(FACING)));
   }

   public List<ItemStack> getDrops(BlockState state, net.minecraft.world.level.storage.loot.LootParams.Builder builder) {
      List<ItemStack> dropsOriginal = super.getDrops(state, builder);
      return !dropsOriginal.isEmpty() ? dropsOriginal : Collections.singletonList(new ItemStack(this, 1));
   }

   public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
      super.entityInside(blockstate, world, pos, entity);
      BlackEntityCollidesInTheBlockProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), entity);
   }

   public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
      return worldIn.getBlockEntity(pos) instanceof MenuProvider menuProvider ? menuProvider : null;
   }

   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new BlackBlockEntity(pos, state);
   }

   public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.triggerEvent(state, world, pos, eventID, eventParam);
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
   }

   public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
      if (state.getBlock() != newState.getBlock()) {
         if (world.getBlockEntity(pos) instanceof BlackBlockEntity be) {
            Containers.dropContents(world, pos, be);
            world.updateNeighbourForOutputSignal(pos, this);
         }

         super.onRemove(state, world, pos, newState, isMoving);
      }
   }

   public boolean hasAnalogOutputSignal(BlockState state) {
      return true;
   }

   public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
      return world.getBlockEntity(pos) instanceof BlackBlockEntity be ? AbstractContainerMenu.getRedstoneSignalFromContainer(be) : 0;
   }
}
