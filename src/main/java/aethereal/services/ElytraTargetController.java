package aethereal;

import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1309;
import net.minecraft.class_1802;
import net.minecraft.class_2868;
import net.minecraft.class_3532;

public class ElytraTargetController implements MinecraftAccess {
   private static final int field0567 = 40;
   private static final int field0004 = 5;
   private static final double field1409 = 4.0;
   private final ElytraTarget field0983;
   private final BooleanSetting field0184;
   private final FloatSetting field0470;
   private final FloatSetting field1627;
   private final FloatSetting field1553;
   private int field1705;
   private int field1137;
   private int field1088;
   private double field1195 = -1.0;

   public ElytraTargetController(ElytraTarget var1, BooleanSetting var2, FloatSetting var3, FloatSetting var4, FloatSetting var5) {
      this.field0983 = var1;
      this.field0184 = var2;
      this.field0470 = var3;
      this.field1627 = var4;
      this.field1553 = var5;
   }

   public void method0578() {
      this.field1705 = 0;
      this.field1137 = 0;
      this.field1088 = 0;
      this.field1195 = -1.0;
   }

   public void method0025() {
      if (field0796.field_1724 == null) {
         this.method0578();
      } else {
         if (this.field1705 > 0) {
            this.field1705--;
         }

         if (this.field1137 > 0) {
            this.field1137--;
         }

         if (!this.field0184.method1938() || !this.field0983.method2195() || !field0796.field_1724.method_6128()) {
            this.field1088 = 0;
            this.field1195 = -1.0;
         } else if (!field0796.field_1724.method_6115()) {
            Aura var1 = Aura.method1701();
            class_1309 var2 = var1 != null ? var1.method0409() : null;
            if (var2 != null && var2.method_6128()) {
               this.field1088 = Math.min(this.field1088 + 1, 200);
               double var3 = field0796.field_1724.method_5739(var2);
               double var5 = this.field1195 < 0.0 ? 0.0 : (this.field1195 - var3) * 20.0;
               this.field1195 = var3;
               if (this.field1705 <= 0) {
                  if (this.field1088 >= 5) {
                     if (this.field1137 <= 3) {
                        if (!(var3 <= 4.0)) {
                           double var7 = this.method0608(var3);
                           boolean var9 = var5 < var7;
                           boolean var10 = var3 > this.field1553.method0492().floatValue();
                           if ((var9 || var10) && this.method2079()) {
                              this.field1705 = this.field1627.method0492().intValue();
                              this.field1137 = 40;
                           }
                        }
                     }
                  }
               }
            } else {
               this.field1088 = 0;
               this.field1195 = -1.0;
            }
         }
      }
   }

   private double method0608(double var1) {
      double var3 = this.field0470.method0492().floatValue();
      double var5 = class_3532.method_15363((float)(var1 / this.field1553.method0492().floatValue()), 0.4F, 2.0F);
      return var3 * var5;
   }

   private boolean method2079() {
      if (field0796.field_1761 == null) {
         return false;
      }

      if (field0796.field_1724.method_6079().method_31574(class_1802.field_8639)) {
         return this.method1120(class_1268.field_5810);
      }

      int var1 = field0796.field_1724.method_31548().field_7545;
      int var2 = InventoryManager.method2154(class_1802.field_8639);
      if (var2 == -1) {
         return false;
      }

      if (var2 == var1) {
         return this.method1120(class_1268.field_5808);
      }

      field0796.field_1724.field_3944.method_52787(new class_2868(var2));
      field0796.field_1724.method_31548().field_7545 = var2;
      boolean var3 = this.method1120(class_1268.field_5808);
      field0796.field_1724.field_3944.method_52787(new class_2868(var1));
      field0796.field_1724.method_31548().field_7545 = var1;
      return var3;
   }

   private boolean method1120(class_1268 var1) {
      class_1269 var2 = field0796.field_1761.method_2919(field0796.field_1724, var1);
      return var2.method_23665();
   }
}
