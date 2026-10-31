package aethereal;

import java.awt.Color;
import lombok.Generated;
import net.minecraft.class_332;
import net.minecraft.class_9848;

public class ModuleSearchBar extends GuiElement {
   private static FontSize field0624;
   private static FontSize field0055;
   private static FontSize field1446;
   private static boolean field1049 = false;
   private final SearchFieldState field0194;

   private static void method0430() {
      if (!field1049) {
         field0624 = Fonts.field0075.method0654(7.0F);
         field0055 = Fonts.field0774.method0654(6.0F);
         field1446 = Fonts.field0774.method0654(4.5F);
         field1049 = true;
      }
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method0430();
      String var5 = this.field0194.method1792().isEmpty()
         ? (this.field0194.method0579() ? " " : this.field0194.method1961())
         : this.field0194.method1792().toString();
      double var6 = (float)(0.5 + 0.5 * Math.sin(System.currentTimeMillis() / 150.0));
      Color var8 = ThemePalette.field0844.get();
      int var9 = var8.getRed() << 16 | var8.getGreen() << 8 | var8.getBlue();
      int var10 = class_9848.method_61330((int)(2.55F * (72.0F + 12.0F * this.field0194.method1612().method0002())), 0xFF000000 | var9);
      GuiRenderHelper.method1462(
         var1.method_51448(), this.method0530(), this.method0002(), this.method2047(), this.method1762(), 7.0F, ThemePalette.field0367.get(), new Color(-1)
      );
      GuiRenderHelper.method0326(var1.method_51448(), this.method0530(), this.method0002(), this.method2047(), this.method1762(), 7.0F, new Color(var10, true));
      GuiRenderHelper.method1461(
         var1.method_51448(), this.method0530(), this.method0002(), this.method2047(), this.method1762(), 7.0F, 0.5F, 0.5F, ThemePalette.field0884
      );
      boolean var11 = !this.field0194.method1792().isEmpty();
      boolean var12 = var11 || this.field0194.method0579();
      float var13 = var12 ? 15.0F : 0.0F;
      float var14 = this.method2047() - 8.0F - 4.0F - var13;
      String var15 = var5;
      if (field0624.method0998(var15) > var14) {
         while (var15.length() > 1 && field0624.method0998("..." + var15) > var14) {
            var15 = var15.substring(1);
         }

         var15 = "..." + var15;
      }

      GuiRenderHelper.method1404(var1, this.method0530() + 4.0F, this.method0002(), this.method2047() - 8.0F, this.method1762());
      if (this.field0194.method0579() && this.field0194.method0026() && var11) {
         Color var16 = ThemeColorManager.method1908().method2063();
         float var17 = field0624.method0998(var15);
         float var18 = field0624.method0530();
         float var19 = this.method0530() + 8.0F - 1.5F;
         float var20 = this.method0002() + 8.0F - 1.5F;
         float var21 = var17 + 3.0F;
         float var22 = var18 + 3.0F;
         Color var23 = new Color(var16.getRed(), var16.getGreen(), var16.getBlue(), 90);
         GuiRenderHelper.method0326(var1.method_51448(), var19, var20, var21, var22, 2.5F, var23);
      }

      GuiRenderHelper.method1488(var1.method_51448(), field0624, var15, this.method0530() + 8.0F, this.method0002() + 8.0F, 0.05F, new Color(-1));
      if (this.field0194.method0579() && !this.field0194.method0026()) {
         float var24 = this.method0530() + 8.0F + field0624.method0998(var15) + 1.0F;
         GuiRenderHelper.method0326(
            var1.method_51448(),
            var24,
            this.method0002() + 0.5F + (this.method1762() - this.method1762() / 3.0F) / 2.0F,
            1.5F,
            this.method1762() / 3.0F,
            0.25F,
            new Color(class_9848.method_61330((int)(255.0 * var6), -1), true)
         );
      }

      GuiRenderHelper.method1400(var1);
      if (var12) {
         boolean var25 = MathHelper.method0689(this.method0530() + this.method2047() - 15.0F, this.method0002() + 5.0F, 10.0F, 10.0F, var2, var3);
         int var26 = var25 ? 72 : 48;
         float var27 = this.method0530() + this.method2047() - 13.0F;
         float var28 = this.method0002() + (this.method1762() - field1446.method0530()) / 2.0F - 0.5F;
         GuiRenderHelper.method1491(
            var1.method_51448(), field1446, "t", var27, var28, new Color(class_9848.method_61330((int)(2.55F * var26), -5592406), true)
         );
      }
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      boolean var6 = !this.field0194.method1792().isEmpty() || this.field0194.method0579();
      if (var6 && MathHelper.method0689(this.method0530() + this.method2047() - 15.0F, this.method0002() + 5.0F, 10.0F, 10.0F, (float)var1, (float)var3)) {
         if (!this.field0194.method1792().isEmpty()) {
            this.field0194.method1792().setLength(0);
            this.field0194.method2078();
         } else {
            this.field0194.method1570(false);
         }

         return true;
      } else if (MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3)) {
         this.field0194.method1570(!this.field0194.method0579());
         this.field0194.method2078();
         if (this.field0194.method0579()) {
            BlockListSettingWidget.method0430();
            KeyBindListSettingWidget.method0430();
         }

         return true;
      } else {
         this.field0194.method2078();
         return false;
      }
   }

   @Override
   public boolean method0746(int var1, int var2, int var3) {
      return this.field0194.method0746(var1, var2, var3);
   }

   @Override
   public boolean method0607(char var1, int var2) {
      return this.field0194.method0607(var1, var2);
   }

   @Generated
   public SearchFieldState method1951() {
      return this.field0194;
   }

   @Generated
   public ModuleSearchBar(SearchFieldState var1) {
      this.field0194 = var1;
   }
}
