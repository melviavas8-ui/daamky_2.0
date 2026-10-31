package aethereal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.class_332;
import net.minecraft.class_3532;

public final class NumberListEditor extends GuiElement {
   private static final float field0566 = 165.0F;
   private static final float field0003 = 12.0F;
   private static final float field1410 = 10.0F;
   private static final float field0957 = 3.0F;
   private static final int field0178 = 7;
   private static final float field0458 = 16.0F;
   private static final float field1614 = 5.0F;
   private static final float field1538 = 0.5F;
   private static final float field1704 = 88.0F;
   private static final float field1136 = 22.0F;
   private static final float field1087 = 4.0F;
   private static final float field1196 = 1.5F;
   private static final float field0871 = 144.0F;
   private static FontSize field0834;
   private static FontSize field0917;
   private static FontSize field1339;
   private static FontSize field1300;
   private static FontSize field1375;
   private static FontSize field0392;
   private static FontSize field0358;
   private static boolean field0442 = false;
   private final NumberListSetting field0267;
   private final Supplier<Float> field0240;
   private final Animation field0297;
   private final StringBuilder field0535 = new StringBuilder();
   private float field0501;
   private float field0547;
   private float field1671;
   private float field1657;
   private boolean field1699;
   private FloatSetting field1593;
   private float field1577;
   private float field1601;
   private final Map<FloatSetting, Float> field1760 = new HashMap<>();

   private static void method2228() {
      if (!field0442) {
         field0834 = Fonts.field0075.method0654(5.5F);
         field0917 = Fonts.field0075.method0654(5.0F);
         field1339 = Fonts.field0075.method0654(5.5F);
         field1300 = Fonts.field0774.method0654(4.0F);
         field1375 = Fonts.field0774.method0654(4.5F);
         field0392 = Fonts.field0075.method0654(5.0F);
         field0358 = Fonts.field0075.method0654(5.0F);
         field0442 = true;
      }
   }

   private static String method2191() {
      try {
         return ClickGuiDashboard.field0984.method0492() == ClickGuiDashboard.Language.field0631 ? "Сбросить" : "Reset";
      } catch (Exception var1) {
         return "Reset";
      }
   }

   public NumberListEditor(NumberListSetting var1, Supplier<Float> var2) {
      this.field0267 = var1;
      this.field0240 = var2;
      this.field0297 = new Animation(200L, 1.0, false, EasingCurve.field1011);
   }

   @Override
   public float method2047() {
      return 165.0F;
   }

   @Override
   public float method1762() {
      return 144.0F;
   }

   public float method1946() {
      return this.field0297.method0002();
   }

   public boolean method0431() {
      return !this.field0297.method0376() && this.field0297.method0002() < 0.01F;
   }

   public void method1570(boolean var1) {
      this.field0297.method1570(var1);
      this.field0297.method1634();
      if (!var1) {
         this.field1699 = false;
         this.field1593 = null;
      }
   }

   public void method2100(float var1, float var2) {
      this.field1671 = var1;
      this.field1657 = var2;
   }

   public float method0355() {
      return this.field1671;
   }

   public float method0483() {
      return this.field1657;
   }

   private List<NumberListSetting.NumberEntry> method2263() {
      String var1 = this.field0535.toString().toLowerCase(Locale.ROOT);
      List var2 = new ArrayList<>();

      for (NumberListSetting.NumberEntry var4 : this.field0267.method1889()) {
         if (var4.method0026()) {
            if (!var1.isEmpty()) {
               String var5 = var4.method0537().method2067().toLowerCase(Locale.ROOT);
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
      method2228();
      this.field0547 = class_3532.method_16439(0.1F, this.field0547, this.field0501);
      float var5 = this.method0530();
      float var6 = this.method0002();
      float var7 = 165.0F;
      ThemeColorManager var8 = ThemeColorManager.method1908();
      Color var9 = new Color(var8.method2063().getRed(), var8.method2063().getGreen(), var8.method2063().getBlue(), 255);
      float var10 = field1300.method0998("h");
      float var11 = var6 + (10.0F - field1300.method0530()) / 2.0F - 0.5F;
      GuiRenderHelper.method1491(var1.method_51448(), field1300, "h", var5, var11, var9);
      String var12 = method2191();
      float var13 = field0358.method0998(var12);
      float var14 = var13 + 8.0F;
      float var15 = 12.0F;
      float var16 = var5 + var7 - var14;
      float var17 = var6 + (10.0F - var15) / 2.0F;
      Color var18 = new Color(255, 255, 255, 18);
      Color var19 = new Color(255, 255, 255, 28);
      GuiRenderHelper.method1463(var1.method_51448(), var16, var17, var14, var15, 2.5F, var18);
      GuiRenderHelper.method1461(var1.method_51448(), var16, var17, var14, var15, 2.5F, 0.5F, 0.5F, var19);
      float var20 = var16 + 4.0F;
      float var21 = var17 + (var15 - field0358.method0530()) / 2.0F;
      GuiRenderHelper.method1491(var1.method_51448(), field0358, var12, var20, var21, ThemePalette.field1268);
      float var22 = var5 + var10 + 2.0F;
      float var23 = var16 - 3.0F - var22;
      String var24 = TextTruncator.method0831(field1339, this.field0267.method2067(), var23);
      float var25 = var6 + (10.0F - field1339.method0530()) / 2.0F;
      Color var26 = new Color(-1208551425, true);
      GuiRenderHelper.method1491(var1.method_51448(), field1339, var24, var22, var25, var26);
      float var27 = var6 + 10.0F + 3.0F;
      Color var28 = new Color(255, 255, 255, 15);
      Color var29 = this.field1699 ? ThemePalette.field1514.get() : new Color(255, 255, 255, 20);
      GuiRenderHelper.method1463(var1.method_51448(), var5, var27, var7, 12.0F, 3.0F, var28);
      GuiRenderHelper.method1461(var1.method_51448(), var5, var27, var7, 12.0F, 3.0F, 0.5F, 0.5F, var29);
      float var30 = var5 + 4.0F;
      boolean var31 = this.field0535.length() > 0;
      String var32 = var31 ? this.field0535.toString() : "Search...";
      Color var33 = var31 ? ThemePalette.field1268 : ThemePalette.field0486;
      GuiRenderHelper.method1491(var1.method_51448(), field0917, var32, var30, var27 + (12.0F - field0917.method0530()) / 2.0F, var33);
      if (this.field1699) {
         float var34 = var30 + field0917.method0998(this.field0535.toString());
         boolean var35 = System.currentTimeMillis() / 500L % 2L == 0L;
         if (var35) {
            GuiRenderHelper.method1463(var1.method_51448(), var34, var27 + 2.5F, 0.5F, 7.0F, 0.0F, ThemePalette.field0334);
         }
      }

      if (var31) {
         String var39 = "t";
         float var41 = field1375.method0998(var39);
         float var36 = var5 + var7 - var41 - 4.0F;
         float var37 = var27 + (12.0F - field1375.method0530()) / 2.0F;
         GuiRenderHelper.method1491(var1.method_51448(), field1375, var39, var36, var37, ThemePalette.field0334);
      }

      List var40 = this.method2263();
      float var42 = var27 + 12.0F + 3.0F;
      float var43 = 112.0F;
      GuiRenderHelper.method1404(var1, var5, var42, var7, var43);
      float var44 = var42 + this.field0547;
      this.method1428(var1, var40, var5, var44, var7, var2, var42, var42 + var43);
      GuiRenderHelper.method1400(var1);
      float var38 = var40.size() * 16.0F;
      this.field0501 = Math.clamp(this.field0501, Math.min(0.0F, var43 - var38), 0.0F);
      if (this.field1593 != null) {
         this.method0611(var2);
      }
   }

   private void method1428(class_332 var1, List<NumberListSetting.NumberEntry> var2, float var3, float var4, float var5, int var6, float var7, float var8) {
      int var9 = var2.size();
      if (var9 != 0) {
         int var10 = Math.max(0, (int)((var7 - var4) / 16.0F));
         int var11 = Math.min(var9 - 1, (int)((var8 - var4) / 16.0F));
         if (var10 <= var11) {
            Color var12 = ThemePalette.field1514.get();
            Color var13 = new Color(255, 255, 255, 8);
            Color var14 = ThemePalette.field1268;
            Color var15 = new Color(255, 255, 255, 24);
            Color var16 = new Color(255, 255, 255, 230);
            float var17 = var5;
            float var18 = 15.5F;

            for (int var19 = var10; var19 <= var11; var19++) {
               NumberListSetting.NumberEntry var20 = var2.get(var19);
               FloatSetting var21 = var20.method0537();
               float var22 = var4 + var19 * 16.0F;
               GuiRenderHelper.method1463(var1.method_51448(), var3, var22, var17, var18, 2.0F, var13);
               float var23 = var3 + var17 - 5.0F - 22.0F - 2.0F;
               float var24 = var23 - 88.0F;
               float var25 = var22 + (var18 - 3.0F) / 2.0F;
               float var26 = var3 + 5.0F;
               float var27 = var24 - var26 - 4.0F;
               String var28 = var21.method2067();
               String var29 = TextTruncator.method0831(field0834, var28, var27);
               float var30 = var22 + (var18 - field0834.method0530()) / 2.0F;
               GuiRenderHelper.method1491(var1.method_51448(), field0834, var29, var26, var30, var14);
               float var31 = var21.method0492();
               float var32 = this.field1760.getOrDefault(var21, var31);
               var32 = class_3532.method_16439(0.3F, var32, var31);
               this.field1760.put(var21, var32);
               float var33 = (var32 - var21.method1878()) / (var21.method1928() - var21.method1878());
               var33 = Math.clamp(var33, 0.0F, 1.0F);
               float var34 = 88.0F * var33;
               GuiRenderHelper.method0326(var1.method_51448(), var24, var25, 88.0F, 3.0F, 0.5F, var15);
               GuiRenderHelper.method0326(var1.method_51448(), var24, var25, var34, 3.0F, 0.5F, var12);
               GuiRenderHelper.method0326(var1.method_51448(), var24 + var34 - 2.0F, var25 - 0.5F, 4.0F, 4.0F, 1.0F, var16);
               int var35 = Math.max(1, (int)Math.ceil(-Math.log10(var21.method1697())));
               String var36 = String.format(Locale.US, "%." + var35 + "f", var32);
               float var37 = var3 + var17 - 5.0F - field0392.method0998(var36);
               float var38 = var22 + (var18 - field0392.method0530()) / 2.0F;
               GuiRenderHelper.method1491(var1.method_51448(), field0392, var36, var37, var38, var14);
            }
         }
      }
   }

   private void method0611(double var1) {
      if (this.field1593 != null) {
         float var3 = this.field1577;
         float var4 = this.field1601;
         if (!(var4 <= var3)) {
            float var5 = (float)class_3532.method_15350(var1, var3, var4);
            float var6 = (var5 - var3) / (var4 - var3);
            float var7 = this.field1593.method1878() + var6 * (this.field1593.method1928() - this.field1593.method1878());
            var7 = Math.round(var7 / this.field1593.method1697()) * this.field1593.method1697();
            var7 = Math.clamp(var7, this.field1593.method1878(), this.field1593.method1928());
            this.field1593.method0206(var7);
         }
      }
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      method2228();
      float var6 = this.method0530();
      float var7 = this.method0002();
      if (!MathHelper.method0689(var6, var7, 165.0F, 144.0F, (float)var1, (float)var3)) {
         return false;
      }

      String var8 = method2191();
      float var9 = field0358.method0998(var8);
      float var10 = var9 + 8.0F;
      float var11 = 12.0F;
      float var12 = var6 + 165.0F - var10;
      float var13 = var7 + (10.0F - var11) / 2.0F;
      if (!MathHelper.method0689(var12, var13, var10, var11, (float)var1, (float)var3)) {
         float var24 = var7 + 10.0F + 3.0F;
         if (this.field0535.length() > 0) {
            String var25 = "t";
            float var27 = field1375.method0998(var25);
            float var17 = var6 + 165.0F - var27 - 4.0F;
            float var18 = var24 + (12.0F - field1375.method0530()) / 2.0F;
            if (MathHelper.method0689(var17 - 2.0F, var18 - 1.0F, var27 + 4.0F, field1375.method0530() + 2.0F, (float)var1, (float)var3)) {
               this.field0535.setLength(0);
               this.field0501 = 0.0F;
               this.field1699 = true;
               return true;
            }
         }

         if (MathHelper.method0689(var6, var24, 165.0F, 12.0F, (float)var1, (float)var3)) {
            this.field1699 = true;
            return true;
         }

         this.field1699 = false;
         float var26 = var24 + 12.0F + 3.0F;
         float var28 = 112.0F;
         if (!(var3 < var26) && !(var3 > var26 + var28)) {
            List var29 = this.method2263();
            float var30 = var26 + this.field0547;
            int var19 = (int)Math.floor((var3 - var30) / 16.0);
            if (var19 >= 0 && var19 < var29.size()) {
               NumberListSetting.NumberEntry var20 = var29.get(var19);
               FloatSetting var21 = var20.method0537();
               float var22 = var6 + 165.0F - 5.0F - 22.0F - 2.0F;
               float var23 = var22 - 88.0F;
               if (var1 >= var23 - 4.0F && var1 <= var22 + 4.0F) {
                  this.field1593 = var21;
                  this.field1577 = var23;
                  this.field1601 = var22;
                  this.method0611(var1);
               }

               return true;
            } else {
               return true;
            }
         } else {
            return true;
         }
      } else {
         for (NumberListSetting.NumberEntry var15 : this.field0267.method1889()) {
            FloatSetting var16 = var15.method0537();
            var16.method0578();
            var16.method1973();
         }

         return true;
      }
   }

   @Override
   public boolean method0112(double var1, double var3, int var5) {
      if (this.field1593 != null) {
         this.field1593 = null;
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean method0623(double var1, double var3, double var5, double var7) {
      float var9 = this.method0530();
      float var10 = this.method0002();
      if (!MathHelper.method0689(var9, var10, 165.0F, 144.0F, (float)var1, (float)var3)) {
         return false;
      }

      float var11 = var10 + 10.0F + 3.0F;
      float var12 = var11 + 12.0F + 3.0F;
      float var13 = 112.0F;
      if (var3 >= var12 && var3 <= var12 + var13) {
         List var14 = this.method2263();
         float var15 = var12 + this.field0547;
         int var16 = (int)Math.floor((var3 - var15) / 16.0);
         if (var16 >= 0 && var16 < var14.size()) {
            FloatSetting var17 = var14.get(var16).method0537();
            float var18 = var9 + 165.0F - 5.0F - 22.0F - 2.0F;
            float var19 = var18 - 88.0F;
            if (var1 >= var19 - 4.0F && var1 <= var18 + 22.0F + 4.0F) {
               float var20 = var17.method1697() * (float)var7;
               float var21 = var17.method0492() + var20;
               var21 = Math.round(var21 / var17.method1697()) * var17.method1697();
               var21 = Math.clamp(var21, var17.method1878(), var17.method1928());
               var17.method0206(var21);
               return true;
            }
         }
      }

      this.field0501 += (float)var7 * 15.0F;
      return true;
   }

   @Override
   public boolean method0746(int var1, int var2, int var3) {
      if (!this.field1699) {
         return false;
      } else if (var1 == 259 && this.field0535.length() > 0) {
         this.field0535.deleteCharAt(this.field0535.length() - 1);
         this.field0501 = 0.0F;
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean method0607(char var1, int var2) {
      if (!this.field1699) {
         return false;
      }

      if (!Character.isLetterOrDigit(var1) && var1 != '_' && var1 != ':' && var1 != ' ' && !method0606(var1)) {
         return false;
      }

      this.field0535.append(var1);
      this.field0501 = 0.0F;
      return true;
   }

   private static boolean method0606(char var0) {
      return var0 >= 1024 && var0 <= 1279 || var0 >= 1280 && var0 <= 1327;
   }
}
