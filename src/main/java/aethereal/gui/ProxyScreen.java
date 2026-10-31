package aethereal;

import java.awt.Color;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_437;

public class ProxyScreen extends class_437 {
   private final class_437 field0742;
   private static final float field0003 = 360.0F;
   private static final float field1410 = 280.0F;
   private static final float field0957 = 26.0F;
   private static final float field0758 = 8.0F;
   private static final float field1242 = 3.0F;
   private final Animation field0327 = new Animation(150L, 1.0, false, EasingCurve.field1477);
   private final Animation field0198 = new Animation(280L, 1.0, false, EasingCurve.field1011);
   private final Animation field0477 = new Animation(220L, 1.0, false, EasingCurve.field1011);
   private final Animation field1635 = new Animation(320L, 1.0, true, EasingCurve.field0330);
   private final Map<ProxyEntry, Long> field1566 = new IdentityHashMap<>();
   private final Map<String, Animation> field1729 = new HashMap<>();
   private final Map<String, Animation> field1156 = new HashMap<>();
   private float field1087;
   private float field1196;
   private float field0871 = 0.0F;
   private float field0826 = 0.0F;
   private boolean field0931 = false;
   private int field1332 = -1;
   private long field1294 = 0L;
   private final ProxyListEntryWidget field1381 = new ProxyListEntryWidget(() -> ProxyAddressHelper.method1044("Host", "Хост"), false, false, 45, "O");
   private final ProxyListEntryWidget field0397 = new ProxyListEntryWidget(() -> ProxyAddressHelper.method1044("Port", "Порт"), true, false, 5, "P");
   private final ProxyListEntryWidget field0362 = new ProxyListEntryWidget(
      () -> ProxyAddressHelper.method1044("Username (optional)", "Логин (опц.)"), false, false, 64, "A"
   );
   private final ProxyListEntryWidget field0432 = new ProxyListEntryWidget(
      () -> ProxyAddressHelper.method1044("Password (optional)", "Пароль (опц.)"), false, true, 64, "N"
   );
   private ProxyType field0265 = ProxyType.field0678;

   public ProxyScreen(class_437 var1) {
      super(class_2561.method_43470("Proxy Manager"));
      this.field0742 = var1;
   }

   protected void method_25426() {
      this.field1087 = (this.field_22789 - 360.0F) / 2.0F;
      this.field1196 = (this.field_22790 - 280.0F) / 2.0F;
      this.field1294 = System.currentTimeMillis();
      this.field0198.method1973();
      this.field0477.method1973();
      this.field0327.method1973();
      this.field1635.method1570(true);
      this.field1635.method1634();

      for (ProxyEntry var2 : ProxyStorage.method1786().method1620()) {
         this.field1566.put(var2, this.field1294);
         if (var2.method0365() == ProxyEntry.ProxyProtocol.field0675) {
            ProxyTester.method0907(var2);
         }
      }
   }

   public void method_25394(class_332 var1, int var2, int var3, float var4) {
      this.method_25420(var1, var2, var3, var4);
      this.field0871 = this.field0826;
      this.field1566.keySet().retainAll(ProxyStorage.method1786().method1620());
      boolean var5 = false;

      for (ProxyEntry var7 : ProxyStorage.method1786().method1620()) {
         if (var7.method0365() == ProxyEntry.ProxyProtocol.field0104) {
            var5 = true;
            break;
         }
      }

      this.method1400(var1);
      this.method1413(var1, var2, var3);
      if (this.field0931) {
         this.method1673(var1, var2, var3);
      } else {
         this.method2169(var1, var2, var3);
         this.method1870(var1, var2, var3);
      }

      if (var5) {
         this.method1401(var1, 1.0F);
      }
   }

   private void method1401(class_332 var1, float var2) {
      float var3 = 140.0F;
      float var4 = 60.0F;
      float var5 = this.field1087 + (360.0F - var3) / 2.0F;
      float var6 = this.field1196 + (280.0F - var4) / 2.0F;
      GuiRenderHelper.method1462(var1.method_51448(), var5, var6, var3, var4, 8.0F, ThemePalette.field0367.get() * 0.6F, new Color(-1));
      GuiRenderHelper.method0326(var1.method_51448(), var5, var6, var3, var4, 8.0F, ThemePalette.field0930.get());
      GuiRenderHelper.method1461(var1.method_51448(), var5, var6, var3, var4, 8.0F, 0.5F, 0.5F, ThemePalette.field0884);
      FontSize var7 = Fonts.field0995.method0654(7.0F);
      String var8 = ProxyAddressHelper.method1044("Testing", "Тестирую");
      float var9 = var7.method0998(var8);
      float var10 = var5 + (var3 - var9 - 24.0F) / 2.0F;
      float var11 = var6 + (var4 - var7.method0530()) / 2.0F + 0.5F;
      GuiRenderHelper.method1491(var1.method_51448(), var7, var8, var10, var11, ThemePalette.field0789);
      float var12 = var10 + var9 + 6.0F;
      float var13 = var6 + var4 / 2.0F;
      long var14 = System.currentTimeMillis();
      Color var16 = ThemePalette.field1036.get();

      for (int var17 = 0; var17 < 3; var17++) {
         double var18 = var14 / 200.0 - var17 * 0.5500001459852684;
         float var20 = (float)(0.3000001807989365 + 0.7000001046902076 * Math.max(0.0, Math.sin(var18)));
         float var21 = 1.6F + var20 * 0.5F;
         int var22 = (int)(90.0F + 165.0F * var20);
         GuiRenderHelper.method0326(
            var1.method_51448(),
            var12 + var17 * 5.0F - var21,
            var13 - var21,
            var21 * 2.0F,
            var21 * 2.0F,
            var21 - 1.0F,
            new Color(var16.getRed(), var16.getGreen(), var16.getBlue(), var22)
         );
      }
   }

   private void method1400(class_332 var1) {
      GuiRenderHelper.method1462(
         var1.method_51448(), this.field1087, this.field1196, 360.0F, 280.0F, 10.0F, ThemePalette.field0367.get() * 0.6F, new Color(-1)
      );
      GuiRenderHelper.method0326(var1.method_51448(), this.field1087, this.field1196, 360.0F, 280.0F, 10.0F, ThemePalette.field0930.get());
      GuiRenderHelper.method1461(var1.method_51448(), this.field1087, this.field1196, 360.0F, 280.0F, 10.0F, 0.5F, 0.5F, ThemePalette.field0884);
   }

   private void method1413(class_332 var1, int var2, int var3) {
      FontSize var4 = Fonts.field0995.method0654(9.0F);
      FontSize var5 = Fonts.field0075.method0654(5.5F);
      String var6 = this.field0931
         ? (
            this.field1332 < 0
               ? ProxyAddressHelper.method1044("Add Proxy", "Добавить прокси")
               : ProxyAddressHelper.method1044("Edit Proxy", "Редактировать прокси")
         )
         : ProxyAddressHelper.method1044("Proxy Manager", "Менеджер прокси");
      GuiRenderHelper.method1491(var1.method_51448(), var4, var6, this.field1087 + 12.0F, this.field1196 + 12.0F, ThemePalette.field0789);
      ProxyEntry var7 = ProxyStorage.method1786().method0547();
      String var8 = this.field0931
         ? ProxyAddressHelper.method1044("Fill the fields and save", "Заполните поля и сохраните")
         : (
            var7 == null
               ? ProxyAddressHelper.method1044("No proxy selected - direct connection", "Прокси не выбран - прямое подключение")
               : ProxyAddressHelper.method1044("Active: ", "Активен: ") + var7.method0017()
         );
      GuiRenderHelper.method1491(var1.method_51448(), var5, var8, this.field1087 + 12.0F, this.field1196 + 24.0F, ThemePalette.field0207);
      this.method0315(var1, var2, var3);
   }

   private void method0315(class_332 var1, int var2, int var3) {
      FontSize var4 = Fonts.field0774.method0654(6.0F);
      float var5 = var4.method0998("F");
      float var6 = var4.method0530();
      float var7 = this.field1087 + 360.0F - var5 - 10.0F;
      float var8 = this.field1196 + 12.0F - var6 / 2.0F;
      boolean var9 = MathHelper.method0689(var7 - 3.0F, var8 - 3.0F, var5 + 6.0F, var6 + 6.0F, var2, var3);
      if (this.field0327.method0376() != var9) {
         this.field0327.method1570(var9);
      }

      float var10 = this.field0327.method0002();
      int var11 = Math.min(255, (int)(170.0F + 70.0F * var10));
      int var12 = Math.min(255, (int)(170.0F + 75.0F * var10));
      int var13 = Math.min(255, (int)(170.0F + 80.0F * var10));
      int var14 = Math.min(255, (int)(2.55F * (52.0F + 90.0F * var10)));
      Color var15 = new Color(var11, var12, var13, var14);
      float var16 = 1.0F + 0.18F * var10;
      float var17 = var7 + var5 / 2.0F;
      float var18 = var8 + var6 / 2.0F;
      var1.method_51448().method_22903();
      var1.method_51448().method_46416(var17, var18, 0.0F);
      var1.method_51448().method_22905(var16, var16, 1.0F);
      var1.method_51448().method_46416(-var17, -var18, 0.0F);
      GuiRenderHelper.method1491(var1.method_51448(), var4, "F", var7, var8, var15);
      var1.method_51448().method_22909();
   }

   private boolean method0616(double var1, double var3) {
      FontSize var5 = Fonts.field0774.method0654(6.0F);
      float var6 = var5.method0998("F");
      float var7 = var5.method0530();
      float var8 = this.field1087 + 360.0F - var6 - 10.0F;
      float var9 = this.field1196 + 12.0F - var7 / 2.0F;
      return MathHelper.method0689(var8 - 3.0F, var9 - 3.0F, var6 + 6.0F, var7 + 6.0F, (float)var1, (float)var3);
   }

   private void method2169(class_332 var1, int var2, int var3) {
      float var4 = this.field1087 + 8.0F;
      float var5 = this.field1196 + 44.0F;
      float var6 = 344.0F;
      float var7 = 194.0F;
      GuiRenderHelper.method1404(var1, var4, var5, var6, var7);
      List var8 = ProxyStorage.method1786().method1620();
      if (var8.isEmpty()) {
         FontSize var9 = Fonts.field0075.method0654(6.5F);
         String var10 = ProxyAddressHelper.method1044("No proxies yet. Click ", "Прокси пока нет. Нажмите ");
         String var11 = ProxyAddressHelper.method1044("Add", "Добавить");
         String var12 = ProxyAddressHelper.method1044(" to create one.", " чтобы создать.");
         float var13 = var9.method0998(var10);
         float var14 = var9.method0998(var11);
         float var15 = var9.method0998(var12);
         float var16 = var13 + var14 + var15;
         float var17 = var4 + (var6 - var16) / 2.0F;
         float var18 = var5 + var7 / 2.0F - var9.method0530() / 2.0F;
         GuiRenderHelper.method1491(var1.method_51448(), var9, var10, var17, var18, ThemePalette.field0207);
         GuiRenderHelper.method1491(var1.method_51448(), var9, var11, var17 + var13, var18, ThemePalette.field1514.get());
         GuiRenderHelper.method1491(var1.method_51448(), var9, var12, var17 + var13 + var14, var18, ThemePalette.field0207);
      } else {
         float var19 = var5 - this.field0871;
         int var21 = ProxyStorage.method1786().method1947();

         for (int var22 = 0; var22 < var8.size(); var22++) {
            this.method1423(var1, var8.get(var22), var22 == var21, var4, var19, var6, var2, var3, var22);
            var19 += 30.0F;
         }
      }

      GuiRenderHelper.method1400(var1);
      float var20 = var8.size() * 30.0F;
      this.field0826 = class_3532.method_15363(this.field0826, 0.0F, Math.max(0.0F, var20 - var7));
   }

   private void method1423(class_332 var1, ProxyEntry var2, boolean var3, float var4, float var5, float var6, float var7, float var8, int var9) {
      boolean var10 = MathHelper.method0689(var4, var5, var6, 26.0F, var7, var8);
      Color var11 = var3
         ? new Color(ThemePalette.field1036.get().getRed(), ThemePalette.field1036.get().getGreen(), ThemePalette.field1036.get().getBlue(), 38)
         : (var10 ? ThemePalette.field1641 : ThemePalette.field1564);
      GuiRenderHelper.method0326(var1.method_51448(), var4, var5, var6, 26.0F, 6.0F, var11);
      FontSize var12 = Fonts.field0995.method0654(5.5F);
      String var13 = var2.method2060().method0557();
      float var14 = var12.method0998(var13) + 10.0F;
      float var15 = 13.0F;
      float var16 = var4 + 6.0F;
      float var17 = var5 + (26.0F - var15) / 2.0F;
      GuiRenderHelper.method0326(
         var1.method_51448(),
         var16,
         var17,
         var14,
         var15,
         3.0F,
         new Color(ThemePalette.field1036.get().getRed(), ThemePalette.field1036.get().getGreen(), ThemePalette.field1036.get().getBlue(), 90)
      );
      GuiRenderHelper.method1491(
         var1.method_51448(), var12, var13, var16 + 5.0F, var17 + (var15 - var12.method0530()) / 2.0F + 0.5F, ThemePalette.field0789
      );
      float var18 = 22.0F;
      float var19 = var16 + var14 + 4.0F;
      Color var20 = new Color(255, 255, 255, 24);
      GuiRenderHelper.method0326(var1.method_51448(), var19, var17, var18, var15, 3.0F, var20);
      String var21 = var2.method2224() != null && !var2.method2224().isEmpty() ? var2.method2224() : "?";
      FontSize var22 = Fonts.field0995.method0654(5.5F);
      float var23 = var22.method0998(var21);
      GuiRenderHelper.method1491(
         var1.method_51448(), var22, var21, var19 + (var18 - var23) / 2.0F, var17 + (var15 - var22.method0530()) / 2.0F + 0.5F, ThemePalette.field0789
      );
      float var24 = 40.0F;
      float var25 = 16.0F;
      float var26 = 3.0F;
      float var27 = var5 + (26.0F - var25) / 2.0F;
      float var28 = var4 + var6 - var24 - 6.0F;
      float var29 = var28 - var24 - var26;
      float var30 = var29 - var24 - var26;
      float var31 = var30 - 34.0F - 4.0F;
      FontSize var32 = Fonts.field0075.method0654(6.5F);
      FontSize var33 = Fonts.field0075.method0654(5.0F);
      String var34 = var2.method1791() + ":" + var2.method1604();
      String var35 = var2.method0579() ? var2.method1961() : ProxyAddressHelper.method1044("anonymous", "анонимно");
      float var36 = var19 + var18 + 6.0F;
      float var37 = var31 - var36 - 6.0F;
      GuiRenderHelper.method1404(var1, var36, var5, var37, 26.0F);
      GuiRenderHelper.method1491(var1.method_51448(), var32, var34, var36, var5 + 4.0F, ThemePalette.field0789);
      GuiRenderHelper.method1491(var1.method_51448(), var33, var35, var36, var5 + 14.0F, ThemePalette.field0207);
      GuiRenderHelper.method1400(var1);
      this.method1422(var1, var2, var31, var27, 34.0F, var25);
      this.method1426(
         var1,
         "row:" + var9 + ":use",
         var3 ? "H" : "M",
         var3 ? ProxyAddressHelper.method1044("Active", "Активен") : ProxyAddressHelper.method1044("Use", "Вкл."),
         var30,
         var27,
         var24,
         var25,
         var7,
         var8,
         var3 ? ProxyScreen.ProxyTab.field0105 : ProxyScreen.ProxyTab.field0676
      );
      this.method1426(
         var1,
         "row:" + var9 + ":edit",
         "F",
         ProxyAddressHelper.method1044("Edit", "Изм."),
         var29,
         var27,
         var24,
         var25,
         var7,
         var8,
         ProxyScreen.ProxyTab.field0676
      );
      this.method1426(
         var1,
         "row:" + var9 + ":del",
         "E",
         ProxyAddressHelper.method1044("Del", "Удал."),
         var28,
         var27,
         var24,
         var25,
         var7,
         var8,
         ProxyScreen.ProxyTab.field1479
      );
   }

   private float method1020(String var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      Animation var8 = this.field1729.computeIfAbsent(var1, var0 -> new Animation(160L, 1.0, false, EasingCurve.field1011));
      boolean var9 = MathHelper.method0689(var2, var3, var4, var5, var6, var7);
      if (var8.method0376() != var9) {
         var8.method1570(var9);
      }

      return var8.method0002();
   }

   private float method0208(String var1) {
      Animation var2 = this.field1156.get(var1);
      if (var2 == null) {
         return 0.0F;
      }

      if (var2.method0376() && var2.method0579()) {
         var2.method1570(false);
      }

      return var2.method0002();
   }

   public void method1013(String var1) {
      Animation var2 = this.field1156.computeIfAbsent(var1, var0 -> new Animation(140L, 1.0, false, EasingCurve.field1011));
      var2.method1570(true);
      var2.method1634();
   }

   private void method1405(class_332 var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = 1.0F + 0.05F * var6 - 0.06F * var7;
      float var9 = var2 + var4 / 2.0F;
      float var10 = var3 + var5 / 2.0F;
      var1.method_51448().method_22903();
      var1.method_51448().method_46416(var9, var10, 0.0F);
      var1.method_51448().method_22905(var8, var8, 1.0F);
      var1.method_51448().method_46416(-var9, -var10, 0.0F);
   }

   private void method1426(
      class_332 var1,
      String var2,
      String var3,
      String var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      ProxyScreen.ProxyTab var11
   ) {
      float var12 = this.method1020(var2, var5, var6, var7, var8, var9, var10);
      float var13 = this.method0208(var2);
      this.method1405(var1, var5, var6, var7, var8, var12, var13);
      Color var14;
      switch (var11) {
         case field0105: {
            Color var23 = ThemePalette.field1036.get();
            int var16 = (int)(35.0F * var12);
            var14 = new Color(
               Math.min(255, var23.getRed() + var16),
               Math.min(255, var23.getGreen() + var16),
               Math.min(255, var23.getBlue() + var16),
               Math.min(255, 200 + (int)(35.0F * var12))
            );
            break;
         }
         case field1479: {
            int var22 = (int)(40.0F * var12);
            var14 = new Color(Math.min(255, 220 + var22 / 3), Math.min(255, 80 + var22), Math.min(255, 80 + var22), Math.min(255, 90 + (int)(90.0F * var12)));
            break;
         }
         default:
            int var15 = 30 + (int)(60.0F * var12);
            var14 = new Color(255, 255, 255, var15);
      }

      GuiRenderHelper.method0326(var1.method_51448(), var5, var6, var7, var8, 4.0F, var14);
      FontSize var24 = Fonts.field1148.method0654(6.5F);
      FontSize var25 = Fonts.field0075.method0654(5.5F);
      float var17 = var24.method0998(var3);
      float var18 = var25.method0998(var4);
      float var19 = 3.0F;
      float var20 = var17 + var19 + var18;
      float var21 = var5 + (var7 - var20) / 2.0F;
      GuiRenderHelper.method1491(var1.method_51448(), var24, var3, var21, var6 + (var8 - var24.method0530()) / 2.0F, ThemePalette.field0789);
      GuiRenderHelper.method1491(
         var1.method_51448(), var25, var4, var21 + var17 + var19, var6 + (var8 - var25.method0530()) / 2.0F + 0.5F, ThemePalette.field0789
      );
      var1.method_51448().method_22909();
   }

   private void method1422(class_332 var1, ProxyEntry var2, float var3, float var4, float var5, float var6) {
      FontSize var7 = Fonts.field0995.method0654(5.5F);
      String var8;
      Color var9;
      switch (var2.method0365()) {
         case field0104:
            var8 = "...";
            var9 = ThemePalette.field0334;
            break;
         case field1478:
            var8 = var2.method0484() + "ms";
            var9 = this.method0723(var2.method0484());
            break;
         case field1012:
            var8 = "FAIL";
            var9 = new Color(235, 90, 90);
            break;
         default:
            var8 = "?";
            var9 = ThemePalette.field0207;
      }

      float var10 = var7.method0998(var8);
      GuiRenderHelper.method1491(var1.method_51448(), var7, var8, var3 + (var5 - var10) / 2.0F, var4 + (var6 - var7.method0530()) / 2.0F + 0.5F, var9);
   }

   private Color method0723(int var1) {
      if (var1 < 100) {
         return new Color(110, 220, 130);
      } else {
         return var1 < 250 ? new Color(220, 200, 100) : new Color(230, 140, 90);
      }
   }

   private void method1424(class_332 var1, String var2, float var3, float var4, float var5, float var6, float var7, float var8, boolean var9) {
      Color var10;
      if (var9) {
         Color var11 = ThemePalette.field1036.get();
         var10 = new Color(var11.getRed(), var11.getGreen(), var11.getBlue(), 200);
      } else {
         var10 = ThemePalette.field1641;
      }

      GuiRenderHelper.method0326(var1.method_51448(), var3, var4, var5, var6, 4.0F, var10);
      FontSize var13 = Fonts.field0075.method0654(5.5F);
      float var12 = var13.method0998(var2);
      GuiRenderHelper.method1491(
         var1.method_51448(), var13, var2, var3 + (var5 - var12) / 2.0F, var4 + (var6 - var13.method0530()) / 2.0F + 0.5F, ThemePalette.field0789
      );
   }

   private void method1870(class_332 var1, int var2, int var3) {
      float var4 = this.field1196 + 280.0F - 34.0F;
      float var5 = 100.0F;
      float var6 = 6.0F;
      float var7 = var5 * 3.0F + var6 * 2.0F;
      float var8 = this.field1087 + (360.0F - var7) / 2.0F;
      this.method1427(var1, "footer:add", "C", ProxyAddressHelper.method1044("Add", "Добавить"), var8, var4, var5, 22.0F, var2, var3, true);
      this.method1427(var1, "footer:test", "K", ProxyAddressHelper.method1044("Test All", "Тест все"), var8 + var5 + var6, var4, var5, 22.0F, var2, var3, false);
      this.method1427(
         var1, "footer:direct", "Q", ProxyAddressHelper.method1044("Direct", "Прямой"), var8 + (var5 + var6) * 2.0F, var4, var5, 22.0F, var2, var3, false
      );
   }

   private void method1427(
      class_332 var1, String var2, String var3, String var4, float var5, float var6, float var7, float var8, float var9, float var10, boolean var11
   ) {
      float var12 = this.method1020(var2, var5, var6, var7, var8, var9, var10);
      float var13 = this.method0208(var2);
      this.method1405(var1, var5, var6, var7, var8, var12, var13);
      Color var14;
      if (var11) {
         Color var15 = ThemePalette.field1036.get();
         int var16 = (int)(40.0F * var12);
         var14 = new Color(
            Math.min(255, var15.getRed() + var16),
            Math.min(255, var15.getGreen() + var16),
            Math.min(255, var15.getBlue() + var16),
            Math.min(255, 200 + (int)(40.0F * var12))
         );
      } else {
         int var22 = 30 + (int)(70.0F * var12);
         var14 = new Color(255, 255, 255, var22);
      }

      GuiRenderHelper.method0326(var1.method_51448(), var5, var6, var7, var8, 6.0F, var14);
      if (var12 > 0.01F) {
         Color var23 = var11
            ? new Color(
               ThemePalette.field1036.get().getRed(),
               ThemePalette.field1036.get().getGreen(),
               ThemePalette.field1036.get().getBlue(),
               (int)(180.0F * var12)
            )
            : new Color(255, 255, 255, (int)(90.0F * var12));
         GuiRenderHelper.method1461(var1.method_51448(), var5, var6, var7, var8, 6.0F, 0.6F, 0.6F, var23);
      }

      FontSize var24 = Fonts.field1148.method0654(8.0F);
      FontSize var25 = Fonts.field0995.method0654(6.5F);
      float var17 = var24.method0998(var3);
      float var18 = var25.method0998(var4);
      float var19 = 4.0F;
      float var20 = var17 + var19 + var18;
      float var21 = var5 + (var7 - var20) / 2.0F;
      GuiRenderHelper.method1491(var1.method_51448(), var24, var3, var21, var6 + (var8 - var24.method0530()) / 2.0F, ThemePalette.field0789);
      GuiRenderHelper.method1491(
         var1.method_51448(), var25, var4, var21 + var17 + var19, var6 + (var8 - var25.method0530()) / 2.0F + 0.5F, ThemePalette.field0789
      );
      var1.method_51448().method_22909();
   }

   private void method0316(class_332 var1, String var2, float var3, float var4, float var5, float var6, float var7, float var8, boolean var9) {
      Color var10;
      if (var9) {
         Color var11 = ThemePalette.field1036.get();
         var10 = new Color(var11.getRed(), var11.getGreen(), var11.getBlue(), 200);
      } else {
         var10 = ThemePalette.field1641;
      }

      GuiRenderHelper.method0326(var1.method_51448(), var3, var4, var5, var6, 6.0F, var10);
      FontSize var13 = Fonts.field0995.method0654(6.5F);
      float var12 = var13.method0998(var2);
      GuiRenderHelper.method1491(
         var1.method_51448(), var13, var2, var3 + (var5 - var12) / 2.0F, var4 + (var6 - var13.method0530()) / 2.0F + 0.5F, ThemePalette.field0789
      );
   }

   private void method1673(class_332 var1, int var2, int var3) {
      float var4 = this.field1087 + 20.0F;
      float var5 = this.field1196 + 50.0F;
      float var6 = 320.0F;
      float var7 = 22.0F;
      float var8 = 10.0F;
      this.method0313(var1, var4, var5, var6, var7, var2, var3);
      float var9 = var5 + var7 + var8;
      this.field1381.method0686(var4, var9, var6 * 0.7F - 4.0F, var7);
      this.field0397.method0686(var4 + var6 * 0.7F + 4.0F, var9, var6 * 0.3F - 4.0F, var7);
      this.field1381.method1402(var1, var2, var3);
      this.field0397.method1402(var1, var2, var3);
      var9 += var7 + var8;
      this.field0362.method0686(var4, var9, var6, var7);
      this.field0362.method1402(var1, var2, var3);
      var9 += var7 + var8;
      this.field0432.method0686(var4, var9, var6, var7);
      this.field0432.method1402(var1, var2, var3);
      float var10 = this.field1196 + 280.0F - 34.0F;
      float var11 = 92.0F;
      float var12 = 92.0F;
      float var13 = 8.0F;
      float var14 = var11 + var13 + var12;
      float var15 = this.field1087 + (360.0F - var14) / 2.0F;
      this.method1427(var1, "editor:save", "G", ProxyAddressHelper.method1044("Save", "Сохранить"), var15, var10, var11, 22.0F, var2, var3, true);
      this.method1427(
         var1, "editor:cancel", "L", ProxyAddressHelper.method1044("Cancel", "Отмена"), var15 + var11 + var13, var10, var12, 22.0F, var2, var3, false
      );
   }

   private void method0313(class_332 var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      ProxyType[] var8 = ProxyType.values();
      float var9 = var4 / var8.length;
      GuiRenderHelper.method0326(var1.method_51448(), var2, var3, var4, var5, 6.0F, ThemePalette.field1564);

      for (int var10 = 0; var10 < var8.length; var10++) {
         float var11 = var2 + var9 * var10;
         boolean var12 = var8[var10] == this.field0265;
         String var13 = "type:" + var8[var10].name();
         float var14 = this.method1020(var13, var11, var3, var9, var5, var6, var7);
         float var15 = this.method0208(var13);
         float var16 = 1.0F + 0.04F * var14 - 0.05F * var15;
         float var17 = var11 + var9 / 2.0F;
         float var18 = var3 + var5 / 2.0F;
         var1.method_51448().method_22903();
         var1.method_51448().method_46416(var17, var18, 0.0F);
         var1.method_51448().method_22905(var16, var16, 1.0F);
         var1.method_51448().method_46416(-var17, -var18, 0.0F);
         if (var12) {
            Color var19 = ThemePalette.field1036.get();
            int var20 = (int)(30.0F * var14);
            GuiRenderHelper.method0326(
               var1.method_51448(),
               var11 + 2.0F,
               var3 + 2.0F,
               var9 - 4.0F,
               var5 - 4.0F,
               4.0F,
               new Color(
                  Math.min(255, var19.getRed() + var20),
                  Math.min(255, var19.getGreen() + var20),
                  Math.min(255, var19.getBlue() + var20),
                  Math.min(255, 200 + (int)(40.0F * var14))
               )
            );
         } else if (var14 > 0.01F) {
            int var23 = 12 + (int)(50.0F * var14);
            GuiRenderHelper.method0326(var1.method_51448(), var11 + 2.0F, var3 + 2.0F, var9 - 4.0F, var5 - 4.0F, 4.0F, new Color(255, 255, 255, var23));
         }

         FontSize var24 = Fonts.field0995.method0654(6.0F);
         float var25 = var24.method0998(var8[var10].method0557());
         Color var21;
         if (var12) {
            var21 = ThemePalette.field0789;
         } else {
            int var22 = 184 + (int)(71.0F * var14);
            var21 = new Color(255, 255, 255, Math.min(255, var22));
         }

         GuiRenderHelper.method1491(
            var1.method_51448(), var24, var8[var10].method0557(), var11 + (var9 - var25) / 2.0F, var3 + (var5 - var24.method0530()) / 2.0F + 0.5F, var21
         );
         var1.method_51448().method_22909();
      }
   }

   public boolean method_25402(double var1, double var3, int var5) {
      if (this.method0616(var1, var3)) {
         this.method1812();
         return true;
      } else {
         return this.field0931 ? this.method0112(var1, var3, var5) : this.method0627(var1, var3, var5);
      }
   }

   private boolean method0627(double var1, double var3, int var5) {
      float var6 = this.field1087 + 8.0F;
      float var7 = this.field1196 + 44.0F;
      float var8 = 344.0F;
      List var9 = ProxyStorage.method1786().method1620();
      float var10 = var7 - this.field0871;

      for (int var11 = 0; var11 < var9.size(); var11++) {
         float var12 = 40.0F;
         float var13 = 16.0F;
         float var14 = 3.0F;
         float var15 = var10 + (26.0F - var13) / 2.0F;
         float var16 = var6 + var8 - var12 - 6.0F;
         float var17 = var16 - var12 - var14;
         float var18 = var17 - var12 - var14;
         if (MathHelper.method0689(var18, var15, var12, var13, (float)var1, (float)var3)) {
            this.method1013("row:" + var11 + ":use");
            ProxyStorage.method1786().method0729(var11);
            return true;
         }

         if (MathHelper.method0689(var17, var15, var12, var13, (float)var1, (float)var3)) {
            this.method1013("row:" + var11 + ":edit");
            this.method0143(var11);
            return true;
         }

         if (MathHelper.method0689(var16, var15, var12, var13, (float)var1, (float)var3)) {
            this.method1013("row:" + var11 + ":del");
            ProxyStorage.method1786().method0143(var11);
            return true;
         }

         var10 += 30.0F;
      }

      float var19 = this.field1196 + 280.0F - 34.0F;
      float var20 = 100.0F;
      float var21 = 6.0F;
      float var22 = var20 * 3.0F + var21 * 2.0F;
      float var23 = this.field1087 + (360.0F - var22) / 2.0F;
      if (MathHelper.method0689(var23, var19, var20, 22.0F, (float)var1, (float)var3)) {
         this.method1013("footer:add");
         this.method0143(-1);
         return true;
      } else if (MathHelper.method0689(var23 + var20 + var21, var19, var20, 22.0F, (float)var1, (float)var3)) {
         this.method1013("footer:test");
         ProxyTester.method0578();
         return true;
      } else if (MathHelper.method0689(var23 + (var20 + var21) * 2.0F, var19, var20, 22.0F, (float)var1, (float)var3)) {
         this.method1013("footer:direct");
         ProxyStorage.method1786().method0025();
         return true;
      } else {
         return false;
      }
   }

   private boolean method0112(double var1, double var3, int var5) {
      float var6 = this.field1087 + 20.0F;
      float var7 = this.field1196 + 50.0F;
      float var8 = 320.0F;
      float var9 = 22.0F;
      ProxyType[] var10 = ProxyType.values();
      float var11 = var8 / var10.length;

      for (int var12 = 0; var12 < var10.length; var12++) {
         float var13 = var6 + var11 * var12;
         if (MathHelper.method0689(var13, var7, var11, var9, (float)var1, (float)var3)) {
            this.method1013("type:" + var10[var12].name());
            this.field0265 = var10[var12];
            return true;
         }
      }

      this.field1381.method0627(var1, var3, var5);
      this.field0397.method0627(var1, var3, var5);
      this.field0362.method0627(var1, var3, var5);
      this.field0432.method0627(var1, var3, var5);
      float var18 = this.field1196 + 280.0F - 34.0F;
      float var19 = 92.0F;
      float var14 = 92.0F;
      float var15 = 8.0F;
      float var16 = var19 + var15 + var14;
      float var17 = this.field1087 + (360.0F - var16) / 2.0F;
      if (MathHelper.method0689(var17, var18, var19, 22.0F, (float)var1, (float)var3)) {
         this.method1013("editor:save");
         this.method2078();
         return true;
      } else if (MathHelper.method0689(var17 + var19 + var15, var18, var14, 22.0F, (float)var1, (float)var3)) {
         this.method1013("editor:cancel");
         this.method0578();
         return true;
      } else {
         return true;
      }
   }

   private void method0143(int var1) {
      this.field0931 = true;
      this.field1332 = var1;
      if (var1 >= 0) {
         ProxyEntry var2 = ProxyStorage.method1786().method1620().get(var1);
         this.field0265 = var2.method2060();
         this.field1381.method1013(var2.method1791());
         this.field0397.method1013(String.valueOf(var2.method1604()));
         this.field0362.method1013(var2.method1961());
         this.field0432.method1013(var2.method0423());
      } else {
         this.field0265 = ProxyType.field0678;
         this.field1381.method1013("");
         this.field0397.method1013("");
         this.field0362.method1013("");
         this.field0432.method1013("");
      }
   }

   private void method0578() {
      this.field0931 = false;
      this.field1332 = -1;
      this.method0025();
   }

   private void method0025() {
      this.field1381.method1570(false);
      this.field0397.method1570(false);
      this.field0362.method1570(false);
      this.field0432.method1570(false);
   }

   private void method2078() {
      String var1 = this.field1381.method0557().trim();
      String var2 = this.field0397.method0557().trim();
      if (!var1.isEmpty() && !var2.isEmpty()) {
         int var3;
         try {
            var3 = Integer.parseInt(var2);
         } catch (NumberFormatException var5) {
            return;
         }

         if (var3 >= 1 && var3 <= 65535) {
            ProxyEntry var4 = new ProxyEntry(this.field0265, var1, var3, this.field0362.method0557(), this.field0432.method0557());
            if (this.field1332 < 0) {
               ProxyStorage.method1786().method0907(var4);
            } else {
               ProxyStorage.method1786().method0763(this.field1332, var4);
            }

            ProxyTester.method0907(var4);
            this.method0578();
         }
      }
   }

   private void method1812() {
      this.field_22787.method_1507(this.field0742);
   }

   public boolean method_25404(int var1, int var2, int var3) {
      if (this.field0931) {
         if (this.field1381.method0746(var1, var2, var3)) {
            return true;
         }

         if (this.field0397.method0746(var1, var2, var3)) {
            return true;
         }

         if (this.field0362.method0746(var1, var2, var3)) {
            return true;
         }

         if (this.field0432.method0746(var1, var2, var3)) {
            return true;
         }
      }

      if (var1 == 256) {
         if (this.field0931) {
            this.method0578();
         } else {
            this.method1812();
         }

         return true;
      } else {
         return super.method_25404(var1, var2, var3);
      }
   }

   public boolean method_25400(char var1, int var2) {
      if (this.field0931) {
         if (this.field1381.method0607(var1, var2)) {
            return true;
         }

         if (this.field0397.method0607(var1, var2)) {
            return true;
         }

         if (this.field0362.method0607(var1, var2)) {
            return true;
         }

         if (this.field0432.method0607(var1, var2)) {
            return true;
         }
      }

      return super.method_25400(var1, var2);
   }

   public boolean method_25401(double var1, double var3, double var5, double var7) {
      if (!this.field0931) {
         List var9 = ProxyStorage.method1786().method1620();
         if (var9.isEmpty()) {
            this.field0826 = 0.0F;
            return true;
         } else {
            float var10 = 194.0F;
            float var11 = var9.size() * 30.0F;
            float var12 = Math.max(0.0F, var11 - var10);
            if (var12 <= 0.0F) {
               this.field0826 = 0.0F;
               return true;
            } else {
               this.field0826 = class_3532.method_15363(this.field0826 - (float)var7 * 18.0F, 0.0F, var12);
               return true;
            }
         }
      } else {
         return super.method_25401(var1, var3, var5, var7);
      }
   }

   public boolean method_25421() {
      return false;
   }

   private enum ProxyTab {
      field0676,
      field0105,
      field1479;
   }
}
