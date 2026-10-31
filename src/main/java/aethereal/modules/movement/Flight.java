package aethereal;

import lombok.Generated;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_243;

public class Flight extends Module {
   private final EnumSetting<Flight.Mode> field0058 = new EnumSetting<>("flight.mode", Flight.Mode.field0627)
      .method1007("Mode")
      .method0210("Flight mode")
      .method2130("Режим полёта");
   private final FloatSetting field1450 = new FloatSetting(
         "flight.speed", 2.0F, 0.1F, 10.0F, 0.1F, () -> this.field0058.method0492() != Flight.Mode.field1449
      )
      .method1007("Speed")
      .method0210("Flight speed")
      .method2130("Скорость полёта");
   private final FloatSetting field0985 = new FloatSetting(
         "flight.dragonxz", 1.5F, 1.0F, 10.0F, 0.1F, () -> this.field0058.method0492() == Flight.Mode.field1449
      )
      .method1007("Dragon XZ Speed")
      .method0210("Horizontal speed")
      .method2130("Горизонтальная скорость");
   private final FloatSetting field0190 = new FloatSetting(
         "flight.dragony", 1.5F, 0.0F, 10.0F, 0.1F, () -> this.field0058.method0492() == Flight.Mode.field1449
      )
      .method1007("Dragon Y Speed")
      .method0210("Vertical speed")
      .method2130("Вертикальная скорость");

   public Flight() {
      super("Flight", ModuleCategory.field0088, "Allows the player to fly");
      this.method1013("Позволяет игроку летать");
   }

   @EventHandler
   private void onPlayerTick(PlayerTickEvent var1) {
      if (!method1974()) {
         switch ((Flight.Mode)this.field0058.method0492()) {
            case field0627:
               this.method1691();
               break;
            case field0059:
               this.method1754();
               break;
            case field1449:
               this.method1735();
         }
      }
   }

   private void method1735() {
      if (field0796.field_1724.method_31549().field_7479) {
         this.method0665(this.field0985.method0492());
         double var1 = 0.0;
         if (field0796.field_1690.field_1903.method_1434()) {
            var1 = this.field0190.method0492().floatValue();
         }

         if (field0796.field_1690.field_1832.method_1434()) {
            var1 = -this.field0190.method0492();
         }

         class_243 var3 = field0796.field_1724.method_18798();
         field0796.field_1724.method_18800(var3.field_1352, var1, var3.field_1350);
      }
   }

   private void method0665(float var1) {
      float var2 = field0796.field_1724.method_36454();
      float var3 = field0796.field_1724.field_6250;
      float var4 = field0796.field_1724.field_6212;
      double var5 = 0.0;
      double var7 = 0.0;
      if (var3 != 0.0F || var4 != 0.0F) {
         float var9 = (float)Math.sqrt(var3 * var3 + var4 * var4);
         var3 /= var9;
         var4 /= var9;
         float var10 = (float)Math.toRadians(var2);
         var5 = (-Math.sin(var10) * var3 + Math.cos(var10) * var4) * var1;
         var7 = (Math.cos(var10) * var3 + Math.sin(var10) * var4) * var1;
      }

      field0796.field_1724.method_18800(var5, field0796.field_1724.method_18798().field_1351, var7);
   }

   private void method1691() {
      double var1;
      if (field0796.field_1690.field_1832.method_1434()) {
         var1 = -this.field1450.method0492() / 1.5;
      } else if (field0796.field_1690.field_1903.method_1434()) {
         var1 = this.field1450.method0492().floatValue() / 1.5;
      } else {
         var1 = 0.0;
      }

      field0796.field_1724.method_18800(field0796.field_1724.method_18798().field_1352, var1, field0796.field_1724.method_18798().field_1350);
      MovementHelper.method0103(this.field1450.method0492().floatValue());
   }

   private void method1754() {
      MovementHelper.method0103(this.field1450.method0492().floatValue());
      field0796.field_1724.method_18800(field0796.field_1724.method_18798().field_1352, -0.0059999982574654945, field0796.field_1724.method_18798().field_1350);
   }

   public enum Mode implements DisplayNamed {
      field0627("Default"),
      field0059("Matrix"),
      field1449("Dragon");

      private final String field1030;

      @Generated
      @Override
      public String method0557() {
         return this.field1030;
      }

      @Generated
      Mode(String var3) {
         this.field1030 = var3;
      }
   }
}
