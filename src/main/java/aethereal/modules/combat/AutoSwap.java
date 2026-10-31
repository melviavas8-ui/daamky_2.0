package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10185;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2851;
import net.minecraft.class_3675;
import net.minecraft.class_9285;
import net.minecraft.class_9334;

public class AutoSwap extends Module {
   private final EnumSetting<AutoSwap.Mode> field0058 = new EnumSetting<>("autoswap.mode", AutoSwap.Mode.field0593)
      .method1007("Mode")
      .method0210("Swap method to use")
      .method2130("Режим");
   private final KeyBindSetting field1468 = new KeyBindSetting("autoswap.bind", new KeyBind(72, false))
      .method1007("Bind")
      .method0210("Key to trigger item swap")
      .method2130("Клавиша для свапа");
   private final EnumSetting<AutoSwap.ItemChoice> field0984 = new EnumSetting<>("autoswap.first", AutoSwap.ItemChoice.field0595)
      .method1007("First Item")
      .method0210("Primary item to swap between")
      .method2130("Первый предмет");
   private final EnumSetting<AutoSwap.ItemChoice> field0189 = new EnumSetting<>("autoswap.second", AutoSwap.ItemChoice.field1430)
      .method1007("Second Item")
      .method0210("Secondary item to swap between")
      .method2130("Второй предмет");
   private final BooleanSetting field0464 = new BooleanSetting("autoswap.notify", true)
      .method1007("Notifications")
      .method0210("Show a notification on swap")
      .method2130("Показывать уведомление при свапе");
   private boolean field1653;
   private AutoSwap.SwapState field1543 = AutoSwap.SwapState.field0594;
   private int field1705 = -1;
   private boolean field1161 = false;

   public AutoSwap() {
      super("AutoSwap", ModuleCategory.field0661, "Automatically swaps to the best weapon");
      this.method1013("Автоматически переключает предметы по бинду");
   }

   @EventHandler
   public void onTick(PlayerTickEvent var1) {
      if (!method1974()) {
         switch (this.field1543) {
            case field1429:
               this.method1735();
               return;
            case field0967:
               this.method1691();
               return;
            case field0765:
               this.method1754();
               return;
            case field1250:
               this.method2029();
               this.field1543 = AutoSwap.SwapState.field0594;
               return;
            default:
               boolean var2 = this.field1468.method0492().method0026();
               if (var2 && !this.field1653 && this.field1543 == AutoSwap.SwapState.field0594) {
                  int var3 = this.method0400();
                  if (var3 == -1) {
                     this.method0457();
                  } else {
                     this.field1705 = var3;
                     if (field0796.field_1724.method_5624()) {
                        this.method0143(this.field0058.method0492() == AutoSwap.Mode.field0028 ? 3 : 1);
                        this.field1543 = this.field0058.method0492() == AutoSwap.Mode.field0593
                           ? AutoSwap.SwapState.field1429
                           : AutoSwap.SwapState.field0967;
                     } else if (this.field0058.method0492() == AutoSwap.Mode.field0593) {
                        this.method2043();
                        this.method0729(var3);
                        this.method0471();
                        this.field1543 = AutoSwap.SwapState.field0594;
                        this.field1705 = -1;
                     } else {
                        this.field1543 = AutoSwap.SwapState.field0967;
                     }
                  }
               }

               this.field1653 = var2;
         }
      }
   }

   private void method1735() {
      this.method2043();
      this.method0729(this.field1705);
      this.method0471();
      this.method2029();
      this.field1705 = -1;
      this.field1543 = AutoSwap.SwapState.field0594;
   }

   private void method1691() {
      field0796.field_1690.field_1894.method_23481(false);
      field0796.field_1690.field_1881.method_23481(false);
      field0796.field_1690.field_1913.method_23481(false);
      field0796.field_1690.field_1849.method_23481(false);
      field0796.field_1690.field_1903.method_23481(false);
      this.field1543 = AutoSwap.SwapState.field0765;
   }

   private void method1754() {
      this.method2043();
      this.method0729(this.field1705);
      this.method0471();
      this.field1705 = -1;
      this.method2015();
      this.field1543 = this.field1161 ? AutoSwap.SwapState.field1250 : AutoSwap.SwapState.field0594;
   }

   private void method0729(int var1) {
      if (field0796.field_1724 == null) {
         InventorySlotHelper.method2102(var1);
      } else {
         class_1799 var2 = field0796.field_1724.method_31548().method_5438(var1).method_7972();
         InventorySlotHelper.method2102(var1);
         if (this.field0464.method0492() && !var2.method_7960()) {
            NewHUD.method1053("Свапнул на", "\"" + var2.method_7964().getString() + "\"", var2, true);
         }
      }
   }

   private void method0143(int var1) {
      field0796.field_1724.method_5728(false);
      field0796.field_1690.field_1867.method_23481(false);
      this.field1161 = true;
      Sprint.field0004 = Math.max(Sprint.field0004, var1);
   }

   private void method2029() {
      if (this.field1161) {
         long var1 = field0796.method_22683().method_4490();
         field0796.field_1690.field_1867.method_23481(class_3675.method_15987(var1, field0796.field_1690.field_1867.method_1429().method_1444()));
         this.field1161 = false;
      }
   }

   private void method2015() {
      long var1 = field0796.method_22683().method_4490();
      field0796.field_1690.field_1894.method_23481(class_3675.method_15987(var1, field0796.field_1690.field_1894.method_1429().method_1444()));
      field0796.field_1690.field_1881.method_23481(class_3675.method_15987(var1, field0796.field_1690.field_1881.method_1429().method_1444()));
      field0796.field_1690.field_1913.method_23481(class_3675.method_15987(var1, field0796.field_1690.field_1913.method_1429().method_1444()));
      field0796.field_1690.field_1849.method_23481(class_3675.method_15987(var1, field0796.field_1690.field_1849.method_1429().method_1444()));
      field0796.field_1690.field_1903.method_23481(class_3675.method_15987(var1, field0796.field_1690.field_1903.method_1429().method_1444()));
   }

   private void method2043() {
      if (field0796.method_1562() != null) {
         field0796.method_1562().method_52787(new class_2851(new class_10185(false, false, false, false, false, false, false)));
      }
   }

   private void method0471() {
      if (field0796.method_1562() != null && field0796.field_1724 != null) {
         field0796.method_1562().method_52787(new class_2851(field0796.field_1724.field_3913.field_54155));
      }
   }

   private void method0457() {
      if (this.field0464.method0492() && field0796.field_1724 != null) {
         class_1792 var1 = this.method0477();
         class_1799 var2 = new class_1799(var1);
         NewHUD.method1053("Нету предмета", "\"" + var2.method_7964().getString() + "\"", var2, false);
      }
   }

   private class_1792 method0477() {
      class_1792 var1 = field0796.field_1724.method_6079().method_7909();
      class_1792 var2 = this.field0984.method0492().field1272;
      class_1792 var3 = this.field0189.method0492().field1272;
      if (var1 == var2) {
         return var3;
      } else {
         return var1 == var3 ? var2 : var2;
      }
   }

   private int method0400() {
      class_1792 var1 = field0796.field_1724.method_6079().method_7909();
      class_1792 var2 = this.field0984.method0492().field1272;
      class_1792 var3 = this.field0189.method0492().field1272;
      if (var1 == var2) {
         return this.method1217(var3);
      }

      if (var1 == var3) {
         return this.method1217(var2);
      }

      int var4 = this.method1217(var2);
      return var4 != -1 ? var4 : this.method1217(var3);
   }

   private int method1217(class_1792 var1) {
      if (var1 == class_1802.field_8575) {
         return InventorySlotHelper.method1106(var1x -> var1x.method_7909() == var1 && method1241(var1x), 0, 35);
      }

      if (var1 != class_1802.field_8288) {
         return InventorySlotHelper.method0262(var1);
      }

      int var2 = InventorySlotHelper.method1106(var1x -> var1x.method_7909() == var1 && (var1x.method_7958() || method1241(var1x)), 0, 35);
      return var2 != -1 ? var2 : InventorySlotHelper.method0262(var1);
   }

   private static boolean method1241(class_1799 var0) {
      class_9285 var1 = (class_9285)var0.method_57824(class_9334.field_49636);
      return var1 != null && !var1.comp_2393().isEmpty();
   }

   @Override
   public void method2078() {
      if (this.field1161) {
         this.method2029();
      }

      this.field1543 = AutoSwap.SwapState.field0594;
      this.field1705 = -1;
      super.method2078();
   }

   public enum Mode implements DisplayNamed {
      field0593("Default"),
      field0028("Legit");

      private final String field1504;

      Mode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }

   private enum SwapState {
      field0594,
      field0029,
      field1429,
      field0967,
      field0765,
      field1250;
   }

   public enum ItemChoice implements DisplayNamed {
      field0595("Totem of Undying", class_1802.field_8288),
      field0030("Player Head", class_1802.field_8575),
      field1430("Golden Apple", class_1802.field_8463),
      field0968("Shield", class_1802.field_8255);

      private final String field0791;
      private final class_1792 field1272;

      ItemChoice(String var3, class_1792 var4) {
         this.field0791 = var3;
         this.field1272 = var4;
      }

      @Override
      public String method0557() {
         return this.field0791;
      }
   }
}
