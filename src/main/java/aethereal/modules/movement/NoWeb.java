package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public class NoWeb extends Module {
   private final EnumSetting<NoWeb.Mode> field0058 = new EnumSetting<>("noweb.mode", NoWeb.Mode.field0668)
      .method1007("Mode")
      .method0210("Cobweb bypass method")
      .method2130("Метод обхода паутины");

   public NoWeb() {
      super("NoWeb", ModuleCategory.field0088, "Removes cobweb slowdown effect");
      this.method1013("Убирает замедление от паутины");
   }

   @EventHandler
   private void onPlayerTick(PlayerTickEvent var1) {
      if (!method1974()) {
         switch ((NoWeb.Mode)this.field0058.method0492()) {
            case field0668:
               this.method1735();
               break;
            case field0096:
               this.method1691();
         }
      }
   }

   private void method1735() {
      boolean var1 = false;
      class_238 var2 = field0796.field_1724.method_5829();

      for (class_2338 var4 : class_2338.method_10094(
         class_3532.method_15357(var2.field_1323),
         class_3532.method_15357(var2.field_1322),
         class_3532.method_15357(var2.field_1321),
         class_3532.method_15357(var2.field_1320),
         class_3532.method_15357(var2.field_1325),
         class_3532.method_15357(var2.field_1324)
      )) {
         if (field0796.field_1687.method_8320(var4).method_27852(class_2246.field_10343)) {
            var1 = true;
         }
      }

      if (var1) {
         class_243 var11 = field0796.field_1724.method_18798();
         float var12 = field0796.field_1724.method_36454();
         double var5 = 0.0;
         double var7 = 0.0;
         if (field0796.field_1724.field_3913.field_54155.comp_3159()) {
            var5++;
         }

         if (field0796.field_1724.field_3913.field_54155.comp_3160()) {
            var5--;
         }

         if (field0796.field_1724.field_3913.field_54155.comp_3161()) {
            var7++;
         }

         if (field0796.field_1724.field_3913.field_54155.comp_3162()) {
            var7--;
         }

         if (var5 != 0.0 || var7 != 0.0) {
            if (var5 != 0.0) {
               if (var7 > 0.0) {
                  var12 += var5 > 0.0 ? -45 : 45;
               } else if (var7 < 0.0) {
                  var12 += var5 > 0.0 ? 45 : -45;
               }

               var7 = 0.0;
               if (var5 > 0.0) {
                  var5 = 1.0;
               } else {
                  var5 = -1.0;
               }
            }

            double var9 = Math.toDegrees(Math.atan2(var7, var5)) + var12;
            var12 = (float)((var9 % 360.0 + 360.0) % 360.0);
         }

         float var13 = 0.63F;
         if ((!(var12 >= 313.0F) || !(var12 <= 317.0F))
            && (!(var12 >= 223.0F) || !(var12 <= 227.0F))
            && (!(var12 >= 133.0F) || !(var12 <= 137.0F))
            && (!(var12 >= 43.0F) || !(var12 <= 47.0F))) {
            if ((!(var12 >= 311.0F) || !(var12 <= 319.0F))
               && (!(var12 >= 221.0F) || !(var12 <= 229.0F))
               && (!(var12 >= 131.0F) || !(var12 <= 139.0F))
               && (!(var12 >= 41.0F) || !(var12 <= 49.0F))) {
               if ((!(var12 >= 310.8F) || !(var12 <= 320.8F))
                  && (!(var12 >= 220.8F) || !(var12 <= 230.8F))
                  && (!(var12 >= 130.8F) || !(var12 <= 140.8F))
                  && (!(var12 >= 40.8F) || !(var12 <= 50.8F))) {
                  if ((!(var12 >= 308.7F) || !(var12 <= 322.7F))
                     && (!(var12 >= 218.7F) || !(var12 <= 232.7F))
                     && (!(var12 >= 128.7F) || !(var12 <= 142.7F))
                     && (!(var12 >= 38.7F) || !(var12 <= 52.7F))) {
                     if ((!(var12 >= 306.5F) || !(var12 <= 324.5F))
                        && (!(var12 >= 216.5F) || !(var12 <= 234.5F))
                        && (!(var12 >= 126.5F) || !(var12 <= 144.5F))
                        && (!(var12 >= 36.5F) || !(var12 <= 54.5F))) {
                        if (var12 >= 304.0F && var12 <= 327.0F
                           || var12 >= 214.0F && var12 <= 237.0F
                           || var12 >= 124.0F && var12 <= 147.0F
                           || var12 >= 34.0F && var12 <= 57.0F) {
                           var13 = 0.75F;
                        }
                     } else {
                        var13 = 0.79F;
                     }
                  } else {
                     var13 = 0.81F;
                  }
               } else {
                  var13 = 0.83F;
               }
            } else {
               var13 = 0.85F;
            }
         } else {
            var13 = 0.88F;
         }

         if (!field0796.field_1690.field_1903.method_1434()) {
            if (field0796.field_1690.field_1832.method_1434()) {
               field0796.field_1724.method_18800(var11.field_1352, -2.2000002384518895, var11.field_1350);
            } else {
               field0796.field_1724.method_18800(var11.field_1352, 0.0, var11.field_1350);
            }
         } else {
            field0796.field_1724.method_18800(var11.field_1352, var5 == 0.0 && var7 == 0.0 ? 1.2999995544940248 : 1.1500003137405002, var11.field_1350);
         }

         MovementHelper.method0103(var13);
      }
   }

   private void method1691() {
      if (this.method1755()) {
         class_243 var1 = field0796.field_1724.method_18798();
         field0796.field_1724.method_18800(var1.field_1352, 0.0, var1.field_1350);
         if (field0796.field_1690.field_1903.method_1434()) {
            field0796.field_1724.method_18800(var1.field_1352, 0.8999997774799112, var1.field_1350);
         }

         if (field0796.field_1690.field_1832.method_1434()) {
            field0796.field_1724.method_18800(var1.field_1352, -0.8999997767629463, var1.field_1350);
         }

         this.method0611(0.21000000378358322);
      }
   }

   private boolean method1755() {
      class_238 var1 = field0796.field_1724.method_5829();

      for (class_2338 var3 : class_2338.method_10094(
         class_3532.method_15357(var1.field_1323),
         class_3532.method_15357(var1.field_1322),
         class_3532.method_15357(var1.field_1321),
         class_3532.method_15357(var1.field_1320),
         class_3532.method_15357(var1.field_1325),
         class_3532.method_15357(var1.field_1324)
      )) {
         if (field0796.field_1687.method_8320(var3).method_27852(class_2246.field_10343)) {
            return true;
         }
      }

      return false;
   }

   private void method0611(double var1) {
      float var3 = field0796.field_1724.method_36454();
      float var4 = 0.0F;
      float var5 = 0.0F;
      if (field0796.field_1690.field_1894.method_1434()) {
         var4++;
      }

      if (field0796.field_1690.field_1881.method_1434()) {
         var4--;
      }

      if (field0796.field_1690.field_1913.method_1434()) {
         var5++;
      }

      if (field0796.field_1690.field_1849.method_1434()) {
         var5--;
      }

      if (var4 != 0.0F || var5 != 0.0F) {
         double var6 = var4 * var4 + var5 * var5;
         if (var6 > 1.0) {
            double var8 = Math.sqrt(var6);
            var4 /= (float)var8;
            var5 /= (float)var8;
         }

         double var19 = Math.toRadians(var3);
         double var10 = Math.sin(var19);
         double var12 = Math.cos(var19);
         double var14 = (var5 * var12 - var4 * var10) * var1;
         double var16 = (var4 * var12 + var5 * var10) * var1;
         class_243 var18 = field0796.field_1724.method_18798();
         field0796.field_1724.method_18800(var14, var18.field_1351, var16);
      }
   }

   public enum Mode implements DisplayNamed {
      field0668("Default"),
      field0096("ReallyWorld");

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
