package vali.glotyflotymod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import vali.glotyflotymod.enums.AdditionalItemTier;
import vali.glotyflotymod.lists.BlockList;
import vali.glotyflotymod.lists.ItemList;

@Mod("glotyflotymod")
public class Main {
	
	public static Main instance;
	public static final String MODID = "glotyflotymod";
	
	private static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public Main() {
		instance = this;
		
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
				//Cheese_Item
				ItemList.cheese_item = new Item(
						new Item.Properties()
							.group(ItemGroup.FOOD)
							.food(
									new Food.Builder()
										.hunger(6)
										.saturation(1.2f)
										.build()
									)
						).setRegistryName(new ResourceLocation(MODID, "cheese_item")),
				
				//Cheese_Block
				ItemList.cheese_block = new BlockItem(
						BlockList.cheese_block, 
						new Item.Properties()
							.group(ItemGroup.DECORATIONS)
						).setRegistryName(BlockList.cheese_block.getRegistryName()),
				
				//Cheese_Sword
				ItemList.cheese_sword = new SwordItem(AdditionalItemTier.CHEESE, 7, 2.0F, new Item.Properties()
						.group(ItemGroup.COMBAT)
						.food(
								new Food.Builder()
								.hunger(6)
								.saturation(1.2f)
								.build()
							)
						).setRegistryName(new ResourceLocation(MODID, "cheese_sword"))			
			);
		}
		
		@SubscribeEvent
		public static void registerBlock(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll
			(
				//Cheese_Block
				BlockList.cheese_block = new Block(
						Block.Properties.create(Material.GOURD)
							.hardnessAndResistance(2.0f,3.0f)
							.sound(SoundType.GROUND)
						).setRegistryName(new ResourceLocation(MODID, "cheese_block"))						
			);
		}
	}
}
