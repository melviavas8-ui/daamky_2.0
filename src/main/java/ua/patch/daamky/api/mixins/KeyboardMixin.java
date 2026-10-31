package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.KeyEvent;
import net.minecraft.class_309;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_309.class)
public abstract class KeyboardMixin {
   @Inject(method = "onKey", at = @At("HEAD"))
   public void onKey(long var1, int var3, int var4, int var5, int var6, CallbackInfo var7) {
      KeyEvent var8 = new KeyEvent(var3, var5, var6);
      DaamkyClient.method2004().method2072().post(var8);
   }
}
