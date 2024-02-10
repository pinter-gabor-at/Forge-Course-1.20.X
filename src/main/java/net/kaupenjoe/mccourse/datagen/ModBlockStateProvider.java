package net.kaupenjoe.mccourse.datagen;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;

public class ModBlockStateProvider extends BlockStateProvider {
	public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, MCCourseMod.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		blockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
		blockWithItem(ModBlocks.RAW_ALEXANDRITE_BLOCK);
		blockWithItem(ModBlocks.ALEXANDRITE_ORE);
		blockWithItem(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);
		blockWithItem(ModBlocks.END_STONE_ALEXANDRITE_ORE);
		blockWithItem(ModBlocks.NETHER_ALEXANDRITE_ORE);
		blockWithItem(ModBlocks.SOUND_BLOCK);
		stairsBlock((StairBlock) ModBlocks.ALEXANDRITE_STAIRS.get(),
			blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
		slabBlock(((SlabBlock) ModBlocks.ALEXANDRITE_SLAB.get()),
			blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()),
			blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
		blockItem(ModBlocks.ALEXANDRITE_STAIRS);
		blockItem(ModBlocks.ALEXANDRITE_SLAB);
	}

	private void blockItem(RegistryObject<Block> blockRegistryObject) {
		Block block = blockRegistryObject.get();
		ResourceLocation res = ForgeRegistries.BLOCKS.getKey(block);
		String name = res == null ? "" : res.getPath();
		simpleBlockItem(block, new ModelFile.UncheckedModelFile(
			MCCourseMod.MOD_ID + ":block/" + name));
	}

	private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
		simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
	}
}
