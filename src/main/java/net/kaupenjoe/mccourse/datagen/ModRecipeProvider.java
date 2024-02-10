package net.kaupenjoe.mccourse.datagen;

import java.util.List;

import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.ItemLike;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
	private static final List<ItemLike> ALEXANDRITE_SMELTABLES = List.of(ModItems.RAW_ALEXANDRITE.get(),
		ModBlocks.ALEXANDRITE_ORE.get(), ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(), ModBlocks.NETHER_ALEXANDRITE_ORE.get(),
		ModBlocks.END_STONE_ALEXANDRITE_ORE.get());

	public ModRecipeProvider(PackOutput pOutput) {
		super(pOutput);
	}

	@Override
	protected void buildRecipes(@NotNull RecipeOutput pWriter) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get())
			.pattern("AAA")
			.pattern("AAA")
			.pattern("AAA")
			.define('A', ModItems.ALEXANDRITE.get())
			.unlockedBy("has_alexandrite", has(ModItems.ALEXANDRITE.get()))
			.save(pWriter);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
			.requires(ModBlocks.ALEXANDRITE_BLOCK.get())
			.unlockedBy("has_alexandrite_block", has(ModBlocks.ALEXANDRITE_BLOCK.get()))
			.save(pWriter);

		nineBlockStorageRecipes(pWriter,
			RecipeCategory.MISC, ModItems.RAW_ALEXANDRITE.get(),
			RecipeCategory.MISC, ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
		oreSmelting(pWriter, ALEXANDRITE_SMELTABLES,
			RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 200, "alexandrite");
		oreBlasting(pWriter, ALEXANDRITE_SMELTABLES,
			RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 100, "alexandrite");
	}
}
