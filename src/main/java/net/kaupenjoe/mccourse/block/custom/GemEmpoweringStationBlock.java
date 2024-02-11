package net.kaupenjoe.mccourse.block.custom;

import com.mojang.serialization.MapCodec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GemEmpoweringStationBlock extends HorizontalDirectionalBlock {
	public static final MapCodec<GemEmpoweringStationBlock> CODEC = simpleCodec(GemEmpoweringStationBlock::new);
	public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 12, 16);

	public GemEmpoweringStationBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	protected @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec() {
		return CODEC;
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel,
		@NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		return SHAPE;
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(FACING);
	}
}
