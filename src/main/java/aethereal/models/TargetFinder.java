package aethereal;

import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1429;
import net.minecraft.class_1531;
import net.minecraft.class_1657;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;

public class TargetFinder {
   private class_1309 field0731;

   public class_1309 method0564() {
      return this.field0731;
   }

   public void method0025() {
      this.field0731 = null;
   }

   public class_1309 method0707(float var1, List<String> var2) {
      class_310 var3 = class_310.method_1551();
      if (var3.field_1724 != null && var3.field_1687 != null) {
         class_243 var4 = var3.field_1724.method_33571();
         double var5 = (double)var1 * var1;
         if (this.field0731 != null && var4.method_1025(method1157(this.field0731)) > var5) {
            this.field0731 = null;
         }

         class_1309 var7 = null;
         double var8 = 1.7976922776554304E308;

         for (class_1297 var11 : var3.field_1687.method_18112()) {
            if (var11 instanceof class_1309 var12 && method1168(var12, var2)) {
               class_243 var13 = method1157(var12);
               double var14 = var4.method_1025(var13);
               if (!(var14 > var5) && var14 < var8) {
                  var8 = var14;
                  var7 = var12;
               }
            }
         }

         if (this.field0731 == null) {
            this.field0731 = var7;
         } else if (this.field0731 != null && !method1168(this.field0731, var2)) {
            this.field0731 = var7;
         }

         return this.field0731;
      } else {
         return null;
      }
   }

   private static boolean method1168(class_1309 var0, List<String> var1) {
      class_310 var2 = class_310.method_1551();
      if (var2.field_1724 == null) {
         return false;
      } else if (var0 == var2.field_1724) {
         return false;
      } else if (var0.method_31481()) {
         return false;
      } else if (var0.method_5628() <= 0) {
         return false;
      } else if (!var0.method_5805() || var0.method_6032() <= 0.0F || var0.field_6213 > 0) {
         return false;
      } else if (var0 == var2.field_1724.method_49694()) {
         return false;
      } else {
         AntiBot var3 = AntiBot.method1700();
         if (var3 != null && var3.method1635() && var0 instanceof class_1657 var4 && var3.method0250(var4)) {
            return false;
         } else if (var0 instanceof class_1657 var6) {
            FriendManager var5 = FriendManager.method0538();
            return var5 != null && var5.method1129(var6) && !var1.contains("Friends") ? false : var1.contains("Players");
         } else if (var0 instanceof class_1429) {
            return var1.contains("Animals");
         } else {
            return var0 instanceof class_1308 ? var1.contains("Mobs") : !(var0 instanceof class_1531);
         }
      }
   }

   private static class_243 method1157(class_1309 var0) {
      class_310 var1 = class_310.method_1551();
      class_243 var2 = var1.field_1724.method_33571();
      class_238 var3 = var0.method_5829();
      return new class_243(
         class_3532.method_15350(var2.field_1352, var3.field_1323, var3.field_1320),
         class_3532.method_15350(var2.field_1351, var3.field_1322, var3.field_1325),
         class_3532.method_15350(var2.field_1350, var3.field_1321, var3.field_1324)
      );
   }
}
