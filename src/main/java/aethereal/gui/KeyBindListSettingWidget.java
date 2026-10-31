package aethereal;

import java.awt.Color;
import java.util.Objects;
import java.util.function.Supplier;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_9848;

public final class KeyBindListSettingWidget extends SettingWidget {
   private static FontSize field0624;
   private static FontSize field0055;
   private static FontSize field1446;
   private static FontSize field0981;
   private static FontSize field0188;
   private static boolean field0497 = false;
   private static final int field1615 = 72;
   private static final int field1539 = 28;
   private static final int field1705 = 48;
   private static final int field1137 = 24;
   private static KeyBindListSettingWidget field1098;
   private final MutableColor field1208 = new MutableColor();
   private final MutableColor field0882 = new MutableColor();
   private final MutableColor field0838 = new MutableColor();
   private final KeyBindListEditor field0921;
   private final PopupPanel field1343;
   private boolean field1312 = false;
   private boolean field1388 = false;
   private float field0385 = 0.0F;

   private static void method2194() {
      if (!field0497) {
         field0624 = Fonts.field0075.method0654(6.0F);
         field0055 = Fonts.field0075.method0654(5.0F);
         field1446 = Fonts.field0774.method0654(5.0F);
         field0981 = Fonts.field1718.method0654(5.0F);
         field0188 = Fonts.field0075.method0654(6.0F);
         field0497 = true;
      }
   }

   public KeyBindListSettingWidget(KeyBindListSetting var1, Supplier<Float> var2) {
      super(Objects.requireNonNull(var1), Objects.requireNonNull(var2));
      this.field0921 = new KeyBindListEditor(var1, var2);
      this.field1343 = new PopupPanel(this.field0921);
   }

   @Override
   public float method1762() {
      method2194();
      String var1 = this.method0828(field0055);
      float var2 = ThemePalette.field0439.get() ? field0055.method0208(var1) : 2.0F;
      return 8.0F + var2;
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method2194();
      if (this.field1312 && !PopupManager.method0416().method1620().contains(this.field1343)) {
         this.field1388 = false;
         this.field1312 = false;
         if (field1098 == this) {
            field1098 = null;
         }
      }

      float var5 = this.method0495().get();
      int var6 = class_9848.method_61319(var5, class_9848.method_61330(122, ThemePalette.field1137), ThemeColorManager.method1604());
      int var7 = class_9848.method_61330((int)(183.59999F + 28.0F * var5), ThemePalette.field0567);
      int var8 = class_9848.method_61330((int)(61.199997F + 24.0F * var5), ThemePalette.field0567);
      this.field1208.method0729(var6);
      this.field0882.method0729(var7);
      this.field0838.method0729(var8);
      String var9 = this.method0366().method1911() != null ? this.method0366().method1911().method1935() : null;
      FontSize var10 = var9 != null ? field0981 : field1446;
      String var11 = var9 != null ? var9 : "e";
      float var12 = var9 != null ? this.method0002() + 1.5F : this.method0002() + 1.0F;
      float var13 = var9 != null ? this.method0530() - 0.5F : this.method0530();
      GuiRenderHelper.method1491(var1.method_51448(), var10, var11, var13, var12, this.field1208);
      float var14 = this.method0530() + var10.method0998(var11) + 2.0F;
      GuiRenderHelper.method1491(var1.method_51448(), field0624, this.method0366().method2067(), var14, this.method0002() + 1.0F, this.field0882);
      if (ThemePalette.field0439.get()) {
         String var15 = this.method0828(field0055);
         GuiRenderHelper.method1491(var1.method_51448(), field0055, var15, this.method0530(), this.method0002() + 8.0F, this.field0838);
      }

      this.method1413(var1, var2, var3);
   }

   private String method0828(FontSize var1) {
      return TextTruncator.method0831(var1, this.method0366().method1791(), this.method2047() - 16.0F);
   }

   private void method1413(class_332 var1, int var2, int var3) {
      String var4 = "Open";
      float var5 = 3.5F;
      float var6 = 1.0F;
      float var7 = field0188.method0998(var4);
      float var8 = field0188.method0208(var4);
      float var9 = var7 + var5 * 2.0F;
      float var10 = var8 + var6 * 2.0F;
      float var11 = this.method0530() + this.method2047() - var9;
      float var12 = this.method0002() + 1.0F;
      float var13 = var10 / 2.0F;
      boolean var14 = MathHelper.method0689(var11, var12, var9, var10, var2, var3) || this.field1312;
      this.field0385 = class_3532.method_15363(this.field0385 + (var14 ? 0.12F : -0.12F), 0.0F, 1.0F);
      float var15 = 1.0F + this.field0385 * 0.05F;
      float var16 = var11 + var9 / 2.0F;
      float var17 = var12 + var10 / 2.0F;
      float var18 = this.method0495().get();
      int var19 = class_9848.method_61330(25, ThemePalette.field0567);
      int var20 = class_9848.method_61330(200, ThemeColorManager.method1604());
      Color var21 = new Color(class_9848.method_61319(var18, var19, var20), true);
      int var22 = class_9848.method_61330(127, ThemePalette.field0567);
      Color var23 = new Color(class_9848.method_61319(var18, var22, -1), true);
      var1.method_51448().method_22903();
      var1.method_51448().method_46416(var16, var17, 0.0F);
      var1.method_51448().method_22905(var15, var15, 1.0F);
      var1.method_51448().method_46416(-var16, -var17, 0.0F);
      GuiRenderHelper.method1462(var1.method_51448(), var11, var12, var9, var10, var13, 6.0F, var21);
      GuiRenderHelper.method1463(var1.method_51448(), var11, var12, var9, var10, var13, var21);
      GuiRenderHelper.method1491(var1.method_51448(), field0188, var4, var11 + var5, var12 + var6, var23);
      var1.method_51448().method_22909();
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      boolean var6 = MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3);
      if ((var5 == 0 || var5 == 1) && var6) {
         if (this.field1388) {
            PopupManager.method0416().method1620().remove(this.field1343);
            this.field1388 = false;
            this.field1312 = false;
            if (field1098 == this) {
               field1098 = null;
            }

            this.method2266();
         } else if (this.field1312) {
            this.method1915();
         } else {
            this.method2266();
         }

         return true;
      } else {
         return this.field1312 && var6 ? true : super.method0627(var1, var3, var5);
      }
   }

   private void method2266() {
      method1890();
      float var1 = this.method0530() + this.method2047() - 8.0F;
      float var2 = this.method0002() + 4.0F;
      float var3 = this.method0645(var1);
      float var4 = var2 - this.field1343.method1762() / 2.0F + 8.0F;
      float var5 = ScreenLayoutHelper.method1762();
      if (var4 + this.field1343.method1762() > var5) {
         var4 = var5 - this.field1343.method1762() - 10.0F;
      }

      if (var4 < 0.0F) {
         var4 = 10.0F;
      }

      this.field0921.method2100(var1, var2);
      this.field0921.method1570(true);
      this.field1343.method2228();
      this.field1343.method0670(var3, var4);
      this.field1343.method0498();
      this.field1312 = true;
      this.field1388 = false;
      field1098 = this;
   }

   private void method1915() {
      this.field0921.method1570(false);
      this.field1388 = true;
   }

   public static void method1973() {
      if (field1098 != null && field1098.field1312) {
         field1098.method1915();
      }
   }

   public static void method0430() {
      if (field1098 != null) {
         field1098.field0921.method1973();
      }
   }

   public static void method2228() {
      if (field1098 != null) {
         PopupManager var0 = PopupManager.method0416();
         if (var0 != null) {
            var0.method1620().remove(field1098.field1343);
         }

         field1098.field0921.method1570(false);
         field1098.field1312 = false;
         field1098.field1388 = false;
         field1098 = null;
      }
   }

   private static void method1890() {
      if (field1098 != null && field1098.field1312) {
         field1098.method1915();
      }

      ColorSettingWidget.method1973();
      BlockListSettingWidget.method1973();
   }

   private float method0645(float var1) {
      float var2 = this.field1343.method2047();
      float var3 = ScreenLayoutHelper.method2047();
      return var1 + var2 + 10.0F > var3 ? var1 - var2 - 10.0F : var1 + 10.0F;
   }
}
