package aethereal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.class_2561;
import net.minecraft.class_310;

public final class StaffCommand extends Command implements MinecraftAccess {
   public StaffCommand() {
      super("staff", "Manage manual staff list", "sl");
      this.method1013("Управление ручным стафф-листом");
   }

   private StaffManager method1614() {
      return DaamkyClient.method2004().method0420();
   }

   @Override
   public void method0800(CommandContext var1) {
      String[] var2 = var1.method1814();
      if (var2.length == 0) {
         this.method1834(var1);
      } else {
         switch (var2[0].toLowerCase()) {
            case "add":
               this.method0803(var1, var2);
               break;
            case "del":
            case "remove":
               this.method0168(var1, var2);
               break;
            case "list":
               this.method0167(var1);
               break;
            case "clear":
               this.method2112(var1);
               break;
            default:
               this.method1834(var1);
         }
      }
   }

   private void method0803(CommandContext var1, String[] var2) {
      if (var2.length < 2) {
         var1.method0213(method1813() ? "Использование: .staff add <имя>" : "Usage: .staff add <name>");
      } else {
         String var3 = var2[1];
         if (var3.contains("|")) {
            var1.method0213(method1813() ? "Имя не может содержать '|'" : "Name cannot contain '|'");
         } else if (!this.method1614().method0214(var3)) {
            var1.method0213(method1813() ? "'" + var3 + "' уже в стафф-листе" : "'" + var3 + "' is already in staff list");
         } else {
            var1.method1013(method1813() ? "Добавлен в стафф: " + var3 : "Added to staff: " + var3);
         }
      }
   }

   private void method0168(CommandContext var1, String[] var2) {
      if (var2.length < 2) {
         var1.method0213(method1813() ? "Использование: .staff del <имя>" : "Usage: .staff del <name>");
      } else {
         String var3 = var2[1];
         if (!this.method1614().method2135(var3)) {
            var1.method0213(method1813() ? "'" + var3 + "' не найден в стафф-листе" : "'" + var3 + "' not found in staff list");
         } else {
            var1.method1013(method1813() ? "Удалён из стаффа: " + var3 : "Removed from staff: " + var3);
         }
      }
   }

   private void method0167(CommandContext var1) {
      List var2 = this.method1614().method0019();
      if (var2.isEmpty()) {
         var1.method2134(method1813() ? "стафф-лист пуст" : "Manual staff list is empty");
      } else {
         var1.method2134((method1813() ? "Персонал (" : "Manual staff (") + var2.size() + "):");

         for (StaffManager.StaffEntry var4 : var2) {
            var1.method0297(class_2561.method_43470("- " + var4.method0017()).method_27694(var0 -> var0.method_36139(11184810)));
         }
      }
   }

   private void method2112(CommandContext var1) {
      int var2 = this.method1614().method1763();
      var1.method1013(method1813() ? "Очищено: " + var2 : "Cleared: " + var2);
   }

   private void method1834(CommandContext var1) {
      String var2 = DaamkyClient.method2004().method2257().method2067();
      var1.method0297(class_2561.method_43470(method1813() ? "Команды стаффа:" : "Staff commands:").method_27694(var0 -> var0.method_36139(8947848)));
      var1.method0297(
         class_2561.method_43470(var2 + "staff add <" + (method1813() ? "имя" : "name") + ">")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(method1813() ? " - Добавить" : " - Add").method_27694(var0 -> var0.method_36139(7829367)))
      );
      var1.method0297(
         class_2561.method_43470(var2 + "staff del <" + (method1813() ? "имя" : "name") + ">")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(method1813() ? " - Удалить" : " - Remove").method_27694(var0 -> var0.method_36139(7829367)))
      );
      var1.method0297(
         class_2561.method_43470(var2 + "staff list")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(method1813() ? " - Показать список" : " - Show list").method_27694(var0 -> var0.method_36139(7829367)))
      );
      var1.method0297(
         class_2561.method_43470(var2 + "staff clear")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(method1813() ? " - Очистить" : " - Clear").method_27694(var0 -> var0.method_36139(7829367)))
      );
   }

   @Override
   public List<String> method1593(String[] var1) {
      if (var1.length <= 1) {
         String var7 = var1.length == 1 ? var1[0].toLowerCase() : "";
         return List.of("add", "del", "list", "clear").stream().filter(var1x -> var1x.startsWith(var7)).toList();
      }

      if (var1.length == 2 && var1[0].equalsIgnoreCase("add")) {
         String var6 = var1[1].toLowerCase();
         class_310 var8 = class_310.method_1551();
         return var8.method_1562() != null
            ? var8.method_1562()
               .method_2880()
               .stream()
               .map(var0 -> var0.method_2966().getName())
               .filter(var1x -> var1x.toLowerCase().startsWith(var6))
               .filter(var1x -> this.method1614().method1008(var1x) == null)
               .toList()
            : List.of();
      }

      if (var1.length == 2 && (var1[0].equalsIgnoreCase("del") || var1[0].equalsIgnoreCase("remove"))) {
         String var2 = var1[1].toLowerCase();
         List var3 = new ArrayList<>();

         for (StaffManager.StaffEntry var5 : this.method1614().method0019()) {
            if (var5.method0017().toLowerCase().startsWith(var2)) {
               var3.add(var5.method0017());
            }
         }

         return var3;
      } else {
         return List.of();
      }
   }

   @Override
   public String method2179(String[] var1) {
      if (var1.length == 2) {
         return switch (var1[0].toLowerCase()) {
            case "add", "del", "remove" -> method1813() ? "<имя>" : "<name>";
            default -> "";
         };
      } else {
         return "";
      }
   }

   @Override
   public Map<String, String> method0351(String[] var1) {
      if (var1.length <= 1) {
         return method1813()
            ? Map.of("add", "Добавить игрока в стафф-лист", "del", "Удалить", "list", "Показать список", "clear", "Очистить список")
            : Map.of("add", "Add a player to the staff list", "del", "Remove", "list", "Show list", "clear", "Clear list");
      } else {
         return Map.of();
      }
   }
}
