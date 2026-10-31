package aethereal;

import org.joml.Matrix4f;

public interface RenderCommand {
   Matrix4f field0750 = new Matrix4f();

   default void method0615(double var1, double var3) {
      this.method0675((float)var1, (float)var3);
   }

   default void method0675(float var1, float var2) {
      this.method1551(field0750, var1, var2);
   }

   default void method1549(Matrix4f var1, double var2, double var4) {
      this.method1551(var1, (float)var2, (float)var4);
   }

   default void method1551(Matrix4f var1, float var2, float var3) {
      this.method1553(var1, var2, var3, 0.0F);
   }

   default void method0619(double var1, double var3, double var5) {
      this.method0684((float)var1, (float)var3, (float)var5);
   }

   default void method0684(float var1, float var2, float var3) {
      this.method1553(field0750, var1, var2, var3);
   }

   default void method1550(Matrix4f var1, double var2, double var4, double var6) {
      this.method1553(var1, (float)var2, (float)var4, (float)var6);
   }

   void method1553(Matrix4f var1, float var2, float var3, float var4);
}
