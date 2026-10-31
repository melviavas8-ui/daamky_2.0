package aethereal;

import net.minecraft.class_276;
import net.minecraft.class_279;
import net.minecraft.class_2960;
import net.minecraft.class_5944;
import net.minecraft.class_6367;
import net.minecraft.class_9960;
import ua.patch.daamky.api.mixins.accessors.GameRendererAccessor;
import ua.patch.daamky.api.mixins.accessors.PostEffectProcessorAccessor;

public class LiquidGlassRenderer implements MinecraftAccess {
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

   public void method0691(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.method0025();
      if (this.field0169) {
         try {
            class_279 var9 = field0796.method_62887().method_62941(class_2960.method_60655("daamky", "liquidglass"), class_9960.field_53902);
            if (var9 == null) {
               return;
            }

            class_5944 var10 = ((PostEffectProcessorAccessor)var9).getPasses().getFirst().method_62922();
            if (var10 == null) {
               return;
            }

            var10.method_62899("DiffuseSampler", field0796.method_1522().method_30277());
            var10.method_34582("GlassWidth").method_1251(var1);
            var10.method_34582("GlassHeight").method_1251(var2);
            var10.method_34582("Radius").method_1251(var3);
            var10.method_34582("Refraction").method_1251(var4);
            var10.method_34582("Sharpness").method_1251(var5);
            var10.method_34582("Blur").method_1251(var6);
            var10.method_34582("Mouse").method_1255(var7, var8);
            var9.method_1258(field0796.method_1522(), ((GameRendererAccessor)field0796.field_1773).getPool());
            field0796.method_1522().method_1235(false);
         } catch (Exception var11) {
         }
      }
   }

   public void method0687(float var1, float var2, float var3, float var4, float var5) {
      this.method0025();
      if (this.field0169 && field0796.method_22683() != null) {
         float var6 = field0796.method_22683().method_4489();
         float var7 = field0796.method_22683().method_4506();
         float var8 = var3 / var6 * 2.0F;
         float var9 = var4 / var7 * 2.0F;
         float var10 = var5 / var6 * 2.0F;
         this.method0691(var8, var9, var10, 0.05F, 0.15F, 0.8F, var1, var7 - var2);
      }
   }

   public void method0134(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.method0025();
      if (this.field0169 && field0796.method_22683() != null) {
         float var9 = field0796.method_22683().method_4489();
         float var10 = field0796.method_22683().method_4506();
         float var11 = var3 / var9 * 2.0F;
         float var12 = var4 / var10 * 2.0F;
         float var13 = var5 / var9 * 2.0F;
         this.method0691(var11, var12, var13, var6, var7, var8, var1, var10 - var2);
      }
   }
}
