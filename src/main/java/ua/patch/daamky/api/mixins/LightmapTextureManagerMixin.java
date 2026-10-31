package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.FullBright;
import net.minecraft.class_2874;
import net.minecraft.class_765;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(class_765.class)
public class LightmapTextureManagerMixin {
   @Redirect(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/dimension/DimensionType;ambientLight()F"))
   private float redirectAmbientLight(class_2874 var1) {
      if (DaamkyClient.method2004() != null && DaamkyClient.method2004().method1783() != null) {
         FullBright var2 = DaamkyClient.method2004().method1783().method0976(FullBright.class);
         return var2 != null && var2.method2195() && var2.method1736() ? 1.0F : var1.comp_656();
      } else {
         return var1.comp_656();
      }
   }
}
