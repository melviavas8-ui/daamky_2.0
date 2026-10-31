package aethereal;

import java.util.Objects;
import java.util.function.Predicate;
import lombok.Generated;
import net.minecraft.class_1297;
import net.minecraft.class_1675;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;

public final class RaycastHelper implements MinecraftAccess {
   public static class_3965 method0640(double var0, Rotation var2, boolean var3) {
      return method1306(Objects.requireNonNull(field0796.field_1724).method_5836(1.0F), var0, var2, var3);
   }

   public static class_3965 method1306(class_243 var0, double var1, Rotation var3, boolean var4) {
      class_1297 var5 = field0796.field_1719;
      if (var5 == null) {
         return null;
      }

      class_243 var6 = var3.method0024();
      class_243 var7 = var0.method_1031(var6.field_1352 * var1, var6.field_1351 * var1, var6.field_1350 * var1);
      class_1937 var8 = field0796.field_1687;
      if (var8 == null) {
         return null;
      }

      class_242 var9 = var4 ? class_242.field_1347 : class_242.field_1348;
      class_3959 var10 = new class_3959(var0, var7, class_3960.field_17559, var9, var5);
      return var8.method_17742(var10);
   }

   public static class_3965 method1339(class_243 var0, class_243 var1, class_3960 var2) {
      return method1340(var0, var1, var2, field0796.field_1724);
   }

   public static class_3965 method1340(class_243 var0, class_243 var1, class_3960 var2, class_1297 var3) {
      return method1341(var0, var1, var2, class_242.field_1348, var3);
   }

   public static class_3965 method1341(class_243 var0, class_243 var1, class_3960 var2, class_242 var3, class_1297 var4) {
      return field0796.field_1687.method_17742(new class_3959(var0, var1, var2, var3, var4));
   }

   public static class_3966 method0639(double var0, Rotation var2, Predicate<class_1297> var3) {
      class_1297 var4 = field0796.field_1724;
      if (var4 == null) {
         return null;
      }

      class_243 var5 = var4.method_5836(1.0F);
      class_243 var6 = var2.method0024();
      class_243 var7 = var5.method_1031(var6.field_1352 * var0, var6.field_1351 * var0, var6.field_1350 * var0);
      class_238 var8 = var4.method_5829().method_18804(var6.method_1021(var0)).method_1009(1.0, 1.0, 1.0);
      return class_1675.method_18075(var4, var5, var7, var8, var1 -> !var1.method_7325() && var3.test(var1), var0 * var0);
   }

   public static boolean method0814(CombatController.CombatAction var0) {
      if (field0796.field_1724.method_6128() && var0.method0564().method_6128()) {
         ElytraTarget var1 = ElytraTarget.method1710();
         float var2 = var1 != null && var1.method2195() ? var1.method0461() : var0.method2047();
         return field0796.field_1724.method_5739(var0.method0564()) <= var2;
      } else {
         return method1307(RotationManager.field0618.method0545().method0024(), var0.method2047() - 0.25F, var0.method0372());
      }
   }

   public static boolean method0643(double var0, class_238 var2) {
      return method1307(RotationManager.field0618.method0545().method0024(), var0 - 0.25, var2);
   }

   public static boolean method1307(class_243 var0, double var1, class_238 var3) {
      class_243 var4 = Objects.requireNonNull(field0796.field_1724).method_33571();
      return var3.method_1006(var4) || var3.method_992(var4, var4.method_1019(var0.method_1021(var1))).isPresent();
   }

   @Generated
   private RaycastHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
