package ua.patch.daamky.api.mixins;

import aethereal.RotationManager;
import net.minecraft.class_1268;
import net.minecraft.class_2886;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_2886.class)
public class PlayerInteractItemC2SPacketMixin {
   @Mutable
   @Shadow
   @Final
   private float field_51930;
   @Mutable
   @Shadow
   @Final
   private float field_51931;

   @Inject(method = "<init>(Lnet/minecraft/util/Hand;IFF)V", at = @At("RETURN"))
   private void modifyRotation(class_1268 var1, int var2, float var3, float var4, CallbackInfo var5) {
      this.field_51930 = RotationManager.field0618.method0545().method2047();
      this.field_51931 = RotationManager.field0618.method0545().method1762();
   }
}
