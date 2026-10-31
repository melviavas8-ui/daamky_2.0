package ua.patch.daamky.api.mixins;

import aethereal.AntiInvisible;
import aethereal.DaamkyClient;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_1297.class)
public class InvisibilityMixin {
   @Inject(method = "isInvisibleTo", at = @At("HEAD"), cancellable = true)
   private void onIsInvisibleTo(class_1657 var1, CallbackInfoReturnable<Boolean> var2) {
      if (DaamkyClient.method2004() != null && DaamkyClient.method2004().method1783() != null) {
         AntiInvisible var3 = DaamkyClient.method2004().method1783().method0976(AntiInvisible.class);
         if (var3 != null && var3.method2195()) {
            if (!var3.method1736() && this == class_310.method_1551().field_1724) {
               return;
            }

            var2.setReturnValue(false);
         }
      }
   }
}
