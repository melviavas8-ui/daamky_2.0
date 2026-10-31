package aethereal;

import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_5250;

public final class LegacyTextParser {
   private LegacyTextParser() {
   }

   public static int[] method1015(String var0) {
      return switch (var0) {
         case "Дезориентация" -> new int[]{
            ColorMath.method0999("#00FF6A"), ColorMath.method0999("#2761F5"), ColorMath.method0999("#B80081")
         };
         case "Божья аура" -> new int[]{ColorMath.method0999("#FBFF00"), ColorMath.method0999("#FF9873"), ColorMath.method0999("#FF9873")};
         case "Пласт" -> new int[]{ColorMath.method0999("#3B005E"), ColorMath.method0999("#8900DB"), ColorMath.method0999("#8900DB")};
         case "Трапка" -> new int[]{ColorMath.method0999("#8F0000"), ColorMath.method0999("#DE0000"), ColorMath.method0999("#FF0000")};
         case "Огненный смерч" -> new int[]{
            ColorMath.method0999("#ED0000"), ColorMath.method0999("#FF682B"), ColorMath.method0999("#FF682B")
         };
         case "Снежок заморозка" -> new int[]{
            ColorMath.method0999("#2BFFCE"), ColorMath.method0999("#00E6B0"), ColorMath.method0999("#00E6B0")
         };
         case "Явная пыль" -> new int[]{ColorMath.method0999("#00FFFA"), ColorMath.method0999("#00FF95"), ColorMath.method0999("#00FF95")};
         case "Зелье мочи Флеша" -> new int[]{ColorMath.method0999("#00799E"), ColorMath.method0999("#00FFFF")};
         case "Зелье медика" -> new int[]{ColorMath.method0999("#8A007D"), ColorMath.method0999("#FF00E8")};
         case "Зелье агента" -> new int[]{ColorMath.method0999("#D99A00"), ColorMath.method0999("#FFEE00")};
         case "Зелье победителя" -> new int[]{ColorMath.method0999("#00821F"), ColorMath.method0999("#00FF3D")};
         case "Зелье киллера" -> new int[]{ColorMath.method0999("#9C0000"), ColorMath.method0999("#FF0F0F")};
         case "Зелье отрыжки" -> new int[]{ColorMath.method0999("#CC4E00"), ColorMath.method0999("#FFA100")};
         case "Зелье серной кислоты" -> new int[]{ColorMath.method0999("#319C00"), ColorMath.method0999("#4AEB00")};
         case "Зелье вспышки" -> new int[]{ColorMath.method0999("#D48600"), ColorMath.method0999("#FFE600")};
         default -> new int[]{ColorMath.method2048()};
      };
   }

   public static class_5250 method1064(String var0, int[] var1, boolean var2) {
      class_5250 var3 = class_2561.method_43473();
      String var4 = var2 ? "[★] " + var0 : var0;
      if (var1.length == 2 && var2) {
         var3.method_10852(class_2561.method_43470("[★] ").method_27692(class_124.field_1070).method_27694(var1x -> var1x.method_36139(var1[0])));
         var3.method_10852(class_2561.method_43470(var0).method_27692(class_124.field_1070).method_27694(var1x -> var1x.method_36139(var1[1])));
      } else if (var1.length != 0 && (var1.length != 1 || var1[0] != ColorMath.method2048())) {
         int var5 = var4.length();
         int var6 = var1.length;

         for (int var7 = 0; var7 < var5; var7++) {
            float var8 = var5 == 1 ? 0.0F : (float)var7 / (var5 - 1);
            int var9 = (int)(var8 * (var6 - 1));
            int var10 = var1[var9];
            int var11 = var1[Math.min(var9 + 1, var6 - 1)];
            float var12 = var8 * (var6 - 1) - var9;
            int var13 = ColorMath.method0741(var10, var11, var12);
            int var14 = var13;
            var3.method_10852(
               class_2561.method_43470(String.valueOf(var4.charAt(var7))).method_27692(class_124.field_1070).method_27694(var1x -> var1x.method_36139(var14))
            );
         }
      } else {
         var3.method_10852(class_2561.method_43470(var4).method_27692(class_124.field_1070));
      }

      return var3;
   }
}
