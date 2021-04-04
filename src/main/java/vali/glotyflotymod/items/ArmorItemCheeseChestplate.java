package vali.glotyflotymod.items;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import vali.glotyflotymod.Main;
import vali.glotyflotymod.enums.AdditionalArmorMaterial;

public class ArmorItemCheeseChestplate extends ArmorItem{

	public ArmorItemCheeseChestplate(ResourceLocation res) {
		super(	AdditionalArmorMaterial.CHEESE, EquipmentSlotType.CHEST, new Item.Properties()	
				.group(ItemGroup.COMBAT)
				.food(Main.foodBuilder)
				);
		
		this.setRegistryName(res);
	}

}
