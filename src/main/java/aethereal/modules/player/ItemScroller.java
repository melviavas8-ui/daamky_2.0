package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_3675;
import net.minecraft.class_465;
import org.lwjgl.glfw.GLFW;
import ua.patch.daamky.api.mixins.accessors.IHandledScreen;

public class ItemScroller extends Module {
   private final FloatSetting field0060 = new FloatSetting("itemscroller.delay", 100.0F, 1.0F, 100.0F, 1.0F)
      .method1007("Delay")
      .method0210("Delay in ms between item moves")
      .method2130("Задержка");
   private final Stopwatch field1464 = new Stopwatch();

   public ItemScroller() {
      super("ItemScroller", ModuleCategory.field1470, "Quick inventory item scrolling with shift + left mouse hold");
      this.method1013("Быстрое перемещение предметов в инвентаре");
   }

   @EventHandler
   private void onRender2D(HudRenderEvent var1) {
      if (!method1974()) {
         if (field0796.field_1755 instanceof class_465<?> var2) {
            IHandledScreen var9 = (IHandledScreen)var2;
            class_1735 var4 = var9.getFocusedSlot();
            if (var4 != null && var4.method_7681()) {
               long var5 = field0796.method_22683().method_4490();
               boolean var7 = GLFW.glfwGetMouseButton(var5, 0) == 1;
               boolean var8 = class_3675.method_15987(var5, 340) || class_3675.method_15987(var5, 344);
               if (var7 && var8) {
                  if (this.field1464.method0779(this.field0060.method0492().longValue())) {
                     var9.daamky$onMouseClick(var4, var4.field_7874, 0, class_1713.field_7794);
                     this.field1464.method1812();
                  }
               }
            }
         }
      }
   }
}
