package aethereal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1309;
import net.minecraft.class_1713;
import net.minecraft.class_1802;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2868;
import net.minecraft.class_3532;

public class AutoWeb extends Module {
   private static final float field0003 = 6.0F;
   private static final float field1410 = 10.0F;
   private final EnumSetting<AutoWeb.PlacementMode> field0984 = new EnumSetting<>("autoweb.placemode", AutoWeb.PlacementMode.field0596)
      .method1007("Place Mode")
      .method0210("Default: single web at feet. Multi: 2 webs vertically at feet + 1 web around target")
      .method2130("Default: 1 паутина под ноги. Multi: по 1 вокруг");
   private final MultiSelectSetting field0202 = new MultiSelectSetting(
         "autoweb.targettype", Arrays.asList("Players", "Naked", "Mobs", "Animals", "Friends", "Armor Stand"), false, () -> true
      )
      .method1007("Target Type")
      .method0210("Entity types that can be targeted")
      .method2130("Типы сущностей, которые можно таргетить");
   private final FloatSetting field0470 = new FloatSetting("autoweb.placespeed", 20.0F, 1.0F, 20.0F, 1.0F)
      .method1007("Place Speed")
      .method0210("Place rate in webs per second")
      .method2130("Скорость установки");
   private final BooleanSetting field1619 = new BooleanSetting("autoweb.frominventory", false)
      .method1007("From Inventory")
      .method0210("Use cobweb from the main inventory when none is in hotbar (swap → place → swap back)")
      .method2130("Ставить паутину из инвентаря, если в хотбаре её нет");
   private final TargetSelector field1549 = new TargetSelector();
   private final Stopwatch field1720 = new Stopwatch();
   private class_1309 field1157;
   private AutoWeb.PlacementCandidate field1092;
   private int field1197 = -1;

   public static AutoWeb method1704() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(AutoWeb.class) : null;
   }

   public AutoWeb() {
      super("AutoWeb", ModuleCategory.field0661, "Places cobwebs under enemy feet to immobilize them");
      this.method1013("Застраивает ноги противника паутиной");
   }

   @Override
   public void method2078() {
      this.method1691();
      this.field1549.method0578();
      this.field1157 = null;
      this.field1092 = null;
      super.method2078();
   }

   @EventHandler
   public void onRotationUpdate(RotationUpdateEvent var1) {
      if (var1.method1760() == 0) {
         if (!method1974()) {
            this.field1157 = this.method2027();
            this.field1092 = null;
            if (this.field1157 != null) {
               if (this.method1755()) {
                  this.field1092 = this.method1259(this.field1157.method_24515());
                  if (this.field1092 != null) {
                     ThreadLocalRandom var2 = ThreadLocalRandom.current();
                     float var3 = (var2.nextFloat() - 0.5F) * 0.4F;
                     float var4 = (var2.nextFloat() - 0.5F) * 0.4F;
                     Rotation var5 = new Rotation(this.field1092.field1466.method2047() + var3, this.field1092.field1466.method1762() + var4);
                     RotationHandler var6 = new RotationHandler(new AutoWebRotationStrategy(), true, true);
                     RotationManager.field0618.method0875(var5, var6, RotationPriority.field0778, this);
                  }
               }
            }
         }
      }
   }

   @EventHandler
   public void onUpdateMovementPost(PostMovementEvent var1) {
      if (!method1974()) {
         this.method1691();
         if (this.field1092 != null && this.field1157 != null) {
            if (this.method1755()) {
               if (this.field1720.method1646((long)(1000.0F / this.field0470.method0492()))) {
                  Rotation var2 = RotationManager.field0618.method2258();
                  if (!(RotationManager.method0871(var2, this.field1092.field1466) > 10.0)) {
                     this.method1274(this.field1092.field0733, this.field1092.field0155);
                  }
               }
            }
         }
      }
   }

   private void method1691() {
      if (this.field1197 != -1) {
         if (field0796.field_1724 != null && field0796.method_1562() != null) {
            field0796.method_1562().method_52787(new class_2868(this.field1197));
            this.field1197 = -1;
         } else {
            this.field1197 = -1;
         }
      }
   }

   private void method1274(class_2338 var1, class_2350 var2) {
      int var3 = field0796.field_1724.method_31548().field_7545;
      class_1268 var4 = BlockPlacementContext.method1219(class_1802.field_8786);
      if (var4 != null) {
         boolean var8 = BlockPlacementContext.method1275(var1, var2, var4, false);
         if (var8) {
            this.field1720.method1634();
         }
      } else {
         int var5 = InventoryManager.method2154(class_1802.field_8786);
         if (var5 != -1) {
            field0796.method_1562().method_52787(new class_2868(var5));
            boolean var9 = BlockPlacementContext.method1275(var1, var2, class_1268.field_5808, false);
            this.field1197 = var3;
            if (var9) {
               this.field1720.method1634();
            }
         } else if (this.field1619.method0492()) {
            int var6 = InventoryManager.method1859(class_1802.field_8786);
            if (var6 != -1) {
               field0796.field_1761.method_2906(0, var6, var3, class_1713.field_7791, field0796.field_1724);
               boolean var7 = BlockPlacementContext.method1275(var1, var2, class_1268.field_5808, false);
               field0796.field_1761.method_2906(0, var6, var3, class_1713.field_7791, field0796.field_1724);
               if (var7) {
                  this.field1720.method1634();
               }
            }
         }
      }
   }

   private AutoWeb.PlacementCandidate method1259(class_2338 var1) {
      List var2 = new ArrayList<>();
      switch ((AutoWeb.PlacementMode)this.field0984.method0492()) {
         case field0596:
            var2.add(var1);
            break;
         case field0031:
            var2.add(var1);
            var2.add(var1.method_10084());
            var2.add(var1.method_10095());
            var2.add(var1.method_10072());
            var2.add(var1.method_10078());
            var2.add(var1.method_10067());
      }

      class_243 var3 = field0796.field_1724.method_33571();
      double var4 = field0796.field_1724.method_55754();
      double var6 = class_3532.method_33723(var4);

      for (class_2338 var9 : var2) {
         if (field0796.field_1687.method_8320(var9).method_45474()) {
            class_2350 var10 = BlockPlacementContext.method0277(var9);
            if (var10 != null) {
               class_2338 var11 = var9.method_10093(var10);
               class_2350 var12 = var10.method_10153();
               class_243 var13 = new class_243(
                  var11.method_10263() + 0.5 + var12.method_10148() * 0.5,
                  var11.method_10264() + 0.5 + var12.method_10164() * 0.5,
                  var11.method_10260() + 0.5 + var12.method_10165() * 0.5
               );
               if (!(var3.method_1025(var13) > var6)) {
                  Rotation var14 = RotationHelper.method1296(var13.method_1020(var3));
                  return new AutoWeb.PlacementCandidate(var9, var10, var14);
               }
            }
         }
      }

      return null;
   }

   private boolean method1755() {
      if (field0796.field_1724.method_6047().method_7909() == class_1802.field_8786) {
         return true;
      } else if (field0796.field_1724.method_6079().method_7909() == class_1802.field_8786) {
         return true;
      } else {
         return InventoryManager.method2154(class_1802.field_8786) != -1
            ? true
            : this.field1619.method0492() && InventoryManager.method1859(class_1802.field_8786) != -1;
      }
   }

   private class_1309 method2027() {
      class_1309 var1 = this.method2013();
      if (var1 != null) {
         return var1;
      }

      TargetSelector.TargetScore var2 = new TargetSelector.TargetScore(this.field0202.method1936());
      this.field1549.method0986(field0796.field_1687.method_18112(), 6.0F, 360.0F, true);
      this.field1549.method1105(var2::method1159);
      return this.field1549.method2074();
   }

   private class_1309 method2013() {
      Aura var1 = Aura.method1701();
      if (var1 != null && var1.method2195()) {
         class_1309 var2 = var1.method0409();
         if (var2 != null && var2.method_5805()) {
            return var2;
         }

         class_1309 var3 = var1.method0520();
         return var3 != null && var3.method_5805() ? var3 : null;
      } else {
         return null;
      }
   }

   private static final class PlacementCandidate {
      final class_2338 field0733;
      final class_2350 field0155;
      final Rotation field1466;

      PlacementCandidate(class_2338 var1, class_2350 var2, Rotation var3) {
         this.field0733 = var1;
         this.field0155 = var2;
         this.field1466 = var3;
      }
   }

   public enum PlacementMode implements DisplayNamed {
      field0596("Default"),
      field0031("Multi");

      private final String field1504;

      PlacementMode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }
}
