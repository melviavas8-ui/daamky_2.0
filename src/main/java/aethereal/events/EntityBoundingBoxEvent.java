package aethereal;

import lombok.Generated;
import net.minecraft.class_1309;
import net.minecraft.class_238;

public class EntityBoundingBoxEvent extends CancellableEvent {
   private class_1309 field0731;
   private class_238 field0156;

   @Generated
   public class_1309 method1799() {
      return this.field0731;
   }

   @Generated
   public class_238 method1627() {
      return this.field0156;
   }

   @Generated
   public void method1158(class_1309 var1) {
      this.field0731 = var1;
   }

   @Generated
   public void method1283(class_238 var1) {
      this.field0156 = var1;
   }

   @Generated
   public EntityBoundingBoxEvent(class_1309 var1, class_238 var2) {
      this.field0731 = var1;
      this.field0156 = var2;
   }
}
