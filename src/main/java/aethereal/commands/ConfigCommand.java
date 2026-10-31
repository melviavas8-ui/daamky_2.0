package aethereal;

import java.io.File;
import java.util.List;
import java.util.Map;
import net.minecraft.class_2561;

public final class ConfigCommand extends Command {
   public ConfigCommand() {
      super("config", "Manage configuration files", "cfg", "c");
      this.method1013("Управление файлами конфигурации");
   }

   private ConfigManager method1607() {
      return DaamkyClient.method2004().method2216();
   }

   @Override
   public void method0800(CommandContext var1) {
      String[] var2 = var1.method1814();
      if (var2.length == 0) {
         this.method1834(var1);
      } else {
         switch (var2[0].toLowerCase()) {
            case "save":
               this.method0168(var1, var2);
               break;
            case "load":
               this.method2113(var1, var2);
               break;
            case "list":
               this.method0167(var1);
               break;
            case "delete":
               this.method1835(var1, var2);
               break;
            case "folder":
               this.method2112(var1);
               break;
            case "reset":
               this.method0803(var1, var2);
               break;
            default:
               this.method1834(var1);
         }
      }
   }

   private void method0803(CommandContext var1, String[] var2) {
      if (var2.length < 2) {
         this.method1607().method0498();
         var1.method1013("Config reset to defaults");
      } else {
         switch (var2[1].toLowerCase()) {
            case "modules":
               this.method1607().method0430();
               var1.method1013("Modules and settings reset to defaults");
               break;
            case "binds":
               this.method1607().method0375();
               var1.method1013("All module binds cleared");
               break;
            default:
               var1.method0213("Usage: .config reset [modules|binds]");
         }
      }
   }

   private void method0168(CommandContext var1, String[] var2) {
      if (var2.length < 2) {
         var1.method0213("Usage: .config save <name>");
      } else {
         String var3 = var2[1];
         this.method1607().method1013(var3);
         var1.method1013("Config saved: " + var3);
      }
   }

   private void method2113(CommandContext var1, String[] var2) {
      if (var2.length < 2) {
         var1.method0213("Usage: .config load <name>");
      } else {
         String var3 = var2[1];
         if (this.method1607().method0214(var3)) {
            var1.method1013("Config loaded: " + var3);
         } else {
            var1.method0213("Config not found: " + var3);
         }
      }
   }

   private void method0167(CommandContext var1) {
      List var2 = this.method1607().method2068();
      if (var2.isEmpty()) {
         var1.method0213("No configs found");
      } else {
         var1.method2134("Available configs:");
         var2.forEach(var1x -> var1.method1846("- " + var1x));
      }
   }

   private void method1835(CommandContext var1, String[] var2) {
      if (var2.length < 2) {
         var1.method0213("Usage: .config delete <name>");
      } else {
         String var3 = var2[1];
         if (this.method1607().method2135(var3)) {
            var1.method1013("Config deleted: " + var3);
         } else {
            var1.method0213("Config not found: " + var3);
         }
      }
   }

   private void method2112(CommandContext var1) {
      try {
         File var2 = this.method1607().method2225().toFile();
         if (!var2.exists()) {
            var2.mkdirs();
         }

         Runtime.getRuntime().exec(new String[]{"explorer.exe", var2.getAbsolutePath()});
         var1.method1013("Config folder opened");
      } catch (Exception var3) {
         var1.method0213("Failed to open folder");
      }
   }

   @Override
   public List<String> method1593(String[] var1) {
      if (var1.length <= 1) {
         String var4 = var1.length == 1 ? var1[0].toLowerCase() : "";
         return List.of("save", "load", "list", "delete", "folder", "reset").stream().filter(var1x -> var1x.startsWith(var4)).toList();
      }

      if (var1.length != 2 || !var1[0].equalsIgnoreCase("load") && !var1[0].equalsIgnoreCase("delete")) {
         if (var1.length == 2 && var1[0].equalsIgnoreCase("reset")) {
            String var3 = var1[1].toLowerCase();
            return List.of("modules", "binds").stream().filter(var1x -> var1x.startsWith(var3)).toList();
         } else {
            return List.of();
         }
      } else {
         String var2 = var1[1].toLowerCase();
         return this.method1607().method2068().stream().filter(var1x -> var1x.toLowerCase().startsWith(var2)).toList();
      }
   }

   @Override
   public String method2179(String[] var1) {
      if (var1.length == 2) {
         return switch (var1[0].toLowerCase()) {
            case "save", "load", "delete" -> method1813() ? "<имя>" : "<name>";
            case "reset" -> "[modules|binds]";
            default -> "";
         };
      } else {
         return "";
      }
   }

   @Override
   public Map<String, String> method0351(String[] var1) {
      if (var1.length <= 1) {
         return Map.of(
            "save",
            "Save config",
            "load",
            "Load config",
            "list",
            "List configs",
            "delete",
            "Delete config",
            "folder",
            "Open config folder",
            "reset",
            "Reset config to defaults"
         );
      } else {
         return var1.length == 2 && var1[0].equalsIgnoreCase("reset") ? Map.of("modules", "Reset modules + settings", "binds", "Reset all binds") : Map.of();
      }
   }

   private void method1834(CommandContext var1) {
      var1.method0297(class_2561.method_43470("Available config commands:").method_27694(var0 -> var0.method_36139(8947848)));
      var1.method0297(
         class_2561.method_43470(".config save <name>")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(" - Save config").method_27694(var0 -> var0.method_36139(7829367)))
      );
      var1.method0297(
         class_2561.method_43470(".config load <name>")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(" - Load config").method_27694(var0 -> var0.method_36139(7829367)))
      );
      var1.method0297(
         class_2561.method_43470(".config list")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(" - List configs").method_27694(var0 -> var0.method_36139(7829367)))
      );
      var1.method0297(
         class_2561.method_43470(".config delete <name>")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(" - Delete config").method_27694(var0 -> var0.method_36139(7829367)))
      );
      var1.method0297(
         class_2561.method_43470(".config folder")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(" - Open config folder").method_27694(var0 -> var0.method_36139(7829367)))
      );
      var1.method0297(
         class_2561.method_43470(".config reset [modules|binds]")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(" - Reset config (full / modules+settings / binds)").method_27694(var0 -> var0.method_36139(7829367)))
      );
   }
}
