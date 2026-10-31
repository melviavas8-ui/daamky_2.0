package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.FogRenderEvent;
import aethereal.NoRender;
import net.minecraft.class_1297;
import net.minecraft.class_4184;
import net.minecraft.class_5636;
import net.minecraft.class_638;
import net.minecraft.class_6854;
import net.minecraft.class_758;
import net.minecraft.class_9958;
import net.minecraft.class_758.class_4596;
import net.minecraft.class_758.class_7286;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_758.class)
public class BackgroundRendererMixin {
   @Inject(method = "getFogColor", at = @At("HEAD"), cancellable = true)
   private static void getFogColorHook(class_4184 var0, float var1, class_638 var2, int var3, float var4, CallbackInfoReturnable<Vector4f> var5) {
      FogRenderEvent var6 = new FogRenderEvent();
      DaamkyClient.method2004().method2072().post(var6);
      if (var6.method2079()) {
         int var7 = var6.method1604();
         float var8 = (var7 >> 16 & 0xFF) / 255.0F;
         float var9 = (var7 >> 8 & 0xFF) / 255.0F;
         float var10 = (var7 & 0xFF) / 255.0F;
         float var11 = (var7 >> 24 & 0xFF) / 255.0F;
         var5.setReturnValue(new Vector4f(var8, var9, var10, var11));
      }
   }

   @Inject(method = "applyFog", at = @At("HEAD"), cancellable = true)
   private static void modifyFog(class_4184 var0, class_4596 var1, Vector4f var2, float var3, boolean var4, float var5, CallbackInfoReturnable<class_9958> var6) {
      DaamkyClient var7 = DaamkyClient.method2004();
      if (var7 != null && var7.method1783() != null) {
         NoRender var8 = var7.method1783().method0976(NoRender.class);
         if (var8 != null && var8.method0458() && var0.method_19334() == class_5636.field_27886) {
            var6.setReturnValue(new class_9958(0.0F, var3, class_6854.field_36350, var2.x, var2.y, var2.z, var2.w));
            return;
         }
      }

      FogRenderEvent var14 = new FogRenderEvent();
      DaamkyClient.method2004().method2072().post(var14);
      if (var14.method2079()) {
         int var9 = var14.method1604();
         float var10 = (var9 >> 16 & 0xFF) / 255.0F;
         float var11 = (var9 >> 8 & 0xFF) / 255.0F;
         float var12 = (var9 & 0xFF) / 255.0F;
         float var13 = (var9 >> 24 & 0xFF) / 255.0F;
         var6.setReturnValue(new class_9958(2.0F, var14.method1762(), class_6854.field_36351, var10, var11, var12, var13));
      }
   }

   @Inject(method = "getFogModifier", at = @At("HEAD"), cancellable = true)
   private static void norender$getFogModifier(class_1297 var0, float var1, CallbackInfoReturnable<class_7286> var2) {
      DaamkyClient var3 = DaamkyClient.method2004();
      if (var3 != null && var3.method1783() != null) {
         NoRender var4 = var3.method1783().method0976(NoRender.class);
         if (var4 != null && var4.method0480()) {
            var2.setReturnValue(null);
         }
      }
   }
}
