package copperplus.core;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CopperPlusItems {
	public static final DeferredRegister<Item> ITEMS =
			DeferredRegister.create(ForgeRegistries.ITEMS, copperplus.core.CopperPlus.MOD_ID);

	// First, let's start with copper tools.
	public static final RegistryObject<AxeItem> COPPER_AXE = ITEMS.register("copper_axe",
			() -> new AxeItem(CopperTier.COPPER, 6.0F, -3.1F,
					(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS))));
	public static final RegistryObject<Item> COPPER_FISHING_ROD = ITEMS.register("copper_fishing_rod",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe",
			() -> new HoeItem(CopperTier.COPPER, -2, -1.0F,
					(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS))));
	public static final RegistryObject<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
			() -> new PickaxeItem(CopperTier.COPPER, 1, -2.8F,
					(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS))));
	public static final RegistryObject<ShearsItem> COPPER_SHEARS = ITEMS.register("copper_shears",
			() -> new ShearsItem((new Item.Properties()).durability(150).tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel",
			() -> new ShovelItem(CopperTier.COPPER, 1.5F, -3.0F,
					(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS))));
	public static final RegistryObject<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword",
			() -> new SwordItem(CopperTier.COPPER, 3, -2.4F,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	
	// Next up: copper armor!
	public static final RegistryObject<ArmorItem> COPPER_BOOTS = ITEMS.register("copper_boots",
			() -> new ArmorItem(CopperArmorMaterial.COPPER, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
			() -> new ArmorItem(CopperArmorMaterial.COPPER, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> COPPER_HELMET = ITEMS.register("copper_helmet",
			() -> new ArmorItem(CopperArmorMaterial.COPPER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
			() -> new ArmorItem(CopperArmorMaterial.COPPER, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

	// Don't forget armor for the horsies!
	public static final RegistryObject<HorseArmorItem> COPPER_HORSE_ARMOR = ITEMS.register("copper_horse_armor",
			() -> new HorseArmorItem(4, "copper", new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	
	// Miscellaneous copper pieces and blocks.
	public static final RegistryObject<Item> COPPER_BUCKET = ITEMS.register("copper_bucket",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> COPPER_HOPPER = ITEMS.register("copper_hopper",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
