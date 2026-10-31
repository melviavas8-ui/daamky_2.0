package aethereal;

import java.util.Arrays;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1511;
import net.minecraft.class_1541;
import net.minecraft.class_1685;
import net.minecraft.class_1701;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2663;
import net.minecraft.class_408;
import net.minecraft.class_9285;
import net.minecraft.class_9334;

public class AutoTotem extends Module {
   private final FloatSetting field1450 = new FloatSetting("autototem.health", 4.0F, 4.0F, 20.0F, 1.0F)
      .method1007("Health")
      .method0210("Health threshold to equip totem")
      .method2130("Уровень здоровья для свапа тотема");
   private final FloatSetting field0985 = new FloatSetting("autototem.elytrahealth", 12.0F, 4.0F, 20.0F, 1.0F)
      .method1007("Elytra Health")
      .method0210("Health threshold to equip totem while wearing elytra")
      .method2130("Уровень здоровья для свапа тотема в элитре");
   private final BooleanSetting field0184 = new BooleanSetting("autototem.swapback", true)
      .method1007("Swap Back")
      .method0210("Restore previous offhand item when safe")
      .method2130("Возвращать предмет");
   private final BooleanSetting field0464 = new BooleanSetting("autototem.noballswitch", false)
      .method1007("No Ball Switch")
      .method0210("Keep player head in offhand")
      .method2130("Не менять когда голова игрока в левой руке");
   private final BooleanSetting field1619 = new BooleanSetting("autototem.saveenchanted", true)
      .method1007("Save Talismans")
      .method0210("Prefer totems without enchants and without attribute modifiers")
      .method2130("Сначала использовать тотемы без чаров и атрибутов");
   private final MultiSelectSetting field1562 = new MultiSelectSetting(
         "autototem.checks", Arrays.asList("GoldenHearts", "Crystals", "RespawnAnchor", "Fall", "TNT", "Trident"), false, () -> true
      )
      .method1007("Checks")
      .method0210("Danger checks that trigger totem swap")
      .method2130("Проверки опасности для смены на тотем");
   private final BooleanSetting field1709 = new BooleanSetting("autototem.bypass", true)
      .method1007("Bypass")
      .method0210("Use inventory desync to swap while moving")
      .method2130("Десинк инвентаря для смены на ходу");
   private int field1137;
   private int field1088 = -1;
   private int field1197 = 0;
   private boolean field0890;
   public boolean field0169;
   private final Stopwatch field0839 = new Stopwatch();
   private boolean field0931;

   public AutoTotem() {
      super("AutoTotem", ModuleCategory.field0661, "Automatically equips totem of undying in offhand");
      this.method1013("Автоматически берёт тотем в левую руку");
   }

   @EventHandler
   public void onTick(PlayerTickEvent var1) {
      if (!method1974()) {
         this.field1197 = InventoryManager.method1217(class_1802.field_8288);
         this.field1137 = (int)field0796.field_1724.field_7512.field_7761.stream().filter(var0 -> {
            class_1799 var1 = var0.method_7677();
            return var1.method_7909() == class_1802.field_8288 && !var1.method_7958() && !method0269(var1);
         }).count();
         class_1735 var2 = field0796.field_1724
            .field_7512
            .field_7761
            .stream()
            .filter(var1x -> var1x.method_7677().method_7909() == class_1802.field_8288 && this.method1241(var1x.method_7677()))
            .findFirst()
            .orElse(null);
         if (this.field0839.method0779(400L)) {
            if (this.method2030()) {
               if (var2 != null && !this.method1755()) {
                  if (this.method1692()) {
                     this.field0931 = true;
                  } else {
                     if (!field0796.field_1724.method_6079().method_7960() && this.field1088 == -1) {
                        this.field1088 = var2.field_7874;
                     }

                     this.method0766(var2.field_7874, class_1268.field_5810, false);
                     this.field0839.method1812();
                  }
               }
            } else if (this.field1088 != -1 && this.field0184.method0492()) {
               this.method0766(this.field1088, class_1268.field_5810, false);
               this.field1088 = -1;
               this.field0839.method1812();
            }
         }
      }
   }

   public void method0766(int var1, class_1268 var2, boolean var3) {
      if (var1 != -1) {
         int var4 = var2 == class_1268.field_5808 ? field0796.field_1724.method_31548().field_7545 : 40;
         if (this.field1709.method0492() && MovementHelper.method1635()) {
            InventoryManager.method0996(() -> InventoryManager.method0753(var1, var4, class_1713.field_7791), 0);
         } else {
            InventoryManager.method0753(var1, var4, class_1713.field_7791);
         }
      }
   }

   @EventHandler
   public void onScreenClose(ScreenCloseEvent var1) {
      if (!method1974()) {
         if (this.field0931) {
            this.field0931 = false;
            InventoryManager.method0996(
               () -> {
                  class_1735 var1 = field0796.field_1724
                     .field_7512
                     .field_7761
                     .stream()
                     .filter(var1x -> var1x.method_7677().method_7909() == class_1802.field_8288 && this.method1241(var1x.method_7677()))
                     .findFirst()
                     .orElse(null);
                  if (var1 != null && !this.method1755()) {
                     if (!field0796.field_1724.method_6079().method_7960() && this.field1088 == -1) {
                        this.field1088 = var1.field_7874;
                     }

                     this.method0766(var1.field_7874, class_1268.field_5810, false);
                     this.field0839.method1812();
                  }
               },
               0
            );
         }
      }
   }

   private boolean method1692() {
      if (field0796.field_1755 == null) {
         return false;
      } else {
         return field0796.field_1755 instanceof class_408 ? false : !(field0796.field_1755 instanceof ClickGuiScreen);
      }
   }

   @EventHandler
   public void onPacket(PacketEvent.Inbound var1) {
      if (!method1974()) {
         if (var1.method1970() instanceof class_2663 var2 && var2.method_11470() == 35 && var2.method_11469(field0796.field_1687) == field0796.field_1724) {
            this.field0890 = true;
         }
      }
   }

   private boolean method1755() {
      for (class_1268 var4 : class_1268.values()) {
         class_1799 var5 = field0796.field_1724.method_5998(var4);
         if (var5.method_7909() == class_1802.field_8288 && this.method1241(var5)) {
            return true;
         }
      }

      return false;
   }

   private boolean method1241(class_1799 var1) {
      if (!this.field1619.method0492()) {
         return true;
      } else {
         return this.field1137 <= 0 ? true : !var1.method_7958() && !method0269(var1);
      }
   }

   private static boolean method0269(class_1799 var0) {
      class_9285 var1 = (class_9285)var0.method_57824(class_9334.field_49636);
      return var1 != null && !var1.comp_2393().isEmpty();
   }

   private boolean method2030() {
      float var1 = field0796.field_1724.method_6059(class_1294.field_5898) ? field0796.field_1724.method_6067() : 0.0F;
      float var2 = field0796.field_1724.method_6032();
      if (this.field1562.method0730(0)) {
         var2 += var1;
      }

      if (!this.method0399() && this.method2016()) {
         return true;
      }

      float var3 = field0796.field_1724.method_6118(class_1304.field_6174).method_7909() == class_1802.field_8833
         ? this.field0985.method0492()
         : this.field1450.method0492();
      return var2 <= var3;
   }

   private boolean method2016() {
      return this.method0458() || this.method0472() || this.method2044() || this.method0480() || this.method0406();
   }

   private boolean method2044() {
      if (!this.field1562.method0730(3)) {
         return false;
      } else if (field0796.field_1724.method_5799()) {
         return false;
      } else {
         return field0796.field_1724.method_6128() ? false : field0796.field_1724.field_6017 > 10.0F;
      }
   }

   private boolean method0472() {
      return !this.field1562.method0730(2) ? false : BlockPlacementHelper.method0708(6.0F, class_2246.field_23152) != null;
   }

   private boolean method0458() {
      if (!this.field1562.method0730(1)) {
         return false;
      }

      for (class_1297 var2 : field0796.field_1687.method_18112()) {
         if (var2 instanceof class_1511 && field0796.field_1724.method_5739(var2) <= 6.0F) {
            return true;
         }
      }

      return false;
   }

   private boolean method0480() {
      if (!this.field1562.method0730(4)) {
         return false;
      }

      for (class_1297 var2 : field0796.field_1687.method_18112()) {
         if ((var2 instanceof class_1541 || var2 instanceof class_1701) && field0796.field_1724.method_5739(var2) <= 6.0F) {
            return true;
         }
      }

      return false;
   }

   private boolean method0406() {
      if (!this.field1562.method0730(5)) {
         return false;
      }

      for (class_1297 var2 : field0796.field_1687.method_18112()) {
         if (var2 instanceof class_1685 var3
            && var3.method_24921() != field0796.field_1724
            && !(var3.method_18798().method_1027() < 0.010000004307821686)
            && field0796.field_1724.method_5739(var3) <= 8.0F) {
            return true;
         }
      }

      return false;
   }

   private boolean method0399() {
      boolean var1 = this.field1562.method0730(3) && field0796.field_1724.field_6017 > 5.0F;
      return var1 ? false : this.field0464.method0492() && field0796.field_1724.method_6079().method_7909() == class_1802.field_8575;
   }

   public void method1735() {
      this.field1088 = -1;
      this.field0931 = false;
   }

   @Override
   public void method1812() {
      super.method1812();
      this.method1735();
   }
}
