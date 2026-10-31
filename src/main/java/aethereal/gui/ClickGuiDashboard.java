package aethereal;

import java.awt.Color;
import java.util.List;
import net.minecraft.class_2960;
import net.minecraft.class_332;

public class ClickGuiDashboard extends GuiElement {
   private static final float field0177 = 33.0F;
   private static FontSize field0468;
   private static FontSize field1625;
   private static FontSize field1552;
   private static FontSize field1713;
   private static boolean field1161 = false;
   private final ClientContext field1094 = new ClientContext();
   private final String field1211 = this.field1094.method0557();
   private final int field0872 = this.field1094.method2048();
   private final String field0841 = this.field1094.method0017();
   public static BooleanSetting field0598 = new BooleanSetting("gui.backgroundblur", true)
      .method1007("Background Blur")
      .method0210("Apply blur effect behind GUI panels")
      .method2130("Размытие фона за панелями GUI");
   public static FloatSetting field0060 = new FloatSetting("gui.blurstrength", 48.0F, 1.0F, 100.0F, 1.0F, field0598::method0492)
      .method1007("Blur Strength")
      .method0210("Intensity of the background blur")
      .method2130("Интенсивность размытия фона");
   public static BooleanSetting field1432 = new BooleanSetting("gui.disablemcblur", false)
      .method1007("Disable Menu Blur")
      .method0210("Disable vanilla blur when GUI is open")
      .method2130("Отключить ванильное размытие при открытом GUI");
   public static EnumSetting<ClickGuiDashboard.Language> field0984 = new EnumSetting<>("gui.language", ClickGuiDashboard.Language.field0631)
      .method1007("Language")
      .method0210("Client interface language")
      .method2130("Язык интерфейса клиента");
   private final SettingsPopover field0920 = new SettingsPopover(
      List.of(
         new BooleanSettingWidget(field0598, () -> 1.0F),
         new NumberSettingWidget(field0060, () -> 1.0F),
         new BooleanSettingWidget(field1432, () -> 1.0F),
         new EnumSettingWidget(field0984, () -> 1.0F)
      )
   );
   private final ThemeEditor field1342 = new ThemeEditor();

   private static void method0498() {
      if (!field1161) {
         field0468 = Fonts.field0774.method0654(6.0F);
         field1625 = Fonts.field0774.method0654(6.0F);
         field1552 = Fonts.field0075.method0654(7.0F);
         field1713 = Fonts.field0075.method0654(6.0F);
         field1161 = true;
      }
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method0498();
      boolean var5 = MathHelper.method0689(this.method0530() + this.method2047() - 12.0F, this.method0002() + 4.0F, 9.0F, 9.0F, var2, var3);
      boolean var6 = MathHelper.method0689(this.method0530() + 24.0F, this.method0002() + 5.0F, 7.0F, 7.0F, var2, var3);
      GuiRenderHelper.method1462(
         var1.method_51448(),
         this.method0530(),
         this.method0002(),
         this.method2047(),
         this.method1762(),
         7.0F,
         ThemePalette.field0367.get(),
         ThemePalette.field0134
      );
      GuiRenderHelper.method1463(
         var1.method_51448(), this.method0530(), this.method0002(), this.method2047(), this.method1762(), 7.0F, ThemePalette.field1349.get()
      );
      GuiRenderHelper.method1461(
         var1.method_51448(), this.method0530(), this.method0002(), this.method2047(), this.method1762(), 7.0F, 0.5F, 0.5F, ThemePalette.field0884
      );
      GuiRenderHelper.method1460(
         var1.method_51448(), this.method0530() + 4.0F, this.method0002() + 4.0F, 16.0F, 16.0F, 3.0F, -0.5F, 1.0F, 1.0F, ThemePalette.field1514.get()
      );
      class_2960 var7 = RemoteAvatarService.method0571();
      if (var7 != null) {
         GuiRenderHelper.method1466(
            var1.method_51448(), this.method0530() + 4.0F, this.method0002() + 4.0F, 16.0F, 16.0F, 3.0F, var7, ThemePalette.field0789
         );
      }

      GuiRenderHelper.method1491(
         var1.method_51448(),
         field0468,
         "f",
         this.method0530() + 24.0F,
         this.method0002() + 5.0F,
         this.field1342.method0376() ? ThemePalette.field1514.get() : (var6 ? ThemePalette.field1268 : ThemePalette.field0334)
      );
      String var8 = this.method2224();
      float var9 = this.method0530() + 33.0F;
      float var10 = this.method0530() + this.method2047() - 14.0F - var9;
      float var11 = field1552.method1016(this.field1211, 0.05F);
      float var12 = field1552.method1016(var8, 0.05F);
      float var13 = this.method0002() + 4.0F;
      if (var11 + var12 <= var10) {
         GuiRenderHelper.method1488(var1.method_51448(), field1552, this.field1211, var9, var13, 0.05F, ThemePalette.field0789);
         GuiRenderHelper.method1491(var1.method_51448(), field1552, var8, var9 + var11, var13, ThemePalette.field1514.get());
      } else if (var12 + 6.0F < var10) {
         float var14 = var9 + var10 - var12;
         float var15 = var14 - var9 - 2.0F;
         this.method1425(var1, this.field1211, var9, var13, var15, ThemePalette.field0789);
         GuiRenderHelper.method1488(var1.method_51448(), field1552, var8, var14, var13, 0.05F, ThemePalette.field1514.get());
      } else {
         this.method1409(var1, var9, var13, var10, var8);
      }

      GuiRenderHelper.method1488(
         var1.method_51448(), field1713, "till " + this.field0841, this.method0530() + 24.0F, this.method0002() + 12.5F, 0.005F, ThemePalette.field0486
      );
      GuiRenderHelper.method1488(
         var1.method_51448(),
         field1625,
         "j",
         this.method0530() + this.method2047() - 12.0F,
         this.method0002() + 5.0F,
         0.005F,
         this.field0920.method0376() ? ThemePalette.field1514.get() : (var5 ? ThemePalette.field1268 : ThemePalette.field0334)
      );
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      if (MathHelper.method0689(this.method0530() + this.method2047() - 12.0F, this.method0002() + 4.0F, 9.0F, 9.0F, (float)var1, (float)var3)) {
         if (this.field1342.method0376()) {
            this.field1342.method1973();
         }

         if (this.field0920.method0376()) {
            this.field0920.method1973();
         } else {
            float var8 = (float)var1;
            float var9 = (float)var3 - 4.5F;
            this.field0920.method2100(var8, var9);
         }

         return true;
      } else if (MathHelper.method0689(this.method0530() + 24.0F, this.method0002() + 5.0F, 7.0F, 7.0F, (float)var1, (float)var3)) {
         if (this.field0920.method0376()) {
            this.field0920.method1973();
         }

         if (this.field1342.method0376()) {
            this.field1342.method1973();
         } else {
            float var6 = (float)var1;
            float var7 = (float)var3 - 3.5F;
            this.field1342.method2100(var6, var7);
         }

         return true;
      } else {
         return false;
      }
   }

   private String method2224() {
      return " [" + this.field0872 + "]";
   }

   private void method1409(class_332 var1, float var2, float var3, float var4, String var5) {
      float var6 = 14.0F;
      float var7 = var2 + var4 - var6;
      float var8 = var2 + var4;
      int var9 = this.field1211.length();
      String var10 = this.field1211 + var5;
      Color var11 = ThemePalette.field0789;
      Color var12 = ThemePalette.field1514.get();
      float var13 = var2;

      for (int var14 = 0; var14 < var10.length(); var14++) {
         String var15 = String.valueOf(var10.charAt(var14));
         float var16 = field1552.method1016(var15, 0.05F);
         float var17 = var13 + var16 / 2.0F;
         float var18;
         if (var17 <= var7) {
            var18 = 1.0F;
         } else if (var17 >= var8) {
            var18 = 0.0F;
         } else {
            var18 = 1.0F - (var17 - var7) / var6;
         }

         if (var18 > 0.01F) {
            Color var19 = var14 >= var9 ? var12 : var11;
            int var20 = Math.max(0, Math.min(255, (int)(var19.getAlpha() * var18)));
            Color var21 = new Color(var19.getRed(), var19.getGreen(), var19.getBlue(), var20);
            GuiRenderHelper.method1488(var1.method_51448(), field1552, var15, var13, var3, 0.05F, var21);
         }

         var13 += var16;
      }
   }

   private void method1425(class_332 var1, String var2, float var3, float var4, float var5, Color var6) {
      float var7 = 14.0F;
      float var8 = var3 + var5 - var7;
      float var9 = var3 + var5;
      float var10 = var3;

      for (int var11 = 0; var11 < var2.length(); var11++) {
         String var12 = String.valueOf(var2.charAt(var11));
         float var13 = field1552.method1016(var12, 0.05F);
         float var14 = var10 + var13 / 2.0F;
         float var15;
         if (var14 <= var8) {
            var15 = 1.0F;
         } else if (var14 >= var9) {
            var15 = 0.0F;
         } else {
            var15 = 1.0F - (var14 - var8) / var7;
         }

         if (var15 > 0.01F) {
            int var16 = Math.max(0, Math.min(255, (int)(var6.getAlpha() * var15)));
            Color var17 = new Color(var6.getRed(), var6.getGreen(), var6.getBlue(), var16);
            GuiRenderHelper.method1488(var1.method_51448(), field1552, var12, var10, var4, 0.05F, var17);
         }

         var10 += var13;
      }
   }

   public void method1973() {
      this.field1342.method0430();
      this.field0920.method0430();
   }

   public void method0430() {
      if (this.field1342.method0376()) {
         this.field1342.method1973();
      }

      if (this.field0920.method0376()) {
         this.field0920.method1973();
      }
   }

   public boolean method0376() {
      return this.field0920.method0376() || this.field1342.method0376();
   }

   public enum Language implements DisplayNamed {
      field0631("Russian"),
      field0064("English");

      private final String field1504;

      Language(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }
}
