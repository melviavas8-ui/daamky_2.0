package aethereal;

import java.awt.Color;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_7833;
import net.minecraft.class_9848;

public class MultiSelectSettingWidget extends SettingWidget {
   private static FontSize field0055;
   private static FontSize field1446;
   private static FontSize field0981;
   private static FontSize field0188;
   private static FontSize field0468;
   private static boolean field1653 = false;
   private static final int field1539 = 3;
   private static final float field1704 = 2.0F;
   Animation field0651 = new Animation(250L, 1.0, false, EasingCurve.field1477);
   private float field1136 = 0.0F;
   private float field1087 = 0.0F;
   private final MutableColor field1208 = new MutableColor();
   private final MutableColor field0882 = new MutableColor();
   private final MutableColor field0838 = new MutableColor();
   private final MutableColor field0924 = new MutableColor();
   private final MutableColor field1344 = new MutableColor();
   private final MutableColor field1303 = new MutableColor();
   private final MutableColor field1379 = new MutableColor(284620799);
   private final MutableColor field0396 = new MutableColor(821491711);

   private static void method1973() {
      if (!field1653) {
         field0055 = Fonts.field0075.method0654(6.0F);
         field1446 = Fonts.field0075.method0654(5.0F);
         field0981 = Fonts.field0774.method0654(4.0F);
         field0188 = Fonts.field0774.method0654(5.0F);
         field0468 = Fonts.field0075.method0654(7.0F);
         field1653 = true;
      }
   }

   public MultiSelectSettingWidget(MultiSelectSetting var1, Supplier<Float> var2) {
      super(var1, var2);
      this.field0651.method1973();

      for (BooleanSetting var4 : var1.method0492()) {
         this.method1620().add(new DependentToggleWidget(var1, var2, var4));
      }
   }

   private int method1071(List<BooleanSetting> var1) {
      int var2 = 0;

      for (BooleanSetting var4 : var1) {
         if (var4.method0492()) {
            var2++;
         }
      }

      return var2;
   }

   private String method0224(List<BooleanSetting> var1) {
      StringBuilder var2 = new StringBuilder();
      boolean var3 = true;

      for (BooleanSetting var5 : var1) {
         if (var5.method0492()) {
            if (!var3) {
               var2.append(", ");
            }

            var2.append(var5.method2067());
            var3 = false;
         }
      }

      return var2.length() == 0 ? "Empty" : var2.toString();
   }

   @Override
   public float method1762() {
      method1973();
      String var1 = TextTruncator.method0831(field1446, this.method0366().method1791(), this.method2047() - 16.0F);
      int var2 = this.method1620().size();
      int var3 = Math.min(var2, 3);
      float var4 = this.method1620().isEmpty() ? 0.0F : this.method1620().get(0).method1762() + 4.0F;
      float var5 = 6.0F + var3 * var4;
      return 10.0F + (ThemePalette.field0439.get() ? field1446.method0208(var1) : 2.0F) + 17.0F + var5 * this.field0651.method0002();
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method1973();
      float var5 = this.field0651.method0376() ? 0.08F : 0.35F;
      this.field1087 = class_3532.method_16439(var5, this.field1087, this.field1136);
      if (!this.field0651.method0376() && Math.abs(this.field1087 - this.field1136) < 0.5F) {
         this.field1087 = this.field1136;
      }

      MultiSelectSetting var6 = (MultiSelectSetting)this.method0366();
      int var7 = this.method1071(var6.method0492());
      int var8 = var6.method0492().size();
      int var9 = class_9848.method_61319(this.method0495().get(), class_9848.method_61330(122, ThemePalette.field1137), ThemeColorManager.method1604());
      int var10 = class_9848.method_61330((int)(183.59999F + 28.0F * this.method0495().get()), ThemePalette.field0567);
      int var11 = class_9848.method_61330((int)(61.199997F + 24.0F * this.method0495().get()), ThemePalette.field0567);
      int var12 = class_9848.method_61319(
         this.field0651.method0002(),
         class_9848.method_61330((int)(61.199997F + 24.0F * this.field0651.method0002() + 48.0F * this.method0495().get()), ThemePalette.field0567),
         class_9848.method_61319(
            this.method0495().get(),
            class_9848.method_61330((int)(61.199997F + 24.0F * this.field0651.method0002() + 48.0F * this.method0495().get()), ThemePalette.field0567),
            ThemeColorManager.method1604()
         )
      );
      String var13 = var7 + " / " + var8;
      this.field1208.method0729(var9);
      this.field0882.method0729(var10);
      this.field0838.method0729(var11);
      String var14 = TextTruncator.method0831(field1446, this.method0366().method1791(), this.method2047() - 16.0F);
      GuiRenderHelper.method1491(var1.method_51448(), field0981, "h", this.method0530(), this.method0002() + 2.0F, this.field1208);
      GuiRenderHelper.method1491(
         var1.method_51448(),
         field0055,
         this.method0366().method2067(),
         this.method0530() + field0981.method0998("h") + 2.0F,
         this.method0002() + 1.0F,
         this.field0882
      );
      if (ThemePalette.field0439.get()) {
         GuiRenderHelper.method1491(var1.method_51448(), field1446, var14, this.method0530(), this.method0002() + 8.0F, this.field0838);
      }

      GuiRenderHelper.method1491(
         var1.method_51448(), field0468, var13, this.method0530() + this.method2047() - field0468.method0998(var13), this.method0002(), this.field1208
      );
      float var15 = this.method0002() + 10.0F + (ThemePalette.field0439.get() ? field1446.method0208(var14) : 2.0F);
      int var16 = this.method1620().size();
      int var17 = Math.min(var16, 3);
      float var18 = this.method1620().isEmpty() ? 0.0F : this.method1620().get(0).method1762() + 4.0F;
      float var19 = var16 * var18;
      float var20 = var17 * var18;
      float var21 = this.method0530() - 1.0F;
      float var22 = this.method2047() + 2.0F;
      float var23 = -this.field1087;

      for (GuiElement var25 : this.method1620()) {
         var25.method0670(var21 + 6.0F, var15 + 17.0F + 5.0F + var23).method0126(var22 - 6.0F - 13.0F - (var16 > 3 ? 4.0F : 0.0F), var25.method1762());
         var23 += var25.method1762() + 4.0F;
      }

      float var46 = 17.0F + (var20 + 6.0F) * this.field0651.method0002();
      this.field1344.method0729(class_9848.method_61330((int)(5.1F + 2.0F * this.method0495().get()), ThemePalette.field0567));
      GuiRenderHelper.method1463(var1.method_51448(), var21, var15, var22, var46, 4.0F, this.field1344);
      GuiRenderHelper.method1461(var1.method_51448(), var21, var15, var22, var46, 4.0F, 0.5F, 0.5F, this.field1344);
      GuiRenderHelper.method1463(
         var1.method_51448(),
         var21,
         var15 + 17.0F,
         var22,
         1.0F,
         0.0F,
         ColorHelper.method0966(new Color(ThemePalette.field0567), (int)(10.0F * this.field0651.method0002()))
      );
      String var47 = this.method0224(var6.method0492());
      int var26 = class_9848.method_61330((int)(2.55F * (72.0F + 28.0F * this.method0495().get())), ThemePalette.field0567);
      float var27 = var21 + 6.0F;
      float var28 = var15 + 5.0F;
      float var29 = var22 - 15.0F - 6.0F;
      float var30 = var29 - 20.0F;
      float var31 = var27;

      for (int var32 = 0; var32 < var47.length(); var32++) {
         char var33 = var47.charAt(var32);
         String var34 = String.valueOf(var33);
         float var35 = field0055.method0998(var34);
         float var36 = var31 + var35 - var27;
         if (var36 > var29) {
            break;
         }

         int var37;
         if (var36 > var30) {
            float var38 = (var36 - var30) / (var29 - var30);
            int var39 = var26 >> 24 & 0xFF;
            var37 = (int)(var39 * (1.0F - var38));
         } else {
            var37 = var26 >> 24 & 0xFF;
         }

         int var54 = var37 << 24 | var26 & 16777215;
         this.field1303.method0729(var54);
         GuiRenderHelper.method1491(var1.method_51448(), field0055, var34, var31, var28, this.field1303);
         var31 += var35;
      }

      float var48 = var21 + var22 - 8.0F - field0188.method0998("G") + 0.5F;
      class_4587 var49 = var1.method_51448();
      float var50 = var15 + 5.0F + 1.2F;
      float var51 = var48 + field0188.method0998("G") / 2.0F;
      float var52 = var50 + field0188.method0530() / 2.0F;
      var49.method_22903();
      var49.method_46416(var51, var52, 0.0F);
      var49.method_22907(class_7833.field_40718.rotationDegrees(180.0F * this.field0651.method0002()));
      var49.method_46416(-var51, -var52, 0.0F);
      this.field0924.method0729(var12);
      GuiRenderHelper.method1488(var1.method_51448(), field0188, "G", var48, var50, 0.1F, this.field0924);
      var49.method_22909();
      float var53 = var15 + 17.0F + 5.0F;
      float var55 = var20;
      GuiRenderHelper.method1404(var1, var21 + 6.0F, var53 - 3.0F, var22 - 12.0F, var55 * this.field0651.method0002() + 2.5F);
      super.method1414(var1, var2, var3, var4);
      GuiRenderHelper.method1400(var1);
      if (var16 > 3 && this.field0651.method0002() > 0.1F) {
         float var56 = 3.0F;
         float var40 = var21 + var22 - 2.0F - 6.0F;
         float var41 = var53 + var56 - 3.0F;
         float var42 = var55 * this.field0651.method0002() - var56 * 2.0F + 3.0F;
         float var43 = var19 - var20;
         float var44 = var20 / var19 * var42;
         float var45 = var41 + this.field1087 / var43 * (var42 - var44);
         GuiRenderHelper.method0326(var1.method_51448(), var40, var41, 2.0F, var42, 1.0F, this.field1379);
         GuiRenderHelper.method0326(var1.method_51448(), var40, var45, 2.0F, var44, 1.0F, this.field0396);
      }
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      if (!MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3)) {
         return false;
      }

      String var6 = TextTruncator.method0831(field1446, this.method0366().method1791(), this.method2047() - 16.0F);
      float var7 = 10.0F + (ThemePalette.field0439.get() ? field1446.method0208(var6) : 2.0F) + 17.0F;
      if (!MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), var7, (float)var1, (float)var3) || var5 != 0 && var5 != 1) {
         if (this.field0651.method0376()) {
            super.method0627(var1, var3, var5);
            return true;
         } else {
            return false;
         }
      } else {
         this.field0651.method1570(!this.field0651.method0376());
         if (!this.field0651.method0376()) {
            this.field1136 = 0.0F;
         }

         return true;
      }
   }

   @Override
   public boolean method0623(double var1, double var3, double var5, double var7) {
      if (this.field0651.method0376()
         && MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3)) {
         int var9 = this.method1620().size();
         if (var9 > 3) {
            float var10 = this.method1620().isEmpty() ? 0.0F : this.method1620().get(0).method1762() + 4.0F;
            float var11 = Math.min(var9, 3) * var10;
            float var12 = var9 * var10;
            float var13 = var12 - var11;
            this.field1136 = Math.max(0.0F, Math.min(var13, this.field1136 - (float)var7 * 5.0F));
         }

         return true;
      } else {
         return super.method0623(var1, var3, var5, var7);
      }
   }
}
