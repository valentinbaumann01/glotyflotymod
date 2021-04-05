package vali.glotyflotymod.items;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import vali.glotyflotymod.lists.BlockList;

public class BlockItemCauldron extends BlockItem{

	public BlockItemCauldron(ResourceLocation res) {
		super(BlockList.fondue_cauldron, new Item.Properties()
				.group(ItemGroup.FOOD)
				);
		this.setRegistryName(res);
	}

}
