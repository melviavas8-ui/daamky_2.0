package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.NoTrace;
import net.minecraft.class_1922;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import net.minecraft.class_4970;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_4970.class)
public abstract class AbstractBlockMixin {
   @Inject(method = "getOutlineShape", at = @At("HEAD"), cancellable = true)
   private void noTrace$emptyOutlineForCobweb(class_2680 var1, class_1922 var2, class_2338 var3, class_3726 var4, CallbackInfoReturnable<class_265> var5) {
      if (var1.method_27852(class_2246.field_10343)) {
         DaamkyClient var6 = DaamkyClient.method2004();
         if (var6 != null && var6.method1783() != null) {
            NoTrace var7 = var6.method1783().method0976(NoTrace.class);
            if (var7 != null && var7.method1692()) {
               var5.setReturnValue(class_259.method_1073());
            }
         }
      }
   }
}
