package net.kaupenjoe.mccourse.item.custom;

import org.jetbrains.annotations.NotNull;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item {
	public MetalDetectorItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public @NotNull InteractionResult useOn(UseOnContext pContext) {
		Player player = pContext.getPlayer();
		if (player == null) return InteractionResult.FAIL;
		if (!pContext.getLevel().isClientSide()) {
			BlockPos positionClicked = pContext.getClickedPos();
			boolean foundBlock = false;
			for (int i = 0; i <= positionClicked.getY() + 64; i++) {
				BlockState blockState = pContext.getLevel().getBlockState(positionClicked.below(i));
				if (isValuableBlock(blockState)) {
					outputValuableCoordinates(positionClicked.below(i), player, blockState.getBlock());
					foundBlock = true;
					break;
				}
			}
			if (!foundBlock) {
				outputNoValuableFound(player);
			}
		}
		pContext.getItemInHand().hurtAndBreak(1, player,
			player1 -> player1.broadcastBreakEvent(player1.getUsedItemHand()));
		return InteractionResult.SUCCESS;
	}

	private void outputNoValuableFound(Player player) {
		player.sendSystemMessage(Component.translatable("item.mccourse.metal_detector.no_valuables"));
	}

	private void outputValuableCoordinates(BlockPos below, Player player, Block block) {
		player.sendSystemMessage(Component.literal("Valuable Found: " + I18n.get(block.getDescriptionId())
			+ " at (" + below.getX() + ", " + below.getY() + ", " + below.getZ() + ")"));
	}

	private boolean isValuableBlock(BlockState blockState) {
		return blockState.is(Blocks.IRON_ORE) || blockState.is(Blocks.DEEPSLATE_IRON_ORE)
			|| blockState.is(Blocks.DIAMOND_ORE);
	}
}
