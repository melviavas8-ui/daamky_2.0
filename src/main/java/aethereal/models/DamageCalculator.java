package aethereal;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.class_1267;
import net.minecraft.class_1280;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1511;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import net.minecraft.class_1922;
import net.minecraft.class_1934;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_5134;
import net.minecraft.class_640;
import net.minecraft.class_6880;
import net.minecraft.class_745;
import net.minecraft.class_9304;
import net.minecraft.class_239.class_240;

public final class DamageCalculator {
   private static final Map<String, Integer> field0720 = new HashMap<String, Integer>() {
      {
         this.put("protection", 1);
         this.put("blast_protection", 2);
         this.put("projectile_protection", 1);
         this.put("feather_falling", 1);
         this.put("fire_protection", 1);
      }
   };

   private DamageCalculator() {
   }

   private static class_310 method0572() {
      return class_310.method_1551();
   }

   public static float method1142(class_1297 var0, class_238 var1, class_1511 var2, boolean var3) {
      return method1144(var0, var1, class_243.method_26410(var2.method_24515(), 0.0), 6.0F, null, var3);
   }

   public static float method1143(class_1297 var0, class_238 var1, class_2338 var2, class_2338 var3, boolean var4) {
      return method1144(var0, var1, class_243.method_26410(var2, 1.0), 6.0F, var3, var4);
   }

   public static float method1144(class_1297 var0, class_238 var1, class_243 var2, float var3, class_2338 var4, boolean var5) {
      class_310 var6 = method0572();
      if (var6.field_1687 != null && var0 != null) {
         if (var6.field_1687.method_8407() == class_1267.field_5801) {
            return 0.0F;
         } else if (!(var0 instanceof class_745) && var0 instanceof class_1657 var7 && method1181(var7) == class_1934.field_9220) {
            return 0.0F;
         } else {
            float var14 = var3 * 2.0F;
            double var8 = Math.sqrt(var1 != null ? var1.method_1005().method_1031(0.0, -0.9000000158408586, 0.0).method_1025(var2) : var0.method_5707(var2))
               / var14;
            if (var8 > 1.0) {
               return 0.0F;
            }

            double var10 = (1.0 - var8) * method1326(var2, var0.method_5829(), var4, var5);
            float var12 = (int)((var10 * var10 + var10) / 2.0 * 7.0 * var14 + 1.0);
            if (var12 <= 0.0F) {
               return 0.0F;
            }

            if (var0 instanceof class_1309 var13) {
               var12 = var6.field_1687.method_8407() == class_1267.field_5805
                  ? Math.min(var12 / 2.0F + 1.0F, var12)
                  : (var6.field_1687.method_8407() == class_1267.field_5807 ? var12 * 3.0F / 2.0F : var12);
               var12 = class_1280.method_5496(
                  var13,
                  var12,
                  var6.field_1687.method_48963().method_48807(null),
                  var13.method_6096(),
                  (float)var13.method_5996(class_5134.field_23725).method_6194()
               );
               var12 *= var13.method_6059(class_1294.field_5907)
                  ? (float)(1.0 - (var13.method_6112(class_1294.field_5907).method_5578() + 1) * 0.2000000097826446)
                  : 1.0F;
               var12 = class_1280.method_5497(var12, method0985(var13.method_5661()));
            }

            return Math.max(var12, 0.0F);
         }
      } else {
         return 0.0F;
      }
   }

   public static int method0985(Iterable<class_1799> var0) {
      int var1 = 0;

      for (class_1799 var3 : var0) {
         var1 += method1239(var3);
      }

      return var1;
   }

   public static int method1239(class_1799 var0) {
      int var1 = 0;
      class_9304 var2 = class_1890.method_57532(var0);

      for (class_6880 var4 : var2.method_57534()) {
         String var5 = var4.method_55840().replace("minecraft:", "");
         if (field0720.containsKey(var5)) {
            var1 += var2.method_57536(var4) * field0720.get(var5);
            break;
         }
      }

      return var1;
   }

   private static class_1934 method1181(class_1657 var0) {
      if (method0572().method_1562() == null) {
         return class_1934.field_9215;
      }

      class_640 var1 = method0572().method_1562().method_2871(var0.method_5667());
      return var1 == null ? class_1934.field_9220 : var1.method_2958();
   }

   private static float method1326(class_243 var0, class_238 var1, class_2338 var2, boolean var3) {
      int var4 = 0;
      int var5 = 0;

      for (double var6 = 0.0; var6 <= 1.0; var6 += 0.45454544864977864) {
         for (double var8 = 0.0; var8 <= 1.0; var8 += 0.2173913237729511) {
            for (double var10 = 0.0; var10 <= 1.0; var10 += 0.45454544864977864) {
               class_243 var12 = new class_243(
                  class_3532.method_16436(var6, var1.field_1323, var1.field_1320) + 0.04545453854468606,
                  class_3532.method_16436(var8, var1.field_1322, var1.field_1325),
                  class_3532.method_16436(var10, var1.field_1321, var1.field_1324) + 0.04545453854468606
               );
               if (method1336(var12, var0, var2, var3) == class_240.field_1333) {
                  var4++;
               }

               var5++;
            }
         }
      }

      return (float)var4 / var5;
   }

   private static class_240 method1336(class_243 var0, class_243 var1, class_2338 var2, boolean var3) {
      class_310 var4 = method0572();
      return var4.field_1687 == null ? class_240.field_1333 : (class_240)class_1922.method_17744(var0, var1, null, (var5, var6) -> {
         class_2680 var7;
         if (var6.equals(var2)) {
            var7 = class_2246.field_10124.method_9564();
         } else {
            var7 = var4.field_1687.method_8320(var6);
            if (var7.method_26204().method_9520() < 600.0F && var3) {
               var7 = class_2246.field_10124.method_9564();
            }
         }

         class_3965 var8 = var7.method_26220(var4.field_1687, var6).method_1092(var0, var1, var6);
         return var8 == null ? null : var8.method_17783();
      }, var0x -> class_240.field_1333);
   }
}
