package aethereal;

import lombok.Generated;
import net.minecraft.class_1792;
import net.minecraft.class_1796;
import net.minecraft.class_1799;

public final class ItemStackHelper implements MinecraftAccess {
   public static int method1217(class_1792 var0) {
      return method1239(var0.method_7854());
   }

   public static int method1239(class_1799 var0) {
      return switch (var0.method_7976()) {
         case field_8950, field_8946 -> 32;
         case field_8947, field_8951 -> 10;
         case field_8953 -> 20;
         case field_8949 -> 0;
         default -> var0.method_7935(field0796.field_1724);
      };
   }

   public static float method0261(class_1792 var0) {
      class_1796 var1 = field0796.field_1724.method_7357();
      return var1.method_7905(var0.method_7854(), 0.0F);
   }

   @Generated
   private ItemStackHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
