package aethereal;

import java.awt.Color;

public record QuadColor(int color1, int color2, int color3, int color4) {
   public static final QuadColor TRANSPARENT = new QuadColor(0, 0, 0, 0);
   public static final QuadColor WHITE = new QuadColor(-1, -1, -1, -1);

   public QuadColor(Color var1, Color var2, Color var3, Color var4) {
      this(var1.getRGB(), var2.getRGB(), var3.getRGB(), var4.getRGB());
   }

   public QuadColor(Color var1) {
      this(var1, var1, var1, var1);
   }

   public QuadColor(int var1) {
      this(var1, var1, var1, var1);
   }

   public int method0531() {
      return this.color1;
   }

   public int method0003() {
      return this.color2;
   }

   public int method2048() {
      return this.color3;
   }

   public int method1763() {
      return this.color4;
   }
}
