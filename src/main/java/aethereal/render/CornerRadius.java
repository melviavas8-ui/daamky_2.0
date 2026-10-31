package aethereal;

public record CornerRadius(float radius1, float radius2, float radius3, float radius4) {
   public static final CornerRadius NO_ROUND = new CornerRadius(0.0F, 0.0F, 0.0F, 0.0F);

   public CornerRadius(double var1, double var3, double var5, double var7) {
      this((float)var1, (float)var3, (float)var5, (float)var7);
   }

   public CornerRadius(double var1) {
      this(var1, var1, var1, var1);
   }

   public CornerRadius(float var1) {
      this(var1, var1, var1, var1);
   }

   public float method0530() {
      return this.radius1;
   }

   public float method0002() {
      return this.radius2;
   }

   public float method2047() {
      return this.radius3;
   }

   public float method1762() {
      return this.radius4;
   }
}
