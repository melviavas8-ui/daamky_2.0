package aethereal;

import java.util.function.Consumer;
import java.util.function.Supplier;
import lombok.Generated;

public abstract class Setting<Value> {
   private final String field1504;
   private String field1030;
   private String field0791;
   private String field1269;
   protected Value field0714;
   protected Value field0135;
   private Supplier<Boolean> field0337 = () -> true;
   private Consumer<Setting<Value>> field0211 = null;
   private Module field0480;

   public Setting(String var1, Value var2) {
      this.field1504 = var1;
      this.field0135 = var2;
      this.field0714 = var2;
   }

   public Setting(String var1, Value var2, Supplier<Boolean> var3) {
      this.field1504 = var1;
      this.field0135 = var2;
      this.field0714 = var2;
      this.field0337 = var3;
   }

   public boolean method0989(Object var1) {
      return this.field0714.equals(var1);
   }

   public void method0206(Value var1) {
      SettingChangedEvent var2 = new SettingChangedEvent(this);
      DaamkyClient.method2004().method2072().post(var2);
      if (!var2.method2079()) {
         this.field0714 = var1;
      }
   }

   public void method2125(Value var1) {
      this.field0714 = var1;
   }

   public void method0578() {
      this.field0714 = this.field0135;
   }

   public boolean method0026() {
      return this.field0337.get();
   }

   public Setting<Value> method1100(Consumer<Setting<Value>> var1) {
      this.field0211 = var1;
      return this;
   }

   public <T extends Setting<Value>> T method1007(String var1) {
      this.field1030 = var1;
      return (T)this;
   }

   public <T extends Setting<Value>> T method0210(String var1) {
      this.field0791 = var1;
      return (T)this;
   }

   public <T extends Setting<Value>> T method2130(String var1) {
      this.field1269 = var1;
      return (T)this;
   }

   public String method2067() {
      if (this.field1030 != null) {
         return this.field1030;
      }

      String var1 = this.field1504.contains(".") ? this.field1504.substring(this.field1504.lastIndexOf(46) + 1) : this.field1504;
      if (var1.isEmpty()) {
         return this.field1504;
      }

      StringBuilder var2 = new StringBuilder();

      for (int var3 = 0; var3 < var1.length(); var3++) {
         char var4 = var1.charAt(var3);
         if (var3 > 0 && Character.isUpperCase(var4) && !Character.isUpperCase(var1.charAt(var3 - 1))) {
            var2.append(' ');
         }

         var2.append(var3 == 0 ? Character.toUpperCase(var4) : var4);
      }

      return var2.toString();
   }

   public String method1791() {
      if (this.field1269 != null && method1891()) {
         return this.field1269;
      } else {
         return this.field0791 != null ? this.field0791 : "";
      }
   }

   private static boolean method1891() {
      try {
         return ClickGuiDashboard.field0984.method0492() == ClickGuiDashboard.Language.field0631;
      } catch (Exception var1) {
         return true;
      }
   }

   public Consumer<Setting<Value>> method1622() {
      return this.field0211;
   }

   public void method1973() {
      if (this.field0211 != null) {
         this.field0211.accept(this);
      }
   }

   @Generated
   public String method0423() {
      return this.field1504;
   }

   @Generated
   public String method0368() {
      return this.field1269;
   }

   @Generated
   public Value method0492() {
      return this.field0714;
   }

   @Generated
   public Value method2223() {
      return this.field0135;
   }

   @Generated
   public Supplier<Boolean> method2193() {
      return this.field0337;
   }

   @Generated
   public Consumer<Setting<Value>> method2264() {
      return this.field0211;
   }

   @Generated
   public Module method1911() {
      return this.field0480;
   }

   @Generated
   public void method1846(String var1) {
      this.field1030 = var1;
   }

   @Generated
   public void method1656(String var1) {
      this.field0791 = var1;
   }

   @Generated
   public void method1985(String var1) {
      this.field1269 = var1;
   }

   @Generated
   public void method1841(Value var1) {
      this.field0135 = var1;
   }

   @Generated
   public void method1109(Supplier<Boolean> var1) {
      this.field0337 = var1;
   }

   @Generated
   public void method0227(Consumer<Setting<Value>> var1) {
      this.field0211 = var1;
   }

   @Generated
   public void method0889(Module var1) {
      this.field0480 = var1;
   }
}
