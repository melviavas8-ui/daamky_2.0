package aethereal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_9848;

public class NumberSettingWidget extends SettingWidget {
   private static FontSize field1446;
   private static FontSize field0981;
   private static FontSize field0188;
   private static FontSize field0468;
   private static boolean field1653 = false;
   float field0566;
   boolean field0169 = false;
   private final Animation field1561 = new Animation(220L, 1.0, false, EasingCurve.field1011);
   private final Animation field1721 = new Animation(180L, 1.0, false, EasingCurve.field1011);
   private final MutableColor field1147 = new MutableColor();
   private final MutableColor field1100 = new MutableColor();
   private final MutableColor field1208 = new MutableColor();
   private final MutableColor field0882 = new MutableColor();
   private final MutableColor field0838 = new MutableColor();
   private static final List<NumberSettingWidget> field0928 = new ArrayList<>();

   private static void method0430() {
      if (!field1653) {
         field1446 = Fonts.field0075.method0654(6.0F);
         field0981 = Fonts.field0075.method0654(5.0F);
         field0188 = Fonts.field0774.method0654(4.0F);
         field0468 = Fonts.field0075.method0654(6.0F);
         field1653 = true;
      }
   }

   public NumberSettingWidget(Setting var1, Supplier<Float> var2) {
      super(var1, var2);
   }

   @Override
   public float method1762() {
      method0430();
      String var1 = TextTruncator.method0831(field0981, this.method0366().method1791(), this.method2047() - 52.0F - 4.0F);
      return 8.0F + (ThemePalette.field0439.get() ? field0981.method0208(var1) : 2.0F);
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method0430();
      FloatSetting var5 = (FloatSetting)this.method0366();
      this.field0566 = class_3532.method_16439(0.18F, this.field0566, var5.method0492());
      boolean var6 = MathHelper.method0689(
         this.method0530() + this.method2047() / 2.0F - 4.0F, this.method0002() + 4.0F, this.method2047() / 2.0F + 8.0F, 10.0F, var2, var3
      );
      if (this.field1721.method0376() != (var6 || this.field0169)) {
         this.field1721.method1570(var6 || this.field0169);
      }

      if (this.field1561.method0376() != this.field0169) {
         this.field1561.method1570(this.field0169);
      }

      float var7 = this.field1561.method0002();
      float var8 = this.field1721.method0002();
      float var9 = Math.max(var7, var8 * 0.5F);
      int var10 = class_9848.method_61319(this.method0495().get(), class_9848.method_61330(122, ThemePalette.field1137), ThemeColorManager.method1604());
      int var11 = class_9848.method_61330((int)(183.59999F + 28.0F * this.method0495().get()), ThemePalette.field0567);
      int var12 = class_9848.method_61330((int)(61.199997F + 24.0F * this.method0495().get()), ThemePalette.field0567);
      int var13 = class_9848.method_61330((int)(2.55F * (2.0F + 2.0F * this.method0495().get() + 4.0F * var9)), ThemePalette.field0567);
      int var14 = class_9848.method_61319(
         this.method0495().get(), class_9848.method_61330((int)(2.55F * (24.0F + 24.0F * var9)), ThemePalette.field0567), ThemeColorManager.method1604()
      );
      float var15 = this.method2047() / 2.0F * ((this.field0566 - var5.method1878()) / (var5.method1928() - var5.method1878()));
      this.field1147.method0729(var10);
      int var16 = Math.max(1, (int)Math.ceil(-Math.log10(var5.method1697())));
      String var17 = String.format("%." + var16 + "f", this.field0566);
      String var18 = TextTruncator.method0831(field0981, this.method0366().method1791(), this.method2047() / 2.0F - 4.0F);
      this.field1100.method0729(var11);
      this.field1208.method0729(var12);
      this.field0882.method0729(var13);
      this.field0838.method0729(var14);
      GuiRenderHelper.method1491(var1.method_51448(), field0188, "i", this.method0530(), this.method0002() + 2.0F, this.field1147);
      GuiRenderHelper.method1491(
         var1.method_51448(),
         field1446,
         this.method0366().method2067(),
         this.method0530() + field0188.method0998("i") + 2.0F,
         this.method0002() + 1.0F,
         this.field1100
      );
      if (ThemePalette.field0439.get()) {
         GuiRenderHelper.method1491(var1.method_51448(), field0981, var18, this.method0530(), this.method0002() + 8.0F, this.field1208);
      }

      float var19 = 3.0F + 0.8F * var9;
      float var20 = this.method0002() + 8.0F - (var19 - 3.0F) / 2.0F;
      GuiRenderHelper.method0326(
         var1.method_51448(), this.method0530() + this.method2047() / 2.0F, var20, this.method2047() / 2.0F, var19, 0.5F + 0.15F * var9, this.field0882
      );
      GuiRenderHelper.method0326(var1.method_51448(), this.method0530() + this.method2047() / 2.0F, var20, var15, var19, 0.5F + 0.15F * var9, this.field0838);
      float var21 = 4.0F + 1.6F * var7 + 0.6F * var8;
      float var22 = (this.field0566 - var5.method1878()) / (var5.method1928() - var5.method1878());
      float var23 = 0.5F - var22;
      float var24 = this.method0530() + this.method2047() / 2.0F + var15 - var21 / 2.0F + var23;
      float var25 = this.method0002() + 8.0F + var19 / 2.0F - var21 / 2.0F - 0.4F * var7 - 0.2F * var8 - 0.1F;
      GuiRenderHelper.method0326(var1.method_51448(), var24, var25, var21, var21, var21 / 4.0F + 0.5F * var7, new Color(Color.WHITE.getRGB(), true));
      float var26 = 1.0F + 0.08F * var7;
      float var27 = field0468.method0998(var17);
      float var28 = this.method0530() + this.method2047() - var27 - 1.0F;
      float var29 = this.method0002() - 1.0F;
      if (var26 > 1.001F) {
         float var30 = var28 + var27;
         float var31 = var29 + field0468.method0530() / 2.0F;
         var1.method_51448().method_22903();
         var1.method_51448().method_46416(var30, var31, 0.0F);
         var1.method_51448().method_22905(var26, var26, 1.0F);
         var1.method_51448().method_46416(-var30, -var31, 0.0F);
         GuiRenderHelper.method1491(var1.method_51448(), field0468, var17, var28, var29, this.field1147);
         var1.method_51448().method_22909();
      } else {
         GuiRenderHelper.method1491(var1.method_51448(), field0468, var17, var28, var29, this.field1147);
      }

      if (this.field0169) {
         this.method0611(var2);
      }
   }

   void method0611(double var1) {
      FloatSetting var3 = (FloatSetting)this.method0366();
      float var4 = this.method0530() + this.method2047() / 2.0F;
      float var5 = this.method0530() + this.method2047();
      float var6 = (float)class_3532.method_15350(var1, var4, var5);
      float var7 = var3.method1878() + (var6 - var4) / (var5 - var4) * (var3.method1928() - var3.method1878());
      var7 = Math.round(var7 / var3.method1697()) * var3.method1697();
      var7 = Math.max(var3.method1878(), Math.min(var3.method1928(), var7));
      var3.method0206(var7);
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      float var6 = this.method0530() + this.method2047() / 2.0F - 4.0F;
      float var7 = this.method0002() + 4.0F;
      float var8 = this.method2047() / 2.0F + 8.0F;
      float var9 = 10.0F;
      if (MathHelper.method0689(var6, var7, var8, var9, (float)var1, (float)var3) && var5 == 0) {
         this.field0169 = true;
         this.method2228();
         this.method0611(var1);
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean method0112(double var1, double var3, int var5) {
      if (this.field0169) {
         this.field0169 = false;
         return true;
      } else {
         return super.method0112(var1, var3, var5);
      }
   }

   public static void method1973() {
      for (int var0 = 0; var0 < field0928.size(); var0++) {
         field0928.get(var0).field0169 = false;
      }

      field0928.clear();
   }

   private void method2228() {
      if (!field0928.contains(this)) {
         field0928.add(this);
      }
   }
}
