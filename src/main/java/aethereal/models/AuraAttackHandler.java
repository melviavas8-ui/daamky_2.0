package aethereal;

import net.minecraft.class_1268;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1675;
import net.minecraft.class_1799;
import net.minecraft.class_1829;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2846;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_640;
import net.minecraft.class_9334;
import net.minecraft.class_2338.class_2339;
import net.minecraft.class_239.class_240;
import net.minecraft.class_2846.class_2847;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;

public class AuraAttackHandler {
   private static final float field0566 = 0.15F;
   private final AuraAttackHandler.AttackState field0082 = new AuraAttackHandler.AttackState();
   private long field1412 = 0L;
   private boolean field1049 = false;
   private long field0760 = 0L;

   public void method0578() {
      this.field1412 = 0L;
      this.field1049 = false;
      this.field0760 = 0L;
      this.field0082.method2078();
   }

   public AuraAttackHandler.AttackState method0013() {
      return this.field0082;
   }

   public void method1167(class_1309 var1, Aura var2) {
      class_310 var3 = class_310.method_1551();
      if (var3.field_1724 != null && var3.field_1687 != null && var1 != null) {
         class_243 var4 = this.method0239(var1);
         float var5 = Math.max(0.5F, var2.method2018() - 0.15F);
         if (!(var3.field_1724.method_33571().method_1022(this.method1170(var1, var4)) > var5)) {
            if (!this.method1162(var1, var5)) {
               if (this.method1662(var1, var2)) {
                  this.method1172(var1, var4, var2);
                  if (this.method0244(var1, var2)) {
                     if (!this.method1853(var1, var2)) {
                        if (RaycastHelper.method0643(var2.method2018(), var1.method_5829())) {
                           if (var3.field_1724.method_6039() && var2.method2274().method0387("Always Shield")) {
                              var3.field_1761.method_2897(var3.field_1724);
                           }

                           NeuralRotationStrategy.method0025();
                           var3.field_1761.method_2918(var3.field_1724, var1);
                           var3.field_1724.method_6104(class_1268.field_5808);
                           this.field0082.method0778(500L);
                        }
                     }
                  }
               }
            }
         }
      }
   }

   public boolean method0244(class_1309 var1, Aura var2) {
      class_310 var3 = class_310.method_1551();
      if (var3.field_1724 == null) {
         return false;
      } else if (!this.field0082.method0579()) {
         return false;
      } else if (var2.method2274().method0387("No Attack When Eat") && this.method1974()) {
         return false;
      } else if (var2.method2274().method0387("Break Shield") && var1 instanceof class_1657 var4 && this.method1183(var4)) {
         return true;
      } else {
         boolean var6 = var2.method2274().method0387("Only Critical");
         boolean var5 = var2.method2270().method1938();
         if (!var3.field_1690.field_1903.method_1434() && var3.field_1724.method_24828() && var6 && var5) {
            return true;
         } else {
            return !var3.field_1690.field_1903.method_1434() && this.method0431() ? true : this.method1813() || !var6;
         }
      }
   }

   private boolean method1183(class_1657 var1) {
      if (var1.method_6039() && this.method1159(var1)) {
         int var2 = InventoryManager.method1567(true);
         int var3 = InventoryManager.method1567(false);
         if (var2 == -1 && var3 != -1) {
            return this.method1026("Inventory", var2, var3, var1);
         }

         if (var2 != -1) {
            this.method1026("Hotbar", var2, var3, var1);
         }

         return false;
      } else {
         return false;
      }
   }

   private boolean method1026(String var1, int var2, int var3, class_1657 var4) {
      class_310 var5 = class_310.method_1551();
      int var6 = var5.field_1724.method_31548().field_7545;
      switch (var1) {
         case "Hotbar":
            InventoryManager.method0143(var2);
            NeuralRotationStrategy.method0025();
            var5.field_1761.method_2918(var5.field_1724, var4);
            var5.field_1724.method_6104(class_1268.field_5808);
            InventoryManager.method0143(var6);
            return true;
         case "Inventory":
            int var9 = this.method2048();
            if (var9 == -1) {
               return false;
            }

            InventoryManager.method0809(InventoryManager.ClickAction.field0047, var3, var9);
            InventoryManager.method0143(var9);
            NeuralRotationStrategy.method0025();
            var5.field_1761.method_2918(var5.field_1724, var4);
            var5.field_1724.method_6104(class_1268.field_5808);
            InventoryManager.method0809(InventoryManager.ClickAction.field0047, var3, var9);
            InventoryManager.method0143(var6);
            return true;
         default:
            return false;
      }
   }

   private int method2048() {
      class_310 var1 = class_310.method_1551();
      if (var1.field_1724 == null) {
         return -1;
      }

      int var2 = var1.field_1724.method_31548().field_7545;

      for (int var3 = 0; var3 < 9; var3++) {
         class_1799 var4 = (class_1799)var1.field_1724.method_31548().field_7547.get(var3);
         if (var4.method_7960() && var2 != var3) {
            return var3;
         }
      }

      for (int var5 = 0; var5 < 9; var5++) {
         class_1799 var6 = (class_1799)var1.field_1724.method_31548().field_7547.get(var5);
         if (!(var6.method_7909() instanceof class_1829) && var2 != var5) {
            return var5;
         }
      }

      return -1;
   }

   private boolean method1159(class_1309 var1) {
      class_310 var2 = class_310.method_1551();
      if (var2.field_1724 == null) {
         return false;
      }

      class_243 var3 = var1.method_5828(1.0F).method_1029();
      class_243 var4 = var2.field_1724.method_33571().method_1020(var1.method_33571()).method_1029();
      double var5 = var3.method_1026(var4);
      double var7 = Math.toDegrees(Math.acos(var5));
      return var7 < 100.0;
   }

   private boolean method1853(class_1309 var1, Aura var2) {
      class_310 var3 = class_310.method_1551();
      if (var3.field_1724 == null) {
         return false;
      }

      if (!var2.method2274().method0387("Raytrace")) {
         return false;
      }

      if (var3.field_1724.method_6128()) {
         return false;
      }

      boolean var4 = var2.method2274().method0387("Ignore The Walls");
      Rotation var5 = RotationManager.field0618.method0545();
      class_3966 var6 = this.method0641(var2.method2018(), var5, var4);
      class_1297 var7 = var6 != null ? var6.method_17782() : null;
      return var7 != var1;
   }

   private class_3966 method0641(double var1, Rotation var3, boolean var4) {
      class_310 var5 = class_310.method_1551();
      class_1297 var6 = var5.method_1560();
      if (var6 != null && var5.field_1687 != null) {
         class_243 var7 = var6.method_33571();
         class_243 var8 = var3.method0024();
         class_243 var9 = var7.method_1031(var8.field_1352 * var1, var8.field_1351 * var1, var8.field_1350 * var1);
         class_238 var10 = var6.method_5829().method_18804(var8.method_1021(var1)).method_1009(1.0, 1.0, 1.0);
         class_3966 var11 = class_1675.method_18075(
            var6, var7, var9, var10, var0 -> var0.method_5863() && var0.method_5805() && !var0.method_7325(), var1 * var1
         );
         if (var11 == null) {
            return null;
         }

         if (var4) {
            return var11;
         }

         class_243 var12 = var11.method_17782().method_5829().method_992(var7, var9).orElse(var11.method_17782().method_19538());
         class_3965 var13 = var5.field_1687.method_17742(new class_3959(var7, var12, class_3960.field_17558, class_242.field_1347, var5.field_1724));
         if (var13 != null && var13.method_17783() == class_240.field_1332) {
            class_2680 var14 = var5.field_1687.method_8320(var13.method_17777());
            if (var14 == null) {
               return var11;
            }

            if (var14.method_26220(var5.field_1687, var13.method_17777()).method_1110()) {
               return var11;
            }

            class_243 var15 = var13.method_17784();
            return var15.method_1025(var7) < var12.method_1025(var7) ? null : var11;
         } else {
            return var11;
         }
      } else {
         return null;
      }
   }

   public boolean method2147(class_1309 var1, Aura var2) {
      class_310 var3 = class_310.method_1551();
      if (var3.field_1724 != null && var3.field_1687 != null && var1 != null && var1.method_5805()) {
         if (!var2.method2274().method0387("Only Critical")) {
            return false;
         } else if (var3.field_1724.method_5799() || var3.field_1724.method_5681()) {
            return false;
         } else {
            return var3.field_1724.method_24828() && var2.method2270().method1938() && !var3.field_1690.field_1903.method_1434()
               ? false
               : this.method1635() || this.field0082.method0026();
         }
      } else {
         return false;
      }
   }

   private boolean method1813() {
      class_310 var1 = class_310.method_1551();
      if (var1.field_1724 == null) {
         return false;
      }

      if (var1.field_1724.method_6059(class_1294.field_5906)) {
         return true;
      }

      double var2 = var1.field_1724.field_6036 - var1.field_1724.method_23318();
      return !var1.field_1724.method_24828()
         && var1.field_1724.field_6017 > 0.0F
         && var2 != 0.12160005034901644
         && var2 != 0.376630501964911
         && var2 != 0.3043168740282738
         && var2 != 0.3739040662872384;
   }

   private boolean method1635() {
      class_310 var1 = class_310.method_1551();
      return var1.field_1724 != null && var1.field_1687 != null
         ? var1.field_1724.method_6101()
            || this.method0376()
            || var1.field_1724.method_5771()
            || var1.field_1724.method_6059(class_1294.field_5919)
            || var1.field_1724.method_6059(class_1294.field_5902)
            || var1.field_1724.method_6059(class_1294.field_5906)
            || var1.field_1724.method_5765()
            || var1.field_1687.method_8320(var1.field_1724.method_24515()).method_27852(class_2246.field_10343)
            || !var1.field_1724.method_24828() && var1.field_1724.field_6017 > 0.0F
         : false;
   }

   private boolean method1662(class_1309 var1, Aura var2) {
      class_310 var3 = class_310.method_1551();
      long var4 = System.currentTimeMillis();
      boolean var6 = this.method0244(var1, var2);
      if (!var6) {
         this.field1049 = false;
         return false;
      }

      if (var3.field_1724 != null && !var3.field_1724.method_24828() && var3.field_1724.field_6017 > 0.0F && var2.method2274().method0387("Only Critical")) {
         this.field1049 = false;
         return true;
      }

      if (!this.field1049) {
         this.field1049 = true;
         this.field1412 = var4 + this.method0791(var2);
      }

      return var4 >= this.field1412;
   }

   private long method0791(Aura var1) {
      if (!var1.method2276().method1938()) {
         return 0L;
      }

      int var2 = var1.method1922().method0492().intValue();
      int var3 = var1.method1920().method0492().intValue();
      return var3 <= var2 ? var2 : MathHelper.method2105(var2, var3);
   }

   private void method1172(class_1309 var1, class_243 var2, Aura var3) {
      class_310 var4 = class_310.method_1551();
      if (var4.field_1724 != null && var4.field_1687 != null && var1 != null) {
         if (var3.method1926().method1938()) {
            if (var3.method2274().method0387("Ignore The Walls")) {
               long var5 = System.currentTimeMillis();
               if (var5 - this.field0760 >= 150L) {
                  class_243 var7 = var4.field_1724.method_33571();
                  class_243 var8 = var2 != null ? var2 : var1.method_33571();
                  if (!this.method1330(var7, var8)) {
                     class_243 var9 = var8.method_1020(var7);
                     if (!(var9.method_1027() < 1.0000000367762732E-7)) {
                        class_243 var10 = var9.method_1029();
                        class_243 var11 = var7;
                        int var12 = 2;
                        boolean var13 = false;

                        for (int var14 = 0; var14 < var12; var14++) {
                           class_3965 var15 = var4.field_1687
                              .method_17742(new class_3959(var11, var8, class_3960.field_17558, class_242.field_1348, var4.field_1724));
                           if (var15 == null || var15.method_17783() != class_240.field_1332) {
                              break;
                           }

                           class_2338 var16 = var15.method_17777();
                           class_2350 var17 = var15.method_17780();
                           var4.field_1724.field_3944.method_52787(new class_2846(class_2847.field_12968, var16, var17));
                           var4.field_1724.field_3944.method_52787(new class_2846(class_2847.field_12973, var16, var17));
                           class_243 var18 = var15.method_17784();
                           var11 = var18.method_1019(var10.method_1021(0.049999994412217905));
                           var13 = true;
                           if (var11.method_1025(var8) < 0.002500000001937133) {
                              break;
                           }
                        }

                        if (var13) {
                           this.field0760 = var5;
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private boolean method1330(class_243 var1, class_243 var2) {
      class_310 var3 = class_310.method_1551();
      if (var3.field_1687 != null && var3.field_1724 != null) {
         class_3965 var4 = var3.field_1687.method_17742(new class_3959(var1, var2, class_3960.field_17558, class_242.field_1348, var3.field_1724));
         return var4 == null || var4.method_17783() == class_240.field_1333;
      } else {
         return true;
      }
   }

   private class_243 method0239(class_1309 var1) {
      class_310 var2 = class_310.method_1551();
      if (var1 != null && var2.field_1724 != null) {
         class_243 var3 = var2.field_1724.method_33571();
         class_238 var4 = var1.method_5829();
         return new class_243(
            class_3532.method_15350(var3.field_1352, var4.field_1323, var4.field_1320),
            class_3532.method_15350(var3.field_1351, var4.field_1322, var4.field_1325),
            class_3532.method_15350(var3.field_1350, var4.field_1321, var4.field_1324)
         );
      } else {
         return class_243.field_1353;
      }
   }

   private class_243 method1170(class_1309 var1, class_243 var2) {
      class_310 var3 = class_310.method_1551();
      if (var1 != null && var3.field_1724 != null && var2 != null) {
         class_238 var4 = var1.method_5829();
         class_243 var5 = var3.field_1724.method_5836(1.0F);
         class_243 var6 = new class_243(var4.field_1323, var4.field_1322, var4.field_1321);
         class_243 var7 = new class_243(var4.field_1320, var4.field_1325, var4.field_1324);
         double var8 = -1.7976922776554316E308;
         double var10 = 1.7976922776554316E308;
         class_243 var12 = var2.method_1020(var5);
         if (var12.method_1027() < 1.0000000367762732E-7) {
            return var2;
         }

         class_243 var13 = var12.method_1029();

         for (int var14 = 0; var14 < 3; var14++) {
            double var15;
            double var17;
            double var19;
            double var21;
            switch (var14) {
               case 0:
                  var15 = var13.field_1352;
                  var17 = var6.field_1352;
                  var19 = var7.field_1352;
                  var21 = var5.field_1352;
                  break;
               case 1:
                  var15 = var13.field_1351;
                  var17 = var6.field_1351;
                  var19 = var7.field_1351;
                  var21 = var5.field_1351;
                  break;
               case 2:
                  var15 = var13.field_1350;
                  var17 = var6.field_1350;
                  var19 = var7.field_1350;
                  var21 = var5.field_1350;
                  break;
               default:
                  continue;
            }

            if (Math.abs(var15) < 1.0000000367762732E-7) {
               if (var21 < var17 || var21 > var19) {
                  return var2;
               }
            } else {
               double var23 = (var17 - var21) / var15;
               double var25 = (var19 - var21) / var15;
               if (var23 > var25) {
                  double var27 = var23;
                  var23 = var25;
                  var25 = var27;
               }

               var8 = Math.max(var8, var23);
               var10 = Math.min(var10, var25);
               if (var8 > var10) {
                  return var2;
               }
            }
         }

         double var29 = var5.method_1022(var2);
         return !(var8 > var29) && !(var8 < 0.0) ? var5.method_1019(var13.method_1021(var8)) : var2;
      } else {
         return var2;
      }
   }

   private boolean method1162(class_1309 var1, float var2) {
      class_310 var3 = class_310.method_1551();
      if (var3.field_1724 == null) {
         return true;
      }

      class_243 var4 = new class_243(var1.method_23317() - var1.field_6014, var1.method_23318() - var1.field_6036, var1.method_23321() - var1.field_5969);
      int var5 = 50;

      try {
         class_640 var6 = var3.method_1562() == null ? null : var3.method_1562().method_2871(var3.field_1724.method_5667());
         if (var6 != null) {
            var5 = var6.method_2959();
         }
      } catch (Exception var11) {
      }

      float var12 = Math.min(var5 / 50.0F, 8.0F);
      class_243 var7 = var4.method_1021(var12).method_22882();
      class_238 var8 = var1.method_5829().method_997(var7);
      class_243 var9 = var3.field_1724.method_33571();
      class_243 var10 = new class_243(
         class_3532.method_15350(var9.field_1352, var8.field_1323, var8.field_1320),
         class_3532.method_15350(var9.field_1351, var8.field_1322, var8.field_1325),
         class_3532.method_15350(var9.field_1350, var8.field_1321, var8.field_1324)
      );
      return var9.method_1022(var10) > var2;
   }

   private boolean method1974() {
      class_310 var1 = class_310.method_1551();
      return var1.field_1724 == null
         ? false
         : var1.field_1724.method_6115() && var1.field_1724.method_6030().method_57353().method_57832(class_9334.field_50075);
   }

   private boolean method0431() {
      class_310 var1 = class_310.method_1551();
      return var1.field_1724 != null && var1.field_1687 != null
         ? var1.field_1724.method_5869()
            || var1.field_1687.method_8320(var1.field_1724.method_24515().method_10069(0, 0, 0)).method_26204() == class_2246.field_10382
         : false;
   }

   private boolean method0376() {
      class_310 var1 = class_310.method_1551();
      if (var1.field_1724 != null && var1.field_1687 != null) {
         class_238 var2 = var1.field_1724.method_5829();
         class_2338 var3 = var1.field_1724.method_24515();
         class_2339 var4 = new class_2339();

         for (int var5 = var3.method_10263() - 2; var5 <= var3.method_10263() + 2; var5++) {
            for (int var6 = var3.method_10264() - 1; var6 <= var3.method_10264() + 4; var6++) {
               for (int var7 = var3.method_10260() - 2; var7 <= var3.method_10260() + 2; var7++) {
                  var4.method_10103(var5, var6, var7);
                  if (var1.field_1687.method_8320(var4).method_26204() == class_2246.field_10343 && var2.method_994(new class_238(var4))) {
                     return true;
                  }
               }
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public static class AttackState {
      private long field0568 = 0L;
      private long field0005 = System.currentTimeMillis();

      public boolean method0579() {
         class_310 var1 = class_310.method_1551();
         float var2 = var1.field_1724 != null ? var1.field_1724.method_7261(0.5F) : 1.0F;
         long var3 = System.currentTimeMillis();
         long var5 = var3 - this.field0005;
         return var5 >= this.field0568 && var2 > 0.9F;
      }

      public boolean method0026() {
         return this.method0730(3);
      }

      public boolean method0730(int var1) {
         long var2 = System.currentTimeMillis() - this.field0005;
         long var4 = var1 * 50L;
         return var2 >= this.field0568 - var4 && var2 < this.field0568 + var4;
      }

      public void method0778(long var1) {
         this.field0005 = System.currentTimeMillis();
         this.field0568 = var1;
      }

      public void method2078() {
         this.field0568 = 0L;
         this.field0005 = System.currentTimeMillis();
      }

      public long method1764() {
         return System.currentTimeMillis() - this.field0005;
      }
   }
}
