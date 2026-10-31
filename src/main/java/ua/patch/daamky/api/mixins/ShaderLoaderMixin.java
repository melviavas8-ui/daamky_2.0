package ua.patch.daamky.api.mixins;

import aethereal.ShaderRegistry;
import net.minecraft.class_10151;
import net.minecraft.class_10156;
import net.minecraft.class_5944;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_10151.class)
public class ShaderLoaderMixin {
   @Inject(method = "getOrCreateProgram", at = @At("HEAD"), cancellable = true)
   private void daamky$intercept(class_10156 var1, CallbackInfoReturnable<class_5944> var2) {
      class_5944 var3 = ShaderRegistry.method1112(var1);
      if (var3 != null) {
         var2.setReturnValue(var3);
      }
   }
}
