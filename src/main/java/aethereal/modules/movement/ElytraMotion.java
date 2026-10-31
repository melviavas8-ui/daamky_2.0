package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1309;
import net.minecraft.class_243;

public class ElytraMotion extends Module {
   public final FloatSetting field0060 = new FloatSetting("elytramotion.distance", 3.0F, 0.1F, 5.0F, 0.1F)
      .method1007("Distance")
      .method0210("Freeze when target is within this distance")
      .method2130("Дистанция");
   private boolean field1527;
   private class_243 field1043 = class_243.field_1353;

   public static ElytraMotion method1709() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(ElytraMotion.class) : null;
   }

   public ElytraMotion() {
      super("ElytraMotion", ModuleCategory.field0088, "Freezes the player while targeting on elytra");
      this.method1013("Замораживает игрока при таргете на элитрах");
   }

   @Override
   public void method2078() {
      this.field1527 = false;
      super.method2078();
   }

   @EventHandler
   public void onPlayerTick(PlayerTickEvent var1) {
      if (!method1974()) {
         if (field0796.field_1724.method_6128()) {
            this.field1043 = field0796.field_1724.method_19538();
         }

         this.field1527 = this.method1692();
      }
   }

   @EventHandler
   public void onMove(MovementEvent var1) {
      if (!method1974()) {
         if (this.field1527) {
            field0796.field_1724.method_33574(this.field1043);
            field0796.field_1724.method_18799(class_243.field_1353);
            var1.method1300(class_243.field_1353);
         }
      }
   }

   private boolean method1692() {
      if (!field0796.field_1724.method_6128()) {
         return false;
      }

      Aura var1 = Aura.method1701();
      if (var1 == null) {
         return false;
      }

      class_1309 var2 = var1.method0409();
      return var2 == null ? false : var2.method_5739(field0796.field_1724) < this.field0060.method0492();
   }
}
