package aethereal;

import lombok.Generated;
import net.minecraft.class_10185;

public class MoveInputEvent extends CancellableEvent {
   private class_10185 field0729;
   private float field0003;
   private float field1410;

   @Generated
   public class_10185 method1797() {
      return this.field0729;
   }

   @Generated
   public float method1603() {
      return this.field0003;
   }

   @Generated
   public float method1946() {
      return this.field1410;
   }

   @Generated
   public void method1114(class_10185 var1) {
      this.field0729 = var1;
   }

   @Generated
   public void method0665(float var1) {
      this.field0003 = var1;
   }

   @Generated
   public void method0124(float var1) {
      this.field1410 = var1;
   }

   @Generated
   public MoveInputEvent(class_10185 var1, float var2, float var3) {
      this.field0729 = var1;
      this.field0003 = var2;
      this.field1410 = var3;
   }
}
