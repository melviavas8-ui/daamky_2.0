package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.Interface;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_490;
import net.minecraft.class_746;
import ua.patch.daamky.api.mixins.accessors.IHandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_490.class)
public abstract class InventoryScreenMixin {
   @Inject(method = "drawBackground", at = @At("HEAD"), cancellable = true)
   private void onDrawBackground(class_332 var1, float var2, int var3, int var4, CallbackInfo var5) {
      DaamkyClient var6 = DaamkyClient.method2004();
      if (var6 != null && var6.method1783() != null) {
         Interface var7 = var6.method1783().method0976(Interface.class);
         if (var7 != null && var7.method1692()) {
            IHandledScreen var8 = (IHandledScreen)this;
            int var9 = var8.daamky$getX();
            int var10 = var8.daamky$getY();
            var7.method1415(var1, var9, var10, var8.daamky$getBackgroundWidth(), var8.daamky$getBackgroundHeight(), "Inventory");
            class_746 var11 = class_310.method_1551().field_1724;
            if (var11 != null) {
               class_490.method_2486(var1, var9 + 26, var10 + 8, var9 + 75, var10 + 78, 30, 0.0625F, var3, var4, var11);
            }

            var5.cancel();
         }
      }
   }

   @Inject(method = "drawForeground", at = @At("HEAD"), cancellable = true)
   private void onDrawForeground(class_332 var1, int var2, int var3, CallbackInfo var4) {
      DaamkyClient var5 = DaamkyClient.method2004();
      if (var5 != null && var5.method1783() != null) {
         Interface var6 = var5.method1783().method0976(Interface.class);
         if (var6 != null && var6.method1692()) {
            var4.cancel();
         }
      }
   }
}
