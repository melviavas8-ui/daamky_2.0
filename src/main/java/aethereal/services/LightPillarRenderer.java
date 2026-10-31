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

public class LightPillarRenderer implements MinecraftAccess {
   private class_276 field0737;
   private boolean field0169 = false;
   private long field1412 = System.currentTimeMillis();
   private float field0957 = 0.322F;
   private float field0177 = 0.153F;
   private float field0458 = 1.0F;
   private float field1614 = 1.0F;
   private float field1538 = 0.624F;
   private float field1704 = 0.988F;
   private float field1136 = 1.0F;
   private float field1087 = 0.005F;
   private float field1196 = 3.0F;
   private float field0871 = 0.4F;
   private float field0826 = 0.5F;
   private float field0910 = 0.3F;
   private float field1331 = 1.0F;
   private float field1292 = 0.0F;
   private float field1369 = 0.0F;
   private float field0385 = 0.0F;

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

   public LightPillarRenderer method0682(float var1, float var2, float var3) {
      this.field0957 = var1;
      this.field0177 = var2;
      this.field0458 = var3;
      return this;
   }

   public LightPillarRenderer method0718(int var1) {
      this.field0957 = (var1 >> 16 & 0xFF) / 255.0F;
      this.field0177 = (var1 >> 8 & 0xFF) / 255.0F;
      this.field0458 = (var1 & 0xFF) / 255.0F;
      return this;
   }

   public LightPillarRenderer method0130(float var1, float var2, float var3) {
      this.field1614 = var1;
      this.field1538 = var2;
      this.field1704 = var3;
      return this;
   }

   public LightPillarRenderer method0138(int var1) {
      this.field1614 = (var1 >> 16 & 0xFF) / 255.0F;
      this.field1538 = (var1 >> 8 & 0xFF) / 255.0F;
      this.field1704 = (var1 & 0xFF) / 255.0F;
      return this;
   }

   public LightPillarRenderer method0653(float var1) {
      this.field1136 = var1;
      return this;
   }

   public LightPillarRenderer method0118(float var1) {
      this.field1087 = var1;
      return this;
   }

   public LightPillarRenderer method2093(float var1) {
      this.field1196 = var1;
      return this;
   }

   public LightPillarRenderer method1818(float var1) {
      this.field0871 = var1;
      return this;
   }

   public LightPillarRenderer method1637(float var1) {
      this.field0826 = var1;
      return this;
   }

   public LightPillarRenderer method1976(float var1) {
      this.field0910 = var1;
      return this;
   }

   public LightPillarRenderer method0434(float var1) {
      this.field1331 = var1;
      return this;
   }

   public LightPillarRenderer method0378(float var1) {
      this.field1292 = var1;
      return this;
   }

   public LightPillarRenderer method0671(float var1, float var2) {
      this.field1369 = var1;
      this.field0385 = var2;
      return this;
   }

   public void method0578() {
      this.method0501(1.0F);
   }

   public void method0501(float var1) {
      this.method2078();
      if (this.field0169) {
         try {
            class_279 var2 = field0796.method_62887().method_62941(class_2960.method_60655("daamky", "lightpillar"), class_9960.field_53902);
            if (var2 == null) {
               return;
            }

            class_5944 var3 = ((PostEffectProcessorAccessor)var2).getPasses().getFirst().method_62922();
            if (var3 == null) {
               return;
            }

            float var4 = (float)(System.currentTimeMillis() - this.field1412) / 1000.0F;
            var3.method_62899("DiffuseSampler", field0796.method_1522().method_30277());
            var3.method_34582("Time").method_1251(var4);
            var3.method_34582("TopColor").method_1249(this.field0957, this.field0177, this.field0458);
            var3.method_34582("BottomColor").method_1249(this.field1614, this.field1538, this.field1704);
            var3.method_34582("Intensity").method_1251(this.field1136);
            var3.method_34582("GlowAmount").method_1251(this.field1087);
            var3.method_34582("PillarWidth").method_1251(this.field1196);
            var3.method_34582("PillarHeight").method_1251(this.field0871);
            var3.method_34582("NoiseIntensity").method_1251(this.field0826);
            var3.method_34582("RotationSpeed").method_1251(this.field0910);
            var3.method_34582("Opacity").method_1251(this.field1331 * var1);
            var3.method_34582("PillarRotation").method_1251(this.field1292);
            var3.method_34582("PillarOffset").method_1255(this.field1369, this.field0385);
            RenderSystem.disableBlend();
            var2.method_1258(field0796.method_1522(), ((GameRendererAccessor)field0796.field_1773).getPool());
            field0796.method_1522().method_1235(false);
         } catch (Exception var5) {
            System.err.println("[LightPillar] Error: " + var5.getMessage());
         }
      }
   }

   public void method0025() {
      this.field1412 = System.currentTimeMillis();
   }
}
