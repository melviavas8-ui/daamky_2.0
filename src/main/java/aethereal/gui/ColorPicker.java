package aethereal;

import java.awt.Color;
import java.util.Objects;
import java.util.function.Supplier;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_3532;

public final class ColorPicker extends GuiElement {
   private static final class_2960 field0738 = DaamkyClient.method1012("textures/hue.png");
   private static final class_2960 field0160 = DaamkyClient.method1012("textures/alphahue.png");
   private static final float field1410 = 10.0F;
   private static final float field0957 = 45.0F;
   private static final float field0177 = 9.0F;
   private static final float field0458 = 7.0F;
   private static final float field1614 = 6.0F;
   private static final float field1538 = 1.5F;
   private static final int field1705 = 6;
   private static final float field1136 = 6.0F;
   private static final float field1087 = 6.0F;
   private static final float field1196 = 0.0F;
   private static final float field0871 = 3.0F;
   private static final float field0826 = 5.0F;
   private static final float field0910 = 4.0F;
   private static final int field1332 = 6;
   private static final int field1293 = 4;
   private static final float field1369 = 73.0F;
   private static final float field0385 = 94.0F;
   private static final float field0351 = 4.5F;
   private static final Color[] field0443 = new Color[]{
      new Color(16739179), new Color(16755021), new Color(16766011), new Color(6937468), new Color(5090295), new Color(13393384)
   };
   private final ColorSetting field0260;
   private final Supplier<Float> field0240;
   private final ColorPicker.ColorSlider field0296;
   private final ColorPicker.PickerArea field0530;
   private final Animation field0510;
   private final Animation field0555;
   private final Animation field1679 = new Animation(150L, 1.0, false, EasingCurve.field1477);
   private int field1658 = -1;
   private RectangleRenderCommand field1696;
   private int field1591 = -1;
   private float field1577 = -1.0F;
   private RectangleRenderCommand field1606;
   private RectangleRenderCommand field1758;
   private float field1739 = -1.0F;
   private float field1766 = -1.0F;
   private float field1174;
   private float field1164;
   private float field1186 = 1.0F;
   private static final float field1119 = 3.0F;

   private static String method2191() {
      try {
         return ClickGuiDashboard.field0984.method0492() == ClickGuiDashboard.Language.field0631 ? "Синхронизация цвета" : "Theme Color Sync";
      } catch (Exception var1) {
         return "Theme Color Sync";
      }
   }

   public void method0665(float var1) {
      this.field1186 = class_3532.method_15363(var1, 0.0F, 1.0F);
   }

   private Color method0960(Color var1) {
      return this.field1186 >= 0.99F
         ? var1
         : new Color(var1.getRed(), var1.getGreen(), var1.getBlue(), Math.max(0, Math.min(255, (int)(var1.getAlpha() * this.field1186))));
   }

   private int method0716(int var1) {
      if (this.field1186 >= 0.99F) {
         return var1;
      }

      int var2 = var1 >>> 24 & 0xFF;
      int var3 = var1 & 16777215;
      int var4 = Math.max(0, Math.min(255, (int)(var2 * this.field1186)));
      return var4 << 24 | var3;
   }

   public ColorPicker(ColorSetting var1, Supplier<Float> var2) {
      this.field0260 = Objects.requireNonNull(var1);
      this.field0240 = Objects.requireNonNull(var2);
      this.field0296 = ColorPicker.ColorSlider.method0957(var1.method1726());
      this.field0530 = new ColorPicker.PickerArea();
      this.field0510 = new Animation(350L, 1.0, false, EasingCurve.field1477);
      this.field0555 = new Animation(250L, 1.0, false, EasingCurve.field1477);
      this.field0555.method1570(var1.method1938());
      this.field0555.method1973();
   }

   public void method1570(boolean var1) {
      this.field0510.method1570(var1);
   }

   public void method2100(float var1, float var2) {
      this.field1174 = var1;
      this.field1164 = var2;
   }

   public boolean method1974() {
      return this.field0510.method0376();
   }

   public boolean method0431() {
      return this.field0510.method0346(false);
   }

   public float method0355() {
      return this.field0510.method0002();
   }

   public float method0483() {
      return this.field1174;
   }

   public float method2213() {
      return this.field1164;
   }

   @Override
   public float method2047() {
      return 73.0F;
   }

   @Override
   public float method1762() {
      return 94.0F;
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      this.method2266();
      this.method1915();
      float var5 = this.method0530();
      float var6 = this.method0002();
      float var7 = var6 + 10.0F + 3.0F;
      this.method1402(var1, var5, var6);
      this.method1411(var1, var5, var6, var2, var3);
      this.method0310(var1, var5 + 0.0F, var7 + 0.0F);
      this.method1672(var1, var5 + 45.0F + 0.0F + 3.0F, var7 + 0.0F);
      this.method1999(var1, var5 + 45.0F + 0.0F + 3.0F + 6.0F + 3.0F, var7 + 0.0F);
      this.method0511(var1, var5 + 45.0F + 0.0F + 3.0F + 6.0F + 3.0F + 6.0F + 3.0F, var7 + 0.0F);
      this.method0392(var1, var5 + 0.0F, var7 + 45.0F + 0.0F + 3.0F);
      this.method2239(var1, var5, var7 + 45.0F + 0.0F + 3.0F + 14.0F + 3.0F);
      if (this.field0530.method1635()) {
         this.method0742(var2, var3, var5, var7);
      }
   }

   private void method1411(class_332 var1, float var2, float var3, int var4, int var5) {
      FontSize var6 = Fonts.field0774.method0654(4.0F);
      float var7 = var6.method0998("F");
      float var8 = var6.method0530();
      float var9 = var2 + 73.0F - var7 - 2.0F;
      float var10 = var3 + (10.0F - var8) / 2.0F - 1.5F;
      boolean var11 = this.field0510.method0002() > 0.5F && MathHelper.method0689(var9 - 3.0F, var10 - 3.0F, var7 + 6.0F, var8 + 6.0F, var4, var5);
      if (this.field1679.method0376() != var11) {
         this.field1679.method1570(var11);
      }

      float var12 = this.field1679.method0002();
      int var13 = (int)(170.0F + 70.0F * var12);
      int var14 = (int)(170.0F + 70.0F * var12);
      int var15 = (int)(170.0F + 80.0F * var12);
      int var16 = (int)(2.55F * (52.0F + 90.0F * var12));
      Color var17 = this.method0960(new Color(Math.min(255, var13), Math.min(255, var14), Math.min(255, var15), Math.min(255, var16)));
      float var18 = 1.0F + 0.18F * var12;
      float var19 = var9 + var7 / 2.0F;
      float var20 = var10 + var8 / 2.0F;
      var1.method_51448().method_22903();
      var1.method_51448().method_46416(var19, var20, 0.0F);
      var1.method_51448().method_22905(var18, var18, 1.0F);
      var1.method_51448().method_46416(-var19, -var20, 0.0F);
      GuiRenderHelper.method1491(var1.method_51448(), var6, "F", var9, var10, var17);
      var1.method_51448().method_22909();
   }

   private boolean method0616(double var1, double var3) {
      FontSize var5 = Fonts.field0774.method0654(4.0F);
      float var6 = var5.method0998("F");
      float var7 = var5.method0530();
      float var8 = this.method0530() + 73.0F - var6 - 2.0F;
      float var9 = this.method0002() + (10.0F - var7) / 2.0F - 0.5F;
      return MathHelper.method0689(var8 - 3.0F, var9 - 3.0F, var6 + 6.0F, var7 + 6.0F, (float)var1, (float)var3);
   }

   private void method1402(class_332 var1, float var2, float var3) {
      FontSize var4 = Fonts.field0075.method0654(5.5F);
      FontSize var5 = Fonts.field0774.method0654(4.0F);
      Color var6 = ThemeColorManager.method1908().method2063();
      Color var7 = this.method0960(new Color(var6.getRed(), var6.getGreen(), var6.getBlue(), 255));
      float var8 = var5.method0998("k");
      float var9 = var3 + (10.0F - var5.method0530()) / 2.0F;
      GuiRenderHelper.method1491(var1.method_51448(), var5, "k", var2, var9, var7);
      float var10 = var2 + var8 + 2.0F;
      float var11 = 73.0F - (var10 - var2);
      String var12 = TextTruncator.method0831(var4, this.field0260.method2067(), var11);
      float var13 = var3 + (10.0F - var4.method0530()) / 2.0F;
      Color var14 = this.method0960(new Color(-1208551425, true));
      GuiRenderHelper.method1491(var1.method_51448(), var4, var12, var10, var13, var14);
   }

   private void method2266() {
      if (!this.field0530.method1635()) {
         Color var1 = this.field0260.method1726();
         float[] var2 = Color.RGBtoHSB(var1.getRed(), var1.getGreen(), var1.getBlue(), null);
         float var3 = 0.001F;
         boolean var4 = Math.abs(this.field0296.method0002() - var2[1]) > var3;
         boolean var5 = Math.abs(this.field0296.method2047() - var2[2]) > var3;
         float var6 = Math.abs(this.field0296.method0530() - var2[0]);
         float var7 = Math.min(var6, 1.0F - var6);
         boolean var8 = var7 > var3;
         if (var4 || var5 || var8) {
            float var9 = this.field0296.method0530();
            if (var2[1] > 0.01F && var2[2] > 0.01F && var8) {
               var9 = var2[0];
            }

            this.field0296.method0684(var9, var2[1], var2[2]);
         }
      }
   }

   private void method0310(class_332 var1, float var2, float var3) {
      this.method2167(var1, var2, var3);
      this.method1869(var1, var2, var3);
   }

   private void method2167(class_332 var1, float var2, float var3) {
      if (this.field1606 == null
         || this.field1758 == null
         || this.field1739 != this.field0296.method0530()
         || Math.abs(this.field1766 - this.field1186) > 0.005F) {
         int var4 = Color.HSBtoRGB(this.field0296.method0530(), 1.0F, 1.0F);
         ColorPicker.RgbColor var5 = ColorPicker.RgbColor.method0719(var4);
         Color var6 = this.method0960(new Color(255, 255, 255, 255));
         Color var7 = this.method0960(new Color(0, 0, 0, 255));
         Color var8 = this.method0960(new Color(0, 0, 0, 255));
         Color var9 = this.method0960(new Color(var5.method0531(), var5.method0003(), var5.method2048(), 255));
         this.field1606 = RenderCommandFactory.method0548()
            .method0925(new RenderSize(45.0F, 45.0F))
            .method0824(new CornerRadius(5.0F))
            .method0916(new QuadColor(var6, var7, var8, var9))
            .method0555();
         Color var10 = this.method0960(new Color(255, 255, 255, 255));
         Color var11 = this.method0960(new Color(255, 255, 255, 0));
         Color var12 = this.method0960(new Color(var5.method0531(), var5.method0003(), var5.method2048(), 0));
         Color var13 = this.method0960(new Color(var5.method0531(), var5.method0003(), var5.method2048(), 255));
         this.field1758 = RenderCommandFactory.method0548()
            .method0925(new RenderSize(45.0F, 45.0F))
            .method0824(new CornerRadius(5.0F))
            .method0916(new QuadColor(var10, var11, var12, var13))
            .method0555();
         this.field1739 = this.field0296.method0530();
         this.field1766 = this.field1186;
      }

      this.field1606.method1551(var1.method_51448().method_23760().method_23761(), var2, var3);
      this.field1758.method1551(var1.method_51448().method_23760().method_23761(), var2, var3);
   }

   private void method1869(class_332 var1, float var2, float var3) {
      float var4 = 3.0F;
      float var5 = var4;
      float var6 = var2 + this.field0296.method0002() * 45.0F;
      float var7 = var3 + (1.0F - this.field0296.method2047()) * 45.0F;
      float var8 = class_3532.method_15363(var6, var2 + var5, var2 + 45.0F - var5);
      float var9 = class_3532.method_15363(var7, var3 + var5, var3 + 45.0F - var5);
      Color var10 = this.method0960(new Color(this.field0260.method1742(), this.field0260.method2019(), this.field0260.method2002(), 255));
      GuiRenderHelper.method0326(var1.method_51448(), var8 - 3.0F, var9 - 3.0F, 6.0F, 6.0F, 2.0F, var10);
      GuiRenderHelper.method0323(var1.method_51448(), var8 - 3.0F, var9 - 3.0F, 6.0F, 6.0F, 2.0F, 0.8F, 0.5F, 0.5F, this.method0960(Color.WHITE));
   }

   private void method1672(class_332 var1, float var2, float var3) {
      GuiRenderHelper.method1466(var1.method_51448(), var2, var3, 6.0F, 44.0F, 2.0F, field0738, this.method0960(Color.WHITE));
      float var4 = var3 + (1.0F - this.field0296.method0530()) * 44.0F;
      float var5 = var2 + 3.0F - 3.0F;
      float var6 = class_3532.method_15363(var4, var3, var3 + 45.0F - 7.0F);
      Color var7 = this.method0960(new Color(Color.HSBtoRGB(this.field0296.method0530(), 1.0F, 1.0F)));
      GuiRenderHelper.method1463(var1.method_51448(), var5, var6, 6.0F, 6.0F, 2.0F, var7);
      GuiRenderHelper.method1460(var1.method_51448(), var5, var6, 6.0F, 6.0F, 2.0F, 0.8F, 0.5F, 0.5F, this.method0960(Color.WHITE));
   }

   private void method1999(class_332 var1, float var2, float var3) {
      int var4 = this.field0260.method1742() << 16 | this.field0260.method2019() << 8 | this.field0260.method2002();
      if (this.field1696 == null || this.field1591 != var4 || Math.abs(this.field1577 - this.field1186) > 0.005F) {
         Color var5 = this.method0960(new Color(this.field0260.method1742(), this.field0260.method2019(), this.field0260.method2002(), 255));
         Color var6 = this.method0960(new Color(this.field0260.method1742(), this.field0260.method2019(), this.field0260.method2002(), 0));
         this.field1696 = RenderCommandFactory.method0548()
            .method0925(new RenderSize(6.0F, 44.0F))
            .method0824(new CornerRadius(2.0F))
            .method0916(new QuadColor(var5, var6, var6, var5))
            .method0555();
         this.field1591 = var4;
         this.field1577 = this.field1186;
      }

      this.field1696.method1551(var1.method_51448().method_23760().method_23761(), var2, var3);
      float var9 = var3 + (1.0F - this.field0260.method2036() / 255.0F) * 44.0F;
      float var10 = var2 + 3.0F - 3.0F;
      float var7 = class_3532.method_15363(var9, var3, var3 + 45.0F - 7.0F);
      Color var8 = this.method0960(new Color(this.field0260.method1742(), this.field0260.method2019(), this.field0260.method2002(), 255));
      GuiRenderHelper.method1463(var1.method_51448(), var10, var7, 6.0F, 6.0F, 2.0F, var8);
      GuiRenderHelper.method1460(var1.method_51448(), var10, var7, 6.0F, 6.0F, 2.0F, 0.8F, 0.5F, 0.5F, this.method0960(Color.WHITE));
   }

   private void method0449(class_332 var1, float var2, float var3) {
      Color var4 = new Color(200, 200, 200);
      Color var5 = new Color(150, 150, 150);
      int var6 = 2;
      int var7 = 12;

      for (int var8 = 0; var8 < var6; var8++) {
         for (int var9 = 0; var9 < var7; var9++) {
            Color var10 = (var8 + var9) % 2 == 0 ? var4 : var5;
            float var11 = var2 + var8 * 4;
            float var12 = var3 + var9 * 4;
            float var13 = Math.min(4.0F, 6.0F - var8 * 4);
            float var14 = Math.min(4.0F, 45.0F - var9 * 4);
            float var15 = 0.0F;
            if (var8 == 0 && var9 == 0) {
               var15 = 4.0F;
            } else if (var8 == var6 - 1 && var9 == 0) {
               var15 = 4.0F;
            } else if (var8 == 0 && var9 == var7 - 1) {
               var15 = 4.0F;
            } else if (var8 == var6 - 1 && var9 == var7 - 1) {
               var15 = 4.0F;
            }

            GuiRenderHelper.method1463(var1.method_51448(), var11, var12, var13, var14, var15, var10);
         }
      }
   }

   private void method0392(class_332 var1, float var2, float var3) {
      float var4 = 63.0F;
      float var5 = 14.0F;
      GuiRenderHelper.method1463(var1.method_51448(), var2, var3, var4, var5, 3.0F, this.method0960(new Color(83294207, true)));
      GuiRenderHelper.method1461(var1.method_51448(), var2, var3 - 0.2F, var4, var5, 3.0F, 0.6F, 0.6F, this.method0960(new Color(150403071, true)));
      FontSize var6 = Fonts.field0075.method0654(6.0F);
      String var7 = String.format("%02X%02X%02X", this.field0260.method1742(), this.field0260.method2019(), this.field0260.method2002());
      Color var8 = this.method0960(new Color(821491711, true));
      Color var9 = this.method0960(new Color(1626798079, true));
      float var10 = var2 + (var4 - var6.method0998("#" + var7)) / 2.0F - 15.0F;
      float var11 = var3 + (var5 - var6.method0530()) / 2.0F;
      GuiRenderHelper.method1491(var1.method_51448(), var6, "#", var10, var11, var8);
      GuiRenderHelper.method1491(var1.method_51448(), var6, var7, var10 + var6.method0998("#"), var11, var9);
   }

   private void method1915() {
      if (this.field1658 >= 0 && this.field1658 < 6) {
         Color var1 = this.field0260.method1687();
         Color var2 = field0443[this.field1658];
         if (var2 == null || var2.getRed() != var1.getRed() || var2.getGreen() != var1.getGreen() || var2.getBlue() != var1.getBlue()) {
            field0443[this.field1658] = new Color(var1.getRed(), var1.getGreen(), var1.getBlue());
         }
      }
   }

   private void method0511(class_332 var1, float var2, float var3) {
      float var4 = 2.0F;

      for (int var5 = 0; var5 < 6; var5++) {
         float var6 = var3 + var5 * 7.5F;
         Color var7 = field0443[var5];
         if (var7 != null) {
            Color var8 = this.method0960(new Color(var7.getRed(), var7.getGreen(), var7.getBlue(), 255));
            GuiRenderHelper.method0326(var1.method_51448(), var2, var6, 6.0F, 6.0F, var4, var8);
         }
      }
   }

   private void method2239(class_332 var1, float var2, float var3) {
      FontSize var4 = Fonts.field0075.method0654(4.5F);
      FontSize var5 = Fonts.field0774.method0654(4.5F);
      float var6 = 10.0F;
      float var7 = 7.0F;
      float var8 = var2 + 73.0F - var6;
      float var9 = var3 + (9.0F - var7) / 2.0F;
      float var10 = var3 + (9.0F - var4.method0530()) / 2.0F;
      float var11 = var3 + (9.0F - var5.method0530()) / 2.0F - 0.5F;
      Color var12 = this.method0960(ThemeColorManager.method1908().method2063());
      GuiRenderHelper.method1491(var1.method_51448(), var5, "r", var2, var11, var12);
      float var13 = var2 + var5.method0998("r") + 2.0F;
      Color var14 = this.method0960(new Color(-1711867905, true));
      GuiRenderHelper.method1491(var1.method_51448(), var4, method2191(), var13, var10, var14);
      this.method2199(var1, var8, var9);
   }

   private void method2199(class_332 var1, float var2, float var3) {
      if (this.field0555.method0376() != this.field0260.method1938()) {
         this.field0555.method1570(this.field0260.method1938());
      }

      float var4 = this.field0555.method0002();
      Color var5 = ThemeColorManager.method1908().method2063();
      Color var6 = new Color(255, 255, 255, 24);
      Color var7 = this.method0960(
         new Color(
            (int)(var6.getRed() + (var5.getRed() - var6.getRed()) * var4),
            (int)(var6.getGreen() + (var5.getGreen() - var6.getGreen()) * var4),
            (int)(var6.getBlue() + (var5.getBlue() - var6.getBlue()) * var4),
            (int)(var6.getAlpha() + (180 - var6.getAlpha()) * var4)
         )
      );
      Color var8 = this.method0960(new Color(255, 255, 255, (int)(160.0F + 60.0F * var4)));
      GuiRenderHelper.method0326(var1.method_51448(), var2, var3, 10.0F, 7.0F, 2.5F, var7);
      GuiRenderHelper.method0326(var1.method_51448(), var2 + 1.0F + 3.0F * var4, var3 + 1.0F, 5.0F, 5.0F, 1.5F, var8);
   }

   private void method0742(int var1, int var2, float var3, float var4) {
      float var5 = var3 + 0.0F;
      float var6 = var4 + 0.0F;
      float var7 = var3 + 45.0F + 0.0F + 3.0F;
      float var8 = var4 + 0.0F;
      float var9 = var3 + 45.0F + 0.0F + 3.0F + 6.0F + 3.0F;
      float var10 = var4 + 0.0F;
      if (this.field0530.method1974()) {
         this.method0686(var1, var2, var5, var6);
      } else if (this.field0530.method0431()) {
         this.method1824(var2, var8);
      } else if (this.field0530.method0376()) {
         this.method1639(var2, var10);
      }
   }

   private void method0686(float var1, float var2, float var3, float var4) {
      float var5 = class_3532.method_15363((var1 - var3) / 45.0F, 0.0F, 1.0F);
      float var6 = 1.0F - class_3532.method_15363((var2 - var4) / 45.0F, 0.0F, 1.0F);
      var5 = Math.round(var5 * 1000.0F) / 1000.0F;
      var6 = Math.round(var6 * 1000.0F) / 1000.0F;
      this.field0296.method0684(this.field0296.method0530(), var5, var6);
      this.method1890();
   }

   private void method1824(float var1, float var2) {
      float var3 = 1.0F - class_3532.method_15363((var1 - var2) / 44.0F, 0.0F, 1.0F);
      var3 = Math.round(var3 * 1000.0F) / 1000.0F;
      float var4 = this.field0296.method0530();
      if (!(Math.abs(var3 - var4) < 0.005F)) {
         this.field0296.method0684(var3, this.field0296.method0002(), this.field0296.method2047());
         this.method1890();
      }
   }

   private void method1639(float var1, float var2) {
      float var3 = 1.0F - class_3532.method_15363((var1 - var2) / 44.0F, 0.0F, 1.0F);
      var3 = Math.round(var3 * 1000.0F) / 1000.0F;
      int var4 = Math.max(10, (int)(var3 * 255.0F));
      if (Math.abs(var4 - this.field0260.method2036()) >= 2) {
         this.field0260.method1827(var4);
      }
   }

   private void method1890() {
      ColorPicker.RgbColor var1 = ColorPicker.RgbColor.method0719(
         Color.HSBtoRGB(this.field0296.method0530(), this.field0296.method0002(), this.field0296.method2047())
      );
      this.field0260.method0749(var1.method0531(), var1.method0003(), var1.method2048(), this.field0260.method2036());
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      float var6 = this.method0530();
      float var7 = this.method0002();
      float var8 = var7 + 10.0F + 3.0F;
      boolean var9 = MathHelper.method0689(var6, var7, this.method2047(), this.method1762(), (float)var1, (float)var3);
      if (!var9) {
         return false;
      }

      if (var5 == 0) {
         if (this.method0616(var1, var3)) {
            ColorSettingWidget.method1973();
            return true;
         }

         float var10 = var8 + 45.0F + 3.0F + 14.0F + 3.0F;
         float var11 = var6 + 73.0F - 10.0F;
         float var12 = var10 + 1.0F;
         if (MathHelper.method0689(var11, var12, 10.0F, 7.0F, (float)var1, (float)var3)) {
            this.field0260.method1570(!this.field0260.method1938());
            this.field0555.method1570(this.field0260.method1938());
            this.field0555.method1634();
            return true;
         }

         float var13 = var6 + 45.0F + 3.0F + 6.0F + 3.0F + 6.0F + 3.0F;
         float var14 = 43.5F;
         if (MathHelper.method0689(var13, var8, 6.0F, var14, (float)var1, (float)var3)) {
            int var15 = (int)(((float)var3 - var8) / 7.5F);
            if (var15 >= 0 && var15 < 6) {
               Color var16 = field0443[var15];
               if (var16 != null) {
                  this.field0260.method0749(var16.getRed(), var16.getGreen(), var16.getBlue(), this.field0260.method2036());
               }

               this.field1658 = var15;
               return true;
            }
         }

         if (this.method0626(var1, var3, var6, var8)) {
            return true;
         }

         if (this.method0110(var1, var3, var6, var8)) {
            return true;
         }

         if (this.method2091(var1, var3, var6, var8)) {
            return true;
         }
      }

      return true;
   }

   private boolean method0626(double var1, double var3, float var5, float var6) {
      float var7 = var5 + 0.0F;
      float var8 = var6 + 0.0F;
      if (MathHelper.method0689(var7, var8, 45.0F, 45.0F, (float)var1, (float)var3)) {
         this.field0530.method0578();
         this.method0686((float)var1, (float)var3, var7, var8);
         return true;
      } else {
         return false;
      }
   }

   private boolean method0110(double var1, double var3, float var5, float var6) {
      float var7 = var5 + 45.0F + 0.0F + 3.0F;
      float var8 = var6 + 0.0F;
      if (MathHelper.method0689(var7, var8, 6.0F, 44.0F, (float)var1, (float)var3)) {
         this.field0530.method0025();
         this.method1824((float)var3, var8);
         return true;
      } else {
         return false;
      }
   }

   private boolean method2091(double var1, double var3, float var5, float var6) {
      float var7 = var5 + 45.0F + 0.0F + 3.0F + 6.0F + 3.0F;
      float var8 = var6 + 0.0F;
      if (MathHelper.method0689(var7, var8, 6.0F, 44.0F, (float)var1, (float)var3)) {
         this.field0530.method2078();
         this.method1639((float)var3, var8);
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean method0112(double var1, double var3, int var5) {
      boolean var6 = MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3);
      if (var5 == 0 || var5 == 1) {
         this.field0530.method1812();
      }

      return var6;
   }

   private static final class ColorSlider {
      private float field0566;
      private float field0003;
      private float field1410;

      private ColorSlider(float var1, float var2, float var3) {
         this.field0566 = var1;
         this.field0003 = var2;
         this.field1410 = var3;
      }

      static ColorPicker.ColorSlider method0957(Color var0) {
         float[] var1 = Color.RGBtoHSB(var0.getRed(), var0.getGreen(), var0.getBlue(), null);
         return new ColorPicker.ColorSlider(var1[0], var1[1], var1[2]);
      }

      void method0684(float var1, float var2, float var3) {
         this.field0566 = var1;
         this.field0003 = var2;
         this.field1410 = var3;
      }

      float method0530() {
         return this.field0566;
      }

      float method0002() {
         return this.field0003;
      }

      float method2047() {
         return this.field1410;
      }
   }

   private record RgbColor(int red, int green, int blue) {
      static ColorPicker.RgbColor method0719(int var0) {
         return new ColorPicker.RgbColor(var0 >> 16 & 0xFF, var0 >> 8 & 0xFF, var0 & 0xFF);
      }

      public int method0531() {
         return this.red;
      }

      public int method0003() {
         return this.green;
      }

      public int method2048() {
         return this.blue;
      }
   }

   private static final class PickerArea {
      private ColorPicker.PickerArea.ColorSlider field0633;

      private PickerArea() {
         this.field0633 = ColorPicker.PickerArea.ColorSlider.field0633;
      }

      void method0578() {
         this.field0633 = ColorPicker.PickerArea.ColorSlider.field0067;
      }

      void method0025() {
         this.field0633 = ColorPicker.PickerArea.ColorSlider.field1455;
      }

      void method2078() {
         this.field0633 = ColorPicker.PickerArea.ColorSlider.field0989;
      }

      void method1812() {
         this.field0633 = ColorPicker.PickerArea.ColorSlider.field0633;
      }

      boolean method1635() {
         return this.field0633 != ColorPicker.PickerArea.ColorSlider.field0633;
      }

      boolean method1974() {
         return this.field0633 == ColorPicker.PickerArea.ColorSlider.field0067;
      }

      boolean method0431() {
         return this.field0633 == ColorPicker.PickerArea.ColorSlider.field1455;
      }

      boolean method0376() {
         return this.field0633 == ColorPicker.PickerArea.ColorSlider.field0989;
      }

      private enum ColorSlider {
         field0633,
         field0067,
         field1455,
         field0989;
      }
   }
}
