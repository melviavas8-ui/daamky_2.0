package aethereal;

public final class PrefixCommand extends Command {
   public PrefixCommand() {
      super("prefix", "Change command prefix", "p");
      this.method1013("Изменить префикс команд");
   }

   @Override
   public void method0800(CommandContext var1) {
      String[] var2 = var1.method1814();
      if (var2.length == 0) {
         String var4 = DaamkyClient.method2004().method2257().method2067();
         var1.method2134("Current prefix: " + var4);
         var1.method2134("Usage: .prefix <new_prefix>");
      } else {
         String var3 = var2[0];
         DaamkyClient.method2004().method2257().method1846(var3);
         var1.method1013("Prefix changed to: " + var3);
      }
   }

   @Override
   public String method2179(String[] var1) {
      if (var1.length <= 1 && (var1.length == 0 || var1[0].isEmpty())) {
         return method1813() ? "<новый префикс>" : "<new prefix>";
      } else {
         return "";
      }
   }
}
