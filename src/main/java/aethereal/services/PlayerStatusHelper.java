package aethereal;

import lombok.Generated;
import net.minecraft.class_1657;
import net.minecraft.class_266;
import net.minecraft.class_8646;
import net.minecraft.class_9013;

public final class PlayerStatusHelper implements MinecraftAccess {
   public static boolean method1014(String var0) {
      return field0796.method_1562() != null && field0796.method_1562().method_45734() != null
         ? field0796.method_1562().method_45734().field_3761.toLowerCase().contains(var0)
         : false;
   }

   public static float method1178(class_1657 var0) {
      try {
         class_266 var1 = var0.method_7327().method_1189(class_8646.field_45158);
         if (var1 != null) {
            class_9013 var2 = var0.method_7327().method_55430(var0, var1);
            if (var2 != null) {
               return var2.method_55397();
            }
         }
      } catch (Exception var3) {
      }

      return -1.0F;
   }

   @Generated
   private PlayerStatusHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
