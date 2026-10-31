package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.BlockOverlay;
import aethereal.WorldProjectionHelper;
import aethereal.NoRender;
import aethereal.RenderEntityEvent;
import aethereal.RenderShaderEvent;
import aethereal.ShaderCache;
import aethereal.WorldRenderEvent;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_1297;
import net.minecraft.class_1533;
import net.minecraft.class_3695;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4604;
import net.minecraft.class_757;
import net.minecraft.class_761;
import net.minecraft.class_898;
import net.minecraft.class_9779;
import net.minecraft.class_9909;
import net.minecraft.class_9922;
import net.minecraft.class_9958;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_761.class)
public abstract class WorldRendererMixin {
   @Shadow
   @Final
   private class_898 field_4109;

   @Shadow
   protected abstract void method_62202(
      class_9909 var1,
      class_4604 var2,
      class_4184 var3,
      Matrix4f var4,
      Matrix4f var5,
      class_9958 var6,
      boolean var7,
      boolean var8,
      class_9779 var9,
      class_3695 var10
   );

   @Inject(method = "render", at = @At("HEAD"))
   public void render(class_9922 var1, class_9779 var2, boolean var3, class_4184 var4, class_757 var5, Matrix4f var6, Matrix4f var7, CallbackInfo var8) {
      WorldRenderEvent.WorldPass var9 = new WorldRenderEvent.WorldPass(var4, var6, var2);
      DaamkyClient.method2004().method2072().post(var9);
      WorldProjectionHelper.field0750.set(var6);
      WorldProjectionHelper.field0168.set(var7);
      WorldProjectionHelper.field1526.set(RenderSystem.getModelViewMatrix());
   }

   @Redirect(
      method = "render",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/WorldRenderer;renderMain(Lnet/minecraft/client/render/FrameGraphBuilder;Lnet/minecraft/client/render/Frustum;Lnet/minecraft/client/render/Camera;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lnet/minecraft/client/render/Fog;ZZLnet/minecraft/client/render/RenderTickCounter;Lnet/minecraft/util/profiler/Profiler;)V"
      )
   )
   private void render$blockOverlay(
      class_761 var1,
      class_9909 var2,
      class_4604 var3,
      class_4184 var4,
      Matrix4f var5,
      Matrix4f var6,
      class_9958 var7,
      boolean var8,
      boolean var9,
      class_9779 var10,
      class_3695 var11
   ) {
      boolean var12 = var8;
      DaamkyClient var13 = DaamkyClient.method2004();
      if (var13 != null && var13.method1783() != null) {
         BlockOverlay var14 = var13.method1783().method0976(BlockOverlay.class);
         if (var14 != null && var14.method2195()) {
            var12 = false;
         }
      }

      this.method_62202(var2, var3, var4, var5, var6, var7, var12, var9, var10, var11);
   }

   @Inject(
      method = "render",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiler/Profiler;swap(Ljava/lang/String;)V", ordinal = 0, shift = Shift.BEFORE)
   )
   private void render$swap(class_9922 var1, class_9779 var2, boolean var3, class_4184 var4, class_757 var5, Matrix4f var6, Matrix4f var7, CallbackInfo var8) {
      RenderShaderEvent var9 = new RenderShaderEvent();
      DaamkyClient.method2004().method2072().post(var9);
   }

   @WrapOperation(
      method = "renderEntity",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/entity/EntityRenderDispatcher;render(Lnet/minecraft/entity/Entity;DDDFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"
      )
   )
   private <E extends class_1297> void renderEntity$render(
      class_898 var1, E var2, double var3, double var5, double var7, float var9, class_4587 var10, class_4597 var11, int var12, Operation<Void> var13
   ) {
      if (var2 instanceof class_1533) {
         DaamkyClient var14 = DaamkyClient.method2004();
         if (var14 != null && var14.method1783() != null) {
            NoRender var15 = var14.method1783().method0976(NoRender.class);
            if (var15 != null && var15.method2208()) {
               return;
            }
         }
      }

      RenderEntityEvent var16 = new RenderEntityEvent(var2, var11, var3, var5, var7, var9, var10);
      DaamkyClient.method2004().method2072().post(var16);
      var13.call(new Object[]{var1, var2, var3, var5, var7, var9, var10, var16.method1630(), var12});
   }

   @Inject(method = "onResized", at = @At("TAIL"))
   private void onResized(int var1, int var2, CallbackInfo var3) {
      ShaderCache.method0550().method0738(var1, var2);
   }

   @Inject(method = "hasBlindnessOrDarkness(Lnet/minecraft/client/render/Camera;)Z", at = @At("HEAD"), cancellable = true)
   private void onHasBlindnessOrDarkness(class_4184 var1, CallbackInfoReturnable<Boolean> var2) {
      DaamkyClient var3 = DaamkyClient.method2004();
      if (var3 != null && var3.method1783() != null) {
         NoRender var4 = var3.method1783().method0976(NoRender.class);
         if (var4 != null && var4.method0480()) {
            var2.setReturnValue(false);
         }
      }
   }
}
