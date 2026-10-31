package aethereal;

import java.awt.Color;
import java.util.function.Supplier;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_4587;

public class SuperFirework extends Module {
   public final EnumSetting<SuperFirework.Mode> field0058 = new EnumSetting<>("superfirework.mode", SuperFirework.Mode.field0692)
      .method1007("Mode")
      .method0210("Boost mode")
      .method2130("Режим буста");
   public final FloatSetting field1450 = new FloatSetting(
         "superfirework.speed", 20.0F, 1.0F, 50.0F, 1.0F, () -> this.field0058.method0492() == SuperFirework.Mode.field0116
      )
      .method1007("Speed")
      .method0210("Firework flight speed")
      .method2130("Скорость полёта фейерверка");
   public final BooleanSetting field0970 = new BooleanSetting("superfirework.hud", false)
      .method1007("Show HUD")
      .method0210("Display Informations")
      .method2130("Рисовать данные");
   private static final Supplier<Boolean> field0489 = () -> method1722() != null && method1722().field0058.method0492() == SuperFirework.Mode.field0692;
   public final FloatSetting field0190 = new FloatSetting("superfirework.grim.safety", 0.96F, 0.8F, 0.99F, 0.01F, field0489)
      .method1007("Safety")
      .method0210("Скорость")
      .method2130("Скорость");
   private static final Color field1641 = new Color(170, 170, 185);
   private static final Color field1564 = new Color(255, 255, 255);
   private static final Color field1726 = new Color(255, 255, 255);
   private static final float field1136 = 10.0F;
   private static final int field1088 = 200;

   public static SuperFirework method1722() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(SuperFirework.class) : null;
   }

   public double method0614(double var1, double var3) {
      double var5 = this.field0190.method0492().floatValue();
      return Math.min(method0106(Math.abs(var1), var5), method0106(Math.abs(var3), var5));
   }

   public double method0608(double var1) {
      return method0106(Math.abs(var1), this.field0190.method0492().floatValue());
   }

   private static double method0106(double var0, double var2) {
      if (var0 < 9.99999767581866E-7) {
         return 100.0;
      }

      double var4 = var0 < 0.5 ? 3.40000008044681 * var0 : 1.7000006035012427;
      return var4 * var2 / var0 - 0.19999997826319743;
   }

   public SuperFirework() {
      super("SuperFirework", ModuleCategory.field0088, "Stronger firework boost");
      this.method1013("Даёт больше буста от фейерверка");
      this.method0213("B");
   }

   @EventHandler
   public void onRender2D(HudRenderEvent var1) {
      if (this.method2195() && this.field0970.method0492()) {
         if (field0796.field_1724 != null) {
            float var2 = field0796.field_1724.method_36454() % 360.0F;
            if (var2 < 0.0F) {
               var2 += 360.0F;
            }

            float var3 = field0796.field_1724.method_36455();
            double var4 = field0796.field_1724.method_23317() - field0796.field_1724.field_6014;
            double var6 = field0796.field_1724.method_23321() - field0796.field_1724.field_5969;
            double var8 = Math.sqrt(var4 * var4 + var6 * var6) * 20.0;
            class_4587 var10 = var1.method1806().method_51448();
            FontSize var11 = Fonts.field0075.method0654(7.0F);
            FontSize var12 = Fonts.field0075.method0654(6.0F);
            float var13 = 8.0F;
            float var14 = 12.0F;
            float var15 = 9.0F;
            float var16 = 40.0F;
            float var17 = 118.0F;
            float var18 = var13 + var14 + 3.0F * var15 + var13;
            float var19 = 4.0F;
            float var20 = 200.0F;
            Color var21 = ThemeColorManager.method1908().method0141(224);
            GuiRenderHelper.method1464(var10, var19, var20, var17, var18, 10.0F, var21, 200);
            GuiRenderHelper.method1491(var10, var11, "superfirework", var19 + var13, var20 + var13, field1726);
            float var22 = var20 + var13 + var14;
            GuiRenderHelper.method1491(var10, var12, "yaw", var19 + var13, var22, field1641);
            GuiRenderHelper.method1491(var10, var12, String.format("%.2f", var2), var19 + var13 + var16, var22, field1564);
            var22 += var15;
            GuiRenderHelper.method1491(var10, var12, "pitch", var19 + var13, var22, field1641);
            GuiRenderHelper.method1491(var10, var12, String.format("%.2f", var3), var19 + var13 + var16, var22, field1564);
            var22 += var15;
            GuiRenderHelper.method1491(var10, var12, "bps", var19 + var13, var22, field1641);
            GuiRenderHelper.method1491(var10, var12, String.format("%.2f", var8), var19 + var13 + var16, var22, field1564);
         }
      }
   }

   public enum Mode implements DisplayNamed {
      field0692("Grim"),
      field0116("Custom");

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
