package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1802;

public class NoSlow extends Module {
   private final EnumSetting<NoSlow.Mode> field0058 = new EnumSetting<>("noslow.mode", NoSlow.Mode.field0666)
      .method1007("Mode")
      .method0210("Anti-cheat bypass method to use")
      .method2130("Метод обхода античита");
   private final BooleanSetting field1432 = new BooleanSetting("noslow.sprint", true, () -> this.field0058.method0492() == NoSlow.Mode.field0666)
      .method1007("Sprint")
      .method0210("Force sprint while using items")
      .method2130("Принудительный спринт при использовании предметов");
   private int field0958;
   private int field0178;
   private int field0459;
   private int field1615;

   public static NoSlow method1715() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(NoSlow.class) : null;
   }

   public NoSlow() {
      super("NoSlow", ModuleCategory.field0088, "Prevents slowdown from using items or blocking");
      this.method1013("Убирает замедление при использовании предметов");
   }

   @EventHandler
   public void onTick(PlayerTickEvent var1) {
      if (!method1974()) {
         if (field0796.field_1724.method_6058() != class_1268.field_5808 && field0796.field_1724.method_6058() != class_1268.field_5810) {
            this.field0958 = 0;
         } else {
            this.field0958++;
         }

         if (this.field0058.method0492() == NoSlow.Mode.field1473 && !field0796.field_1724.method_6128()) {
            if (field0796.field_1724.method_6115()) {
               this.field0178++;
            } else {
               this.field0178 = 0;
            }
         }

         if (this.field0058.method0492() == NoSlow.Mode.field1007) {
            if (field0796.field_1724.method_6115()) {
               this.field0459++;
            } else {
               this.field0459 = 0;
            }
         }

         if (this.field0058.method0492() == NoSlow.Mode.field0777) {
            if (field0796.field_1724.method_6115()) {
               this.field1615++;
            } else {
               this.field1615 = 0;
            }
         }
      }
   }

   @EventHandler
   public void onNoSlow(NoSlowEvent var1) {
      if (!method1974()) {
         if (field0796.field_1724.method_6115()) {
            NoSlow.Mode var2 = this.field0058.method0492();
            if (var2 == NoSlow.Mode.field0777) {
               if (this.field1615 % 3 == 0) {
                  var1.method0578();
               }
            } else if (var2 != NoSlow.Mode.field1473) {
               if (var2 == NoSlow.Mode.field1007) {
                  if (this.field0459 % 4 == 0) {
                     var1.method0578();
                  }
               } else if (var2 == NoSlow.Mode.field0095) {
                  if (this.field0958 > 1 && field0796.field_1724.method_6048() > 1) {
                     var1.method0578();
                     this.field0958 = 0;
                  }
               } else {
                  if (var2 == NoSlow.Mode.field1260) {
                     if (!field0796.field_1724.method_6030().method_31574(class_1802.field_8399)) {
                        return;
                     }

                     if (field0796.field_1724.field_3913.field_3905 > 0.0F && !field0796.field_1724.method_6128()) {
                        field0796.field_1724.method_5728(true);
                     }

                     var1.method0578();
                  }
               }
            } else {
               if (this.field0178 == 1 || this.field0178 == 2) {
                  var1.method0578();
               }

               if (this.field0178 >= 2) {
                  this.field0178 = 0;
               }

               if (this.field0178 == 0) {
                  var1.method0025();
               }
            }
         }
      }
   }

   @Override
   public void method2078() {
      super.method2078();
   }

   public enum Mode implements DisplayNamed {
      field0666("Grim Old"),
      field0095("SpookyTime"),
      field1473("MultiServer"),
      field1007("Legit"),
      field0777("LegitV2"),
      field1260("FunTime");

      private final String field0336;

      Mode(String var3) {
         this.field0336 = var3;
      }

      @Override
      public String method0557() {
         return this.field0336;
      }
   }
}
