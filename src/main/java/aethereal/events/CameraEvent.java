package aethereal;

import lombok.Generated;
import net.minecraft.class_4184;

public final class CameraEvent extends CancellableEvent {
   private final class_4184 field0741;
   private float field0003;
   private double field1409;
   private double field0956;
   private double field0757;
   private float field1242;
   private float field0314;
   private boolean field0219;
   private float field0458;

   public CameraEvent(class_4184 var1, float var2, double var3, double var5, double var7) {
      this.field0741 = var1;
      this.field0003 = var2;
      this.field1409 = var3;
      this.field0956 = var5;
      this.field0757 = var7;
      this.field1242 = 0.0F;
      this.field0314 = 0.0F;
      this.field0219 = false;
      this.field0458 = 1.0F;
   }

   public CameraEvent(class_4184 var1, float var2, double var3, double var5, double var7, float var9, float var10, float var11) {
      this.field0741 = var1;
      this.field0003 = var2;
      this.field1409 = var3;
      this.field0956 = var5;
      this.field0757 = var7;
      this.field1242 = var9;
      this.field0314 = var10;
      this.field0219 = false;
      this.field0458 = var11;
   }

   public void method0675(float var1, float var2) {
      this.field1242 = var1;
      this.field0314 = var2;
      this.field0219 = true;
   }

   @Generated
   public class_4184 method1807() {
      return this.field0741;
   }

   @Generated
   public float method1603() {
      return this.field0003;
   }

   @Generated
   public double method1945() {
      return this.field1409;
   }

   @Generated
   public double method0412() {
      return this.field0956;
   }

   @Generated
   public double method0354() {
      return this.field0757;
   }

   @Generated
   public float method0483() {
      return this.field1242;
   }

   @Generated
   public float method2213() {
      return this.field0314;
   }

   @Generated
   public boolean method2195() {
      return this.field0219;
   }

   @Generated
   public float method2253() {
      return this.field0458;
   }

   @Generated
   public void method0665(float var1) {
      this.field0003 = var1;
   }

   @Generated
   public void method0611(double var1) {
      this.field1409 = var1;
   }

   @Generated
   public void method0103(double var1) {
      this.field0956 = var1;
   }

   @Generated
   public void method2086(double var1) {
      this.field0757 = var1;
   }

   @Generated
   public void method0124(float var1) {
      this.field1242 = var1;
   }

   @Generated
   public void method2098(float var1) {
      this.field0314 = var1;
   }

   @Generated
   public void method0345(boolean var1) {
      this.field0219 = var1;
   }

   @Generated
   public void method1822(float var1) {
      this.field0458 = var1;
   }
}
