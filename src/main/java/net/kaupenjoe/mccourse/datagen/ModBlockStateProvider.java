package net.kaupenjoe.mccourse.datagen;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.util.ModNameUtil;

import net.minecraft.world.level.block.FenceBlock;

import net.minecraft.world.level.block.FenceGateBlock;

import net.minecraft.world.level.block.WallBlock;

import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
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
		buttonBlock((ButtonBlock) ModBlocks.ALEXANDRITE_BUTTON.get(),
			blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
		pressurePlateBlock((PressurePlateBlock) ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(),
			blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
		fenceBlock((FenceBlock) ModBlocks.ALEXANDRITE_FENCE.get(),
			blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.ALEXANDRITE_FENCE_GATE.get(),
			blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.ALEXANDRITE_WALL.get(),
			blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        blockItem(ModBlocks.ALEXANDRITE_STAIRS);
        blockItem(ModBlocks.ALEXANDRITE_SLAB);
        blockItem(ModBlocks.ALEXANDRITE_PRESSURE_PLATE);
        blockItem(ModBlocks.ALEXANDRITE_FENCE_GATE);
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
		Block block = blockRegistryObject.get();
		simpleBlockItem(block, new ModelFile.UncheckedModelFile(
			MCCourseMod.MOD_ID + ":block/" + ModNameUtil.getPath(block)));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
