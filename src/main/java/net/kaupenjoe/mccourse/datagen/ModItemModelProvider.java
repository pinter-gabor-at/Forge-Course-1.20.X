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
		handheldItem(ModItems.ALEXANDRITE_SWORD);
		handheldItem(ModItems.ALEXANDRITE_PICKAXE);
		handheldItem(ModItems.ALEXANDRITE_SHOVEL);
		handheldItem(ModItems.ALEXANDRITE_AXE);
		handheldItem(ModItems.ALEXANDRITE_HOE);
		handheldItem(ModItems.ALEXANDRITE_PAXEL);
		handheldItem(ModItems.ALEXANDRITE_HAMMER);
		// simpleItem(ModItems.ALEXANDRITE_HELMET);
		// simpleItem(ModItems.ALEXANDRITE_CHESTPLATE);
		// simpleItem(ModItems.ALEXANDRITE_LEGGING);
		// simpleItem(ModItems.ALEXANDRITE_BOOTS);
		simpleItem(ModItems.ALEXANDRITE_HORSE_ARMOR);
		simpleItem(ModItems.KOHLRABI_SEEDS);
		simpleItem(ModItems.BAR_BRAWL_RECORD);
		// simpleItem(ModItems.DATA_TABLET);
		buttonItem(ModBlocks.ALEXANDRITE_BUTTON, ModBlocks.ALEXANDRITE_BLOCK);
		fenceItem(ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_BLOCK);
		wallItem(ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_BLOCK);
		simpleBlockItem(ModBlocks.ALEXANDRITE_DOOR);
	}

	public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
		withExistingParent(ModNameUtil.getPath(block), mcLoc("block/fence_inventory"))
			.texture("texture", modResourceLocation("block/" + ModNameUtil.getPath(baseBlock)));
	}

	public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
		withExistingParent(ModNameUtil.getPath(block), mcLoc("block/wall_inventory"))
			.texture("wall", modResourceLocation("block/" + ModNameUtil.getPath(baseBlock)));
	}

	public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
		withExistingParent(ModNameUtil.getPath(block), mcLoc("block/button_inventory"))
			.texture("texture", modResourceLocation("block/" + ModNameUtil.getPath(baseBlock)));
	}

	@SuppressWarnings({"UnusedReturnValue", "SameParameterValue"})
	private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
			new ResourceLocation("item/handheld"))
			.texture("layer0",
				modResourceLocation("item/" + item.getId().getPath()));
	}

	@SuppressWarnings({"UnusedReturnValue", "SameParameterValue"})
	private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
		return withExistingParent(item.getId().getPath(),
			new ResourceLocation("item/generated"))
			.texture("layer0",
				modResourceLocation("item/" + item.getId().getPath()));
	}

	@SuppressWarnings("UnusedReturnValue")
	private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
			new ResourceLocation("item/generated"))
			.texture("layer0",
				modResourceLocation("item/" + item.getId().getPath()));
	}
}
