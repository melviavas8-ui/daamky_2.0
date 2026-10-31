package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1764;
import net.minecraft.class_4587;

public class ViewModel extends Module {
   private final FloatSetting field0060 = new FloatSetting("viewmodel.mainhandx", 0.0F, -3.0F, 3.0F, 0.05F)
      .method1007("Main Hand X")
      .method0210("Horizontal offset for main hand")
      .method2130("Горизонтальное смещение правой руки");
   private final FloatSetting field1450 = new FloatSetting("viewmodel.mainhandy", 0.0F, -2.0F, 2.0F, 0.05F)
      .method1007("Main Hand Y")
      .method0210("Vertical offset for main hand")
      .method2130("Вертикальное смещение правой руки");
   private final FloatSetting field0985 = new FloatSetting("viewmodel.mainhandz", 0.0F, -3.0F, 3.0F, 0.05F)
      .method1007("Main Hand Z")
      .method0210("Depth offset for main hand")
      .method2130("Смещение глубины правой руки");
   private final FloatSetting field0190 = new FloatSetting("viewmodel.offhandx", 0.0F, -3.0F, 3.0F, 0.05F)
      .method1007("Off Hand X")
      .method0210("Horizontal offset for off hand")
      .method2130("Горизонтальное смещение левой руки");
   private final FloatSetting field0470 = new FloatSetting("viewmodel.offhandy", 0.0F, -2.0F, 2.0F, 0.05F)
      .method1007("Off Hand Y")
      .method0210("Vertical offset for off hand")
      .method2130("Вертикальное смещение левой руки");
   private final FloatSetting field1627 = new FloatSetting("viewmodel.offhandz", 0.0F, -3.0F, 3.0F, 0.05F)
      .method1007("Off Hand Z")
      .method0210("Depth offset for off hand")
      .method2130("Смещение глубины левой руки");

   public ViewModel() {
      super("ViewModel", ModuleCategory.field1004, "Customizes held item rendering position and scale");
      this.method1013("Настраивает позицию и размер предмета в руке");
   }

   @EventHandler
   public void onHandOffset(HandOffsetEvent var1) {
      class_1268 var2 = var1.method1966();
      if (var2 != class_1268.field_5808 || !(var1.method1625().method_7909() instanceof class_1764)) {
         class_4587 var3 = var1.method1808();
         float var4;
         float var5;
         float var6;
         if (var2 == class_1268.field_5808) {
            var4 = this.field0060.method0492();
            var5 = this.field1450.method0492();
            var6 = this.field0985.method0492();
         } else {
            var4 = this.field0190.method0492();
            var5 = this.field0470.method0492();
            var6 = this.field1627.method0492();
         }

         var3.method_46416(var4, var5, var6);
      }
   }
}
