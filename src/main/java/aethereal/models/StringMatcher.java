package aethereal;

public class StringMatcher {
   public static boolean method1014(String var0) {
      try {
         Integer.parseInt(var0);
         return true;
      } catch (Exception var2) {
         var2.printStackTrace();
         return false;
      }
   }

   public static boolean method0214(String var0) {
      try {
         Float.parseFloat(var0);
         return true;
      } catch (Exception var2) {
         var2.printStackTrace();
         return false;
      }
   }

   public static boolean method2135(String var0) {
      try {
         Double.parseDouble(var0);
         return true;
      } catch (Exception var2) {
         var2.printStackTrace();
         return false;
      }
   }

   public static boolean method1847(String var0) {
      try {
         Boolean.parseBoolean(var0);
         return true;
      } catch (Exception var2) {
         var2.printStackTrace();
         return false;
      }
   }

   public static boolean method1025(String var0, int var1) {
      try {
         Long.parseLong(var0, var1);
         return true;
      } catch (Exception var3) {
         var3.printStackTrace();
         return false;
      }
   }

   public static boolean method1657(String var0) {
      return method1014(var0) || method0214(var0) || method2135(var0) || method1025(var0, 16);
   }

   public static float method1042(String var0, String var1) {
      return Math.abs(var0.length() - var1.length()) / 100.0F;
   }

   public static double method0217(String var0, String var1) {
      String var2 = var0;
      String var3 = var1;
      if (var0.length() < var1.length()) {
         var2 = var1;
         var3 = var0;
      }

      int var4 = var2.length();
      return var4 == 0 ? 1.0 : (double)(var4 - method2138(var2, var3)) / var4;
   }

   public static int method2138(String var0, String var1) {
      var0 = var0.toLowerCase();
      var1 = var1.toLowerCase();
      int[] var2 = new int[var1.length() + 1];

      for (int var3 = 0; var3 <= var0.length(); var3++) {
         int var4 = var3;

         for (int var5 = 0; var5 <= var1.length(); var5++) {
            if (var3 == 0) {
               var2[var5] = var5;
            } else if (var5 > 0) {
               int var6 = var2[var5 - 1];
               if (var0.charAt(var3 - 1) != var1.charAt(var5 - 1)) {
                  var6 = Math.min(Math.min(var6, var4), var2[var5]) + 1;
               }

               var2[var5 - 1] = var4;
               var4 = var6;
            }
         }

         if (var3 > 0) {
            var2[var1.length()] = var4;
         }
      }

      return var2[var1.length()];
   }
}
