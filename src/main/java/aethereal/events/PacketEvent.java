package aethereal;

import lombok.Generated;
import net.minecraft.class_2596;

public class PacketEvent extends CancellableEvent {
   private final class_2596<?> field0736;

   public boolean method1813() {
      return this instanceof PacketEvent.Outbound;
   }

   public boolean method1635() {
      return this instanceof PacketEvent.Inbound;
   }

   @Generated
   public PacketEvent(class_2596<?> var1) {
      this.field0736 = var1;
   }

   @Generated
   public class_2596<?> method1970() {
      return this.field0736;
   }

   public static class Outbound extends PacketEvent {
      public Outbound(class_2596<?> var1) {
         super(var1);
      }
   }

   public static class Inbound extends PacketEvent {
      public Inbound(class_2596<?> var1) {
         super(var1);
      }
   }

   public static class Transfer extends PacketEvent {
      public Transfer(class_2596<?> var1) {
         super(var1);
      }
   }
}
