package ua.patch.daamky.api.mixins;

import aethereal.RotationManager;
import aethereal.MinecraftAccess;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.class_1657;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_1657.class)
public abstract class PlayerEntityMixin implements MinecraftAccess {
   @ModifyExpressionValue(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;getYaw()F"))
   private float hookFixRotation(float var1) {
      return RotationManager.field0618.method1781().method2047();
   }
}
