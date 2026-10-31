package aethereal;

import lombok.Generated;
import net.minecraft.class_2596;

public class PacketReceiveEvent extends CancellableEvent {
   private class_2596<?> field0736;

   @Generated
   public PacketReceiveEvent(class_2596<?> var1) {
      this.field0736 = var1;
   }

   @Generated
   public class_2596<?> method1804() {
      return this.field0736;
   }

   @Generated
   public void method1354(class_2596<?> var1) {
      this.field0736 = var1;
   }
}
