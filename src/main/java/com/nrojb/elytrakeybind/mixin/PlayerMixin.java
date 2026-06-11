package com.nrojb.elytrakeybind.mixin;

import com.nrojb.elytrakeybind.ElytraKeybind;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin {

    @Inject(
            method = "tryToStartFallFlying",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onTryStartFallFlying(CallbackInfoReturnable<Boolean> cir) {
        //if ((Player) (Object) this instanceof LocalPlayer) {
            if (!ElytraKeybind.elytraToggleEnabled) {
                System.out.println("stopped fallflying");
                cir.setReturnValue(false);
            }
        //}
    }
}

