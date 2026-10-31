package aethereal;

import lombok.Generated;

public class ItemUseEvent extends CancellableEvent {
   byte field0564;

   @Generated
   public byte method1760() {
      return this.field0564;
   }

   @Generated
   public void method0604(byte var1) {
      this.field0564 = var1;
   }

   @Generated
   public ItemUseEvent(byte var1) {
      this.field0564 = var1;
   }
}
