package ua.patch.daamky.api.mixins;

import aethereal.Ambience;
import aethereal.DaamkyClient;
import net.minecraft.class_4587;
import net.minecraft.class_9975;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_9975.class)
public class SkyRenderingMixin {
   @Inject(method = "renderSky(FFF)V", at = @At("HEAD"), cancellable = true)
   private void onRenderSky(float var1, float var2, float var3, CallbackInfo var4) {
      if (DaamkyClient.method2004() != null && DaamkyClient.method2004().method1783() != null) {
         Ambience var5 = DaamkyClient.method2004().method1783().method0976(Ambience.class);
         if (var5 != null && var5.method1755()) {
            var5.method2029();
            var4.cancel();
         }
      }
   }

   @Inject(method = "renderSkyDark", at = @At("HEAD"), cancellable = true)
   private void onRenderSkyDark(class_4587 var1, CallbackInfo var2) {
      if (DaamkyClient.method2004() != null && DaamkyClient.method2004().method1783() != null) {
         Ambience var3 = DaamkyClient.method2004().method1783().method0976(Ambience.class);
         if (var3 != null && var3.method1755()) {
            var3.method2029();
            var2.cancel();
         }
      }
   }

   @Inject(method = "renderCelestialBodies", at = @At("HEAD"), cancellable = true)
   private void onRenderCelestialBodies(CallbackInfo var1) {
      if (DaamkyClient.method2004() != null && DaamkyClient.method2004().method1783() != null) {
         Ambience var2 = DaamkyClient.method2004().method1783().method0976(Ambience.class);
         if (var2 != null && var2.method1755()) {
            var1.cancel();
         }
      }
   }

   @Inject(method = "renderStars", at = @At("HEAD"), cancellable = true)
   private void onRenderStars(CallbackInfo var1) {
      if (DaamkyClient.method2004() != null && DaamkyClient.method2004().method1783() != null) {
         Ambience var2 = DaamkyClient.method2004().method1783().method0976(Ambience.class);
         if (var2 != null && var2.method1755()) {
            var1.cancel();
         }
      }
   }
}
