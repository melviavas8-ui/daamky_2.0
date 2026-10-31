package aethereal;

import java.util.Arrays;
import java.util.List;
import lombok.Generated;
import net.minecraft.class_1713;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_2596;
import net.minecraft.class_2868;

public final class HotbarItemSwitcher implements MinecraftAccess {
   public static InventorySlotResult method1218(class_1792 var0) {
      if (field0796.field_1724 == null) {
         return InventorySlotResult.method0536();
      }

      for (int var1 = 0; var1 < 9; var1++) {
         class_1799 var2 = field0796.field_1724.method_31548().method_5438(var1);
         if (var2.method_7909() == var0 && var2.method_7919() < 430) {
            return new InventorySlotResult(var1, true, var2);
         }
      }

      return InventorySlotResult.method0536();
   }

   public static InventorySlotResult method1072(List<class_1792> var0) {
      if (field0796.field_1724 == null) {
         return InventorySlotResult.method0536();
      }

      for (int var1 = 0; var1 < 9; var1++) {
         class_1799 var2 = field0796.field_1724.method_31548().method_5438(var1);
         if (var0.contains(var2.method_7909()) && var2.method_7919() < 430) {
            return new InventorySlotResult(var1, true, var2);
         }
      }

      return InventorySlotResult.method0536();
   }

   public static InventorySlotResult method1595(class_1792... var0) {
      return method1072(Arrays.asList(var0));
   }

   public static InventorySlotResult method0263(class_1792 var0) {
      if (field0796.field_1724 == null) {
         return InventorySlotResult.method0536();
      }

      for (class_1799 var2 : field0796.field_1724.method_31548().field_7548) {
         if (var2.method_7909() == var0 && var2.method_7919() < 430) {
            return new InventorySlotResult(-2, true, var2);
         }
      }

      for (int var4 = 36; var4 >= 0; var4--) {
         class_1799 var5 = field0796.field_1724.method_31548().method_5438(var4);
         if (var5.method_7909() == var0 && var5.method_7919() < 430) {
            int var3 = var4 < 9 ? var4 + 36 : var4;
            return new InventorySlotResult(var3, true, var5);
         }
      }

      return InventorySlotResult.method0536();
   }

   public static void method0729(int var0) {
      if (field0796.field_1724 != null && field0796.method_1562() != null) {
         if (field0796.field_1724.method_31548().field_7545 != var0) {
            field0796.field_1724.method_31548().field_7545 = var0;
         }
      }
   }

   public static void method0143(int var0) {
      if (field0796.field_1724 != null && field0796.method_1562() != null) {
         field0796.method_1562().method_52787(new class_2868(var0));
      }
   }

   public static void method1354(class_2596<?> var0) {
      if (field0796.method_1562() != null) {
         field0796.method_1562().method_52787(var0);
      }
   }

   public static void method2102(int var0) {
      if (var0 != -1 && field0796.field_1761 != null && field0796.field_1724 != null) {
         field0796.field_1761.method_2906(field0796.field_1724.field_7512.field_7763, var0, 0, class_1713.field_7790, field0796.field_1724);
      }
   }

   public static void method0769(int var0, class_1713 var1) {
      if (var0 != -1 && field0796.field_1761 != null && field0796.field_1724 != null) {
         field0796.field_1761.method_2906(field0796.field_1724.field_7512.field_7763, var0, 0, var1, field0796.field_1724);
      }
   }

   public static void method0753(int var0, int var1, class_1713 var2) {
      if (var0 != -1 && field0796.field_1761 != null && field0796.field_1724 != null) {
         field0796.field_1761.method_2906(field0796.field_1724.field_7512.field_7763, var0, var1, var2, field0796.field_1724);
      }
   }

   @Generated
   private HotbarItemSwitcher() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
