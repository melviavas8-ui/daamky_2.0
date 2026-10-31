package aethereal;

import java.awt.Color;

public final class ColorConverter {
   public static int method0748(int var0, int var1, int var2, int var3) {
      return (var3 & 0xFF) << 24 | (var0 & 0xFF) << 16 | (var1 & 0xFF) << 8 | (var2 & 0xFF) << 0;
   }

   public static int[] method0731(int var0) {
      return new int[]{var0 >> 16 & 0xFF, var0 >> 8 & 0xFF, var0 & 0xFF, var0 >> 24 & 0xFF};
   }

   public static float[] method0962(Color var0) {
      return new float[]{var0.getRed() / 255.0F, var0.getGreen() / 255.0F, var0.getBlue() / 255.0F, var0.getAlpha() / 255.0F};
   }

   public static float[] method0145(int var0) {
      int[] var1 = method0731(var0);
      return new float[]{var1[0] / 255.0F, var1[1] / 255.0F, var1[2] / 255.0F, var1[3] / 255.0F};
   }
}
