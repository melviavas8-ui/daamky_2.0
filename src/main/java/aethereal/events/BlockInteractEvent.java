package aethereal;

import lombok.Generated;
import net.minecraft.class_2338;
import net.minecraft.class_2350;

public class BlockInteractEvent extends CancellableEvent {
   private final class_2338 field0733;
   private final class_2350 field0155;

   @Generated
   public BlockInteractEvent(class_2338 var1, class_2350 var2) {
      this.field0733 = var1;
      this.field0155 = var2;
   }

   @Generated
   public class_2338 method1802() {
      return this.field0733;
   }

   @Generated
   public class_2350 method1626() {
      return this.field0155;
   }
}
