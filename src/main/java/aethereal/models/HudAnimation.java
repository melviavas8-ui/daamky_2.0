package aethereal;

import lombok.Generated;

public class HudAnimation {
   private float field0566;
   private float field0003;
   private EasingCurve field1477;
   private Animation field1000 = new Animation(0L, 0.0, false, EasingCurve.field0672);

   public HudAnimation(EasingCurve var1) {
      this.field1477 = var1;
   }

   public float method0705(float var1, long var2) {
      var2 = Math.max(1L, var2);
      this.field0566 = this.field0003 - this.field1000.method0002();
      this.field0003 = var1;
      if (this.field0566 != this.field0003 - var1) {
         this.field1000 = new Animation(var2, this.field0003 - this.field0566, false, this.field1477);
      }

      return this.field0566;
   }

   public float method0530() {
      this.field0566 = this.field0003 - this.field1000.method0002();
      return this.field0566;
   }

   public boolean method0026() {
      return this.field0566 == this.field0003 || this.field1000.method0579() || this.field1000.method0346(false);
   }

   public float method2047() {
      this.field0566 = this.field0003 - this.field1000.method0002();
      return this.field0566;
   }

   @Generated
   public void method0901(EasingCurve var1) {
      this.field1477 = var1;
   }

   @Generated
   public Animation method1780() {
      return this.field1000;
   }
}
