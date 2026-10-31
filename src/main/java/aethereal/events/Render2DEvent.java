package aethereal;

import lombok.Generated;
import net.minecraft.class_332;
import net.minecraft.class_9779;

public class Render2DEvent extends CancellableEvent {
   private class_332 field0740;
   private class_9779 field0167;

   @Generated
   public Render2DEvent(class_332 var1, class_9779 var2) {
      this.field0740 = var1;
      this.field0167 = var2;
   }

   @Generated
   public class_332 method1806() {
      return this.field0740;
   }

   @Generated
   public class_9779 method1632() {
      return this.field0167;
   }
}
