package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.NoRender;
import net.minecraft.class_332;
import net.minecraft.class_337;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_337.class)
public abstract class BossBarHudMixin {
   @Inject(method = "render", at = @At("HEAD"), cancellable = true)
   private void onRender(class_332 var1, CallbackInfo var2) {
      DaamkyClient var3 = DaamkyClient.method2004();
      if (var3 != null && var3.method1783() != null) {
         NoRender var4 = var3.method1783().method0976(NoRender.class);
         if (var4 != null && var4.method2044()) {
            var2.cancel();
         }
      }
   }

   @Inject(method = "render", at = @At("RETURN"))
   private void afterRender(class_332 var1, CallbackInfo var2) {
      var1.method_51452();
   }
}
