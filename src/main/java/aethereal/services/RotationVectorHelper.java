package aethereal;

import lombok.Generated;
import net.minecraft.class_1297;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public final class RotationVectorHelper implements MinecraftAccess {
   public static float[] method1130(class_1297 var0) {
      return method0621(var0.method_23317(), var0.method_23318(), var0.method_23321());
   }

   public static float[] method1302(class_243 var0) {
      return method0621(var0.field_1352, var0.field_1351, var0.field_1350);
   }

   public static float[] method0621(double var0, double var2, double var4) {
      double var6 = var0 - field0796.field_1724.method_23317();
      double var8 = var2 - field0796.field_1724.method_23320();
      double var10 = var4 - field0796.field_1724.method_23321();
      double var12 = class_3532.method_15355((float)(var6 * var6 + var10 * var10));
      float var14 = (float)(class_3532.method_15349(var10, var6) * 57.29580383201761 - 90.0);
      float var15 = (float)(-class_3532.method_15349(var8, var12) * 57.29580383201761);
      return new float[]{var14, var15};
   }

   public static float[] method1281(class_2350 var0) {
      return switch (var0) {
         case field_11033 -> new float[]{field0796.field_1724.method_36454(), 90.0F};
         case field_11036 -> new float[]{field0796.field_1724.method_36454(), -90.0F};
         case field_11043 -> new float[]{180.0F, field0796.field_1724.method_36455()};
         case field_11035 -> new float[]{0.0F, field0796.field_1724.method_36455()};
         case field_11039 -> new float[]{90.0F, field0796.field_1724.method_36455()};
         case field_11034 -> new float[]{-90.0F, field0796.field_1724.method_36455()};
         default -> throw new MatchException(null, null);
      };
   }

   public static float[] method1579(float[] var0) {
      var0[0] -= var0[0] % method0530();
      var0[1] -= var0[1] % method0530();
      return new float[]{var0[0], var0[1]};
   }

   public static float method0530() {
      double var0 = (Double)field0796.field_1690.method_42495().method_41753() * 0.7999999195643113;
      return (float)(var0 * var0 * var0 * 8.0 * 0.1500000045479434);
   }

   @Generated
   private RotationVectorHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
