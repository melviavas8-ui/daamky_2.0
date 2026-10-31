package aethereal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1074;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1934;
import net.minecraft.class_2561;
import net.minecraft.class_2678;
import net.minecraft.class_268;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_408;
import net.minecraft.class_4081;
import net.minecraft.class_4587;
import net.minecraft.class_640;
import net.minecraft.class_742;
import net.minecraft.class_7439;
import net.minecraft.class_7923;

public class NewHUD extends Module {
   private Color field0134 = new Color(21, 21, 27, 224);
   private static final Color field1500 = new Color(255, 255, 255, 55);
   private static final Color field1026 = new Color(255, 255, 255, 80);
   private static final Color field0207 = new Color(255, 255, 255, 10);
   private static final Color field0486 = new Color(255, 255, 255, 41);
   private static final Color field1641 = new Color(255, 255, 255);
   private static final Color field1564 = new Color(210, 210, 210);
   private static final Color field1726 = new Color(255, 255, 255, 184);
   private Color field1153 = new Color(74, 214, 160);
   private static final Color field1104 = new Color(255, 255, 255);
   private static final Color field1210 = new Color(60, 60, 70);
   private static final Color field0884 = new Color(37, 37, 50);
   private static final Color field0840 = new Color(255, 255, 255, 184);
   private static final Color field0927 = new Color(255, 255, 255, 122);
   private static final Color field1346 = new Color(255, 255, 255, 184);
   private static final Color field1307 = new Color(255, 255, 255, 10);
   private static final Color field1383 = new Color(255, 255, 255, 41);
   private static final Color field0399 = new Color(32, 32, 44);
   private static final Color field0364 = new Color(37, 37, 50);
   private static final Color field0436 = new Color(37, 37, 50);
   private static final Color field0269 = new Color(146, 146, 158);
   private static final Color field0236 = new Color(95, 95, 111);
   private static final Color field0298 = new Color(28, 28, 38);
   private static final Color field0533 = new Color(72, 72, 86);
   private static final float field0501 = 14.0F;
   private static final float field0547 = 10.0F;
   private final MultiSelectSetting field1680 = new MultiSelectSetting(
         "newhud.elements",
         Arrays.asList("Watermark", "Info", "Inventory", "ArmorHUD", "KeyBinds", "Potions", "Notifications", "TargetHud", "StaffList"),
         false,
         () -> true
      )
      .method1007("Elements")
      .method0210("HUD elements to display")
      .method2130("Отображаемые элементы интерфейса");
   private final BooleanSetting field1659 = new BooleanSetting("newhud.watermark.username", true)
      .method1007("Show Username")
      .method0210("Display username in the watermark")
      .method2130("Отображать имя пользователя в водяном знаке");
   private final BooleanSetting field1691 = new BooleanSetting("newhud.blur", true)
      .method1007("Blur")
      .method0210("Apply background blur to HUD elements")
      .method2130("Применить размытие фона к элементам интерфейса");
   private final List<String> field1595 = new ArrayList<>(List.of("Server", "FPS", "Ping"));
   private final BooleanSetting field1580 = new BooleanSetting("newhud.watermark.blur", true)
      .method1007("Blur")
      .method0210("Background blur")
      .method2130("Размытие фона");
   private final BooleanSetting field1604 = new BooleanSetting("newhud.info.blur", true)
      .method1007("Blur")
      .method0210("Background blur")
      .method2130("Размытие фона");
   private final BooleanSetting field1756 = new BooleanSetting("newhud.inventory.blur", true)
      .method1007("Blur")
      .method0210("Background blur")
      .method2130("Размытие фона");
   private final BooleanSetting field1743 = new BooleanSetting("newhud.armor.blur", true)
      .method1007("Blur")
      .method0210("Background blur")
      .method2130("Размытие фона");
   private final EnumSetting<NewHUD.DurabilityMode> field1768 = new EnumSetting<>("newhud.armor.durmode", NewHUD.DurabilityMode.field0664)
      .method1007("Durability Mode")
      .method0210("How armor durability is displayed")
      .method2130("Формат отображения прочности брони");
   private final BooleanSetting field1176 = new BooleanSetting("newhud.keybinds.blur", true)
      .method1007("Blur")
      .method0210("Background blur")
      .method2130("Размытие фона");
   private final BooleanSetting field1166 = new BooleanSetting("newhud.keybinds.renderEmpty", false)
      .method1007("Render When Empty")
      .method0210("Render even with no active keybinds")
      .method2130("Рендерить когда нет активных кейбиндов");
   private final BooleanSetting field1188 = new BooleanSetting("newhud.potions.blur", true)
      .method1007("Blur")
      .method0210("Background blur")
      .method2130("Размытие фона");
   private final BooleanSetting field1121 = new BooleanSetting("newhud.potions.renderEmpty", false)
      .method1007("Render When Empty")
      .method0210("Render even with no active potions")
      .method2130("Рендерить когда нет активных зелий");
   private final BooleanSetting field1114 = new BooleanSetting("newhud.notifications.blur", true)
      .method1007("Blur")
      .method0210("Background blur")
      .method2130("Размытие фона");
   private final EnumSetting<NewHUD.NotificationDirection> field1131 = new EnumSetting<>("newhud.notifications.direction", NewHUD.NotificationDirection.field0092)
      .method1007("Direction")
      .method0210("Slide direction")
      .method2130("Направление появления");
   private final BooleanSetting field1229 = new BooleanSetting("newhud.targethud.blur", true)
      .method1007("Blur")
      .method0210("Background blur")
      .method2130("Размытие фона");
   private final BooleanSetting field1221 = new BooleanSetting("newhud.targethud.particles", true)
      .method1007("Particles")
      .method0210("HP loss particles")
      .method2130("Частицы потери здоровья");
   private final BooleanSetting field1235 = new BooleanSetting("newhud.stafflist.blur", true)
      .method1007("Blur")
      .method0210("Background blur")
      .method2130("Размытие фона");
   private final BooleanSetting field0900 = new BooleanSetting("newhud.stafflist.renderEmpty", false)
      .method1007("Render When Empty")
      .method0210("Render even with no staff online")
      .method2130("Рендерить когда нет администрации");
   private final BooleanSetting field0894 = new BooleanSetting("newhud.stafflist.notify", true)
      .method1007("Notifications")
      .method0210("Staff join/leave alerts")
      .method2130("Уведомления о входе/выходе стаффа");
   private boolean field0907 = false;
   private String field0859 = "";
   private int field0848;
   private int field0864;
   private String field0942 = "0";
   private String field0936 = "0";
   private String field0951 = "20.0";
   private String field1358 = "0";
   private String field1352 = "0";
   private String field1362 = "0";
   private List<Module> field1323 = Collections.emptyList();
   private final List<class_1293> field1318 = new ArrayList<>();
   private final List<class_1293> field1327 = new ArrayList<>();
   private final Set<String> field1400 = new HashSet<>();
   private final Map<String, Integer> field1392 = new HashMap<>();
   private final Map<class_2960, HudAnimation> field1405 = new HashMap<>();
   private final Set<String> field0414 = new HashSet<>();
   private final Map<String, class_2960> field0409 = new HashMap<>();
   private final Map<Integer, Float> field0420 = new HashMap<>();
   private class_1799 field0377 = class_1799.field_8037;
   private long field0372;
   private boolean field0382;
   private final Animation field0450 = new Animation(250L, 1.0, false, EasingCurve.field1011);
   private final Animation field0445 = new Animation(250L, 1.0, false, EasingCurve.field1011);
   private final Animation field0454 = new Animation(250L, 1.0, false, EasingCurve.field1011);
   private final Animation field0281 = new Animation(250L, 1.0, false, EasingCurve.field1011);
   private final Animation field0275 = new Animation(250L, 1.0, false, EasingCurve.field1011);
   private final Animation field0286 = new Animation(250L, 1.0, false, EasingCurve.field1011);
   private final Animation field0248 = new Animation(250L, 1.0, false, EasingCurve.field1011);
   private final Animation field0245 = new Animation(250L, 1.0, false, EasingCurve.field1011);
   private final Animation field0253 = new Animation(250L, 1.0, false, EasingCurve.field1011);
   private final Animation field0308 = new Animation(200L, 1.0, false, EasingCurve.field0203);
   private final Animation field0305 = new Animation(250L, 1.0, false, EasingCurve.field1011);
   private class_1309 field0312;
   private final HudAnimation field0544 = new HudAnimation(EasingCurve.field0203);
   private final HudAnimation field0541 = new HudAnimation(EasingCurve.field0203);
   private float field0545 = -1.0F;
   private final List<float[]> field0520 = new ArrayList<>();
   private static final class_2960 field0517 = class_2960.method_60655("daamky", "textures/glow.png");
   private static final Pattern field0522 = Pattern.compile("^\\w{3,16}$");
   private static final Pattern field0562 = Pattern.compile(
      ".*(mod|der|adm|wne|гм|medi|мод|модер|адм|админ|хелп|хелпер|стаж|taf|yout|curat|куратор|dev|разраб|supp|саппорт|yt|ют)(?<!D\\.HELPER).*", 2
   );
   private static final int field0560 = 10;
   private final Map<String, Animation> field0563 = new HashMap<>();
   private final Map<String, NewHUD.NotificationEntry> field1685 = new HashMap<>();
   private final Map<String, Long> field1684 = new HashMap<>();
   private final Map<String, class_2960> field1686 = new HashMap<>();
   private final Set<String> field1668 = new HashSet<>();
   private final LinkedHashSet<String> field1667 = new LinkedHashSet<>();
   private boolean field1669 = false;
   private final Animation field1701 = new Animation(250L, 1.0, false, EasingCurve.field1011);
   private final HudAnimation field1700 = new HudAnimation(EasingCurve.field0203);
   private static final Color field1702 = new Color(92, 218, 19);
   private static final Color field1599 = new Color(193, 107, 46);
   private static final Color field1598 = new Color(214, 214, 214);
   private static final Color field1600 = new Color(202, 40, 40);
   private static final CopyOnWriteArrayList<NewHUD.HudEntry> field1588 = new CopyOnWriteArrayList<>();
   private final HudAnimation field1587 = new HudAnimation(EasingCurve.field0203);
   private final HudAnimation field1589 = new HudAnimation(EasingCurve.field0203);
   private final HudAnimation field1611 = new HudAnimation(EasingCurve.field0203);
   private final HudAnimation field1610 = new HudAnimation(EasingCurve.field0203);
   private final Animation field1612 = new Animation(180L, 1.0, false, EasingCurve.field1011);
   private final Animation field1764 = new Animation(150L, 1.0, false, EasingCurve.field1011);
   private float field1763 = 0.0F;
   private float field1765 = 0.0F;
   private float field1751 = 0.0F;
   private float field1750 = 0.0F;
   private long field1752 = 0L;
   private final HudAnimation field1776 = new HudAnimation(EasingCurve.field0203);
   private final HudAnimation field1775 = new HudAnimation(EasingCurve.field0203);
   private float field1777 = Float.NaN;
   private final HudAnimation field1183 = new HudAnimation(EasingCurve.field0203);
   private final HudAnimation field1182 = new HudAnimation(EasingCurve.field0203);
   private final HudAnimation field1184 = new HudAnimation(EasingCurve.field0203);
   private final HudAnimation field1172 = new HudAnimation(EasingCurve.field0203);
   private final HudAnimation field1171 = new HudAnimation(EasingCurve.field0203);
   private final Animation field1173 = new Animation(200L, 1.0, false, EasingCurve.field1011);
   private static final String[] field1193 = new String[]{"Q", "R", "S", "U", "I", "w", "s", "T", "D"};
   private static final String[] field1192 = new String[]{
      "NewWatermark", "NewServerInfo", "NewInventory", "NewArmorHUD", "NewKeyBinds", "NewPotions", "NewNotifications", "NewTargetHud", "NewStaffList"
   };
   private final Animation field1194 = new Animation(200L, 1.0, false, EasingCurve.field1011);
   private String field1127 = "";
   private static final Color field1126 = new Color(255, 255, 255, 5);
   private static final Color field1128 = new Color(255, 255, 255, 10);
   private static final Color field1117 = new Color(255, 255, 255, 123);

   public static void method1036(String var0, ModuleCategory var1, boolean var2) {
      field1588.add(new NewHUD.HudEntry(var0, var1, var2));
      if (field1588.size() > 5) {
         field1588.remove(0);
      }
   }

   public static void method1050(String var0, String var1, String var2, boolean var3) {
      field1588.add(new NewHUD.HudEntry(var0, var1, var2, var3));
      if (field1588.size() > 5) {
         field1588.remove(0);
      }
   }

   public static void method1053(String var0, String var1, class_1799 var2, boolean var3) {
      field1588.add(new NewHUD.HudEntry(var0, var1, null, var2, var3));
      if (field1588.size() > 5) {
         field1588.remove(0);
      }
   }

   public static void method1051(String var0, String var1, List<class_1799> var2, boolean var3) {
      field1588.add(new NewHUD.HudEntry(var0, var1, null, null, var2, null, null, var3));
      if (field1588.size() > 5) {
         field1588.remove(0);
      }
   }

   public static void method1054(String var0, String var1, class_2960 var2, boolean var3) {
      field1588.add(new NewHUD.HudEntry(var0, var1, null, null, var2, var3));
      if (field1588.size() > 5) {
         field1588.remove(0);
      }
   }

   public static void method1350(class_2561 var0, String var1, boolean var2) {
      String var3 = var0 == null ? "" : var0.getString();
      field1588.add(new NewHUD.HudEntry(var3, "", var1, var2));
      if (field1588.size() > 5) {
         field1588.remove(0);
      }
   }

   public static void method1351(class_2561 var0, class_1799 var1, boolean var2) {
      String var3 = var0 == null ? "" : var0.getString();
      field1588.add(new NewHUD.HudEntry(var3, "", null, var1, null, null, var2));
      if (field1588.size() > 5) {
         field1588.remove(0);
      }
   }

   public static void method0220(String var0, String var1, class_2960 var2, boolean var3) {
      field1588.add(new NewHUD.HudEntry(var0, var1, null, null, null, var2, var3));
      if (field1588.size() > 5) {
         field1588.remove(0);
      }
   }

   public static void method1735() {
      NewHUD var0 = DaamkyClient.method2004().method1783().method0976(NewHUD.class);
      if (var0 != null) {
         var0.field1173.method1570(false);
         var0.field1173.method1973();
      }
   }

   public static void method1475(class_4587 var0, float var1, float var2, boolean var3) {
      NewHUD var4 = DaamkyClient.method2004().method1783().method0976(NewHUD.class);
      if (var4 != null) {
         boolean var5 = !var4.method2195() || var4.field1680.method1889().isEmpty();
         var4.field1173.method1570(var5 && var3);
         float var6 = var4.field1173.method0002();
         if (!(var6 < 0.01F)) {
            FontSize var7 = Fonts.field0075.method0654(6.0F);
            FontSize var8 = Fonts.field0774.method0654(5.0F);
            String var9 = "d";
            String var10 = NewHUD.HudEntry.method0026() ? "Нажмите ПКМ по пустой области для настройки HUD" : "Right-click an empty area to configure HUD";
            float var11 = 5.0F;
            float var12 = 3.0F;
            float var13 = var8.method0998(var9);
            float var14 = var7.method0998(var10);
            float var15 = var11 + var13 + var12 + var14 + var11;
            float var16 = var11 + var7.method0530() + var11;
            float var17 = (var1 - var15) / 2.0F;
            float var18 = var2 * 0.08F - var16 / 2.0F;
            var4.method0321(var0, var6, var17, var18, var15, var16);
            var4.method1468(var0, var17, var18, var15, var16, var6, var4.field1691.method0492());
            Color var19 = var4.method0964(Color.WHITE, var6);
            float var20 = var18 + (var16 - var8.method0530()) / 2.0F - 0.5F;
            float var21 = var18 + (var16 - var7.method0530()) / 2.0F;
            GuiRenderHelper.method1491(var0, var8, var9, var17 + var11, var20, var19);
            GuiRenderHelper.method1491(var0, var7, var10, var17 + var11 + var13 + var12, var21, var19);
            var0.method_22909();
         }
      }
   }

   public float method1679() {
      return this.field1777;
   }

   public void method0665(float var1) {
      this.field1777 = var1;
   }

   public NewHUD() {
      super("NewHUD", ModuleCategory.field1004, "Customizable HUD overlay with draggable elements");
      this.method1013("Настраиваемый HUD с перемещаемыми элементами");
      this.method1570(false);
      this.method2178(true);
   }

   public List<BooleanSetting> method1751() {
      return this.field1680.method0492();
   }

   public List<String> method2025() {
      return this.field1595;
   }

   public void method0738(int var1, int var2) {
      if (var1 >= 0 && var1 < this.field1595.size() && var2 >= 0 && var2 < this.field1595.size() && var1 != var2) {
         String var3 = this.field1595.remove(var1);
         this.field1595.add(var2, var3);
      }
   }

   public List<Setting<?>> method2132(String var1) {
      return switch (var1) {
         case "NewWatermark" -> List.of(this.field1580);
         case "NewServerInfo" -> List.of(this.field1604);
         case "NewInventory" -> List.of(this.field1756);
         case "NewArmorHUD" -> List.of(this.field1743, this.field1768);
         case "NewKeyBinds" -> List.of(this.field1176, this.field1166);
         case "NewPotions" -> List.of(this.field1188, this.field1121);
         case "NewNotifications" -> List.of(this.field1114, this.field1131);
         case "NewTargetHud" -> List.of(this.field1229, this.field1221);
         case "NewStaffList" -> List.of(this.field1235, this.field0900, this.field0894);
         default -> List.of();
      };
   }

   public String method1844(String var1) {
      return switch (var1) {
         case "NewWatermark" -> "Watermark";
         case "NewServerInfo" -> "Info";
         case "NewInventory" -> "Inventory";
         case "NewArmorHUD" -> "ArmorHUD";
         case "NewKeyBinds" -> "KeyBinds";
         case "NewPotions" -> "Potions";
         case "NewNotifications" -> "Notifications";
         case "NewTargetHud" -> "TargetHud";
         case "NewStaffList" -> "StaffList";
         default -> var1;
      };
   }

   public String method1655(String var1) {
      for (int var2 = 0; var2 < field1192.length; var2++) {
         if (field1192[var2].equals(var1)) {
            return field1193[var2];
         }
      }

      return "";
   }

   private void method1457(class_4587 var1, float var2, float var3, float var4, float var5) {
      this.method1458(var1, var2, var3, var4, var5, 1.0F);
   }

   private void method1458(class_4587 var1, float var2, float var3, float var4, float var5, float var6) {
      this.method1468(var1, var2, var3, var4, var5, var6, this.field1691.method0492());
   }

   private void method1468(class_4587 var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
      if (!(var6 < 0.01F)) {
         if (var7 && this.field1691.method0492()) {
            Color var8 = var6 >= 0.99F ? field1104 : new Color(255, 255, 255, (int)(255.0F * var6));
            GuiRenderHelper.method1462(var1, var2, var3, var4, var5, 10.0F, 14.0F, var8);
         }

         Color var9 = var6 >= 0.99F
            ? this.field0134
            : new Color(this.field0134.getRed(), this.field0134.getGreen(), this.field0134.getBlue(), (int)(this.field0134.getAlpha() * var6));
         GuiRenderHelper.method1463(var1, var2, var3, var4, var5, 10.0F, var9);
      }
   }

   private void method0321(class_4587 var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = Math.max(0.3F, var2);
      float var8 = Math.max(0.3F, var2 * var2);
      float var9 = var3 + var5 / 2.0F;
      float var10 = var4 + var6 / 2.0F;
      var1.method_22903();
      var1.method_46416(var9, var10, 0.0F);
      var1.method_22905(var7, var8, 1.0F);
      var1.method_46416(-var9, -var10, 0.0F);
   }

   private Color method0964(Color var1, float var2) {
      return var2 >= 0.99F ? var1 : new Color(var1.getRed(), var1.getGreen(), var1.getBlue(), Math.max(0, (int)(var1.getAlpha() * var2)));
   }

   public void method2015() {
      this.field0907 = false;
      this.field1777 = Float.NaN;
   }

   private void method2043() {
      float var1 = ScreenLayoutHelper.method2047();
      float var2 = ScreenLayoutHelper.method1762();
      float var3 = var1 / 2.0F - 75.0F;
      HudWidgetManager var4 = HudWidgetManager.method1605();
      boolean var5 = !var4.method1963().containsKey("NewWatermark") && var4.method1002("NewWatermark") == null;
      boolean var6 = !var4.method1963().containsKey("NewServerInfo") && var4.method1002("NewServerInfo") == null;
      if (var5 && !var4.method0371().containsKey("NewWatermark")) {
         var4.method1062("NewWatermark", true);
      }

      if (var6 && !var4.method0371().containsKey("NewServerInfo")) {
         var4.method1062("NewServerInfo", true);
      }

      var4.method1019("NewWatermark", var3, 5.0F, 150.0F, 28.0F);
      var4.method1019("NewServerInfo", var3 - 12.0F, 30.0F, 196.0F, 34.0F);
      HudWidgetManager.method1605().method1019("NewInventory", var1 - 160.0F, var2 - 110.0F, 154.0F, 71.0F);
      HudWidgetManager.method1605().method1019("NewTPS", 5.0F, var2 - 50.0F, 82.0F, 23.0F);
      HudWidgetManager.method1605().method1019("NewCoords", 70.0F, var2 - 50.0F, 150.0F, 23.0F);
      HudWidgetManager.method1605().method1019("NewArmorHUD", var3 - 16.0F, var2 - 105.0F, 150.0F, 23.0F);
      HudWidgetManager.method1605().method1019("NewKeyBinds", 10.0F, 10.0F, 120.0F, 23.0F);
      HudWidgetManager.method1605().method1019("NewPotions", 10.0F, 120.0F, 154.0F, 23.0F);
      HudWidgetManager.method1605().method1019("NewNotifications", var3 - 12.0F, var2 - 130.0F, 150.0F, 45.0F);
      HudWidgetState var7 = HudWidgetManager.method1605().method1002("NewNotifications");
      if (var7 != null) {
         var7.method1570(true);
      }

      HudWidgetManager.method1605().method1019("NewTargetHud", var3 + 3.0F, var2 / 2.0F - 15.0F, 114.0F, 33.0F);
      HudWidgetManager.method1605().method1019("NewStaffList", 5.0F, 60.0F, 120.0F, 23.0F);
   }

   @EventHandler
   public void onRender2D(HudRenderEvent var1) {
      if (!method1974()) {
         this.field1153 = ThemeColorManager.method1908().method2063();
         this.field0134 = ThemeColorManager.method1908().method0141(224);
         if (!this.field0907) {
            this.method2043();
            this.field0907 = true;
         }

         if (field0796.field_1755 instanceof class_408) {
            double var2 = field0796.field_1729.method_1603() * ScreenLayoutHelper.method2047() / field0796.method_22683().method_4480();
            double var4 = field0796.field_1729.method_1604() * ScreenLayoutHelper.method1762() / field0796.method_22683().method_4507();
            HudWidgetManager.method1605().method0630(var2, var4, this.method0469());
         }

         boolean var18 = field0796.method_53526().method_53536();
         boolean var3 = field0796.field_1690.field_1907.method_1434();
         boolean var19 = this.method2195() && !var18 && !var3;
         boolean var5 = field0796.field_1755 instanceof class_408;
         boolean var6 = !this.field1323.isEmpty();
         boolean var7 = !this.field1318.isEmpty() || !this.field1327.isEmpty();
         boolean var8 = !this.field1685.isEmpty();
         this.field0450.method1570(var19 && this.field1680.method0730(0));
         boolean var9 = var19 && this.field1680.method0730(1);
         this.field0445.method1570(var9);
         this.field0281.method1570(var9);
         this.field0275.method1570(var9);
         this.field0454.method1570(var19 && this.field1680.method0730(2));
         this.field0286.method1570(var19 && this.field1680.method0730(3));
         this.field0248.method1570(var19 && this.field1680.method0730(4) && (this.field1166.method0492() || var6 || var5));
         this.field0245.method1570(var19 && this.field1680.method0730(5) && (this.field1121.method0492() || var7 || var5));
         this.field0253.method1570(var19 && this.field1680.method0730(6));
         this.field0308.method1570(var19 && this.field1680.method0730(7));
         this.field1701.method1570(var19 && this.field1680.method0730(8) && (this.field0900.method0492() || var8 || var5));
         boolean var10 = this.field0450.method0002() > 0.01F
            || this.field0445.method0002() > 0.01F
            || this.field0454.method0002() > 0.01F
            || this.field0281.method0002() > 0.01F
            || this.field0275.method0002() > 0.01F
            || this.field0286.method0002() > 0.01F
            || this.field0248.method0002() > 0.01F
            || this.field0245.method0002() > 0.01F
            || this.field0253.method0002() > 0.01F
            || this.field0308.method0002() > 0.01F
            || this.field1701.method0002() > 0.01F;
         if (var10) {
            boolean var11 = this.field1691.method0492();
            if (var11) {
               GuiRenderHelper.method0578();
            }

            try {
               if (this.field0450.method0002() > 0.01F) {
                  this.method0843(var1);
               }

               if (this.field0445.method0002() > 0.01F) {
                  this.method0176(var1);
               }

               if (this.field0454.method0002() > 0.01F) {
                  this.method1650(var1);
               }

               if (this.field0281.method0002() > 0.01F) {
                  this.method2117(var1);
               }

               if (this.field0275.method0002() > 0.01F) {
                  this.method1838(var1);
               }

               if (this.field0286.method0002() > 0.01F) {
                  this.method1981(var1);
               }

               if (this.field0248.method0002() > 0.01F) {
                  this.method0437(var1);
               }

               if (this.field0245.method0002() > 0.01F) {
                  this.method0381(var1);
               }

               if (this.field0253.method0002() > 0.01F) {
                  this.method2233(var1);
               }

               if (this.field0308.method0002() > 0.01F) {
                  this.method0502(var1);
               }

               if (this.field1701.method0002() > 0.01F) {
                  this.method2197(var1);
               }
            } finally {
               if (var11) {
                  GuiRenderHelper.method0025();
               }
            }
         }

         if (field0796.field_1755 instanceof class_408) {
            double var20 = field0796.field_1729.method_1603() * ScreenLayoutHelper.method2047() / field0796.method_22683().method_4480();
            double var13 = field0796.field_1729.method_1604() * ScreenLayoutHelper.method1762() / field0796.method_22683().method_4507();
            HudWidgetManager.method1605().method1400(var1.method1806());
            this.field1400.clear();
            if (this.field1680.method0730(0)) {
               this.field1400.add("NewWatermark");
            }

            if (this.field1680.method0730(1)) {
               this.field1400.add("NewServerInfo");
               this.field1400.add("NewTPS");
               this.field1400.add("NewCoords");
            }

            if (this.field1680.method0730(2)) {
               this.field1400.add("NewInventory");
            }

            if (this.field1680.method0730(3)) {
               this.field1400.add("NewArmorHUD");
            }

            if (this.field1680.method0730(4)) {
               this.field1400.add("NewKeyBinds");
            }

            if (this.field1680.method0730(5)) {
               this.field1400.add("NewPotions");
            }

            if (this.field1680.method0730(6)) {
               this.field1400.add("NewNotifications");
            }

            if (this.field1680.method0730(7)) {
               this.field1400.add("NewTargetHud");
            }

            if (this.field1680.method0730(8)) {
               this.field1400.add("NewStaffList");
            }

            ServerAssist var15 = DaamkyClient.method2004().method1783().method0976(ServerAssist.class);
            if (var15 != null && var15.method2195() && var15.method1755()) {
               this.field1400.add("ServerAssist");
            }

            HudWidgetManager.method1605().method1431(var1.method1806(), this.field1400);
            this.method0844(var1, (float)var20, (float)var13);
         } else if (HudWidgetManager.method1605().method2079()) {
            HudWidgetManager.method1605().method1812();
         }
      }
   }

   private static String method0441(String var0) {
      return switch (var0) {
         case "NewArmorHUD" -> NewHUD.HudEntry.method0026()
            ? "Alt + ПКМ для переключения вертикально/горизонтально"
            : "Alt + RMB to toggle vertical/horizontal";
         default -> null;
      };
   }

   private void method0844(HudRenderEvent var1, float var2, float var3) {
      String var4 = "";

      for (HudWidgetState var6 : HudWidgetManager.method1605().method0560().values()) {
         if (var6.method0676(var2, var3) && this.field1400.contains(var6.method1619())) {
            var4 = var6.method1619();
            break;
         }
      }

      String var27 = var4.isEmpty() ? null : method0441(var4);
      boolean var28 = var27 != null;
      if (var28 && !var4.equals(this.field1127)) {
         this.field1127 = var4;
      }

      this.field1194.method1570(var28);
      float var7 = this.field1194.method0002();
      if (!(var7 < 0.01F)) {
         String var8 = method0441(this.field1127);
         if (var8 != null) {
            class_4587 var9 = var1.method1806().method_51448();
            FontSize var10 = Fonts.field0075.method0654(5.0F);
            FontSize var11 = Fonts.field0774.method0654(4.0F);
            float var12 = var11.method0998("d");
            float var13 = var10.method0998(var8);
            float var14 = 6.0F + var12 + 4.0F + var13 + 6.0F;
            float var15 = 14.0F;
            HudWidgetState var16 = HudWidgetManager.method1605().method1002(this.field1127);
            if (var16 != null) {
               float var17 = var16.method1946() + var16.method0355() / 2.0F - var14 / 2.0F;
               float var18 = var16.method0413() - var15 - 4.0F;
               float var19 = ScreenLayoutHelper.method2047();
               if (var17 + var14 > var19 - 2.0F) {
                  var17 = var19 - var14 - 2.0F;
               }

               if (var17 < 2.0F) {
                  var17 = 2.0F;
               }

               if (var18 < 2.0F) {
                  var18 = var16.method0413() + var16.method0483() + 4.0F;
               }

               float var20 = 0.9F + 0.1F * var7;
               float var21 = var17 + var14 / 2.0F;
               float var22 = var18 + var15 / 2.0F;
               var9.method_22903();
               var9.method_46416(var21, var22, 0.0F);
               var9.method_22905(var20, var20, 1.0F);
               var9.method_46416(-var21, -var22, 0.0F);
               Color var23 = new Color(this.field0134.getRed(), this.field0134.getGreen(), this.field0134.getBlue(), (int)(this.field0134.getAlpha() * var7));
               GuiRenderHelper.method1462(var9, var17, var18, var14, var15, 6.0F, 14.0F, new Color(255, 255, 255, (int)(255.0F * var7)));
               GuiRenderHelper.method1463(var9, var17, var18, var14, var15, 6.0F, var23);
               Color var24 = this.method0964(this.field1153, var7);
               Color var25 = new Color(255, 255, 255, (int)(220.0F * var7));
               float var26 = var18 + (var15 - var10.method0530()) / 2.0F;
               GuiRenderHelper.method1491(var9, var11, "d", var17 + 6.0F, var18 + (var15 - var11.method0530()) / 2.0F - 0.5F, var24);
               GuiRenderHelper.method1491(var9, var10, var8, var17 + 6.0F + var12 + 4.0F, var26, var25);
               var9.method_22909();
            }
         }
      }
   }

   @EventHandler
   public void onRenderStatusEffects(StatusEffectsRenderEvent var1) {
      if (this.field1680.method0730(5)) {
         var1.method0578();
      }
   }

   @EventHandler
   public void onMouse(MouseEvent var1) {
      if (field0796.field_1755 instanceof class_408) {
         double var2 = field0796.field_1729.method_1603() * ScreenLayoutHelper.method2047() / field0796.method_22683().method_4480();
         double var4 = field0796.field_1729.method_1604() * ScreenLayoutHelper.method1762() / field0796.method_22683().method_4507();
         if (var1.method1604() == 1) {
            if (var1.method1763() == 0
               && this.field1751 > 0.0F
               && MathHelper.method0689(this.field1763, this.field1765, this.field1751, this.field1750, (float)var2, (float)var4)) {
               String var6 = this.field1358 + " " + this.field1352 + " " + this.field1362;
               field0796.field_1774.method_1455(var6);
               method1050("Coords", "copied", "h", true);
               this.field1752 = System.currentTimeMillis();
               return;
            }

            HudWidgetManager.method1605().method0628(var2, var4, var1.method1763(), this.method0469());
         } else if (var1.method1604() == 0) {
            HudWidgetManager.method1605().method0111(var2, var4, var1.method1763());
         }
      }
   }

   public boolean method1986(String var1) {
      return this.method0469().contains(var1);
   }

   private Set<String> method0469() {
      Set var1 = new HashSet<>();
      if (this.field1680.method0730(0)) {
         var1.add("NewWatermark");
      }

      if (this.field1680.method0730(1)) {
         var1.add("NewServerInfo");
         var1.add("NewTPS");
         var1.add("NewCoords");
      }

      if (this.field1680.method0730(2)) {
         var1.add("NewInventory");
      }

      if (this.field1680.method0730(3)) {
         var1.add("NewArmorHUD");
      }

      if (this.field1680.method0730(4)) {
         var1.add("NewKeyBinds");
      }

      if (this.field1680.method0730(5)) {
         var1.add("NewPotions");
      }

      if (this.field1680.method0730(6)) {
         var1.add("NewNotifications");
      }

      if (this.field1680.method0730(7)) {
         var1.add("NewTargetHud");
      }

      if (this.field1680.method0730(8)) {
         var1.add("NewStaffList");
      }

      ServerAssist var2 = DaamkyClient.method2004().method1783().method0976(ServerAssist.class);
      if (var2 != null && var2.method2195() && var2.method1755()) {
         var1.add("ServerAssist");
      }

      return var1;
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         this.method0457();
         field1588.removeIf(NewHUD.HudEntry::method1974);
         this.method0479();
         this.field0859 = DaamkyClient.method2004().method1744().method0557();
         TpsTracker.method0578();
         this.field0848 = TpsTracker.method0003();
         this.field0942 = String.valueOf(this.field0848);
         this.field0864 = ServerEnvironment.method2048();
         this.field0936 = String.valueOf(this.field0864);
         float var2 = 20.0F;
         if (field0796.field_1687 != null) {
            var2 = field0796.field_1687.method_54719().method_54748();
         }

         this.field0951 = String.format("%.1f", var2);
         if (field0796.field_1724 != null) {
            this.field1358 = String.valueOf((int)field0796.field_1724.method_23317());
            this.field1352 = String.valueOf((int)field0796.field_1724.method_23318());
            this.field1362 = String.valueOf((int)field0796.field_1724.method_23321());
         }

         this.field1323 = DaamkyClient.method2004()
            .method1783()
            .method0019()
            .stream()
            .filter(var0 -> var0.method2195() && !var0.method2259().method0579())
            .sorted(Comparator.comparing(Module::method0423))
            .toList();
         this.field1318.clear();
         this.field1327.clear();
         Set var3 = new HashSet<>();
         if (field0796.field_1724 != null && !field0796.field_1724.method_6088().isEmpty()) {
            try {
               for (class_1293 var5 : field0796.field_1724.method_6088().values()) {
                  if (this.method2143(var5)) {
                     this.field1318.add(var5);
                  } else {
                     this.field1327.add(var5);
                  }

                  String var6 = this.method1659(var5);
                  var3.add(var6);
                  int var7 = var5.method_5584();
                  if (var7 > 0) {
                     this.field1392.merge(var6, var7, Math::max);
                  }
               }

               this.field1318.sort(Comparator.comparingInt(class_1293::method_5584).reversed());
               this.field1327.sort(Comparator.comparingInt(class_1293::method_5584).reversed());
            } catch (Exception var11) {
            }
         }

         this.field1392.keySet().retainAll(var3);
         if (field0796.field_1724 != null) {
            Map var12 = new HashMap<>();

            for (class_1293 var19 : field0796.field_1724.method_6088().values()) {
               String var26 = class_1074.method_4662(((class_1291)var19.method_5579().comp_349()).method_5567(), new Object[0]);
               var12.put(var26, var19);
            }

            String var16 = NewHUD.HudEntry.method0026() ? "Эффект" : "Effect";
            if (!this.field0414.isEmpty()) {
               for (String var27 : this.field0414) {
                  if (!var12.containsKey(var27)) {
                     class_2960 var8 = this.field0409.remove(var27);
                     String var9 = var27 + (NewHUD.HudEntry.method0026() ? " закончился" : " expired");
                     if (var8 != null) {
                        method1054(var16, var9, var8, false);
                     } else {
                        method1050(var16, var9, "w", false);
                     }
                  }
               }
            }

            for (Entry var28 : var12.entrySet()) {
               if (!this.field0414.contains(var28.getKey())) {
                  class_1293 var33 = var28.getValue();
                  class_2960 var36 = this.method0232(var33);
                  this.field0409.put(var28.getKey(), var36);
                  if (!this.method1124(var33)) {
                     String var10 = var28.getKey() + (NewHUD.HudEntry.method0026() ? " наложен" : " applied");
                     method1054(var16, var10, var36, true);
                  }
               }
            }

            this.field0414.clear();
            this.field0414.addAll(var12.keySet());
            this.field0409.keySet().retainAll(var12.keySet());
         }

         if (field0796.field_1687 != null && field0796.field_1724 != null) {
            Map var13 = new HashMap<>();

            for (class_1657 var22 : field0796.field_1687.method_18456()) {
               if (var22 != field0796.field_1724 && !(var22.method_5858(field0796.field_1724) > 2500.0)) {
                  float var29 = PlayerStatusHelper.method1178(var22);
                  float var34 = var29 >= 0.0F ? var29 : var22.method_6032();
                  var13.put(var22.method_5628(), var34);
                  Float var37 = this.field0420.get(var22.method_5628());
                  if (var37 != null && var37 > 0.0F && var34 <= 0.0F) {
                     method1050(var22.method_5477().getString(), NewHUD.HudEntry.method0026() ? "был убит!" : "was killed!", "V", true);
                  }
               }
            }

            this.field0420.clear();
            this.field0420.putAll(var13);
         }

         if (field0796.field_1687 != null) {
            List var14 = this.method0404();
            Set var18 = new HashSet<>();

            for (NewHUD.NotificationEntry var30 : var14) {
               var18.add(var30.field0715);
               if (this.field1669 && !this.field1668.contains(var30.field0715) && this.field0894.method0492()) {
                  method0220(
                     NewHUD.HudEntry.method0026() ? "Стафф" : "Staff",
                     var30.field0715 + (NewHUD.HudEntry.method0026() ? " зашел на сервер" : " joined"),
                     this.method0505(var30.field0715),
                     true
                  );
               }

               this.field1684.putIfAbsent(var30.field0715, System.currentTimeMillis());
               this.field1685.put(var30.field0715, var30);
               Animation var35 = this.field0563
                  .computeIfAbsent(var30.field0715, var0 -> new Animation(250L, 1.0, false, EasingCurve.field0203));
               var35.method1570(true);
               this.field1667.add(var30.field0715);
            }

            if (this.field1669 && this.field0894.method0492()) {
               for (String var31 : new HashSet<>(this.field1668)) {
                  if (!var18.contains(var31)) {
                     method0220(
                        NewHUD.HudEntry.method0026() ? "Стафф" : "Staff",
                        var31 + (NewHUD.HudEntry.method0026() ? " вышел с сервера" : " left"),
                        this.method0505(var31),
                        false
                     );
                  }
               }
            }

            this.field1669 = true;
            this.field1668.clear();
            this.field1668.addAll(var18);
            Iterator var25 = this.field0563.entrySet().iterator();

            while (var25.hasNext()) {
               Entry var32 = var25.next();
               if (!var18.contains(var32.getKey())) {
                  var32.getValue().method1570(false);
                  if (var32.getValue().method0346(false)) {
                     var25.remove();
                     this.field1685.remove(var32.getKey());
                     this.field1684.remove(var32.getKey());
                     this.field1667.remove(var32.getKey());
                  }
               }
            }
         }
      }
   }

   @EventHandler
   public void onPacketReceive(PacketEvent.Inbound var1) {
      if (!method1974()) {
         if (field0796.field_1724 != null) {
            if (var1.method1970() instanceof class_2678) {
               this.field0563.clear();
               this.field1685.clear();
               this.field1684.clear();
               this.field1668.clear();
               this.field1667.clear();
               this.field1686.clear();
               this.field1669 = false;
            }

            if (var1.method1970() instanceof class_7439 var2) {
               String var5 = var2.comp_763().getString().toLowerCase();
               String var4 = field0796.field_1724.method_5477().getString().toLowerCase();
               if (!var4.isEmpty() && var5.contains(var4) && !var5.startsWith("<" + var4 + ">") && !var5.startsWith(var4 + ":")) {
                  method1050(
                     NewHUD.HudEntry.method0026() ? "Чат" : "Chat", NewHUD.HudEntry.method0026() ? "Вас упомянули!" : "You were mentioned!", "Z", true
                  );
               }
            }
         }
      }
   }

   private void method0843(HudRenderEvent var1) {
      float var2 = this.field0450.method0002();
      HudWidgetState var3 = HudWidgetManager.method1605().method1002("NewWatermark");
      if (var3 != null) {
         class_4587 var4 = var1.method1806().method_51448();
         FontSize var5 = Fonts.field1558.method0654(8.0F);
         FontSize var6 = Fonts.field0075.method0654(6.5F);
         FontSize var7 = Fonts.field0075.method0654(6.5F);
         float var8 = var3.method0413();
         float var9 = 23.0F;
         float var10 = 21.0F;
         float var11 = 1.0F;
         String var12 = "Daamky";
         String var13 = ".cc";
         String var14 = this.field0859;
         float var15 = var6.method0998(var12);
         float var16 = var7.method0998(var13);
         float var17 = var6.method0998(var14);
         float var18 = 12.0F;
         float var19 = 3.0F;
         float var20 = var15 + var16;
         if (this.field1659.method0492()) {
            var20 += 13.0F;
            var20 += var18 + var19 + var17;
         }

         float var21 = 8.0F;
         float var22 = var20 + var21 * 2.0F;
         float var23 = var10 + var11 + var22;
         this.field1587.method0705(var23, 200L);
         float var24 = this.field1587.method0530();
         HudWidgetManager.method1605().method0215("NewWatermark", var23, var9);
         if (var3.method2079() && !var3.method2195()) {
            var3.method0665((ScreenLayoutHelper.method2047() - var23) / 2.0F);
         }

         float var25 = var3.method1946() + (var23 - var24) / 2.0F;
         this.method0321(var4, var2, var25, var8, var24, var9);
         this.method1468(var4, var25, var8, var24, var9, var2, this.field1580.method0492());
         Color var26 = this.method0964(this.field1153, var2);
         Color var27 = this.method0964(field1564, var2);
         Color var28 = this.method0964(field1641, var2);
         Color var29 = this.method0964(field1726, var2);
         Color var30 = this.method0964(field1500, var2);
         Color var31 = this.method0964(field1026, var2);
         GuiRenderHelper.method1404(var1.method1806(), var25, var8, var24, var9);
         float var32 = var25 + (var10 - var5.method0998("A")) / 2.0F + 1.0F;
         float var33 = var8 + (var9 - var5.method0530()) / 2.0F - 1.0F;
         GuiRenderHelper.method1491(var4, var5, "A", var32, var33, var26);
         float var34 = var25 + var10;
         GuiRenderHelper.method1463(var4, Math.round(var34), var8, var11, var9, 0.0F, var30);
         float var35 = var34 + var11 + var21;
         float var36 = var8 + (var9 - var6.method0530()) / 2.0F;
         float var37 = var35;
         GuiRenderHelper.method1491(var4, var6, var12, var37, var36, var28);
         var37 += var15;
         float var38 = var8 + (var9 - var7.method0530()) / 2.0F;
         GuiRenderHelper.method1491(var4, var7, var13, var37, var38, var29);
         var37 += var16;
         if (this.field1659.method0492()) {
            var37 += 6.0F;
            float var39 = 7.0F;
            float var40 = var8 + (var9 - var39) / 2.0F;
            GuiRenderHelper.method0326(var4, Math.round(var37), var40, 1.0F, var39, 1.0F, var31);
            var37 += 7.0F;
            float var41 = var8 + (var9 - var18) / 2.0F;
            float var42 = 1.0F;
            GuiRenderHelper.method0323(var4, var37, var41, var18, var18, var18 / 2.0F - 1.0F, var42 - 0.5F, 0.5F, 0.5F, var26);
            float var43 = var18 - var42 * 2.0F - 1.0F;
            float var44 = var37 + var42 + 0.5F;
            float var45 = var41 + var42 + 0.5F;

            try {
               class_2960 var46 = RemoteAvatarService.method0571();
               if (var46 != null) {
                  GuiRenderHelper.method0328(var4, var44, var45, var43, var43, var43 / 2.0F - 1.0F, var46, new Color(255, 255, 255, var28.getAlpha()));
               } else {
                  GuiRenderHelper.method1463(var4, var44, var45, var43, var43, var43 / 2.0F, field1210);
               }
            } catch (Exception var47) {
               GuiRenderHelper.method1463(var4, var44, var45, var43, var43, var43 / 2.0F, field1210);
            }

            var37 += var18 + var19;
            GuiRenderHelper.method1491(var4, var6, var14, var37, var36, var28);
         }

         GuiRenderHelper.method1400(var1.method1806());
         var4.method_22909();
      }
   }

   private void method0176(HudRenderEvent var1) {
      float var2 = this.field0445.method0002();
      HudWidgetState var3 = HudWidgetManager.method1605().method1002("NewServerInfo");
      if (var3 != null) {
         class_4587 var4 = var1.method1806().method_51448();
         FontSize var5 = Fonts.field0774.method0654(6.0F);
         FontSize var6 = Fonts.field0774.method0654(6.0F);
         FontSize var7 = Fonts.field0774.method0654(6.0F);
         FontSize var8 = Fonts.field0075.method0654(6.5F);
         FontSize var9 = Fonts.field0075.method0654(6.5F);
         float var10 = var3.method0413();
         float var11 = 23.0F;
         float var12 = 8.0F;
         float var13 = 4.0F;
         float var14 = 6.0F;
         float var15 = 7.0F;
         String var16 = "server";
         String var17 = ".su";
         if (field0796.method_1558() != null) {
            String var18 = field0796.method_1558().field_3761;
            int var19 = var18.lastIndexOf(46);
            if (var19 > 0) {
               var16 = var18.substring(0, var19);
               var17 = var18.substring(var19);
            } else {
               var16 = var18;
               var17 = "";
            }
         } else if (field0796.method_1542()) {
            var16 = "Single";
            var17 = "player";
         }

         float var50 = var5.method0998("M");
         float var51 = var8.method0998(var16);
         float var20 = var9.method0998(var17);
         float var21 = var6.method0998("W");
         float var22 = var8.method0998("999");
         float var23 = var9.method0998("fps");
         float var24 = var7.method0998("a");
         float var25 = var8.method0998(this.field0936);
         float var26 = var9.method0998("ms");
         float var27 = var50 + var13 + var51 + var20;
         float var28 = var21 + var13 + var22 + var23;
         float var29 = var24 + var13 + var25 + var26;
         float[] var30 = new float[this.field1595.size()];

         for (int var31 = 0; var31 < this.field1595.size(); var31++) {
            var30[var31] = switch ((String)this.field1595.get(var31)) {
               case "Server" -> var27;
               case "FPS" -> var28;
               case "Ping" -> var29;
               default -> 0.0F;
            };
         }

         float var52 = var12;

         for (int var54 = 0; var54 < var30.length; var54++) {
            var52 += var30[var54];
            if (var54 < var30.length - 1) {
               var52 += var14 + 1.0F + var14;
            }
         }

         var52 += var12;
         this.field1589.method0705(var52, 200L);
         float var55 = this.field1589.method0530();
         HudWidgetManager.method1605().method0215("NewServerInfo", var52, var11);
         if (var3.method2079() && !var3.method2195()) {
            var3.method0665((ScreenLayoutHelper.method2047() - var52) / 2.0F);
         }

         float var56 = var3.method1946() + (var52 - var55) / 2.0F;
         this.method0321(var4, var2, var56, var10, var55, var11);
         this.method1468(var4, var56, var10, var55, var11, var2, this.field1604.method0492());
         Color var34 = this.method0964(this.field1153, var2);
         Color var35 = this.method0964(field1564, var2);
         Color var36 = this.method0964(field1641, var2);
         Color var37 = this.method0964(field1726, var2);
         Color var38 = this.method0964(field1026, var2);
         GuiRenderHelper.method1404(var1.method1806(), var56, var10, var55, var11);
         float var39 = var56 + var12;
         float var40 = var10 + (var11 - var8.method0530()) / 2.0F;
         float var41 = var10 + (var11 - var5.method0530()) / 2.0F - 0.5F;
         float var42 = var10 + (var11 - var6.method0530()) / 2.0F - 0.5F;
         float var43 = var10 + (var11 - var7.method0530()) / 2.0F - 0.5F;
         float var44 = var10 + (var11 - var9.method0530()) / 2.0F;
         float var45 = var10 + (var11 - var15) / 2.0F;
         float var46 = var8.method0998(this.field0942);

         for (int var47 = 0; var47 < this.field1595.size(); var47++) {
            if (var47 > 0) {
               GuiRenderHelper.method0326(var4, Math.round(var39), var45, 1.0F, var15, 1.0F, var38);
               var39 += 1.0F + var14;
            }

            switch ((String)this.field1595.get(var47)) {
               case "Server":
                  GuiRenderHelper.method1491(var4, var5, "M", var39, var41, var34);
                  var39 += var50 + var13;
                  GuiRenderHelper.method1491(var4, var8, var16, var39, var40, var36);
                  var39 += var51;
                  GuiRenderHelper.method1491(var4, var9, var17, var39, var44, var37);
                  var39 += var20 + var14;
                  break;
               case "FPS":
                  GuiRenderHelper.method1491(var4, var6, "W", var39, var42, var34);
                  var39 += var21 + var13;
                  GuiRenderHelper.method1491(var4, var8, this.field0942, var39, var40, var36);
                  GuiRenderHelper.method1491(var4, var9, "fps", var39 + var46, var44, var37);
                  var39 += var22 + var23 + var14;
                  break;
               case "Ping":
                  GuiRenderHelper.method1491(var4, var7, "a", var39, var43, var34);
                  var39 += var24 + var13;
                  GuiRenderHelper.method1491(var4, var8, this.field0936, var39, var40, var36);
                  GuiRenderHelper.method1491(var4, var9, "ms", var39 + var25, var44, var37);
                  var39 += var25 + var26 + var14;
            }
         }

         GuiRenderHelper.method1400(var1.method1806());
         var4.method_22909();
      }
   }

   private void method2117(HudRenderEvent var1) {
      float var2 = this.field0281.method0002();
      HudWidgetState var3 = HudWidgetManager.method1605().method1002("NewTPS");
      if (var3 != null) {
         class_4587 var4 = var1.method1806().method_51448();
         FontSize var5 = Fonts.field0774.method0654(6.0F);
         FontSize var6 = Fonts.field0075.method0654(6.5F);
         FontSize var7 = Fonts.field0075.method0654(6.5F);
         float var8 = var3.method1946();
         float var9 = var3.method0413();
         float var10 = 23.0F;
         float var11 = 21.0F;
         float var12 = 1.0F;
         float var13 = 8.0F;
         float var14 = var6.method0998(this.field0951);
         float var15 = var7.method0998("tps");
         float var16 = var11 + var12 + var14 + var15 + var13 * 2.0F;
         this.field1611.method0705(var16, 200L);
         float var17 = this.field1611.method0530();
         HudWidgetManager.method1605().method0215("NewTPS", var17, var10);
         this.method0321(var4, var2, var8, var9, var17, var10);
         this.method1468(var4, var8, var9, var17, var10, var2, this.field1604.method0492());
         Color var18 = this.method0964(this.field1153, var2);
         Color var19 = this.method0964(field1564, var2);
         Color var20 = this.method0964(field1641, var2);
         Color var21 = this.method0964(field1726, var2);
         GuiRenderHelper.method1404(var1.method1806(), var8, var9, var17, var10);
         float var22 = var9 + (var10 - var5.method0530()) / 2.0F;
         GuiRenderHelper.method1491(var4, var5, "E", var8 + 8.0F, var22 - 0.5F, var18);
         float var23 = var8 + var11;
         GuiRenderHelper.method1463(var4, var23, var9, var12, var10, 0.0F, this.method0964(field1500, var2));
         float var24 = var9 + (var10 - var6.method0530()) / 2.0F;
         float var25 = var9 + (var10 - var7.method0530()) / 2.0F;
         float var26 = var23 + var12 + var13;
         GuiRenderHelper.method1491(var4, var6, this.field0951, var26, var24, var20);
         var26 += var14;
         GuiRenderHelper.method1491(var4, var7, "tps", var26, var25, var21);
         GuiRenderHelper.method1400(var1.method1806());
         var4.method_22909();
      }
   }

   private void method1838(HudRenderEvent var1) {
      float var2 = this.field0275.method0002();
      HudWidgetState var3 = HudWidgetManager.method1605().method1002("NewCoords");
      if (var3 != null) {
         class_4587 var4 = var1.method1806().method_51448();
         FontSize var5 = Fonts.field0774.method0654(6.0F);
         FontSize var6 = Fonts.field0075.method0654(6.5F);
         FontSize var7 = Fonts.field0075.method0654(6.5F);
         FontSize var8 = Fonts.field0774.method0654(5.0F);
         FontSize var9 = Fonts.field0075.method0654(6.0F);
         float var10 = var3.method1946();
         float var11 = var3.method0413();
         float var12 = 23.0F;
         float var13 = 1.0F;
         float var14 = 21.0F;
         float var15 = 1.0F;
         float var16 = 8.0F;
         float var17 = 7.0F;
         float var18 = var6.method0998(this.field1358);
         float var19 = var7.method0998("x");
         float var20 = var6.method0998(this.field1352);
         float var21 = var7.method0998("y");
         float var22 = var6.method0998(this.field1362);
         float var23 = var7.method0998("z");
         float var24 = var19 + var18 + var13 + var21 + var20 + var13 + var23 + var22;
         float var25 = var14 + var15 + var24 + var16 * 2.0F;
         String var26 = NewHUD.HudEntry.method0026() ? "Скопировать" : "Copy";
         float var27 = var9.method0998(var26);
         float var28 = var8.method0998("u");
         float var29 = 6.0F;
         float var30 = 1.0F;
         float var31 = 3.0F;
         float var32 = 8.0F;
         float var33 = var29 + var30 + var29 + var27 + var31 + var28 + var32;
         boolean var34 = field0796.field_1755 instanceof class_408;
         double var35 = var34 ? field0796.field_1729.method_1603() * ScreenLayoutHelper.method2047() / field0796.method_22683().method_4480() : -1.0E9;
         double var37 = var34 ? field0796.field_1729.method_1604() * ScreenLayoutHelper.method1762() / field0796.method_22683().method_4507() : -1.0E9;
         float var39 = this.field1612.method0002();
         boolean var40 = var34 && MathHelper.method0689(var10, var11, var25, var12, (float)var35, (float)var37);
         float var41 = var10 + var25;
         float var42 = Math.max(0.0F, this.field1610.method0530() - var25);
         boolean var43 = var34 && var42 > 0.0F && var39 > 0.5F && MathHelper.method0689(var41, var11, var42, var12, (float)var35, (float)var37);
         boolean var44 = var40 || var43;
         if (this.field1612.method0376() != var44) {
            this.field1612.method1570(var44);
         }

         float var45 = this.field1612.method0002();
         float var46 = var25 + var33 * var45;
         this.field1610.method0705(var46, 200L);
         float var47 = Math.max(this.field1610.method0530(), var46);
         HudWidgetManager.method1605().method0215("NewCoords", var47, var12);
         this.method0321(var4, var2, var10, var11, var47, var12);
         this.method1468(var4, var10, var11, var47, var12, var2, this.field1604.method0492());
         Color var48 = this.method0964(this.field1153, var2);
         Color var49 = this.method0964(field1564, var2);
         Color var50 = this.method0964(field1641, var2);
         Color var51 = this.method0964(field1726, var2);
         Color var52 = this.method0964(field1500, var2);
         GuiRenderHelper.method1404(var1.method1806(), var10, var11, var47, var12);
         float var53 = var11 + (var12 - var5.method0530()) / 2.0F;
         GuiRenderHelper.method1491(var4, var5, "N", var10 + 8.0F, var53 - 0.5F, var48);
         float var54 = var10 + var14;
         GuiRenderHelper.method1463(var4, var54, var11, var15, var12, 0.0F, var52);
         float var55 = var11 + (var12 - var6.method0530()) / 2.0F;
         float var56 = var11 + (var12 - var7.method0530()) / 2.0F;
         float var57 = var54 + var15 + var16;
         GuiRenderHelper.method1491(var4, var7, "x", var57, var56, var51);
         var57 += var19;
         GuiRenderHelper.method1491(var4, var6, this.field1358, var57, var55, var50);
         var57 += var18 + var13;
         GuiRenderHelper.method1491(var4, var7, "y", var57, var56, var51);
         var57 += var21;
         GuiRenderHelper.method1491(var4, var6, this.field1352, var57, var55, var50);
         var57 += var20 + var13;
         GuiRenderHelper.method1491(var4, var7, "z", var57, var56, var51);
         var57 += var23;
         GuiRenderHelper.method1491(var4, var6, this.field1362, var57, var55, var50);
         var57 += var22;
         if (var45 > 0.05F) {
            float var58 = var57 + var29;
            float var59 = var11 + (var12 - var17) / 2.0F;
            int var60 = (int)(var52.getAlpha() * var45);
            GuiRenderHelper.method0326(
               var4, var58, var59, var30, var17, 0.5F, new Color(var52.getRed(), var52.getGreen(), var52.getBlue(), Math.max(0, Math.min(255, var60)))
            );
            float var61 = var11 + var12 / 2.0F;
            float var62 = var58 + var30 + var29;
            float var63 = var61 - var9.method0530() / 2.0F;
            float var64 = var62 + var27 + var31;
            float var65 = var61 - var8.method0530() / 2.0F;
            this.field1763 = var62 - 3.0F;
            this.field1765 = var11;
            this.field1751 = var64 + var28 - var62 + 6.0F;
            this.field1750 = var12;
            boolean var66 = var34
               && var45 > 0.5F
               && MathHelper.method0689(this.field1763, this.field1765, this.field1751, this.field1750, (float)var35, (float)var37);
            if (this.field1764.method0376() != var66) {
               this.field1764.method1570(var66);
            }

            float var67 = this.field1764.method0002();
            int var68 = (int)(170.0F + 70.0F * var67);
            int var69 = (int)(170.0F + 70.0F * var67);
            int var70 = (int)(170.0F + 80.0F * var67);
            int var71 = (int)(2.55F * (52.0F + 90.0F * var67) * var45);
            Color var72 = new Color(Math.min(255, var68), Math.min(255, var69), Math.min(255, var70), Math.max(0, Math.min(255, var71)));
            long var73 = System.currentTimeMillis() - this.field1752;
            long var75 = 180L;
            long var77 = 420L;
            float var79 = 0.0F;
            if (this.field1752 > 0L && var73 < var75 + var77) {
               float var80;
               if (var73 < var75) {
                  var80 = (float)var73 / (float)var75;
               } else {
                  var80 = 1.0F - (float)(var73 - var75) / (float)var77;
               }

               var80 = Math.max(0.0F, Math.min(1.0F, var80));
               var79 = var80 * var80 * (3.0F - 2.0F * var80);
            }

            int var96 = 170;
            int var81 = (int)(var96 + (var48.getRed() - var96) * var79);
            int var82 = (int)(var96 + (var48.getGreen() - var96) * var79);
            int var83 = (int)(var96 + (var48.getBlue() - var96) * var79);
            int var84 = (int)(2.55F * (52.0F + 90.0F * var67) * var45);
            Color var85 = new Color(
               Math.max(0, Math.min(255, var81)), Math.max(0, Math.min(255, var82)), Math.max(0, Math.min(255, var83)), Math.max(0, Math.min(255, var84))
            );
            GuiRenderHelper.method1491(var4, var9, var26, var62, var63, var72);
            float var86 = 1.0F + 0.18F * var67;
            float var87 = var64 + var28 / 2.0F;
            float var88 = var65 + var8.method0530() / 2.0F;
            var4.method_22903();
            var4.method_46416(var87, var88, 0.0F);
            var4.method_22905(var86, var86, 1.0F);
            var4.method_46416(-var87, -var88, 0.0F);
            GuiRenderHelper.method1491(var4, var8, "u", var64, var65, var85);
            var4.method_22909();
         } else {
            this.field1751 = 0.0F;
         }

         GuiRenderHelper.method1400(var1.method1806());
         var4.method_22909();
      }
   }

   private void method1650(HudRenderEvent var1) {
      float var2 = this.field0454.method0002();
      HudWidgetState var3 = HudWidgetManager.method1605().method1002("NewInventory");
      if (var3 != null) {
         class_4587 var4 = var1.method1806().method_51448();
         FontSize var5 = Fonts.field0774.method0654(4.0F);
         float var6 = var3.method1946();
         float var7 = var3.method0413();
         float var8 = 23.0F;
         float var9 = 8.0F;
         float var10 = 10.0F;
         float var11 = 6.0F;
         float var12 = 1.0F;
         float var13 = 7.0F;
         int var14 = 9;
         int var15 = 3;
         float var16 = var14 * var10 + (var14 - 1) * var11;
         float var17 = var16 + var9 * 2.0F;
         float var18 = var15 * var8 + (var15 - 1) * 1.0F;
         HudWidgetManager.method1605().method0215("NewInventory", var17, var18);
         this.method0321(var4, var2, var6, var7, var17, var18);
         this.method1468(var4, var6, var7, var17, var18, var2, this.field1756.method0492());
         GuiRenderHelper.method1404(var1.method1806(), var6, var7, var17, var18);
         float var19 = var6 + var9;

         for (int var20 = 0; var20 < var15; var20++) {
            float var21 = var7 + var20 * (var8 + 1.0F);
            float var22 = var21 + (var8 - var10) / 2.0F;

            for (int var23 = 0; var23 < var14; var23++) {
               int var24 = 9 + var20 * 9 + var23;
               float var25 = var19 + var23 * (var10 + var11);
               class_1799 var26 = class_1799.field_8037;
               if (field0796.field_1724 != null) {
                  var26 = field0796.field_1724.method_31548().method_5438(var24);
               }

               if (var26.method_7960()) {
                  float var27 = var5.method0530();
                  float var28 = var25 + (var10 - var27) / 2.0F;
                  float var29 = var22 + (var10 - var27) / 2.0F;
                  GuiRenderHelper.method1491(var4, var5, "t", var28, var29, this.method0964(field0486, var2));
               } else {
                  if (var2 > 0.85F) {
                     float var34 = var10 / 16.0F;
                     var4.method_22903();
                     var4.method_46416(var25, var22, 0.0F);
                     var4.method_22905(var34, var34, 1.0F);
                     var1.method1806().method_51427(var26, 0, 0);
                     var4.method_22909();
                  }

                  int var35 = var26.method_7947();
                  if (var35 > 1) {
                     FontSize var37 = Fonts.field0075.method0654(5.0F);
                     String var39 = "x" + var35;
                     float var30 = var37.method0998(var39);
                     float var31 = var25 + var10 - var30;
                     float var32 = var22 + var10 - var37.method0530() + 2.0F;
                     GuiRenderHelper.method1491(var4, var37, var39, var31, var32, this.method0964(field1641, var2));
                  }
               }

               if (var23 < var14 - 1) {
                  float var36 = var25 + var10 + (var11 - var12) / 2.0F;
                  float var38 = var22 + (var10 - var13) / 2.0F;
                  GuiRenderHelper.method0326(var4, var36, var38, var12, var13, 1.0F, this.method0964(field1026, var2));
               }
            }

            if (var20 < var15 - 1) {
               float var33 = var21 + var8;
               GuiRenderHelper.method1463(var4, var6, var33, var17, 1.0F, 0.0F, this.method0964(field0207, var2));
            }
         }

         GuiRenderHelper.method1400(var1.method1806());
         var4.method_22909();
      }
   }

   private boolean method1124(class_1293 var1) {
      if (var1 != null && !this.field0377.method_7960()) {
         if (System.currentTimeMillis() - this.field0372 > 3000L) {
            return false;
         }

         class_1291 var2 = (class_1291)var1.method_5579().comp_349();
         return var2 == class_1294.field_5924.comp_349()
            || var2 == class_1294.field_5898.comp_349()
            || var2 == class_1294.field_5907.comp_349()
            || var2 == class_1294.field_5918.comp_349();
      } else {
         return false;
      }
   }

   private void method0457() {
      if (field0796.field_1724 == null) {
         this.field0382 = false;
      } else if (!field0796.field_1724.method_6115()) {
         this.field0382 = false;
      } else {
         class_1799 var1 = field0796.field_1724.method_6030();
         if (var1.method_7909() != class_1802.field_8463 && var1.method_7909() != class_1802.field_8367) {
            this.field0382 = false;
         } else {
            int var2 = var1.method_7935(field0796.field_1724);
            if (var2 > 0) {
               if (field0796.field_1724.method_6048() >= var2 - 2 && !this.field0382) {
                  this.field0382 = true;
                  this.field0377 = var1.method_7972();
                  this.field0372 = System.currentTimeMillis();
                  String var3 = NewHUD.HudEntry.method0026() ? "Вы съели" : "You ate";
                  method1053(var3, "\"" + var1.method_7964().getString() + "\"", var1.method_7972(), true);
               }
            }
         }
      }
   }

   private void method1981(HudRenderEvent var1) {
      float var2 = this.field0286.method0002();
      HudWidgetState var3 = HudWidgetManager.method1605().method1002("NewArmorHUD");
      if (var3 != null) {
         class_4587 var4 = var1.method1806().method_51448();
         FontSize var5 = Fonts.field0774.method0654(6.0F);
         FontSize var6 = Fonts.field0075.method0654(6.5F);
         FontSize var7 = Fonts.field0075.method0654(6.5F);
         HudWidgetState.WidgetState var8 = var3.method1885();
         float var9 = var3.method1946();
         float var10 = var3.method0413();
         if (var8 == HudWidgetState.WidgetState.field0642) {
            this.method0846(var1, var4, var3, var9, var10, var5, var7, var2);
         } else {
            this.method0177(var1, var4, var3, var9, var10, var5, var7, var2);
         }
      }
   }

   private void method0846(
      HudRenderEvent var1, class_4587 var2, HudWidgetState var3, float var4, float var5, FontSize var6, FontSize var7, float var8
   ) {
      float var9 = 23.0F;
      float var10 = 21.0F;
      float var11 = 1.0F;
      float var12 = 8.0F;
      float var13 = 10.0F;
      float var14 = 6.0F;
      float var15 = 1.0F;
      float var16 = 7.0F;
      float var17 = 2.0F;
      float var18 = 1.0F;
      class_1799[] var19 = new class_1799[4];
      float[] var20 = new float[4];
      String[] var21 = new String[4];

      for (int var22 = 0; var22 < 4; var22++) {
         var19[var22] = class_1799.field_8037;
         var21[var22] = "";
         var20[var22] = 0.0F;
         if (field0796.field_1724 != null) {
            var19[var22] = field0796.field_1724.method_31548().method_7372(3 - var22);
         }

         if (!var19[var22].method_7960() && var19[var22].method_7936() > 0) {
            int var23 = var19[var22].method_7936() - var19[var22].method_7919();
            var20[var22] = (float)var23 / var19[var22].method_7936();
            if (this.field1768.method0492() == NewHUD.DurabilityMode.field0093) {
               var21[var22] = Math.round(var20[var22] * 100.0F) + "%";
            } else {
               var21[var22] = String.valueOf(var23);
            }
         }
      }

      float var43 = 0.0F;

      for (int var44 = 0; var44 < 4; var44++) {
         var43 += var13;
         if (!var21[var44].isEmpty()) {
            var43 += 2.0F + var7.method0998(var21[var44]);
         }

         if (var44 < 3) {
            var43 += var14;
         }
      }

      float var45 = 8.0F;
      float var24 = var43 + var45 * 2.0F;
      float var25 = var10 + var11 + var24;
      this.field1776.method0705(var25, 200L);
      float var26 = this.field1776.method0530();
      if (Float.isNaN(this.field1777) || var3.method2195()) {
         float var27 = var3.method2195() ? var3.method0355() : var25;
         this.field1777 = var3.method1946() + var27 / 2.0F;
      }

      float var46 = this.field1777 - var25 / 2.0F;
      var3.method0665(var46);
      HudWidgetManager.method1605().method0215("NewArmorHUD", var25, var9);
      var4 = this.field1777 - var26 / 2.0F;
      this.method0321(var2, var8, var4, var5, var26, var9);
      this.method1468(var2, var4, var5, var26, var9, var8, this.field1743.method0492());
      Color var28 = this.method0964(this.field1153, var8);
      Color var29 = this.method0964(field1564, var8);
      Color var30 = this.method0964(field1641, var8);
      GuiRenderHelper.method1404(var1.method1806(), var4, var5, var26, var9);
      FontSize var31 = Fonts.field0774.method0654(6.0F);
      float var32 = var5 + (var9 - var31.method0530()) / 2.0F - 0.5F;
      GuiRenderHelper.method1491(var2, var31, "U", var4 + 7.6F, var32, var28);
      float var33 = var4 + var10;
      GuiRenderHelper.method1463(var2, Math.round(var33), var5, var11, var9, 0.0F, this.method0964(field1500, var8));
      float var34 = var33 + var11 + var45;
      float var35 = var5 + (var9 - var13 - var18 - var17) / 2.0F;

      for (int var36 = 0; var36 < 4; var36++) {
         float var37 = var34 + 1.0F;
         if (var19[var36].method_7960()) {
            float var38 = var6.method0530();
            float var39 = var34 + (var13 - var38) / 2.0F;
            float var40 = 1.7F;
            float var41 = var35 + (var13 - var38) / 2.0F + var40 - 1.0F;
            GuiRenderHelper.method1491(var2, var6, "t", var39, var41, this.method0964(field0486, var8));
         } else if (var8 > 0.85F) {
            float var48 = var13 / 16.0F;
            var2.method_22903();
            var2.method_46416(var34, var35, 0.0F);
            var2.method_22905(var48, var48, 1.0F);
            var1.method1806().method_51427(var19[var36], 0, 0);
            var2.method_22909();
         }

         var34 += var13;
         if (!var21[var36].isEmpty()) {
            var34 += 2.0F;
            float var49 = var5 + (var9 - var7.method0530()) / 2.0F - (var18 + var17) / 2.0F;
            GuiRenderHelper.method1491(var2, var7, var21[var36], var34, var49, var30);
            var34 += var7.method0998(var21[var36]);
         }

         if (!var19[var36].method_7960() && var19[var36].method_7936() > 0) {
            float var50 = var34 - var37;
            float var52 = var35 + var13 + var18;
            GuiRenderHelper.method0326(var2, var37, var52, var50, var17, 1.0F, field0364);
            float var54 = var50 * var20[var36];
            if (var54 > 0.0F) {
               GuiRenderHelper.method0326(var2, var37, var52, var54, var17, 1.0F, var28);
            }
         }

         if (var36 < 3) {
            float var51 = var34 + (var14 - var15) / 2.0F;
            float var53 = var5 + (var9 - var16) / 2.0F;
            GuiRenderHelper.method0326(var2, Math.round(var51), var53, 1.0F, var16, 1.0F, field0364);
            var34 += var14;
         }
      }

      GuiRenderHelper.method1400(var1.method1806());
      var2.method_22909();
   }

   private void method0177(
      HudRenderEvent var1, class_4587 var2, HudWidgetState var3, float var4, float var5, FontSize var6, FontSize var7, float var8
   ) {
      float var9 = 26.0F;
      float var10 = 23.0F;
      float var11 = 1.0F;
      float var12 = 7.0F;
      float var13 = 7.0F;
      float var14 = 10.0F;
      float var15 = 6.0F;
      float var16 = 6.0F;
      float var17 = 1.0F;
      float var18 = 2.0F;
      float var19 = 1.0F;
      class_1799[] var20 = new class_1799[4];
      float[] var21 = new float[4];

      for (int var22 = 0; var22 < 4; var22++) {
         var20[var22] = class_1799.field_8037;
         var21[var22] = 0.0F;
         if (field0796.field_1724 != null) {
            var20[var22] = field0796.field_1724.method_31548().method_7372(3 - var22);
         }

         if (!var20[var22].method_7960() && var20[var22].method_7936() > 0) {
            int var23 = var20[var22].method_7936() - var20[var22].method_7919();
            var21[var22] = (float)var23 / var20[var22].method_7936();
         }
      }

      float var42 = var14 + var15;
      float var43 = 4.0F * var14 + 3.0F * var15;
      float var24 = var10 + var11 + var12 + var43 + var13;
      this.field1775.method0705(var24, 200L);
      float var25 = this.field1775.method0530();
      if (Float.isNaN(this.field1777) || var3.method2195()) {
         float var26 = var3.method2195() ? var3.method0355() : var9;
         this.field1777 = var3.method1946() + var26 / 2.0F;
      }

      float var44 = this.field1777 - var9 / 2.0F;
      var3.method0665(var44);
      HudWidgetManager.method1605().method0215("NewArmorHUD", var9, var25);
      var4 = var44;
      this.method0321(var2, var8, var4, var5, var9, var25);
      this.method1468(var2, var4, var5, var9, var25, var8, this.field1743.method0492());
      Color var27 = this.method0964(this.field1153, var8);
      Color var28 = this.method0964(field1564, var8);
      GuiRenderHelper.method1404(var1.method1806(), var4, var5, var9, var25);
      FontSize var29 = Fonts.field0774.method0654(6.0F);
      float var30 = var5 + (var10 - var29.method0530()) / 2.0F - 0.5F;
      GuiRenderHelper.method1491(var2, var29, "U", var4 + 9.0F, var30, var27);
      float var31 = var5 + var10;
      GuiRenderHelper.method1463(var2, var4, Math.round(var31), var9, var11, 0.0F, this.method0964(field1500, var8));
      float var32 = var31 + var11 + var12;
      float var33 = var4 + (var9 - var14) / 2.0F;
      float var34 = var4 + (var9 - var16) / 2.0F;

      for (int var35 = 0; var35 < 4; var35++) {
         float var36 = var32 + var35 * var42;
         if (var20[var35].method_7960()) {
            float var37 = var6.method0998("t");
            float var38 = var6.method0530();
            float var39 = var4 + (var9 - var37) / 2.0F - 0.5F;
            float var40 = var36 + (var14 - var38) / 2.0F;
            GuiRenderHelper.method1491(var2, var6, "t", var39, var40, this.method0964(field0486, var8));
         } else if (var8 > 0.85F) {
            float var45 = var14 / 16.0F;
            var2.method_22903();
            var2.method_46416(var33, var36, 0.0F);
            var2.method_22905(var45, var45, 1.0F);
            var1.method1806().method_51427(var20[var35], 0, 0);
            var2.method_22909();
         }

         if (!var20[var35].method_7960() && var20[var35].method_7936() > 0) {
            float var46 = var36 + var14 + var19;
            GuiRenderHelper.method0326(var2, var33, var46, var14, var18, 1.0F, field0364);
            float var48 = var14 * var21[var35];
            if (var48 > 0.0F) {
               GuiRenderHelper.method0326(var2, var33, var46, var48, var18, 1.0F, var27);
            }
         }

         if (var35 < 3) {
            float var47 = var36 + var14 + (var15 - var17) / 2.0F;
            GuiRenderHelper.method0326(var2, var34, Math.round(var47), var16, var17, 1.0F, field0364);
         }
      }

      GuiRenderHelper.method1400(var1.method1806());
      var2.method_22909();
   }

   private void method0437(HudRenderEvent var1) {
      float var2 = this.field0248.method0002();
      List var3 = this.field1323;
      HudWidgetState var4 = HudWidgetManager.method1605().method1002("NewKeyBinds");
      if (var4 != null) {
         class_4587 var5 = var1.method1806().method_51448();
         FontSize var6 = Fonts.field0774.method0654(5.5F);
         FontSize var7 = Fonts.field0774.method0654(5.5F);
         FontSize var8 = Fonts.field0774.method0654(4.5F);
         FontSize var9 = Fonts.field0075.method0654(6.5F);
         FontSize var10 = Fonts.field0075.method0654(5.0F);
         float var11 = var4.method1946();
         float var12 = var4.method0413();
         float var13 = 6.0F;
         float var14 = 23.0F;
         float var15 = 6.0F;
         float var16 = 10.0F;
         float var17 = 3.0F;
         float var18 = 1.0F;
         float var19 = 7.0F;
         float var20 = 3.0F;
         float var21 = 3.0F;
         float var22 = 10.0F;
         float var23 = 4.0F;
         float var24 = 6.0F;
         float var25 = var6.method0998("I");

         for (ModuleCategory var29 : ModuleCategory.values()) {
            var25 = Math.max(var25, var6.method0998(var29.method0017()));
         }

         var25 = Math.max(var25, 8.0F);
         float var60 = var25 + var23 + var18 + var23;
         float var61 = var3.isEmpty() ? 0.0F : var3.size() * (var16 + var17) - var17;
         float var62 = var14 + (var61 > 0.0F ? 1.0F + var15 * 2.0F + var61 : 0.0F);
         float var63 = var60 + var9.method0998("Keybinds");

         for (Module var31 : var3) {
            float var32 = var10.method0998(var31.method2259().toString());
            float var33 = var20 + var32 + 3.0F + var8.method0998("X") + var20;
            var63 = Math.max(var63, var60 + var9.method0998(var31.method0423()) + var24 + var33);
         }

         float var64 = Math.max(95.0F, var13 * 2.0F + var63);
         this.field1183.method0705(var62, 200L);
         float var65 = this.field1183.method0530();
         this.field1182.method0705(var64, 200L);
         float var66 = this.field1182.method0530();
         HudWidgetManager.method1605().method0215("NewKeyBinds", var66, var65);
         this.method0321(var5, var2, var11, var12, var66, var65);
         this.method1468(var5, var11, var12, var66, var65, var2, this.field1176.method0492());
         Color var67 = this.method0964(this.field1153, var2);
         Color var34 = this.method0964(field1564, var2);
         Color var35 = this.method0964(field1641, var2);
         Color var36 = this.method0964(field1126, var2);
         Color var37 = this.method0964(field1128, var2);
         Color var38 = this.method0964(field0207, var2);
         GuiRenderHelper.method1404(var1.method1806(), var11, var12, var66, var65);
         float var39 = var11 + var13;
         float var40 = var12 + (var14 - var9.method0530()) / 2.0F;
         GuiRenderHelper.method1491(var5, var6, "I", var39 + 1.0F, var12 + (var14 - var6.method0530()) / 2.0F - 0.5F, var67);
         var39 = var11 + var13 + var25 + var23;
         float var41 = var12 + (var14 - var19) / 2.0F;
         GuiRenderHelper.method0326(var5, Math.round(var39), var41, var18, var19, 1.0F, this.method0964(field1026, var2));
         var39 += var18 + var23;
         GuiRenderHelper.method1491(var5, var9, "Keybinds", var39, var40, var35);
         if (!var3.isEmpty()) {
            float var42 = var12 + var14;
            GuiRenderHelper.method1463(var5, var11, var42, var66, 1.0F, 0.0F, var38);
            float var43 = var42 + 1.0F + var15;
            float var44 = var11 + var13;
            float var45 = var11 + var66 - var13;

            for (int var46 = 0; var46 < var3.size(); var46++) {
               Module var47 = var3.get(var46);
               float var48 = var43 + var46 * (var16 + var17);
               float var49 = var48 + var16 / 2.0F;
               String var50 = var47.method2220().method0017();
               float var51 = var47.method2220() == ModuleCategory.field1470 ? 0.7F : 0.0F;
               GuiRenderHelper.method1491(var5, var7, var50, var44 + 1.0F + var51, var49 - var6.method0530() / 2.0F - 0.1F, var67);
               float var52 = var44 + var25 + var23;
               GuiRenderHelper.method0326(var5, Math.round(var52), var49 - var19 / 2.0F, var18, var19, 1.0F, this.method0964(field1026, var2));
               var52 += var18 + var23;
               GuiRenderHelper.method1491(var5, var9, var47.method0423(), var52, var49 - var9.method0530() / 2.0F, var35);
               String var53 = var47.method2259().toString();
               float var54 = var10.method0998(var53);
               float var55 = var8.method0998("X");
               float var56 = var20 + var54 + 3.0F + var55 + var20;
               float var57 = var45 - var56;
               float var58 = var49 - var22 / 2.0F;
               GuiRenderHelper.method0326(var5, var57, var58, var56, var22, var21, var36);
               GuiRenderHelper.method1460(var5, var57, var58, var56, var22, var21, 0.3F, 0.5F, 0.5F, var37);
               GuiRenderHelper.method1491(var5, var10, var53, var57 + var20, var49 - var10.method0530() / 2.0F, var35);
               GuiRenderHelper.method1491(var5, var8, "X", var57 + var20 + var54 + 2.8F, var49 - var8.method0530() / 2.0F - 0.2F, var67);
            }
         }

         GuiRenderHelper.method1400(var1.method1806());
         var5.method_22909();
      }
   }

   private void method0381(HudRenderEvent var1) {
      float var2 = this.field0245.method0002();
      HudWidgetState var3 = HudWidgetManager.method1605().method1002("NewPotions");
      if (var3 != null) {
         class_4587 var4 = var1.method1806().method_51448();
         FontSize var5 = Fonts.field0774.method0654(6.0F);
         FontSize var6 = Fonts.field0075.method0654(6.5F);
         FontSize var7 = Fonts.field0075.method0654(6.5F);
         FontSize var8 = Fonts.field0075.method0654(5.0F);
         float var9 = var3.method1946();
         float var10 = var3.method0413();
         float var11 = 8.0F;
         float var12 = 23.0F;
         float var13 = 6.0F;
         float var14 = 10.0F;
         float var15 = 3.0F;
         float var16 = 1.0F;
         float var17 = 7.0F;
         float var18 = 8.0F;
         float var19 = 0.7F;
         float var20 = 3.0F;
         float var21 = 3.0F;
         float var22 = 10.0F;
         float var23 = 6.0F;
         List var24 = this.field1318;
         List var25 = this.field1327;
         float var26 = var12;
         if (!var24.isEmpty()) {
            var26 += 1.0F + var13 * 2.0F + var24.size() * (var14 + var15) - var15;
         }

         if (!var25.isEmpty()) {
            var26 += 1.0F + var13 * 2.0F + var25.size() * (var14 + var15) - var15;
         }

         float var27 = 6.0F;
         float var28 = var18 + 4.0F + var16 + 4.0F + var6.method0998("Potions");

         for (List var30 : List.of(var24, var25)) {
            for (class_1293 var32 : var30) {
               float var33 = var32.method_5578() > 0 ? var27 + var7.method0998(String.valueOf(var32.method_5578() + 1)) : 0.0F;
               float var34 = var20 + var8.method0998(this.method0142(var32.method_5584())) + 3.0F + var23 + var20;
               float var35 = var18 + 4.0F + var16 + 4.0F + var6.method0998(this.method1850(var32)) + var33 + var27 + var34;
               var28 = Math.max(var28, var35);
            }
         }

         float var70 = Math.max(95.0F, var11 * 2.0F + var28);
         this.field1184.method0705(var26, 200L);
         float var71 = this.field1184.method0530();
         this.field1172.method0705(var70, 200L);
         float var72 = this.field1172.method0530();
         HudWidgetManager.method1605().method0215("NewPotions", var72, var71);
         this.method0321(var4, var2, var9, var10, var72, var71);
         this.method1468(var4, var9, var10, var72, var71, var2, this.field1188.method0492());
         Color var73 = this.method0964(this.field1153, var2);
         Color var74 = this.method0964(field1564, var2);
         Color var75 = this.method0964(field1641, var2);
         Color var76 = this.method0964(field1726, var2);
         Color var36 = this.method0964(field1026, var2);
         Color var37 = this.method0964(field0207, var2);
         Color var38 = this.method0964(field1126, var2);
         Color var39 = this.method0964(field1128, var2);
         Color var40 = this.method0964(field0884, var2);
         GuiRenderHelper.method1404(var1.method1806(), var9, var10, var72, var71);
         float var41 = var9 + var11;
         float var42 = var10 + (var12 - var6.method0530()) / 2.0F;
         float var43 = var41 + (var18 - var5.method0998("w")) / 2.0F;
         GuiRenderHelper.method1491(var4, var5, "w", var43, var10 + (var12 - var5.method0530()) / 2.0F - 0.5F, var73);
         var41 = var9 + var11 + var18 + 4.0F;
         float var44 = var10 + (var12 - var17) / 2.0F;
         GuiRenderHelper.method0326(var4, Math.round(var41), var44, var16, var17, 1.0F, var36);
         var41 += var16 + 4.0F;
         GuiRenderHelper.method1491(var4, var6, "Potions", var41, var42, var75);
         float var45 = var10 + var12;
         float var46 = var9 + var11;
         float var47 = var9 + var72 - var11;
         if (!var24.isEmpty()) {
            GuiRenderHelper.method1463(var4, var9, var45, var72, 1.0F, 0.0F, var37);
            float var48 = ++var45 + var13;

            for (int var49 = 0; var49 < var24.size(); var49++) {
               try {
                  class_1293 var50 = var24.get(var49);
                  float var51 = var48 + var49 * (var14 + var15);
                  float var52 = var51 + var14 / 2.0F;
                  class_2960 var53 = this.method0232(var50);
                  GuiRenderHelper.method1466(var4, var46 - var19, var52 - var18 / 2.0F, var18, var18, 0.0F, var53, Color.WHITE);
                  float var54 = var46 + var18 + 4.0F;
                  GuiRenderHelper.method0326(var4, Math.round(var54), var52 - var17 / 2.0F, var16, var17, 1.0F, var36);
                  var54 += 5.0F;
                  String var55 = this.method1850(var50);
                  GuiRenderHelper.method1491(var4, var6, var55, var54, var52 - var6.method0530() / 2.0F, var75);
                  var54 += var6.method0998(var55);
                  if (var50.method_5578() > 0) {
                     String var56 = String.valueOf(var50.method_5578() + 1);
                     GuiRenderHelper.method1491(var4, var7, var56, var54 + var27 - 4.0F, var52 - var7.method0530() / 2.0F, var76);
                  }

                  String var93 = this.method0142(var50.method_5584());
                  float var57 = var8.method0998(var93);
                  float var58 = var20 + var57 + 3.0F + var23 + var20;
                  class_2960 var59 = this.method0232(var50);
                  HudAnimation var60 = this.field1405.computeIfAbsent(var59, var0 -> new HudAnimation(EasingCurve.field0203));
                  var60.method0705(var58, 150L);
                  float var61 = var60.method0530();
                  float var62 = var47 - var61;
                  float var63 = var52 - var22 / 2.0F;
                  GuiRenderHelper.method0326(var4, var62, var63, var61, var22, var21, var38);
                  GuiRenderHelper.method1460(var4, var62, var63, var61, var22, var21, 0.3F, 0.5F, 0.5F, var39);
                  float var64 = var47 - var58 + var20;
                  GuiRenderHelper.method1491(var4, var8, var93, var64, var52 - var8.method0530() / 2.0F, var75);
                  float var65 = var64 + var57 + 3.0F + var23 / 2.0F;
                  float var66 = var52;
                  float var67 = this.method1987(var50);
                  GuiRenderHelper.method2171(var4, var65, var66, var23 / 2.0F, 0.5F, 1.0F, var40);
                  if (var67 > 0.0F) {
                     GuiRenderHelper.method2171(var4, var65, var66, var23 / 2.0F - 0.5F, 0.5F, var67, var73);
                  }
               } catch (Exception var69) {
               }
            }

            var45 += var13 * 2.0F + var24.size() * (var14 + var15) - var15;
         }

         if (!var25.isEmpty()) {
            GuiRenderHelper.method1463(var4, var9, var45, var72, 1.0F, 0.0F, var37);
            float var81 = ++var45 + var13;

            for (int var82 = 0; var82 < var25.size(); var82++) {
               try {
                  class_1293 var83 = var25.get(var82);
                  float var84 = var81 + var82 * (var14 + var15);
                  float var85 = var84 + var14 / 2.0F;
                  class_2960 var86 = this.method0232(var83);
                  Color var89 = new Color(255, 255, 255, 122);
                  GuiRenderHelper.method1466(var4, var46 - var19, var85 - var18 / 2.0F, var18, var18, 0.0F, var86, var89);
                  float var90 = var46 + var18 + 4.0F;
                  GuiRenderHelper.method0326(var4, Math.round(var90), var85 - var17 / 2.0F, var16, var17, 1.0F, var36);
                  var90 += 5.0F;
                  String var94 = this.method1850(var83);
                  GuiRenderHelper.method1491(var4, var6, var94, var90, var85 - var6.method0530() / 2.0F, this.method0964(field0840, var2));
                  var90 += var6.method0998(var94);
                  if (var83.method_5578() > 0) {
                     String var95 = String.valueOf(var83.method_5578() + 1);
                     GuiRenderHelper.method1491(var4, var7, var95, var90 + var27 - 4.0F, var85 - var7.method0530() / 2.0F, this.method0964(field0927, var2));
                  }

                  String var96 = this.method0142(var83.method_5584());
                  float var97 = var8.method0998(var96);
                  float var98 = var20 + var97 + 3.0F + var23 + var20;
                  HudAnimation var99 = this.field1405.computeIfAbsent(var86, var0 -> new HudAnimation(EasingCurve.field0203));
                  var99.method0705(var98, 150L);
                  float var100 = var99.method0530();
                  float var101 = var47 - var100;
                  float var102 = var85 - var22 / 2.0F;
                  GuiRenderHelper.method0326(var4, var101, var102, var100, var22, var21, var38);
                  GuiRenderHelper.method1460(var4, var101, var102, var100, var22, var21, 0.3F, 0.5F, 0.5F, var39);
                  float var103 = var47 - var98 + var20;
                  GuiRenderHelper.method1491(var4, var8, var96, var103, var85 - var8.method0530() / 2.0F, this.method0964(field1346, var2));
                  float var104 = var103 + var97 + 3.0F + var23 / 2.0F;
                  float var105 = var85;
                  float var106 = this.method1987(var83);
                  GuiRenderHelper.method2171(var4, var104, var105, var23 / 2.0F, 0.5F, 1.0F, this.method0964(field1307, var2));
                  if (var106 > 0.0F) {
                     GuiRenderHelper.method2171(var4, var104, var105, var23 / 2.0F - 0.5F, 0.5F, var106, this.method0964(field1383, var2));
                  }
               } catch (Exception var68) {
               }
            }
         }

         GuiRenderHelper.method1400(var1.method1806());
         var4.method_22909();
      }
   }

   private class_2960 method0232(class_1293 var1) {
      try {
         class_2960 var2 = class_7923.field_41174.method_10221((class_1291)var1.method_5579().comp_349());
         if (var2 != null) {
            return class_2960.method_60655(var2.method_12836(), "textures/mob_effect/" + var2.method_12832() + ".png");
         }
      } catch (Exception var3) {
      }

      return class_2960.method_60655("minecraft", "textures/mob_effect/empty.png");
   }

   private boolean method2143(class_1293 var1) {
      try {
         return ((class_1291)var1.method_5579().comp_349()).method_18792() == class_4081.field_18271;
      } catch (Exception var3) {
         return true;
      }
   }

   private String method1850(class_1293 var1) {
      String var2 = ((class_1291)var1.method_5579().comp_349()).method_5567();
      return class_1074.method_4662(var2, new Object[0]);
   }

   private String method1659(class_1293 var1) {
      try {
         class_2960 var2 = class_7923.field_41174.method_10221((class_1291)var1.method_5579().comp_349());
         return var2 != null ? var2.toString() + "_" + var1.method_5578() : ((class_1291)var1.method_5579().comp_349()).method_5567();
      } catch (Exception var3) {
         return ((class_1291)var1.method_5579().comp_349()).method_5567();
      }
   }

   private boolean method0730(int var1) {
      return var1 < 0 || var1 >= 1073741823;
   }

   private float method1987(class_1293 var1) {
      if (this.method0730(var1.method_5584())) {
         return 1.0F;
      }

      String var2 = this.method1659(var1);
      int var3 = this.field1392.getOrDefault(var2, var1.method_5584());
      return var3 <= 0 ? 1.0F : Math.min(1.0F, (float)var1.method_5584() / var3);
   }

   private String method0142(int var1) {
      if (this.method0730(var1)) {
         return "**:**";
      }

      int var2 = var1 / 20;
      int var3 = var2 / 60;
      var2 %= 60;
      return var3 >= 60 ? String.format("%dh %02d:%02d", var3 / 60, var3 % 60, var2) : String.format("%d:%02d", var3, var2);
   }

   private void method0479() {
      if (field0796.field_1724 != null && field0796.field_1687 != null) {
         Aura var1 = Aura.method1701();
         class_1309 var2 = var1 != null && var1.method2195() ? var1.method0409() : null;
         if (var2 != null && var2.method_5805()) {
            this.field0312 = var2;
            this.field0305.method1570(true);
         } else if (field0796.field_1755 instanceof class_408 && field0796.field_1724.method_5805()) {
            this.field0312 = field0796.field_1724;
            this.field0305.method1570(true);
         } else {
            this.field0305.method1570(false);
            if (this.field0305.method0346(false)) {
               this.field0312 = null;
               this.field0520.clear();
               this.field0545 = -1.0F;
            }
         }
      } else {
         this.field0312 = null;
      }
   }

   private void method0502(HudRenderEvent var1) {
      float var2 = this.field0308.method0002();
      HudWidgetState var3 = HudWidgetManager.method1605().method1002("NewTargetHud");
      if (var3 != null) {
         float var4 = this.field0305.method0002();
         if (this.field0312 != null || !(var4 < 0.01F)) {
            if (!(var2 < 0.01F)) {
               class_4587 var5 = var1.method1806().method_51448();
               FontSize var6 = Fonts.field0075.method0654(5.0F);
               FontSize var7 = Fonts.field0075.method0654(4.0F);
               float var8 = 33.0F;
               float var9 = 1.0F;
               float var10 = 80.0F;
               float var11 = var8 + var9 + var10;
               float var12 = 33.0F;
               float var13 = 6.0F;
               this.field0544.method0705(var11, 200L);
               float var14 = this.field0544.method0530();
               float var15 = var3.method0355();
               HudWidgetManager.method1605().method0215("NewTargetHud", var14, var12);
               if (!var3.method2195() && var15 > 0.0F && Math.abs(var14 - var15) > 0.1F && Math.abs(var14 - var15) < 2.0F) {
                  var3.method0665(var3.method1946() - (var14 - var15) / 2.0F);
               }

               float var16 = var3.method1946();
               float var17 = var3.method0413();
               if (!(var4 <= 0.01F)) {
                  float var18 = var2 * var4;
                  this.method0321(var5, var18, var16, var17, var14, var12);
                  this.method1468(var5, var16, var17, var14, var12, var18, this.field1229.method0492());
                  GuiRenderHelper.method1404(var1.method1806(), var16, var17, var14, var12);
                  Color var19 = this.method0964(this.field1153, var18);
                  Color var20 = this.method0964(field1564, var18);
                  Color var21 = this.method0964(field1641, var18);
                  Color var22 = this.method0964(field0399, var18);
                  float var23 = 22.0F;
                  float var24 = (var8 - var23) / 2.0F;
                  float var25 = var16 + var24;
                  float var26 = var17 + (var12 - var23) / 2.0F;
                  GuiRenderHelper.method1463(var5, var25, var26, var23, var23, 3.0F, this.method0964(field1210, var18));
                  if (this.field0312 instanceof class_742 var27) {
                     try {
                        class_2960 var66 = var27.method_52814().comp_1626();
                        GuiRenderHelper.method1459(
                           var5, var25, var26, var23, var23, 3.0F, 0.125F, 0.125F, 0.125F, 0.125F, var66, this.method0964(field1641, var18)
                        );
                     } catch (Exception var64) {
                     }
                  }

                  float var65 = var16 + var8;
                  GuiRenderHelper.method1463(var5, var65, var17, var9, var12, 0.0F, var22);
                  float var67 = var65 + var9 + var13;
                  float var29 = var17 + var13;
                  String var30 = this.field0312 != null ? NameProtect.method2131(this.field0312.method_5477().getString()) : "";
                  GuiRenderHelper.method1491(var5, var6, var30, var67, var29, var21);
                  float var31 = 0.0F;
                  float var32 = 20.0F;
                  float var33 = 0.0F;
                  if (this.field0312 != null) {
                     if (this.field0312 instanceof class_1657 var34) {
                        float var69 = PlayerStatusHelper.method1178(var34);
                        var31 = var69 >= 0.0F ? var69 : this.field0312.method_6032();
                     } else {
                        var31 = this.field0312.method_6032();
                     }

                     var32 = this.field0312.method_6063();
                     var33 = this.field0312.method_6067();
                  }

                  String var68 = String.valueOf((int)(var31 + var33));
                  float var70 = var6.method0998(var68);
                  float var36 = 6.0F;
                  float var37 = var17 + var12 - var36 - 4.5F;
                  float var38 = var65 + var9 + var13 - 1.0F;
                  float var39 = var14 - (var65 + var9 - var16) - var13 * 2.0F - 6.5F;
                  float var40 = var32 > 0.0F ? Math.min(1.0F, var31 / var32) : 0.0F;
                  float var41 = 2.0F;
                  this.field0541.method0705(var40, 300L);
                  float var42 = this.field0541.method0530();
                  Color var43 = ThemeColorManager.method1908().method0662(var18 * 0.07F);
                  GuiRenderHelper.method1463(var5, var38, var37, var39, var36, var41, var43);
                  if (var42 > 0.0F) {
                     float var44 = var39 * var42;
                     float var45 = var44 < var36 ? 0.0F : var41;
                     GuiRenderHelper.method1463(var5, var38, var37, var44, var36, var45, var19);
                  }

                  if (var33 > 0.0F) {
                     float var71 = Math.min(1.0F, var33 / var32);
                     float var73 = var39 * var71;
                     float var46 = var39 * var42;
                     float var47 = var38 + var46;
                     if (var47 + var73 > var38 + var39) {
                        var73 = var38 + var39 - var47;
                     }

                     if (var73 > 0.0F) {
                        GuiRenderHelper.method0326(var5, var47, var37, var73, var36, var41, this.method0964(new Color(255, 215, 0), var18));
                     }
                  }

                  float var72 = var38 + var39 * var40;
                  float var74 = var37 + var36 / 2.0F;
                  if (this.field1221.method0492() && this.field0545 >= 0.0F && var40 < this.field0545 && var18 > 0.5F) {
                     int var75 = 18 + (int)((this.field0545 - var40) * 25.0F);

                     for (int var77 = 0; var77 < var75; var77++) {
                        float var48 = (float)(Math.random() * 0.40000007F - 0.1F);
                        float var49 = (float)(Math.random() * 0.5 - 0.35000005F);
                        float var50 = 3.0F + (float)(Math.random() * 4.0);
                        float var51 = 80.0F + (float)(Math.random() * 60.0);
                        this.field0520.add(new float[]{var72, var74, var48, var49, var50, var51, var51});
                     }
                  }

                  this.field0545 = var40;
                  FontSize var76 = Fonts.field0774.method0654(4.0F);
                  float var78 = var76.method0998("J");
                  float var79 = var16 + var14 - var13 - var70;
                  GuiRenderHelper.method1491(var5, var76, "J", var79 - var78 - 2.0F, var29 + 0.7F, var19);
                  GuiRenderHelper.method1491(var5, var6, var68, var79, var29, var21);
                  float var80 = var29 + var6.method0530() + 1.0F;
                  float var81 = 8.0F;
                  float var82 = 2.5F;
                  float var52 = 1.0F;
                  float var53 = var67;
                  if (this.field0312 instanceof class_1657 var54) {
                     class_1799[] var84 = new class_1799[]{var54.method_6047(), var54.method_6079(), null, null, null, null};

                     for (int var56 = 0; var56 < 4; var56++) {
                        var84[2 + var56] = var54.method_31548().method_7372(3 - var56);
                     }

                     int var86 = 0;

                     for (int var57 = 0; var57 < 6; var57++) {
                        if (!var84[var57].method_7960()) {
                           float var58 = var53 + var86 * (var81 + var82);
                           float var59 = var80;
                           if (var18 > 0.85F) {
                              float var60 = var81 / 16.0F;
                              var5.method_22903();
                              var5.method_46416(var58, var59, 0.0F);
                              var5.method_22905(var60, var60, 1.0F);
                              var1.method1806().method_51427(var84[var57], 0, 0);
                              var5.method_22909();
                           }

                           if (var84[var57].method_7947() > 1) {
                              FontSize var91 = Fonts.field0075.method0654(3.5F);
                              String var61 = String.valueOf(var84[var57].method_7947());
                              float var62 = var58 + var81 - var91.method0998(var61);
                              float var63 = var59 + var81 - var91.method0530() + 1.0F;
                              GuiRenderHelper.method1491(var5, var91, var61, var62, var63, var21);
                           }

                           var86++;
                        }
                     }
                  }

                  GuiRenderHelper.method1400(var1.method1806());
                  var5.method_22909();
                  Color var83 = ThemeColorManager.method1908().method2063();
                  Iterator var85 = this.field0520.iterator();

                  while (var85.hasNext()) {
                     float[] var87 = var85.next();
                     var87[0] += var87[2];
                     var87[1] += var87[3];
                     var87[3] += 0.005F;
                     var87[2] *= 0.99F;
                     var87[5]--;
                     if (var87[5] <= 0.0F) {
                        var85.remove();
                     } else {
                        float var88 = var87[5] / var87[6] * var18;
                        float var89 = var87[4] * (var87[5] / var87[6]);
                        Color var90 = new Color(var83.getRed(), var83.getGreen(), var83.getBlue(), Math.max(0, Math.min(255, (int)(var88 * 200.0F))));
                        GuiRenderHelper.method1466(var5, var87[0] - var89 / 2.0F, var87[1] - var89 / 2.0F, var89, var89, var89 / 2.0F, field0517, var90);
                     }
                  }
               }
            }
         }
      }
   }

   private void method2233(HudRenderEvent var1) {
      float var2 = this.field0253.method0002();
      HudWidgetState var3 = HudWidgetManager.method1605().method1002("NewNotifications");
      if (var3 != null) {
         class_4587 var4 = var1.method1806().method_51448();
         FontSize var5 = Fonts.field0774.method0654(5.0F);
         FontSize var6 = Fonts.field0075.method0654(6.5F);
         float var7 = ScreenLayoutHelper.method2047();
         float var8 = 23.0F;
         float var9 = 4.0F;
         float var10 = 12.0F;
         float var11 = 1.0F;
         float var12 = 7.0F;
         float var13 = 1.0F;
         Color var14 = this.method0964(field0436, var2);
         boolean var15 = this.field1131.method0492() == NewHUD.NotificationDirection.field0092;
         float var16 = var3.method0413();
         List var17 = new ArrayList<>(field1588);
         boolean var18 = field0796.field_1755 instanceof class_408 && var17.isEmpty();
         if (!var18) {
            for (NewHUD.HudEntry var20 : var17) {
               if (var20.method1635()) {
                  var20.method1812();
               }
            }
         }

         float var71 = 10.0F;
         long var72 = 1500L;
         ModuleCategory[] var22 = ModuleCategory.values();
         class_1799[] var23 = new class_1799[]{
            new class_1799(class_1802.field_8802),
            new class_1799(class_1802.field_8288),
            new class_1799(class_1802.field_8634),
            new class_1799(class_1802.field_8463)
         };
         int var24 = var22.length + var23.length;
         int var25 = var18 ? (int)(System.currentTimeMillis() / var72 % var24) : 0;
         boolean var26 = var18 && var25 >= var22.length;
         class_1799 var27 = var26 ? var23[var25 - var22.length] : null;
         String var28 = var18 && !var26 ? var22[var25].method0017() : "";
         String var29 = NewHUD.HudEntry.method0026() ? "Это пример уведомления" : "Sample notification";
         int var30 = var18 ? 1 : var17.size();
         float[] var31 = new float[var30];
         float var32 = 0.0F;

         for (int var33 = 0; var33 < var30; var33++) {
            NewHUD.HudEntry var34 = var18 ? null : var17.get(var33);
            boolean var35 = var18 ? var26 : var34.method0567() != null && !var34.method0567().method_7960();
            boolean var36 = var34 != null && var34.field1274 != null && !var35;
            boolean var37 = var34 != null && var34.field0339 != null && !var35 && !var36;
            String var38 = var18 ? var28 : (var34 != null && var34.field1504 != null ? var34.field1504 : "");
            String var39 = var18 ? var29 : (var34.field0136 != null && !var34.field0136.isEmpty() ? var34.field0715 + " " : var34.field0715);
            String var40 = var18 ? "" : var34.field0136;
            float var41 = !var35 && !var36 && !var37 ? var5.method0998(var38) : var71;
            float var42 = var41;
            if (var18) {
               this.field1171.method0705(var41, 200L);
               var42 = this.field1171.method0530();
            }

            float var43 = 6.0F;
            float var44 = var6.method0998(var39);
            float var45 = var6.method0998(var40);
            float var46 = var10 + var42 + var43 + var11 + 6.0F + var44 + var45 + var10;
            var31[var33] = var46;
            var32 = Math.max(var32, var46);
         }

         float var73 = var30 * (var8 + var9);
         if (var73 > 0.0F) {
            var73 -= var9;
         }

         var3.method0665(var7 / 2.0F - var32 / 2.0F);
         HudWidgetManager.method1605().method0215("NewNotifications", var32, Math.max(var8, var73));
         var3.method1638(var15 ? -(var73 - var8) : 0.0F);
         float var74 = var3.method1946() + var32 / 2.0F;

         for (int var75 = 0; var75 < var30; var75++) {
            float var76;
            if (var15) {
               var76 = var16 - var75 * (var8 + var9);
            } else {
               var76 = var16 + var75 * (var8 + var9);
            }

            NewHUD.HudEntry var77 = var18 ? null : var17.get(var75);
            float var78 = var18 ? 1.0F : var77.field1561.method0002();
            if (var18 || !(var78 < 0.01F) || !var77.field1735) {
               boolean var79 = var18 || var77 != null && var77.field0219;
               boolean var80 = var18 ? var26 : var77.method0567() != null && !var77.method0567().method_7960();
               boolean var81 = var77 != null && var77.field1274 != null && !var80;
               boolean var82 = var77 != null && var77.field0339 != null && !var80 && !var81;
               String var83 = var18 ? var28 : (var77 != null && var77.field1504 != null ? var77.field1504 : "");
               String var84 = var18 ? var29 : (var77.field0136 != null && !var77.field0136.isEmpty() ? var77.field0715 + " " : var77.field0715);
               String var85 = var18 ? "" : var77.field0136;
               float var86 = !var80 && !var81 && !var82 ? var5.method0998(var83) : var71;
               if (var18) {
                  var86 = this.field1171.method0530();
               }

               float var47 = var6.method0998(var84);
               float var48 = var31[var75];
               float var49 = var74 - var48 / 2.0F;
               float var50 = var76;
               float var51 = Math.max(0.3F, var78);
               float var52 = Math.max(0.3F, var78 * var78);
               float var53 = var49 + var48 / 2.0F;
               float var54 = var50 + var8 / 2.0F;
               var4.method_22903();
               var4.method_46416(var53, var54, 0.0F);
               var4.method_22905(var51, var52, 1.0F);
               var4.method_46416(-var53, -var54, 0.0F);
               this.method1468(var4, var49, var50, var48, var8, var78, this.field1114.method0492());
               GuiRenderHelper.method1404(var1.method1806(), var53 - var48 * var51 / 2.0F, var54 - var8 * var52 / 2.0F, var48 * var51, var8 * var52);
               float var55 = var2 * var78;
               float var56 = var6.method0998(var85);
               float var57 = var86 + 6.0F + var11 + 6.0F + var47 + var56;
               float var58 = var74 - var57 / 2.0F;
               float var59 = var50 + (var8 - var13 - var6.method0530()) / 2.0F;
               float var60 = var59 + (var6.method0530() - var5.method0530()) / 2.0F - 0.4F;
               if (var79) {
                  this.method0964(this.field1153, var55);
               } else {
                  this.method0964(this.field1153, var55 * 0.48F);
               }

               if (var80 && var55 > 0.85F) {
                  float var91 = var59 + (var6.method0530() - var86) / 2.0F - 0.5F;
                  float var94 = var86 / 16.0F;
                  var4.method_22903();
                  var4.method_46416(var58, var91, 0.0F);
                  var4.method_22905(var94, var94, 1.0F);
                  var1.method1806().method_51427(var18 ? var27 : var77.method0567(), 0, 0);
                  var4.method_22909();
               } else if (var81) {
                  float var62 = var59 + (var6.method0530() - var71) / 2.0F - 0.5F;
                  int var63 = Math.max(0, Math.min(255, (int)(var55 * 255.0F)));
                  Color var64 = new Color(255, 255, 255, var63);
                  GuiRenderHelper.method1466(var4, var58, var62, var71, var71, 0.0F, var77.field1274, var64);
               } else if (var82) {
                  float var90 = var59 + (var6.method0530() - var71) / 2.0F - 0.5F;
                  float var93 = 2.5F;

                  try {
                     GuiRenderHelper.method1459(
                        var4, var58, var90, var71, var71, var93, 0.125F, 0.125F, 0.125F, 0.125F, var77.field0339, this.method0964(field1641, var55)
                     );
                  } catch (Exception var70) {
                     GuiRenderHelper.method1463(var4, var58, var90, var71, var71, var93, this.method0964(field1210, var55));
                  }
               } else if (!var80) {
                  GuiRenderHelper.method1491(var4, var5, var83, var58, var60 - 0.2F, this.method0964(this.field1153, var55));
               }

               var58 += var86 + 6.0F;
               float var92 = var59 + (var6.method0530() - var12) / 2.0F;
               GuiRenderHelper.method0326(var4, Math.round(var58), var92, var11, var12, 1.0F, this.method0964(field1026, var55));
               var58 += var11 + 6.0F;
               Color var95 = var79 ? this.method0964(field1641, var55) : this.method0964(field0269, var55);
               GuiRenderHelper.method1491(var4, var6, var84, var58, var59, var95);
               var58 += var47;
               Color var96 = var79 ? this.method0964(this.field1153, var55) : this.method0964(field0236, var55);
               GuiRenderHelper.method1491(var4, var6, var85, var58, var59, var96);
               float var65 = var50 + var8 - var13 - 4.0F;
               float var66 = var18 ? 1.0F - (float)(System.currentTimeMillis() % var72) / (float)var72 : 1.0F - var77.method2047();
               float var67 = var10;
               Color var68 = var79 ? this.method0964(field0436, var55) : this.method0964(field0298, var55);
               Color var69 = var79 ? this.method0964(this.field1153, var55) : this.method0964(field0533, var55);
               GuiRenderHelper.method1463(var4, var49 + var67, var65, var48 - var67 * 2.0F, var13, 0.0F, var68);
               if (var66 > 0.0F) {
                  GuiRenderHelper.method1463(var4, var49 + var67, var65, (var48 - var67 * 2.0F) * var66, var13, 0.0F, var69);
               }

               GuiRenderHelper.method1400(var1.method1806());
               var4.method_22909();
            }
         }
      }
   }

   private void method2197(HudRenderEvent var1) {
      float var2 = this.field1701.method0002();
      HudWidgetState var3 = HudWidgetManager.method1605().method1002("NewStaffList");
      if (var3 != null) {
         class_4587 var4 = var1.method1806().method_51448();
         FontSize var5 = Fonts.field1558.method0654(6.0F);
         FontSize var6 = Fonts.field0075.method0654(6.5F);
         FontSize var7 = Fonts.field0075.method0654(6.0F);
         float var8 = var3.method1946();
         float var9 = var3.method0413();
         float var10 = 23.0F;
         float var11 = 8.0F;
         float var12 = 18.0F;
         float var13 = 8.0F;
         float var14 = 2.5F;
         float var15 = 7.0F;
         List var16 = new ArrayList<>();

         for (String var18 : this.field1667) {
            if (this.field1685.containsKey(var18)) {
               var16.add(var18);
            }
         }

         long var59 = System.currentTimeMillis();
         float var19 = 0.0F;
         float var20 = 0.0F;

         for (String var22 : var16) {
            Animation var23 = this.field0563.get(var22);
            if (var23 != null && !(var23.method0002() <= 0.0F)) {
               NewHUD.NotificationEntry var24 = this.field1685.get(var22);
               if (var24 != null) {
                  String var25 = method1345(var24.field0158);
                  String var26 = method0777((var59 - this.field1684.getOrDefault(var22, var59)) / 1000L);
                  float var27 = var6.method0998(var25 + var24.field0715);
                  float var28 = var7.method0998(var26);
                  float var29 = var13 + 6.0F + 1.0F + 6.0F + var27 + 8.0F + var28;
                  var19 = Math.max(var19, var29);
                  var20 += var12 * var23.method0002();
               }
            }
         }

         String var60 = "Staff List";
         float var61 = var6.method0998(var60);
         float var62 = var5.method0998("D");
         float var63 = var11 + var62 + 6.0F + 1.0F + 6.0F + var61 + var11;
         float var64 = Math.max(95.0F, Math.max(var63, var11 + var19 + var11));
         float var65 = var10;
         if (!var16.isEmpty()) {
            var65 += var20 + 2.0F;
         }

         this.field1700.method0705(var64, 200L);
         float var66 = this.field1700.method0530();
         HudWidgetManager.method1605().method0215("NewStaffList", var64, var65);
         var8 = var3.method1946() + (var64 - var66) / 2.0F;
         this.method0321(var4, var2, var8, var9, var66, var65);
         this.method1468(var4, var8, var9, var66, var65, var2, this.field1235.method0492());
         Color var67 = this.method0964(this.field1153, var2);
         Color var68 = this.method0964(field1564, var2);
         Color var30 = this.method0964(field1641, var2);
         Color var31 = this.method0964(field1726, var2);
         Color var32 = this.method0964(field1500, var2);
         Color var33 = this.method0964(field1026, var2);
         Color var34 = this.method0964(field0207, var2);
         GuiRenderHelper.method1404(var1.method1806(), var8, var9, var66, var65);
         float var35 = var8 + var11;
         float var36 = var9 + (var10 - var5.method0530()) / 2.0F - 0.5F;
         GuiRenderHelper.method1491(var4, var5, "D", var35, var36, var67);
         var35 += var5.method0998("D") + 6.0F;
         float var37 = var9 + (var10 - var15) / 2.0F;
         GuiRenderHelper.method0326(var4, Math.round(var35), var37, 1.0F, var15, 1.0F, var33);
         var35 += 7.0F;
         float var38 = var9 + (var10 - var6.method0530()) / 2.0F;
         GuiRenderHelper.method1491(var4, var6, var60, var35, var38, var30);
         if (!var16.isEmpty()) {
            GuiRenderHelper.method1463(var4, var8, var9 + var10 - 0.5F, var66, 0.5F, 0.0F, var34);
         }

         float var39 = var9 + var10 + 1.0F;

         for (int var40 = 0; var40 < var16.size(); var40++) {
            String var41 = var16.get(var40);
            Animation var42 = this.field0563.get(var41);
            if (var42 != null) {
               float var43 = var42.method0002();
               if (!(var43 <= 0.0F)) {
                  NewHUD.NotificationEntry var44 = this.field1685.get(var41);
                  if (var44 != null) {
                     float var45 = var2 * var43;
                     float var46 = var12 * var43;
                     if (var40 > 0) {
                        GuiRenderHelper.method1463(var4, var8 + var11, var39, var66 - var11 * 2.0F, 0.5F, 0.0F, var34);
                     }

                     float var47 = var39 + (var46 - var6.method0530()) / 2.0F;
                     float var48 = var8 + var11;
                     float var49 = var39 + (var46 - var13) / 2.0F;
                     class_2960 var50 = this.method0505(var44.field0715);
                     if (var50 != null) {
                        try {
                           GuiRenderHelper.method1459(
                              var4, var48, var49, var13, var13, var14, 0.125F, 0.125F, 0.125F, 0.125F, var50, this.method0964(field1641, var45)
                           );
                        } catch (Exception var57) {
                           GuiRenderHelper.method1463(var4, var48, var49, var13, var13, var14, field1210);
                        }
                     } else {
                        GuiRenderHelper.method1463(var4, var48, var49, var13, var13, var14, this.method0964(field1210, var45));
                     }

                     var48 += var13 + 6.0F;
                     float var51 = var39 + (var46 - var15) / 2.0F;
                     GuiRenderHelper.method0326(var4, var48, var51, 1.0F, var15, 1.0F, this.method0964(field1026, var45));
                     var48 += 7.0F;
                     String var52 = method1345(var44.field0158);
                     if (!var52.isEmpty()) {
                        GuiRenderHelper.method1491(var4, var6, var52, var48, var47, this.method0964(field1726, var45));
                        var48 += var6.method0998(var52);
                     }

                     GuiRenderHelper.method1491(var4, var6, var44.field0715, var48, var47, this.method0964(field1641, var45));
                     String var53 = method0777((var59 - this.field1684.getOrDefault(var41, var59)) / 1000L);
                     float var54 = var7.method0998(var53);
                     float var55 = var8 + var66 - var11 - var54;
                     Color var56 = this.method0897(var44.field1472, var45);
                     GuiRenderHelper.method1491(var4, var7, var53, var55, var47 + (var6.method0530() - var7.method0530()) / 2.0F, var56);
                     var39 += var46;
                  }
               }
            }
         }

         GuiRenderHelper.method1400(var1.method1806());
         var4.method_22909();
      }
   }

   private List<NewHUD.NotificationEntry> method0404() {
      List var1 = new ArrayList<>();
      Set var2 = new HashSet<>();
      if (field0796.field_1687 == null) {
         return var1;
      }

      List var3 = new ArrayList<>(field0796.field_1687.method_8428().method_1159());
      var3.sort(Comparator.comparing(class_268::method_1197));

      for (class_268 var5 : var3) {
         Collection var6 = var5.method_1204();
         if (!var6.isEmpty()) {
            class_2561 var7 = var5.method_1144();
            String var8 = var7 != null ? var7.getString() : "";
            String var9 = NameDecorator.method1010(var8);
            String var10 = var9.replaceAll("§.", "").trim();
            if (field0562.matcher(var10).matches()) {
               for (String var12 : var6) {
                  if (field0522.matcher(var12).matches() && var2.add(var12)) {
                     var1.add(new NewHUD.NotificationEntry(var12, var7, this.method0385(var12)));
                     if (var1.size() >= 10) {
                        return var1;
                     }
                  }
               }
            }
         }
      }

      StaffManager var13 = DaamkyClient.method2004().method0420();
      if (var13 != null && field0796.method_1562() != null) {
         for (String var15 : var13.method2069()) {
            if (var15 != null && !var15.isEmpty()) {
               String var16 = null;

               for (class_640 var18 : field0796.method_1562().method_2880()) {
                  String var19 = var18.method_2966().getName();
                  if (var19 != null && var19.equalsIgnoreCase(var15)) {
                     var16 = var19;
                     break;
                  }
               }

               if (var16 != null && var2.add(var16)) {
                  var1.add(new NewHUD.NotificationEntry(var16, class_2561.method_43470(""), this.method0385(var16)));
                  if (var1.size() >= 10) {
                     return var1;
                  }
               }
            }
         }
      }

      return var1;
   }

   public static List<String> method1397(class_310 var0) {
      List var1 = new ArrayList<>();
      if (var0 != null && var0.field_1687 != null) {
         for (class_268 var3 : var0.field_1687.method_8428().method_1159()) {
            Collection var4 = var3.method_1204();
            if (!var4.isEmpty()) {
               class_2561 var5 = var3.method_1144();
               String var6 = var5 != null ? var5.getString() : "";
               String var7 = NameDecorator.method1010(var6).replaceAll("§.", "").trim();
               if (field0562.matcher(var7).matches()) {
                  for (String var9 : var4) {
                     if (field0522.matcher(var9).matches()) {
                        var1.add(var9);
                        if (var1.size() >= 10) {
                           return var1;
                        }
                     }
                  }
               }
            }
         }

         return var1;
      } else {
         return var1;
      }
   }

   private NewHUD.ArmorState method0385(String var1) {
      if (field0796.field_1687 != null) {
         for (class_1657 var3 : field0796.field_1687.method_18456()) {
            if (var3.method_5477().getString().equals(var1)) {
               return NewHUD.ArmorState.field0094;
            }
         }
      }

      if (field0796.method_1562() != null) {
         for (class_640 var5 : field0796.method_1562().method_2880()) {
            if (var5.method_2966().getName().equals(var1)) {
               if (var5.method_2958() == class_1934.field_9219) {
                  return NewHUD.ArmorState.field1472;
               }

               return NewHUD.ArmorState.field0665;
            }
         }
      }

      return NewHUD.ArmorState.field1006;
   }

   private static String method0777(long var0) {
      long var2 = var0 / 3600L;
      long var4 = var0 / 60L % 60L;
      long var6 = var0 % 60L;
      return var2 > 0L ? String.format("%d:%02d:%02d", var2, var4, var6) : String.format("%d:%02d", var4, var6);
   }

   private static String method1345(class_2561 var0) {
      if (var0 == null) {
         return "";
      }

      String var1 = var0.getString();
      if (var1 == null) {
         return "";
      }

      String var2 = NameDecorator.method1010(var1);
      String var3 = var2.replaceAll("§.", "").trim();
      if (!var3.isEmpty() && !var3.endsWith(" ")) {
         var3 = var3 + " ";
      }

      return var3;
   }

   private Color method0897(NewHUD.ArmorState var1, float var2) {
      Color var3 = switch (var1) {
         case field0094 -> field1599;
         case field1472 -> field1598;
         case field1006 -> field1600;
         default -> field1702;
      };
      int var4 = Math.max(0, Math.min(255, Math.round(255.0F * var2)));
      return new Color(var3.getRed(), var3.getGreen(), var3.getBlue(), var4);
   }

   private class_2960 method0505(String var1) {
      class_2960 var2 = null;
      if (field0796.field_1687 != null) {
         for (class_1657 var4 : field0796.field_1687.method_18456()) {
            if (var4 instanceof class_742 var5 && var1.equals(var4.method_5477().getString())) {
               var2 = var5.method_52814().comp_1626();
               break;
            }
         }
      }

      if (var2 == null && field0796.method_1562() != null) {
         class_640 var6 = field0796.method_1562().method_2874(var1);
         if (var6 != null) {
            var2 = var6.method_52810().comp_1626();
         }
      }

      if (var2 != null) {
         this.field1686.put(var1, var2);
      } else {
         var2 = this.field1686.get(var1);
      }

      return var2;
   }

   public static class HudEntry {
      public final String field0715;
      public final String field0136;
      public final String field1504;
      public final class_1799 field1040;
      public final List<class_1799> field0793;
      public final class_2960 field1274;
      public final class_2960 field0339;
      public final boolean field0219;
      public final long field0460;
      public final long field1616;
      public final Animation field1561;
      private boolean field1735;
      private static final long field1138 = 1000L;

      public class_1799 method0567() {
         if (this.field0793 != null && !this.field0793.isEmpty()) {
            int var1 = (int)(System.currentTimeMillis() / 1000L % this.field0793.size());
            return this.field0793.get(var1);
         } else {
            return this.field1040;
         }
      }

      static boolean method0026() {
         try {
            return ClickGuiDashboard.field0984.method0492() == ClickGuiDashboard.Language.field0631;
         } catch (Exception var1) {
            return false;
         }
      }

      public HudEntry(String var1, ModuleCategory var2, boolean var3) {
         this(
            method0026() ? "Модуль" : "Module",
            method0026() ? (var3 ? var1 + " был включён!" : var1 + " был выключён!") : (var3 ? var1 + " was enabled!" : var1 + " was disabled!"),
            var2.method0017(),
            var3
         );
      }

      public HudEntry(String var1, String var2, String var3, boolean var4) {
         this(var1, var2, var3, null, null, var4);
      }

      public HudEntry(String var1, String var2, String var3, class_1799 var4, boolean var5) {
         this(var1, var2, var3, var4, null, var5);
      }

      public HudEntry(String var1, String var2, String var3, class_1799 var4, class_2960 var5, boolean var6) {
         this(var1, var2, var3, var4, var5, null, var6);
      }

      public HudEntry(String var1, String var2, String var3, class_1799 var4, class_2960 var5, class_2960 var6, boolean var7) {
         this(var1, var2, var3, var4, null, var5, var6, var7);
      }

      public HudEntry(String var1, String var2, String var3, class_1799 var4, List<class_1799> var5, class_2960 var6, class_2960 var7, boolean var8) {
         this.field0715 = var1;
         this.field0136 = var2;
         this.field1504 = var3;
         this.field1040 = var4;
         this.field0793 = var5;
         this.field1274 = var6;
         this.field0339 = var7;
         this.field0219 = var8;
         this.field0460 = System.currentTimeMillis();
         this.field1616 = 3000L;
         this.field1561 = new Animation(250L, 1.0, true, EasingCurve.field1011);
         this.field1735 = false;
      }

      public float method2047() {
         return Math.min(1.0F, (float)(System.currentTimeMillis() - this.field0460) / (float)this.field1616);
      }

      public void method1812() {
         if (!this.field1735) {
            this.field1735 = true;
            this.field1561.method1570(false);
         }
      }

      public boolean method1635() {
         return !this.field1735 && System.currentTimeMillis() - this.field0460 > this.field1616 - 200L;
      }

      public boolean method1974() {
         return this.field1735 && this.field1561.method0346(false);
      }
   }

   public enum NotificationDirection implements DisplayNamed {
      field0663("Top Down"),
      field0092("Bottom Up");

      private final String field1504;

      NotificationDirection(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }

   public enum DurabilityMode implements DisplayNamed {
      field0664("Number"),
      field0093("Percent");

      private final String field1504;

      DurabilityMode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }

   private enum ArmorState {
      field0665,
      field0094,
      field1472,
      field1006;
   }

   private static class NotificationEntry {
      final String field0715;
      final class_2561 field0158;
      final NewHUD.ArmorState field1472;

      NotificationEntry(String var1, class_2561 var2, NewHUD.ArmorState var3) {
         this.field0715 = var1;
         this.field0158 = var2;
         this.field1472 = var3;
      }
   }
}
