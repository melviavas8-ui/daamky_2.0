package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.CameraEvent;
import aethereal.MovementState;
import aethereal.RotationPlan;
import aethereal.RotationManager;
import aethereal.Rotation;
import aethereal.MinecraftAccess;
import aethereal.NoRender;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_4184.class)
public abstract class CameraMixin implements MinecraftAccess {
   @Shadow
   private class_243 field_18712;
   @Shadow
   private float field_18718;
   @Shadow
   private float field_18717;
   @Unique
   private float daamky$lastTickDelta;
   @Unique
   private float daamky$currentYaw;
   @Unique
   private float daamky$currentPitch;

   @Shadow
   protected abstract void method_19322(class_243 var1);

   @Shadow
   protected abstract void method_19325(float var1, float var2);

   @Inject(method = "clipToSpace", at = @At("HEAD"), cancellable = true)
   private void daamky$noCameraClip(float var1, CallbackInfoReturnable<Float> var2) {
      DaamkyClient var3 = DaamkyClient.method2004();
      if (var3 != null && var3.method1783() != null) {
         NoRender var4 = var3.method1783().method0976(NoRender.class);
         if (var4 != null && var4.method2203()) {
            var2.setReturnValue(var1);
         }
      }
   }

   @ModifyArg(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/Camera;clipToSpace(F)F"), index = 0)
   private float modifyCameraDistance(float var1) {
      CameraEvent var2 = new CameraEvent(
         (class_4184)this,
         var1,
         this.field_18712.field_1352,
         this.field_18712.field_1351,
         this.field_18712.field_1350,
         this.field_18718,
         this.field_18717,
         this.daamky$lastTickDelta
      );
      DaamkyClient.method2004().method2072().post(var2);
      if (var2.method2195()) {
         this.method_19325(var2.method0483(), var2.method2213());
      }

      return var2.method1603();
   }

   @Inject(method = "update", at = @At("HEAD"))
   private void onCameraUpdateHead(class_1922 var1, class_1297 var2, boolean var3, boolean var4, float var5, CallbackInfo var6) {
      this.daamky$lastTickDelta = var5;
      this.daamky$currentYaw = this.field_18718;
      this.daamky$currentPitch = this.field_18717;
   }

   @Inject(method = "update", at = @At("TAIL"))
   private void onCameraUpdate(class_1922 var1, class_1297 var2, boolean var3, boolean var4, float var5, CallbackInfo var6) {
      CameraEvent var7 = new CameraEvent(
         (class_4184)this,
         4.0F,
         this.field_18712.field_1352,
         this.field_18712.field_1351,
         this.field_18712.field_1350,
         this.field_18718,
         this.field_18717,
         var5
      );
      DaamkyClient.method2004().method2072().post(var7);
      if (var7.method1945() != this.field_18712.field_1352
         || var7.method0412() != this.field_18712.field_1351
         || var7.method0354() != this.field_18712.field_1350) {
         this.method_19322(new class_243(var7.method1945(), var7.method0412(), var7.method0354()));
      }

      if (var7.method2195() && !var3) {
         this.method_19325(var7.method0483(), var7.method2213());
      }
   }

   @Inject(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/Camera;setPos(DDD)V", shift = Shift.AFTER))
   private void injectQuickPerspectiveSwap(class_1922 var1, class_1297 var2, boolean var3, boolean var4, float var5, CallbackInfo var6) {
      RotationManager var7 = RotationManager.field0618;
      RotationPlan var8 = var7.method1606();
      Rotation var9 = var7.method2188();
      Rotation var10 = var7.method2219();
      boolean var11 = var8 != null && var8.method0376();
      if (var10 != null && var9 != null && var11) {
         this.method_19325(
            (float)class_3532.method_16436(
               MovementState.method1945() == 1488.0 ? var5 : MovementState.method1945(), var9.method2047(), var10.method2047()
            ),
            (float)class_3532.method_16436(
               MovementState.method1945() == 1488.0 ? var5 : MovementState.method1945(), var9.method1762(), var10.method1762()
            )
         );
      }
   }
}
