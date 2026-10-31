package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_2720;
import net.minecraft.class_2856;
import net.minecraft.class_634;
import net.minecraft.class_2856.class_2857;

public class ServerRPSpoofer extends Module {
   private ServerRPSpoofer.SpoofState field0109 = ServerRPSpoofer.SpoofState.field1484;
   private final Stopwatch field1464 = new Stopwatch();

   public ServerRPSpoofer() {
      super("ServerRPSpoofer", ModuleCategory.field0776, "Spoofs server resource pack response");
      this.method1013("Подменяет ответ на ресурспак сервера");
   }

   @EventHandler
   public void onPacket(PacketEvent.Inbound var1) {
      if (var1.method1970() instanceof class_2720) {
         this.field0109 = ServerRPSpoofer.SpoofState.field0683;
         var1.method0578();
      }
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         class_634 var2 = field0796.method_1562();
         if (var2 != null) {
            if (this.field0109 == ServerRPSpoofer.SpoofState.field0683) {
               var2.method_52787(new class_2856(field0796.field_1724.method_5667(), class_2857.field_13016));
               this.field0109 = ServerRPSpoofer.SpoofState.field0109;
               this.field1464.method1812();
            } else {
               if (this.field0109 == ServerRPSpoofer.SpoofState.field0109 && this.field1464.method0779(300L)) {
                  var2.method_52787(new class_2856(field0796.field_1724.method_5667(), class_2857.field_13017));
                  this.field0109 = ServerRPSpoofer.SpoofState.field1484;
               }
            }
         }
      }
   }

   @Override
   public void method2078() {
      this.field0109 = ServerRPSpoofer.SpoofState.field1484;
      super.method2078();
   }

   public enum SpoofState {
      field0683,
      field0109,
      field1484;
   }
}
