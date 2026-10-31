package aethereal;

import lombok.Generated;

public class CancellableEvent {
   private boolean field0751;

   public void method0578() {
      this.field0751 = true;
   }

   public void method0025() {
      this.field0751 = false;
   }

   public void method1570(boolean var1) {
      this.field0751 = var1;
   }

   @Generated
   public boolean method2079() {
      return this.field0751;
   }
}
