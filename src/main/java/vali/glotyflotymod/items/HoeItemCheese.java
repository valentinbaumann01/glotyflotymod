package vali.glotyflotymod.items;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import vali.glotyflotymod.Main;
import vali.glotyflotymod.enums.AdditionalItemTier;

public class HoeItemCheese extends HoeItem{

	public HoeItemCheese(ResourceLocation res) {
		super(AdditionalItemTier.CHEESE, 7, 2.0F, new Item.Properties()
				.group(ItemGroup.COMBAT)
				.food(Main.foodBuilder)
				);

		this.setRegistryName(res);
	}

}
