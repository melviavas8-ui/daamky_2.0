package aethereal;

import java.util.function.Supplier;
import net.minecraft.class_332;
import net.minecraft.class_9848;

public class ConditionalToggleWidget extends SettingWidget {
   private static FontSize field0624;
   private static FontSize field0055;
   private static FontSize field1446;
   private static FontSize field0981;
   private static boolean field0219 = false;
   private final Animation field0477 = new Animation(180L, 1.0, false, EasingCurve.field1477);
   private final MutableColor field1629 = new MutableColor();
   private final MutableColor field1555 = new MutableColor();
   private final MutableColor field1717 = new MutableColor();
   private final MutableColor field1147 = new MutableColor();

   private static void method1973() {
      if (!field0219) {
         field0624 = Fonts.field0075.method0654(6.0F);
         field0055 = Fonts.field0075.method0654(5.0F);
         field1446 = Fonts.field0774.method0654(5.0F);
         field0981 = Fonts.field0774.method0654(5.0F);
         field0219 = true;
      }
   }

   public ConditionalToggleWidget(Setting var1, Supplier<Float> var2) {
      super(var1, var2);
   }

   @Override
   public float method1762() {
      method1973();
      String var1 = TextTruncator.method0831(field0055, this.method0366().method1791(), this.method2047() - 16.0F);
      return 8.0F + (ThemePalette.field0439.get() ? field0055.method0208(var1) : 2.0F);
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method1973();
      boolean var5 = MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), var2, var3);
      this.field0477.method1570(var5);
      int var6 = class_9848.method_61319(this.method0495().get(), class_9848.method_61330(122, ThemePalette.field1137), ThemeColorManager.method1604());
      int var7 = class_9848.method_61330((int)(183.59999F + 28.0F * this.method0495().get()), ThemePalette.field0567);
      int var8 = class_9848.method_61330((int)(61.199997F + 24.0F * this.method0495().get()), ThemePalette.field0567);
      int var9 = class_9848.method_61319(this.field0477.method0002(), class_9848.method_61330(122, ThemePalette.field1137), ThemeColorManager.method1604());
      String var10 = TextTruncator.method0831(field0055, this.method0366().method1791(), this.method2047() - 16.0F);
      this.field1629.method0729(var6);
      this.field1555.method0729(var7);
      this.field1717.method0729(var8);
      this.field1147.method0729(var9);
      GuiRenderHelper.method1491(var1.method_51448(), field1446, "n", this.method0530(), this.method0002() + 0.5F, this.field1629);
      GuiRenderHelper.method1491(
         var1.method_51448(),
         field0624,
         this.method0366().method2067(),
         this.method0530() + field1446.method0998("n") + 2.0F,
         this.method0002(),
         this.field1555
      );
      if (ThemePalette.field0439.get()) {
         GuiRenderHelper.method1491(var1.method_51448(), field0055, var10, this.method0530(), this.method0002() + 8.0F, this.field1717);
      }

      String var11 = "k";
      float var12 = field0981.method0998(var11);
      GuiRenderHelper.method1491(
         var1.method_51448(), field0981, var11, this.method0530() + this.method2047() - var12, this.method0002() + 0.5F, this.field1147
      );
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      if (var5 != 0) {
         return false;
      } else if (MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3)) {
         ((ConditionalBooleanSetting)this.method0366()).method1890();
         return true;
      } else {
         return super.method0627(var1, var3, var5);
      }
   }
}
