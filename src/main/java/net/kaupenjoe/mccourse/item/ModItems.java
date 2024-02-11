package net.kaupenjoe.mccourse.item;

import static net.kaupenjoe.mccourse.util.ModNameUtil.modResourceLocation;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.item.custom.DataTabletItem;
import net.kaupenjoe.mccourse.item.custom.FuelItem;
import net.kaupenjoe.mccourse.item.custom.HammerItem;
import net.kaupenjoe.mccourse.item.custom.MetalDetectorItem;
import net.kaupenjoe.mccourse.item.custom.ModArmorItem;
import net.kaupenjoe.mccourse.item.custom.PaxelItem;
import net.kaupenjoe.mccourse.item.custom.SlowingSwordItem;
import net.kaupenjoe.mccourse.sound.ModSounds;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.ShovelItem;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS =
		DeferredRegister.create(ForgeRegistries.ITEMS, MCCourseMod.MOD_ID);
	public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
		() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register("raw_alexandrite",
		() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
		() -> new MetalDetectorItem(new Item.Properties().durability(512)));
	public static final RegistryObject<Item> KOHLRABI = ITEMS.register("kohlrabi",
		() -> new Item(new Item.Properties().food(ModFoodProperties.KOHLRABI)));
	public static final RegistryObject<Item> PEAT_BRICK = ITEMS.register("peat_brick",
		() -> new FuelItem(new Item.Properties(), 200));
	public static final RegistryObject<Item> ALEXANDRITE_SWORD = ITEMS.register("alexandrite_sword",
		() -> new SlowingSwordItem(ModToolTiers.ALEXANDRITE, 2, 3, new Item.Properties().durability(256)));
	public static final RegistryObject<Item> ALEXANDRITE_PICKAXE = ITEMS.register("alexandrite_pickaxe",
		() -> new PickaxeItem(ModToolTiers.ALEXANDRITE, 1, 2, new Item.Properties().durability(256)));
	public static final RegistryObject<Item> ALEXANDRITE_SHOVEL = ITEMS.register("alexandrite_shovel",
		() -> new ShovelItem(ModToolTiers.ALEXANDRITE, 2, 3, new Item.Properties().durability(256)));
	public static final RegistryObject<Item> ALEXANDRITE_AXE = ITEMS.register("alexandrite_axe",
		() -> new AxeItem(ModToolTiers.ALEXANDRITE, 2, 3, new Item.Properties().durability(256)));
	public static final RegistryObject<Item> ALEXANDRITE_HOE = ITEMS.register("alexandrite_hoe",
		() -> new HoeItem(ModToolTiers.ALEXANDRITE, 2, 3, new Item.Properties().durability(256)));
	public static final RegistryObject<Item> ALEXANDRITE_PAXEL = ITEMS.register("alexandrite_paxel",
		() -> new PaxelItem(ModToolTiers.ALEXANDRITE, 2, 3, new Item.Properties().durability(256)));
	public static final RegistryObject<Item> ALEXANDRITE_HAMMER = ITEMS.register("alexandrite_hammer",
		() -> new HammerItem(ModToolTiers.ALEXANDRITE, 2, 3, new Item.Properties().durability(256)));
	public static final RegistryObject<Item> ALEXANDRITE_HELMET = ITEMS.register("alexandrite_helmet",
		() -> new ModArmorItem(ModArmorMaterials.ALEXANDRITE, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> ALEXANDRITE_CHESTPLATE = ITEMS.register("alexandrite_chestplate",
		() -> new ModArmorItem(ModArmorMaterials.ALEXANDRITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> ALEXANDRITE_LEGGING = ITEMS.register("alexandrite_leggings",
		() -> new ModArmorItem(ModArmorMaterials.ALEXANDRITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> ALEXANDRITE_BOOTS = ITEMS.register("alexandrite_boots",
		() -> new ModArmorItem(ModArmorMaterials.ALEXANDRITE, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> ALEXANDRITE_HORSE_ARMOR = ITEMS.register("alexandrite_horse_armor",
		() -> new HorseArmorItem(12,
			modResourceLocation("textures/entity/horse/armor/horse_armor_alexandrite.png"),
			new Item.Properties()));
	public static final RegistryObject<Item> DATA_TABLET = ITEMS.register("data_tablet",
		() -> new DataTabletItem(new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> KOHLRABI_SEEDS = ITEMS.register("kohlrabi_seeds",
		() -> new ItemNameBlockItem(ModBlocks.KOHLRABI_CROP.get(), new Item.Properties()));
	public static final RegistryObject<Item> BAR_BRAWL_RECORD = ITEMS.register("bar_brawl_record",
		() -> new RecordItem(4, ModSounds.BAR_BRAWL, new Item.Properties().stacksTo(1), 2440));
	public static final RegistryObject<Item> RADIATION_STAFF = ITEMS.register("radiation_staff",
		() -> new Item(new Item.Properties().durability(1024)));
	public static final RegistryObject<Item> ALEXANDRITE_BOW = ITEMS.register("alexandrite_bow",
		() -> new BowItem(new Item.Properties().durability(500)));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
