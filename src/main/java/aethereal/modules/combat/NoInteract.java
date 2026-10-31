package aethereal;

import net.minecraft.class_1297;
import net.minecraft.class_1531;
import net.minecraft.class_1533;
import net.minecraft.class_1534;
import net.minecraft.class_2199;
import net.minecraft.class_2238;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2269;
import net.minecraft.class_2272;
import net.minecraft.class_2349;
import net.minecraft.class_2354;
import net.minecraft.class_2401;
import net.minecraft.class_2480;
import net.minecraft.class_2533;

public class NoInteract extends Module {
   private final BooleanSetting field0034 = new BooleanSetting("nointeract.onlyaura", false)
      .method1007("Only With Aura")
      .method0210("Block interactions only while Aura is enabled")
      .method2130("Блокировать только при включённой Aura");

   public NoInteract() {
      super("NoInteract", ModuleCategory.field0661, "Prevents accidental block interaction during combat");
      this.method1013("Запрещает открытие мешающих блоков во время боя");
   }

   public boolean method1253(class_2248 var1) {
      if (!this.method2195()) {
         return false;
      } else {
         return !this.method0274(var1) ? false : this.method1736();
      }
   }

   public boolean method1129(class_1297 var1) {
      if (!this.method2195()) {
         return false;
      } else {
         return !this.method0235(var1) ? false : this.method1736();
      }
   }

   private boolean method1736() {
      if (!this.field0034.method0492()) {
         return true;
      }

      Aura var1 = Aura.method1701();
      return var1 != null && var1.method2195();
   }

   private boolean method0274(class_2248 var1) {
      if (var1 instanceof class_2480) {
         return true;
      } else if (var1 instanceof class_2354) {
         return true;
      } else if (var1 instanceof class_2349) {
         return true;
      } else if (var1 instanceof class_2533) {
         return true;
      } else if (var1 instanceof class_2199) {
         return true;
      } else if (var1 instanceof class_2238) {
         return true;
      } else if (var1 instanceof class_2269) {
         return true;
      } else if (var1 instanceof class_2401) {
         return true;
      } else {
         return var1 instanceof class_2272
            ? true
            : var1 == class_2246.field_10034
               || var1 == class_2246.field_10380
               || var1 == class_2246.field_10443
               || var1 == class_2246.field_10181
               || var1 == class_2246.field_16333
               || var1 == class_2246.field_16334
               || var1 == class_2246.field_9980
               || var1 == class_2246.field_10312
               || var1 == class_2246.field_10223
               || var1 == class_2246.field_10179
               || var1 == class_2246.field_10200
               || var1 == class_2246.field_10228
               || var1 == class_2246.field_10083
               || var1 == class_2246.field_16329
               || var1 == class_2246.field_16337
               || var1 == class_2246.field_16335
               || var1 == class_2246.field_16336
               || var1 == class_2246.field_10485
               || var1 == class_2246.field_10333
               || var1 == class_2246.field_16330;
      }
   }

   private boolean method0235(class_1297 var1) {
      return var1 instanceof class_1533 || var1 instanceof class_1531 || var1 instanceof class_1534;
   }
}
