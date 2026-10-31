package aethereal;

import java.util.Arrays;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_3965;
import net.minecraft.class_239.class_240;

public class CrystalHelper extends Module {
   private final MultiSelectSetting field0089 = new MultiSelectSetting("crystalhelper.modes", Arrays.asList("Place", "Tap", "Anchor"), false, () -> true)
      .method1007("Modes")
      .method0210("Active modes")
      .method2130("Активные режимы");
   private final KeyBindSetting field1468 = new KeyBindSetting("crystalhelper.anchorbind", new KeyBind(-1, false), () -> this.field0089.method0387("Anchor"))
      .method1007("Anchor Bind")
      .method0210("Key to place + charge a respawn anchor")
      .method2130("Клавиша для постановки и взрыва якоря");
   private static final long field0959 = 500L;
   private CrystalHelper.ActionState field0187 = CrystalHelper.ActionState.field0622;
   private class_2338 field0492;
   private class_2338 field1648;
   private class_2350 field1570;
   private final Stopwatch field1720 = new Stopwatch();
   private boolean field1161;
   private boolean field1109;

   public CrystalHelper() {
      super("CrystalHelper", ModuleCategory.field0661, "Assists with crystal PvP");
      this.method1013("Помощник для кристалл PvP");
   }

   @EventHandler
   public void onTick(PlayerTickEvent var1) {
      if (!method1974()) {
         if (field0796.field_1755 == null) {
            switch (this.field0187) {
               case field0622:
                  boolean var4 = !this.field1468.method0492().method0579() && this.field1468.method0492().method0026();
                  if (this.field0089.method0387("Anchor") && var4 && !this.field1109) {
                     this.method0457();
                  }

                  this.field1109 = var4;
                  if (this.field0187 == CrystalHelper.ActionState.field0622) {
                     boolean var3 = field0796.field_1690.field_1904.method_1434();
                     if (var3 && !this.field1161) {
                        if (this.field0089.method0387("Place")) {
                           this.method2043();
                        }

                        if (this.field0187 == CrystalHelper.ActionState.field0622 && this.field0089.method0387("Tap")) {
                           this.method0471();
                        }
                     }

                     this.field1161 = var3;
                  }
                  break;
               case field0053:
                  class_2248 var2 = field0796.field_1687.method_8320(this.field0492).method_26204();
                  if (var2 == class_2246.field_10540 || var2 == class_2246.field_9987) {
                     this.field0187 = CrystalHelper.ActionState.field1444;
                  } else if (this.field1720.method0779(500L)) {
                     this.method0479();
                  }
               case field1444:
               case field0979:
               case field0187:
               case field0467:
               default:
                  break;
               case field0766:
                  if (this.method0276(this.field0492) != null) {
                     this.field0187 = CrystalHelper.ActionState.field1252;
                     this.field1720.method1812();
                  } else if (this.field1720.method0779(500L)) {
                     this.method0479();
                  }
                  break;
               case field1252:
               case field0320:
                  if (this.field1720.method0779(1500L)) {
                     this.method0479();
                  }
                  break;
               case field1624:
               case field1551:
               case field1712:
                  if (this.field1720.method0779(1500L)) {
                     this.method0479();
                  }
            }

            if (this.field0187 == CrystalHelper.ActionState.field0622) {
               this.field1161 = field0796.field_1690.field_1904.method_1434();
               this.field1109 = !this.field1468.method0492().method0579() && this.field1468.method0492().method0026();
            }
         }
      }
   }

   @EventHandler
   public void onRotationUpdate(RotationUpdateEvent var1) {
      if (!method1974()) {
         if (var1.method1760() == 0) {
            switch (this.field0187) {
               case field1444:
                  if (this.method1264(this.field0492)) {
                     this.field0187 = CrystalHelper.ActionState.field0979;
                  } else {
                     this.method0479();
                  }
                  break;
               case field0979:
                  this.method1264(this.field0492);
                  this.method1691();
               case field0766:
               default:
                  break;
               case field1252:
                  class_1511 crystalx = this.method0276(this.field0492);
                  if (crystalx != null && this.method1175(crystalx)) {
                     this.field0187 = CrystalHelper.ActionState.field0320;
                  }
                  break;
               case field0320:
                  class_1511 var2 = this.method0276(this.field0492);
                  if (var2 != null) {
                     this.method1175(var2);
                     this.method0245(var2);
                  } else {
                     this.field0187 = CrystalHelper.ActionState.field1252;
                  }
                  break;
               case field0187:
                  if (this.method1736()) {
                     this.field0187 = CrystalHelper.ActionState.field0467;
                  }
                  break;
               case field0467:
                  this.method1736();
                  this.method1754();
                  break;
               case field1624:
                  if (field0796.field_1687.method_8320(this.field0492).method_26204() != class_2246.field_23152) {
                     this.method0479();
                     return;
                  }

                  if (this.method1264(this.field0492)) {
                     this.field0187 = CrystalHelper.ActionState.field1551;
                  }
                  break;
               case field1551:
                  this.method1264(this.field0492);
                  this.method2029();
                  break;
               case field1712:
                  this.method1264(this.field0492);
                  this.method2015();
            }
         }
      }
   }

   private boolean method1264(class_2338 var1) {
      if (var1 != null && field0796.field_1724 != null) {
         class_243 var2 = class_243.method_24953(var1);
         Rotation var3 = RotationHelper.method1296(var2.method_1020(field0796.field_1724.method_33571()));
         RotationHandler var4 = new RotationHandler(new LinearRotationStrategy(), true, false);
         RotationManager.field0618.method0870(var3, 2, var4, RotationPriority.field0778, this);
         return true;
      } else {
         return false;
      }
   }

   private boolean method1175(class_1511 var1) {
      if (var1 != null && field0796.field_1724 != null) {
         class_243 var2 = new class_243(var1.method_23317(), var1.method_23318() + 1.0, var1.method_23321());
         Rotation var3 = RotationHelper.method1296(var2.method_1020(field0796.field_1724.method_33571()));
         RotationHandler var4 = new RotationHandler(new LinearRotationStrategy(), true, false);
         RotationManager.field0618.method0870(var3, 2, var4, RotationPriority.field0778, this);
         return true;
      } else {
         return false;
      }
   }

   private boolean method1736() {
      if (this.field1648 != null && this.field1570 != null && field0796.field_1724 != null) {
         class_243 var1 = class_243.method_24953(this.field1648)
            .method_1031(this.field1570.method_10148() * 0.5, this.field1570.method_10164() * 0.5, this.field1570.method_10165() * 0.5);
         Rotation var2 = RotationHelper.method1296(var1.method_1020(field0796.field_1724.method_33571()));
         RotationHandler var3 = new RotationHandler(new LinearRotationStrategy(), true, false);
         RotationManager.field0618.method0870(var2, 2, var3, RotationPriority.field0778, this);
         return true;
      } else {
         return false;
      }
   }

   private void method1691() {
      if (this.field0492 != null && field0796.field_1724 != null) {
         int var1 = InventoryManager.method2154(class_1802.field_8301);
         if (var1 == -1) {
            this.method0479();
         } else {
            if (field0796.field_1724.method_6115()) {
               field0796.field_1761.method_2897(field0796.field_1724);
            }

            int var2 = field0796.field_1724.method_31548().field_7545;
            field0796.field_1724.method_31548().field_7545 = var1;
            class_243 var3 = class_243.method_24953(this.field0492).method_1031(0.0, 0.5, 0.0);
            field0796.field_1761.method_2896(field0796.field_1724, class_1268.field_5808, new class_3965(var3, class_2350.field_11036, this.field0492, false));
            field0796.field_1724.method_6104(class_1268.field_5808);
            field0796.field_1724.method_31548().field_7545 = var2;
            if (this.field0089.method0387("Place")) {
               this.field0187 = CrystalHelper.ActionState.field0766;
               this.field1720.method1812();
            } else {
               this.method0479();
            }
         }
      } else {
         this.method0479();
      }
   }

   private void method0245(class_1511 var1) {
      if (field0796.field_1724 == null) {
         this.method0479();
      } else {
         if (field0796.field_1724.method_6115()) {
            field0796.field_1761.method_2897(field0796.field_1724);
         }

         field0796.field_1761.method_2918(field0796.field_1724, var1);
         field0796.field_1724.method_6104(class_1268.field_5808);
         this.method0479();
      }
   }

   private void method1754() {
      if (this.field0492 != null && this.field1648 != null && this.field1570 != null && field0796.field_1724 != null) {
         int var1 = InventoryManager.method2154(class_1802.field_23141);
         if (var1 == -1) {
            this.method0479();
         } else {
            if (field0796.field_1724.method_6115()) {
               field0796.field_1761.method_2897(field0796.field_1724);
            }

            int var2 = field0796.field_1724.method_31548().field_7545;
            field0796.field_1724.method_31548().field_7545 = var1;
            class_243 var3 = class_243.method_24953(this.field1648)
               .method_1031(this.field1570.method_10148() * 0.5, this.field1570.method_10164() * 0.5, this.field1570.method_10165() * 0.5);
            field0796.field_1761.method_2896(field0796.field_1724, class_1268.field_5808, new class_3965(var3, this.field1570, this.field1648, false));
            field0796.field_1724.method_6104(class_1268.field_5808);
            field0796.field_1724.method_31548().field_7545 = var2;
            this.field0187 = CrystalHelper.ActionState.field1624;
            this.field1720.method1812();
         }
      } else {
         this.method0479();
      }
   }

   private void method2029() {
      if (this.field0492 != null && field0796.field_1724 != null) {
         int var1 = InventoryManager.method2154(class_1802.field_8801);
         if (var1 == -1) {
            this.method0479();
         } else {
            if (field0796.field_1724.method_6115()) {
               field0796.field_1761.method_2897(field0796.field_1724);
            }

            int var2 = field0796.field_1724.method_31548().field_7545;
            field0796.field_1724.method_31548().field_7545 = var1;
            class_243 var3 = class_243.method_24953(this.field0492).method_1031(0.0, 0.5, 0.0);
            field0796.field_1761.method_2896(field0796.field_1724, class_1268.field_5808, new class_3965(var3, class_2350.field_11036, this.field0492, false));
            field0796.field_1724.method_6104(class_1268.field_5808);
            field0796.field_1724.method_31548().field_7545 = var2;
            this.field0187 = CrystalHelper.ActionState.field1712;
         }
      } else {
         this.method0479();
      }
   }

   private void method2015() {
      if (this.field0492 != null && field0796.field_1724 != null) {
         if (field0796.field_1687.method_8320(this.field0492).method_26204() != class_2246.field_23152) {
            this.method0479();
         } else {
            if (field0796.field_1724.method_6115()) {
               field0796.field_1761.method_2897(field0796.field_1724);
            }

            int var1 = InventoryManager.method0147(0, 8);
            if (var1 != -1) {
               field0796.field_1724.method_31548().field_7545 = var1;
            } else if (field0796.field_1724.method_6047().method_7909() == class_1802.field_8801) {
               this.method0479();
               return;
            }

            class_243 var2 = class_243.method_24953(this.field0492).method_1031(0.0, 0.5, 0.0);
            field0796.field_1761.method_2896(field0796.field_1724, class_1268.field_5808, new class_3965(var2, class_2350.field_11036, this.field0492, false));
            field0796.field_1724.method_6104(class_1268.field_5808);
            this.method0479();
         }
      } else {
         this.method0479();
      }
   }

   private void method2043() {
      if (field0796.field_1724.method_6047().method_7909() == class_1802.field_8281) {
         if (field0796.field_1765 instanceof class_3965 var1 && var1.method_17783() == class_240.field_1332) {
            if (InventoryManager.method2154(class_1802.field_8301) != -1) {
               this.field0492 = var1.method_17777().method_10093(var1.method_17780());
               this.field0187 = CrystalHelper.ActionState.field0053;
               this.field1720.method1812();
            }
         }
      }
   }

   private void method0471() {
      if (field0796.field_1765 instanceof class_3965 var1 && var1.method_17783() == class_240.field_1332) {
         class_2248 var3 = field0796.field_1687.method_8320(var1.method_17777()).method_26204();
         if (var3 == class_2246.field_10540 || var3 == class_2246.field_9987) {
            if (InventoryManager.method2154(class_1802.field_8301) != -1) {
               this.field0492 = var1.method_17777();
               this.field0187 = CrystalHelper.ActionState.field1444;
            }
         }
      }
   }

   private void method0457() {
      if (field0796.field_1765 instanceof class_3965 var1 && var1.method_17783() == class_240.field_1332) {
         if (InventoryManager.method2154(class_1802.field_23141) != -1) {
            if (InventoryManager.method2154(class_1802.field_8801) != -1) {
               class_2338 var5 = var1.method_17777();
               class_2350 var3 = var1.method_17780();
               class_2338 var4 = var5.method_10093(var3);
               if (field0796.field_1687.method_8320(var4).method_45474()) {
                  this.field0492 = var4;
                  this.field1648 = var5;
                  this.field1570 = var3;
                  this.field0187 = CrystalHelper.ActionState.field0187;
                  this.field1720.method1812();
               }
            }
         }
      }
   }

   private class_1511 method0276(class_2338 var1) {
      if (var1 != null && field0796.field_1687 != null) {
         double var2 = var1.method_10263() + 0.5;
         double var4 = var1.method_10264() + 1.0;
         double var6 = var1.method_10260() + 0.5;
         class_1511 var8 = null;
         double var9 = 9.0;

         for (class_1297 var12 : field0796.field_1687.method_18112()) {
            if (var12 instanceof class_1511 var13 && !var13.method_31481()) {
               double var14 = var13.method_5649(var2, var4, var6);
               if (var14 < var9) {
                  var9 = var14;
                  var8 = var13;
               }
            }
         }

         return var8;
      } else {
         return null;
      }
   }

   private void method0479() {
      this.field0187 = CrystalHelper.ActionState.field0622;
      this.field0492 = null;
      this.field1648 = null;
      this.field1570 = null;
   }

   @Override
   public void method2078() {
      this.method0479();
      super.method2078();
   }

   private enum ActionState {
      field0622,
      field0053,
      field1444,
      field0979,
      field0766,
      field1252,
      field0320,
      field0187,
      field0467,
      field1624,
      field1551,
      field1712;
   }
}
