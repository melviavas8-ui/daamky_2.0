package aethereal;

import lombok.Generated;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public class Rotation {
   public static Rotation field0653 = new Rotation(0.0F, 0.0F);
   private float field0003;
   private float field1410;

   public static Rotation method1331(class_243 var0, class_243 var1, double var2) {
      double var4 = var1.field_1351 + var2 * 0.9000000168111054;
      double var6 = var1.field_1352 - var0.field_1352;
      double var8 = var4 - (var0.field_1351 + 1.5);
      double var10 = var1.field_1350 - var0.field_1350;
      float var12 = (float)Math.toDegrees(Math.atan2(var10, var6)) - 90.0F;
      var12 = class_3532.method_15393(var12);
      double var13 = Math.sqrt(var6 * var6 + var10 * var10);
      float var15 = (float)Math.toDegrees(-Math.atan2(var8, var13));
      var15 = class_3532.method_15363(var15, -90.0F, 90.0F);
      return new Rotation(var12, var15);
   }

   public Rotation method0545() {
      double var1 = MathHelper.method0529();
      Rotation var3 = RotationManager.field0618.method2258();
      float var4 = this.method0677(this.field0003, var3.field0003, var1);
      float var5 = this.method0677(this.field1410, var3.field1410, var1);
      return new Rotation(var4, class_3532.method_15363(var5, -90.0F, 90.0F));
   }

   public Rotation method0657(float var1) {
      return new Rotation(this.field0003 + MathHelper.method0667(-var1, var1), this.field1410 + MathHelper.method0667(-var1, var1));
   }

   private float method0677(float var1, float var2, double var3) {
      float var5 = class_3532.method_15393(var1 - var2);
      return var2 + (float)Math.round(var5 / var3) * (float)var3;
   }

   public final class_243 method0024() {
      float var1 = this.field1410 * (float) (Math.PI / 180.0);
      float var2 = -this.field0003 * (float) (Math.PI / 180.0);
      float var3 = class_3532.method_15362(var2);
      float var4 = class_3532.method_15374(var2);
      float var5 = class_3532.method_15362(var1);
      float var6 = class_3532.method_15374(var1);
      return new class_243(var4 * var5, -var6, var3 * var5);
   }

   public Rotation method0121(float var1) {
      return new Rotation(this.field0003 + var1, this.field1410);
   }

   public Rotation method2095(float var1) {
      this.field1410 = class_3532.method_15363(this.field1410 + var1, -90.0F, 90.0F);
      return this;
   }

   public Rotation method0868(Rotation var1) {
      return new Rotation(var1.method2047(), var1.method1762());
   }

   @Generated
   public float method2047() {
      return this.field0003;
   }

   @Generated
   public float method1762() {
      return this.field1410;
   }

   @Generated
   public void method1822(float var1) {
      this.field0003 = var1;
   }

   @Generated
   public void method1638(float var1) {
      this.field1410 = var1;
   }

   @Generated
   @Override
   public String toString() {
      return "Rotation(yaw=" + this.method2047() + ", pitch=" + this.method1762() + ")";
   }

   @Generated
   public Rotation(float var1, float var2) {
      this.field0003 = var1;
      this.field1410 = var2;
   }

   public static class VectorRotation {
      private final Rotation field0653;
      private final class_243 field0157;

      @Generated
      @Override
      public String toString() {
         return "Rotation.VectorRotation(angle=" + this.method0545() + ", vec=" + this.method0024() + ")";
      }

      @Generated
      public Rotation method0545() {
         return this.field0653;
      }

      @Generated
      public class_243 method0024() {
         return this.field0157;
      }

      @Generated
      public VectorRotation(Rotation var1, class_243 var2) {
         this.field0653 = var1;
         this.field0157 = var2;
      }
   }
}
