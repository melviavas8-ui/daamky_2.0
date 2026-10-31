package aethereal;

import lombok.Generated;
import net.minecraft.class_1268;
import net.minecraft.class_1799;
import net.minecraft.class_4587;

public class HandOffsetEvent extends CancellableEvent {
   private class_4587 field0743;
   private class_1799 field0154;
   private class_1268 field1518;

   @Generated
   public class_4587 method1808() {
      return this.field0743;
   }

   @Generated
   public class_1799 method1625() {
      return this.field0154;
   }

   @Generated
   public class_1268 method1966() {
      return this.field1518;
   }

   @Generated
   public void method1452(class_4587 var1) {
      this.field0743 = var1;
   }

   @Generated
   public void method1240(class_1799 var1) {
      this.field0154 = var1;
   }

   @Generated
   public void method1119(class_1268 var1) {
      this.field1518 = var1;
   }

   @Generated
   public HandOffsetEvent(class_4587 var1, class_1799 var2, class_1268 var3) {
      this.field0743 = var1;
      this.field0154 = var2;
      this.field1518 = var3;
   }
}
