package aethereal;

import lombok.Generated;
import net.minecraft.class_1297;
import net.minecraft.class_238;

public class EntityCollisionEvent extends CancellableEvent {
   private class_238 field0734;
   private class_1297 field0149;
   private static boolean field1527 = false;

   public static boolean method1813() {
      return field1527;
   }

   public static void method0345(boolean var0) {
      field1527 = var0;
   }

   @Generated
   public class_238 method1627() {
      return this.field0734;
   }

   @Generated
   public class_1297 method1967() {
      return this.field0149;
   }

   @Generated
   public void method1283(class_238 var1) {
      this.field0734 = var1;
   }

   @Generated
   public void method1128(class_1297 var1) {
      this.field0149 = var1;
   }

   @Generated
   public EntityCollisionEvent(class_238 var1, class_1297 var2) {
      this.field0734 = var1;
      this.field0149 = var2;
   }
}
