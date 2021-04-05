package vali.glotyflotymod.items;

import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import vali.glotyflotymod.lists.FluidList;

public class BucketItemFondue extends BucketItem{

	public BucketItemFondue(ResourceLocation res) {
		super(()->FluidList.flowing_fondue,new Item.Properties()
				.group(ItemGroup.FOOD)
				.maxStackSize(1)
				);
		this.setRegistryName(res);
	}

}
