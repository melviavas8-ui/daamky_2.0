package aethereal;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1294;
import net.minecraft.class_243;
import net.minecraft.class_2824;
import net.minecraft.class_2824.class_5908;
import net.minecraft.class_2828.class_2829;

public class Criticals extends Module {
   private final EnumSetting<Criticals.Mode> field1448 = new EnumSetting<>("criticals.mode", Criticals.Mode.field0620)
      .method1007("Mode")
      .method0210("Critical hit trigger strategy.")
      .method2130("Режим");
   private final MultiSelectSetting field1005 = new MultiSelectSetting(
         "RW Mode", List.of("Web", "Smooth Falling"), false, () -> this.field1448.method0492() == Criticals.Mode.field0620
      )
      .method1007("RW Mode")
      .method0210("Условия");
   public static boolean field0169;

   public Criticals() {
      super("Criticals", ModuleCategory.field0661, "Forces a critical hit on every aura attack.");
      this.method1013("Гарантирует критический удар при атаке от ауры.");
   }

   @EventHandler
   public void onPacketSend(PacketEvent.Outbound var1) {
      if (!method1974()) {
         if (var1.method1970() instanceof class_2824 var2) {
            if (method1376(var2)) {
               if (field0169) {
                  field0169 = false;
               } else {
                  this.method1735();
               }
            }
         }
      }
   }

   private void method1735() {
      Aura var1 = Aura.method1701();
      if (var1 != null && var1.method0409() != null) {
         if (!field0796.field_1724.method_24828()) {
            double var2 = field0796.field_1724.method_23318();
            if (var2 != (int)var2) {
               if (this.field1448.method0492() == Criticals.Mode.field0620) {
                  boolean var4 = false;
                  if (this.field1005.method0387("Web") && BlockPlacementHelper.method2079()) {
                     var4 = true;
                  }

                  if (this.field1005.method0387("Smooth Falling")
                     && field0796.field_1724.method_6059(class_1294.field_5906)
                     && !field0796.field_1724.method_24828()
                     && field0796.field_1724.method_18798().field_1351 < 0.0) {
                     var4 = true;
                  }

                  if (!var4) {
                     return;
                  }
               }

               float var5 = method0667(1.0E-7F, 1.0E-6F);
               field0796.field_1724.field_6017 = 0.001F;
               field0796.field_1724
                  .field_3944
                  .method_52787(
                     new class_2829(
                        field0796.field_1724.method_23317(), field0796.field_1724.method_23318() - var5, field0796.field_1724.method_23321(), false, false
                     )
                  );
               field0796.field_1724.field_6017 = var5;
            }
         }
      }
   }

   private static boolean method1376(class_2824 var0) {
      final boolean[] var1 = new boolean[]{false};
      var0.method_34209(new class_5908() {
         public void method_34219(class_1268 var1x) {
         }

         public void method_34220(class_1268 var1x, class_243 var2) {
         }

         public void method_34218() {
            var1[0] = true;
         }
      });
      return var1[0];
   }

   private static float method0667(float var0, float var1) {
      return var0 + ThreadLocalRandom.current().nextFloat() * (var1 - var0);
   }

   public enum Mode implements DisplayNamed {
      field0620("ReallyWorld"),
      field0051("Packet");

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
