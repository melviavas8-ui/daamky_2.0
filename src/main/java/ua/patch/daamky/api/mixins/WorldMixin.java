package ua.patch.daamky.api.mixins;

import aethereal.Ambience;
import aethereal.DaamkyClient;
import net.minecraft.class_1937;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_1937.class)
public abstract class WorldMixin {
   @Inject(method = "getTimeOfDay", at = @At("HEAD"), cancellable = true)
   private void onGetTimeOfDay(CallbackInfoReturnable<Long> var1) {
      if (this instanceof class_638) {
         if (DaamkyClient.method2004() != null && DaamkyClient.method2004().method1783() != null) {
            Ambience var2 = DaamkyClient.method2004().method1783().method0976(Ambience.class);
            if (var2 != null && var2.method1736()) {
               var1.setReturnValue(var2.method1681());
            }
         }
      }
   }

   @Inject(method = "getSkyAngleRadians", at = @At("HEAD"), cancellable = true)
   private void onGetSkyAngleRadians(float var1, CallbackInfoReturnable<Float> var2) {
      if (this instanceof class_638) {
         if (DaamkyClient.method2004() != null && DaamkyClient.method2004().method1783() != null) {
            Ambience var3 = DaamkyClient.method2004().method1783().method0976(Ambience.class);
            if (var3 != null && var3.method1736()) {
               float var4 = (float)(var3.method1681() % 24000L) / 24000.0F;
               var2.setReturnValue(var4 * (float) (Math.PI * 2));
            }
         }
      }
   }
}
