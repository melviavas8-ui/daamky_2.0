package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_5892;
import net.minecraft.class_2828.class_2829;

public class AutoRespawn extends Module {
   private final EnumSetting<AutoRespawn.Mode> field0058 = new EnumSetting<>("autorespawn.mode", AutoRespawn.Mode.field0592)
      .method1007("Mode")
      .method0210("Respawn method to use")
      .method2130("Метод возрождения");

   public AutoRespawn() {
      super("AutoRespawn", ModuleCategory.field1470, "Automatically respawns after death");
      this.method1013("Автоматический респаун после смерти");
   }

   @EventHandler
   public void onPacket(PacketEvent.Inbound var1) {
      if (!method1974()) {
         if (var1.method1970() instanceof class_5892) {
            if (this.field0058.method0492() == AutoRespawn.Mode.field0592) {
               field0796.field_1724.field_3944.method_52787(new class_2829(1448.0, 1337.0, 228.0, false, false));
               field0796.field_1724.method_7331();
               field0796.field_1724.method_7346();
            }
         }
      }
   }

   @EventHandler
   public void onDeathScreen(DeathScreenEvent var1) {
      if (!method1974()) {
         if (this.field0058.method0492() == AutoRespawn.Mode.field0027) {
            field0796.field_1724.method_7331();
            field0796.method_1507(null);
         }
      }
   }

   public enum Mode implements DisplayNamed {
      field0592("FunTime Back"),
      field0027("Default");

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
