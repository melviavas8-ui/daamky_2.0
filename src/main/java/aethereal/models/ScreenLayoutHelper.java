package aethereal;

import net.minecraft.class_310;

public class ScreenLayoutHelper {
   private static final float field0003 = 960.0F;
   private static final float field1410 = 540.0F;
   public static final double field0565 = 2.0;
   private static final double field0956 = 2.0;
   private static float field0758 = 1.0F;

   public static void method0738(int var0, int var1) {
      field0758 = Math.min(var0 / 960.0F, var1 / 540.0F);
   }

   public static float method0530() {
      return field0758;
   }

   public static float method0645(float var0) {
      return var0 * field0758;
   }

   public static float method0002() {
      class_310 var0 = class_310.method_1551();
      return var0.method_22683() == null ? 1.0F : (float)(2.0 / var0.method_22683().method_4495());
   }

   public static float method2047() {
      class_310 var0 = class_310.method_1551();
      return var0.method_22683() == null ? 960.0F : (float)(var0.method_22683().method_4489() / 2.0);
   }

   public static float method1762() {
      class_310 var0 = class_310.method_1551();
      return var0.method_22683() == null ? 540.0F : (float)(var0.method_22683().method_4506() / 2.0);
   }
}
