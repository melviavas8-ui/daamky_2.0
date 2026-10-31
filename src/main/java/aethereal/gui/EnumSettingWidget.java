package aethereal;

import java.util.function.Supplier;
import net.minecraft.class_332;
import net.minecraft.class_9848;

public class EnumSettingWidget extends SettingWidget {
   private static FontSize field0624;
   private static FontSize field0055;
   private static FontSize field1446;
   private static FontSize field0981;
   private static boolean field0219 = false;
   private final int field0459 = ThemePalette.field1137;
   private final int field1615 = ThemePalette.field0567;
   private final int field1539 = ThemePalette.field0567;
   private final MutableColor field1717 = new MutableColor();
   private final MutableColor field1147 = new MutableColor();
   private final MutableColor field1100 = new MutableColor();

   private static void method1973() {
      if (!field0219) {
         field0624 = Fonts.field0075.method0654(6.0F);
         field0055 = Fonts.field0075.method0654(5.0F);
         field1446 = Fonts.field0774.method0654(4.0F);
         field0981 = Fonts.field0075.method0654(6.0F);
         field0219 = true;
      }
   }

   public EnumSettingWidget(EnumSetting<?> var1, Supplier<Float> var2) {
      super(var1, var2);
      Object[] var3 = var1.method0492().getClass().getEnumConstants();

      for (Object var7 : var3) {
         this.method1620().add(new EnumOptionWidget(var1, this.method0495(), (Enum<?>)var7));
      }
   }

   @Override
   public float method1762() {
      method1973();
      String var1 = TextTruncator.method0831(field0055, this.method0366().method1791(), this.method2047() - 16.0F);
      float var2 = 11.0F;
      float var3 = 0.0F;

      for (GuiElement var5 : this.method1620()) {
         EnumOptionWidget var6 = (EnumOptionWidget)var5;
         if (var3 + var6.method2047() > this.method2047()) {
            var3 = 0.0F;
            var2 += var6.method1762();
         }

         var3 += var6.method2047();
      }

      return 10.0F + (ThemePalette.field0439.get() ? field0055.method0208(var1) : 2.0F) + var2;
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method1973();
      int var5 = class_9848.method_61319(this.method0495().get(), class_9848.method_61330(122, this.field0459), ThemeColorManager.method1604());
      int var6 = class_9848.method_61330((int)(183.59999F + 28.0F * this.method0495().get()), this.field1615);
      int var7 = class_9848.method_61330((int)(61.199997F + 24.0F * this.method0495().get()), this.field1539);
      this.field1717.method0729(var5);
      this.field1147.method0729(var6);
      this.field1100.method0729(var7);
      String var8 = TextTruncator.method0831(field0055, this.method0366().method1791(), this.method2047() - 16.0F);
      GuiRenderHelper.method1491(var1.method_51448(), field1446, "g", this.method0530(), this.method0002() + 2.0F, this.field1717);
      GuiRenderHelper.method1491(
         var1.method_51448(),
         field0624,
         this.method0366().method2067(),
         this.method0530() + field1446.method0998("g") + 2.0F,
         this.method0002() + 1.0F,
         this.field1147
      );
      if (ThemePalette.field0439.get()) {
         GuiRenderHelper.method1491(var1.method_51448(), field0055, var8, this.method0530(), this.method0002() + 8.0F, this.field1100);
      }

      float var9 = 0.0F;
      float var10 = 0.0F;

      for (GuiElement var12 : this.method1620()) {
         EnumOptionWidget var13 = (EnumOptionWidget)var12;
         if (var9 + var13.method2047() > this.method2047()) {
            var9 = 0.0F;
            var10 += var13.method1762();
         }

         var13.method0670(this.method0530() + var9, this.method0002() + 10.0F + (ThemePalette.field0439.get() ? field0055.method0208(var8) : 2.0F) + var10);
         var9 += var13.method2047();
      }

      String var14 = ((DisplayNamed)this.method0366().method0492()).method0557();
      GuiRenderHelper.method1491(
         var1.method_51448(), field0981, var14, this.method0530() + this.method2047() - field0981.method0998(var14), this.method0002() + 1.0F, this.field1717
      );
      super.method1414(var1, var2, var3, var4);
   }
}
