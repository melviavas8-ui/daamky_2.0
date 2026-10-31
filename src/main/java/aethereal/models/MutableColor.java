package aethereal;

import java.awt.Color;

public class MutableColor extends Color {
   private int field0567;

   public MutableColor() {
      super(0, true);
      this.field0567 = 0;
   }

   public MutableColor(int var1) {
      super(0, true);
      this.field0567 = var1;
   }

   public void method0729(int var1) {
      this.field0567 = var1;
   }

   public void method0749(int var1, int var2, int var3, int var4) {
      this.field0567 = (var4 & 0xFF) << 24 | (var1 & 0xFF) << 16 | (var2 & 0xFF) << 8 | var3 & 0xFF;
   }

   @Override
   public int getAlpha() {
      return this.field0567 >> 24 & 0xFF;
   }

   @Override
   public int getRed() {
      return this.field0567 >> 16 & 0xFF;
   }

   @Override
   public int getGreen() {
      return this.field0567 >> 8 & 0xFF;
   }

   @Override
   public int getBlue() {
      return this.field0567 & 0xFF;
   }

   @Override
   public int getRGB() {
      return this.field0567;
   }

   @Override
   public float[] getRGBComponents(float[] var1) {
      float[] var2 = var1 != null && var1.length >= 4 ? var1 : new float[4];
      var2[0] = this.getRed() / 255.0F;
      var2[1] = this.getGreen() / 255.0F;
      var2[2] = this.getBlue() / 255.0F;
      var2[3] = this.getAlpha() / 255.0F;
      return var2;
   }

   @Override
   public float[] getComponents(float[] var1) {
      return this.getRGBComponents(var1);
   }
}
