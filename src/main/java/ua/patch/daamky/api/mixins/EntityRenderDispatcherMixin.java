package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.Chams;
import aethereal.MinecraftAccess;
import aethereal.Shaders;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_10017;
import net.minecraft.class_1297;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_897;
import net.minecraft.class_898;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_898.class)
public class EntityRenderDispatcherMixin implements MinecraftAccess {
   @Inject(
      method = "render(Lnet/minecraft/entity/Entity;DDDFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/render/entity/EntityRenderer;)V",
      at = @At("HEAD"),
      cancellable = true
   )
   private void render$pixelScaleSkip(
      class_1297 var1,
      double var2,
      double var4,
      double var6,
      float var8,
      class_4587 var9,
      class_4597 var10,
      int var11,
      class_897<?, ?> var12,
      CallbackInfo var13
   ) {
      Chams var14 = Chams.method1705();
      if (var14 != null && var14.method1129(var1)) {
         var13.cancel();
      }
   }

   @WrapOperation(
      method = "render(Lnet/minecraft/entity/Entity;DDDFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/render/entity/EntityRenderer;)V",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/entity/EntityRenderDispatcher;renderFire(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/render/entity/state/EntityRenderState;Lorg/joml/Quaternionf;)V"
      )
   )
   private void render$renderFire(class_898 var1, class_4587 var2, class_4597 var3, class_10017 var4, Quaternionf var5, Operation<Void> var6) {
      class_4597 var7 = var3;
      DaamkyClient var8 = DaamkyClient.method2004();
      if (var8 != null && var8.method1783() != null) {
         Shaders var9 = var8.method1783().method0976(Shaders.class);
         if (var9 != null && var9.method2195()) {
            var7 = field0796.method_22940().method_23000();
         }
      }

      var6.call(new Object[]{var1, var2, var7, var4, var5});
   }
}
