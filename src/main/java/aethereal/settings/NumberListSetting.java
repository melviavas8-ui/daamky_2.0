package aethereal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class NumberListSetting extends Setting<Object> {
   private static final Object field1502 = new Object();
   private final List<NumberListSetting.NumberEntry> field1032 = new ArrayList<>();

   public NumberListSetting(String var1) {
      super(var1, field1502);
   }

   public NumberListSetting(String var1, Supplier<Boolean> var2) {
      super(var1, field1502, var2);
   }

   public NumberListSetting method0838(FloatSetting var1, Supplier<Boolean> var2) {
      this.field1032.add(new NumberListSetting.NumberEntry(var1, var2));
      return this;
   }

   public NumberListSetting method0836(FloatSetting var1) {
      return this.method0838(var1, () -> true);
   }

   public List<NumberListSetting.NumberEntry> method1889() {
      return this.field1032;
   }

   public int method1929() {
      int var1 = 0;

      for (NumberListSetting.NumberEntry var3 : this.field1032) {
         if (var3.method0026()) {
            var1++;
         }
      }

      return var1;
   }

   public static final class NumberEntry {
      private final FloatSetting field0628;
      private final Supplier<Boolean> field0144;

      public NumberEntry(FloatSetting var1, Supplier<Boolean> var2) {
         this.field0628 = var1;
         this.field0144 = var2;
      }

      public FloatSetting method0537() {
         return this.field0628;
      }

      public boolean method0026() {
         return this.field0144.get();
      }
   }
}
