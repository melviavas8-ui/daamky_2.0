package aethereal;

import lombok.Generated;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_266;
import net.minecraft.class_268;
import net.minecraft.class_269;
import net.minecraft.class_2761;
import net.minecraft.class_3532;
import net.minecraft.class_640;
import net.minecraft.class_8646;
import net.minecraft.class_9011;
import org.apache.commons.lang3.StringUtils;
import ua.patch.daamky.api.mixins.accessors.IBossBarHud;

public final class ServerEnvironment implements MinecraftAccess {
   private static final Stopwatch field1634 = new Stopwatch();
   public static String field0715 = "Vanilla";
   public static float field0003 = 20.0F;
   public static long field1412;
   public static int field0958 = -1;
   public static boolean field0219;
   public static int field0459 = 0;
   private static boolean field1574 = false;

   public static void method0578() {
      if (!field1574) {
         field1574 = true;
         DaamkyClient.method2004().method2072().subscribe(new ServerEnvironment.PacketListener());
      }
   }

   public static void method0025() {
      if (field0796.field_1687 == null) {
         field0715 = "Vanilla";
         field0958 = -1;
         field0459 = 0;
      } else {
         field0958 = method1698();
         field0715 = method1791();
         field0219 = method1755();
         if (method1692()) {
            field1634.method1812();
         }

         if (method0499()) {
            field0459 = method1929();
         }
      }
   }

   public static void method0903(PacketEvent var0) {
      if (var0.method1970() instanceof class_2761) {
         long var1 = System.nanoTime();
         float var3 = 20.0F;
         if (field1412 > 0L) {
            float var4 = var3 * (1.0E9F / (float)(var1 - field1412));
            field0003 = class_3532.method_15363(var4, 0.0F, var3);
         }

         field1412 = var1;
      }
   }

   public static int method2048() {
      if (method0499() && field0459 > 0) {
         return field0459;
      } else if (field0796.field_1724 != null && field0796.method_1562() != null) {
         class_640 var0 = field0796.method_1562().method_2871(field0796.field_1724.method_5667());
         return var0 != null ? var0.method_2959() : 0;
      } else {
         return 0;
      }
   }

   private static int method1929() {
      if (field0796.field_1687 == null) {
         return 0;
      }

      class_269 var0 = field0796.field_1687.method_8428();
      class_266 var1 = var0.method_1189(class_8646.field_45157);
      if (var1 == null) {
         return field0459;
      }

      try {
         for (class_9011 var3 : var0.method_1184(var1)) {
            String var4 = class_268.method_1142(var0.method_1164(var3.comp_2127()), var3.method_55387()).getString();
            String var5 = var4.toLowerCase();
            if (var5.contains("пинг") || var5.contains("ping")) {
               int var6 = var4.indexOf(58);
               if (var6 != -1) {
                  String var7 = var4.substring(var6 + 1);
                  StringBuilder var8 = new StringBuilder();

                  for (char var12 : var7.toCharArray()) {
                     if (var12 >= '0' && var12 <= '9') {
                        var8.append(var12);
                     } else if (var8.length() > 0) {
                        break;
                     }
                  }

                  if (var8.length() > 0) {
                     return Integer.parseInt(var8.toString());
                  }
               }
            }
         }
      } catch (Exception var13) {
      }

      return field0459;
   }

   public static String method1791() {
      if (field0796.field_1724 != null
         && field0796.field_1687 != null
         && field0796.method_1562() != null
         && field0796.method_1562().method_45734() != null
         && field0796.method_1562().method_52790() != null) {
         String var0 = field0796.method_1562().method_45734().field_3761.toLowerCase();
         String var1 = field0796.method_1562().method_52790().toLowerCase();
         if (var1.contains("botfilter")) {
            return "FunTime";
         } else if (var1.contains("§6spooky§ccore")) {
            return "SpookyTime";
         } else if (var0.contains("funtime") || var0.contains("skytime") || var0.contains("space-times") || var0.contains("funsky")) {
            return "CopyTime";
         } else if (var1.contains("holyworld") || var1.contains("vk.com/idwok")) {
            return "HolyWorld";
         } else if (var0.contains("reallyworld")) {
            return "ReallyWorld";
         } else {
            return var0.contains("gulpvp") ? "GulPvP" : "Vanilla";
         }
      } else {
         return "Vanilla";
      }
   }

   private static int method1698() {
      if (field0796.field_1687 == null) {
         return -1;
      }

      class_269 var0 = field0796.field_1687.method_8428();
      class_266 var1 = var0.method_1189(class_8646.field_45157);

      try {
         switch (field0715) {
            case "FunTime":
               if (var1 != null) {
                  String[] var9 = var1.method_1114().getString().split("-");
                  if (var9.length > 1) {
                     return Integer.parseInt(var9[1]);
                  }
               }
               break;
            case "HolyWorld":
               if (var1 != null) {
                  for (class_9011 var5 : var0.method_1184(var1)) {
                     String var6 = class_268.method_1142(var0.method_1164(var5.comp_2127()), var5.method_55387()).getString();
                     if (!var6.isEmpty()) {
                        String var7 = StringUtils.substringBetween(var6, "#", " -◆-");
                        if (var7 != null && !var7.isEmpty()) {
                           return Integer.parseInt(var7.replace(" (1.20)", "").trim());
                        }
                     }
                  }
               }
         }
      } catch (Exception var8) {
      }

      return -1;
   }

   public static boolean method1635() {
      return !field1634.method0779(500L);
   }

   private static boolean method1692() {
      return field0796.field_1705 == null
         ? false
         : ((IBossBarHud)field0796.field_1705.method_1740())
            .getBossBars()
            .values()
            .stream()
            .map(var0 -> var0.method_5414().getString().toLowerCase())
            .anyMatch(var0 -> var0.contains("pvp") || var0.contains("пвп"));
   }

   private static boolean method1755() {
      return field0796.field_1705 == null
         ? false
         : ((IBossBarHud)field0796.field_1705.method_1740())
            .getBossBars()
            .values()
            .stream()
            .map(var0 -> var0.method_5414().getString().toLowerCase())
            .anyMatch(var0 -> (var0.contains("pvp") || var0.contains("пвп")) && (var0.contains("0") || var0.contains("1")));
   }

   public static String method1961() {
      return field0796.field_1687 != null ? field0796.field_1687.method_27983().method_29177().method_12832() : "unknown";
   }

   public static boolean method0431() {
      return field0715.equals("CopyTime") || field0715.equals("SpookyTime") || field0715.equals("FunTime");
   }

   public static boolean method0376() {
      return field0715.equals("FunTime");
   }

   public static boolean method0499() {
      return field0715.equals("ReallyWorld");
   }

   public static boolean method2229() {
      return field0715.equals("HolyWorld");
   }

   public static boolean method2195() {
      return field0715.equals("SpookyTime");
   }

   public static boolean method2267() {
      return field0715.equals("Vanilla");
   }

   @Generated
   private ServerEnvironment() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   @Generated
   public static int method1902() {
      return field0958;
   }

   @Generated
   public static boolean method1891() {
      return field0219;
   }

   public static final class PacketListener implements MinecraftAccess {
      @EventHandler
      public void onTick(PreTickEvent var1) {
         ServerEnvironment.method0025();
      }

      @EventHandler
      public void onPacket(PacketEvent.Inbound var1) {
         ServerEnvironment.method0903(var1);
      }
   }
}
