package com.nrojb.elytrakeybind.mixin;

import com.nrojb.elytrakeybind.ElytraKeybind;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.Method;

@Mixin(LivingEntity.class)
//@Mixin(Entity.class)
public class LivingEntityMixin {

//    @Inject(method = "gameEvent", at = @At("HEAD"), cancellable = true)
//    public void gameEvent(Holder<GameEvent> event, Entity entity, CallbackInfo ci) {
//        if (entity == null) {
//            entity = (Entity) (Object) this;
//        }
//
//        if (entity instanceof LivingEntity) {
//            if (!ElytraKeybind.elytraToggleEnabled && event.is(GameEvent.ELYTRA_GLIDE)) {
//                System.out.println("blocked event");
//                ci.cancel();
//                return;
//            }
//        }
//        // continue to the original method
//    }

    @Inject(method = "isFallFlying", at = @At("HEAD"), cancellable = true)
    private void injectedisFallFlying(CallbackInfoReturnable<Boolean> cir) {

        if (!ElytraKeybind.elytraToggleEnabled) {
//            Entity e = (Entity)(Object)this;
//            try {
//                Method m = Entity.class.getDeclaredMethod("setSharedFlag", int.class, boolean.class);
//                m.setAccessible(true);
//                m.invoke(e, 7, false);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
            cir.setReturnValue(false);
            return;
        }

    }

//    @Inject(method = "isFlyEnabled", at = @At("HEAD"), cancellable = true)
//    private static void injectedisFlyEnabled(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
//
//        if (!ElytraKeybind.elytraToggleEnabled) {
//            cir.setReturnValue(false);
//            return;
//        }
//
//        cir.setReturnValue(stack.getDamageValue() < stack.getMaxDamage() - 1);
//    }
}
