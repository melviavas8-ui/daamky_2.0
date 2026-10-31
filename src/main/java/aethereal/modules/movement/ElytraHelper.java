package aethereal;

import java.util.concurrent.ThreadLocalRandom;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10185;
import net.minecraft.class_1268;
import net.minecraft.class_1304;
import net.minecraft.class_1713;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_2815;
import net.minecraft.class_2848;
import net.minecraft.class_2851;
import net.minecraft.class_3675;
import net.minecraft.class_408;
import net.minecraft.class_2848.class_2849;

public class ElytraHelper extends Module {
   private final KeyBindSetting field0085 = new KeyBindSetting("elytrahelper.bindelytra", new KeyBind(-1, false))
      .method1007("Elytra Bind")
      .method0210("Key to swap elytra and chestplate")
      .method2130("Клавиша для свапа элитры");
   private final KeyBindSetting field1468 = new KeyBindSetting("elytrahelper.bindfirework", new KeyBind(-1, false))
      .method1007("Firework Bind")
      .method0210("Key to use a firework rocket while gliding")
      .method2130("Клавиша для использования фейерверка");
   private final BooleanSetting field0970 = new BooleanSetting("elytrahelper.autogliding", false)
      .method1007("Auto Takeoff")
      .method0210("Automatically start")
      .method2130("Автоматический взлет");
   private boolean field0219;
   private boolean field0497;
   private final Stopwatch field1634 = new Stopwatch();
   private long field1540 = method1699();
   private ElytraHelper.FlightState field1714 = ElytraHelper.FlightState.field0626;
   private boolean field1161;
   private int field1088 = -1;
   private int field1197 = -1;
   private int field0872 = -1;

   private static long method1699() {
      return ThreadLocalRandom.current().nextLong(50L, 101L);
   }

   public ElytraHelper() {
      super("ElytraHelper", ModuleCategory.field0088, "Assists with elytra flight control");
      this.method1013("Помощник управления полётом на элитре");
   }

   @EventHandler
   public void onKey(KeyEvent var1) {
      if (!method1974()) {
         if (!(field0796.field_1755 instanceof class_408)) {
            this.method0773(var1.method1763(), false, var1.method1604());
         }
      }
   }

   @EventHandler
   public void onMouse(MouseEvent var1) {
      if (!method1974()) {
         if (field0796.field_1755 == null) {
            this.method0773(var1.method1763(), true, var1.method1604());
         }
      }
   }

   private void method0773(int var1, boolean var2, int var3) {
      KeyBind var4 = this.field0085.method0492();
      KeyBind var5 = this.field1468.method0492();
      if (!var4.method0579() && var4.method1813() == var2 && var1 == var4.method2048()) {
         if (var3 == 1) {
            this.field0219 = true;
         } else if (var3 == 0 && var4.method1635()) {
            this.field0219 = true;
         }
      } else if (var3 == 1 && !var5.method0579() && var5.method1813() == var2 && var1 == var5.method2048() && field0796.field_1724.method_6128()) {
         this.field0497 = true;
      }
   }

   @EventHandler
   private void onTick(PlayerTickEvent var1) {
      if (!method1974()) {
         switch (this.field1714) {
            case field0057:
               this.method1754();
               return;
            case field1447:
               this.method2015();
               return;
            case field0982:
               this.method2043();
               return;
            case field0767:
               this.method0471();
               return;
            case field1253:
               this.method0457();
               return;
            default:
               if (this.field0497) {
                  this.field0497 = false;
                  this.method2029();
               } else if (this.field0219) {
                  if (this.field1634.method0779(this.field1540)) {
                     this.field0219 = false;
                     this.field1634.method1812();
                     this.field1540 = method1699();
                     this.method1691();
                  }
               } else if (!field0796.field_1724.method_6128() && !field0796.field_1724.method_5799() && !field0796.field_1724.method_5765()) {
                  boolean var2 = this.field0970.method1938() && field0796.field_1724.field_3913.field_54155.comp_3163();
                  if (var2) {
                     boolean var3 = field0796.field_1724.method_6118(class_1304.field_6174).method_7909() == class_1802.field_8833;
                     if (var3) {
                        if (!field0796.field_1724.method_24828()) {
                           field0796.method_1562().method_52787(new class_2848(field0796.field_1724, class_2849.field_12982));
                           field0796.field_1724.method_23669();
                           if (InventoryManager.method0262(class_1802.field_8639) != -1) {
                              this.field0497 = true;
                           }
                        }
                     }
                  }
               }
         }
      }
   }

   private void method1691() {
      if (this.method0406()) {
         this.method0729(1);
         this.field1714 = ElytraHelper.FlightState.field0057;
      } else {
         this.method0410();
         this.method0479();
         this.method0521();
      }
   }

   private void method1754() {
      this.method0410();
      this.method0479();
      this.method0521();
      this.method0398();
      this.field1714 = ElytraHelper.FlightState.field0626;
   }

   private void method2029() {
      int var1 = InventoryManager.method2154(class_1802.field_8639);
      if (var1 != -1) {
         this.field1088 = var1;
         this.method2015();
      } else {
         int var2 = InventoryManager.method1859(class_1802.field_8639);
         if (var2 != -1) {
            this.field1197 = var2;
            this.field0872 = (field0796.field_1724.method_31548().field_7545 + 1) % 9;
            if (this.method0406()) {
               this.method0729(3);
               this.field1714 = ElytraHelper.FlightState.field0982;
            } else {
               this.method2043();
            }
         }
      }
   }

   private void method2015() {
      int var1 = field0796.field_1724.method_31548().field_7545;
      field0796.field_1724.method_31548().field_7545 = this.field1088;
      field0796.field_1761.method_2919(field0796.field_1724, class_1268.field_5808);
      field0796.field_1724.method_31548().field_7545 = var1;
      this.field1088 = -1;
      this.field1714 = ElytraHelper.FlightState.field0626;
   }

   private void method2043() {
      this.method0410();
      field0796.field_1761.method_2906(0, this.field1197, this.field0872, class_1713.field_7791, field0796.field_1724);
      this.method0521();
      this.field1714 = ElytraHelper.FlightState.field0767;
   }

   private void method0471() {
      int var1 = field0796.field_1724.method_31548().field_7545;
      field0796.field_1724.method_31548().field_7545 = this.field0872;
      field0796.field_1761.method_2919(field0796.field_1724, class_1268.field_5808);
      field0796.field_1724.method_31548().field_7545 = var1;
      this.field1714 = ElytraHelper.FlightState.field1253;
   }

   private void method0457() {
      this.method0410();
      field0796.field_1761.method_2906(0, this.field1197, this.field0872, class_1713.field_7791, field0796.field_1724);
      this.method0521();
      this.field1197 = -1;
      this.field0872 = -1;
      this.method0398();
      this.field1714 = ElytraHelper.FlightState.field0626;
   }

   private void method0479() {
      if (field0796.field_1724.method_6118(class_1304.field_6174).method_7909() == class_1802.field_8833) {
         int var1 = this.method0523();
         if (var1 != -1) {
            if (var1 <= 8) {
               field0796.field_1761.method_2906(0, 6, var1, class_1713.field_7791, field0796.field_1724);
            } else {
               field0796.field_1761.method_2906(0, var1, 8, class_1713.field_7791, field0796.field_1724);
               field0796.field_1761.method_2906(0, 6, 8, class_1713.field_7791, field0796.field_1724);
               field0796.field_1761.method_2906(0, var1, 8, class_1713.field_7791, field0796.field_1724);
            }
         } else {
            field0796.field_1761.method_2906(0, 6, 0, class_1713.field_7794, field0796.field_1724);
         }
      } else {
         int var2 = this.method0512();
         if (var2 != -1) {
            if (var2 <= 8) {
               field0796.field_1761.method_2906(0, 6, var2, class_1713.field_7791, field0796.field_1724);
            } else {
               field0796.field_1761.method_2906(0, var2, 8, class_1713.field_7791, field0796.field_1724);
               field0796.field_1761.method_2906(0, 6, 8, class_1713.field_7791, field0796.field_1724);
               field0796.field_1761.method_2906(0, var2, 8, class_1713.field_7791, field0796.field_1724);
            }
         }
      }

      field0796.method_1562().method_52787(new class_2815(0));
   }

   private boolean method0406() {
      return field0796.field_1724.method_5624() || field0796.field_1690.field_1867.method_1434();
   }

   private void method0729(int var1) {
      if (field0796.field_1724.method_5624()) {
         field0796.field_1724.method_5728(false);
      }

      field0796.field_1690.field_1867.method_23481(false);
      this.field1161 = true;
      Sprint.field0004 = Math.max(Sprint.field0004, var1);
   }

   private void method0398() {
      if (this.field1161) {
         long var1 = field0796.method_22683().method_4490();
         field0796.field_1690.field_1867.method_23481(class_3675.method_15987(var1, field0796.field_1690.field_1867.method_1429().method_1444()));
         this.field1161 = false;
      }
   }

   private void method0410() {
      if (field0796.method_1562() != null) {
         field0796.method_1562().method_52787(new class_2851(new class_10185(false, false, false, false, false, false, false)));
      }
   }

   private void method0521() {
      if (field0796.method_1562() != null && field0796.field_1724 != null) {
         field0796.method_1562().method_52787(new class_2851(field0796.field_1724.field_3913.field_54155));
      }
   }

   private int method0512() {
      int var1 = InventoryManager.method2154(class_1802.field_8833);
      return var1 != -1 ? var1 : InventoryManager.method1859(class_1802.field_8833);
   }

   private int method0523() {
      for (int var1 = 0; var1 <= 8; var1++) {
         if (this.method1222(field0796.field_1724.method_31548().method_5438(var1).method_7909())) {
            return var1;
         }
      }

      for (int var2 = 9; var2 <= 35; var2++) {
         if (this.method1222(field0796.field_1724.method_31548().method_5438(var2).method_7909())) {
            return var2;
         }
      }

      return -1;
   }

   private boolean method1222(class_1792 var1) {
      return var1 == class_1802.field_8577
         || var1 == class_1802.field_8873
         || var1 == class_1802.field_8678
         || var1 == class_1802.field_8523
         || var1 == class_1802.field_8058
         || var1 == class_1802.field_22028;
   }

   @Override
   public void method2078() {
      if (this.field1161) {
         this.method0398();
      }

      this.field1714 = ElytraHelper.FlightState.field0626;
      this.field0219 = false;
      this.field0497 = false;
      this.field1088 = -1;
      this.field1197 = -1;
      this.field0872 = -1;
      super.method2078();
   }

   private enum FlightState {
      field0626,
      field0057,
      field1447,
      field0982,
      field0767,
      field1253;
   }
}
