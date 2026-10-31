package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10185;
import net.minecraft.class_1268;
import net.minecraft.class_1713;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1934;
import net.minecraft.class_2851;
import net.minecraft.class_310;
import net.minecraft.class_3675;
import org.lwjgl.glfw.GLFW;

public class ClickPearl extends Module {
   private static final class_310 field0161 = class_310.method_1551();
   private final EnumSetting<ClickPearl.Mode> field1448 = new EnumSetting<>("clickpearl.mode", ClickPearl.Mode.field0604)
      .method1007("Mode")
      .method0210("Pearl throwing mode")
      .method2130("Режим");
   private final KeyBindSetting field1002 = new KeyBindSetting("clickpearl.key", new KeyBind(-1, false, false))
      .method1007("Key")
      .method0210("Key for throwing pearl")
      .method2130("Клавиша для броска");
   private boolean field0219 = false;
   private long field0460 = 0L;
   private ClickPearl.UseState field1620 = ClickPearl.UseState.field0605;
   private int field1539 = -1;
   private boolean field1735 = false;
   private int field1137 = -1;
   private int field1088 = -1;

   public ClickPearl() {
      super("ClickPearl", ModuleCategory.field0661, "Click to throw ender pearl");
      this.method1013("Бросок эндер-жемчуга при нажатии клавишы");
   }

   @EventHandler
   public void onTick(PlayerTickEvent var1) {
      if (field0161.field_1724 == null || field0161.field_1687 == null) {
         this.method0457();
      } else if (this.field1620 == ClickPearl.UseState.field1437) {
         this.method2015();
      } else if (this.field1620 == ClickPearl.UseState.field0043) {
         this.method2029();
      } else {
         boolean var2 = this.method0406();
         if (!this.field0219 && var2 && System.currentTimeMillis() - this.field0460 > 100L && !this.method0480()) {
            this.field0460 = System.currentTimeMillis();
            if (this.field1448.method0492() == ClickPearl.Mode.field0604) {
               this.method1735();
            } else {
               this.method1691();
            }
         }

         this.field0219 = var2;
      }
   }

   private void method1735() {
      if (field0161.field_1755 == null) {
         InventorySlotResult var1 = HotbarItemSwitcher.method1218(class_1802.field_8634);
         if (var1.method1813()) {
            int var3 = field0161.field_1724.method_31548().field_7545;
            field0161.field_1724.method_31548().field_7545 = var1.method2048();
            field0161.field_1761.method_2919(field0161.field_1724, class_1268.field_5808);
            field0161.field_1724.method_31548().field_7545 = var3;
         } else {
            InventorySlotResult var2 = HotbarItemSwitcher.method0263(class_1802.field_8634);
            if (var2.method1813() && !var2.method0026()) {
               this.field1539 = var2.method2048();
               this.method0729(1);
               this.field1620 = ClickPearl.UseState.field0043;
            } else {
               NewHUD.method1053("Нету предмета", "\"Эндер-жемчуг\"", new class_1799(class_1802.field_8634), false);
            }
         }
      }
   }

   private void method1691() {
      if (field0161.field_1755 == null) {
         this.field1137 = field0161.field_1724.method_31548().field_7545;
         this.field1088 = -1;
         InventorySlotResult var1 = HotbarItemSwitcher.method1218(class_1802.field_8634);
         if (var1.method1813()) {
            field0161.field_1724.method_31548().field_7545 = var1.method2048();
            field0161.field_1761.method_2919(field0161.field_1724, class_1268.field_5808);
            this.field1620 = ClickPearl.UseState.field1437;
         } else {
            InventorySlotResult var2 = HotbarItemSwitcher.method0263(class_1802.field_8634);
            if (var2.method1813() && !var2.method0026()) {
               this.field1088 = var2.method2048();
               this.field1539 = var2.method2048();
               this.method0729(2);
               this.field1620 = ClickPearl.UseState.field0043;
            } else {
               NewHUD.method1053("Нету предмета", "\"Эндер-жемчуг\"", new class_1799(class_1802.field_8634), false);
               this.field1137 = -1;
            }
         }
      }
   }

   private void method0729(int var1) {
      if (field0161.field_1724.method_5624()) {
         field0161.field_1724.method_5728(false);
         field0161.field_1690.field_1867.method_23481(false);
         this.field1735 = true;
         Sprint.field0004 = Math.max(Sprint.field0004, var1);
      }
   }

   private void method1754() {
      if (this.field1735) {
         long var1 = field0161.method_22683().method_4490();
         field0161.field_1690.field_1867.method_23481(class_3675.method_15987(var1, field0161.field_1690.field_1867.method_1429().method_1444()));
         this.field1735 = false;
      }
   }

   private void method2029() {
      if (field0161.field_1724 == null) {
         this.method0457();
      } else {
         int var1 = field0161.field_1724.method_31548().field_7545;
         this.method2043();
         field0161.field_1761.method_2906(0, this.field1539, var1, class_1713.field_7791, field0161.field_1724);
         field0161.field_1761.method_2919(field0161.field_1724, class_1268.field_5808);
         if (this.field1448.method0492() == ClickPearl.Mode.field0604) {
            field0161.field_1761.method_2906(0, this.field1539, var1, class_1713.field_7791, field0161.field_1724);
            this.method0471();
            this.method1754();
            this.method0457();
         } else {
            this.method0471();
            this.field1539 = -1;
            this.field1620 = ClickPearl.UseState.field1437;
         }
      }
   }

   private void method2015() {
      if (field0161.field_1724 == null) {
         this.method0457();
      } else {
         if (this.field1088 != -1) {
            this.method2043();
            field0161.field_1761.method_2906(0, this.field1088, field0161.field_1724.method_31548().field_7545, class_1713.field_7791, field0161.field_1724);
            this.method0471();
         }

         field0161.field_1724.method_31548().field_7545 = this.field1137;
         this.method1754();
         this.method0457();
      }
   }

   private void method2043() {
      field0161.method_1562().method_52787(new class_2851(new class_10185(false, false, false, false, false, false, false)));
   }

   private void method0471() {
      field0161.method_1562().method_52787(new class_2851(field0161.field_1724.field_3913.field_54155));
   }

   private void method0457() {
      this.field1620 = ClickPearl.UseState.field0605;
      this.field1539 = -1;
      this.field1137 = -1;
      this.field1088 = -1;
   }

   @Override
   public void method2078() {
      if (this.field1735) {
         this.method1754();
      }

      this.method0457();
      super.method2078();
   }

   private boolean method0480() {
      if (field0161.field_1761 != null && field0161.field_1761.method_2920() == class_1934.field_9220) {
         KeyBind var1 = this.field1002.method0492();
         return var1 != null && var1.method1813() ? field0161.field_1690.field_1871.method_1433(var1.method2048()) : false;
      } else {
         return false;
      }
   }

   private boolean method0406() {
      KeyBind var1 = this.field1002.method0492();
      if (var1 != null && var1.method2048() != -1) {
         long var2 = field0161.method_22683().method_4490();
         int var4 = var1.method2048();
         if (var1.method1813()) {
            return GLFW.glfwGetMouseButton(var2, var4) == 1;
         } else {
            return var4 >= 0 && var4 <= 7 ? GLFW.glfwGetMouseButton(var2, var4) == 1 : class_3675.method_15987(var2, var4);
         }
      } else {
         return false;
      }
   }

   public enum Mode implements DisplayNamed {
      field0604("Default"),
      field0042("Legit");

      private final String field1504;

      Mode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }

   private enum UseState {
      field0605,
      field0043,
      field1437;
   }
}
