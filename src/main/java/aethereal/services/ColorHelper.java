package aethereal;

import java.awt.Color;
import java.nio.ByteBuffer;
import lombok.Generated;
import net.minecraft.class_3532;
import org.lwjgl.opengl.GL11;

public final class ColorHelper implements MinecraftAccess {
   public static Color method0672(float var0, float var1) {
      ByteBuffer var2 = ByteBuffer.allocateDirect(4);
      GL11.glReadPixels(
         (int)(var0 * field0796.method_22683().method_4495()),
         (int)((field0796.method_22683().method_4502() - var1) * field0796.method_22683().method_4495()),
         1,
         1,
         6408,
         5121,
         var2
      );
      return new Color(var2.get() & 255, var2.get() & 255, var2.get() & 255);
   }

   public static Color method0966(Color var0, int var1) {
      return new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), var1);
   }

   public static Color method0969(Color var0, Color var1, float var2) {
      int var3 = (int)(var0.getRed() * (1.0F - var2) + var1.getRed() * var2);
      int var4 = (int)(var0.getGreen() * (1.0F - var2) + var1.getGreen() * var2);
      int var5 = (int)(var0.getBlue() * (1.0F - var2) + var1.getBlue() * var2);
      int var6 = (int)(var0.getAlpha() * (1.0F - var2) + var1.getAlpha() * var2);
      return new Color(var3, var4, var5, var6);
   }

   public static Color method0967(Color var0, long var1) {
      var1 = class_3532.method_53062(var1, 0L, 30L);
      double var3 = Math.sin(
         6.283186745622039 * ((float)var1 / 30.0F) * ((float)(System.currentTimeMillis() - DaamkyClient.method2004().method2020()) / 1000.0F)
      );
      double var5 = (var3 + 1.0) / 2.0;
      return new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), (int)(var0.getAlpha() * var5));
   }

   public static Color method0960(Color var0) {
      return method0967(var0, 15L);
   }

   public static Color method0197(Color var0, int var1) {
      return method0966(var0, var1);
   }

   public static Color method0964(Color var0, float var1) {
      var1 = class_3532.method_15363(var1, 0.0F, 1.0F);
      return new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), (int)(var0.getAlpha() * var1));
   }

   public static Color method0723(int var0) {
      return new Color(68, 91, 150, var0);
   }

   public static Color method0553() {
      return method0723(255);
   }

   public static Color method0198(Color var0, Color var1, float var2) {
      var2 = class_3532.method_15363(var2, 0.0F, 1.0F);
      int var3 = class_3532.method_48781(var2, var0.getRed(), var1.getRed());
      int var4 = class_3532.method_48781(var2, var0.getGreen(), var1.getGreen());
      int var5 = class_3532.method_48781(var2, var0.getBlue(), var1.getBlue());
      int var6 = class_3532.method_48781(var2, var0.getAlpha(), var1.getAlpha());
      return new Color(var3, var4, var5, var6);
   }

   public static String method1010(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         StringBuilder var1 = new StringBuilder();
         int var2 = 0;

         while (var2 < var0.length()) {
            if (var2 + 14 <= var0.length() && var0.charAt(var2) == '&' && var2 + 1 < var0.length() && var0.charAt(var2 + 1) == 'x') {
               String var3 = method1024(var0, var2);
               if (var3 != null) {
                  var1.append(var3);
                  var2 += 14;
                  continue;
               }
            }

            char var5 = var0.charAt(var2);
            if (var5 == '&' && var2 + 1 < var0.length()) {
               char var4 = var0.charAt(var2 + 1);
               if (method0606(var4)) {
                  var1.append('§').append(var4);
                  var2 += 2;
                  continue;
               }
            }

            var1.append(var5);
            var2++;
         }

         return var1.toString();
      } else {
         return var0;
      }
   }

   private static String method1024(String var0, int var1) {
      if (var1 + 14 > var0.length()) {
         return null;
      }

      StringBuilder var2 = new StringBuilder("§x");

      for (int var3 = 0; var3 < 6; var3++) {
         int var4 = var1 + 2 + var3 * 2;
         if (var4 + 1 >= var0.length() || var0.charAt(var4) != '&') {
            return null;
         }

         char var5 = var0.charAt(var4 + 1);
         if (!method0101(var5)) {
            return null;
         }

         var2.append('§').append(Character.toLowerCase(var5));
      }

      return var2.toString();
   }

   private static boolean method0606(char var0) {
      return var0 >= '0' && var0 <= '9'
         || var0 >= 'a' && var0 <= 'f'
         || var0 >= 'A' && var0 <= 'F'
         || var0 >= 'k' && var0 <= 'o'
         || var0 >= 'K' && var0 <= 'O'
         || var0 == 'r'
         || var0 == 'R';
   }

   private static boolean method0101(char var0) {
      return var0 >= '0' && var0 <= '9' || var0 >= 'a' && var0 <= 'f' || var0 >= 'A' && var0 <= 'F';
   }

   public static Color method0211(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         if (var0.startsWith("#")) {
            var0 = var0.substring(1);
         }

         if (var0.length() != 6) {
            return Color.WHITE;
         }

         try {
            int var1 = Integer.parseInt(var0.substring(0, 2), 16);
            int var2 = Integer.parseInt(var0.substring(2, 4), 16);
            int var3 = Integer.parseInt(var0.substring(4, 6), 16);
            return new Color(var1, var2, var3);
         } catch (NumberFormatException var4) {
            return Color.WHITE;
         }
      } else {
         return Color.WHITE;
      }
   }

   @Generated
   private ColorHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
