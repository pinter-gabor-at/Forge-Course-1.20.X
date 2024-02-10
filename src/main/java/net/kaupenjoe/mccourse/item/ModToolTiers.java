package net.kaupenjoe.mccourse.item;

import static net.kaupenjoe.mccourse.util.ModNameUtil.modResourceLocation;

import java.util.List;

import net.kaupenjoe.mccourse.util.ModTags;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;

public class ModToolTiers {
	public static final Tier ALEXANDRITE = TierSortingRegistry.registerTier(
		new ForgeTier(5, 1400, 11f, 3f, 26,
			ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL, () -> Ingredient.of(ModItems.ALEXANDRITE.get())),
		modResourceLocation("alexandrite"), List.of(Tiers.NETHERITE), List.of());
}
