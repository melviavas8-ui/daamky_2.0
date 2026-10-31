package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1306;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_7833;

public class SwingAnimation extends Module {
   private static final int field0004 = 6;
   private final EnumSetting<SwingAnimation.Style> field1448 = new EnumSetting<>("swinganimation.style", SwingAnimation.Style.field0693)
      .method1007("Style")
      .method0210("Swing animation type")
      .method2130("Тип анимации");
   private final FloatSetting field0985 = new FloatSetting("swinganimation.strength", 1.0F, 0.5F, 3.0F, 0.1F)
      .method1007("Strength")
      .method0210("Animation intensity")
      .method2130("Сила");
   private final FloatSetting field0190 = new FloatSetting("swinganimation.speed", 1.0F, 0.5F, 2.5F, 0.1F)
      .method1007("Speed")
      .method0210("Swing duration multiplier")
      .method2130("Скорость");
   private final BooleanSetting field0464 = new BooleanSetting("swinganimation.onauratarget", false)
      .method1007("On Aura Target")
      .method0210("Animate only while Aura has a target")
      .method2130("Только при Таргете");

   public SwingAnimation() {
      super("SwingAnimation", ModuleCategory.field1004, "Custom hand swing animation styles");
      this.method1013("Анимирует руки");
   }

   @EventHandler
   public void onSwingDuration(SwingDurationEvent var1) {
      float var2 = class_3532.method_15363(this.field0190.method0492(), 0.1F, 10.0F);
      var1.method0729(Math.max(1, Math.round(6.0F / var2)));
      var1.method0578();
   }

   @EventHandler
   public void onHandAnimation(HandAnimationEvent var1) {
      if (!method1974()) {
         if (var1.method1624() == class_1268.field_5808) {
            class_4587 var2 = var1.method1808();
            float var3 = var1.method1946();
            int var4 = field0796.field_1724.method_6068() == class_1306.field_6183 ? 1 : -1;
            float var5 = class_3532.method_15374(var3 * var3 * (float) Math.PI);
            float var6 = class_3532.method_15374(class_3532.method_15355(var3) * (float) Math.PI);
            float var7 = (float)(Math.sin(var3 * 3.1415936072652464) * 0.5);
            float var8 = this.field0985.method0492();
            if (!this.field0464.method0492() || this.method1736()) {
               switch ((SwingAnimation.Style)this.field1448.method0492()) {
                  case field0693:
                     var2.method_46416(0.56F * var4, -0.32F, -0.72F);
                     var2.method_22907(class_7833.field_40716.rotationDegrees(70 * var4));
                     var2.method_22907(class_7833.field_40718.rotationDegrees(-20 * var4));
                     var2.method_22907(class_7833.field_40716.rotationDegrees(var6 * var5 * -5.0F * var8));
                     var2.method_22907(class_7833.field_40714.rotationDegrees(var6 * var5 * -120.0F * var8));
                     var2.method_22907(class_7833.field_40714.rotationDegrees(-70.0F));
                     break;
                  case field0117:
                     var2.method_46416(var4 * 0.56F, -0.32F, -0.72F);
                     var2.method_22907(class_7833.field_40716.rotationDegrees(76 * var4));
                     var2.method_22907(class_7833.field_40716.rotationDegrees(var6 * -5.0F * var8));
                     var2.method_22907(class_7833.field_40713.rotationDegrees(var6 * -100.0F * var8));
                     var2.method_22907(class_7833.field_40714.rotationDegrees(var6 * -155.0F * var8));
                     var2.method_22907(class_7833.field_40714.rotationDegrees(-100.0F));
                     break;
                  case field1488:
                     var2.method_46416(var4 * 0.56F, -0.42F, -0.72F);
                     var2.method_22907(class_7833.field_40716.rotationDegrees(var4 * (45.0F + var5 * -20.0F * var8)));
                     var2.method_22907(class_7833.field_40718.rotationDegrees(var4 * var6 * -20.0F * var8));
                     var2.method_22907(class_7833.field_40714.rotationDegrees(var6 * -80.0F * var8));
                     var2.method_22907(class_7833.field_40716.rotationDegrees(var4 * -45.0F));
                     var2.method_22904(0.0, -0.10000002235663849, 0.0);
                     break;
                  case field1017:
                     var2.method_46416(var4 * 0.56F, -0.42F, -0.72F);
                     var2.method_22907(class_7833.field_40714.rotationDegrees(var6 * -80.0F * var8));
                     var2.method_22904(0.0, -0.10000002235663849, 0.0);
                     break;
                  case field0782:
                     var2.method_46416(var4 * 0.56F, -0.32F, -0.72F);
                     var2.method_46416(-var7 * var7 * var5 * var4 * var8, 0.0F, 0.0F);
                     var2.method_22907(class_7833.field_40716.rotationDegrees(61 * var4));
                     var2.method_22907(class_7833.field_40718.rotationDegrees(var6 * var8));
                     var2.method_22907(class_7833.field_40716.rotationDegrees(var6 * var5 * -5.0F * var8));
                     var2.method_22907(class_7833.field_40714.rotationDegrees(var6 * var5 * -30.0F * var8));
                     var2.method_22907(class_7833.field_40714.rotationDegrees(-60.0F));
                     var2.method_22907(class_7833.field_40714.rotationDegrees(var7 * -60.0F * var8));
                     break;
                  case field1265:
                     var2.method_46416(var4 * 0.56F, -0.32F, -0.72F);
                     var2.method_22907(class_7833.field_40716.rotationDegrees(30 * var4));
                     var2.method_22907(class_7833.field_40716.rotationDegrees(var6 * 75.0F * var4 * var8));
                     var2.method_22907(class_7833.field_40714.rotationDegrees(var6 * -45.0F * var8));
                     var2.method_22907(class_7833.field_40716.rotationDegrees(30 * var4));
                     var2.method_22907(class_7833.field_40714.rotationDegrees(-80.0F));
                     var2.method_22907(class_7833.field_40716.rotationDegrees(35 * var4));
                     break;
                  case field0332:
                     var2.method_46416(var4 * 0.56F, -0.36F, -0.72F);
                     var2.method_22907(class_7833.field_40716.rotationDegrees(80 * var4));
                     var2.method_22907(class_7833.field_40714.rotationDegrees(var6 * -90.0F * var8));
                     var2.method_22907(class_7833.field_40718.rotationDegrees((var5 - var6) * 60.0F * var4 * var8));
                     var2.method_22907(class_7833.field_40714.rotationDegrees(-30.0F));
                     var2.method_46416(0.0F, -0.1F, 0.05F);
               }

               var1.method0578();
            }
         }
      }
   }

   private boolean method1736() {
      Aura var1 = Aura.method1701();
      return var1 != null && var1.method2195() ? var1.method0409() != null && var1.method0409().method_5805() : false;
   }

   public enum Style implements DisplayNamed {
      field0693("Swipe"),
      field0117("Down"),
      field1488("Smooth"),
      field1017("Smooth 2"),
      field0782("Power"),
      field1265("Feast"),
      field0332("Twist");

      private final String field0208;

      Style(String var3) {
         this.field0208 = var3;
      }

      @Override
      public String method0557() {
         return this.field0208;
      }
   }
}
