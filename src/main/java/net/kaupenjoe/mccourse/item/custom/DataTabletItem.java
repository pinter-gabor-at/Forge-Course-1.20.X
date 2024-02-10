package net.kaupenjoe.mccourse.item.custom;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class DataTabletItem extends Item {
	public DataTabletItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public @NotNull InteractionResultHolder<ItemStack> use(
		@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pUsedHand) {
		if (pPlayer.getItemInHand(pUsedHand).hasTag()) {
			pPlayer.getItemInHand(pUsedHand).setTag(new CompoundTag());
		}
		return super.use(pLevel, pPlayer, pUsedHand);
	}

	@Override
	public boolean isFoil(ItemStack pStack) {
		return pStack.hasTag();
	}

	@Override
	public void appendHoverText(ItemStack pStack, @Nullable Level pLevel,
		@NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
		if (pStack.hasTag()) {
			@SuppressWarnings("DataFlowIssue") String currentFoundOre =
				pStack.getTag().getString("mccourse.found_ore");
			pTooltipComponents.add(Component.literal(currentFoundOre));
		}
		super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
	}
}
