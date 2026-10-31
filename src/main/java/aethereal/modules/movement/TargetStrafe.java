package aethereal;

import java.util.Arrays;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_243;

public class TargetStrafe extends Module {
   private final EnumSetting<TargetStrafe.Mode> field0058 = new EnumSetting<>("targetstrafe.mode", TargetStrafe.Mode.field0703)
      .method1007("Mode")
      .method0210("Strafe movement algorithm")
      .method2130("Алгоритм движения стрейфа");
   private final EnumSetting<TargetStrafe.ActivationMode> field1448 = new EnumSetting<>(
         "targetstrafe.grimpoint", TargetStrafe.ActivationMode.field0704, () -> this.field0058.method0492() == TargetStrafe.Mode.field0127
      )
      .method1007("Grim Point")
      .method0210("Path shape for Grim mode strafing")
      .method2130("Форма пути для стрейфа в режиме Grim");
   private final EnumSetting<TargetStrafe.ActivationMode> field0984 = new EnumSetting<>(
         "targetstrafe.matrixpoint", TargetStrafe.ActivationMode.field1496, () -> this.field0058.method0492() == TargetStrafe.Mode.field0703
      )
      .method1007("Matrix Point")
      .method0210("Path shape for Matrix mode strafing")
      .method2130("Форма пути для стрейфа в режиме Matrix");
   private final EnumSetting<TargetStrafe.Direction> field0189 = new EnumSetting<>("targetstrafe.direction", TargetStrafe.Direction.field0702)
      .method1007("Direction")
      .method0210("Strafe rotation direction around target")
      .method2130("Направление вращения стрейфа вокруг цели");
   private final FloatSetting field0470 = new FloatSetting(
         "targetstrafe.grimradius", 0.87F, 0.1F, 1.5F, 0.01F, () -> this.field0058.method0492() == TargetStrafe.Mode.field0127
      )
      .method1007("Grim Radius")
      .method0210("Strafe distance from target in Grim mode")
      .method2130("Дистанция стрейфа от цели в режиме Grim");
   private final FloatSetting field1627 = new FloatSetting(
         "targetstrafe.radius", 2.5F, 0.1F, 7.0F, 0.01F, () -> this.field0058.method0492() == TargetStrafe.Mode.field0703
      )
      .method1007("Radius")
      .method0210("Strafe distance from target in Matrix mode")
      .method2130("Дистанция стрейфа от цели в режиме Matrix");
   private final FloatSetting field1553 = new FloatSetting(
         "targetstrafe.speed", 0.3F, 0.1F, 1.0F, 0.01F, () -> this.field0058.method0492() == TargetStrafe.Mode.field0703
      )
      .method1007("Speed")
      .method0210("Movement speed while strafing")
      .method2130("Скорость движения при стрейфе");
   private final MultiSelectSetting field1723 = new MultiSelectSetting(
         "targetstrafe.options", Arrays.asList("Auto Jump", "Only Key Pressed", "In front of the target", "Direction Mode"), false, () -> true
      )
      .method1007("Options")
      .method0210("Additional strafe behavior toggles")
      .method2130("Дополнительные настройки поведения стрейфа");
   private int field1137;

   public TargetStrafe() {
      super("TargetStrafe", ModuleCategory.field0088, "Strafes around the current target");
      this.method1013("Стрейфит вокруг текущей цели");
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         class_1309 var2 = this.method1753();
         if (var2 != null && var2.method_5805()) {
            if (this.field0058.method0492() == TargetStrafe.Mode.field0703) {
               if (!this.method2135("Only Key Pressed") || this.method1692()) {
                  class_243 var3 = field0796.field_1724.method_19538();
                  class_243 var4 = var2.method_19538();
                  double var5 = this.field1627.method0492().floatValue();
                  if (this.method2135("Auto Jump") && field0796.field_1724.method_24828()) {
                     field0796.field_1724.method_6043();
                  }

                  int var7 = this.method1698();
                  if (this.method2135("In front of the target")) {
                     float var19 = var2.method_36454();
                     double var20 = var4.field_1352 - Math.sin(Math.toRadians(var19)) * var5 * var7;
                     double var22 = var4.field_1350 + Math.cos(Math.toRadians(var19)) * var5 * var7;
                     float var13 = (float)Math.toDegrees(Math.atan2(var22 - var3.field_1350, var20 - var3.field_1352)) - 90.0F;
                     double var24 = this.field1553.method0492().floatValue();
                     field0796.field_1724
                        .method_18800(
                           -Math.sin(Math.toRadians(var13)) * var24, field0796.field_1724.method_18798().field_1351, Math.cos(Math.toRadians(var13)) * var24
                        );
                  } else {
                     if (this.field0984.method0492() == TargetStrafe.ActivationMode.field0704) {
                        class_243[] var8 = new class_243[]{
                           new class_243(var4.field_1352 - var5, var3.field_1351, var4.field_1350 - var5),
                           new class_243(var4.field_1352 - var5, var3.field_1351, var4.field_1350 + var5),
                           new class_243(var4.field_1352 + var5, var3.field_1351, var4.field_1350 + var5),
                           new class_243(var4.field_1352 + var5, var3.field_1351, var4.field_1350 - var5)
                        };
                        if (var3.method_1022(var8[this.field1137]) < 0.5) {
                           this.field1137 = (this.field1137 + var7 + var8.length) % var8.length;
                        }

                        class_243 var9 = var8[this.field1137];
                        class_243 var10 = var9.method_1020(var3).method_1029();
                        float var11 = (float)Math.toDegrees(Math.atan2(var10.field_1350, var10.field_1352)) - 90.0F;
                        double var12 = this.field1553.method0492().floatValue();
                        field0796.field_1724
                           .method_18800(
                              -Math.sin(Math.toRadians(var11)) * var12, field0796.field_1724.method_18798().field_1351, Math.cos(Math.toRadians(var11)) * var12
                           );
                     } else {
                        double var17 = Math.atan2(var3.field_1350 - var4.field_1350, var3.field_1352 - var4.field_1352);
                        var17 += var7 * this.field1553.method0492() / Math.max(var3.method_1022(var4), var5);
                        double var21 = var4.field_1352 + var5 * Math.cos(var17);
                        double var23 = var4.field_1350 + var5 * Math.sin(var17);
                        float var14 = (float)Math.toDegrees(Math.atan2(var23 - var3.field_1350, var21 - var3.field_1352)) - 90.0F;
                        double var15 = this.field1553.method0492().floatValue();
                        field0796.field_1724
                           .method_18800(
                              -Math.sin(Math.toRadians(var14)) * var15, field0796.field_1724.method_18798().field_1351, Math.cos(Math.toRadians(var14)) * var15
                           );
                     }
                  }
               }
            }
         }
      }
   }

   @Override
   public void method0025() {
      this.field1137 = 0;
      super.method0025();
   }

   private boolean method2135(String var1) {
      BooleanSetting var2 = this.field1723.method0439(var1);
      return var2 != null && var2.method0492();
   }

   private int method1698() {
      return switch ((TargetStrafe.Direction)this.field0189.method0492()) {
         case field0126 -> -1;
         case field1495 -> System.currentTimeMillis() / 3000L % 2L == 0L ? 1 : -1;
         default -> 1;
      };
   }

   private boolean method1692() {
      return field0796.field_1690.field_1894.method_1434()
         || field0796.field_1690.field_1881.method_1434()
         || field0796.field_1690.field_1913.method_1434()
         || field0796.field_1690.field_1849.method_1434();
   }

   private class_1309 method1753() {
      if (field0796.field_1724 != null && field0796.field_1687 != null) {
         class_1309 var1 = null;
         double var2 = 1.7976922776554316E308;
         double var4 = this.field1627.method0492().floatValue() * 2.0;

         for (class_1297 var7 : field0796.field_1687.method_18112()) {
            if (var7 instanceof class_1309 var8
               && var8 != field0796.field_1724
               && var8.method_5805()
               && !(var8 instanceof class_1657 var9 && var9.method_7337())) {
               double var11 = field0796.field_1724.method_5858(var8);
               if (!(var11 > var4 * var4) && var11 < var2) {
                  var2 = var11;
                  var1 = var8;
               }
            }
         }

         return var1;
      } else {
         return null;
      }
   }

   public enum Direction implements DisplayNamed {
      field0702("Clockwise"),
      field0126("Counterclockwise"),
      field1495("Random");

      private final String field1030;

      Direction(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }

   public enum Mode implements DisplayNamed {
      field0703("Matrix"),
      field0127("Grim");

      private final String field1504;

      Mode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }

   public enum ActivationMode implements DisplayNamed {
      field0704("Cube"),
      field0128("Center"),
      field1496("Circle");

      private final String field1030;

      ActivationMode(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }
}
