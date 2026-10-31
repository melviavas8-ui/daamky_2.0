package aethereal;

import lombok.Generated;

public class IntervalTimer {
   private long field0568;

   public IntervalTimer() {
      this.method0578();
   }

   public boolean method0612(double var1) {
      return System.currentTimeMillis() - var1 >= this.field0568;
   }

   public boolean method0104(double var1) {
      boolean var3 = this.method0612(var1);
      if (var3) {
         this.method0578();
      }

      return var3;
   }

   public void method0578() {
      this.field0568 = System.currentTimeMillis();
   }

   public long method0004() {
      return System.currentTimeMillis() - this.field0568;
   }

   public IntervalTimer method0776(long var1) {
      this.field0568 = System.currentTimeMillis() - var1;
      return this;
   }

   @Generated
   public long method2049() {
      return this.field0568;
   }
}
