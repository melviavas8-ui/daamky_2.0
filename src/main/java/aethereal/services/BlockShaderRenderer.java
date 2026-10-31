package aethereal;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import net.minecraft.class_10142;
import net.minecraft.class_10149;
import net.minecraft.class_10156;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_5944;
import net.minecraft.class_6367;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;
import org.joml.Vector4f;

public class BlockShaderRenderer implements MinecraftAccess {
   private static final class_10156 field0728 = new class_10156(ResourceHelper.method1012("block_shader"), class_290.field_1592, class_10149.field_53930);
   private static final class_10156 field0146 = new class_10156(
      ResourceHelper.method1012("block_shader_aurora"), class_290.field_1592, class_10149.field_53930
   );
   private static final class_10156 field1517 = new class_10156(
      ResourceHelper.method1012("block_shader_cosmic"), class_290.field_1592, class_10149.field_53930
   );
   private class_6367 field1048;
   private class_6367 field0217;
   private boolean field0497;

   public void method0578() {
      this.method2078();
   }

   public void method1285(class_238 var1, Color var2, float var3, float var4, BlockShaderRenderer.ShaderType var5) {
      if (var1 != null) {
         class_276 var6 = field0796.method_1522();
         if (field0796.method_22683() != null && var6 != null) {
            this.method0025();
            if (this.field1048 != null && this.field0217 != null) {
               method1372(var6, this.field1048, 16640);
               this.method1283(var1);
               this.method1371(var6, var1, var2, var3, var4, method0810(var5));
               var6.method_1235(true);
            }
         }
      }
   }

   private static class_10156 method0810(BlockShaderRenderer.ShaderType var0) {
      switch (var0) {
         case field0615:
         default:
            return field0728;
         case field0048:
            return field0146;
         case field1441:
            return field1517;
      }
   }

   private void method1283(class_238 var1) {
      method1525(this.field0217);
      this.field0217.method_1235(true);
      RenderSystem.disableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.disableBlend();
      RenderSystem.disableCull();
      RenderSystem.colorMask(true, true, true, true);
      class_238 var2 = method2160(var1);
      Matrix4f var3 = new Matrix4f();
      int var4 = -1;
      class_287 var5 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1576);
      var5.method_22918(var3, (float)var2.field_1323, (float)var2.field_1325, (float)var2.field_1321).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1323, (float)var2.field_1325, (float)var2.field_1324).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1320, (float)var2.field_1325, (float)var2.field_1324).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1320, (float)var2.field_1325, (float)var2.field_1321).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1323, (float)var2.field_1322, (float)var2.field_1321).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1320, (float)var2.field_1322, (float)var2.field_1321).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1320, (float)var2.field_1322, (float)var2.field_1324).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1323, (float)var2.field_1322, (float)var2.field_1324).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1323, (float)var2.field_1322, (float)var2.field_1321).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1323, (float)var2.field_1325, (float)var2.field_1321).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1320, (float)var2.field_1325, (float)var2.field_1321).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1320, (float)var2.field_1322, (float)var2.field_1321).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1323, (float)var2.field_1322, (float)var2.field_1324).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1320, (float)var2.field_1322, (float)var2.field_1324).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1320, (float)var2.field_1325, (float)var2.field_1324).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1323, (float)var2.field_1325, (float)var2.field_1324).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1323, (float)var2.field_1322, (float)var2.field_1321).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1323, (float)var2.field_1322, (float)var2.field_1324).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1323, (float)var2.field_1325, (float)var2.field_1324).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1323, (float)var2.field_1325, (float)var2.field_1321).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1320, (float)var2.field_1322, (float)var2.field_1321).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1320, (float)var2.field_1325, (float)var2.field_1321).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1320, (float)var2.field_1325, (float)var2.field_1324).method_39415(var4);
      var5.method_22918(var3, (float)var2.field_1320, (float)var2.field_1322, (float)var2.field_1324).method_39415(var4);
      RenderSystem.setShader(class_10142.field_53876);
      class_286.method_43433(var5.method_60800());
      RenderSystem.enableCull();
      RenderSystem.depthMask(true);
      RenderSystem.enableDepthTest();
   }

   private void method1371(class_276 var1, class_238 var2, Color var3, float var4, float var5, class_10156 var6) {
      method0729(this.field1048.method_30277());
      method0729(this.field0217.method_30277());
      var1.method_1235(true);
      RenderSystem.disableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.disableBlend();
      RenderSystem.colorMask(true, true, true, true);

      class_5944 var7;
      try {
         var7 = RenderSystem.setShader(var6);
      } catch (Throwable var9) {
         if (!this.field0497) {
            System.err.println("[BlockShader] composite shader failed to load: " + var9.getMessage());
            var9.printStackTrace();
            this.field0497 = true;
         }

         return;
      }

      if (var7 != null) {
         var7.method_62899("SceneTexture", this.field1048.method_30277());
         var7.method_62899("MaskTexture", this.field0217.method_30277());
         var7.method_35785("InSize").method_1255(var1.field_1482, var1.field_1481);
         var7.method_35785("Time").method_1251(var4);
         var7.method_35785("Intensity").method_1251(Math.max(0.0F, var5));
         var7.method_35785("TintColor").method_1249(var3.getRed() / 255.0F, var3.getGreen() / 255.0F, var3.getBlue() / 255.0F);
         float[] var8 = method0283(var2);
         var7.method_35785("BlockCenter").method_1255(var8[0], var8[1]);
         method1812();
         RenderSystem.depthMask(true);
         RenderSystem.enableDepthTest();
      }
   }

   private void method0025() {
      int var1 = field0796.method_22683().method_4489();
      int var2 = field0796.method_22683().method_4506();
      if (var1 > 0 && var2 > 0) {
         if (this.field1048 == null || this.field1048.field_1482 != var1 || this.field1048.field_1481 != var2) {
            this.method2078();
            this.field1048 = new class_6367(var1, var2, true);
            this.field0217 = new class_6367(var1, var2, false);
         }
      }
   }

   private void method2078() {
      if (this.field1048 != null) {
         this.field1048.method_1238();
      }

      if (this.field0217 != null) {
         this.field0217.method_1238();
      }

      this.field1048 = null;
      this.field0217 = null;
   }

   private static float[] method0283(class_238 var0) {
      class_243 var1 = var0.method_1005();
      class_243 var2 = MinecraftAccess.field0796.field_1773.method_19418().method_19326();
      Vector4f var3 = new Vector4f(
         (float)(var1.field_1352 - var2.field_1352), (float)(var1.field_1351 - var2.field_1351), (float)(var1.field_1350 - var2.field_1350), 1.0F
      );
      Matrix4f var4 = new Matrix4f(RenderSystem.getModelViewMatrix());
      Matrix4f var5 = new Matrix4f(RenderSystem.getProjectionMatrix());
      var4.transform(var3);
      var5.transform(var3);
      if (Math.abs(var3.w) < 1.0E-4F) {
         return new float[]{0.5F, 0.5F};
      }

      float var6 = var3.x / var3.w;
      float var7 = var3.y / var3.w;
      return new float[]{(var6 + 1.0F) * 0.5F, (var7 + 1.0F) * 0.5F};
   }

   private static class_238 method2160(class_238 var0) {
      class_243 var1 = MinecraftAccess.field0796.field_1773.method_19418().method_19326();
      return new class_238(
         var0.field_1323 - var1.field_1352,
         var0.field_1322 - var1.field_1351,
         var0.field_1321 - var1.field_1350,
         var0.field_1320 - var1.field_1352,
         var0.field_1325 - var1.field_1351,
         var0.field_1324 - var1.field_1350
      );
   }

   private static void method1812() {
      class_287 var0 = class_289.method_1348().method_60827(class_5596.field_27380, class_290.field_1592);
      var0.method_22912(-1.0F, -1.0F, 0.0F);
      var0.method_22912(1.0F, -1.0F, 0.0F);
      var0.method_22912(-1.0F, 1.0F, 0.0F);
      var0.method_22912(1.0F, 1.0F, 0.0F);
      class_286.method_43433(var0.method_60800());
   }

   private static void method1372(class_276 var0, class_276 var1, int var2) {
      GlStateManager._glBindFramebuffer(36008, var0.field_1476);
      GlStateManager._glBindFramebuffer(36009, var1.field_1476);
      GlStateManager._glBlitFrameBuffer(0, 0, var0.field_1482, var0.field_1481, 0, 0, var1.field_1482, var1.field_1481, var2, 9728);
   }

   private static void method1525(class_6367 var0) {
      var0.method_1235(true);
      GlStateManager._clearColor(0.0F, 0.0F, 0.0F, 0.0F);
      RenderSystem.clear(16384);
   }

   private static void method0729(int var0) {
      RenderSystem.activeTexture(33984);
      RenderSystem.bindTexture(var0);
      GlStateManager._texParameter(3553, 10241, 9729);
      GlStateManager._texParameter(3553, 10240, 9729);
   }

   public enum ShaderType implements DisplayNamed {
      field0615("Universe"),
      field0048("Aurora"),
      field1441("Cosmic");

      private final String field1030;

      ShaderType(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }
}
