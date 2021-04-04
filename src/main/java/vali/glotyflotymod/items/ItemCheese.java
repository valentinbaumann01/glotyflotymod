package vali.glotyflotymod.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import vali.glotyflotymod.Main;

public class ItemCheese extends Item {
	
	public ItemCheese(ResourceLocation res) {
		super(new Item.Properties()
				.group(ItemGroup.FOOD)
				.food(Main.foodBuilder)
				);
		
		this.setRegistryName(res);
	}

}
