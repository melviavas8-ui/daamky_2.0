package aethereal;

import java.util.function.Supplier;

public class ConditionalBooleanSetting extends Setting<Boolean> {
   private final Runnable field1503;

   public ConditionalBooleanSetting(String var1, Runnable var2) {
      super(var1, false);
      this.field1503 = var2;
   }

   public ConditionalBooleanSetting(String var1, Runnable var2, Supplier<Boolean> var3) {
      super(var1, false, var3);
      this.field1503 = var2;
   }

   public void method1890() {
      if (this.field1503 != null) {
         this.field1503.run();
      }
   }
}
