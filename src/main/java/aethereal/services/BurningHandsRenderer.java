package aethereal;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_10149;
import net.minecraft.class_10156;
import net.minecraft.class_276;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_5944;
import net.minecraft.class_6367;
import net.minecraft.class_293.class_5596;

public class BurningHandsRenderer implements MinecraftAccess {
   private static final float field0566 = 1.18F;
   private static final float field0003 = 120.0F;
   private static final class_10156 field1517 = new class_10156(
      ResourceHelper.method1012("burning_hands_mask"), class_290.field_1592, class_10149.field_53930
   );
   private static final class_10156 field1037 = new class_10156(
      ResourceHelper.method1012("burning_hands_glow"), class_290.field_1592, class_10149.field_53930
   );
   private static final class_10156 field0212 = new class_10156(
      ResourceHelper.method1012("burning_hands_trail"), class_290.field_1592, class_10149.field_53930
   );
   private static final class_10156 field0490 = new class_10156(
      ResourceHelper.method1012("burning_hands_composite"), class_290.field_1592, class_10149.field_53930
   );
   private class_6367 field1652;
   private class_6367 field1573;
   private class_6367 field1734;
   private class_6367 field1160;
   private class_6367 field1108;
   private class_6367 field1217;
   private long field0873;
   private long field0828;
   private boolean field0931;

   public void method0578() {
      this.field0873 = 0L;
      this.field0828 = 0L;
      this.method2078();
   }

   public void method0992(Runnable var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.method0995(var1, var2, var3, var4, var5, var6, var7, false, 1.0F, 0.5F, 0.15F, 0.0F);
   }

   public void method0993(
      Runnable var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11
   ) {
      this.method0995(var1, var2, var3, var4, var5, var6, var7, false, var8, var9, var10, var11);
   }

   public void method0994(Runnable var1, float var2, float var3, float var4, float var5, float var6, float var7, boolean var8) {
      this.method0995(var1, var2, var3, var4, var5, var6, var7, var8, 1.0F, 0.5F, 0.15F, 0.0F);
   }

   public void method0995(
      Runnable var1, float var2, float var3, float var4, float var5, float var6, float var7, boolean var8, float var9, float var10, float var11, float var12
   ) {
      if (var1 != null) {
         class_276 var13 = field0796.method_1522();
         if (field0796.method_22683() != null && var13 != null) {
            boolean var14 = var2 > 0.0F || var3 > 0.0F;
            boolean var15 = this.method1571(var14, var6);
            if (!var14 && !var15) {
               if (this.field0873 != 0L || this.field0828 != 0L) {
                  this.method1812();
               }

               var13.method_1235(true);
               var1.run();
            } else {
               this.method0025();
               if (this.field1652 != null
                  && this.field1573 != null
                  && this.field1734 != null
                  && this.field1160 != null
                  && this.field1108 != null
                  && this.field1217 != null) {
                  method1372(var13, this.field1652, 16640);
                  var13.method_1235(true);
                  RenderSystem.colorMask(true, true, true, true);
                  RenderSystem.depthMask(true);
                  RenderSystem.enableDepthTest();
                  RenderSystem.defaultBlendFunc();
                  var1.run();
                  method1372(var13, this.field1573, 16640);
                  if (var14) {
                     this.field0828 = 0L;
                     this.method0675(var2, var3);
                     this.method0688(var4, var7, var9, var10, var11, var12);
                  } else {
                     method1525(this.field1734);
                     method1525(this.field1160);
                  }

                  this.method0690(var5, var6, var7, var9, var10, var11, var12);
                  this.method1373(var13, var8);
                  var13.method_1235(true);
               } else {
                  var13.method_1235(true);
                  var1.run();
               }
            }
         } else {
            var1.run();
         }
      }
   }

   private void method0025() {
      int var1 = field0796.method_22683().method_4489();
      int var2 = field0796.method_22683().method_4506();
      if (var1 > 0 && var2 > 0) {
         if (this.field1652 == null || this.field1652.field_1482 != var1 || this.field1652.field_1481 != var2) {
            this.method2078();
            int var3 = Math.max(1, var1 / 2);
            int var4 = Math.max(1, var2 / 2);
            this.field1652 = new class_6367(var1, var2, true);
            this.field1573 = new class_6367(var1, var2, true);
            this.field1734 = new class_6367(var1, var2, false);
            this.field1160 = new class_6367(var3, var4, false);
            this.field1108 = new class_6367(var3, var4, false);
            this.field1217 = new class_6367(var3, var4, false);
            this.method1812();
         }
      }
   }

   private void method2078() {
      if (this.field1652 != null) {
         this.field1652.method_1238();
      }

      if (this.field1573 != null) {
         this.field1573.method_1238();
      }

      if (this.field1734 != null) {
         this.field1734.method_1238();
      }

      if (this.field1160 != null) {
         this.field1160.method_1238();
      }

      if (this.field1108 != null) {
         this.field1108.method_1238();
      }

      if (this.field1217 != null) {
         this.field1217.method_1238();
      }

      this.field1652 = this.field1573 = this.field1734 = this.field1160 = this.field1108 = this.field1217 = null;
   }

   private void method1812() {
      if (this.field1108 != null) {
         method1525(this.field1108);
      }

      if (this.field1217 != null) {
         method1525(this.field1217);
      }

      this.field0873 = 0L;
      this.field0828 = 0L;
   }

   private boolean method1571(boolean var1, float var2) {
      if (var1) {
         this.field0828 = 0L;
         return true;
      }

      if (this.field0873 == 0L) {
         return false;
      }

      long var3 = System.nanoTime();
      if (this.field0828 == 0L) {
         this.field0828 = var3;
      }

      float var5 = Math.max(0.05F, method0681(var2, 2.0F, 40.0F) / 20.0F);
      long var6 = (long)(Math.max(0.16F, var5 * 1.35F) * 1.0E9F);
      return var3 - this.field0828 <= var6;
   }

   private void method0675(float var1, float var2) {
      method0729(this.field1652.method_30277());
      method0729(this.field1573.method_30277());
      method0729(this.field1652.method_30278());
      method0729(this.field1573.method_30278());
      method1525(this.field1734);
      this.field1734.method_1235(true);
      RenderSystem.disableDepthTest();
      RenderSystem.disableBlend();

      class_5944 var3;
      try {
         var3 = RenderSystem.setShader(field1517);
      } catch (Throwable var5) {
         if (!this.field0931) {
            System.err.println("[FireMask] mask shader failed to load: " + var5.getMessage());
            var5.printStackTrace();
            this.field0931 = true;
         }

         return;
      }

      if (var3 != null) {
         var3.method_62899("BeforeColor", this.field1652.method_30277());
         var3.method_62899("AfterColor", this.field1573.method_30277());
         var3.method_62899("BeforeDepth", this.field1652.method_30278());
         var3.method_62899("AfterDepth", this.field1573.method_30278());
         var3.method_35785("TexelSize").method_1255(1.0F / this.field1734.field_1482, 1.0F / this.field1734.field_1481);
         var3.method_35785("GlowSides").method_1255(var1, var2);
         method1634();
      }
   }

   private void method0688(float var1, float var2, float var3, float var4, float var5, float var6) {
      method0729(this.field1734.method_30277());
      method1525(this.field1160);
      this.field1160.method_1235(true);
      RenderSystem.disableDepthTest();
      RenderSystem.disableBlend();
      class_5944 var7 = RenderSystem.setShader(field1037);
      if (var7 != null) {
         var7.method_62899("HandTexture", this.field1734.method_30277());
         var7.method_35785("TexelSize").method_1255(1.0F / this.field1734.field_1482, 1.0F / this.field1734.field_1481);
         var7.method_35785("Radius").method_1251(method0681(var1, 6.0F, 34.0F));
         var7.method_35785("Strength").method_1251(1.18F);
         var7.method_35785("FlameSpeed").method_1251(method0681(var2, 0.2F, 2.5F));
         var7.method_35785("Time").method_1251((float)System.nanoTime() / 1.0E9F);
         var7.method_35785("FireColor").method_1249(var3, var4, var5);
         var7.method_35785("ColorMix").method_1251(method0681(var6, 0.0F, 1.0F));
         method1634();
      }
   }

   private void method0690(float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      long var8 = System.nanoTime();
      float var10 = 8333333.5F;
      if (this.field0873 == 0L || !((float)(var8 - this.field0873) < var10)) {
         float var11 = this.field0873 == 0L ? 0.008333334F : (float)(var8 - this.field0873) / 1.0E9F;
         this.field0873 = var8;
         float var12 = Math.max(0.05F, method0681(var2, 2.0F, 40.0F) / 20.0F);
         float var13 = (float)Math.pow(0.035000008F, Math.max(0.0F, var11) / var12);
         method0729(this.field1108.method_30277());
         method0729(this.field1160.method_30277());
         method0729(this.field1734.method_30277());
         method1525(this.field1217);
         this.field1217.method_1235(true);
         RenderSystem.disableDepthTest();
         RenderSystem.disableBlend();
         class_5944 var14 = RenderSystem.setShader(field0212);
         if (var14 != null) {
            var14.method_62899("TrailTexture", this.field1108.method_30277());
            var14.method_62899("GlowTexture", this.field1160.method_30277());
            var14.method_62899("HandTexture", this.field1734.method_30277());
            var14.method_35785("TexelSize").method_1255(1.0F / this.field1217.field_1482, 1.0F / this.field1217.field_1481);
            var14.method_35785("Decay").method_1251(method0681(var13, 0.0F, 0.995F));
            var14.method_35785("FlameHeight").method_1251(method0681(var1, 6.0F, 64.0F));
            var14.method_35785("FlowSpeed").method_1251(method0681(var3, 0.2F, 2.5F));
            var14.method_35785("Time").method_1251((float)var8 / 1.0E9F);
            var14.method_35785("FireColor").method_1249(var4, var5, var6);
            var14.method_35785("ColorMix").method_1251(method0681(var7, 0.0F, 1.0F));
            method1634();
         }

         class_6367 var15 = this.field1108;
         this.field1108 = this.field1217;
         this.field1217 = var15;
      }
   }

   private void method1373(class_276 var1, boolean var2) {
      method0729(this.field1652.method_30277());
      method0729(this.field1573.method_30277());
      method0729(this.field1734.method_30277());
      method0729(this.field1160.method_30277());
      method0729(this.field1108.method_30277());
      var1.method_1235(true);
      RenderSystem.disableDepthTest();
      RenderSystem.disableBlend();
      RenderSystem.colorMask(true, true, true, true);
      class_5944 var3 = RenderSystem.setShader(field0490);
      if (var3 != null) {
         int var4 = var2 ? this.field1652.method_30277() : this.field1573.method_30277();
         var3.method_62899("SceneTexture", var4);
         var3.method_62899("HandTexture", this.field1734.method_30277());
         var3.method_62899("GlowTexture", this.field1160.method_30277());
         var3.method_62899("TrailTexture", this.field1108.method_30277());
         var3.method_35785("GlowStrength").method_1251(1.18F);
         var3.method_35785("TrailStrength").method_1251(1.16F);
         var3.method_35785("TexelSize").method_1255(1.0F / var1.field_1482, 1.0F / var1.field_1481);
         var3.method_35785("FillMode").method_1251(var2 ? 1.0F : 0.0F);
         method1634();
      }

      RenderSystem.enableDepthTest();
      RenderSystem.depthMask(true);
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableBlend();
   }

   private static void method1634() {
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

   private static float method0681(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }
}
