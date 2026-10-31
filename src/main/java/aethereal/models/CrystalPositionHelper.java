package aethereal;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import net.minecraft.class_1294;
import net.minecraft.class_1303;
import net.minecraft.class_1511;
import net.minecraft.class_1542;
import net.minecraft.class_1799;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3486;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_5134;
import net.minecraft.class_7924;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;

public final class CrystalPositionHelper {
   private static final int field0567 = 12;
   private static final class_2382[] field0174;
   private static final int[] field1529 = new int[13];

   private static class_310 method0572() {
      return class_310.method_1551();
   }

   private CrystalPositionHelper() {
   }

   public static int method0609(double var0) {
      return field1529[class_3532.method_15340((int)Math.ceil(var0), 0, field1529.length - 1)];
   }

   public static class_2382 method0726(int var0) {
      return field0174[var0];
   }

   public static class_243 method1273(class_2338 var0, class_2350 var1) {
      return var0.method_46558().method_1031(var1.method_10148() / 2.0, var1.method_10164() / 2.0, var1.method_10165() / 2.0);
   }

   public static class_2350 method1279(class_2338 var0, boolean var1) {
      class_310 var2 = method0572();
      if (var1) {
         if (var2.field_1724 != null && var2.field_1687 != null) {
            if (var2.field_1724.method_23318() >= var0.method_10264()) {
               return class_2350.field_11036;
            }

            class_3965 var3 = var2.field_1687
               .method_17742(
                  new class_3959(var2.field_1724.method_33571(), class_243.method_24953(var0), class_3960.field_17559, class_242.field_1348, var2.field_1724)
               );
            return var3 != null && var3.method_17783() == class_240.field_1332 && var3.method_17780() != null ? var3.method_17780() : method1862(var0);
         } else {
            return method1862(var0);
         }
      } else {
         return method1862(var0);
      }
   }

   private static class_2350 method1862(class_2338 var0) {
      class_310 var1 = method0572();
      if (var1.field_1724 == null) {
         return class_2350.field_11036;
      }

      class_2350 var2 = null;
      class_243 var3 = null;

      for (class_2350 var7 : class_2350.values()) {
         class_243 var8 = method1273(var0, var7);
         if (var2 == null || var1.field_1724.method_5707(var8) < var1.field_1724.method_5707(var3)) {
            var2 = var7;
            var3 = var8;
         }
      }

      return var2;
   }

   public static boolean method1596(class_2338... var0) {
      class_310 var1 = method0572();
      return var1.field_1687 == null ? false : Arrays.stream(var0).allMatch(var1x -> var1.field_1687.method_8320(var1x).method_26204().method_36555() != -1.0F);
   }

   public static boolean method0352(class_2338... var0) {
      class_310 var1 = method0572();
      return var1.field_1687 == null ? false : Arrays.stream(var0).allMatch(var1x -> var1.field_1687.method_8320(var1x).method_45474());
   }

   public static class_2248 method1261(class_2338 var0) {
      class_310 var1 = method0572();
      return var1.field_1687 == null ? null : var1.field_1687.method_8320(var0).method_26204();
   }

   public static boolean method0279(class_2338 var0) {
      return method0281(var0, false);
   }

   public static boolean method0281(class_2338 var0, boolean var1) {
      class_310 var2 = method0572();
      if (var2.field_1687 == null || var2.field_1724 == null) {
         return false;
      } else {
         return !var2.field_1687.method_8320(var0).method_45474()
            ? false
            : var2.field_1687
               .method_8335(null, new class_238(var0))
               .stream()
               .noneMatch(
                  var2x -> !(var2x instanceof class_1511)
                     && !(var2x instanceof class_1303)
                     && !(var2x instanceof class_1542)
                     && (!var2x.equals(var2.field_1724) || !var1)
               );
      }
   }

   public static boolean method2159(class_2338 var0) {
      class_310 var1 = method0572();
      if (var1.field_1687 == null) {
         return false;
      } else {
         return !var1.field_1687.method_8320(var0).method_45474()
            ? false
            : var1.field_1687
               .method_8335(null, new class_238(var0))
               .stream()
               .noneMatch(var0x -> !(var0x instanceof class_1511) && !(var0x instanceof class_1303));
      }
   }

   public static float method1364(class_2680 var0, int var1) {
      class_310 var2 = method0572();
      if (var2.field_1724 != null && var2.field_1687 != null) {
         float var3 = ((class_1799)var2.field_1724.method_31548().field_7547.get(var1)).method_7924(var0);
         if (var3 > 1.0F) {
            class_1799 var4 = var2.field_1724.method_31548().method_5438(var1);
            int var5 = class_1890.method_8225(var2.field_1687.method_30349().method_30530(class_7924.field_41265).method_46747(class_1893.field_9131), var4);
            if (var5 > 0 && !var4.method_7960()) {
               var3 += (float)(StrictMath.pow(var5, 2.0) + 1.0);
            }
         }

         if (var2.field_1724.method_6059(class_1294.field_5917)) {
            var3 *= 1.0F + (var2.field_1724.method_6112(class_1294.field_5917).method_5578() + 1) * 0.2F;
         }

         if (var2.field_1724.method_6059(class_1294.field_5901)) {
            var3 *= (float)Math.pow(0.30000013F, var2.field_1724.method_6112(class_1294.field_5901).method_5578() + 1);
         }

         if (var2.field_1724.method_5777(class_3486.field_15517)) {
            var3 *= (float)var2.field_1724.method_5996(class_5134.field_51576).method_6194();
         }

         if (!var2.field_1724.method_24828()) {
            var3 /= 5.0F;
         }

         var3 = var3 < 0.0F ? 0.0F : var3;
         float var7 = var0.method_26204().method_36555();
         return var7 <= 0.0F
            ? 0.0F
            : var3 / var7 / (var0.method_29291() && !((class_1799)var2.field_1724.method_31548().field_7547.get(var1)).method_7951(var0) ? 100 : 30);
      } else {
         return 0.0F;
      }
   }

   static {
      class_2338 var0 = class_2338.field_10980;
      Set var1 = new TreeSet<>(
         (var1x, var2x) -> {
            if (var1x.equals(var2x)) {
               return 0;
            }

            int var3 = Double.compare(var0.method_10262(var1x), var0.method_10262(var2x));
            if (var3 == 0) {
               var3 = Integer.compare(
                  Math.abs(var1x.method_10263()) + Math.abs(var1x.method_10264()) + Math.abs(var1x.method_10260()),
                  Math.abs(var2x.method_10263()) + Math.abs(var2x.method_10264()) + Math.abs(var2x.method_10260())
               );
            }

            return var3 == 0 ? 1 : var3;
         }
      );

      for (int var2 = -12; var2 <= 12; var2++) {
         for (int var3 = -12; var3 <= 12; var3++) {
            for (int var4 = -12; var4 < 12; var4++) {
               double var5 = (double)var2 * var2 + (double)var4 * var4 + (double)var3 * var3;
               if (var5 < class_3532.method_34954(12)) {
                  var1.add(new class_2338(var2, var4, var3));
               }
            }
         }
      }

      field0174 = new class_2382[var1.size()];
      int var7 = 0;
      int var8 = 0;

      for (class_2338 var10 : var1) {
         while (Math.sqrt(var0.method_10262(var10)) > var8 && var8 < field1529.length) {
            field1529[var8++] = var7;
         }

         field0174[var7++] = var10;
      }

      while (var8 < field1529.length) {
         field1529[var8++] = var7;
      }
   }
}
