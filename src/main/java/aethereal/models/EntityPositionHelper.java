package aethereal;

import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;

public final class EntityPositionHelper {
   private EntityPositionHelper() {
   }

   private static class_310 method0572() {
      return class_310.method_1551();
   }

   public static class_2338 method1126(class_1297 var0) {
      return new class_2338(
         var0.method_31477(),
         class_3532.method_15357(
            var0.method_23318() - Math.floor(var0.method_23318()) > 0.8000001491307842
               ? Math.floor(var0.method_23318()) + 1.0
               : Math.floor(var0.method_23318())
         ),
         var0.method_31479()
      );
   }

   public static class_238 method1193(class_1657 var0, int var1) {
      if (var0 != null && method0572().field_1687 != null) {
         double var2 = var0.method_23317() - var0.field_6014;
         double var4 = var0.method_23321() - var0.field_5969;
         double var6 = 0.0;
         double var8 = 0.0;

         for (double var10 = 1.0;
            var10 <= var1 && !method0572().field_1687.method_39454(var0, var0.method_5829().method_997(new class_243(var2 * var10, 0.0, var4 * var10)));
            var10 += 0.5
         ) {
            var6 = var2 * var10;
            var8 = var4 * var10;
         }

         return var0.method_5829().method_997(new class_243(var6, 0.0, var8));
      } else {
         return null;
      }
   }
}
