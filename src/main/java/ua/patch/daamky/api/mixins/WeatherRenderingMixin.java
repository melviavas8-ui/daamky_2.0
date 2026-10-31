package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.NoRender;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_4597;
import net.minecraft.class_9976;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_9976.class)
public abstract class WeatherRenderingMixin {
   @Inject(
      method = "renderPrecipitation(Lnet/minecraft/world/World;Lnet/minecraft/client/render/VertexConsumerProvider;IFLnet/minecraft/util/math/Vec3d;)V",
      at = @At("HEAD"),
      cancellable = true
   )
   private void daamky$onRenderPrecipitation(class_1937 var1, class_4597 var2, int var3, float var4, class_243 var5, CallbackInfo var6) {
      DaamkyClient var7 = DaamkyClient.method2004();
      if (var7 != null && var7.method1783() != null) {
         NoRender var8 = var7.method1783().method0976(NoRender.class);
         if (var8 != null && var8.method2252()) {
            var6.cancel();
         }
      }
   }
}
