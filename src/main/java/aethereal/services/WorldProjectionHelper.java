package aethereal;

import lombok.Generated;
import net.minecraft.class_243;
import net.minecraft.class_4184;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;
import ua.patch.daamky.api.mixins.accessors.IGameRenderer;

public final class WorldProjectionHelper implements MinecraftAccess {
   public static final Matrix4f field0750 = new Matrix4f();
   public static final Matrix4f field0168 = new Matrix4f();
   public static final Matrix4f field1526 = new Matrix4f();

   public static class_243 method1299(class_243 var0) {
      class_4184 var1 = field0796.method_1561().field_4686;
      int[] var2 = new int[4];
      GL11.glGetIntegerv(2978, var2);
      Vector3f var3 = new Vector3f();
      double var4 = var0.field_1352 - var1.method_19326().field_1352;
      double var6 = var0.field_1351 - var1.method_19326().field_1351;
      double var8 = var0.field_1350 - var1.method_19326().field_1350;
      Vector4f var10 = new Vector4f((float)var4, (float)var6, (float)var8, 1.0F).mul(field0750);
      Matrix4f var11 = new Matrix4f(field0168);
      Matrix4f var12 = new Matrix4f(field1526);
      var11.mul(var12).project(var10.x(), var10.y(), var10.z(), var2, var3);
      double var13 = 2.0;
      return new class_243(var3.x / var13, (field0796.method_22683().method_4507() - var3.y) / var13, var3.z);
   }

   public static double method1303(class_243 var0, double var1) {
      class_243 var3 = field0796.field_1773.method_19418().method_19326();
      double var4 = var3.method_1022(var0);
      double var6 = ((IGameRenderer)field0796.field_1773).getFov$drug(field0796.field_1773.method_19418(), field0796.method_61966().method_60637(true), true);
      return Math.max(10.0, 1000.0 / var4) * (var1 / 30.0) / (var6 == 70.0 ? 1.0 : var6 / 70.0);
   }

   @Generated
   private WorldProjectionHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
