package aethereal;

import java.util.List;
import java.util.Map;
import net.minecraft.class_2561;
import net.minecraft.class_310;

public final class FriendCommand extends Command {
   public FriendCommand() {
      super("friend", "Manage friend list", "f", "friends");
      this.method1013("Управление списком друзей");
   }

   private FriendManager method1608() {
      return DaamkyClient.method2004().method1608();
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
            case "remove":
            case "del":
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
         var1.method0213("Usage: .friend add <name>");
      } else {
         String var3 = var2[1];
         if (this.method1608().method2135(var3)) {
            var1.method0213(var3 + " is already a friend");
         } else {
            this.method1608().method1013(var3);
            var1.method1013("Added friend: " + var3);
         }
      }
   }

   private void method0168(CommandContext var1, String[] var2) {
      if (var2.length < 2) {
         var1.method0213("Usage: .friend remove <name>");
      } else {
         String var3 = var2[1];
         if (!this.method1608().method2135(var3)) {
            var1.method0213(var3 + " is not a friend");
         } else {
            this.method1608().method0213(var3);
            var1.method1013("Removed friend: " + var3);
         }
      }
   }

   private void method0167(CommandContext var1) {
      List var2 = this.method1608().method0424();
      if (var2.isEmpty()) {
         var1.method2134("Friend list is empty");
      } else {
         var1.method2134("Friends (" + var2.size() + "):");
         var2.forEach(var1x -> var1.method1846("- " + var1x));
      }
   }

   private void method2112(CommandContext var1) {
      int var2 = this.method1608().method0424().size();
      this.method1608().method2078();
      var1.method1013("Cleared " + var2 + " friends");
   }

   @Override
   public List<String> method1593(String[] var1) {
      if (var1.length <= 1) {
         String var5 = var1.length == 1 ? var1[0].toLowerCase() : "";
         return List.of("add", "remove", "list", "clear").stream().filter(var1x -> var1x.startsWith(var5)).toList();
      }

      if (var1.length == 2 && var1[0].equalsIgnoreCase("add")) {
         String var4 = var1[1].toLowerCase();
         class_310 var3 = class_310.method_1551();
         return var3.method_1562() != null
            ? var3.method_1562()
               .method_2880()
               .stream()
               .map(var0 -> var0.method_2966().getName())
               .filter(var1x -> var1x.toLowerCase().startsWith(var4))
               .filter(var1x -> !this.method1608().method2135(var1x))
               .toList()
            : List.of();
      }

      if (var1.length != 2 || !var1[0].equalsIgnoreCase("remove") && !var1[0].equalsIgnoreCase("del")) {
         return List.of();
      }

      String var2 = var1[1].toLowerCase();
      return this.method1608().method0424().stream().filter(var1x -> var1x.toLowerCase().startsWith(var2)).toList();
   }

   @Override
   public String method2179(String[] var1) {
      if (var1.length == 2) {
         return switch (var1[0].toLowerCase()) {
            case "add", "remove", "del" -> method1813() ? "<имя>" : "<name>";
            default -> "";
         };
      } else {
         return "";
      }
   }

   @Override
   public Map<String, String> method0351(String[] var1) {
      return var1.length <= 1 ? Map.of("add", "Add friend", "remove", "Remove friend", "list", "Show friends", "clear", "Clear all friends") : Map.of();
   }

   private void method1834(CommandContext var1) {
      String var2 = DaamkyClient.method2004().method2257().method2067();
      var1.method0297(class_2561.method_43470("Friend commands:").method_27694(var0 -> var0.method_36139(8947848)));
      var1.method0297(
         class_2561.method_43470(var2 + "friend add <name>")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(" - Add friend").method_27694(var0 -> var0.method_36139(7829367)))
      );
      var1.method0297(
         class_2561.method_43470(var2 + "friend remove <name>")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(" - Remove friend").method_27694(var0 -> var0.method_36139(7829367)))
      );
      var1.method0297(
         class_2561.method_43470(var2 + "friend list")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(" - Show friends").method_27694(var0 -> var0.method_36139(7829367)))
      );
      var1.method0297(
         class_2561.method_43470(var2 + "friend clear")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(" - Clear all friends").method_27694(var0 -> var0.method_36139(7829367)))
      );
   }
}
