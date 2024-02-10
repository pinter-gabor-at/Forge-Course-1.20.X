package net.kaupenjoe.mccourse.item;

import static net.kaupenjoe.mccourse.util.ModNameUtil.modResourceLocation;

import net.minecraft.client.renderer.item.ItemProperties;

public class ModItemProperties {
	public static void addCustomItemProperties() {
		ItemProperties.register(ModItems.DATA_TABLET.get(), modResourceLocation("on"),
			(pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f);
	}
}
