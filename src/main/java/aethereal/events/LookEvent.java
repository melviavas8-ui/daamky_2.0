package aethereal;

import lombok.Generated;

public class LookEvent extends CancellableEvent {
   private float field0566;
   private float field0003;

   @Generated
   public float method1762() {
      return this.field0566;
   }

   @Generated
   public float method1603() {
      return this.field0003;
   }

   @Generated
   public void method0665(float var1) {
      this.field0566 = var1;
   }

   @Generated
   public void method0124(float var1) {
      this.field0003 = var1;
   }

   @Generated
   public LookEvent(float var1, float var2) {
      this.field0566 = var1;
      this.field0003 = var2;
   }
}
