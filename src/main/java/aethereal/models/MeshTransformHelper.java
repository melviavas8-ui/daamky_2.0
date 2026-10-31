package aethereal;

import org.joml.Vector3f;

public class MeshTransformHelper {
   public static Vector3f[] method1582(int[] var0) {
      int var1 = var0.length / 8;
      Vector3f[] var2 = new Vector3f[var1];

      for (int var3 = 0; var3 < var1; var3++) {
         int var4 = var3 * 8;
         Vector3f var5 = new Vector3f(Float.intBitsToFloat(var0[var4]), Float.intBitsToFloat(var0[var4 + 1]), Float.intBitsToFloat(var0[var4 + 2]));
         var2[var3] = var5;
      }

      return var2;
   }

   public static void method1586(int[] var0, Vector3f[] var1) {
      int var2 = var0.length / 8;

      for (int var3 = 0; var3 < var2; var3++) {
         int var4 = var3 * 8;
         var0[var4] = Float.floatToIntBits(var1[var3].x);
         var0[var4 + 1] = Float.floatToIntBits(var1[var3].y);
         var0[var4 + 2] = Float.floatToIntBits(var1[var3].z);
      }
   }

   public static int[] method0349(int[] var0) {
      int var1 = var0.length / 8;
      int[] var2 = new int[var0.length];

      for (int var3 = 0; var3 < var1; var3++) {
         int var4 = 8;
         System.arraycopy(var0, var3 * var4, var2, (var1 - var3 - 1) * var4, var4);
      }

      return var2;
   }

   public static Vector3f[] method1600(Vector3f[] var0, float var1) {
      if (var0.length != 4) {
         return null;
      }

      Vector3f var2 = new Vector3f();

      for (Vector3f var6 : var0) {
         var2.add(var6);
      }

      var2.div(var0.length);
      Vector3f var10 = var0[0];
      Vector3f var11 = var0[1];
      var10.sub(var2);
      var11.sub(var2);
      Vector3f var12 = new Vector3f(var10);
      var12.add(var11);
      Vector3f var13 = new Vector3f(var10);
      var13.sub(var11);
      var12.normalize();
      var13.normalize();
      Vector3f var7 = var12;
      var7.add(var13);
      var7.mul(var1);
      Vector3f var8 = new Vector3f(var7).reflect(var13);
      Vector3f[] var9 = new Vector3f[]{new Vector3f(var7), new Vector3f(var8), var7.mul(-1.0F), var8.mul(-1.0F)};
      var10.add(var2);
      var11.add(var2);
      return var9;
   }

   public static Vector3f[] method1601(Vector3f[] var0, Vector3f var1, Vector3f var2) {
      Vector3f[] var3 = new Vector3f[var0.length];
      Vector3f var4 = new Vector3f(var2);
      var4.normalize();
      var4.mul(1.0E-4F);
      var2.add(var4);

      for (int var5 = 0; var5 < var0.length; var5++) {
         Vector3f var6 = new Vector3f(var0[var5]);
         var6.add(var2);
         var6.add(var1);
         var3[var5] = var6;
      }

      return var3;
   }
}
