package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.EntitySpawnEvent;
import net.minecraft.class_1297;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_638.class)
public abstract class ClientWorldMixin {
   @Inject(method = "addEntity", at = @At("HEAD"))
   private void onAddEntity(class_1297 var1, CallbackInfo var2) {
      EntitySpawnEvent var3 = new EntitySpawnEvent(var1);
      if (DaamkyClient.method2004() != null) {
         DaamkyClient.method2004().method2072().post(var3);
      }
   }
}
