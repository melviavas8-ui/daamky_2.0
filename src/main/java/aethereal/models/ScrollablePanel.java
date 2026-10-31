package aethereal;

import java.awt.Color;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;
import net.minecraft.class_332;
import net.minecraft.class_4587;

public class ScrollablePanel {
   private static final float field0566 = 240.0F;
   private static final float field0003 = 32.0F;
   private static final float field1410 = 28.0F;
   private static final float field0957 = 12.0F;
   private float field0758;
   private float field1242;
   private float field0314 = 0.0F;
   private float field0177 = 0.0F;
   private float field0458 = 0.0F;
   private boolean field1653 = false;
   private YearMonth field1565 = YearMonth.now();

   public void method0675(float var1, float var2) {
      this.field0758 = var1;
      this.field1242 = var2;
   }

   public void method0578() {
      this.field1653 = !this.field1653;
      this.field0314 = this.field1653 ? this.method1603() : 0.0F;
   }

   public void method0025() {
      this.field1653 = false;
      this.field0314 = 0.0F;
   }

   public boolean method2079() {
      return this.field1653 || this.field0177 > 1.0F;
   }

   private float method1603() {
      int var1 = this.method1947();
      return 84.0F + var1 * 28.0F + 12.0F;
   }

   private int method1947() {
      LocalDate var1 = this.field1565.atDay(1);
      int var2 = var1.getDayOfWeek().getValue();
      int var3 = this.field1565.lengthOfMonth();
      return (int)Math.ceil((var2 - 1 + var3) / 7.0);
   }

   public void method1812() {
      float var1 = 0.15F;
      this.field0177 = this.field0177 + (this.field0314 - this.field0177) * var1;
      this.field0458 = this.field0458 + ((this.field1653 ? 1.0F : 0.0F) - this.field0458) * var1;
      if (Math.abs(this.field0177 - this.field0314) < 0.5F) {
         this.field0177 = this.field0314;
      }

      if (Math.abs(this.field0458 - (this.field1653 ? 1.0F : 0.0F)) < 0.01F) {
         this.field0458 = this.field1653 ? 1.0F : 0.0F;
      }
   }

   public void method1400(class_332 var1) {
      if (!(this.field0177 < 1.0F)) {
         class_4587 var2 = var1.method_51448();
         float var3 = this.field0758 - 120.0F;
         float var4 = this.field1242;
         int var5 = (int)(220.0F * this.field0458);
         Color var6 = new Color(20, 20, 25, var5);
         Color var7 = new Color(255, 255, 255, (int)(30.0F * this.field0458));
         GuiRenderHelper.method1462(var2, var3, var4, 240.0F, this.field0177, 8.0F, 20.0F, new Color(255, 255, 255, (int)(40.0F * this.field0458)));
         GuiRenderHelper.method1463(var2, var3, var4, 240.0F, this.field0177, 8.0F, var6);
         GuiRenderHelper.method1461(var2, var3, var4, 240.0F, this.field0177, 8.0F, 1.0F, 1.0F, var7);
         if (!(this.field0458 < 0.1F)) {
            FontSize var8 = Fonts.field1258.method0654(9.0F);
            FontSize var9 = Fonts.field1258.method0654(7.0F);
            FontSize var10 = Fonts.field1258.method0654(6.0F);
            String var11 = this.field1565.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " " + this.field1565.getYear();
            float var12 = var8.method0998(var11);
            GuiRenderHelper.method1491(var2, var8, "<", var3 + 12.0F, var4 + 12.0F, new Color(255, 255, 255, (int)(180.0F * this.field0458)));
            GuiRenderHelper.method1491(var2, var8, var11, var3 + 120.0F - var12 / 2.0F, var4 + 12.0F, new Color(255, 255, 255, (int)(255.0F * this.field0458)));
            GuiRenderHelper.method1491(
               var2, var8, ">", var3 + 240.0F - 12.0F - var8.method0998(">"), var4 + 12.0F, new Color(255, 255, 255, (int)(180.0F * this.field0458))
            );
            float var13 = var4 + 32.0F;
            float var14 = 30.857143F;
            String[] var15 = new String[]{"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};

            for (int var16 = 0; var16 < 7; var16++) {
               float var17 = var3 + 12.0F + var16 * var14 + var14 / 2.0F - var10.method0998(var15[var16]) / 2.0F;
               GuiRenderHelper.method1491(var2, var10, var15[var16], var17, var13, new Color(255, 255, 255, (int)(120.0F * this.field0458)));
            }

            var13 += 28.0F;
            LocalDate var30 = this.field1565.atDay(1);
            int var31 = var30.getDayOfWeek().getValue() % 7;
            int var18 = this.field1565.lengthOfMonth();
            LocalDate var19 = LocalDate.now();
            int var20 = 1;

            for (int var21 = 0; var20 <= var18; var21++) {
               for (int var22 = 0; var22 < 7; var22++) {
                  if (var21 != 0 || var22 >= var31) {
                     if (var20 > var18) {
                        break;
                     }

                     float var23 = var3 + 12.0F + var22 * var14 + var14 / 2.0F;
                     float var24 = var13 + var21 * 28.0F + 14.0F;
                     boolean var25 = this.field1565.getYear() == var19.getYear()
                        && this.field1565.getMonthValue() == var19.getMonthValue()
                        && var20 == var19.getDayOfMonth();
                     if (var25) {
                        GuiRenderHelper.method1463(var2, var23 - 12.0F, var24 - 10.0F, 24.0F, 20.0F, 10.0F, ThemePalette.field1514.get());
                     }

                     String var26 = String.valueOf(var20);
                     float var27 = var9.method0998(var26);
                     Color var28 = var25 ? new Color(255, 255, 255, (int)(255.0F * this.field0458)) : new Color(255, 255, 255, (int)(200.0F * this.field0458));
                     GuiRenderHelper.method1491(var2, var9, var26, var23 - var27 / 2.0F, var24 - var9.method0530() / 2.0F, var28);
                     var20++;
                  }
               }
            }
         }
      }
   }

   public boolean method0627(double var1, double var3, int var5) {
      if (this.field1653 && !(this.field0177 < 10.0F)) {
         float var6 = this.field0758 - 120.0F;
         float var7 = this.field1242;
         if (var1 >= var6 && var1 <= var6 + 240.0F && var3 >= var7 && var3 <= var7 + this.field0177) {
            if (var3 < var7 + 32.0F) {
               if (var1 < var6 + 40.0F) {
                  this.field1565 = this.field1565.minusMonths(1L);
                  this.field0314 = this.method1603();
               } else if (var1 > var6 + 240.0F - 40.0F) {
                  this.field1565 = this.field1565.plusMonths(1L);
                  this.field0314 = this.method1603();
               }
            }

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public boolean method0616(double var1, double var3) {
      if (!this.field1653) {
         return false;
      }

      float var5 = this.field0758 - 120.0F;
      float var6 = this.field1242;
      return var1 >= var5 && var1 <= var5 + 240.0F && var3 >= var6 && var3 <= var6 + this.field0177;
   }
}
