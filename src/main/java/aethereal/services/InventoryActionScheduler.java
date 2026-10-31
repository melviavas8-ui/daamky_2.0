package aethereal;

import java.util.List;
import lombok.Generated;
import net.minecraft.class_304;
import net.minecraft.class_3675;

public final class InventoryActionScheduler implements MinecraftAccess {
   public static final DelayedAction field0649 = new DelayedAction();
   public static final DelayedAction field0078 = new DelayedAction();
   public static boolean field1527 = true;
   private static final Module field1003 = new InventoryActionScheduler.InventoryModule();

   public static void method0578() {
      field0649.method2078();
   }

   public static void method0025() {
      field0078.method2078();
   }

   public static void method0991(Runnable var0) {
      if (field0649.method0026() && MovementHelper.method1635()) {
         String var1 = ServerEnvironment.field0715;
         switch (var1) {
            case "FunTime":
               field0649.method0578();
               field0649.method0765(1, () -> {
                  method2078();
                  method0430();
               }, 0);
               field0649.method0765(2, () -> {
                  var0.run();
                  method1812();
               }, 0);
               return;
            case "ReallyWorld":
               if (field0796.field_1724 != null && field0796.field_1724.method_24828()) {
                  field0649.method0578();
                  field0649.method0765(1, InventoryActionScheduler::method2078, 0);
                  field0649.method0765(2, InventoryActionScheduler::method0430, 0);
                  field0649.method0765(3, var0::run, 0);
                  field0649.method0765(4, InventoryActionScheduler::method1812, 0);
                  return;
               }
               break;
            case "SpookyTime":
            case "CopyTime":
               field0649.method0578();
               field0649.method0765(1, () -> {
                  method2078();
                  method0430();
               }, 0);
               field0649.method0765(2, var0::run, 0);
               field0649.method0765(3, InventoryActionScheduler::method1812, 0);
               return;
         }
      }

      field0649.method0765(1, InventoryActionScheduler::method0430, 0);
      field0078.method0578();
      field0078.method0765(1, () -> {
         var0.run();
         InventorySearch.method1570(true);
      }, 0);
   }

   private static void method0430() {
   }

   public static void method2078() {
      field1527 = false;
      method1634();
   }

   public static void method1812() {
      InventorySearch.method1570(true);
      field1527 = true;
      method1973();
   }

   public static void method1634() {
      if (field0796.field_1690 != null) {
         for (class_304 var1 : method0370()) {
            var1.method_23481(false);
         }
      }
   }

   public static void method1973() {
      if (field0796.field_1690 != null && field0796.method_22683() != null) {
         for (class_304 var1 : method0370()) {
            var1.method_23481(class_3675.method_15987(field0796.method_22683().method_4490(), var1.method_1429().method_1444()));
         }
      }
   }

   private static List<class_304> method0370() {
      return List.of(
         field0796.field_1690.field_1894,
         field0796.field_1690.field_1881,
         field0796.field_1690.field_1913,
         field0796.field_1690.field_1849,
         field0796.field_1690.field_1903
      );
   }

   @Generated
   private InventoryActionScheduler() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   private static final class InventoryModule extends Module {
      InventoryModule() {
         super("InvPipelineRot", ModuleCategory.field0776, "Internal rotation provider for InvPipeline");
         this.method1570(true);
      }
   }
}
