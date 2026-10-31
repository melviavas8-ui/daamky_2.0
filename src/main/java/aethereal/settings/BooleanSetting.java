package aethereal;

import java.util.function.Supplier;

public class BooleanSetting extends Setting<Boolean> {
   private String field1504;

   public BooleanSetting(String var1, Boolean var2, Supplier<Boolean> var3) {
      super(var1, var2, var3);
   }

   public BooleanSetting(String var1, Boolean var2) {
      super(var1, var2);
   }

   public String method1888() {
      return this.field1504;
   }

   public void method0442(String var1) {
      this.field1504 = var1;
   }

   public boolean method1938() {
      return this.method0492();
   }

   @Override
   public String method2067() {
      return this.field1504 != null && !this.field1504.isEmpty() ? this.field1504 : super.method2067();
   }
}
