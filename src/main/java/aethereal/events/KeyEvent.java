package aethereal;

import lombok.Generated;

public class KeyEvent extends CancellableEvent {
   private int field0567;
   private int field0004;
   private int field1411;

   @Generated
   public KeyEvent(int var1, int var2, int var3) {
      this.field0567 = var1;
      this.field0004 = var2;
      this.field1411 = var3;
   }

   @Generated
   public int method1763() {
      return this.field0567;
   }

   @Generated
   public int method1604() {
      return this.field0004;
   }

   @Generated
   public int method1947() {
      return this.field1411;
   }
}
