package aethereal;

import lombok.Generated;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_9779;
import org.joml.Matrix4f;

public class WorldRenderEvent extends CancellableEvent {
   public static class GamePass extends CancellableEvent {
      private final class_9779 field0748;
      private final class_4587 field0163;

      @Generated
      public GamePass(class_9779 var1, class_4587 var2) {
         this.field0748 = var1;
         this.field0163 = var2;
      }

      @Generated
      public class_9779 method1811() {
         return this.field0748;
      }

      @Generated
      public class_4587 method1629() {
         return this.field0163;
      }
   }

   public static class WorldPass extends CancellableEvent {
      private final class_4184 field0741;
      private final Matrix4f field0168;
      private final class_9779 field1525;

      @Generated
      public WorldPass(class_4184 var1, Matrix4f var2, class_9779 var3) {
         this.field0741 = var1;
         this.field0168 = var2;
         this.field1525 = var3;
      }

      @Generated
      public class_4184 method1807() {
         return this.field0741;
      }

      @Generated
      public Matrix4f method1633() {
         return this.field0168;
      }

      @Generated
      public class_9779 method1972() {
         return this.field1525;
      }
   }
}
