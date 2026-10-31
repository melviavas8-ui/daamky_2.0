package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_243;

public class Glide extends Module {
   private final IntervalTimer field0077 = new IntervalTimer();

   public Glide() {
      super("Glide", ModuleCategory.field0088, "Grim Glide");
      this.method1013("Grim Glide");
   }

   @EventHandler
   private void onMove(MovementEvent var1) {
      if (!method1974()) {
         if (field0796.field_1724.method_6128()) {
            class_243 var2 = field0796.field_1724.method_19538();
            float var3 = field0796.field_1724.method_36454();
            double var4 = 0.08500001683481971;
            double var6 = -Math.sin(Math.toRadians(var3)) * var4;
            double var8 = Math.cos(Math.toRadians(var3)) * var4;
            field0796.field_1724.method_18800(var6 * 1.25, field0796.field_1724.method_18798().field_1351 - 0.010000003492925088, var8 * 1.25);
            if (this.field0077.method0104(45.0)) {
               field0796.field_1724.method_5814(var2.method_10216() + var6, var2.method_10214(), var2.method_10215() + var8);
            }

            field0796.field_1724.method_18800(var6 * 1.25, field0796.field_1724.method_18798().field_1351 + 0.014999994412322623, var8 * 1.25);
         }
      }
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field0077.method0578();
   }
}
