package aethereal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lombok.Generated;

public class AnimatedValue<T> {
   private final List<AnimatedValue.ValueState<T>> field0719 = new ArrayList<>();

   public void method0862(AnimatedValue.ValueState<T> var1) {
      this.field0719.removeIf(var1x -> var1x.field1469 == var1.field1469);
      this.field0719.add(var1);
      this.field0719.sort(Comparator.comparingInt(AnimatedValue.ValueState::method2048).reversed());
   }

   public T method0555() {
      return this.field0719.isEmpty() ? null : this.field0719.get(0).field1029;
   }

   public AnimatedValue.ValueState<T> method0011() {
      return this.field0719.isEmpty() ? null : this.field0719.get(0);
   }

   public void method2078() {
      this.field0719.forEach(AnimatedValue.ValueState::method0578);
      this.field0719.removeIf(var0 -> var0.field0567 <= 0);
   }

   public static class ValueState<T> {
      private int field0567;
      private final int field0004;
      private final Module field1469;
      private final T field1029;

      public void method0578() {
         this.field0567--;
      }

      @Generated
      public int method0003() {
         return this.field0567;
      }

      @Generated
      public int method2048() {
         return this.field0004;
      }

      @Generated
      public Module method1782() {
         return this.field1469;
      }

      @Generated
      public T method1618() {
         return this.field1029;
      }

      @Generated
      public ValueState(int var1, int var2, Module var3, T var4) {
         this.field0567 = var1;
         this.field0004 = var2;
         this.field1469 = var3;
         this.field1029 = var4;
      }
   }
}
