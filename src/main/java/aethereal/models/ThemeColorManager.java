package aethereal;

import java.awt.Color;
import lombok.Generated;

public class ThemeColorManager {
   private static final ThemeColorManager field0640 = new ThemeColorManager();
   private ThemeColorManager.PalettePreset field0071 = ThemeColorManager.PalettePreset.field1256;
   private boolean field1527 = true;
   private Color field1026 = new Color(4904608);
   private float field0758;
   private float field1242;
   private float field0314;
   private float field0177;
   private float field0458;
   private float field1614;
   private float field1538;
   private float field1704;
   private float field1136;
   private long field1089 = 0L;
   private static final long field1198 = 500L;

   public void method1570(boolean var1) {
      boolean var2 = !this.field1527;
      this.field1527 = var1;
      if (var2 && var1) {
         this.method1691();
      }
   }

   private void method1691() {
      DaamkyClient var1 = DaamkyClient.method2004();
      if (var1 != null) {
         ModuleManager var2 = var1.method1783();
         if (var2 != null) {
            for (Module var4 : var2.method0019()) {
               for (Setting var6 : var4.method1914()) {
                  if (var6 instanceof ColorSetting var7) {
                     var7.method1570(true);
                  }
               }
            }
         }
      }
   }

   public ThemeColorManager() {
      Color var1 = ThemeColorManager.PalettePreset.field1256.method1617();
      this.field0758 = this.field0177 = this.field1538 = var1.getRed();
      this.field1242 = this.field0458 = this.field1704 = var1.getGreen();
      this.field0314 = this.field1614 = this.field1136 = var1.getBlue();
   }

   public void method0850(ThemeColorManager.PalettePreset var1) {
      this.field0071 = var1;
      this.field1538 = this.field0758;
      this.field1704 = this.field1242;
      this.field1136 = this.field0314;
      Color var2 = var1.method0553();
      this.field0177 = var2.getRed();
      this.field0458 = var2.getGreen();
      this.field1614 = var2.getBlue();
      this.field1089 = System.currentTimeMillis();
   }

   public void method0961(Color var1) {
      this.field1026 = var1;
      if (this.field0071 == ThemeColorManager.PalettePreset.field1556) {
         this.field1538 = this.field0758;
         this.field1704 = this.field1242;
         this.field1136 = this.field0314;
         this.field0177 = var1.getRed();
         this.field0458 = var1.getGreen();
         this.field1614 = var1.getBlue();
         this.field1089 = System.currentTimeMillis();
      }
   }

   public void method0578() {
      long var1 = System.currentTimeMillis() - this.field1089;
      float var3 = Math.min(1.0F, (float)var1 / 500.0F);
      var3 = this.method0115(var3);
      this.field0758 = this.field1538 + (this.field0177 - this.field1538) * var3;
      this.field1242 = this.field1704 + (this.field0458 - this.field1704) * var3;
      this.field0314 = this.field1136 + (this.field1614 - this.field1136) * var3;
      ThemePalette.method0578();
   }

   private float method0115(float var1) {
      return 1.0F - (float)Math.pow(1.0F - var1, 3.0);
   }

   public Color method0015() {
      return new Color(
         Math.max(0, Math.min(255, Math.round(this.field0758))),
         Math.max(0, Math.min(255, Math.round(this.field1242))),
         Math.max(0, Math.min(255, Math.round(this.field0314)))
      );
   }

   public Color method0723(int var1) {
      return new Color(
         Math.max(0, Math.min(255, Math.round(this.field0758))),
         Math.max(0, Math.min(255, Math.round(this.field1242))),
         Math.max(0, Math.min(255, Math.round(this.field0314))),
         var1
      );
   }

   public Color method2063() {
      this.method0578();
      return this.method0015();
   }

   public Color method0662(float var1) {
      this.method0578();
      return this.method0723((int)(255.0F * var1));
   }

   public int method1763() {
      this.method0578();
      int var1 = Math.max(0, Math.min(255, Math.round(this.field0758)));
      int var2 = Math.max(0, Math.min(255, Math.round(this.field1242)));
      int var3 = Math.max(0, Math.min(255, Math.round(this.field0314)));
      return 0xFF000000 | var1 << 16 | var2 << 8 | var3;
   }

   public static int method1604() {
      return field0640.method1763();
   }

   public boolean method1974() {
      return false;
   }

   public boolean method0431() {
      return false;
   }

   public Color method0141(int var1) {
      this.method0578();
      int var2 = Math.max(0, Math.min(255, Math.round(this.field0758)));
      int var3 = Math.max(0, Math.min(255, Math.round(this.field1242)));
      int var4 = Math.max(0, Math.min(255, Math.round(this.field0314)));
      if (this.method1974()) {
         int var12 = 240;
         int var13 = 240;
         int var14 = 245;
         float var15 = 0.03F;
         int var17 = (int)(var12 + (var2 - 128) * var15);
         int var20 = (int)(var13 + (var3 - 128) * var15);
         int var23 = (int)(var14 + (var4 - 128) * var15);
         var17 = Math.max(230, Math.min(250, var17));
         var20 = Math.max(230, Math.min(250, var20));
         var23 = Math.max(230, Math.min(250, var23));
         return new Color(var17, var20, var23, var1);
      } else {
         int var5 = 21;
         int var6 = 21;
         int var7 = 21;
         float var8 = 0.03F;
         int var9 = (int)(var5 + (var2 - 128) * var8);
         int var10 = (int)(var6 + (var3 - 128) * var8);
         int var11 = (int)(var7 + (var4 - 128) * var8);
         var9 = Math.max(15, Math.min(30, var9));
         var10 = Math.max(15, Math.min(30, var10));
         var11 = Math.max(15, Math.min(30, var11));
         return new Color(var9, var10, var11, var1);
      }
   }

   public Color method0367() {
      return this.method0141(255);
   }

   public Color method0491() {
      return this.method0141(214);
   }

   public Color method2222() {
      return this.method0141(183);
   }

   public Color method2189() {
      return this.method0141(122);
   }

   public Color method2260() {
      return this.method0141(61);
   }

   public void method0178(ThemeColorManager.PalettePreset var1) {
      this.field0071 = var1;
      Color var2 = var1.method0553();
      this.field0177 = this.field0758 = this.field1538 = var2.getRed();
      this.field0458 = this.field1242 = this.field1704 = var2.getGreen();
      this.field1614 = this.field0314 = this.field1136 = var2.getBlue();
      this.field1089 = 0L;
   }

   public void method0194(Color var1) {
      this.field1026 = var1;
      if (this.field0071 == ThemeColorManager.PalettePreset.field1556) {
         this.field0177 = this.field0758 = this.field1538 = var1.getRed();
         this.field0458 = this.field1242 = this.field1704 = var1.getGreen();
         this.field1614 = this.field0314 = this.field1136 = var1.getBlue();
         this.field1089 = 0L;
      }
   }

   @Generated
   public static ThemeColorManager method1908() {
      return field0640;
   }

   @Generated
   public ThemeColorManager.PalettePreset method1884() {
      return this.field0071;
   }

   @Generated
   public boolean method1938() {
      return this.field1527;
   }

   @Generated
   public Color method1726() {
      return this.field1026;
   }

   public enum PalettePreset {
      field0639(new Color(16750746), "Red"),
      field0071(new Color(16766104), "Orange"),
      field1458(new Color(16751865), "Yellow"),
      field0993(new Color(3492151), "Green"),
      field0772(new Color(10022143), "Cyan"),
      field1256(new Color(4904608), "Blue"),
      field0323(new Color(6632321), "Purple"),
      field0195(new Color(608842), "White"),
      field0474(new Color(9864191), "Violet"),
      field1630(new Color(792721), "Navy"),
      field1556(new Color(4904608), "Custom");

      private final Color field1726;
      private final String field1154;

      PalettePreset(Color var3, String var4) {
         this.field1726 = var3;
         this.field1154 = var4;
      }

      public Color method0553() {
         return this == field1556 ? ThemeColorManager.method1908().method1726() : this.field1726;
      }

      public Color method0723(int var1) {
         Color var2 = this.method0553();
         return new Color(var2.getRed(), var2.getGreen(), var2.getBlue(), var1);
      }

      public Color method0015() {
         return this.method0723(61);
      }

      public Color method2063() {
         return this.method0723(122);
      }

      public Color method1790() {
         return this.method0723(122);
      }

      @Generated
      public Color method1617() {
         return this.field1726;
      }

      @Generated
      public String method1961() {
         return this.field1154;
      }
   }
}
