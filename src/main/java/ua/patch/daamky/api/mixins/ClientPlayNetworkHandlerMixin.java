package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.ClientConnectEvent;
import net.minecraft.class_2678;
import net.minecraft.class_634;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_634.class)
public class ClientPlayNetworkHandlerMixin {
   @Inject(method = "sendChatMessage", at = @At("HEAD"), cancellable = true)
   private void onSendChatMessage(String var1, CallbackInfo var2) {
      if (DaamkyClient.method2004().method2257().method0214(var1)) {
         var2.cancel();
      }
   }

   @Inject(method = "onGameJoin", at = @At("HEAD"))
   private void onGameJoinHook(class_2678 var1, CallbackInfo var2) {
      DaamkyClient.method2004().method2072().post(new ClientConnectEvent());
   }
}
