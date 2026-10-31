package aethereal;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import lombok.Generated;

public class StringSetting extends Setting<String> {
   private List<String> field1508;

   public StringSetting(String var1, String var2) {
      super(var1, "");
      this.method1656(var2);
   }

   public StringSetting method1591(String... var1) {
      this.field1508 = Arrays.asList(var1);
      this.method2125(this.field1508.isEmpty() ? "" : this.field1508.get(0));
      return this;
   }

   public StringSetting method0230(Supplier<Boolean> var1) {
      this.method1109(var1);
      return this;
   }

   public StringSetting method0440(String var1) {
      if (this.field1508.contains(var1)) {
         this.method2125(var1);
      }

      return this;
   }

   public String method1888() {
      return this.method0492();
   }

   public void method0386(String var1) {
      this.method0206(var1);
   }

   public boolean method0506(String var1) {
      return this.method0492().equals(var1);
   }

   @Generated
   public List<String> method1936() {
      return this.field1508;
   }
}
