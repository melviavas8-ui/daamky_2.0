package aethereal;

import java.util.function.Supplier;
import net.minecraft.class_332;
import net.minecraft.class_9848;

public class DependentToggleWidget extends SettingWidget {
   private static FontSize field0624;
   private static FontSize field0055;
   private static boolean field1527 = false;
   private final BooleanSetting field0970;
   private final Animation field0198 = new Animation(250L, 1.0, false, EasingCurve.field1477);
   private boolean field0497 = false;
   private final MutableColor field1629 = new MutableColor();
   private final MutableColor field1555 = new MutableColor();
   private final MutableColor field1717 = new MutableColor();
   private final MutableColor field1147 = new MutableColor();

   private static void method1973() {
      if (!field1527) {
         field0624 = Fonts.field0075.method0654(6.0F);
         field0055 = Fonts.field0774.method0654(4.0F);
         field1527 = true;
      }
   }

   public DependentToggleWidget(Setting var1, Supplier<Float> var2, BooleanSetting var3) {
      super(var1, var2);
      this.field0970 = var3;
      this.field0198.method1570(var3.method0492());
      this.field0198.method1973();
   }

   @Override
   public float method1762() {
      return 7.0F;
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method1973();
      boolean var5 = this.field0970.method0492();
      if (!this.field0497) {
         if (this.field0198.method0376() != var5) {
            this.field0198.method1570(var5);
         }

         this.field0198.method1973();
         this.field0497 = true;
      } else if (this.field0198.method0376() != var5) {
         this.field0198.method1570(var5);
      }

      int var6 = class_9848.method_61319(
         this.field0198.method0002(),
         class_9848.method_61330((int)(2.55F * (24.0F + 24.0F * this.field0198.method0002())), ThemePalette.field0567),
         class_9848.method_61319(
            this.method0495().get(),
            class_9848.method_61330((int)(2.55F * (24.0F + 24.0F * this.field0198.method0002())), ThemePalette.field0567),
            ThemeColorManager.method1604()
         )
      );
      int var7 = class_9848.method_61330((int)(2.55F * (2.0F + 2.0F * this.method0495().get())), ThemePalette.field0567);
      int var8 = class_9848.method_61319(
         this.field0198.method0002(),
         class_9848.method_61330((int)(122.399994F * this.field0198.method0002()), ThemePalette.field1137),
         class_9848.method_61330((int)(2.55F * (48.0F * this.field0198.method0002() + 52.0F * this.method0495().get())), ThemePalette.field1137)
      );
      int var9 = class_9848.method_61319(
         this.field0198.method0002(),
         class_9848.method_61330((int)(5.1F + 10.0F * this.field0198.method0002()), ThemePalette.field0567),
         class_9848.method_61319(
            this.method0495().get(),
            class_9848.method_61330((int)(5.1F + 10.0F * this.field0198.method0002()), ThemePalette.field0567),
            ThemeColorManager.method1604()
         )
      );
      this.field1629.method0729(var6);
      this.field1555.method0729(var9);
      this.field1717.method0729(var7);
      this.field1147.method0729(var8);
      GuiRenderHelper.method1491(var1.method_51448(), field0624, this.field0970.method2067(), this.method0530(), this.method0002(), this.field1629);
      GuiRenderHelper.method1463(var1.method_51448(), this.method0530() + this.method2047() - 7.5F, this.method0002() - 0.5F, 7.5F, 7.5F, 1.2F, this.field1555);
      GuiRenderHelper.method1460(
         var1.method_51448(), this.method0530() + this.method2047() - 7.5F, this.method0002() - 0.5F, 7.5F, 7.5F, 1.2F, -0.8F, 1.0F, 1.0F, this.field1717
      );
      GuiRenderHelper.method1491(var1.method_51448(), field0055, "u", this.method0530() + this.method2047() - 6.1F, this.method0002() + 1.0F, this.field1147);
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      if (MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3)) {
         this.field0970.method0206(!this.field0970.method0492());
         this.field0198.method1570(this.field0970.method0492());
         this.field0198.method1634();
         return true;
      } else {
         return false;
      }
   }
}
