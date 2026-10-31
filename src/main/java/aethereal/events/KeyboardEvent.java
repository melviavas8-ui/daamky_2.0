package aethereal;

import lombok.Generated;

public class KeyboardEvent extends CancellableEvent {
   private float field0566;
   private float field0003;
   private boolean field1527;
   private boolean field1049;
   private boolean field0798;

   @Generated
   public float method1762() {
      return this.field0566;
   }

   @Generated
   public float method1603() {
      return this.field0003;
   }

   @Generated
   public boolean method1974() {
      return this.field1527;
   }

   @Generated
   public boolean method0431() {
      return this.field1049;
   }

   @Generated
   public boolean method0376() {
      return this.field0798;
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
   public void method0345(boolean var1) {
      this.field1527 = var1;
   }

   @Generated
   public void method2178(boolean var1) {
      this.field1049 = var1;
   }

   @Generated
   public void method1876(boolean var1) {
      this.field0798 = var1;
   }

   @Generated
   public KeyboardEvent(float var1, float var2, boolean var3, boolean var4, boolean var5) {
      this.field0566 = var1;
      this.field0003 = var2;
      this.field1527 = var3;
      this.field1049 = var4;
      this.field0798 = var5;
   }
}
