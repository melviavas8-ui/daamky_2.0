package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_243;
import net.minecraft.class_310;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;

public class ViewFrustumHelper {
   private static final Matrix4f field0750 = new Matrix4f();
   private static final Matrix4f field0168 = new Matrix4f();
   private static final Matrix4f field1526 = new Matrix4f();
   private static final int[] field1051 = new int[4];

   public static void method1548(Matrix4f var0) {
      field0750.set(class_310.method_1551().field_1773.method_22973(((Integer)class_310.method_1551().field_1690.method_41808().method_41753()).floatValue()));
      field0168.set(RenderSystem.getModelViewMatrix());
      field1526.set(var0);
      GL11.glGetIntegerv(2978, field1051);
   }

   public static class_243 method1299(class_243 var0) {
      class_310 var1 = class_310.method_1551();
      if (var1.field_1773 != null && var1.field_1773.method_19418() != null) {
         class_243 var2 = var1.field_1773.method_19418().method_19326();
         float var3 = (float)(var0.field_1352 - var2.field_1352);
         float var4 = (float)(var0.field_1351 - var2.field_1351);
         float var5 = (float)(var0.field_1350 - var2.field_1350);
         Vector4f var6 = new Vector4f(var3, var4, var5, 1.0F).mul(field1526);
         Matrix4f var7 = new Matrix4f(field0750).mul(field0168);
         Vector3f var8 = new Vector3f();
         var7.project(var6.x(), var6.y(), var6.z(), field1051, var8);
         int var9 = field1051[3];
         double var10 = var1.method_22683().method_4495();
         return new class_243(var8.x / var10, (var9 - var8.y) / var10, var8.z);
      } else {
         return null;
      }
   }

   public static boolean method0289(class_243 var0) {
      return var0 != null && var0.field_1350 > -1.0 && var0.field_1350 < 1.0;
   }
}
