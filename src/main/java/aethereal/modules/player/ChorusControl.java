package aethereal;

import java.awt.Color;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2708;
import net.minecraft.class_2793;
import net.minecraft.class_2828;
import net.minecraft.class_4587;

public class ChorusControl extends Module {
   private final KeyBindSetting field0085 = new KeyBindSetting("chorus.confirm", new KeyBind(340, false))
      .method1007("Confirm")
      .method0210("Key to confirm the teleport")
      .method2130("Клавиша для подтверждения телепорта");
   private final EnumSetting<ChorusControl.Mode> field1448 = new EnumSetting<>("chorus.mode", ChorusControl.Mode.field0972)
      .method1007("Mode")
      .method0210("Rendering mode for the target block")
      .method2130("Режим отображения целевого блока");
   private final ColorSetting field0978 = new ColorSetting(
         "chorus.fill",
         100,
         200,
         255,
         60,
         () -> this.field1448.method0492() == ChorusControl.Mode.field0038 || this.field1448.method0492() == ChorusControl.Mode.field0972
      )
      .method1007("Fill Color")
      .method0210("Fill rendering color")
      .method2130("Цвет заливки");
   private final ColorSetting field0185 = new ColorSetting(
         "chorus.outline",
         100,
         200,
         255,
         255,
         () -> this.field1448.method0492() == ChorusControl.Mode.field1436 || this.field1448.method0492() == ChorusControl.Mode.field0972
      )
      .method1007("Outline Color")
      .method0210("Outline rendering color")
      .method2130("Цвет обводки");
   private class_2708 field0494;
   private boolean field1653 = false;

   public ChorusControl() {
      super("ChorusControl", ModuleCategory.field1470, "Lets you choose where to land after eating a chorus");
      this.method1013("Позволяет выбрать точку приземления после телепортации хорусом");
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         if (!this.field1653 && field0796.field_1724.method_6115()) {
            class_1799 var2 = field0796.field_1724.method_5998(field0796.field_1724.method_6058());
            if (var2.method_7909() == class_1802.field_8233 && var2.method_7935(field0796.field_1724) - field0796.field_1724.method_6048() <= 1) {
               this.field1653 = true;
            }
         }
      }
   }

   @EventHandler
   public void onKey(KeyEvent var1) {
      if (!method1974()) {
         if (this.field0494 != null) {
            if (var1.method1604() == 1) {
               KeyBind var2 = this.field0085.method0492();
               if (!var2.method0579() && !var2.method1813() && var1.method1763() == var2.method2048()) {
                  this.method1735();
               }
            }
         }
      }
   }

   @EventHandler
   public void onMouse(MouseEvent var1) {
      if (!method1974()) {
         if (this.field0494 != null) {
            if (var1.method1604() == 1) {
               KeyBind var2 = this.field0085.method0492();
               if (!var2.method0579() && var2.method1813() && var1.method1763() == var2.method2048()) {
                  this.method1735();
               }
            }
         }
      }
   }

   @EventHandler
   public void onPacketSend(PacketEvent.Outbound var1) {
      if (!method1974() && this.field1653) {
         if (var1.method1970() instanceof class_2828 var2 && var2.method_36171()) {
            var1.method0578();
         } else {
            if (var1.method1970() instanceof class_2793) {
               var1.method0578();
            }
         }
      }
   }

   @EventHandler
   public void onPacketReceive(PacketEvent.Inbound var1) {
      if (!method1974() && this.field1653) {
         if (var1.method1970() instanceof class_2708 var2) {
            var1.method0578();
            this.field0494 = var2;
         }
      }
   }

   @EventHandler
   public void onRender3D(WorldRenderEvent.WorldPass var1) {
      if (!method1974()) {
         if (this.field0494 != null) {
            class_243 var2 = new class_243(
               this.field0494.comp_3228().comp_3148().method_10216(),
               this.field0494.comp_3228().comp_3148().method_10214(),
               this.field0494.comp_3228().comp_3148().method_10215()
            );
            class_238 var3 = class_1657.field_18135.method_30757(var2);
            class_4587 var4 = new class_4587();
            ChorusControl.Mode var5 = this.field1448.method0492();
            if (var5 == ChorusControl.Mode.field0038 || var5 == ChorusControl.Mode.field0972) {
               Color var6 = this.field0978.method1726();
               WorldRenderHelper.method1498(var4, var3, var6);
            }

            if (var5 == ChorusControl.Mode.field1436 || var5 == ChorusControl.Mode.field0972) {
               Color var7 = this.field0185.method1726();
               WorldRenderHelper.method2173(var4, var3, var7);
            }
         }
      }
   }

   private void method1735() {
      if (this.field0494 != null && field0796.method_1562() != null) {
         this.field0494.method_11740(field0796.method_1562());
         this.field0494 = null;
         this.field1653 = false;
      }
   }

   @Override
   public void method2078() {
      if (field0796.method_1562() != null && this.field0494 != null) {
         this.method1735();
      }

      this.field0494 = null;
      this.field1653 = false;
      super.method2078();
   }

   public enum Mode implements DisplayNamed {
      field0602("None"),
      field0038("Fill"),
      field1436("Outline"),
      field0972("Both");

      private final String field0791;

      Mode(String var3) {
         this.field0791 = var3;
      }

      @Override
      public String method0557() {
         return this.field0791;
      }
   }
}
