package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_4587;
import net.minecraft.class_490;
import net.minecraft.class_746;

public class CustomizationScreen extends class_437 implements MinecraftAccess {
   private static final float field0003 = 320.0F;
   private static final float field1410 = 200.0F;
   private static final float field0957 = 8.0F;
   private static final float field0177 = 8.0F;
   private static final float field0458 = 20.0F;
   private static final float field1614 = 17.0F;
   private static final float field1538 = 8.0F;
   private static final float field1704 = 4.0F;
   private static final float field1136 = 6.0F;
   private static final float field1087 = 6.0F;
   private static FontSize field1205;
   private static FontSize field0879;
   private static FontSize field0834;
   private static FontSize field0917;
   private static FontSize field1339;
   private static FontSize field1300;
   private static FontSize field1375;
   private static FontSize field0392;
   private static boolean field0369 = false;
   private final Animation field0434 = new Animation(220L, 1.0, true, EasingCurve.field1011);
   private final Animation field0264 = new Animation(200L, 1.0, false, EasingCurve.field1011);
   private final Map<EspTargetType, Animation> field0239 = new EnumMap<>(EspTargetType.class);
   private final Map<EspDisplayMode, Animation> field0301 = new EnumMap<>(EspDisplayMode.class);
   private final List<CustomizationScreen.PreviewPanel> field0536 = new ArrayList<>();
   private final PopupManager field0507;
   private boolean field0558 = false;
   private long field1673 = -1L;
   private float field1657 = 0.0F;
   private float field1688 = 0.0F;
   private float field1590 = 0.0F;
   private float field1577 = 0.0F;
   private float field1601 = 0.0F;
   private float field1753 = 0.0F;
   private float field1739 = 0.0F;
   private float field1766 = 0.0F;
   private float field1174 = 0.0F;
   private float field1164 = 0.0F;
   private float field1186 = 0.0F;
   public static CustomizationScreen.CustomizationTab field0623 = CustomizationScreen.CustomizationTab.field0623;

   private static void method0578() {
      if (!field0369) {
         field1205 = Fonts.field0075.method0654(7.0F);
         field0879 = Fonts.field0075.method0654(6.0F);
         field0834 = Fonts.field0774.method0654(6.0F);
         field0917 = Fonts.field0075.method0654(7.0F);
         field1339 = Fonts.field0075.method0654(6.0F);
         field1300 = Fonts.field0075.method0654(6.0F);
         field1375 = Fonts.field0075.method0654(6.0F);
         field0392 = Fonts.field0774.method0654(5.0F);
         field0369 = true;
      }
   }

   public CustomizationScreen() {
      super(class_2561.method_43470("customization"));

      for (EspTargetType var4 : EspTargetType.values()) {
         Animation var5 = new Animation(180L, 1.0, var4 == Customization.field1475, EasingCurve.field1011);
         this.field0239.put(var4, var5);
      }

      for (EspDisplayMode var9 : EspDisplayMode.values()) {
         Animation var10 = new Animation(180L, 1.0, var9 == Customization.field1008, EasingCurve.field1011);
         this.field0301.put(var9, var10);
      }

      this.field0507 = PopupManager.method0416() != null ? PopupManager.method0416() : new PopupManager();
      Customization.field0169 = true;
      this.method0025();
   }

   private void method0025() {
      this.field0536.clear();

      for (Class var2 : this.method0900(Customization.field1475, Customization.field1008)) {
         Module var3 = DaamkyClient.method2004().method1783().method0976(var2);
         if (var3 != null) {
            VisibleBooleanSetting var4 = new VisibleBooleanSetting("customization.toggle." + var3.method0423().toLowerCase(), var2);
            var4.method1846(var3.method0423());
            var4.method1656(var3.method0557());
            SettingWidget var5 = SettingWidgetFactory.method0866(this.field0264, var4);
            if (var5 != null) {
               List var6 = new ArrayList<>();

               for (Setting var8 : var3.method1914()) {
                  SettingWidget var9 = SettingWidgetFactory.method0866(this.field0264, var8);
                  if (var9 != null) {
                     var6.add(var9);
                  }
               }

               this.field0536.add(new CustomizationScreen.PreviewPanel(var3, var4, var5, var6));
            }
         }
      }

      this.field0264.method1570(true);
      this.field0264.method1634();
      this.field1657 = 0.0F;
      this.field1688 = 0.0F;
   }

   private List<Class<? extends Module>> method0900(EspTargetType var1, EspDisplayMode var2) {
      return var1 == EspTargetType.field0670 && var2 == EspDisplayMode.field0669 ? Arrays.asList(NameTags.class, Chams.class) : List.of();
   }

   private float method0645(float var1) {
      float var2 = Math.max(220.0F, var1 - 40.0F);
      return Math.min(380.0F, var2);
   }

   private float method0826(CustomizationScreen.PreviewPanel var1, float var2) {
      float var3 = 16.0F;
      var1.field1454.method0126(var2 - 16.0F, -1.0F);
      var3 += var1.field1454.method1762();
      boolean var4 = var1.field0660.method2195();
      if (var4) {
         boolean var5 = true;

         for (SettingWidget var7 : var1.field1032) {
            if (var7.method0366().method0026()) {
               var7.method0126(var2 - 16.0F, -1.0F);
               var3 += 6.0F + var7.method1762();
               var5 = false;
            }
         }
      }

      return var3;
   }

   private float method0115(float var1) {
      float var2 = 0.0F;
      boolean var3 = true;

      for (CustomizationScreen.PreviewPanel var5 : this.field0536) {
         if (!var3) {
            var2 += 4.0F;
         }

         var2 += this.method0826(var5, var1);
         var3 = false;
      }

      return var2;
   }

   public void method_25394(class_332 var1, int var2, int var3, float var4) {
      method0578();
      if (this.field0558 && this.field1673 > 0L && System.currentTimeMillis() - this.field1673 > 250L) {
         field0796.method_1507(null);
      } else {
         super.method_25394(var1, var2, var3, var4);
         float var5 = ScreenLayoutHelper.method0002();
         int var6 = (int)(var2 / var5);
         int var7 = (int)(var3 / var5);
         var1.method_51448().method_22903();
         var1.method_51448().method_22905(var5, var5, 1.0F);
         class_4587 var8 = var1.method_51448();
         float var9 = ScreenLayoutHelper.method2047();
         float var10 = ScreenLayoutHelper.method1762();
         float var11 = this.method0645(var10);
         float var12 = 528.0F;
         float var13 = (var9 - var12) / 2.0F;
         float var14 = (var10 - var11) / 2.0F;
         float var15 = var13 + 320.0F + 8.0F;
         float var16 = var14;
         float var17 = var11;
         float var18 = this.field0434.method0002();
         if (this.field0558) {
            var18 = Math.max(0.0F, var18 - (float)(System.currentTimeMillis() - this.field1673) / 250.0F);
         }

         RenderSystem.enableBlend();
         GuiRenderHelper.method1463(var8, 0.0F, 0.0F, var9, var10, 0.0F, new Color(0, 0, 0, (int)(40.0F * var18)));
         if (var18 < 0.01F) {
            var1.method_51448().method_22909();
         } else {
            var8.method_22903();
            float var19 = var13 + var12 / 2.0F;
            float var20 = var14 + var11 / 2.0F;
            float var21 = 0.94F + 0.06F * var18;
            var8.method_46416(var19, var20, 0.0F);
            var8.method_22905(var21, var21, 1.0F);
            var8.method_46416(-var19, -var20, 0.0F);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var18);
            this.method1435(var1, var8, var13, var14, var11, var6, var7, var4);
            this.method1433(var1, var8, var15, var16, 200.0F, var17, var6, var7);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            var8.method_22909();
            if (this.field0507 != null) {
               this.field0507.method1414(var1, var6, var7, var4);
            }

            var1.method_51448().method_22909();
         }
      }
   }

   private void method1435(class_332 var1, class_4587 var2, float var3, float var4, float var5, int var6, int var7, float var8) {
      GuiRenderHelper.method1462(var2, var3, var4, 320.0F, var5, 8.0F, ThemePalette.field0367.get(), ThemePalette.field0134);
      GuiRenderHelper.method0326(var2, var3, var4, 320.0F, var5, 8.0F, ThemePalette.field0930.get());
      GuiRenderHelper.method1461(var2, var3, var4, 320.0F, var5, 8.0F, 0.5F, 0.5F, ThemePalette.field0884);
      float var9 = var3 + 8.0F;
      float var10 = var4 + 8.0F;
      float var11 = 304.0F;
      this.method1470(var2, var9, var10, var11, 20.0F, var6, var7);
      float var12 = var10 + 20.0F + 6.0F;
      this.method0329(var2, var9, var12, var11, 17.0F, var6, var7);
      float var13 = var12 + 17.0F + 6.0F;
      float var14 = var4 + var5 - 8.0F - var13;
      if (var14 < 60.0F) {
         var14 = 60.0F;
      }

      float var15 = this.method0115(var11);
      float var16 = Math.max(0.0F, var15 - var14);
      if (this.field1657 > var16) {
         this.field1657 = var16;
      }

      if (this.field1657 < 0.0F) {
         this.field1657 = 0.0F;
      }

      this.field1688 = this.field1688 + (this.field1657 - this.field1688) * 0.18F;
      if (Math.abs(this.field1688 - this.field1657) < 0.05F) {
         this.field1688 = this.field1657;
      }

      this.field1590 = var9;
      this.field1577 = var13;
      this.field1601 = var11;
      this.field1753 = var14;
      this.field1739 = var15;
      GuiRenderHelper.method0312(var1, var9, var13, var11, var14);

      try {
         float var17 = var13 - this.field1688;
         boolean var18 = true;

         for (CustomizationScreen.PreviewPanel var20 : this.field0536) {
            if (!var18) {
               var17 += 4.0F;
            }

            var17 += this.method1436(var1, var2, var20, var9, var17, var11, var6, var7, var8);
            var18 = false;
         }

         if (this.field0536.isEmpty()) {
            FontSize var28 = Fonts.field0075.method0654(6.0F);
            String var30 = "No modules in this section";
            float var21 = var28.method0998(var30);
            Color var22 = new Color(246, 247, 255, 90);
            GuiRenderHelper.method1491(var2, var28, var30, var9 + (var11 - var21) / 2.0F, var13 + var14 / 2.0F - var28.method0530() / 2.0F, var22);
         }
      } finally {
         GuiRenderHelper.method1400(var1);
      }

      if (var16 > 0.0F) {
         float var26 = 1.5F;
         float var27 = var9 + var11 - var26 - 1.0F;
         float var29 = var14 * (var14 / var15);
         if (var29 < 16.0F) {
            var29 = 16.0F;
         }

         float var31 = var13 + this.field1688 / var16 * (var14 - var29);
         Color var32 = ThemeColorManager.method1908().method2063();
         GuiRenderHelper.method0326(var2, var27, var31, var26, var29, 0.75F, new Color(var32.getRed(), var32.getGreen(), var32.getBlue(), 140));
      }
   }

   private float method1436(
      class_332 var1, class_4587 var2, CustomizationScreen.PreviewPanel var3, float var4, float var5, float var6, int var7, int var8, float var9
   ) {
      float var10 = this.method0826(var3, var6);
      GuiRenderHelper.method0326(var2, var4, var5, var6, var10, 6.0F, ThemePalette.field1726);
      GuiRenderHelper.method1461(var2, var4, var5, var6, var10, 6.0F, 0.5F, 0.5F, ThemePalette.field1210);
      float var11 = var5 + 8.0F;
      float var12 = var6 - 16.0F;
      var3.field1454.method0670(var4 + 8.0F, var11).method0126(var12, -1.0F);
      var3.field1454.method1414(var1, var7, var8, var9);
      var11 += var3.field1454.method1762();
      if (var3.field0660.method2195()) {
         var11 += 6.0F;
         GuiRenderHelper.method0326(var2, var4 + 8.0F, var11 - 3.0F, var12, 0.5F, 0.0F, ThemePalette.field1564);

         for (SettingWidget var14 : var3.field1032) {
            if (var14.method0366().method0026()) {
               var14.method0670(var4 + 8.0F, var11).method0126(var12, -1.0F);
               var14.method1414(var1, var7, var8, var9);
               var11 += var14.method1762() + 6.0F;
            }
         }
      }

      return var10;
   }

   private void method1433(class_332 var1, class_4587 var2, float var3, float var4, float var5, float var6, int var7, int var8) {
      GuiRenderHelper.method1462(var2, var3, var4, var5, var6, 8.0F, ThemePalette.field0367.get(), ThemePalette.field0134);
      GuiRenderHelper.method0326(var2, var3, var4, var5, var6, 8.0F, ThemePalette.field0930.get());
      GuiRenderHelper.method1461(var2, var3, var4, var5, var6, 8.0F, 0.5F, 0.5F, ThemePalette.field0884);
      float var9 = 6.0F;
      float var10 = 22.0F;
      float var11 = var3 + var9;
      float var12 = var4 + var9;
      float var13 = var5 - var9 * 2.0F;
      GuiRenderHelper.method0326(var2, var11, var12, var13, var10, 6.0F, ThemePalette.field1726);
      GuiRenderHelper.method1461(var2, var11, var12, var13, var10, 6.0F, 0.5F, 0.5F, ThemePalette.field1210);
      String var14 = "t.me/jbdsgn";
      String var15 = "12";
      String var16 = "hp";
      Color var17 = ThemeColorManager.method1908().method2063();
      Color var18 = new Color(246, 247, 255, 255);
      float var19 = field0917.method0998(var14);
      float var20 = field1339.method0998(var15);
      float var21 = field1339.method0998(var16);
      float var22 = 6.0F;
      float var23 = var19 + var22 + var20 + 1.0F + var21;
      float var24 = var11 + (var13 - var23) / 2.0F;
      float var25 = var12 + (var10 - field0917.method0530()) / 2.0F;
      GuiRenderHelper.method1491(var2, field0917, var14, var24, var25, var18);
      float var26 = var24 + var19 + var22;
      float var27 = var12 + (var10 - field1339.method0530()) / 2.0F;
      GuiRenderHelper.method1491(var2, field1339, var15, var26, var27, var17);
      var26 += var20 + 1.0F;
      GuiRenderHelper.method1491(var2, field1339, var16, var26, var27, var17);
      float var28 = var12 + var10 + 26.0F;
      float var29 = var4 + var6 - var9 - 22.0F;
      float var30 = var29 - var28;
      float var31 = var5 - var9 * 4.0F;
      float var32 = var3 + (var5 - var31) / 2.0F;
      Chams var33 = DaamkyClient.method2004().method1783().method0976(Chams.class);
      NameTags var34 = DaamkyClient.method2004().method1783().method0976(NameTags.class);
      boolean var35 = var33 != null && var33.method2195();
      boolean var36 = var34 != null && var34.method2195();
      Color var37 = var35 ? var33.field0049.method1726() : null;
      this.method1434(var1, var2, var32, var28, var31, var30, var7, var8, var37);
      if (var36) {
         this.method1456(var2, var32, var28, var31);
      }

      float var38 = var4 + var6 - var9 - 18.0F;
      float var39 = 72.0F;
      float var40 = var3 + var5 - var9 - var39;
      String var41 = field0623.name();
      boolean var42 = MathHelper.method0689(var40, var38, var39, 18.0F, var7, var8);
      Color var43 = var42 ? new Color(var17.getRed(), var17.getGreen(), var17.getBlue(), 90) : new Color(var17.getRed(), var17.getGreen(), var17.getBlue(), 40);
      Color var44 = new Color(var17.getRed(), var17.getGreen(), var17.getBlue(), var42 ? 200 : 100);
      GuiRenderHelper.method0326(var2, var40, var38, var39, 18.0F, 6.0F, var43);
      GuiRenderHelper.method1461(var2, var40, var38, var39, 18.0F, 6.0F, 0.5F, 0.5F, var44);
      float var45 = field0834.method0998("e") + 4.0F;
      float var46 = field1300.method0998(var41);
      float var47 = var45 + var46;
      float var48 = var40 + (var39 - var47) / 2.0F;
      float var49 = var38 + (18.0F - field1300.method0530()) / 2.0F;
      float var50 = var38 + (18.0F - field0834.method0530()) / 2.0F;
      GuiRenderHelper.method1491(var2, field0834, "e", var48, var50, var18);
      GuiRenderHelper.method1491(var2, field1300, var41, var48 + var45, var49, var18);
      this.field1766 = var40;
      this.field1174 = var38;
      this.field1164 = var39;
      this.field1186 = 18.0F;
      float var51 = 18.0F;
      float var52 = var3 + var9;
      GuiRenderHelper.method0326(var2, var52, var38, var51, 18.0F, 6.0F, ThemePalette.field1726);
      GuiRenderHelper.method1461(var2, var52, var38, var51, 18.0F, 6.0F, 0.5F, 0.5F, ThemePalette.field1210);
      Color var53 = new Color(246, 247, 255, 124);
      GuiRenderHelper.method1491(
         var2, field0834, "d", var52 + (var51 - field0834.method0998("d")) / 2.0F, var38 + (18.0F - field0834.method0530()) / 2.0F, var53
      );
   }

   private void method1456(class_4587 var1, float var2, float var3, float var4) {
      String var5 = "t.me/jbdsgn";
      String var6 = "12";
      float var7 = 3.0F;
      float var8 = 4.0F;
      float var9 = field0392.method0998("J");
      float var10 = field1375.method0998(var5);
      float var11 = field1375.method0998(var6);
      float var12 = var10 + var8 + var9 + 1.0F + var11;
      float var13 = var12 + var7 * 2.0F + 8.0F;
      float var14 = field1375.method0530() + var7 * 2.0F + 2.0F;
      float var15 = var2 + (var4 - var13) / 2.0F;
      float var16 = var3 - var14 - 4.0F;
      GuiRenderHelper.method0326(var1, var15, var16, var13, var14, 4.0F, ThemePalette.field0930.get());
      GuiRenderHelper.method1461(var1, var15, var16, var13, var14, 4.0F, 0.5F, 0.5F, ThemePalette.field1564);
      Color var17 = new Color(246, 247, 255, 240);
      Color var18 = ThemeColorManager.method1908().method2063();
      float var19 = var15 + (var13 - var12) / 2.0F;
      float var20 = var16 + (var14 - field1375.method0530()) / 2.0F;
      GuiRenderHelper.method1491(var1, field1375, var5, var19, var20, var17);
      var19 += var10 + var8;
      float var21 = var16 + (var14 - field0392.method0530()) / 2.0F;
      GuiRenderHelper.method1491(var1, field0392, "J", var19, var21, var18);
      var19 += var9 + 1.0F;
      GuiRenderHelper.method1491(var1, field1375, var6, var19, var20, var17);
   }

   private void method1434(class_332 var1, class_4587 var2, float var3, float var4, float var5, float var6, int var7, int var8, Color var9) {
      class_746 var10 = class_310.method_1551().field_1724;
      if (var10 == null) {
         FontSize var29 = Fonts.field0075.method0654(6.0F);
         String var30 = "Join a world to see preview";
         float var31 = var29.method0998(var30);
         Color var32 = new Color(246, 247, 255, 100);
         GuiRenderHelper.method1491(var2, var29, var30, var3 + (var5 - var31) / 2.0F, var4 + var6 / 2.0F - var29.method0530() / 2.0F, var32);
      } else {
         int var11 = (int)Math.min(var5, var6) / 2;
         int var12 = (int)var3;
         int var13 = (int)var4;
         int var14 = (int)(var3 + var5);
         int var15 = (int)(var4 + var6);
         float var16 = 1.0F;
         float var17 = 1.0F;
         float var18 = 1.0F;
         if (var9 != null) {
            float var19 = 0.7F;
            var16 = var9.getRed() / 255.0F * var19 + (1.0F - var19);
            var17 = var9.getGreen() / 255.0F * var19 + (1.0F - var19);
            var18 = var9.getBlue() / 255.0F * var19 + (1.0F - var19);
         }

         try {
            if (var9 != null) {
               RenderSystem.setShaderColor(var16, var17, var18, 1.0F);
            }

            class_490.method_2486(var1, var12, var13, var14, var15, var11, 0.0625F, var12 + (var14 - var12) / 2.0F, var13 + (var15 - var13) / 2.0F, var10);
         } catch (Throwable var27) {
            FontSize var20 = Fonts.field0075.method0654(6.0F);
            String var21 = "Preview unavailable";
            float var22 = var20.method0998(var21);
            Color var23 = new Color(246, 247, 255, 100);
            GuiRenderHelper.method1491(var2, var20, var21, var3 + (var5 - var22) / 2.0F, var4 + var6 / 2.0F - var20.method0530() / 2.0F, var23);
         } finally {
            if (var9 != null) {
               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            }
         }
      }
   }

   private void method1470(class_4587 var1, float var2, float var3, float var4, float var5, int var6, int var7) {
      EspTargetType[] var8 = EspTargetType.values();
      int var9 = var8.length;
      float var10 = 4.0F;
      float var11 = (var4 - var10 * (var9 - 1)) / var9;

      for (int var12 = 0; var12 < var9; var12++) {
         EspTargetType var13 = var8[var12];
         float var14 = var2 + var12 * (var11 + var10);
         this.method1472(
            var1, var14, var3, var11, var5, var13.method0017(), var13.method0557(), this.field0239.get(var13).method0002(), var6, var7, field1205, field0834
         );
      }
   }

   private void method0329(class_4587 var1, float var2, float var3, float var4, float var5, int var6, int var7) {
      EspDisplayMode[] var8 = EspDisplayMode.values();
      int var9 = var8.length;
      float var10 = 4.0F;
      float var11 = (var4 - var10 * (var9 - 1)) / var9;

      for (int var12 = 0; var12 < var9; var12++) {
         EspDisplayMode var13 = var8[var12];
         float var14 = var2 + var12 * (var11 + var10);
         this.method1472(var1, var14, var3, var11, var5, null, var13.method0557(), this.field0301.get(var13).method0002(), var6, var7, field0879, null);
      }
   }

   private void method1472(
      class_4587 var1,
      float var2,
      float var3,
      float var4,
      float var5,
      String var6,
      String var7,
      float var8,
      int var9,
      int var10,
      FontSize var11,
      FontSize var12
   ) {
      boolean var13 = MathHelper.method0689(var2, var3, var4, var5, var9, var10);
      Color var14 = ThemeColorManager.method1908().method2063();
      Color var15 = method0712(var8, var13, var14);
      GuiRenderHelper.method0326(var1, var2, var3, var4, var5, 6.0F, var15);
      GuiRenderHelper.method1461(var1, var2, var3, var4, var5, 6.0F, 0.5F, 0.5F, method2097(var8));
      float var16 = var6 != null && var12 != null ? var12.method0998(var6) + 4.0F : 0.0F;
      float var17 = var11.method0998(var7);
      float var18 = var16 + var17;
      float var19 = var2 + (var4 - var18) / 2.0F;
      float var20 = var3 + (var5 - var11.method0530()) / 2.0F;
      Color var21 = method1821(var8);
      if (var6 != null && var12 != null) {
         float var22 = var3 + (var5 - var12.method0530()) / 2.0F;
         GuiRenderHelper.method1491(var1, var12, var6, var19, var22, var21);
         var19 += var16;
      }

      GuiRenderHelper.method1491(var1, var11, var7, var19, var20, var21);
   }

   private static Color method0712(float var0, boolean var1, Color var2) {
      int var3 = var2.getRed();
      int var4 = var2.getGreen();
      int var5 = var2.getBlue();
      int var6 = 255;
      int var7 = var1 ? 10 : 5;
      int var8 = (int)(var7 + (var6 - var7) * var0);
      if (var0 >= 0.99F) {
         return new Color(var3, var4, var5, 255);
      }

      Color var9 = new Color(246, 247, 255, var8);
      return var0 <= 0.01F ? var9 : method0969(var9, new Color(var3, var4, var5, 255), var0);
   }

   private static Color method2097(float var0) {
      int var1 = (int)(10.0F + 6.0F * (1.0F - var0));
      return new Color(246, 247, 255, var1);
   }

   private static Color method1821(float var0) {
      Color var1 = new Color(246, 247, 255, 184);
      Color var2 = new Color(246, 247, 255, 255);
      return method0969(var1, var2, var0);
   }

   private static Color method0969(Color var0, Color var1, float var2) {
      int var3 = (int)(var0.getRed() * (1.0F - var2) + var1.getRed() * var2);
      int var4 = (int)(var0.getGreen() * (1.0F - var2) + var1.getGreen() * var2);
      int var5 = (int)(var0.getBlue() * (1.0F - var2) + var1.getBlue() * var2);
      int var6 = (int)(var0.getAlpha() * (1.0F - var2) + var1.getAlpha() * var2);
      return new Color(method0716(var3), method0716(var4), method0716(var5), method0716(var6));
   }

   private static int method0716(int var0) {
      return var0 < 0 ? 0 : Math.min(var0, 255);
   }

   public boolean method_25402(double var1, double var3, int var5) {
      float var6 = ScreenLayoutHelper.method0002();
      double var7 = var1 / var6;
      double var9 = var3 / var6;
      if (this.field0507 != null && this.field0507.method0627(var7, var9, var5)) {
         return true;
      }

      float var11 = ScreenLayoutHelper.method2047();
      float var12 = ScreenLayoutHelper.method1762();
      float var13 = this.method0645(var12);
      float var14 = 528.0F;
      float var15 = (var11 - var14) / 2.0F;
      float var16 = (var12 - var13) / 2.0F;
      if (var5 == 0) {
         float var17 = var15 + 8.0F;
         float var18 = var16 + 8.0F;
         float var19 = 304.0F;
         EspTargetType[] var20 = EspTargetType.values();
         float var21 = 4.0F;
         float var22 = (var19 - var21 * (var20.length - 1)) / var20.length;

         for (int var23 = 0; var23 < var20.length; var23++) {
            float var24 = var17 + var23 * (var22 + var21);
            if (MathHelper.method0689(var24, var18, var22, 20.0F, (float)var7, (float)var9)) {
               this.method0899(var20[var23]);
               return true;
            }
         }

         float var35 = var18 + 20.0F + 6.0F;
         EspDisplayMode[] var36 = EspDisplayMode.values();
         float var25 = (var19 - var21 * (var36.length - 1)) / var36.length;

         for (int var26 = 0; var26 < var36.length; var26++) {
            float var27 = var17 + var26 * (var25 + var21);
            if (MathHelper.method0689(var27, var35, var25, 17.0F, (float)var7, (float)var9)) {
               this.method0898(var36[var26]);
               return true;
            }
         }
      }

      if (var5 == 0
         && this.field1164 > 0.0F
         && MathHelper.method0689(this.field1766, this.field1174, this.field1164, this.field1186, (float)var7, (float)var9)) {
         field0623 = field0623.method0535();
         return true;
      }

      boolean var28 = MathHelper.method0689(this.field1590, this.field1577, this.field1601, this.field1753, (float)var7, (float)var9);
      if (var28) {
         for (CustomizationScreen.PreviewPanel var31 : this.field0536) {
            if (var31.field1454.method0627(var7, var9, var5)) {
               return true;
            }

            if (var31.field0660.method2195()) {
               for (SettingWidget var34 : var31.field1032) {
                  if (var34.method0366().method0026() && var34.method0627(var7, var9, var5)) {
                     return true;
                  }
               }
            }
         }
      }

      boolean var30 = !MathHelper.method0689(var15, var16, 320.0F, var13, (float)var7, (float)var9);
      boolean var32 = !MathHelper.method0689(var15 + 320.0F + 8.0F, var16, 200.0F, var13, (float)var7, (float)var9);
      if (var30 && var32) {
         this.method_25419();
         return true;
      } else {
         return false;
      }
   }

   private void method0899(EspTargetType var1) {
      if (Customization.field1475 != var1) {
         Animation var2 = this.field0239.get(Customization.field1475);
         if (var2 != null) {
            var2.method1570(false);
         }

         Customization.field1475 = var1;
         Animation var3 = this.field0239.get(var1);
         if (var3 != null) {
            var3.method1570(true);
         }

         this.method0025();
      }
   }

   private void method0898(EspDisplayMode var1) {
      if (Customization.field1008 != var1) {
         Animation var2 = this.field0301.get(Customization.field1008);
         if (var2 != null) {
            var2.method1570(false);
         }

         Customization.field1008 = var1;
         Animation var3 = this.field0301.get(var1);
         if (var3 != null) {
            var3.method1570(true);
         }

         this.method0025();
      }
   }

   public boolean method_25406(double var1, double var3, int var5) {
      float var6 = ScreenLayoutHelper.method0002();
      double var7 = var1 / var6;
      double var9 = var3 / var6;
      NumberSettingWidget.method1973();
      if (this.field0507 != null && this.field0507.method0112(var7, var9, var5)) {
         return true;
      }

      for (CustomizationScreen.PreviewPanel var12 : this.field0536) {
         if (var12.field1454.method0112(var7, var9, var5)) {
            return true;
         }

         for (SettingWidget var14 : var12.field1032) {
            if (var14.method0112(var7, var9, var5)) {
               return true;
            }
         }
      }

      return false;
   }

   public boolean method_25401(double var1, double var3, double var5, double var7) {
      float var9 = ScreenLayoutHelper.method0002();
      double var10 = var1 / var9;
      double var12 = var3 / var9;
      boolean var14 = MathHelper.method0689(this.field1590, this.field1577, this.field1601, this.field1753, (float)var10, (float)var12);
      if (var14) {
         float var15 = Math.max(0.0F, this.field1739 - this.field1753);
         if (var15 > 0.0F) {
            this.field1657 -= (float)var7 * 20.0F;
            if (this.field1657 < 0.0F) {
               this.field1657 = 0.0F;
            }

            if (this.field1657 > var15) {
               this.field1657 = var15;
            }

            return true;
         }
      }

      return false;
   }

   public boolean method_25404(int var1, int var2, int var3) {
      if (var1 == 256) {
         this.method_25419();
         return true;
      }

      for (CustomizationScreen.PreviewPanel var5 : this.field0536) {
         if (var5.field1454.method0746(var1, var2, var3)) {
            return true;
         }

         for (SettingWidget var7 : var5.field1032) {
            if (var7.method0746(var1, var2, var3)) {
               return true;
            }
         }
      }

      return true;
   }

   public boolean method_25400(char var1, int var2) {
      for (CustomizationScreen.PreviewPanel var4 : this.field0536) {
         if (var4.field1454.method0607(var1, var2)) {
            return true;
         }

         for (SettingWidget var6 : var4.field1032) {
            if (var6.method0607(var1, var2)) {
               return true;
            }
         }
      }

      return false;
   }

   public void method_25419() {
      if (!this.field0558) {
         this.field0558 = true;
         this.field1673 = System.currentTimeMillis();
         this.field0434.method1570(false);
         ColorSettingWidget.method1973();
      }
   }

   public void method_25432() {
      super.method_25432();
      Customization.field0169 = false;
      ColorSettingWidget.method0430();
      if (this.field0507 != null) {
         this.field0507.method1620().clear();
      }
   }

   public boolean method_25421() {
      return false;
   }

   private static class PreviewPanel {
      final Module field0660;
      final VisibleBooleanSetting field0132;
      final SettingWidget field1454;
      final List<SettingWidget> field1032;

      PreviewPanel(Module var1, VisibleBooleanSetting var2, SettingWidget var3, List<SettingWidget> var4) {
         this.field0660 = var1;
         this.field0132 = var2;
         this.field1454 = var3;
         this.field1032 = var4;
      }
   }

   public enum CustomizationTab {
      field0623,
      field0054,
      field1445,
      field0980;

      public CustomizationScreen.CustomizationTab method0535() {
         CustomizationScreen.CustomizationTab[] var1 = values();
         return var1[(this.ordinal() + 1) % var1.length];
      }
   }
}
