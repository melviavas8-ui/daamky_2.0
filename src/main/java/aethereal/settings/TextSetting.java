package aethereal;

import java.util.function.Supplier;
import lombok.Generated;

public class TextSetting extends Setting<String> {
   private final boolean field1527;

   public TextSetting(String var1, String var2, boolean var3) {
      super(var1, var2);
      this.field1527 = var3;
   }

   public TextSetting(String var1, String var2, Supplier<Boolean> var3, boolean var4) {
      super(var1, var2, var3);
      this.field1527 = var4;
   }

   @Generated
   public boolean method1891() {
      return this.field1527;
   }
}
