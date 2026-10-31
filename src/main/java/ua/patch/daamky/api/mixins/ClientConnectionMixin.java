package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.PacketQueue;
import aethereal.PacketEvent;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.class_2535;
import net.minecraft.class_2596;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_2535.class)
public abstract class ClientConnectionMixin {
   @Inject(method = "channelRead0(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/packet/Packet;)V", at = @At("HEAD"), cancellable = true)
   public void channelRead0(ChannelHandlerContext var1, class_2596<?> var2, CallbackInfo var3) {
      PacketEvent.Inbound var4 = new PacketEvent.Inbound(var2);
      PacketEvent.Transfer var5 = new PacketEvent.Transfer(var2);
      DaamkyClient.method2004().method2072().post(var4);
      DaamkyClient.method2004().method2072().post(var5);
      if (var4.method2079() || var5.method2079()) {
         var3.cancel();
      }
   }

   @Inject(method = "send(Lnet/minecraft/network/packet/Packet;)V", at = @At("HEAD"), cancellable = true)
   public void send(class_2596<?> var1, CallbackInfo var2) {
      if (PacketQueue.method0559().contains(var1)) {
         PacketQueue.method0559().remove(var1);
      } else {
         PacketEvent.Outbound var3 = new PacketEvent.Outbound(var1);
         PacketEvent.Transfer var4 = new PacketEvent.Transfer(var1);
         DaamkyClient.method2004().method2072().post(var3);
         DaamkyClient.method2004().method2072().post(var4);
         if (var3.method2079() || var4.method2079()) {
            var2.cancel();
         }
      }
   }
}
