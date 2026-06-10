package com.nrojb.elytrakeybind.mixin;

import com.nrojb.elytrakeybind.ElytraKeybind;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(method = "setSharedFlag", at = @At("HEAD"), cancellable = true)
    protected void setSharedFlag(int flag_id, boolean flag, CallbackInfo ci) {
        if (((Entity) (Object) this) instanceof LivingEntity) {
            if (!ElytraKeybind.elytraToggleEnabled && flag_id == 7) {
                if (flag) {
                    System.out.println("blocked flying");
                    ci.cancel();
                    return;
                }
            }
        }

    }
}
