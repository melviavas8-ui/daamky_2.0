package ua.patch.daamky.api.mixins;

import aethereal.Aura;
import aethereal.RotationManager;
import aethereal.EntityModelRenderHook;
import aethereal.StaticPlayerEntityAccessor;
import aethereal.MinecraftAccess;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import java.util.Map;
import net.minecraft.class_10042;
import net.minecraft.class_1309;
import net.minecraft.class_1921;
import net.minecraft.class_2350;
import net.minecraft.class_3532;
import net.minecraft.class_4050;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_465;
import net.minecraft.class_572;
import net.minecraft.class_583;
import net.minecraft.class_630;
import net.minecraft.class_897;
import net.minecraft.class_922;
import net.minecraft.class_9848;
import net.minecraft.class_5617.class_5618;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(class_922.class)
public abstract class LivingEntityRendererMixin<T extends class_1309, S extends class_10042, M extends class_583<? super S>>
   extends class_897<T, S>
   implements MinecraftAccess,
   EntityModelRenderHook {
   @Shadow
   protected M field_4737;

   @Shadow
   public abstract int method_62484(S var1);

   @Shadow
   public abstract float method_23185(S var1);

   @Shadow
   @Nullable
   public abstract class_1921 method_24302(S var1, boolean var2, boolean var3, boolean var4);

   @Shadow
   public abstract boolean method_4056(S var1);

   @Shadow
   public abstract void method_4058(S var1, class_4587 var2, float var3, float var4);

   @Shadow
   public abstract void method_4042(S var1, class_4587 var2);

   public LivingEntityRendererMixin(class_5618 var1) {
      super(var1);
   }

   @ModifyVariable(method = "updateRenderState", at = @At("HEAD"), argsOnly = true)
   private float daamky$staticEntityTickDelta(float var1, class_1309 var2) {
      return var2 instanceof StaticPlayerEntityAccessor var3 && var3.daamky$isStaticPlayerEntity() ? 1.0F : var1;
   }

   @ModifyExpressionValue(
      method = "updateRenderState(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;F)V",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;lerpAngleDegrees(FFF)F")
   )
   private float lerpAngleDegreesHook(float var1, @Local(ordinal = 0, argsOnly = true) class_1309 var2, @Local(ordinal = 0, argsOnly = true) float var3) {
      RotationManager var4 = RotationManager.field0618;
      Aura var5 = Aura.method1701();
      if (var2.equals(MinecraftAccess.field0796.field_1724)
         && var4.method2059().method2047() != MinecraftAccess.field0796.field_1724.method_36454()
         && var4.method0012().method2047() != MinecraftAccess.field0796.field_1724.method_36454()
         && !(MinecraftAccess.field0796.field_1755 instanceof class_465)) {
         boolean var6 = Aura.field0169;
         float var7 = var6 ? var4.method0012().method2047() : var4.method2059().method2047();
         float var8 = var6 ? var4.method0012().method2047() : var4.method0545().method2047();
         if (Aura.method1701().method0409() == null) {
            var7 = var4.method2059().method2047();
            var8 = var4.method0545().method2047();
         }

         return class_3532.method_16439(var3, var7, var8);
      } else {
         return var1;
      }
   }

   @ModifyExpressionValue(
      method = "updateRenderState(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;F)V",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getLerpedPitch(F)F")
   )
   private float getLerpedPitchHook(float var1, @Local(ordinal = 0, argsOnly = true) class_1309 var2, @Local(ordinal = 0, argsOnly = true) float var3) {
      RotationManager var4 = RotationManager.field0618;
      Aura var5 = Aura.method1701();
      if (var2.equals(MinecraftAccess.field0796.field_1724)
         && var4.method2059().method1762() != MinecraftAccess.field0796.field_1724.method_36455()
         && var4.method0012().method1762() != MinecraftAccess.field0796.field_1724.method_36455()
         && !(MinecraftAccess.field0796.field_1755 instanceof class_465)) {
         boolean var6 = Aura.field0169;
         float var7 = var6 ? var4.method0012().method1762() : var4.method2059().method1762();
         float var8 = var6 ? var4.method0012().method1762() : var4.method0545().method1762();
         if (Aura.method1701().method0409() == null) {
            var7 = var4.method2059().method1762();
            var8 = var4.method0545().method1762();
         }

         return class_3532.method_16439(var3, var7, var8);
      } else {
         return var1;
      }
   }

   @Override
   public void daamky$render(class_10042 var1, class_4587 var2, class_4597 var3, int var4) {
      var2.method_22903();
      if (var1.method_62613(class_4050.field_18078)) {
         class_2350 var5 = var1.field_53463;
         if (var5 != null) {
            float var6 = var1.field_53331 - 0.1F;
            var2.method_46416(-var5.method_10148() * var6, 0.0F, -var5.method_10165() * var6);
         }
      }

      float var13 = var1.field_53453;
      var2.method_22905(var13, var13, var13);
      this.method_4058((S)var1, var2, var1.field_53446, var13);
      var2.method_22905(-1.0F, -1.0F, 1.0F);
      this.method_4042((S)var1, var2);
      var2.method_46416(0.0F, -1.501F, 0.0F);
      this.field_4737.method_2819(var1);
      boolean var14 = this.method_4056((S)var1);
      boolean var7 = !var14 && !var1.field_53461;
      class_1921 var8 = this.method_24302((S)var1, var14, var7, var1.field_53462);
      if (var8 != null) {
         class_4588 var9 = var3.getBuffer(var8);
         int var10 = class_922.method_23622(var1, this.method_23185((S)var1));
         int var11 = var7 ? 654311423 : -1;
         int var12 = class_9848.method_61322(var11, this.method_62484((S)var1));
         this.field_4737.method_62100(var2, var9, var4, var10, var12);
      }

      var2.method_22909();
   }

   @Override
   public void daamky$collectSkeleton(class_10042 var1, class_4587 var2, Map<String, Vector3f> var3) {
      if (this.field_4737 instanceof class_572 var4) {
         var2.method_22903();
         if (var1.method_62613(class_4050.field_18078)) {
            class_2350 var7 = var1.field_53463;
            if (var7 != null) {
               float var6 = var1.field_53331 - 0.1F;
               var2.method_46416(-var7.method_10148() * var6, 0.0F, -var7.method_10165() * var6);
            }
         }

         float var8 = var1.field_53453;
         var2.method_22905(var8, var8, var8);
         this.method_4058((S)var1, var2, var1.field_53446, var8);
         var2.method_22905(-1.0F, -1.0F, 1.0F);
         this.method_4042((S)var1, var2);
         var2.method_46416(0.0F, -1.501F, 0.0F);
         this.field_4737.method_2819(var1);
         var3.put("headTop", this.daamky$joint(var2, var4.field_3398, 0.0F, -0.5F, 0.0F));
         var3.put("neck", this.daamky$joint(var2, var4.field_3398, 0.0F, 0.0F, 0.0F));
         var3.put("pelvis", this.daamky$joint(var2, var4.field_3391, 0.0F, 0.75F, 0.0F));
         var3.put("shoulderR", this.daamky$joint(var2, var4.field_3401, 0.0F, 0.0F, 0.0F));
         var3.put("handR", this.daamky$joint(var2, var4.field_3401, 0.0F, 0.625F, 0.0F));
         var3.put("shoulderL", this.daamky$joint(var2, var4.field_27433, 0.0F, 0.0F, 0.0F));
         var3.put("handL", this.daamky$joint(var2, var4.field_27433, 0.0F, 0.625F, 0.0F));
         var3.put("hipR", this.daamky$joint(var2, var4.field_3392, 0.0F, 0.0F, 0.0F));
         var3.put("footR", this.daamky$joint(var2, var4.field_3392, 0.0F, 0.75F, 0.0F));
         var3.put("hipL", this.daamky$joint(var2, var4.field_3397, 0.0F, 0.0F, 0.0F));
         var3.put("footL", this.daamky$joint(var2, var4.field_3397, 0.0F, 0.75F, 0.0F));
         var2.method_22909();
      }
   }

   @Unique
   private Vector3f daamky$joint(class_4587 var1, class_630 var2, float var3, float var4, float var5) {
      var1.method_22903();
      var2.method_22703(var1);
      Vector3f var6 = new Vector3f(var3, var4, var5);
      var1.method_23760().method_23761().transformPosition(var6);
      var1.method_22909();
      return var6;
   }
}
