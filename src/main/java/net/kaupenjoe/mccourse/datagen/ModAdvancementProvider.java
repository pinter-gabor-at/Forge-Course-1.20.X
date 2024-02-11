package net.kaupenjoe.mccourse.datagen;

import static net.kaupenjoe.mccourse.util.ModNameUtil.modResourceLocation;

import java.util.Optional;
import java.util.function.Consumer;

import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import org.jetbrains.annotations.NotNull;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class ModAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {

	@Override
	public void generate(HolderLookup.@NotNull Provider registries, @NotNull Consumer<AdvancementHolder> saver,
		@NotNull ExistingFileHelper existingFileHelper) {
		AdvancementHolder rootAdvancement = Advancement.Builder.advancement()
			.display(
				new DisplayInfo(new ItemStack(ModItems.ALEXANDRITE.get()),
					Component.literal("MC Course"),
					Component.literal("The Power lies in the Alexandrite!"),
					Optional.of(modResourceLocation("textures/block/alexandrite_ore.png")),
					AdvancementType.TASK,
					true, true, false))
			.addCriterion("has_alexandrite",
				InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ALEXANDRITE.get()))
			.save(saver, modResourceLocation("mccourse"));
		Advancement.Builder.advancement()
			.display(new DisplayInfo(new ItemStack(ModItems.METAL_DETECTOR.get()),
				Component.literal("Metal Detector"),
				Component.literal("Batteries not included! (Actually doesn't need batteries)"),
				Optional.empty(),
				AdvancementType.TASK,
				true, true, false))
			.parent(rootAdvancement)
			.addCriterion("has_metal_detector",
				InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.METAL_DETECTOR.get()))
			.save(saver, modResourceLocation("metal_detector"));
	}
}
