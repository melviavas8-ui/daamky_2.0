package aethereal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.StreamSupport;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_124;
import net.minecraft.class_1268;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1542;
import net.minecraft.class_1684;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1796;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2637;
import net.minecraft.class_2653;
import net.minecraft.class_266;
import net.minecraft.class_2680;
import net.minecraft.class_269;
import net.minecraft.class_2775;
import net.minecraft.class_2824;
import net.minecraft.class_2868;
import net.minecraft.class_2886;
import net.minecraft.class_332;
import net.minecraft.class_3675;
import net.minecraft.class_3944;
import net.minecraft.class_3988;
import net.minecraft.class_408;
import net.minecraft.class_4587;
import net.minecraft.class_5134;
import net.minecraft.class_5250;
import net.minecraft.class_6880;
import net.minecraft.class_7439;
import net.minecraft.class_7924;
import net.minecraft.class_8646;
import net.minecraft.class_9279;
import net.minecraft.class_9285;
import net.minecraft.class_9288;
import net.minecraft.class_9334;
import org.apache.commons.lang3.StringUtils;

public class ServerAssist extends Module {
   private static final String field0136 = "ServerAssist";
   private final EnumSetting<ServerAssist.ServerMode> field1448 = new EnumSetting<>("serverassist.mode", ServerAssist.ServerMode.field1483)
      .method1007("Server Type")
      .method2130("Тип сервера");
   private final BooleanSetting field0970 = new BooleanSetting(
         "serverassist.autoloot", true, () -> this.field1448.method0492() == ServerAssist.ServerMode.field0108
      )
      .method1007("Auto Loot")
      .method2130("Авто-лут с ботов на ивенте");
   private final BooleanSetting field0184 = new BooleanSetting(
         "serverassist.autoshulker", true, () -> this.field1448.method0492() == ServerAssist.ServerMode.field0108
      )
      .method1007("Auto Shulker")
      .method2130("Авто-складывание лута в шалкер");
   private final BooleanSetting field0464 = new BooleanSetting(
         "serverassist.autorepair", true, () -> this.field1448.method0492() == ServerAssist.ServerMode.field0108
      )
      .method1007("Auto Repair")
      .method2130("Авто-ремонт брони пузырём опыта");
   private final BooleanSetting field1619 = new BooleanSetting(
         "serverassist.orbswap", false, () -> this.field1448.method0492() == ServerAssist.ServerMode.field0682
      )
      .method1007("Swap Orb")
      .method2130("Свапать шар на тот что лучше по урону");
   private final MultiSelectSetting field1562 = new MultiSelectSetting(
         "serverassist.orbswap.conditions",
         Arrays.asList("Lower Health", "Enemy Eating", "Player Retreating", "Popped Totem"),
         false,
         () -> this.field1448.method0492() == ServerAssist.ServerMode.field0682 && this.field1619.method0492()
      )
      .method1007("Swap Conditions")
      .method2130("Какие условия проверять перед свапом шара (любое из выбранных)");
   private final BooleanSetting field1709 = new BooleanSetting(
         "serverassist.funtimeorbswap", false, () -> this.field1448.method0492() == ServerAssist.ServerMode.field1483
      )
      .method1007("Swap Item")
      .method2130("Свапать сферу или талик в нужный момент на тот что лучше по урону");
   private final MultiSelectSetting field1152 = new MultiSelectSetting(
         "serverassist.funtimeorbswap.conditions",
         Arrays.asList("Enemy Eating", "Player Retreating", "Popped Totem"),
         false,
         () -> this.field1448.method0492() == ServerAssist.ServerMode.field1483 && this.field1709.method0492()
      )
      .method1007("Swap Conditions")
      .method2130("Какие условия проверять перед свапом предмета (любое из выбранных)");
   private final BooleanSetting field1093 = new BooleanSetting(
         "serverassist.consumables", true, () -> this.field1448.method0492() == ServerAssist.ServerMode.field1483
      )
      .method1007("Trap Tracker")
      .method2130("Засекать таймер взрывных трапок");
   private final BooleanSetting field1201 = new BooleanSetting(
         "serverassist.autopoint", true, () -> this.field1448.method0492() == ServerAssist.ServerMode.field1483
      )
      .method1007("Auto Point")
      .method2130("Ставить метки на ивенты");
   private final BooleanSetting field0875 = new BooleanSetting(
         "serverassist.eventcheck", true, () -> this.field1448.method0492() == ServerAssist.ServerMode.field1483
      )
      .method1007("Check Events")
      .method2130("Проверять ивенты на анархии");
   private final BooleanSetting field0830 = new BooleanSetting("serverassist.displayonscreen", true)
      .method1007("Display On Screen")
      .method2130("Отображать предметы и их задержку на экране");
   private final KeyBindListSetting field0926 = new KeyBindListSetting("serverassist.binds")
      .method1007("Server Binds")
      .method0210("Per-mode consumable hotkeys")
      .method2130("Бинды расходников по выбранному серверу");
   private final List<ServerAssist.TrackedPlayer> field1347 = new ArrayList<>();
   private final Map<String, ServerAssist.PendingAction> field1309 = new HashMap<>();
   private final Map<String, Boolean> field1385 = new HashMap<>();
   private final Map<String, Long> field0401 = new HashMap<>();
   private final List<String> field0366 = new ArrayList<>();
   private final Stopwatch field0433 = new Stopwatch();
   private ServerAssist.ActionState field0266 = ServerAssist.ActionState.field0681;
   private long field0228 = 0L;
   private long field0291 = 0L;
   private int field0524 = -1;
   private int field0502 = -1;
   private int field0548 = -1;
   private String field1681 = null;
   private boolean field1665 = false;
   private boolean field1699;
   private boolean field1597;
   private boolean field1586;
   private boolean field1609;
   private final Map<class_2338, class_2680> field1760 = new HashMap<>();
   private final List<ServerAssist.EventInfo> field1746 = new ArrayList<>();
   private final List<ServerAssist.ItemPosition> field1772 = new ArrayList<>();
   private final Map<Integer, class_1792> field1180 = new HashMap<>();
   private final Map<String, Float> field1170 = new HashMap<>();
   private final Stopwatch field1189 = new Stopwatch();
   private final Stopwatch field1123 = new Stopwatch();
   private final Stopwatch field1115 = new Stopwatch();
   private final Stopwatch field1133 = new Stopwatch();
   private final Stopwatch field1231 = new Stopwatch();
   private final Stopwatch field1223 = new Stopwatch();
   private final Stopwatch field1237 = new Stopwatch();
   private boolean field0903 = false;
   private String field0895 = null;
   private boolean field0907 = false;
   private int field0856 = 0;
   private UUID field0852 = null;
   private UUID field0868;
   private static final Set<String> field0944 = new HashSet<>(
      Arrays.asList("Маяк убийца", "Вулкан", "Сундук смерти", "Адская резня", "Мистический сундук", "Гейзер", "Метеоритный дождь")
   );
   private int field0934 = -1;
   private boolean field0953 = false;
   private final Stopwatch field1357 = new Stopwatch();
   private String field1352 = null;
   private final Set<String> field1365 = new HashSet<>();
   private final List<ServerAssist.TrackedItem> field1323 = new ArrayList<>();
   private String field1317 = null;
   private boolean field1328 = false;
   private int field1396 = 0;
   private long field1391 = 0L;

   public ServerAssist() {
      super("ServerAssist", ModuleCategory.field0776, "Server keybind helper");
      this.method1013("Помощник для комфортный игры на серверах");
      this.method0213("A");
      this.method2015();
      this.method2043();
      this.method2029();
   }

   public static ServerAssist method1717() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(ServerAssist.class) : null;
   }

   public boolean method1692() {
      return this.method2195() && this.field1448.method0492() == ServerAssist.ServerMode.field0682;
   }

   private void method2029() {
      for (ServerAssist.TrackedPlayer var2 : this.field1347) {
         this.field0926.method0884(var2.field1259, var2.field1519, () -> this.field1448.method0492() == var2.field1014);
      }

      if (!this.method1914().contains(this.field0926)) {
         this.method1914().add(this.field0926);
      }
   }

   private void method2015() {
      this.method1052("Анти полёт", "антиполет", class_1802.field_8450, ServerAssist.ServerMode.field0682, 0);
      this.method1052("Свиток опыта", "свитокопыта", class_1802.field_8498, ServerAssist.ServerMode.field0682, 0);
      this.method1052("Взрывная трапка", "взрывнаятрапка", class_1802.field_8662, ServerAssist.ServerMode.field0108, 5);
      this.method1052("Обычная трапка", "трапка", class_1802.field_8882, ServerAssist.ServerMode.field0108, 0);
      this.method1052("Стан", "стан", class_1802.field_8137, ServerAssist.ServerMode.field0108, 30);
      this.method1052("Взрывная штучка", "взрывнаяштучка", class_1802.field_8814, ServerAssist.ServerMode.field0108, 0);
      this.method1052("Снежок HW", "снежок", class_1802.field_8543, ServerAssist.ServerMode.field0108, 0);
      this.method1052("Светильник Джека", "светильникджека", class_1802.field_8693, ServerAssist.ServerMode.field0108, 0);
      this.method1052("Пузырь опыта", "пузырьопыта", class_1802.field_8287, ServerAssist.ServerMode.field0108, 0);
      this.method1052("Рюкзак 1 уровня", "рюкзак(iуровень)", class_1802.field_8520, ServerAssist.ServerMode.field0108, 0);
      this.method1052("Рюкзак 2 уровня", "рюкзак(iiуровень)", class_1802.field_8350, ServerAssist.ServerMode.field0108, 0);
      this.method1052("Рюкзак 3 уровня", "рюкзак(iiiуровень)", class_1802.field_8676, ServerAssist.ServerMode.field0108, 0);
      this.method1052("Рюкзак 4 уровня", "рюкзак(ivуровень)", class_1802.field_8520, ServerAssist.ServerMode.field0108, 0);
      this.method1052("Божья аура", "божьяаура", class_1802.field_8614, ServerAssist.ServerMode.field1483, 0);
      this.method1052("Арбалет", "арбалет", class_1802.field_8399, ServerAssist.ServerMode.field1483, 0);
      this.method1052("Трапка", "трапка", class_1802.field_22021, ServerAssist.ServerMode.field1483, 0);
      this.method1052("Пласт", "пласт", class_1802.field_8551, ServerAssist.ServerMode.field1483, 0);
      this.method1052("Явная пыль", "явная", class_1802.field_8479, ServerAssist.ServerMode.field1483, 10);
      this.method1052("Огненный смерч", "огненныйсмерч", class_1802.field_8814, ServerAssist.ServerMode.field1483, 10);
      this.method1052("Дезориентация", "дезориентация", class_1802.field_8449, ServerAssist.ServerMode.field1483, 10);
      this.method1052("Снежок заморозка", "снежокзаморозка", class_1802.field_8543, ServerAssist.ServerMode.field1483, 0);
      this.method1052("Зелье отрыжки", "отрыжки", class_1802.field_8436, ServerAssist.ServerMode.field1483, 0);
      this.method1052("Зелье серной кислоты", "серная", class_1802.field_8436, ServerAssist.ServerMode.field1483, 0);
      this.method1052("Зелье вспышки", "вспышка", class_1802.field_8436, ServerAssist.ServerMode.field1483, 0);
      this.method1052("Зелье мочи Флеша", "мочафлеша", class_1802.field_8436, ServerAssist.ServerMode.field1483, 0);
      this.method1052("Зелье победителя", "победителя", class_1802.field_8436, ServerAssist.ServerMode.field1483, 0);
      this.method1052("Зелье агента", "агента", class_1802.field_8436, ServerAssist.ServerMode.field1483, 0);
      this.method1052("Зелье медика", "медика", class_1802.field_8436, ServerAssist.ServerMode.field1483, 0);
      this.method1052("Зелье киллера", "киллера", class_1802.field_8436, ServerAssist.ServerMode.field1483, 0);
   }

   private void method2043() {
      for (ServerAssist.TrackedPlayer var2 : this.field1347) {
         this.field1309.put(var2.field0715, new ServerAssist.PendingAction(var2.field0136, var2.field1519, var2.field0715));
         this.field1385.put(var2.field0715, false);
      }
   }

   private void method1052(String var1, String var2, class_1792 var3, ServerAssist.ServerMode var4, int var5) {
      KeyBindSetting var6 = new KeyBindSetting("serverassist.bind." + var1, new KeyBind(-1, false, false), () -> false)
         .method1007(var1)
         .method2130("Клавиша: " + var1);
      ServerAssist.TrackedPlayer var7 = new ServerAssist.TrackedPlayer(var1, var2, var3, var4, var5, var6);
      this.field1347.add(var7);
      if (!this.method1914().contains(var6)) {
         this.method1914().add(var6);
      }
   }

   @Override
   public void method0025() {
      super.method0025();
      HudWidgetManager.method1605().method1019("ServerAssist", 10.0F, 200.0F, 22.0F, 25.0F);
      this.method0471();
   }

   @Override
   public void method2078() {
      if (this.field1665) {
         this.method2251();
      }

      this.method0398();
      this.method0471();
      super.method2078();
   }

   private void method0471() {
      this.field1180.clear();
      this.field0366.clear();
      this.field0433.method1812();
      this.field1385.replaceAll((var0, var1) -> false);
      this.field0266 = ServerAssist.ActionState.field0681;
      this.field0524 = -1;
      this.field0502 = -1;
      this.field0548 = -1;
      this.field1681 = null;
      this.field0291 = 0L;
      this.field1665 = false;
      this.field0903 = false;
      this.field0895 = null;
      this.field0907 = false;
      this.field0856 = 0;
      this.field0852 = null;
      this.field1231.method1812();
      this.field1223.method0436(0L);
      this.field1237.method0436(0L);
      this.field0934 = -1;
      this.field0953 = false;
      this.field1352 = null;
      this.field1365.clear();
      this.field1317 = null;
      this.field1328 = false;
      this.field1396 = 0;
   }

   @EventHandler
   public void onPacket(PacketEvent.Inbound var1) {
      if (field0796.field_1724 != null && field0796.field_1687 != null) {
         if (var1.method1970() instanceof class_2775 var2) {
            this.method1374(var2);
         } else if (var1.method1970() instanceof class_2653 var3) {
            this.method1358(var3);
         } else if (var1.method1970() instanceof class_2637 var4
            && this.field1093.method0492()
            && this.field1448.method0492() == ServerAssist.ServerMode.field1483) {
            this.method1357(var4);
         } else if (var1.method1970() instanceof class_7439 var5) {
            this.method1537(var5);
         } else if (var1.method1970() instanceof class_3944 var6 && var6.method_17594().getString().contains("Рюкзак") && !this.field1180.isEmpty()) {
         }
      }
   }

   private void method1374(class_2775 var1) {
      if (this.field0184.method0492() && this.field1448.method0492() == ServerAssist.ServerMode.field0108) {
         if (var1.method_11912() == field0796.field_1724.method_5628()) {
            if (field0796.field_1687.method_8469(var1.method_11915()) instanceof class_1542 var2) {
               class_1799 var4 = var2.method_6983();
               if (var4.method_57824(class_9334.field_49622) == null) {
                  this.field1180.put(-MathHelper.method0736(1, 999999999), var4.method_7909());
                  this.field1123.method1812();
               }
            }
         }
      }
   }

   private void method1358(class_2653 var1) {
      if (var1.method_11452() == 0) {
         class_1792 var2 = var1.method_11449().method_7909();
         new ArrayList();
         Integer var4 = null;

         for (Entry var6 : this.field1180.entrySet()) {
            if (var6.getKey() < 0 && var6.getValue().equals(var2)) {
               var4 = var6.getKey();
               break;
            }
         }

         if (var4 != null) {
            this.field1180.put(var1.method_11450() + 18, var2);
            this.field1180.remove(var4);
         }
      }
   }

   private void method1357(class_2637 var1) {
      var1.method_30621((var1x, var2) -> this.field1760.put(var1x, var2));
      if (this.field1760.size() > 50 && this.field1760.size() < 600) {
         var1.method_30621((var1x, var2) -> {
            class_243 var3 = var1x.method_46558();
            if (this.method1264(var1x.method_10086(2))) {
               this.method1235(class_1802.field_22021, var3, System.currentTimeMillis() + 15000L);
            } else if (this.method0279(var1x.method_10086(3))) {
               this.method1235(class_1802.field_22021, var3, System.currentTimeMillis() + 30000L);
            }
         });
      }
   }

   private void method1537(class_7439 var1) {
      class_2561 var2 = var1.comp_763();
      String var3 = var2.toString();
      String var4 = var2.getString();
      if (this.field1201.method0492() && this.field1448.method0492() == ServerAssist.ServerMode.field1483) {
         String var5 = StringUtils.substringBetween(var4, "||| [", "] ");
         if (var5 != null) {
            String var6 = StringUtils.substringBetween(var3, "value='/gps ", "'");
            String var7 = StringUtils.substringBetween(var4, "Уровень лута: ", "\n ║");
            String var8 = StringUtils.substringBetween(var4, "Призван игроком: ", "\n ║");
            if (var6 != null) {
               String[] var9 = var6.split(" ");

               try {
                  class_243 var10 = class_2338.method_49637(Integer.parseInt(var9[0]), Integer.parseInt(var9[1]), Integer.parseInt(var9[2])).method_46558();
                  switch (var5) {
                     case "Мистический сундук":
                        this.method1049(var5, var7, var8, var10, "overworld", 300, 0);
                        break;
                     case "Вулкан":
                        this.method1049(var5, var7, var8, var10, "overworld", 300, 120);
                        break;
                     case "Метеоритный дождь":
                     case "Маяк убийца":
                     case "Мистический Алтарь":
                        this.method1049(var5, var7, var8, var10, "overworld", 360, 0);
                        break;
                     case "Загадочный маяк":
                        this.method1049(var5, var7, var8, var10, "overworld", 60, 180);
                  }
               } catch (NumberFormatException var14) {
               }
            } else {
               switch (var5) {
                  case "Сундук смерти":
                     this.method1049(var5, var7, var8, class_2338.method_49637(-155.0, 64.0, 205.0).method_46558(), "lobby", 300, 0);
                     break;
                  case "Адская резня":
                     this.method1049(var5, var7, var8, class_2338.method_49637(48.0, 87.0, 73.0).method_46558(), "lobby", 180, 120);
               }
            }
         }
      }

      if (this.field0934 >= 0) {
         this.method2134(var4);
      }

      if (var4.contains("▶ Повторно активировать Пузырь опыта возможно через")) {
         String var15 = StringUtils.substringBetween(var4, "через ", " секунд");
         if (var15 != null && !var15.isEmpty()) {
            try {
               int var16 = Integer.parseInt(var15) * 20;
               class_1796 var17 = field0796.field_1724.method_7357();
               var17.method_62835(class_1802.field_8287.method_7854(), var16);
            } catch (NumberFormatException var13) {
            }
         }
      }
   }

   private int method0451() {
      if (field0796.field_1687 != null && ServerEnvironment.method0376()) {
         class_269 var1 = field0796.field_1687.method_8428();
         class_266 var2 = var1.method_1189(class_8646.field_45157);
         if (var2 == null) {
            return -1;
         }

         String var3 = var2.method_1114().getString();
         if (!var3.contains("Анархия")) {
            return -1;
         }

         Matcher var4 = Pattern.compile("Анархия\\D*(\\d+)").matcher(var3);
         if (var4.find()) {
            try {
               return Integer.parseInt(var4.group(1));
            } catch (NumberFormatException var6) {
            }
         }

         return 0;
      } else {
         return -1;
      }
   }

   private void method0479() {
      boolean var1 = this.field1448.method0492() == ServerAssist.ServerMode.field1483 && this.field0875.method0492();
      int var2 = var1 ? this.method0451() : -1;
      if (var2 >= 0 && var2 != this.field0934) {
         this.method0398();
         this.method0410();
         this.field1365.clear();
         this.field1352 = null;
         this.field1317 = null;
         this.field0953 = true;
         this.field1357.method1812();
      } else if (var2 < 0 && this.field0934 >= 0) {
         this.field0953 = false;
         this.field1365.clear();
         this.field1352 = null;
         this.field1317 = null;
         this.method0398();
      }

      this.field0934 = var2;
      if (var2 >= 0) {
         if (this.field0953 && this.field1357.method0779(1500L)) {
            if (field0796.field_1724 != null && field0796.field_1724.field_3944 != null) {
               field0796.field_1724.field_3944.method_45730("event delay");
            }

            this.field0953 = false;
         }

         this.method0405();
      }
   }

   private void method2134(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         long var2 = System.currentTimeMillis();

         for (String var7 : var1.split("\n")) {
            String var8 = var7.trim();
            if (!var8.isEmpty()) {
               if (this.field1317 != null && var2 - this.field1391 > 8000L) {
                  this.field1317 = null;
               }

               if (var8.contains("До следующего ивента")) {
                  this.method1846(StringUtils.substringAfter(var8, "До следующего ивента").replaceFirst("^[\\s:»>]+", ""));
                  this.field1317 = null;
               } else if (var8.endsWith(":")) {
                  this.field1317 = method1984(var8);
                  this.field1328 = false;
                  this.field1396 = 0;
                  this.field1391 = var2;
               } else if (this.field1317 != null) {
                  this.field1391 = var2;
                  if (var8.contains("Призван игроком")) {
                     this.field1328 = true;
                  }

                  if (!this.field1328 && (var8.contains("Начнётся") || var8.contains("до активации") || var8.contains("активирован"))) {
                     this.method1045(this.field1317, method0441(var8));
                  }

                  if (var8.contains("Открытие через")) {
                     this.field1396 = method0383(var8);
                  }

                  int var9 = var8.indexOf("Координаты");
                  if (var9 >= 0) {
                     String var10 = StringUtils.substringBetween(var8.substring(var9), "[", "]");
                     if (var10 != null && !this.field1328) {
                        this.method1047(this.field1317, var10, this.field1396);
                     }

                     this.field1317 = null;
                     this.field1328 = false;
                     this.field1396 = 0;
                  }
               }
            }
         }
      }
   }

   private void method1047(String var1, String var2, int var3) {
      String[] var4 = var2.trim().split("\\s+");
      if (var4.length >= 3) {
         int var5;
         int var6;
         int var7;
         try {
            var5 = Integer.parseInt(var4[0]);
            var6 = Integer.parseInt(var4[1]);
            var7 = Integer.parseInt(var4[2]);
         } catch (NumberFormatException var19) {
            return;
         }

         double var8 = var5 + 0.5;
         double var10 = var6;
         double var12 = var7 + 0.5;
         long var14 = System.currentTimeMillis() + (var3 > 0 ? var3 + 360 : 600) * 1000L;

         for (ServerAssist.TrackedItem var17 : this.field1323) {
            if (var17.field0715.equals(var1) && var17.field0002 == var8 && var17.field0956 == var12) {
               var17.field1244 = var14;
               return;
            }
         }

         WaypointManager var20 = WaypointManager.method0552();
         if (var20 != null) {
            String var21 = WaypointManager.method1791();
            boolean var18 = var20.method0941(
               new WaypointManager.Waypoint(var1, var8, var10, var12, WaypointManager.method1947(), var21, "minecraft:overworld")
            );
            if (var18) {
               this.field1323.add(new ServerAssist.TrackedItem(var1, var8, var10, var12, var21, var14));
               this.method1656(var1);
            }
         }
      }
   }

   private void method0405() {
      if (!this.field1323.isEmpty()) {
         long var1 = System.currentTimeMillis();
         boolean var3 = "minecraft:overworld".equals(WaypointManager.method1619());
         String var4 = WaypointManager.method1791();
         Iterator var5 = this.field1323.iterator();

         while (var5.hasNext()) {
            ServerAssist.TrackedItem var6 = var5.next();
            boolean var7 = var1 > var6.field1244;
            boolean var8 = false;
            if (var3 && field0796.field_1724 != null && var6.field0791.equals(var4)) {
               double var9 = field0796.field_1724.method_23317() - var6.field0002;
               double var11 = field0796.field_1724.method_23321() - var6.field0956;
               if (var9 * var9 + var11 * var11 <= 36.0) {
                  var8 = true;
               }
            }

            if (var7 || var8) {
               this.method0927(var6);
               var5.remove();
            }
         }
      }
   }

   private void method0398() {
      if (!this.field1323.isEmpty()) {
         for (ServerAssist.TrackedItem var2 : this.field1323) {
            this.method0927(var2);
         }

         this.field1323.clear();
      }
   }

   private void method0927(ServerAssist.TrackedItem var1) {
      WaypointManager var2 = WaypointManager.method0552();
      if (var2 != null) {
         boolean var3 = var2.method2192()
            .removeIf(
               var1x -> var1x.method0557().equals(var1.field0715)
                  && var1x.method1961().equals(var1.field0791)
                  && "minecraft:overworld".equals(var1x.method0423())
                  && var1x.method0001() == var1.field0002
                  && var1x.method1761() == var1.field0956
            );
         if (var3) {
            var2.method0498();
         }
      }
   }

   private void method0410() {
      WaypointManager var1 = WaypointManager.method0552();
      if (var1 != null) {
         String var2 = WaypointManager.method1791();
         boolean var3 = var1.method2192()
            .removeIf(var1x -> var1x.method1961().equals(var2) && "minecraft:overworld".equals(var1x.method0423()) && field0944.contains(var1x.method0557()));
         if (var3) {
            var1.method0498();
         }
      }
   }

   private void method1846(String var1) {
      String var2 = var1 == null ? "" : var1.trim();
      if (!var2.isEmpty() && !var2.equals(this.field1352)) {
         this.field1352 = var2;
         NewHUD.method1050("Следующий ивент", "через " + var2, ModuleCategory.field0776.method0017(), true);
      }
   }

   private void method1656(String var1) {
      NewHUD.method1050("Установлена метка", "ивент \"" + var1 + "\"", ModuleCategory.field0776.method0017(), true);
   }

   private void method1045(String var1, String var2) {
      if (var1 != null && this.field1365.add(var1)) {
         String var3 = var2 == null ? "" : var2.trim();
         NewHUD.method1050(var1, var3.isEmpty() ? "скоро начнётся" : "начнётся через " + var3, ModuleCategory.field0776.method0017(), true);
      }
   }

   private static String method1984(String var0) {
      for (String var2 : field0944) {
         if (var0.endsWith(var2 + ":")) {
            return var2;
         }
      }

      return null;
   }

   private static String method0441(String var0) {
      String var1 = var0.contains("до активации") ? "до активации" : (var0.contains("через") ? "через" : null);
      return var1 == null ? "" : StringUtils.substringAfter(var0, var1).replaceFirst("^[\\s:»>]+", "").trim();
   }

   private static int method0383(String var0) {
      if (var0 == null) {
         return 0;
      }

      int var1 = 0;
      Matcher var2 = Pattern.compile("(\\d+)\\s*(ч|мин|сек|min|sec|h)").matcher(var0);

      while (var2.find()) {
         int var3;
         try {
            var3 = Integer.parseInt(var2.group(1));
         } catch (NumberFormatException var6) {
            continue;
         }

         switch (var2.group(2)) {
            case "ч":
            case "h":
               var1 += var3 * 3600;
               break;
            case "мин":
            case "min":
               var1 += var3 * 60;
               break;
            default:
               var1 += var3;
         }
      }

      return var1;
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         this.method2207();
         this.method0479();
         if (field0796.field_1755 == null || field0796.field_1755 instanceof class_408) {
            ServerAssist.ServerMode var2 = this.field1448.method0492();

            for (ServerAssist.TrackedPlayer var4 : this.field1347) {
               if (var4.field1014 == var2) {
                  String var5 = var4.field0715;
                  KeyBind var6 = var4.field1259.method0492();
                  boolean var7 = var6 != null && var6.method2048() != -1 && var6.method0026();
                  boolean var8 = this.field1385.getOrDefault(var5, false);
                  if (var7 && !var8) {
                     ServerAssist.PendingAction var9 = this.field1309.get(var5);
                     if (var9 != null) {
                        class_1735 var10 = InventorySearch.method1104(
                           var1x -> var1x.method_7677().method_7909().equals(var9.field0153)
                              && InventorySearch.method1345(var1x.method_7677().method_7964())
                                 .replace(" ", "")
                                 .contains(var9.field0715.toLowerCase(Locale.ROOT).replace(" ", ""))
                        );
                        if (var10 != null) {
                           class_1799 var11 = var10.method_7677();
                           if (field0796.field_1724.method_7357().method_7904(var11)) {
                              this.method0932(var9);
                           } else if (!this.field0366.contains(var5)) {
                              this.field0366.add(var5);
                           }
                        } else {
                           this.method0187(var9);
                        }
                     }
                  }

                  this.field1385.put(var5, var7);
               }
            }

            boolean var12 = System.currentTimeMillis() < this.field0291
               || this.field0266 != ServerAssist.ActionState.field0681 && this.field0266 != ServerAssist.ActionState.field0331;
            if (var12) {
               field0796.field_1690.field_1894.method_23481(false);
               field0796.field_1690.field_1881.method_23481(false);
               field0796.field_1690.field_1913.method_23481(false);
               field0796.field_1690.field_1849.method_23481(false);
               if (field0796.field_1724.field_3913 != null) {
                  field0796.field_1724.field_3913.field_3905 = 0.0F;
                  field0796.field_1724.field_3913.field_3907 = 0.0F;
               }

               if (field0796.field_1724.method_5624()) {
                  field0796.field_1724.method_5728(false);
               }
            }

            if (this.field0266 != ServerAssist.ActionState.field0681) {
               this.method2243();
            }

            if (this.field0266 == ServerAssist.ActionState.field0681 && !this.field0366.isEmpty() && this.field0433.method0779(150L)) {
               String var13 = this.field0366.remove(0);
               ServerAssist.PendingAction var16 = this.field1309.get(var13);
               if (var16 != null) {
                  class_1735 var20 = InventorySearch.method1104(
                     var1x -> var1x.method_7677().method_7909().equals(var16.field0153)
                        && InventorySearch.method1345(var1x.method_7677().method_7964())
                           .replace(" ", "")
                           .contains(var16.field0715.toLowerCase(Locale.ROOT).replace(" ", ""))
                  );
                  if (var20 != null) {
                     class_1799 var23 = var20.method_7677();
                     if (!field0796.field_1724.method_7357().method_7904(var23)) {
                        this.method1213(var20, var16);
                     } else {
                        this.method0932(var16);
                     }
                  } else {
                     this.method0187(var16);
                  }

                  this.field0433.method1812();
               }
            }

            if (this.field0464.method0492() && this.field1448.method0492() == ServerAssist.ServerMode.field0108) {
               boolean var14 = false;

               for (class_1799 var21 : field0796.field_1724.method_5661()) {
                  if (!var21.method_7960() && var21.method_7936() != 0 && !((double)var21.method_7919() / var21.method_7936() < 0.9400000271331854)) {
                     class_6880 var24 = (class_6880<class_1887>)field0796.field_1687
                        .method_30349()
                        .method_30530(class_7924.field_41265)
                        .method_10223(class_1893.field_9101.method_29177())
                        .orElse(null);
                     if (var24 != null && class_1890.method_8225(var24, var21) > 0) {
                        var14 = true;
                        break;
                     }
                  }
               }

               if (var14 && this.field1115.method0779(5000L)) {
                  class_1735 var18 = InventorySearch.method1104(
                     var0 -> {
                        class_1799 var1 = var0.method_7677();
                        class_9279 var2 = (class_9279)var1.method_57824(class_9334.field_49628);
                        return !field0796.field_1724.method_7357().method_7904(var1)
                           && var1.method_7909().equals(class_1802.field_8287)
                           && var2 != null
                           && var2.toString().contains("\"text\":\" - при нажатие ПКМ, полностью ремонтирует\"");
                     }
                  );
                  if (var18 != null) {
                     class_1735 var22 = var18;
                     InventoryActionScheduler.method0991(() -> InventorySearch.method1206(var22));
                     this.field1115.method1812();
                  }
               }
            }

            if (!InventorySearch.method0026() && !this.field1180.isEmpty() && InventoryActionScheduler.field0649.method0026() && this.field1123.method0779(300L)) {
               class_1735 var15 = InventorySearch.method1107(
                  var0 -> var0.method_7677().method_57824(class_9334.field_49622) != null, Comparator.comparingInt(var0 -> {
                     class_9288 var1 = (class_9288)var0.method_7677().method_57825(class_9334.field_49622, null);
                     if (var1 == null) {
                        return 0;
                     }

                     int[] var2 = new int[]{0};
                     var1.method_59714().forEach(var1x -> var2[0]++);
                     return var2[0];
                  })
               );
               if (var15 != null) {
                  class_1735 var19 = var15;
                  InventorySearch.method1215(var19, class_1268.field_5808, false);
                  InventorySearch.method1570(false);
                  field0796.field_1761.method_2919(field0796.field_1724, class_1268.field_5808);
                  InventoryActionScheduler.field0078.method0578();
                  InventoryActionScheduler.field0078
                     .method0765(
                        0,
                        () -> {
                           List var2 = new ArrayList<>();
                           InventorySearch.method0562()
                              .forEach(
                                 var2x -> {
                                    for (Entry var4 : new ArrayList<>(this.field1180.entrySet())) {
                                       if (var2x.field_7871 == field0796.field_1724.method_31548()
                                          && var4.getValue().equals(var2x.method_7677().method_7909())
                                          && var4.getKey() == var2x.field_7874) {
                                          InventorySearch.method1209(var2x, 0, class_1713.field_7794, false);
                                          var2.add(var2x.field_7874);
                                       }
                                    }
                                 }
                              );
                           var2.forEach(this.field1180::remove);
                           InventorySearch.method1570(false);
                           InventorySearch.method1215(var19, class_1268.field_5808, false);
                           InventorySearch.method1570(false);
                           this.field1123.method1812();
                        },
                        0
                     );
               }
            }

            if (this.field0970.method0492() && this.field1448.method0492() == ServerAssist.ServerMode.field0108) {
               StreamSupport.<class_1297>stream(field0796.field_1687.method_18112().spliterator(), false)
                  .filter(class_3988.class::isInstance)
                  .map(class_3988.class::cast)
                  .filter(var0 -> var0.method_6084(class_1304.field_6173) || var0.method_6084(class_1304.field_6171))
                  .findFirst()
                  .ifPresent(
                     var1x -> {
                        this.field1189.method1812();
                        this.field0868 = var1x.method_5667();
                        if (field0796.field_1724.method_33571().method_1022(var1x.method_5829().method_1005()) <= 6.0) {
                           field0796.field_1724
                              .field_3944
                              .method_52787(class_2824.method_34208(var1x, false, class_1268.field_5808, var1x.method_5829().method_1005()));
                           field0796.field_1724.field_3944.method_52787(class_2824.method_34207(var1x, false, class_1268.field_5808));
                        }
                     }
                  );
            }

            this.method0521();
            this.field1760.clear();
            this.field1772.removeIf(var0 -> var0.time - System.currentTimeMillis() <= 0.0);
            this.field1746.removeIf(var0 -> var0.timeEnd + 90000.0 - System.currentTimeMillis() <= 0.0);
         }
      }
   }

   private void method0521() {
      ServerAssist.ServerMode var1 = this.field1448.method0492();
      boolean var2 = var1 == ServerAssist.ServerMode.field0682 && this.field1619.method0492();
      boolean var3 = var1 == ServerAssist.ServerMode.field1483 && this.field1709.method0492();
      if (!var2 && !var3) {
         if (this.field0903) {
            this.method0527();
         }

         this.field0907 = false;
         this.field0856 = field0796.field_1724 == null ? 0 : field0796.field_1724.field_6235;
         this.field0852 = null;
      } else {
         Aura var4 = Aura.method1701();
         class_1309 var5 = var4 == null ? null : (var4.method0409() != null && var4.method0409().method_5805() ? var4.method0409() : var4.method0520());
         UUID var6 = var5 != null && var5.method_5805() ? var5.method_5667() : null;
         if (!Objects.equals(var6, this.field0852)) {
            this.field0852 = var6;
            this.field1231.method1812();
            this.field1223.method0436(0L);
            this.field1237.method0436(0L);
         }

         this.method1158(var5);
         if (this.field0903) {
            if (this.field0907) {
               int var15 = this.field0895 != null ? this.method1061(this.field0895, var3) : -1;
               if (var15 != -1) {
                  InventorySlotHelper.method2102(var15);
               }

               this.field1133.method1812();
               this.method0527();
            }
         } else {
            this.field0907 = false;
            if (this.field1133.method0779(1000L)) {
               if (var5 != null && var5.method_5805()) {
                  float var7 = PlayerActionHelper.method0238(field0796.field_1724);
                  float var8 = PlayerActionHelper.method0238(var5);
                  MultiSelectSetting var9 = var3 ? this.field1152 : this.field1562;
                  if (var9.method1936().isEmpty() || this.method0896(var9, var5, var7, var8)) {
                     class_1799 var10 = field0796.field_1724.method_6079();
                     boolean var11 = var3 ? this.method0269(var10) : this.method1241(var10);
                     if (var11) {
                        double var12 = this.method2155(var10);
                        int var14 = var3 ? this.method1223(var10.method_7909(), var12) : this.method0609(var12);
                        if (var14 != -1) {
                           this.field0895 = var10.method_7964().getString();
                           InventorySlotHelper.method2102(var14);
                           this.field0903 = true;
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private boolean method0517() {
      return this.field1231.method0779(2500L) || !this.field1223.method0779(3000L);
   }

   private boolean method0896(MultiSelectSetting var1, class_1309 var2, float var3, float var4) {
      if (var1.method0387("Lower Health") && var4 < var3) {
         return true;
      } else if (var1.method0387("Enemy Eating") && var2.method_6115() && var2.method_6030().method_57824(class_9334.field_53964) != null) {
         return true;
      } else {
         return var1.method0387("Player Retreating") && this.method0517() ? true : var1.method0387("Popped Totem") && !this.field1237.method0779(3000L);
      }
   }

   private void method0527() {
      this.field0903 = false;
      this.field0895 = null;
   }

   private void method1158(class_1309 var1) {
      if (field0796.field_1724 != null) {
         int var2 = field0796.field_1724.field_6235;
         boolean var3 = var2 > this.field0856;
         this.field0856 = var2;
         if (var3 && var1 != null) {
            class_1282 var4 = field0796.field_1724.method_6081();
            class_1297 var5 = var4 != null ? var4.method_5529() : null;
            boolean var6;
            if (var5 != null) {
               var6 = var5.method_5628() == var1.method_5628();
            } else {
               var6 = field0796.field_1724.method_5739(var1) <= 6.0;
            }

            if (var6) {
               this.field1231.method1812();
               if (this.field0903) {
                  this.field0907 = true;
               }
            }
         }
      }
   }

   @EventHandler
   public void onSpawnEntity(EntitySpawnEvent var1) {
      if (!method1974()) {
         if (this.method2247()) {
            if (this.field0852 != null) {
               if (var1.method1798() instanceof class_1684 var2) {
                  class_1297 var4 = var2.method_24921();
                  if (var4 != null && this.field0852.equals(var4.method_5667())) {
                     this.field1223.method1812();
                  }
               }
            }
         }
      }
   }

   @EventHandler
   public void onPopTotem(TotemPopEvent var1) {
      if (!method1974()) {
         if (this.method2247()) {
            if (this.field0852 != null && var1.method1800() != null) {
               if (this.field0852.equals(var1.method1800().method_5667())) {
                  this.field1237.method1812();
               }
            }
         }
      }
   }

   private boolean method2247() {
      ServerAssist.ServerMode var1 = this.field1448.method0492();
      return var1 == ServerAssist.ServerMode.field0682 && this.field1619.method0492()
         || var1 == ServerAssist.ServerMode.field1483 && this.field1709.method0492();
   }

   private boolean method1241(class_1799 var1) {
      if (var1 != null && !var1.method_7960() && var1.method_7909() == class_1802.field_8575) {
         class_2561 var2 = var1.method_7964();
         if (var2 == null) {
            return false;
         }

         String var3 = var2.getString();
         return var3 != null && var3.contains("Шар");
      } else {
         return false;
      }
   }

   private boolean method0269(class_1799 var1) {
      if (var1 != null && !var1.method_7960()) {
         return var1.method_7909() != class_1802.field_8575 && var1.method_7909() != class_1802.field_8288 ? false : this.method2155(var1) > 0.0;
      } else {
         return false;
      }
   }

   private double method2155(class_1799 var1) {
      if (var1 != null && !var1.method_7960()) {
         class_9285 var2 = (class_9285)var1.method_57824(class_9334.field_49636);
         if (var2 == null) {
            return 0.0;
         }

         double[] var3 = new double[]{0.0};
         var2.method_57482(class_1304.field_6171, (var1x, var2x) -> {
            if (var1x.comp_349() == class_5134.field_23721.comp_349()) {
               var3[0] += var2x.comp_2449();
            }
         });
         return var3[0];
      } else {
         return 0.0;
      }
   }

   private int method0609(double var1) {
      int var3 = -1;
      double var4 = var1;

      for (int var6 = 0; var6 <= 35; var6++) {
         class_1799 var7 = field0796.field_1724.method_31548().method_5438(var6);
         if (this.method1241(var7)) {
            double var8 = this.method2155(var7);
            if (var8 > var4) {
               var4 = var8;
               var3 = var6;
            }
         }
      }

      return var3;
   }

   private int method0504(String var1) {
      for (int var2 = 0; var2 <= 35; var2++) {
         class_1799 var3 = field0796.field_1724.method_31548().method_5438(var2);
         if (this.method1241(var3)) {
            class_2561 var4 = var3.method_7964();
            if (var4 != null && var1.equals(var4.getString())) {
               return var2;
            }
         }
      }

      return -1;
   }

   private int method1223(class_1792 var1, double var2) {
      int var4 = -1;
      double var5 = var2;

      for (int var7 = 0; var7 <= 35; var7++) {
         class_1799 var8 = field0796.field_1724.method_31548().method_5438(var7);
         if (var8 != null && !var8.method_7960() && var8.method_7909() == var1) {
            double var9 = this.method2155(var8);
            if (var9 > var5) {
               var5 = var9;
               var4 = var7;
            }
         }
      }

      return var4;
   }

   private int method1061(String var1, boolean var2) {
      for (int var3 = 0; var3 <= 35; var3++) {
         class_1799 var4 = field0796.field_1724.method_31548().method_5438(var3);
         if (var4 != null
            && !var4.method_7960()
            && (var2 ? var4.method_7909() == class_1802.field_8575 || var4.method_7909() == class_1802.field_8288 : this.method1241(var4))) {
            class_2561 var5 = var4.method_7964();
            if (var5 != null && var1.equals(var5.getString())) {
               return var3;
            }
         }
      }

      return -1;
   }

   private void method1213(class_1735 var1, ServerAssist.PendingAction var2) {
      this.field0524 = field0796.field_1724.method_31548().field_7545;
      this.field0548 = var1.field_7874;
      this.field0502 = var1.field_7874;
      this.field1681 = var2.field0715;
      boolean var3 = (var1.field_7874 < 0 || var1.field_7874 >= 9) && (var1.field_7874 < 36 || var1.field_7874 >= 45);
      long var4 = field0796.method_22683().method_4490();
      this.field1699 = class_3675.method_15987(var4, field0796.field_1690.field_1894.method_1429().method_1444());
      this.field1597 = class_3675.method_15987(var4, field0796.field_1690.field_1881.method_1429().method_1444());
      this.field1586 = class_3675.method_15987(var4, field0796.field_1690.field_1913.method_1429().method_1444());
      this.field1609 = class_3675.method_15987(var4, field0796.field_1690.field_1849.method_1429().method_1444());
      this.field1665 = true;
      field0796.field_1690.field_1894.method_23481(false);
      field0796.field_1690.field_1881.method_23481(false);
      field0796.field_1690.field_1913.method_23481(false);
      field0796.field_1690.field_1849.method_23481(false);
      this.field0291 = System.currentTimeMillis() + 95L;
      this.field0228 = System.currentTimeMillis();
      this.field0266 = var3 ? ServerAssist.ActionState.field0107 : ServerAssist.ActionState.field1013;
      class_5250 var6 = class_2561.method_43473()
         .method_10852(LegacyTextParser.method1064(var2.field1504, LegacyTextParser.method1015(var2.field1504), false))
         .method_27693("  " + method2236(var2.field1504));
      NewHUD.method1350(var6, ModuleCategory.field0776.method0017(), true);
   }

   private static String method2236(String var0) {
      if (var0 == null) {
         return "использован";
      } else {
         String var1 = var0.trim().toLowerCase();
         if (var1.isEmpty()) {
            return "использован";
         } else {
            String[] var2 = var1.split("\\s+");
            String var3 = var2[0];
            boolean var4 = var3.endsWith("ый")
               || var3.endsWith("ий")
               || var3.endsWith("ой")
               || var3.endsWith("ая")
               || var3.endsWith("яя")
               || var3.endsWith("ое")
               || var3.endsWith("ее")
               || var3.endsWith("ые")
               || var3.endsWith("ие")
               || var3.endsWith("ья");
            String var5 = var4 && var2.length > 1 ? var2[var2.length - 1] : var3;
            if (var5.isEmpty()) {
               return "использован";
            } else {
               char var6 = var5.charAt(var5.length() - 1);
               if (var6 == 1072 || var6 == 1103) {
                  return "использована";
               } else if (var6 != 1086 && var6 != 1077) {
                  return var6 != 1100 || !var5.equals("пыль") && !var5.equals("часть") && !var5.equals("соль") ? "использован" : "использована";
               } else {
                  return "использовано";
               }
            }
         }
      }
   }

   private void method2243() {
      long var1 = System.currentTimeMillis();
      long var3 = var1 - this.field0228;
      int var5 = field0796.field_1724.field_7498.field_7763;
      switch (this.field0266) {
         case field0107:
            if (field0796.field_1724.field_3913 != null) {
               field0796.field_1724.field_3913.field_3905 = 0.0F;
               field0796.field_1724.field_3913.field_3907 = 0.0F;
            }

            if (field0796.field_1724.method_5624()) {
               field0796.field_1724.method_5728(false);
            }

            if (var3 > 1L) {
               this.field0266 = ServerAssist.ActionState.field1482;
            }
            break;
         case field1482:
            if (field0796.field_1724.field_3913 != null) {
               field0796.field_1724.field_3913.field_3905 = 0.0F;
               field0796.field_1724.field_3913.field_3907 = 0.0F;
            }

            double var13 = Math.abs(field0796.field_1724.method_18798().field_1352);
            double var8 = Math.abs(field0796.field_1724.method_18798().field_1350);
            if (var13 < 9.999995420718636E-4 && var8 < 9.999995420718636E-4 || var3 > 75L) {
               this.field0266 = ServerAssist.ActionState.field1013;
               this.field0228 = var1;
            }
            break;
         case field1013:
            if (var3 > 25L) {
               if (this.field0502 >= 0 && this.field0502 < 9) {
                  field0796.field_1724.field_3944.method_52787(new class_2868(this.field0502));
                  field0796.field_1724.method_31548().field_7545 = this.field0502;
               } else if (this.field0502 >= 36 && this.field0502 < 45) {
                  int var12 = this.field0502 - 36;
                  field0796.field_1724.field_3944.method_52787(new class_2868(var12));
                  field0796.field_1724.method_31548().field_7545 = var12;
                  this.field0502 = var12;
               } else {
                  int var11 = 8;
                  InventorySearch.method0754(this.field0502, var11, class_1713.field_7791, false);
                  this.field0502 = var11;
                  field0796.field_1724.field_3944.method_52787(new class_2868(var11));
                  field0796.field_1724.method_31548().field_7545 = var11;
               }

               this.field0266 = ServerAssist.ActionState.field0780;
               this.field0228 = var1;
            }
            break;
         case field0780:
            if (var3 > 40L) {
               field0796.field_1724
                  .field_3944
                  .method_52787(new class_2886(class_1268.field_5808, 0, field0796.field_1724.method_36454(), field0796.field_1724.method_36455()));
               field0796.field_1724.method_6104(class_1268.field_5808);
               if (this.field1681 != null) {
                  for (ServerAssist.TrackedPlayer var14 : this.field1347) {
                     if (var14.field0136.equals(this.field1681) && var14.field0759 > 0) {
                        this.field0401.put(var14.field0715, var1 + var14.field0759 * 1000L);
                        break;
                     }
                  }
               }

               this.field0266 = ServerAssist.ActionState.field1264;
               this.field0228 = var1;
            }
            break;
         case field1264:
            if (var3 > 25L) {
               boolean var6 = (this.field0548 < 0 || this.field0548 >= 9) && (this.field0548 < 36 || this.field0548 >= 45);
               if (var6) {
                  if (this.field0502 >= 0 && this.field0502 < 9) {
                     InventorySearch.method0754(this.field0548, this.field0502, class_1713.field_7791, false);
                  }
               } else if (this.field0548 >= 36 && this.field0548 < 45) {
                  int var7 = this.field0548 - 36;
                  if (this.field0502 != var7) {
                     field0796.field_1724.field_3944.method_52787(new class_2868(var7));
                     field0796.field_1724.method_31548().field_7545 = var7;
                  }
               } else if (this.field0548 >= 0 && this.field0548 < 9 && this.field0502 != this.field0548) {
                  field0796.field_1724.field_3944.method_52787(new class_2868(this.field0548));
                  field0796.field_1724.method_31548().field_7545 = this.field0548;
               }

               if (field0796.field_1724.method_31548().field_7545 != this.field0524) {
                  field0796.field_1724.field_3944.method_52787(new class_2868(this.field0524));
                  field0796.field_1724.method_31548().field_7545 = this.field0524;
               }

               this.method2251();
               this.field0266 = ServerAssist.ActionState.field0331;
               this.field0228 = var1;
            }
            break;
         case field0331:
            if (var3 > 75L) {
               this.field0266 = ServerAssist.ActionState.field0681;
               this.field0524 = -1;
               this.field0502 = -1;
               this.field0548 = -1;
               this.field1681 = null;
            }
      }
   }

   private void method2251() {
      if (this.field1665) {
         field0796.field_1690.field_1894.method_23481(this.field1699);
         field0796.field_1690.field_1881.method_23481(this.field1597);
         field0796.field_1690.field_1913.method_23481(this.field1586);
         field0796.field_1690.field_1849.method_23481(this.field1609);
         if (field0796.field_1724 != null && field0796.field_1724.field_3913 != null) {
            if (this.field1699) {
               field0796.field_1724.field_3913.field_3905 = 1.0F;
               if (!field0796.field_1724.method_5624()) {
                  field0796.field_1724.method_5728(true);
               }
            }

            if (this.field1597) {
               field0796.field_1724.field_3913.field_3905 = -1.0F;
            }

            if (this.field1586) {
               field0796.field_1724.field_3913.field_3907 = 1.0F;
            }

            if (this.field1609) {
               field0796.field_1724.field_3913.field_3907 = -1.0F;
            }
         }

         this.field1665 = false;
      }
   }

   @EventHandler
   public void onWorldRender(WorldRenderEvent.GamePass var1) {
      if (!method1974()) {
         class_4587 var2 = var1.method1629();

         for (ServerAssist.TrackedPlayer var4 : this.field1347) {
            if (var4.field1014 == this.field1448.method0492()) {
               KeyBind var5 = var4.field1259.method0492();
               if (var5 != null && var5.method2048() != -1 && var5.method0026() && InventorySearch.method1220(var4.field1519) != null) {
                  class_2338 var6 = field0796.field_1724.method_24515();
                  int[] var7 = LegacyTextParser.method1015(var4.field0715);
                  Color var8 = method0723(var7.length > 1 ? ColorMath.method0758(10, 0, var7) : var7[0]);
                  switch (var4.field0715) {
                     case "Трапка":
                     case "Обычная трапка":
                        this.method1497(var2, var6, 1.99F, var8);
                        break;
                     case "Дезориентация":
                     case "Огненный смерч":
                     case "Явная пыль":
                        this.method1477(var2, 5.0F, var8);
                        break;
                     case "Взрывная штучка":
                        this.method1477(var2, 5.0F, var8);
                        break;
                     case "Взрывная трапка":
                        this.method1497(var2, var6, 3.99F, var8);
                        break;
                     case "Стан":
                        this.method1497(var2, var6, 15.01F, var8);
                  }
               }
            }
         }
      }
   }

   private void method1497(class_4587 var1, class_2338 var2, float var3, Color var4) {
      class_238 var5 = new class_238(var2.method_10084()).method_1014(var3);
      WorldRenderHelper.method2173(var1, var5, var4);
   }

   private void method1477(class_4587 var1, float var2, Color var3) {
      float var4 = field0796.field_1724.method_17681() / 2.0F;
      class_243 var5 = field0796.field_1724.method_19538().method_1031(var4, 0.020000008421942297, var4);

      for (int var6 = 0; var6 < 90; var6++) {
         class_243 var7 = MathHelper.method0740(var6, 90, var2).method_1019(var5);
         class_243 var8 = MathHelper.method0740(var6 + 1, 90, var2).method_1019(var5);
         WorldRenderHelper.method1507(var1, var7, var8, var3);
      }
   }

   @EventHandler
   public void onRender2D(HudRenderEvent var1) {
      if (!method1974()) {
         if (!(field0796.field_1755 instanceof class_408)) {
            this.method1400(var1.method1806());
         }
      }
   }

   public void method1400(class_332 var1) {
      if (!method1974()) {
         class_4587 var2 = var1.method_51448();
         this.method2207();
         if (this.field0830.method0492()) {
            this.method1432(var1, var2);
         }

         if (this.field1201.method0492() && this.field1448.method0492() == ServerAssist.ServerMode.field1483) {
            this.method0317(var1, var2);
         }
      }
   }

   private void method2207() {
      if (this.field0830.method0492()) {
         if (Fonts.field0075 != null) {
            FontSize var1 = Fonts.field0075.method0654(5.0F);
            float var2 = 22.0F;
            float var3 = 3.0F;
            float var4 = 4.0F;
            float var5 = 25.0F;
            float var6 = 0.0F;
            int var7 = 0;

            for (ServerAssist.TrackedPlayer var9 : this.field1347) {
               if (var9.field1014 == this.field1448.method0492() && var9.field1259.method0492().method2048() != -1) {
                  String var10 = var9.field1259.method0492().toString();
                  float var11 = var1.method0998(var10);
                  float var12 = Math.max(var2, var11 + var3 * 2.0F + 2.0F);
                  var6 += var12;
                  var7++;
               }
            }

            if (var7 == 0) {
               HudWidgetManager.method1605().method0215("ServerAssist", var2, var5);
            } else {
               var6 += (var7 - 1) * var4;
               HudWidgetManager.method1605().method0215("ServerAssist", var6, var5);
            }
         }
      }
   }

   public boolean method1755() {
      return this.field0830.method0492();
   }

   private void method1432(class_332 var1, class_4587 var2) {
      HudWidgetState var3 = HudWidgetManager.method1605().method1002("ServerAssist");
      if (var3 != null) {
         List var4 = new ArrayList<>();

         for (ServerAssist.TrackedPlayer var6 : this.field1347) {
            if (var6.field1014 == this.field1448.method0492() && var6.field1259.method0492().method2048() != -1) {
               var4.add(var6);
            }
         }

         if (var4.isEmpty()) {
            HudWidgetManager.method1605().method0215("ServerAssist", 22.0F, 28.0F);
         } else {
            FontSize var53 = Fonts.field0075.method0654(5.0F);
            float var54 = 25.0F;
            float var7 = 4.0F;
            float var8 = 6.0F;
            float var9 = 14.0F;
            float var10 = 3.0F;
            float var11 = 11.0F;
            float var12 = 3.0F;
            float var13 = 3.0F;
            float var14 = 22.0F;
            float[] var15 = new float[var4.size()];

            for (int var16 = 0; var16 < var4.size(); var16++) {
               String var17 = var4.get(var16).field1259.method0492().toString();
               float var18 = var53.method0998(var17);
               var15[var16] = Math.max(var14, var18 + var13 * 2.0F + 2.0F);
            }

            int var55 = var4.size();
            float var56 = 0.0F;

            for (int var57 = 0; var57 < var55; var57++) {
               var56 += var15[var57];
            }

            if (var55 > 0) {
               var56 += (var55 - 1) * var7;
            }

            float var58 = var54;
            HudWidgetManager.method1605().method0215("ServerAssist", var56, var58);
            float var19 = var3.method1946();
            float var20 = var3.method0413();
            Color var21 = ThemePalette.field0930.get();
            Color var22 = ThemePalette.field0884;
            Color var23 = ThemePalette.field0134;
            Color var24 = new Color(255, 255, 255);
            Color var25 = ThemeColorManager.method1908().method2063();
            Color var26 = new Color(var25.getRed(), var25.getGreen(), var25.getBlue(), 90);
            Color var27 = new Color(255, 255, 255, 5);
            Color var28 = new Color(255, 255, 255, 10);
            long var29 = System.currentTimeMillis();
            float var31 = var19;

            for (int var32 = 0; var32 < var55; var32++) {
               ServerAssist.TrackedPlayer var33 = var4.get(var32);
               KeyBind var34 = var33.field1259.method0492();
               float var35 = var15[var32];
               GuiRenderHelper.method1462(var2, var31, var20, var35, var54, var8, ThemePalette.field0367.get(), var23);
               GuiRenderHelper.method1463(var2, var31, var20, var35, var54, var8, var21);
               GuiRenderHelper.method1461(var2, var31, var20, var35, var54, var8, 0.5F, 0.5F, var22);
               var2.method_22903();
               float var36 = var9 / 16.0F;
               float var37 = var31 + (var35 - var9) / 2.0F;
               float var38 = var20 + var10;
               var2.method_46416(var37, var38, 0.0F);
               var2.method_22905(var36, var36, 1.0F);
               var1.method_51427(new class_1799(var33.field1519), 0, 0);
               var2.method_22909();
               String var39 = var34.toString();
               float var40 = var53.method0998(var39);
               float var41 = var13 + var40 + var13;
               float var42 = var31 + (var35 - var41) / 2.0F;
               float var43 = var20 + var54 - var11 - 2.0F;
               GuiRenderHelper.method1462(var2, var42, var43, var41, var11, var12, ThemePalette.field0367.get(), ThemePalette.field0134);
               GuiRenderHelper.method1463(var2, var42, var43, var41, var11, var12, ThemePalette.field0930.get());
               GuiRenderHelper.method0326(var2, var42, var43, var41, var11, var12, var27);
               GuiRenderHelper.method1460(var2, var42, var43, var41, var11, var12, 0.3F, 0.5F, 0.5F, var28);
               float var44 = var42 + (var41 - var40) / 2.0F;
               float var45 = var43 + (var11 - var53.method0530()) / 2.0F;
               GuiRenderHelper.method1491(var2, var53, var39, var44, var45, var24);
               Long var46 = this.field0401.get(var33.field0715);
               boolean var47 = var46 != null && var46 > var29 && var33.field0759 > 0;
               float var48;
               if (var47) {
                  float var49 = var33.field0759 * 1000.0F;
                  float var50 = (float)(var46 - var29);
                  float var51 = Math.clamp(1.0F - var50 / var49, 0.0F, 1.0F);
                  var48 = 1.0F - var51;
               } else {
                  var48 = 0.0F;
               }

               float var59 = this.field1170.getOrDefault(var33.field0715, 0.0F);
               var59 += (var48 - var59) * 0.18F;
               if (Math.abs(var59 - var48) < 0.005F) {
                  var59 = var48;
               }

               this.field1170.put(var33.field0715, var59);
               float var61 = var54 * var59;
               if (var61 > 0.5F) {
                  float var62 = var20 + var54 - var61;
                  float var52 = Math.clamp(var8 - (var54 - var61), 0.0F, var8);
                  RenderCommandFactory.method0548()
                     .method0925(new RenderSize(var35, var61))
                     .method0824(new CornerRadius(var52, var8, var8, var52))
                     .method0916(new QuadColor(var26))
                     .method0555()
                     .method1551(var2.method_23760().method_23761(), var31, var62);
               }

               var31 += var35 + var7;
            }
         }
      }
   }

   private void method0317(class_332 var1, class_4587 var2) {
      FontSize var3 = Fonts.field0075.method0654(7.0F);
      Color var4 = new Color(0, 0, 0, 150);
      Color var5 = new Color(255, 255, 255, 255);

      for (ServerAssist.ItemPosition var7 : this.field1772) {
         if (ServerEnvironment.method1961().equals(var7.world)) {
            class_243 var8 = ViewFrustumHelper.method1299(var7.vec);
            if (ViewFrustumHelper.method0289(var8)) {
               double var9 = (var7.time - System.currentTimeMillis()) / 1000.0;
               String var11 = MathHelper.method0614(var9, 0.10000000745064033) + "с";
               float var12 = var3.method0998(var11);
               float var13 = (float)(var8.field_1352 - var12 / 2.0F);
               float var14 = (float)var8.field_1351;
               GuiRenderHelper.method1463(var2, var13 - 4.0F, var14 - 2.0F, var12 + 8.0F, 10.0F, 1.5F, var4);
               GuiRenderHelper.method1491(var2, var3, var11, var13, var14, var5);
            }
         }
      }

      for (ServerAssist.EventInfo var25 : this.field1746) {
         if (ServerEnvironment.method1961().equals(var25.world)) {
            class_243 var26 = ViewFrustumHelper.method1299(var25.vec);
            if (ViewFrustumHelper.method0289(var26)) {
               double var27 = field0796.method_1561().field_4686.method_19326().method_1022(var25.vec);
               double var28 = (var25.timeOpen - System.currentTimeMillis()) / 1000.0;
               double var29 = (var25.timeEnd - System.currentTimeMillis()) / 1000.0;
               String var15 = " [" + MathHelper.method0614(var27, 0.10000000745064033) + "m]";
               String var16 = var28 > 0.0
                  ? ("До начала: " + MathHelper.method0614(var28, var28 < 30.0 ? 0.10000000745064033 : 1.0) + "с").replace(".0", "")
                  : (
                     var29 > 0.0
                        ? ("До конца: " + MathHelper.method0614(var29, var29 < 30.0 ? 0.10000000745064033 : 1.0) + "с").replace(".0", "")
                        : "Конец ивента!"
                  );
               List var17 = new ArrayList<>();
               var17.add(var25.name + var15);
               if (var25.owner != null) {
                  var17.add("Призван: " + class_124.field_1065 + var25.owner);
               }

               var17.add(var16);
               if (var25.lvl != null) {
                  var17.add(var25.lvl);
               }

               float var18 = 0.0F;

               for (String var20 : var17) {
                  float var21 = var3.method0998(var20);
                  float var22 = (float)(var26.field_1352 - var21 / 2.0F);
                  float var23 = (float)(var26.field_1351 + var18);
                  GuiRenderHelper.method1463(var2, var22 - 4.0F, var23 - 2.0F, var21 + 8.0F, 10.0F, 2.0F, var4);
                  GuiRenderHelper.method1491(var2, var3, var20, var22, var23, var5);
                  var18 += 10.0F;
               }
            }
         }
      }

      if (this.field0868 != null) {
         StreamSupport.<class_1297>stream(field0796.field_1687.method_18112().spliterator(), false)
            .filter(var1x -> var1x.method_5667().equals(this.field0868))
            .findFirst()
            .ifPresent(
               var5x -> {
                  class_243 var6 = var5x.method_24515().method_10074().method_46558();
                  class_243 var7 = ViewFrustumHelper.method1299(var6);
                  if (ViewFrustumHelper.method0289(var7)) {
                     String var8 = !this.field1189.method0779(200L)
                        ? "Можно забрать"
                        : (
                           !this.field1189.method0779(20000L)
                              ? MathHelper.method0614(20.0F - (float)this.field1189.method1948() / 1000.0F, 0.10000000745064033) + "с"
                              : "Скоро"
                        );
                     float var9 = var3.method0998(var8);
                     float var10 = (float)(var7.field_1352 - var9 / 2.0F);
                     float var11 = (float)var7.field_1351;
                     GuiRenderHelper.method1463(var2, var10 - 4.0F, var11 - 2.0F, var9 + 8.0F, 10.0F, 2.0F, var4);
                     GuiRenderHelper.method1491(var2, var3, var8, var10, var11, var5);
                  }
               }
            );
      }
   }

   private void method0932(ServerAssist.PendingAction var1) {
      class_5250 var2 = class_2561.method_43473()
         .method_10852(LegacyTextParser.method1064(var1.field1504, LegacyTextParser.method1015(var1.field1504), false))
         .method_27693("  в кулдауне");
      NewHUD.method1350(var2, ModuleCategory.field0776.method0017(), false);
   }

   private void method0187(ServerAssist.PendingAction var1) {
      NewHUD.method1053("Нету предмета", "\"" + var1.field1504 + "\"", new class_1799(var1.field0153), false);
   }

   private void method1049(String var1, String var2, String var3, class_243 var4, String var5, int var6, int var7) {
      for (ServerAssist.EventInfo var9 : this.field1746) {
         if (var9.vec.equals(var4)) {
            return;
         }
      }

      long var12 = System.currentTimeMillis() + var6 * 1000L;
      long var10 = var12 + var7 * 1000L;
      this.field1746.add(new ServerAssist.EventInfo(var1, var2, var3, var4, var5, var12, var10));
   }

   private void method1235(class_1792 var1, class_243 var2, double var3) {
      for (ServerAssist.ItemPosition var6 : this.field1772) {
         if (var6.vec.equals(var2)) {
            return;
         }
      }

      this.field1772.add(new ServerAssist.ItemPosition(var1, var2, ServerEnvironment.method1961(), var3));
   }

   private boolean method1264(class_2338 var1) {
      int var2 = 0;

      for (class_2338 var4 : BlockAreaScanner.method1268(var1, 2, 2, true)) {
         if (var4.method_46558().method_1022(var1.method_46558()) < 2.0) {
            class_2680 var5 = this.field1760.get(var4);
            if (var5 != null && !var5.method_26215()) {
               var2++;
            }
         } else if (!var4.equals(var1.method_10086(2).method_10095().method_10078())
            && !var4.equals(var1.method_10086(2).method_10095().method_10067())
            && !var4.equals(var1.method_10086(2).method_10072().method_10078())
            && !var4.equals(var1.method_10086(2).method_10072().method_10067())) {
            class_2680 var6 = this.field1760.get(var4);
            if (var6 == null || var6.method_26215()) {
               var2++;
            }
         }

         if (var2 > 1) {
            return false;
         }
      }

      return true;
   }

   private boolean method0279(class_2338 var1) {
      int var2 = 0;

      for (class_2338 var4 : BlockAreaScanner.method1268(var1, 3, 3, true)) {
         if (Math.abs(var4.method_10263() - var1.method_10263()) <= 2
            && Math.abs(var4.method_10264() - var1.method_10264()) <= 2
            && Math.abs(var4.method_10260() - var1.method_10260()) <= 2) {
            class_2680 var6 = this.field1760.get(var4);
            if (var6 != null && !var6.method_26215()) {
               var2++;
            }
         } else if (!var4.equals(var1.method_10086(3))) {
            class_2680 var5 = this.field1760.get(var4);
            if (var5 == null || var5.method_26215()) {
               var2++;
            }
         }

         if (var2 > 1) {
            return false;
         }
      }

      return true;
   }

   private static Color method0723(int var0) {
      return new Color(var0, true);
   }

   private enum ActionState {
      field0681,
      field0107,
      field1482,
      field1013,
      field0780,
      field1264,
      field0331;
   }

   private static class TrackedItem {
      final String field0715;
      final double field0002;
      final double field1409;
      final double field0956;
      final String field0791;
      long field1244;

      TrackedItem(String var1, double var2, double var4, double var6, String var8, long var9) {
         this.field0715 = var1;
         this.field0002 = var2;
         this.field1409 = var4;
         this.field0956 = var6;
         this.field0791 = var8;
         this.field1244 = var9;
      }
   }

   private static class TrackedPlayer {
      final String field0715;
      final String field0136;
      final class_1792 field1519;
      final ServerAssist.ServerMode field1014;
      final int field0759;
      final KeyBindSetting field1259;

      TrackedPlayer(String var1, String var2, class_1792 var3, ServerAssist.ServerMode var4, int var5, KeyBindSetting var6) {
         this.field0715 = var1;
         this.field0136 = var2;
         this.field1519 = var3;
         this.field1014 = var4;
         this.field0759 = var5;
         this.field1259 = var6;
      }
   }

   private record ItemPosition(class_1792 item, class_243 vec, String world, double time) {
      public class_1792 method0566() {
         return this.item;
      }

      public class_243 method0024() {
         return this.vec;
      }

      public String method2067() {
         return this.world;
      }

      public double method1761() {
         return this.time;
      }
   }

   public enum ServerMode implements DisplayNamed {
      field0682("ReallyWorld"),
      field0108("HolyWorld"),
      field1483("FunTime");

      private final String field1030;

      ServerMode(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }

   private record EventInfo(String name, String lvl, String owner, class_243 vec, String world, double timeOpen, double timeEnd) {
      public String method0557() {
         return this.name;
      }

      public String method0017() {
         return this.lvl;
      }

      public String method2067() {
         return this.owner;
      }

      public class_243 method1803() {
         return this.vec;
      }

      public String method1619() {
         return this.world;
      }

      public double method1945() {
         return this.timeOpen;
      }

      public double method0412() {
         return this.timeEnd;
      }
   }

   private static class PendingAction {
      final String field0715;
      final class_1792 field0153;
      final String field1504;

      PendingAction(String var1, class_1792 var2, String var3) {
         this.field0715 = var1;
         this.field0153 = var2;
         this.field1504 = var3;
      }
   }
}
