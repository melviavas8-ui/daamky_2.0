package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1839;
import net.minecraft.class_2886;

public class CrossbowRapid extends Module {
   public CrossbowRapid() {
      super("Crossbow Rapid", ModuleCategory.field0661, "Enables rapid crossbow firing");
      this.method1013("Быстрая стрельба из арбалета");
   }

   @EventHandler
   private void onNoSlow(NoSlowEvent var1) {
      if (field0796.field_1724 != null) {
         class_1268 var2 = field0796.field_1724.method_6058();
         if (var2 != null) {
            class_1799 var3 = field0796.field_1724.method_5998(var2);
            if (!var3.method_7960() && var3.method_7909() == class_1802.field_8399) {
               class_1799 var4 = field0796.field_1724.method_6079();
               class_1839 var5 = var4.method_7976();
               boolean var6 = var5 == class_1839.field_8949 && var2 == class_1268.field_5808;
               boolean var7 = var5 == class_1839.field_8950 && var2 == class_1268.field_5808;
               if (!var6 && !var7) {
                  field0796.field_1724
                     .field_3944
                     .method_52787(new class_2886(var2, 0, field0796.field_1724.method_36454(), field0796.field_1724.method_36455()));
                  class_1268 var8 = InventoryManager.method1118(var2);
                  field0796.field_1724
                     .field_3944
                     .method_52787(new class_2886(var8, 0, field0796.field_1724.method_36454(), field0796.field_1724.method_36455()));
                  var1.method1570(true);
               }
            }
         }
      }
   }
}
