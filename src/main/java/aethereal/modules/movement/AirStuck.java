package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1304;
import net.minecraft.class_1713;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_2815;
import net.minecraft.class_2828;

public class AirStuck extends Module {
   private final BooleanSetting field0034 = new BooleanSetting("airstuck.equipchestplate", false)
      .method1007("Equip Chestplate")
      .method0210("Equip a chestplate from the inventory if one isn't worn")
      .method2130("Одевать нагрудник, если он не надет");
   private double field1409;
   private double field0956;
   private double field0176;
   private final Stopwatch field0476 = new Stopwatch();

   public AirStuck() {
      super("AirStuck", ModuleCategory.field0088, "Freezes player position in the air");
      this.method1013("Позволяет зависнуть в воздухе");
   }

   @Override
   public void method0025() {
      super.method0025();
      if (field0796.field_1724 != null) {
         this.field1409 = field0796.field_1724.method_23317();
         this.field0956 = field0796.field_1724.method_23318();
         this.field0176 = field0796.field_1724.method_23321();
      }
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (field0796.field_1724 != null && field0796.field_1687 != null) {
         field0796.field_1724.method_18800(0.0, 0.0, 0.0);
         field0796.field_1724.method_6125(0.0F);
         field0796.field_1724.method_5814(this.field1409, this.field0956, this.field0176);
         if (this.field0034.method1938() && this.field0476.method0779(150L) && this.method1736()) {
            this.field0476.method1812();
         }
      }
   }

   @EventHandler
   public void onPacket(PacketEvent.Outbound var1) {
      if (field0796.field_1724 != null && field0796.field_1687 != null) {
         field0796.field_1724.method_18800(0.0, 0.0, 0.0);
         field0796.field_1724.method_6125(0.0F);
         if (var1.method1970() instanceof class_2828) {
            var1.method0578();
         }
      }
   }

   private boolean method1736() {
      if (this.method1222(field0796.field_1724.method_6118(class_1304.field_6174).method_7909())) {
         return false;
      }

      int var1 = this.method1680();
      if (var1 == -1) {
         return false;
      }

      this.method0729(var1);
      field0796.method_1562().method_52787(new class_2815(0));
      return true;
   }

   private void method0729(int var1) {
      if (var1 <= 8) {
         field0796.field_1761.method_2906(0, 6, var1, class_1713.field_7791, field0796.field_1724);
      } else {
         field0796.field_1761.method_2906(0, var1, 8, class_1713.field_7791, field0796.field_1724);
         field0796.field_1761.method_2906(0, 6, 8, class_1713.field_7791, field0796.field_1724);
         field0796.field_1761.method_2906(0, var1, 8, class_1713.field_7791, field0796.field_1724);
      }
   }

   private int method1680() {
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
}
