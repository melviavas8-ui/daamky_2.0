package aethereal;

import java.util.List;

public final class GpsCommand extends Command implements MinecraftAccess {
   public GpsCommand() {
      super("gps", "Quick unnamed waypoint at given X Z");
      this.method1013("Быстрая безымянная метка по X Z");
   }

   @Override
   public void method0800(CommandContext var1) {
      String[] var2 = var1.method1814();
      if (var2.length == 0) {
         this.method0167(var1);
      } else {
         String var3 = var2[0].toLowerCase();
         if (!var3.equals("clear") && !var3.equals("off") && !var3.equals("del") && !var3.equals("remove")) {
            if (var2.length < 2) {
               this.method0167(var1);
            } else if (field0796.field_1687 == null) {
               var1.method0213(method1813() ? "Не в мире" : "Not in a world");
            } else {
               double var6;
               double var10;
               try {
                  var10 = Double.parseDouble(var2[0]);
                  var6 = Double.parseDouble(var2[1]);
               } catch (NumberFormatException var9) {
                  var1.method0213(method1813() ? "Неверные координаты" : "Invalid coordinates");
                  return;
               }

               DaamkyClient.method2004().method1956().method0615(var10, var6);
               var1.method1013(String.format(method1813() ? "GPS-метка: %d, %d" : "GPS target: %d, %d", (int)Math.floor(var10), (int)Math.floor(var6)));
            }
         } else {
            boolean var4 = DaamkyClient.method2004().method1956().method2079();
            if (var4) {
               var1.method1013(method1813() ? "GPS-метка снята" : "GPS target cleared");
            } else {
               var1.method0213(method1813() ? "GPS-метка не была установлена" : "No GPS target set");
            }
         }
      }
   }

   private void method0167(CommandContext var1) {
      String var2 = DaamkyClient.method2004().method2257().method2067();
      var1.method2134(
         method1813() ? "Использование: " + var2 + "gps <x> <z>  |  " + var2 + "gps clear" : "Usage: " + var2 + "gps <x> <z>  |  " + var2 + "gps clear"
      );
   }

   @Override
   public String method2179(String[] var1) {
      return switch (var1.length) {
         case 1 -> "<x> <z>";
         case 2 -> "<z>";
         default -> "";
      };
   }

   @Override
   public List<String> method1593(String[] var1) {
      if (var1.length == 1) {
         String var2 = var1[0].toLowerCase();
         return "clear".startsWith(var2) ? List.of("clear") : List.of();
      } else {
         return List.of();
      }
   }
}
