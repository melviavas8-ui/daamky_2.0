package aethereal;

import lombok.Generated;

public class Animation {
   private final Stopwatch field0648 = new Stopwatch();
   private long field0005;
   private final EasingCurve field1477;
   private boolean field1049;
   private double field0757;

   public Animation(long var1, double var3, boolean var5, EasingCurve var6) {
      this.field0005 = var1;
      this.field0757 = var3;
      this.field1049 = var5;
      this.field1477 = var6;
   }

   public void method1570(boolean var1) {
      if (this.field1049 != var1) {
         this.field1049 = var1;
         long var2 = Math.min(this.field0005, this.field0648.method0415());
         this.field0648.method0436(System.currentTimeMillis() - (this.field0005 - var2));
      }
   }

   public boolean method0346(boolean var1) {
      return this.field0648.method0161(this.field0005) && var1 == this.field1049;
   }

   public boolean method0579() {
      return this.field0648.method0161(this.field0005) && this.field1049;
   }

   public float method0002() {
      if (this.field1049) {
         return this.field0648.method0161(this.field0005)
            ? (float)this.field0757
            : (float)(this.field1477.method0608((double)this.field0648.method0415() / this.field0005) * this.field0757);
      } else {
         return this.field0648.method0161(this.field0005)
            ? 0.0F
            : (float)((1.0 - this.field1477.method0608((double)this.field0648.method0415() / this.field0005)) * this.field0757);
      }
   }

   public float method2047() {
      if (this.field1049) {
         return this.field0648.method0161(this.field0005)
            ? (float)this.field0757
            : (float)((double)this.field0648.method0415() / this.field0005 * this.field0757);
      } else {
         return this.field0648.method0161(this.field0005) ? 0.0F : (float)((1.0 - (double)this.field0648.method0415() / this.field0005) * this.field0757);
      }
   }

   public float method1762() {
      return 1.0F - this.method0002();
   }

   public void method1634() {
      this.field0648.method1812();
   }

   public void method1973() {
      this.field0648.method0436(System.currentTimeMillis() - this.field0005 - 1L);
   }

   public void method0430() {
      if (this.method0579()) {
         this.method1570(false);
      } else if (this.method0346(false)) {
         this.method1570(true);
      }
   }

   @Generated
   public void method0778(long var1) {
      this.field0005 = var1;
   }

   @Generated
   public boolean method0376() {
      return this.field1049;
   }

   @Generated
   public void method0611(double var1) {
      this.field0757 = var1;
   }
}
