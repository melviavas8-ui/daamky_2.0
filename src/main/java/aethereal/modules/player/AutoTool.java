package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1799;
import net.minecraft.class_1829;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_239;
import net.minecraft.class_2680;
import net.minecraft.class_3965;
import net.minecraft.class_239.class_240;

public class AutoTool extends Module {
   private final BooleanSetting field0034 = new BooleanSetting("autotool.swapback", true)
      .method1007("Swap Back")
      .method0210("Return to the original slot after mining")
      .method2130("Возвращаться на изначальный слот после копания");
   private final FloatSetting field1450 = new FloatSetting("autotool.swapbackDelay", 4.0F, 0.0F, 40.0F, 1.0F)
      .method1007("Swap Back Delay")
      .method0210("Ticks before switching back to the original slot")
      .method2130("Задержка");
   private int field0958 = -1;
   private int field0178 = 0;
   private class_2338 field0492;

   public AutoTool() {
      super("AutoTool", ModuleCategory.field1470, "AutoTool");
      this.method1013("Берет нужный предмет для копания блоков");
   }

   @Override
   public void method2078() {
      super.method2078();
      this.method1691();
      this.field0178 = 0;
      this.field0492 = null;
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         if (field0796.field_1761 != null && !field0796.field_1724.method_7337() && !field0796.field_1724.method_7325()) {
            boolean var2 = field0796.field_1690.field_1886.method_1434();
            if (var2) {
               this.field0178 = 0;
               class_2338 var3 = this.method1732();
               if (var3 != null) {
                  this.field0492 = var3;
                  class_2680 var4 = field0796.field_1687.method_8320(var3);
                  if (!var4.method_26215()) {
                     int var5 = this.method1362(var4);
                     int var6 = field0796.field_1724.method_31548().field_7545;
                     if (var5 != -1 && var5 != var6) {
                        if (this.field0958 == -1) {
                           this.field0958 = var6;
                        }

                        field0796.field_1724.method_31548().field_7545 = var5;
                     }
                  }
               }
            } else {
               this.field0492 = null;
               this.field0178++;
               if (this.field0034.method0492() && this.field0958 != -1 && this.field0178 >= this.field1450.method0492().intValue()) {
                  this.method1691();
               }
            }
         }
      }
   }

   private class_2338 method1732() {
      class_239 var1 = field0796.field_1765;
      return var1 instanceof class_3965 var2 && var1.method_17783() == class_240.field_1332 ? var2.method_17777() : this.field0492;
   }

   private int method1362(class_2680 var1) {
      double var2 = -1.0;
      int var4 = -1;
      boolean var5 = var1.method_27852(class_2246.field_10343);

      for (int var6 = 0; var6 < 9; var6++) {
         class_1799 var7 = field0796.field_1724.method_31548().method_5438(var6);
         if (!var7.method_7960() && (var5 || !(var7.method_7909() instanceof class_1829))) {
            double var8 = var7.method_7924(var1);
            if (!(var8 <= 1.0) && var8 > var2) {
               var2 = var8;
               var4 = var6;
            }
         }
      }

      return var4;
   }

   private void method1691() {
      if (this.field0958 != -1 && field0796.field_1724 != null) {
         if (this.field0958 >= 0 && this.field0958 < 9) {
            field0796.field_1724.method_31548().field_7545 = this.field0958;
         }

         this.field0958 = -1;
      } else {
         this.field0958 = -1;
      }
   }
}
