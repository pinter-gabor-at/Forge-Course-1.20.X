package net.kaupenjoe.mccourse.util;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

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

	/**
	 * Create a mod specific {@link ResourceLocation}
	 */
	public static ResourceLocation modResourceLocation(String pPath) {
		return new ResourceLocation(MCCourseMod.MOD_ID, pPath);
	}

	/**
	 * Create a mod specific {@link ResourceLocation} prefixed by "item"
	 */
	public static ResourceLocation modItemResourceLocation(String pPath) {
		return modResourceLocation("item", pPath);
	}

	/**
	 * Create a mod specific {@link ResourceLocation} prefixed by "block"
	 */
	public static ResourceLocation modBlockResourceLocation(String pPath) {
		return modResourceLocation("block", pPath);
	}

	/**
	 * Create a mod specific {@link ResourceLocation} prefixed by anything
	 */
	public static ResourceLocation modResourceLocation(String prefix, String pPath) {
		return modResourceLocation(prefix + "/" + pPath);
	}

	/**
	 * Create a name prefixed by {@link MCCourseMod#MOD_ID}
	 */
	public static String modName(String name) {
		return MCCourseMod.MOD_ID + ":" + name;
	}
}
