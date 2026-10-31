package aethereal;

import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1311;
import net.minecraft.class_1429;
import net.minecraft.class_1511;
import net.minecraft.class_1542;
import net.minecraft.class_1588;
import net.minecraft.class_1657;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public class EntityFilter {
   public static boolean method1129(class_1297 var0) {
      return var0 instanceof class_1657;
   }

   public static boolean method0235(class_1297 var0) {
      return var0 instanceof class_1588 || var0.method_5864().method_5891() == class_1311.field_6302;
   }

   public static boolean method2144(class_1297 var0) {
      return var0 instanceof class_1429
         || var0.method_5864().method_5891() == class_1311.field_6294
         || var0.method_5864().method_5891() == class_1311.field_6300
         || var0.method_5864().method_5891() == class_1311.field_30092
         || var0.method_5864().method_5891() == class_1311.field_34447;
   }

   public static boolean method1851(class_1297 var0) {
      return var0.method_5864().method_5891() == class_1311.field_6303 || var0.method_5864().method_5891() == class_1311.field_24460;
   }

   public static boolean method1660(class_1297 var0) {
      return var0 instanceof class_1542;
   }

   public static boolean method1988(class_1297 var0) {
      return var0 instanceof class_1511;
   }

   public static boolean method0444(class_1297 var0) {
      return var0 instanceof class_1309 && var0.method_5767();
   }

   public static boolean method0388(class_1297 var0) {
      return method2144(var0) || method1851(var0);
   }

   public static boolean method0507(class_1297 var0) {
      return var0 instanceof class_1309;
   }

   public static class_243 method1325(class_243 var0, class_238 var1) {
      return new class_243(
         class_3532.method_15350(var0.field_1352, var1.field_1323, var1.field_1320),
         class_3532.method_15350(var0.field_1351, var1.field_1322, var1.field_1325),
         class_3532.method_15350(var0.field_1350, var1.field_1321, var1.field_1324)
      );
   }

   public static class_243 method1322(class_243 var0, class_1297 var1) {
      return method1325(var0, var1.method_5829());
   }

   public static double method1140(class_1297 var0, class_1297 var1) {
      return method1322(var0.method_33571(), var1).method_1020(var0.method_33571()).method_1033();
   }

   public static EntityFilter.EntityKind method2237(class_1297 var0) {
      if (method1129(var0)) {
         return EntityFilter.EntityKind.field0644;
      } else if (method0235(var0)) {
         return EntityFilter.EntityKind.field0074;
      } else if (method2144(var0)) {
         return EntityFilter.EntityKind.field1459;
      } else if (method1851(var0)) {
         return EntityFilter.EntityKind.field0994;
      } else if (method0444(var0)) {
         return EntityFilter.EntityKind.field0773;
      } else if (method1660(var0)) {
         return EntityFilter.EntityKind.field1257;
      } else {
         return method1988(var0) ? EntityFilter.EntityKind.field0324 : EntityFilter.EntityKind.field0196;
      }
   }

   public enum EntityKind {
      field0644,
      field0074,
      field1459,
      field0994,
      field0773,
      field1257,
      field0324,
      field0196;
   }
}
