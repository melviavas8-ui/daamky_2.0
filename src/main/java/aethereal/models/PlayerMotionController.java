package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_2848;

public class PlayerMotionController {
   public static boolean field0751;

   @EventHandler
   public void onTick(PlayerTickEvent var1) {
      DaamkyClient.method2004().method1881().method0578();
      InventoryComponent.method0578();
   }

   @EventHandler
   public void onPacketSend(PacketEvent.Outbound var1) {
      if (var1.method1970() instanceof class_2848 var2) {
         switch (var2.method_12365()) {
            case field_12981:
               if (field0751) {
                  var1.method1570(true);
               }

               field0751 = true;
               break;
            case field_12985:
               if (!field0751) {
                  var1.method1570(true);
               }

               field0751 = false;
         }
      }

      DaamkyClient.method2004().method1881().method0903(var1);
   }

   @EventHandler
   public void onPacketReceive(PacketEvent.Inbound var1) {
      DaamkyClient.method2004().method1881().method0903(var1);
   }

   @EventHandler
   public void onUsingItemEvent(ItemUseEvent var1) {
      DaamkyClient.method2004().method1881().method0880(var1);
   }

   @EventHandler
   public void onPostMovementEvent(PostMovementTickEvent var1) {
      DaamkyClient.method2004().method1881().method0025();
   }
}
