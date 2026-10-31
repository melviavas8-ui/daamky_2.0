package aethereal;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10185;
import net.minecraft.class_2596;
import net.minecraft.class_2813;
import net.minecraft.class_2815;
import net.minecraft.class_2848;
import net.minecraft.class_2851;
import net.minecraft.class_304;
import net.minecraft.class_3675;
import net.minecraft.class_408;
import net.minecraft.class_465;
import net.minecraft.class_490;
import net.minecraft.class_498;
import net.minecraft.class_2848.class_2849;

public class GuiMove extends Module {
   private final BooleanSetting field1432 = new BooleanSetting("guimove.bypass", true)
      .method1007("Bypass")
      .method0210("ac bypass")
      .method2130("Обход разных античитов");
   private final BooleanSetting field0970 = new BooleanSetting("guimove.look", false)
      .method1007("Look")
      .method0210("Allow camera rotation while in GUI")
      .method2130("Разрешить вращение камеры");
   private final BooleanSetting field0184 = new BooleanSetting("guimove.disableSprintInInventory", false)
      .method1007("Disable Sprint in Inventory")
      .method0210("Disables sprint when a container is open")
      .method2130("Отключает спринт при открытом инвентаре");
   private final BooleanSetting field0464 = new BooleanSetting("guimove.disableInContainer", true)
      .method1007("Disable in Container")
      .method0210("Disables movement in external containers")
      .method2130("Отключает движение в контейнерах");
   private final Queue<class_2596<?>> field1645 = new ConcurrentLinkedQueue<>();
   public static class_304[] field0175 = null;
   private boolean field1574 = false;
   private boolean field1735 = false;

   public GuiMove() {
      super("GuiMove", ModuleCategory.field0088, "Allows movement while GUI screens are open");
      this.method1013("Позволяет двигаться с открытым интерфейсом");
   }

   private void method1691() {
      if (field0175 == null && field0796 != null && field0796.field_1690 != null) {
         field0175 = new class_304[]{
            field0796.field_1690.field_1894,
            field0796.field_1690.field_1881,
            field0796.field_1690.field_1913,
            field0796.field_1690.field_1849,
            field0796.field_1690.field_1903
         };
      }
   }

   @EventHandler
   public void onSendPacket(PacketEvent.Outbound var1) {
      if (!method1974()) {
         if (this.field1432.method0492()) {
            if (!this.field1735) {
               class_2596 var2 = var1.method1970();
               if (!(
                  var2 instanceof class_2813 var3
                     && var3.method_12194() == 0
                     && field0796.field_1755 instanceof class_465
                     && (MovementHelper.method1635() || field0796.field_1724.method_5624())
               )) {
                  if (var2 instanceof class_2815 var8 && var8.method_36168() == 0 && !this.field1645.isEmpty()) {
                     var1.method0578();
                     if (field0796.method_1562() == null) {
                        this.field1645.clear();
                        this.field1574 = false;
                        return;
                     }

                     this.field1735 = true;

                     try {
                        field0796.method_1562().method_52787(new class_2851(new class_10185(false, false, false, false, false, false, false)));
                        if (this.field1574) {
                           field0796.method_1562().method_52787(new class_2848(field0796.field_1724, class_2849.field_12985));
                        }

                        while (!this.field1645.isEmpty()) {
                           class_2596 var4 = this.field1645.poll();
                           if (var4 != null) {
                              field0796.method_1562().method_52787(var4);
                           }
                        }

                        field0796.method_1562().method_52787(var8);
                        if (this.field1574) {
                           field0796.method_1562().method_52787(new class_2848(field0796.field_1724, class_2849.field_12981));
                        }
                     } finally {
                        this.field1735 = false;
                        this.field1574 = false;
                     }
                  }
               } else {
                  if (this.field1645.isEmpty()) {
                     this.field1574 = field0796.field_1724.method_5624();
                  }

                  this.field1645.add(var2);
                  var1.method0578();
               }
            }
         }
      }
   }

   @EventHandler
   public void onTick(PlayerTickEvent var1) {
      if (!method1974()) {
         if (this.field0184.method0492() && field0796.field_1755 != null && !(field0796.field_1755 instanceof class_408)) {
            field0796.field_1724.method_5728(false);
            Sprint.field0004 = 2;
         }

         if (!this.field1432.method0492() && !this.field1645.isEmpty()) {
            this.field1645.clear();
         }

         this.method1691();
         if (field0175 != null) {
            if (field0796.field_1755 instanceof class_408 || field0796.field_1755 instanceof class_498) {
               Arrays.stream(field0175).forEach(var0 -> var0.method_23481(false));
            } else if (this.field0464.method0492() && field0796.field_1755 instanceof class_465 && !(field0796.field_1755 instanceof class_490)) {
               Arrays.stream(field0175).forEach(var0 -> var0.method_23481(false));
            } else if (InventoryManager.method0544().method0026()) {
               if (!this.method1755()) {
                  long var2 = field0796.method_22683().method_4490();
                  Arrays.stream(field0175).forEach(var2x -> var2x.method_23481(class_3675.method_15987(var2, var2x.method_1429().method_1444())));
               }
            }
         }
      }
   }

   @Override
   public void method2078() {
      this.field1645.clear();
      super.method2078();
   }

   public boolean method1736() {
      return this.method2195()
         && this.field0970.method0492()
         && field0796.field_1755 != null
         && !(field0796.field_1755 instanceof class_408)
         && !(field0796.field_1755 instanceof class_498)
         && !this.method1755();
   }

   private boolean method1755() {
      return field0796.field_1755 instanceof ClickGuiScreen var1 && var1.method1775().method1951().method0579();
   }
}
