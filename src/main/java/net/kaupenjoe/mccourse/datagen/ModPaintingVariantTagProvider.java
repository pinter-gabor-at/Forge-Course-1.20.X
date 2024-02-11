package net.kaupenjoe.mccourse.datagen;

import static net.kaupenjoe.mccourse.util.ModNameUtil.modResourceLocation;

import java.util.concurrent.CompletableFuture;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.PaintingVariantTags;

public class ModPaintingVariantTagProvider extends PaintingVariantTagsProvider {
	public ModPaintingVariantTagProvider(PackOutput packOutput,
		CompletableFuture<HolderLookup.Provider> future,
		@Nullable ExistingFileHelper existingFileHelper) {
		super(packOutput, future, MCCourseMod.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.@NotNull Provider pProvider) {
		this.tag(PaintingVariantTags.PLACEABLE)
			.addOptional(modResourceLocation("saw_them"))
			.addOptional(modResourceLocation("shrimp"))
			.addOptional(modResourceLocation("world"));
	}
}
