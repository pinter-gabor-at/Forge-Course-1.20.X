package net.kaupenjoe.mccourse.item;

import static net.kaupenjoe.mccourse.util.ModNameUtil.modName;

import java.util.EnumMap;
import java.util.function.Supplier;

import org.jetbrains.annotations.NotNull;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public enum ModArmorMaterials implements ArmorMaterial {
	ALEXANDRITE("alexandrite", 24,
		Util.make(new EnumMap<>(ArmorItem.Type.class), (type) -> {
			type.put(ArmorItem.Type.BOOTS, 4);
			type.put(ArmorItem.Type.LEGGINGS, 5);
			type.put(ArmorItem.Type.CHESTPLATE, 7);
			type.put(ArmorItem.Type.HELMET, 5);
		}), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.of(ModItems.ALEXANDRITE.get()));

	private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE =
		Util.make(new EnumMap<>(ArmorItem.Type.class), (type) -> {
			type.put(ArmorItem.Type.BOOTS, 13);
			type.put(ArmorItem.Type.LEGGINGS, 15);
			type.put(ArmorItem.Type.CHESTPLATE, 16);
			type.put(ArmorItem.Type.HELMET, 11);
		});
	private final String name;
	private final int durabilityMultiplier;
	private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final Supplier<Ingredient> repairIngredient;

	ModArmorMaterials(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionTypeMap,
		int enchantmentValue, SoundEvent soundEvent, float toughness, float knockbackRes, Supplier<Ingredient> repairMaterial) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.protectionFunctionForType = protectionTypeMap;
		this.enchantmentValue = enchantmentValue;
		this.sound = soundEvent;
		this.toughness = toughness;
		this.knockbackResistance = knockbackRes;
		this.repairIngredient = repairMaterial;
	}

	public int getDurabilityForType(ArmorItem.@NotNull Type pType) {
		return HEALTH_FUNCTION_FOR_TYPE.get(pType) * this.durabilityMultiplier;
	}

	public int getDefenseForType(ArmorItem.@NotNull Type pType) {
		return this.protectionFunctionForType.get(pType);
	}

	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	public @NotNull SoundEvent getEquipSound() {
		return this.sound;
	}

	public @NotNull Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	public @NotNull String getName() {
		return modName(this.name);
	}

	public float getToughness() {
		return this.toughness;
	}

	/**
	 * Gets the percentage of knockback resistance provided by armor of the material.
	 */
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
