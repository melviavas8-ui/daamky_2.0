package aethereal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1661;
import net.minecraft.class_1799;
import net.minecraft.class_2561;
import net.minecraft.class_266;
import net.minecraft.class_268;
import net.minecraft.class_269;
import net.minecraft.class_332;
import net.minecraft.class_408;
import net.minecraft.class_4587;
import net.minecraft.class_465;
import net.minecraft.class_8646;
import net.minecraft.class_9011;

public class Interface extends Module {
   private static final float field0003 = 10.0F;
   private static final float field1410 = 14.0F;
   private static final Color field1026 = new Color(21, 21, 27, 224);
   private static final Color field0207 = new Color(255, 255, 255, 55);
   private static final Color field0486 = new Color(255, 255, 255, 80);
   private static final Color field1641 = new Color(255, 255, 255, 10);
   private static final Color field1564 = new Color(255, 255, 255, 41);
   private static final Color field1726 = new Color(255, 255, 255);
   private static final Color field1153 = new Color(255, 255, 255, 184);
   private static final Color field1104 = new Color(37, 37, 50);
   private static final Color field1210 = new Color(255, 255, 255, 28);
   private static final Color field0884 = new Color(255, 255, 255, 22);
   private static final Color field0840 = new Color(230, 90, 90);
   private static final Color field0927 = new Color(220, 60, 60);
   private static final Color field1346 = new Color(255, 215, 0);
   private static final Color field1307 = new Color(205, 140, 60);
   private static final Color field1383 = new Color(180, 200, 220);
   private static final Color field0399 = new Color(120, 220, 80);
   private final MultiSelectSetting field0363 = new MultiSelectSetting(
         "interface.elements", Arrays.asList("Hotbar", "Inventory", "Scoreboard", "Tab"), true, () -> true
      )
      .method1007("Elements")
      .method0210("Vanilla UI parts to replace")
      .method2130("Интерфейса для замены");
   private final BooleanSetting field0426 = new BooleanSetting("interface.blur", true)
      .method1007("Blur")
      .method0210("Apply background blur")
      .method2130("Размытие");
   private final BooleanSetting field0259 = new BooleanSetting("interface.outline", true)
      .method1007("Outline")
      .method0210("Draw subtle panel borders")
      .method2130("Рисовать рамки панелей");
   private final ColorSetting field0231 = new ColorSetting("interface.accent", 74, 214, 160, 255)
      .method1882()
      .method1007("Accent")
      .method0210("Accent color")
      .method2130("Цвет");
   private final BooleanSetting field0292 = new BooleanSetting(
         "interface.scoreboard.title", true, () -> this.field0363.method0439("Scoreboard") != null && this.field0363.method0439("Scoreboard").method0492()
      )
      .method1007("Scoreboard Title")
      .method0210("Show objective title")
      .method2130("Показывать заголовок");
   private float field0523 = 0.0F;
   private float field0501 = 0.0F;
   private float field0547 = 0.0F;
   private float field1671 = 0.0F;
   private float field1657 = 0.0F;
   private long field1690 = 0L;

   public Interface() {
      super("Interface", ModuleCategory.field1004, "Replaces vanilla hotbar, inventory and scoreboard");
      this.method1013("Улучшает игровой интерфейс в стиле клиента");
   }

   private static float method0685(float var0, float var1, float var2, float var3) {
      float var4 = 1.0F - (float)Math.exp(-var2 * var3);
      return var0 + (var1 - var0) * var4;
   }

   public boolean method1736() {
      BooleanSetting var1 = this.field0363.method0439("Hotbar");
      return this.method2195() && var1 != null && var1.method0492();
   }

   public boolean method1692() {
      BooleanSetting var1 = this.field0363.method0439("Inventory");
      return this.method2195() && var1 != null && var1.method0492();
   }

   public boolean method1755() {
      BooleanSetting var1 = this.field0363.method0439("Scoreboard");
      return this.method2195() && var1 != null && var1.method0492();
   }

   public boolean method2030() {
      BooleanSetting var1 = this.field0363.method0439("Tab");
      return this.method2195() && var1 != null && var1.method0492();
   }

   public void method1404(class_332 var1, float var2, float var3, float var4, float var5) {
      this.method1457(var1.method_51448(), var2, var3, var4, var5);
   }

   private Color method2010() {
      return this.field0231.method1726();
   }

   private void method1457(class_4587 var1, float var2, float var3, float var4, float var5) {
      if (this.field0426.method0492()) {
         GuiRenderHelper.method1462(var1, var2, var3, var4, var5, 10.0F, 14.0F, new Color(255, 255, 255));
      }

      GuiRenderHelper.method1463(var1, var2, var3, var4, var5, 10.0F, field1026);
      if (this.field0259.method0492()) {
         GuiRenderHelper.method1460(var1, var2, var3, var4, var5, 10.0F, 0.2F, 0.5F, 0.5F, field1210);
      }
   }

   @EventHandler
   public void onRender2D(HudRenderEvent var1) {
      if (!method1974()) {
         boolean var2 = field0796.field_1755 != null && !(field0796.field_1755 instanceof class_408) && !(field0796.field_1755 instanceof class_465);
         boolean var3 = field0796.method_53526().method_53536();
         if (this.method1736() && !var2 && !var3) {
            this.method0843(var1);
         }

         if (this.method1755() && !var2 && !var3) {
            this.method0176(var1);
         }
      }
   }

   private void method0843(HudRenderEvent var1) {
      class_332 var2 = var1.method1806();
      class_4587 var3 = var2.method_51448();
      class_1661 var4 = field0796.field_1724.method_31548();
      float var5 = ScreenLayoutHelper.method2047();
      float var6 = ScreenLayoutHelper.method1762();
      float var7 = 16.0F;
      float var8 = 2.0F;
      float var9 = 6.0F;
      int var10 = 9;
      float var11 = var10 * var7 + (var10 - 1) * var8;
      float var12 = var11 + var9 * 2.0F;
      float var13 = var7 + var9 * 2.0F;
      float var14 = (var5 - var12) / 2.0F;
      float var15 = var6 - var13 - 4.0F;
      boolean var16 = field0796.field_1724.method_6079() != null && !field0796.field_1724.method_6079().method_7960();
      this.method1457(var3, var14, var15, var12, var13);
      int var17 = var4.field_7545;
      float var18 = var15 + var9;

      for (int var19 = 0; var19 < var10; var19++) {
         float var20 = var14 + var9 + var19 * (var7 + var8);
         boolean var21 = var19 == var17;
         if (var21) {
            GuiRenderHelper.method1463(var3, var20 - 1.0F, var18 - 1.0F, var7 + 2.0F, var7 + 2.0F, 3.0F, method0966(this.method2010(), 60));
            GuiRenderHelper.method1460(var3, var20 - 1.0F, var18 - 1.0F, var7 + 2.0F, var7 + 2.0F, 3.0F, 0.2F, 0.5F, 0.5F, this.method2010());
         }

         class_1799 var22 = var4.method_5438(var19);
         if (!var22.method_7960()) {
            var3.method_22903();
            var3.method_46416(var20, var18, 0.0F);
            var2.method_51427(var22, 0, 0);
            var2.method_51432(field0796.field_1772, var22, 0, 0, null);
            var3.method_22909();
         } else {
            FontSize var23 = Fonts.field0774.method0654(6.0F);
            String var24 = "t";
            float var25 = var23.method0998(var24);
            GuiRenderHelper.method1491(var3, var23, var24, var20 + (var7 - var25) / 2.0F, var18 + (var7 - var23.method0530()) / 2.0F, field1564);
         }

         if (var19 < var10 - 1) {
            float var32 = var20 + var7 + (var8 - 1.0F) / 2.0F;
            float var34 = var18 + (var7 - 7.0F) / 2.0F;
            GuiRenderHelper.method0326(var3, var32, var34, 1.0F, 7.0F, 1.0F, field0486);
         }
      }

      float var28 = var7 - 4.0F;
      float var29 = var14 + var9 + var17 * (var7 + var8) + 2.0F;
      float var30 = var15 + var13 - 1.5F;
      GuiRenderHelper.method0326(var3, var29, var30, var28, 1.5F, 0.75F, this.method2010());
      if (var16) {
         float var31 = var7 + var9 * 2.0F;
         float var33 = var14 - var31 - 3.0F;
         float var35 = var15;
         this.method1457(var3, var33, var35, var31, var13);
         float var36 = var33 + var9;
         float var26 = var35 + var9;
         class_1799 var27 = field0796.field_1724.method_6079();
         var3.method_22903();
         var3.method_46416(var36, var26, 0.0F);
         var2.method_51427(var27, 0, 0);
         var2.method_51432(field0796.field_1772, var27, 0, 0, null);
         var3.method_22909();
      }

      if (!field0796.field_1724.method_7337() && !field0796.field_1724.method_7325()) {
         this.method1456(var3, var14, var15 - 6.0F, var12);
      }
   }

   private void method1456(class_4587 var1, float var2, float var3, float var4) {
      float var5 = Math.max(1.0F, field0796.field_1724.method_6063());
      float var6 = field0796.field_1724.method_6032();
      float var7 = field0796.field_1724.method_6067();
      float var8 = field0796.field_1724.method_7344().method_7586();
      int var9 = field0796.field_1724.method_6096();
      int var10 = field0796.field_1724.field_7520;
      float var11 = field0796.field_1724.field_7510;
      float var12 = Math.min(1.0F, var6 / var5);
      float var13 = var7 > 0.0F ? Math.min(1.0F, var7 / Math.max(var5, var7)) : 0.0F;
      float var14 = Math.min(1.0F, var8 / 20.0F);
      float var15 = var9 > 0 ? Math.min(1.0F, var9 / 20.0F) : 0.0F;
      long var16 = System.nanoTime();
      float var18 = this.field1690 == 0L ? 0.0F : (float)(var16 - this.field1690) / 1.0E9F;
      this.field1690 = var16;
      if (var18 > 0.1F) {
         var18 = 0.1F;
      }

      float var19 = 12.0F;
      this.field0523 = method0685(this.field0523, var12, var18, var19);
      this.field0501 = method0685(this.field0501, var13, var18, var19);
      this.field0547 = method0685(this.field0547, var14, var18, var19);
      this.field1671 = method0685(this.field1671, var15, var18, var19);
      this.field1657 = method0685(this.field1657, var11, var18, var19);
      float var20 = 2.6F;
      float var21 = (var4 - 2.0F) / 2.0F;
      float var22 = var2;
      float var23 = var2 + var4 / 2.0F + 1.0F;
      float var24 = var3;
      GuiRenderHelper.method0326(var1, var22, var24, var21, var20, 1.0F, field1104);
      if (this.field0523 > 0.001F) {
         Color var25 = var6 <= var5 * 0.25F ? field0927 : field0840;
         GuiRenderHelper.method0326(var1, var22, var24, var21 * this.field0523, var20, 1.0F, var25);
      }

      if (this.field0501 > 0.001F) {
         GuiRenderHelper.method0326(var1, var22, var24 - var20 - 1.0F, var21 * this.field0501, var20, 1.0F, field1346);
      }

      GuiRenderHelper.method0326(var1, var23, var24, var21, var20, 1.0F, field1104);
      if (this.field0547 > 0.001F) {
         float var29 = var21 * this.field0547;
         GuiRenderHelper.method0326(var1, var23 + var21 - var29, var24, var29, var20, 1.0F, field1307);
      }

      if (var9 > 0 || this.field1671 > 0.001F) {
         float var30 = var24 - var20 - 1.0F;
         GuiRenderHelper.method0326(var1, var23, var30, var21, var20, 1.0F, field1104);
         float var26 = var21 * this.field1671;
         GuiRenderHelper.method0326(var1, var23 + var21 - var26, var30, var26, var20, 1.0F, field1383);
      }

      float var31 = var24 - var20 - 1.0F;
      if (var7 > 0.0F || var9 > 0) {
         var31 = var24 - (var20 + 1.0F) * 2.0F;
      }

      GuiRenderHelper.method0326(var1, var2, var31, var4, var20, 1.0F, field1104);
      if (this.field1657 > 0.001F) {
         GuiRenderHelper.method0326(var1, var2, var31, var4 * this.field1657, var20, 1.0F, field0399);
      }

      if (var10 > 0) {
         FontSize var32 = Fonts.field0075.method0654(7.0F);
         String var27 = String.valueOf(var10);
         float var28 = var32.method0998(var27);
         GuiRenderHelper.method1491(var1, var32, var27, var2 + (var4 - var28) / 2.0F, var31 - var32.method0530() - 0.5F, field0399);
      }
   }

   private void method0176(HudRenderEvent var1) {
      if (field0796.field_1687 != null) {
         class_269 var2 = field0796.field_1687.method_8428();
         class_266 var3 = var2.method_1189(class_8646.field_45157);
         if (var3 != null) {
            Collection var4 = var2.method_1184(var3);
            List var5 = var4.stream()
               .filter(var0 -> var0.comp_2127() != null && !var0.comp_2127().startsWith("#"))
               .sorted(Comparator.comparing(class_9011::comp_2128).reversed().thenComparing(class_9011::comp_2127, String.CASE_INSENSITIVE_ORDER))
               .limit(15L)
               .collect(Collectors.toList());
            class_332 var6 = var1.method1806();
            class_4587 var7 = var6.method_51448();
            class_2561 var8 = var3.method_1114();
            boolean var9 = this.field0292.method0492();
            int var10 = 9;
            float var11 = 8.0F;
            float var12 = 1.0F;
            float var13 = var10 + var12;
            float var14 = var9 ? var10 + 6.0F : 0.0F;
            List var15 = new ArrayList<>(var5.size());
            float var16 = var9 ? field0796.field_1772.method_27525(var8) : 0.0F;

            for (class_9011 var18 : var5) {
               class_268 var19 = var2.method_1164(var18.comp_2127());
               class_2561 var20 = class_268.method_1142(var19, class_2561.method_43470(var18.comp_2127()));
               var15.add(var20);
               float var21 = field0796.field_1772.method_27525(var20);
               if (var21 > var16) {
                  var16 = var21;
               }
            }

            float var28 = var16 + var11 * 2.0F;
            float var29 = var15.size() * var13 + var11;
            float var30 = var14 + var29;
            float var31 = ScreenLayoutHelper.method2047();
            float var32 = ScreenLayoutHelper.method1762();
            float var22 = var31 - var28 - 4.0F;
            float var23 = (var32 - var30) / 2.0F;
            this.method1457(var7, var22, var23, var28, var30);
            int var24 = method0956(field1726);
            float var25 = var23;
            if (var9) {
               float var26 = field0796.field_1772.method_27525(var8);
               var6.method_27535(field0796.field_1772, var8, (int)(var22 + (var28 - var26) / 2.0F), (int)(var25 + 4.0F), var24);
               float var27 = var25 + var14 - 1.0F;
               GuiRenderHelper.method1463(var7, var22 + var11, var27, var28 - var11 * 2.0F, 1.0F, 0.4F, field0207);
               var25 += var14;
            }

            var25 += var11 * 0.5F;

            for (class_2561 var35 : var15) {
               var6.method_27535(field0796.field_1772, var35, (int)(var22 + var11), (int)var25, var24);
               var25 += var13;
            }
         }
      }
   }

   private static int method0956(Color var0) {
      return var0.getAlpha() << 24 | var0.getRed() << 16 | var0.getGreen() << 8 | var0.getBlue();
   }

   public void method1415(class_332 var1, int var2, int var3, int var4, int var5, String var6) {
      class_4587 var7 = var1.method_51448();
      float var8 = 8.0F;
      float var9 = var2 - var8;
      float var10 = var3 - var8;
      float var11 = var4 + var8 * 2.0F;
      float var12 = var5 + var8 * 2.0F;
      this.method1457(var7, var9, var10, var11, var12);
      FontSize var13 = Fonts.field0075.method0654(7.0F);
      if (var6 != null && !var6.isEmpty()) {
         float var14 = var13.method0998(var6);
         GuiRenderHelper.method1491(var7, var13, var6, var9 + (var11 - var14) / 2.0F, var10 + 4.0F, field1726);
         float var15 = var10 + var13.method0530() + 6.0F;
         GuiRenderHelper.method1463(var7, var9 + var8, var15, var11 - var8 * 2.0F, 1.0F, 0.4F, field0207);
      }

      this.method1473(var7, var2 + 8, var3 + 84, 9, 3);
      this.method1473(var7, var2 + 8, var3 + 142, 9, 1);
      this.method1473(var7, var2 + 8, var3 + 8, 1, 4);
      this.method1455(var7, var2 + 77, var3 + 62);
      this.method1473(var7, var2 + 98, var3 + 18, 2, 2);
      this.method1455(var7, var2 + 154, var3 + 28);
   }

   private void method1473(class_4587 var1, float var2, float var3, int var4, int var5) {
      float var6 = 18.0F;

      for (int var7 = 0; var7 < var5; var7++) {
         for (int var8 = 0; var8 < var4; var8++) {
            float var9 = var2 + var8 * var6;
            float var10 = var3 + var7 * var6;
            this.method1455(var1, var9, var10);
         }
      }
   }

   private void method1455(class_4587 var1, float var2, float var3) {
      GuiRenderHelper.method1463(var1, var2, var3, 16.0F, 16.0F, 3.0F, field1104);
      if (this.field0259.method0492()) {
         GuiRenderHelper.method1460(var1, var2, var3, 16.0F, 16.0F, 3.0F, 0.2F, 0.5F, 0.5F, field0884);
      }
   }

   private static Color method0966(Color var0, int var1) {
      return new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), Math.max(0, Math.min(255, var1)));
   }
}
