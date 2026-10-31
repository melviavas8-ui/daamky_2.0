package aethereal;

import java.util.function.Supplier;

public class VisibleBooleanSetting extends BooleanSetting {
   private final Class<? extends Module> field1501;
   private Module field1003;

   public VisibleBooleanSetting(String var1, Class<? extends Module> var2) {
      super(var1, false);
      this.field1501 = var2;
   }

   public VisibleBooleanSetting(String var1, Class<? extends Module> var2, Supplier<Boolean> var3) {
      super(var1, false, var3);
      this.field1501 = var2;
   }

   private Module method1746() {
      if (this.field1003 != null) {
         return this.field1003;
      }

      try {
         this.field1003 = DaamkyClient.method2004().method1783().method0976(this.field1501);
      } catch (Exception var2) {
      }

      return this.field1003;
   }

   public Boolean method1727() {
      Module var1 = this.method1746();
      return var1 != null && var1.method2195();
   }

   public void method0974(Boolean var1) {
      super.method0206(var1);
      Module var2 = this.method1746();
      if (var2 != null && var2.method2195() != var1) {
         var2.method0345(var1);
      }
   }

   public Module method1686() {
      return this.method1746();
   }
}
