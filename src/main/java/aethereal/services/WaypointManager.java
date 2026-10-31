package aethereal;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import lombok.Generated;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_310;

public class WaypointManager implements MinecraftAccess {
   private final List<WaypointManager.Waypoint> field0719 = new ArrayList<>();
   private volatile WaypointManager.Waypoint field0133;

   public static WaypointManager method0552() {
      return DaamkyClient.method2004().method1956();
   }

   public WaypointManager.Waypoint method0014() {
      WaypointManager.Waypoint var1 = this.field0133;
      if (var1 == null) {
         return null;
      } else {
         return var1.method1961().equals(method1791()) && var1.method0423().equals(method1619()) ? var1 : null;
      }
   }

   public void method0615(double var1, double var3) {
      double var5 = field0796.field_1724 != null ? field0796.field_1724.method_23318() : 64.0;
      this.field0133 = new WaypointManager.Waypoint("", var1, var5, var3, method1947(), method1791(), method1619());
   }

   public boolean method2079() {
      boolean var1 = this.field0133 != null;
      this.field0133 = null;
      return var1;
   }

   public static String method1791() {
      class_310 var0 = class_310.method_1551();
      if (var0.method_1558() != null && var0.method_1558().field_3761 != null) {
         return var0.method_1558().field_3761.toLowerCase();
      }

      if (var0.method_1542() && var0.method_1576() != null) {
         try {
            String var1 = var0.method_1576().method_27728().method_27433().method_27339();
            return "sp:" + (var1 == null ? "unknown" : var1);
         } catch (Exception var2) {
            return "sp:unknown";
         }
      } else {
         return "unknown";
      }
   }

   public static String method1619() {
      class_310 var0 = class_310.method_1551();
      return var0.field_1687 == null ? "unknown" : var0.field_1687.method_27983().method_29177().toString();
   }

   public static int method1947() {
      float var0 = ThreadLocalRandom.current().nextFloat();
      Color var1 = Color.getHSBColor(var0, 0.9F, 0.95F);
      return var1.getRGB() & 16777215;
   }

   public List<WaypointManager.Waypoint> method0424() {
      String var1 = method1791();
      String var2 = method1619();
      List var3 = new ArrayList<>();

      for (WaypointManager.Waypoint var5 : this.field0719) {
         if (var5.method1961().equals(var1) && var5.method0423().equals(var2)) {
            var3.add(var5);
         }
      }

      return var3;
   }

   public WaypointManager.Waypoint method1009(String var1) {
      String var2 = method1791();
      String var3 = method1619();

      for (WaypointManager.Waypoint var5 : this.field0719) {
         if (var5.method1961().equals(var2) && var5.method0423().equals(var3) && var5.method0557().equalsIgnoreCase(var1)) {
            return var5;
         }
      }

      return null;
   }

   public boolean method0941(WaypointManager.Waypoint var1) {
      if (this.method1009(var1.method0557()) != null) {
         return false;
      }

      this.field0719.add(var1);
      this.method0498();
      return true;
   }

   public boolean method0214(String var1) {
      WaypointManager.Waypoint var2 = this.method1009(var1);
      if (var2 == null) {
         return false;
      }

      this.field0719.remove(var2);
      this.method0498();
      return true;
   }

   public int method0356() {
      String var1 = method1791();
      String var2 = method1619();
      int var3 = this.field0719.size();
      this.field0719.removeIf(var2x -> var2x.method1961().equals(var1) && var2x.method0423().equals(var2));
      int var4 = var3 - this.field0719.size();
      if (var4 > 0) {
         this.method0498();
      }

      return var4;
   }

   private Path method2262() {
      return FabricLoader.getInstance().getGameDir().resolve("daamky").resolve("waypoints").resolve("waypoints.ab");
   }

   public void method0498() {
      try {
         Path var1 = this.method2262();
         Files.createDirectories(var1.getParent());

         try (BufferedWriter var2 = Files.newBufferedWriter(var1)) {
            var2.write("[daamky-waypoints]\n");

            for (WaypointManager.Waypoint var4 : this.field0719) {
               var2.write(var4.method1961());
               var2.write(124);
               var2.write(method2131(var4.method0423()));
               var2.write(124);
               var2.write(var4.method0557());
               var2.write(124);
               var2.write(Double.toString(var4.method0001()));
               var2.write(124);
               var2.write(Double.toString(var4.method2046()));
               var2.write(124);
               var2.write(Double.toString(var4.method1761()));
               var2.write(124);
               var2.write(String.format("%06X", var4.method1604() & 16777215));
               var2.write(10);
            }
         }
      } catch (IOException var7) {
         System.err.println("[WaypointManager] Failed to save: " + var7.getMessage());
      }
   }

   public void method2228() {
      Path var1 = this.method2262();
      if (Files.exists(var1)) {
         this.field0719.clear();

         String var3;
         try (BufferedReader var2 = Files.newBufferedReader(var1)) {
            while ((var3 = var2.readLine()) != null) {
               var3 = var3.trim();
               if (!var3.isEmpty() && !var3.startsWith("[")) {
                  String[] var4 = var3.split("\\|", 7);
                  if (var4.length == 7) {
                     try {
                        String var5 = var4[0];
                        String var6 = method1844(var4[1]);
                        String var7 = var4[2];
                        double var8 = Double.parseDouble(var4[3]);
                        double var10 = Double.parseDouble(var4[4]);
                        double var12 = Double.parseDouble(var4[5]);
                        int var14 = Integer.parseInt(var4[6], 16) & 16777215;
                        this.field0719.add(new WaypointManager.Waypoint(var7, var8, var10, var12, var14, var5, var6));
                     } catch (Exception var16) {
                     }
                  }
               }
            }
         } catch (IOException var18) {
            System.err.println("[WaypointManager] Failed to load: " + var18.getMessage());
         }
      }
   }

   static String method2131(String var0) {
      return switch (var0) {
         case "minecraft:overworld" -> "o";
         case "minecraft:the_nether" -> "n";
         case "minecraft:the_end" -> "e";
         default -> "*" + var0;
      };
   }

   static String method1844(String var0) {
      return switch (var0) {
         case "o" -> "minecraft:overworld";
         case "n" -> "minecraft:the_nether";
         case "e" -> "minecraft:the_end";
         default -> var0.startsWith("*") ? var0.substring(1) : var0;
      };
   }

   @Generated
   public List<WaypointManager.Waypoint> method2192() {
      return this.field0719;
   }

   public record Waypoint(String name, double x, double y, double z, int color, String server, String dimension) {
      public String method0557() {
         return this.name;
      }

      public double method0001() {
         return this.x;
      }

      public double method2046() {
         return this.y;
      }

      public double method1761() {
         return this.z;
      }

      public int method1604() {
         return this.color;
      }

      public String method1961() {
         return this.server;
      }

      public String method0423() {
         return this.dimension;
      }
   }
}
