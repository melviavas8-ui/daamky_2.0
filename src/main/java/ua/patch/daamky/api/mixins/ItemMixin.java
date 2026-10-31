package ua.patch.daamky.api.mixins;

import aethereal.RotationManager;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(class_1792.class)
public class ItemMixin {
   @Redirect(
      method = "raycast",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;getRotationVector(FF)Lnet/minecraft/util/math/Vec3d;")
   )
   private static class_243 raycastHook(class_1657 var0, float var1, float var2) {
      return RotationManager.field0618.method0545().method0024();
   }
}
