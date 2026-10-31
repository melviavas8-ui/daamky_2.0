package aethereal;

import net.minecraft.class_1799;

public record InventorySlotResult(int slot, boolean found, class_1799 stack) {
   private static final InventorySlotResult NOT_FOUND_RESULT = new InventorySlotResult(-1, false, null);

   public static InventorySlotResult method0536() {
      return NOT_FOUND_RESULT;
   }

   public boolean method0026() {
      return this.slot >= 0 && this.slot < 9;
   }

   public int method2048() {
      return this.slot;
   }

   public boolean method1813() {
      return this.found;
   }

   public class_1799 method1625() {
      return this.stack;
   }
}
