package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.DeathScreenEvent;
import net.minecraft.class_332;
import net.minecraft.class_418;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_418.class)
public class DeathScreenMixin {
   @Shadow
   private int field_2451;

   @Inject(method = "render", at = @At("HEAD"))
   private void render$death(class_332 var1, int var2, int var3, float var4, CallbackInfo var5) {
      DaamkyClient.method2004().method2072().post(new DeathScreenEvent(this.field_2451));
   }
}
