package aethereal;

import lombok.Generated;
import net.minecraft.class_1268;
import net.minecraft.class_1294;
import net.minecraft.class_1309;
import net.minecraft.class_1713;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2815;
import net.minecraft.class_2868;
import net.minecraft.class_4050;
import net.minecraft.class_2848.class_2849;

public class AttackController implements MinecraftAccess {
   private final IntervalTimer field0647 = new IntervalTimer();
   private final IntervalTimer field0077 = new IntervalTimer();
   private final IntervalTimer field1463 = new IntervalTimer();
   private final MaceCooldownTracker field0977 = new MaceCooldownTracker();
   private int field0178 = 0;
   private boolean field0497;
   private class_2849 field1650 = null;
   private boolean field1574 = false;
   private boolean field1735 = false;
   private boolean field1161 = false;
   private static final long field1089 = 200L;

   void method0578() {
   }

   void method0903(PacketEvent var1) {
   }

   void method0880(ItemUseEvent var1) {
      if (var1.method1760() == -1 && !this.field0077.method0612(50.0)) {
         var1.method0578();
      }
   }

   void method0813(CombatController.CombatAction var1) {
      if (this.method0815(var1, 0)) {
         this.method0170(var1);
      }

      boolean var2 = Aura.method1701().method0409() != null && Aura.method1701().method0409().method_6128() && field0796.field_1724.method_6128();
      if (var2) {
         ElytraTarget var3 = ElytraTarget.method1710();
         if (var3 != null && var3.method2195()) {
            class_243 var4 = var3.method1157(var1.method0564());
            class_238 var5 = var3.method1169(var1.method0564(), var4);
            if (var4 != null && var5 != null) {
               class_243 var6 = field0796.field_1724.method_33571();
               class_243 var7 = RotationManager.field0618.method0545().method0024();
               if (!var5.method_992(var6, var6.method_1019(var7.method_1021(var1.method2047()))).isPresent()) {
                  return;
               }
            }
         }

         if (!RaycastHelper.method0814(var1) || !this.method0815(var1, 0)) {
            return;
         }
      } else if (!RaycastHelper.method0814(var1) || !this.method0815(var1, 0)) {
         return;
      }

      if (this.method1916()) {
         this.method1836(var1);
      } else {
         String var8 = this.method1888();
         if (var8.equals("Legit") && !this.method1938()) {
            this.method1836(var1);
         }

         if (var8.equals("Packet")) {
            field0796.field_1724.method_5728(false);
            field0796.field_1724.method_46742();
            this.method1836(var1);
         }
      }
   }

   private boolean method1916() {
      return !field0796.field_1724.method_6115() ? false : !field0796.field_1724.method_6030().method_7909().equals(class_1802.field_8255);
   }

   private String method1888() {
      if (Aura.method1701().method1635()) {
         return Aura.method1701().method2241().method0492().method0557();
      } else {
         return TriggerBot.method1724().method1635() ? TriggerBot.method1724().field0204.method1888() : "Legit";
      }
   }

   void method0170(CombatController.CombatAction var1) {
      if (var1.method1974() && field0796.field_1724.method_6115() && field0796.field_1724.method_6030().method_7909().equals(class_1802.field_8255)) {
         field0796.field_1761.method_2897(field0796.field_1724);
         this.field0077.method0578();
      }

      if (!this.method1916()) {
         String var2 = this.method1888();
         if (var2.equals("Legit")) {
            if (field0796.field_1724.method_5624() && this.method1678() <= this.method1697() && this.field1463.method0612(200.0)) {
               this.field1463.method0578();
               Sprint.field0004 = 2;
               field0796.field_1690.field_1867.method_23481(false);
               field0796.field_1724.method_5728(false);
            }
         }
      }
   }

   void method2114(CombatController.CombatAction var1) {
   }

   void method1836(CombatController.CombatAction var1) {
      this.method1980(var1);
      this.method1648(var1);
      this.field0647.method0578();
      this.field0178++;
   }

   private void method1648(CombatController.CombatAction var1) {
      class_1309 var2 = var1.method0564();
      Rotation var3 = RotationHelper.method1296(field0796.field_1724.method_5829().method_1005().method_1020(var2.method_33571()));
      boolean var4 = var2.method_6115() && var2.method_6030().method_7909().equals(class_1802.field_8255);
      boolean var5 = Math.abs(RotationManager.method0667(var2.method_36454(), var3.method2047())) < 90.0F;
      int var6 = InventoryManager.method1567(true);
      if (var1.method1635() && var4 && var6 != -1 && var5) {
         if (var6 >= 9) {
            field0796.field_1761
               .method_2906(
                  field0796.field_1724.field_7512.field_7763, var6, field0796.field_1724.method_31548().field_7545, class_1713.field_7791, field0796.field_1724
               );
            field0796.method_1562().method_52787(new class_2815(field0796.field_1724.field_7512.field_7763));
            this.method1980(var1);
            field0796.field_1761
               .method_2906(
                  field0796.field_1724.field_7512.field_7763, var6, field0796.field_1724.method_31548().field_7545, class_1713.field_7791, field0796.field_1724
               );
            field0796.method_1562().method_52787(new class_2815(field0796.field_1724.field_7512.field_7763));
         } else {
            field0796.method_1562().method_52787(new class_2868(var6));
            this.method1980(var1);
            field0796.method_1562().method_52787(new class_2868(field0796.field_1724.method_31548().field_7545));
         }
      }
   }

   private void method1980(CombatController.CombatAction var1) {
      TriggerBot var2 = TriggerBot.method1724();
      if (var2.method1635() && var2.field0481.method0387("Hit Chance") && MathHelper.method0736(0, 100) >= var2.field1627.method0492()) {
         field0796.field_1724.method_6104(class_1268.field_5808);
         this.field0977.method0025();
      } else {
         if (field0796.field_1724.method_6115()) {
            field0796.field_1761.method_2897(field0796.field_1724);
         }

         ShiftTap.method1691();
         field0796.field_1761.method_2918(field0796.field_1724, var1.method0564());
         field0796.field_1724.method_6104(class_1268.field_5808);
         this.field0977.method0025();
      }
   }

   void method0025() {
   }

   private boolean method1938() {
      return PlayerMotionController.field0751 && !field0796.field_1724.method_6128() && !field0796.field_1724.method_5799();
   }

   private float method1697() {
      return Aura.method1701().method1635() ? Aura.method1701().method2204().method0492() : 3.0F;
   }

   private double method1678() {
      if (Aura.method1701().method1635() && Aura.method1701().method0409() != null) {
         return field0796.field_1724.method_5739(Aura.method1701().method0409());
      } else {
         return TriggerBot.method1724().method1635() && TriggerBot.method1724().field1569 != null
            ? field0796.field_1724.method_5739(TriggerBot.method1724().field1569)
            : 0.0;
      }
   }

   public boolean method0815(CombatController.CombatAction var1, int var2) {
      for (int var3 = 0; var3 <= var2; var3++) {
         if (this.method0171(var1, var3)) {
            return true;
         }
      }

      return false;
   }

   public boolean method0171(CombatController.CombatAction var1, int var2) {
      if (field0796.field_1724.method_6115() && !field0796.field_1724.method_6030().method_7909().equals(class_1802.field_8255) && var1.method0431()) {
         return false;
      }

      if (!this.field0977.method1572(false, 1)) {
         return false;
      }

      SimulatedPlayerInput var3 = SimulatedPlayerInput.method0717(var2);
      boolean var4 = !this.method0805(var3);
      boolean var5 = this.method0806(var3, var2);
      if (!TriggerBot.method1724().field1432.method1938() || !TriggerBot.method1724().method1635()) {
         boolean var6 = var1.method1813();
         if (var6
            && Aura.method1701() != null
            && Aura.method1701().method1635()
            && Aura.method1701().method2270().method1938()
            && !field0796.field_1690.field_1903.method_1434()) {
            var6 = false;
         }

         return var6 && !field0796.field_1724.method_6128() && !this.method0805(var3) ? this.method0806(var3, var2) : true;
      } else {
         return !var4 ? true : var5 || var3.field0890;
      }
   }

   private boolean method0805(SimulatedPlayerInput var1) {
      return var1.method1531(class_1294.field_5919)
         || var1.method1531(class_1294.field_5902)
         || PlayerActionHelper.method1290(var1.field0214.method_1014(-9.999994343091742E-4), class_2246.field_10343)
         || var1.method0431()
         || var1.method1974()
         || var1.method1813()
         || !PlayerActionHelper.method1447(class_4050.field_18076, var1.field1521)
         || var1.field0732.method_31549().field_7479;
   }

   private boolean method0806(SimulatedPlayerInput var1, int var2) {
      boolean var3 = var1.field1704 > 0.0F;
      return !var1.field0890 && var3;
   }

   @Generated
   public void method0729(int var1) {
      this.field0178 = var1;
   }

   @Generated
   public void method1570(boolean var1) {
      this.field0497 = var1;
   }

   @Generated
   public void method1378(class_2849 var1) {
      this.field1650 = var1;
   }

   @Generated
   public void method0345(boolean var1) {
      this.field1574 = var1;
   }

   @Generated
   public void method2178(boolean var1) {
      this.field1735 = var1;
   }

   @Generated
   public void method1876(boolean var1) {
      this.field1161 = var1;
   }

   @Generated
   public IntervalTimer method2057() {
      return this.field0647;
   }

   @Generated
   public IntervalTimer method1779() {
      return this.field0077;
   }

   @Generated
   public IntervalTimer method1611() {
      return this.field1463;
   }

   @Generated
   public MaceCooldownTracker method1950() {
      return this.field0977;
   }

   @Generated
   public int method0414() {
      return this.field0178;
   }

   @Generated
   public boolean method0376() {
      return this.field0497;
   }

   @Generated
   public class_2849 method0497() {
      return this.field1650;
   }

   @Generated
   public boolean method2229() {
      return this.field1574;
   }

   @Generated
   public boolean method2195() {
      return this.field1735;
   }

   @Generated
   public boolean method2267() {
      return this.field1161;
   }
}
