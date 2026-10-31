package aethereal;

import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import net.minecraft.class_1268;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_1730;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_2561;
import net.minecraft.class_2815;
import net.minecraft.class_4174;
import net.minecraft.class_9334;

public class InventorySearch implements MinecraftAccess {
   public static Stream<class_1735> method0562() {
      return field0796.field_1724.field_7512.field_7761.stream();
   }

   public static class_1735 method1220(class_1792 var0) {
      return method1230(var0, var0x -> true);
   }

   public static class_1735 method1230(class_1792 var0, Predicate<class_1735> var1) {
      return method0562().filter(var1x -> var1x.method_7677().method_7909().equals(var0)).filter(var1).findFirst().orElse(null);
   }

   public static class_1735 method1104(Predicate<class_1735> var0) {
      return method0562().filter(var0).findFirst().orElse(null);
   }

   public static class_1735 method1107(Predicate<class_1735> var0, Comparator<class_1735> var1) {
      return method0562().filter(var0).max(var1).orElse(null);
   }

   public static class_1735 method1229(class_1792 var0, Comparator<class_1735> var1, Predicate<class_1735> var2) {
      return method0562().filter(var1x -> var1x.method_7677().method_7909().equals(var0)).filter(var2).max(var1).orElse(null);
   }

   public static class_1735 method1073(List<class_1792> var0) {
      return method0562().filter(var1 -> var0.contains(var1.method_7677().method_7909())).findFirst().orElse(null);
   }

   public static int method1103(IntPredicate var0) {
      return IntStream.range(0, 9).filter(var0).findFirst().orElse(-1);
   }

   public static int method0228(Predicate<class_1735> var0) {
      return method0562().filter(var0).mapToInt(var0x -> var0x.method_7677().method_7947()).sum();
   }

   public static boolean method0026() {
      return method0562().toList().size() != 46;
   }

   public static String method1345(class_2561 var0) {
      if (var0 == null) {
         return "";
      }

      String var1 = var0.getString();
      return var1 == null ? "" : var1.replaceAll("§[0-9a-fk-or]", "").toLowerCase();
   }

   public static void method0754(int var0, int var1, class_1713 var2, boolean var3) {
      method0750(field0796.field_1724.field_7512.field_7763, var0, var1, var2, var3);
   }

   public static void method1209(class_1735 var0, int var1, class_1713 var2, boolean var3) {
      if (var0 != null) {
         method0754(var0.field_7874, var1, var2, var3);
      }
   }

   public static void method0750(int var0, int var1, int var2, class_1713 var3, boolean var4) {
      field0796.field_1761.method_2906(var0, var1, var2, var3, field0796.field_1724);
      if (var4) {
         field0796.field_1724.field_7512.method_7593(var1, var2, var3, field0796.field_1724);
      }
   }

   public static void method1208(class_1735 var0, int var1) {
      if (var0 != null) {
         method0757(var0.field_7874, var1, false, false);
      }
   }

   public static void method1210(class_1735 var0, int var1, boolean var2) {
      if (var0 != null) {
         method0757(var0.field_7874, var1, var2, false);
      }
   }

   public static void method0757(int var0, int var1, boolean var2, boolean var3) {
      if (var0 != var1 && var0 != -1) {
         int var4 = Math.toIntExact(method0562().count()) - 10;
         if (var0 >= var4 && var4 == 36) {
            if (var2) {
               InventoryActionScheduler.method0991(() -> method0754(var1, var0 - var4, class_1713.field_7791, false));
            } else {
               method0754(var1, var0 - var4, class_1713.field_7791, false);
            }
         } else {
            if (var2) {
               InventoryActionScheduler.method0991(() -> method0756(var0, var1, var3));
            } else {
               method0756(var0, var1, var3);
            }
         }
      }
   }

   public static void method0756(int var0, int var1, boolean var2) {
      method0754(var0, 0, class_1713.field_7791, false);
      method0754(var1, 0, class_1713.field_7791, false);
      method0754(var0, 0, class_1713.field_7791, false);
   }

   public static void method1215(class_1735 var0, class_1268 var1, boolean var2) {
      method1216(var0, var1, var2, false);
   }

   public static void method1216(class_1735 var0, class_1268 var1, boolean var2, boolean var3) {
      if (var0 != null
         && var0.field_7874 != -1
         && (!var1.equals(class_1268.field_5810) || var0.field_7871 instanceof class_1661 || var0.field_7871 instanceof class_1730)) {
         int var4 = var1.equals(class_1268.field_5808) ? field0796.field_1724.method_31548().field_7545 : 40;
         if (var2) {
            InventoryActionScheduler.method0991(() -> method0259(var0, var4, var3));
         } else {
            method0259(var0, var4, var3);
         }
      }
   }

   public static void method0259(class_1735 var0, int var1, boolean var2) {
      method1209(var0, var1, class_1713.field_7791, false);
   }

   public static void method0265(class_1792 var0) {
      method1236(var0, false);
   }

   public static void method1236(class_1792 var0, boolean var1) {
      class_1735 var2 = method1220(var0);
      if (var2 != null) {
         if (var1) {
            InventoryActionScheduler.method0991(() -> method1206(var2));
         } else {
            method1206(var2);
         }
      }
   }

   public static void method1206(class_1735 var0) {
      method1215(var0, class_1268.field_5808, false);
      if (field0796.field_1761 != null && field0796.field_1724 != null) {
         field0796.field_1761.method_2919(field0796.field_1724, class_1268.field_5808);
      }

      method1216(var0, class_1268.field_5808, false, true);
   }

   public static void method1570(boolean var0) {
      if (field0796.field_1724 != null) {
         if (var0) {
            field0796.field_1724.field_3944.method_52787(new class_2815(field0796.field_1724.field_7512.field_7763));
         } else {
            field0796.field_1724.method_7346();
         }
      }
   }

   public static class_1735 method2075() {
      return method0562().filter(var0 -> var0.method_7677().method_57824(class_9334.field_50075) != null).max(Comparator.comparingDouble(var0 -> {
         class_4174 var1 = (class_4174)var0.method_7677().method_57824(class_9334.field_50075);
         return var1 == null ? 0.0 : var1.comp_2492();
      })).orElse(null);
   }
}
