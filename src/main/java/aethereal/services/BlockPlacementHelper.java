package aethereal;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import lombok.Generated;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1799;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3959;
import net.minecraft.class_5134;
import net.minecraft.class_9285;
import net.minecraft.class_9334;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;

public final class BlockPlacementHelper implements MinecraftAccess {
   private static final Pattern field0727 = Pattern.compile("^\\w{3,16}$");

   public static boolean method0579() {
      return field0796.field_1724.method_6115() && field0796.field_1724.method_6030().method_57353().method_57832(class_9334.field_50075);
   }

   public static boolean method1301(class_243 var0) {
      class_239 var1 = field0796.field_1687
         .method_17742(new class_3959(field0796.method_1560().method_33571(), var0, class_3960.field_17559, class_242.field_1348, field0796.method_1560()));
      return var1 == null || var1.method_17783() == class_240.field_1333;
   }

   public static boolean method0026() {
      if (field0796.field_1724 == null) {
         return false;
      } else {
         return field0796.field_1687 == null
            ? false
            : field0796.field_1724.method_5869()
               || field0796.field_1687.method_8320(field0796.field_1724.method_24515().method_10069(0, 0, 0)).method_26204() == class_2246.field_10382;
      }
   }

   public static boolean method2079() {
      if (field0796.field_1724 == null) {
         return false;
      }

      class_238 var0 = field0796.field_1724.method_5829();
      class_2338 var1 = field0796.field_1724.method_24515();
      return method1260(var1).stream().anyMatch(var1x -> method1291(var0, var1x));
   }

   private static boolean method1291(class_238 var0, class_2338 var1) {
      return var0.method_994(new class_238(var1))
         && field0796.field_1687 != null
         && field0796.field_1687.method_8320(var1).method_26204() == class_2246.field_10343;
   }

   public static List<class_2338> method1260(class_2338 var0) {
      List var1 = new ArrayList<>();

      for (int var2 = var0.method_10263() - 2; var2 <= var0.method_10263() + 2; var2++) {
         for (int var3 = var0.method_10264() - 1; var3 <= var0.method_10264() + 4; var3++) {
            for (int var4 = var0.method_10260() - 2; var4 <= var0.method_10260() + 2; var4++) {
               var1.add(new class_2338(var2, var3, var4));
            }
         }
      }

      return var1;
   }

   public static class_2248 method0683(float var0, float var1, float var2) {
      class_243 var3 = field0796.field_1724.method_19538();
      return field0796.field_1687
         .method_8320(new class_2338(new class_2382((int)(var3.field_1352 + var0), (int)(var3.field_1351 + var1), (int)(var3.field_1350 + var2))))
         .method_26204();
   }

   public static class_2338 method0708(float var0, class_2248 var1) {
      class_243 var2 = field0796.field_1724.method_19538();
      int var3 = (int)var0;

      for (int var4 = -var3; var4 <= var3; var4++) {
         for (int var5 = -var3; var5 <= var3; var5++) {
            for (int var6 = -var3; var6 <= var3; var6++) {
               class_2338 var7 = class_2338.method_49637(var2.field_1352 + var4, var2.field_1351 + var5, var2.field_1350 + var6);
               if (field0796.field_1687.method_8320(var7).method_26204() == var1
                  && field0796.field_1724.method_19538().method_1022(class_243.method_24953(var7)) <= var0) {
                  return var7;
               }
            }
         }
      }

      return null;
   }

   public static boolean method1129(class_1297 var0) {
      return method1133(var0, 0.0F);
   }

   public static boolean method1133(class_1297 var0, float var1) {
      class_238 var2 = field0796.field_1724.method_5829();
      class_238 var3 = var0.method_5829().method_1009(var1, 0.0, var1);
      return var2.field_1320 > var3.field_1323
         && var2.field_1325 > var3.field_1322
         && var2.field_1324 > var3.field_1321
         && var2.field_1323 < var3.field_1320
         && var2.field_1322 < var3.field_1325
         && var2.field_1321 < var3.field_1324;
   }

   public static boolean method1014(String var0) {
      return field0727.matcher(var0).matches();
   }

   public static double method1237(class_1799 var0) {
      if (var0 != null && !var0.method_7960()) {
         class_9285 var1 = (class_9285)var0.method_57824(class_9334.field_49636);
         if (var1 == null) {
            return 0.0;
         }

         double[] var2 = new double[]{0.0};
         var1.method_57482(class_1304.field_48824, (var1x, var2x) -> {
            if (var1x.comp_349() == class_5134.field_23724.comp_349() || var1x.comp_349() == class_5134.field_23725.comp_349()) {
               var2[0] += var2x.comp_2449();
            }
         });
         return var2[0];
      } else {
         return 0.0;
      }
   }

   @Generated
   private BlockPlacementHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
