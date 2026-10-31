package aethereal;

import java.util.function.Supplier;
import net.minecraft.class_332;
import net.minecraft.class_9848;

public class BooleanSettingWidget extends SettingWidget {
   private static FontSize field0055;
   private static FontSize field1446;
   private static FontSize field0981;
   private static boolean field0219 = false;
   Animation field0651 = new Animation(250L, 1.0, false, EasingCurve.field1477);
   private boolean field0497 = false;
   private final MutableColor field1629 = new MutableColor();
   private final MutableColor field1555 = new MutableColor();
   private final MutableColor field1717 = new MutableColor();
   private final MutableColor field1147 = new MutableColor();
   private final MutableColor field1100 = new MutableColor();

   private static void method1973() {
      if (!field0219) {
         field0055 = Fonts.field0075.method0654(6.0F);
         field1446 = Fonts.field0075.method0654(5.0F);
         field0981 = Fonts.field0774.method0654(5.0F);
         field0219 = true;
      }
   }

   public BooleanSettingWidget(Setting var1, Supplier<Float> var2) {
      super(var1, var2);
      this.field0651.method1570(((BooleanSetting)var1).method0492());
      this.field0651.method1973();
   }

   @Override
   public float method1762() {
      method1973();
      String var1 = TextTruncator.method0831(field1446, this.method0366().method1791(), this.method2047() - 16.0F);
      return 8.0F + (ThemePalette.field0439.get() ? field1446.method0208(var1) : 2.0F);
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method1973();
      boolean var5 = ((BooleanSetting)this.method0366()).method0492();
      if (!this.field0497) {
         if (this.field0651.method0376() != var5) {
            this.field0651.method1570(var5);
         }

         this.field0651.method1973();
         this.field0497 = true;
      } else if (this.field0651.method0376() != var5) {
         this.field0651.method1570(var5);
      }

      int var6 = class_9848.method_61319(this.method0495().get(), class_9848.method_61330(122, ThemePalette.field1137), ThemeColorManager.method1604());
      int var7 = class_9848.method_61330((int)(183.59999F + 28.0F * this.method0495().get()), ThemePalette.field0567);
      int var8 = class_9848.method_61330((int)(61.199997F + 24.0F * this.method0495().get()), ThemePalette.field0567);
      String var9 = TextTruncator.method0831(field1446, this.method0366().method1791(), this.method2047() - 16.0F);
      this.field1629.method0729(var6);
      this.field1555.method0729(var7);
      this.field1717.method0729(var8);
      GuiRenderHelper.method1491(var1.method_51448(), field0981, "r", this.method0530(), this.method0002() + 0.5F, this.field1629);
      GuiRenderHelper.method1491(
         var1.method_51448(),
         field0055,
         this.method0366().method2067(),
         this.method0530() + field0981.method0998("r") + 2.0F,
         this.method0002(),
         this.field1555
      );
      if (ThemePalette.field0439.get()) {
         GuiRenderHelper.method1491(var1.method_51448(), field1446, var9, this.method0530(), this.method0002() + 8.0F, this.field1717);
      }

      int var10 = class_9848.method_61319(
         this.field0651.method0002(),
         class_9848.method_61330((int)(30.599998F + 12.0F * this.field0651.method0002()), ThemePalette.field0567),
         class_9848.method_61319(
            this.method0495().get(),
            class_9848.method_61330((int)(30.599998F + 12.0F * this.field0651.method0002()), ThemePalette.field0567),
            ThemeColorManager.method1604()
         )
      );
      int var11 = class_9848.method_61330(
         (int)(2.55F * (24.0F + 24.0F * this.field0651.method0002() + 52.0F * this.method0495().get())), ThemePalette.field0567
      );
      this.field1147.method0729(var10);
      this.field1100.method0729(var11);
      GuiRenderHelper.method0326(var1.method_51448(), this.method0530() + this.method2047() - 10.0F, this.method0002(), 10.0F, 7.0F, 2.5F, this.field1147);
      GuiRenderHelper.method0326(
         var1.method_51448(),
         this.method0530() + this.method2047() - 9.0F + 3.0F * this.field0651.method0002(),
         this.method0002() + 1.0F,
         5.0F,
         5.0F,
         1.5F,
         this.field1100
      );
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      if (MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3)) {
         BooleanSetting var6 = (BooleanSetting)this.method0366();
         var6.method0206(!var6.method0492());
         this.field0651.method1570(var6.method0492());
         this.field0651.method1634();
         return true;
      } else {
         return super.method0627(var1, var3, var5);
      }
   }
}
