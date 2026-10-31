package aethereal;

import lombok.Generated;
import net.minecraft.class_10185;

public class KeyboardInputEvent extends CancellableEvent {
   private class_10185 field0729;

   public void method0345(boolean var1) {
      this.field0729 = new class_10185(
         this.field0729.comp_3159(),
         this.field0729.comp_3160(),
         this.field0729.comp_3161(),
         this.field0729.comp_3162(),
         var1,
         this.field0729.comp_3164(),
         this.field0729.comp_3165()
      );
   }

   public void method1574(boolean var1, boolean var2, boolean var3, boolean var4) {
      this.field0729 = new class_10185(var1, var2, var3, var4, this.field0729.comp_3163(), this.field0729.comp_3164(), this.field0729.comp_3165());
   }

   public void method1812() {
      this.field0729 = new class_10185(false, false, false, false, false, false, false);
   }

   public int method1604() {
      return this.field0729.comp_3159() ? 1 : (this.field0729.comp_3160() ? -1 : 0);
   }

   public float method1946() {
      return this.field0729.comp_3161() ? 1.0F : (this.field0729.comp_3162() ? -1.0F : 0.0F);
   }

   @Generated
   public class_10185 method0427() {
      return this.field0729;
   }

   @Generated
   public void method1114(class_10185 var1) {
      this.field0729 = var1;
   }

   @Generated
   public KeyboardInputEvent(class_10185 var1) {
      this.field0729 = var1;
   }
}
