package aethereal;

import java.awt.Color;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_4587;

public class FriendScreen extends class_437 {
   private static final float field0566 = 38.0F;
   private static final float field0003 = 10.0F;
   private static final float field1410 = 11.0F;
   private static final float field0957 = 3.0F;
   private static final float field0758 = 5.0F;
   private static final float field1242 = 3.0F;
   private static final float field0314 = 3.0F;
   private static final float field0177 = 2.0F;
   private final String field0487;
   private final float field1614;
   private final float field1538;
   private float field1704;
   private float field1136;
   private float field1087 = 0.0F;
   private boolean field1218 = true;
   private boolean field0890;

   public FriendScreen(String var1, float var2, float var3) {
      super(class_2561.method_43473());
      this.field0487 = var1;
      this.field1614 = var2;
      this.field1538 = var3;
      this.field0890 = FriendManager.method0538().method2135(var1);
   }

   protected void method_25426() {
      float var1 = this.method0530();
      float var2 = ScreenLayoutHelper.method2047();
      float var3 = ScreenLayoutHelper.method1762();
      this.field1704 = this.field1614 - this.method0002() / 2.0F;
      this.field1136 = this.field1538 + 8.0F;
      if (this.field1704 + this.method0002() > var2 - 4.0F) {
         this.field1704 = var2 - this.method0002() - 4.0F;
      }

      if (this.field1136 + var1 > var3 - 4.0F) {
         this.field1136 = var3 - var1 - 4.0F;
      }

      if (this.field1704 < 4.0F) {
         this.field1704 = 4.0F;
      }

      if (this.field1136 < 4.0F) {
         this.field1136 = 4.0F;
      }

      this.field1218 = true;
      this.field1087 = 0.0F;
   }

   private float method0530() {
      return 28.0F;
   }

   private float method0002() {
      FontSize var1 = Fonts.field0075.method0654(5.5F);
      float var2 = var1.method0998(this.field0487);
      return Math.max(38.0F, var2 + 6.0F);
   }

   private float[] method2080() {
      FontSize var1 = Fonts.field0075.method0654(5.0F);
      FontSize var2 = Fonts.field0774.method0654(5.0F);
      float var3 = var1.method0998("Friend");
      float var4 = var2.method0998("u");
      float var5 = var3 + 2.0F + var4;
      float var6 = 6.0F + var5;
      float var7 = this.field1704 + (this.method0002() - var6) / 2.0F;
      float var8 = this.field1136 + 3.0F + 10.0F + 1.0F;
      return new float[]{var7, var8, var6, 11.0F};
   }

   public void method_25394(class_332 var1, int var2, int var3, float var4) {
      float var5 = this.field1218 ? 1.0F : 0.0F;
      this.field1087 = this.field1087 + (var5 - this.field1087) * 0.18F;
      if (this.field1087 >= 0.99F) {
         this.field1087 = 1.0F;
      }

      if (!this.field1218 && this.field1087 <= 0.01F) {
         this.field1087 = 0.0F;
         this.method_25419();
      } else {
         float var6 = ScreenLayoutHelper.method0002();
         float var7 = (float)class_310.method_1551().field_1729.method_1603()
            * ScreenLayoutHelper.method2047()
            / class_310.method_1551().method_22683().method_4480();
         float var8 = (float)class_310.method_1551().field_1729.method_1604()
            * ScreenLayoutHelper.method1762()
            / class_310.method_1551().method_22683().method_4507();
         class_4587 var9 = var1.method_51448();
         float var10 = this.method0530();
         float var11 = this.field1087;
         float var12 = 0.9F + 0.1F * this.field1087;
         float var13 = this.field1704 + this.method0002() / 2.0F;
         float var14 = this.field1136;
         var9.method_22903();
         var9.method_22905(var6, var6, 1.0F);
         var9.method_22903();
         var9.method_46416(var13, var14, 0.0F);
         var9.method_22905(var12, var12, 1.0F);
         var9.method_46416(-var13, -var14, 0.0F);
         Color var15 = ThemeColorManager.method1908().method2063();
         Color var16 = ThemePalette.field0930.get();
         Color var17 = ThemePalette.field0884;
         Color var18 = new Color(255, 255, 255, 5);
         Color var19 = new Color(255, 255, 255, 10);
         GuiRenderHelper.method1462(
            var9,
            this.field1704,
            this.field1136,
            this.method0002(),
            var10,
            5.0F,
            ThemePalette.field0367.get(),
            method0964(ThemePalette.field0134, var11)
         );
         GuiRenderHelper.method1463(var9, this.field1704, this.field1136, this.method0002(), var10, 5.0F, method0964(var16, var11));
         GuiRenderHelper.method1461(var9, this.field1704, this.field1136, this.method0002(), var10, 5.0F, 0.5F, 0.5F, method0964(var17, var11));
         FontSize var20 = Fonts.field0075.method0654(5.5F);
         FontSize var21 = Fonts.field0075.method0654(5.0F);
         FontSize var22 = Fonts.field0774.method0654(5.0F);
         float var23 = this.field1136 + 3.0F + (10.0F - var20.method0530()) / 2.0F;
         float var24 = var20.method0998(this.field0487);
         float var25 = this.field1704 + (this.method0002() - var24) / 2.0F;
         GuiRenderHelper.method1491(var9, var20, this.field0487, var25, var23, method0964(Color.WHITE, var11));
         float[] var26 = this.method2080();
         float var27 = var26[0];
         float var28 = var26[1];
         float var29 = var26[2];
         GuiRenderHelper.method1462(var9, var27, var28, var29, 11.0F, 3.0F, ThemePalette.field0367.get(), method0964(ThemePalette.field0134, var11));
         GuiRenderHelper.method1463(var9, var27, var28, var29, 11.0F, 3.0F, method0964(var16, var11));
         GuiRenderHelper.method0326(var9, var27, var28, var29, 11.0F, 3.0F, method0964(var18, var11));
         GuiRenderHelper.method1460(var9, var27, var28, var29, 11.0F, 3.0F, 0.3F, 0.5F, 0.5F, method0964(var19, var11));
         String var30 = "Friend";
         String var31 = "u";
         float var32 = var21.method0998(var30);
         float var33 = var22.method0998(var31);
         float var34 = var27 + 3.0F;
         float var35 = var28 + (11.0F - var21.method0530()) / 2.0F;
         GuiRenderHelper.method1491(var9, var21, var30, var34, var35, method0964(Color.WHITE, var11));
         Color var36 = this.field0890 ? var15 : new Color(180, 180, 180, 90);
         float var37 = var34 + var32 + 2.0F;
         float var38 = var28 + (11.0F - var22.method0530()) / 2.0F - 0.3F;
         GuiRenderHelper.method1491(var9, var22, var31, var37, var38, method0964(var36, var11));
         var9.method_22909();
         var9.method_22909();
      }
   }

   public boolean method_25402(double var1, double var3, int var5) {
      if (var5 != 0) {
         return super.method_25402(var1, var3, var5);
      }

      float var6 = (float)class_310.method_1551().field_1729.method_1603()
         * ScreenLayoutHelper.method2047()
         / class_310.method_1551().method_22683().method_4480();
      float var7 = (float)class_310.method_1551().field_1729.method_1604()
         * ScreenLayoutHelper.method1762()
         / class_310.method_1551().method_22683().method_4507();
      float var8 = this.method0530();
      if (!MathHelper.method0689(this.field1704, this.field1136, this.method0002(), var8, var6, var7)) {
         this.field1218 = false;
         return true;
      }

      float[] var9 = this.method2080();
      if (MathHelper.method0689(var9[0], var9[1], var9[2], var9[3], var6, var7)) {
         FriendManager var10 = FriendManager.method0538();
         if (this.field0890) {
            var10.method0213(this.field0487);
         } else {
            var10.method1013(this.field0487);
         }

         this.field0890 = !this.field0890;
         this.field1218 = false;
         return true;
      } else {
         return true;
      }
   }

   public boolean method_25421() {
      return false;
   }

   public boolean method_25422() {
      return true;
   }

   private static Color method0964(Color var0, float var1) {
      return var1 >= 0.99F ? var0 : new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), Math.max(0, Math.min(255, (int)(var0.getAlpha() * var1))));
   }
}
