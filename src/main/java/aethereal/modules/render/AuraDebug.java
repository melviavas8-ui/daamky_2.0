package aethereal;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2661;
import net.minecraft.class_2663;
import net.minecraft.class_2743;
import net.minecraft.class_2824;
import net.minecraft.class_2828;
import net.minecraft.class_2848;
import net.minecraft.class_2868;
import net.minecraft.class_2879;
import net.minecraft.class_4587;
import net.minecraft.class_5134;
import net.minecraft.class_6880;
import net.minecraft.class_7439;
import net.minecraft.class_8043;
import net.minecraft.class_8143;
import net.minecraft.class_9285;
import net.minecraft.class_9304;
import net.minecraft.class_9334;
import net.minecraft.class_2824.class_5908;
import net.minecraft.class_2848.class_2849;

public class AuraDebug extends Module {
   private static final Color field0134 = new Color(12, 12, 18, 220);
   private static final Color field1500 = new Color(160, 160, 180);
   private static final Color field1026 = new Color(235, 235, 240);
   private static final Color field0207 = new Color(120, 220, 130);
   private static final Color field0486 = new Color(220, 110, 110);
   private static final Color field1641 = new Color(230, 200, 90);
   private static final Color field1564 = new Color(220, 120, 220);
   private static final Color field1726 = new Color(120, 200, 230);
   private static final Color field1153 = new Color(255, 255, 255);
   private static final String[] field1111 = new String[]{
      "античит",
      "anticheat",
      "бан",
      "забанен",
      "ban",
      "кик",
      "kick",
      "мут",
      "mute",
      "подозрит",
      "suspect",
      "читы",
      "cheat",
      "флаг",
      "flag",
      "детект",
      "detect",
      "blocked",
      "заблок"
   };
   private final BooleanSetting field1201 = new BooleanSetting("HUD", true);
   private final BooleanSetting field0875 = new BooleanSetting("Log File", true);
   private final BooleanSetting field0830 = new BooleanSetting("Aura Only", true);
   private final BooleanSetting field0914 = new BooleanSetting("Capture Chat", true);
   private final BooleanSetting field1335 = new BooleanSetting("Rotation Trail", true);
   private final BooleanSetting field1296 = new BooleanSetting("Packet Trail", true);
   private final BooleanSetting field1372 = new BooleanSetting("Damage Timeline", true);
   private final BooleanSetting field0389 = new BooleanSetting("Tick Snapshots", false);
   private final FloatSetting field0360 = new FloatSetting("Miss Timeout (ms)", 500.0F, 100.0F, 2000.0F, 50.0F);
   private final FloatSetting field0430 = new FloatSetting("Snap Threshold", 30.0F, 5.0F, 90.0F, 1.0F);
   private final FloatSetting field0262 = new FloatSetting("HUD Events", 6.0F, 3.0F, 15.0F, 1.0F);
   private final FloatSetting field0234 = new FloatSetting("Trail Ticks", 20.0F, 5.0F, 60.0F, 1.0F);
   private final FloatSetting field0295 = new FloatSetting("Damage Trace Ticks", 20.0F, 5.0F, 60.0F, 1.0F);
   private final FloatSetting field0529 = new FloatSetting("Packet History", 20.0F, 5.0F, 50.0F, 1.0F);
   private final FloatSetting field0506 = new FloatSetting("Tick Snapshot Interval", 10.0F, 1.0F, 40.0F, 1.0F);
   private final FloatSetting field0552 = new FloatSetting("Cut Ratio", 0.7F, 0.3F, 0.95F, 0.05F);
   private final Deque<AuraDebug.DebugText> field1682 = new ArrayDeque<>();
   private final Deque<AuraDebug.DebugLine> field1664 = new ArrayDeque<>();
   private final Deque<AuraDebug.DebugLine> field1697 = new ArrayDeque<>();
   private final List<AuraDebug.DebugBox> field1595 = new ArrayList<>();
   private final Deque<AuraDebug.DebugBox> field1584 = new ArrayDeque<>();
   private final Deque<Long> field1607 = new ArrayDeque<>();
   private final Deque<Long> field1759 = new ArrayDeque<>();
   private final Deque<Long> field1745 = new ArrayDeque<>();
   private final Deque<Long> field1771 = new ArrayDeque<>();
   private final Deque<Long> field1179 = new ArrayDeque<>();
   private BufferedWriter field1169;
   private Path field1190;
   private long field1120;
   private long field1113;
   private long field1130;
   private long field1228 = -1L;
   private long field1220 = -1L;

   public static AuraDebug method1702() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(AuraDebug.class) : null;
   }

   public AuraDebug() {
      super("AuraDebug", ModuleCategory.field1004, "Forensic Aura logger v2: hit outcomes, packet trails, damage timelines");
      this.method1013("Forensic Aura v2: исход хитов, трейлы пакетов, таймлайны урона");
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field1120 = System.currentTimeMillis();
      this.field1113 = 0L;
      this.field1130 = 0L;
      this.field1228 = -1L;
      this.field1220 = -1L;
      this.field1682.clear();
      this.field1664.clear();
      this.field1697.clear();
      this.field1595.clear();
      this.field1584.clear();
      this.field1607.clear();
      this.field1759.clear();
      this.field1745.clear();
      this.field1771.clear();
      this.field1179.clear();
      this.method1691();
   }

   @Override
   public void method2078() {
      this.method1754();
      super.method2078();
   }

   private void method1691() {
      if (this.field0875.method1938()) {
         try {
            Path var1 = field0796.field_1697.toPath().resolve("daamky").resolve("debug");
            Files.createDirectories(var1);
            String var2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            this.field1190 = var1.resolve("aura-" + var2 + ".jsonl");
            this.field1169 = Files.newBufferedWriter(this.field1190, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            JsonObject var3 = new JsonObject();
            var3.addProperty("type", "session_start");
            var3.addProperty("ts", this.field1120);
            var3.addProperty("user", field0796.field_1724 != null ? field0796.field_1724.method_5477().getString() : "unknown");
            var3.addProperty("server", field0796.method_1558() != null ? field0796.method_1558().field_3761 : "singleplayer");
            var3.addProperty("schemaVersion", 2);
            this.method0943(var3);
         } catch (IOException var4) {
            this.field1169 = null;
         }
      }
   }

   private void method1754() {
      if (this.field1169 != null) {
         try {
            for (AuraDebug.DebugBox var2 : this.field1595) {
               if (var2.field0287.equals("PENDING")) {
                  var2.field0287 = "DISABLED";
               }

               this.method0943(this.method1833(var2));
            }

            JsonObject var4 = new JsonObject();
            var4.addProperty("type", "session_end");
            var4.addProperty("ts", System.currentTimeMillis());
            var4.addProperty("totalAttacks", this.field1113);
            this.method0943(var4);
            this.field1169.flush();
            this.field1169.close();
         } catch (IOException var3) {
         }

         this.field1169 = null;
         this.field1595.clear();
      }
   }

   private void method0943(JsonObject var1) {
      if (this.field1169 != null) {
         try {
            this.field1169.write(var1.toString());
            this.field1169.newLine();
            this.field1169.flush();
         } catch (IOException var3) {
         }
      }
   }

   private boolean method2030() {
      if (field0796.field_1724 == null || field0796.field_1687 == null) {
         return false;
      }

      if (!this.field0830.method1938()) {
         return true;
      }

      Aura var1 = Aura.method1701();
      return var1 != null && var1.method2195();
   }

   @EventHandler
   public void onTick(PlayerTickEvent var1) {
      if (this.method2195() && field0796.field_1724 != null && field0796.field_1687 != null) {
         this.field1130++;
         if (this.method2030()) {
            this.method2015();
         }

         this.method0457();
         this.method0405();
         this.method0471();
         if (this.field0389.method1938()
            && this.method2030()
            && this.field0506.method0492() > 0.0F
            && this.field1130 % this.field0506.method0492().longValue() == 0L) {
            this.method2043();
         }
      }
   }

   private void method2015() {
      AuraDebug.DebugText var1 = new AuraDebug.DebugText();
      var1.field0568 = System.currentTimeMillis();
      var1.field0005 = this.field1130;
      Rotation var2 = RotationHelper.method0545();
      Rotation var3 = RotationManager.field0618.method0545();
      Rotation var4 = RotationManager.field0618.method2258();
      var1.field1410 = var2.method2047();
      var1.field0957 = var2.method1762();
      var1.field0758 = var3.method2047();
      var1.field1242 = var3.method1762();
      var1.field0314 = var4.method2047();
      var1.field0177 = var4.method1762();
      var1.field0497 = field0796.field_1724.method_24828();
      var1.field1614 = field0796.field_1724.field_6017;
      var1.field1574 = field0796.field_1724.method_5624();
      var1.field1735 = field0796.field_1724.method_6115();
      var1.field1161 = field0796.field_1724.method_5715();
      class_243 var5 = field0796.field_1724.method_18798();
      var1.field1086 = var5.field_1352;
      var1.field1195 = var5.field_1351;
      var1.field0870 = var5.field_1350;
      var1.field0826 = field0796.field_1724.field_6251;
      var1.field0931 = field0796.field_1724.field_6252;
      this.field1682.addLast(var1);
   }

   private void method2043() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("type", "tick_state");
      var1.addProperty("ts", System.currentTimeMillis());
      var1.addProperty("absTick", this.field1130);
      var1.addProperty("gameTime", field0796.field_1687.method_8510());
      Rotation var2 = RotationHelper.method0545();
      Rotation var3 = RotationManager.field0618.method0545();
      Rotation var4 = RotationManager.field0618.method2258();
      var1.addProperty("cameraYaw", var2.method2047());
      var1.addProperty("cameraPitch", var2.method1762());
      var1.addProperty("currentYaw", var3.method2047());
      var1.addProperty("currentPitch", var3.method1762());
      var1.addProperty("serverYaw", var4.method2047());
      var1.addProperty("serverPitch", var4.method1762());
      class_243 var5 = field0796.field_1724.method_18798();
      var1.addProperty("velX", var5.field_1352);
      var1.addProperty("velY", var5.field_1351);
      var1.addProperty("velZ", var5.field_1350);
      var1.addProperty("sprinting", field0796.field_1724.method_5624());
      var1.addProperty("sneaking", field0796.field_1724.method_5715());
      var1.addProperty("onGround", field0796.field_1724.method_24828());
      var1.addProperty("fallDistance", field0796.field_1724.field_6017);
      var1.addProperty("usingItem", field0796.field_1724.method_6115());
      var1.addProperty("handSwinging", field0796.field_1724.field_6252);
      var1.addProperty("swingProgress", field0796.field_1724.field_6251);
      var1.addProperty("hotbarSlot", field0796.field_1724.method_31548().field_7545);
      this.method0943(var1);
   }

   private void method0471() {
      int var1 = Math.max(this.field0234.method0492().intValue() * 3, 80);

      while (this.field1682.size() > var1) {
         this.field1682.removeFirst();
      }

      int var2 = this.field0529.method0492().intValue();

      while (this.field1664.size() > var2) {
         this.field1664.removeFirst();
      }

      while (this.field1697.size() > var2) {
         this.field1697.removeFirst();
      }

      long var3 = System.currentTimeMillis() - 1000L;
      method1070(this.field1607, var3);
      method1070(this.field1759, var3);
      method1070(this.field1745, var3);
      method1070(this.field1771, var3);
      method1070(this.field1179, var3);
   }

   private static void method1070(Deque<Long> var0, long var1) {
      while (!var0.isEmpty() && var0.peekFirst() < var1) {
         var0.removeFirst();
      }
   }

   @EventHandler
   public void onPacketSend(PacketEvent.Outbound var1) {
      if (this.method2195() && field0796.field_1724 != null) {
         class_2596 var2 = var1.method1970();
         long var3 = System.currentTimeMillis();
         AuraDebug.DebugLine var5 = new AuraDebug.DebugLine();
         var5.field0568 = var3;
         var5.field0005 = this.field1130;
         var5.field1527 = true;
         var5.field1030 = var2.getClass().getSimpleName();
         var5.field0791 = this.method1353(var2);
         this.field1664.addLast(var5);
         if (var2 instanceof class_2879) {
            this.field1759.addLast(var3);
         } else if (var2 instanceof class_2828 var6 && var6.method_36172()) {
            this.field1771.addLast(var3);
         } else if (var2 instanceof class_2848 var7) {
            class_2849 var8 = var7.method_12365();
            if (var8 == class_2849.field_12981 || var8 == class_2849.field_12985) {
               this.field1745.addLast(var3);
            }
         } else if (var2 instanceof class_2868) {
            this.field1179.addLast(var3);
         }

         if (var2 instanceof class_2824 var9 && method1376(var9)) {
            this.field1607.addLast(var3);
            if (this.method2030()) {
               Aura var10 = Aura.method1701();
               class_1309 var11 = var10 != null ? var10.method0409() : null;
               if (var11 != null) {
                  this.method1166(var11, var3);
               }
            }
         }
      }
   }

   @EventHandler
   public void onPacketReceive(PacketEvent.Inbound var1) {
      if (this.method2195()) {
         class_2596 var2 = var1.method1970();
         long var3 = System.currentTimeMillis();
         AuraDebug.DebugLine var5 = new AuraDebug.DebugLine();
         var5.field0568 = var3;
         var5.field0005 = this.field1130;
         var5.field1527 = false;
         var5.field1030 = var2.getClass().getSimpleName();
         var5.field0791 = this.method0299(var2);
         this.field1697.addLast(var5);
         if (var2 instanceof class_8143 var6) {
            this.method1546(var6, var3);
         } else if (var2 instanceof class_8043 var7) {
            this.method1545(var7, var3);
         } else if (var2 instanceof class_2743 var8) {
            this.method1370(var8, var3);
         } else if (var2 instanceof class_2663 var9) {
            this.method1359(var9, var3);
         } else if (var2 instanceof class_7439 var10) {
            if (!this.field0914.method1938()) {
               return;
            }

            String var12 = var10.comp_763().getString();
            String var13 = var12.toLowerCase();

            for (String var17 : field1111) {
               if (var13.contains(var17)) {
                  this.method2134(var12);
                  return;
               }
            }
         } else if (var2 instanceof class_2661 var11) {
            String var18 = var11.comp_2325() != null ? var11.comp_2325().getString() : "unknown";
            this.method1846(var18);
         }
      }
   }

   private void method1546(class_8143 var1, long var2) {
      int var4 = var1.comp_1267();
      boolean var5 = field0796.field_1724 != null
         && (var1.comp_1269() == field0796.field_1724.method_5628() || var1.comp_1270() == field0796.field_1724.method_5628());
      String var6 = null;

      try {
         var6 = var1.comp_1268().method_55840();
      } catch (Throwable var11) {
      }

      for (AuraDebug.DebugBox var8 : this.field1595) {
         if (var8.field0759 == var4) {
            AuraDebug.DebugFrame var9 = new AuraDebug.DebugFrame();
            var9.field0715 = "damage";
            var9.field0005 = var2;
            var9.field1411 = (int)(this.field1130 - var8.field1412);
            JsonObject var10 = new JsonObject();
            var10.addProperty("sourceCauseId", var1.comp_1269());
            var10.addProperty("sourceDirectId", var1.comp_1270());
            if (var6 != null) {
               var10.addProperty("damageType", var6);
            }

            var1.comp_1271().ifPresent(var1x -> {
               var10.addProperty("sourceX", var1x.field_1352);
               var10.addProperty("sourceY", var1x.field_1351);
               var10.addProperty("sourceZ", var1x.field_1350);
            });
            var10.addProperty("attackerIsUs", var5);
            var9.field1025 = var10;
            var8.field0276.add(var9);
            if (var5 && !var8.field1367) {
               var8.field1367 = true;
               var8.field1322 = var6;
            }
         }
      }
   }

   private void method1545(class_8043 var1, long var2) {
      int var4 = var1.comp_1202();

      for (AuraDebug.DebugBox var6 : this.field1595) {
         if (var6.field0759 == var4) {
            AuraDebug.DebugFrame var7 = new AuraDebug.DebugFrame();
            var7.field0715 = "tilt";
            var7.field0005 = var2;
            var7.field1411 = (int)(this.field1130 - var6.field1412);
            JsonObject var8 = new JsonObject();
            var8.addProperty("tiltYaw", var1.comp_1203());
            var8.addProperty("idealYaw", var6.field0423);
            var8.addProperty("serverYaw", var6.field0385);
            var7.field1025 = var8;
            var6.field0276.add(var7);
         }
      }
   }

   private void method1370(class_2743 var1, long var2) {
      int var4 = var1.method_11818();

      for (AuraDebug.DebugBox var6 : this.field1595) {
         if (var6.field0759 == var4) {
            AuraDebug.DebugFrame var7 = new AuraDebug.DebugFrame();
            var7.field0715 = "knockback";
            var7.field0005 = var2;
            var7.field1411 = (int)(this.field1130 - var6.field1412);
            JsonObject var8 = new JsonObject();
            var8.addProperty("vx", var1.method_11815());
            var8.addProperty("vy", var1.method_11816());
            var8.addProperty("vz", var1.method_11819());
            var8.addProperty(
               "magnitude",
               Math.sqrt(var1.method_11815() * var1.method_11815() + var1.method_11816() * var1.method_11816() + var1.method_11819() * var1.method_11819())
            );
            var7.field1025 = var8;
            var6.field0276.add(var7);
         }
      }
   }

   private void method1359(class_2663 var1, long var2) {
      if (field0796.field_1687 != null) {
         class_1297 var4;
         try {
            var4 = var1.method_11469(field0796.field_1687);
         } catch (Throwable var11) {
            return;
         }

         if (var4 != null) {
            int var5 = var4.method_5628();
            byte var6 = var1.method_11470();

            for (AuraDebug.DebugBox var8 : this.field1595) {
               if (var8.field0759 == var5) {
                  AuraDebug.DebugFrame var9 = new AuraDebug.DebugFrame();
                  var9.field0715 = "status";
                  var9.field0005 = var2;
                  var9.field1411 = (int)(this.field1130 - var8.field1412);
                  JsonObject var10 = new JsonObject();
                  var10.addProperty("status", Integer.valueOf(var6));
                  var9.field1025 = var10;
                  var8.field0276.add(var9);
               }
            }
         }
      }
   }

   private String method1353(class_2596<?> var1) {
      try {
         if (var1 instanceof class_2828 var7) {
            return String.format(
               "look=%s pos=%s yaw=%.2f pitch=%.2f og=%b",
               var7.method_36172(),
               var7.method_36171(),
               var7.method_12271(0.0F),
               var7.method_12270(0.0F),
               var7.method_12273()
            );
         }

         if (var1 instanceof class_2824 var6) {
            return method1376(var6) ? "ATTACK" : "interact";
         }

         if (var1 instanceof class_2879 var5) {
            return "hand=" + var5.method_12512().name();
         }

         if (var1 instanceof class_2848 var4) {
            return "mode=" + var4.method_12365().name();
         }

         if (var1 instanceof class_2868 var2) {
            return "slot=" + var2.method_12442();
         }
      } catch (Throwable var3) {
      }

      return "";
   }

   private String method0299(class_2596<?> var1) {
      try {
         if (var1 instanceof class_8143 var8) {
            return "eid=" + var8.comp_1267();
         }

         if (var1 instanceof class_8043 var7) {
            return String.format("eid=%d yaw=%.2f", var7.comp_1202(), var7.comp_1203());
         }

         if (var1 instanceof class_2743 var6) {
            return String.format("eid=%d v=%.2f,%.2f,%.2f", var6.method_11818(), var6.method_11815(), var6.method_11816(), var6.method_11819());
         }

         if (var1 instanceof class_2663 var5) {
            return "status=" + var5.method_11470();
         }

         if (var1 instanceof class_7439 var2) {
            String var3 = var2.comp_763().getString();
            return var3.length() > 60 ? var3.substring(0, 60) : var3;
         }
      } catch (Throwable var4) {
      }

      return "";
   }

   private void method2134(String var1) {
      for (AuraDebug.DebugBox var3 : this.field1595) {
         if (var3.field0306 == null) {
            var3.field0306 = new ArrayList<>();
         }

         var3.field0306.add(var1);
      }

      AuraDebug.DebugBox var4 = this.field1584.peekLast();
      if (var4 != null && var4.field0311 == null) {
         var4.field0311 = method1024(var1, 40);
      }

      if (this.field0875.method1938()) {
         JsonObject var5 = new JsonObject();
         var5.addProperty("type", "chat_flag");
         var5.addProperty("ts", System.currentTimeMillis());
         var5.addProperty("absTick", this.field1130);
         var5.addProperty("msg", var1);
         this.method0943(var5);
      }

      AuraDebug.DebugBox var6 = new AuraDebug.DebugBox();
      var6.field0568 = ++this.field1113;
      var6.field0005 = System.currentTimeMillis();
      var6.field0287 = "CHAT_FLAG";
      var6.field1269 = "—";
      var6.field0311 = method1024(var1, 40);
      this.method2110(var6);
   }

   private void method1846(String var1) {
      if (this.field0875.method1938()) {
         JsonObject var2 = new JsonObject();
         var2.addProperty("type", "disconnect");
         var2.addProperty("ts", System.currentTimeMillis());
         var2.addProperty("absTick", this.field1130);
         var2.addProperty("reason", var1);
         this.method0943(var2);

         for (AuraDebug.DebugBox var4 : this.field1595) {
            var4.field0287 = "DISCONNECT";
            var4.field0244 = System.currentTimeMillis() - var4.field0005;
            this.method0943(this.method1833(var4));
         }
      }

      this.field1595.clear();
      AuraDebug.DebugBox var6 = new AuraDebug.DebugBox();
      var6.field0568 = ++this.field1113;
      var6.field0005 = System.currentTimeMillis();
      var6.field0287 = "DISCONNECT";
      var6.field1269 = "—";
      var6.field0311 = method1024(var1, 40);
      this.method2110(var6);

      try {
         if (this.field1169 != null) {
            this.field1169.flush();
         }
      } catch (IOException var5) {
      }
   }

   private void method1166(class_1309 var1, long var2) {
      AuraDebug.DebugBox var4 = new AuraDebug.DebugBox();
      var4.field0568 = ++this.field1113;
      var4.field0005 = var2;
      var4.field1412 = this.field1130;
      var4.field0959 = field0796.field_1687.method_8510();
      var4.field0759 = var1.method_5628();
      var4.field1269 = var1.method_5477().getString();
      class_243 var5 = var1.method_19538();
      var4.field0313 = var5.field_1352;
      var4.field0176 = var5.field_1351;
      var4.field0457 = var5.field_1350;
      class_243 var6 = var1.method_18798();
      var4.field1613 = var6.field_1352;
      var4.field1537 = var6.field_1351;
      var4.field1703 = var6.field_1350;
      var4.field1135 = field0796.field_1724.method_5739(var1);
      var4.field1087 = var1.method_6032();
      var4.field1196 = var1.method_6067();
      var4.field0872 = var1.field_6235;
      var4.field0826 = var1.field_6283;
      Rotation var7 = RotationHelper.method0545();
      Rotation var8 = RotationManager.field0618.method0545();
      Rotation var9 = RotationManager.field0618.method2258();
      Rotation var10 = RotationHelper.method1296(var1.method_33571().method_1020(field0796.field_1724.method_33571()));
      var4.field0910 = var7.method2047();
      var4.field1331 = var7.method1762();
      var4.field1292 = var8.method2047();
      var4.field1369 = var8.method1762();
      var4.field0385 = var9.method2047();
      var4.field0351 = var9.method1762();
      var4.field0423 = var10.method2047();
      var4.field0255 = var10.method1762();
      Rotation var11 = RotationHelper.method0872(var9, var10);
      var4.field0226 = var11.method2047();
      var4.field0289 = var11.method1762();
      if (!this.field1682.isEmpty()) {
         AuraDebug.DebugText var12 = this.field1682.peekLast();
         float var13 = RotationHelper.method0667(var9.method2047(), var12.field0314);
         float var14 = var9.method1762() - var12.field0177;
         var4.field0523 = var13;
         var4.field0501 = var14;
         float var15 = this.field0430.method0492();
         var4.field0558 = Math.abs(var13) > var15 || Math.abs(var14) > var15 * 0.6F;
      }

      var4.field1683 = field0796.field_1724.method_24828();
      var4.field1665 = field0796.field_1724.method_5624();
      var4.field1699 = field0796.field_1724.method_5715();
      var4.field1597 = field0796.field_1724.field_6017 > 0.0F;
      var4.field1601 = field0796.field_1724.field_6017;
      var4.field1586 = field0796.field_1724.method_6115();
      var4.field0899 = field0796.field_1724.method_7261(0.5F);
      var4.field1754 = field0796.field_1724.field_6235;
      var4.field1749 = field0796.field_1724.field_6252;
      var4.field1766 = field0796.field_1724.field_6251;
      var4.field1175 = field0796.field_1724.method_31548().field_7545;
      class_243 var22 = field0796.field_1724.method_18798();
      var4.field1163 = var22.field_1352;
      var4.field1185 = var22.field_1351;
      var4.field1118 = var22.field_1350;

      try {
         var4.field1112 = field0796.field_1724.field_3913 != null ? field0796.field_1724.field_3913.field_3905 : 0.0F;
         var4.field1129 = field0796.field_1724.field_3913 != null ? field0796.field_1724.field_3913.field_3907 : 0.0F;
         var4.field1233 = field0796.field_1690.field_1903.method_1434();
         var4.field1225 = field0796.field_1690.field_1867.method_1434();
         var4.field1239 = field0796.field_1690.field_1832.method_1434();
      } catch (Throwable var21) {
      }

      class_1799 var23 = field0796.field_1724.method_6047();
      var4.field0906 = var23.method_7909().toString();
      var4.field0897 = this.method0480();
      var4.field0863 = this.method0793(var4);
      var4.field1391 = this.field1220 > 0L ? var2 - this.field1220 : -1L;
      var4.field1404 = this.field1228 >= 0L ? this.field1130 - this.field1228 : -1L;
      this.field1220 = var2;
      this.field1228 = this.field1130;
      long var24 = var2 - 1000L;
      method1070(this.field1607, var24);
      method1070(this.field1759, var24);
      method1070(this.field1745, var24);
      method1070(this.field1771, var24);
      method1070(this.field1179, var24);
      var4.field0413 = this.field1607.size();
      var4.field0408 = this.field1759.size();
      var4.field0419 = this.field1745.size();
      var4.field0375 = this.field1771.size();
      var4.field0371 = this.field1179.size();

      try {
         Aura var16 = Aura.method1701();
         if (var16 != null) {
            var4.field0859 = String.valueOf(var16.method0524().method0492());
            if (var16.method0464() != null) {
               var4.field0851 = var16.method0464().method2067();
            }
         }
      } catch (Throwable var20) {
      }

      int var25 = this.field0234.method0492().intValue();
      Iterator var17 = this.field1682.descendingIterator();
      var4.field0381 = new ArrayList<>();

      for (int var18 = 0; var17.hasNext() && var18 < var25; var18++) {
         AuraDebug.DebugText var19 = var17.next();
         var4.field0381
            .add(
               0,
               new float[]{
                  var19.field0758,
                  var19.field1242,
                  var19.field0314,
                  var19.field0177,
                  var19.field1410,
                  var19.field0957,
                  (float)(var19.field0568 - var4.field0005),
                  (float)var19.field1086,
                  (float)var19.field1195,
                  (float)var19.field0870,
                  var19.field0826,
                  var19.field0931 ? 1.0F : 0.0F,
                  var19.field1574 ? 1.0F : 0.0F,
                  var19.field0497 ? 1.0F : 0.0F,
                  var19.field1161 ? 1.0F : 0.0F
               }
            );
      }

      if (this.field1296.method1938()) {
         var4.field0451 = new ArrayList<>(this.field1664);
         var4.field0446 = new ArrayList<>(this.field1697);
      }

      if (this.field1372.method1938()) {
         var4.field0455 = new ArrayList<>();
         this.method0794(var4, var1, 0);
         var4.field0280 = this.field1130 + this.field0295.method0492().longValue();
      }

      var4.field0276 = new ArrayList<>();
      var4.field0287 = "PENDING";
      this.field1595.add(var4);
   }

   private void method0457() {
      if (this.field1372.method1938()) {
         for (AuraDebug.DebugBox var2 : this.field1595) {
            if (this.field1130 <= var2.field0280 && field0796.field_1687 != null && field0796.field_1687.method_8469(var2.field0759) instanceof class_1309 var4
               )
             {
               this.method0794(var2, var4, (int)(this.field1130 - var2.field1412));
            }
         }
      }
   }

   private void method0794(AuraDebug.DebugBox var1, class_1309 var2, int var3) {
      class_243 var4 = var2.method_18798();
      var1.field0455
         .add(
            new float[]{
               var3,
               var2.method_6032(),
               var2.method_6067(),
               var2.field_6235,
               (float)var4.field_1352,
               (float)var4.field_1351,
               (float)var4.field_1350,
               var2.field_6283,
               var2.method_36454(),
               var2.method_36455()
            }
         );
   }

   private boolean method0480() {
      try {
         return field0796.field_1724.method_7261(0.5F) > 0.9F
            && field0796.field_1724.field_6017 > 0.0F
            && !field0796.field_1724.method_24828()
            && !field0796.field_1724.method_6101()
            && !field0796.field_1724.method_5799()
            && !field0796.field_1724.method_6059(class_1294.field_5919)
            && !field0796.field_1724.method_5765()
            && !field0796.field_1724.method_5624();
      } catch (Throwable var2) {
         return false;
      }
   }

   private float method0793(AuraDebug.DebugBox var1) {
      try {
         float var2 = (float)field0796.field_1724.method_45325(class_5134.field_23721);
         class_1799 var3 = field0796.field_1724.method_6047();
         float var4 = this.method1238(var3);
         int var5 = this.method0268(var3);
         float var6 = var5 > 0 ? 0.5F * var5 + 0.5F : 0.0F;
         float var7 = var2 + var4;
         float var8 = var1.field0899;
         float var9 = var7 * (0.2F + var8 * var8 * 0.8F);
         if (var1.field0897) {
            var9 *= 1.5F;
         }

         float var10 = var6 * var8;
         var1.field0941 = var2;
         var1.field0933 = var4;
         var1.field0949 = var5;
         var1.field1356 = var10;
         var1.field1351 = var1.field0897 ? 1.5F : 1.0F;
         return var9 + var10;
      } catch (Throwable var11) {
         return 0.0F;
      }
   }

   private float method1238(class_1799 var1) {
      if (var1 != null && !var1.method_7960()) {
         class_9285 var2 = (class_9285)var1.method_57824(class_9334.field_49636);
         if (var2 == null) {
            return 0.0F;
         }

         float[] var3 = new float[]{0.0F};

         try {
            var2.method_57482(class_1304.field_6173, (var1x, var2x) -> {
               if (var1x.comp_349() == class_5134.field_23721.comp_349()) {
                  var3[0] += (float)var2x.comp_2449();
               }
            });
         } catch (Throwable var5) {
         }

         return var3[0];
      } else {
         return 0.0F;
      }
   }

   private int method0268(class_1799 var1) {
      if (var1 != null && !var1.method_7960()) {
         try {
            class_9304 var2 = class_1890.method_57532(var1);

            for (class_6880 var4 : var2.method_57534()) {
               if ("minecraft:sharpness".equals(var4.method_55840())) {
                  return var2.method_57536(var4);
               }
            }
         } catch (Throwable var5) {
         }

         return 0;
      } else {
         return 0;
      }
   }

   private void method0405() {
      long var1 = System.currentTimeMillis();
      long var3 = this.field0360.method0492().longValue();
      float var5 = this.field0552.method0492();
      Iterator var6 = this.field1595.iterator();

      while (var6.hasNext()) {
         AuraDebug.DebugBox var7 = var6.next();
         class_1309 var9 = field0796.field_1687.method_8469(var7.field0759) instanceof class_1309 var10 ? var10 : null;
         if (var9 != null) {
            int var15 = var9.field_6235;
            if (!var7.field1328 && var15 >= 10 && var7.field1315 < 10) {
               var7.field1328 = true;
               var7.field1397 = this.field1130;
            }

            var7.field1315 = var15;
            if (var7.field1328 && this.field1130 >= var7.field1397 + 1L && var7.field0287.equals("PENDING")) {
               float var11 = var9.method_6032() + var9.method_6067();
               float var12 = var7.field1087 + var7.field1196;
               float var13 = var12 - var11;
               var7.field0244 = var1 - var7.field0005;
               var7.field0252 = (int)(this.field1130 - var7.field1412);
               if (var13 < -0.5F) {
                  var7.field0246 = 0.0F;
                  var7.field0287 = var7.field1367 ? "HIT_HEALED" : "HEALED";
               } else if (var13 <= 0.05F) {
                  var7.field0246 = 0.0F;
                  var7.field0287 = var7.field1367 ? "CUT" : "CANCELLED";
               } else {
                  var7.field0246 = var13;
                  boolean var14 = var7.field1367;
                  if (var7.field0863 > 0.0F && var13 < var7.field0863 * var5) {
                     var7.field0287 = var14 ? "CUT" : "CUT_UNCONFIRMED";
                  } else {
                     var7.field0287 = var14 ? "HIT" : "HIT_UNCONFIRMED";
                  }
               }

               if (this.field1372.method1938() && this.field1130 <= var7.field0280) {
                  var7.field0280 = this.field1130 + Math.min(8L, this.field0295.method0492().longValue());
               } else {
                  this.method0165(var7);
                  var6.remove();
               }
               continue;
            }
         } else {
            var7.field0309 = true;
         }

         if ((!this.field1372.method1938() || this.field1130 > var7.field0280 || var1 - var7.field0005 > var3 * 2L) && var1 - var7.field0005 > var3) {
            if (var7.field0287.equals("PENDING")) {
               var7.field0287 = var7.field0309 ? "TARGET_GONE" : "CANCELLED";
               var7.field0244 = var1 - var7.field0005;
               var7.field0252 = (int)(this.field1130 - var7.field1412);
            }

            if (!this.field1372.method1938() || this.field1130 > var7.field0280) {
               this.method0165(var7);
               var6.remove();
            }
         }
      }
   }

   private void method0165(AuraDebug.DebugBox var1) {
      this.method2110(var1);
      if (this.field0875.method1938()) {
         this.method0943(this.method1833(var1));
      }
   }

   private void method2110(AuraDebug.DebugBox var1) {
      this.field1584.addLast(var1);
      int var2 = this.field0262.method0492().intValue();

      while (this.field1584.size() > var2) {
         this.field1584.removeFirst();
      }
   }

   private JsonObject method1833(AuraDebug.DebugBox var1) {
      JsonObject var2 = new JsonObject();
      var2.addProperty("type", "attack");
      var2.addProperty("seq", var1.field0568);
      var2.addProperty("sendMs", var1.field0005);
      var2.addProperty("sendTickAbs", var1.field1412);
      var2.addProperty("gameTime", var1.field0959);
      var2.addProperty("outcome", var1.field0287);
      var2.addProperty("latencyMs", var1.field0244);
      var2.addProperty("latencyTicks", var1.field0252);
      var2.addProperty("msSinceLastAttack", var1.field1391);
      var2.addProperty("ticksSinceLastAttack", var1.field1404);
      var2.addProperty("attacksLastSec", var1.field0413);
      var2.addProperty("swingsLastSec", var1.field0408);
      var2.addProperty("sprintCmdsLastSec", var1.field0419);
      var2.addProperty("lookChangesLastSec", var1.field0375);
      var2.addProperty("slotChangesLastSec", var1.field0371);
      var2.addProperty("targetId", var1.field0759);
      var2.addProperty("target", var1.field1269);
      var2.addProperty("targetX", var1.field0313);
      var2.addProperty("targetY", var1.field0176);
      var2.addProperty("targetZ", var1.field0457);
      var2.addProperty("targetVelX", var1.field1613);
      var2.addProperty("targetVelY", var1.field1537);
      var2.addProperty("targetVelZ", var1.field1703);
      var2.addProperty("distance", var1.field1135);
      var2.addProperty("healthBefore", var1.field1087);
      var2.addProperty("absorptionBefore", var1.field1196);
      var2.addProperty("targetHurtTimeBefore", var1.field0872);
      var2.addProperty("targetBodyYawBefore", var1.field0826);
      var2.addProperty("expectedDamage", var1.field0863);
      var2.addProperty("actualDamage", var1.field0246);
      var2.addProperty("playerBaseDamage", var1.field0941);
      var2.addProperty("weaponBonusDamage", var1.field0933);
      var2.addProperty("sharpnessLevel", var1.field0949);
      var2.addProperty("enchantDamage", var1.field1356);
      var2.addProperty("critMultiplier", var1.field1351);
      var2.addProperty("damageConfirmedByEvent", var1.field1367);
      if (var1.field1322 != null) {
         var2.addProperty("damageType", var1.field1322);
      }

      var2.addProperty("cameraYaw", var1.field0910);
      var2.addProperty("cameraPitch", var1.field1331);
      var2.addProperty("currentYaw", var1.field1292);
      var2.addProperty("currentPitch", var1.field1369);
      var2.addProperty("serverYaw", var1.field0385);
      var2.addProperty("serverPitch", var1.field0351);
      var2.addProperty("idealYaw", var1.field0423);
      var2.addProperty("idealPitch", var1.field0255);
      var2.addProperty("deltaYaw", var1.field0226);
      var2.addProperty("deltaPitch", var1.field0289);
      var2.addProperty("prevTickServerYawDelta", var1.field0523);
      var2.addProperty("prevTickServerPitchDelta", var1.field0501);
      var2.addProperty("snapDetected", var1.field0558);
      var2.addProperty("onGround", var1.field1683);
      var2.addProperty("sprinting", var1.field1665);
      var2.addProperty("sneaking", var1.field1699);
      var2.addProperty("fallActive", var1.field1597);
      var2.addProperty("fallDistance", var1.field1601);
      var2.addProperty("usingItem", var1.field1586);
      var2.addProperty("hurtTime", var1.field1754);
      var2.addProperty("handSwinging", var1.field1749);
      var2.addProperty("swingProgress", var1.field1766);
      var2.addProperty("hotbarSlot", var1.field1175);
      var2.addProperty("velX", var1.field1163);
      var2.addProperty("velY", var1.field1185);
      var2.addProperty("velZ", var1.field1118);
      var2.addProperty("inputForward", var1.field1112);
      var2.addProperty("inputSide", var1.field1129);
      var2.addProperty("jumpKey", var1.field1233);
      var2.addProperty("sprintKey", var1.field1225);
      var2.addProperty("sneakKey", var1.field1239);
      var2.addProperty("cooldownProgress", var1.field0899);
      var2.addProperty("canCrit", var1.field0897);
      var2.addProperty("weapon", var1.field0906);
      if (var1.field0859 != null) {
         var2.addProperty("auraAimMode", var1.field0859);
      }

      if (var1.field0851 != null) {
         var2.addProperty("smoother", var1.field0851);
      }

      if (this.field1335.method1938() && var1.field0381 != null) {
         JsonArray var3 = new JsonArray();

         for (float[] var5 : var1.field0381) {
            JsonArray var6 = new JsonArray();

            for (float var10 : var5) {
               var6.add(var10);
            }

            var3.add(var6);
         }

         var2.add("trail", var3);
      }

      if (this.field1296.method1938() && var1.field0451 != null) {
         JsonArray var11 = new JsonArray();

         for (AuraDebug.DebugLine var21 : var1.field0451) {
            JsonObject var26 = new JsonObject();
            var26.addProperty("ts", var21.field0568);
            var26.addProperty("absTick", var21.field0005);
            var26.addProperty("name", var21.field1030);
            var26.addProperty("summary", var21.field0791);
            var11.add(var26);
         }

         var2.add("packetOut", var11);
      }

      if (this.field1296.method1938() && var1.field0446 != null) {
         JsonArray var12 = new JsonArray();

         for (AuraDebug.DebugLine var22 : var1.field0446) {
            JsonObject var27 = new JsonObject();
            var27.addProperty("ts", var22.field0568);
            var27.addProperty("absTick", var22.field0005);
            var27.addProperty("name", var22.field1030);
            var27.addProperty("summary", var22.field0791);
            var12.add(var27);
         }

         var2.add("packetIn", var12);
      }

      if (this.field1372.method1938() && var1.field0455 != null && !var1.field0455.isEmpty()) {
         JsonArray var13 = new JsonArray();

         for (float[] var23 : var1.field0455) {
            JsonArray var28 = new JsonArray();

            for (float var33 : var23) {
               var28.add(var33);
            }

            var13.add(var28);
         }

         var2.add("damageTimeline", var13);
      }

      if (var1.field0276 != null && !var1.field0276.isEmpty()) {
         JsonArray var14 = new JsonArray();

         for (AuraDebug.DebugFrame var24 : var1.field0276) {
            JsonObject var29 = new JsonObject();
            var29.addProperty("kind", var24.field0715);
            var29.addProperty("ts", var24.field0005);
            var29.addProperty("tickOffset", var24.field1411);
            if (var24.field1025 != null) {
               var29.add("data", var24.field1025);
            }

            var14.add(var29);
         }

         var2.add("targetEvents", var14);
      }

      if (var1.field0306 != null && !var1.field0306.isEmpty()) {
         JsonArray var15 = new JsonArray();

         for (String var25 : var1.field0306) {
            var15.add(var25);
         }

         var2.add("chatFlags", var15);
      }

      if (var1.field0311 != null) {
         var2.addProperty("chatFlag", var1.field0311);
      }

      return var2;
   }

   private static boolean method1376(class_2824 var0) {
      final boolean[] var1 = new boolean[]{false};
      var0.method_34209(new class_5908() {
         public void method_34219(class_1268 var1x) {
         }

         public void method_34220(class_1268 var1x, class_243 var2) {
         }

         public void method_34218() {
            var1[0] = true;
         }
      });
      return var1[0];
   }

   @EventHandler
   public void onRender2D(HudRenderEvent var1) {
      if (this.method2195() && field0796.field_1724 != null && field0796.field_1687 != null) {
         if (this.field1201.method1938()) {
            class_4587 var2 = var1.method1806().method_51448();
            FontSize var3 = Fonts.field0075.method0654(7.0F);
            FontSize var4 = Fonts.field0075.method0654(6.0F);
            Aura var5 = Aura.method1701();
            List var6 = this.method0792(var5);
            List var7 = this.method0396();
            float var8 = 6.0F;
            float var9 = 12.0F;
            float var10 = 9.0F;
            float var11 = 96.0F;
            float var12 = 270.0F;
            float var13 = var8 + var9 + var6.size() * var10 + 8.0F + (var7.size() + 1) * var10 + var8;
            float var14 = 4.0F;
            float var15 = 80.0F;
            GuiRenderHelper.method1463(var2, var14, var15, var12, var13, 4.0F, field0134);
            GuiRenderHelper.method1491(var2, var3, "aura debug v2", var14 + var8, var15 + var8, field1153);
            float var16 = var15 + var8 + var9;

            for (String[] var18 : var6) {
               GuiRenderHelper.method1491(var2, var4, var18[0], var14 + var8, var16, field1500);
               GuiRenderHelper.method1491(var2, var4, var18[1], var14 + var8 + var11, var16, method1983(var18[1]));
               var16 += var10;
            }

            var16 += 5.0F;
            GuiRenderHelper.method1491(var2, var4, "events:", var14 + var8, var16, field1726);
            var16 += var10;

            for (AuraDebug.DebugPoint var22 : var7) {
               GuiRenderHelper.method1491(var2, var4, var22.field0715, var14 + var8, var16, var22.field0134);
               GuiRenderHelper.method1491(var2, var4, var22.field1504, var14 + var8 + 56.0F, var16, field1026);
               var16 += var10;
            }
         }
      }
   }

   private List<String[]> method0792(Aura var1) {
      List var2 = new ArrayList<>();
      boolean var3 = var1 != null && var1.method2195();
      var2.add(new String[]{"aura", var3 ? "ON" : "OFF"});
      var2.add(new String[]{"collecting", this.method2030() ? "yes" : "no"});
      var2.add(new String[]{"pending", String.valueOf(this.field1595.size())});
      var2.add(new String[]{"session #", String.valueOf(this.field1113)});
      var2.add(new String[]{"tick", String.valueOf(this.field1130)});
      if (var1 != null && var1.method0409() != null) {
         class_1309 var4 = var1.method0409();
         String var5 = method1024(var4.method_5477().getString(), 14);
         var2.add(new String[]{"target", var5 + " " + String.format("%.2fm", field0796.field_1724.method_5739(var4))});
         var2.add(new String[]{"target hp", String.format("%.1f/%.1f", var4.method_6032(), var4.method_6063())});
         Rotation var6 = RotationManager.field0618.method2258();
         Rotation var7 = RotationHelper.method1296(var4.method_33571().method_1020(field0796.field_1724.method_33571()));
         Rotation var8 = RotationHelper.method0872(var6, var7);
         var2.add(new String[]{"srv->ideal", String.format("%.1f / %.1f", var8.method2047(), var8.method1762())});
         double var9 = RotationManager.method0871(var6, RotationHelper.method0545());
         var2.add(new String[]{"cam desync", String.format("%.2f", var9)});
      } else {
         var2.add(new String[]{"target", "none"});
      }

      try {
         AttackController var12 = DaamkyClient.method2004().method1881().method2051();
         if (var12 != null) {
            var2.add(new String[]{"hit count", String.valueOf(var12.method0414())});
            var2.add(new String[]{"since hit", var12.method2057().method0004() + "ms"});
         }
      } catch (Throwable var11) {
      }

      long var13 = System.currentTimeMillis() - 1000L;
      method1070(this.field1607, var13);
      method1070(this.field1759, var13);
      var2.add(new String[]{"atk/s · sw/s", this.field1607.size() + " · " + this.field1759.size()});
      var2.add(new String[]{"cooldown", String.format("%.0f%%", field0796.field_1724.method_7261(0.5F) * 100.0F)});
      var2.add(new String[]{"crit ready", this.method0480() ? "yes" : "no"});
      if (this.field1190 != null) {
         var2.add(new String[]{"log", this.field1190.getFileName().toString()});
      }

      return var2;
   }

   private List<AuraDebug.DebugPoint> method0396() {
      List var1 = new ArrayList<>();
      Iterator var2 = this.field1584.descendingIterator();

      while (var2.hasNext()) {
         AuraDebug.DebugBox var3 = var2.next();
         AuraDebug.DebugPoint var4 = new AuraDebug.DebugPoint();
         var4.field0715 = "[" + var3.field0287 + "]";
         var4.field0134 = method1654(var3.field0287);
         var4.field1504 = method1647(var3);
         var1.add(var4);
      }

      return var1;
   }

   private static String method1647(AuraDebug.DebugBox var0) {
      StringBuilder var1 = new StringBuilder();
      var1.append('#').append(var0.field0568).append(' ');
      if (var0.field1269 != null) {
         var1.append(method1024(var0.field1269, 8)).append(' ');
      }

      if (var0.field1135 > 0.0) {
         var1.append(String.format("d=%.1fm ", var0.field1135));
      }

      switch (var0.field0287) {
         case "HIT":
         case "CUT":
         case "HIT_UNCONFIRMED":
         case "CUT_UNCONFIRMED":
            var1.append(String.format("%.1f/%.1f (%dms)", var0.field0246, var0.field0863, var0.field0244));
            break;
         case "HIT_HEALED":
         case "HEALED":
            var1.append(String.format("hit ok, healed (exp %.1f)", var0.field0863));
            break;
         case "CANCELLED":
         case "TARGET_GONE":
         case "DISCONNECT":
         case "DISABLED":
            var1.append(String.format("exp %.1f", var0.field0863));
            break;
         case "PENDING":
            var1.append(String.format("exp %.1f wait", var0.field0863));
         case "CHAT_FLAG":
            break;
         default:
            var1.append('?');
      }

      if (var0.field0558) {
         var1.append(" SNAP");
      }

      if (var0.field0311 != null) {
         var1.append(" \"").append(var0.field0311).append('"');
      }

      return var1.toString();
   }

   private static String method1024(String var0, int var1) {
      if (var0 == null) {
         return "?";
      } else {
         return var0.length() > var1 ? var0.substring(0, var1) : var0;
      }
   }

   private static Color method1654(String var0) {
      return switch (var0) {
         case "HIT", "HIT_UNCONFIRMED" -> field0207;
         case "HIT_HEALED", "HEALED" -> field1726;
         case "CUT", "CUT_UNCONFIRMED" -> field1641;
         case "CANCELLED", "TARGET_GONE" -> field0486;
         case "DISCONNECT", "DISABLED" -> field1564;
         case "CHAT_FLAG" -> field1564;
         case "PENDING" -> field1500;
         default -> field1026;
      };
   }

   private static Color method1983(String var0) {
      if (var0 == null) {
         return field1026;
      }

      if (var0.equals("ON") || var0.equals("yes")) {
         return field0207;
      }

      if (var0.equals("OFF") || var0.equals("no") || var0.equals("none")) {
         return field0486;
      }

      if (var0.endsWith("%")) {
         try {
            float var1 = Float.parseFloat(var0.substring(0, var0.length() - 1).trim());
            if (var1 >= 90.0F) {
               return field0207;
            }

            if (var1 >= 50.0F) {
               return field1641;
            }

            return field0486;
         } catch (NumberFormatException var2) {
         }
      }

      return field1026;
   }

   private static class DebugPoint {
      String field0715;
      Color field0134;
      String field1504;
   }

   private static class DebugLine {
      long field0568;
      long field0005;
      boolean field1527;
      String field1030;
      String field0791;
   }

   private static class DebugBox {
      long field0568;
      long field0005;
      long field1412;
      long field0959;
      int field0759;
      String field1269;
      double field0313;
      double field0176;
      double field0457;
      double field1613;
      double field1537;
      double field1703;
      double field1135;
      float field1087;
      float field1196;
      int field0872;
      float field0826;
      float field0910;
      float field1331;
      float field1292;
      float field1369;
      float field0385;
      float field0351;
      float field0423;
      float field0255;
      float field0226;
      float field0289;
      float field0523;
      float field0501;
      boolean field0558;
      boolean field1683;
      boolean field1665;
      boolean field1699;
      boolean field1597;
      boolean field1586;
      float field1601;
      int field1754;
      boolean field1749;
      float field1766;
      int field1175;
      double field1163;
      double field1185;
      double field1118;
      float field1112;
      float field1129;
      boolean field1233;
      boolean field1225;
      boolean field1239;
      float field0899;
      boolean field0897;
      String field0906;
      String field0859;
      String field0851;
      float field0863;
      float field0941;
      float field0933;
      int field0949;
      float field1356;
      float field1351;
      boolean field1367;
      String field1322;
      int field1315;
      boolean field1328;
      long field1397;
      long field1391;
      long field1404;
      int field0413;
      int field0408;
      int field0419;
      int field0375;
      int field0371;
      List<float[]> field0381;
      List<AuraDebug.DebugLine> field0451;
      List<AuraDebug.DebugLine> field0446;
      List<float[]> field0455;
      long field0280;
      List<AuraDebug.DebugFrame> field0276;
      String field0287;
      float field0246;
      long field0244;
      int field0252;
      boolean field0309;
      List<String> field0306;
      String field0311;
   }

   private static class DebugText {
      long field0568;
      long field0005;
      float field1410;
      float field0957;
      float field0758;
      float field1242;
      float field0314;
      float field0177;
      boolean field0497;
      float field1614;
      boolean field1574;
      boolean field1735;
      boolean field1161;
      double field1086;
      double field1195;
      double field0870;
      float field0826;
      boolean field0931;
   }

   private static class DebugFrame {
      String field0715;
      long field0005;
      int field1411;
      JsonObject field1025;
   }
}
