package aethereal;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_332;
import net.minecraft.class_4587;

public class MediaStatusWidget {
   private static final float field0566 = 28.0F;
   private static final float field0003 = 12.0F;
   private static final float field1410 = 6.0F;
   private static final float field0957 = 8.0F;
   private static final float field0758 = 6.0F;
   private static final float field1242 = 12.0F;
   private static final float field0314 = 12.0F;
   private static final float field0177 = 6.0F;
   private static final int field0459 = 20;
   private static final int field1615 = 15;
   private static final int field1539 = 155;
   private static final int field1705 = 25;
   private static final long field1138 = 1000L;
   private static final DateTimeFormatter field1105 = DateTimeFormatter.ofPattern("HH:mm");
   private static final DateTimeFormatter field1212 = DateTimeFormatter.ofPattern("EEE, d MMM");
   private final List<MediaStatusWidget.MediaStatus> field0885 = new ArrayList<>();
   private float field0826 = 0.0F;
   private float field0910 = 1.0F;
   private long field1333 = 0L;
   private float field1292;
   private float field1369;
   private float field0385;
   private float field0351;
   private float field0423;
   private int field0256;
   private float field0226;

   public MediaStatusWidget() {
      this.field0885.add(new MediaStatusWidget.MediaStatus("c", "Update"));
   }

   public void method0738(int var1, int var2) {
   }

   public void method0578() {
      this.field0910 = 1.0F;
   }

   public void method0025() {
      this.field0910 = 0.0F;
   }

   public void method2078() {
      this.field0826 = this.field0826 + (this.field0910 - this.field0826) * 0.12F;
      if (Math.abs(this.field0826 - this.field0910) < 0.001F) {
         this.field0826 = this.field0910;
      }

      this.field0226 *= 0.85F;
      if (this.field0226 < 0.01F) {
         this.field0226 = 0.0F;
         this.field0256 = 0;
      }

      if (System.currentTimeMillis() - this.field1333 > 1000L) {
         this.field1333 = System.currentTimeMillis();
         SystemMetrics.method0578();
         OfflineWeatherService.method0578();
         MediaSessionManager var1 = DaamkyClient.method2004().method0489();
         if (var1 != null) {
            var1.method0578();
         }
      }
   }

   public void method1412(class_332 var1, int var2) {
      if (!(this.field0826 < 0.01F)) {
         float var3 = ScreenLayoutHelper.method0530();
         float var4 = 28.0F * var3;
         float var5 = 12.0F * var3;
         float var6 = 6.0F * var3;
         float var7 = 12.0F * var3;
         float var8 = 12.0F * var3;
         float var9 = 6.0F * var3;
         float var10 = 8.0F * var3;
         float var11 = 6.0F * var3;
         class_4587 var12 = var1.method_51448();
         float var13 = var5 - (var5 + var4) * (1.0F - this.field0826);
         int var14 = (int)(255.0F * this.field0826);
         FontSize var15 = Fonts.field0197.method0654(10.0F * var3);
         FontSize var16 = Fonts.field0075.method0654(7.0F * var3);
         FontSize var17 = Fonts.field0075.method0654(6.0F * var3);
         float var18 = var5;
         float var19 = var2 - var5;
         var18 = this.method1484(var12, var15, var16, var17, var18, var13, var14, var4, var10, var11, var7, var8, var9);
         var18 += var6;
         var18 = this.method1483(var12, var15, var16, var17, var18, var13, var14, var4, var10, var11, var7, var9);
         var19 = this.method0331(var12, var15, var16, var17, var19, var13, var14, var4, var10, var11, var7, var9);
         var19 -= var6;
         var19 = this.method1482(var12, var15, var17, var19, var13, var14, var4, var10, var11, var7, var9);
         var19 -= var6;
         this.method1481(var12, var15, var19, var13, var14, var4, var10, var11, var7, var9);
      }
   }

   private float method1484(
      class_4587 var1,
      FontSize var2,
      FontSize var3,
      FontSize var4,
      float var5,
      float var6,
      int var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13
   ) {
      float var14 = ScreenLayoutHelper.method0530();
      MediaSessionManager var15 = DaamkyClient.method2004().method0489();
      String var16 = "No media";
      String var17 = "";
      if (var15 != null) {
         String var18 = var15.method0368();
         String var19 = var15.method0493();
         if (var18 != null && !var18.isEmpty()) {
            var16 = this.method1024(var18, 20);
         }

         if (var19 != null && !var19.isEmpty()) {
            var17 = this.method1024(var19, 15);
         }
      }

      String var35 = "b";
      String var36 = var15 != null && var15.method0026() ? "g" : "k";
      String var20 = "a";
      float var21 = var12 * 3.0F + var13 * 2.0F;
      float var22 = var8 - 6.0F * var14;
      float var23 = Math.max(var3.method0998(var16), var17.isEmpty() ? 0.0F : var4.method0998(var17));
      float var24 = var9 * 2.0F + var21 + var13 + var22 + var13 + var23;
      this.field1292 = var5;
      this.field1369 = var6;
      this.field0385 = var5 + var9;
      this.field0351 = this.field0385 + var12 + var13;
      this.field0423 = this.field0351 + var12 + var13;
      this.method1469(var1, var5, var6, var24, var8, var7, var10);
      float var25 = var6 + var8 / 2.0F + 1.0F * var14;
      float var26 = 1.0F - this.field0226 * 0.25F;
      float var27 = 1.0F - this.field0226 * 0.5F;
      float var28 = 0.7F;
      float var29 = 0.95F;
      Color var30 = new Color(255, 255, 255, var7);
      this.method1487(var1, var2, var35, this.field0385, var25, var12, var28, var30, this.field0256 == 1 ? var26 : 1.0F, this.field0256 == 1 ? var27 : 1.0F);
      this.method1487(var1, var2, var36, this.field0351, var25, var12, var29, var30, this.field0256 == 2 ? var26 : 1.0F, this.field0256 == 2 ? var27 : 1.0F);
      this.method1487(var1, var2, var20, this.field0423, var25, var12, var28, var30, this.field0256 == 3 ? var26 : 1.0F, this.field0256 == 3 ? var27 : 1.0F);
      float var31 = var5 + var9 + var21 + var13;
      float var32 = var6 + (var8 - var22) / 2.0F;
      if (var15 != null && var15.method0428() != null && !var16.equals("No media")) {
         try {
            GuiRenderHelper.method1465(var1, var31, var32, var22, var22, 4.0F * var14, var15.method0428(), new Color(255, 255, 255, var7));
         } catch (Exception var34) {
         }
      }

      float var33 = var31 + var22 + var13;
      if (!var17.isEmpty()) {
         this.method1486(var1, var3, var4, var16, var17, var33, var6, var7, 0.6F, var8);
      } else {
         this.method1489(var1, var3, var16, var33, var6, (int)(var7 * 0.7F), var8);
      }

      return var5 + var24;
   }

   private float method1483(
      class_4587 var1,
      FontSize var2,
      FontSize var3,
      FontSize var4,
      float var5,
      float var6,
      int var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12
   ) {
      float var13 = ScreenLayoutHelper.method0530();
      String var14 = "j";
      String var15 = OfflineWeatherService.method2067();
      String var16 = OfflineWeatherService.method0017();
      float var17 = Math.max(var3.method0998(var15), var4.method0998(var16));
      float var18 = var9 * 2.0F + var11 + var12 + var17;
      this.method1469(var1, var5, var6, var18, var8, var7, var10);
      float var19 = var5 + var9;
      float var20 = var6 + var8 / 2.0F - 1.0F * var13;
      this.method1487(var1, var2, var14, var19, var20, var11, 0.85F, new Color(255, 255, 255, var7), 1.0F, 1.0F);
      this.method1486(var1, var3, var4, var15, var16, var19 + var11 + var12, var6, var7, 0.6F, var8);
      return var5 + var18;
   }

   private float method1482(
      class_4587 var1, FontSize var2, FontSize var3, float var4, float var5, int var6, float var7, float var8, float var9, float var10, float var11
   ) {
      float var12 = ScreenLayoutHelper.method0530();
      String var13 = "h";
      String var14 = "e";
      String var15 = "i";
      String var16 = SystemMetrics.method2067();
      String var17 = SystemMetrics.method0017();
      String var18 = SystemMetrics.method1961();
      float var19 = var10 + var11 + var3.method0998(var16);
      float var20 = var10 + var11 + var3.method0998(var17);
      float var21 = var10 + var11 + var3.method0998(var18);
      float var22 = var8 * 2.0F + var19 + var11 + var20 + var11 + var21;
      float var23 = var4 - var22;
      this.method1469(var1, var23, var5, var22, var7, var6, var9);
      float var24 = var5 + var7 / 2.0F;
      float var25 = var24 - 2.0F * var12;
      float var26 = var23 + var8;
      Color var27 = new Color(255, 255, 255, var6);
      var26 = this.method1485(var1, var2, var3, var13, var16, var26, var25, var24, var27, var6, 0.75F, var10, var11);
      var26 = this.method1485(var1, var2, var3, var14, var17, var26, var25, var24, var27, var6, 0.85F, var10, var11);
      this.method1485(var1, var2, var3, var15, var18, var26, var25, var24, var27, var6, 0.85F, var10, var11);
      return var23;
   }

   private void method1481(class_4587 var1, FontSize var2, float var3, float var4, int var5, float var6, float var7, float var8, float var9, float var10) {
      float var11 = ScreenLayoutHelper.method0530();
      if (!this.field0885.isEmpty()) {
         float var12 = var7 * 2.0F + this.field0885.size() * var9 + (this.field0885.size() - 1) * var10;
         float var13 = var3 - var12;
         this.method1469(var1, var13, var4, var12, var6, var5, var8);
         float var14 = var13 + var7;
         float var15 = var4 + var6 / 2.0F - 2.0F * var11;

         for (int var16 = 0; var16 < this.field0885.size(); var16++) {
            MediaStatusWidget.MediaStatus var17 = this.field0885.get(var16);
            Color var18 = new Color(255, 255, 255, var5);
            this.method1487(var1, var2, var17.icon, var14, var15, var9, 0.85F, var18, 1.0F, 1.0F);
            var14 += var9 + var10;
         }
      }
   }

   private float method0331(
      class_4587 var1,
      FontSize var2,
      FontSize var3,
      FontSize var4,
      float var5,
      float var6,
      int var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12
   ) {
      LocalDateTime var13 = LocalDateTime.now();
      String var14 = var13.format(field1105);
      String var15 = var13.format(field1212);
      String var16 = "f";
      float var17 = var3.method0998(var14);
      float var18 = var4.method0998(var15);
      float var19 = Math.max(var17, var18);
      float var20 = var9 * 2.0F + var11 + var12 + var19;
      float var21 = var5 - var20;
      this.method1469(var1, var21, var6, var20, var8, var7, var10);
      float var22 = var21 + var9;
      float var23 = var6 + var8 / 2.0F;
      this.method1487(var1, var2, var16, var22, var23, var11, 0.85F, new Color(255, 255, 255, var7), 1.0F, 1.0F);
      this.method1486(var1, var3, var4, var14, var15, var22 + var11 + var12, var6, var7, 0.7F, var8);
      return var21;
   }

   private String method1024(String var1, int var2) {
      return var1.length() > var2 ? var1.substring(0, var2 - 3) + "..." : var1;
   }

   private void method1486(
      class_4587 var1, FontSize var2, FontSize var3, String var4, String var5, float var6, float var7, int var8, float var9, float var10
   ) {
      float var11 = ScreenLayoutHelper.method0530();
      Color var12 = new Color(255, 255, 255, var8);
      Color var13 = new Color(255, 255, 255, (int)(var8 * var9));
      GuiRenderHelper.method1491(var1, var2, var4, var6, var7 + var10 / 2.0F - var2.method0530() + 1.0F * var11, var12);
      GuiRenderHelper.method1491(var1, var3, var5, var6, var7 + var10 / 2.0F + 2.0F * var11, var13);
   }

   private void method1489(class_4587 var1, FontSize var2, String var3, float var4, float var5, int var6, float var7) {
      GuiRenderHelper.method1491(var1, var2, var3, var4, var5 + (var7 - var2.method0530()) / 2.0F, new Color(255, 255, 255, var6));
   }

   private float method1485(
      class_4587 var1,
      FontSize var2,
      FontSize var3,
      String var4,
      String var5,
      float var6,
      float var7,
      float var8,
      Color var9,
      int var10,
      float var11,
      float var12,
      float var13
   ) {
      this.method1487(var1, var2, var4, var6, var7, var12, var11, var9, 1.0F, 1.0F);
      float var14 = var6 + var12 + var13;
      GuiRenderHelper.method1491(var1, var3, var5, var14, var8 - var3.method0530() / 2.0F, new Color(255, 255, 255, (int)(var10 * 0.8F)));
      return var14 + var3.method0998(var5) + var13;
   }

   private void method1487(
      class_4587 var1, FontSize var2, String var3, float var4, float var5, float var6, float var7, Color var8, float var9, float var10
   ) {
      float var11 = var2.method0998(var3);
      float var12 = var2.method0530();
      float var13 = var4 + var6 / 2.0F;
      int var14 = (int)(var8.getAlpha() * var10);
      Color var15 = new Color(var8.getRed(), var8.getGreen(), var8.getBlue(), var14);
      var1.method_22903();
      var1.method_46416(var13, var5, 0.0F);
      if (var7 != 1.0F) {
         var1.method_22905(var7, var7, 1.0F);
      }

      if (var9 != 1.0F) {
         var1.method_22905(var9, var9, 1.0F);
      }

      var1.method_46416(-var11 / 2.0F, -var12 / 2.0F, 0.0F);
      GuiRenderHelper.method1491(var1, var2, var3, 0.0F, 0.0F, var15);
      var1.method_22909();
   }

   private void method1469(class_4587 var1, float var2, float var3, float var4, float var5, int var6, float var7) {
      float var8 = ScreenLayoutHelper.method0530();
      float var9 = var6 / 255.0F;
      Color var10 = new Color(255, 255, 255, (int)(255.0F * var9));
      Color var11 = new Color(0, 0, 0, (int)(155.0F * var9));
      Color var12 = new Color(255, 255, 255, (int)(25.0F * var9));
      GuiRenderHelper.method0325(var1, var2, var3, var4, var5, var7, 8.0F * var8, var10);
      GuiRenderHelper.method1463(var1, var2, var3, var4, var5, var7, var11);
      GuiRenderHelper.method1461(var1, var2, var3, var4, var5, var7, 0.5F, 0.5F, var12);
   }

   public boolean method0627(double var1, double var3, int var5) {
      if (this.field0826 < 0.5F) {
         return false;
      }

      float var6 = ScreenLayoutHelper.method0530();
      float var7 = 28.0F * var6;
      float var8 = 12.0F * var6;
      if (!(var3 < this.field1369) && !(var3 > this.field1369 + var7)) {
         MediaSessionManager var9 = DaamkyClient.method2004().method0489();
         if (var9 == null) {
            return false;
         } else if (var1 >= this.field0385 && var1 < this.field0351) {
            this.field0256 = 1;
            this.field0226 = 1.0F;
            var9.method2078();
            return true;
         } else if (var1 >= this.field0351 && var1 < this.field0423) {
            this.field0256 = 2;
            this.field0226 = 1.0F;
            var9.method1634();
            return true;
         } else if (var1 >= this.field0423 && var1 < this.field0423 + var8) {
            this.field0256 = 3;
            this.field0226 = 1.0F;
            var9.method1812();
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public float method1762() {
      float var1 = ScreenLayoutHelper.method0530();
      return (28.0F * var1 + 12.0F * var1) * this.field0826;
   }

   private record MediaStatus(String icon, String text) {
      public String method0557() {
         return this.icon;
      }

      public String method0017() {
         return this.text;
      }
   }
}
