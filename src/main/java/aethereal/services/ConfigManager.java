package aethereal;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lombok.Generated;
import meteordevelopment.orbit.EventHandler;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_1041;
import net.minecraft.class_310;

public class ConfigManager {
   private static final int field0567 = 200;
   private static final String field0136 = "lastconfig";
   private final Path field1506;
   private String field1030 = "autosave";
   private boolean field0798 = false;
   private int field1243 = 0;

   public ConfigManager() {
      this.field1506 = FabricLoader.getInstance().getGameDir().resolve("daamky").resolve("cfg");

      try {
         Files.createDirectories(this.field1506);
      } catch (IOException var2) {
         System.err.println("Failed to create config directory: " + var2.getMessage());
      }
   }

   public void method0578() {
      DaamkyClient.method2004().method2072().subscribe(this);
   }

   @EventHandler
   private void onTick(PreTickEvent var1) {
      this.field1243++;
      if (this.field1243 >= 200) {
         this.field1243 = 0;
         this.method1812();
      }
   }

   public boolean method0026() {
      return this.field0798;
   }

   public void method1013(String var1) {
      if (!this.field0798) {
         class_1041 var2 = class_310.method_1551().method_22683();
         if (var2 != null && var2.method_4489() >= 1 && var2.method_4506() >= 1) {
            Path var3 = this.field1506.resolve(var1 + ".ab");
            Path var4 = this.field1506.resolve(var1 + ".ab.tmp");

            try (BufferedWriter var5 = Files.newBufferedWriter(var4)) {
               var5.write("[daamky-cfg]\n");
               var5.write("version = \"3.2\"\n");
               var5.write("name = \"" + var1 + "\"\n\n");

               for (Module var7 : DaamkyClient.method2004().method1783().method0019()) {
                  var5.write("[Module." + var7.method0423() + "]\n");
                  var5.write("enabled = " + var7.method2195() + "\n");
                  if (var7.method2259() != null && var7.method2259().method2048() != -1) {
                     var5.write("bind_key = " + var7.method2259().method2048() + "\n");
                     var5.write("bind_mouse = " + var7.method2259().method1813() + "\n");
                  }

                  for (Setting var9 : var7.method1914()) {
                     String var10 = this.method0934(var9);
                     if (var10 != null) {
                        var5.write(var9.method0423() + " = " + var10 + "\n");
                     }
                  }

                  var5.write("\n");
               }

               this.method0972(var5);
               this.method0199(var5);
               this.method2122(var5);
               this.method1651(var5);
               this.method1839(var5);
            } catch (IOException var16) {
               System.err.println("[ConfigManager] Failed to save config: " + var16.getMessage());
               var16.printStackTrace();

               try {
                  Files.deleteIfExists(var4);
               } catch (IOException var11) {
               }

               return;
            }

            try {
               Files.move(var4, var3, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            } catch (IOException var14) {
               try {
                  Files.move(var4, var3, StandardCopyOption.REPLACE_EXISTING);
               } catch (IOException var13) {
                  System.err.println("[ConfigManager] Failed to replace config: " + var13.getMessage());
                  return;
               }
            }

            this.field1030 = var1;
         }
      }
   }

   private void method0972(BufferedWriter var1) throws IOException {
      var1.write("[DraggablePositions]\n");
      HudWidgetManager var2 = HudWidgetManager.method1605();
      Map var3 = var2.method0560();
      float var4 = ScreenLayoutHelper.method2047();
      float var5 = ScreenLayoutHelper.method1762();
      if (var3.isEmpty()) {
         Map var6 = var2.method0425();
         Map var7 = var2.method0371();

         for (Entry var9 : var2.method1963().entrySet()) {
             float[] var10 = (float[])var9.getValue();
            boolean var11 = Math.abs(var10[0]) <= 2.0F && Math.abs(var10[1]) <= 2.0F;
            float var12 = var11 ? var10[0] : var10[0] / var4;
            float var13 = var11 ? var10[1] : var10[1] / var5;
             HudWidgetState.WidgetState var14 = (HudWidgetState.WidgetState)var6.get(var9.getKey());
             Boolean var15 = (Boolean)var7.get(var9.getKey());
            var1.write(
               String.format(
                  Locale.US,
                  "%s = [%.5f, %.5f, %s, %s]\n",
                  var9.getKey(),
                  var12,
                  var13,
                  var14 != null ? var14.name() : HudWidgetState.WidgetState.field0642.name(),
                  var15 != null && var15
               )
            );
         }
      } else {
          for (Object var18Object : var3.entrySet()) {
             Entry var18 = (Entry)var18Object;
             HudWidgetState var20 = (HudWidgetState)var18.getValue();
            var1.write(
               String.format(
                  Locale.US,
                  "%s = [%.5f, %.5f, %s, %s]\n",
                  var18.getKey(),
                  var20.method1946() / var4,
                  var20.method0413() / var5,
                  var20.method1885().name(),
                  var20.method2079()
               )
            );
         }
      }

      NewHUD var17 = DaamkyClient.method2004().method1783() != null ? DaamkyClient.method2004().method1783().method0976(NewHUD.class) : null;
      if (var17 != null) {
         float var19 = var17.method1679();
         if (!Float.isNaN(var19)) {
            var1.write(String.format(Locale.US, "__NewArmorHUD_centerX = %.2f\n", var19));
         }
      }

      var1.write("\n");
   }

   private void method0199(BufferedWriter var1) throws IOException {
      var1.write("[Theme]\n");
      var1.write("color = \"" + ThemeColorManager.method1908().method1884().name() + "\"\n");
      Color var2 = ThemeColorManager.method1908().method1726();
      var1.write(String.format("custom = [%d, %d, %d]\n", var2.getRed(), var2.getGreen(), var2.getBlue()));
      var1.write("themeSync = " + ThemeColorManager.method1908().method1938() + "\n");
      var1.write("\n");
   }

   private void method2122(BufferedWriter var1) throws IOException {
      var1.write("[Prefix]\n");
      var1.write("value = \"" + DaamkyClient.method2004().method2257().method2067() + "\"\n");
      var1.write("\n");
   }

   private void method1839(BufferedWriter var1) throws IOException {
      var1.write("[GuiSettings]\n");
      var1.write("language = \"" + ClickGuiDashboard.field0984.method0492().name() + "\"\n");
      var1.write("backgroundBlur = " + ClickGuiDashboard.field0598.method0492() + "\n");
      var1.write("blurStrength = " + ClickGuiDashboard.field0060.method0492() + "\n");
      var1.write("disableMenuBlur = " + ClickGuiDashboard.field1432.method0492() + "\n");
      var1.write("\n");
   }

   private void method1651(BufferedWriter var1) throws IOException {
      NewHUD var2 = DaamkyClient.method2004().method1783().method0976(NewHUD.class);
      if (var2 != null) {
         var1.write("[HudOrder]\n");
         var1.write("info = [" + var2.method2025().stream().map(var0 -> "\"" + var0 + "\"").collect(Collectors.joining(", ")) + "]\n");
         var1.write("\n");
      }
   }

   public boolean method0214(String var1) {
      Path var2 = this.field1506.resolve(var1 + ".ab");
      if (!Files.exists(var2)) {
         return false;
      }

      this.field0798 = true;
      HudWidgetManager.method1605().method0025();
      HudWidgetManager.method1605().method1963().clear();
      HudWidgetManager.method1605().method0425().clear();
      HudWidgetManager.method1605().method0371().clear();
      NewHUD var3 = DaamkyClient.method2004().method1783().method0976(NewHUD.class);
      if (var3 != null) {
         var3.method2015();
      }

      try (BufferedReader var4 = Files.newBufferedReader(var2)) {
         Module var6 = null;
         boolean var7 = false;
         boolean var8 = false;
         boolean var9 = false;
         boolean var10 = false;
         boolean var11 = false;
         String var12 = "3.0";

         String var5;
         while ((var5 = var4.readLine()) != null) {
            var5 = var5.trim();
            if (!var5.isEmpty() && !var5.startsWith("#")) {
               if (var5.startsWith("version = ")) {
                  var12 = var5.substring(10).replace("\"", "").trim();
               } else if (var5.equals("[DraggablePositions]")) {
                  var7 = true;
                  var8 = false;
                  var6 = null;
               } else if (var5.equals("[Theme]")) {
                  var8 = true;
                  var7 = false;
                  var9 = false;
                  var6 = null;
               } else if (var5.equals("[Prefix]")) {
                  var9 = true;
                  var8 = false;
                  var7 = false;
                  var10 = false;
                  var6 = null;
               } else if (var5.equals("[HudOrder]")) {
                  var10 = true;
                  var9 = false;
                  var8 = false;
                  var7 = false;
                  var11 = false;
                  var6 = null;
               } else if (var5.equals("[GuiSettings]")) {
                  var11 = true;
                  var10 = false;
                  var9 = false;
                  var8 = false;
                  var7 = false;
                  var6 = null;
               } else if (var5.startsWith("[Module.") && var5.endsWith("]")) {
                  String var28 = var5.substring(8, var5.length() - 1);
                  var6 = this.method1843(var28);
                  var7 = false;
                  var8 = false;
               } else if (var5.contains(" = ")) {
                  String[] var13 = var5.split(" = ", 2);
                  String var14 = var13[0].trim();
                  String var15 = var13[1].trim();
                  if (var7) {
                     this.method1045(var14, var15);
                  } else if (var8) {
                     this.method0218(var14, var15);
                  } else if (var9) {
                     this.method1658(var14, var15);
                  } else if (var10) {
                     this.method2139(var14, var15);
                  } else if (var11) {
                     this.method1849(var14, var15);
                  } else if (var6 != null) {
                     if (var14.equals("enabled")) {
                        var6.method2178(Boolean.parseBoolean(var15));
                     } else if (var14.equals("bind_key")) {
                        int var16 = Integer.parseInt(var15);
                        var6.method0881(new KeyBind(var16, var6.method2259() != null && var6.method2259().method1813()));
                     } else if (var14.equals("bind_mouse")) {
                        boolean var30 = Boolean.parseBoolean(var15);
                        int var17 = var6.method2259() != null ? var6.method2259().method2048() : -1;
                        var6.method0881(new KeyBind(var17, var30));
                     } else {
                        Setting var31 = this.method0892(var6, var14);
                        if (var31 != null) {
                           this.method0935(var31, var15, var12);
                        }
                     }
                  }
               }
            }
         }

         this.field1030 = var1;
         return true;
      } catch (IOException var25) {
         System.err.println("[ConfigManager] Failed to load config: " + var25.getMessage());
         var25.printStackTrace();
         return false;
      } finally {
         this.field0798 = false;
      }
   }

   private void method1045(String var1, String var2) {
      if (var1.equals("__NewArmorHUD_centerX")) {
         try {
            float var11 = Float.parseFloat(var2.trim());
            NewHUD var12 = DaamkyClient.method2004().method1783() != null ? DaamkyClient.method2004().method1783().method0976(NewHUD.class) : null;
            if (var12 != null) {
               var12.method0665(var11);
            }
         } catch (Exception var8) {
         }
      } else {
         try {
            String[] var3 = var2.replace("[", "").replace("]", "").split(",");
            if (var3.length >= 2) {
               float var4 = Float.parseFloat(var3[0].trim());
               float var5 = Float.parseFloat(var3[1].trim());
               HudWidgetManager var6 = HudWidgetManager.method1605();
               var6.method1018(var1, var4, var5);
               if (var3.length >= 3) {
                  try {
                     HudWidgetState.WidgetState var7 = HudWidgetState.WidgetState.valueOf(var3[2].trim());
                     var6.method1033(var1, var7);
                  } catch (IllegalArgumentException var9) {
                  }
               }

               if (var3.length >= 4) {
                  var6.method1062(var1, Boolean.parseBoolean(var3[3].trim()));
               }
            }
         } catch (Exception var10) {
            System.err.println("Failed to load draggable position for " + var1 + ": " + var10.getMessage());
         }
      }
   }

   private void method0218(String var1, String var2) {
      if (var1.equals("color")) {
         String var3 = var2.replace("\"", "");

         try {
            ThemeColorManager.PalettePreset var4 = ThemeColorManager.PalettePreset.valueOf(var3);
            ThemeColorManager.method1908().method0178(var4);
         } catch (IllegalArgumentException var7) {
            System.err.println("Unknown theme color: " + var3);
         }
      } else if (var1.equals("custom")) {
         String[] var8 = var2.replace("[", "").replace("]", "").split(",");
         if (var8.length == 3) {
            int var9 = Math.max(0, Math.min(255, Integer.parseInt(var8[0].trim())));
            int var5 = Math.max(0, Math.min(255, Integer.parseInt(var8[1].trim())));
            int var6 = Math.max(0, Math.min(255, Integer.parseInt(var8[2].trim())));
            ThemeColorManager.method1908().method0194(new Color(var9, var5, var6));
         }
      } else if (var1.equals("themeSync")) {
         ThemeColorManager.method1908().method1570(Boolean.parseBoolean(var2));
      }
   }

   private void method2139(String var1, String var2) {
      if (var1.equals("info")) {
         NewHUD var3 = DaamkyClient.method2004().method1783().method0976(NewHUD.class);
         if (var3 == null) {
            return;
         }

         String var4 = var2.replace("[", "").replace("]", "");
         String[] var5 = var4.split(",");
         List var6 = new ArrayList<>();

         for (String var10 : var5) {
            String var11 = var10.trim().replace("\"", "");
            if (!var11.isEmpty()) {
               var6.add(var11);
            }
         }

         if (!var6.isEmpty()) {
            var3.method2025().clear();
            var3.method2025().addAll(var6);
         }
      }
   }

   private void method1849(String var1, String var2) {
      Class var3 = ClickGuiDashboard.class;
      switch (var1) {
         case "language":
            String var6 = var2.replace("\"", "");

            try {
               ClickGuiDashboard.field0984.method2125(ClickGuiDashboard.Language.valueOf(var6));
            } catch (IllegalArgumentException var8) {
            }
            break;
         case "backgroundBlur":
            ClickGuiDashboard.field0598.method2125(Boolean.parseBoolean(var2));
            break;
         case "blurStrength":
            ClickGuiDashboard.field0060.method2125(Float.parseFloat(var2));
            break;
         case "disableMenuBlur":
            ClickGuiDashboard.field1432.method2125(Boolean.parseBoolean(var2));
      }
   }

   private void method1658(String var1, String var2) {
      if (var1.equals("value")) {
         String var3 = var2.replace("\"", "");
         if (!var3.isEmpty()) {
            DaamkyClient.method2004().method2257().method1846(var3);
         }
      }
   }

   public boolean method2135(String var1) {
      Path var2 = this.field1506.resolve(var1 + ".ab");

      try {
         boolean var3 = Files.deleteIfExists(var2);
         if (var3 && var1.equals(this.field1030)) {
            this.field1030 = "autosave";
            this.method1915();
         }

         return var3;
      } catch (IOException var4) {
         System.err.println("Failed to delete config: " + var4.getMessage());
         return false;
      }
   }

   public List<String> method2068() {
      try {
         return Files.list(this.field1506)
            .filter(var0 -> var0.toString().endsWith(".ab"))
            .map(var0 -> var0.getFileName().toString().replace(".ab", ""))
            .collect(Collectors.toList());
      } catch (IOException var2) {
         return new ArrayList<>();
      }
   }

   public void method1812() {
      if (!this.field0798) {
         this.method1013(this.field1030);
         this.method1915();
      }
   }

   public void method1634() {
      this.method1812();
   }

   public void method1973() {
      String var1 = this.method1888();
      if (var1 != null && this.method2068().contains(var1)) {
         this.method0214(var1);
      } else if (this.method2068().contains("autosave")) {
         this.method0214("autosave");
      }
   }

   public void method0430() {
      if (!this.field0798) {
         this.field0798 = true;

         try {
            ModuleManager var1 = DaamkyClient.method2004().method1783();
            NewHUD var2 = var1.method0976(NewHUD.class);
             for (Module var5 : var1.method0019()) {
                boolean var6 = var5 == var2;
               var5.method2178(var6);

               for (Setting var8 : var5.method1914()) {
                  var8.method0578();
               }
            }
         } finally {
            this.field0798 = false;
         }
      }
   }

   public void method0375() {
      if (!this.field0798) {
         ModuleManager var1 = DaamkyClient.method2004().method1783();

         for (Module var3 : var1.method0019()) {
            var3.method0881(new KeyBind(-1, false));
         }
      }
   }

   public void method0498() {
      this.method0430();
      this.method0375();
      ThemeColorManager.method1908().method0178(ThemeColorManager.PalettePreset.field1256);
      ThemeColorManager.method1908().method0194(new Color(4904608));
      ThemeColorManager.method1908().method1570(false);
      HudWidgetManager var1 = HudWidgetManager.method1605();
      var1.method0025();
      var1.method1963().clear();
      var1.method0425().clear();
      var1.method0371().clear();
      NewHUD var2 = DaamkyClient.method2004().method1783().method0976(NewHUD.class);
      if (var2 != null) {
         var2.method2015();
      }
   }

   private void method1915() {
      Path var1 = this.field1506.resolve("lastconfig");

      try {
         Files.writeString(var1, this.field1030);
      } catch (IOException var3) {
      }
   }

   private String method1888() {
      Path var1 = this.field1506.resolve("lastconfig");

      try {
         if (Files.exists(var1)) {
            return Files.readString(var1).trim();
         }
      } catch (IOException var3) {
      }

      return null;
   }

   private String method0934(Setting<?> var1) {
      Object var2 = var1.method0492();
      if (var1 instanceof BooleanSetting) {
         return String.valueOf(var2);
      } else if (var1 instanceof FloatSetting) {
         return String.valueOf(var2);
      } else if (var1 instanceof EnumSetting var3) {
         Object var14 = var3.method0492();
         String var15 = var14 instanceof DisplayNamed var10 ? var10.method0557() : var14.toString();
         return "\"" + var15 + "\"";
      } else if (var1 instanceof ColorSetting var4) {
         Color var13 = var4.method1687();
         String var9 = String.format("[%d, %d, %d, %d]", var13.getRed(), var13.getGreen(), var13.getBlue(), var13.getAlpha());
         if (var4.method1938()) {
            var9 = "theme:" + var9;
         }

         return var9;
      } else if (var1 instanceof MultiSelectSetting var5) {
         List var12 = var5.method0492().stream().map(var0 -> {
             String var11 = var0.method1888() != null ? var0.method1888() : var0.method0423();
             return var0.method0492() ? "\"" + var11 + "\"" : "\"!" + var11 + "\"";
         }).collect(Collectors.toList());
         return "[" + String.join(", ", var12) + "]";
      } else if (var1 instanceof KeyBindSetting var6) {
         KeyBind var11 = var6.method0492();
         return String.format("[%d, %b, %b]", var11.method2048(), var11.method1813(), var11.method1635());
      } else if (var1 instanceof BlockListSetting var7) {
         List var8 = var7.method1936();
         return "[" + var8.stream().map(var0 -> "\"" + var0 + "\"").collect(Collectors.joining(", ")) + "]";
      } else {
         return null;
      }
   }

   private void method0935(Setting<?> var1, String var2, String var3) {
      try {
         if (var1 instanceof BooleanSetting && !(var1 instanceof MultiSelectSetting)) {
            ((Setting<Boolean>)var1).method2125(Boolean.parseBoolean(var2));
         } else if (var1 instanceof FloatSetting var4) {
            ((Setting<Float>)var1).method2125(Float.parseFloat(var2));
         } else if (var1 instanceof EnumSetting var5) {
            String var10 = var2.replace("\"", "");
            this.method0835(var5, var10);
         } else if (var1 instanceof ColorSetting var6) {
            boolean var21 = var2.startsWith("theme:");
            String var11 = var21 ? var2.substring(6) : var2;
            String[] var12 = var11.replace("[", "").replace("]", "").split(",");
            if (var12.length == 4) {
               int var13 = Math.max(0, Math.min(255, Integer.parseInt(var12[0].trim())));
               int var14 = Math.max(0, Math.min(255, Integer.parseInt(var12[1].trim())));
               int var15 = Math.max(0, Math.min(255, Integer.parseInt(var12[2].trim())));
               int var16 = Math.max(0, Math.min(255, Integer.parseInt(var12[3].trim())));
               ((Setting<Color>)var1).method2125(new Color(var13, var14, var15, var16));
            }

            var6.method1570(var21);
         } else if (var1 instanceof MultiSelectSetting var7) {
            String var22 = var2.replace("[", "").replace("]", "").trim();
            Set var25 = new HashSet<>();
            Set var28 = new HashSet<>();
            boolean var31 = var3.compareTo("3.1") >= 0;
            if (!var22.isEmpty()) {
               String[] var34 = var22.split(",");

               for (String var18 : var34) {
                  String var19 = var18.trim().replace("\"", "");
                  if (!var19.isEmpty()) {
                     if (var19.startsWith("!")) {
                        if (var31) {
                           var28.add(var19.substring(1));
                        }
                     } else {
                        var25.add(var19);
                     }
                  }
               }
            }

            for (BooleanSetting var38 : var7.method0492()) {
               String var41 = var38.method1888();
               String var43 = var38.method0423();
               boolean var45 = var25.contains(var43) || var41 != null && var25.contains(var41);
               boolean var46 = var28.contains(var43) || var41 != null && var28.contains(var41);
               if (var45) {
                  var38.method2125(true);
               } else if (var46) {
                  var38.method2125(false);
               }
            }
         } else if (var1 instanceof KeyBindSetting var8) {
            String[] var23 = var2.replace("[", "").replace("]", "").split(",");
            if (var23.length >= 2) {
               int var26 = Integer.parseInt(var23[0].trim());
               boolean var29 = Boolean.parseBoolean(var23[1].trim());
               boolean var32 = var23.length >= 3 && Boolean.parseBoolean(var23[2].trim());
               var8.method2125(new KeyBind(var26, var29, var32));
            }
         } else if (var1 instanceof BlockListSetting var9) {
            String var24 = var2.replace("[", "").replace("]", "").trim();
            if (!var24.isEmpty()) {
               List var27 = new ArrayList<>();
               String[] var30 = var24.split(",");

               for (String var42 : var30) {
                  String var44 = var42.trim().replace("\"", "");
                  if (!var44.isEmpty()) {
                     var27.add(var44);
                  }
               }

               var9.method1074(var27);
            }
         }
      } catch (Exception var20) {
         System.err.println("Failed to deserialize setting " + var1.method0423() + ": " + var20.getMessage());
      }
   }

   private Module method1843(String var1) {
      return DaamkyClient.method2004().method1783().method0019().stream().filter(var1x -> var1x.method0423().equals(var1)).findFirst().orElse(null);
   }

   private Setting<?> method0892(Module var1, String var2) {
      return var1.method1914().stream().filter(var1x -> var1x.method0423().equals(var2)).findFirst().orElse(null);
   }

   private <V extends Enum<?>> void method0835(EnumSetting<V> var1, String var2) {
      for (Enum var6 : (Enum[])var1.method0492().getClass().getEnumConstants()) {
         if (var6 instanceof DisplayNamed var7 && var7.method0557().equalsIgnoreCase(var2)) {
             var1.method2125((V)var6);
            return;
         }
      }
   }

   @Generated
   public Path method2225() {
      return this.field1506;
   }

   @Generated
   public String method2191() {
      return this.field1030;
   }

   @Generated
   public int method2254() {
      return this.field1243;
   }
}
