package aethereal;

import java.util.Objects;
import java.util.function.Supplier;
import net.minecraft.class_332;
import net.minecraft.class_9848;

public final class NumberListSettingWidget extends SettingWidget {
   private static FontSize field0624;
   private static FontSize field0055;
   private static FontSize field1446;
   private static FontSize field0981;
   private static boolean field0219 = false;
   private static final int field0459 = 72;
   private static final int field1615 = 28;
   private static final int field1539 = 48;
   private static final int field1705 = 24;
   private static NumberListSettingWidget field1145;
   private final MutableColor field1100 = new MutableColor();
   private final MutableColor field1208 = new MutableColor();
   private final MutableColor field0882 = new MutableColor();
   private final NumberListEditor field0837;
   private final PopupPanel field0923;
   private boolean field1350 = false;
   private boolean field1312 = false;

   private static void method2228() {
      if (!field0219) {
         field0624 = Fonts.field0075.method0654(6.0F);
         field0055 = Fonts.field0075.method0654(5.0F);
         field1446 = Fonts.field0774.method0654(4.0F);
         field0981 = Fonts.field0075.method0654(7.0F);
         field0219 = true;
      }
   }

   public NumberListSettingWidget(NumberListSetting var1, Supplier<Float> var2) {
      super(Objects.requireNonNull(var1), Objects.requireNonNull(var2));
      this.field0837 = new NumberListEditor(var1, var2);
      this.field0923 = new PopupPanel(this.field0837, true);
   }

   @Override
   public float method1762() {
      method2228();
      String var1 = this.method0828(field0055);
      float var2 = ThemePalette.field0439.get() ? field0055.method0208(var1) : 2.0F;
      return 8.0F + var2;
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method2228();
      if (this.field1312 && this.field0837.method0431()) {
         PopupManager.method0416().method1620().remove(this.field0923);
         this.field1312 = false;
         this.field1350 = false;
         if (field1145 == this) {
            field1145 = null;
         }
      }

      float var5 = this.method0495().get();
      int var6 = class_9848.method_61319(var5, class_9848.method_61330(122, ThemePalette.field1137), ThemeColorManager.method1604());
      int var7 = class_9848.method_61330((int)(183.59999F + 28.0F * var5), ThemePalette.field0567);
      int var8 = class_9848.method_61330((int)(61.199997F + 24.0F * var5), ThemePalette.field0567);
      this.field1100.method0729(var6);
      this.field1208.method0729(var7);
      this.field0882.method0729(var8);
      GuiRenderHelper.method1491(var1.method_51448(), field1446, "i", this.method0530(), this.method0002() + 2.0F, this.field1100);
      float var9 = this.method0530() + field1446.method0998("i") + 2.0F;
      GuiRenderHelper.method1491(var1.method_51448(), field0624, this.method0366().method2067(), var9, this.method0002() + 1.0F, this.field1208);
      if (ThemePalette.field0439.get()) {
         String var10 = this.method0828(field0055);
         GuiRenderHelper.method1491(var1.method_51448(), field0055, var10, this.method0530(), this.method0002() + 8.0F, this.field0882);
      }

      NumberListSetting var12 = (NumberListSetting)this.method0366();
      String var11 = String.valueOf(var12.method1929());
      GuiRenderHelper.method1491(
         var1.method_51448(), field0981, var11, this.method0530() + this.method2047() - field0981.method0998(var11), this.method0002(), this.field1100
      );
   }

   private String method0828(FontSize var1) {
      return TextTruncator.method0831(var1, this.method0366().method1791(), this.method2047() - 16.0F);
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      boolean var6 = MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3);
      if ((var5 == 0 || var5 == 1) && var6) {
         if (this.field1350) {
            this.method2266();
         } else {
            this.method2194();
         }

         return true;
      } else {
         return this.field1350 && var6 ? true : super.method0627(var1, var3, var5);
      }
   }

   private void method2194() {
      method1915();
      float var1 = this.method0530() + this.method2047() - 8.0F;
      float var2 = this.method0002() + 4.0F;
      float var3 = this.method0645(var1);
      float var4 = var2 - this.field0923.method1762() / 2.0F + 8.0F;
      float var5 = ScreenLayoutHelper.method1762();
      if (var4 + this.field0923.method1762() > var5) {
         var4 = var5 - this.field0923.method1762() - 10.0F;
      }

      if (var4 < 0.0F) {
         var4 = 10.0F;
      }

      this.field0837.method2100(var1, var2);
      this.field0837.method1570(true);
      this.field0923.method0670(var3, var4);
      this.field0923.method0498();
      this.field1350 = true;
      field1145 = this;
   }

   private void method2266() {
      this.field0837.method1570(false);
      this.field1312 = true;
   }

   public static void method1973() {
      if (field1145 != null && field1145.field1350) {
         field1145.method2266();
      }
   }

   public static void method0430() {
      if (field1145 != null) {
         PopupManager var0 = PopupManager.method0416();
         if (var0 != null) {
            var0.method1620().remove(field1145.field0923);
         }

         field1145.field0837.method1570(false);
         field1145.field1350 = false;
         field1145.field1312 = false;
         field1145 = null;
      }
   }

   private static void method1915() {
      if (field1145 != null && field1145.field1350) {
         field1145.method2266();
      }
   }

   private float method0645(float var1) {
      float var2 = this.field0923.method2047();
      float var3 = ScreenLayoutHelper.method2047();
      return var1 + var2 + 10.0F > var3 ? var1 - var2 - 10.0F : var1 + 10.0F;
   }
}
