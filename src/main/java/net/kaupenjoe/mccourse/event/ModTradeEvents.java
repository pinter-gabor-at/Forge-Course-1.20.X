package net.kaupenjoe.mccourse.event;

import java.util.List;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.item.ModItems;
import net.kaupenjoe.mccourse.villager.ModVillagers;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModTradeEvents {

	@SubscribeEvent
	public static void addCustomTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.FARMER) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(ModItems.KOHLRABI.get(), 6);
			trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
				new ItemStack(Items.EMERALD, 2), stack, 10, 2, 0.02f
			));
			trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
				new ItemStack(Items.EMERALD, 5),
				new ItemStack(ModItems.KOHLRABI_SEEDS.get()), 3, 2, 0.02f
			));
		}
		if (event.getType() == VillagerProfession.TOOLSMITH) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(ModItems.ALEXANDRITE_PAXEL.get(), 1);
			trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
				new ItemStack(Items.EMERALD, 12), stack, 2, 5, 0.06f
			));
		}
		if (event.getType() == ModVillagers.SOUND_MASTER.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(ModBlocks.SOUND_BLOCK.get(), 1);
			trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
				new ItemStack(Items.EMERALD, 25), stack, 2, 5, 0.06f
			));
		}
	}

	@SubscribeEvent
	public static void addCustomWanderingTrades(WandererTradesEvent event) {
		List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
		List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();
		ItemStack stack = new ItemStack(ModItems.KOHLRABI.get(), 6);
		genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
			new ItemStack(Items.EMERALD, 2), stack, 10, 2, 0.02f
		));
		rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
			new ItemStack(Items.EMERALD, 5),
			new ItemStack(ModItems.KOHLRABI_SEEDS.get()), 3, 2, 0.02f
		));
	}

}
