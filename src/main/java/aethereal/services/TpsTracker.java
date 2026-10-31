package aethereal;

import lombok.Generated;
import net.minecraft.class_3532;

public final class TpsTracker implements MinecraftAccess {
   private static int field0567;

   public static void method0578() {
      int var0 = field0796.method_47599();
      field0567 = class_3532.method_48781(0.05F, field0567, var0);
   }

   @Generated
   private TpsTracker() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   @Generated
   public static int method0003() {
      return field0567;
   }
}
