package vali.glotyflotymod.enums;

import vali.glotyflotymod.lists.ItemList;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundEvent;


public enum AdditionalArmorMaterial implements IArmorMaterial{
	
	CHEESE(
			0,							//maxDamage
			new int[] {7,9,11,7},		//damageReductionAmountArrray
			0,							//enchantability
			0f,							//thoughness
			null,						//soundEvent
			ItemList.cheese_item,		//repairMaterial
			"glotyflotymod:cheese"		//name
			);
	
	private static final int[] MAX_DAMAGE_ARRAY = {16,16,16,16};
	
	private final int maxDamage, enchantability;
	private final int[] damageReductionAmountArray;
	private final float thoughness;
	private final SoundEvent soundEvent;
	private final String name;
	private final IItemProvider repairMaterial;

	
	private AdditionalArmorMaterial(
			int maxDamage,
			int[] damageReductionAmountArrray,
			int enchantability,
			float thoughness,
			SoundEvent soundEvent,
			IItemProvider repairMaterial,
			String name
			) {
		this.maxDamage = maxDamage;
		this.damageReductionAmountArray = damageReductionAmountArrray;
		this.enchantability = enchantability;
		this.thoughness = thoughness;
		this.soundEvent = soundEvent;
		this.repairMaterial = repairMaterial;
		this.name = name;
	}

	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamage;
		}
	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
		}
	@Override
	public int getEnchantability() {return this.enchantability;}
	@Override
	public SoundEvent getSoundEvent() {return this.soundEvent;}
	@Override
	public Ingredient getRepairMaterial() {return Ingredient.fromItems(this.repairMaterial);}
	@Override
	public String getName() {return this.name;}
	@Override
	public float getToughness() {return this.thoughness;}
	@Override
	public float func_230304_f_() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
