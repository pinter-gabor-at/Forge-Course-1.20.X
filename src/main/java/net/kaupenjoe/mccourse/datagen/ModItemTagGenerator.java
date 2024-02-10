package net.kaupenjoe.mccourse.datagen;

import java.util.concurrent.CompletableFuture;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;

public class ModItemTagGenerator extends ItemTagsProvider {
	public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future,
		CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
		super(packOutput, future, completableFuture, MCCourseMod.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.@NotNull Provider pProvider) {
		// Add Item Tags here
	}

	@Override
	public @NotNull String getName() {
		return "Item Tags";
	}
}
