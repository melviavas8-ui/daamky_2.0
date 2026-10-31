package aethereal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.class_243;
import net.minecraft.class_2561;

public final class WaypointCommand extends Command implements MinecraftAccess {
   public WaypointCommand() {
      super("waypoint", "Manage waypoints", "wp");
      this.method1013("Управление вейпойнтами");
   }

   private WaypointManager method1616() {
      return DaamkyClient.method2004().method1956();
   }

   @Override
   public void method0800(CommandContext var1) {
      String[] var2 = var1.method1814();
      if (var2.length == 0) {
         this.method2112(var1);
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
               this.method2113(var1, var2);
               break;
            case "clear":
               this.method0167(var1);
               break;
            default:
               this.method2112(var1);
         }
      }
   }

   private void method0803(CommandContext var1, String[] var2) {
      if (var2.length < 2) {
         var1.method0213("Usage: .wp add <name> [x y z]");
      } else {
         String var3 = var2[1];
         if (var3.contains("|")) {
            var1.method0213("Name cannot contain '|'");
         } else if (field0796.field_1687 == null) {
            var1.method0213("Cannot add waypoint: not in a world");
         } else if (this.method1616().method1009(var3) != null) {
            var1.method0213("Waypoint '" + var3 + "' already exists here");
         } else {
            double var4;
            double var6;
            double var8;
            if (var2.length == 2) {
               if (field0796.field_1724 == null) {
                  var1.method0213("Cannot add waypoint: no player");
                  return;
               }

               var4 = field0796.field_1724.method_23317();
               var6 = field0796.field_1724.method_23318();
               var8 = field0796.field_1724.method_23321();
            } else {
               if (var2.length != 5) {
                  var1.method0213("Usage: .wp add <name> [x y z]");
                  return;
               }

               try {
                  var4 = Double.parseDouble(var2[2]);
                  var6 = Double.parseDouble(var2[3]);
                  var8 = Double.parseDouble(var2[4]);
               } catch (NumberFormatException var12) {
                  var1.method0213("Invalid coordinates");
                  return;
               }
            }

            int var10 = WaypointManager.method1947();
            WaypointManager.Waypoint var11 = new WaypointManager.Waypoint(
               var3, var4, var6, var8, var10, WaypointManager.method1791(), WaypointManager.method1619()
            );
            this.method1616().method0941(var11);
            var1.method1013(String.format("Added waypoint '%s' at %d %d %d", var3, (int)Math.floor(var4), (int)Math.floor(var6), (int)Math.floor(var8)));
         }
      }
   }

   private void method0168(CommandContext var1, String[] var2) {
      if (var2.length < 2) {
         var1.method0213("Usage: .wp del <name>");
      } else {
         String var3 = var2[1];
         if (!this.method1616().method0214(var3)) {
            var1.method0213("Waypoint '" + var3 + "' not found here");
         } else {
            var1.method1013("Removed waypoint '" + var3 + "'");
         }
      }
   }

   private void method2113(CommandContext var1, String[] var2) {
      boolean var3 = var2.length >= 2 && var2[1].equalsIgnoreCase("all");
      List var4;
      if (var3) {
         var4 = this.method1616().method2192();
      } else {
         var4 = this.method1616().method0424();
      }

      if (var4.isEmpty()) {
         var1.method2134(var3 ? "No waypoints saved" : "No waypoints in current world");
      } else {
         var1.method2134("Waypoints (" + var4.size() + "):");
         if (var3) {
            for (WaypointManager.Waypoint var6 : var4) {
               var1.method1846(
                  String.format(
                     "- [%s | %s] %s  %d %d %d",
                     var6.method1961(),
                     method2131(var6.method0423()),
                     var6.method0557(),
                     (int)Math.floor(var6.method0001()),
                     (int)Math.floor(var6.method2046()),
                     (int)Math.floor(var6.method1761())
                  )
               );
            }
         } else {
            for (WaypointManager.Waypoint var10 : var4) {
               long var7 = field0796.field_1724 == null
                  ? 0L
                  : Math.round(field0796.field_1724.method_19538().method_1022(new class_243(var10.method0001(), var10.method2046(), var10.method1761())));
               var1.method1846(
                  String.format(
                     "- %s  %d %d %d  (%dm)",
                     var10.method0557(),
                     (int)Math.floor(var10.method0001()),
                     (int)Math.floor(var10.method2046()),
                     (int)Math.floor(var10.method1761()),
                     var7
                  )
               );
            }
         }
      }
   }

   private void method0167(CommandContext var1) {
      int var2 = this.method1616().method0356();
      var1.method1013("Cleared " + var2 + " waypoint" + (var2 == 1 ? "" : "s"));
   }

   private static String method2131(String var0) {
      return switch (var0) {
         case "minecraft:overworld" -> "o";
         case "minecraft:the_nether" -> "n";
         case "minecraft:the_end" -> "e";
         default -> var0;
      };
   }

   @Override
   public List<String> method1593(String[] var1) {
      if (var1.length <= 1) {
         String var7 = var1.length == 1 ? var1[0].toLowerCase() : "";
         return List.of("add", "del", "list", "clear").stream().filter(var1x -> var1x.startsWith(var7)).toList();
      }

      if (var1.length != 2 || !var1[0].equalsIgnoreCase("del") && !var1[0].equalsIgnoreCase("remove")) {
         if (var1.length == 2 && var1[0].equalsIgnoreCase("list")) {
            String var6 = var1[1].toLowerCase();
            return "all".startsWith(var6) ? List.of("all") : List.of();
         } else {
            return List.of();
         }
      } else {
         String var2 = var1[1].toLowerCase();
         List var3 = new ArrayList<>();

         for (WaypointManager.Waypoint var5 : this.method1616().method0424()) {
            if (var5.method0557().toLowerCase().startsWith(var2)) {
               var3.add(var5.method0557());
            }
         }

         return var3;
      }
   }

   @Override
   public String method2179(String[] var1) {
      if (var1.length == 2) {
         return switch (var1[0].toLowerCase()) {
            case "add", "del", "remove" -> method1813() ? "<имя>" : "<name>";
            default -> "";
         };
      } else if (var1.length >= 3 && var1[0].equalsIgnoreCase("add")) {
         return switch (var1.length) {
            case 3 -> "<x> <y> <z>";
            case 4 -> "<y> <z>";
            case 5 -> "<z>";
            default -> "";
         };
      } else {
         return "";
      }
   }

   @Override
   public Map<String, String> method0351(String[] var1) {
      return var1.length <= 1
         ? Map.of("add", "Add waypoint at current position", "del", "Remove waypoint", "list", "Show waypoints", "clear", "Clear waypoints in current world")
         : Map.of();
   }

   private void method2112(CommandContext var1) {
      String var2 = DaamkyClient.method2004().method2257().method2067();
      var1.method0297(class_2561.method_43470("Waypoint commands:").method_27694(var0 -> var0.method_36139(8947848)));
      var1.method0297(
         class_2561.method_43470(var2 + "wp add <name> [x y z]")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(" - Add waypoint").method_27694(var0 -> var0.method_36139(7829367)))
      );
      var1.method0297(
         class_2561.method_43470(var2 + "wp del <name>")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(" - Remove waypoint").method_27694(var0 -> var0.method_36139(7829367)))
      );
      var1.method0297(
         class_2561.method_43470(var2 + "wp list [all]")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(" - Show waypoints").method_27694(var0 -> var0.method_36139(7829367)))
      );
      var1.method0297(
         class_2561.method_43470(var2 + "wp clear")
            .method_27694(var0 -> var0.method_36139(11184810))
            .method_10852(class_2561.method_43470(" - Clear current world's waypoints").method_27694(var0 -> var0.method_36139(7829367)))
      );
   }
}
