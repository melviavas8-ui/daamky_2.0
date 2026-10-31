package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.RotationPlan;
import aethereal.RotationManager;
import aethereal.StaticPlayerEntityAccessor;
import aethereal.Rotation;
import aethereal.MinecraftAccess;
import aethereal.SwingDurationEvent;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_1309.class)
public abstract class LivingEntityMixin extends class_1297 implements MinecraftAccess, StaticPlayerEntityAccessor {
   @Unique
   private boolean daamky$staticPlayerEntity;

   public LivingEntityMixin(class_1299<?> var1, class_1937 var2) {
      super(var1, var2);
   }

   @Override
   public boolean daamky$isStaticPlayerEntity() {
      return this.daamky$staticPlayerEntity;
   }

   @Override
   public void daamky$setStaticPlayerEntity(boolean var1) {
      this.daamky$staticPlayerEntity = var1;
   }

   @Inject(method = "getHandSwingDuration", at = @At("HEAD"), cancellable = true)
   private void onGetHandSwingDuration(CallbackInfoReturnable<Integer> var1) {
      if (this == field0796.field_1724) {
         SwingDurationEvent var2 = new SwingDurationEvent();
         DaamkyClient.method2004().method2072().post(var2);
         if (var2.method2079()) {
            var1.setReturnValue(Math.max(1, var2.method1763()));
         }
      }
   }

   @Redirect(method = "calcGlidingVelocity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getPitch()F"))
   private float hookModifyFallFlyingPitchRedirect(class_1309 var1) {
      if (this != field0796.field_1724) {
         return var1.method_36455();
      }

      RotationManager var2 = RotationManager.field0618;
      Rotation var3 = var2.method0545();
      RotationPlan var4 = var2.method1606();
      return var3 != null && var4 != null && var4.method0431() && !var4.method0376() ? var3.method1762() : var1.method_36455();
   }

   @Redirect(
      method = "calcGlidingVelocity",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getRotationVector()Lnet/minecraft/util/math/Vec3d;")
   )
   private class_243 hookModifyFallFlyingRotationVectorRedirect(class_1309 var1) {
      if (this != field0796.field_1724) {
         return var1.method_5720();
      }

      RotationManager var2 = RotationManager.field0618;
      Rotation var3 = var2.method0545();
      RotationPlan var4 = var2.method1606();
      return var3 != null && var4 != null && var4.method0431() && !var4.method0376() ? var3.method0024() : var1.method_5720();
   }

   @ModifyExpressionValue(method = "jump", at = @At(value = "NEW", target = "(DDD)Lnet/minecraft/util/math/Vec3d;"))
   private class_243 hookFixRotation(class_243 var1) {
      if (this != field0796.field_1724) {
         return var1;
      }

      float var2 = RotationManager.field0618.method1781().method2047() * (float) (Math.PI / 180.0);
      return new class_243(-class_3532.method_15374(var2) * 0.2F, 0.0, class_3532.method_15362(var2) * 0.2F);
   }

   @ModifyExpressionValue(method = "calcGlidingVelocity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getPitch()F"))
   private float hookModifyFallFlyingPitch(float var1) {
      return this != field0796.field_1724 ? var1 : RotationManager.field0618.method1781().method1762();
   }

   @ModifyExpressionValue(
      method = "calcGlidingVelocity",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getRotationVector()Lnet/minecraft/util/math/Vec3d;")
   )
   private class_243 hookModifyFallFlyingRotationVector(class_243 var1) {
      return this != field0796.field_1724 ? var1 : RotationManager.field0618.method1781().method0024();
   }
}
