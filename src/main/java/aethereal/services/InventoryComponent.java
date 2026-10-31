package aethereal;

import java.util.List;
import lombok.Generated;
import net.minecraft.class_304;
import net.minecraft.class_3675;
import net.minecraft.class_463;
import net.minecraft.class_471;
import net.minecraft.class_497;
import net.minecraft.class_498;

public final class InventoryComponent implements MinecraftAccess {
   public static final List<class_304> field0719 = List.of(
      field0796.field_1690.field_1894,
      field0796.field_1690.field_1881,
      field0796.field_1690.field_1913,
      field0796.field_1690.field_1849,
      field0796.field_1690.field_1903
   );
   public static final ActionSequence field0076 = new ActionSequence();
   public static final ActionSequence field1462 = new ActionSequence();
   public static boolean field1049 = true;

   public static void method0578() {
      field0076.method1634();
   }

   public static void method0025() {
      field1462.method1634();
   }

   public static void method0888(KeyboardInputEvent var0) {
      if (!field1049) {
         var0.method1812();
      }
   }

   public static void method0991(Runnable var0) {
      if (field0076.method1974() && MovementState.method0579()) {
         switch (ServerEnvironment.field0715) {
            case "FunTime":
               field0076.method1778().method0154(0, () -> {
                  method2078();
                  method0375();
               }).method0154(1, () -> {
                  var0.run();
                  method1812();
               });
               return;
            case "ReallyWorld":
               if (field0796.field_1724.method_24828()) {
                  field0076.method1778()
                     .method0154(0, InventoryComponent::method2078)
                     .method0154(2, InventoryComponent::method0375)
                     .method0154(3, var0::run)
                     .method0154(4, InventoryComponent::method1812);
                  return;
               }
               break;
            case "SpookyTime":
            case "CopyTime":
               field0076.method1778().method0154(0, () -> {
                  method2078();
                  method0375();
               }).method0154(1, var0::run).method0154(2, InventoryComponent::method1812);
               return;
         }
      }

      field0076.method0154(0, InventoryComponent::method0375);
      field1462.method1778().method0154(0, () -> {
         var0.run();
         InventoryClickManager.method1570(true);
      });
   }

   private static void method0375() {
      Module var0 = new Module("InventoryComponent", ModuleCategory.field1470, "Inventory Component") {};
      var0.method2178(true);
      RotationManager.field0618.method0875(RotationHelper.method0545(), RotationHandler.field0654, RotationPriority.field1476, var0);
   }

   public static void method2078() {
      field1049 = false;
      method1634();
   }

   public static void method1812() {
      InventoryClickManager.method1570(true);
      field1049 = true;
      method1973();
   }

   public static void method1634() {
      field0719.forEach(var0 -> var0.method_23481(false));
   }

   public static void method1973() {
      field0719.forEach(var0 -> var0.method_23481(class_3675.method_15987(field0796.method_22683().method_4490(), var0.method_1429().method_1444())));
   }

   public static boolean method0431() {
      return field0796.field_1755 != null
         && !PlayerActionHelper.method1451(field0796.field_1755)
         && !(field0796.field_1755 instanceof class_498)
         && !(field0796.field_1755 instanceof class_471)
         && !(field0796.field_1755 instanceof class_463)
         && !(field0796.field_1755 instanceof class_497)
         && !(field0796.field_1755 instanceof ClickGuiScreen);
   }

   @Generated
   private InventoryComponent() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
