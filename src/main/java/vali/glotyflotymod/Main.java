package vali.glotyflotymod;

import vali.glotyflotymod.blocks.BlockCheese;
import vali.glotyflotymod.items.ArmorItemCheeseBoots;
import vali.glotyflotymod.items.ArmorItemCheeseChestplate;
import vali.glotyflotymod.items.ArmorItemCheeseHelmet;
import vali.glotyflotymod.items.ArmorItemCheeseLeggins;
import vali.glotyflotymod.items.AxeItemCheese;
import vali.glotyflotymod.items.BlockItemCheese;
import vali.glotyflotymod.items.HoeItemCheese;
import vali.glotyflotymod.items.ItemCheese;
import vali.glotyflotymod.items.PickaxeItemCheese;
import vali.glotyflotymod.items.ShovelItemCheese;
import vali.glotyflotymod.items.SwordItemCheese;
import vali.glotyflotymod.lists.BlockList;
import vali.glotyflotymod.lists.ItemList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("glotyflotymod")
public class Main {
	
	public static final String MODID = "glotyflotymod";	
	private static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final Food foodBuilder = new Food.Builder()
			.hunger(6)
			.saturation(1.2f)
			.build();
	
	public Main() {
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegisteries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		LOGGER.info("setup made");
	}
	
	private void clientRegisteries(final FMLClientSetupEvent event) {
		LOGGER.info("clientRegister made");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegstryEvent{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll
			(
				ItemList.cheese_item = new ItemCheese(new ResourceLocation(MODID, "cheese_item")),
				
				ItemList.cheese_block = new BlockItemCheese(),
				
				ItemList.cheese_sword = new SwordItemCheese(new ResourceLocation(MODID, "cheese_sword")),
				
				ItemList.cheese_pickaxe = new PickaxeItemCheese(new ResourceLocation(MODID, "cheese_pickaxe")),
				
				ItemList.cheese_shovel = new ShovelItemCheese(new ResourceLocation(MODID, "cheese_shovel")),
				
				ItemList.cheese_axe = new AxeItemCheese(new ResourceLocation(MODID, "cheese_axe")),
				
				ItemList.cheese_hoe = new HoeItemCheese(new ResourceLocation(MODID, "cheese_hoe")),
				
				ItemList.cheese_helmet = new ArmorItemCheeseHelmet(new ResourceLocation(MODID, "cheese_helmet")),
				
				ItemList.cheese_chestplate = new ArmorItemCheeseChestplate(new ResourceLocation(MODID, "cheese_chestplate")),
				
				ItemList.cheese_leggings = new ArmorItemCheeseLeggins(new ResourceLocation(MODID, "cheese_leggings")),
				
				ItemList.cheese_boots = new ArmorItemCheeseBoots(new ResourceLocation(MODID, "cheese_boots"))
				);
		}
		
		@SubscribeEvent
		public static void registerBlock(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll
			(
				BlockList.cheese_block = new BlockCheese(new ResourceLocation(MODID, "cheese_block"))						
			);
		}
	}
}
