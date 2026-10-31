package aethereal;

import java.awt.Color;
import net.minecraft.class_332;
import net.minecraft.class_4587;

public class MainMenuCard {
   private static final float field0566 = 12.0F;
   private static final float field0003 = 0.5F;
   private static final float field1410 = 6.0F;
   private float field0957;
   private float field0758;
   private float field1242;
   private float field0314;
   private final String field0208;
   private final String field0487;
   private final Runnable field1642;
   private final MainMenuCard.CardStyle field1557;
   private final float field1704;
   private float field1136;
   private boolean field1109;
   private float field1196 = 0.0F;
   private float field0871 = 0.0F;
   private int field0827;
   private int field0911;

   public MainMenuCard(String var1, String var2, Runnable var3, MainMenuCard.CardStyle var4, float var5) {
      this.field0208 = var1;
      this.field0487 = var2;
      this.field1642 = var3;
      this.field1557 = var4;
      this.field1704 = var5;
   }

   public void method0686(float var1, float var2, float var3, float var4) {
      this.field0957 = var1;
      this.field0758 = var2;
      this.field1242 = var3;
      this.field0314 = var4;
   }

   public void method0738(int var1, int var2) {
      this.field0827 = var1;
      this.field0911 = var2;
   }

   public void method1414(class_332 var1, int var2, int var3, float var4) {
      this.field1136 = var4;
      float var5 = ScreenLayoutHelper.method0530();
      class_4587 var6 = var1.method_51448();
      float var7 = this.field0827 > 0 ? Math.max(-1.0F, Math.min(1.0F, (var2 - this.field0827 / 2.0F) / (this.field0827 / 2.0F))) : 0.0F;
      float var8 = this.field0911 > 0 ? Math.max(-1.0F, Math.min(1.0F, (var3 - this.field0911 / 2.0F) / (this.field0911 / 2.0F))) : 0.0F;
      float var9 = var7 * 6.0F * var5;
      float var10 = var8 * 6.0F * var5;
      this.field1196 = this.field1196 + (var9 - this.field1196) * 0.08F;
      this.field0871 = this.field0871 + (var10 - this.field0871) * 0.08F;
      float var11 = this.field0957 + this.field1196;
      float var12 = this.field0758 + this.field0871;
      float var13 = var11;
      float var14 = this.field1242;
      if (this.field1557 == MainMenuCard.CardStyle.field0643) {
         var13 = var11 + this.field0314 + 8.0F * var5;
         var14 = this.field1242 - this.field0314 - 8.0F * var5;
      }

      this.field1109 = var2 >= var13 && var2 <= var13 + var14 && var3 >= var12 && var3 <= var12 + this.field0314;
      float var15 = 12.0F * var5;
      float var16 = ThemePalette.field0367.get() * var5;
      Color var17 = method0964(new Color(0, 0, 0, 100), var4);
      Color var18 = method0964(ThemePalette.field1210, var4);
      Color var19 = method0964(ThemePalette.field0134, var4);
      if (this.field1557 == MainMenuCard.CardStyle.field0643) {
         float var20 = this.field0314;
         float var21 = 8.0F * var5;
         float var22 = this.field1242 - var20 - var21;
         float var23 = var11 + var20 + var21;
         GuiRenderHelper.method0325(var6, var23, var12, var22, this.field0314, var15, var16, var19);
         GuiRenderHelper.method1463(var6, var23, var12, var22, this.field0314, var15, var17);
         GuiRenderHelper.method1461(var6, var23, var12, var22, this.field0314, var15, 0.5F, 0.5F, var18);
      } else {
         GuiRenderHelper.method0325(var6, var11, var12, this.field1242, this.field0314, var15, var16, var19);
         GuiRenderHelper.method1463(var6, var11, var12, this.field1242, this.field0314, var15, var17);
         GuiRenderHelper.method1461(var6, var11, var12, this.field1242, this.field0314, var15, 0.5F, 0.5F, var18);
      }
   }

   private static Color method0964(Color var0, float var1) {
      int var2 = Math.max(0, Math.min(255, (int)(var0.getAlpha() * var1)));
      return new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), var2);
   }

   public void method1400(class_332 var1) {
      float var2 = ScreenLayoutHelper.method0530();
      class_4587 var3 = var1.method_51448();
      float var4 = this.field0957 + this.field1196;
      float var5 = this.field0758 + this.field0871;
      int var6 = (int)(this.field1136 * 255.0F);
      Color var7 = new Color(255, 255, 255, Math.min(255, var6));
      FontSize var8 = Fonts.field0075.method0654(10.0F * var2);
      if (this.field1557 == MainMenuCard.CardStyle.field0643) {
         float var9 = this.field0314;
         float var10 = 8.0F * var2;
         float var11 = this.field1242 - var9 - var10;
         float var12 = var4 + var9 + var10 + (var11 - var8.method0010().method1016(this.field0208, var8.method2047())) / 2.0F;
         float var13 = var5 + (this.field0314 - var8.method0010().method0645(var8.method2047())) / 2.0F;
         GuiRenderHelper.method1491(var3, var8, this.field0208, var12, var13, var7);
      } else {
         float var14 = var4 + (this.field1242 - var8.method0010().method1016(this.field0208, var8.method2047())) / 2.0F;
         float var15 = var5 + (this.field0314 - var8.method0010().method0645(var8.method2047())) / 2.0F;
         GuiRenderHelper.method1491(var3, var8, this.field0208, var14, var15, var7);
      }

      this.method1478(var3, var6, var4, var5);
   }

   private void method1478(class_4587 var1, int var2, float var3, float var4) {
      if (this.field0487 != null && !this.field0487.isEmpty()) {
         float var5 = ScreenLayoutHelper.method0530();
         FontSize var6 = Fonts.field0075.method0654(5.0F * var5);
         float var7 = 8.0F * var5;
         float var8 = this.field1557 == MainMenuCard.CardStyle.field0643 ? this.field1242 - this.field0314 - var7 : this.field1242;
         float var9 = this.field1557 == MainMenuCard.CardStyle.field0643 ? var3 + this.field0314 + var7 : var3;
         int var10 = (int)(var2 * 0.6F);
         Color var11 = new Color(180, 160, 200, Math.min(255, var10));
         String[] var12 = this.field0487.split("\n");
         float var13 = var6.method0010().method0645(var6.method2047());
         float var14 = 2.0F * var5;
         float var15 = var12.length * var13 + (var12.length - 1) * var14;
         float var16 = var4 - var15 - 4.0F * var5 + this.field1704 * var5;

         for (int var17 = 0; var17 < var12.length; var17++) {
            String var18 = var12[var17].trim();
            float var19 = var6.method0010().method1016(var18, var6.method2047());
            float var20 = var9 + (var8 - var19) / 2.0F;
            float var21 = var16 + var17 * (var13 + var14);
            GuiRenderHelper.method1491(var1, var6, var18, var20, var21, var11);
         }
      }
   }

   public boolean method0627(double var1, double var3, int var5) {
      if (var5 == 0 && this.field1109) {
         this.field1642.run();
         return true;
      } else {
         return false;
      }
   }

   public float method0530() {
      return this.field0957;
   }

   public float method0002() {
      return this.field0758;
   }

   public float method2047() {
      return this.field1242;
   }

   public float method1762() {
      return this.field0314;
   }

   public enum CardStyle {
      field0643,
      field0073;
   }
}
