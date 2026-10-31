package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import net.minecraft.class_10142;
import net.minecraft.class_2561;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_429;
import net.minecraft.class_437;
import net.minecraft.class_4587;
import net.minecraft.class_500;
import net.minecraft.class_526;
import net.minecraft.class_7833;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;

public class MainMenuScreen extends class_437 {
   private static final class_2960 field0738 = class_2960.method_60655("daamky", "textures/glow.png");
   private static final DateTimeFormatter field0138 = DateTimeFormatter.ofPattern("HH:mm");
   private static final DateTimeFormatter field1507 = DateTimeFormatter.ofPattern("dd MMMM yyyy");
   private static final float field0957 = 0.3F;
   private static final float field0758 = 0.1F;
   private static final float field1242 = 0.2F;
   private static final float field0314 = 0.5F;
   private static final float field0177 = 0.08F;
   private static final float field0458 = 0.3F;
   private static final float field1614 = 40.0F;
   private static final float field1538 = 193.0F;
   private static final float field1704 = 115.0F;
   private static final float field1136 = 8.0F;
   private static final float field1087 = -55.0F;
   private Color field1210 = new Color(74, 214, 160);
   private Color field0884 = new Color(30, 5, 50);
   private final DarkVeilRenderer field0832 = new DarkVeilRenderer();
   private final DarkVeilRenderer field0915 = new DarkVeilRenderer();
   private final PanoramaHatRenderer field1336 = new PanoramaHatRenderer();
   private final LightPillarRenderer field1297 = new LightPillarRenderer();
   private final MediaStatusWidget field1380 = new MediaStatusWidget();
   private final ClientContext field0390 = new ClientContext();
   private boolean field0369 = true;
   private float field0423 = 0.0F;
   private float field0255 = 0.0F;
   private int field0227;
   private int field0290;
   private MainMenuCard field0532;
   private MainMenuCard field0509;
   private MainMenuCard field0554;
   private MainMenuCard field1678;
   private static final String[] field1666 = new String[]{
      "A mod-client carefully designed to fit all of your gameplay needs.",
      "Bypass-first architecture with reliable coverage across eighty percent of popular servers.",
      "Every visual element is clean and deeply customizable right out of the box.",
      "Engineered from the ground up for Minecraft 1.21.4 and built to perform."
   };

   public MainMenuScreen() {
      super(class_2561.method_43470("Daamky"));
      this.method0578();
   }

   private void method0578() {
      this.field0832.method0665(0.5F);
      this.field0832.method0124(0.0F);
      this.field0832.method2098(0.07F);
      this.field0832.method1822(0.0F);
      this.field0832.method1638(4.9F);
      this.field0832.method1977(5.0F);
      this.field0832.method0435(0.97F);
      this.field0915.method0665(0.3F);
      this.field0915.method0124(0.0F);
      this.field0915.method2098(0.05F);
      this.field0915.method1822(0.0F);
      this.field0915.method1638(3.0F);
      this.field0915.method1977(3.0F);
      this.field0915.method0435(0.97F);
      this.field0915.method0379(-1.5F);
      this.field0915.method0501(0.5F);
      this.field1336.method0652(0.6F).method0117(5.0F);
      this.field1297
         .method0653(1.0F)
         .method0118(0.003F)
         .method2093(5.9F)
         .method1818(1.9F)
         .method1637(1.8F)
         .method1976(1.0F)
         .method0434(1.0F)
         .method0378(135.0F)
         .method0671(1.5F, 0.0F);
      this.method0025();
   }

   private void method0025() {
      this.field1210 = ThemeColorManager.method1908().method2063();
      int var1 = this.field1210.getRed();
      int var2 = this.field1210.getGreen();
      int var3 = this.field1210.getBlue();
      float[] var4 = Color.RGBtoHSB(var1, var2, var3, null);
      float var5 = Math.min(1.0F, var4[1] + 0.3F);
      int var6 = Color.HSBtoRGB(var4[0], var5, var4[2] * 0.35F);
      int var7 = var6 & 16777215;
      int var8 = Color.HSBtoRGB(var4[0], var5, var4[2] * 0.35F);
      int var9 = var8 & 16777215;
      this.field0832.method0729(var7);
      this.field0915.method0729(var9);
      this.field1297.method0718(var7).method0138(var7);
      int var10 = Color.HSBtoRGB(var4[0], var5, var4[2] * 0.12F);
      Color var11 = new Color(var10);
      this.field0884 = new Color(var11.getRed(), var11.getGreen(), var11.getBlue());
   }

   private void method2078() {
      int var1 = this.field_22787.method_22683().method_4489();
      int var2 = this.field_22787.method_22683().method_4506();
      this.field0227 = var1;
      this.field0290 = var2;
      this.field0832.method0738(var1, var2);
      this.field0915.method0738(var1, var2);
      this.field1336.method0738(var1, var2);
      this.field1297.method0738(var1, var2);
   }

   protected void method_25426() {
      this.method2078();
      this.field1380.method0738(this.field_22789, this.field_22790);
      this.field0532 = new MainMenuCard(
         "SINGLEPLAYER",
         "Embark on solo adventures,\ncreate and explore \ninfinite worlds at your own pace",
         () -> this.field_22787.method_1507(new class_526(this)),
         MainMenuCard.CardStyle.field0643,
         95.0F
      );
      this.field0509 = new MainMenuCard(
         "MULTIPLAYER",
         "Connect with friends and players from around the world,\njoin thrilling multiplayer servers, collaborate on epic builds,\ncompete in exciting minigames, and share unforgettable\nadventures in endless community-driven experiences",
         () -> this.field_22787.method_1507(new class_500(this)),
         MainMenuCard.CardStyle.field0643,
         105.0F
      );
      this.field0554 = new MainMenuCard(
         "SETTINGS",
         "Customize your gaming experience with graphics,\ncontrols, performance, audio settings,\nand accessibility options",
         () -> this.field_22787.method_1507(new class_429(this, this.field_22787.field_1690)),
         MainMenuCard.CardStyle.field0073,
         95.0F
      );
      this.field1678 = new MainMenuCard(
         "QUIT", "Exit the game\nand return to your desktop", () -> this.field_22787.method_1592(), MainMenuCard.CardStyle.field0073, 85.0F
      );
   }

   public void method_25420(class_332 var1, int var2, int var3, float var4) {
      this.method2166(var1);
   }

   public void method_25394(class_332 var1, int var2, int var3, float var4) {
      Fonts.method0578();
      ScreenLayoutHelper.method0738(this.field_22789, this.field_22790);
      int var5 = this.field_22787.method_22683().method_4489();
      int var6 = this.field_22787.method_22683().method_4506();
      if (var5 != this.field0227 || var6 != this.field0290) {
         this.method2078();
      }

      float var7 = ScreenLayoutHelper.method0530();
      this.method0025();
      this.method1634();
      this.method1973();
      super.method_25394(var1, var2, var3, var4);
      float var8 = this.field_22790 / 2.0F - 40.0F * var7 - this.field0423 * this.field_22790;
      float var9 = this.method0645(var8);
      if (var9 > 0.01F) {
         this.method0310(var1, var8, var9);
         this.method2167(var1, var8, var9);
      }

      this.method1671(var1);
      this.method1998(var1);
      this.method1413(var1, var2, var3);
      this.method1868(var1);
   }

   private void method1812() {
      if (this.field0423 > 0.3F) {
         this.field1380.method0578();
      } else {
         this.field1380.method0025();
      }
   }

   private void method1413(class_332 var1, int var2, int var3) {
      if (!(this.field0423 < 0.3F)) {
         float var4 = Math.min(1.0F, (this.field0423 - 0.3F) / 0.4F);
         float var5 = this.method0115(var4);

         try {
            this.field0915.method2232(var5);
         } catch (Exception var7) {
         }

         this.field0532.method1414(var1, var2, var3, var5);
         this.field0509.method1414(var1, var2, var3, var5);
         this.field0554.method1414(var1, var2, var3, var5);
         this.field1678.method1414(var1, var2, var3, var5);
         this.field0532.method1400(var1);
         this.field0509.method1400(var1);
         this.field0554.method1400(var1);
         this.field1678.method1400(var1);
         this.method0309(var1);
         this.method1400(var1);
      }
   }

   private void method1400(class_332 var1) {
      if (!(this.field0423 < 0.3F)) {
         float var2 = ScreenLayoutHelper.method0530();
         float var3 = Math.min(1.0F, (this.field0423 - 0.3F) / 0.5F);
         float var4 = this.method0115(var3);
         FontSize var5 = Fonts.field0075.method0654(5.5F * var2);
         float var6 = 3.0F * var2;
         float var7 = this.field_22790 / 2.0F + 50.0F * var2 - this.field0423 * (this.field_22790 / 2.0F - 100.0F * var2);
         float var8 = 115.0F * var2;
         float var9 = var7 + var8 + 8.0F * var2 + var8;
         float var10 = var9 + 14.0F * var2;
         int var11 = (int)(40.0F * var4);
         Color var12 = new Color(255, 255, 255, var11);

         for (int var13 = 0; var13 < field1666.length; var13++) {
            float var14 = var5.method0998(field1666[var13]);
            float var15 = (this.field_22789 - var14) / 2.0F;
            float var16 = var10 + var13 * (var5.method0530() + var6) + 40.0F;
            GuiRenderHelper.method1491(var1.method_51448(), var5, field1666[var13], var15, var16, var12);
         }
      }
   }

   private void method0309(class_332 var1) {
      if (!(this.field0423 < 0.3F)) {
         float var2 = ScreenLayoutHelper.method0530();
         float var3 = Math.min(1.0F, (this.field0423 - 0.3F) / 0.5F);
         float var4 = this.method0115(var3);
         FontSize var5 = Fonts.field1558.method0654(448.0F * var2);
         String var6 = "A";
         float var7 = var5.method0998(var6);
         float var8 = var5.method0530();
         float var9 = 35.0F * var2;
         float var10 = 80.0F * var2;
         float var11 = var9 - var10 * (1.0F - var4);
         float var12 = this.field_22790 / 2.0F + 50.0F * var2 - this.field0423 * (this.field_22790 / 2.0F - 100.0F * var2);
         float var13 = 115.0F * var2;
         float var14 = var13 * 2.0F + 8.0F * var2;
         float var15 = var12 + (var14 - var8) / 2.0F;
         int var16 = (int)(6.0F * var4);
         Color var17 = new Color(this.field1210.getRed(), this.field1210.getGreen(), this.field1210.getBlue(), var16);
         GuiRenderHelper.method1491(var1.method_51448(), var5, var6, var11 - 60.0F, var15 + 60.0F, var17);
      }
   }

   private void method1634() {
      this.field0423 = class_3532.method_16439(0.1F, this.field0423, this.field0255);
      this.field0423 = class_3532.method_15363(this.field0423, 0.0F, 1.0F);
   }

   private void method1973() {
      float var1 = ScreenLayoutHelper.method0530();
      float var2 = this.field_22790 / 2.0F + 50.0F * var1 - this.field0423 * (this.field_22790 / 2.0F - 100.0F * var1);
      float var3 = this.field_22789 / 2.0F;
      float var4 = 241.0F * var1;
      float var5 = 421.0F * var1;
      float var6 = -117.0F * var1;
      float var7 = var4 + var6 + var5;
      float var8 = var3 - var7 / 2.0F + -55.0F * var1;
      float var9 = 115.0F * var1;
      this.field0532.method0738(this.field_22789, this.field_22790);
      this.field0509.method0738(this.field_22789, this.field_22790);
      this.field0554.method0738(this.field_22789, this.field_22790);
      this.field1678.method0738(this.field_22789, this.field_22790);
      this.field0532.method0686(var8, var2, var4, var9);
      this.field0509.method0686(var8 + var4 + var6, var2, var5, var9);
      float var10 = 206.5F * var1;
      float var11 = var3 - (var10 * 2.0F + var6) / 2.0F + -55.0F * var1;
      this.field0554.method0686(var11, var2 + var9 + 8.0F * var1, var10, var9);
      this.field1678.method0686(var11 + var10 + var6 + 125.0F * var1, var2 + var9 + 8.0F * var1, var10, var9);
   }

   private void method2166(class_332 var1) {
      if (this.field0369) {
         try {
            this.field0832.method0578();
            this.field1297.method0501(1.0F - this.field0423 * 0.5F);
         } catch (Exception var5) {
            this.field0369 = false;
         }
      }

      if (this.field0423 > 0.1F) {
         float var2 = this.method0115(Math.min(1.0F, (this.field0423 - 0.1F) / 0.3F));
         this.field1336.method2098(var2);
      }

      int var6 = (int)(64.0F * (1.0F - this.field0423 * 0.3F));
      var1.method_25294(0, 0, this.field_22789, this.field_22790, var6 << 24);
      if (this.field0423 > 0.2F) {
         float var3 = Math.min(1.0F, (this.field0423 - 0.2F) / 0.5F);
         RenderSystem.enableBlend();
         RenderSystem.defaultBlendFunc();
         GuiRenderHelper.method1466(
            var1.method_51448(),
            0.0F,
            0.0F,
            this.field_22789,
            this.field_22790,
            0.0F,
            field0738,
            new Color(this.field0884.getRed(), this.field0884.getGreen(), this.field0884.getBlue(), (int)(var3 * 200.0F))
         );
         RenderSystem.disableBlend();
      }

      float var7 = this.method0115(class_3532.method_15363(this.field0423, 0.0F, 1.0F));
      float var4 = this.field0423 > 0.3F ? this.method0115(Math.min(1.0F, (this.field0423 - 0.3F) / 0.4F)) : 0.0F;
      this.method1402(var1, var7, var4);
   }

   private void method1402(class_332 var1, float var2, float var3) {
      if (!(var2 <= 0.01F) || !(var3 <= 0.01F)) {
         int var4 = Math.max(0, Math.min(255, (int)(var2 * 170.0F)));
         int var5 = Math.max(0, Math.min(255, (int)(var3 * 170.0F)));
         int var6 = var4 << 24;
         int var7 = var5 << 24;
         int var8 = 0;
         float var9 = this.field_22789 * 0.42F;
         float var10 = this.field_22790 * 0.42F;
         RenderSystem.enableBlend();
         RenderSystem.defaultBlendFunc();
         RenderSystem.setShader(class_10142.field_53876);
         class_287 var11 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1576);
         Matrix4f var12 = var1.method_51448().method_23760().method_23761();
         var11.method_22918(var12, 0.0F, 0.0F, 0.0F).method_39415(var7);
         var11.method_22918(var12, this.field_22789, 0.0F, 0.0F).method_39415(var7);
         var11.method_22918(var12, this.field_22789, var10, 0.0F).method_39415(var8);
         var11.method_22918(var12, 0.0F, var10, 0.0F).method_39415(var8);
         var11.method_22918(var12, 0.0F, this.field_22790 - var10, 0.0F).method_39415(var8);
         var11.method_22918(var12, this.field_22789, this.field_22790 - var10, 0.0F).method_39415(var8);
         var11.method_22918(var12, this.field_22789, this.field_22790, 0.0F).method_39415(var6);
         var11.method_22918(var12, 0.0F, this.field_22790, 0.0F).method_39415(var6);
         var11.method_22918(var12, 0.0F, 0.0F, 0.0F).method_39415(var6);
         var11.method_22918(var12, var9, 0.0F, 0.0F).method_39415(var8);
         var11.method_22918(var12, var9, this.field_22790, 0.0F).method_39415(var8);
         var11.method_22918(var12, 0.0F, this.field_22790, 0.0F).method_39415(var6);
         var11.method_22918(var12, this.field_22789 - var9, 0.0F, 0.0F).method_39415(var8);
         var11.method_22918(var12, this.field_22789, 0.0F, 0.0F).method_39415(var6);
         var11.method_22918(var12, this.field_22789, this.field_22790, 0.0F).method_39415(var6);
         var11.method_22918(var12, this.field_22789 - var9, this.field_22790, 0.0F).method_39415(var8);
         class_286.method_43433(var11.method_60800());
         RenderSystem.disableBlend();
      }
   }

   private void method0310(class_332 var1, float var2, float var3) {
      float var4 = ScreenLayoutHelper.method0530();
      int var5 = (int)(255.0F * var3);
      if (var5 >= 10) {
         LocalDateTime var6 = LocalDateTime.now();
         String var7 = var6.format(field0138);
         String var8 = var6.format(field1507);
         FontSize var9 = Fonts.field0995.method0654(64.0F * var4);
         FontSize var10 = Fonts.field0075.method0654(14.0F * var4);
         float var11 = var9.method0010().method1016(var7, var9.method2047());
         float var12 = var9.method0010().method0645(var9.method2047());
         float var13 = var10.method0010().method1016(var8, var10.method2047());
         float var14 = (this.field_22789 - var11) / 2.0F;
         float var15 = var2;
         float var16 = (this.field_22789 - var13) / 2.0F + 3.0F * var4;
         float var17 = var15 + var12 + 8.0F * var4;

         try {
            Color var18 = new Color(255, 255, 255, var5);
            Color var19 = new Color(255, 255, 255, (int)(var5 * 0.9F));
            if (var15 > -var12) {
               GuiRenderHelper.method1492(var1.method_51448(), var9, var7, var14, var15, var18, 1.5F, var3);
            }

            if (var17 > -var10.method0530()) {
               GuiRenderHelper.method1492(var1.method_51448(), var10, var8, var16, var17, var19, 1.2F, var3);
            }
         } catch (Exception var20) {
         }
      }
   }

   private void method2167(class_332 var1, float var2, float var3) {
      float var4 = ScreenLayoutHelper.method0530();
      int var5 = (int)(185.0F * var3);
      if (var5 >= 10) {
         FontSize var6 = Fonts.field0325.method0654(32.0F * var4);
         FontSize var7 = Fonts.field0075.method0654(18.0F * var4);
         String var8 = "Welcome, ";
         String var9 = this.field0390.method0557() + "!";
         float var10 = var6.method0010().method1016(var8, var6.method2047());
         float var11 = var7.method0010().method1016(var9, var7.method2047());
         float var12 = var6.method0010().method0645(var6.method2047());
         float var13 = var7.method0010().method0645(var7.method2047());
         float var14 = (this.field_22789 - var10 - var11) / 2.0F;
         float var15 = var2 + 110.0F * var4 + var12 - 50.0F * var4;

         try {
            float var16 = (var12 - var13) * 0.6F;
            GuiRenderHelper.method1491(
               var1.method_51448(), var6, var8, var14, var15, new Color(this.field1210.getRed(), this.field1210.getGreen(), this.field1210.getBlue(), var5)
            );
            GuiRenderHelper.method1492(var1.method_51448(), var7, var9, var14 + var10, var15 + var16 - 2.5F * var4, new Color(255, 255, 255, var5), 1.2F, 1.0F);
         } catch (Exception var17) {
         }
      }
   }

   private float method0645(float var1) {
      float var2 = ScreenLayoutHelper.method0530();
      float var3 = class_3532.method_15363((this.field0423 - 0.08F) / 0.22000001F, 0.0F, 1.0F);
      float var4 = 1.0F - this.method0115(var3);
      float var5 = class_3532.method_15363((var1 - 10.0F * var2) / (72.0F * var2), 0.0F, 1.0F);
      float var6 = this.method0115(var5);
      return Math.min(var4, var6);
   }

   private void method1868(class_332 var1) {
      float var2 = ScreenLayoutHelper.method0530();
      float var3 = 12.0F * var2;
      float var4 = 20.0F * var2;
      float var5 = var4 / 2.0F;
      float var6 = 6.0F * var2;
      float var7 = 7.0F * var2;
      float var8 = 8.0F * var2;
      float var9 = 5.0F * var2;
      FontSize var10 = Fonts.field0075.method0654(6.5F * var2);
      FontSize var11 = Fonts.field0075.method0654(5.0F * var2);
      String var12 = this.field0390.method0557();
      String var13 = "UID: " + this.field0390.method2048();
      float var14 = var10.method0998(var12);
      float var15 = var11.method0998(var13);
      float var16 = Math.max(var14, var15);
      float var17 = var4 + var6 + var16 + var8 * 2.0F;
      float var18 = var4 + var9 * 2.0F;
      float var19 = this.field_22789 - var3 - var17;
      float var20 = var3;
      float var21 = Math.min(1.0F, (this.field0423 - 0.3F) / 0.4F);
      float var22 = this.field0423 > 0.3F ? this.method0115(var21) : 0.0F;
      int var23 = (int)(255.0F * var22);
      if (var23 >= 5) {
         float var24 = var23 / 255.0F;
         class_4587 var25 = var1.method_51448();
         Color var26 = new Color(21, 21, 21, (int)(214.0F * var24));
         Color var27 = new Color(246, 247, 255, (int)(5.0F * var24));
         GuiRenderHelper.method0325(var25, var19, var20, var17, var18, var7, 6.0F * var2, new Color(255, 255, 255, var23));
         GuiRenderHelper.method1463(var25, var19, var20, var17, var18, var7, var26);
         GuiRenderHelper.method1461(var25, var19, var20, var17, var18, var7, 0.5F, 0.5F, var27);
         float var28 = var19 + var8;
         float var29 = var20 + (var18 - var4) / 2.0F;
         Color var30 = new Color(this.field1210.getRed(), this.field1210.getGreen(), this.field1210.getBlue(), (int)(122.0F * var24));
         GuiRenderHelper.method1463(var25, var28, var29, var4, var4, var5, var30);
         GuiRenderHelper.method1461(
            var25, var28, var29, var4, var4, var5, 1.0F, 0.5F, new Color(this.field1210.getRed(), this.field1210.getGreen(), this.field1210.getBlue(), var23)
         );
         class_2960 var31 = RemoteAvatarService.method0571();
         if (var31 != null) {
            GuiRenderHelper.method1466(var25, var28, var29, var4, var4, var5, var31, new Color(255, 255, 255, var23));
         } else {
            FontSize var32 = Fonts.field0075.method0654(9.0F * var2);
            String var33 = var12.substring(0, 1).toUpperCase();
            float var34 = var32.method0998(var33);
            float var35 = var32.method0530();
            GuiRenderHelper.method1491(var25, var32, var33, var28 + (var4 - var34) / 2.0F, var29 + (var4 - var35) / 2.0F, new Color(246, 247, 255, var23));
         }

         float var36 = var28 + var4 + var6;
         float var37 = var20 + var18 / 2.0F - var10.method0530();
         float var38 = var20 + var18 / 2.0F + 1.5F * var2;
         GuiRenderHelper.method1491(var25, var10, var12, var36, var37, new Color(246, 247, 255, var23));
         GuiRenderHelper.method1491(var25, var11, var13, var36, var38, new Color(246, 247, 255, (int)(var23 * 0.48F)));
      }
   }

   private void method1671(class_332 var1) {
      float var2 = ScreenLayoutHelper.method0530();
      int var3 = (int)(255.0F * (1.0F - this.field0423));
      if (var3 >= 10) {
         FontSize var4 = Fonts.field0774.method0654(12.0F * var2);
         String var5 = "G";
         float var6 = var4.method0010().method1016(var5, var4.method2047());
         float var7 = var4.method0010().method0645(var4.method2047());
         float var8 = (float)Math.sin(System.currentTimeMillis() / 500.0) * 3.0F * var2;
         float var9 = (this.field_22789 - var6) / 2.0F;
         float var10 = this.field_22790 - 50.0F * var2 + var8;
         var1.method_51448().method_22903();
         var1.method_51448().method_46416(var9 + var6 / 2.0F, var10 + var7 / 2.0F, 0.0F);
         var1.method_51448().method_22907(class_7833.field_40718.rotationDegrees(180.0F * this.field0423));
         var1.method_51448().method_46416(-(var9 + var6 / 2.0F), -(var10 + var7 / 2.0F), 0.0F);
         GuiRenderHelper.method1491(
            var1.method_51448(), var4, var5, var9, var10, new Color(this.field1210.getRed(), this.field1210.getGreen(), this.field1210.getBlue(), var3)
         );
         var1.method_51448().method_22909();
      }
   }

   private void method1998(class_332 var1) {
      float var2 = ScreenLayoutHelper.method0530();
      int var3 = 3;
      float var4 = 2.0F * var2;
      float var5 = 16.0F * var2;
      float var6 = (var3 - 1) * var5;
      float var7 = this.field_22789 - 20.0F * var2;
      float var8 = (this.field_22790 - var6) / 2.0F;

      for (int var9 = 0; var9 < var3; var9++) {
         float var10 = var8 + var9 * var5;
         float var11 = (float)var9 / (var3 - 1);
         float var12 = Math.abs(this.field0423 - var11);
         float var13 = 1.0F - Math.min(var12 * 2.0F, 1.0F);
         int var14 = (int)(80.0F + 175.0F * var13);
         float var15 = var4 * (1.0F + var13 * 0.3F);
         GuiRenderHelper.method1463(
            var1.method_51448(),
            var7 - var15,
            var10 - var15,
            var15 * 2.0F,
            var15 * 2.0F,
            var15 - 1.0F,
            new Color(this.field1210.getRed(), this.field1210.getGreen(), this.field1210.getBlue(), var14)
         );
      }
   }

   public boolean method_25402(double var1, double var3, int var5) {
      if (var5 == 0 && this.method0616(var1, var3)) {
         this.field0255 = 1.0F;
         return true;
      }

      if (this.field0423 > 0.5F) {
         if (this.field0532.method0627(var1, var3, var5)) {
            return true;
         }

         if (this.field0509.method0627(var1, var3, var5)) {
            return true;
         }

         if (this.field0554.method0627(var1, var3, var5)) {
            return true;
         }

         if (this.field1678.method0627(var1, var3, var5)) {
            return true;
         }
      }

      return super.method_25402(var1, var3, var5);
   }

   private boolean method0616(double var1, double var3) {
      if (this.field0423 >= 0.96F) {
         return false;
      }

      float var5 = ScreenLayoutHelper.method0530();
      float var6 = 34.0F * var5;
      float var7 = this.field_22789 / 2.0F - var6 / 2.0F;
      float var8 = this.field_22790 - 56.0F * var5;
      return MathHelper.method0689(var7, var8, var6, var6, (float)var1, (float)var3);
   }

   public boolean method_25401(double var1, double var3, double var5, double var7) {
      this.field0255 -= (float)var7 * 0.2F;
      this.field0255 = class_3532.method_15363(this.field0255, 0.0F, 1.0F);
      return true;
   }

   public boolean method_25404(int var1, int var2, int var3) {
      if (var1 == 264) {
         this.field0255 = Math.min(1.0F, this.field0255 + 0.3F);
         return true;
      } else if (var1 == 265) {
         this.field0255 = Math.max(0.0F, this.field0255 - 0.3F);
         return true;
      } else {
         return super.method_25404(var1, var2, var3);
      }
   }

   public boolean method_25422() {
      if (this.field0423 > 0.1F) {
         this.field0255 = 0.0F;
         return false;
      } else {
         return false;
      }
   }

   private float method0115(float var1) {
      return var1 * var1 * (3.0F - 2.0F * var1);
   }
}
