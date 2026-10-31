package aethereal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1735;
import net.minecraft.class_1738;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1829;
import net.minecraft.class_1836;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_2378;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_465;
import net.minecraft.class_5321;
import net.minecraft.class_6880;
import net.minecraft.class_7924;
import net.minecraft.class_9290;
import net.minecraft.class_9334;
import net.minecraft.class_1792.class_9635;
import ua.patch.daamky.api.mixins.accessors.IHandledScreen;

public class AuctionHelper extends Module {
   private static final Pattern field0145 = Pattern.compile("(\\d{1,3}(?:[\\s,._]\\d{3})+|\\d+)");
   private static final long field1412 = 900L;
   private static final float field0957 = 0.35F;
   private static final float field0177 = 1.0F;
   private static final int field0459 = 104;
   private final MultiSelectSetting field1637 = new MultiSelectSetting(
         "auctionhelper.armorfilters", Arrays.asList("No Thorns", "Protection 5"), false, () -> true
      )
      .method1007("Armor Filters")
      .method0210("Filters applied only to armor; other items pass through untouched")
      .method2130("Фильтры для брони");
   private final MultiSelectSetting field1562 = new MultiSelectSetting(
         "auctionhelper.swordfilters", Arrays.asList("Sharpness 7", "No Knockback"), false, () -> true
      )
      .method1007("Sword Filters")
      .method0210("Filters applied only to swords; other items pass through untouched")
      .method2130("Фильтры только для мечей");
   private final ColorSetting field1711 = new ColorSetting("auctionhelper.cheapest", 75, 255, 75, 180)
      .method1007("Cheapest Color")
      .method0210("Highlight color for the cheapest item")
      .method2130("Цвет подсветки самого дешёвого предмета");
   private final ColorSetting field1143 = new ColorSetting("auctionhelper.effective", 255, 75, 75, 180)
      .method1007("Best Per-Item Color")
      .method0210("Highlight color for the lowest price per unit")
      .method2130("Цвет подсветки лучшей цены за штуку");

   public AuctionHelper() {
      super("AuctionHelper", ModuleCategory.field1004, "Highlights the cheapest items in auction-style containers");
      this.method1013("Подсвечивает самые дешёвые предметы на аукционе");
   }

   @EventHandler
   public void onScreenRender(HandledScreenRenderEvent var1) {
      if (!method1974()) {
         class_465 var2 = var1.method1810();
         if (var2 != null) {
            class_332 var3 = var1.method1628();
            IHandledScreen var4 = (IHandledScreen)var2;
            int var5 = var4.daamky$getX();
            int var6 = var4.daamky$getY();
            List var7 = field0796.field_1724.field_7512.field_7761;
            class_1735 var8 = null;
            int var9 = Integer.MAX_VALUE;

            for (class_1735 var11 : var7) {
               if (this.method1207(var11)) {
                  class_1799 var12 = var11.method_7677();
                  if (!var12.method_7960() && this.method1241(var12)) {
                     int var13 = this.method0268(var12);
                     if (var13 >= 0 && var13 < var9) {
                        var9 = var13;
                        var8 = var11;
                     }
                  }
               }
            }

            class_1735 var23 = null;
            double var24 = Double.POSITIVE_INFINITY;
            int var25 = Integer.MAX_VALUE;

            for (class_1735 var15 : var7) {
               if (this.method1207(var15) && var15 != var8) {
                  class_1799 var16 = var15.method_7677();
                  if (!var16.method_7960() && this.method1241(var16)) {
                     int var17 = this.method0268(var16);
                     if (var17 >= 0) {
                        int var18 = Math.max(1, var16.method_7947());
                        double var19 = (double)var17 / var18;
                        boolean var21 = var19 < var24 - 9.999995561963904E-10;
                        boolean var22 = Math.abs(var19 - var24) <= 9.999995561963904E-10;
                        if (var21 || var22 && var17 < var25) {
                           var24 = var19;
                           var25 = var17;
                           var23 = var15;
                        }
                     }
                  }
               }
            }

            var3.method_51448().method_22903();
            var3.method_51448().method_46416(0.0F, 0.0F, 250.0F);
            if (var8 != null) {
               this.method1416(var3, var5, var6, var8, method0956(this.field1711.method1726()));
            }

            if (var23 != null) {
               this.method1416(var3, var5, var6, var23, method0956(this.field1143.method1726()));
            }

            var3.method_51448().method_22909();
         }
      }
   }

   private boolean method1207(class_1735 var1) {
      if (field0796.field_1724 != null && var1 != null) {
         return var1.field_7871 == field0796.field_1724.method_31548() ? false : var1.field_7872 < 104;
      } else {
         return false;
      }
   }

   private boolean method1241(class_1799 var1) {
      class_1792 var2 = var1.method_7909();
      if (var2 instanceof class_1738) {
         if (this.field1637.method0387("No Thorns") && this.method1244(var1, class_1893.field_9097) > 0) {
            return false;
         }

         if (this.field1637.method0387("Protection 5") && this.method1244(var1, class_1893.field_9111) < 5) {
            return false;
         }
      } else if (var2 instanceof class_1829) {
         if (this.field1562.method0387("Sharpness 7") && this.method1244(var1, class_1893.field_9118) < 7) {
            return false;
         }

         if (this.field1562.method0387("No Knockback") && this.method1244(var1, class_1893.field_9121) > 0) {
            return false;
         }
      }

      return true;
   }

   private int method1244(class_1799 var1, class_5321<class_1887> var2) {
      if (field0796.field_1687 == null) {
         return 0;
      }

      class_2378 var3 = field0796.field_1687.method_30349().method_30530(class_7924.field_41265);
      class_6880 var4 = (class_6880<class_1887>)var3.method_10223(var2.method_29177()).orElse(null);
      return var4 == null ? 0 : class_1890.method_8225(var4, var1);
   }

   private void method1416(class_332 var1, int var2, int var3, class_1735 var4, int var5) {
      int var6 = var2 + var4.field_7873;
      int var7 = var3 + var4.field_7872;
      var1.method_25294(var6, var7, var6 + 16, var7 + 16, var5);
   }

   private static int method0956(Color var0) {
      long var1 = System.currentTimeMillis();
      float var3 = (float)(var1 % 900L) / 900.0F;
      float var4 = 0.5F - 0.5F * class_3532.method_15362(var3 * (float) (Math.PI * 2));
      float var5 = class_3532.method_15363(0.35F + 0.65F * var4, 0.0F, 1.0F);
      int var6 = (int)(var0.getAlpha() * var5);
      return var6 << 24 | var0.getRed() << 16 | var0.getGreen() << 8 | var0.getBlue();
   }

   private int method0268(class_1799 var1) {
      List var2 = this.method2156(var1);
      int var3 = Math.max(1, var1.method_7947());
      long var4 = -1L;
      long var6 = -1L;

      for (String var9 : var2) {
         String var10 = method2131(var9);
         if (!var10.isEmpty()) {
            String var11 = var10.toLowerCase();
            if (this.method1847(var11) && !var11.contains("истек") && !var11.contains("expir") && !var11.contains("осталось")) {
               boolean var12 = var11.contains("за шт")
                  || var11.contains("/шт")
                  || var11.contains("шт.")
                  || var11.contains(" per ")
                  || var11.contains(" each ")
                  || var11.contains("за 1 ед");
               long var13 = this.method1043(var10, var11);
               if (var13 > 0L) {
                  if (var12) {
                     if (var13 > var6) {
                        var6 = var13;
                     }
                  } else if (var13 > var4) {
                     var4 = var13;
                  }
               }
            }
         }
      }

      long var15;
      if (var4 > 0L) {
         var15 = var4;
      } else {
         if (var6 <= 0L) {
            return -1;
         }

         var15 = var6 * var3;
      }

      return var15 > 2147483647L ? Integer.MAX_VALUE : (int)var15;
   }

   private List<String> method2156(class_1799 var1) {
      ArrayList var2 = new ArrayList<>();
      List var3 = this.method1860(var1);
      if (var3 != null) {
         for (class_2561 var5 : var3) {
            var2.add(var5.getString());
         }
      }

      class_9290 var8 = (class_9290)var1.method_57824(class_9334.field_49632);
      if (var8 != null) {
         for (class_2561 var6 : var8.comp_2400()) {
            var2.add(var6.getString());
         }
      }

      try {
         var2.add(var1.method_7964().getString());
      } catch (Throwable var7) {
      }

      return var2;
   }

   private long method1043(String var1, String var2) {
      Matcher var3 = field0145.matcher(var1);
      long var4 = -1L;

      while (var3.find()) {
         long var6 = this.method1653(var3.group(1));
         if (var6 > 0L) {
            long var8 = this.method1022(var2, var3.end(1));
            if (var8 != 1L) {
               var6 *= var8;
            }

            if (var6 > var4) {
               var4 = var6;
            }
         }
      }

      return var4;
   }

   private List<class_2561> method1860(class_1799 var1) {
      try {
         return var1.method_7950(class_9635.field_51353, field0796.field_1724, class_1836.field_41070);
      } catch (Throwable var3) {
         return null;
      }
   }

   private static String method2131(String var0) {
      if (var0 == null) {
         return "";
      }

      StringBuilder var1 = new StringBuilder(var0.length());

      for (int var2 = 0; var2 < var0.length(); var2++) {
         char var3 = var0.charAt(var2);
         if (!Character.isSpaceChar(var3) && var3 != '\t' && var3 != '\n' && var3 != '\r') {
            var1.append(var3);
         } else {
            var1.append(' ');
         }
      }

      return var1.toString();
   }

   private boolean method1847(String var1) {
      return var1.contains("цена")
         || var1.contains("price")
         || var1.contains("стоим")
         || var1.contains("монет")
         || var1.contains("coins")
         || var1.contains("коин")
         || var1.contains("$")
         || var1.contains("₽")
         || var1.contains("¤");
   }

   private long method1022(String var1, int var2) {
      if (var2 >= var1.length()) {
         return 1L;
      }

      char var3 = var1.charAt(var2);
      char var4 = var2 + 1 < var1.length() ? var1.charAt(var2 + 1) : '\u0000';
      if (var3 != 'k' && var3 != 1082) {
         if (var3 != 'm' && var3 != 1084) {
            return 1L;
         } else {
            return method0606(var4) ? 1L : 1000000L;
         }
      } else if (var4 == 'k' || var4 == 1082) {
         char var5 = var2 + 2 < var1.length() ? var1.charAt(var2 + 2) : '\u0000';
         return method0606(var5) ? 1L : 1000000L;
      } else {
         return method0606(var4) ? 1L : 1000L;
      }
   }

   private static boolean method0606(char var0) {
      return Character.isLetterOrDigit(var0);
   }

   private long method1653(String var1) {
      long var2 = 0L;

      for (int var4 = 0; var4 < var1.length(); var4++) {
         char var5 = var1.charAt(var4);
         if (var5 >= '0' && var5 <= '9') {
            var2 = var2 * 10L + (var5 - '0');
         }
      }

      return var2;
   }
}
