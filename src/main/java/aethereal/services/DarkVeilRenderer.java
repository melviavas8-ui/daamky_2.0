package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_276;
import net.minecraft.class_279;
import net.minecraft.class_2960;
import net.minecraft.class_5944;
import net.minecraft.class_6367;
import net.minecraft.class_9960;
import ua.patch.daamky.api.mixins.accessors.GameRendererAccessor;
import ua.patch.daamky.api.mixins.accessors.PostEffectProcessorAccessor;

public class DarkVeilRenderer implements MinecraftAccess {
   private class_276 field0737;
   private boolean field0169 = false;
   private long field1412 = System.currentTimeMillis();
   private float field0957 = 0.5F;
   private float field0177 = 0.0F;
   private float field0458 = 0.07F;
   private float field1614 = 0.0F;
   private float field1538 = 4.9F;
   private float field1704 = 5.0F;
   private float field1136 = 0.33F;
   private float field1087 = 0.06F;
   private float field1196 = 0.7F;
   private float field0871 = 0.8F;
   private float field0826 = 0.0F;
   private float field0910 = 0.0F;

   private void method2078() {
      if (!this.field0169 && field0796.method_22683() != null) {
         this.field0737 = new class_6367(field0796.method_22683().method_4489(), field0796.method_22683().method_4506(), true);
         this.field0169 = true;
      }
   }

   public void method0738(int var1, int var2) {
      this.method2078();
      if (this.field0169) {
         this.field0737.method_1234(var1, var2);
      }
   }

   public void method0665(float var1) {
      this.field0957 = var1;
   }

   public void method0124(float var1) {
      this.field0177 = var1;
   }

   public void method2098(float var1) {
      this.field0458 = var1;
   }

   public void method1822(float var1) {
      this.field1614 = var1;
   }

   public void method1638(float var1) {
      this.field1538 = var1;
   }

   public void method1977(float var1) {
      this.field1704 = var1;
   }

   public void method0684(float var1, float var2, float var3) {
      this.field1136 = var1;
      this.field1087 = var2;
      this.field1196 = var3;
   }

   public void method0729(int var1) {
      this.field1136 = (var1 >> 16 & 0xFF) / 255.0F;
      this.field1087 = (var1 >> 8 & 0xFF) / 255.0F;
      this.field1196 = (var1 & 0xFF) / 255.0F;
   }

   public void method0435(float var1) {
      this.field0871 = var1;
   }

   public void method0379(float var1) {
      this.field0826 = var1;
   }

   public void method0501(float var1) {
      this.field0910 = var1;
   }

   public void method0578() {
      this.method2232(1.0F);
   }

   public void method2232(float var1) {
      if (!(var1 <= 0.001F)) {
         this.method2078();
         if (this.field0169) {
            float var2 = Math.max(0.0F, Math.min(1.0F, var1));

            try {
               class_279 var3 = field0796.method_62887().method_62941(class_2960.method_60655("daamky", "darkveil"), class_9960.field_53902);
               if (var3 == null) {
                  return;
               }

               class_5944 var4 = ((PostEffectProcessorAccessor)var3).getPasses().getFirst().method_62922();
               if (var4 == null) {
                  return;
               }

               float var5 = (float)(System.currentTimeMillis() - this.field1412) / 1000.0F;
               var4.method_62899("DiffuseSampler", field0796.method_1522().method_30277());
               var4.method_34582("Time").method_1251(var5);
               var4.method_34582("Speed").method_1251(this.field0957);
               var4.method_34582("HueShift").method_1251(this.field0177);
               var4.method_34582("NoiseIntensity").method_1251(this.field0458);
               var4.method_34582("ScanlineIntensity").method_1251(this.field1614);
               var4.method_34582("ScanlineFrequency").method_1251(this.field1538);
               var4.method_34582("WarpAmount").method_1251(this.field1704);
               var4.method_34582("TintColor").method_1249(this.field1136, this.field1087, this.field1196);
               var4.method_34582("TintStrength").method_1251(this.field0871);
               var4.method_34582("VerticalOffset").method_1251(this.field0826);
               var4.method_34582("FadeHeight").method_1251(this.field0910);
               var4.method_34582("Opacity").method_1251(var2);
               RenderSystem.disableBlend();
               var3.method_1258(field0796.method_1522(), ((GameRendererAccessor)field0796.field_1773).getPool());
               field0796.method_1522().method_1235(false);
            } catch (Exception var6) {
               System.err.println("[DarkVeil] Error: " + var6.getMessage());
               var6.printStackTrace();
            }
         }
      }
   }

   public void method0025() {
      this.field1412 = System.currentTimeMillis();
   }
}
