package ua.patch.daamky.api.mixins;

import net.minecraft.class_268;
import net.minecraft.class_269;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_269.class)
public class ScoreboardMixin {
   @Inject(method = "removeScoreHolderFromTeam", at = @At("HEAD"), cancellable = true)
   private void onRemoveFromTeam(String var1, class_268 var2, CallbackInfo var3) {
      try {
         class_269 var4 = (class_269)this;
         class_268 var5 = var4.method_1164(var1);
         if (var5 != var2) {
            var3.cancel();
         }
      } catch (Exception var6) {
         var3.cancel();
      }
   }
}
