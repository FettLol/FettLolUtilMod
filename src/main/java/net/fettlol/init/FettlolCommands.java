package net.fettlol.init;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.network.MessageType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.util.concurrent.ThreadLocalRandom;

public class FettlolCommands {

    public static void init() {
        CommandRegistrationCallback.EVENT.register(FettlolCommands::roll);
    }

    /**
     * Simple implementation of the "roll" command, giving players the ability to roll a random number
     * between 0 and whatever number the argument is.
     *
     * @param dispatcher The command dispatcher
     * @param dedicated Whether this is running dedicated (server) or not.
     */
    private static void roll(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(CommandManager.literal("roll")
            .then(CommandManager.argument("sides", IntegerArgumentType.integer(0))
                .executes(context -> {
                    String roller = context.getSource().getName();
                    int maxValue = context.getArgument("sides", Integer.class);
                    int randomRoll = ThreadLocalRandom.current().nextInt(0, maxValue + 1);

                    final Text text = new TranslatableText(
                        String.format("%s: Rolling between 0 and %d: %d", roller, maxValue, randomRoll)
                    );

                    context.getSource()
                        .getMinecraftServer()
                        .getPlayerManager()
                        .broadcastChatMessage(text, MessageType.CHAT, context.getSource().getPlayer().getUuid());
                    return 1;
                })
            )
        );
    }
}
