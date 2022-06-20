package copperplus.core;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StoneButtonBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CopperPlusBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, copperplus.core.CopperPlus.MOD_ID);
	
	// Functional blocks.
	public static final RegistryObject<Block> COPPER_BUTTON = registerBlock("copper_button",
			() -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL).strength(1F)), CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Block> COPPER_DOOR = registerBlock("copper_door",
			() -> new DoorBlock(BlockBehaviour.Properties.of(Material.METAL).strength(3F).noOcclusion()), CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Block> COPPER_PRESSURE_PLATE = registerBlock("copper_pressure_plate",
			() -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.METAL).strength(1F)),
				CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Block> COPPER_TRAPDOOR = registerBlock("copper_trapdoor",
			() -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.METAL).strength(3F).noOcclusion()), CreativeModeTab.TAB_REDSTONE);
	
	// Decorative blocks.
	public static final RegistryObject<Block> COPPER_BARS = registerBlock("copper_bars",
			() -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4F).sound(SoundType.METAL).noOcclusion()),
				CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> COPPER_CHAIN = registerBlock("copper_chain",
			() -> new ChainBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4F).sound(SoundType.METAL).noOcclusion()), 
				CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> COPPER_LANTERN = registerBlock("copper_lantern",
			() -> new LanternBlock(BlockBehaviour.Properties.of(Material.METAL).strength(1F, 1.5F).sound(SoundType.LANTERN).noOcclusion().
					lightLevel(BlockState -> 15)), CreativeModeTab.TAB_DECORATIONS);
	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn, tab);
		return toReturn;
	}
	
	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
		return copperplus.core.CopperPlusItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
