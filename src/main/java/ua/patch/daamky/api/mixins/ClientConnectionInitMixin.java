package ua.patch.daamky.api.mixins;

import aethereal.ProxyChannelFactory;
import aethereal.ProxyEntry;
import aethereal.ProxyStorage;
import io.netty.channel.Channel;
import io.netty.handler.proxy.ProxyHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net/minecraft/network/ClientConnection$1")
public abstract class ClientConnectionInitMixin {
   @Inject(method = "initChannel(Lio/netty/channel/Channel;)V", at = @At("HEAD"))
   private void onInitChannel(Channel var1, CallbackInfo var2) {
      ProxyEntry var3 = ProxyStorage.method1786().method0547();
      if (var3 != null) {
         ProxyHandler var4 = ProxyChannelFactory.method0906(var3);
         if (var4 != null) {
            var1.pipeline().addFirst("daamky_proxy", var4);
         }
      }
   }
}
