package aethereal;

public record RenderSize(float width, float height) {
   public static final RenderSize NONE = new RenderSize(0.0F, 0.0F);

   public RenderSize(double var1, double var3) {
      this((float)var1, (float)var3);
   }

   public float method0530() {
      return this.width;
   }

   public float method0002() {
      return this.height;
   }
}
