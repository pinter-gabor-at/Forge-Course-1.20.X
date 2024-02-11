package net.kaupenjoe.mccourse.util;

import static net.kaupenjoe.mccourse.util.ModNameUtil.modResourceLocation;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
	@SuppressWarnings("unused")
	public static class Items {

		private static TagKey<Item> tag(String name) {
			return ItemTags.create(modResourceLocation(name));
		}

		private static TagKey<Item> forgeTag(String name) {
			return ItemTags.create(new ResourceLocation("forge", name));
		}
	}

	@SuppressWarnings("unused")
	public static class Blocks {
		public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
		public static final TagKey<Block> NEEDS_ALEXANDRITE_TOOL = tag("needs_alexandrite_tool");
		public static final TagKey<Block> PAXEL_MINEABLE = tag("mineable/paxel");

		@SuppressWarnings("SameParameterValue")
		private static TagKey<Block> tag(String name) {
			return BlockTags.create(modResourceLocation(name));
		}

		private static TagKey<Block> forgeTag(String name) {
			return BlockTags.create(new ResourceLocation("forge", name));
		}
	}
}
