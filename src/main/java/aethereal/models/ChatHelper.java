package aethereal;

import lombok.Generated;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_310;
import net.minecraft.class_5250;
import net.minecraft.class_5251;

public final class ChatHelper {
   private static class_5250 method0575() {
      int var0 = ThemeColorManager.method1604() & 16777215;
      class_2583 var1 = class_2583.field_24360.method_27703(class_5251.method_27717(var0));
      class_2583 var2 = class_2583.field_24360.method_27703(class_5251.method_27717(8355732));
      return class_2561.method_43470("[Daamky] ").method_10862(var1).method_10852(class_2561.method_43470("» ").method_10862(var2));
   }

   public static void method1013(String var0) {
      class_310 var1 = class_310.method_1551();
      if (var1.field_1724 != null) {
         class_5250 var2 = method0575().method_10852(class_2561.method_43470(var0).method_27692(class_124.field_1068));
         var1.field_1724.method_7353(var2, false);
      }
   }

   public static void method1347(class_2561 var0) {
      class_310 var1 = class_310.method_1551();
      if (var1.field_1724 != null) {
         class_5250 var2 = method0575().method_10852(var0);
         var1.field_1724.method_7353(var2, false);
      }
   }

   @Generated
   private ChatHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
