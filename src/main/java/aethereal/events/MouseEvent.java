package aethereal;

import lombok.Generated;

public class MouseEvent extends CancellableEvent {
   private int field0567;
   private int field0004;

   @Generated
   public MouseEvent(int var1, int var2) {
      this.field0567 = var1;
      this.field0004 = var2;
   }

   @Generated
   public int method1763() {
      return this.field0567;
   }

   @Generated
   public int method1604() {
      return this.field0004;
   }
}
