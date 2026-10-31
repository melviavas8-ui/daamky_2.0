package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.HandAnimationEvent;
import aethereal.HandOffsetEvent;
import aethereal.FirstPersonTrailRenderer;
import aethereal.RenderHandEvent;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_1268;
import net.minecraft.class_1306;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_742;
import net.minecraft.class_746;
import net.minecraft.class_759;
import net.minecraft.class_7833;
import net.minecraft.class_811;
import net.minecraft.class_4597.class_4598;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = class_759.class, priority = 999)
public abstract class HeldItemRendererMixin {
   @Shadow
   private class_1799 field_4048;
   @Shadow
   @Final
   private class_310 field_4050;

   @Shadow
   protected abstract void method_3219(class_4587 var1, class_4597 var2, int var3, float var4, float var5, class_1306 var6);

   @Shadow
   protected abstract void method_3231(class_4587 var1, class_4597 var2, int var3, float var4, float var5, float var6);

   @Shadow
   protected abstract void method_3222(class_4587 var1, class_4597 var2, int var3, float var4, class_1306 var5, float var6, class_1799 var7);

   @Shadow
   protected abstract void method_3224(class_4587 var1, class_1306 var2, float var3);

   @Shadow
   protected abstract void method_3217(class_4587 var1, class_1306 var2, float var3);

   @Shadow
   public abstract void method_3233(class_1309 var1, class_1799 var2, class_811 var3, boolean var4, class_4587 var5, class_4597 var6, int var7);

   @Unique
   private static float getV(class_4587 var0, float var1, float var2) {
      float var3 = var1;
      if (1.0F < var3) {
         var3 = 1.0F;
      }

      if (0.1F < var3) {
         float var4 = class_3532.method_15374((var2 - 0.1F) * 1.3F);
         float var5 = var3 - 0.1F;
         float var6 = var4 * var5;
         var0.method_46416(var6 * 0.0F, var6 * 0.004F, var6 * 0.0F);
      }

      return var3;
   }

   @Unique
   private static float getU(float var0, @NotNull class_1799 var1, @NotNull class_4587 var2, float var3, @NotNull class_310 var4) {
      var2.method_22907(class_7833.field_40716.rotationDegrees(var3 * 35.3F));
      var2.method_22907(class_7833.field_40718.rotationDegrees(var3 * -9.785F));
      assert null != var4.field_1724;
      class_1309 var6 = var4.field_1724;
      return var1.method_7935(var6) - (var6.method_6014() - var0 + 1.0F);
   }

   @Inject(method = "renderFirstPersonItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;push()V", shift = Shift.AFTER))
   private void renderFirstPersonItem$offset(
      class_742 var1,
      float var2,
      float var3,
      class_1268 var4,
      float var5,
      class_1799 var6,
      float var7,
      class_4587 var8,
      class_4597 var9,
      int var10,
      CallbackInfo var11
   ) {
      HandOffsetEvent var12 = new HandOffsetEvent(var8, var6, var4);
      DaamkyClient.method2004().method2072().post(var12);
   }

   @WrapOperation(
      method = "renderItem(FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider$Immediate;Lnet/minecraft/client/network/ClientPlayerEntity;I)V",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/item/HeldItemRenderer;renderFirstPersonItem(Lnet/minecraft/client/network/AbstractClientPlayerEntity;FFLnet/minecraft/util/Hand;FLnet/minecraft/item/ItemStack;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"
      )
   )
   private void renderItem$renderFirstPersonItem(
      class_759 var1,
      class_742 var2,
      float var3,
      float var4,
      class_1268 var5,
      float var6,
      class_1799 var7,
      float var8,
      class_4587 var9,
      class_4597 var10,
      int var11,
      Operation<Void> var12
   ) {
      RenderHandEvent var13 = new RenderHandEvent(var10, var9, var7, var5);
      DaamkyClient.method2004().method2072().post(var13);
      FirstPersonTrailRenderer.method1543(var1, var2, var3, var4, var5, var6, var7, var8, var9, var13.method1809(), var11, var12);
      var12.call(new Object[]{var1, var2, var3, var4, var5, var6, var7, var8, var9, var13.method1809(), var11});
   }

   @Inject(
      method = "renderItem(FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider$Immediate;Lnet/minecraft/client/network/ClientPlayerEntity;I)V",
      at = @At("TAIL")
   )
   private void renderItem$TAIL(float var1, class_4587 var2, class_4598 var3, class_746 var4, int var5, CallbackInfo var6) {
      DaamkyClient.method2004().method2072().post(new RenderHandEvent.Pre());
   }

   @WrapOperation(
      method = "renderFirstPersonItem",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/item/HeldItemRenderer;swingArm(FFLnet/minecraft/client/util/math/MatrixStack;ILnet/minecraft/util/Arm;)V",
         ordinal = 2
      )
   )
   private void renderFirstPersonItem$swingAnimation(
      class_759 var1,
      float var2,
      float var3,
      class_4587 var4,
      int var5,
      class_1306 var6,
      Operation<Void> var7,
      @Local(ordinal = 0, argsOnly = true) class_742 var8,
      @Local(ordinal = 0, argsOnly = true) class_1268 var9
   ) {
      HandAnimationEvent var10 = new HandAnimationEvent(var4, var9, var2);
      DaamkyClient.method2004().method2072().post(var10);
      if (!var10.method2079()) {
         var7.call(new Object[]{var1, var2, var3, var4, var5, var6});
      }
   }
}
