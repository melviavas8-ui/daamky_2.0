package aethereal;

import net.minecraft.class_1309;
import net.minecraft.class_243;

public class ElytraMovementPredictor {
   private static final double field0565 = 13.0;
   private final BooleanSetting field0034;
   private final EnumSetting<ElytraPredictionMode> field1448;
   private final BooleanSetting field0970;
   private final FloatSetting field0768;

   public ElytraMovementPredictor(BooleanSetting var1, EnumSetting<ElytraPredictionMode> var2, BooleanSetting var3, FloatSetting var4) {
      this.field0034 = var1;
      this.field1448 = var2;
      this.field0970 = var3;
      this.field0768 = var4;
   }

   public class_243 method1170(class_1309 var1, class_243 var2) {
      if (!this.field0034.method1938()) {
         return var2;
      } else if (method1152(var1) < 13.0) {
         return var2;
      } else {
         return this.field0970.method1938() && !var1.method_6128()
            ? var2
            : this.field1448.method0492().method1171(var1, var2, this.field0768.method0492().floatValue());
      }
   }

   private static double method1152(class_1309 var0) {
      class_243 var1 = var0.method_18798();
      return Math.hypot(var1.field_1352, var1.field_1350) * 20.0;
   }
}
