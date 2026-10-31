package aethereal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1294;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1842;
import net.minecraft.class_1844;
import net.minecraft.class_2868;
import net.minecraft.class_2886;
import net.minecraft.class_6880;
import net.minecraft.class_9334;
import net.minecraft.class_2828.class_2831;

public class AutoPotions extends Module {
   private final MultiSelectSetting field0089 = new MultiSelectSetting(
         "autopotions.potions",
         () -> true,
         Arrays.asList(
            method1055("heal", "Heal", true),
            method1055("speed", "Speed", true),
            method1055("strength", "Strength", true),
            method1055("fireresistance", "Fire Resistance", false)
         )
      )
      .method1007("Potions")
      .method0210("Potions to auto-use")
      .method2130("Виды зелий");
   private final FloatSetting field1450 = new FloatSetting("autopotions.health", 12.0F, 1.0F, 20.0F, 0.5F, () -> this.field0089.method0387("Heal"))
      .method1007("Health Threshold")
      .method0210("Use heal potion below this HP")
      .method2130("Использовать исцелку при");
   private final Map<String, Integer> field1033 = new HashMap<>();
   private static final int field0178 = 10;

   private static BooleanSetting method1055(String var0, String var1, boolean var2) {
      BooleanSetting var3 = new BooleanSetting("autopotions.potions." + var0, var2, () -> true);
      var3.method0442(var1);
      return var3;
   }

   public AutoPotions() {
      super("AutoPotions", ModuleCategory.field0661, "Automatically uses potions when needed");
      this.method1013("Автоматически использует зелья при необходимости");
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field1033.clear();
   }

   @EventHandler
   public void onPlayerTick(PlayerTickEvent var1) {
      if (!method1974() && field0796.field_1755 == null) {
         if (!field0796.field_1724.method_6115()) {
            this.field1033.entrySet().removeIf(var0 -> {
               var0.setValue(var0.getValue() - 1);
               return var0.getValue() <= 0;
            });
            if (this.field0089.method0387("Heal")
               && field0796.field_1724.method_6032() <= this.field1450.method0492()
               && !this.field1033.containsKey("healing")
               && this.method2135("healing")) {
               this.field1033.put("healing", 10);
            }

            if (this.field0089.method0387("Speed")
               && !field0796.field_1724.method_6059(class_1294.field_5904)
               && !this.field1033.containsKey("speed")
               && (this.method2135("speed") || this.method1847("speed"))) {
               this.field1033.put("speed", 10);
            }

            if (this.field0089.method0387("Strength")
               && !field0796.field_1724.method_6059(class_1294.field_5910)
               && !this.field1033.containsKey("strength")
               && (this.method2135("strength") || this.method1847("strength"))) {
               this.field1033.put("strength", 10);
            }

            if (this.field0089.method0387("Fire Resistance")
               && !field0796.field_1724.method_6059(class_1294.field_5918)
               && !this.field1033.containsKey("fire_resistance")
               && (this.method2135("fire_resistance") || this.method1847("fire_resistance"))) {
               this.field1033.put("fire_resistance", 10);
            }
         }
      }
   }

   private boolean method2135(String var1) {
      int var2 = this.method1061(var1, true);
      if (var2 == -1) {
         return false;
      }

      int var3 = field0796.field_1724.method_31548().field_7545;
      float var4 = field0796.field_1724.method_36454();
      boolean var5 = var2 != var3;
      field0796.field_1724.field_3944.method_52787(new class_2831(var4, 90.0F, field0796.field_1724.method_24828(), field0796.field_1724.field_5976));
      if (var5) {
         field0796.field_1724.field_3944.method_52787(new class_2868(var2));
      }

      PlayerActionHelper.method1534(var1x -> new class_2886(class_1268.field_5808, var1x, var4, 90.0F));
      if (var5) {
         field0796.field_1724.field_3944.method_52787(new class_2868(var3));
      }

      return true;
   }

   private boolean method1847(String var1) {
      int var2 = this.method1061(var1, false);
      if (var2 == -1) {
         return false;
      }

      int var3 = field0796.field_1724.method_31548().field_7545;
      boolean var4 = var2 != var3;
      float var5 = field0796.field_1724.method_36454();
      float var6 = field0796.field_1724.method_36455();
      if (var4) {
         field0796.field_1724.field_3944.method_52787(new class_2868(var2));
      }

      PlayerActionHelper.method1534(var2x -> new class_2886(class_1268.field_5808, var2x, var5, var6));
      if (var4) {
         field0796.field_1724.field_3944.method_52787(new class_2868(var3));
      }

      return true;
   }

   private int method1061(String var1, boolean var2) {
      for (int var3 = 0; var3 < 9; var3++) {
         class_1799 var4 = field0796.field_1724.method_31548().method_5438(var3);
         if (!var4.method_7960() && (!var2 || var4.method_7909() == class_1802.field_8436) && (var2 || var4.method_7909() == class_1802.field_8574)) {
            class_1844 var5 = (class_1844)var4.method_57824(class_9334.field_49651);
            if (var5 != null && !var5.comp_2378().isEmpty()) {
               boolean var6 = ((class_1842)((class_6880)var5.comp_2378().get()).comp_349())
                  .method_8049()
                  .stream()
                  .anyMatch(var1x -> var1x.method_5579().method_55840().contains(var1));
               if (var6) {
                  return var3;
               }
            }
         }
      }

      return -1;
   }
}
