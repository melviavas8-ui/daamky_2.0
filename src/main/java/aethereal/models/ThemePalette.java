package aethereal;

import java.awt.Color;
import java.util.function.Supplier;

public class ThemePalette {
   public static int field0567 = -1842205;
   private static int field0256 = 14935011;
   public static Color field0134 = new Color(-1);
   public static Supplier<Color> field1514 = () -> ThemeColorManager.method1908().method2063();
   public static Supplier<Color> field1036 = () -> ThemeColorManager.method1908().method0662(0.75F);
   public static Color field0789 = new Color(-1842205);
   public static Color field1268 = new Color(-689708061, true);
   public static Color field0334 = new Color(-1209801757, true);
   public static Color field0207 = new Color(2061755363, true);
   public static Color field0486 = new Color(1038345187, true);
   public static Color field1641 = new Color(518251491, true);
   public static Color field1564 = new Color(182707171, true);
   public static Color field1726 = new Color(98821091, true);
   public static int field1137 = -2960686;
   public static Color field1104 = new Color(210, 210, 210);
   public static Color field1210 = field1726;
   public static Color field0884 = field1564;
   public static Supplier<Color> field0844 = () -> ThemeColorManager.method1908().method0367();
   public static Supplier<Color> field0930 = () -> ThemeColorManager.method1908().method0491();
   public static Supplier<Color> field1349 = () -> ThemeColorManager.method1908().method2222();
   public static Supplier<Color> field1310 = () -> ThemeColorManager.method1908().method2189();
   public static Supplier<Color> field1386 = () -> ThemeColorManager.method1908().method2260();
   public static Supplier<Color> field0402 = () -> ThemeColorManager.method1908().method0141(10);
   public static Supplier<Float> field0367 = () -> ClickGuiDashboard.field0598.method0492() ? ClickGuiDashboard.field0060.method0492() : 0.0F;
   public static Supplier<Boolean> field0439 = () -> true;

   public static void method0578() {
      boolean var0 = ThemeColorManager.method1908().method1974();
      field0256 = var0 ? 1710638 : 14935011;
      field0567 = 0xFF000000 | field0256;
      field0134 = var0 ? new Color(-15066578) : new Color(-1);
      field0789 = new Color(field0567);
      field1268 = new Color(-704643072 | field0256, true);
      field0334 = new Color(-1224736768 | field0256, true);
      field0207 = new Color(2046820352 | field0256, true);
      field0486 = new Color(1023410176 | field0256, true);
      field1641 = new Color(503316480 | field0256, true);
      field1564 = new Color(167772160 | field0256, true);
      field1726 = new Color(83886080 | field0256, true);
      field1137 = var0 ? -14013890 : -2960686;
      field1104 = var0 ? new Color(42, 42, 62) : new Color(210, 210, 210);
      boolean var1 = ThemeColorManager.method1908().method0431();
      if (var1) {
         field1210 = new Color(0, 0, 0, 60);
         field0884 = new Color(0, 0, 0, 100);
      } else {
         field1210 = field1726;
         field0884 = field1564;
      }
   }
}
