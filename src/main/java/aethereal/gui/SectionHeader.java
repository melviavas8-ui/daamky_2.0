package aethereal;

import java.awt.Color;
import java.util.function.Supplier;
import net.minecraft.class_332;

public class SectionHeader extends SettingWidget {
   private static FontSize field0624;
   private static boolean field0169 = false;
   private final String field1504;
   private final MutableColor field0992 = new MutableColor();

   private static void method1973() {
      if (!field0169) {
         field0624 = Fonts.field0075.method0654(6.0F);
         field0169 = true;
      }
   }

   public SectionHeader(String var1, Supplier<Float> var2) {
      super(new BooleanSetting("customization.header." + var1.toLowerCase().replace(' ', '_'), true), var2);
      this.field1504 = var1;
   }

   @Override
   public float method1762() {
      method1973();
      return field0624.method0530() + 6.0F;
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method1973();
      Color var5 = ThemeColorManager.method1908().method2063();
      this.field0992.method0729(new Color(var5.getRed(), var5.getGreen(), var5.getBlue(), 200).getRGB());
      GuiRenderHelper.method1491(var1.method_51448(), field0624, this.field1504, this.method0530(), this.method0002(), this.field0992);
      float var6 = this.method0002() + field0624.method0530() + 2.0F;
      GuiRenderHelper.method0326(var1.method_51448(), this.method0530(), var6, this.method2047(), 0.5F, 0.0F, ThemePalette.field1564);
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      return false;
   }
}
