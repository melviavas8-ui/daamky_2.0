package aethereal;

import java.util.concurrent.ConcurrentLinkedQueue;

public class SelectedSlotTracker {
   private final ConcurrentLinkedQueue<Long> field0723 = new ConcurrentLinkedQueue<>();

   public void method0578() {
      this.field0723.add(System.currentTimeMillis() + 1000L);
   }

   public int method0003() {
      this.field0723.removeIf(var0 -> var0 < System.currentTimeMillis());
      return this.field0723.size();
   }

   public void method2078() {
      this.field0723.clear();
   }
}
