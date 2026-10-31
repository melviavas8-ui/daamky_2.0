package aethereal;

import java.awt.Color;

public class ModifyGlint extends Module {
   public static ModifyGlint field0087;
   public ColorSetting field1443 = new ColorSetting("modifyglint.color", 215, 133, 255, 255)
      .method1882()
      .method1007("Glint Color")
      .method0210("Custom glint color")
      .method2130("Цвет");
   public FloatSetting field0985 = new FloatSetting("modifyglint.alpha", 2.0F, 0.0F, 2.0F, 0.05F)
      .method1007("Alpha")
      .method0210("Glint transparency")
      .method2130("Прозрачность");
   public FloatSetting field0190 = new FloatSetting("modifyglint.speed", 0.1F, 0.1F, 5.0F, 0.1F)
      .method1007("Speed")
      .method0210("Glint animation speed")
      .method2130("Скорость");
   public FloatSetting field0470 = new FloatSetting("modifyglint.brightness", 3.0F, 0.5F, 3.0F, 0.1F)
      .method1007("Brightness")
      .method0210("Glint brightness multiplier")
      .method2130("Яркость");

   public ModifyGlint() {
      super("ModifyGlint", ModuleCategory.field1004, "Modifies enchantment glint appearance");
      this.method1013("Изменяет отображение блеска зачарования");
      field0087 = this;
   }

   public Color method1726() {
      if (!this.method2195()) {
         return new Color(255, 255, 255, 255);
      }

      Color var1 = this.field1443.method1726();
      float var2 = this.field0470.method0492();
      int var3 = Math.min(255, (int)(var1.getRed() * var2));
      int var4 = Math.min(255, (int)(var1.getGreen() * var2));
      int var5 = Math.min(255, (int)(var1.getBlue() * var2));
      return new Color(var3, var4, var5, var1.getAlpha());
   }

   public float method1679() {
      return !this.method2195() ? 1.0F : this.field0985.method0492();
   }

   public float method1741() {
      return !this.method2195() ? 1.0F : this.field0190.method0492();
   }
}
