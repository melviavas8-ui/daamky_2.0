package aethereal;

import java.util.function.Supplier;
import lombok.Generated;
import net.minecraft.class_332;
import net.minecraft.class_9848;

public class EnumOptionWidget extends SettingWidget {
   private static FontSize field0624;
   private static FontSize field0055;
   private static boolean field1527 = false;
   private final Enum<?> field1028;
   private final Animation field0198 = new Animation(250L, 1.0, true, EasingCurve.field0672);
   private final Animation field0477 = new Animation(280L, 1.0, false, EasingCurve.field0203);
   private boolean field1653 = false;
   private final MutableColor field1555 = new MutableColor();
   private final MutableColor field1717 = new MutableColor();
   private final MutableColor field1147 = new MutableColor();

   private static void method1937() {
      if (!field1527) {
         field0624 = Fonts.field0075.method0654(6.0F);
         field0055 = Fonts.field0774.method0654(5.0F);
         field1527 = true;
      }
   }

   public EnumOptionWidget(EnumSetting<?> var1, Supplier<Float> var2, Enum<?> var3) {
      super(var1, var2);
      this.field1028 = var3;
      this.field0198.method1570(var1.method0492() == var3);
      this.field0198.method1973();
      this.field0477.method1973();
   }

   @Override
   public float method2047() {
      method1937();
      String var1 = ((DisplayNamed)this.field1028).method0557();
      return 8.0F + field0624.method1016(var1, 0.05F) + (this.method0366().method0492() == this.field1028 ? 8 : 0);
   }

   @Override
   public float method1762() {
      return 11.0F;
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method1937();
      EnumSetting var5 = (EnumSetting<?>)this.method0366();
      boolean var6 = var5.method0492() == this.field1028;
      if (!this.field1653) {
         if (this.field0198.method0376() != var6) {
            this.field0198.method1570(var6);
         }

         this.field0198.method1973();
         this.field1653 = true;
      } else if (this.field0198.method0376() != var6) {
         this.field0198.method1570(var6);
      }

      float var7 = var6 ? this.field0198.method0002() : 0.0F;
      int var8 = class_9848.method_61319(
         var7,
         class_9848.method_61330((int)(5.1F + 10.0F * var7), ThemePalette.field0567),
         class_9848.method_61319(
            this.method0495().get(), class_9848.method_61330((int)(5.1F + 10.0F * var7), ThemePalette.field0567), ThemeColorManager.method1604()
         )
      );
      int var9 = class_9848.method_61330((int)(2.55F * (24.0F + 24.0F * var7 + 52.0F * this.method0495().get())), ThemePalette.field0567);
      int var10 = class_9848.method_61330((int)(2.55F * (24.0F * var7 + 76.0F * this.method0495().get() * var7)), ThemePalette.field0567);
      this.field1555.method0729(var8);
      this.field1717.method0729(var10);
      this.field1147.method0729(var9);
      float var11 = this.field0477.method0002();
      boolean var12 = var11 > 0.001F;
      if (var12) {
         float var13 = 1.0F + 0.07F * var11;
         float var14 = this.method0530() + this.method2047() / 2.0F;
         float var15 = this.method0002() + this.method1762() / 2.0F;
         var1.method_51448().method_22903();
         var1.method_51448().method_46416(var14, var15, 0.0F);
         var1.method_51448().method_22905(var13, var13, 1.0F);
         var1.method_51448().method_46416(-var14, -var15, 0.0F);
      }

      GuiRenderHelper.method1463(var1.method_51448(), this.method0530(), this.method0002(), this.method2047(), this.method1762(), 2.0F, this.field1555);
      GuiRenderHelper.method1488(var1.method_51448(), field0055, "q", this.method0530() + 4.0F, this.method0002() + 2.5F, 0.1F, this.field1717);
      String var16 = ((DisplayNamed)this.field1028).method0557();
      GuiRenderHelper.method1488(
         var1.method_51448(),
         field0624,
         var16,
         this.method0530() + this.method2047() - 4.0F - field0624.method1016(var16, 0.05F),
         this.method0002() + 2.0F,
         0.05F,
         this.field1147
      );
      if (var12) {
         var1.method_51448().method_22909();
      }

      super.method1414(var1, var2, var3, var4);
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      EnumSetting var6 = (EnumSetting<?>)this.method0366();
      if (MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3) && var5 == 0) {
         if (var6.method0492() != this.field1028) {
            var6.method0442(((DisplayNamed)this.field1028).method0557());
            this.field0198.method1634();
            this.field0477.method1634();
         }

         return true;
      } else {
         return super.method0627(var1, var3, var5);
      }
   }

   @Generated
   public Enum<?> method1960() {
      return this.field1028;
   }

   @Generated
   public Animation method0418() {
      return this.field0198;
   }

   @Generated
   public Animation method2218() {
      return this.field0477;
   }

   @Generated
   public boolean method2195() {
      return this.field1653;
   }

   @Generated
   public MutableColor method2256() {
      return this.field1555;
   }

   @Generated
   public MutableColor method1907() {
      return this.field1717;
   }

   @Generated
   public MutableColor method1883() {
      return this.field1147;
   }
}
