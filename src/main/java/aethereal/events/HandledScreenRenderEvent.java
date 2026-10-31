package aethereal;

import lombok.Generated;
import net.minecraft.class_332;
import net.minecraft.class_465;

public class HandledScreenRenderEvent extends CancellableEvent {
   private final class_465<?> field0746;
   private final class_332 field0162;
   private final int field1411;
   private final int field0958;

   @Generated
   public HandledScreenRenderEvent(class_465<?> var1, class_332 var2, int var3, int var4) {
      this.field0746 = var1;
      this.field0162 = var2;
      this.field1411 = var3;
      this.field0958 = var4;
   }

   @Generated
   public class_465<?> method1810() {
      return this.field0746;
   }

   @Generated
   public class_332 method1628() {
      return this.field0162;
   }

   @Generated
   public int method1947() {
      return this.field1411;
   }

   @Generated
   public int method0414() {
      return this.field0958;
   }
}
