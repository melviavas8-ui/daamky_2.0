package aethereal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class CommandManager {
   private final Map<String, Command> field0720 = new ConcurrentHashMap<>();
   private String field0136;

   public CommandManager() {
      this(".");
   }

   public CommandManager(String var1) {
      this.field0136 = var1;
   }

   public void method0578() {
      this.method1589(
         new HelpCommand(), new ConfigCommand(), new PrefixCommand(), new FriendCommand(), new WaypointCommand(), new GpsCommand(), new StaffCommand()
      );
   }

   public void method1589(Command... var1) {
      for (Command var5 : var1) {
         this.method0849(var5);
      }
   }

   public void method0849(Command var1) {
      Objects.requireNonNull(var1, "Command cannot be null");
      this.field0720.put(var1.method0557().toLowerCase(), var1);
   }

   public void method1013(String var1) {
      this.field0720.remove(var1.toLowerCase());
   }

   public boolean method0214(String var1) {
      if (!var1.startsWith(this.field0136)) {
         return false;
      }

      String[] var2 = var1.substring(this.field0136.length()).trim().split("\\s+");
      if (var2.length != 0 && !var2[0].isEmpty()) {
         String var9 = var2[0];
         String[] var4 = Arrays.copyOfRange(var2, 1, var2.length);
         Optional var5 = this.method2133(var9);
         if (var5.isPresent()) {
            try {
               CommandContext var10 = new CommandContext(var5.get(), var9, var1, var4);
               var5.get().method0800(var10);
               return true;
            } catch (Exception var8) {
               CommandContext var7 = new CommandContext(null, var9, var1, var4);
               var7.method0213("Command execution error: " + var8.getMessage());
               return false;
            }
         } else {
            CommandContext var6 = new CommandContext(null, var9, var1, var4);
            var6.method0213("Unknown command");
            var6.method2134("Use 'help' command for available commands");
            return false;
         }
      } else {
         CommandContext var3 = new CommandContext(null, "", var1, new String[0]);
         var3.method2134("Use 'help' command for available commands");
         return true;
      }
   }

   public Collection<Command> method0018() {
      return Collections.unmodifiableCollection(this.field0720.values());
   }

   public Optional<Command> method2133(String var1) {
      return this.field0720.values().stream().filter(var1x -> var1x.method0214(var1)).findFirst();
   }

   public String method2067() {
      return this.field0136;
   }

   public void method1846(String var1) {
      this.field0136 = Objects.requireNonNull(var1, "Prefix cannot be null");
   }
}
