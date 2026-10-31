package aethereal;

import lombok.Generated;
import net.minecraft.class_1268;
import net.minecraft.class_4587;

public class HandAnimationEvent extends CancellableEvent {
   private class_4587 field0743;
   private class_1268 field0148;
   private float field1410;

   @Generated
   public class_4587 method1808() {
      return this.field0743;
   }

   @Generated
   public class_1268 method1624() {
      return this.field0148;
   }

   @Generated
   public float method1946() {
      return this.field1410;
   }

   @Generated
   public void method1452(class_4587 var1) {
      this.field0743 = var1;
   }

   @Generated
   public void method1119(class_1268 var1) {
      this.field0148 = var1;
   }

   @Generated
   public void method0665(float var1) {
      this.field1410 = var1;
   }

   @Generated
   public HandAnimationEvent(class_4587 var1, class_1268 var2, float var3) {
      this.field0743 = var1;
      this.field0148 = var2;
      this.field1410 = var3;
   }
}
