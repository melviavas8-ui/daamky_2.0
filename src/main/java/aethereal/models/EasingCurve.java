package aethereal;

import java.util.function.Function;
import lombok.Generated;

public enum EasingCurve {
   field0672(var0 -> var0),
   field0100(var0 -> -(Math.cos(3.1415933129662683 * var0) - 1.0) / 2.0),
   field1477(var0 -> var0 < 0.5 ? (1.0 - Math.sqrt(1.0 - Math.pow(2.0 * var0, 2.0))) / 2.0 : (Math.sqrt(1.0 - Math.pow(-2.0 * var0 + 2.0, 2.0)) + 1.0) / 2.0),
   field1011(var0 -> var0 < 0.5 ? 4.0 * var0 * var0 * var0 : 1.0 - Math.pow(-2.0 * var0 + 2.0, 3.0) / 2.0),
   field0779(var0 -> var0 < 0.5 ? 8.0 * var0 * var0 * var0 * var0 : 1.0 - Math.pow(-2.0 * var0 + 2.0, 4.0) / 2.0),
   field1262(var0 -> 1.0 + 2.7015783687885104 * Math.pow(var0 - 1.0, 3.0) + 1.7015800377204118 * Math.pow(var0 - 1.0, 2.0)),
   field0330(var0 -> Math.sqrt(1.0 - Math.pow(var0 - 1.0, 2.0))),
   field0203(var0 -> 1.0 - Math.pow(1.0 - var0, 3.0)),
   field0482(var0 -> -2.0 * Math.pow(var0, 3.0) + 3.0 * Math.pow(var0, 2.0)),
   field1638(var0 -> 3.0 * Math.pow(1.0 - var0, 2.0) * var0 * -0.19999997782436657 + 3.0 * (1.0 - var0) * Math.pow(var0, 2.0) * 1.5 + Math.pow(var0, 3.0));

   private final Function<Double, Double> field1568;

   public double method0608(double var1) {
      return this.field1568.apply(var1);
   }

   @Generated
   EasingCurve(Function<Double, Double> var3) {
      this.field1568 = var3;
   }
}
