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

public class ProxyStorage {
   private static final ProxyStorage field0677 = new ProxyStorage();
   private final List<ProxyEntry> field0139 = new ArrayList<>();
   private int field1411 = -1;
   private final Path field1031 = FabricLoader.getInstance().getGameDir().resolve("daamky").resolve("proxies.txt");

   private ProxyStorage() {
      this.method0430();
   }

   public ProxyEntry method0547() {
      return this.field1411 >= 0 && this.field1411 < this.field0139.size() ? this.field0139.get(this.field1411) : null;
   }

   public void method0729(int var1) {
      if (var1 >= -1 && var1 < this.field0139.size()) {
         this.field1411 = var1;
         this.method2078();
      }
   }

   public void method0025() {
      this.field1411 = -1;
      this.method2078();
   }

   public void method0907(ProxyEntry var1) {
      this.field0139.add(var1);
      this.method2078();
   }

   public void method0763(int var1, ProxyEntry var2) {
      if (var1 >= 0 && var1 < this.field0139.size()) {
         this.field0139.set(var1, var2);
         this.method2078();
      }
   }

   public void method0143(int var1) {
      if (var1 >= 0 && var1 < this.field0139.size()) {
         this.field0139.remove(var1);
         if (this.field1411 == var1) {
            this.field1411 = -1;
         } else if (this.field1411 > var1) {
            this.field1411--;
         }

         this.method2078();
      }
   }

   public void method2078() {
      try {
         Files.createDirectories(this.field1031.getParent());

         try (BufferedWriter var1 = Files.newBufferedWriter(this.field1031)) {
            var1.write("active=" + this.field1411);
            var1.newLine();

            for (ProxyEntry var3 : this.field0139) {
               var1.write(this.method0184(var3));
               var1.newLine();
            }
         }
      } catch (IOException var6) {
      }
   }

   private void method0430() {
      if (Files.exists(this.field1031)) {
         this.field0139.clear();
         this.field1411 = -1;

         try (BufferedReader var1 = Files.newBufferedReader(this.field1031)) {
            String var2;
            while ((var2 = var1.readLine()) != null) {
               if (!var2.isEmpty()) {
                  if (var2.startsWith("active=")) {
                     try {
                        this.field1411 = Integer.parseInt(var2.substring(7).trim());
                     } catch (NumberFormatException var5) {
                     }
                  } else {
                     ProxyEntry var3 = this.method1005(var2);
                     if (var3 != null) {
                        this.field0139.add(var3);
                     }
                  }
               }
            }

            if (this.field1411 >= this.field0139.size()) {
               this.field1411 = -1;
            }
         } catch (IOException var7) {
         }
      }
   }

   private String method0184(ProxyEntry var1) {
      return var1.method2060().method0557()
         + "|"
         + this.method0212(var1.method1791())
         + "|"
         + var1.method1604()
         + "|"
         + this.method0212(var1.method1961())
         + "|"
         + this.method0212(var1.method0423());
   }

   private ProxyEntry method1005(String var1) {
      String[] var2 = var1.split("\\|", -1);
      if (var2.length < 5) {
         return null;
      }

      try {
         ProxyType var3 = ProxyType.method1006(var2[0]);
         String var4 = var2[1];
         int var5 = Integer.parseInt(var2[2]);
         String var6 = var2[3];
         String var7 = var2[4];
         return new ProxyEntry(var3, var4, var5, var6, var7);
      } catch (NumberFormatException var8) {
         return null;
      }
   }

   private String method0212(String var1) {
      return var1 == null ? "" : var1.replace("|", "");
   }

   @Generated
   public static ProxyStorage method1786() {
      return field0677;
   }

   @Generated
   public List<ProxyEntry> method1620() {
      return this.field0139;
   }

   @Generated
   public int method1947() {
      return this.field1411;
   }
}
