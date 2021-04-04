package vali.glotyflotymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockCheese extends Block{

	public BlockCheese(ResourceLocation res) {
		super(Block.Properties.create(Material.GOURD)
				.hardnessAndResistance(2.0f,3.0f)
				.sound(SoundType.GROUND)
				);
		this.setRegistryName(res);
	}

}
