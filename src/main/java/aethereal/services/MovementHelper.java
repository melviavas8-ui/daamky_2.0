package aethereal;

import lombok.Generated;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public final class MovementHelper implements MinecraftAccess {
   public static boolean method0579() {
      class_238 var0 = new class_238(
         field0796.field_1724.method_23317() - 0.3000000243657645,
         field0796.field_1724.method_23318() + field0796.field_1724.method_18381(field0796.field_1724.method_18376()),
         field0796.field_1724.method_23321() + 0.3000000243657645,
         field0796.field_1724.method_23317() + 0.3000000243657645,
         field0796.field_1724.method_23318() + (!field0796.field_1724.method_24828() ? 1.5 : 2.5),
         field0796.field_1724.method_23321() - 0.3000000243657645
      );
      return !field0796.field_1687.method_8587(field0796.field_1724, var0);
   }

   public static boolean method0620(double var0, double var2, double var4) {
      class_238 var6 = new class_238(
         field0796.field_1724.method_23317() - var0,
         field0796.field_1724.method_23318() + field0796.field_1724.method_18381(field0796.field_1724.method_18376()),
         field0796.field_1724.method_23321() + var4,
         field0796.field_1724.method_23317() + var0,
         field0796.field_1724.method_23318() + field0796.field_1724.method_18381(field0796.field_1724.method_18376()) + var2,
         field0796.field_1724.method_23321() - var4
      );
      return !field0796.field_1687.method_8587(field0796.field_1724, var6);
   }

   public static boolean method0666(float var0) {
      if (field0796.field_1724.method_23318() < 0.0) {
         return false;
      }

      class_238 var1 = field0796.field_1724.method_5829().method_989(0.0, -var0, 0.0);
      return !field0796.field_1687.method_8587(field0796.field_1724, var1);
   }

   public static void method0611(double var0) {
      if (method1635()) {
         double var2 = method1945();
         field0796.field_1724
            .method_18799(
               new class_243(
                  -class_3532.method_15374((float)var2) * var0, field0796.field_1724.method_18798().field_1351, class_3532.method_15362((float)var2) * var0
               )
            );
      }
   }

   public static void method0632(double var0, float var2) {
      if (method1635()) {
         var2 = (float)Math.toRadians(var2);
         field0796.field_1724
            .method_18799(
               new class_243(-class_3532.method_15374(var2) * var0, field0796.field_1724.method_18798().field_1351, class_3532.method_15362(var2) * var0)
            );
      }
   }

   public static void method0025() {
      field0796.field_1724.method_18799(field0796.field_1724.method_18798().method_18805(0.0, 1.0, 0.0));
   }

   public static void method2078() {
      method0611(method0354());
   }

   public static boolean method1813() {
      return !field0796.field_1687
            .method_8587(
               field0796.field_1724,
               field0796.field_1724
                  .method_5829()
                  .method_989(-4.999996982825781E-4, -0.5, -4.999996982825781E-4)
                  .method_1012(9.999993966401952E-4, 0.0, 9.999993966401952E-4)
            )
         && field0796.field_1724.method_24828();
   }

   public static boolean method1635() {
      return field0796.field_1724 != null && (field0796.field_1724.field_3913.field_3905 != 0.0F || field0796.field_1724.field_3913.field_3907 != 0.0F);
   }

   public static void method0886(KeyboardEvent var0, float var1) {
      float var2 = var0.method1762();
      float var3 = var0.method1603();
      if (var2 != 0.0F || var3 != 0.0F) {
         double var4 = class_3532.method_15338(
            Math.toDegrees(method0680(field0796.field_1724.method_6128() ? var1 : field0796.field_1724.method_36454(), var2, var3))
         );
         method0887(var0, var1, var4);
      }
   }

   public static void method0887(KeyboardEvent var0, float var1, double var2) {
      if (var0.method1762() != 0.0F || var0.method1603() != 0.0F) {
         float var4 = 0.0F;
         float var5 = 0.0F;
         double var6 = 1.7976922776554316E308;

         for (float var8 = -1.0F; var8 <= 1.0F; var8++) {
            for (float var9 = -1.0F; var9 <= 1.0F; var9++) {
               if (var8 != 0.0F || var9 != 0.0F) {
                  double var10 = class_3532.method_15338(Math.toDegrees(method0680(var1, var8, var9)));
                  double var12 = Math.abs(class_3532.method_15338(var2 - var10));
                  if (var12 < var6) {
                     var6 = var12;
                     var4 = var8;
                     var5 = var9;
                  }
               }
            }
         }

         var0.method0665(var4);
         var0.method0124(var5);
      }
   }

   public static double method1125(class_1297 var0) {
      double var1 = var0.method_23317() - field0796.field_1724.method_23317();
      double var3 = var0.method_23321() - field0796.field_1724.method_23321();
      return class_3532.method_15338(Math.toDegrees(Math.atan2(var3, var1)) - 90.0);
   }

   public static double method1945() {
      float var0 = field0796.field_1724.method_36454();
      if (field0796.field_1724.field_3913.field_3905 < 0.0F) {
         var0 += 180.0F;
      }

      float var1 = 1.0F;
      if (field0796.field_1724.field_3913.field_3905 < 0.0F) {
         var1 = -0.5F;
      } else if (field0796.field_1724.field_3913.field_3905 > 0.0F) {
         var1 = 0.5F;
      }

      if (field0796.field_1724.field_3913.field_3907 > 0.0F) {
         var0 -= 90.0F * var1;
      }

      if (field0796.field_1724.field_3913.field_3907 < 0.0F) {
         var0 += 90.0F * var1;
      }

      return Math.toRadians(var0);
   }

   public static double method0412() {
      float var0 = field0796.field_1724.method_36454();
      if (field0796.field_1724.field_3913.field_3905 < 0.0F && field0796.field_1724.field_3913.field_3905 == 0.0F) {
         var0 += 180.0F;
      }

      if (field0796.field_1724.field_3913.field_3907 > 0.0F) {
         var0 -= 90.0F;
      }

      if (field0796.field_1724.field_3913.field_3907 < 0.0F) {
         var0 += 90.0F;
      }

      return Math.toRadians(var0);
   }

   public static double method0680(float var0, float var1, float var2) {
      if (var1 < 0.0F) {
         var0 += 180.0F;
      }

      float var3 = 1.0F;
      if (var1 < 0.0F) {
         var3 = -0.5F;
      }

      if (var1 > 0.0F) {
         var3 = 0.5F;
      }

      if (var2 > 0.0F) {
         var0 -= 90.0F * var3;
      }

      if (var2 < 0.0F) {
         var0 += 90.0F * var3;
      }

      return Math.toRadians(var0);
   }

   public static void method0633(double var0, float var2, double var3, double var5) {
      if (var5 != 0.0) {
         if (var3 > 0.0) {
            var2 += var5 > 0.0 ? -45 : 45;
         } else if (var3 < 0.0) {
            var2 += var5 > 0.0 ? 45 : -45;
         }

         var3 = 0.0;
         if (var5 > 0.0) {
            var5 = 1.0;
         } else if (var5 < 0.0) {
            var5 = -1.0;
         }
      }

      if (var3 > 0.0) {
         var3 = 1.0;
      } else if (var3 < 0.0) {
         var3 = -1.0;
      }

      double var7 = Math.cos(Math.toRadians(var2 + 90.0F));
      double var9 = Math.sin(Math.toRadians(var2 + 90.0F));
      field0796.field_1724
         .method_18799(
            new class_243(var5 * var0 * var7 + var3 * var0 * var9, field0796.field_1724.method_18798().field_1351, var5 * var0 * var9 - var3 * var0 * var7)
         );
   }

   public static void method0103(double var0) {
      double var2 = field0796.field_1724.field_3913.field_3905;
      double var4 = field0796.field_1724.field_3913.field_3907;
      float var6 = field0796.field_1724.method_36454();
      if (var2 == 0.0 && var4 == 0.0) {
         field0796.field_1724.method_18799(new class_243(0.0, field0796.field_1724.method_18798().field_1351, 0.0));
      } else {
         if (var2 != 0.0) {
            if (var4 > 0.0) {
               var6 += var2 > 0.0 ? -45 : 45;
            } else if (var4 < 0.0) {
               var6 += var2 > 0.0 ? 45 : -45;
            }

            var4 = 0.0;
            if (var2 > 0.0) {
               var2 = 1.0;
            } else if (var2 < 0.0) {
               var2 = -1.0;
            }
         }

         double var7 = class_3532.method_15374((float)Math.toRadians(var6 + 90.0F));
         double var9 = class_3532.method_15362((float)Math.toRadians(var6 + 90.0F));
         field0796.field_1724
            .method_18799(
               new class_243(var2 * var0 * var9 + var4 * var0 * var7, field0796.field_1724.method_18798().field_1351, var2 * var0 * var7 - var4 * var0 * var9)
            );
      }
   }

   public static void method0113(double var0, float var2) {
      method0633(var0, var2, field0796.field_1724.field_3913.field_3907, field0796.field_1724.field_3913.field_3905);
   }

   public static double method0354() {
      return Math.hypot(field0796.field_1724.method_18798().field_1352, field0796.field_1724.method_18798().field_1350);
   }

   public static double method0482() {
      return Math.sqrt(
         field0796.field_1724.method_18798().field_1352 * field0796.field_1724.method_18798().field_1352
            + field0796.field_1724.method_18798().field_1350 * field0796.field_1724.method_18798().field_1350
      );
   }

   public static double method0233(class_1297 var0) {
      double var1 = var0.method_23317() - var0.field_6014;
      double var3 = var0.method_23321() - var0.field_5969;
      return Math.sqrt(var1 * var1 + var3 * var3) * 15.0;
   }

   public static double method2212() {
      return Math.hypot(field0796.field_1724.method_18798().field_1352, field0796.field_1724.method_18798().field_1350);
   }

   public static double[] method2087(double var0) {
      float var2 = field0796.field_1724.field_3913.field_3905;
      float var3 = field0796.field_1724.field_3913.field_3907;
      return method0636(var0, var2, var3);
   }

   public static double[] method0636(double var0, float var2, float var3) {
      float var4 = field0796.field_1724.method_36454();
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

   @Generated
   private MovementHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
