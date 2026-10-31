package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import net.minecraft.class_332;
import net.minecraft.class_9848;

public class ThemeEditor extends PopupPanel {
   private static FontSize field0624;
   private static FontSize field0055;
   private static FontSize field1446;
   private static boolean field1049 = false;
   private static final float field0177 = 102.5F;
   private static final float field0458 = 17.0F;
   private static final float field1614 = 17.0F;
   private static final float field1538 = 4.0F;
   private static final float field1704 = 38.0F;
   private static final float field1136 = 5.0F;
   private static final float field1087 = 2.5F;
   private static final float field1196 = 7.0F;
   private static final float field0871 = 5.0F;
   private static final long field0828 = 200L;
   private static final float field0910 = 1.25F;
   private static final float field1331 = 1.0F;
   private static final float field1292 = 0.15F;
   private boolean field1388 = false;
   private boolean field0404 = false;
   private long field0353 = 0L;
   private float field0423;
   private float field0255;
   private final float[] field0242 = new float[ThemeColorManager.PalettePreset.values().length];
   private final Animation field0297 = new Animation(250L, 1.0, false, EasingCurve.field1477);
   private final MutableColor field0531 = new MutableColor();
   private final MutableColor field0508 = new MutableColor();
   private final MutableColor field0553 = new MutableColor();
   private final MutableColor field1677 = new MutableColor();
   private final MutableColor field1662 = new MutableColor();

   private static void method1754() {
      if (!field1049) {
         field0624 = Fonts.field0075.method0654(5.5F);
         field0055 = Fonts.field0075.method0654(4.5F);
         field1446 = Fonts.field0774.method0654(5.0F);
         field1049 = true;
      }
   }

   public ThemeEditor() {
      super(new GuiElement() {
         @Override
         public float method2047() {
            return 102.5F;
         }

         @Override
         public float method1762() {
            return 38.0F;
         }
      }, true);

      for (int var1 = 0; var1 < this.field0242.length; var1++) {
         this.field0242[var1] = 1.0F;
      }

      if (ThemeColorManager.method1908().method1938()) {
         this.field0297.method1570(true);
         this.field0297.method1973();
      }
   }

   @Override
   public float method2047() {
      return 102.5F;
   }

   @Override
   public float method1762() {
      return 38.0F;
   }

   public void method2100(float var1, float var2) {
      this.field0423 = var1;
      this.field0255 = var2;
      this.method0670(var1 - 51.25F, var2 - 38.0F - 8.0F);
      this.method1570(true);
      this.field0404 = true;
      this.field1388 = true;
      this.field0353 = System.currentTimeMillis();
      if (!PopupManager.method0416().method1620().contains(this)) {
         PopupManager.method0416().method1620().add(this);
      }
   }

   @Override
   public void method1973() {
      if (this.field1388 && this.field0404) {
         this.field0404 = false;
         this.field0353 = System.currentTimeMillis();
      }
   }

   public void method0430() {
      this.field1388 = false;
      this.field0404 = false;
      PopupManager.method0416().method1620().remove(this);
   }

   public boolean method0376() {
      return this.field1388 && this.field0404;
   }

   @Override
   public boolean method1825(float var1, float var2) {
      return this.field1388 && !this.field0404 && !this.method2016()
         ? true
         : this.field1388 && this.field0404 && MathHelper.method0689(this.method0530(), this.method0002(), 102.5F, 38.0F, var1, var2);
   }

   private float method2018() {
      long var1 = System.currentTimeMillis() - this.field0353;
      float var3 = Math.min(1.0F, (float)var1 / 200.0F);
      var3 = (float)EasingCurve.field0330.method0608(var3);
      return this.field0404 ? var3 : 1.0F - var3;
   }

   private boolean method2016() {
      return System.currentTimeMillis() - this.field0353 >= 200L;
   }

   private void method2043() {
      ThemeColorManager.PalettePreset[] var1 = ThemeColorManager.PalettePreset.values();
      ThemeColorManager.PalettePreset var2 = ThemeColorManager.method1908().method1884();

      for (int var3 = 0; var3 < var1.length; var3++) {
         float var4 = var1[var3] == var2 ? 1.25F : 1.0F;
         this.field0242[var3] = this.field0242[var3] + (var4 - this.field0242[var3]) * 0.15F;
      }
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method1754();
      if (this.field1388) {
         float var5 = this.method2018();
         if (!this.field0404 && this.method2016()) {
            this.field1388 = false;
            PopupManager.method0416().method1620().remove(this);
         } else if (!(var5 <= 0.01F)) {
            this.method2043();
            if (this.field0297.method0376() != ThemeColorManager.method1908().method1938()) {
               this.field0297.method1570(ThemeColorManager.method1908().method1938());
            }

            float var6 = this.method0530();
            float var7 = this.method0002() + (1.0F - var5) * 8.0F;
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var5);
            GuiRenderHelper.method1462(var1.method_51448(), var6, var7, 102.5F, 38.0F, 3.0F, 24.0F, ThemePalette.field0134);
            GuiRenderHelper.method1463(var1.method_51448(), var6, var7, 102.5F, 38.0F, 4.0F, ThemePalette.field0930.get());
            GuiRenderHelper.method1461(var1.method_51448(), var6, var7, 102.5F, 38.0F, 4.0F, 0.5F, 0.5F, ThemePalette.field0884);
            ThemeColorManager.PalettePreset[] var8 = ThemeColorManager.PalettePreset.values();
            float var9 = var6 + 5.0F;
            float var10 = var7 + 8.5F;

            for (int var11 = 0; var11 < var8.length; var11++) {
               ThemeColorManager.PalettePreset var12 = var8[var11];
               if (var12 != ThemeColorManager.PalettePreset.field1556) {
                  float var13 = var9 + var11 * 9.5F;
                  float var14 = var10 - 3.5F;
                  boolean var15 = ThemeColorManager.method1908().method1884() == var12;
                  boolean var16 = this.field0404 && MathHelper.method0689(var13, var14, 7.0F, 7.0F, var2, var3);
                  this.method1408(var1, var13, var14, this.field0242[var11], var12, var15, var16);
               }
            }

            float var17 = var7 + 17.0F + 2.0F;
            GuiRenderHelper.method1463(var1.method_51448(), var6, var17 - 1.0F, 102.5F, 1.0F, 0.0F, ThemePalette.field1641);
            float var18 = var7 + 17.0F + 4.0F;
            this.method1411(var1, var6, var18, var2, var3);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         }
      }
   }

   private void method1411(class_332 var1, float var2, float var3, int var4, int var5) {
      float var6 = var2 + 5.0F;
      float var7 = var3 + 2.0F;
      double var8 = this.field0297.method0002();
      int var10 = class_9848.method_61319((float)var8, class_9848.method_61330(122, ThemePalette.field0567), ThemeColorManager.method1604());
      this.field0531.method0729(var10);
      GuiRenderHelper.method1491(var1.method_51448(), field1446, "r", var6, var7 + 0.5F, this.field0531);
      float var11 = field1446.method0998("r") + 2.0F;
      int var12 = class_9848.method_61330(183, ThemePalette.field0567);
      this.field0508.method0729(var12);
      GuiRenderHelper.method1491(var1.method_51448(), field0624, "Theme Sync", var6 + var11, var7, this.field0508);
      int var13 = class_9848.method_61330(91, ThemePalette.field0567);
      this.field0553.method0729(var13);
      GuiRenderHelper.method1491(var1.method_51448(), field0055, "Sync colors across all modules", var6, var7 + 6.0F, this.field0553);
      float var14 = 10.0F;
      float var15 = 7.0F;
      float var16 = var2 + 102.5F - 5.0F - var14;
      float var17 = var3 + (17.0F - var15) / 2.0F;
      int var18 = class_9848.method_61319((float)var8, class_9848.method_61330(30, ThemePalette.field0567), ThemeColorManager.method1604());
      int var19 = class_9848.method_61330(
         (int)(2.5500004F * (24.0 + 24.0 * var8 + 52 * (ThemeColorManager.method1908().method1938() ? 1 : 0))), ThemePalette.field0567
      );
      this.field1677.method0729(var18);
      this.field1662.method0729(var19);
      GuiRenderHelper.method0326(var1.method_51448(), var16, var17, var14, var15, 2.5F, this.field1677);
      GuiRenderHelper.method0326(var1.method_51448(), var16 + 1.0F + 3.0F * (float)var8, var17 + 1.0F, 5.0F, 5.0F, 1.5F, this.field1662);
   }

   private void method1408(class_332 var1, float var2, float var3, float var4, ThemeColorManager.PalettePreset var5, boolean var6, boolean var7) {
      Color var8 = var6 ? var5.method1790() : var5.method0015();
      Color var9 = var6 ? var5.method0553() : var5.method2063();
      if (var7 && !var6) {
         var9 = var5.method0723(183);
      }

      float var10 = 7.0F * var4;
      float var11 = 5.0F * var4;
      float var12 = (7.0F - var10) / 2.0F;
      float var13 = (7.0F - var10) / 2.0F;
      GuiRenderHelper.method1463(var1.method_51448(), var2 + var12, var3 + var13, var10, var10, var10 / 2.0F - 1.0F, var8);
      float var14 = (var10 - var11) / 2.0F;
      GuiRenderHelper.method1463(var1.method_51448(), var2 + var12 + var14, var3 + var13 + var14, var11, var11, var11 / 2.0F - 1.0F, var9);
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      if (this.field1388 && this.field0404) {
         if (!MathHelper.method0689(this.method0530(), this.method0002(), 102.5F, 38.0F, (float)var1, (float)var3)) {
            return false;
         }

         float var6 = this.method0002();
         float var7 = var6 + 17.0F + 4.0F;
         if (MathHelper.method0689(this.method0530(), var7, 102.5F, 17.0F, (float)var1, (float)var3)) {
            boolean var14 = !ThemeColorManager.method1908().method1938();
            ThemeColorManager.method1908().method1570(var14);
            this.field0297.method1570(var14);
            this.field0297.method1634();
            DaamkyClient.method2004().method2216().method1634();
            return true;
         }

         ThemeColorManager.PalettePreset[] var8 = ThemeColorManager.PalettePreset.values();
         float var9 = this.method0530() + 5.0F;
         float var10 = var6 + 8.5F;

         for (int var11 = 0; var11 < var8.length; var11++) {
            if (var8[var11] != ThemeColorManager.PalettePreset.field1556) {
               float var12 = var9 + var11 * 9.5F;
               float var13 = var10 - 3.5F;
               if (MathHelper.method0689(var12, var13, 7.0F, 7.0F, (float)var1, (float)var3)) {
                  ThemeColorManager.method1908().method0850(var8[var11]);
                  DaamkyClient.method2004().method2216().method1634();
                  return true;
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }
}
