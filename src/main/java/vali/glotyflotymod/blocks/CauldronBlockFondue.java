package vali.glotyflotymod.blocks;

import net.minecraft.block.CauldronBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class CauldronBlockFondue extends CauldronBlock{

	public CauldronBlockFondue(ResourceLocation res) {
		super(CauldronBlock.Properties
				.create(Material.GOURD)
				);
		this.setRegistryName(res);
	}

}
