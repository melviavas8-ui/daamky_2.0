package aethereal;

import net.minecraft.class_332;
import net.minecraft.class_9779;

public class StatusEffectsRenderEvent extends CancellableEvent {
   private final class_332 field0740;
   private final class_9779 field0167;

   public StatusEffectsRenderEvent(class_332 var1, class_9779 var2) {
      this.field0740 = var1;
      this.field0167 = var2;
   }

   public class_332 method1806() {
      return this.field0740;
   }

   public class_9779 method1632() {
      return this.field0167;
   }
}
