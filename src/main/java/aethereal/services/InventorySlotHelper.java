package aethereal;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;
import lombok.Generated;
import net.minecraft.class_1268;
import net.minecraft.class_1291;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1842;
import net.minecraft.class_1844;
import net.minecraft.class_4174;
import net.minecraft.class_6880;
import net.minecraft.class_9334;

public final class InventorySlotHelper implements MinecraftAccess {
   public static int method0716(int var0) {
      return var0 >= 0 && var0 <= 8 ? 36 + var0 : var0;
   }

   public static void method0143(int var0) {
      if (field0796.field_1724 != null && field0796.field_1761 != null) {
         field0796.field_1761.method_2906(field0796.field_1724.field_7512.field_7763, var0, 0, class_1713.field_7794, field0796.field_1724);
      }
   }

   public static void method2102(int var0) {
      if (field0796.field_1724 != null && field0796.field_1761 != null) {
         field0796.field_1761.method_2906(field0796.field_1724.field_7512.field_7763, method0716(var0), 40, class_1713.field_7791, field0796.field_1724);
      }
   }

   public static int method1106(Predicate<class_1799> var0, int var1, int var2) {
      if (field0796.field_1724 == null) {
         return -1;
      }

      for (int var3 = var2; var3 >= var1; var3--) {
         class_1799 var4 = field0796.field_1724.method_31548().method_5438(var3);
         if (var0.test(var4)) {
            return var3;
         }
      }

      return -1;
   }

   public static int method1225(class_1792 var0, int var1, int var2) {
      return method1106(var1x -> var1x.method_7909() == var0, var1, var2);
   }

   public static int method1217(class_1792 var0) {
      return method1225(var0, 0, 8);
   }

   public static int method0262(class_1792 var0) {
      return method1225(var0, 0, 35);
   }

   public static int method0531() {
      if (field0796.field_1724 == null) {
         return -1;
      }

      Optional var0 = field0796.field_1724
         .field_7498
         .field_7761
         .stream()
         .filter(var0x -> var0x.method_7681() && var0x.field_7874 >= 9 && var0x.field_7874 <= 44)
         .filter(var0x -> var0x.method_7677().method_57824(class_9334.field_50075) != null)
         .max(Comparator.comparingDouble(var0x -> {
            class_4174 var1 = (class_4174)var0x.method_7677().method_57824(class_9334.field_50075);
            return var1 == null ? 0.0 : var1.comp_2492();
         }));
      return var0.<Integer>map(var0x -> method1826(var0x.field_7874)).orElse(-1);
   }

   public static int method1529(class_6880<class_1291> var0) {
      if (field0796.field_1724 == null) {
         return -1;
      }

      for (class_1735 var2 : field0796.field_1724.field_7498.field_7761) {
         if (var2.method_7681() && var2.field_7874 >= 9 && var2.field_7874 <= 44) {
            class_1799 var3 = var2.method_7677();
            if (var3.method_7909() == class_1802.field_8574 || var3.method_7909() == class_1802.field_8436 || var3.method_7909() == class_1802.field_8150) {
               class_1844 var4 = (class_1844)var3.method_57824(class_9334.field_49651);
               if (var4 != null && !var4.comp_2378().isEmpty()) {
                  boolean var5 = ((class_1842)((class_6880)var4.comp_2378().get()).comp_349())
                     .method_8049()
                     .stream()
                     .anyMatch(var1 -> var1.method_5579().equals(var0));
                  if (var5) {
                     return method1826(var2.field_7874);
                  }
               }
            }
         }
      }

      return -1;
   }

   public static int method1826(int var0) {
      return var0 >= 36 && var0 <= 44 ? var0 - 36 : var0;
   }

   public static class_1268 method1118(class_1268 var0) {
      return var0 == class_1268.field_5808 ? class_1268.field_5810 : class_1268.field_5808;
   }

   @Generated
   private InventorySlotHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
