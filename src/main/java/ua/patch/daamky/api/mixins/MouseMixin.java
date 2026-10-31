package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.FreeLook;
import aethereal.GuiMove;
import aethereal.MouseEvent;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_312.class)
public abstract class MouseMixin {
   @Shadow
   @Final
   private class_310 field_1779;

   @Inject(method = "onMouseButton", at = @At("HEAD"), cancellable = true)
   public void onMouseButton(long var1, int var3, int var4, int var5, CallbackInfo var6) {
      MouseEvent var7 = new MouseEvent(var3, var4);
      DaamkyClient.method2004().method2072().post(var7);
      if (var7.method2079()) {
         var6.cancel();
      }
   }

   @Redirect(method = "tick()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Mouse;isCursorLocked()Z"))
   private boolean daamky$shouldDriveCamera(class_312 var1) {
      if (var1.method_1613()) {
         return true;
      } else {
         DaamkyClient var2 = DaamkyClient.method2004();
         if (var2 != null && var2.method1783() != null) {
            GuiMove var3 = var2.method1783().method0976(GuiMove.class);
            return var3 != null && var3.method1736();
         } else {
            return false;
         }
      }
   }

   @Redirect(method = "updateMouse(D)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;changeLookDirection(DD)V"))
   private void daamky$onChangeLookDirection(class_746 var1, double var2, double var4) {
      DaamkyClient var6 = DaamkyClient.method2004();
      if (var6 != null && var6.method1783() != null) {
         FreeLook var7 = var6.method1783().method0976(FreeLook.class);
         if (var7 == null || !var7.method2195() || !var7.method0616(var2, var4)) {
            var1.method_5872(var2, var4);
         }
      } else {
         var1.method_5872(var2, var4);
      }
   }
}
