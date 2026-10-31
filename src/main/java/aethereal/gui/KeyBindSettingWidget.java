package aethereal;

import java.util.function.Supplier;
import net.minecraft.class_332;
import net.minecraft.class_9848;

public class KeyBindSettingWidget extends SettingWidget {
   private static FontSize field0981;
   private static FontSize field0188;
   private static FontSize field0468;
   private static FontSize field1625;
   private static FontSize field1552;
   private static boolean field1735 = false;
   boolean field0751 = false;
   Animation field0079 = new Animation(250L, 1.0, false, EasingCurve.field1477);
   Animation field1465 = new Animation(250L, 1.0, false, EasingCurve.field1477);
   private boolean field1161 = false;
   private final MutableColor field1100 = new MutableColor();
   private final MutableColor field1208 = new MutableColor();
   private final MutableColor field0882 = new MutableColor();
   private final MutableColor field0838 = new MutableColor();
   private final MutableColor field0924 = new MutableColor();
   private final MutableColor field1344 = new MutableColor();
   private final MutableColor field1303 = new MutableColor();
   private float field1369;
   private float field0385;

   private static void method1973() {
      if (!field1735) {
         field0981 = Fonts.field0075.method0654(6.0F);
         field0188 = Fonts.field0075.method0654(5.0F);
         field0468 = Fonts.field0774.method0654(5.0F);
         field1625 = Fonts.field0075.method0654(5.0F);
         field1552 = Fonts.field0075.method0654(4.0F);
         field1735 = true;
      }
   }

   public KeyBindSettingWidget(Setting var1, Supplier<Float> var2) {
      super(var1, var2);
   }

   @Override
   public float method1762() {
      method1973();
      String var1 = this.field0751 ? "None" : this.method0366().method0492().toString().replace("_", " ");
      float var2 = field1625.method0998("W");
      float var3 = 4.0F + Math.max(field1625.method0998(var1), var2);
      String var4 = TextTruncator.method0831(field0188, this.method0366().method1791(), this.method2047() - var3 - 4.0F);
      return 8.0F + (ThemePalette.field0439.get() ? field0188.method0208(var4) : 2.0F);
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method1973();
      KeyBind var5 = ((KeyBindSetting)this.method0366()).method0492();
      if (!this.field1161) {
         if (this.field0079.method0376() != this.field0751) {
            this.field0079.method1570(this.field0751);
         }

         this.field0079.method1973();
         if (this.field1465.method0376() != var5.method1635()) {
            this.field1465.method1570(var5.method1635());
         }

         this.field1465.method1973();
         this.field1161 = true;
      }

      int var6 = class_9848.method_61319(this.method0495().get(), class_9848.method_61330(122, ThemePalette.field1137), ThemeColorManager.method1604());
      int var7 = class_9848.method_61330((int)(183.59999F + 28.0F * this.method0495().get()), ThemePalette.field0567);
      int var8 = class_9848.method_61330((int)(61.199997F + 24.0F * this.method0495().get()), ThemePalette.field0567);
      String var9 = TextTruncator.method0831(field0188, this.method0366().method1791(), this.method2047() - 16.0F);
      String var10 = this.field0751 ? "None" : this.method0366().method0492().toString().replace("_", " ");
      KeyBind var11 = ((KeyBindSetting)this.method0366()).method0492();
      boolean var12 = var11.method2048() != -1;
      String var13 = var11.method1635() ? "Hold" : "Toggle";
      float var14 = field1625.method0998("W");
      float var15 = 4.0F + Math.max(field1625.method0998(var10), var14);
      this.field0385 = 6.0F + field1552.method1016(var13, 0.05F);
      this.field1369 = this.method0530() + this.method2047() - var15 - this.field0385 - 2.0F;
      this.field1100.method0729(var6);
      this.field1208.method0729(var7);
      this.field0882.method0729(var8);
      GuiRenderHelper.method1491(var1.method_51448(), field0468, "e", this.method0530(), this.method0002() + 1.0F, this.field1100);
      GuiRenderHelper.method1491(
         var1.method_51448(),
         field0981,
         this.method0366().method2067(),
         this.method0530() + field0468.method0998("G") + 2.0F,
         this.method0002(),
         this.field1208
      );
      if (ThemePalette.field0439.get()) {
         GuiRenderHelper.method1491(var1.method_51448(), field0188, var9, this.method0530(), this.method0002() + 8.0F, this.field0882);
      }

      this.field1465.method1570(var11.method1635());
      int var16 = class_9848.method_61330(30, ThemePalette.field0567);
      int var17 = var8;
      this.field0838.method0729(var16);
      this.field0924.method0729(var17);
      GuiRenderHelper.method0326(var1.method_51448(), this.field1369, this.method0002(), this.field0385, 8.0F, 2.0F, this.field0838);
      float var18 = this.field1369 + (this.field0385 - field1552.method1016(var13, 0.05F)) / 2.0F;
      GuiRenderHelper.method1488(
         var1.method_51448(), field1552, var13, var18, this.method0002() + (8.0F - field1552.method0530()) / 2.0F + 0.2F, 0.05F, this.field0924
      );
      int var19;
      int var20;
      if (var12) {
         int var21 = class_9848.method_61319(
            this.field0079.method0002(),
            class_9848.method_61330((int)(30.599998F + 12.0F * this.field0079.method0002()), ThemePalette.field0567),
            class_9848.method_61330(61, ThemePalette.field0567)
         );
         var19 = class_9848.method_61319(this.method0495().get(), var21, ThemeColorManager.method1604());
         var20 = class_9848.method_61319(this.method0495().get(), var8, -1);
      } else {
         var19 = class_9848.method_61319(
            this.field0079.method0002(),
            class_9848.method_61330((int)(30.599998F + 12.0F * this.field0079.method0002()), ThemePalette.field0567),
            class_9848.method_61330(61, ThemePalette.field0567)
         );
         var20 = var8;
      }

      float var24 = this.method0530() + this.method2047() - var15;
      float var22 = field1625.method0998(var10);
      float var23 = var24 + (var15 - var22) / 2.0F;
      this.field1344.method0729(var19);
      this.field1303.method0729(var20);
      GuiRenderHelper.method0326(var1.method_51448(), var24, this.method0002(), var15, 8.0F, 1.0F, this.field1344);
      GuiRenderHelper.method1491(
         var1.method_51448(), field1625, var10, var23, this.method0002() + (8.0F - field1625.method0530()) / 2.0F + 0.2F, this.field1303
      );
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      if (this.field0751) {
         KeyBind var7 = ((KeyBindSetting)this.method0366()).method0492();
         ((KeyBindSetting)this.method0366()).method0206(new KeyBind(var5, true, var7.method1635()));
         this.field0751 = false;
         this.field0079.method1570(false);
         return true;
      } else if (MathHelper.method0689(this.field1369, this.method0002(), this.field0385, 8.0F, (float)var1, (float)var3)) {
         KeyBind var6 = ((KeyBindSetting)this.method0366()).method0492();
         var6.method0345(!var6.method1635());
         return true;
      } else if (MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3)) {
         this.field0751 = !this.field0751;
         this.field0079.method1570(this.field0751);
         this.field0079.method1634();
         return true;
      } else {
         return super.method0627(var1, var3, var5);
      }
   }

   @Override
   public boolean method0746(int var1, int var2, int var3) {
      if (this.field0751) {
         KeyBind var4 = ((KeyBindSetting)this.method0366()).method0492();
         ((KeyBindSetting)this.method0366()).method0206(new KeyBind(var1 == 256 ? -1 : var1, false, var4.method1635()));
         this.field0751 = false;
         this.field0079.method1570(false);
         ClickGuiScreen var5 = ClickGuiScreen.method1904();
         if (var5 != null) {
            var5.method0578();
         }

         return true;
      } else {
         return super.method0746(var1, var2, var3);
      }
   }
}
