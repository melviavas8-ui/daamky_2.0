package aethereal;

import net.minecraft.class_310;

public class Customization extends Module {
   public static boolean field0169 = false;
   public static EspTargetType field1475 = EspTargetType.field0670;
   public static EspDisplayMode field1008 = EspDisplayMode.field0669;
   private final ConditionalBooleanSetting field0186 = new ConditionalBooleanSetting("customization.openpanel", Customization::method1735)
      .method1007("Open Customization");

   public Customization() {
      super("Customization", ModuleCategory.field1004, "Unified visual customization panel.");
      this.method1013("Единая панель кастомизации");
   }

   public static void method1735() {
      class_310 var0 = class_310.method_1551();
      if (var0 != null) {
         var0.method_1507(new CustomizationScreen());
      }
   }
}
