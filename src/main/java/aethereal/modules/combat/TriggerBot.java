package aethereal;

import java.util.Arrays;
import java.util.Random;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1294;
import net.minecraft.class_1296;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1531;
import net.minecraft.class_1588;
import net.minecraft.class_1657;
import net.minecraft.class_2246;
import net.minecraft.class_3966;
import net.minecraft.class_4050;
import net.minecraft.class_239.class_240;

public class TriggerBot extends Module {
   public final MultiSelectSetting field0089 = new MultiSelectSetting(
         "triggerbot.targettype", Arrays.asList("Players", "Naked", "Mobs", "Animals", "Friends", "Armor Stand"), false, () -> true
      )
      .method1007("Target Type")
      .method0210("Entity types to attack")
      .method2130("Типы сущностей для атаки");
   public final BooleanSetting field1432 = new BooleanSetting("triggerbot.smartcrits", false)
      .method1007("Only Critical")
      .method0210("Only attack when a critical hit is possible")
      .method2130("Только в прыжке");
   public final BooleanSetting field0970 = new BooleanSetting("triggerbot.smartcriticals", false, () -> this.field1432.method0492())
      .method1007("Smart Criticals")
      .method0210("Crit only while jump key is held; otherwise hit normally")
      .method2130("Ударяет критами только с пробелом");
   public final StringSetting field0204 = new StringSetting("triggerbot.sprintreset", "Sprint reset mode").method1591("Legit", "Packet").method0440("Legit");
   public final MultiSelectSetting field0481 = new MultiSelectSetting("triggerbot.attacksetting", Arrays.asList("Hit Chance"), false, () -> true)
      .method1007("Attack Setting");
   public final FloatSetting field1627 = new FloatSetting("triggerbot.hitchance", 100.0F, 1.0F, 100.0F, 1.0F, () -> this.field0481.method0387("Hit Chance"))
      .method1007("Hit Chance")
      .method0210("Probability of attacking per tick")
      .method2130("Вероятность атаки");
   public class_1309 field1569;
   private final Random field1730 = new Random();

   public static TriggerBot method1724() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(TriggerBot.class) : null;
   }

   public TriggerBot() {
      super("TriggerBot", ModuleCategory.field0661, "Automatically attacks entities in crosshair");
      this.method1013("Автоматически атакует сущность в прицеле");
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         if (!(field0796.field_1724.method_7261(0.5F) < 1.0F)) {
            this.field1569 = this.method1753();
            if (this.field1569 != null) {
               if (this.field1432.method0492()) {
                  boolean var2 = !this.field0970.method0492() || field0796.field_1690.field_1903.method_1434();
                  if (var2 && !this.method1692()) {
                     return;
                  }
               }

               if (!this.field0481.method0387("Hit Chance") || !(this.field1730.nextFloat() * 100.0F > this.field1627.method0492())) {
                  ShiftTap.method1691();
                  field0796.field_1761.method_2918(field0796.field_1724, this.field1569);
                  field0796.field_1724.method_6104(class_1268.field_5808);
               }
            }
         }
      }
   }

   private boolean method1692() {
      SimulatedPlayerInput var1 = SimulatedPlayerInput.method0717(1);
      return this.method0805(var1) ? false : !var1.field0890 && var1.field1704 > 0.0F;
   }

   private boolean method0805(SimulatedPlayerInput var1) {
      return var1.method1531(class_1294.field_5919)
         || var1.method1531(class_1294.field_5902)
         || PlayerActionHelper.method1290(var1.field0214.method_1014(-9.999993965600388E-4), class_2246.field_10343)
         || var1.method0431()
         || var1.method1974()
         || var1.method1813()
         || !PlayerActionHelper.method1447(class_4050.field_18076, var1.field1521)
         || var1.field0732.method_31549().field_7479;
   }

   private class_1309 method1753() {
      return field0796.field_1765 instanceof class_3966 var1
            && var1.method_17783() == class_240.field_1331
            && var1.method_17782() instanceof class_1309 var2
            && this.method1159(var2)
         ? var2
         : null;
   }

   private boolean method1159(class_1309 var1) {
      if (var1 == field0796.field_1724) {
         return false;
      }

      if (var1.method_5805() && !var1.method_31481()) {
         boolean var2 = var1 instanceof class_1657;
         boolean var3 = var1 instanceof class_1588;
         boolean var4 = var1 instanceof class_1296;
         boolean var5 = var1 instanceof class_1531;
         if (var2) {
            if (!this.method2135("Friends") && FriendManager.method0538().method2135(var1.method_5477().getString())) {
               return false;
            } else {
               return this.method0241(var1) ? this.method2135("Naked") : this.method2135("Players");
            }
         } else if (var5) {
            return this.method2135("Armor Stand");
         } else if (var3) {
            return this.method2135("Mobs");
         } else {
            return var4 ? this.method2135("Animals") : false;
         }
      } else {
         return false;
      }
   }

   private boolean method2135(String var1) {
      BooleanSetting var2 = this.field0089.method0439(var1);
      return var2 != null && var2.method0492();
   }

   private boolean method0241(class_1309 var1) {
      return var1.method_6118(class_1304.field_6169).method_7960()
         && var1.method_6118(class_1304.field_6174).method_7960()
         && var1.method_6118(class_1304.field_6172).method_7960()
         && var1.method_6118(class_1304.field_6166).method_7960();
   }
}
