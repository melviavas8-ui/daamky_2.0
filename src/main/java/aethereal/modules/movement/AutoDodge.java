package aethereal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1665;
import net.minecraft.class_1667;
import net.minecraft.class_1685;
import net.minecraft.class_1686;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1844;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4081;
import net.minecraft.class_9334;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;

public class AutoDodge extends Module {
   private final MultiSelectSetting field0089 = new MultiSelectSetting(
         "autododge.types",
         new BooleanSetting("autododge.types.debuffs", true)
            .method1007("Debuffs")
            .method0210("Dodge debuff potions")
            .method2130("Уклоняться от зелий с дебаффами"),
         new BooleanSetting("autododge.types.arrows", true).method1007("Arrows").method0210("Dodge arrows").method2130("Уклоняться от стрел"),
         new BooleanSetting("autododge.types.tridents", false).method1007("Tridents").method0210("Dodge tridents").method2130("Уклоняться от трезубцев")
      )
      .method1007("Dodge Types")
      .method0210("What projectiles to dodge")
      .method2130("От чего уклоняться");
   private boolean field1527;
   private float field0957;
   private boolean field0219;

   public AutoDodge() {
      super("AutoDodge", ModuleCategory.field0088, "Automatically dodges incoming projectiles");
      this.method1013("Автоматически уклоняется от плохих штучек");
   }

   @EventHandler
   private void onPlayerTick(PlayerTickEvent var1) {
      if (!method1974()) {
         this.field1527 = false;
         this.field0219 = false;
         if (this.field0089.method0730(0)) {
            this.method1735();
         }

         if (this.field0089.method0730(1)) {
            this.method0977(class_1667.class);
         }

         if (this.field0089.method0730(2)) {
            this.method0977(class_1685.class);
         }
      }
   }

   @EventHandler
   private void onKeyboard(KeyboardEvent var1) {
      if (!method1974() && this.field1527) {
         this.method0885(var1);
         if (this.field0219 && field0796.field_1724.method_24828()) {
            var1.method0345(true);
         }
      }
   }

   private void method1735() {
      List var1 = StreamSupport.<class_1297>stream(field0796.field_1687.method_18112().spliterator(), false)
         .filter(class_1686.class::isInstance)
         .map(class_1686.class::cast)
         .filter(var0 -> var0.method_24921() != field0796.field_1724)
         .filter(this::method1203)
         .toList();
      if (!var1.isEmpty()) {
         for (class_1686 var3 : var1) {
            class_243 var4 = this.method1145(var3, var3.method_18798());
            float var5 = var3.method_7495().method_31574(class_1802.field_8150) ? 4.0F : 5.0F;
            double var6 = field0796.field_1724.method_19538().method_1022(var4);
            if (var6 <= var5) {
               class_243 var8 = field0796.field_1724.method_19538();
               class_243 var9 = var4.method_1020(var8).method_1029();
               this.field0957 = (float)class_3532.method_15338(Math.toDegrees(Math.atan2(var9.field_1350, var9.field_1352)) - 90.0) + 180.0F;
               this.field1527 = true;
               this.field0219 = this.method1692();
               break;
            }
         }
      }
   }

   private <T extends class_1297> void method0977(Class<T> var1) {
      if (!this.field1527) {
         List var2 = StreamSupport.<class_1297>stream(field0796.field_1687.method_18112().spliterator(), false)
            .filter(var1::isInstance)
            .map(var1::cast)
            .toList();
         if (!var2.isEmpty()) {
            class_243 var3 = field0796.field_1724.method_19538();
            List var4 = new ArrayList<>();

            for (class_1297 var6 : var2) {
               if ((!(var6 instanceof class_1665 var7) || var7.method_24921() != field0796.field_1724)
                  && !(var6.method_18798().method_1027() < 0.010000000583934252)) {
                  class_243 var15 = var6.method_18798();
                  class_243 var8 = var6.method_19538();

                  for (int var9 = 0; var9 < 100; var9++) {
                     class_243 var10 = var8;
                     var8 = var8.method_1019(var15);
                     var15 = this.method1322(var15, var6);
                     class_3965 var11 = field0796.field_1687.method_17742(new class_3959(var10, var8, class_3960.field_17558, class_242.field_1348, var6));
                     if (var11.method_17783() != class_240.field_1333) {
                        var8 = var11.method_17784();
                        break;
                     }

                     if (var8.field_1351 <= field0796.field_1687.method_31607()) {
                        break;
                     }

                     class_243 var12 = this.method1337(var10, var8, var3);
                     double var13 = var3.method_1022(var12);
                     if (var13 <= 2.0) {
                        var4.add(new AutoDodge.ThreatPath(var10, var8, var13));
                        break;
                     }
                  }
               }
            }

            if (!var4.isEmpty()) {
               this.field0957 = this.method1321(var3, var4);
               this.field1527 = true;
               this.field0219 = this.method1692();
            }
         }
      }
   }

   private float method1321(class_243 var1, List<AutoDodge.ThreatPath> var2) {
      if (var2.size() == 1) {
         AutoDodge.ThreatPath var16 = var2.get(0);
         class_243 var4 = var16.end.method_1020(var16.start).method_1029();
         class_243 var17 = new class_243(-var4.field_1350, 0.0, var4.field_1352).method_1029();
         double var18 = this.method0293(var16.start, var16.end, var1.method_1019(var17.method_1021(1.0)));
         double var8 = this.method0293(var16.start, var16.end, var1.method_1020(var17.method_1021(1.0)));
         class_243 var19 = var18 > var8 ? var17 : var17.method_1021(-1.0);
         return (float)class_3532.method_15338(Math.toDegrees(Math.atan2(var19.field_1350, var19.field_1352)) - 90.0);
      }

      double var3 = Double.NEGATIVE_INFINITY;
      float var5 = 0.0F;

      for (int var6 = 0; var6 < 360; var6 += 15) {
         double var7 = Math.toRadians(var6);
         class_243 var9 = var1.method_1019(new class_243(Math.cos(var7), 0.0, Math.sin(var7)).method_1021(0.80000015285335));
         double var10 = 0.0;

         for (AutoDodge.ThreatPath var13 : var2) {
            double var14 = this.method0293(var13.start, var13.end, var9);
            var10 += var14 / (var13.distance + 0.10000000116491012);
         }

         if (var10 > var3) {
            var3 = var10;
            var5 = var6;
         }
      }

      return var5;
   }

   private class_243 method1145(class_1297 var1, class_243 var2) {
      class_243 var3 = var1.method_19538();

      for (int var4 = 0; var4 < 200; var4++) {
         class_243 var5 = var3;
         var3 = var3.method_1019(var2);
         var2 = this.method1322(var2, var1);
         class_3965 var6 = field0796.field_1687.method_17742(new class_3959(var5, var3, class_3960.field_17558, class_242.field_1348, var1));
         if (var6.method_17783() != class_240.field_1333) {
            return var6.method_17784();
         }

         if (var3.field_1351 <= field0796.field_1687.method_31607()) {
            break;
         }
      }

      return var3;
   }

   private class_243 method1322(class_243 var1, class_1297 var2) {
      double var3 = var2.method_5799() ? 0.80000015285335 : 0.9900000193145464;
      return var1.method_1021(var3).method_1023(0.0, 0.04999999500158768, 0.0);
   }

   private class_243 method1337(class_243 var1, class_243 var2, class_243 var3) {
      class_243 var4 = var2.method_1020(var1);
      double var5 = var4.method_1027();
      if (var5 == 0.0) {
         return var1;
      }

      double var7 = class_3532.method_15350(var3.method_1020(var1).method_1026(var4) / var5, 0.0, 1.0);
      return var1.method_1019(var4.method_1021(var7));
   }

   private double method0293(class_243 var1, class_243 var2, class_243 var3) {
      return var3.method_1022(this.method1337(var1, var2, var3));
   }

   private boolean method1203(class_1686 var1) {
      class_1799 var2 = var1.method_7495();
      if (!var2.method_31574(class_1802.field_8436) && !var2.method_31574(class_1802.field_8150)) {
         return false;
      }

      class_1844 var3 = (class_1844)var2.method_57824(class_9334.field_49651);
      if (var3 == null) {
         return false;
      }

      float var4 = 0.0F;

      for (class_1293 var6 : var3.method_57397()) {
         class_4081 var7 = ((class_1291)var6.method_5579().comp_349()).method_18792();
         int var8 = var6.method_5578() + 1;
         if (var7 == class_4081.field_18271) {
            var4 += var8;
         } else if (var7 == class_4081.field_18272) {
            var4 -= var8 * (method1124(var6) ? 2.0F : 1.0F);
         }
      }

      return var4 < 0.0F;
   }

   private static boolean method1124(class_1293 var0) {
      class_1291 var1 = (class_1291)var0.method_5579().comp_349();
      return var1 == class_1294.field_5920.comp_349()
         || var1 == class_1294.field_5921.comp_349()
         || var1 == class_1294.field_5899.comp_349()
         || var1 == class_1294.field_5902.comp_349();
   }

   private boolean method1692() {
      if (field0796.field_1724.method_6059(class_1294.field_5904)) {
         int var1 = field0796.field_1724.method_6112(class_1294.field_5904).method_5578();
         if (var1 < 1) {
            return true;
         }
      }

      if (field0796.field_1724.method_6059(class_1294.field_5909)) {
         int var2 = field0796.field_1724.method_6112(class_1294.field_5909).method_5578();
         if (var2 > 2) {
            return true;
         }
      }

      return false;
   }

   private void method0885(KeyboardEvent var1) {
      float var2 = 0.0F;
      float var3 = 0.0F;
      float var4 = Float.MAX_VALUE;

      for (float var5 = -1.0F; var5 <= 1.0F; var5++) {
         for (float var6 = -1.0F; var6 <= 1.0F; var6++) {
            if (var5 != 0.0F || var6 != 0.0F) {
               float var7 = this.method0681(field0796.field_1724.method_36454(), var5, var6);
               float var8 = Math.abs(class_3532.method_15393(var7 - this.field0957));
               if (var8 < var4) {
                  var4 = var8;
                  var2 = var5;
                  var3 = var6;
               }
            }
         }
      }

      var1.method0665(var2);
      var1.method0124(var3);
   }

   private float method0681(float var1, float var2, float var3) {
      if (var2 < 0.0F) {
         var1 += 180.0F;
      }

      float var4 = 1.0F;
      if (var2 < 0.0F) {
         var4 = -0.5F;
      } else if (var2 > 0.0F) {
         var4 = 0.5F;
      }

      if (var3 > 0.0F) {
         var1 -= 90.0F * var4;
      }

      if (var3 < 0.0F) {
         var1 += 90.0F * var4;
      }

      return class_3532.method_15393(var1);
   }

   private record ThreatPath(class_243 start, class_243 end, double distance) {
      public class_243 method0569() {
         return this.start;
      }

      public class_243 method0024() {
         return this.end;
      }

      public double method2046() {
         return this.distance;
      }
   }
}
