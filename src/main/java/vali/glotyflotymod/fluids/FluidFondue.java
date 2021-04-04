package vali.glotyflotymod.fluids;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fluids.FluidAttributes;
import vali.glotyflotymod.Main;
import vali.glotyflotymod.lists.BlockList;
import vali.glotyflotymod.lists.FluidList;
import vali.glotyflotymod.lists.ItemList;

public abstract class FluidFondue extends FlowingFluid{

	@Override
	public Fluid getFlowingFluid() {
		return FluidList.flowing_fondue;
	}

	@Override
	public Fluid getStillFluid() {
		return FluidList.fondue;
	}
	
	@Override
	protected boolean canSourcesMultiply() {
		return false;
	}
	
	@Override
	protected void beforeReplacingBlock(IWorld arg0, BlockPos arg1, BlockState arg2) {
	}

	@Override
	protected int getSlopeFindDistance(IWorldReader arg0) {
		return 4;
	}
	
	@Override
	protected int getLevelDecreasePerBlock(IWorldReader arg0) {
		return 3;
	}

	@Override
	public Item getFilledBucket() {
		return ItemList.fondue_bucket;
	}

	@Override
	protected boolean canDisplace(FluidState state, IBlockReader reader, BlockPos pos, Fluid fluid, Direction dir) {
		return dir == Direction.DOWN && !fluid.isIn(FluidList.Tags.FONDUE);
	}

	@Override
	public int getTickRate(IWorldReader p_205569_1_) {
		return 60;
	}

	@Override
	protected float getExplosionResistance() {
		return 100.0f;
	}

	@Override
	protected BlockState getBlockState(FluidState state) {
		return BlockList.fondue
				.getDefaultState()
				.with(
						FlowingFluidBlock.LEVEL, 
						Integer.valueOf(getLevelFromState(state))
						);	
	}
	
	@Override
	public boolean isEquivalentTo(Fluid fluid) {
		return fluid == FluidList.fondue || fluid == FluidList.flowing_fondue;
	}
	
	@Override
	protected FluidAttributes createAttributes() {
		return FluidAttributes.builder(new ResourceLocation(Main.MODID , "block/fondue_still"), new ResourceLocation(Main.MODID , "block/fondue_flow"))
				.translationKey("block.glotyflotymod.fondue")
				.build(this);
	}
	
	public static class Flowing extends FluidFondue{
		@Override
		protected void fillStateContainer(Builder<Fluid, FluidState> builder) {
			super.fillStateContainer(builder);
			builder.add(LEVEL_1_8);
		}
		
		@Override
		public boolean isSource(FluidState state) {
			return false;
		}

		@Override
		public int getLevel(FluidState state) {
			return state.get(FluidFondue.LEVEL_1_8);
		}
		
	}
	
	public static class Source extends FluidFondue{

		@Override
		public boolean isSource(FluidState state) {
			return true;
		}

		@Override
		public int getLevel(FluidState state) {
			return 8;
		}
		
	}
}
