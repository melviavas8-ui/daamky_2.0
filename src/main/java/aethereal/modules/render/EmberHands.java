package aethereal;

import java.awt.Color;
import net.minecraft.class_1306;
import net.minecraft.class_1799;

public class EmberHands extends Module implements MinecraftAccess {
   private final FloatSetting field0060 = new FloatSetting("emberhands.glowradius", 15.0F, 6.0F, 32.0F, 1.0F)
      .method1007("Glow Radius")
      .method0210("Halo radius around the item in pixels")
      .method2130("Радиус ореола вокруг предмета");
   private final FloatSetting field1450 = new FloatSetting("emberhands.flameheight", 28.0F, 8.0F, 56.0F, 1.0F)
      .method1007("Flame Height")
      .method0210("How tall the flame plume stretches above the item")
      .method2130("Высота пламени над предметом");
   private final FloatSetting field0985 = new FloatSetting("emberhands.traillength", 12.0F, 3.0F, 28.0F, 1.0F)
      .method1007("Trail Length")
      .method0210("Persistence of the trailing flame")
      .method2130("Длина следа пламени");
   private final FloatSetting field0190 = new FloatSetting("emberhands.flowspeed", 1.1F, 0.25F, 2.0F, 0.05F)
      .method1007("Flow Speed")
      .method0210("Animation speed of the flame curl")
      .method2130("Скорость движения пламени");
   private final BooleanSetting field0464 = new BooleanSetting("emberhands.usecustomcolor", false)
      .method1007("Custom Color")
      .method0210("Override the fire color instead of using item color")
      .method2130("Использовать свой цвет огня вместо цвета предмета");
   private final ColorSetting field1623 = new ColorSetting("emberhands.firecolor", 255, 120, 30, 255, this.field0464::method0492)
      .method1007("Fire Color")
      .method0210("Custom fire color")
      .method2130("Цвет огня");
   private final BurningHandsRenderer field1547 = new BurningHandsRenderer();

   public EmberHands() {
      super("EmberHands", ModuleCategory.field1004, "Burning fire effect on the held item");
      this.method1013("Эффект пылающего пламени на предмете в руке");
   }

   @Override
   public void method2078() {
      super.method2078();
      this.field1547.method0578();
   }

   public void method0991(Runnable var1) {
      class_1799 var2 = field0796.field_1724 == null ? class_1799.field_8037 : field0796.field_1724.method_6047();
      class_1799 var3 = field0796.field_1724 == null ? class_1799.field_8037 : field0796.field_1724.method_6079();
      boolean var4 = !var2.method_7960();
      boolean var5 = !var3.method_7960();
      boolean var6 = field0796.field_1724 == null || field0796.field_1724.method_6068() == class_1306.field_6183;
      float var7 = 0.0F;
      float var8 = 0.0F;
      if (var4) {
         if (var6) {
            var8 = 1.0F;
         } else {
            var7 = 1.0F;
         }
      }

      if (var5) {
         if (var6) {
            var7 = 1.0F;
         } else {
            var8 = 1.0F;
         }
      }

      Color var9 = this.field1623.method1726();
      float var10 = var9.getRed() / 255.0F;
      float var11 = var9.getGreen() / 255.0F;
      float var12 = var9.getBlue() / 255.0F;
      float var13 = this.field0464.method0492() ? 1.0F : 0.0F;
      this.field1547
         .method0993(
            var1,
            var7,
            var8,
            this.field0060.method0492(),
            this.field1450.method0492(),
            this.field0985.method0492(),
            this.field0190.method0492(),
            var10,
            var11,
            var12,
            var13
         );
   }
}
