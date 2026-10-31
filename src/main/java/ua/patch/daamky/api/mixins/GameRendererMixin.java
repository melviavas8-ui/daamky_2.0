package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.WorldRenderHelper;
import aethereal.WorldGeometryRenderer;
import aethereal.RaycastHelper;
import aethereal.RotationManager;
import aethereal.EmberHands;
import aethereal.EntityCollisionEvent;
import aethereal.FovEvent;
import aethereal.GlowRenderEvent;
import aethereal.MinecraftAccess;
import aethereal.NoRender;
import aethereal.NoTrace;
import aethereal.RenderEntityEvent;
import aethereal.RenderShaderEvent;
import aethereal.WorldRenderEvent;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_1297;
import net.minecraft.class_1675;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3966;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_757;
import net.minecraft.class_9779;
import net.minecraft.class_239.class_240;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_757.class)
public abstract class GameRendererMixin implements MinecraftAccess {
   @Shadow
   private float field_4005;
   @Shadow
   private float field_3988;
   @Shadow
   private float field_4004;

   @Shadow
   public abstract float method_32796();

   @Inject(method = "renderWorld", at = @At("HEAD"))
   public void renderWorld(class_9779 var1, CallbackInfo var2) {
      WorldRenderHelper.method0578();
   }

   @WrapOperation(
      method = "renderWorld",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/GameRenderer;renderHand(Lnet/minecraft/client/render/Camera;FLorg/joml/Matrix4f;)V")
   )
   private void renderWorld$emberHands(class_757 var1, class_4184 var2, float var3, Matrix4f var4, Operation<Void> var5) {
      EmberHands var6 = DaamkyClient.method2004().method1783().method0976(EmberHands.class);
      if (var6 != null && var6.method2195()) {
         var6.method0991(() -> var5.call(new Object[]{var1, var2, var3, var4}));
      } else {
         var5.call(new Object[]{var1, var2, var3, var4});
      }
   }

   @Inject(at = @At(value = "FIELD", target = "Lnet/minecraft/client/render/GameRenderer;renderHand:Z", opcode = 180, ordinal = 0), method = "renderWorld")
   public void renderWorld(class_9779 var1, CallbackInfo var2, @Local(ordinal = 2) Matrix4f var3, @Local(ordinal = 1) float var4, @Local class_4587 var5) {
      RenderSystem.getModelViewStack().pushMatrix();
      RenderSystem.getModelViewStack().mul(var3);
      class_4587 var6 = new class_4587();
      RenderSystem.getModelViewStack().mul(var6.method_23760().method_23761());
      WorldRenderEvent.GamePass var7 = new WorldRenderEvent.GamePass(var1, var5);
      DaamkyClient.method2004().method2072().post(var7);
      WorldRenderHelper.method1081(WorldRenderHelper.field0139, WorldRenderHelper.field1508, false);
      WorldRenderHelper.method1081(WorldRenderHelper.field1032, WorldRenderHelper.field0209, true);
      WorldRenderHelper.method1079(WorldRenderHelper.field0488, WorldRenderHelper.field1644);
      RenderSystem.getModelViewStack().popMatrix();
   }

   @Inject(
      method = "renderWorld",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/WorldRenderer;render(Lnet/minecraft/client/util/ObjectAllocator;Lnet/minecraft/client/render/RenderTickCounter;ZLnet/minecraft/client/render/Camera;Lnet/minecraft/client/render/GameRenderer;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;)V",
         shift = Shift.AFTER
      )
   )
   private void renderWorld$swap(class_9779 var1, CallbackInfo var2, @Local(ordinal = 2) Matrix4f var3, @Local(ordinal = 1) float var4, @Local class_4587 var5) {
      RenderSystem.getModelViewStack().pushMatrix();
      RenderSystem.getModelViewStack().mul(var3);
      WorldGeometryRenderer.method0578();
      DaamkyClient.method2004().method2072().post(new GlowRenderEvent(var5, var4));
      WorldGeometryRenderer.method1081(WorldGeometryRenderer.field0139, WorldGeometryRenderer.field1508, false);
      WorldGeometryRenderer.method1081(WorldGeometryRenderer.field1032, WorldGeometryRenderer.field0209, true);
      WorldGeometryRenderer.method1079(WorldGeometryRenderer.field0488, WorldGeometryRenderer.field1644);
      WorldGeometryRenderer.field0751 = false;
      DaamkyClient.method2004().method2072().post(new GlowRenderEvent.Pre(var5, var4));
      DaamkyClient.method2004().method2072().post(new RenderEntityEvent.Pre());
      RenderSystem.getModelViewStack().popMatrix();
   }

   @Inject(method = "findCrosshairTarget", at = @At("HEAD"))
   private void findCrosshairTarget$hitboxOn(class_1297 var1, double var2, double var4, float var6, CallbackInfoReturnable<class_239> var7) {
      EntityCollisionEvent.method0345(true);
   }

   @Inject(method = "findCrosshairTarget", at = @At("RETURN"))
   private void findCrosshairTarget$hitboxOff(class_1297 var1, double var2, double var4, float var6, CallbackInfoReturnable<class_239> var7) {
      EntityCollisionEvent.method0345(false);
   }

   @Redirect(
      method = "findCrosshairTarget",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;raycast(DFZ)Lnet/minecraft/util/hit/HitResult;")
   )
   private class_239 hookRaycast(class_1297 var1, double var2, float var4, boolean var5) {
      return (class_239)(var1 != field0796.field_1724
         ? var1.method_5745(var2, var4, var5)
         : RaycastHelper.method0640(var2, RotationManager.field0618.method0545(), var5));
   }

   @Redirect(
      method = "findCrosshairTarget",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getRotationVec(F)Lnet/minecraft/util/math/Vec3d;")
   )
   private class_243 hookRotationVector(class_1297 var1, float var2) {
      return RotationManager.field0618.method0545().method0024();
   }

   @Inject(method = "findCrosshairTarget", at = @At("HEAD"), cancellable = true)
   private void findCrosshairTarget$noTrace(class_1297 var1, double var2, double var4, float var6, CallbackInfoReturnable<class_239> var7) {
      DaamkyClient var8 = DaamkyClient.method2004();
      if (var8 != null && var8.method1783() != null) {
         NoTrace var9 = var8.method1783().method0976(NoTrace.class);
         if (var9 != null) {
            boolean var10 = var9.method1736();
            boolean var11 = var9.method1692();
            if (var10 || var11) {
               double var12 = Math.max(var2, var4);
               class_239 var14 = (class_239)(var11 ? var9.method1131(var1, var12, var6, false) : var1.method_5745(var12, var6, false));
               if (var10) {
                  var7.setReturnValue(var14);
               } else {
                  class_243 var15 = var1.method_5836(var6);
                  class_243 var16 = var1.method_5828(var6);
                  class_243 var17 = var15.method_1031(var16.field_1352 * var12, var16.field_1351 * var12, var16.field_1350 * var12);
                  class_238 var18 = var1.method_5829().method_18804(var16.method_1021(var12)).method_1009(1.0, 1.0, 1.0);
                  double var19 = var14.method_17783() == class_240.field_1333 ? var12 * var12 : var15.method_1025(var14.method_17784());
                  class_3966 var21 = class_1675.method_18075(var1, var15, var17, var18, var0 -> !var0.method_7325() && var0.method_5863(), var19);
                  if (var21 != null) {
                     double var22 = var15.method_1025(var21.method_17784());
                     if (var22 < var19 || var14.method_17783() == class_240.field_1333) {
                        var7.setReturnValue(var21);
                        return;
                     }
                  }

                  var7.setReturnValue(var14);
               }
            }
         }
      }
   }

   @Inject(method = "getBasicProjectionMatrix", at = @At("TAIL"), cancellable = true)
   private void getBasicProjectionMatrix$aspect(float var1, CallbackInfoReturnable<Matrix4f> var2) {
      FovEvent var3 = new FovEvent();
      DaamkyClient.method2004().method2072().post(var3);
      if (var3.method2079()) {
         Matrix4f var4 = new Matrix4f();
         if (this.field_4005 != 1.0F) {
            var4.translate(this.field_3988, -this.field_4004, 0.0F);
            var4.scale(this.field_4005, this.field_4005, 1.0F);
         }

         var4.perspective(var1 * (float) (Math.PI / 180.0), var3.method1762(), 0.05F, this.method_32796());
         var2.setReturnValue(var4);
      }
   }

   @Inject(method = "renderWorld", at = @At("TAIL"))
   private void renderWorld$TAIL(class_9779 var1, CallbackInfo var2) {
      DaamkyClient.method2004().method2072().post(new RenderShaderEvent.Pre());
   }

   @Inject(method = "tiltViewWhenHurt", at = @At("HEAD"), cancellable = true)
   private void onTiltViewWhenHurt(CallbackInfo var1) {
      DaamkyClient var2 = DaamkyClient.method2004();
      if (var2 != null && var2.method1783() != null) {
         NoRender var3 = var2.method1783().method0976(NoRender.class);
         if (var3 != null && var3.method1692()) {
            var1.cancel();
         }
      }
   }
}
