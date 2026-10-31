package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import lombok.Generated;
import net.minecraft.class_10142;
import net.minecraft.class_332;

public class PopupPanel extends GuiElement {
   private final GuiElement field0606;
   private boolean field0169;
   private float field1410 = 0.0F;
   private boolean field1049 = false;
   private final Animation field0198 = new Animation(180L, 1.0, false, EasingCurve.field1011);

   public PopupPanel(GuiElement var1) {
      this.field0606 = var1;
      this.field0169 = false;
   }

   public PopupPanel(GuiElement var1, boolean var2) {
      this.field0606 = var1;
      this.field0169 = var2;
   }

   public void method1570(boolean var1) {
      this.field0169 = var1;
   }

   public void method0498() {
      if (!PopupManager.method0416().method1620().contains(this)) {
         PopupManager.method0416().method1620().add(this);
      }
   }

   public void method2228() {
      this.field1410 = 0.0F;
   }

   public void method2194() {
      this.field1049 = true;
      this.field0198.method1570(true);
      this.method0498();
   }

   public void method1973() {
      this.field1049 = false;
      this.field0198.method1570(false);
   }

   public boolean method2267() {
      return !this.method0431() ? !this.field1049 && this.field0198.method0346(false) : !this.field1049 && this.field1410 <= 0.01F;
   }

   @Override
   public float method1762() {
      return this.field0606.method1762();
   }

   @Override
   public float method2047() {
      return this.field0606.method2047() + 8.0F;
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      float var5 = 1.0F;
      float var6 = this.method0530();
      float var7 = this.method0002();
      if (this.field0606 instanceof ColorPicker var27) {
         float var40 = var27.method1974() ? 1.0F : 0.0F;
         this.field1410 = this.field1410 + (var40 - this.field1410) * 0.22F;
         if (Math.abs(var40 - this.field1410) < 0.004F) {
            this.field1410 = var40;
         }

         if (var40 == 0.0F && this.field1410 <= 0.005F) {
            this.field1410 = 0.0F;
         } else {
            var5 = this.field1410;
            var1.method_51448().method_22903();
            float var45 = 0.94F + 0.06F * this.field1410;
            float var49 = var6 + this.method2047() / 2.0F;
            float var53 = var7 + this.method1762();
            var1.method_51448().method_46416(var49, var53, 0.0F);
            var1.method_51448().method_22905(var45, var45, 1.0F);
            var1.method_51448().method_46416(-var49, -var53, 0.0F);
            this.field0606.method0670(var6 + 4.0F, var7 + 4.0F);
            Color var57 = method0964(new Color(-1), this.field1410);
            Color var61 = method0964(ThemePalette.field0930.get(), this.field1410);
            Color var63 = method0964(ThemePalette.field0884, this.field1410);
            GuiRenderHelper.method1462(var1.method_51448(), var6, var7, this.method2047(), this.method1762(), 6.0F, ThemePalette.field0367.get(), var57);
            GuiRenderHelper.method1463(var1.method_51448(), var6, var7, this.method2047(), this.method1762(), 6.0F, var61);
            GuiRenderHelper.method1461(var1.method_51448(), var6, var7, this.method2047(), this.method1762(), 6.0F, 0.5F, 0.5F, var63);
            var27.method0665(this.field1410);
            this.field0606.method1414(var1, var2, var3, var4);
            var27.method0665(1.0F);
            var1.method_51448().method_22909();
         }
      } else if (this.field0606 instanceof BlockListEditor var28) {
         float var39 = var28.method1974() ? 1.0F : 0.0F;
         this.field1410 = this.field1410 + (var39 - this.field1410) * 0.22F;
         if (Math.abs(var39 - this.field1410) < 0.004F) {
            this.field1410 = var39;
         }

         if (var39 == 0.0F && this.field1410 <= 0.005F) {
            this.field1410 = 0.0F;
         } else {
            var5 = this.field1410;
            var1.method_51448().method_22903();
            float var44 = 0.94F + 0.06F * this.field1410;
            float var48 = var6 + this.method2047() / 2.0F;
            float var52 = var7 + this.method1762();
            var1.method_51448().method_46416(var48, var52, 0.0F);
            var1.method_51448().method_22905(var44, var44, 1.0F);
            var1.method_51448().method_46416(-var48, -var52, 0.0F);
            this.field0606.method0670(var6 + 4.0F, var7 + 4.0F);
            Color var56 = method0964(new Color(-1), this.field1410);
            Color var60 = method0964(ThemePalette.field0930.get(), this.field1410);
            Color var62 = method0964(ThemePalette.field0884, this.field1410);
            GuiRenderHelper.method1462(var1.method_51448(), var6, var7, this.method2047(), this.method1762(), 6.0F, ThemePalette.field0367.get(), var56);
            GuiRenderHelper.method1463(var1.method_51448(), var6, var7, this.method2047(), this.method1762(), 6.0F, var60);
            GuiRenderHelper.method1461(var1.method_51448(), var6, var7, this.method2047(), this.method1762(), 6.0F, 0.5F, 0.5F, var62);
            var28.method0665(this.field1410);
            this.field0606.method1414(var1, var2, var3, var4);
            var28.method0665(1.0F);
            var1.method_51448().method_22909();
         }
      } else if (this.field0606 instanceof KeyBindListEditor var30) {
         float var38 = var30.method0376() ? 1.0F : 0.0F;
         this.field1410 = this.field1410 + (var38 - this.field1410) * 0.22F;
         if (Math.abs(var38 - this.field1410) < 0.004F) {
            this.field1410 = var38;
         }

         if (var38 == 0.0F && this.field1410 <= 0.005F) {
            this.field1410 = 0.0F;
         } else {
            var5 = this.field1410;
            var1.method_51448().method_22903();
            float var43 = 0.94F + 0.06F * this.field1410;
            float var47 = var6 + this.method2047() / 2.0F;
            float var51 = var7 + this.method1762();
            var1.method_51448().method_46416(var47, var51, 0.0F);
            var1.method_51448().method_22905(var43, var43, 1.0F);
            var1.method_51448().method_46416(-var47, -var51, 0.0F);
            this.field0606.method0670(var6 + 4.0F, var7 + 4.0F);
            Color var55 = method0964(new Color(-1), this.field1410);
            Color var59 = method0964(ThemePalette.field0930.get(), this.field1410);
            Color var18 = method0964(ThemePalette.field0884, this.field1410);
            GuiRenderHelper.method1462(var1.method_51448(), var6, var7, this.method2047(), this.method1762(), 6.0F, ThemePalette.field0367.get(), var55);
            GuiRenderHelper.method1463(var1.method_51448(), var6, var7, this.method2047(), this.method1762(), 6.0F, var59);
            GuiRenderHelper.method1461(var1.method_51448(), var6, var7, this.method2047(), this.method1762(), 6.0F, 0.5F, 0.5F, var18);
            var30.method0665(this.field1410);
            this.field0606.method1414(var1, var2, var3, var4);
            var30.method0665(1.0F);
            var1.method_51448().method_22909();
         }
      } else if (this.field0606 instanceof NumberListEditor var8) {
         var5 = var8.method1946();
         if (!(var5 <= 0.2F)) {
            float var35 = var8.method0355();
            float var41 = var8.method0483();
            float var46 = this.method0530() + this.method2047() / 2.0F;
            float var50 = this.method0002() + this.method1762() / 2.0F;
            var6 = var35 + (var46 - var35) * var5 - this.method2047() / 2.0F;
            var7 = var41 + (var50 - var41) * var5 - this.method1762() / 2.0F;
            var1.method_51448().method_22903();
            float var9 = var6 + this.method2047() / 2.0F;
            float var10 = var7 + this.method1762() / 2.0F;
            var1.method_51448().method_46416(var9, var10, 0.0F);
            float var11 = var5;
            var35 = var5;
            var41 = 0.3F;
            var11 = Math.max(var11, var41);
            var35 = Math.max(var35, var41);
            var1.method_51448().method_22905(var11, var35, 1.0F);
            var1.method_51448().method_46416(-var9, -var10, 0.0F);
            this.field0606.method0670(var6 + 4.0F, var7 + 4.0F);
            GuiRenderHelper.method1462(
               var1.method_51448(), var6, var7, this.method2047(), this.method1762() + 3.0F, 6.0F, ThemePalette.field0367.get(), new Color(-1)
            );
            GuiRenderHelper.method1463(var1.method_51448(), var6, var7, this.method2047(), this.method1762() + 3.0F, 6.0F, ThemePalette.field0930.get());
            GuiRenderHelper.method1461(
               var1.method_51448(), var6, var7, this.method2047(), this.method1762() + 3.0F, 6.0F, 0.5F, 0.5F, ThemePalette.field0884
            );
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableCull();
            RenderSystem.setShader(class_10142.field_53876);
            RenderSystem.enableCull();
            RenderSystem.disableBlend();
            this.field0606.method1414(var1, var2, var3, var4);
            var1.method_51448().method_22909();
         }
      } else {
         var5 = this.field0198.method0002();
         if (!(var5 <= 0.01F)) {
            var7 = this.method0002() + 3.0F * (1.0F - var5);
            var1.method_51448().method_22903();
            float var34 = Math.max(0.3F, var5);
            float var13 = Math.max(0.3F, var5 * var5);
            float var14 = var6 + this.method2047() / 2.0F;
            float var15 = var7 + this.method1762() / 2.0F;
            var1.method_51448().method_46416(var14, var15, 0.0F);
            var1.method_51448().method_22905(var34, var13, 1.0F);
            var1.method_51448().method_46416(-var14, -var15, 0.0F);
            this.field0606.method0670(var6 + 4.0F, var7 + 4.0F);
            GuiRenderHelper.method1462(
               var1.method_51448(), var6, var7, this.method2047(), this.method1762(), 6.0F, ThemePalette.field0367.get(), method0964(new Color(-1), var5)
            );
            GuiRenderHelper.method1463(
               var1.method_51448(), var6, var7, this.method2047(), this.method1762(), 6.0F, method0964(ThemePalette.field0930.get(), var5)
            );
            GuiRenderHelper.method1461(
               var1.method_51448(), var6, var7, this.method2047(), this.method1762(), 6.0F, 0.5F, 0.5F, method0964(ThemePalette.field0884, var5)
            );
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableCull();
            RenderSystem.setShader(class_10142.field_53876);
            RenderSystem.enableCull();
            RenderSystem.disableBlend();
            if (this.field0606 instanceof ModuleTitle var16) {
               var16.method0665(var5);
            }

            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var5);
            this.field0606.method1414(var1, var2, var3, var4);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            if (this.field0606 instanceof ModuleTitle var54) {
               var54.method0665(1.0F);
            }

            var1.method_51448().method_22909();
         }
      }
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      boolean var6 = this.field0606.method0627(var1, var3, var5);
      return var6 ? true : MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3);
   }

   @Override
   public boolean method0112(double var1, double var3, int var5) {
      return this.field0606.method0112(var1, var3, var5);
   }

   @Override
   public boolean method0746(int var1, int var2, int var3) {
      return this.field0606.method0746(var1, var2, var3);
   }

   @Override
   public boolean method0607(char var1, int var2) {
      return this.field0606.method0607(var1, var2);
   }

   @Override
   public boolean method0623(double var1, double var3, double var5, double var7) {
      return this.field0606.method0623(var1, var3, var5, var7);
   }

   public boolean method1825(float var1, float var2) {
      return MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762() + 8.0F, var1, var2);
   }

   private static Color method0964(Color var0, float var1) {
      return var1 >= 0.99F ? var0 : new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), Math.max(0, Math.min(255, (int)(var0.getAlpha() * var1))));
   }

   private boolean method0431() {
      return this.field0606 instanceof ColorPicker
         || this.field0606 instanceof BlockListEditor
         || this.field0606 instanceof KeyBindListEditor
         || this.field0606 instanceof NumberListEditor;
   }

   @Generated
   public GuiElement method1905() {
      return this.field0606;
   }

   @Generated
   public boolean method1891() {
      return this.field0169;
   }

   @Generated
   public float method1928() {
      return this.field1410;
   }

   @Generated
   public boolean method1736() {
      return this.field1049;
   }

   @Generated
   public Animation method1685() {
      return this.field0198;
   }
}
