package aethereal;

import java.util.function.ToIntFunction;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1291;
import net.minecraft.class_1294;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1842;
import net.minecraft.class_1844;
import net.minecraft.class_4174;
import net.minecraft.class_6880;
import net.minecraft.class_9334;
import ua.patch.daamky.api.mixins.accessors.IClientPlayerInteractionManager;

public class AutoUse extends Module {
   private final BooleanSetting field0034 = new BooleanSetting("autouse.eat", true)
      .method1007("Eat")
      .method0210("Auto eat food")
      .method2130("Автоматически есть еду");
   private final BooleanSetting field1432 = new BooleanSetting("autouse.invisibility", false)
      .method1007("Invisibility")
      .method0210("Auto use invisibility potions")
      .method2130("Автоматически пить зелья невидимости");
   private final FloatSetting field0985 = new FloatSetting("autouse.health", 10.0F, 1.0F, 20.0F, 0.5F, this.field0034::method0492)
      .method1007("Health")
      .method0210("Eat when health below this value")
      .method2130("Есть при здоровье");
   private final FloatSetting field0190 = new FloatSetting("autouse.delay", 0.0F, 0.0F, 20.0F, 1.0F)
      .method1007("Delay (ticks)")
      .method0210("Delay between actions in ticks")
      .method2130("Задержка");
   private int field0459 = 0;
   private int field1615 = -1;
   private boolean field1574 = false;

   public AutoUse() {
      super("AutoUse", ModuleCategory.field1470, "Eats the best food and uses items, completing the action");
      this.method1013("Ест лучшую еду и использует предметы, доводя действие до конца");
   }

   @Override
   public void method2078() {
      super.method2078();
      this.method1735();
   }

   @EventHandler
   public void onPlayerTick(PlayerTickEvent var1) {
      if (!method1974() && field0796.field_1755 == null) {
         if (this.field1574) {
            if (field0796.field_1724.method_6115()) {
               field0796.field_1690.field_1904.method_23481(true);
               return;
            }

            this.method1735();
         }

         this.field0459++;
         if (!(this.field0459 < this.field0190.method0492())) {
            boolean var2 = field0796.field_1724.method_6032() <= this.field0985.method0492();
            if (this.field0034.method0492()
               && (var2 || field0796.field_1724.method_7344().method_7587())
               && this.method1110(var2x -> this.method1246(var2x, var2))) {
               this.field0459 = 0;
            } else {
               if (this.field1432.method0492() && !field0796.field_1724.method_6059(class_1294.field_5905) && this.method1110(this::method1239)) {
                  this.field0459 = 0;
               }
            }
         }
      } else {
         this.method1735();
      }
   }

   private boolean method1110(ToIntFunction<class_1799> var1) {
      int var2 = -2;
      int var3 = -1;

      for (int var4 = 0; var4 <= 8; var4++) {
         int var5 = var1.applyAsInt(field0796.field_1724.method_31548().method_5438(var4));
         if (var5 > var3) {
            var3 = var5;
            var2 = var4;
         }
      }

      int var6 = var1.applyAsInt(field0796.field_1724.method_6079());
      if (var6 > var3) {
         var3 = var6;
         var2 = -1;
      }

      if (var3 < 0) {
         return false;
      }

      class_1268 var7;
      if (var2 == -1) {
         var7 = class_1268.field_5810;
      } else {
         if (var2 != field0796.field_1724.method_31548().field_7545) {
            this.field1615 = field0796.field_1724.method_31548().field_7545;
            this.method0729(var2);
         }

         var7 = class_1268.field_5808;
      }

      field0796.field_1761.method_2919(field0796.field_1724, var7);
      field0796.field_1690.field_1904.method_23481(true);
      this.field1574 = true;
      return true;
   }

   private void method1735() {
      if (this.field1574) {
         field0796.field_1690.field_1904.method_23481(false);
         if (this.field1615 != -1 && field0796.field_1724 != null) {
            this.method0729(this.field1615);
         }

         this.field1615 = -1;
         this.field1574 = false;
      }
   }

   private void method0729(int var1) {
      field0796.field_1724.method_31548().field_7545 = var1;
      ((IClientPlayerInteractionManager)field0796.field_1761).syncSelectedSlot$drug();
   }

   private int method1246(class_1799 var1, boolean var2) {
      if (var1.method_7960()) {
         return -1;
      }

      if (var1.method_7909() == class_1802.field_8367) {
         return var2 ? 1000 : -1;
      }

      if (var1.method_7909() == class_1802.field_8463) {
         return var2 ? 900 : -1;
      }

      class_4174 var3 = (class_4174)var1.method_57824(class_9334.field_50075);
      return var3 == null ? -1 : Math.round(var3.comp_2491() * 10.0F + var3.comp_2492() * 10.0F);
   }

   private int method1239(class_1799 var1) {
      if (!this.method1245(var1, class_1294.field_5905)) {
         return -1;
      } else {
         return field0796.field_1724.method_7357().method_7904(var1) ? -1 : 1;
      }
   }

   private boolean method1245(class_1799 var1, class_6880<class_1291> var2) {
      if (var1.method_7909() != class_1802.field_8574 && var1.method_7909() != class_1802.field_8436 && var1.method_7909() != class_1802.field_8150) {
         return false;
      }

      class_1844 var3 = (class_1844)var1.method_57824(class_9334.field_49651);
      return var3 != null && !var3.comp_2378().isEmpty()
         ? ((class_1842)((class_6880)var3.comp_2378().get()).comp_349()).method_8049().stream().anyMatch(var1x -> var1x.method_5579().equals(var2))
         : false;
   }
}
