package aethereal;

import java.awt.Color;
import java.util.function.Supplier;
import lombok.Generated;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_9848;

public class ProxyListEntryWidget {
   private float field0566;
   private float field0003;
   private float field1410;
   private float field0957;
   private final StringBuilder field0792 = new StringBuilder();
   private final Supplier<String> field1271;
   private final boolean field0343;
   private final boolean field0219;
   private final int field0459;
   private final String field1643;
   private boolean field1574;
   private int field1705 = 0;
   private int field1137 = 0;
   private float field1087 = 0.0F;
   private float field1196 = 0.0F;

   public ProxyListEntryWidget(Supplier<String> var1, boolean var2, boolean var3, int var4, String var5) {
      this.field1271 = var1;
      this.field0343 = var2;
      this.field0219 = var3;
      this.field0459 = var4;
      this.field1643 = var5;
   }

   public void method0686(float var1, float var2, float var3, float var4) {
      this.field0566 = var1;
      this.field0003 = var2;
      this.field1410 = var3;
      this.field0957 = var4;
   }

   public void method1013(String var1) {
      this.field0792.setLength(0);
      if (var1 != null) {
         this.field0792.append(var1);
      }

      this.field1705 = this.field0792.length();
      this.field1137 = this.field1705;
      this.field1196 = 0.0F;
   }

   public String method0557() {
      return this.field0792.toString();
   }

   private int method1680() {
      return Math.min(this.field1705, this.field1137);
   }

   private int method1742() {
      return Math.max(this.field1705, this.field1137);
   }

   private boolean method2030() {
      return this.field1705 != this.field1137;
   }

   private void method2015() {
      this.field1137 = this.field1705;
   }

   private String method2040() {
      return this.field0219 ? "*".repeat(this.field0792.length()) : this.field0792.toString();
   }

   public void method1402(class_332 var1, float var2, float var3) {
      FontSize var4 = Fonts.field0075.method0654(6.5F);
      Color var5 = new Color(255, 255, 255, this.field1574 ? 14 : 8);
      GuiRenderHelper.method1462(
         var1.method_51448(), this.field0566, this.field0003, this.field1410, this.field0957, 5.0F, ThemePalette.field0367.get() * 0.6F, new Color(-1)
      );
      GuiRenderHelper.method0326(var1.method_51448(), this.field0566, this.field0003, this.field1410, this.field0957, 5.0F, var5);
      float var6 = this.field0566 + 6.0F;
      if (this.field1643 != null) {
         FontSize var7 = Fonts.field1148.method0654(7.0F);
         float var8 = var7.method0998(this.field1643);
         GuiRenderHelper.method1491(
            var1.method_51448(),
            var7,
            this.field1643,
            this.field0566 + 6.0F,
            this.field0003 + (this.field0957 - var7.method0530()) / 2.0F,
            ThemePalette.field0334
         );
         var6 = this.field0566 + 6.0F + var8 + 6.0F;
      }

      float var25 = this.field0566 + this.field1410 - 4.0F;
      float var26 = var25 - var6;
      String var9 = this.method2040();
      boolean var10 = var9.isEmpty();
      String var11 = var10 ? this.field1271.get() : var9;
      Color var12 = var10 ? ThemePalette.field0207 : ThemePalette.field0789;
      float var13 = var10 ? 0.0F : var4.method0998(var9.substring(0, this.field1705));
      this.field1087 = class_3532.method_16439(0.45F, this.field1087, var13);
      float var14 = var6 + this.field1087 - this.field1196;
      float var15 = var25 - 4.0F;
      float var16 = var6 + 2.0F;
      if (var14 > var15) {
         this.field1196 += var14 - var15;
      } else if (var14 < var16) {
         this.field1196 -= var16 - var14;
      }

      this.field1196 = Math.max(0.0F, this.field1196);
      GuiRenderHelper.method1404(var1, var6 - 1.0F, this.field0003, var26 + 2.0F, this.field0957);
      float var17 = this.field0003 + (this.field0957 - var4.method0530()) / 2.0F;
      float var18 = var6 - this.field1196;
      if (this.field1574 && this.method2030() && !var10) {
         float var19 = var4.method0998(var9.substring(0, this.method1680()));
         float var20 = var4.method0998(var9.substring(0, this.method1742()));
         Color var21 = ThemeColorManager.method1908().method0662(0.35F);
         GuiRenderHelper.method0326(var1.method_51448(), var18 + var19 - 1.2F, var17 - 1.5F, var20 - var19 + 2.4F, var4.method0530() + 3.0F, 2.5F, var21);
      }

      GuiRenderHelper.method1491(var1.method_51448(), var4, var11, var18, var17, var12);
      if (this.field1574) {
         float var27 = this.field0957 * 0.45F;
         float var28 = this.field0003 + (this.field0957 - var27) / 2.0F;
         float var29 = var18 + this.field1087 - 0.85F;
         double var22 = 0.5 + 0.5 * Math.sin(System.currentTimeMillis() / 220.0);
         int var24 = (int)(170.0 + 85.0 * var22);
         GuiRenderHelper.method0326(var1.method_51448(), var29, var28, 1.7F, var27, 0.85F, new Color(class_9848.method_61330(var24, -1), true));
      }

      GuiRenderHelper.method1400(var1);
   }

   public boolean method0627(double var1, double var3, int var5) {
      boolean var6 = MathHelper.method0689(this.field0566, this.field0003, this.field1410, this.field0957, (float)var1, (float)var3);
      if (!var6) {
         this.field1574 = false;
         return false;
      }

      this.field1574 = true;
      FontSize var7 = Fonts.field0075.method0654(6.5F);
      float var8 = this.field0566 + 6.0F;
      if (this.field1643 != null) {
         FontSize var9 = Fonts.field1148.method0654(7.0F);
         var8 = this.field0566 + 6.0F + var9.method0998(this.field1643) + 6.0F;
      }

      String var12 = this.method2040();
      float var10 = (float)var1 - var8 + this.field1196;
      int var11 = this.method1031(var12, var7, var10);
      this.field1705 = var11;
      this.field1137 = var11;
      return true;
   }

   private int method1031(String var1, FontSize var2, float var3) {
      if (!var1.isEmpty() && !(var3 <= 0.0F)) {
         for (int var4 = 1; var4 <= var1.length(); var4++) {
            float var5 = var2.method0998(var1.substring(0, var4));
            float var6 = var2.method0998(var1.substring(0, var4 - 1));
            if (var3 < (var6 + var5) / 2.0F) {
               return var4 - 1;
            }
         }

         return var1.length();
      } else {
         return 0;
      }
   }

   public boolean method0746(int var1, int var2, int var3) {
      if (!this.field1574) {
         return false;
      }

      boolean var4 = (var3 & 2) != 0;
      boolean var5 = (var3 & 1) != 0;
      if (var4 && var1 == 65) {
         this.field1137 = 0;
         this.field1705 = this.field0792.length();
         return true;
      }

      if (var4 && var1 == 67) {
         if (this.method2030()) {
            class_310.method_1551().field_1774.method_1455(this.field0792.substring(this.method1680(), this.method1742()));
         } else {
            class_310.method_1551().field_1774.method_1455(this.field0792.toString());
         }

         return true;
      } else if (var4 && var1 == 88) {
         if (this.method2030()) {
            class_310.method_1551().field_1774.method_1455(this.field0792.substring(this.method1680(), this.method1742()));
            this.method0471();
         } else if (this.field0792.length() > 0) {
            class_310.method_1551().field_1774.method_1455(this.field0792.toString());
            this.field0792.setLength(0);
            this.field1705 = 0;
            this.field1137 = 0;
         }

         return true;
      } else if (var4 && var1 == 86) {
         String var14 = class_310.method_1551().field_1774.method_1460();
         if (var14 != null) {
            if (this.method2030()) {
               this.method0471();
            }

            for (char var10 : var14.toCharArray()) {
               this.method0605(var10);
            }
         }

         return true;
      } else {
         switch (var1) {
            case 256:
            case 257:
            case 258:
            case 335:
               this.field1574 = false;
               return true;
            case 259:
               if (this.method2030()) {
                  this.method0471();
               } else if (this.field1705 > 0) {
                  int var13 = var4 ? this.method2101(this.field1705) : this.field1705 - 1;
                  this.field0792.delete(var13, this.field1705);
                  this.field1705 = var13;
                  this.field1137 = this.field1705;
               }

               return true;
            case 261:
               if (this.method2030()) {
                  this.method0471();
               } else if (this.field1705 < this.field0792.length()) {
                  int var12 = var4 ? this.method1826(this.field1705) : this.field1705 + 1;
                  this.field0792.delete(this.field1705, var12);
               }

               return true;
            case 262:
               int var11 = var4 ? this.method1826(this.field1705) : Math.min(this.field0792.length(), this.field1705 + 1);
               this.field1705 = var11;
               if (!var5) {
                  this.field1137 = this.field1705;
               }

               return true;
            case 263:
               int var6 = var4 ? this.method2101(this.field1705) : Math.max(0, this.field1705 - 1);
               this.field1705 = var6;
               if (!var5) {
                  this.field1137 = this.field1705;
               }

               return true;
            case 268:
               this.field1705 = 0;
               if (!var5) {
                  this.field1137 = this.field1705;
               }

               return true;
            case 269:
               this.field1705 = this.field0792.length();
               if (!var5) {
                  this.field1137 = this.field1705;
               }

               return true;
            default:
               return false;
         }
      }
   }

   public boolean method0607(char var1, int var2) {
      if (!this.field1574) {
         return false;
      }

      if (this.method2030()) {
         this.method0471();
      }

      this.method0605(var1);
      return true;
   }

   private void method0605(char var1) {
      if (var1 >= ' ' && var1 != 127) {
         if (this.field0459 <= 0 || this.field0792.length() < this.field0459) {
            if (!this.field0343 || Character.isDigit(var1)) {
               this.field0792.insert(this.field1705, var1);
               this.field1705++;
               this.field1137 = this.field1705;
            }
         }
      }
   }

   private void method0471() {
      int var1 = this.method1680();
      int var2 = this.method1742();
      this.field0792.delete(var1, var2);
      this.field1705 = var1;
      this.field1137 = var1;
   }

   private int method2101(int var1) {
      int var2 = var1 - 1;

      while (var2 > 0 && Character.isWhitespace(this.field0792.charAt(var2))) {
         var2--;
      }

      while (var2 > 0 && !Character.isWhitespace(this.field0792.charAt(var2 - 1))) {
         var2--;
      }

      return Math.max(0, var2);
   }

   private int method1826(int var1) {
      int var2 = this.field0792.length();
      int var3 = var1;

      while (var3 < var2 && !Character.isWhitespace(this.field0792.charAt(var3))) {
         var3++;
      }

      while (var3 < var2 && Character.isWhitespace(this.field0792.charAt(var3))) {
         var3++;
      }

      return Math.min(var2, var3);
   }

   @Generated
   public float method0002() {
      return this.field0566;
   }

   @Generated
   public float method2047() {
      return this.field0003;
   }

   @Generated
   public float method1762() {
      return this.field1410;
   }

   @Generated
   public float method1603() {
      return this.field0957;
   }

   @Generated
   public StringBuilder method1962() {
      return this.field0792;
   }

   @Generated
   public Supplier<String> method0426() {
      return this.field1271;
   }

   @Generated
   public boolean method0376() {
      return this.field0343;
   }

   @Generated
   public boolean method0499() {
      return this.field0219;
   }

   @Generated
   public int method2214() {
      return this.field0459;
   }

   @Generated
   public String method2191() {
      return this.field1643;
   }

   @Generated
   public boolean method2267() {
      return this.field1574;
   }

   @Generated
   public int method1902() {
      return this.field1705;
   }

   @Generated
   public int method1879() {
      return this.field1137;
   }

   @Generated
   public float method1928() {
      return this.field1087;
   }

   @Generated
   public float method1697() {
      return this.field1196;
   }

   @Generated
   public void method0665(float var1) {
      this.field0566 = var1;
   }

   @Generated
   public void method0124(float var1) {
      this.field0003 = var1;
   }

   @Generated
   public void method2098(float var1) {
      this.field1410 = var1;
   }

   @Generated
   public void method1822(float var1) {
      this.field0957 = var1;
   }

   @Generated
   public void method1570(boolean var1) {
      this.field1574 = var1;
   }

   @Generated
   public void method0729(int var1) {
      this.field1705 = var1;
   }

   @Generated
   public void method0143(int var1) {
      this.field1137 = var1;
   }

   @Generated
   public void method1638(float var1) {
      this.field1087 = var1;
   }

   @Generated
   public void method1977(float var1) {
      this.field1196 = var1;
   }
}
