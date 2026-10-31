package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1309;
import net.minecraft.class_243;

public class Speed extends Module {
   private final EnumSetting<Speed.Mode> field0058 = new EnumSetting<>("speed.mode", Speed.Mode.field0688)
      .method1007("Mode")
      .method0210("Mode bypass ac")
      .method2130("Режим обхода античита");
   private final FloatSetting field1450 = new FloatSetting(
         "speed.customspeed", 0.039F, 0.001F, 0.2F, 0.001F, () -> this.field0058.method0492() == Speed.Mode.field0112
      )
      .method1007("Speed")
      .method0210("Boost velocity per tick toward target")
      .method2130("Скорость");
   private final FloatSetting field0985 = new FloatSetting(
         "speed.radius", 0.5F, 0.0F, 3.0F, 0.1F, () -> this.field0058.method0492() == Speed.Mode.field0112
      )
      .method1007("Radius")
      .method0210("Blocks to expand the target hitbox; boost works within this range")
      .method2130("Радиус");

   public Speed() {
      super("Speed", ModuleCategory.field0088, "Boosts movement");
      this.method1013("Ускоряет движение");
   }

   @EventHandler
   private void onPlayerTick(PlayerTickEvent var1) {
      if (!method1974()) {
         Aura var2 = Aura.method1701();
         if (var2 != null) {
            class_1309 var3 = var2.method0409();
            if (var3 != null && var3.method_5805()) {
               if (field0796.field_1724.field_3913.field_3905 != 0.0F || field0796.field_1724.field_3913.field_3907 != 0.0F) {
                  double var4 = this.field0058.method0492() == Speed.Mode.field0112 ? this.field0985.method0492().floatValue() : 0.0;
                  if (field0796.field_1724.method_5829().method_994(var3.method_5829().method_1014(var4))) {
                     double var6 = this.field0058.method0492() == Speed.Mode.field0112
                        ? this.field1450.method0492().floatValue()
                        : this.field0058.method0492().field0956;
                     double var8 = var3.method_23317() - field0796.field_1724.method_23317();
                     double var10 = var3.method_23321() - field0796.field_1724.method_23321();
                     double var12 = Math.sqrt(var8 * var8 + var10 * var10);
                     if (var12 != 0.0) {
                        class_243 var14 = new class_243(var8 / var12 * var6, 0.0, var10 / var12 * var6);
                        field0796.field_1724.method_18799(field0796.field_1724.method_18798().method_1019(var14));
                     }
                  }
               }
            }
         }
      }
   }

   public enum Mode implements DisplayNamed {
      field0688("HolyWorld", 0.038999981389667725),
      field0112("Custom", 0.038999981389667725);

      private final String field1504;
      private final double field0956;

      Mode(String var3, double var4) {
         this.field1504 = var3;
         this.field0956 = var4;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }
}
