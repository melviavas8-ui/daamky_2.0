package ua.patch.daamky.api.mixins;

import aethereal.RotationPlan;
import aethereal.RotationManager;
import aethereal.Rotation;
import aethereal.MinecraftAccess;
import net.minecraft.class_1309;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_1309.class)
public abstract class LivingEntityElytraMixin implements MinecraftAccess {
   @Shadow
   protected abstract double method_61426();

   @Inject(method = "calcGlidingVelocity", at = @At("HEAD"), cancellable = true)
   private void daamky$fixGlidingVelocity(class_243 var1, CallbackInfoReturnable<class_243> var2) {
      if (this == field0796.field_1724) {
         RotationManager var3 = RotationManager.field0618;
         RotationPlan var4 = var3.method1606();
         if (var4 != null && var4.method0431()) {
            Rotation var5 = var3.method2219();
            if (var5 != null) {
               float var6 = var5.method2047();
               float var7 = var5.method1762();
               class_243 var8 = class_243.method_1030(var7, var6);
               float var9 = var7 * (float) (Math.PI / 180.0);
               double var10 = Math.sqrt(var8.field_1352 * var8.field_1352 + var8.field_1350 * var8.field_1350);
               double var12 = var1.method_37267();
               double var14 = this.method_61426();
               double var16 = class_3532.method_33723(Math.cos(var9));
               class_243 var18 = var1.method_1031(0.0, var14 * (-1.0 + var16 * 0.75), 0.0);
               if (var18.field_1351 < 0.0 && var10 > 0.0) {
                  double var19 = var18.field_1351 * -0.1 * var16;
                  var18 = var18.method_1031(var8.field_1352 * var19 / var10, var19, var8.field_1350 * var19 / var10);
               }

               if (var9 < 0.0F && var10 > 0.0) {
                  double var22 = var12 * -class_3532.method_15374(var9) * 0.04;
                  var18 = var18.method_1031(-var8.field_1352 * var22 / var10, var22 * 3.2, -var8.field_1350 * var22 / var10);
               }

               if (var10 > 0.0) {
                  var18 = var18.method_1031(
                     (var8.field_1352 / var10 * var12 - var18.field_1352) * 0.1, 0.0, (var8.field_1350 / var10 * var12 - var18.field_1350) * 0.1
                  );
               }

               var18 = var18.method_18805(0.99F, 0.98F, 0.99F);
               var2.setReturnValue(var18);
            }
         }
      }
   }
}
