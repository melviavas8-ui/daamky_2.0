package aethereal;

public final class TextTruncator {
   public static String method0831(FontSize var0, String var1, float var2) {
      StringBuilder var3 = new StringBuilder();
      String[] var4 = var1.split(" ");
      float var5 = 0.0F;

      for (String var9 : var4) {
         float var10 = var0.method1016(var9, 0.05F);
         if (var5 + var10 > var2) {
            var3.append("\n");
            var5 = 0.0F;
         } else if (var5 > 0.0F) {
            var3.append(" ");
            var5 += var0.method0998(" ");
         }

         var5 += var10;
         var3.append(var9);
      }

      return var3.toString();
   }
}
