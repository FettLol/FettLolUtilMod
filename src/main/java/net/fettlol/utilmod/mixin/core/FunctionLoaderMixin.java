package net.fettlol.utilmod.mixin.core;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.fettlol.utilmod.api.FunctionImpl;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.function.CommandFunction;
import net.minecraft.server.function.FunctionLoader;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Map;

@Mixin(FunctionLoader.class)
public class FunctionLoaderMixin {

    final ThreadLocal<Identifier> fettlol$id = ThreadLocal.withInitial(() -> null);

    @Inject(method = "method_29451", at = @At("HEAD"))
    public void captureIdentifier(Map.Entry<?, ?> entry, Identifier id, ServerCommandSource serverCommandSource, CallbackInfoReturnable<CommandFunction> cir) {
        fettlol$id.set(id);
    }

    @ModifyExpressionValue(
        method = "method_29451", // lambda inside map.put(id, supplyAsync(...))
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/function/FunctionLoader;readLines(Lnet/minecraft/resource/Resource;)Ljava/util/List;"
        )
    )
    public List<String> blockFunction(List<String> original) {
        if (FunctionImpl.blockedFunctions.contains(fettlol$id.get())) {
            return List.of();
        }

        return original;
    }
}
