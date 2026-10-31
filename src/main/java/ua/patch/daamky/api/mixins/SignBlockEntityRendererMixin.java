package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.NoRender;
import net.minecraft.class_10529;
import net.minecraft.class_2338;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_8242;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_10529.class)
public abstract class SignBlockEntityRendererMixin {
   @Inject(method = "renderText", at = @At("HEAD"), cancellable = true, require = 0)
   private void onRenderText(class_2338 var1, class_8242 var2, class_4587 var3, class_4597 var4, int var5, int var6, int var7, boolean var8, CallbackInfo var9) {
      DaamkyClient var10 = DaamkyClient.method2004();
      if (var10 != null && var10.method1783() != null) {
         NoRender var11 = var10.method1783().method0976(NoRender.class);
         if (var11 != null && var11.method0517()) {
            var9.cancel();
         }
      }
   }
}
