package net.kaupenjoe.mccourse.util;

import net.kaupenjoe.mccourse.MCCourseMod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ModNameUtil {

	/**
	 * Get path
	 * @return the path part of the id
	 */
	public static @NotNull String getPath(RegistryObject<Block> blockRegistryObject) {
		return getPath(blockRegistryObject.get());
	}

	/**
	 * Get path
	 * @return the path part of the id
	 */
	public static @NotNull String getPath(Block block) {
		ResourceLocation res = ForgeRegistries.BLOCKS.getKey(block);
		return res == null ? "" : res.getPath();
	}

	public static ResourceLocation modResourceLocation(String pPath) {
		return new ResourceLocation(MCCourseMod.MOD_ID, pPath);
	}
}
