package vali.glotyflotymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import vali.glotyflotymod.lists.FluidList;

public class FlowingFluidBlockFondue extends FlowingFluidBlock{

	public FlowingFluidBlockFondue(ResourceLocation res) {
		super(()-> FluidList.fondue, Block.Properties
				.create(Material.WATER)
				.doesNotBlockMovement()
				.noDrops()
				);
		this.setRegistryName(res);
	}

}
