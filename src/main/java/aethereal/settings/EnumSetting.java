package aethereal;

import java.util.function.Supplier;

public class EnumSetting<Value extends Enum<?>> extends Setting<Value> {
   public EnumSetting(String var1, Value var2) {
      super(var1, var2);
   }

   public EnumSetting(String var1, Value var2, Supplier<Boolean> var3) {
      super(var1, var2, var3);
   }

   public void method1890() {
      this.method0206((Value)EnumCycler.method0203(this.field0714));
   }

   public String method1935() {
      return ((DisplayNamed)this.field0714).method0557();
   }

   public void method0442(String var1) {
      for (Enum var5 : (Enum[])this.field0714.getClass().getEnumConstants()) {
         if (((DisplayNamed)var5).method0557().equalsIgnoreCase(var1)) {
            this.method0206(var5);
            break;
         }
      }
   }
}
