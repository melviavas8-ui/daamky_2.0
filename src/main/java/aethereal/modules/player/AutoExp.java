package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1802;

public class AutoExp extends Module {
   private final KeyBindSetting field0085 = new KeyBindSetting("autoexp.usekey", new KeyBind(88, false))
      .method1007("Use Key")
      .method0210("Key to throw experience bottles")
      .method2130("Клавиша для броска");
   private final BooleanSetting field1432 = new BooleanSetting("autoexp.lookdown", true)
      .method1007("Look Down")
      .method0210("Look down before throwing for maximum XP pickup")
      .method2130("Смотреть вниз перед броском (чтобы подобрать больше опыта)");
   private final BooleanSetting field0970 = new BooleanSetting("autoexp.silentswitch", true)
      .method1007("Silent Switch")
      .method0210("Switch to bottles without visible hand change")
      .method2130("Переключать на пузырьки без смены предметы (Пакетный)");

   public AutoExp() {
      super("AutoExp", ModuleCategory.field1470, "Automatically uses experience bottles");
      this.method1013("Автоматически использует пузырьки опыта");
   }

   @EventHandler
   public void onTick(PlayerTickEvent var1) {
      if (!method1974()) {
         if (field0796.field_1755 == null) {
            KeyBind var2 = this.field0085.method0492();
            if (!var2.method0579() && var2.method1635()) {
               if (var2.method0026()) {
                  this.method1735();
               }
            }
         }
      }
   }

   @EventHandler
   public void onKey(KeyEvent var1) {
      if (!method1974()) {
         if (field0796.field_1755 == null) {
            KeyBind var2 = this.field0085.method0492();
            if (!var2.method0579() && !var2.method1813() && !var2.method1635()) {
               if (var1.method1604() == 1 && var1.method1763() == var2.method2048()) {
                  this.method1735();
               }
            }
         }
      }
   }

   @EventHandler
   public void onMouse(MouseEvent var1) {
      if (!method1974()) {
         if (field0796.field_1755 == null) {
            KeyBind var2 = this.field0085.method0492();
            if (!var2.method0579() && var2.method1813() && !var2.method1635()) {
               if (var1.method1604() == 1 && var1.method1763() == var2.method2048()) {
                  this.method1735();
               }
            }
         }
      }
   }

   private void method1735() {
      int var1 = InventoryManager.method2154(class_1802.field_8287);
      if (var1 != -1) {
         int var2 = field0796.field_1724.method_31548().field_7545;
         float var3 = field0796.field_1724.method_36455();
         if (this.field0970.method0492()) {
            InventoryManager.method0808(InventoryManager.SwitchMode.field0046, var1, var2);
         } else {
            field0796.field_1724.method_31548().field_7545 = var1;
         }

         if (this.field1432.method0492()) {
            field0796.field_1724.method_36457(90.0F);
         }

         field0796.field_1761.method_2919(field0796.field_1724, class_1268.field_5808);
         if (this.field1432.method0492()) {
            field0796.field_1724.method_36457(var3);
         }

         if (this.field0970.method0492()) {
            InventoryManager.method0169(InventoryManager.SwitchMode.field0046, var1, var2);
         } else {
            field0796.field_1724.method_31548().field_7545 = var2;
         }
      }
   }
}
