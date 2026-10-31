package ua.patch.daamky.api.mixins;

import aethereal.RotationManager;
import net.minecraft.class_1297;
import net.minecraft.class_340;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(class_340.class)
public abstract class DebugHudMixin {
   @Redirect(method = "getLeftText", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getYaw()F"))
   private float redirectYaw(class_1297 var1) {
      return RotationManager.field0618.method0545().method2047();
   }

   @Redirect(method = "getLeftText", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getPitch()F"))
   private float redirectPitch(class_1297 var1) {
      return RotationManager.field0618.method0545().method1762();
   }
}
