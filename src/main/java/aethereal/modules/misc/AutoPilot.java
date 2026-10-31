package aethereal;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1542;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_2828.class_2830;

public class AutoPilot extends Module {
   private static final class_310 field1045 = class_310.method_1551();
   public class_1542 field0151;
   private float field0177;
   private float field0458;
   private float field1614;
   private float field1538;
   Rotation field1466 = new Rotation(0.0F, 0.0F);

   public AutoPilot() {
      super("AutoPilot", ModuleCategory.field0776, "It automatically flies to the selected coordinates");
      this.method1013("Автоматически летит на выбранные координаты с помощью элитры");
   }

   public static AutoPilot method1703() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(AutoPilot.class) : null;
   }

   @EventHandler
   public void onTick(PlayerTickEvent var1) {
      if (field1045.field_1724 != null && field1045.field_1687 != null && field1045.method_1562() != null) {
         this.field0151 = this.method1690();
         if (this.field0151 != null) {
            double var2 = this.field0151.method_19538().method_10216() - field1045.field_1724.method_19538().method_10216();
            double var4 = this.field0151.method_19538().method_10214()
               - (field1045.field_1724.method_19538().method_10214() + field1045.field_1724.method_18381(field1045.field_1724.method_18376()));
            double var6 = this.field0151.method_19538().method_10215() - field1045.field_1724.method_19538().method_10215();
            this.field1614 = (float)(Math.atan2(var6, var2) * 180.0 / 3.1415933129668367 - 90.0);
            this.field1538 = (float)(-Math.atan2(var4, Math.sqrt(var2 * var2 + var6 * var6)) * 180.0 / 3.1415933129668367);
            float var8 = 1024.0F;
            float var9 = class_3532.method_15393(this.field1614 - this.field0177);
            float var10 = class_3532.method_15363(var9, -var8, var8);
            this.field0177 += var10;
            float var11 = class_3532.method_15393(this.field1538 - this.field0458);
            float var12 = class_3532.method_15363(var11, -var8, var8);
            this.field0458 += var12;
            field1045.field_1724.method_36456(this.field0177);
            field1045.field_1724.method_36457(this.field0458);
            this.field1466.method1822(this.field0177);
            this.field1466.method1638(this.field0458);
            RotationManager.field0618.method0875(this.field1466, RotationHandler.field0654, RotationPriority.field0778, this);
         } else {
            this.field0177 = field1045.field_1724.method_36454();
            this.field0458 = field1045.field_1724.method_36455();
         }
      } else {
         this.field0151 = null;
      }
   }

   private class_1542 method1690() {
      List var1 = field1045.field_1687
         .method_8390(class_1542.class, field1045.field_1724.method_5829().method_1014(50.0), var1x -> var1x.method_5805() && this.method1176(var1x))
         .stream()
         .sorted(Comparator.comparingDouble(var0 -> field1045.field_1724.method_5858(var0)))
         .collect(Collectors.toList());
      return var1.isEmpty() ? null : var1.get(0);
   }

   private boolean method1176(class_1542 var1) {
      class_1799 var2 = var1.method_6983();
      return var2.method_7909() == class_1802.field_8849
         || var2.method_7909() == class_1802.field_8575
         || var2.method_7909() == class_1802.field_8367
         || var2.method_7909().toString().contains("_spawn_egg");
   }

   @Override
   public void method2078() {
      this.field0151 = null;
      if (field1045.field_1724 != null) {
         field1045.method_1562()
            .method_52787(
               new class_2830(
                  field1045.field_1724.method_19538().method_10216(),
                  field1045.field_1724.method_19538().method_10214(),
                  field1045.field_1724.method_19538().method_10215(),
                  field1045.field_1724.method_36454(),
                  field1045.field_1724.method_36455(),
                  field1045.field_1724.method_24828(),
                  false
               )
            );
      }

      super.method2078();
   }
}
