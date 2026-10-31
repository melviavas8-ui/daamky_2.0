package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_3532;
import net.minecraft.class_5498;

public final class FreeLook extends Module {
   private final KeyBindSetting field0085 = new KeyBindSetting("freelook.bind", new KeyBind(-1, false));
   private boolean field1527;
   private class_5498 field1046;
   private float field0177;
   private float field0458;

   public FreeLook() {
      super("FreeLook", ModuleCategory.field1004);
   }

   @Override
   public void method2078() {
      this.method2029();
      super.method2078();
   }

   @EventHandler
   public void onClientTick(ClientTickEvent var1) {
      if (method1974()) {
         this.method2029();
      } else {
         KeyBind var2 = this.field0085.method0492();
         if (var2.method0579()) {
            if (this.field1527) {
               this.method2029();
            }
         } else if (var2.method1635()) {
            boolean var3 = var2.method0026();
            if (var3) {
               if (!this.field1527) {
                  this.method1754();
               }
            } else if (this.field1527) {
               this.method2029();
            }
         }
      }
   }

   @EventHandler
   public void onKey(KeyEvent var1) {
      if (!method1974() && field0796.field_1755 == null) {
         KeyBind var2 = this.field0085.method0492();
         if (!var2.method0579() && !var2.method1635() && !var2.method1813()) {
            if (var1.method1604() == 1 && var1.method1763() == var2.method2048()) {
               this.method1691();
            }
         }
      }
   }

   @EventHandler
   public void onMouse(MouseEvent var1) {
      if (!method1974() && field0796.field_1755 == null) {
         KeyBind var2 = this.field0085.method0492();
         if (!var2.method0579() && !var2.method1635() && var2.method1813()) {
            if (var1.method1604() == 1 && var1.method1763() == var2.method2048()) {
               this.method1691();
            }
         }
      }
   }

   @EventHandler
   public void onCamera(CameraEvent var1) {
      if (this.field1527) {
         var1.method0675(this.field0177, this.field0458);
      }
   }

   public boolean method0616(double var1, double var3) {
      if (!this.field1527) {
         return false;
      }

      this.field0177 += (float)(var1 * 0.15F);
      this.field0458 = class_3532.method_15363(this.field0458 + (float)(var3 * 0.15F), -90.0F, 90.0F);
      return true;
   }

   public boolean method1736() {
      return this.field1527;
   }

   private void method1691() {
      if (this.field1527) {
         this.method2029();
      } else {
         this.method1754();
      }
   }

   private void method1754() {
      if (!this.field1527 && field0796.field_1724 != null && field0796.field_1690 != null) {
         this.field1527 = true;
         this.field1046 = field0796.field_1690.method_31044();
         if (field0796.field_1690.method_31044() != class_5498.field_26665) {
            field0796.field_1690.method_31043(class_5498.field_26665);
         }

         this.field0177 = field0796.field_1724.method_36454();
         this.field0458 = field0796.field_1724.method_36455();
      }
   }

   private void method2029() {
      if (this.field1527) {
         this.field1527 = false;
         if (this.field1046 != null) {
            field0796.field_1690.method_31043(this.field1046);
         }

         this.field1046 = null;
      }
   }
}
