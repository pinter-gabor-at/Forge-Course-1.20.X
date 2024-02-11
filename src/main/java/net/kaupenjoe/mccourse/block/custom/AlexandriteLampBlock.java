package net.kaupenjoe.mccourse.block.custom;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class AlexandriteLampBlock extends Block {
	public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");

	public AlexandriteLampBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.defaultBlockState().setValue(CLICKED, false));
	}

	// Overriding this method is an expected usage and is not deprecated in any way.
	@SuppressWarnings("deprecation")
	@Override
	public @NotNull InteractionResult use(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos,
		@NotNull Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {
		if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
			boolean currentState = pState.getValue(CLICKED);
			pLevel.setBlock(pPos, pState.setValue(CLICKED, !currentState), 3);
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(CLICKED);
	}
}
