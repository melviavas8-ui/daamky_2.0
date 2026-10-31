package aethereal;

import lombok.Generated;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;

public final class CameraMath implements MinecraftAccess {
   public static double method0622(double var0, double var2, double var4, double var6) {
      if (var4 <= 0.0) {
         return var2;
      }

      double var8 = 2.0 / var4;
      double var10 = var8 * var6;
      double var12 = 1.0 / (1.0 + var10 + 0.4799998223142956 * var10 * var10 + 0.23499991059442615 * var10 * var10 * var10);
      double var14 = var0 - var2;
      double var16 = (var14 + var8 * var14 * var6) * var12;
      return var2 + var16;
   }

   public static double method0608(double var0) {
      return var0 < 0.5 ? 4.0 * var0 * var0 * var0 : 1.0 - Math.pow(-2.0 * var0 + 2.0, 3.0) / 2.0;
   }

   public static double method0102(double var0) {
      return 1.0 - Math.pow(1.0 - var0, 4.0);
   }

   public static double method2085(double var0) {
      return -(Math.cos(3.141593610808183 * var0) - 1.0) / 2.0;
   }

   public static double method1815(double var0) {
      return var0 == 1.0 ? 1.0 : 1.0 - Math.pow(2.0, -10.0 * var0);
   }

   public static double method0614(double var0, double var2) {
      double var4 = 6.283187266698228;
      return 1.0 - Math.exp(-var2 * var0) * Math.cos(var4 * var0 * (1.0 - var2 * 0.1000000000116534));
   }

   public static double method0617(double var0, double var2, double var4) {
      return var0 + (var2 - var0) * var4;
   }

   public static float method0681(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * var2;
   }

   public static double method0109(double var0, double var2, double var4, double var6) {
      double var8 = 1.0 - Math.pow(1.0 - var4, var6 * 60.0);
      return method0617(var0, var2, var8);
   }

   public static float method0685(float var0, float var1, float var2, float var3) {
      float var4 = (float)(1.0 - Math.pow(1.0 - var2, var3 * 60.0));
      return method0681(var0, var1, var4);
   }

   public static double method2090(double var0, double var2, double var4, double var6) {
      return var4 <= 0.0 ? var2 : var2 + (var0 - var2) * Math.exp(-0.6931471266636435 / var4 * var6);
   }

   public static double method0107(double var0, double var2, double var4) {
      double var6 = var2 - var0;
      return Math.abs(var6) <= var4 ? var2 : var0 + Math.signum(var6) * var4;
   }

   public static float method0129(float var0, float var1, float var2) {
      float var3 = class_3532.method_15393(var1 - var0);
      return var0 + var3 * var2;
   }

   public static float method0132(float var0, float var1, float var2, float var3) {
      float var4 = (float)(1.0 - Math.pow(1.0 - var2, var3 * 60.0));
      return method0129(var0, var1, var4);
   }

   public static double method1177(class_1657 var0) {
      class_243 var1 = var0.method_18798();
      return Math.sqrt(var1.field_1352 * var1.field_1352 + var1.field_1350 * var1.field_1350);
   }

   public static double method0247(class_1657 var0) {
      return var0.method_18798().field_1351;
   }

   public static boolean method2151(class_1657 var0) {
      return method1177(var0) > 0.01000000395813517;
   }

   public static boolean method1855(class_1657 var0) {
      return var0.method_5624() && method1177(var0) > 0.1000000000116534;
   }

   public static boolean method1664(class_1657 var0) {
      return !var0.method_24828() && var0.method_18798().field_1351 < -0.10000000304602849;
   }

   public static boolean method1991(class_1657 var0) {
      return !var0.method_24828() && var0.method_18798().field_1351 > 0.1000000000116534;
   }

   public static class_3965 method1184(class_1657 var0, double var1) {
      class_243 var3 = var0.method_33571();
      class_243 var4 = var0.method_5828(1.0F);
      class_243 var5 = var3.method_1019(var4.method_1021(var1));
      return field0796.field_1687.method_17742(new class_3959(var3, var5, class_3960.field_17559, class_242.field_1348, var0));
   }

   public static boolean method0579() {
      return field0796.field_1761 != null && field0796.field_1761.method_2923();
   }

   public static class_2338 method0022() {
      return field0796.field_1765 != null && field0796.field_1765.method_17783() == class_240.field_1332
         ? ((class_3965)field0796.field_1765).method_17777()
         : null;
   }

   public static class_2350 method2076() {
      return field0796.field_1765 != null && field0796.field_1765.method_17783() == class_240.field_1332
         ? ((class_3965)field0796.field_1765).method_17780()
         : null;
   }

   public static boolean method0251(class_1657 var0, double var1) {
      class_2338 var3 = var0.method_24515();

      for (int var4 = -1; var4 <= 1; var4++) {
         for (int var5 = -1; var5 <= 1; var5++) {
            class_2338 var6 = var3.method_10069(var4, 1, var5);
            class_2680 var7 = field0796.field_1687.method_8320(var6);
            if (!var7.method_26215() && var7.method_26234(field0796.field_1687, var6)) {
               return true;
            }
         }
      }

      return false;
   }

   public static float method1189(class_1657 var0, float var1, double var2) {
      float[] var4 = new float[]{0.0F, 45.0F, -45.0F, 90.0F, -90.0F, 135.0F, -135.0F, 180.0F};

      for (float var8 : var4) {
         float var9 = var1 + var8;
         if (method0252(var0, var9, var2)) {
            return var9;
         }
      }

      return var1;
   }

   public static boolean method0252(class_1657 var0, float var1, double var2) {
      class_243 var4 = var0.method_33571();
      double var5 = Math.toRadians(var1);
      class_243 var7 = var4.method_1031(-Math.sin(var5) * var2, 0.0, Math.cos(var5) * var2);
      class_3965 var8 = field0796.field_1687.method_17742(new class_3959(var4, var7, class_3960.field_17558, class_242.field_1348, var0));
      return var8.method_17783() == class_240.field_1333 || var8.method_17784().method_1022(var4) > var2 * 0.8999998333405653;
   }

   public static class_243 method1315(class_243 var0, float var1, float var2, double var3) {
      double var5 = Math.toRadians(var1);
      double var7 = Math.toRadians(var2);
      double var9 = -Math.sin(var5) * Math.cos(var7) * var3;
      double var11 = -Math.sin(var7) * var3;
      double var13 = Math.cos(var5) * Math.cos(var7) * var3;
      return var0.method_1031(var9, var11, var13);
   }

   public static float method1197(class_1657 var0, class_2338 var1) {
      if (var1 == null) {
         return var0.method_36454();
      }

      class_243 var2 = var0.method_19538();
      class_243 var3 = class_243.method_24953(var1);
      double var4 = var3.field_1352 - var2.field_1352;
      double var6 = var3.field_1350 - var2.field_1350;
      float var8 = (float)Math.toDegrees(Math.atan2(-var4, var6));
      return var8 + 90.0F;
   }

   public static double method0106(double var0, double var2) {
      return Math.abs(var0) < var2 ? 0.0 : var0;
   }

   public static double method1816(double var0, double var2, double var4, double var6) {
      if (var0 < var2) {
         return var2 - var6 * (1.0 - Math.exp(-(var2 - var0) / var6));
      } else {
         return var0 > var4 ? var4 + var6 * (1.0 - Math.exp(-(var0 - var4) / var6)) : var0;
      }
   }

   public static double method2089(double var0, double var2, double var4) {
      return class_3532.method_15350((var0 - var2) / (var4 - var2), 0.0, 1.0);
   }

   public static double method0624(double var0, double var2, double var4, double var6, double var8) {
      double var10 = method2089(var0, var2, var4);
      return method0617(var6, var8, var10);
   }

   @Generated
   private CameraMath() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
