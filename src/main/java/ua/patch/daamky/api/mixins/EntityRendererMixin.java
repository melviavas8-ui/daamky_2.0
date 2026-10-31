package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.NameTags;
import net.minecraft.class_10017;
import net.minecraft.class_10039;
import net.minecraft.class_10042;
import net.minecraft.class_1297;
import net.minecraft.class_2561;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_897;
import net.minecraft.class_9998;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_897.class)
public abstract class EntityRendererMixin<T extends class_1297, S extends class_10017> {
   @Inject(method = "renderLabelIfPresent", at = @At("HEAD"), cancellable = true)
   private void onRenderLabel(S var1, class_2561 var2, class_4587 var3, class_4597 var4, int var5, CallbackInfo var6) {
      NameTags var7 = DaamkyClient.method2004().method1783().method0976(NameTags.class);
      if (var7 != null && var7.method2195()) {
         if (!(var1 instanceof class_9998)) {
            boolean var8 = var1 instanceof class_10042 || var1 instanceof class_10039;
            if (var8) {
               var6.cancel();
            }
         }
      }
   }
}
