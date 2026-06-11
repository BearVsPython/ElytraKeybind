package com.nrojb.elytrakeybind.mixin;

import com.nrojb.elytrakeybind.ElytraKeybind;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;



@Mixin(Connection.class)
public abstract class ConnectionMixin {

    @Inject(
            method = "send(Lnet/minecraft/network/protocol/Packet;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onSend(Packet<?> packet, CallbackInfo ci) {
        if (!ElytraKeybind.elytraToggleEnabled) {
            if (packet instanceof ServerboundPlayerCommandPacket cmd) {
                if (cmd.getAction() == ServerboundPlayerCommandPacket.Action.START_FALL_FLYING) {
                    ci.cancel();
                }
            }
        }
    }
}
