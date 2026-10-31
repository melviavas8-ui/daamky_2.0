package aethereal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_640;

public final class ProjectionHelper implements MinecraftAccess {
   public static class_243 method1188(class_1657 var0, float var1) {
      double var2 = class_3532.method_16436(var1, var0.field_6014, var0.method_23317());
      double var4 = class_3532.method_16436(var1, var0.field_6036, var0.method_23318());
      double var6 = class_3532.method_16436(var1, var0.field_5969, var0.method_23321());
      return new class_243(var2, var4 + var0.method_17682() + 0.3000001454031455, var6);
   }

   public static class_243 method1299(class_243 var0) {
      return WorldProjectionHelper.method1299(var0);
   }

   public static float method1309(class_243 var0, float var1) {
      return (float)WorldProjectionHelper.method1303(var0, var1);
   }

   public static boolean method0289(class_243 var0) {
      return var0.field_1350 > 0.0 && var0.field_1350 < 1.0;
   }

   public static float method1178(class_1657 var0) {
      float var1 = PlayerStatusHelper.method1178(var0);
      return var1 >= 0.0F ? var1 : var0.method_6032();
   }

   public static float method0248(class_1657 var0) {
      return var0.method_6063();
   }

   public static float method2149(class_1657 var0) {
      return method1178(var0) / method0248(var0);
   }

   public static float method1854(class_1657 var0) {
      return var0.method_6067();
   }

   public static int method1663(class_1657 var0) {
      if (field0796.method_1562() == null) {
         return 0;
      }

      class_640 var1 = field0796.method_1562().method_2871(var0.method_5667());
      return var1 != null ? var1.method_2959() : 0;
   }

   public static Color method0723(int var0) {
      if (var0 < 50) {
         return new Color(100, 255, 100);
      } else if (var0 < 100) {
         return new Color(200, 255, 100);
      } else if (var0 < 150) {
         return new Color(255, 255, 100);
      } else {
         return var0 < 200 ? new Color(255, 200, 100) : new Color(255, 100, 100);
      }
   }

   public static Color method0662(float var0) {
      if (var0 > 0.75F) {
         return new Color(100, 255, 100);
      } else if (var0 > 0.5F) {
         return new Color(255, 255, 100);
      } else {
         return var0 > 0.25F ? new Color(255, 150, 50) : new Color(255, 80, 80);
      }
   }

   public static List<class_1799> method1990(class_1657 var0) {
      List var1 = new ArrayList<>();

      for (class_1799 var3 : var0.method_5661()) {
         var1.add(0, var3);
      }

      return var1;
   }

   public static class_1799 method0445(class_1657 var0) {
      return var0.method_6047();
   }

   public static class_1799 method0389(class_1657 var0) {
      return var0.method_6079();
   }

   public static float method0832(FontSize var0, String var1, int var2, float var3, float var4, boolean var5, boolean var6) {
      float var7 = var0.method0998(var1);
      if (var6) {
         String var8 = String.format(" %.1f", var3);
         var7 += var0.method0998(var8);
      }

      if (var5) {
         String var9 = " " + var2 + "ms";
         var7 += var0.method0998(var9);
      }

      return var7;
   }

   public static float method0751(int var0, int var1, List<class_1799> var2, class_1799 var3, class_1799 var4) {
      int var5 = 0;

      for (class_1799 var7 : var2) {
         if (!var7.method_7960()) {
            var5++;
         }
      }

      if (!var3.method_7960()) {
         var5++;
      }

      if (!var4.method_7960()) {
         var5++;
      }

      return var5 == 0 ? 0.0F : var5 * var0 + (var5 - 1) * var1;
   }

   public static String method0673(float var0, float var1) {
      return String.valueOf((int)(var0 + var1));
   }

   public static boolean method0508(class_1657 var0) {
      if (var0 == field0796.field_1724) {
         return false;
      } else {
         return var0.method_29504() ? false : !var0.method_5767();
      }
   }

   public static boolean method1185(class_1657 var0, double var1) {
      return field0796.field_1724 == null ? false : field0796.field_1724.method_5739(var0) <= var1;
   }

   @Generated
   private ProjectionHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
