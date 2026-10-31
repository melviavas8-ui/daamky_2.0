package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10185;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1684;
import net.minecraft.class_1713;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_243;
import net.minecraft.class_2851;
import net.minecraft.class_3532;
import net.minecraft.class_3675;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;

public class TargetPearl extends Module {
   private TargetPearl.TargetState field0125 = TargetPearl.TargetState.field0701;
   private class_243 field1521;
   private Rotation field1001;
   private int field0178 = -1;
   private int field0459 = -1;
   private boolean field1653 = false;

   public TargetPearl() {
      super("TargetPearl", ModuleCategory.field0661, "Throws a pearl to the same spot as the target");
      this.method1013("Бросает жемчуг туда же куда бросил таргет ауры");
   }

   @EventHandler
   public void onTick(PlayerTickEvent var1) {
      if (!method1974()) {
         if (field0796.field_1755 == null) {
            if (this.field0125 == TargetPearl.TargetState.field1021) {
               this.field0125 = TargetPearl.TargetState.field0784;
            } else if (this.field0125 == TargetPearl.TargetState.field0701) {
               class_1309 var2 = this.method0455();
               if (var2 != null) {
                  for (class_1297 var4 : field0796.field_1687.method_18112()) {
                     if (var4 instanceof class_1684 var5 && var5.method_5628() != this.field0178 && var5.method_24921() == var2) {
                        this.field0178 = var5.method_5628();
                        int var6 = InventoryManager.method2154(class_1802.field_8634);
                        int var7 = var6 == -1 ? InventoryManager.method1859(class_1802.field_8634) : -1;
                        if (var6 == -1 && var7 == -1) {
                           NewHUD.method1053("Нету предмета", "\"Эндер-жемчуг\"", new class_1799(class_1802.field_8634), false);
                           return;
                        }

                        class_243 var8 = this.method1201(var5);
                        if (var8 == null) {
                           return;
                        }

                        this.field1521 = var8;
                        this.field1001 = this.method1327(field0796.field_1724.method_33571(), var8);
                        this.field0459 = var6 != -1 ? -1 : var7;
                        if (this.field0459 != -1 && field0796.field_1724.method_5624()) {
                           this.method2029();
                           this.field0125 = TargetPearl.TargetState.field1021;
                        } else {
                           this.field0125 = TargetPearl.TargetState.field0125;
                        }

                        return;
                     }
                  }
               }
            }
         }
      }
   }

   @EventHandler
   public void onRotationUpdate(RotationUpdateEvent var1) {
      if (!method1974()) {
         if (var1.method1760() == 0) {
            switch (this.field0125) {
               case field0125:
                  if (this.method1736()) {
                     this.field0125 = TargetPearl.TargetState.field1494;
                  } else {
                     this.method0479();
                  }
                  break;
               case field1494:
                  this.method1736();
                  this.method1691();
                  this.method0479();
               case field1021:
               default:
                  break;
               case field0784:
                  this.method1736();
                  this.method1754();
                  this.method0479();
            }
         }
      }
   }

   private boolean method1736() {
      if (this.field1001 != null && field0796.field_1724 != null) {
         RotationHandler var1 = new RotationHandler(new LinearRotationStrategy(), true, false);
         RotationManager.field0618.method0870(this.field1001, 2, var1, RotationPriority.field0778, this);
         return true;
      } else {
         return false;
      }
   }

   private void method1691() {
      if (field0796.field_1724 != null) {
         int var1 = InventoryManager.method2154(class_1802.field_8634);
         if (var1 != -1) {
            if (field0796.field_1724.method_6115()) {
               field0796.field_1761.method_2897(field0796.field_1724);
            }

            int var2 = field0796.field_1724.method_31548().field_7545;
            field0796.field_1724.method_31548().field_7545 = var1;
            field0796.field_1761.method_2919(field0796.field_1724, class_1268.field_5808);
            field0796.field_1724.method_31548().field_7545 = var2;
         }
      }
   }

   private void method1754() {
      if (field0796.field_1724 != null && this.field0459 != -1) {
         if (field0796.field_1724.method_6115()) {
            field0796.field_1761.method_2897(field0796.field_1724);
         }

         int var1 = field0796.field_1724.method_31548().field_7545;
         this.method2043();
         field0796.field_1761.method_2906(0, this.field0459, var1, class_1713.field_7791, field0796.field_1724);
         field0796.field_1761.method_2919(field0796.field_1724, class_1268.field_5808);
         field0796.field_1761.method_2906(0, this.field0459, var1, class_1713.field_7791, field0796.field_1724);
         this.method0471();
         this.method2015();
      } else {
         this.method0479();
      }
   }

   private Rotation method1327(class_243 var1, class_243 var2) {
      double var3 = var2.field_1352 - var1.field_1352;
      double var5 = var2.field_1350 - var1.field_1350;
      float var7 = (float)Math.toDegrees(Math.atan2(var5, var3)) - 90.0F;
      var7 = class_3532.method_15393(var7);
      float var8 = 0.0F;
      double var9 = 1.7976922776554332E308;

      for (float var11 = -80.0F; var11 <= 80.0F; var11++) {
         class_243 var12 = this.method1314(var1, var7, var11);
         double var13 = var12.method_1025(var2);
         if (var13 < var9) {
            var9 = var13;
            var8 = var11;
         }
      }

      for (float var16 = var8 - 1.0F; var16 <= var8 + 1.0F; var16 += 0.1F) {
         class_243 var17 = this.method1314(var1, var7, var16);
         double var18 = var17.method_1025(var2);
         if (var18 < var9) {
            var9 = var18;
            var8 = var16;
         }
      }

      return new Rotation(var7, var8);
   }

   private class_243 method1314(class_243 var1, float var2, float var3) {
      float var4 = var2 * (float) (Math.PI / 180.0);
      float var5 = var3 * (float) (Math.PI / 180.0);
      float var6 = class_3532.method_15362(var5);
      double var7 = -class_3532.method_15374(var4) * var6;
      double var9 = -class_3532.method_15374(var5);
      double var11 = class_3532.method_15362(var4) * var6;
      class_243 var13 = new class_243(var7, var9, var11).method_1029().method_1021(1.5);
      class_243 var14 = var1;

      for (int var15 = 0; var15 < 300; var15++) {
         class_243 var16 = var14;
         var14 = var14.method_1019(var13);
         var13 = var13.method_1021(0.9900001267003649).method_1023(0.0, 0.02999998800922546, 0.0);
         class_3965 var17 = field0796.field_1687.method_17742(new class_3959(var16, var14, class_3960.field_17558, class_242.field_1348, field0796.field_1724));
         if (var17.method_17783() != class_240.field_1333) {
            return var17.method_17784();
         }

         if (var14.field_1351 < field0796.field_1687.method_31607()) {
            return var14;
         }
      }

      return var14;
   }

   private class_243 method1201(class_1684 var1) {
      class_243 var2 = var1.method_19538();
      class_243 var3 = var1.method_18798();

      for (int var4 = 0; var4 < 300; var4++) {
         class_243 var5 = var2;
         var2 = var2.method_1019(var3);
         var3 = var3.method_1021(0.9900001267003649).method_1023(0.0, 0.02999998800922546, 0.0);
         class_3965 var6 = field0796.field_1687.method_17742(new class_3959(var5, var2, class_3960.field_17558, class_242.field_1348, var1));
         if (var6.method_17783() != class_240.field_1333) {
            return var6.method_17784();
         }

         if (var2.field_1351 < field0796.field_1687.method_31607()) {
            return var2;
         }
      }

      return var2;
   }

   private void method2029() {
      field0796.field_1724.method_5728(false);
      field0796.field_1690.field_1867.method_23481(false);
      this.field1653 = true;
      Sprint.field0004 = Math.max(Sprint.field0004, 1);
   }

   private void method2015() {
      if (this.field1653) {
         long var1 = field0796.method_22683().method_4490();
         field0796.field_1690.field_1867.method_23481(class_3675.method_15987(var1, field0796.field_1690.field_1867.method_1429().method_1444()));
         this.field1653 = false;
      }
   }

   private void method2043() {
      if (field0796.method_1562() != null) {
         field0796.method_1562().method_52787(new class_2851(new class_10185(false, false, false, false, false, false, false)));
      }
   }

   private void method0471() {
      if (field0796.method_1562() != null && field0796.field_1724 != null) {
         field0796.method_1562().method_52787(new class_2851(field0796.field_1724.field_3913.field_54155));
      }
   }

   private class_1309 method0455() {
      Aura var1 = Aura.method1701();
      if (var1 == null) {
         return null;
      }

      class_1309 var2 = var1.method0409();
      if (var2 != null && var2.method_5805()) {
         return var2;
      }

      var2 = var1.method0520();
      return var2 != null && var2.method_5805() ? var2 : null;
   }

   private void method0479() {
      this.field0125 = TargetPearl.TargetState.field0701;
      this.field1521 = null;
      this.field1001 = null;
      this.field0459 = -1;
   }

   @Override
   public void method2078() {
      if (this.field1653) {
         this.method2015();
      }

      this.method0479();
      this.field0178 = -1;
      super.method2078();
   }

   private enum TargetState {
      field0701,
      field0125,
      field1494,
      field1021,
      field0784;
   }
}
