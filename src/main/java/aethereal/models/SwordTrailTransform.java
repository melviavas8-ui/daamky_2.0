package aethereal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import org.joml.Matrix4f;

public final class SwordTrailTransform {
   private SwordTrailTransform() {
   }

   public static void method1452(class_4587 var0) {
      SwordTrail var1 = DaamkyClient.method2004().method1783().method0976(SwordTrail.class);
      if (var1 != null && var1.method0480()) {
         List var2 = new ArrayList<>();

         for (SwordTrailSample var4 : var1.method1712().method2065()) {
            var2.add(var4);
         }

         int var35 = var1.method0400();
         if (var2.size() > var35) {
            var2 = var2.subList(var2.size() - var35, var2.size());
         }

         if (var2.size() >= 2) {
            class_310 var36 = class_310.method_1551();
            if (var36.field_1773 != null && var36.field_1773.method_19418() != null) {
               class_4184 var5 = var36.field_1773.method_19418();
               class_243 var6 = var5.method_19326();
               float var7 = var1.method0393();
               Color var8 = var1.method0407();
               Color var9 = var1.method0518();
               SwordTrail.GradientMode var10 = var1.method0514();
               SwordTrail.FadeMode var11 = var1.method0525();
               long var12 = System.currentTimeMillis();
               Matrix4f var14 = new class_4587().method_23760().method_23761();
               int var15 = var2.size();

               for (int var16 = 0; var16 < var15 - 1; var16++) {
                  SwordTrailSample var17 = var2.get(var16);
                  SwordTrailSample var18 = var2.get(var16 + 1);
                  class_243 var19 = var17.method0569().method_1020(var6);
                  class_243 var20 = var18.method0569().method_1020(var6);
                  class_243 var21 = var20.method_1020(var19);
                  if (!(var21.method_1027() < 9.999997729060978E-7)) {
                     var21 = var21.method_1029();
                     class_243 var22 = var19.method_1029();
                     class_243 var23 = var21.method_1036(var22);
                     if (var23.method_1027() < 9.999997729060978E-7) {
                        var23 = new class_243(0.0, 1.0, 0.0);
                     }

                     var23 = var23.method_1029();
                     float var24 = 1.0F - (float)var16 / (var15 - 1);
                     float var25 = 1.0F - (float)(var16 + 1) / (var15 - 1);
                     if (var11 == SwordTrail.FadeMode.field0119) {
                        var24 *= var24;
                        var25 *= var25;
                     }

                     int var26 = method0939(var10, var8, var9, var24, var12, var16, var15);
                     int var27 = method0939(var10, var8, var9, var25, var12, var16 + 1, var15);
                     int var28 = method0733(var26, var24);
                     int var29 = method0733(var27, var25);
                     float var30 = var7 * 0.5F;
                     class_243 var31 = var19.method_1019(var23.method_1021(var30));
                     class_243 var32 = var19.method_1020(var23.method_1021(var30));
                     class_243 var33 = var20.method_1019(var23.method_1021(var30));
                     class_243 var34 = var20.method_1020(var23.method_1021(var30));
                     WorldGeometryRenderer.field0139
                        .add(
                           new WorldGeometryRenderer.VertexBatch(
                              new WorldGeometryRenderer.ColoredVertex(var14, (float)var31.field_1352, (float)var31.field_1351, (float)var31.field_1350, var28),
                              new WorldGeometryRenderer.ColoredVertex(var14, (float)var32.field_1352, (float)var32.field_1351, (float)var32.field_1350, var28),
                              new WorldGeometryRenderer.ColoredVertex(var14, (float)var34.field_1352, (float)var34.field_1351, (float)var34.field_1350, var29),
                              new WorldGeometryRenderer.ColoredVertex(var14, (float)var33.field_1352, (float)var33.field_1351, (float)var33.field_1350, var29)
                           )
                        );
                  }
               }
            }
         }
      }
   }

   private static int method0939(SwordTrail.GradientMode var0, Color var1, Color var2, float var3, long var4, int var6, int var7) {
      return switch (var0) {
         case field0696 -> var1.getRGB();
         case field0120 -> method0968(var2, var1, var3);
         case field1490 -> method0781(var4, var6, var7);
      };
   }

   private static int method0968(Color var0, Color var1, float var2) {
      int var3 = (int)(var0.getRed() + (var1.getRed() - var0.getRed()) * var2);
      int var4 = (int)(var0.getGreen() + (var1.getGreen() - var0.getGreen()) * var2);
      int var5 = (int)(var0.getBlue() + (var1.getBlue() - var0.getBlue()) * var2);
      int var6 = (int)(var0.getAlpha() + (var1.getAlpha() - var0.getAlpha()) * var2);
      return new Color(method0716(var3), method0716(var4), method0716(var5), method0716(var6)).getRGB();
   }

   private static int method0781(long var0, int var2, int var3) {
      float var4 = ((float)(var0 % 2000L) / 2000.0F + (float)var2 / var3) % 1.0F;
      return Color.HSBtoRGB(var4, 1.0F, 1.0F) | 0xFF000000;
   }

   private static int method0733(int var0, float var1) {
      int var2 = Math.round((var0 >> 24 & 0xFF) * var1);
      return method0716(var2) << 24 | var0 & 16777215;
   }

   private static int method0716(int var0) {
      return Math.max(0, Math.min(255, var0));
   }
}
