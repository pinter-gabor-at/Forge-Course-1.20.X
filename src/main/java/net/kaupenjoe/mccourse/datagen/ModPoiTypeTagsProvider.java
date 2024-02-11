package net.kaupenjoe.mccourse.datagen;

import static net.kaupenjoe.mccourse.util.ModNameUtil.modResourceLocation;

import java.util.concurrent.CompletableFuture;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.tags.PoiTypeTags;

public class ModPoiTypeTagsProvider extends PoiTypeTagsProvider {
	public ModPoiTypeTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future,
		@Nullable ExistingFileHelper existingFileHelper) {
		super(packOutput, future, MCCourseMod.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.@NotNull Provider pProvider) {
		tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
			.addOptional(modResourceLocation("sound_poi"));
	}
}
