package aethereal;

import meteordevelopment.orbit.EventHandler;

public class ShiftTap extends Module {
   private long field0005;
   private boolean field1527;

   public static ShiftTap method1718() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(ShiftTap.class) : null;
   }

   public ShiftTap() {
      super("ShiftTap", ModuleCategory.field0661, "Automatically taps shift for attack mechanics");
      this.method1013("Автоматически нажимает шифт при ударе");
   }

   public static void method1691() {
      ShiftTap var0 = method1718();
      if (var0 != null && var0.method2195()) {
         var0.method1754();
      }
   }

   private void method1754() {
      if (!method1974()) {
         this.field0005 = System.currentTimeMillis() + 25L;
         if (!this.field1527) {
            field0796.field_1690.field_1832.method_23481(true);
            this.field1527 = true;
         }
      }
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974() && !field0796.field_1724.method_7325()) {
         if (this.field1527 && System.currentTimeMillis() > this.field0005) {
            this.method2029();
         }
      } else {
         this.method2029();
      }
   }

   @Override
   public void method2078() {
      this.method2029();
      super.method2078();
   }

   private void method2029() {
      if (this.field1527) {
         field0796.field_1690.field_1832.method_23481(false);
         this.field1527 = false;
      }
   }
}
