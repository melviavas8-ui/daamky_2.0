package ua.patch.daamky.api.mixins;

import aethereal.Ambience;
import aethereal.DaamkyClient;
import net.minecraft.class_638.class_5271;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_5271.class)
public class ClientWorldPropertiesMixin {
   @Shadow
   private long field_24439;

   @Inject(method = "setTimeOfDay", at = @At("HEAD"), cancellable = true)
   private void setTimeOfDay$ambience(long var1, CallbackInfo var3) {
      if (DaamkyClient.method2004() != null && DaamkyClient.method2004().method1783() != null) {
         Ambience var4 = DaamkyClient.method2004().method1783().method0976(Ambience.class);
         if (var4 != null && var4.method1736()) {
            this.field_24439 = var4.method1681();
            var3.cancel();
         }
      }
   }
}
