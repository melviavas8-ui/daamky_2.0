package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.HandledScreenRenderEvent;
import aethereal.NameProtect;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_465;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_465.class)
public abstract class HandledScreenMixin {
   @Inject(method = "render", at = @At("TAIL"))
   private void daamky$onRender(class_332 var1, int var2, int var3, float var4, CallbackInfo var5) {
      HandledScreenRenderEvent var6 = new HandledScreenRenderEvent((class_465<?>)this, var1, var2, var3);
      DaamkyClient.method2004().method2072().post(var6);
   }

   @ModifyArg(
      method = "drawForeground",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/DrawContext;drawText(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;IIIZ)I"
      ),
      index = 1
   )
   private class_2561 daamky$maskTitle(class_2561 var1) {
      class_2561 var2 = NameProtect.method1346(var1);
      return var2 != null ? var2 : var1;
   }
}
