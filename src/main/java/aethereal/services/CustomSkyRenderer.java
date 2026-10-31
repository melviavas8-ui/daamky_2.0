package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import net.minecraft.class_279;
import net.minecraft.class_2960;
import net.minecraft.class_5944;
import net.minecraft.class_9960;
import ua.patch.daamky.api.mixins.accessors.GameRendererAccessor;
import ua.patch.daamky.api.mixins.accessors.PostEffectProcessorAccessor;

public class CustomSkyRenderer implements MinecraftAccess {
   private final long field0568 = System.currentTimeMillis();
   private float field0003 = 0.85F;
   private Color field1500 = new Color(0, 0, 13);
   private Color field1026 = new Color(5, 3, 38);
   private float field0177 = 80.0F;
   private float field0458 = 1.0F;
   private float field1614 = 3.0F;
   private float field1538 = 0.3F;
   private Color field1726 = new Color(77, 26, 128);
   private float field1136 = 0.0F;

   public void method0665(float var1) {
      this.field0003 = var1;
   }

   public void method0961(Color var1) {
      this.field1500 = var1;
   }

   public void method0194(Color var1) {
      this.field1026 = var1;
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

   public void method2121(Color var1) {
      this.field1726 = var1;
   }

   public void method1977(float var1) {
      this.field1136 = var1;
   }

   public void method0578() {
      if (field0796.method_22683() != null && field0796.field_1773 != null) {
         try {
            class_279 var1 = field0796.method_62887().method_62941(class_2960.method_60655("daamky", "customsky"), class_9960.field_53902);
            if (var1 == null) {
               return;
            }

            class_5944 var2 = ((PostEffectProcessorAccessor)var1).getPasses().getFirst().method_62922();
            if (var2 == null) {
               return;
            }

            float var3 = (float)(System.currentTimeMillis() - this.field0568) / 1000.0F;
            float var4 = field0796.field_1773.method_19418() != null ? field0796.field_1773.method_19418().method_19329() : 0.0F;
            float var5 = field0796.field_1773.method_19418() != null ? field0796.field_1773.method_19418().method_19330() : 0.0F;
            var2.method_62899("DiffuseSampler", field0796.method_1522().method_30277());
            var2.method_62899("DepthSampler", field0796.method_1522().method_30278());
            var2.method_34582("Time").method_1251(var3);
            var2.method_34582("SkyMix").method_1251(this.field0003);
            var2.method_34582("SkyColor1").method_1249(this.field1500.getRed() / 255.0F, this.field1500.getGreen() / 255.0F, this.field1500.getBlue() / 255.0F);
            var2.method_34582("SkyColor2").method_1249(this.field1026.getRed() / 255.0F, this.field1026.getGreen() / 255.0F, this.field1026.getBlue() / 255.0F);
            var2.method_34582("StarDensity").method_1251(this.field0177);
            var2.method_34582("StarBrightness").method_1251(this.field0458);
            var2.method_34582("NebulaDensity").method_1251(this.field1614);
            var2.method_34582("NebulaIntensity").method_1251(this.field1538);
            var2.method_34582("NebulaColor")
               .method_1249(this.field1726.getRed() / 255.0F, this.field1726.getGreen() / 255.0F, this.field1726.getBlue() / 255.0F);
            var2.method_34582("CameraPitch").method_1251(var4);
            var2.method_34582("CameraYaw").method_1251(var5);
            var2.method_34582("Aurora").method_1251(this.field1136);
            RenderSystem.disableBlend();
            var1.method_1258(field0796.method_1522(), ((GameRendererAccessor)field0796.field_1773).getPool());
            field0796.method_1522().method_1235(false);
         } catch (Exception var6) {
         }
      }
   }
}
