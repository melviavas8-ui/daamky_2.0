package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.NoRender;
import net.minecraft.class_10034;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_572;
import net.minecraft.class_970;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_970.class)
public abstract class ArmorFeatureRendererMixin<S extends class_10034, M extends class_572<S>, A extends class_572<S>> {
   @Inject(
      method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/render/entity/state/BipedEntityRenderState;FF)V",
      at = @At("HEAD"),
      cancellable = true
   )
   private void onRenderArmor(class_4587 var1, class_4597 var2, int var3, S var4, float var5, float var6, CallbackInfo var7) {
      DaamkyClient var8 = DaamkyClient.method2004();
      if (var8 != null && var8.method1783() != null) {
         NoRender var9 = var8.method1783().method0976(NoRender.class);
         if (var9 != null && var9.method0411()) {
            var7.cancel();
         }
      }
   }
}
