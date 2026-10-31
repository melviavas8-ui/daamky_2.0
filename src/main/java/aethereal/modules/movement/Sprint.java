package aethereal;

import meteordevelopment.orbit.EventHandler;

public class Sprint extends Module {
   public static int field0004;
   private final EnumSetting<Sprint.Mode> field1448 = new EnumSetting<>("sprint.mode", Sprint.Mode.field0690)
      .method1007("Mode")
      .method0210("Sprint activation method")
      .method2130("Метод активации спринта");

   public Sprint() {
      super("Sprint", ModuleCategory.field0088, "Automatically enables sprinting");
      this.method1013("Автоматически включает бег");
   }

   public static Sprint method1720() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(Sprint.class) : null;
   }

   @EventHandler
   public void onPlayerTick(PlayerTickEvent var1) {
      if (!method1974()) {
         boolean var2 = field0796.field_1724.field_5976;
         boolean var3 = field0796.field_1724.method_5715() && !field0796.field_1724.method_5681();
         boolean var4 = field0796.field_1724.method_5799() && !field0796.field_1724.method_5869() && !field0796.field_1724.method_5681();
         if (field0004 > 0 || var3 || var2 || var4) {
            field0796.field_1724.method_5728(false);
         } else if (!field0796.field_1724.method_6115()) {
            switch ((Sprint.Mode)this.field1448.method0492()) {
               case field0690:
                  if (field0796.field_1724.field_3913.field_3905 > 0.0F) {
                     field0796.field_1724.method_5728(true);
                  }
                  break;
               case field0114:
                  if (field0796.field_1724.field_3913.field_3905 > 0.0F && !field0796.field_1690.field_1867.method_1434()) {
                     field0796.field_1724.method_5728(true);
                  }
            }
         }

         if (field0004 > 0) {
            field0004--;
         }
      }
   }

   public enum Mode implements DisplayNamed {
      field0690("Normal"),
      field0114("Legit");

      private final String field1504;

      Mode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }
}
