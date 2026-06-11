package com.nrojb.elytrakeybind.mixin;

import com.nrojb.elytrakeybind.ElytraKeybind;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "isFallFlying", at = @At("HEAD"), cancellable = true)
    private void injectedisFallFlying(CallbackInfoReturnable<Boolean> cir) {

        if (!ElytraKeybind.elytraToggleEnabled) {
            cir.setReturnValue(false);
            return;
        }

    }
}