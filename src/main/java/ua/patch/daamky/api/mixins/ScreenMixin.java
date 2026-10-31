package ua.patch.daamky.api.mixins;

import aethereal.ClickGuiDashboard;
import net.minecraft.class_437;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_437.class)
public abstract class ScreenMixin {
   @Inject(method = "applyBlur", at = @At("HEAD"), cancellable = true)
   protected void onApplyBlur(CallbackInfo var1) {
      if (ClickGuiDashboard.field1432.method0492()) {
         var1.cancel();
      }
   }
}
