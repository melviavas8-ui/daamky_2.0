package aethereal;

import java.util.Arrays;

public class CyclicIntSequence {
   private final int[][] field0755;
   private final int field0004;
   private final int field1411;
   private int field0958 = 0;
   private int field0759 = 0;

   public CyclicIntSequence(int var1, int var2) {
      this.field0004 = var1;
      this.field1411 = var2;
      this.field0755 = new int[var2][var1];
   }

   public void method1581(int[] var1) {
      if (var1.length != this.field0004) {
         throw new IllegalArgumentException("Array length must match cycle length");
      }

      System.arraycopy(var1, 0, this.field0755[this.field0958], 0, this.field0004);
   }

   public Integer method0724(int var1) {
      int var2 = (this.field0759 + var1) % this.field0004;
      return this.field0755[this.field0958][var2];
   }

   public boolean method0579() {
      return this.method0144(1);
   }

   public boolean method0144(int var1) {
      this.field0759 += var1;
      if (this.field0759 >= this.field0004) {
         this.field0759 = 0;
         this.field0958 = (this.field0958 + 1) % this.field1411;
         return true;
      } else {
         return false;
      }
   }

   public void method0025() {
      for (int[] var4 : this.field0755) {
         Arrays.fill(var4, 0);
      }

      this.field0958 = 0;
      this.field0759 = 0;
   }

   public int method2048() {
      return this.field1411;
   }
}
