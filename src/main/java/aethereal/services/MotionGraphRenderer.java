package aethereal;

import net.minecraft.class_276;
import net.minecraft.class_279;
import net.minecraft.class_2960;
import net.minecraft.class_5944;
import net.minecraft.class_6367;
import net.minecraft.class_9960;
import ua.patch.daamky.api.mixins.accessors.GameRendererAccessor;
import ua.patch.daamky.api.mixins.accessors.PostEffectProcessorAccessor;

public class MotionGraphRenderer implements MinecraftAccess {
   private class_276 field0737;
   private class_276 field0159;
   private boolean field1527 = false;

   private void method0025() {
      if (!this.field1527 && field0796.method_22683() != null) {
         this.field0737 = new class_6367(field0796.method_22683().method_4489(), field0796.method_22683().method_4506(), true);
         this.field0159 = new class_6367(field0796.method_22683().method_4489(), field0796.method_22683().method_4506(), true);
         this.field0737.method_1236(0.0F, 0.0F, 0.0F, 0.0F);
         this.field0159.method_1236(0.0F, 0.0F, 0.0F, 0.0F);
         this.field1527 = true;
      }
   }

   public void method0738(int var1, int var2) {
      this.method0025();
      if (this.field1527) {
         this.field0737.method_1234(var1, var2);
         this.field0159.method_1234(var1, var2);
      }
   }

   public class_276 method0570() {
      this.method0025();
      return this.field0737;
   }

   public void method0693(float var1, float var2, float var3, float var4, float var5, int var6, float var7, float var8, float var9, float var10, float var11) {
      this.method0025();
      if (this.field1527) {
         try {
            class_279 var12 = field0796.method_62887().method_62941(class_2960.method_60655("daamky", "motiongraph"), class_9960.field_53902);
            if (var12 == null) {
               return;
            }

            class_5944 var13 = ((PostEffectProcessorAccessor)var12).getPasses().getFirst().method_62922();
            if (var13 == null) {
               return;
            }

            var13.method_62899("DiffuseSampler", field0796.method_1522().method_30277());
            var13.method_62899("GraphBuffer", this.field0737.method_30277());
            var13.method_34582("PosX").method_1251(var1 / 100.0F);
            var13.method_34582("PosY").method_1251(var2 / 100.0F);
            var13.method_34582("GraphWidth").method_1251(var3 / 100.0F);
            var13.method_34582("GraphHeight").method_1251(var4 / 100.0F);
            var13.method_34582("Speed").method_1251(var5);
            var13.method_34582("Points").method_1251(var6);
            var13.method_34582("Intensity").method_1251(var7);
            var13.method_34582("FadeR").method_1251(var8);
            var13.method_34582("FadeG").method_1251(var9);
            var13.method_34582("FadeB").method_1251(var10);
            var13.method_34582("Motion").method_1251(var11);
            var13.method_34582("Time").method_1251((float)(System.currentTimeMillis() % 100000L) / 1000.0F);
            this.field0159.method_1230();
            var12.method_1258(this.field0159, ((GameRendererAccessor)field0796.field_1773).getPool());
            class_276 var14 = this.field0737;
            this.field0737 = this.field0159;
            this.field0159 = var14;
            var12.method_1258(field0796.method_1522(), ((GameRendererAccessor)field0796.field_1773).getPool());
            field0796.method_1522().method_1235(false);
         } catch (Exception var15) {
         }
      }
   }
}
