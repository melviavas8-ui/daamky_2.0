package ua.patch.daamky.api.mixins;

import aethereal.ModifyGlint;
import java.awt.Color;
import net.minecraft.class_284;
import net.minecraft.class_5944;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_5944.class)
public class ShaderProgramMixin {
   @Shadow
   @Nullable
   public class_284 field_29474;
   @Shadow
   @Nullable
   public class_284 field_42231;
   @Shadow
   @Nullable
   public class_284 field_29472;

   @Inject(method = "bind", at = @At("RETURN"))
   private void onBind(CallbackInfo var1) {
      ModifyGlint var2 = ModifyGlint.field0087;
      if (var2 != null && var2.method2195()) {
         if (this.field_42231 != null) {
            if (this.field_29474 != null) {
               Color var3 = var2.method1726();
               float var4 = var3.getRed() / 255.0F;
               float var5 = var3.getGreen() / 255.0F;
               float var6 = var3.getBlue() / 255.0F;
               float var7 = var3.getAlpha() / 255.0F;
               this.field_29474.method_35657(var4, var5, var6, var7);
               this.field_29474.method_1300();
            }

            float var8 = var2.method1679();
            this.field_42231.method_1251(var8);
            this.field_42231.method_1300();
         }
      }
   }
}
