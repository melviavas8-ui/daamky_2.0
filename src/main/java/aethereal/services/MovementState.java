package aethereal;

import java.util.Objects;
import lombok.Generated;
import net.minecraft.class_10185;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public final class MovementState implements MinecraftAccess {
   public static boolean method0579() {
      return field0796.field_1724.field_3913.field_3905 != 0.0F || field0796.field_1724.field_3913.field_3907 != 0.0F;
   }

   public static double[] method0613(double var0) {
      return method0678(field0796.field_1724.field_3913.field_3905, field0796.field_1724.field_3913.field_3907, var0);
   }

   public static final boolean method0730(int var0) {
      boolean var1 = field0796.field_1690.field_1894.method_1434();
      boolean var2 = field0796.field_1690.field_1913.method_1434();
      boolean var3 = field0796.field_1690.field_1881.method_1434();
      boolean var4 = field0796.field_1690.field_1849.method_1434();
      return var0 == 0 ? var1 : (var0 == 1 ? var2 : (var0 == 2 ? var3 : var0 == 3 && var4));
   }

   public static final boolean method0026() {
      return method0730(0);
   }

   public static final boolean method2079() {
      return method0730(1);
   }

   public static final boolean method1813() {
      return method0730(2);
   }

   public static final boolean method1635() {
      return method0730(3);
   }

   public static final float method0645(float var0) {
      return var0
         + (
            !method2079() || !method1635() || method0026() && method1813() || !method0026() && !method1813()
               ? (
                  !method0026() || !method1813() || method2079() && method1635() || !method2079() && !method1635()
                     ? (
                        (!method2079() || !method1635() || method0026() && method1813()) && (!method0026() || !method1813() || method2079() && method1635())
                           ? (
                              !method2079() && !method1635() && !method1813()
                                 ? 0
                                 : (
                                       method0026() && !method1813()
                                          ? 45
                                          : (
                                             !method1813() || method0026()
                                                ? (!method0026() && !method1813() || method0026() && method1813() ? 90 : 0)
                                                : (!method2079() && !method1635() ? 180 : 135)
                                          )
                                    )
                                    * (method2079() ? -1 : 1)
                           )
                           : 0
                     )
                     : (method2079() ? -90 : (method1635() ? 90 : 0))
               )
               : (method0026() ? 0 : (method1813() ? 180 : 0))
         );
   }

   public static double[] method0105(double var0) {
      float var2 = field0796.field_1724.field_3913.field_3905;
      float var3 = field0796.field_1724.field_3913.field_3907;
      float var4 = RotationManager.field0618.method0545().method2047();
      if (var2 != 0.0F) {
         if (var3 > 0.0F) {
            var4 += var2 > 0.0F ? -45 : 45;
         } else if (var3 < 0.0F) {
            var4 += var2 > 0.0F ? 45 : -45;
         }

         var3 = 0.0F;
         if (var2 > 0.0F) {
            var2 = 1.0F;
         } else if (var2 < 0.0F) {
            var2 = -1.0F;
         }
      }

      double var5 = Math.sin(Math.toRadians(var4 + 90.0F));
      double var7 = Math.cos(Math.toRadians(var4 + 90.0F));
      double var9 = var2 * var0 * var7 + var3 * var0 * var5;
      double var11 = var2 * var0 * var5 - var3 * var0 * var7;
      return new double[]{var9, var11};
   }

   public static float method0679(float var0, float var1, double var2, double var4, double var6, double var8, float var10) {
      if (Aura.field0169 && Aura.method1701().method0409() != null) {
         var0 = RotationManager.field0618.method1910().method2047();
      } else {
         var0 = RotationManager.field0618.method0545().method2047();
      }

      double var11 = var6 - var2;
      double var13 = var8 - var4;
      float var15 = (float)(var11 * var11 + var13 * var13);
      float var16 = var1;
      float var17 = field0796.field_1724.field_6251;
      if (var15 > 0.0025000002F) {
         float var18 = (float)class_3532.method_15349(var13, var11) * (180.0F / (float)Math.PI) - 90.0F;
         float var19 = class_3532.method_15379(class_3532.method_15393(var0) - var18);
         if (95.0F < var19 && var19 < 265.0F) {
            var16 = var18 - 180.0F;
         } else {
            var16 = var18;
         }
      }

      if (field0796.field_1724 != null && field0796.field_1724.field_6251 - 0.2F > 0.0F) {
         var16 = var0;
      }

      float var23 = class_3532.method_15393(var16 - var1);
      var16 = var1 + var23 * 0.3F;
      float var24 = class_3532.method_15393(var0 - var16);
      float var20 = 52.0F;
      if (Math.abs(var24) > var20) {
         var16 += var24 - class_3532.method_17822(var24) * var20;
      }

      return var16;
   }

   public static double method1945() {
      return 1488.0;
   }

   public static double[] method0678(float var0, float var1, double var2) {
      float var4 = RotationManager.field0618.method0545().method2047();
      if (var0 != 0.0F) {
         if (var1 > 0.0F) {
            var4 += var0 > 0.0F ? -45.0F : 45.0F;
         } else if (var1 < 0.0F) {
            var4 += var0 > 0.0F ? 45.0F : -45.0F;
         }

         var1 = 0.0F;
         var0 = var0 > 0.0F ? 1.0F : -1.0F;
      }

      double var5 = Math.sin(Math.toRadians(var4 + 90.0F));
      double var7 = Math.cos(Math.toRadians(var4 + 90.0F));
      double var9 = var0 * var2 * var7 + var1 * var2 * var5;
      double var11 = var0 * var2 * var5 - var1 * var2 * var7;
      return new double[]{var9, var11};
   }

   public static double method1125(class_1297 var0) {
      return Math.sqrt(var0.method_5707(new class_243(var0.field_6014, var0.field_6036, var0.field_5969)));
   }

   public static void method2086(double var0) {
      double[] var2 = method0613(var0);
      Objects.requireNonNull(field0796.field_1724).method_18800(var2[0], field0796.field_1724.method_18798().method_10214(), var2[1]);
   }

   public static void method0615(double var0, double var2) {
      double[] var4 = method0613(var0);
      Objects.requireNonNull(field0796.field_1724).method_18800(var4[0], var2, var4[1]);
   }

   public static double method1308(class_243 var0, float var1) {
      float var2 = (float)Math.atan2(-var0.field_1352, var0.field_1350);
      double var3 = Math.toRadians(class_3532.method_15393(var1));
      return Math.toDegrees(class_3532.method_15338(var2 - var3));
   }

   public static class_10185 method1116(class_10185 var0, double var1, float var3) {
      boolean var4 = var0.comp_3159();
      boolean var5 = var0.comp_3160();
      boolean var6 = var0.comp_3161();
      boolean var7 = var0.comp_3162();
      if (var1 >= -90.0F + var3 && var1 <= 90.0F - var3) {
         var4 = true;
      } else if (var1 < -90.0F - var3 || var1 > 90.0F + var3) {
         var5 = true;
      }

      if (var1 >= 0.0F + var3 && var1 <= 180.0F - var3) {
         var7 = true;
      } else if (var1 >= -180.0F + var3 && var1 <= 0.0F - var3) {
         var6 = true;
      }

      return new class_10185(var4, var5, var6, var7, var0.comp_3163(), var0.comp_3164(), var0.comp_3165());
   }

   public static class_10185 method1115(class_10185 var0, double var1) {
      return method1116(var0, var1, 20.0F);
   }

   @Generated
   private MovementState() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
