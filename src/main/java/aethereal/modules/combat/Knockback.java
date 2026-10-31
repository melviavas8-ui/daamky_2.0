package aethereal;

import java.util.Arrays;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2378;
import net.minecraft.class_243;
import net.minecraft.class_2824;
import net.minecraft.class_3532;
import net.minecraft.class_6880;
import net.minecraft.class_7924;
import net.minecraft.class_2824.class_5908;
import net.minecraft.class_2828.class_2831;

public class Knockback extends Module {
   private final EnumSetting<Knockback.Mode> field0058 = new EnumSetting<>("kbdisp.mode", Knockback.Mode.field0659)
      .method1007("Mode")
      .method0210("How to redirect the bonus knockback applied by sprint/Knockback hits")
      .method2130("Куда направлять бонусный отскок от спринт-удара/зачара");
   private final MultiSelectSetting field1471 = new MultiSelectSetting("kbdisp.trigger", Arrays.asList("Sprint Hits", "Knockback Enchant"), false, () -> true)
      .method1007("Trigger")
      .method0210("Which bonus-knockback sources should be redirected")
      .method2130("Источники бонусного отскока, на которые срабатывает");
   private final BooleanSetting field0970 = new BooleanSetting("kbdisp.smartCooldown", true)
      .method1007("Cooldown Gate")
      .method0210("Only displace when attack cooldown is full enough for bonus knockback (>0.9)")
      .method2130("Срабатывать только при готовности атаки (cooldown > 0.9)");
   private final FloatSetting field0190 = new FloatSetting(
         "kbdisp.trapRadius", 4.0F, 1.0F, 8.0F, 1.0F, () -> this.field0058.method0492() == Knockback.Mode.field0086
      )
      .method1007("Trap Radius")
      .method0210("Search radius (blocks) for hazards around the target")
      .method2130("Радиус поиска ловушек вокруг цели");
   private final BooleanSetting field0464 = new BooleanSetting(
         "kbdisp.fallbackReverse", true, () -> this.field0058.method0492() == Knockback.Mode.field0086
      )
      .method1007("Fallback Reverse")
      .method0210("If no hazard found near the target, fall back to Reverse")
      .method2130("Если ловушка не найдена — использовать Reverse");

   public Knockback() {
      super("Knockback", ModuleCategory.field0661, "Redirects sprint and Knockback-enchant bonus knockback by spoofing the look packet sent before the attack");
      this.method1013("Перенаправляет бонусный отскок от спринт-удара и зачара Knockback");
   }

   @EventHandler
   public void onPacketSend(PacketEvent.Outbound var1) {
      if (!method1974()) {
         if (var1.method1970() instanceof class_2824 var2) {
            if (method1376(var2)) {
               if (field0796.field_1687.method_8469(var2.field_12870) instanceof class_1309 var4) {
                  if (var4 != field0796.field_1724) {
                     boolean var5 = this.method1736();
                     boolean var6 = this.method1239(field0796.field_1724.method_6047()) > 0;
                     boolean var7 = this.field1471.method0387("Sprint Hits") && var5 || this.field1471.method0387("Knockback Enchant") && var6;
                     if (var7) {
                        if (!this.field0970.method1938() || !(field0796.field_1724.method_7261(0.5F) <= 0.9F)) {
                           Float var8 = this.method1155(var4);
                           if (var8 != null) {
                              PlayerActionHelper.method1354(
                                 new class_2831(
                                    class_3532.method_15393(var8),
                                    field0796.field_1724.method_36455(),
                                    field0796.field_1724.method_24828(),
                                    field0796.field_1724.field_5976
                                 )
                              );
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private Float method1155(class_1309 var1) {
      class_243 var2 = field0796.field_1724.method_19538();
      class_243 var3 = var1.method_19538();
      switch ((Knockback.Mode)this.field0058.method0492()) {
         case field0659:
            return RotationHelper.method1296(var2.method_1020(var3)).method2047();
         case field0086:
            class_243 var4 = this.method1317(var3, this.field0190.method0492().intValue());
            if (var4 != null) {
               return RotationHelper.method1296(var4.method_1020(var3)).method2047();
            } else {
               if (this.field0464.method1938()) {
                  return RotationHelper.method1296(var2.method_1020(var3)).method2047();
               }

               return null;
            }
         default:
            return null;
      }
   }

   private class_243 method1317(class_243 var1, int var2) {
      class_2338 var3 = class_2338.method_49638(var1);
      class_243 var4 = null;
      double var5 = 1.7976922776554304E308;
      int var7 = var2 * var2;

      for (int var8 = -var2; var8 <= var2; var8++) {
         for (int var9 = -var2; var9 <= var2; var9++) {
            if (var8 * var8 + var9 * var9 <= var7) {
               for (int var10 = -1; var10 <= 2; var10++) {
                  class_2338 var11 = var3.method_10069(var8, var10, var9);
                  if (this.method1264(var11)) {
                     class_243 var12 = class_243.method_24953(var11);
                     double var13 = var12.method_1025(var1);
                     if (var13 < var5) {
                        var5 = var13;
                        var4 = var12;
                     }
                  }
               }
            }
         }
      }

      return var4;
   }

   private boolean method1264(class_2338 var1) {
      class_2248 var2 = field0796.field_1687.method_8320(var1).method_26204();
      return var2 == class_2246.field_10343
         || var2 == class_2246.field_10164
         || var2 == class_2246.field_10036
         || var2 == class_2246.field_22089
         || var2 == class_2246.field_10092
         || var2 == class_2246.field_17350
         || var2 == class_2246.field_23860
         || var2 == class_2246.field_16999;
   }

   private boolean method1736() {
      return field0796.field_1724.method_5624() && !field0796.field_1724.method_6115();
   }

   private int method1239(class_1799 var1) {
      if (field0796.field_1687 != null && !var1.method_7960()) {
         class_2378 var2 = field0796.field_1687.method_30349().method_30530(class_7924.field_41265);
         class_6880 var3 = (class_6880<class_1887>)var2.method_10223(class_1893.field_9121.method_29177()).orElse(null);
         return var3 == null ? 0 : class_1890.method_8225(var3, var1);
      } else {
         return 0;
      }
   }

   private static boolean method1376(class_2824 var0) {
      final boolean[] var1 = new boolean[]{false};
      var0.method_34209(new class_5908() {
         public void method_34219(class_1268 var1x) {
         }

         public void method_34220(class_1268 var1x, class_243 var2) {
         }

         public void method_34218() {
            var1[0] = true;
         }
      });
      return var1[0];
   }

   public enum Mode implements DisplayNamed {
      field0659("Reverse"),
      field0086("Smart Trap");

      private final String field1504;

      Mode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }
}
