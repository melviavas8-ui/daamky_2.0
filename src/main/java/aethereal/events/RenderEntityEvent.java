package aethereal;

import lombok.Generated;
import net.minecraft.class_1297;
import net.minecraft.class_4587;
import net.minecraft.class_4597;

public class RenderEntityEvent extends CancellableEvent {
   private final class_1297 field0730;
   private class_4597 field0165;
   private final double field1409;
   private final double field0956;
   private final double field0757;
   private final float field1242;
   private final class_4587 field0340;

   @Generated
   public RenderEntityEvent(class_1297 var1, class_4597 var2, double var3, double var5, double var7, float var9, class_4587 var10) {
      this.field0730 = var1;
      this.field0165 = var2;
      this.field1409 = var3;
      this.field0956 = var5;
      this.field0757 = var7;
      this.field1242 = var9;
      this.field0340 = var10;
   }

   @Generated
   public class_1297 method1798() {
      return this.field0730;
   }

   @Generated
   public class_4597 method1630() {
      return this.field0165;
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
   public class_4587 method2227() {
      return this.field0340;
   }

   @Generated
   public void method1516(class_4597 var1) {
      this.field0165 = var1;
   }

   public static class Pre extends CancellableEvent {
   }
}
