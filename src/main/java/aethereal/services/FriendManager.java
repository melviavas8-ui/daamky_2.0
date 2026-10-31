package aethereal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_1297;
import net.minecraft.class_1657;

public class FriendManager {
   private final List<String> field0719 = new ArrayList<>();

   public static FriendManager method0538() {
      return DaamkyClient.method2004().method1608();
   }

   private Path method0369() {
      return FabricLoader.getInstance().getGameDir().resolve("daamky").resolve("friends").resolve("friends.ab");
   }

   public String method0017() {
      return "friends";
   }

   public void method1013(String var1) {
      if (!var1.isEmpty() && !this.method2135(var1)) {
         this.field0719.add(var1);
         this.method1634();
      }
   }

   public void method0213(String var1) {
      if (this.field0719.removeIf(var1x -> var1x.equalsIgnoreCase(var1))) {
         this.method1634();
      }
   }

   public void method2078() {
      this.field0719.clear();
      this.method1634();
   }

   public boolean method2135(String var1) {
      return this.field0719.stream().anyMatch(var1x -> var1x.equalsIgnoreCase(var1));
   }

   public boolean method1129(class_1297 var1) {
      return var1 instanceof class_1657 var2 ? this.method2135(var2.method_5477().getString()) : false;
   }

   public boolean method1813() {
      return this.field0719.isEmpty();
   }

   public void method1634() {
      try {
         Path var1 = this.method0369();
         Files.createDirectories(var1.getParent());

         try (BufferedWriter var2 = Files.newBufferedWriter(var1)) {
            var2.write("[daamky-friends]\n");

            for (String var4 : this.field0719) {
               var2.write(var4 + "\n");
            }
         }
      } catch (IOException var7) {
         System.err.println("[FriendManager] Failed to save friends: " + var7.getMessage());
      }
   }

   public void method1973() {
      Path var1 = this.method0369();
      if (Files.exists(var1)) {
         try (BufferedReader var2 = Files.newBufferedReader(var1)) {
            boolean var4 = false;
            this.field0719.clear();

            String var3;
            while ((var3 = var2.readLine()) != null) {
               var3 = var3.trim();
               if (var3.equals("[daamky-friends]")) {
                  var4 = true;
               } else if (var4 && !var3.isEmpty()) {
                  this.field0719.add(var3);
               }
            }
         } catch (IOException var7) {
            System.err.println("[FriendManager] Failed to load friends: " + var7.getMessage());
         }
      }
   }

   @Generated
   public List<String> method0424() {
      return this.field0719;
   }
}
