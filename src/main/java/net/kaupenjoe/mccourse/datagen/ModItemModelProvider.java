package net.kaupenjoe.mccourse.datagen;

import static net.kaupenjoe.mccourse.util.ModNameUtil.modResourceLocation;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.item.ModItems;
import net.kaupenjoe.mccourse.util.ModNameUtil;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModItemModelProvider extends ItemModelProvider {
	public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, MCCourseMod.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		simpleItem(ModItems.ALEXANDRITE);
		simpleItem(ModItems.RAW_ALEXANDRITE);
		simpleItem(ModItems.KOHLRABI);
		simpleItem(ModItems.METAL_DETECTOR);
		simpleItem(ModItems.PEAT_BRICK);
		buttonItem(ModBlocks.ALEXANDRITE_BUTTON, ModBlocks.ALEXANDRITE_BLOCK);
	}

	public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
		withExistingParent(ModNameUtil.getPath(block), mcLoc("block/button_inventory"))
			.texture("texture", modResourceLocation("block/" + ModNameUtil.getPath(baseBlock)));
	}

	@SuppressWarnings("UnusedReturnValue")
	private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
			new ResourceLocation("item/generated")).texture("layer0",
			modResourceLocation("item/" + item.getId().getPath()));
	}
}
