package aethereal;

import net.minecraft.class_1309;
import net.minecraft.class_243;

public enum ElytraPredictionMode implements DisplayNamed {
   field0673("Simple"),
   field0101("Velocity");

   private final String field1504;

   ElytraPredictionMode(String var3) {
      this.field1504 = var3;
   }

   public class_243 method1171(class_1309 var1, class_243 var2, double var3) {
      class_243 var5 = var2.method_1019(var1.method_18798().method_1021(var3));

      return switch (this) {
         case field0673 -> var5;
         case field0101 -> var5.method_1023(0.0, 0.025000005868059873 * var3 * var3, 0.0);
      };
   }

   @Override
   public String method0557() {
      return this.field1504;
   }
}
