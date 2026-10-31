package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2879;
import net.minecraft.class_2886;
import net.minecraft.class_3965;
import net.minecraft.class_239.class_240;

public class Spider extends Module {
   private final EnumSetting<Spider.Mode> field0058 = new EnumSetting<>("spider.mode", Spider.Mode.field1487)
      .method1007("Mode")
      .method0210("Climbing method to use")
      .method2130("Режим");
   private long field1412;
   private long field0959;
   private int field0178;

   public Spider() {
      super("Spider", ModuleCategory.field0088, "Allows climbing any block like a spider");
      this.method1013("Позволяет по блокам");
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         switch ((Spider.Mode)this.field0058.method0492()) {
            case field0689:
               this.method1691();
               break;
            case field0113:
               this.method1754();
               break;
            case field1487:
               this.method2029();
               break;
            case field1016:
               this.method1735();
         }
      }
   }

   @Override
   public void method2078() {
      if (field0796.field_1690 != null) {
         field0796.field_1690.field_1903.method_23481(false);
      }

      super.method2078();
   }

   private void method1735() {
      if (field0796.field_1724.method_6047().method_7909() == class_1802.field_8705) {
         if (field0796.field_1724.field_5976) {
            field0796.field_1761.method_2919(field0796.field_1724, class_1268.field_5808);
            field0796.field_1724.method_6104(class_1268.field_5808);
            field0796.field_1724
               .method_18800(field0796.field_1724.method_18798().field_1352, 0.30000017937458284, field0796.field_1724.method_18798().field_1350);
         }
      }
   }

   private void method1691() {
      long var1 = System.currentTimeMillis();
      if (var1 - this.field1412 >= 310L) {
         if (field0796.field_1724.method_6047().method_7909() == class_1802.field_8705) {
            if (field0796.field_1724.field_5976) {
               field0796.field_1724
                  .field_3944
                  .method_52787(new class_2886(class_1268.field_5808, 0, field0796.field_1724.method_36454(), field0796.field_1724.method_36455()));
               field0796.field_1724.field_3944.method_52787(new class_2879(class_1268.field_5808));
               field0796.field_1724
                  .method_18800(field0796.field_1724.method_18798().field_1352, 0.3500000625851053, field0796.field_1724.method_18798().field_1350);
               this.field1412 = var1;
            }
         }
      }
   }

   private void method1754() {
      long var1 = System.currentTimeMillis();
      if (var1 - this.field0959 >= 400L) {
         if (!field0796.field_1690.field_1903.method_1434()) {
            if (field0796.field_1724.field_5976) {
               field0796.field_1724.method_24830(true);
               field0796.field_1724.method_6043();
               this.field0959 = var1;
            }
         }
      }
   }

   private void method2029() {
      if (field0796.field_1724.field_5976 && !(field0796.field_1724.method_18798().field_1351 <= -1.0)) {
         class_2338 var1 = field0796.field_1724.method_24515();
         boolean var2 = this.method1270(var1.method_10078(), class_2246.field_10030)
            || this.method1270(var1.method_10067(), class_2246.field_10030)
            || this.method1270(var1.method_10095(), class_2246.field_10030)
            || this.method1270(var1.method_10072(), class_2246.field_10030);
         if (var2) {
            if (field0796.field_1765 instanceof class_3965 var3 && var3.method_17783() == class_240.field_1332) {
               if (!field0796.field_1687.method_8320(var3.method_17777()).method_26215()) {
                  int var7 = InventorySlotHelper.method1217(class_1802.field_8828);
                  if (var7 != -1) {
                     int var5 = field0796.field_1724.method_31548().field_7545;
                     field0796.field_1724.method_31548().field_7545 = var7;
                     class_3965 var6 = new class_3965(var3.method_17784(), var3.method_17780(), var3.method_17777(), false);
                     field0796.field_1761.method_2896(field0796.field_1724, class_1268.field_5808, var6);
                     field0796.field_1724.method_6104(class_1268.field_5808);
                     this.field0178++;
                     if (this.field0178 >= 1) {
                        field0796.field_1724
                           .method_18800(field0796.field_1724.method_18798().field_1352, 0.629999766945848, field0796.field_1724.method_18798().field_1350);
                        this.field0178 = 0;
                     }

                     field0796.field_1724.method_31548().field_7545 = var5;
                  }
               }
            }
         }
      }
   }

   private boolean method1270(class_2338 var1, class_2248 var2) {
      return field0796.field_1687.method_8320(var1).method_26204() == var2;
   }

   public enum Mode implements DisplayNamed {
      field0689("SpookyTime"),
      field0113("FunTime"),
      field1487("Slime Block"),
      field1016("Water Bucket");

      private final String field0791;

      Mode(String var3) {
         this.field0791 = var3;
      }

      @Override
      public String method0557() {
         return this.field0791;
      }
   }
}
