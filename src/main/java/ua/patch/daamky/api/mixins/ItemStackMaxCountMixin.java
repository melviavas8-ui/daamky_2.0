package ua.patch.daamky.api.mixins;

import aethereal.ServerAssist;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_1799.class)
public abstract class ItemStackMaxCountMixin {
   @Inject(method = "getMaxCount", at = @At("HEAD"), cancellable = true)
   private void daamky$reallyWorldPotionStack(CallbackInfoReturnable<Integer> var1) {
      ServerAssist var2 = ServerAssist.method1717();
      if (var2 != null && var2.method1692()) {
         class_1799 var3 = (class_1799)this;
         if (var3.method_7909() == class_1802.field_8574 || var3.method_7909() == class_1802.field_8436 || var3.method_7909() == class_1802.field_8150) {
            var1.setReturnValue(7);
         }
      }
   }
}
