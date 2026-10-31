package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1707;
import net.minecraft.class_1735;
import net.minecraft.class_1802;
import net.minecraft.class_476;

public class ChestStealer extends Module {
   private final EnumSetting<ChestStealer.Mode> field0058 = new EnumSetting<>("cheststealer.mode", ChestStealer.Mode.field0601)
      .method1007("Mode")
      .method0210("Stealing mode to use")
      .method2130("Мод");
   private final FloatSetting field1450 = new FloatSetting(
         "cheststealer.delay", 100.0F, 0.0F, 1000.0F, 1.0F, () -> this.field0058.method0492() != ChestStealer.Mode.field0601
      )
      .method1007("Delay")
      .method0210("Delay in ms between taking items")
      .method2130("Задержка");
   private final Stopwatch field0998 = new Stopwatch();

   public ChestStealer() {
      super("ChestStealer", ModuleCategory.field1470, "Automatically takes items from chests");
      this.method1013("Автоматически забирает предметы из сундуков");
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         if (this.field0058.method0492() != ChestStealer.Mode.field0601) {
            if (field0796.field_1724.field_7512 instanceof class_1707 var6) {
               for (class_1735 var10 : var6.field_7761) {
                  if (var10.method_7681()
                     && var10.field_7871 != field0796.field_1724.method_31548()
                     && this.field0998.method0779((long)this.field1450.method0492().floatValue())) {
                     InventorySlotHelper.method0143(var10.field_7874);
                     this.field0998.method1812();
                  }
               }
            }
         } else {
            if (field0796.field_1755 instanceof class_476 var2) {
               String var7 = var2.method_25440().getString().toLowerCase();
               if (!var7.contains("????") && !var7.contains("myst")) {
                  return;
               }

               if (field0796.field_1724.method_7357().method_7904(class_1802.field_8054.method_7854())) {
                  return;
               }

               for (class_1735 var5 : ((class_1707)var2.method_17577()).field_7761) {
                  if (var5.method_7681() && var5.field_7871 != field0796.field_1724.method_31548() && this.field0998.method0779(150L)) {
                     InventorySlotHelper.method0143(var5.field_7874);
                     this.field0998.method1812();
                  }
               }
            }
         }
      }
   }

   public enum Mode implements DisplayNamed {
      field0601("FunTime"),
      field0037("Default");

      private final String field1504;

      Mode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }
}
