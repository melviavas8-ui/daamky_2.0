package aethereal;

import java.awt.Color;
import java.util.Objects;
import java.util.function.Supplier;

public final class ColorSetting extends Setting<Color> {
   private static final int field1411 = 0;
   private static final int field0958 = 255;
   private boolean field0798 = false;

   public ColorSetting(String var1, Color var2) {
      super(var1, Objects.requireNonNull(var2));
   }

   public ColorSetting(String var1, Color var2, Supplier<Boolean> var3) {
      super(var1, Objects.requireNonNull(var2), var3);
   }

   public ColorSetting(String var1, int var2, int var3, int var4, int var5) {
      this(var1, method0151(var2, var3, var4, var5));
   }

   public ColorSetting(String var1, int var2, int var3, int var4, int var5, Supplier<Boolean> var6) {
      this(var1, method0151(var2, var3, var4, var5), var6);
   }

   public ColorSetting method1882() {
      this.field0798 = true;
      return this;
   }

   public boolean method1938() {
      return this.field0798;
   }

   public void method1570(boolean var1) {
      this.field0798 = var1;
   }

   private static Color method0151(int var0, int var1, int var2, int var3) {
      method1641(var0);
      method1641(var1);
      method1641(var2);
      method1641(var3);
      return new Color(var0, var1, var2, var3);
   }

   private static void method1641(int var0) {
      if (var0 < 0 || var0 > 255) {
         throw new IllegalArgumentException("Color component must be between 0 and 255: " + var0);
      }
   }

   public Color method1726() {
      if (this.field0798 && ThemeColorManager.method1908().method1938()) {
         Color var1 = ThemeColorManager.method1908().method2063();
         Color var2 = (Color)super.method0492();
         return new Color(var1.getRed(), var1.getGreen(), var1.getBlue(), var2.getAlpha());
      } else {
         return (Color)super.method0492();
      }
   }

   public Color method1687() {
      return (Color)super.method0492();
   }

   public int method1742() {
      return this.method1726().getRed();
   }

   public int method2019() {
      return this.method1726().getGreen();
   }

   public int method2002() {
      return this.method1726().getBlue();
   }

   public int method2036() {
      return this.method1726().getAlpha();
   }

   public void method0729(int var1) {
      method1641(var1);
      this.field0798 = false;
      this.method0206(new Color(var1, this.method2019(), this.method2002(), this.method2036()));
   }

   public void method0143(int var1) {
      method1641(var1);
      this.field0798 = false;
      this.method0206(new Color(this.method1742(), var1, this.method2002(), this.method2036()));
   }

   public void method2102(int var1) {
      method1641(var1);
      this.field0798 = false;
      this.method0206(new Color(this.method1742(), this.method2019(), var1, this.method2036()));
   }

   public void method1827(int var1) {
      method1641(var1);
      Color var2 = this.method1687();
      this.method0206(new Color(var2.getRed(), var2.getGreen(), var2.getBlue(), var1));
   }

   public void method0749(int var1, int var2, int var3, int var4) {
      this.field0798 = false;
      this.method0206(method0151(var1, var2, var3, var4));
   }
}
