package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import net.minecraft.class_279;
import net.minecraft.class_2960;
import net.minecraft.class_5944;
import net.minecraft.class_9960;
import ua.patch.daamky.api.mixins.accessors.GameRendererAccessor;
import ua.patch.daamky.api.mixins.accessors.PostEffectProcessorAccessor;

public class ToneShaderRenderer implements MinecraftAccess {
   private Color field0712 = new Color(255, 220, 180);
   private float field0003 = 0.25F;
   private float field1410 = 0.4F;
   private float field0957 = 1.15F;
   private float field0177 = 1.0F;
   private float field0458 = 1.05F;
   private float field1614 = 0.3F;

   public void method0961(Color var1) {
      this.field0712 = var1;
   }

   public void method0665(float var1) {
      this.field0003 = var1;
   }

   public void method0124(float var1) {
      this.field1410 = var1;
   }

   public void method2098(float var1) {
      this.field0957 = var1;
   }

   public void method1822(float var1) {
      this.field0177 = var1;
   }

   public void method1638(float var1) {
      this.field0458 = var1;
   }

   public void method1977(float var1) {
      this.field1614 = var1;
   }

   public void method0578() {
      if (field0796.method_22683() != null && field0796.field_1773 != null) {
         try {
            class_279 var1 = field0796.method_62887().method_62941(class_2960.method_60655("daamky", "tone"), class_9960.field_53902);
            if (var1 == null) {
               return;
            }

            class_5944 var2 = ((PostEffectProcessorAccessor)var1).getPasses().getFirst().method_62922();
            if (var2 == null) {
               return;
            }

            var2.method_62899("DiffuseSampler", field0796.method_1522().method_30277());
            var2.method_34582("TintColor").method_1249(this.field0712.getRed() / 255.0F, this.field0712.getGreen() / 255.0F, this.field0712.getBlue() / 255.0F);
            var2.method_34582("TintStrength").method_1251(this.field0003);
            var2.method_34582("Vignette").method_1251(this.field1410);
            var2.method_34582("Saturation").method_1251(this.field0957);
            var2.method_34582("Brightness").method_1251(this.field0177);
            var2.method_34582("Contrast").method_1251(this.field0458);
            var2.method_34582("BloomStrength").method_1251(this.field1614);
            RenderSystem.disableBlend();
            var1.method_1258(field0796.method_1522(), ((GameRendererAccessor)field0796.field_1773).getPool());
            field0796.method_1522().method_1235(false);
         } catch (Exception var3) {
         }
      }
   }
}
