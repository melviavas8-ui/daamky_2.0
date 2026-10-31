package aethereal;

import java.lang.reflect.Field;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2708;
import net.minecraft.class_2743;
import net.minecraft.class_2846;
import net.minecraft.class_6373;
import net.minecraft.class_2828.class_2830;
import net.minecraft.class_2846.class_2847;

public class Velocity extends Module {
   private final EnumSetting<Velocity.Mode> field0058 = new EnumSetting<>("velocity.mode", Velocity.Mode.field0707)
      .method1007("Mode")
      .method0210("Anti-knockback bypass method")
      .method2130("Режим");
   private final FloatSetting field1450 = new FloatSetting(
         "velocity.jumpreset.chance", 100.0F, 0.0F, 100.0F, 1.0F, () -> this.field0058.method0492() == Velocity.Mode.field0787
      )
      .method1007("Chance")
      .method0210("Probability of triggering a jump reset when conditions are met")
      .method2130("Шанс срабатывания");
   private final BooleanSetting field0970 = new BooleanSetting(
         "velocity.jumpreset.jumpByDelay", true, () -> this.field0058.method0492() == Velocity.Mode.field0787
      )
      .method1007("JumpByDelay")
      .method0210("Jump after a specific tick delay between resets")
      .method2130("Прыгать с задержкой тиков");
   private final FloatSetting field0190 = new FloatSetting(
         "velocity.jumpreset.ticksUntilJump",
         2.0F,
         0.0F,
         20.0F,
         1.0F,
         () -> this.field0058.method0492() == Velocity.Mode.field0787 && this.field0970.method1938()
      )
      .method1007("UntilJump")
      .method0210("Ticks to wait between jump resets")
      .method2130("Сколько тиков ждать между прыжком");
   private boolean field0497;
   private int field1615;
   private int field1539;
   private int field1705;
   private boolean field1161;

   public Velocity() {
      super("Velocity", ModuleCategory.field0661, "Modifies knockback velocity from attacks");
      this.method1013("Отключает отбрасывание");
   }

   @EventHandler
   public void onPacket(PacketEvent.Inbound var1) {
      if (!method1974()) {
         if (!field0796.field_1724.method_5799() && !field0796.field_1724.method_5869() && !field0796.field_1724.method_5771()) {
            if (this.field1539 > 0) {
               this.field1539--;
            } else {
               if (var1.method1970() instanceof class_2743 var2 && var2.method_11818() == field0796.field_1724.method_5628()) {
                  switch ((Velocity.Mode)this.field0058.method0492()) {
                     case field0707:
                        var1.method0578();
                        this.field0497 = true;
                        break;
                     case field0131:
                        var1.method0578();
                        this.field1615 = 6;
                        break;
                     case field1499:
                        if (!this.field0497) {
                           var1.method0578();
                           this.field0497 = true;
                        } else {
                           this.field0497 = false;
                           this.method1369(var2, (int)(var2.method_11815() * -0.10000000398723294));
                           this.method0304(var2, (int)(var2.method_11819() * -0.10000000398723294));
                        }
                        break;
                     case field1023:
                        var1.method0578();
                        break;
                     case field0787:
                        this.field1161 = var2.method_11815() == 0.0 && var2.method_11819() == 0.0 && var2.method_11816() < 0.0;
                  }
               }

               if (this.field0058.method0492() == Velocity.Mode.field0131 && var1.method1970() instanceof class_6373 && this.field1615 > 0) {
                  var1.method0578();
                  this.field1615--;
               }

               if (var1.method1970() instanceof class_2708 && this.field0058.method0492() == Velocity.Mode.field0707) {
                  this.field1539 = 5;
               }
            }
         }
      }
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         if (!field0796.field_1724.method_5799() && !field0796.field_1724.method_5869()) {
            if (this.field0058.method0492() == Velocity.Mode.field1499 && field0796.field_1724.field_6235 > 0 && !field0796.field_1724.method_24828()) {
               double var2 = field0796.field_1724.method_36454() * (float) (Math.PI / 180.0);
               double var4 = Math.sqrt(
                  field0796.field_1724.method_18798().field_1352 * field0796.field_1724.method_18798().field_1352
                     + field0796.field_1724.method_18798().field_1350 * field0796.field_1724.method_18798().field_1350
               );
               field0796.field_1724.method_18800(-Math.sin(var2) * var4, field0796.field_1724.method_18798().field_1351, Math.cos(var2) * var4);
               field0796.field_1724.method_5728(field0796.field_1724.field_6012 % 2 != 0);
            }

            if (this.field0058.method0492() == Velocity.Mode.field0707 && this.field0497) {
               if (this.field1539 <= 0) {
                  field0796.field_1724
                     .field_3944
                     .method_52787(
                        new class_2830(
                           field0796.field_1724.method_23317(),
                           field0796.field_1724.method_23318(),
                           field0796.field_1724.method_23321(),
                           field0796.field_1724.method_36454(),
                           field0796.field_1724.method_36455(),
                           field0796.field_1724.method_24828(),
                           false
                        )
                     );
                  field0796.field_1724
                     .field_3944
                     .method_52787(new class_2846(class_2847.field_12973, class_2338.method_49638(field0796.field_1724.method_19538()), class_2350.field_11033));
               }

               this.field0497 = false;
            }

            if (this.field1615 > 0) {
               this.field1615--;
            }
         }
      }
   }

   @EventHandler
   public void onInput(KeyboardInputEvent var1) {
      if (!method1974()) {
         if (this.field0058.method0492() == Velocity.Mode.field0787) {
            if (!field0796.field_1724.method_5799() && !field0796.field_1724.method_5869() && !field0796.field_1724.method_5771()) {
               boolean var2 = this.field1450.method0492() != 100.0F && Math.random() * 100.0 > this.field1450.method0492().floatValue();
               if (field0796.field_1724.field_6235 == 9
                  && field0796.field_1724.method_24828()
                  && field0796.field_1724.method_5624()
                  && !this.field1161
                  && this.method1736()
                  && !var2) {
                  var1.method0345(true);
                  this.field1705 = 0;
               } else {
                  this.method1691();
               }
            }
         }
      }
   }

   private boolean method1736() {
      return this.field0970.method1938() ? this.field1705 >= this.field0190.method0492().intValue() : true;
   }

   private void method1691() {
      this.field1705++;
   }

   @Override
   public void method0025() {
      this.field1615 = 0;
      this.field0497 = false;
      this.field1539 = 0;
      this.field1705 = 0;
      this.field1161 = false;
      super.method0025();
   }

   private void method1369(class_2743 var1, int var2) {
      try {
         Field var3 = class_2743.class.getDeclaredField("velocityX");
         var3.setAccessible(true);
         var3.setInt(var1, var2);
      } catch (Exception var4) {
      }
   }

   private void method0304(class_2743 var1, int var2) {
      try {
         Field var3 = class_2743.class.getDeclaredField("velocityZ");
         var3.setAccessible(true);
         var3.setInt(var1, var2);
      } catch (Exception var4) {
      }
   }

   public enum Mode implements DisplayNamed {
      field0707("NewGrim"),
      field0131("OldGrim"),
      field1499("Matrix"),
      field1023("Normal"),
      field0787("JumpReset");

      private final String field1269;

      Mode(String var3) {
         this.field1269 = var3;
      }

      @Override
      public String method0557() {
         return this.field1269;
      }
   }
}
