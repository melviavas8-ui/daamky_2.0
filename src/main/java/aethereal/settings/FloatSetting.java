package aethereal;

import java.util.function.Supplier;
import lombok.Generated;

public class FloatSetting extends Setting<Float> {
   private final float field1410;
   private final float field0957;
   private final float field0758;

   public FloatSetting(String var1, float var2, float var3, float var4, float var5) {
      super(var1, var2);
      this.field1410 = var3;
      this.field0957 = var4;
      this.field0758 = var5;
   }

   public FloatSetting(String var1, float var2, float var3, float var4, float var5, Supplier<Boolean> var6) {
      super(var1, var2, var6);
      this.field1410 = var3;
      this.field0957 = var4;
      this.field0758 = var5;
   }

   @Generated
   public float method1878() {
      return this.field1410;
   }

   @Generated
   public float method1928() {
      return this.field0957;
   }

   @Generated
   public float method1697() {
      return this.field0758;
   }
}
