package aethereal;

import net.minecraft.class_2596;
import net.minecraft.class_2792;
import net.minecraft.class_310;
import net.minecraft.class_7202;
import net.minecraft.class_7204;
import ua.patch.daamky.api.mixins.accessors.IClientWorld;

public final class SequencedPacketSender {
   private SequencedPacketSender() {
   }

   public static void method1534(class_7204 var0) {
      class_310 var1 = class_310.method_1551();
      if (var1.field_1687 != null && var1.method_1562() != null) {
         class_7202 var2 = ((IClientWorld)var1.field_1687).invokeGetPendingUpdateManager().method_41937();

         try {
            class_2596 var3 = var0.predict(var2.method_41942());
            var1.method_1562().method_52787(var3);
         } catch (Throwable var6) {
            if (var2 != null) {
               try {
                  var2.close();
               } catch (Throwable var5) {
                  var6.addSuppressed(var5);
               }
            }

            throw var6;
         }

         if (var2 != null) {
            var2.close();
         }
      }
   }
}
