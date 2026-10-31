package aethereal;

import java.awt.Color;
import java.util.regex.Pattern;
import lombok.Generated;
import net.minecraft.class_9848;

public final class ColorMath {
   public static final Pattern field0727 = Pattern.compile("(?i)§[0-9a-f-or]");
   public static final int field0004 = method0146(0, 0.5F);
   public static final int field1411 = method1640(0);
   public static final int field0958 = method1640(255);
   public static final int field0759 = method0744(255, 0, 0);
   public static final int field1243 = method0744(0, 255, 0);
   public static final int field0315 = method0744(0, 0, 255);
   public static final int field0178 = method0744(255, 255, 0);

   public static int method0531() {
      Color var0 = ThemeColorManager.method1908().method1726();
      return 0xFF000000 | var0.getRed() << 16 | var0.getGreen() << 8 | var0.getBlue();
   }

   public static int method0003() {
      return new Color(60, 220, 120, 255).getRGB();
   }

   public static int method2048() {
      return method1640(255);
   }

   public static int method0646(float var0) {
      return method0146(255, var0);
   }

   public static int method0733(int var0, float var1) {
      return method0146(var0, var1);
   }

   public static int method0716(int var0) {
      return var0 >> 16 & 0xFF;
   }

   public static int method0137(int var0) {
      return var0 >> 8 & 0xFF;
   }

   public static int method2101(int var0) {
      return var0 & 0xFF;
   }

   public static int method1826(int var0) {
      return var0 >> 24 & 0xFF;
   }

   public static int method0748(int var0, int var1, int var2, int var3) {
      return (var3 & 0xFF) << 24 | (var0 & 0xFF) << 16 | (var1 & 0xFF) << 8 | var2 & 0xFF;
   }

   public static int method0744(int var0, int var1, int var2) {
      return method0748(var0, var1, var2, 255);
   }

   public static int method0747(int var0, int var1, int var2, float var3) {
      return method0748(var0, var1, var2, Math.round(var3 * 255.0F));
   }

   public static int method0146(int var0, float var1) {
      return method0748(var0, var0, var0, Math.round(var1 * 255.0F));
   }

   public static int method1640(int var0) {
      return method0748(var0, var0, var0, 255);
   }

   public static int method0150(int var0, int var1, int var2, int var3) {
      return method0748(var0, var1, var2, var3);
   }

   public static int method2104(int var0, float var1) {
      return method0748(method0716(var0), method0137(var0), method2101(var0), Math.round(method1826(var0) * var1));
   }

   public static int method1828(int var0, float var1) {
      return method0748(method0716(var0), method0137(var0), method2101(var0), Math.round(var1 * 255.0F));
   }

   public static int method1642(int var0, float var1) {
      return class_9848.method_61324(
         (int)(class_9848.method_61320(var0) * (var1 / 255.0F)), class_9848.method_61327(var0), class_9848.method_61329(var0), class_9848.method_61331(var0)
      );
   }

   public static int method0741(int var0, int var1, float var2) {
      int var3 = method1826(var0);
      int var4 = method1826(var1);
      int var5 = method0716(var0);
      int var6 = method0716(var1);
      int var7 = method0137(var0);
      int var8 = method0137(var1);
      int var9 = method2101(var0);
      int var10 = method2101(var1);
      int var11 = (int)(var3 + (var4 - var3) * var2);
      int var12 = (int)(var5 + (var6 - var5) * var2);
      int var13 = (int)(var7 + (var8 - var7) * var2);
      int var14 = (int)(var9 + (var10 - var9) * var2);
      return method0748(var12, var13, var14, var11);
   }

   public static int method0758(int var0, int var1, int[] var2) {
      if (var2 != null && var2.length != 0) {
         if (var2.length == 1) {
            return var2[0];
         }

         float var3 = var0 > 0 ? (float)(var1 % var0) / var0 : 0.0F;
         int var4 = (int)(var3 * (var2.length - 1));
         int var5 = Math.min(var4 + 1, var2.length - 1);
         float var6 = var3 * (var2.length - 1) - var4;
         return method0741(var2[var4], var2[var5], var6);
      } else {
         return method2048();
      }
   }

   public static int method1978(int var0) {
      float var1 = Math.abs(var0 * 2 % 120 - 60) / 60.0F;
      return method0741(method0744(90, 180, 255), method0744(180, 90, 220), var1);
   }

   public static int method0999(String var0) {
      String var1 = var0.startsWith("#") ? var0.substring(1) : var0;
      if (var1.length() == 6) {
         var1 = "FF" + var1;
      }

      long var2 = Long.parseLong(var1, 16);
      return (int)var2;
   }

   public static String method0212(String var0) {
      return var0 == null ? "" : field0727.matcher(var0).replaceAll("");
   }

   @Generated
   private ColorMath() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
