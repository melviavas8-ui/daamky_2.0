package aethereal;

import java.util.function.Function;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_243;

public enum TargetPointMode implements DisplayNamed {
   field0674("Eyes", class_1297::method_33571),
   field0102("Center", var0 -> var0.method_19538().method_1031(0.0, var0.method_17682() / 2.0, 0.0));

   private final String field1504;
   private final Function<class_1309, class_243> field1035;

   TargetPointMode(String var3, Function<class_1309, class_243> var4) {
      this.field1504 = var3;
      this.field1035 = var4;
   }

   public class_243 method1157(class_1309 var1) {
      return this.field1035.apply(var1);
   }

   @Override
   public String method0557() {
      return this.field1504;
   }
}
