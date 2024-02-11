package net.kaupenjoe.mccourse.item;

import static net.kaupenjoe.mccourse.util.ModNameUtil.modResourceLocation;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItemProperties {
	public static void addCustomItemProperties() {
		ItemProperties.register(ModItems.DATA_TABLET.get(), modResourceLocation("on"),
			(pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f);
		makeBow(ModItems.ALEXANDRITE_BOW.get());
	}

	private static void makeBow(Item item) {
		ItemProperties.register(item, new ResourceLocation("pull"),
			(pStack, pLevel, pEntity, pSeed) ->
				pEntity != null && pEntity.getUseItem() == pStack ?
					(float) (pStack.getUseDuration() - pEntity.getUseItemRemainingTicks()) / 20f : 0f);
		ItemProperties.register(item, new ResourceLocation("pulling"),
			(pStack, pLevel, pEntity, pSeed) ->
				pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ?
					1f : 0f);
	}
}
