package ua.patch.daamky.api.mixins;

import aethereal.RotationManager;
import aethereal.MinecraftAccess;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.class_1309;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_1309.class)
public abstract class LivingEntityJumpMixin implements MinecraftAccess {
   @ModifyExpressionValue(method = "jump", at = @At(value = "NEW", target = "(DDD)Lnet/minecraft/util/math/Vec3d;"))
   private class_243 daamky$fixJumpSprintBoost(class_243 var1) {
      if (this != field0796.field_1724) {
         return var1;
      }

      float var2 = RotationManager.field0618.method1781().method2047() * (float) (Math.PI / 180.0);
      return new class_243(-class_3532.method_15374(var2) * 0.2F, 0.0, class_3532.method_15362(var2) * 0.2F);
   }
}
