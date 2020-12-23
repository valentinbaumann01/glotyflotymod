package vali.glotyflotymod.enums;

import vali.glotyflotymod.lists.ItemList;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;


public enum AdditionalItemTier implements IItemTier{

	CHEESE(4,1500,15.0F, 7.0F, 250, ItemList.cheese_item);
	
	private final int harvestLevel, maxUses, enchantability;
	private final float efficiency, attackDamage;
	private final IItemProvider repairMaterial;
	
	private AdditionalItemTier(
			int harvestLevel,
			int maxUses,
			float efficiency,
			float attackDamage,
			int enchantability,
			IItemProvider repairMaterial
			) {
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial; 
	}

	@Override
	public int getMaxUses() {return this.maxUses;}
	@Override
	public float getEfficiency() {return this.efficiency;}
	@Override
	public float getAttackDamage() {return this.attackDamage;}
	@Override
	public int getHarvestLevel() {return this.harvestLevel;}
	@Override
	public int getEnchantability() {return this.enchantability;}
	@Override
	public Ingredient getRepairMaterial() {return Ingredient.fromItems(this.repairMaterial);}
	
}
