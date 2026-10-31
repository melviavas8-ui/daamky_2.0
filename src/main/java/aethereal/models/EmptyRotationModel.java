package aethereal;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.minecraft.class_1309;
import net.minecraft.class_243;

public final class EmptyRotationModel {
   private static final double field0002 = 0.45000000223554565;
   private static final double field1409 = 0.19999998746560727;
   private static final long field0959 = 60L;
   public static final EmptyRotationModel field0655 = new EmptyRotationModel();
   private final Map<UUID, EmptyRotationModel.State> field0794 = new HashMap<>();

   public synchronized void method1166(class_1309 var1, long var2) {
      if (var1 != null) {
         EmptyRotationModel.State var4 = this.field0794.computeIfAbsent(var1.method_5667(), var0 -> new EmptyRotationModel.State());
         class_243 var5 = var1.method_19538();
         if (var4.field0735 != null && var4.field0959 >= 0L) {
            long var6 = Math.max(1L, var2 - var4.field0959);
            class_243 var8 = var5.method_1020(var4.field0735).method_1021(1.0 / var6);
            var4.field0157 = var4.field0157.method_1021(0.5500000603110402).method_1019(var8.method_1021(0.45000000223554565));
            double var9 = var8.method_1020(var4.field0157).method_1027();
            var4.field1409 = 0.8000000313235127 * var4.field1409 + 0.19999998746560727 * var9;
         }

         var4.field0735 = var5;
         var4.field0959 = var2;
         this.method0778(var2);
      }
   }

   public synchronized class_243 method1160(class_1309 var1, double var2) {
      EmptyRotationModel.State var4 = this.field0794.get(var1.method_5667());
      return var4 == null ? var1.method_19538() : var1.method_19538().method_1019(var4.field0157.method_1021(var2));
   }

   public synchronized double method0242(class_1309 var1, double var2) {
      EmptyRotationModel.State var4 = this.field0794.get(var1.method_5667());
      return var4 == null ? 0.0 : Math.sqrt(var4.field1409 * Math.max(1.0, var2));
   }

   public synchronized class_243 method1157(class_1309 var1) {
      EmptyRotationModel.State var2 = this.field0794.get(var1.method_5667());
      return var2 == null ? class_243.field_1353 : var2.field0157;
   }

   private void method0778(long var1) {
      this.field0794.values().removeIf(var2 -> var1 - var2.field0959 > 60L);
   }

   private static final class State {
      class_243 field0735;
      class_243 field0157 = class_243.field_1353;
      double field1409 = 0.0;
      long field0959 = -1L;
   }
}
