package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_5498;

public class VisualSpin extends Module {
   private final FloatSetting field0060 = new FloatSetting("visualspin.yawspeed", 60.0F, 5.0F, 360.0F, 5.0F)
      .method1007("Yaw Speed")
      .method0210("Yaw rotation speed (degrees per tick)")
      .method2130("Скорость yaw (градусов/тик)");
   private final FloatSetting field1450 = new FloatSetting("visualspin.pitchamp", 30.0F, 0.0F, 90.0F, 5.0F)
      .method1007("Pitch Amplitude")
      .method0210("Maximum pitch deviation in degrees")
      .method2130("Амплитуда колебаний питча (градусов)");
   private final FloatSetting field0985 = new FloatSetting("visualspin.pitchspeed", 12.0F, 1.0F, 60.0F, 1.0F)
      .method1007("Pitch Speed")
      .method0210("Pitch oscillation speed")
      .method2130("Скорость колебаний питча");
   private final BooleanSetting field0184 = new BooleanSetting("visualspin.onlyf5", true)
      .method1007("Only In F5")
      .method0210("Only spin when in third-person view")
      .method2130("Только в третьем лице (F5)");
   private final BooleanSetting field0464 = new BooleanSetting("visualspin.requireaura", false)
      .method1007("Require Aura Active")
      .method0210("Spin pitch only when aura is targeting (safer)")
      .method2130("Спинить питч только когда аура активна (безопаснее)");
   private float field1614 = 0.0F;
   private float field1538 = 0.0F;

   public VisualSpin() {
      super("VisualSpin", ModuleCategory.field1004, "Local-only visual rotation spin (server and other players see normal rotation)");
      this.method1013("Локальный визуальный спин (сервер и другие игроки видят обычную ротацию)");
   }

   @Override
   public void method2078() {
      super.method2078();
      this.field1614 = 0.0F;
      this.field1538 = 0.0F;
   }

   private boolean method1736() {
      return method1974() ? false : !this.field0184.method0492() || field0796.field_1690.method_31044() != class_5498.field_26664;
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (this.method1736()) {
         this.field1614 = (this.field1614 + this.field0060.method0492()) % 360.0F;
         this.field1538 = (this.field1538 + this.field0985.method0492()) % 360.0F;
      }
   }

   @EventHandler
   public void onPostMovement(PostMovementTickEvent var1) {
      if (this.method1736()) {
         field0796.field_1724.method_5636(this.field1614);
         field0796.field_1724.method_5847(this.field1614);
         field0796.field_1724.field_6220 = this.field1614;
         field0796.field_1724.field_6259 = this.field1614;
         boolean var2 = RotationManager.field0618.method1606() != null;
         if ((!this.field0464.method0492() || var2) && var2) {
            float var3 = (float)Math.sin(Math.toRadians(this.field1538)) * this.field1450.method0492();
            field0796.field_1724.method_36457(var3);
         }
      }
   }
}
