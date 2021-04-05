package vali.glotyflotymod.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import vali.glotyflotymod.lists.ItemList;

public class CauldronBlockFondue extends CauldronBlock{

	public CauldronBlockFondue(ResourceLocation res) {
		super(CauldronBlock.Properties
				.create(Material.GOURD)
				);
		this.setRegistryName(res);
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult blockRayTraceResult) {
		Item fonduebucket = ItemList.fondue_bucket;
		Item waterbucket = ForgeRegistries.ITEMS.getValue(new ResourceLocation("water_bucket"));
		
		//replace to water from fondue on fill
		if(ItemStack.areItemsEqual(player.getHeldItem(hand), new ItemStack(fonduebucket))) {
			player.setHeldItem(Hand.MAIN_HAND, new ItemStack(waterbucket));
		}
		
		//main bucket-super-logic
		ActionResultType res = super.onBlockActivated(state, world, pos, player, hand, blockRayTraceResult);
		
		//replace to fondue from water on drain
		if(ItemStack.areItemsEqual(player.getHeldItem(hand), new ItemStack(waterbucket))) {
			player.setHeldItem(Hand.MAIN_HAND, new ItemStack(fonduebucket));
		}
		
		return res;
	}

}
