package aethereal;

import net.minecraft.class_276;
import net.minecraft.class_279;
import net.minecraft.class_2960;
import net.minecraft.class_5944;
import net.minecraft.class_6367;
import net.minecraft.class_9960;
import ua.patch.daamky.api.mixins.accessors.GameRendererAccessor;
import ua.patch.daamky.api.mixins.accessors.PostEffectProcessorAccessor;

public class LiquidGlassRendererV2 implements MinecraftAccess {
   private class_276 field0737;
   private boolean field0169 = false;

   private void method0025() {
      if (!this.field0169 && field0796.method_22683() != null) {
         this.field0737 = new class_6367(field0796.method_22683().method_4489(), field0796.method_22683().method_4506(), true);
         this.field0169 = true;
      }
   }

   public void method0738(int var1, int var2) {
      this.method0025();
      if (this.field0169) {
         this.field0737.method_1234(var1, var2);
      }
   }

   public class_276 method0570() {
      this.method0025();
      return this.field0737;
   }

   public void method0690(float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.method0025();
      if (this.field0169) {
         try {
            class_279 var8 = field0796.method_62887().method_62941(class_2960.method_60655("daamky", "liquidglass2"), class_9960.field_53902);
            if (var8 == null) {
               return;
            }

            class_5944 var9 = ((PostEffectProcessorAccessor)var8).getPasses().getFirst().method_62922();
            if (var9 == null) {
               return;
            }

            var9.method_62899("DiffuseSampler", field0796.method_1522().method_30277());
            var9.method_34582("RectCenter").method_1255(var1, var2);
            var9.method_34582("RectSize").method_1255(var3, var4);
            var9.method_34582("BorderWidth").method_1251(1.0F);
            var9.method_34582("LensStrength").method_1251(var5);
            var9.method_34582("BlurAmount").method_1251(var6);
            var9.method_34582("LightingStrength").method_1251(var7);
            var8.method_1258(field0796.method_1522(), ((GameRendererAccessor)field0796.field_1773).getPool());
            field0796.method_1522().method_1235(false);
         } catch (Exception var10) {
         }
      }
   }

   public void method0686(float var1, float var2, float var3, float var4) {
      this.method0133(var1, var2, var3, var4, 1.0F, 0.5F, 1.0F);
   }

   public void method0133(float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.method0025();
      if (this.field0169 && field0796.method_22683() != null) {
         float var8 = (float)field0796.method_22683().method_4495();
         float var9 = field0796.method_22683().method_4506();
         float var10 = (var1 + var3 / 2.0F) * var8;
         float var11 = var9 - (var2 + var4 / 2.0F) * var8;
         float var12 = var3 / 2.0F * var8;
         float var13 = var4 / 2.0F * var8;
         this.method0690(var10, var11, var12, var13, var5, var6, var7);
      }
   }
}
