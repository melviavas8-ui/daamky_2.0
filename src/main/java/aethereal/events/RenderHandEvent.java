package aethereal;

import lombok.Generated;
import net.minecraft.class_1268;
import net.minecraft.class_1799;
import net.minecraft.class_4587;
import net.minecraft.class_4597;

public class RenderHandEvent extends CancellableEvent {
   private class_4597 field0745;
   private final class_4587 field0163;
   private final class_1799 field1520;
   private final class_1268 field1039;

   @Generated
   public class_4597 method1809() {
      return this.field0745;
   }

   @Generated
   public class_4587 method1629() {
      return this.field0163;
   }

   @Generated
   public class_1799 method1968() {
      return this.field1520;
   }

   @Generated
   public class_1268 method0429() {
      return this.field1039;
   }

   @Generated
   public void method1516(class_4597 var1) {
      this.field0745 = var1;
   }

   @Generated
   public RenderHandEvent(class_4597 var1, class_4587 var2, class_1799 var3, class_1268 var4) {
      this.field0745 = var1;
      this.field0163 = var2;
      this.field1520 = var3;
      this.field1039 = var4;
   }

   public static class Pre extends CancellableEvent {
   }
}
