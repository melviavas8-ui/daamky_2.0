package ua.patch.daamky.api.mixins;

import aethereal.RotationManager;
import aethereal.MinecraftAccess;
import aethereal.SuperFirework;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1309;
import net.minecraft.class_1671;
import net.minecraft.class_243;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_1671.class)
public class FireworkRocketEntityMixin implements MinecraftAccess {
   @Shadow
   @Nullable
   private class_1309 field_7616;

   @WrapOperation(
      method = "tick",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getRotationVector()Lnet/minecraft/util/math/Vec3d;")
   )
   public class_243 getRotationVectorHook(class_1309 var1, Operation<class_243> var2) {
      return this.field_7616 == field0796.field_1724 ? RotationManager.field0618.method1781().method0024() : (class_243)var2.call(new Object[]{var1});
   }

   @WrapOperation(
      method = "tick",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getVelocity()Lnet/minecraft/util/math/Vec3d;", ordinal = 0)
   )
   public class_243 getVelocityHook(class_1309 var1, Operation<class_243> var2) {
      if (this.field_7616 != field0796.field_1724) {
         return (class_243)var2.call(new Object[]{var1});
      }

      SuperFirework var3 = SuperFirework.method1722();
      if (var3 != null && var3.method2195()) {
         class_243 var4 = (class_243)var2.call(new Object[]{var1});
         class_243 var5 = RotationManager.field0618.method1781().method0024();
         boolean var6 = Math.abs(RotationManager.field0618.method1781().method1762()) > 60.0F;
         if (var3.field0058.method0492() == SuperFirework.Mode.field0692) {
            double var17 = var3.method0614(var5.field_1352, var5.field_1350);
            double var18 = var3.method0608(var5.field_1351);
            return new class_243(
               var4.field_1352 + var5.field_1352 * (var17 - 1.5),
               var4.field_1351 + var5.field_1351 * (var18 - 1.5),
               var4.field_1350 + var5.field_1350 * (var17 - 1.5)
            );
         } else {
            float var7 = RotationManager.field0618.method0545().method2047();
            int var8 = var7 > 0.0F ? 45 : -45;
            double var9 = Math.abs((var7 + var8) % 90.0F - var8) / 45.0;
            double var11 = 1.0 + 0.3 * var9 * var9;
            class_243 var13 = RotationManager.field0618.method1781().method0024();
            float var14 = var3.field1450.method0492() / 20.0F;
            double var15 = var14 * var11;
            return new class_243(var13.field_1352 * var15, var6 ? var13.field_1351 * var15 : var13.field_1351 * var14, var13.field_1350 * var15);
         }
      } else {
         return (class_243)var2.call(new Object[]{var1});
      }
   }
}
