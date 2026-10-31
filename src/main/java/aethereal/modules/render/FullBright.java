package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1293;
import net.minecraft.class_1294;

public class FullBright extends Module {
   private final EnumSetting<FullBright.Mode> field0058 = new EnumSetting<>("fullbright.mode", FullBright.Mode.field0062)
      .method1007("Mode")
      .method0210("Brightness method to use")
      .method2130("Метод увеличения яркости");

   public FullBright() {
      super("FullBright", ModuleCategory.field1004, "Maximum brightness, removes darkness");
      this.method1013("Ставит свечку, чтобы светлее стало");
   }

   @Override
   public void method2078() {
      super.method2078();
      if (field0796.field_1724 != null) {
         field0796.field_1724.method_6016(class_1294.field_5925);
      }
   }

   @EventHandler
   public void onTick(ClientTickEvent var1) {
      if (!method1974()) {
         if (this.field0058.method0492() == FullBright.Mode.field0062) {
            field0796.field_1724.method_6092(new class_1293(class_1294.field_5925, Integer.MAX_VALUE, 0, false, false));
         } else if (field0796.field_1724.method_6059(class_1294.field_5925)) {
            class_1293 var2 = field0796.field_1724.method_6112(class_1294.field_5925);
            if (var2 != null && var2.method_5584() == Integer.MAX_VALUE && !var2.method_5581()) {
               field0796.field_1724.method_6016(class_1294.field_5925);
            }
         }
      }
   }

   public boolean method1736() {
      return this.field0058.method0492() == FullBright.Mode.field0629;
   }

   public enum Mode implements DisplayNamed {
      field0629("Gamma"),
      field0062("NightVision");

      private final String field1504;

      Mode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }
}
