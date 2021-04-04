package vali.glotyflotymod.items;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import vali.glotyflotymod.lists.BlockList;

public class BlockItemCheese extends BlockItem{

	public BlockItemCheese() {
		super(BlockList.cheese_block, new Item.Properties()
				.group(ItemGroup.DECORATIONS)
				);
		
		this.setRegistryName(BlockList.cheese_block.getRegistryName());
	}
}
