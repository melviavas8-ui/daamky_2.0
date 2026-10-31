package aethereal;

import lombok.Generated;
import net.minecraft.class_4587;

public class GlowRenderEvent extends CancellableEvent {
   private final class_4587 field0743;
   private final float field0003;

   @Generated
   public class_4587 method1808() {
      return this.field0743;
   }

   @Generated
   public float method1603() {
      return this.field0003;
   }

   @Generated
   public GlowRenderEvent(class_4587 var1, float var2) {
      this.field0743 = var1;
      this.field0003 = var2;
   }

   public static class Pre extends CancellableEvent {
      private final class_4587 field0743;
      private final float field0003;

      @Generated
      public class_4587 method1808() {
         return this.field0743;
      }

      @Generated
      public float method1603() {
         return this.field0003;
      }

      @Generated
      public Pre(class_4587 var1, float var2) {
         this.field0743 = var1;
         this.field0003 = var2;
      }
   }
}
