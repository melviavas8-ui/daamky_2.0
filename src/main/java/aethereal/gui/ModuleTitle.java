package aethereal;

import java.awt.Color;
import java.util.function.Supplier;
import lombok.Generated;
import net.minecraft.class_332;

public class ModuleTitle extends GuiElement {
   private static final float field0566 = 120.0F;
   private static final float field0003 = 4.0F;
   private static final float field1410 = 4.0F;
   private static final float field0957 = 0.0F;
   private static final float field0177 = 4.0F;
   private static final float field0458 = 2.0F;
   private static final float field1614 = 4.0F;
   private static final float field1538 = 0.05F;
   private static final float field1704 = 6.0F;
   private static final float field1136 = 4.0F;
   private static final float field1087 = 2.5F;
   private static final String field1211 = "d";
   private static FontSize field0879;
   private static FontSize field0834;
   private static boolean field0931 = false;
   private final Supplier<Module> field1349;
   private float field1292 = 1.0F;

   private static void method0375() {
      if (!field0931) {
         field0879 = Fonts.field0075.method0654(6.0F);
         field0834 = Fonts.field0774.method0654(4.0F);
         field0931 = true;
      }
   }

   public void method0665(float var1) {
      this.field1292 = var1;
   }

   @Override
   public float method2047() {
      method0375();
      String var1 = method0830(field0879, this.field1349.get().method0557());
      float var2 = method0173(field0879, var1);
      return 4.0F + field0834.method0998("d") + 2.0F + var2 + 4.0F;
   }

   @Override
   public float method1762() {
      method0375();
      String var1 = method0830(field0879, this.field1349.get().method0557());
      int var2 = method0999(var1);
      return 0.0F + var2 * field0879.method0530() + 4.0F + 4.0F;
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method0375();
      String var5 = method0830(field0879, this.field1349.get().method0557());
      float var6 = this.method0530() + 4.0F + field0834.method0998("d") + 2.0F;
      float var7 = this.method0002() + 0.0F;
      Color var8 = method0964(ThemePalette.field0789, this.field1292);
      GuiRenderHelper.method1491(var1.method_51448(), field0834, "d", this.method0530() + 4.0F, this.method0002() + 2.5F - 1.2F, var8);
      GuiRenderHelper.method1488(var1.method_51448(), field0879, var5, var6, var7, 0.05F, var8);
   }

   private static String method0830(FontSize var0, String var1) {
      float var2 = var0.method1016(var1, 0.05F);
      return var2 > 120.0F ? TextTruncator.method0831(var0, var1, 120.0F) : var1;
   }

   private static int method0999(String var0) {
      int var1 = 1;

      for (int var2 = 0; var2 < var0.length(); var2++) {
         if (var0.charAt(var2) == '\n') {
            var1++;
         }
      }

      return var1;
   }

   private static float method0173(FontSize var0, String var1) {
      float var2 = 0.0F;
      int var3 = 0;

      for (int var4 = 0; var4 <= var1.length(); var4++) {
         if (var4 == var1.length() || var1.charAt(var4) == '\n') {
            float var5 = var0.method1016(var1.substring(var3, var4), 0.05F);
            if (var5 > var2) {
               var2 = var5;
            }

            var3 = var4 + 1;
         }
      }

      return var2;
   }

   private static Color method0964(Color var0, float var1) {
      if (var1 >= 0.99F) {
         return var0;
      }

      int var2 = Math.max(0, Math.min(255, (int)(var0.getAlpha() * var1)));
      return new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), var2);
   }

   @Generated
   public Supplier<Module> method1965() {
      return this.field1349;
   }

   @Generated
   public float method0413() {
      return this.field1292;
   }

   @Generated
   public ModuleTitle(Supplier<Module> var1) {
      this.field1349 = var1;
   }
}
