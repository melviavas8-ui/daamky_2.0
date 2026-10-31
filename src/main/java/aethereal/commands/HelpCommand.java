package aethereal;

import net.minecraft.class_2561;

public final class HelpCommand extends Command {
   public HelpCommand() {
      super("help", "Display all available commands", "h", "?");
      this.method1013("Показать все доступные команды");
   }

   @Override
   public void method0800(CommandContext var1) {
      CommandManager var2 = DaamkyClient.method2004().method2257();
      String var3 = var2.method2067();
      var1.method0297(class_2561.method_43470("Available commands").method_27694(var0 -> var0.method_36139(11184810)));
      var2.method0018()
         .forEach(var2x -> var1.method0297(class_2561.method_43470(var3 + var2x.method0557()).method_27694(var0x -> var0x.method_36139(11184810))));
   }
}
