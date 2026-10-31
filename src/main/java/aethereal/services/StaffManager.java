package aethereal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import lombok.Generated;
import net.fabricmc.loader.api.FabricLoader;

public class StaffManager implements MinecraftAccess {
   private final List<StaffManager.StaffEntry> field0719 = new ArrayList<>();

   public static StaffManager method0551() {
      return DaamkyClient.method2004().method0420();
   }

   public List<StaffManager.StaffEntry> method0019() {
      String var1 = WaypointManager.method1791();
      List var2 = new ArrayList<>();

      for (StaffManager.StaffEntry var4 : this.field0719) {
         if (var4.method0557().equalsIgnoreCase(var1)) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public Set<String> method2069() {
      Set var1 = new LinkedHashSet<>();

      for (StaffManager.StaffEntry var3 : this.method0019()) {
         var1.add(var3.method0017());
      }

      return var1;
   }

   public StaffManager.StaffEntry method1008(String var1) {
      String var2 = WaypointManager.method1791();

      for (StaffManager.StaffEntry var4 : this.field0719) {
         if (var4.method0557().equalsIgnoreCase(var2) && var4.method0017().equalsIgnoreCase(var1)) {
            return var4;
         }
      }

      return null;
   }

   public boolean method0214(String var1) {
      if (var1 == null || var1.isBlank()) {
         return false;
      }

      if (this.method1008(var1) != null) {
         return false;
      }

      this.field0719.add(new StaffManager.StaffEntry(WaypointManager.method1791(), var1));
      this.method1634();
      return true;
   }

   public boolean method2135(String var1) {
      StaffManager.StaffEntry var2 = this.method1008(var1);
      if (var2 == null) {
         return false;
      }

      this.field0719.remove(var2);
      this.method1634();
      return true;
   }

   public int method1763() {
      String var1 = WaypointManager.method1791();
      int var2 = this.field0719.size();
      this.field0719.removeIf(var1x -> var1x.method0557().equalsIgnoreCase(var1));
      int var3 = var2 - this.field0719.size();
      if (var3 > 0) {
         this.method1634();
      }

      return var3;
   }

   private Path method0369() {
      return FabricLoader.getInstance().getGameDir().resolve("daamky").resolve("staff").resolve("staff.ab");
   }

   public void method1634() {
      try {
         Path var1 = this.method0369();
         Files.createDirectories(var1.getParent());

         try (BufferedWriter var2 = Files.newBufferedWriter(var1)) {
            var2.write("[daamky-staff]\n");

            for (StaffManager.StaffEntry var4 : this.field0719) {
               if (var4.method0017() != null && !var4.method0017().isEmpty() && !var4.method0017().contains("|") && !var4.method0557().contains("|")) {
                  var2.write(var4.method0557());
                  var2.write(124);
                  var2.write(var4.method0017());
                  var2.write(10);
               }
            }
         }
      } catch (IOException var7) {
         System.err.println("[StaffListManager] Failed to save: " + var7.getMessage());
      }
   }

   public void method1973() {
      Path var1 = this.method0369();
      if (Files.exists(var1)) {
         this.field0719.clear();

         String var3;
         try (BufferedReader var2 = Files.newBufferedReader(var1)) {
            while ((var3 = var2.readLine()) != null) {
               var3 = var3.trim();
               if (!var3.isEmpty() && !var3.startsWith("[")) {
                  String[] var4 = var3.split("\\|", 2);
                  if (var4.length == 2) {
                     this.field0719.add(new StaffManager.StaffEntry(var4[0], var4[1]));
                  }
               }
            }
         } catch (IOException var7) {
            System.err.println("[StaffListManager] Failed to load: " + var7.getMessage());
         }
      }
   }

   @Generated
   public List<StaffManager.StaffEntry> method0424() {
      return this.field0719;
   }

   public record StaffEntry(String server, String name) {
      public String method0557() {
         return this.server;
      }

      public String method0017() {
         return this.name;
      }
   }
}
