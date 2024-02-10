package net.kaupenjoe.mccourse.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class ReturnHomeCommand {
	public ReturnHomeCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("home")
			.then(Commands.literal("return").executes(this::execute)));
	}

	private int execute(CommandContext<CommandSourceStack> context) {
		ServerPlayer player = context.getSource().getPlayer();
		if (player != null) {
			int[] homePos = player.getPersistentData().getIntArray("mccourse.homepos");
			if (homePos.length == 3) {
				player.teleportTo(homePos[0], homePos[1], homePos[2]);
				context.getSource().sendSuccess(() ->
					Component.literal("Player returned Home!"), false);
				return 1;
			}
			context.getSource().sendFailure(Component.literal("No Home Position has been set!"));
		}
		return -1;
	}
}
