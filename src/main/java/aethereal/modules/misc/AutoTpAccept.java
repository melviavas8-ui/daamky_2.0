package aethereal;

import java.util.Arrays;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_7439;

public class AutoTpAccept extends Module {
   private final String[] field0173 = new String[]{
      "has requested teleport", "просит телепортироваться", "хочет телепортироваться к вам", "просит телепортироваться к Вам"
   };
   private final BooleanSetting field1432 = new BooleanSetting("autotpaccept.onlyfriends", true)
      .method1007("Only Friends")
      .method0210("Only accept teleport requests from friends")
      .method2130("Принимать запросы на телепортацию только от друзей");
   private boolean field1049;

   public AutoTpAccept() {
      super("AutoTpAccept", ModuleCategory.field0776, "Automatically accepts teleport requests");
      this.method1013("Автоматически принимает запросы телепортации");
   }

   @EventHandler
   public void onPacket(PacketEvent.Inbound var1) {
      if (var1.method1970() instanceof class_7439 var2) {
         String var6 = var2.comp_763().getString().toLowerCase();
         if (this.method2135(var6)) {
            boolean var4 = true;
            if (this.field1432.method0492()) {
               DaamkyClient var5 = DaamkyClient.method2004();
               if (var5 != null && var5.method1608() != null) {
                  var4 = var5.method1608().method0424().stream().map(String::toLowerCase).anyMatch(var6::contains);
               }
            }

            this.field1049 = var4;
         }
      }
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         if (this.field1049) {
            field0796.field_1724.field_3944.method_45730("tpaccept");
            this.field1049 = false;
         }
      }
   }

   private boolean method2135(String var1) {
      return Arrays.stream(this.field0173).map(String::toLowerCase).anyMatch(var1::contains);
   }
}
