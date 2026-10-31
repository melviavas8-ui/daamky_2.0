package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.awt.image.BufferedImage;
import lombok.Generated;
import net.minecraft.class_1011;
import net.minecraft.class_10142;
import net.minecraft.class_1043;
import net.minecraft.class_1044;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

public final class GuiRenderHelper implements MinecraftAccess {
   public static void method1463(class_4587 var0, float var1, float var2, float var3, float var4, float var5, Color var6) {
      RectangleRenderCommand var7 = RenderCommandFactory.method0548()
         .method0925(new RenderSize(var3, var4))
         .method0824(new CornerRadius(var5))
         .method0916(new QuadColor(var6))
         .method0555();
      var7.method1551(var0.method_23760().method_23761(), var1, var2);
   }

   public static void method0326(class_4587 var0, float var1, float var2, float var3, float var4, float var5, Color var6) {
      CircularRectangleRenderCommand var7 = RenderCommandFactory.method0005()
         .method0922(new RenderSize(var3, var4))
         .method0821(new CornerRadius(var5))
         .method0913(new QuadColor(var6))
         .method0555();
      var7.method1551(var0.method_23760().method_23761(), var1, var2);
   }

   public static void method0578() {
      BlurRenderCommand.method0578();
   }

   public static void method0025() {
      BlurRenderCommand.method0025();
   }

   public static void method1462(class_4587 var0, float var1, float var2, float var3, float var4, float var5, float var6, Color var7) {
      BlurRenderCommand var8 = RenderCommandFactory.method0358()
         .method0919(new RenderSize(var3, var4))
         .method0818(new CornerRadius(var5))
         .method0116(var6)
         .method0910(new QuadColor(var7))
         .method0555();
      var8.method1551(var0.method_23760().method_23761(), var1, var2);
   }

   public static void method0325(class_4587 var0, float var1, float var2, float var3, float var4, float var5, float var6, Color var7) {
      GaussianBlurRenderCommand var8 = RenderCommandFactory.method0486()
         .method0924(new RenderSize(var3, var4))
         .method0823(new CornerRadius(var5))
         .method0119(var6)
         .method0915(new QuadColor(var7))
         .method0555();
      var8.method1551(var0.method_23760().method_23761(), var1, var2);
   }

   public static void method1461(class_4587 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, Color var8) {
      BorderRenderCommand var9 = RenderCommandFactory.method2050()
         .method0920(new RenderSize(var3, var4))
         .method0819(new CornerRadius(var5))
         .method0668(var6, var7)
         .method0911(new QuadColor(var8))
         .method0555();
      var9.method1551(var0.method_23760().method_23761(), var1, var2);
   }

   public static void method1460(class_4587 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, Color var9) {
      BorderRenderCommand var10 = RenderCommandFactory.method2050()
         .method0920(new RenderSize(var3, var4))
         .method0819(new CornerRadius(var5))
         .method0668(var7, var8)
         .method0648(var6)
         .method0911(new QuadColor(var9))
         .method0555();
      var10.method1551(var0.method_23760().method_23761(), var1, var2);
   }

   public static void method0324(class_4587 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, Color var8) {
      CircularBorderRenderCommand var9 = RenderCommandFactory.method1767()
         .method0921(new RenderSize(var3, var4))
         .method0820(new CornerRadius(var5))
         .method0669(var6, var7)
         .method0912(new QuadColor(var8))
         .method0555();
      var9.method1551(var0.method_23760().method_23761(), var1, var2);
   }

   public static void method0323(class_4587 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, Color var9) {
      CircularBorderRenderCommand var10 = RenderCommandFactory.method1767()
         .method0921(new RenderSize(var3, var4))
         .method0820(new CornerRadius(var5))
         .method0669(var7, var8)
         .method0649(var6)
         .method0912(new QuadColor(var9))
         .method0555();
      var10.method1551(var0.method_23760().method_23761(), var1, var2);
   }

   public static void method1464(class_4587 var0, float var1, float var2, float var3, float var4, float var5, Color var6, int var7) {
      method1462(var0, var1, var2, var3, var4, var5, 10.0F, new Color(255, 255, 255, var7));
      method1463(var0, var1, var2, var3, var4, var5, var6);
   }

   public static void method2170(class_4587 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, Color var8) {
      LiquidCardRenderCommand var9 = new LiquidCardRenderCommand(new RenderSize(var3, var4), new CornerRadius(var5), new QuadColor(var8), var6, var7);
      var9.method1551(var0.method_23760().method_23761(), var1, var2);
   }

   public static void method1871(class_4587 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, Color var8) {
      GlassBorderRenderCommand var9 = new GlassBorderRenderCommand(new RenderSize(var3, var4), new CornerRadius(var5), new QuadColor(var8), var6, var7);
      var9.method1551(var0.method_23760().method_23761(), var1, var2);
   }

   public static void method1491(class_4587 var0, FontSize var1, String var2, float var3, float var4, Color var5) {
      MsdfTextRenderCommand var6 = RenderCommandFactory.method0419()
         .method0658(var1.method2047())
         .method0853(var1.method0010())
         .method1004(var2)
         .method0122(0.05F)
         .method0959(var5)
         .method0555();
      var6.method1551(var0.method_23760().method_23761(), var3, var4);
   }

   public static void method1488(class_4587 var0, FontSize var1, String var2, float var3, float var4, float var5, Color var6) {
      MsdfTextRenderCommand var7 = RenderCommandFactory.method0419()
         .method0658(var1.method2047())
         .method0853(var1.method0010())
         .method1004(var2)
         .method0122(var5)
         .method0959(var6)
         .method0555();
      var7.method1551(var0.method_23760().method_23761(), var3, var4);
   }

   public static void method1492(class_4587 var0, FontSize var1, String var2, float var3, float var4, Color var5, float var6, float var7) {
      LiquidGlassTextRenderCommand var8 = new LiquidGlassTextRenderCommand(
         var1.method0010(), var2, var1.method2047(), 0.05F, var5.getRGB(), 0.3F, 0.0F, var6, var7
      );
      var8.method1551(var0.method_23760().method_23761(), var3, var4);
   }

   public static void method0332(class_4587 var0, FontSize var1, String var2, float var3, float var4, Color var5) {
      method1492(var0, var1, var2, var3, var4, var5, 0.03F, 3.0F);
   }

   public static void method1466(class_4587 var0, float var1, float var2, float var3, float var4, float var5, class_2960 var6, Color var7) {
      method1465(var0, var1, var2, var3, var4, var5, field0796.method_1531().method_4619(var6), var7);
   }

   public static void method1465(class_4587 var0, float var1, float var2, float var3, float var4, float var5, class_1044 var6, Color var7) {
      TextureRenderCommand var8 = RenderCommandFactory.method1615()
         .method0926(new RenderSize(var3, var4))
         .method0825(new CornerRadius(var5))
         .method0698(1.0F, 1.0F, 1.0F, 1.0F, var6)
         .method0917(new QuadColor(var7))
         .method0555();
      var8.method1551(var0.method_23760().method_23761(), var1, var2);
   }

   public static void method1459(
      class_4587 var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      class_2960 var10,
      Color var11
   ) {
      TextureRenderCommand var12 = RenderCommandFactory.method1615()
         .method0926(new RenderSize(var3, var4))
         .method0825(new CornerRadius(var5))
         .method0698(var6, var7, var8, var9, field0796.method_1531().method_4619(var10))
         .method0917(new QuadColor(var11))
         .method0555();
      var12.method1551(var0.method_23760().method_23761(), var1, var2);
   }

   public static void method0328(class_4587 var0, float var1, float var2, float var3, float var4, float var5, class_2960 var6, Color var7) {
      method0327(var0, var1, var2, var3, var4, var5, field0796.method_1531().method_4619(var6), var7);
   }

   public static void method0327(class_4587 var0, float var1, float var2, float var3, float var4, float var5, class_1044 var6, Color var7) {
      CircularTextureRenderCommand var8 = RenderCommandFactory.method1949()
         .method0923(new RenderSize(var3, var4))
         .method0822(new CornerRadius(var5))
         .method0697(1.0F, 1.0F, 1.0F, 1.0F, var6)
         .method0914(new QuadColor(var7))
         .method0555();
      var8.method1551(var0.method_23760().method_23761(), var1, var2);
   }

   public static void method0322(
      class_4587 var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      class_2960 var10,
      Color var11
   ) {
      CircularTextureRenderCommand var12 = RenderCommandFactory.method1949()
         .method0923(new RenderSize(var3, var4))
         .method0822(new CornerRadius(var5))
         .method0697(var6, var7, var8, var9, field0796.method_1531().method_4619(var10))
         .method0914(new QuadColor(var11))
         .method0555();
      var12.method1551(var0.method_23760().method_23761(), var1, var2);
   }

   public static void method1467(
      class_4587 var0, float var1, float var2, float var3, float var4, float var5, class_2960 var6, Color var7, Color var8, Color var9, Color var10
   ) {
      TextureRenderCommand var11 = RenderCommandFactory.method1615()
         .method0926(new RenderSize(var3, var4))
         .method0825(new CornerRadius(var5))
         .method0698(1.0F, 1.0F, 1.0F, 1.0F, field0796.method_1531().method_4619(var6))
         .method0917(new QuadColor(var7, var8, var9, var10))
         .method0555();
      var11.method1551(var0.method_23760().method_23761(), var1, var2);
   }

   public static void method2171(class_4587 var0, float var1, float var2, float var3, float var4, float var5, Color var6) {
      if (!(var5 <= 0.0F)) {
         var5 = Math.min(1.0F, var5);
         int var7 = 256;
         float var8 = (float) (-Math.PI / 2);
         float var9 = (float)(6.283186738202282 * var5);
         float var10 = var3;
         float var11 = var3 - var4;
         float var12 = 0.5F;
         float var13 = var10 + var12;
         float var14 = var11 - var12;
         Matrix4f var15 = var0.method_23760().method_23761();
         int var16 = var6.getRed();
         int var17 = var6.getGreen();
         int var18 = var6.getBlue();
         int var19 = var6.getAlpha();
         boolean var20 = GL11.glIsEnabled(3042);
         RenderSystem.enableBlend();
         RenderSystem.defaultBlendFunc();
         RenderSystem.setShader(class_10142.field_53876);
         class_287 var21 = class_289.method_1348().method_60827(class_5596.field_27380, class_290.field_1576);

         for (int var22 = 0; var22 <= var7; var22++) {
            float var23 = var8 + var9 * var22 / var7;
            float var24 = (float)Math.cos(var23);
            float var25 = (float)Math.sin(var23);
            var21.method_22918(var15, var1 + var13 * var24, var2 + var13 * var25, 0.0F).method_1336(var16, var17, var18, 0);
            var21.method_22918(var15, var1 + var10 * var24, var2 + var10 * var25, 0.0F).method_1336(var16, var17, var18, var19);
         }

         class_286.method_43433(var21.method_60800());
         var21 = class_289.method_1348().method_60827(class_5596.field_27380, class_290.field_1576);

         for (int var29 = 0; var29 <= var7; var29++) {
            float var31 = var8 + var9 * var29 / var7;
            float var33 = (float)Math.cos(var31);
            float var35 = (float)Math.sin(var31);
            var21.method_22918(var15, var1 + var10 * var33, var2 + var10 * var35, 0.0F).method_1336(var16, var17, var18, var19);
            var21.method_22918(var15, var1 + var11 * var33, var2 + var11 * var35, 0.0F).method_1336(var16, var17, var18, var19);
         }

         class_286.method_43433(var21.method_60800());
         var21 = class_289.method_1348().method_60827(class_5596.field_27380, class_290.field_1576);

         for (int var30 = 0; var30 <= var7; var30++) {
            float var32 = var8 + var9 * var30 / var7;
            float var34 = (float)Math.cos(var32);
            float var36 = (float)Math.sin(var32);
            var21.method_22918(var15, var1 + var11 * var34, var2 + var11 * var36, 0.0F).method_1336(var16, var17, var18, var19);
            var21.method_22918(var15, var1 + var14 * var34, var2 + var14 * var36, 0.0F).method_1336(var16, var17, var18, 0);
         }

         class_286.method_43433(var21.method_60800());
         if (!var20) {
            RenderSystem.disableBlend();
         }
      }
   }

   public static void method1404(class_332 var0, float var1, float var2, float var3, float var4) {
      var0.method_44379((int)var1, (int)var2, (int)(var1 + var3), (int)(var2 + var4));
   }

   public static void method0312(class_332 var0, float var1, float var2, float var3, float var4) {
      float var5 = ScreenLayoutHelper.method0002();
      var0.method_44379((int)(var1 * var5), (int)(var2 * var5), (int)((var1 + var3) * var5), (int)((var2 + var4) * var5));
   }

   public static void method1400(class_332 var0) {
      var0.method_44380();
   }

   public static class_1044 method0970(BufferedImage var0) {
      int var1 = var0.getWidth();
      int var2 = var0.getHeight();
      class_1011 var3 = new class_1011(var1, var2, false);

      for (int var4 = 0; var4 < var2; var4++) {
         for (int var5 = 0; var5 < var1; var5++) {
            var3.method_61941(var5, var4, var0.getRGB(var5, var4));
         }
      }

      return new class_1043(var3);
   }

   @Generated
   private GuiRenderHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
