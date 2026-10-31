package ua.patch.daamky.api.mixins;

import net.minecraft.class_310;
import net.minecraft.class_9919;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_9919.class)
public class InactivityFpsLimiterMixin {
   @Inject(method = "update", at = @At("HEAD"), cancellable = true)
   private void unlockMenuFps(CallbackInfoReturnable<Integer> var1) {
      class_310 var2 = class_310.method_1551();
      if (var2.field_1755 != null && var2.field_1687 == null) {
         var1.setReturnValue((Integer)var2.field_1690.method_42524().method_41753());
      }
   }
}
