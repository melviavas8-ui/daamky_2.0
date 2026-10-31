package aethereal;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import net.minecraft.class_9848;

public class ServerSearchOverlay {
   private static final float field0566 = 104.0F;
   private static final float field0003 = 19.0F;
   private static final float field1410 = 6.0F;
   private static final float field0957 = 10.0F;
   private static final float field0758 = 10.0F;
   private static final float field1242 = 4.0F;
   private static final float field0314 = 10.0F;
   private static final float field0177 = 7.0F;
   private static final float field0458 = 2.5F;
   private static final float field1614 = 5.0F;
   private static final float field1538 = 1.5F;
   private static final float field1704 = 3.0F;
   private static final Color field1153 = new Color(255, 255, 255, 80);
   private static final Color field1104 = new Color(255, 255, 255, 15);
   private static final Color field1210 = new Color(255, 255, 255, 40);
   private boolean field0890 = false;
   private float field0826;
   private float field0910;
   private float field1331 = 0.0F;
   private boolean field1312 = false;
   private final Animation field1382 = new Animation(150L, 1.0, false, EasingCurve.field1011);
   private static final int field0386 = 8;
   private static final int field0352 = 8;
   private String field0437 = "";
   private String field0270 = "";
   private String field0237 = "";
   private List<Setting<?>> field0300 = List.of();
   private final Animation[] field0540 = new Animation[8];
   private final Animation[] field0516 = new Animation[8];
   private boolean field0558 = false;
   private int field1672 = -1;
   private float field1657 = 0.0F;
   private float field1688 = 0.0F;
   private final Map<String, Float> field1596 = new HashMap<>();
   private static final float field1577 = 0.32F;
   private static final float field1601 = 11.0F;
   private static final float field1753 = 1.5F;
   private static final float field1739 = 12.0F;

   public ServerSearchOverlay() {
      for (int var1 = 0; var1 < 8; var1++) {
         this.field0540[var1] = new Animation(200L, 1.0, false, EasingCurve.field1477);
      }

      for (int var2 = 0; var2 < 8; var2++) {
         this.field0516[var2] = new Animation(250L, 1.0, true, EasingCurve.field0672);
      }
   }

   public void method0703(float var1, float var2, String var3) {
      NewHUD var4 = this.method1955();
      if (var4 != null) {
         this.field0437 = var3;
         this.field0300 = var4.method2132(var3);
         this.field0558 = var3.equals("NewServerInfo");
         if (!this.field0300.isEmpty() || this.field0558) {
            this.field0237 = var4.method1844(var3);
            this.field0270 = var4.method1655(var3);
            int var5 = 0;

            for (int var6 = 0; var6 < this.field0300.size(); var6++) {
               if (this.field0300.get(var6) instanceof BooleanSetting var7) {
                  this.field0540[var6].method1570(var7.method0492());
               } else if (this.field0300.get(var6) instanceof EnumSetting var8) {
                  Enum[] var18 = (Enum<?>[])var8.method0492().getClass().getEnumConstants();

                  for (Enum var13 : var18) {
                     if (var5 < 8) {
                        this.field0516[var5].method1570(var8.method0492() == var13);
                        this.field0516[var5].method1973();
                        var5++;
                     }
                  }
               }
            }

            this.field1672 = -1;
            this.field1596.clear();
            float var14 = ScreenLayoutHelper.method2047();
            float var15 = ScreenLayoutHelper.method1762();
            float var16 = this.method1603();
            this.field0826 = var1;
            this.field0910 = var2;
            if (this.field0826 + 104.0F > var14) {
               this.field0826 = var14 - 104.0F - 4.0F;
            }

            if (this.field0910 + var16 > var15) {
               this.field0910 = var15 - var16 - 4.0F;
            }

            if (this.field0826 < 4.0F) {
               this.field0826 = 4.0F;
            }

            if (this.field0910 < 4.0F) {
               this.field0910 = 4.0F;
            }

            this.field0890 = true;
            this.field1312 = true;
         }
      }
   }

   public void method0578() {
      this.field1312 = false;
      this.field1672 = -1;
   }

   public boolean method0026() {
      return this.field0890;
   }

   public boolean method1014(String var1) {
      NewHUD var2 = this.method1955();
      if (var2 == null) {
         return false;
      } else {
         return var1.equals("NewServerInfo") ? true : !var2.method2132(var1).isEmpty();
      }
   }

   private float method2047() {
      float var1 = this.field0910 + 19.0F + 6.0F;
      if (!this.field0300.isEmpty()) {
         for (Setting var3 : this.field0300) {
            var1 += 14.0F;
            if (var3 instanceof EnumSetting) {
               var1 += 12.0F;
            }
         }

         var1 -= 4.0F;
         var1 += 6.0F;
      }

      return var1;
   }

   private int method1763() {
      NewHUD var1 = this.method1955();
      return var1 != null && this.field0558 ? var1.method2025().size() : 0;
   }

   private float method1603() {
      float var1 = 25.0F;
      if (!this.field0300.isEmpty()) {
         for (Setting var3 : this.field0300) {
            var1 += 14.0F;
            if (var3 instanceof EnumSetting) {
               var1 += 12.0F;
            }
         }

         var1 -= 4.0F;
      }

      if (this.field0558) {
         int var4 = this.method1763();
         if (!this.field0300.isEmpty()) {
            var1 += 6.0F;
         }

         var1 += var4 * 10.0F + (var4 > 1 ? (var4 - 1) * 4.0F : 0.0F);
      }

      return var1 + 6.0F;
   }

   private NewHUD method1955() {
      return DaamkyClient.method2004().method1783().method0976(NewHUD.class);
   }

   public void method1414(class_332 var1, int var2, int var3, float var4) {
      if (this.field0890) {
         float var5 = this.field1312 ? 1.0F : 0.0F;
         this.field1331 = this.field1331 + (var5 - this.field1331) * 0.22F;
         if (Math.abs(var5 - this.field1331) < 0.004F) {
            this.field1331 = var5;
         }

         if (!this.field1312 && this.field1331 <= 0.005F) {
            this.field1331 = 0.0F;
            this.field0890 = false;
         } else {
            float var6 = this.field1331;
            class_4587 var7 = var1.method_51448();
            float var8 = this.method1603();
            float var9 = 0.94F + 0.06F * this.field1331;
            float var10 = this.field0826 + 52.0F;
            float var11 = this.field0910 + var8;
            var7.method_22903();
            var7.method_46416(var10, var11, 0.0F);
            var7.method_22905(var9, var9, 1.0F);
            var7.method_46416(-var10, -var11, 0.0F);
            Color var12 = ThemeColorManager.method1908().method0141(224);
            GuiRenderHelper.method1462(var7, this.field0826, this.field0910, 104.0F, var8, 10.0F, 14.0F, method0964(Color.WHITE, var6));
            GuiRenderHelper.method1463(var7, this.field0826, this.field0910, 104.0F, var8, 10.0F, method0964(var12, var6));
            FontSize var13 = Fonts.field0075.method0654(5.5F);
            FontSize var14 = Fonts.field0774.method0654(5.5F);
            Color var15 = ThemeColorManager.method1908().method2063();
            float var16 = this.field0910 + 6.0F;
            float var17 = this.field0826 + 6.0F;
            if (!this.field0270.isEmpty()) {
               GuiRenderHelper.method1491(var7, var14, this.field0270, var17, var16, method0964(var15, var6));
               var17 += var14.method0998(this.field0270) + 3.0F;
            }

            float var18 = this.field0910 + 8.0F - 1.5F;
            GuiRenderHelper.method0326(var7, var17, var18, 1.3F, 6.0F, 0.2F, method0964(field1153, var6));
            var17 += 3.5F;
            GuiRenderHelper.method1491(var7, var13, this.field0237, var17, var16, method0964(Color.WHITE, var6));
            FontSize var19 = Fonts.field0774.method0654(4.0F);
            float var20 = var19.method0998("F");
            float var21 = var19.method0530();
            float var22 = this.field0826 + 104.0F - 6.0F - var20 - 4.0F;
            float var23 = var16 + 1.0F;
            float var24 = 3.0F;
            boolean var25 = this.field1331 > 0.5F
               && MathHelper.method0689(var22 - var24, var23 - var24, var20 + var24 * 2.0F, var21 + var24 * 2.0F, var2, var3);
            if (this.field1382.method0376() != var25) {
               this.field1382.method1570(var25);
            }

            float var26 = this.field1382.method0002();
            int var27 = (int)(170.0F + 70.0F * var26);
            int var28 = (int)(170.0F + 70.0F * var26);
            int var29 = (int)(170.0F + 80.0F * var26);
            int var30 = (int)(2.55F * (52.0F + 90.0F * var26));
            Color var31 = new Color(Math.min(255, var27), Math.min(255, var28), Math.min(255, var29), Math.min(255, var30));
            float var32 = 1.0F + 0.18F * var26;
            float var33 = var22 + var20 / 2.0F;
            float var34 = var23 + var21 / 2.0F;
            var7.method_22903();
            var7.method_46416(var33, var34, 0.0F);
            var7.method_22905(var32, var32, 1.0F);
            var7.method_46416(-var33, -var34, 0.0F);
            GuiRenderHelper.method1491(var7, var19, "F", var22, var23, method0964(var31, var6));
            var7.method_22909();
            float var35 = this.field0910 + 19.0F - 0.5F;
            GuiRenderHelper.method1463(var7, this.field0826, var35, 104.0F, 0.5F, 0.0F, method0964(new Color(255, 255, 255, 10), var6));
            FontSize var36 = Fonts.field0075.method0654(5.5F);
            float var37 = this.field0910 + 19.0F + 6.0F;
            int var38 = 0;
            FontSize var39 = Fonts.field0774.method0654(4.0F);

            for (int var40 = 0; var40 < this.field0300.size(); var40++) {
               Setting var41 = this.field0300.get(var40);
               float var42 = var37 + (10.0F - var36.method0530()) / 2.0F;
               if (var41 instanceof EnumSetting) {
                  GuiRenderHelper.method1491(var7, var39, "g", this.field0826 + 6.0F, var42 + 1.0F, method0964(var15, var6));
                  GuiRenderHelper.method1491(
                     var7, var36, var41.method2067(), this.field0826 + 6.0F + var39.method0998("g") + 2.0F, var42, method0964(Color.WHITE, var6)
                  );
               } else {
                  GuiRenderHelper.method1491(var7, var39, "r", this.field0826 + 6.0F, var42 + 1.0F, method0964(var15, var6));
                  GuiRenderHelper.method1491(
                     var7, var36, var41.method2067(), this.field0826 + 6.0F + var39.method0998("r") + 2.0F, var42, method0964(Color.WHITE, var6)
                  );
               }

               if (var41 instanceof BooleanSetting var43) {
                  if (this.field0540[var40].method0376() != var43.method0492()) {
                     this.field0540[var40].method1570(var43.method0492());
                  }

                  float var45 = this.field0826 + 104.0F - 6.0F - 10.0F;
                  float var46 = var37 + 1.5F;
                  float var47 = this.field0540[var40].method0002();
                  int var48 = class_9848.method_61319(
                     var47, method0195(new Color(255, 255, 255, (int)(2.55F * (12.0F + 12.0F * var47))), var6), method0195(var15, var6)
                  );
                  int var49 = method0195(new Color(246, 247, 255, 255), var6);
                  GuiRenderHelper.method0326(var7, var45, var46, 10.0F, 7.0F, 2.5F, new Color(var48, true));
                  GuiRenderHelper.method0326(var7, var45 + 1.0F + 3.0F * var47, var46 + 1.0F, 5.0F, 5.0F, 1.5F, new Color(var49, true));
               } else if (var41 instanceof EnumSetting var44) {
                  float var64 = var37 + 10.0F + 1.0F;
                  float var66 = this.field0826 + 6.0F - 2.0F;
                  FontSize var68 = Fonts.field0774.method0654(5.0F);
                  Enum[] var70 = (Enum<?>[])var44.method0492().getClass().getEnumConstants();

                  for (int var72 = 0; var72 < var70.length; var72++) {
                     Enum var50 = var70[var72];
                     boolean var51 = var44.method0492() == var50;
                     if (var38 < 8) {
                        if (this.field0516[var38].method0376() != var51) {
                           this.field0516[var38].method1570(var51);
                        }

                        float var52 = var51 ? this.field0516[var38].method0002() : 0.0F;
                        String var53 = ((DisplayNamed)var50).method0557();
                        float var54 = 8.0F + var36.method0998(var53) + (var51 ? 8 : 0);
                        int var55 = class_9848.method_61319(
                           var52, method0195(new Color(255, 255, 255, (int)(2.55F * (2.0F + 10.0F * var52))), var6), method0195(var15, var6)
                        );
                        int var56 = method0195(new Color(246, 247, 255, (int)(2.55F * (24.0F + 24.0F * var52 + 52.0F))), var6);
                        int var57 = method0195(new Color(246, 247, 255, (int)(2.55F * (24.0F * var52 + 76.0F * var52))), var6);
                        GuiRenderHelper.method1463(var7, var66, var64, var54, 11.0F, 2.0F, new Color(var55, true));
                        GuiRenderHelper.method1488(var7, var68, "q", var66 + 4.0F, var64 + 2.5F, 0.1F, new Color(var57, true));
                        GuiRenderHelper.method1488(
                           var7, var36, var53, var66 + var54 - 4.0F - var36.method0998(var53), var64 + 2.0F, 0.05F, new Color(var56, true)
                        );
                        var66 += var54 + 1.5F;
                        var38++;
                     }
                  }
               }

               var37 += 14.0F;
               if (var41 instanceof EnumSetting) {
                  var37 += 12.0F;
               }
            }

            if (this.field0558) {
               NewHUD var59 = this.method1955();
               if (var59 != null) {
                  List var60 = var59.method2025();
                  if (!this.field0300.isEmpty()) {
                     GuiRenderHelper.method1463(var7, this.field0826 + 6.0F, var37 - 2.0F, 92.0F, 0.5F, 0.0F, method0964(field1153, var6));
                  }

                  float var61 = this.method2047();
                  FontSize var62 = Fonts.field0774.method0654(4.0F);
                  float var63 = var61;
                  float var65 = var61 + (var60.size() - 1) * 14.0F;

                  for (int var67 = 0; var67 < var60.size(); var67++) {
                     String var69 = var60.get(var67);
                     float var71 = var61 + var67 * 14.0F;
                     float var74;
                     if (this.field1672 == var67) {
                        float rowYx = this.field1688 - this.field1657;
                        var74 = Math.max(var63, Math.min(var65, rowYx));
                        this.field1596.put(var69, var74);
                        GuiRenderHelper.method0326(var7, this.field0826 + 6.0F - 2.0F, var74 - 1.0F, 96.0F, 12.0F, 3.0F, method0964(field1104, var6));
                     } else {
                        float var75 = this.field1596.getOrDefault(var69, var71);
                        var75 += (var71 - var75) * 0.32F;
                        if (Math.abs(var71 - var75) < 0.1F) {
                           var75 = var71;
                        }

                        this.field1596.put(var69, var75);
                        var74 = var75;
                     }

                     float var77 = var74 + (10.0F - var36.method0530()) / 2.0F;
                     GuiRenderHelper.method1491(
                        var7, var62, "g", this.field0826 + 6.0F, var74 + (10.0F - var62.method0530()) / 2.0F, method0964(field1210, var6)
                     );
                     float var78 = this.field0826 + 6.0F + var62.method0998("g") + 4.0F;
                     Color var79 = this.field1672 == var67 ? method0964(var15, var6) : method0964(Color.WHITE, var6);
                     GuiRenderHelper.method1491(var7, var36, var69, var78, var77, var79);
                  }
               }
            }

            var7.method_22909();
         }
      }
   }

   public boolean method0627(double var1, double var3, int var5) {
      if (!this.field0890) {
         return false;
      }

      float var6 = this.method1603();
      if (!MathHelper.method0689(this.field0826, this.field0910, 104.0F, var6, (float)var1, (float)var3)) {
         this.method0578();
         return false;
      }

      if (var5 == 0) {
         FontSize var7 = Fonts.field0774.method0654(4.0F);
         float var8 = var7.method0998("F");
         float var9 = var7.method0530();
         float var10 = this.field0826 + 104.0F - 6.0F - var8 - 4.0F;
         float var11 = this.field0910 + 6.0F + 1.0F;
         float var12 = 3.0F;
         if (MathHelper.method0689(var10 - var12, var11 - var12, var8 + var12 * 2.0F, var9 + var12 * 2.0F, (float)var1, (float)var3)) {
            this.method0578();
            return true;
         }

         float var13 = this.field0910 + 19.0F + 6.0F;
         int var14 = 0;

         for (int var15 = 0; var15 < this.field0300.size(); var15++) {
            Setting var16 = this.field0300.get(var15);
            if (var16 instanceof BooleanSetting var17) {
               if (MathHelper.method0689(this.field0826, var13, 104.0F, 10.0F, (float)var1, (float)var3)) {
                  var17.method0206(!var17.method0492());
                  this.field0540[var15].method1570(var17.method0492());
                  this.field0540[var15].method1634();
                  DaamkyClient.method2004().method2216().method1634();
                  return true;
               }
            } else if (var16 instanceof EnumSetting var18) {
               float var19 = var13 + 10.0F + 1.0F;
               float var20 = this.field0826 + 6.0F - 2.0F;
               FontSize var21 = Fonts.field0075.method0654(5.5F);
               Enum[] var22 = (Enum<?>[])var18.method0492().getClass().getEnumConstants();

               for (int var23 = 0; var23 < var22.length; var23++) {
                  Enum var24 = var22[var23];
                  boolean var25 = var18.method0492() == var24;
                  String var26 = ((DisplayNamed)var24).method0557();
                  float var27 = 8.0F + var21.method0998(var26) + (var25 ? 8 : 0);
                  if (MathHelper.method0689(var20, var19, var27, 11.0F, (float)var1, (float)var3)) {
                     var18.method0442(((DisplayNamed)var24).method0557());
                     if (var14 < 8) {
                        this.field0516[var14].method1634();
                     }

                     DaamkyClient.method2004().method2216().method1634();
                     return true;
                  }

                  var20 += var27 + 1.5F;
                  var14++;
               }
            }

            var13 += 14.0F;
            if (var16 instanceof EnumSetting) {
               var13 += 12.0F;
            }
         }

         if (this.field0558) {
            float var28 = this.method2047();
            int var29 = this.method1763();

            for (int var30 = 0; var30 < var29; var30++) {
               float var31 = var28 + var30 * 14.0F;
               if (MathHelper.method0689(this.field0826, var31, 104.0F, 10.0F, (float)var1, (float)var3)) {
                  this.field1672 = var30;
                  this.field1657 = (float)var3 - var31;
                  this.field1688 = (float)var3;
                  return true;
               }
            }
         }
      }

      return true;
   }

   public void method0615(double var1, double var3) {
      if (this.field1672 >= 0) {
         this.field1688 = (float)var3;
         this.method0430();
      }
   }

   public void method0111(double var1, double var3, int var5) {
      if (this.field1672 >= 0 && var5 == 0) {
         this.field1672 = -1;
      }
   }

   private void method0430() {
      NewHUD var1 = this.method1955();
      if (var1 != null) {
         List var2 = var1.method2025();
         if (this.field1672 >= 0 && this.field1672 < var2.size()) {
            float var3 = this.method2047();
            float var4 = this.field1688 - this.field1657 + 5.0F;
            int var5 = Math.round((var4 - var3) / 14.0F);
            var5 = Math.max(0, Math.min(var2.size() - 1, var5));
            if (var5 != this.field1672) {
               var1.method0738(this.field1672, var5);
               this.field1672 = var5;
               DaamkyClient.method2004().method2216().method1634();
            }
         }
      }
   }

   private static Color method0964(Color var0, float var1) {
      return var1 >= 0.99F ? var0 : new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), Math.max(0, Math.min(255, (int)(var0.getAlpha() * var1))));
   }

   private static int method0195(Color var0, float var1) {
      int var2 = Math.max(0, Math.min(255, (int)(var0.getAlpha() * var1)));
      return var2 << 24 | var0.getRed() << 16 | var0.getGreen() << 8 | var0.getBlue();
   }
}
