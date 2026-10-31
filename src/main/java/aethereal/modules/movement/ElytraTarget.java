package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1309;
import net.minecraft.class_238;
import net.minecraft.class_243;

public class ElytraTarget extends Module {
   private final BooleanSetting field0034 = new BooleanSetting("elytratarget.customrot", true)
      .method1007("Custom rotations")
      .method2130("Своя ротация на цель в полёте");
   private final BooleanSetting field1432 = new BooleanSetting("elytratarget.sharp", false, this.field0034::method0492)
      .method1007("Sharp")
      .method2130("Более резкие повороты");
   private final BooleanSetting field0970 = new BooleanSetting("elytratarget.autodistance", true)
      .method1007("Auto distance")
      .method2130("Корректировка точки прицеливания по дистанции");
   private final EnumSetting<TargetPointMode> field0189 = new EnumSetting<>("elytratarget.rotateat", TargetPointMode.field0102)
      .method1007("Rotate at")
      .method2130("Точка прицеливания на цели");
   private final BooleanSetting field0464 = new BooleanSetting("elytratarget.prediction", true)
      .method1007("Prediction")
      .method2130("Предсказание движения цели");
   private final EnumSetting<ElytraPredictionMode> field1626 = new EnumSetting<>("elytratarget.predictmode", ElytraPredictionMode.field0673, this.field0464::method0492)
      .method1007("Mode")
      .method2130("Алгоритм предсказания");
   private final BooleanSetting field1544 = new BooleanSetting("elytratarget.glidingonly", true, this.field0464::method0492)
      .method1007("Gliding only")
      .method2130("Предсказывать только летящих");
   private final FloatSetting field1716 = new FloatSetting("elytratarget.multiplier", 1.8F, 0.5F, 6.0F, 0.1F, this.field0464::method0492)
      .method1007("Multiplier")
      .method2130("Множитель предсказания");
   private final FloatSetting field1144 = new FloatSetting("elytratarget.findrange", 32.0F, 0.0F, 96.0F, 1.0F)
      .method1007("Find Range")
      .method2130("Доп. дистанция поиска цели в полёте");
   private final FloatSetting field1097 = new FloatSetting("elytratarget.reach", 3.0F, 2.5F, 3.0F, 0.05F)
      .method1007("Elytra Reach")
      .method2130("Дистанция удара в глайде. Hard cap 3.0 — Grim cancellит выше");
   private final BooleanSetting field1201 = new BooleanSetting("elytratarget.autofirework", true)
      .method1007("Auto Firework")
      .method2130("Автоматически кидать фейерверк при догоне цели");
   private final FloatSetting field0881 = new FloatSetting("elytratarget.fwclosing", 0.6F, 0.0F, 2.0F, 0.05F, this.field1201::method0492)
      .method1007("FW Min Closing")
      .method2130("Минимальная скорость сближения для кидка");
   private final FloatSetting field0836 = new FloatSetting("elytratarget.fwcooldown", 6.0F, 4.0F, 30.0F, 1.0F, this.field1201::method0492)
      .method1007("FW Cooldown")
      .method2130("Минимальный интервал между фейерверками в тиках");
   private final FloatSetting field0919 = new FloatSetting("elytratarget.spamdistance", 14.0F, 5.0F, 40.0F, 1.0F, this.field1201::method0492)
      .method1007("Spam Distance")
      .method2130("Дистанция для агрессивного догона");
   private final ElytraMovementPredictor field1345 = new ElytraMovementPredictor(this.field0464, this.field1626, this.field1544, this.field1716);
   private final ElytraRotationController field1298 = new ElytraRotationController(this, this.field1345);
   private final ElytraTargetController field1373 = new ElytraTargetController(this, this.field1201, this.field0881, this.field0836, this.field0919);

   public static ElytraTarget method1710() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(ElytraTarget.class) : null;
   }

   public ElytraTarget() {
      super("ElytraTarget", ModuleCategory.field0088, "Predictive rotation on the elytra target");
      this.method1013("Прицеливание на цель в полёте на элитрах");
   }

   public boolean method1692() {
      return this.field0034.method1938();
   }

   public boolean method1755() {
      return this.field1432.method1938();
   }

   public boolean method2030() {
      return this.field0970.method1938();
   }

   public TargetPointMode method2008() {
      return this.field0189.method0492();
   }

   public float method2035() {
      return field0796.field_1724 != null && field0796.field_1724.method_6128() ? this.field1144.method0492() : 0.0F;
   }

   public float method0461() {
      return Math.min(this.field1097.method0492(), 3.0F);
   }

   @Override
   public void method2078() {
      this.field1373.method0578();
      super.method2078();
   }

   @EventHandler
   public void onRotationUpdate(RotationUpdateEvent var1) {
      if (var1.method1760() == 0) {
         this.field1298.method0025();
      }
   }

   @EventHandler
   public void onPlayerTick(PlayerTickEvent var1) {
      this.field1373.method0025();
   }

   public class_243 method1157(class_1309 var1) {
      return var1 == null ? null : var1.method_19538().method_1031(0.0, var1.method_17682() * 0.5, 0.0);
   }

   public class_238 method1169(class_1309 var1, class_243 var2) {
      if (var1 != null && var2 != null) {
         double var3 = var1.method_17681() * 0.5;
         double var5 = var1.method_17682() * 0.5;
         return new class_238(
            var2.field_1352 - var3, var2.field_1351 - var5, var2.field_1350 - var3, var2.field_1352 + var3, var2.field_1351 + var5, var2.field_1350 + var3
         );
      } else {
         return null;
      }
   }
}
