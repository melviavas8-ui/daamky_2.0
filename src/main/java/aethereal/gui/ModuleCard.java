package aethereal;

import java.awt.Color;
import lombok.Generated;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import net.minecraft.class_7833;
import net.minecraft.class_9848;

public class ModuleCard extends GuiElement {
   private static FontSize field0624;
   private static FontSize field0055;
   private static FontSize field1446;
   private static FontSize field0981;
   private static boolean field0219 = false;
   private final Module field0480;
   private final Animation field1635 = new Animation(250L, 1.0, false, EasingCurve.field1477);
   private final Animation field1561 = new Animation(180L, 1.0, false, EasingCurve.field1011);
   private final Animation field1721 = new Animation(280L, 1.0, false, EasingCurve.field1011);
   private final PopupPanel field1146 = new PopupPanel(new ModuleTitle(this::method1954));
   private boolean field1109 = false;
   private boolean field1218 = false;
   private boolean field0890 = false;
   private final MutableColor field0838 = new MutableColor();
   private final MutableColor field0924 = new MutableColor();
   private final MutableColor field1344 = new MutableColor();
   private boolean field1312 = false;
   private float field1369 = Float.MIN_VALUE;
   private float field0385 = Float.MAX_VALUE;
   private long field0353 = 0L;
   private boolean field0442 = false;
   private static final long field0257 = 100L;
   private SettingList field0235;

   private static void method0457() {
      if (!field0219) {
         field0624 = Fonts.field0075.method0654(7.0F);
         field0055 = Fonts.field0075.method0654(5.0F);
         field1446 = Fonts.field0774.method0654(5.0F);
         field0981 = Fonts.field0774.method0654(5.0F);
         field0219 = true;
      }
   }

   public void method2100(float var1, float var2) {
      this.field1369 = var1;
      this.field0385 = var2;
   }

   public ModuleCard(Module var1) {
      this.field0480 = var1;
      this.field1635.method1570(var1.method2195());
      this.field1635.method1973();
      this.field1561.method1973();
      this.field1721.method1973();
   }

   private SettingList method0475() {
      if (this.field0235 == null) {
         this.field0235 = new SettingList(SettingWidgetFactory.method0841(this));
      }

      return this.field0235;
   }

   private boolean method0406() {
      return !this.field0480.method1914().isEmpty();
   }

   @Override
   public float method1762() {
      float var1 = this.field1721.method0002();
      if (var1 < 0.01F) {
         return 20.0F;
      }

      float var2 = this.method0475().method1762() + (this.method0475().method1974() ? 0.0F : 12.0F);
      return 20.0F + var2 * var1;
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method0457();
      if (!this.field0890) {
         if (this.field1635.method0376() != this.field0480.method2195()) {
            this.field1635.method1570(this.field0480.method2195());
         }

         this.field1635.method1973();
         this.field0890 = true;
      } else if (this.field1635.method0376() != this.field0480.method2195()) {
         this.field1635.method1570(this.field0480.method2195());
      }

      boolean var5 = MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), 20.0F, var2, var3);
      this.field1312 = var5;
      Color var6 = ColorHelper.method0966(new Color(ThemePalette.field0567), (int)(2.55F * (2.0F + 2.0F * this.field1635.method0002())));
      GuiRenderHelper.method1463(var1.method_51448(), this.method0530(), this.method0002(), this.method2047(), this.method1762(), 4.0F, var6);
      GuiRenderHelper.method1461(var1.method_51448(), this.method0530(), this.method0002(), this.method2047(), this.method1762(), 4.0F, 0.5F, 0.5F, var6);
      float var7 = 4.0F + field0055.method1016(this.field0480.method2259().toString(), 0.05F);
      boolean var8 = this.field0480.method2259() != null && this.field0480.method2259().method2048() != -1;
      if (var8 || this.field1218) {
         int var9 = class_9848.method_61319(this.field1635.method0002(), class_9848.method_61330(30, ThemePalette.field0567), ThemeColorManager.method1604());
         if (this.field1218) {
            var9 = class_9848.method_61319(this.field1635.method0002(), class_9848.method_61330(61, ThemePalette.field0567), ThemeColorManager.method1604());
         }

         this.field0838.method0729(var9);
         GuiRenderHelper.method1463(var1.method_51448(), this.method0530() + 8.0F, this.method0002() + 6.0F, var7, 8.0F, 1.0F, this.field0838);
         GuiRenderHelper.method1488(
            var1.method_51448(),
            field0055,
            this.field0480.method2259().toString(),
            this.method0530() + 10.0F,
            this.method0002() + 7.0F,
            0.05F,
            ColorHelper.method0966(new Color(ThemePalette.field0567), (int)(2.55F * (72.0F + 28.0F * this.field1635.method0002())))
         );
      }

      GuiRenderHelper.method1491(
         var1.method_51448(),
         field0624,
         this.field0480.method0423(),
         this.method0530() + 8.0F + (!var8 && !this.field1218 ? 0.0F : var7 + 2.0F),
         this.method0002() + (20.0F - field0624.method0530()) / 2.0F,
         ColorHelper.method0966(new Color(ThemePalette.field0567), (int)(2.55F * (72.0F + 28.0F * this.field1635.method0002())))
      );
      this.method1402(var1, var2, var3);
      if (this.method0406()) {
         GuiRenderHelper.method1463(
            var1.method_51448(),
            this.method0530(),
            this.method0002() + 20.0F,
            this.method2047(),
            1.0F,
            0.0F,
            ColorHelper.method0966(new Color(ThemePalette.field0567), (int)(10.0F * this.field1721.method0002()))
         );
      }

      if (this.field1721.method0002() > 0.010000005145931292) {
         GuiRenderHelper.method1404(var1, this.method0530(), this.method0002(), this.method2047(), this.method1762());
         this.method0475().method0670(this.method0530() + 8.0F, this.method0002() + 26.0F).method0126(this.method2047() - 16.0F, 1488.0F);
         this.method0475().method1414(var1, var2, var3, var4);
         GuiRenderHelper.method1400(var1);
      }
   }

   private void method1402(class_332 var1, float var2, float var3) {
      float var4 = field1446.method0998("G");
      float var5 = 0.0F;
      int var6 = class_9848.method_61319(
         this.field1721.method0002(),
         class_9848.method_61330((int)(2.55F * (24.0F + 48.0F * this.field1635.method0002())), ThemePalette.field1137),
         class_9848.method_61319(
            this.field1635.method0002(),
            class_9848.method_61330((int)(2.55F * (24.0F + 48.0F * this.field1635.method0002())), ThemePalette.field1137),
            ThemeColorManager.method1604()
         )
      );
      int var7 = class_9848.method_61319(
         this.field1561.method0002(),
         class_9848.method_61330((int)(2.55F * (24.0F + 24.0F * this.field1561.method0002() + 48.0F * this.field1635.method0002())), ThemePalette.field1137),
         class_9848.method_61319(
            this.field1635.method0002(),
            class_9848.method_61330(
               (int)(2.55F * (24.0F + 24.0F * this.field1561.method0002() + 48.0F * this.field1635.method0002())), ThemePalette.field1137
            ),
            ThemeColorManager.method1604()
         )
      );
      boolean var8 = this.method0399();
      if (this.method0406()) {
         class_4587 var9 = var1.method_51448();
         float var10 = this.method0530() + this.method2047() - 8.0F - var4;
         float var11 = this.method0002() + (20.0F - field1446.method0530()) / 2.0F;
         var9.method_22903();
         float var12 = var11 + field1446.method0530() / 2.0F + 0.5F * this.field1721.method0002();
         var9.method_46416(var10 + var4 / 2.0F, var12, 0.0F);
         var9.method_22907(class_7833.field_40718.rotationDegrees(180.0F * this.field1721.method0002()));
         var9.method_46416(-(var10 + var4 / 2.0F), -var12, 0.0F);
         this.field0924.method0729(var6);
         GuiRenderHelper.method1488(
            var1.method_51448(),
            field1446,
            "G",
            var10 - 0.9F * this.field1721.method0002(),
            var11 + 0.2F + 0.3F * this.field1721.method0002(),
            0.1F,
            this.field0924
         );
         var9.method_22909();
         var5 = var4 + 6.0F;
      }

      float var13 = !this.method0406()
         ? this.method0530() + this.method2047() - 8.0F - var4 + (var4 - field0981.method0998("d")) / 2.0F
         : this.method0530() + this.method2047() - 5.0F - field0981.method0998("d") - var5;
      float var14 = this.method0002() + (20.0F - field0981.method0530()) / 2.0F;
      if (!this.field0480.method0557().isEmpty()) {
         this.field1344.method0729(var7);
         GuiRenderHelper.method1488(var1.method_51448(), field0981, "d", var13, var14, 0.1F, this.field1344);
         boolean var15 = this.method0002() >= this.field1369 && this.method0002() + 20.0F <= this.field0385;
         boolean var16 = var15 && MathHelper.method0689(var13, var14, 8.0F, 8.0F, var2, var3);
         if (!var8 && var16) {
            if (!this.field0442) {
               this.field0442 = true;
               this.field0353 = System.currentTimeMillis();
            }

            if (System.currentTimeMillis() - this.field0353 >= 100L) {
               this.field1561.method1570(true);
               this.field1146.method0670(var13 - this.field1146.method2047() / 2.0F + 3.5F, var14 - 20.0F);
               this.field1146.method2194();
            }
         } else {
            this.method0410();
         }
      }
   }

   private boolean method0399() {
      ClickGuiScreen var1 = ClickGuiScreen.method1904();
      return var1 != null && var1.method0499();
   }

   private void method0410() {
      this.field0442 = false;
      this.field0353 = 0L;
      this.field1561.method1570(false);
      this.field1146.method1973();
   }

   @Override
   public boolean method0746(int var1, int var2, int var3) {
      if (this.field1218) {
         this.field0480.method0881(new KeyBind(var1 == 256 ? -1 : var1, false));
         this.field1218 = false;
         ClickGuiScreen var4 = ClickGuiScreen.method1904();
         if (var4 != null) {
            var4.method0578();
         }

         return true;
      } else {
         return this.field1109 && this.method0475().method0746(var1, var2, var3) ? true : super.method0746(var1, var2, var3);
      }
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      if (this.field1218) {
         this.field0480.method0881(new KeyBind(var5, true));
         this.field1218 = false;
         return true;
      }

      if (MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3)) {
         if (this.field1109 && this.method0475().method0627(var1, var3, var5)) {
            return true;
         }

         if (MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), 20.0F, (float)var1, (float)var3)) {
            switch (var5) {
               case 0:
                  this.field0480.method0345(!this.field0480.method2195());
                  this.field1635.method1570(this.field0480.method2195());
                  this.field1635.method1634();
                  break;
               case 1:
                  if (!this.method0406()) {
                     return false;
                  }

                  if (this.field1109) {
                     ColorSettingWidget.method1973();
                  }

                  this.field1109 = !this.field1109;
                  this.field1721.method1570(this.field1109);
                  this.field1721.method1634();
                  break;
               case 2:
                  this.field1218 = !this.field1218;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean method0112(double var1, double var3, int var5) {
      return this.field1109 && this.field0235 != null ? this.field0235.method0112(var1, var3, var5) : false;
   }

   @Override
   public boolean method0623(double var1, double var3, double var5, double var7) {
      return this.field1109 && this.method0475().method0623(var1, var3, var5, var7) ? true : super.method0623(var1, var3, var5, var7);
   }

   @Generated
   public Module method1954() {
      return this.field0480;
   }

   @Generated
   public Animation method0418() {
      return this.field1635;
   }

   @Generated
   public Animation method0364() {
      return this.field1561;
   }

   @Generated
   public Animation method0488() {
      return this.field1721;
   }

   @Generated
   public PopupPanel method2217() {
      return this.field1146;
   }

   @Generated
   public boolean method2195() {
      return this.field1109;
   }

   @Generated
   public boolean method2267() {
      return this.field1218;
   }

   @Generated
   public boolean method1916() {
      return this.field0890;
   }

   @Generated
   public MutableColor method1883() {
      return this.field0838;
   }

   @Generated
   public MutableColor method1932() {
      return this.field0924;
   }

   @Generated
   public MutableColor method1713() {
      return this.field1344;
   }

   @Generated
   public boolean method1692() {
      return this.field1312;
   }

   @Generated
   public float method1741() {
      return this.field1369;
   }

   @Generated
   public float method2018() {
      return this.field0385;
   }

   @Generated
   public long method2003() {
      return this.field0353;
   }

   @Generated
   public boolean method2044() {
      return this.field0442;
   }

   @Generated
   public SettingList method0466() {
      return this.field0235;
   }
}
