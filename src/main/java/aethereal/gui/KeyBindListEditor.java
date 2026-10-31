package aethereal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;
import net.minecraft.class_1799;
import net.minecraft.class_332;
import net.minecraft.class_3532;

public final class KeyBindListEditor extends GuiElement {
   private static final float field0566 = 110.0F;
   private static final float field0003 = 10.0F;
   private static final float field1410 = 0.625F;
   private static final float field0957 = 15.0F;
   private static final float field0177 = 10.0F;
   private static final float field0458 = 3.0F;
   private static final int field1615 = 6;
   private static final float field1538 = 14.0F;
   private static final float field1704 = 4.0F;
   private static final float field1136 = 0.5F;
   private static final float field1087 = 8.0F;
   private static final float field1196 = 1.2F;
   private static final float field0871 = 2.0F;
   private static final float field0826 = 106.8F;
   private static final float field0910 = 119.0F;
   private static final float field1331 = 3.0F;
   private static FontSize field1300;
   private static FontSize field1375;
   private static FontSize field0392;
   private static FontSize field0358;
   private static FontSize field0428;
   private static FontSize field0261;
   private static FontSize field0232;
   private static FontSize field0294;
   private static boolean field0538 = false;
   private final KeyBindListSetting field0511;
   private final Supplier<Float> field0557;
   private final Animation field1679;
   private final Animation field1663 = new Animation(150L, 1.0, false, EasingCurve.field1477);
   private final SearchFieldState field1695 = new SearchFieldState().method1001("Search...");
   private float field1590;
   private float field1577;
   private float field1601;
   private float field1753;
   private float field1739 = 1.0F;
   private KeyBindSetting field1770;

   private static void method2266() {
      if (!field0538) {
         field1300 = Fonts.field0075.method0654(5.5F);
         field1375 = Fonts.field0075.method0654(5.0F);
         field0392 = Fonts.field0075.method0654(5.5F);
         field0358 = Fonts.field0774.method0654(4.0F);
         field0428 = Fonts.field1718.method0654(5.5F);
         field0261 = Fonts.field0774.method0654(3.0F);
         field0232 = Fonts.field0774.method0654(4.0F);
         field0294 = Fonts.field0075.method0654(5.0F);
         field0538 = true;
      }
   }

   public KeyBindListEditor(KeyBindListSetting var1, Supplier<Float> var2) {
      this.field0511 = var1;
      this.field0557 = var2;
      this.field1679 = new Animation(350L, 1.0, false, EasingCurve.field1477);
   }

   public void method1973() {
      this.field1695.method1570(false);
   }

   public void method0665(float var1) {
      this.field1739 = class_3532.method_15363(var1, 0.0F, 1.0F);
   }

   private Color method0960(Color var1) {
      return this.field1739 >= 0.99F
         ? var1
         : new Color(var1.getRed(), var1.getGreen(), var1.getBlue(), Math.max(0, Math.min(255, (int)(var1.getAlpha() * this.field1739))));
   }

   @Override
   public float method2047() {
      return 110.0F;
   }

   @Override
   public float method1762() {
      return 119.0F;
   }

   public float method0413() {
      return this.field1679.method0002();
   }

   public boolean method0376() {
      return this.field1679.method0376();
   }

   public boolean method0499() {
      return this.field1679.method0346(false);
   }

   public void method1570(boolean var1) {
      this.field1679.method1570(var1);
      if (!var1) {
         this.field1695.method1570(false);
         this.field1770 = null;
      }
   }

   public void method2100(float var1, float var2) {
      this.field1601 = var1;
      this.field1753 = var2;
   }

   public float method2213() {
      return this.field1601;
   }

   public float method2182() {
      return this.field1753;
   }

   private List<KeyBindListSetting.KeyBindEntry> method1914() {
      String var1 = this.field1695.method1792().toString().toLowerCase(Locale.ROOT);
      List var2 = new ArrayList<>();

      for (KeyBindListSetting.KeyBindEntry var4 : this.field0511.method1889()) {
         if (var4.method2079()) {
            if (!var1.isEmpty()) {
               String var5 = var4.method0546().method2067().toLowerCase(Locale.ROOT);
               if (!var5.contains(var1)) {
                  continue;
               }
            }

            var2.add(var4);
         }
      }

      return var2;
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method2266();
      this.field1577 = class_3532.method_16439(0.1F, this.field1577, this.field1590);
      float var5 = this.method0530();
      float var6 = this.method0002();
      float var7 = 110.0F;
      this.method1406(var1, var5, var6, var7, var2, var3);
      float var8 = var6 + 10.0F + 3.0F;
      this.method2168(var1, var5, var8, var7, var2, var3);
      List var9 = this.method1914();
      float var10 = var8 + 15.0F + 3.0F;
      float var11 = 84.0F;
      GuiRenderHelper.method1404(var1, var5, var10, 106.8F, var11);
      float var12 = var10 + this.field1577;
      this.method1429(var1, var9, var5, var12, 106.8F, var2, var3, var10, var10 + var11);
      GuiRenderHelper.method1400(var1);
      float var13 = var9.size() * 14.0F;
      this.field1590 = Math.clamp(this.field1590, Math.min(0.0F, var11 - var13), 0.0F);
      this.method1404(var1, var5 + 106.8F + 2.0F, var10, var11, var13);
   }

   private void method1404(class_332 var1, float var2, float var3, float var4, float var5) {
      Color var6 = this.method0960(new Color(183957503, true));
      GuiRenderHelper.method0326(var1.method_51448(), var2, var3, 1.2F, var4, 0.6F, var6);
      if (!(var5 <= var4)) {
         float var7 = Math.max(8.0F, var4 * (var4 / var5));
         float var8 = var4 - var7;
         float var9 = var5 - var4;
         float var10 = var9 <= 1.0E-4F ? 0.0F : -this.field1577 / var9;
         var10 = class_3532.method_15363(var10, 0.0F, 1.0F);
         float var11 = var3 + var10 * var8;
         Color var12 = this.method0960(new Color(1039595519, true));
         GuiRenderHelper.method0326(var1.method_51448(), var2, var11, 1.2F, var7, 0.6F, var12);
      }
   }

   private void method1406(class_332 var1, float var2, float var3, float var4, int var5, int var6) {
      ThemeColorManager var7 = ThemeColorManager.method1908();
      Color var8 = this.method0960(new Color(var7.method2063().getRed(), var7.method2063().getGreen(), var7.method2063().getBlue(), 255));
      String var9 = this.field0511.method1911() != null ? this.field0511.method1911().method1935() : null;
      FontSize var10 = var9 != null ? field0428 : field0358;
      String var11 = var9 != null ? var9 : "e";
      float var12 = var10.method0998(var11);
      float var13 = var3 + (10.0F - var10.method0530()) / 2.0F - 0.5F;
      GuiRenderHelper.method1491(var1.method_51448(), var10, var11, var2, var13, var8);
      float var14 = field0232.method0998("F");
      float var15 = var2 + var4 - var14 - 2.0F;
      float var16 = var3 + (10.0F - field0232.method0530()) / 2.0F - 1.5F;
      this.method0314(var1, var15, var16, var14, var5, var6);
      float var17 = var2 + var12 + 2.0F;
      float var18 = var15 - var17 - 3.0F;
      String var19 = TextTruncator.method0831(field0392, this.field0511.method2067(), var18);
      float var20 = var3 + (10.0F - field0392.method0530()) / 2.0F;
      Color var21 = this.method0960(new Color(-1208551425, true));
      GuiRenderHelper.method1491(var1.method_51448(), field0392, var19, var17, var20, var21);
   }

   private void method0314(class_332 var1, float var2, float var3, float var4, int var5, int var6) {
      float var7 = field0232.method0530();
      boolean var8 = this.field1679.method0002() > 0.5F && MathHelper.method0689(var2 - 3.0F, var3 - 3.0F, var4 + 6.0F, var7 + 6.0F, var5, var6);
      if (this.field1663.method0376() != var8) {
         this.field1663.method1570(var8);
      }

      float var9 = this.field1663.method0002();
      int var10 = (int)(170.0F + 70.0F * var9);
      int var11 = (int)(170.0F + 70.0F * var9);
      int var12 = (int)(170.0F + 80.0F * var9);
      int var13 = (int)(2.55F * (52.0F + 90.0F * var9));
      Color var14 = this.method0960(new Color(Math.min(255, var10), Math.min(255, var11), Math.min(255, var12), Math.min(255, var13)));
      float var15 = 1.0F + 0.18F * var9;
      float var16 = var2 + var4 / 2.0F;
      float var17 = var3 + var7 / 2.0F;
      var1.method_51448().method_22903();
      var1.method_51448().method_46416(var16, var17, 0.0F);
      var1.method_51448().method_22905(var15, var15, 1.0F);
      var1.method_51448().method_46416(-var16, -var17, 0.0F);
      GuiRenderHelper.method1491(var1.method_51448(), field0232, "F", var2, var3, var14);
      var1.method_51448().method_22909();
   }

   private void method2168(class_332 var1, float var2, float var3, float var4, int var5, int var6) {
      Color var7 = this.method0960(new Color(183957503, true));
      GuiRenderHelper.method1463(var1.method_51448(), var2, var3, var4, 15.0F, 3.0F, var7);
      boolean var8 = !this.field1695.method1792().isEmpty();
      boolean var9 = this.field1695.method0579();
      boolean var10 = var8 || var9;
      String var11 = this.field1695.method1792().toString();
      String var12 = var8 ? var11 : (var9 ? "" : "Search...");
      Color var13 = this.method0960(var8 ? ThemePalette.field1268 : ThemePalette.field0486);
      float var14 = var2 + 5.0F;
      float var15 = var3 + (15.0F - field1375.method0530()) / 2.0F;
      float var16 = var10 ? field0261.method0998("t") + 6.0F : 0.0F;
      GuiRenderHelper.method1404(var1, var2 + 4.0F, var3, var4 - 8.0F - var16, 15.0F);
      if (var9 && this.field1695.method0026() && var8) {
         Color var17 = ThemePalette.field1514.get();
         float var18 = field1375.method0998(var11);
         float var19 = field1375.method0530();
         float var20 = var14 - 1.0F;
         float var21 = var15 - 1.0F;
         float var22 = var18 + 2.0F;
         float var23 = var19 + 2.0F;
         Color var24 = this.method0960(new Color(var17.getRed(), var17.getGreen(), var17.getBlue(), 90));
         GuiRenderHelper.method0326(var1.method_51448(), var20, var21, var22, var23, 1.5F, var24);
      }

      GuiRenderHelper.method1491(var1.method_51448(), field1375, var12, var14, var15, var13);
      if (var9 && !this.field1695.method0026()) {
         float var25 = var14 + field1375.method0998(var11) + 0.5F;
         float var27 = (float)(0.5 + 0.5 * Math.sin(System.currentTimeMillis() / 150.0));
         Color var29 = this.method0960(new Color(255, 255, 255, (int)(255.0F * var27)));
         float var31 = 6.8181815F;
         float var33 = var3 + (15.0F - var31) / 2.0F;
         GuiRenderHelper.method0326(var1.method_51448(), var25, var33, 0.6F, var31, 0.3F, var29);
      }

      GuiRenderHelper.method1400(var1);
      if (var10) {
         String var26 = "t";
         float var28 = field0261.method0998(var26);
         float var30 = var2 + var4 - var28 - 4.0F;
         float var32 = var3 + (15.0F - field0261.method0530()) / 2.0F;
         boolean var34 = MathHelper.method0689(var30 - 2.0F, var32 - 1.0F, var28 + 4.0F, field0261.method0530() + 2.0F, var5, var6);
         int var35 = var34 ? 72 : 48;
         Color var36 = this.method0960(new Color((int)(2.55F * var35) << 24 | 11184810, true));
         GuiRenderHelper.method1491(var1.method_51448(), field0261, var26, var30, var32, var36);
      }
   }

   private boolean method0616(double var1, double var3) {
      float var5 = field0232.method0998("F");
      float var6 = field0232.method0530();
      float var7 = this.method0530() + 110.0F - var5 - 2.0F;
      float var8 = this.method0002() + (10.0F - var6) / 2.0F - 1.5F;
      return MathHelper.method0689(var7 - 3.0F, var8 - 3.0F, var5 + 6.0F, var6 + 6.0F, (float)var1, (float)var3);
   }

   private void method1429(
      class_332 var1, List<KeyBindListSetting.KeyBindEntry> var2, float var3, float var4, float var5, int var6, int var7, float var8, float var9
   ) {
      int var10 = var2.size();
      if (var10 != 0) {
         int var11 = Math.max(0, (int)((var8 - var4) / 14.0F));
         int var12 = Math.min(var10 - 1, (int)((var9 - var4) / 14.0F));
         if (var11 <= var12) {
            Color var13 = ThemePalette.field1514.get();
            Color var14 = this.method0960(new Color(255, 255, 255, 8));
            Color var15 = this.method0960(ThemePalette.field1268);
            Color var16 = this.method0960(ThemePalette.field0207);
            float var17 = var5;
            float var18 = 13.5F;

            for (int var19 = var11; var19 <= var12; var19++) {
               KeyBindListSetting.KeyBindEntry var20 = var2.get(var19);
               KeyBindSetting var21 = var20.method0546();
               KeyBind var22 = var21.method0492();
               boolean var23 = this.field1770 == var21;
               boolean var24 = var22.method2048() != -1;
               String var25 = var23 ? "..." : var22.toString().replace("_", " ");
               float var26 = var4 + var19 * 14.0F;
               GuiRenderHelper.method1463(var1.method_51448(), var3, var26, var17, var18, 2.0F, var14);
               if (this.field1739 > 0.85F) {
                  class_1799 var27 = new class_1799(var20.method0021());
                  var1.method_51448().method_22903();
                  float var28 = var3 + 4.0F;
                  float var29 = var26 + (var18 - 10.0F) / 2.0F;
                  var1.method_51448().method_46416(var28, var29, 0.0F);
                  var1.method_51448().method_22905(0.625F, 0.625F, 1.0F);
                  var1.method_51427(var27, 0, 0);
                  var1.method_51448().method_22909();
               }

               float var40 = field0294.method0998("W");
               float var41 = 4.0F + Math.max(field0294.method0998(var25), var40);
               float var42 = var3 + var17 - 4.0F - var41;
               float var30 = var26 + (var18 - 8.0F) / 2.0F;
               float var31 = var3 + 4.0F + 10.0F + 4.0F;
               float var32 = var42 - var31 - 2.0F;
               String var33 = var21.method2067();
               String var34 = TextTruncator.method0831(field1300, var33, var32);
               float var35 = var26 + (var18 - field1300.method0530()) / 2.0F;
               GuiRenderHelper.method1491(var1.method_51448(), field1300, var34, var31, var35, var15);
               Color var36;
               Color var37;
               if (var24 && !var23) {
                  var36 = this.method0960(var13);
                  var37 = this.method0960(Color.WHITE);
               } else if (var23) {
                  var36 = this.method0960(new Color(var13.getRed(), var13.getGreen(), var13.getBlue(), 96));
                  var37 = this.method0960(Color.WHITE);
               } else {
                  var36 = this.method0960(new Color(255, 255, 255, 24));
                  var37 = var16;
               }

               GuiRenderHelper.method0326(var1.method_51448(), var42, var30, var41, 8.0F, 1.0F, var36);
               float var38 = field0294.method0998(var25);
               float var39 = var42 + (var41 - var38) / 2.0F;
               GuiRenderHelper.method1491(var1.method_51448(), field0294, var25, var39, var30 + (8.0F - field0294.method0530()) / 2.0F, var37);
            }
         }
      }
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      method2266();
      float var6 = this.method0530();
      float var7 = this.method0002();
      if (!MathHelper.method0689(var6, var7, 110.0F, 119.0F, (float)var1, (float)var3)) {
         if (this.field1770 != null) {
            this.field1770 = null;
         }

         return false;
      } else {
         if (var5 == 0 && this.method0616(var1, var3)) {
            KeyBindListSettingWidget.method1973();
            return true;
         }

         float var8 = var7 + 10.0F + 3.0F;
         if (this.field1770 != null) {
            this.field1770.method0206(new KeyBind(var5, true, false));
            this.field1770 = null;
            return true;
         }

         boolean var9 = !this.field1695.method1792().isEmpty() || this.field1695.method0579();
         if (var9) {
            String var10 = "t";
            float var11 = field0261.method0998(var10);
            float var12 = var6 + 110.0F - var11 - 4.0F;
            float var13 = var8 + (15.0F - field0261.method0530()) / 2.0F;
            if (MathHelper.method0689(var12 - 2.0F, var13 - 1.0F, var11 + 4.0F, field0261.method0530() + 2.0F, (float)var1, (float)var3)) {
               if (!this.field1695.method1792().isEmpty()) {
                  this.field1695.method1792().setLength(0);
                  this.field1695.method2078();
                  this.field1590 = 0.0F;
               } else {
                  this.field1695.method1570(false);
               }

               return true;
            }
         }

         if (MathHelper.method0689(var6, var8, 110.0F, 15.0F, (float)var1, (float)var3)) {
            this.field1695.method1570(true);
            this.field1695.method2078();
            ClickGuiScreen var17 = ClickGuiScreen.method1904();
            if (var17 != null && var17.method1775() != null) {
               var17.method1775().method1951().method1570(false);
            }

            return true;
         } else {
            this.field1695.method1570(false);
            this.field1695.method2078();
            float var16 = var8 + 15.0F + 3.0F;
            float var18 = 84.0F;
            if (!(var3 < var16) && !(var3 > var16 + var18)) {
               List var19 = this.method1914();
               float var20 = var16 + this.field1577;
               int var14 = (int)Math.floor((var3 - var20) / 14.0);
               if (var14 >= 0 && var14 < var19.size()) {
                  KeyBindListSetting.KeyBindEntry var15 = var19.get(var14);
                  this.field1770 = var15.method0546();
                  return true;
               } else {
                  return true;
               }
            } else {
               return true;
            }
         }
      }
   }

   @Override
   public boolean method0623(double var1, double var3, double var5, double var7) {
      if (MathHelper.method0689(this.method0530(), this.method0002(), 110.0F, 119.0F, (float)var1, (float)var3)) {
         this.field1590 += (float)var7 * 15.0F;
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean method0746(int var1, int var2, int var3) {
      if (this.field1770 != null) {
         this.field1770.method0206(new KeyBind(var1 == 256 ? -1 : var1, false, false));
         this.field1770 = null;
         ClickGuiScreen var5 = ClickGuiScreen.method1904();
         if (var5 != null) {
            var5.method0578();
         }

         return true;
      } else {
         if (!this.field1695.method0579()) {
            return false;
         }

         boolean var4 = this.field1695.method0746(var1, var2, var3);
         if (var4) {
            this.field1590 = 0.0F;
         }

         return var4;
      }
   }

   @Override
   public boolean method0607(char var1, int var2) {
      if (!this.field1695.method0579()) {
         return false;
      }

      boolean var3 = this.field1695.method0607(var1, var2);
      if (var3) {
         this.field1590 = 0.0F;
      }

      return var3;
   }
}
