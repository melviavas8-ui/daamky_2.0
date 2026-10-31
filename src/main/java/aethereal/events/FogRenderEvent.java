package aethereal;

import lombok.Generated;

public class FogRenderEvent extends CancellableEvent {
   private float field0566;
   private int field0004;

   @Generated
   public float method1762() {
      return this.field0566;
   }

   @Generated
   public int method1604() {
      return this.field0004;
   }

   @Generated
   public void method0665(float var1) {
      this.field0566 = var1;
   }

   @Generated
   public void method0729(int var1) {
      this.field0004 = var1;
   }
}
