package aethereal;

import net.minecraft.class_276;
import net.minecraft.class_279;
import net.minecraft.class_2960;
import net.minecraft.class_5944;
import net.minecraft.class_6367;
import net.minecraft.class_9960;
import ua.patch.daamky.api.mixins.accessors.GameRendererAccessor;
import ua.patch.daamky.api.mixins.accessors.PostEffectProcessorAccessor;

public class HatShaderRenderer implements MinecraftAccess {
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

   public void method0684(float var1, float var2, float var3) {
      this.method0025();
      if (this.field0169) {
         try {
            class_279 var4 = field0796.method_62887().method_62941(class_2960.method_60655("daamky", "hat"), class_9960.field_53902);
            if (var4 == null) {
               System.err.println("Hat shader is null!");
               return;
            }

            class_5944 var5 = ((PostEffectProcessorAccessor)var4).getPasses().getFirst().method_62922();
            if (var5 == null) {
               System.err.println("Hat program is null!");
               return;
            }

            var5.method_62899("DiffuseSampler", field0796.method_1522().method_30277());
            var5.method_34582("PanSpeed").method_1251(var1);
            var5.method_34582("Tilt").method_1251(var2);
            var5.method_34582("FOV").method_1251(var3);
            var5.method_34582("Time").method_1251((float)(System.currentTimeMillis() % 100000L) / 1000.0F);
            var4.method_1258(field0796.method_1522(), ((GameRendererAccessor)field0796.field_1773).getPool());
            field0796.method_1522().method_1235(false);
         } catch (Exception var6) {
            System.err.println("Error rendering hat shader: " + var6.getMessage());
            var6.printStackTrace();
         }
      }
   }
}
