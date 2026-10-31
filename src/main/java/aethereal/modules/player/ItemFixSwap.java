package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_2596;
import net.minecraft.class_2824;
import net.minecraft.class_2846;
import net.minecraft.class_2868;
import net.minecraft.class_2885;
import net.minecraft.class_2886;

public class ItemFixSwap extends Module {
   private int field0004 = -1;

   public ItemFixSwap() {
      super("ItemFixSwap", ModuleCategory.field1470, "Cancels slot-change packets so the server keeps you on the original slot");
      this.method1013("Отключает отправку смены слота на сервер");
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field0004 = field0796.field_1724 != null ? field0796.field_1724.method_31548().field_7545 : -1;
   }

   @Override
   public void method2078() {
      this.method1735();
      this.field0004 = -1;
      super.method2078();
   }

   @EventHandler
   public void onPacketSend(PacketEvent.Outbound var1) {
      class_2596 var2 = var1.method1970();
      if (var2 instanceof class_2868 var3) {
         if (var3.method_12442() != this.field0004) {
            var1.method0578();
         }
      } else {
         if (this.method1355(var2)) {
            this.method1735();
         }
      }
   }

   private boolean method1355(class_2596<?> var1) {
      return var1 instanceof class_2886 || var1 instanceof class_2885 || var1 instanceof class_2824 || this.method0301(var1);
   }

   private boolean method0301(class_2596<?> var1) {
      if (var1 instanceof class_2846 var2) {
         return switch (var2.method_12363()) {
            case field_12968, field_12973, field_12971, field_12974, field_12975, field_12970, field_12969 -> true;
            default -> false;
         };
      } else {
         return false;
      }
   }

   private void method1735() {
      if (field0796.field_1724 != null) {
         int var1 = field0796.field_1724.method_31548().field_7545;
         if (var1 != this.field0004) {
            PacketQueue.method1354(new class_2868(var1));
            this.field0004 = var1;
         }
      }
   }
}
