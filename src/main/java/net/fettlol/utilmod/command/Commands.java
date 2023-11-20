package net.fettlol.utilmod.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fettlol.utilmod.UtilMod;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.apache.logging.log4j.LogManager;

import static net.fettlol.utilmod.config.Config.getPlayerConfig;
import static net.fettlol.utilmod.config.Config.updatePlayerConfig;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class Commands {
	private static class SetConfigCommand implements Command<ServerCommandSource> {
		@Override
		public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
			String property = context.getInput().split(" ")[1];
			ServerPlayerEntity player = (ServerPlayerEntity) context.getSource().getEntityOrThrow();
			boolean value = BoolArgumentType.getBool(context, "value");

			updatePlayerConfig(player, config -> config.getBuilder().setAutoPlant(value).build());
			player.sendMessage(Text.literal(property + ": " + value));
			return 0;
		}
	}

	private static class GetConfigCommand implements Command<ServerCommandSource> {
		@Override
		public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
			String property = context.getInput().split(" ")[1];
			ServerPlayerEntity player = (ServerPlayerEntity) context.getSource().getEntityOrThrow();

			player.sendMessage(Text.literal(property + ": " + getPlayerConfig(player).autoPlant));
			return 0;
		}
	}

	public static void init() {
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(literal(UtilMod.MOD_ID)
				.then(literal("autoplant")
					.executes(new GetConfigCommand())
					.then(argument("value", BoolArgumentType.bool())
						.executes(new SetConfigCommand()))));
		});
	}
}
