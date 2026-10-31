package aethereal;

import java.awt.Color;
import java.util.List;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import net.minecraft.class_9848;

public class InventoryHudEditor {
   private static final float field0566 = 104.0F;
   private static final float field0003 = 19.0F;
   private static final float field1410 = 6.0F;
   private static final float field0957 = 10.0F;
   private static final float field0758 = 6.0F;
   private static final float field1242 = 10.0F;
   private static final float field0314 = 7.0F;
   private static final float field0177 = 2.5F;
   private static final float field0458 = 5.0F;
   private static final float field1614 = 1.5F;
   private static final float field1538 = 3.0F;
   private static final Color field1726 = new Color(21, 21, 27, 224);
   private static final Color field1153 = new Color(255, 255, 255, 10);
   private static final Color field1104 = new Color(255, 255, 255, 80);
   private static final Color field1210 = new Color(255, 255, 255, 184);
   private static final String[] field0892 = new String[]{"Q", "R", "S", "U", "I", "w", "s", "T", "D"};
   private static final String[] field0846 = new String[]{
      "Displays the unique client name and version on the screen.",
      "Provides real-time data such as FPS, TPS, and server info.",
      "Renders a compact view of your inventory items on the HUD.",
      "Displays your current armor durability and equipped items.",
      "Displays a list of your assigned hotkeys and their states.",
      "Tracks active potion effects and their remaining durations.",
      "Shows module toggle alerts when enabling or disabling.",
      "Shows detailed information about the entity you are attacking.",
      "Displays a list of detected staff members and their status."
   };
   private static final String[] field0932 = new String[]{
      "Отображает уникальное имя клиента и версию на экране.",
      "Предоставляет данные в реальном времени: FPS, TPS, информация о сервере.",
      "Рисует компактный вид инвентаря на HUD.",
      "Отображает прочность брони и экипированные предметы.",
      "Показывает список назначенных клавиш и их состояний.",
      "Отслеживает активные эффекты зелий и их оставшееся время.",
      "Показывает уведомления при включении и выключении модулей.",
      "Показывает информацию о сущности, которую вы атакуете.",
      "Отображает список обнаруженных стаффов и их статус."
   };
   private boolean field1350 = false;
   private float field1292;
   private float field1369;
   private final Animation[] field0405 = new Animation[9];
   private float field0351 = 0.0F;
   private boolean field0442 = false;

   private static String[] method2084() {
      try {
         if (ClickGuiDashboard.field0984.method0492() == ClickGuiDashboard.Language.field0631) {
            return field0932;
         }
      } catch (Exception var1) {
      }

      return field0846;
   }

   public InventoryHudEditor() {
      for (int var1 = 0; var1 < this.field0405.length; var1++) {
         this.field0405[var1] = new Animation(200L, 1.0, false, EasingCurve.field1477);
      }
   }

   public void method0675(float var1, float var2) {
      float var3 = ScreenLayoutHelper.method2047();
      float var4 = ScreenLayoutHelper.method1762();
      float var5 = this.method1762();
      this.field1292 = var1;
      this.field1369 = var2;
      if (this.field1292 + 104.0F > var3) {
         this.field1292 = var3 - 104.0F - 4.0F;
      }

      if (this.field1369 + var5 > var4) {
         this.field1369 = var4 - var5 - 4.0F;
      }

      if (this.field1292 < 4.0F) {
         this.field1292 = 4.0F;
      }

      if (this.field1369 < 4.0F) {
         this.field1369 = 4.0F;
      }

      this.field1350 = true;
      this.field0442 = true;
      this.method1634();
   }

   public void method0578() {
      this.field0442 = false;
   }

   public boolean method0026() {
      return this.field1350;
   }

   private int method0829(FontSize var1, int var2) {
      String[] var3 = method2084();
      String var4 = var2 < var3.length ? var3[var2] : "";
      float var5 = 92.0F;
      int var6 = 1;
      StringBuilder var7 = new StringBuilder();

      for (String var11 : var4.split(" ")) {
         String var12 = var7.isEmpty() ? var11 : var7 + " " + var11;
         if (var1.method0998(var12) > var5 && !var7.isEmpty()) {
            var6++;
            var7 = new StringBuilder(var11);
         } else {
            var7 = new StringBuilder(var12);
         }
      }

      return var6;
   }

   private float method0172(FontSize var1, int var2) {
      int var3 = this.method0829(var1, var2);
      float var4 = var3 * (var1.method0530() + 1.0F);
      return 9.0F + var4 + 2.0F;
   }

   private float method1762() {
      FontSize var1 = Fonts.field0075.method0654(5.0F);
      NewHUD var2 = this.method1955();
      int var3 = var2 != null ? Math.min(var2.method1751().size(), field0892.length) : field0892.length;
      float var4 = 25.0F;

      for (int var5 = 0; var5 < var3; var5++) {
         var4 += this.method0172(var1, var5);
         if (var5 < var3 - 1) {
            var4 += 6.0F;
         }
      }

      return var4 + 1.0F;
   }

   private void method1634() {
      NewHUD var1 = this.method1955();
      if (var1 != null) {
         List var2 = var1.method1751();

         for (int var3 = 0; var3 < Math.min(var2.size(), this.field0405.length); var3++) {
            this.field0405[var3].method1570(var2.get(var3).method0492());
         }
      }
   }

   private NewHUD method1955() {
      return DaamkyClient.method2004().method1783().method0976(NewHUD.class);
   }

   public void method1414(class_332 var1, int var2, int var3, float var4) {
      if (this.field1350) {
         float var5 = this.field0442 ? 1.0F : 0.0F;
         this.field0351 = this.field0351 + (var5 - this.field0351) * 0.15F;
         if (this.field0351 >= 0.99F) {
            this.field0351 = 1.0F;
         }

         if (this.field0351 <= 0.01F) {
            this.field0351 = 0.0F;
            this.field1350 = false;
         } else {
            float var6 = this.field0351;
            class_4587 var7 = var1.method_51448();
            float var8 = this.method1762();
            float var9 = 0.9F + 0.1F * this.field0351;
            float var10 = this.field1292 + 52.0F;
            float var11 = this.field1369 + var8;
            var7.method_22903();
            var7.method_46416(var10, var11, 0.0F);
            var7.method_22905(var9, var9, 1.0F);
            var7.method_46416(-var10, -var11, 0.0F);
            Color var12 = ThemeColorManager.method1908().method0141(224);
            GuiRenderHelper.method1462(var7, this.field1292, this.field1369, 104.0F, var8, 10.0F, 14.0F, method0964(Color.WHITE, var6));
            GuiRenderHelper.method1463(var7, this.field1292, this.field1369, 104.0F, var8, 10.0F, method0964(var12, var6));
            FontSize var13 = Fonts.field0075.method0654(5.5F);
            FontSize var14 = Fonts.field0774.method0654(5.5F);
            Color var15 = ThemeColorManager.method1908().method2063();
            float var16 = this.field1369 + 6.0F;
            float var17 = this.field1292 + 6.0F;
            GuiRenderHelper.method1491(var7, var14, "C", var17, var16, method0964(var15, var6));
            var17 += var14.method0998("C") + 3.0F;
            float var18 = this.field1369 + 8.0F - 1.5F;
            GuiRenderHelper.method0326(var7, var17, var18, 1.3F, 6.0F, 0.2F, method0964(field1104, var6));
            var17 += 3.5F;
            GuiRenderHelper.method1491(var7, var13, "Settings", var17, var16, method0964(Color.WHITE, var6));
            FontSize var19 = Fonts.field0774.method0654(4.0F);
            float var20 = this.field1292 + 104.0F - 6.0F - var19.method0998("F") - 5.0F;
            GuiRenderHelper.method1491(var7, var19, "F", var20, var16 + 1.0F, method0964(new Color(170, 170, 170, 122), var6));
            float var21 = this.field1369 + 19.0F - 0.5F;
            GuiRenderHelper.method1463(var7, this.field1292, var21, 104.0F, 0.5F, 0.0F, method0964(field1153, var6));
            NewHUD var22 = this.method1955();
            if (var22 == null) {
               var7.method_22909();
            } else {
               List var23 = var22.method1751();
               FontSize var24 = Fonts.field0075.method0654(5.5F);
               FontSize var25 = Fonts.field0075.method0654(5.0F);
               FontSize var26 = Fonts.field0774.method0654(5.5F);
               FontSize var27 = Fonts.field1558.method0654(5.5F);
               float var28 = this.field1369 + 19.0F + 6.0F;

               for (int var29 = 0; var29 < Math.min(var23.size(), field0892.length); var29++) {
                  BooleanSetting var30 = var23.get(var29);
                  float var31 = this.method0172(var25, var29);
                  float var32 = var28;
                  if (this.field0405[var29].method0376() != var30.method0492()) {
                     this.field0405[var29].method1570(var30.method0492());
                  }

                  float var33 = var32;
                  String var34 = field0892[var29 % field0892.length];
                  FontSize var35 = var29 == 8 ? var27 : var26;
                  float var36 = 0.0F;

                  for (int var37 = 0; var37 < field0892.length; var37++) {
                     FontSize var38 = var37 == 8 ? var27 : var26;
                     var36 = Math.max(var36, var38.method0998(field0892[var37]));
                  }

                  float var65 = var35.method0998(var34);
                  float var66 = var29 == 0 ? 0.5F : (var29 == 2 ? 0.5F : (var29 == 5 ? 1.0F : (var29 == 6 ? -0.5F : 0.0F)));
                  float var39 = this.field1292 + 6.0F + (var36 - var65) / 2.0F + var66;
                  Color var40 = var30.method0492() ? method0964(var15, var6) : new Color(246, 247, 255, (int)(122.399994F * var6));
                  GuiRenderHelper.method1491(var7, var35, var34, var39, var33, var40);
                  float var41 = this.field1292 + 6.0F + var36 + 3.0F;
                  float var42 = var33 + var24.method0530() / 2.0F - 3.0F;
                  GuiRenderHelper.method0326(var7, var41, var42, 1.3F, 6.0F, 0.2F, method0964(field1104, var6));
                  String var43 = var30.method1888() != null ? var30.method1888() : var30.method2067();
                  float var44 = var41 + 0.5F + 3.0F;
                  GuiRenderHelper.method1491(var7, var24, var43, var44, var33, method0964(Color.WHITE, var6));
                  float var45 = this.field1292 + 104.0F - 6.0F - 10.0F;
                  float var46 = var33 + (var24.method0530() - 7.0F) / 2.0F;
                  float var47 = this.field0405[var29].method0002();
                  int var48 = class_9848.method_61319(
                     var47, method0195(new Color(255, 255, 255, (int)(2.55F * (12.0F + 12.0F * var47))), var6), method0195(var15, var6)
                  );
                  int var49 = method0195(new Color(246, 247, 255, 255), var6);
                  GuiRenderHelper.method0326(var7, var45, var46, 10.0F, 7.0F, 2.5F, new Color(var48, true));
                  GuiRenderHelper.method0326(var7, var45 + 1.0F + 3.0F * var47, var46 + 1.0F, 5.0F, 5.0F, 1.5F, new Color(var49, true));
                  String[] var50 = method2084();
                  String var51 = var29 < var50.length ? var50[var29] : "";
                  int var52 = (int)(field1210.getAlpha() * var6);
                  Color var53 = new Color(255, 255, 255, Math.max(0, Math.min(255, var52)));
                  float var54 = 92.0F;
                  float var55 = var33 + var24.method0530() + 2.0F;
                  String[] var56 = var51.split(" ");
                  StringBuilder var57 = new StringBuilder();

                  for (String var61 : var56) {
                     String var62 = var57.isEmpty() ? var61 : var57 + " " + var61;
                     if (var25.method0998(var62) > var54 && !var57.isEmpty()) {
                        GuiRenderHelper.method1491(var7, var25, var57.toString(), this.field1292 + 6.0F, var55, var53);
                        var55 += var25.method0530() + 1.0F;
                        var57 = new StringBuilder(var61);
                     } else {
                        var57 = new StringBuilder(var62);
                     }
                  }

                  if (!var57.isEmpty()) {
                     GuiRenderHelper.method1491(var7, var25, var57.toString(), this.field1292 + 6.0F, var55, var53);
                  }

                  var28 += var31 + 6.0F;
                  if (var29 < Math.min(var23.size(), field0892.length) - 1) {
                     GuiRenderHelper.method1463(var7, this.field1292 + 6.0F, var28 - 3.0F, 92.0F, 0.5F, 0.0F, method0964(field1104, var6));
                  }
               }

               var7.method_22909();
            }
         }
      }
   }

   public boolean method0627(double var1, double var3, int var5) {
      if (!this.field1350) {
         return false;
      }

      float var6 = this.method1762();
      if (!MathHelper.method0689(this.field1292, this.field1369, 104.0F, var6, (float)var1, (float)var3)) {
         this.method0578();
         return false;
      }

      if (var5 == 0) {
         FontSize var7 = Fonts.field0774.method0654(4.0F);
         float var8 = this.field1292 + 104.0F - 6.0F - var7.method0998("F") - 5.0F;
         float var9 = this.field1369 + 6.0F + 1.0F;
         if (MathHelper.method0689(var8, var9, var7.method0998("F"), var7.method0530(), (float)var1, (float)var3)) {
            this.method0578();
            return true;
         }

         NewHUD var10 = this.method1955();
         if (var10 == null) {
            return true;
         }

         List var11 = var10.method1751();
         FontSize var12 = Fonts.field0075.method0654(5.0F);
         float var13 = this.field1369 + 19.0F + 6.0F;

         for (int var14 = 0; var14 < Math.min(var11.size(), field0892.length); var14++) {
            float var15 = this.method0172(var12, var14);
            if (MathHelper.method0689(this.field1292, var13, 104.0F, var15, (float)var1, (float)var3)) {
               BooleanSetting var16 = var11.get(var14);
               var16.method0206(!var16.method0492());
               this.field0405[var14].method1570(var16.method0492());
               this.field0405[var14].method1634();
               DaamkyClient.method2004().method2216().method1634();
               return true;
            }

            var13 += var15 + 6.0F;
         }
      }

      return true;
   }

   private static Color method0964(Color var0, float var1) {
      return var1 >= 0.99F ? var0 : new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), Math.max(0, Math.min(255, (int)(var0.getAlpha() * var1))));
   }

   private static int method0195(Color var0, float var1) {
      int var2 = Math.max(0, Math.min(255, (int)(var0.getAlpha() * var1)));
      return var2 << 24 | var0.getRed() << 16 | var0.getGreen() << 8 | var0.getBlue();
   }
}
