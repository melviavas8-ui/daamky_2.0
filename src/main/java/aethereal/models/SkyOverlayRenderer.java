package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import net.minecraft.class_10149;
import net.minecraft.class_10156;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_310;
import net.minecraft.class_5944;
import net.minecraft.class_293.class_5596;

public final class SkyOverlayRenderer {
   private static final class_10156 field0728 = new class_10156(ResourceHelper.method1012("sky_overlay"), class_290.field_1592, class_10149.field_53930);
   private static final long field0005 = System.currentTimeMillis();

   private SkyOverlayRenderer() {
   }

   public static void method0706(float var0, Color var1, Color var2, Color var3, Color var4, Color var5, float var6) {
      class_310 var7 = class_310.method_1551();
      if (var7.field_1773 != null && var7.field_1773.method_19418() != null && var7.field_1690 != null) {
         class_5944 var8 = RenderSystem.setShader(field0728);
         if (var8 != null) {
            float var9 = (float)(System.currentTimeMillis() - field0005) / 1000.0F;
            var8.method_34582("Time").method_1251(var9);
            var8.method_34582("CloudIntensity").method_1251(var0);
            var8.method_34582("SkyColor1").method_1249(var1.getRed() / 255.0F, var1.getGreen() / 255.0F, var1.getBlue() / 255.0F);
            var8.method_34582("SkyColor2").method_1249(var2.getRed() / 255.0F, var2.getGreen() / 255.0F, var2.getBlue() / 255.0F);
            var8.method_34582("NebulaColor1").method_1249(var3.getRed() / 255.0F, var3.getGreen() / 255.0F, var3.getBlue() / 255.0F);
            var8.method_34582("NebulaColor2").method_1249(var4.getRed() / 255.0F, var4.getGreen() / 255.0F, var4.getBlue() / 255.0F);
            var8.method_34582("SunColor").method_1249(var5.getRed() / 255.0F, var5.getGreen() / 255.0F, var5.getBlue() / 255.0F);
            var8.method_34582("SunSize").method_1251(var6);
            RenderSystem.disableBlend();
            RenderSystem.disableCull();
            RenderSystem.depthMask(false);
            RenderSystem.disableDepthTest();
            class_287 var10 = class_289.method_1348().method_60827(class_5596.field_27380, class_290.field_1592);
            var10.method_22912(-1.0F, -1.0F, 0.0F);
            var10.method_22912(1.0F, -1.0F, 0.0F);
            var10.method_22912(-1.0F, 1.0F, 0.0F);
            var10.method_22912(1.0F, 1.0F, 0.0F);
            class_286.method_43433(var10.method_60800());
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(true);
            RenderSystem.enableCull();
         }
      }
   }
}
