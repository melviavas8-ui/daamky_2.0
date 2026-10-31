package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import net.minecraft.class_276;
import net.minecraft.class_279;
import net.minecraft.class_283;
import net.minecraft.class_2960;
import net.minecraft.class_5944;
import net.minecraft.class_6367;
import net.minecraft.class_9960;
import ua.patch.daamky.api.mixins.accessors.GameRendererAccessor;
import ua.patch.daamky.api.mixins.accessors.PostEffectProcessorAccessor;

public class PanoramaHatRenderer implements MinecraftAccess {
   private class_276 field0737;
   private boolean field0169 = false;
   private float field1410 = 0.3F;
   private float field0957 = 2.0F;

   private void method0578() {
      if (!this.field0169 && field0796.method_22683() != null) {
         this.field0737 = new class_6367(field0796.method_22683().method_4489(), field0796.method_22683().method_4506(), true);
         this.field0169 = true;
      }
   }

   public void method0738(int var1, int var2) {
      this.method0578();
      if (this.field0169) {
         this.field0737.method_1234(var1, var2);
      }
   }

   public PanoramaHatRenderer method0652(float var1) {
      this.field1410 = Math.max(0.0F, Math.min(1.0F, var1));
      return this;
   }

   public PanoramaHatRenderer method0117(float var1) {
      this.field0957 = var1;
      return this;
   }

   public void method2098(float var1) {
      this.method0578();
      if (this.field0169) {
         try {
            class_279 var2 = field0796.method_62887().method_62941(class_2960.method_60655("daamky", "hat"), class_9960.field_53902);
            if (var2 == null) {
               return;
            }

            List var3 = ((PostEffectProcessorAccessor)var2).getPasses();
            if (var3 == null || var3.isEmpty()) {
               return;
            }

            class_5944 var4 = var3.getFirst().method_62922();
            if (var4 == null) {
               return;
            }

            if (var4.method_34582("Time") == null) {
               return;
            }

            var4.method_62899("DiffuseSampler", field0796.method_1522().method_30277());
            var4.method_34582("PanSpeed").method_1251(var1);
            var4.method_34582("Tilt").method_1251(this.field1410);
            var4.method_34582("FOV").method_1251(this.field0957);
            var4.method_34582("Time").method_1251((float)(System.currentTimeMillis() % 100000L) / 1000.0F);
            RenderSystem.disableBlend();
            var2.method_1258(field0796.method_1522(), ((GameRendererAccessor)field0796.field_1773).getPool());
            field0796.method_1522().method_1235(false);
         } catch (Exception var5) {
         }
      }
   }
}
