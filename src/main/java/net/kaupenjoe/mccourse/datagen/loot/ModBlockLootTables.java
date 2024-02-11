package net.kaupenjoe.mccourse.datagen.loot;

import java.util.Set;

import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.block.custom.KohlrabiCropBlock;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public class ModBlockLootTables extends BlockLootSubProvider {
	public ModBlockLootTables() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	protected void generate() {
		dropSelf(ModBlocks.ALEXANDRITE_BLOCK.get());
		dropSelf(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
		dropSelf(ModBlocks.SOUND_BLOCK.get());
		add(ModBlocks.ALEXANDRITE_ORE.get(),
			block -> createOreDrop(ModBlocks.ALEXANDRITE_ORE.get(), ModItems.RAW_ALEXANDRITE.get()));
		add(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
			block -> createOreDrop(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(), ModItems.RAW_ALEXANDRITE.get()));
		add(ModBlocks.END_STONE_ALEXANDRITE_ORE.get(),
			block -> createOreDrop(ModBlocks.END_STONE_ALEXANDRITE_ORE.get(), ModItems.RAW_ALEXANDRITE.get()));
		add(ModBlocks.NETHER_ALEXANDRITE_ORE.get(),
			block -> createOreDrop(ModBlocks.NETHER_ALEXANDRITE_ORE.get(), ModItems.RAW_ALEXANDRITE.get()));
		dropSelf(ModBlocks.ALEXANDRITE_STAIRS.get());
		add(ModBlocks.ALEXANDRITE_SLAB.get(),
			block -> createSlabItemTable(ModBlocks.ALEXANDRITE_SLAB.get()));
		dropSelf(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get());
		dropSelf(ModBlocks.ALEXANDRITE_BUTTON.get());
		dropSelf(ModBlocks.ALEXANDRITE_FENCE.get());
		dropSelf(ModBlocks.ALEXANDRITE_FENCE_GATE.get());
		dropSelf(ModBlocks.ALEXANDRITE_WALL.get());
		dropSelf(ModBlocks.ALEXANDRITE_TRAPDOOR.get());
		add(ModBlocks.ALEXANDRITE_DOOR.get(),
			block -> createDoorTable(ModBlocks.ALEXANDRITE_DOOR.get()));
		dropSelf(ModBlocks.ALEXANDRITE_LAMP.get());
		LootItemCondition.Builder lootBuilder = LootItemBlockStatePropertyCondition
			.hasBlockStateProperties(ModBlocks.KOHLRABI_CROP.get())
			.setProperties(StatePropertiesPredicate.Builder.properties()
				.hasProperty(KohlrabiCropBlock.AGE, 6));
		add(ModBlocks.KOHLRABI_CROP.get(), createCropDrops(ModBlocks.KOHLRABI_CROP.get(),
			ModItems.KOHLRABI.get(), ModItems.KOHLRABI_SEEDS.get(), lootBuilder));
		dropSelf(ModBlocks.SNAPDRAGON.get());
		add(ModBlocks.POTTED_SNAPDRAGON.get(),
			createPotFlowerItemTable(ModBlocks.SNAPDRAGON.get()));
		dropSelf(ModBlocks.GEM_EMPOWERING_STATION.get());
	}

	@Override
	protected @NotNull Iterable<Block> getKnownBlocks() {
		return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
