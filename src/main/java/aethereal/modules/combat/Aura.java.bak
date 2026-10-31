package aethereal;

import java.util.Arrays;
import java.util.Objects;
import lombok.Generated;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1743;
import net.minecraft.class_1799;
import net.minecraft.class_1829;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2663;
import net.minecraft.class_3532;
import net.minecraft.class_3545;
import net.minecraft.class_9362;

public class Aura extends Module {
   private static final float field0458 = 0.253F;
   private TargetSelector field1622 = new TargetSelector();
   private AttackPrediction field1548 = new AttackPrediction();
   private final AuraAttackHandler field1722 = new AuraAttackHandler();
   private final TargetFinder field1150 = new TargetFinder();
   private class_1309 field1106;
   private class_1309 field1215;
   private long field0873 = 0L;
   public static boolean field0169;
   public static float field1410;
   private EnumSetting<Aura.AimMode> field0835 = new EnumSetting<>("aura.aimMode", Aura.AimMode.field0575)
      .method1007("Aim Mode")
      .method0210("Rotation algorithm used when aiming at targets")
      .method2130("Тип ротации");
   private EnumSetting<Aura.CorrectionMode> field0918 = new EnumSetting<>("aura.correctionType", Aura.CorrectionMode.field0576)
      .method1007("Movement Correction")
      .method0210("How player movement is corrected during rotation")
      .method2130("Тип коррекции движения");
   private EnumSetting<Aura.SprintResetMode> field1340 = new EnumSetting<>("aura.sprintReset", Aura.SprintResetMode.field0577)
      .method1007("Sprint Reset")
      .method0210("How sprint is reset before landing a hit")
      .method2130("Тип сброса спринта");
   private MultiSelectSetting field1306 = new MultiSelectSetting(
         "aura.targetType", Arrays.asList("Players", "Naked", "Mobs", "Animals", "Friends", "Armor Stand"), false, () -> true
      )
      .method1007("Target Type")
      .method0210("Entity types that can be attacked")
      .method2130("Типы сущностей, которые можно атаковать");
   private FloatSetting field1377 = new FloatSetting("aura.attackRange", 3.0F, 1.0F, 6.0F, 0.1F)
      .method1007("Attack Range")
      .method0210("Maximum distance at which targets are attacked")
      .method2130("Дистанция атаки");
   private FloatSetting field0393 = new FloatSetting("aura.lookRange", 1.5F, 0.0F, 4.0F, 0.1F)
      .method1007("Look Range")
      .method0210("Additional distance used for target rotation before attack range is reached")
      .method2130("Дополнительная дистанция для ротации");
   private FloatSetting field0360 = new FloatSetting(
         "aura.preDistance", 0.3F, 0.0F, 3.0F, 0.1F, () -> this.field0835.method0492() == Aura.AimMode.field1416
      )
      .method1007("Pre Distance")
      .method0210("Extra distance used by Neuro mode for tracking before attack range")
      .method2130("Дополнительная дистанция для ротации в режиме Neuro");
   private MultiSelectSetting field0435 = new MultiSelectSetting(
         "aura.attackSetting",
         Arrays.asList(
            "Only Critical",
            "Break Shield",
            "Always Shield",
            "Raytrace",
            "UnPress Shield",
            "No Attack When Eat",
            "Ignore The Walls",
            "No Attack In Container",
            "Only Weapon"
         ),
         false,
         () -> true
      )
      .method1007("Attack Options")
      .method0210("Additional hit behavior options")
      .method2130("Дополнительные параметры удара");
   private BooleanSetting field0259 = new BooleanSetting("aura.smartCriticals", false, () -> this.field0435.method0387("Only Critical"))
      .method1007("Smart Criticals")
      .method0210("Crit only while jump key is held; otherwise hit normally")
      .method2130("Ударяет критами только с пробелом");
   private BooleanSetting field0229 = new BooleanSetting("aura.hitDelay", false, () -> this.field0835.method0492() == Aura.AimMode.field1416)
      .method1007("Hit Delay")
      .method0210("Adds a random delay before each hit in Neuro mode")
      .method2130("Случайная задержка перед ударом в режиме Neuro");
   private FloatSetting field0295 = new FloatSetting(
         "aura.hitDelayMin", 0.0F, 0.0F, 300.0F, 10.0F, () -> this.field0835.method0492() == Aura.AimMode.field1416 && this.field0229.method1938()
      )
      .method1007("Hit Delay Min (ms)")
      .method0210("Minimum hit delay in milliseconds")
      .method2130("Минимальная задержка удара в мс");
   private FloatSetting field0529 = new FloatSetting(
         "aura.hitDelayMax", 50.0F, 0.0F, 500.0F, 10.0F, () -> this.field0835.method0492() == Aura.AimMode.field1416 && this.field0229.method1938()
      )
      .method1007("Hit Delay Max (ms)")
      .method0210("Maximum hit delay in milliseconds")
      .method2130("Максимальная задержка удара в мс");
   private BooleanSetting field0503 = new BooleanSetting(
         "aura.throughWallsBypass", true, () -> this.field0835.method0492() == Aura.AimMode.field1416 && this.field0435.method0387("Ignore The Walls")
      )
      .method1007("Through Walls Bypass")
      .method0210("Sends fake block break packets to land hits through walls")
      .method2130("Обход через стены через фейк-пакеты ломания блоков");
   public static boolean field1049;
   public boolean field0219 = false;
   private boolean field0558 = false;

   public static Aura method1701() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(Aura.class) : null;
   }

   public Aura() {
      super("Aura", ModuleCategory.field0661, "Automatically attacks nearby entities");
      this.method1013("Автоматически атакует ближайшие цели");
   }

   @Override
   public void method0025() {
      this.field1622.method0578();
      this.field1150.method0025();
      this.field1106 = null;
      this.field1722.method0578();
      super.method0025();
   }

   @Override
   public void method2078() {
      this.field1622.method0578();
      this.field1150.method0025();
      this.field1106 = null;
      this.field1722.method0578();
      super.method2078();
   }

   @EventHandler
   public void onKeyboard(KeyboardEvent var1) {
      if (this.method2195()) {
         if (!PlayerActionHelper.method1813()) {
            Rotation var2 = RotationManager.field0618.method2219();
            if (var2 != null) {
               switch ((Aura.CorrectionMode)this.field0918.method0492()) {
                  case field0576:
                     MovementHelper.method0886(var1, var2.method2047());
                     break;
                  case field0011:
                     if (this.field1106 == null) {
                        return;
                     }

                     MovementHelper.method0887(var1, var2.method2047(), MovementHelper.method1125(this.field1106));
               }
            }
         }
      }
   }

   @EventHandler
   public void onPacketReceive(PacketEvent.Inbound var1) {
      if (var1.method1970() instanceof class_2663 var2 && var2.method_11470() == 30) {
         class_1297 var4 = var2.method_11469(field0796.field_1687);
         if (var4 != null && var4.equals(this.field1106)) {
         }
      }
   }

   @EventHandler
   public void tick(PlayerTickEvent var1) {
      if (!PlayerActionHelper.method1813()) {
         if (this.field1106 != null) {
            if (this.method1755() && this.field1722.method2147(this.field1106, this)) {
               Sprint.field0004 = 2;
               field0796.field_1690.field_1867.method_23481(false);
               field0796.field_1724.method_5728(false);
            }
         }
      }
   }

   @EventHandler
   public void onRotationUpdate(RotationUpdateEvent var1) {
      if (this.field0435.method0387("No Attack In Container") && this.method1899()) {
         this.field1106 = null;
      } else if (this.field0435.method0387("Only Weapon") && !this.method1943()) {
         this.field1106 = null;
      } else {
         switch (var1.method1760()) {
            case 0:
               this.field1106 = this.method1941();
               if (this.field1106 != null) {
                  if (this.method1755() && field0796.field_1724.method_33571().method_1022(this.method2145(this.field1106)) > this.method1679()) {
                     this.field1150.method0025();
                     this.field1106 = null;
                     return;
                  }

                  this.method0813(this.method2005());
                  this.field1215 = this.field1106;
               }
               break;
            case 2:
               if (this.field1106 != null) {
                  if (this.method1755()) {
                     this.field1722.method1167(this.field1106, this);
                  } else {
                     DaamkyClient.method2004().method1881().method0813(this.method2005());
                  }
               }
         }
      }
   }

   private class_243 method2145(class_1309 var1) {
      class_243 var2 = field0796.field_1724.method_33571();
      class_238 var3 = var1.method_5829();
      return new class_243(
         class_3532.method_15350(var2.field_1352, var3.field_1323, var3.field_1320),
         class_3532.method_15350(var2.field_1351, var3.field_1322, var3.field_1325),
         class_3532.method_15350(var2.field_1350, var3.field_1321, var3.field_1324)
      );
   }

   public float method1679() {
      return field0796.field_1724.method_6128() ? 20.0F : this.field1377.method0492() + this.field0360.method0492();
   }

   private boolean method1899() {
      return field0796.field_1724 != null && field0796.field_1724.field_7512 != field0796.field_1724.field_7498;
   }

   private boolean method1943() {
      if (field0796.field_1724 == null) {
         return false;
      }

      class_1799 var1 = field0796.field_1724.method_6047();
      return var1 != null && !var1.method_7960()
         ? var1.method_7909() instanceof class_1829 || var1.method_7909() instanceof class_1743 || var1.method_7909() instanceof class_9362
         : false;
   }

   public boolean method1755() {
      return this.field0835.method0492() == Aura.AimMode.field1416;
   }

   public float method2018() {
      return this.field1377.method0492();
   }

   private class_1309 method1941() {
      if (this.method1755()) {
         return this.field1150.method0707(this.method1679(), this.field1306.method1936());
      }

      TargetSelector.TargetScore var1 = new TargetSelector.TargetScore(this.field1306.method1936());
      ElytraTarget var2 = ElytraTarget.method1710();
      float var3 = field0796.field_1724.method_6128() && var2 != null && var2.method2195() ? var2.method2035() : this.field0393.method0492();
      float var4 = this.field1377.method0492() + 0.253F + var3;
      boolean var5 = this.field0435.method0387("Ignore The Walls");
      float var6 = 360.0F;
      this.field1622.method0986(field0796.field_1687.method_18112(), var4, var6, var5);
      this.field1622.method1105(var1::method1159);
      return this.field1622.method2074();
   }

   private void method0813(CombatController.CombatAction var1) {
      AttackController var2 = DaamkyClient.method2004().method1881().method2051();
      RotationManager var3 = RotationManager.field0618;
      Rotation.VectorRotation var4 = new Rotation.VectorRotation(var1.method0012(), var1.method0012().method0024());
      RotationHandler var5 = this.method2038();
      boolean var6 = field0796.field_1724.method_6128() && this.field0435.method0387("Elytra possibilities");
      if (field0169 && this.field1106 != null) {
         LonyGriefRotationStrategy var7 = new LonyGriefRotationStrategy();
         Rotation var8 = var7.method0874(var3.method0545(), var4.method0545(), var4.method0024(), this.field1106);
         var3.method0181(var8);
      }

      field0169 = false;
      switch ((Aura.AimMode)this.field0835.method0492()) {
         case field0575:
            var3.method0867(var4, this.field1106, 1, var5, RotationPriority.field0778, this);
            break;
         case field0010:
            var3.method0867(var4, this.field1106, 1, var5, RotationPriority.field0778, this);
            break;
         case field1416:
            var3.method0867(var4, this.field1106, 1, var5, RotationPriority.field0778, this);
      }

      if (field1049) {
         var3.method0867(var4, this.field1106, 1, var5, RotationPriority.field0778, this);
      }

      if (var6) {
         var3.method0867(var4, this.field1106, 1, var5, RotationPriority.field0778, this);
      }
   }

   public CombatController.CombatAction method2005() {
      float var1 = this.method1755() ? this.field1377.method0492() : this.field1377.method0492() + 0.253F;
      class_3545 var2 = this.field1548
         .method1163(
            this.field1106, var1, RotationManager.field0618.method0545(), this.method0464().method0569(), this.field0435.method0387("Ignore The Walls")
         );
      class_243 var3 = (class_243)var2.method_15442();
      class_238 var4 = (class_238)var2.method_15441();
      Rotation var5 = RotationHelper.method1296(var3.method_1020(Objects.requireNonNull(field0796.field_1724).method_33571()));
      return new CombatController.CombatAction(this.field1106, var5, var1, this.field0435.method1936(), var4);
   }

   public RotationHandler method2038() {
      boolean var1 = this.field0918.method0492() != Aura.CorrectionMode.field1417;
      boolean var2 = this.field0918.method0492() == Aura.CorrectionMode.field0576;
      return new RotationHandler(this.method0464(), var1, var2);
   }

   public RotationStrategy method0464() {
      if (field0796.field_1724.method_6128() && this.field0435.method0387("Elytra possibilities")) {
         return new LinearRotationStrategy();
      }

      return switch ((Aura.AimMode)this.field0835.method0492()) {
         case field0575 -> new FunTimeRotationStrategy();
         case field0010 -> new ReallyWorldRotationStrategy();
         case field1416 -> new NeuralRotationStrategy();
         default -> new FunTimeRotationStrategy();
      };
   }

   @Generated
   public void method0817(TargetSelector var1) {
      this.field1622 = var1;
   }

   @Generated
   public void method0812(AttackPrediction var1) {
      this.field1548 = var1;
   }

   @Generated
   public void method1158(class_1309 var1) {
      this.field1106 = var1;
   }

   @Generated
   public void method0240(class_1309 var1) {
      this.field1215 = var1;
   }

   @Generated
   public void method0778(long var1) {
      this.field0873 = var1;
   }

   @Generated
   public void method0834(EnumSetting<Aura.AimMode> var1) {
      this.field0835 = var1;
   }

   @Generated
   public void method0174(EnumSetting<Aura.CorrectionMode> var1) {
      this.field0918 = var1;
   }

   @Generated
   public void method2115(EnumSetting<Aura.SprintResetMode> var1) {
      this.field1340 = var1;
   }

   @Generated
   public void method0895(MultiSelectSetting var1) {
      this.field1306 = var1;
   }

   @Generated
   public void method0837(FloatSetting var1) {
      this.field1377 = var1;
   }

   @Generated
   public void method0175(FloatSetting var1) {
      this.field0393 = var1;
   }

   @Generated
   public void method2116(FloatSetting var1) {
      this.field0360 = var1;
   }

   @Generated
   public void method0183(MultiSelectSetting var1) {
      this.field0435 = var1;
   }

   @Generated
   public void method0796(BooleanSetting var1) {
      this.field0259 = var1;
   }

   @Generated
   public void method0166(BooleanSetting var1) {
      this.field0229 = var1;
   }

   @Generated
   public void method1837(FloatSetting var1) {
      this.field0295 = var1;
   }

   @Generated
   public void method1649(FloatSetting var1) {
      this.field0529 = var1;
   }

   @Generated
   public void method2111(BooleanSetting var1) {
      this.field0503 = var1;
   }

   @Generated
   public void method1876(boolean var1) {
      this.field0219 = var1;
   }

   @Generated
   public void method1676(boolean var1) {
      this.field0558 = var1;
   }

   @Generated
   public TargetSelector method0452() {
      return this.field1622;
   }

   @Generated
   public AttackPrediction method0474() {
      return this.field1548;
   }

   @Generated
   public AuraAttackHandler method0402() {
      return this.field1722;
   }

   @Generated
   public TargetFinder method0394() {
      return this.field1150;
   }

   @Generated
   public class_1309 method0409() {
      return this.field1106;
   }

   @Generated
   public class_1309 method0520() {
      return this.field1215;
   }

   @Generated
   public long method0513() {
      return this.field0873;
   }

   @Generated
   public EnumSetting<Aura.AimMode> method0524() {
      return this.field0835;
   }

   @Generated
   public EnumSetting<Aura.CorrectionMode> method2245() {
      return this.field0918;
   }

   @Generated
   public EnumSetting<Aura.SprintResetMode> method2241() {
      return this.field1340;
   }

   @Generated
   public MultiSelectSetting method2249() {
      return this.field1306;
   }

   @Generated
   public FloatSetting method2204() {
      return this.field1377;
   }

   @Generated
   public FloatSetting method2201() {
      return this.field0393;
   }

   @Generated
   public FloatSetting method2210() {
      return this.field0360;
   }

   @Generated
   public MultiSelectSetting method2274() {
      return this.field0435;
   }

   @Generated
   public BooleanSetting method2270() {
      return this.field0259;
   }

   @Generated
   public BooleanSetting method2276() {
      return this.field0229;
   }

   @Generated
   public FloatSetting method1922() {
      return this.field0295;
   }

   @Generated
   public FloatSetting method1920() {
      return this.field0529;
   }

   @Generated
   public BooleanSetting method1926() {
      return this.field0503;
   }

   @Generated
   public boolean method1897() {
      return this.field0219;
   }

   @Generated
   public boolean method1894() {
      return this.field0558;
   }

   public enum AimMode implements DisplayNamed {
      field0575("FunTime"),
      field0010("ReallyWorld"),
      field1416("Neuro");

      private final String field1030;

      AimMode(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }

   public enum CorrectionMode implements DisplayNamed {
      field0576("Free"),
      field0011("Focused"),
      field1417("Not Visible");

      private final String field1030;

      CorrectionMode(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }

   public enum SprintResetMode implements DisplayNamed {
      field0577("Legit"),
      field0012("Packet");

      private final String field1504;

      SprintResetMode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }
}
