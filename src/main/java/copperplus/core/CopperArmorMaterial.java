package copperplus.core;

import java.util.function.Supplier;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

@SuppressWarnings("deprecation")
public enum CopperArmorMaterial implements ArmorMaterial {
	COPPER("copper", 8, new int[] {2, 3, 4, 2}, 8, SoundEvents.ARMOR_EQUIP_GENERIC, 0F, 0F,
			() -> { return Ingredient.of(net.minecraft.world.item.Items.COPPER_INGOT); 
	});
	
	private static final int[] HEALTH_PER_SLOT = new int[] {13, 15, 16, 11};
	private final String name;
	private final int durabilityMultiplier;
	private final int[] slotProtections;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final LazyLoadedValue<Ingredient> repairIngredient;
	
	private CopperArmorMaterial(
			String name,
			int durabilityMultiplier,
			int[] slotProtections,
			int enchantmentValue,
			SoundEvent sound,
			float toughness,
			float knockbackResistance,
			Supplier<Ingredient> ingredient) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.slotProtections = slotProtections;
		this.enchantmentValue = enchantmentValue;
		this.sound = sound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = new LazyLoadedValue<>(ingredient);
	}
	
	@Override
	public int getDurabilityForSlot(EquipmentSlot slot) {
		return HEALTH_PER_SLOT[slot.getIndex()] * this.durabilityMultiplier;
	}
	
	@Override
	public int getDefenseForSlot(EquipmentSlot slot) {
		return this.slotProtections[slot.getIndex()];
	}
	
	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}
	
	@Override
	public SoundEvent getEquipSound() {
		return this.sound;
	}
	
	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}
	
	@Override
	public String getName() {
		return "copperplus:" + this.name;
	}
	
	@Override
	public float getToughness() {
		return this.toughness;
	}
	
	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
