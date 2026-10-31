package aethereal;

import com.mojang.blaze3d.platform.GlStateManager.class_4534;
import com.mojang.blaze3d.platform.GlStateManager.class_4535;
import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.class_10142;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_290;
import net.minecraft.class_4587;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;
import ua.patch.daamky.api.mixins.accessors.IWorldRenderer;

public final class WorldRenderHelper implements MinecraftAccess {
   public static boolean field0751 = false;
   public static List<WorldRenderHelper.VertexBatch> field0139 = new ArrayList<>();
   public static List<WorldRenderHelper.VertexBatch> field1508 = new ArrayList<>();
   public static List<WorldRenderHelper.VertexBatch> field1032 = new ArrayList<>();
   public static List<WorldRenderHelper.VertexBatch> field0209 = new ArrayList<>();
   public static List<WorldRenderHelper.VertexBatch> field0488 = new ArrayList<>();
   public static List<WorldRenderHelper.VertexBatch> field1644 = new ArrayList<>();

   public static void method1502(class_4587 var0, class_243 var1, double var2, boolean var4, Color var5, boolean var6, Color var7) {
      if (var6) {
         method2173(var0, new class_238(var1.method_1031(-0.5 * var2, -0.5 * var2, -0.5 * var2), var1.method_1031(0.5 * var2, 0.5 * var2, 0.5 * var2)), var7);
      }

      if (var4) {
         method1498(var0, new class_238(var1.method_1031(-0.5 * var2, -0.5 * var2, -0.5 * var2), var1.method_1031(0.5 * var2, 0.5 * var2, 0.5 * var2)), var5);
      }
   }

   public static void method1501(class_4587 var0, class_238 var1, boolean var2, Color var3, boolean var4, Color var5) {
      if (var4) {
         method2173(var0, var1, var5);
      }

      if (var2) {
         method1498(var0, var1, var3);
      }
   }

   public static void method1498(class_4587 var0, class_238 var1, Color var2) {
      method1500(var0, var1, var2, var2);
   }

   public static void method0333(class_4587 var0, class_238 var1, Color var2) {
      if (field0751) {
         if (method1284(var1)) {
            Matrix4f var3 = var0.method_23760().method_23761();
            var1 = method0282(var1);
            int var4 = var2.getRGB();
            field0488.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1321, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1324, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1324, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1321, var4)
               )
            );
            field0488.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1324, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1324, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1324, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1324, var4)
               )
            );
            field0488.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1324, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1324, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1321, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1321, var4)
               )
            );
            field0488.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1321, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1321, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1321, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1321, var4)
               )
            );
            field0488.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1321, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1321, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1324, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1324, var4)
               )
            );
            field0488.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1321, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1321, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1324, var4),
                  new WorldRenderHelper.ColoredVertex(var3, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1324, var4)
               )
            );
         }
      }
   }

   public static void method2173(class_4587 var0, class_238 var1, Color var2) {
      method0334(var0, var1, var2, var2);
   }

   public static void method1500(class_4587 var0, class_238 var1, Color var2, Color var3) {
      if (field0751) {
         if (method1284(var1)) {
            Matrix4f var4 = var0.method_23760().method_23761();
            var1 = method0282(var1);
            field0139.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1321, var2.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1324, var2.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1324, var2.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1321, var2.getRGB())
               )
            );
            field0139.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1324, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1324, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1324, var2.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1324, var2.getRGB())
               )
            );
            field0139.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1324, var2.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1324, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1321, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1321, var2.getRGB())
               )
            );
            field0139.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1321, var2.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1321, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1321, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1321, var2.getRGB())
               )
            );
            field0139.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1321, var2.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1321, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1324, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1324, var2.getRGB())
               )
            );
            field0139.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1321, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1321, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1324, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1324, var3.getRGB())
               )
            );
         }
      }
   }

   public static void method1507(class_4587 var0, class_243 var1, class_243 var2, Color var3) {
      if (field0751) {
         Matrix4f var4 = var0.method_23760().method_23761();
         class_243 var5 = method1299(var1);
         class_243 var6 = method1299(var2);
         field1508.add(
            new WorldRenderHelper.VertexBatch(
               new WorldRenderHelper.ColoredVertex(var4, (float)var5.field_1352, (float)var5.field_1351, (float)var5.field_1350, var3.getRGB()),
               new WorldRenderHelper.ColoredVertex(var4, (float)var6.field_1352, (float)var6.field_1351, (float)var6.field_1350, var3.getRGB())
            )
         );
      }
   }

   public static void method0337(class_4587 var0, class_243 var1, class_243 var2, Color var3) {
      if (field0751) {
         Matrix4f var4 = var0.method_23760().method_23761();
         class_243 var5 = method1299(var1);
         class_243 var6 = method1299(var2);
         field1644.add(
            new WorldRenderHelper.VertexBatch(
               new WorldRenderHelper.ColoredVertex(var4, (float)var5.field_1352, (float)var5.field_1351, (float)var5.field_1350, var3.getRGB()),
               new WorldRenderHelper.ColoredVertex(var4, (float)var6.field_1352, (float)var6.field_1351, (float)var6.field_1350, var3.getRGB())
            )
         );
      }
   }

   public static void method0334(class_4587 var0, class_238 var1, Color var2, Color var3) {
      if (field0751) {
         if (method1284(var1)) {
            Matrix4f var4 = var0.method_23760().method_23761();
            var1 = method0282(var1);
            field1508.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1321, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1324, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1324, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1324, var3.getRGB())
               )
            );
            field1508.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1324, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1321, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1321, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1321, var3.getRGB())
               )
            );
            field1508.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1321, var2.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1324, var2.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1324, var2.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1324, var2.getRGB())
               )
            );
            field1508.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1324, var2.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1321, var2.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1321, var2.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1321, var2.getRGB())
               )
            );
            field1508.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1321, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1321, var2.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1321, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1321, var2.getRGB())
               )
            );
            field1508.add(
               new WorldRenderHelper.VertexBatch(
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1322, (float)var1.field_1324, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1320, (float)var1.field_1325, (float)var1.field_1324, var2.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1322, (float)var1.field_1324, var3.getRGB()),
                  new WorldRenderHelper.ColoredVertex(var4, (float)var1.field_1323, (float)var1.field_1325, (float)var1.field_1324, var2.getRGB())
               )
            );
         }
      }
   }

   public static void method0578() {
      field0139 = new ArrayList<>();
      field1508 = new ArrayList<>();
      field1032 = new ArrayList<>();
      field0209 = new ArrayList<>();
      field0488 = new ArrayList<>();
      field1644 = new ArrayList<>();
      field0751 = true;
   }

   public static void method1079(List<WorldRenderHelper.VertexBatch> var0, List<WorldRenderHelper.VertexBatch> var1) {
      if (!var0.isEmpty() || !var1.isEmpty()) {
         RenderSystem.enableBlend();
         RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE);
         RenderSystem.disableDepthTest();
         if (!var0.isEmpty()) {
            class_287 var2 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1576);

            for (WorldRenderHelper.VertexBatch var4 : var0) {
               var4.method1379(var2);
            }

            RenderSystem.setShader(class_10142.field_53876);
            RenderSystem.disableCull();
            class_286.method_43433(var2.method_60800());
            RenderSystem.enableCull();
         }

         if (!var1.isEmpty()) {
            class_287 var5 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_29344, class_290.field_1576);

            for (WorldRenderHelper.VertexBatch var7 : var1) {
               var7.method1379(var5);
            }

            RenderSystem.setShader(class_10142.field_53876);
            GL11.glHint(3154, 4354);
            GL11.glEnable(2848);
            class_286.method_43433(var5.method_60800());
            GL11.glDisable(2848);
         }

         RenderSystem.enableDepthTest();
         RenderSystem.disableBlend();
      }
   }

   public static void method1081(List<WorldRenderHelper.VertexBatch> var0, List<WorldRenderHelper.VertexBatch> var1, boolean var2) {
      RenderSystem.enableBlend();
      if (var2) {
         RenderSystem.blendFunc(770, 32772);
      } else {
         RenderSystem.blendFuncSeparate(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA, class_4535.ONE, class_4534.ZERO);
      }

      RenderSystem.disableDepthTest();
      if (!var0.isEmpty()) {
         class_287 var3 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1576);

         for (WorldRenderHelper.VertexBatch var5 : var0) {
            var5.method1379(var3);
         }

         RenderSystem.setShader(class_10142.field_53876);
         RenderSystem.disableCull();
         class_286.method_43433(var3.method_60800());
         RenderSystem.enableCull();
      }

      if (!var1.isEmpty()) {
         class_287 var6 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_29344, class_290.field_1576);

         for (WorldRenderHelper.VertexBatch var8 : var1) {
            var8.method1379(var6);
         }

         RenderSystem.setShader(class_10142.field_53876);
         GL11.glHint(3154, 4354);
         GL11.glEnable(2848);
         class_286.method_43433(var6.method_60800());
         GL11.glDisable(2848);
      }

      RenderSystem.enableDepthTest();
      RenderSystem.disableBlend();
   }

   private static boolean method1284(class_238 var0) {
      return ((IWorldRenderer)field0796.field_1769).getFrustum().method_23093(var0);
   }

   private static class_243 method1299(class_243 var0) {
      class_243 var1 = field0796.field_1773.method_19418().method_19326();
      Vector4f var2 = new Vector4f(
         (float)(var0.field_1352 - var1.field_1352), (float)(var0.field_1351 - var1.field_1351), (float)(var0.field_1350 - var1.field_1350), 1.0F
      );
      var2.mul(new class_4587().method_23760().method_23761());
      return new class_243(var2.x(), var2.y(), var2.z());
   }

   private static class_238 method0282(class_238 var0) {
      class_243 var1 = method1299(new class_243(var0.field_1323, var0.field_1322, var0.field_1321));
      class_243 var2 = method1299(new class_243(var0.field_1320, var0.field_1325, var0.field_1324));
      return new class_238(var1, var2);
   }

   @Generated
   private WorldRenderHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   private record VertexBatch(WorldRenderHelper.ColoredVertex... vertices) {
      public void method1379(class_287 var1) {
         for (WorldRenderHelper.ColoredVertex var5 : this.vertices) {
            var1.method_22918(var5.matrix, var5.x, var5.y, var5.z).method_39415(var5.color);
         }
      }

      public WorldRenderHelper.ColoredVertex[] method0584() {
         return this.vertices;
      }
   }

   private record ColoredVertex(Matrix4f matrix, float x, float y, float z, int color) {
      public Matrix4f method0577() {
         return this.matrix;
      }

      public float method0002() {
         return this.x;
      }

      public float method2047() {
         return this.y;
      }

      public float method1762() {
         return this.z;
      }

      public int method1604() {
         return this.color;
      }
   }
}
