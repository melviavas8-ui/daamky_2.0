package aethereal;

import java.awt.Color;
import java.util.Objects;
import java.util.function.Supplier;
import net.minecraft.class_332;
import net.minecraft.class_9848;

public final class ColorSettingWidget extends SettingWidget {
   private static FontSize field0624;
   private static FontSize field0055;
   private static FontSize field1446;
   private static FontSize field0981;
   private static boolean field0219 = false;
   private static final float field0458 = 8.0F;
   private static final float field1614 = 1.5F;
   private static final int field1539 = 72;
   private static final int field1705 = 28;
   private static final int field1137 = 48;
   private static final int field1088 = 24;
   private static ColorSettingWidget field1207;
   private final MutableColor field0882 = new MutableColor();
   private final MutableColor field0838 = new MutableColor();
   private final MutableColor field0924 = new MutableColor();
   private final MutableColor field1344 = new MutableColor();
   private final MutableColor field1303 = new MutableColor();
   private final ColorPicker field1378;
   private final PopupPanel field0394;
   private boolean field0369 = false;
   private boolean field0442 = false;

   private static void method2228() {
      if (!field0219) {
         field0624 = Fonts.field0075.method0654(6.0F);
         field0055 = Fonts.field0075.method0654(5.0F);
         field1446 = Fonts.field0774.method0654(4.0F);
         field0981 = Fonts.field0075.method0654(4.5F);
         field0219 = true;
      }
   }

   public ColorSettingWidget(ColorSetting var1, Supplier<Float> var2) {
      super(Objects.requireNonNull(var1), Objects.requireNonNull(var2));
      this.field1378 = new ColorPicker(var1, var2);
      this.field0394 = new PopupPanel(this.field1378);
   }

   @Override
   public float method1762() {
      method2228();
      String var1 = this.method0828(field0055);
      float var2 = ThemePalette.field0439.get() ? field0055.method0208(var1) : 2.0F;
      return 8.0F + var2;
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method2228();
      if (this.field0369 && !PopupManager.method0416().method1620().contains(this.field0394)) {
         this.field0442 = false;
         this.field0369 = false;
         if (field1207 == this) {
            field1207 = null;
         }
      }

      ColorSettingWidget.ColorFieldPalette var5 = this.method2187();
      String var6 = this.method0828(field0055);
      this.method1418(var1, field1446, var5);
      this.method1417(var1, field0624, field1446, var5);
      this.method1419(var1, field0055, var6, var5);
      this.method1420(var1, var5);
   }

   private ColorSettingWidget.ColorFieldPalette method2187() {
      float var1 = this.method0495().get();
      int var2 = class_9848.method_61319(var1, class_9848.method_61330(122, ThemePalette.field1137), ThemeColorManager.method1604());
      int var3 = class_9848.method_61330((int)(183.59999F + 28.0F * var1), ThemePalette.field0567);
      int var4 = class_9848.method_61330((int)(61.199997F + 24.0F * var1), ThemePalette.field0567);
      int var5 = class_9848.method_61330(61, ThemePalette.field0567);
      return new ColorSettingWidget.ColorFieldPalette(var2, var3, var4, var5);
   }

   private String method0828(FontSize var1) {
      return TextTruncator.method0831(var1, this.method0366().method1791(), this.method2047() - 8.0F - 8.0F);
   }

   private void method1418(class_332 var1, FontSize var2, ColorSettingWidget.ColorFieldPalette var3) {
      this.field0882.method0729(var3.method0531());
      GuiRenderHelper.method1491(var1.method_51448(), var2, "k", this.method0530(), this.method0002() + 2.0F, this.field0882);
   }

   private void method1417(class_332 var1, FontSize var2, FontSize var3, ColorSettingWidget.ColorFieldPalette var4) {
      float var5 = this.method0530() + var3.method0998("k") + 2.0F;
      float var6 = this.method0002() + 1.0F;
      this.field0838.method0729(var4.method0003());
      GuiRenderHelper.method1491(var1.method_51448(), var2, this.method0366().method2067(), var5, var6, this.field0838);
   }

   private void method1419(class_332 var1, FontSize var2, String var3, ColorSettingWidget.ColorFieldPalette var4) {
      if (ThemePalette.field0439.get()) {
         this.field0924.method0729(var4.method2048());
         GuiRenderHelper.method1491(var1.method_51448(), var2, var3, this.method0530(), this.method0002() + 8.0F, this.field0924);
      }
   }

   private void method1420(class_332 var1, ColorSettingWidget.ColorFieldPalette var2) {
      ColorSetting var3 = (ColorSetting)this.method0366();
      Color var4 = var3.method1726();
      float var5 = this.method0530() + this.method2047() - 8.0F;
      float var6 = this.method0002();
      String var7 = String.format("#%02X%02X%02X", var4.getRed(), var4.getGreen(), var4.getBlue());
      float var8 = field0981.method0998(var7);
      float var9 = 3.0F;
      float var10 = var8 + var9 * 2.0F;
      float var11 = 7.0F;
      float var12 = var5 - var10 - 3.0F;
      float var13 = var6 + (8.0F - var11) / 2.0F;
      Color var14 = new Color(var4.getRed(), var4.getGreen(), var4.getBlue(), 255);
      this.field1303.method0729(this.method0964(var14, 0.35F).getRGB());
      GuiRenderHelper.method0326(var1.method_51448(), var12, var13, var10, var11, 2.0F, this.field1303);
      this.field1344.method0729(var14.getRGB());
      GuiRenderHelper.method1491(var1.method_51448(), field0981, var7, var12 + var9, var13 + (var11 - field0981.method0530()) / 2.0F, this.field1344);
      int var15 = Math.max(var4.getAlpha(), 40);
      Color var16 = new Color(var4.getRed(), var4.getGreen(), var4.getBlue(), var15);
      Color var17 = this.method0196(var16, 0.7F);
      GuiRenderHelper.method0326(var1.method_51448(), var5, var6, 8.0F, 8.0F, 3.0F, var17);
      GuiRenderHelper.method0326(var1.method_51448(), var5 + 1.5F - 0.5F, var6 + 1.5F - 0.5F, 6.0F, 6.0F, 2.0F, var16);
   }

   private Color method0964(Color var1, float var2) {
      return new Color((int)(var1.getRed() * 0.3F), (int)(var1.getGreen() * 0.3F), (int)(var1.getBlue() * 0.3F), (int)(255.0F * var2));
   }

   private Color method0196(Color var1, float var2) {
      int var3 = (int)(var1.getRed() * var2);
      int var4 = (int)(var1.getGreen() * var2);
      int var5 = (int)(var1.getBlue() * var2);
      return new Color(var3, var4, var5, var1.getAlpha());
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      if (this.method0616(var1, var3)) {
         if (var5 == 1) {
            ColorSetting var6 = (ColorSetting)this.method0366();
            var6.method1570(!var6.method1938());
            return true;
         }

         if (var5 == 0) {
            if (this.field0442) {
               PopupManager.method0416().method1620().remove(this.field0394);
               this.field0442 = false;
               this.field0369 = false;
               if (field1207 == this) {
                  field1207 = null;
               }

               this.method2100((float)var1, (float)var3);
            } else if (this.field0369) {
               this.method2266();
            } else {
               this.method2100((float)var1, (float)var3);
            }

            return true;
         }
      }

      return this.field0369
            && MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3)
         ? true
         : super.method0627(var1, var3, var5);
   }

   private boolean method0616(double var1, double var3) {
      float var5 = this.method0530() + this.method2047() - 8.0F;
      float var6 = this.method0002();
      return MathHelper.method0689(var5, var6, 8.0F, 8.0F, (float)var1, (float)var3);
   }

   private void method2100(float var1, float var2) {
      method1915();
      float var3 = this.method0530() + this.method2047() - 4.0F;
      float var4 = this.method0002() + 4.0F;
      float var5 = this.method0645(var3);
      float var6 = var4 - this.field0394.method1762() / 2.0F + 8.0F;
      float var7 = ScreenLayoutHelper.method1762();
      if (var6 + this.field0394.method1762() > var7) {
         var6 = var7 - this.field0394.method1762() - 10.0F;
      }

      if (var6 < 0.0F) {
         var6 = 10.0F;
      }

      this.field1378.method2100(var3, var4);
      this.field1378.method1570(true);
      this.field0394.method2228();
      this.field0394.method0670(var5, var6);
      this.field0394.method0498();
      this.field0369 = true;
      this.field0442 = false;
      field1207 = this;
   }

   private void method2266() {
      this.field1378.method1570(false);
      this.field0442 = true;
   }

   public static void method1973() {
      if (field1207 != null && field1207.field0369) {
         field1207.method2266();
      }
   }

   public static void method0430() {
      if (field1207 != null) {
         PopupManager var0 = PopupManager.method0416();
         if (var0 != null) {
            var0.method1620().remove(field1207.field0394);
         }

         field1207.field1378.method1570(false);
         field1207.field0369 = false;
         field1207.field0442 = false;
         field1207 = null;
      }
   }

   private static void method1915() {
      if (field1207 != null && field1207.field0369) {
         field1207.method2266();
      }

      BlockListSettingWidget.method1973();
      KeyBindListSettingWidget.method1973();
   }

   private float method0645(float var1) {
      float var2 = this.field0394.method2047();
      float var3 = ScreenLayoutHelper.method2047();
      return var1 + var2 + 10.0F > var3 ? var1 - var2 - 10.0F : var1 + 10.0F;
   }

   private float method0115(float var1) {
      float var2 = this.field0394.method1762();
      float var3 = ScreenLayoutHelper.method1762();
      return var1 + var2 + 10.0F > var3 ? var1 - var2 - 10.0F : var1 + 10.0F;
   }

   private record ColorFieldPalette(int icon, int name, int description, int border) {
      public int method0531() {
         return this.icon;
      }

      public int method0003() {
         return this.name;
      }

      public int method2048() {
         return this.description;
      }

      public int method1763() {
         return this.border;
      }
   }
}
