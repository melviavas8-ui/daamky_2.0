package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import net.minecraft.class_10149;
import net.minecraft.class_10156;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_4587;
import net.minecraft.class_5944;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;

public final class SplashProgressRenderer {
   private static final class_10156 field0728 = new class_10156(DaamkyClient.method1012("core/splash_loader"), class_290.field_1585, class_10149.field_53930);
   private static final long field0005 = System.currentTimeMillis();

   private SplashProgressRenderer() {
   }

   public static void method1471(class_4587 var0, float var1, float var2, float var3, float var4, Color var5) {
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableCull();
      class_5944 var6 = RenderSystem.setShader(field0728);
      if (var6 == null) {
         RenderSystem.enableCull();
         RenderSystem.disableBlend();
      } else {
         var6.method_34582("Progress").method_1251(var4);
         var6.method_34582("Time").method_1251((float)(System.currentTimeMillis() - field0005) / 1000.0F);
         var6.method_34582("ThemeColor").method_1249(var5.getRed() / 255.0F, var5.getGreen() / 255.0F, var5.getBlue() / 255.0F);
         Matrix4f var7 = var0.method_23760().method_23761();
         class_287 var8 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1585);
         var8.method_22918(var7, var1, var2, 0.0F).method_22913(0.0F, 0.0F);
         var8.method_22918(var7, var1, var2 + var3, 0.0F).method_22913(0.0F, 1.0F);
         var8.method_22918(var7, var1 + var3, var2 + var3, 0.0F).method_22913(1.0F, 1.0F);
         var8.method_22918(var7, var1 + var3, var2, 0.0F).method_22913(1.0F, 0.0F);
         class_286.method_43433(var8.method_60800());
         RenderSystem.enableCull();
         RenderSystem.disableBlend();
      }
   }
}
