package aethereal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class DelayedAction {
   private final TreeMap<Integer, List<DelayedAction.ScheduledAction>> field0722 = new TreeMap<>();
   private int field0004 = 0;
   private boolean field1527 = false;

   public DelayedAction method0765(int var1, Runnable var2, int var3) {
      this.field0722.computeIfAbsent(var1, var0 -> new ArrayList<>()).add(new DelayedAction.ScheduledAction(var2, var3));
      if (!this.field1527) {
         this.field1527 = true;
         this.field0004 = 0;
      }

      return this;
   }

   public void method0578() {
      this.field0722.clear();
      this.field0004 = 0;
      this.field1527 = false;
   }

   public boolean method0026() {
      return !this.field1527;
   }

   public void method2078() {
      if (this.field1527) {
         this.field0004++;
         List var1 = this.field0722.get(this.field0004);
         if (var1 != null) {
            var1.sort(Comparator.comparingInt(var0 -> var0.priority));

            for (DelayedAction.ScheduledAction var3 : var1) {
               var3.action.run();
            }
         }

         if (this.field0722.isEmpty() || this.field0004 >= this.field0722.lastKey()) {
            this.field1527 = false;
            this.field0722.clear();
            this.field0004 = 0;
         }
      }
   }

   private record ScheduledAction(Runnable action, int priority) {
      public Runnable method0556() {
         return this.action;
      }

      public int method0003() {
         return this.priority;
      }
   }
}
