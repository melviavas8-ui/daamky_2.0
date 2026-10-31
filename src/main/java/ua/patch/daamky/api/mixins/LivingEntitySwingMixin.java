package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.MinecraftAccess;
import aethereal.SwingDurationEvent;
import net.minecraft.class_1309;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_1309.class)
public abstract class LivingEntitySwingMixin implements MinecraftAccess {
   @Inject(method = "getHandSwingDuration", at = @At("HEAD"), cancellable = true)
   private void daamky$swingDuration(CallbackInfoReturnable<Integer> var1) {
      if (this == field0796.field_1724) {
         SwingDurationEvent var2 = new SwingDurationEvent();
         DaamkyClient.method2004().method2072().post(var2);
         if (var2.method2079()) {
            var1.setReturnValue(Math.max(1, var2.method1763()));
         }
      }
   }
}
