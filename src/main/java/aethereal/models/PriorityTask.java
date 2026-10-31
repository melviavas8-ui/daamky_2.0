package aethereal;

import java.util.PriorityQueue;
import lombok.Generated;

public class PriorityTask<T> {
   public int field0567 = 0;
   public PriorityQueue<PriorityTask.TaskValue<T>> field0141 = new PriorityQueue<>((var0, var1) -> Integer.compare(var1.field0004, var0.field0004));

   public void method0729(int var1) {
      this.field0567 += var1;
   }

   public void method0859(PriorityTask.TaskValue<T> var1) {
      this.field0141.removeIf(var1x -> var1x.field1469.equals(var1.field1469));
      var1.field0567 = var1.field0567 + this.field0567;
      this.field0141.add(var1);
   }

   public T method0555() {
      while (
         !this.field0141.isEmpty()
            && this.field0141.peek() != null
            && (this.field0141.peek().field0567 <= this.field0567 || !this.field0141.peek().field1469.method2195())
      ) {
         this.field0141.poll();
      }

      if (this.field0141.isEmpty()) {
         return null;
      } else {
         return this.field0141.peek() != null ? this.field0141.peek().field1029 : null;
      }
   }

   public static class TaskValue<T> {
      private int field0567;
      private final int field0004;
      private final Module field1469;
      private final T field1029;

      @Generated
      @Override
      public String toString() {
         return "TaskProcessor.Task(expiresIn="
            + this.field0567
            + ", priority="
            + this.field0004
            + ", provider="
            + this.field1469
            + ", value="
            + this.field1029
            + ")";
      }

      @Generated
      public TaskValue(int var1, int var2, Module var3, T var4) {
         this.field0567 = var1;
         this.field0004 = var2;
         this.field1469 = var3;
         this.field1029 = var4;
      }
   }
}
