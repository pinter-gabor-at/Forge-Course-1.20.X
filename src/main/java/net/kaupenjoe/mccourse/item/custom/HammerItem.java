package net.kaupenjoe.mccourse.item.custom;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class HammerItem extends DiggerItem implements Vanishable {
	public HammerItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
		super(pAttackDamageModifier, pAttackSpeedModifier, pTier, BlockTags.MINEABLE_WITH_PICKAXE, pProperties);
	}

	public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initalBlockPos, ServerPlayer player) {
		List<BlockPos> positions = new ArrayList<>();
		Level world = player.level();
		Vec3 eyePosition = player.getEyePosition();
		BlockHitResult traceResult = world.clip(new ClipContext(eyePosition,
			(eyePosition.add(player.getViewVector(1f).scale(6f))),
			ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
		if (traceResult.getType() == HitResult.Type.MISS) {
			return positions;
		}
		if (traceResult.getDirection() == Direction.DOWN || traceResult.getDirection() == Direction.UP) {
			for (int x = -range; x <= range; x++) {
				for (int y = -range; y <= range; y++) {
					positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY(), initalBlockPos.getZ() + y));
				}
			}
		}
		if (traceResult.getDirection() == Direction.NORTH || traceResult.getDirection() == Direction.SOUTH) {
			for (int x = -range; x <= range; x++) {
				for (int y = -range; y <= range; y++) {
					positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ()));
				}
			}
		}
		if (traceResult.getDirection() == Direction.EAST || traceResult.getDirection() == Direction.WEST) {
			for (int x = -range; x <= range; x++) {
				for (int y = -range; y <= range; y++) {
					positions.add(new BlockPos(initalBlockPos.getX(), initalBlockPos.getY() + y, initalBlockPos.getZ() + x));
				}
			}
		}
		return positions;
	}
}
