package aethereal;

import java.util.Arrays;
import meteordevelopment.orbit.EventHandler;
import ua.patch.daamky.api.mixins.accessors.IClientPlayerInteractionManager;
import ua.patch.daamky.api.mixins.accessors.ILivingEntity;
import ua.patch.daamky.api.mixins.accessors.IMinecraftClient;

public class NoDelay extends Module {
   public final MultiSelectSetting field0089 = new MultiSelectSetting("nodelay.type", Arrays.asList("Jump", "Right Click", "Break CoolDown"), false, () -> true)
      .method1007("Type")
      .method0210("Which delays to remove")
      .method2130("Какие задержки убрать");

   public NoDelay() {
      super("NoDelay", ModuleCategory.field1470, "Removes various game delays");
      this.method1013("Убирает различные игровые задержки");
   }

   public static NoDelay method1714() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(NoDelay.class) : null;
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         if (this.method2135("Break CoolDown") && field0796.field_1761 != null) {
            ((IClientPlayerInteractionManager)field0796.field_1761).setBlockBreakingCooldown(0);
         }

         if (this.method2135("Jump")) {
            ((ILivingEntity)field0796.field_1724).setJumpingCooldown(0);
         }

         if (this.method2135("Right Click")) {
            ((IMinecraftClient)field0796).setItemUseCooldown(0);
         }
      }
   }

   private boolean method2135(String var1) {
      BooleanSetting var2 = this.field0089.method0439(var1);
      return var2 != null && var2.method0492();
   }
}
