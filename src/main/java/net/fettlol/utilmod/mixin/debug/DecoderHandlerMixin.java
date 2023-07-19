package net.fettlol.utilmod.mixin.debug;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.fettlol.utilmod.UtilMod;
import net.minecraft.network.DecoderHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(DecoderHandler.class)
public abstract class DecoderHandlerMixin {
	@Inject(method = "decode", at = @At(value = "NEW", target = "java/io/IOException", ordinal = 0))
	public void fettlol$logInvalidPacketAdress(ChannelHandlerContext ctx, ByteBuf buf, List<Object> objects, CallbackInfo ci) {
		UtilMod.LOGGER.warn("invalid packet from {}", ctx.channel().remoteAddress());
	}
}
