package net.fettlol.utilmod.mixin.debug;

import net.minecraft.network.NetworkState;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.PacketListener;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.function.Function;

@Mixin(NetworkState.PacketHandler.class)
public abstract class NetworkStatePacketHandlerMixin<T extends PacketListener> {
	@Shadow @Final
	private List<Function<PacketByteBuf, ? extends Packet<T>>> packetFactories;

	// fix IndexOutOfBoundsException being thrown which DecoderHandler.decode() doesn't handle
	@Inject(method = "createPacket", at = @At("HEAD"), cancellable = true)
	public void fettlol$returnNullOnInvalidId(int id, PacketByteBuf buf, CallbackInfoReturnable<Packet<?>> cir) {
		if (id >= packetFactories.size() || id < 0)
			cir.setReturnValue(null);
	}
}
