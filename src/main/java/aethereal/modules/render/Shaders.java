package aethereal;

import java.awt.Color;
import java.util.Arrays;
import lombok.Generated;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1297;
import net.minecraft.class_1657;

public class Shaders extends Module {
   private static Shaders field0268;
   private final OutlineShaderRenderer field0230 = new OutlineShaderRenderer();
   public EnumSetting<Shaders.Mode> field0058 = new EnumSetting<>("Mode", Shaders.Mode.field1485)
      .method1007("Mode")
      .method0210("Shader render mode")
      .method2130("Тип отрисовки");
   public ColorSetting field1443 = new ColorSetting("Color", 255, 152, 236, 75)
      .method1882()
      .method1007("Color")
      .method0210("Base shader color")
      .method2130("Цвет");
   public MultiSelectSetting field1005 = new MultiSelectSetting(
         "Target", Arrays.asList("Players", "Hostiles", "Animals", "Ambient", "Invisibles", "Items", "Crystals", "Others", "Hands"), false, () -> true
      )
      .method1007("Target")
      .method0210("Entity types to apply shaders to")
      .method2130("Типы сущностей");
   public MultiSelectSetting field0202 = new MultiSelectSetting(
         "Enhance", Arrays.asList("Shine", "Glint", "Noise", "Circuit"), () -> this.field0058.method0492() != Shaders.Mode.field0110
      )
      .method1007("Enhance")
      .method0210("Shader enhancement effects")
      .method2130("Эффекты шейдера");
   public ColorSetting field0466 = new ColorSetting("HostilesColor", 250, 150, 255, 80, () -> this.field1005.method0439("Hostiles").method0492())
      .method1882()
      .method1007("Hostiles Color")
      .method0210("Shader color for hostile mobs")
      .method2130("Цвет для враждебных мобов");
   public ColorSetting field1623 = new ColorSetting("AnimalsColor", 100, 255, 100, 80, () -> this.field1005.method0439("Animals").method0492())
      .method1882()
      .method1007("Animals Color")
      .method0210("Shader color for animals")
      .method2130("Цвет для животных");
   public ColorSetting field1550 = new ColorSetting("AmbientColor", 150, 150, 255, 80, () -> this.field1005.method0439("Ambient").method0492())
      .method1882()
      .method1007("Ambient Color")
      .method0210("Shader color for ambient creatures")
      .method2130("Цвет для фоновых существ");
   public ColorSetting field1711 = new ColorSetting("InvisiblesColor", 253, 121, 218, 80, () -> this.field1005.method0439("Invisibles").method0492())
      .method1882()
      .method1007("Invisibles Color")
      .method0210("Shader color for invisible entities")
      .method2130("Цвет для невидимых сущностей");
   public FloatSetting field1144 = new FloatSetting(
         "GlintSpeed",
         1.0F,
         0.1F,
         2.0F,
         0.05F,
         () -> this.field0058.method0492() != Shaders.Mode.field0110 && this.field0202.method0439("Glint").method0492()
      )
      .method1007("Glint Speed")
      .method0210("Speed of the glint animation")
      .method2130("Скорость анимации");
   public FloatSetting field1097 = new FloatSetting(
         "GlintWidth",
         2.0F,
         0.1F,
         2.0F,
         0.05F,
         () -> this.field0058.method0492() != Shaders.Mode.field0110 && this.field0202.method0439("Glint").method0492()
      )
      .method1007("Glint Width")
      .method0210("Width of the glint band")
      .method2130("Ширина полосы");
   public FloatSetting field1206 = new FloatSetting(
         "GlintGrad",
         3.0F,
         1.0F,
         10.0F,
         0.5F,
         () -> this.field0058.method0492() != Shaders.Mode.field0110 && this.field0202.method0439("Glint").method0492()
      )
      .method1007("Glint Gradient")
      .method0210("Glint gradient softness")
      .method2130("Мягкость градиента");
   public ColorSetting field0878 = new ColorSetting(
         "GlintColor", 255, 0, 200, 175, () -> this.field0058.method0492() != Shaders.Mode.field0110 && this.field0202.method0439("Glint").method0492()
      )
      .method1882()
      .method1007("Glint Color")
      .method0210("Color of the glint effect")
      .method2130("Цвет блика");
   public FloatSetting field0836 = new FloatSetting(
         "NoiseSpeed",
         5.0F,
         0.1F,
         5.0F,
         0.1F,
         () -> this.field0058.method0492() != Shaders.Mode.field0110 && this.field0202.method0439("Noise").method0492()
      )
      .method1007("Noise Speed")
      .method0210("Speed of noise animation")
      .method2130("Скорость анимации");
   public FloatSetting field0919 = new FloatSetting(
         "NoiseAngle",
         360.0F,
         0.0F,
         360.0F,
         1.0F,
         () -> this.field0058.method0492() != Shaders.Mode.field0110 && this.field0202.method0439("Noise").method0492()
      )
      .method1007("Noise Angle")
      .method0210("Angle of noise pattern")
      .method2130("Угол паттерна");
   public FloatSetting field1341 = new FloatSetting(
         "NoiseScale",
         20.0F,
         1.0F,
         20.0F,
         0.5F,
         () -> this.field0058.method0492() != Shaders.Mode.field0110 && this.field0202.method0439("Noise").method0492()
      )
      .method1007("Noise Scale")
      .method0210("Scale of noise pattern")
      .method2130("Масштаб паттерна");
   public ColorSetting field1299 = new ColorSetting(
         "NoiseColor",
         255,
         110,
         221,
         255,
         () -> this.field0058.method0492() != Shaders.Mode.field0110 && this.field0202.method0439("Noise").method0492()
      )
      .method1882()
      .method1007("Noise Color")
      .method0210("Color of the noise effect")
      .method2130("Цвет шума");
   public FloatSetting field1377 = new FloatSetting(
         "CircuitSpeed",
         0.2F,
         0.1F,
         2.0F,
         0.1F,
         () -> this.field0058.method0492() != Shaders.Mode.field0110 && this.field0202.method0439("Circuit").method0492()
      )
      .method1007("Circuit Speed")
      .method0210("Speed of circuit animation")
      .method2130("Скорость анимации");
   public FloatSetting field0393 = new FloatSetting(
         "CircuitIntensity",
         2.4F,
         0.1F,
         3.0F,
         0.1F,
         () -> this.field0058.method0492() != Shaders.Mode.field0110 && this.field0202.method0439("Circuit").method0492()
      )
      .method1007("Circuit Intensity")
      .method0210("Intensity of circuit pattern")
      .method2130("Интенсивность паттерна");
   public ColorSetting field0357 = new ColorSetting(
         "CircuitColor",
         212,
         35,
         129,
         255,
         () -> this.field0058.method0492() != Shaders.Mode.field0110 && this.field0202.method0439("Circuit").method0492()
      )
      .method1882()
      .method1007("Circuit Color")
      .method0210("Color of the circuit effect")
      .method2130("Цвет эффекта");
   public BooleanSetting field0426 = new BooleanSetting("FriendColor", true)
      .method1007("Friend Color")
      .method0210("Render friends in green instead of the default color")
      .method2130("Рисовать друзей зелёным цветом");
   private boolean field0302;
   private boolean field0538;
   private boolean field0514;
   private boolean field0558;
   private boolean field1683;
   private boolean field1665;
   private boolean field1699;
   private boolean field1597;
   private boolean field1586;

   public OutlineShaderRenderer method1708() {
      return this.field0230;
   }

   public Shaders() {
      super("Shaders", ModuleCategory.field1004, "Applies shader effects to entities");
      this.method1013("Применяет шейдер к сущностям");
      field0268 = this;
      this.field1005.method0439("Players").method0206(true);
      this.field1005.method0439("Hostiles").method0206(true);
      this.field1005.method0439("Animals").method0206(true);
      this.field1005.method0439("Ambient").method0206(true);
      this.field1005.method0439("Invisibles").method0206(true);
      this.field1005.method0439("Items").method0206(true);
      this.field1005.method0439("Crystals").method0206(true);
      this.field1005.method0439("Others").method0206(true);
      this.field1005.method0439("Hands").method0206(true);
      this.field0202.method0439("Shine").method0206(true);
      this.field0202.method0439("Glint").method0206(true);
      this.field0202.method0439("Noise").method0206(true);
      this.field0202.method0439("Circuit").method0206(true);
   }

   @EventHandler
   public void onRenderShader(RenderShaderEvent var1) {
      if (this.method2195()) {
         if (field0796.field_1724 != null && field0796.field_1687 != null) {
            this.method0457();
            this.field0230.method0578();
         }
      }
   }

   @EventHandler
   public void onRenderEntity(RenderEntityEvent var1) {
      if (this.method2195()) {
         if (field0796.field_1724 != null && field0796.field_1687 != null) {
            if (this.method1129(var1.method1798())) {
               Color var2 = this.method0234(var1.method1798());
               var1.method1516(this.field0230.method1517(var1.method1630(), var2));
            }
         }
      }
   }

   @EventHandler
   public void onRenderEntity$POST(RenderEntityEvent.Pre var1) {
      if (this.method2195()) {
         if (field0796.field_1724 != null && field0796.field_1687 != null) {
            if (this.method0472()) {
               this.field0230.method2058().method0578();
               if (!this.field1586) {
                  this.method2043();
               }
            }
         }
      }
   }

   @EventHandler
   public void onRenderHand(RenderHandEvent var1) {
      if (this.method2195()) {
         if (field0796.field_1724 != null && field0796.field_1687 != null) {
            if (this.field1586) {
               Color var2 = this.field1443.method1726();
               var1.method1516(this.field0230.method1517(var1.method1809(), var2));
            }
         }
      }
   }

   @EventHandler
   public void onRenderHand$POST(RenderHandEvent.Pre var1) {
      if (this.method2195()) {
         if (field0796.field_1724 != null && field0796.field_1687 != null) {
            if (this.field1586) {
               this.field0230.method2058().method0578();
            }
         }
      }
   }

   @EventHandler
   public void onRenderShader$POST(RenderShaderEvent.Pre var1) {
      if (this.method2195()) {
         if (field0796.field_1724 != null && field0796.field_1687 != null) {
            if (this.field1586) {
               this.method2043();
            }
         }
      }
   }

   private void method2043() {
      this.field0230
         .method0764(
            this.field0058.method0492() == Shaders.Mode.field0686 ? 0 : (this.field0058.method0492() == Shaders.Mode.field0110 ? 1 : 2),
            this.field1443.method1726(),
            this.field0202.method0439("Shine").method0492(),
            this.field0202.method0439("Glint").method0492(),
            this.field1144.method0492(),
            this.field1097.method0492(),
            this.field1206.method0492(),
            this.field0878.method1726(),
            this.field0202.method0439("Noise").method0492(),
            this.field0836.method0492(),
            this.field0919.method0492(),
            this.field1341.method0492(),
            this.field1299.method1726(),
            this.field0202.method0439("Circuit").method0492(),
            this.field1377.method0492(),
            this.field0393.method0492(),
            this.field0357.method1726()
         );
   }

   public void method1691() {
      if (this.method2195()) {
         if (field0796.field_1724 != null && field0796.field_1687 != null) {
            if (this.field1586) {
               this.field0230.method2058().method0578();
               this.method2043();
            }
         }
      }
   }

   private boolean method0472() {
      return this.field0302 || this.field0538 || this.field0514 || this.field0558 || this.field1683 || this.field1665 || this.field1699 || this.field1597;
   }

   public boolean method1755() {
      return this.field1586;
   }

   public Color method2023() {
      return this.field1443.method1726();
   }

   private void method0457() {
      this.field0302 = this.field1005.method0439("Players").method0492();
      this.field0538 = this.field1005.method0439("Hostiles").method0492();
      this.field0514 = this.field1005.method0439("Animals").method0492();
      this.field0558 = this.field1005.method0439("Ambient").method0492();
      this.field1683 = this.field1005.method0439("Invisibles").method0492();
      this.field1665 = this.field1005.method0439("Items").method0492();
      this.field1699 = this.field1005.method0439("Crystals").method0492();
      this.field1597 = this.field1005.method0439("Others").method0492();
      this.field1586 = this.field1005.method0439("Hands").method0492();
   }

   public boolean method1129(class_1297 var1) {
      if (this.field0302 && EntityFilter.method1129(var1)) {
         return true;
      } else if (this.field0538 && EntityFilter.method0235(var1)) {
         return true;
      } else if (this.field0514 && EntityFilter.method2144(var1)) {
         return true;
      } else if (this.field0558 && EntityFilter.method1851(var1)) {
         return true;
      } else if (this.field1683 && var1.method_5767()) {
         return true;
      } else if (this.field1665 && EntityFilter.method1660(var1)) {
         return true;
      } else {
         return this.field1699 && EntityFilter.method1988(var1) ? true : this.field1597;
      }
   }

   private Color method0234(class_1297 var1) {
      if (!(var1 instanceof class_1657 var2)) {
         EntityFilter.EntityKind var5 = EntityFilter.method2237(var1);

         return switch (var5) {
            case field0644 -> this.field1443.method1726();
            case field0074 -> this.field0466.method1726();
            case field1459 -> this.field1623.method1726();
            case field0994 -> this.field1550.method1726();
            case field0773 -> this.field1711.method1726();
            case field1257, field0324, field0196 -> this.field1443.method1726();
         };
      } else {
         boolean var3 = this.field0426.method0492() && DaamkyClient.method2004().method1608().method2135(var2.method_5477().getString());
         if (var3) {
            Color var4 = this.field1443.method1726();
            return new Color(66, 245, 149, var4.getAlpha());
         } else {
            return this.field1443.method1726();
         }
      }
   }

   @Generated
   public static Shaders method2009() {
      return field0268;
   }

   public enum Mode implements DisplayNamed {
      field0686("Fill"),
      field0110("Outline"),
      field1485("Both");

      private final String field1030;

      Mode(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }
}
