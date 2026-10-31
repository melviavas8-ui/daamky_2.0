package aethereal;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3959;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;

public final class RaycastMath {
   public static final double field0565 = 12.0;

   private RaycastMath() {
   }

   public static double method0614(double var0, double var2) {
      if (var0 > var2) {
         return 0.0;
      }

      double var4 = 1.0 - var0 / var2;
      return var4 <= 0.0 ? 0.0 : (var4 * var4 + var4) / 2.0 * 7.0 * var2 + 1.0;
   }

   public static double method1324(class_243 var0, class_238 var1) {
      double var2 = method0617(var0.field_1352, var1.field_1323, var1.field_1320);
      double var4 = method0617(var0.field_1351, var1.field_1322, var1.field_1325);
      double var6 = method0617(var0.field_1350, var1.field_1321, var1.field_1324);
      return var0.method_1022(new class_243(var2, var4, var6));
   }

   public static double method1251(class_1937 var0, class_243 var1, class_238 var2, int var3, class_1297 var4) {
      if (var3 < 1) {
         return 1.0;
      }

      int var5 = 0;
      double var6 = var2.field_1320 - var2.field_1323;
      double var8 = var2.field_1325 - var2.field_1322;
      double var10 = var2.field_1324 - var2.field_1321;
      ThreadLocalRandom var12 = ThreadLocalRandom.current();

      for (int var13 = 0; var13 < var3; var13++) {
         class_243 var14 = new class_243(
            var2.field_1323 + var12.nextDouble() * var6, var2.field_1322 + var12.nextDouble() * var8, var2.field_1321 + var12.nextDouble() * var10
         );
         class_3959 var15 = new class_3959(var1, var14, class_3960.field_17558, class_242.field_1348, var4);
         class_239 var16 = var0.method_17742(var15);
         if (var16.method_17783() == class_240.field_1333) {
            var5++;
         }
      }

      return (double)var5 / var3;
   }

   public static double method0272(class_1937 var0, class_243 var1, class_238 var2, int var3, class_1297 var4) {
      double var5 = method1324(var1, var2);
      double var7 = method0614(var5, 12.0);
      if (var7 <= 0.0) {
         return 0.0;
      }

      double var9 = method1251(var0, var1, var2, var3, var4);
      return var7 * var9;
   }

   public static class_238 method1292(class_238 var0, class_243 var1) {
      return var0.method_989(var1.field_1352, var1.field_1351, var1.field_1350);
   }

   public static class_238 method0286(class_238 var0, class_243 var1) {
      class_243 var2 = var0.method_1005();
      return var0.method_989(var1.field_1352 - var2.field_1352, var1.field_1351 - var2.field_1351, var1.field_1350 - var2.field_1350);
   }

   private static double method0617(double var0, double var2, double var4) {
      return Math.max(var2, Math.min(var4, var0));
   }
}
