package aethereal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.class_1799;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_7923;

public final class BlockListEditor extends GuiElement {
   private static final float field0566 = 104.0F;
   private static final float field0003 = 2.0F;
   private static final float field1410 = 100.0F;
   private static final float field0957 = 8.0F;
   private static final float field0177 = 4.0F;
   private static final float field0458 = 15.0F;
   private static final float field1614 = 3.0F;
   private static final float field1538 = 13.0F;
   private static final float field1704 = 2.0F;
   private static final float field1136 = 4.0F;
   private static final int field1088 = 4;
   private static final int field1197 = 4;
   private static final float field0871 = 1.8F;
   private static final float field0826 = 1.2F;
   private static final float field0910 = 2.0F;
   private static final float field1331 = 96.8F;
   private static final float field1292 = 22.85F;
   private static final float field1369 = 2.5F;
   private static final float field0385 = 12.7960005F;
   private static final float field0351 = 0.79975003F;
   private static final float field0423 = 4.0F;
   private static final float field0255 = 96.8F;
   private static final float field0226 = 147.8F;
   private static final float field0289 = 3.0F;
   private static FontSize field0528;
   private static FontSize field0505;
   private static FontSize field0551;
   private static FontSize field1674;
   private static FontSize field1660;
   private static FontSize field1692;
   private static FontSize field1592;
   private static FontSize field1582;
   private static FontSize field1605;
   private static boolean field1762 = false;
   private final BlockListSetting field1742;
   private final Animation field1769;
   private final Animation field1178 = new Animation(150L, 1.0, false, EasingCurve.field1477);
   private final SearchFieldState field1168 = new SearchFieldState().method1001("Search...");
   private float field1186;
   private float field1119;
   private float field1112;
   private float field1129;
   private float field1227 = 1.0F;
   private List<class_2248> field1224 = new ArrayList<>();
   private List<class_2248> field1238 = new ArrayList<>();
   private String field0901 = null;
   private int field0893 = -1;
   private BlockListEditor.FilterMode field0905 = BlockListEditor.FilterMode.field0066;
   private BlockListEditor.FilterMode field0858 = BlockListEditor.FilterMode.field0066;
   private final Animation field0850 = new Animation(280L, 1.0, false, EasingCurve.field1011);
   private static final long field0865 = 220L;
   private final List<BlockListEditor.BlockEntry> field0943 = new ArrayList<>();
   private static final List<class_2248> field0937 = new ArrayList<>();
   private static final Map<class_2248, String> field0952 = new HashMap<>();
   private static final Map<class_2248, String> field1360 = new HashMap<>();
   private static final Map<class_2248, String> field1354 = new HashMap<>();
   private static final Map<class_2248, class_1799> field1364 = new HashMap<>();

   private static void method2266() {
      if (!field1762) {
         field0528 = Fonts.field0075.method0654(5.5F);
         field0505 = Fonts.field0075.method0654(5.0F);
         field0551 = Fonts.field0075.method0654(5.5F);
         field1674 = Fonts.field0075.method0654(5.0F);
         field1660 = Fonts.field0774.method0654(4.0F);
         field1692 = Fonts.field1718.method0654(5.5F);
         field1592 = Fonts.field0774.method0654(3.0F);
         field1582 = Fonts.field0774.method0654(4.5F);
         field1605 = Fonts.field0774.method0654(4.0F);
         field1762 = true;
      }
   }

   public BlockListEditor(BlockListSetting var1, Supplier<Float> var2) {
      this.field1742 = var1;
      this.field1769 = new Animation(350L, 1.0, false, EasingCurve.field1477);
   }

   @Override
   public float method2047() {
      return 104.0F;
   }

   @Override
   public float method1762() {
      return 147.8F;
   }

   public boolean method1974() {
      return this.field1769.method0376();
   }

   public boolean method0431() {
      return this.field1769.method0346(false);
   }

   public float method0355() {
      return this.field1769.method0002();
   }

   public void method1570(boolean var1) {
      this.field1769.method1570(var1);
      if (!var1) {
         this.field1168.method1570(false);
      }
   }

   public void method0665(float var1) {
      this.field1227 = class_3532.method_15363(var1, 0.0F, 1.0F);
   }

   public void method0498() {
      this.field1168.method1570(false);
   }

   public void method2100(float var1, float var2) {
      this.field1112 = var1;
      this.field1129 = var2;
   }

   public float method2213() {
      return this.field1112;
   }

   public float method2182() {
      return this.field1129;
   }

   private Color method0960(Color var1) {
      return this.field1227 >= 0.99F
         ? var1
         : new Color(var1.getRed(), var1.getGreen(), var1.getBlue(), Math.max(0, Math.min(255, (int)(var1.getAlpha() * this.field1227))));
   }

   private void method1915() {
      String var1 = this.field1168.method1792().toString().toLowerCase(Locale.ROOT);
      int var2 = this.field1742.method1879();
      if (this.field0901 == null || !var1.equals(this.field0901) || var2 != this.field0893) {
         this.field1224.clear();
         this.field1238.clear();

         for (class_2248 var4 : field0937) {
            if (var1.isEmpty() || field0952.get(var4).contains(var1) || field1360.get(var4).contains(var1)) {
               if (this.field1742.method1253(var4)) {
                  this.field1224.add(var4);
               } else {
                  this.field1238.add(var4);
               }
            }
         }

         this.field0901 = var1;
         this.field0893 = var2;
      }
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method2266();
      this.field1119 = class_3532.method_16439(0.1F, this.field1119, this.field1186);
      float var5 = this.method0530() + 2.0F;
      float var6 = this.method0002();
      this.method1915();
      int var7 = this.field1742.method0492().size();
      int var8 = field0937.size();
      this.method1407(var1, var5, var6, 100.0F, var7, var8, var2, var3);
      float var9 = var6 + 8.0F + 4.0F;
      this.method0314(var1, var5, var9, 100.0F, var2, var3);
      float var10 = var9 + 15.0F + 3.0F;
      this.method1403(var1, var5, var10, 100.0F);
      float var11 = var10 + 13.0F + 4.0F;
      this.method1402(var1, var5, var11);
   }

   private void method1407(class_332 var1, float var2, float var3, float var4, int var5, int var6, int var7, int var8) {
      Color var9 = ThemePalette.field1514.get();
      Color var10 = this.method0960(new Color(var9.getRed(), var9.getGreen(), var9.getBlue(), 255));
      String var11 = this.field1742.method1911() != null ? this.field1742.method1911().method1935() : null;
      FontSize var12 = var11 != null ? field1692 : field1660;
      String var13 = var11 != null ? var11 : "h";
      float var14 = var12.method0998(var13);
      float var15 = var3 + (8.0F - var12.method0530()) / 2.0F - 0.5F;
      GuiRenderHelper.method1491(var1.method_51448(), var12, var13, var2, var15, var10);
      float var16 = field1605.method0998("F");
      float var17 = var2 + var4 - var16;
      float var18 = var3 + (8.0F - field1605.method0530()) / 2.0F - 0.5F;
      this.method1406(var1, var17, var18, var16, var7, var8);
      String var19 = var5 + " / " + var6;
      float var20 = field1674.method0998(var19);
      float var21 = var17 - var20 - 4.0F;
      float var22 = var3 + (8.0F - field1674.method0530()) / 2.0F;
      Color var23 = this.method0960(new Color(1157627903, true));
      GuiRenderHelper.method1491(var1.method_51448(), field1674, var19, var21, var22, var23);
      float var24 = var2 + var14 + 2.0F;
      float var25 = var21 - var24 - 3.0F;
      String var26 = this.field1742.method2067();
      String var27 = TextTruncator.method0831(field0551, var26, var25);
      float var28 = var3 + (8.0F - field0551.method0530()) / 2.0F;
      Color var29 = this.method0960(new Color(-591873, true));
      GuiRenderHelper.method1491(var1.method_51448(), field0551, var27, var24, var28, var29);
   }

   private void method1406(class_332 var1, float var2, float var3, float var4, int var5, int var6) {
      float var7 = field1605.method0530();
      boolean var8 = this.field1769.method0002() > 0.5F && MathHelper.method0689(var2 - 3.0F, var3 - 3.0F, var4 + 6.0F, var7 + 6.0F, var5, var6);
      if (this.field1178.method0376() != var8) {
         this.field1178.method1570(var8);
      }

      float var9 = this.field1178.method0002();
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
      GuiRenderHelper.method1491(var1.method_51448(), field1605, "F", var2, var3, var14);
      var1.method_51448().method_22909();
   }

   private boolean method0616(double var1, double var3) {
      float var5 = field1605.method0998("F");
      float var6 = field1605.method0530();
      float var7 = this.method0530() + 2.0F + 100.0F - var5;
      float var8 = this.method0002() + (8.0F - var6) / 2.0F - 0.5F;
      return MathHelper.method0689(var7 - 3.0F, var8 - 3.0F, var5 + 6.0F, var6 + 6.0F, (float)var1, (float)var3);
   }

   private void method0314(class_332 var1, float var2, float var3, float var4, int var5, int var6) {
      Color var7 = this.method0960(new Color(183957503, true));
      GuiRenderHelper.method1463(var1.method_51448(), var2, var3, var4, 15.0F, 3.0F, var7);
      boolean var8 = !this.field1168.method1792().isEmpty();
      boolean var9 = this.field1168.method0579();
      boolean var10 = var8 || var9;
      String var11 = this.field1168.method1792().toString();
      String var12 = var8 ? var11 : (var9 ? "" : "Search...");
      Color var13 = this.method0960(var8 ? ThemePalette.field1268 : ThemePalette.field0486);
      float var14 = var2 + 5.0F;
      float var15 = var3 + (15.0F - field0505.method0530()) / 2.0F;
      float var16 = var10 ? field1592.method0998("t") + 6.0F : 0.0F;
      GuiRenderHelper.method1404(var1, var2 + 4.0F, var3, var4 - 8.0F - var16, 15.0F);
      if (var9 && this.field1168.method0026() && var8) {
         Color var17 = ThemePalette.field1514.get();
         float var18 = field0505.method0998(var11);
         float var19 = field0505.method0530();
         float var20 = var14 - 1.0F;
         float var21 = var15 - 1.0F;
         float var22 = var18 + 2.0F;
         float var23 = var19 + 2.0F;
         Color var24 = this.method0960(new Color(var17.getRed(), var17.getGreen(), var17.getBlue(), 90));
         GuiRenderHelper.method0326(var1.method_51448(), var20, var21, var22, var23, 1.5F, var24);
      }

      GuiRenderHelper.method1491(var1.method_51448(), field0505, var12, var14, var15, var13);
      if (var9 && !this.field1168.method0026()) {
         float var25 = var14 + field0505.method0998(var11) + 0.5F;
         float var27 = (float)(0.5 + 0.5 * Math.sin(System.currentTimeMillis() / 150.0));
         Color var29 = this.method0960(new Color(255, 255, 255, (int)(255.0F * var27)));
         float var31 = 6.8181815F;
         float var33 = var3 + (15.0F - var31) / 2.0F;
         GuiRenderHelper.method0326(var1.method_51448(), var25, var33, 0.6F, var31, 0.3F, var29);
      }

      GuiRenderHelper.method1400(var1);
      if (var10) {
         String var26 = "t";
         float var28 = field1592.method0998(var26);
         float var30 = var2 + var4 - var28 - 4.0F;
         float var32 = var3 + (15.0F - field1592.method0530()) / 2.0F;
         boolean var34 = MathHelper.method0689(var30 - 2.0F, var32 - 1.0F, var28 + 4.0F, field1592.method0530() + 2.0F, var5, var6);
         int var35 = var34 ? 72 : 48;
         Color var36 = this.method0960(new Color((int)(2.55F * var35) << 24 | 11184810, true));
         GuiRenderHelper.method1491(var1.method_51448(), field1592, var26, var30, var32, var36);
      }
   }

   private void method1403(class_332 var1, float var2, float var3, float var4) {
      float var5 = (var4 - 2.0F) / 2.0F;
      this.method1410(var1, var2, var3, var5, "Active", this.field0905 == BlockListEditor.FilterMode.field0632);
      this.method1410(var1, var2 + var5 + 2.0F, var3, var5, "All", this.field0905 == BlockListEditor.FilterMode.field0066);
   }

   private void method1410(class_332 var1, float var2, float var3, float var4, String var5, boolean var6) {
      Color var7 = ThemePalette.field1514.get();
      Color var8;
      if (var6) {
         var8 = this.method0960(new Color(var7.getRed(), var7.getGreen(), var7.getBlue(), 255));
      } else {
         var8 = this.method0960(new Color(183957503, true));
      }

      GuiRenderHelper.method1463(var1.method_51448(), var2, var3, var4, 13.0F, 3.0F, var8);
      Color var9 = var6 ? this.method0960(new Color(255, 255, 255, 255)) : this.method0960(ThemePalette.field0207);
      float var10 = field0505.method0998(var5);
      if (var6) {
         float var11 = field1582.method0998("q");
         float var12 = 2.5F;
         float var13 = var11 + var12 + var10;
         float var14 = var2 + (var4 - var13) / 2.0F;
         float var15 = var3 + (13.0F - field1582.method0530()) / 2.0F - 0.3F;
         GuiRenderHelper.method1491(var1.method_51448(), field1582, "q", var14, var15, var9);
         float var16 = var3 + (13.0F - field0505.method0530()) / 2.0F;
         GuiRenderHelper.method1491(var1.method_51448(), field0505, var5, var14 + var11 + var12, var16, var9);
      } else {
         float var17 = var2 + (var4 - var10) / 2.0F;
         float var18 = var3 + (13.0F - field0505.method0530()) / 2.0F;
         GuiRenderHelper.method1491(var1.method_51448(), field0505, var5, var17, var18, var9);
      }
   }

   private void method1402(class_332 var1, float var2, float var3) {
      List var4 = this.field0905 == BlockListEditor.FilterMode.field0632 ? this.field1224 : this.field1238;
      int var5 = (var4.size() + 4 - 1) / 4;
      float var6 = var5 == 0 ? 0.0F : var5 * 22.85F + (var5 - 1) * 1.8F;
      float var7 = Math.min(0.0F, 96.8F - var6);
      this.field1186 = class_3532.method_15363(this.field1186, var7, 0.0F);
      GuiRenderHelper.method1404(var1, var2, var3, 96.8F, 96.8F);
      float var8 = this.field0850.method0002();
      boolean var9 = this.field0850.method0376() && var8 < 0.999F;
      if (var9) {
         boolean var10 = this.field0905 == BlockListEditor.FilterMode.field0066 && this.field0858 == BlockListEditor.FilterMode.field0632;
         float var11 = var10 ? 1.0F : -1.0F;
         float var12 = var11 * 96.8F * (1.0F - var8);
         float var13 = -var11 * 96.8F * var8;
         List var14 = this.field0858 == BlockListEditor.FilterMode.field0632 ? this.field1224 : this.field1238;
         this.method1430(var1, var14, var2 + var13, var3, true);
         this.method1430(var1, var4, var2 + var12, var3, false);
      } else {
         this.method1430(var1, var4, var2, var3, false);
      }

      if (!this.field0943.isEmpty()) {
         Color var16 = ThemePalette.field1514.get();

         for (int var17 = this.field0943.size() - 1; var17 >= 0; var17--) {
            BlockListEditor.BlockEntry var18 = this.field0943.get(var17);
            float var19 = var18.field0775.method0002();
            if (var19 <= 0.01F) {
               this.field0943.remove(var17);
            } else {
               int var20 = (int)(160.0F * var19);
               Color var15 = this.method0960(new Color(var16.getRed(), var16.getGreen(), var16.getBlue(), var20));
               GuiRenderHelper.method1463(var1.method_51448(), var18.field0566, var18.field0003, var18.field1410, var18.field0957, 2.5F, var15);
            }
         }
      }

      GuiRenderHelper.method1400(var1);
      this.method0311(var1, var2 + 96.8F + 2.0F, var3, var6);
   }

   private void method1430(class_332 var1, List<class_2248> var2, float var3, float var4, boolean var5) {
      if (!var2.isEmpty()) {
         int var6 = (var2.size() + 4 - 1) / 4;
         float var7 = var4 + (var5 ? 0.0F : this.field1119);
         int var8 = Math.max(0, (int)((var4 - var7) / 24.65F));
         int var9 = Math.min(var6 - 1, (int)((var4 + 96.8F - var7) / 24.65F));
         Color var10 = this.method0960(new Color(100663295, true));
         Color var11 = this.method0960(new Color(268435455, true));
         Color var12 = ThemePalette.field1514.get();
         Color var13 = this.method0960(new Color(var12.getRed(), var12.getGreen(), var12.getBlue(), 200));

         for (int var14 = var8; var14 <= var9; var14++) {
            for (int var15 = 0; var15 < 4; var15++) {
               int var16 = var14 * 4 + var15;
               if (var16 >= var2.size()) {
                  break;
               }

               class_2248 var17 = var2.get(var16);
               float var18 = var3 + var15 * 24.65F;
               float var19 = var7 + var14 * 24.65F;
               Color var20 = (var14 + var15 & 1) == 0 ? var10 : var11;
               GuiRenderHelper.method1463(var1.method_51448(), var18, var19, 22.85F, 22.85F, 2.5F, var20);
               boolean var21 = this.field1742.method1253(var17);
               if (var21) {
                  GuiRenderHelper.method1461(var1.method_51448(), var18, var19, 22.85F, 22.85F, 2.5F, 0.5F, 0.5F, var13);
               }

               class_1799 var22 = field1364.get(var17);
               if (var22 != null && this.field1227 > 0.85F) {
                  var1.method_51448().method_22903();
                  float var23 = var18 + 5.027F;
                  float var24 = var19 + 5.027F;
                  var1.method_51448().method_46416(var23, var24, 0.0F);
                  var1.method_51448().method_22905(0.79975003F, 0.79975003F, 1.0F);
                  var1.method_51427(var22, 0, 0);
                  var1.method_51448().method_22909();
               }
            }
         }
      }
   }

   private void method0311(class_332 var1, float var2, float var3, float var4) {
      Color var5 = this.method0960(new Color(183957503, true));
      GuiRenderHelper.method0326(var1.method_51448(), var2, var3, 1.2F, 96.8F, 0.6F, var5);
      if (!(var4 <= 96.8F)) {
         float var6 = Math.max(8.0F, 96.8F * (96.8F / var4));
         float var7 = 96.8F - var6;
         float var8 = var4 - 96.8F;
         float var9 = var8 <= 1.0E-4F ? 0.0F : -this.field1119 / var8;
         var9 = class_3532.method_15363(var9, 0.0F, 1.0F);
         float var10 = var3 + var9 * var7;
         Color var11 = this.method0960(new Color(1039595519, true));
         GuiRenderHelper.method0326(var1.method_51448(), var2, var10, 1.2F, var6, 0.6F, var11);
      }
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      float var6 = this.method0530();
      float var7 = this.method0002();
      if (!MathHelper.method0689(var6, var7, 104.0F, 147.8F, (float)var1, (float)var3)) {
         return false;
      }

      if (var5 == 0 && this.method0616(var1, var3)) {
         BlockListSettingWidget.method1973();
         return true;
      }

      float var8 = var6 + 2.0F;
      float var9 = var7 + 8.0F + 4.0F;
      boolean var10 = !this.field1168.method1792().isEmpty() || this.field1168.method0579();
      if (var10) {
         String var11 = "t";
         float var12 = field1592.method0998(var11);
         float var13 = var8 + 100.0F - var12 - 4.0F;
         float var14 = var9 + (15.0F - field1592.method0530()) / 2.0F;
         if (MathHelper.method0689(var13 - 2.0F, var14 - 1.0F, var12 + 4.0F, field1592.method0530() + 2.0F, (float)var1, (float)var3)) {
            if (!this.field1168.method1792().isEmpty()) {
               this.field1168.method1792().setLength(0);
               this.field1168.method2078();
               this.field1186 = 0.0F;
            } else {
               this.field1168.method1570(false);
            }

            return true;
         }
      }

      if (MathHelper.method0689(var8, var9, 100.0F, 15.0F, (float)var1, (float)var3)) {
         this.field1168.method1570(true);
         this.field1168.method2078();
         ClickGuiScreen var23 = ClickGuiScreen.method1904();
         if (var23 != null && var23.method1775() != null) {
            var23.method1775().method1951().method1570(false);
         }

         return true;
      } else {
         this.field1168.method1570(false);
         this.field1168.method2078();
         float var22 = var9 + 15.0F + 3.0F;
         float var24 = 49.0F;
         if (MathHelper.method0689(var8, var22, var24, 13.0F, (float)var1, (float)var3)) {
            this.method0842(BlockListEditor.FilterMode.field0632);
            return true;
         }

         if (MathHelper.method0689(var8 + var24 + 2.0F, var22, var24, 13.0F, (float)var1, (float)var3)) {
            this.method0842(BlockListEditor.FilterMode.field0066);
            return true;
         }

         float var25 = var22 + 13.0F + 4.0F;
         if (var3 < var25 || var3 > var25 + 96.8F) {
            return true;
         }

         if (!(var1 < var8) && !(var1 > var8 + 96.8F)) {
            this.method1915();
            List var26 = this.field0905 == BlockListEditor.FilterMode.field0632 ? this.field1224 : this.field1238;
            float var15 = var25 + this.field1119;
            int var16 = (int)Math.floor((var3 - var15) / 24.65F);
            int var17 = (int)Math.floor((var1 - var8) / 24.65F);
            if (var16 >= 0 && var17 >= 0 && var17 < 4) {
               float var18 = var8 + var17 * 24.65F;
               float var19 = var15 + var16 * 24.65F;
               if (var1 > var18 + 22.85F) {
                  return true;
               }

               if (var3 > var19 + 22.85F) {
                  return true;
               }

               int var20 = var16 * 4 + var17;
               if (var20 >= var26.size()) {
                  return true;
               }

               class_2248 var21 = var26.get(var20);
               this.method0686(var18, var19, 22.85F, 22.85F);
               this.field1742.method1861(var21);
               return true;
            } else {
               return true;
            }
         } else {
            return true;
         }
      }
   }

   private void method0842(BlockListEditor.FilterMode var1) {
      if (this.field0905 != var1) {
         this.field0858 = this.field0905;
         this.field0905 = var1;
         this.field0850.method1570(false);
         this.field0850.method1634();
         this.field0850.method1570(true);
         this.field1186 = 0.0F;
         this.field1119 = 0.0F;
      }
   }

   private void method0686(float var1, float var2, float var3, float var4) {
      Animation var5 = new Animation(220L, 1.0, false, EasingCurve.field0203);
      var5.method1634();
      this.field0943.add(new BlockListEditor.BlockEntry(var1, var2, var3, var4, var5));
   }

   @Override
   public boolean method0623(double var1, double var3, double var5, double var7) {
      if (MathHelper.method0689(this.method0530(), this.method0002(), 104.0F, 147.8F, (float)var1, (float)var3)) {
         this.field1186 += (float)var7 * 14.0F;
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean method0746(int var1, int var2, int var3) {
      if (!this.field1168.method0579()) {
         return false;
      }

      boolean var4 = this.field1168.method0746(var1, var2, var3);
      if (var4) {
         this.field1186 = 0.0F;
      }

      return var4;
   }

   @Override
   public boolean method0607(char var1, int var2) {
      if (!this.field1168.method0579()) {
         return false;
      }

      boolean var3 = this.field1168.method0607(var1, var2);
      if (var3) {
         this.field1186 = 0.0F;
      }

      return var3;
   }

   static {
      for (class_2248 var1 : class_7923.field_41175) {
         class_1799 var2 = new class_1799(var1);
         if (!var2.method_7960() && var1 != class_2246.field_10124) {
            String var3 = var1.method_9518().getString();
            field0937.add(var1);
            field1354.put(var1, var3);
            field0952.put(var1, var3.toLowerCase(Locale.ROOT));
            field1360.put(var1, class_7923.field_41175.method_10221(var1).toString().toLowerCase(Locale.ROOT));
            field1364.put(var1, var2);
         }
      }
   }

   private static final class BlockEntry {
      final float field0566;
      final float field0003;
      final float field1410;
      final float field0957;
      final Animation field0775;

      BlockEntry(float var1, float var2, float var3, float var4, Animation var5) {
         this.field0566 = var1;
         this.field0003 = var2;
         this.field1410 = var3;
         this.field0957 = var4;
         this.field0775 = var5;
      }
   }

   private enum FilterMode {
      field0632,
      field0066;
   }
}
