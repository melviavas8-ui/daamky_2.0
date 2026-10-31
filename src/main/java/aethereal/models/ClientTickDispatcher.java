package aethereal;

import meteordevelopment.orbit.EventHandler;

public class ClientTickDispatcher {
   private static boolean field0751 = false;

   public static void method0578() {
      if (!field0751) {
         field0751 = true;
         DaamkyClient.method2004().method2072().subscribe(new ClientTickDispatcher());
      }
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      InventoryActionScheduler.method0578();
      InventoryActionScheduler.method0025();
   }
}
