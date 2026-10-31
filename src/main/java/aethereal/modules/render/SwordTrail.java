package aethereal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1743;
import net.minecraft.class_1766;
import net.minecraft.class_1799;
import net.minecraft.class_1829;

public class SwordTrail extends Module {
   private final BooleanSetting field0034 = new BooleanSetting("swordtrail.onlymainhand", true)
      .method1007("Only Main Hand")
      .method0210("Effects only on the main hand")
      .method2130("Эффекты только на главной руке");
   private final EnumSetting<SwordTrail.ItemFilter> field1448 = new EnumSetting<>("swordtrail.itemfilter", SwordTrail.ItemFilter.field0118)
      .method1007("Item Filter")
      .method0210("Which held items trigger effects")
      .method2130("Какие предметы активируют эффекты");
   private final BooleanSetting field0970 = new BooleanSetting("swordtrail.mesh", false)
      .method1007("Mesh Afterimage")
      .method0210("3D ghost copies of the hand/item along the swing")
      .method2130("3D-призраки руки/предмета вдоль взмаха");
   private final FloatSetting field0190 = new FloatSetting("swordtrail.mesh.interval", 2.0F, 1.0F, 10.0F, 1.0F, this.field0970::method0492)
      .method1007("Spawn Interval")
      .method0210("Ticks between ghost spawns while swinging")
      .method2130("Тиков между появлениями призраков во время удара");
   private final FloatSetting field0470 = new FloatSetting("swordtrail.mesh.lifetime", 20.0F, 5.0F, 60.0F, 1.0F, this.field0970::method0492)
      .method1007("Lifetime")
      .method0210("How long each ghost lives (ticks) before disappearing")
      .method2130("Сколько тиков живёт каждый призрак до исчезновения");
   private final FloatSetting field1627 = new FloatSetting("swordtrail.mesh.fadein", 0.25F, 0.0F, 0.5F, 0.05F, this.field0970::method0492)
      .method1007("Fade In Ratio")
      .method0210("Fraction of lifetime used to fade in (appear)")
      .method2130("Доля жизни на проявление");
   private final FloatSetting field1553 = new FloatSetting("swordtrail.mesh.fadeout", 0.4F, 0.0F, 0.9F, 0.05F, this.field0970::method0492)
      .method1007("Fade Out Ratio")
      .method0210("Fraction of lifetime used to fade out (disappear)")
      .method2130("Доля жизни на исчезновение");
   private final FloatSetting field1716 = new FloatSetting("swordtrail.mesh.opacity", 0.5F, 0.1F, 1.0F, 0.05F, this.field0970::method0492)
      .method1007("Mesh Opacity")
      .method0210("Peak brightness of a ghost at its midlife")
      .method2130("Пиковая яркость призрака в середине жизни");
   private final BooleanSetting field1141 = new BooleanSetting("swordtrail.mesh.perghost", false, this.field0970::method0492)
      .method1007("Per-Ghost Shader Pass")
      .method0210("Run Shaders effect independently per ghost (more expensive)")
      .method2130("Запускать Shaders-эффект отдельно на каждого призрака (дороже)");
   private final BooleanSetting field1093 = new BooleanSetting("swordtrail.mesh.tint", false, this.field0970::method0492)
      .method1007("Mesh Tint Enabled")
      .method0210("Overlay tint color on ghosts")
      .method2130("Накладывать цвет поверх призраков");
   private final ColorSetting field1203 = new ColorSetting(
         "swordtrail.mesh.tintcolor", 255, 150, 255, 128, () -> this.field0970.method0492() && this.field1093.method0492()
      )
      .method1007("Mesh Tint Color")
      .method0210("Tint color for ghosts")
      .method2130("Цвет наложения на призраков");
   private final BooleanSetting field0875 = new BooleanSetting("swordtrail.mesh.pulse", false, this.field0970::method0492)
      .method1007("Alpha Pulse")
      .method0210("Each ghost fades in and out over time (phase-shifted across ghosts)")
      .method2130("Каждый призрак появляется и исчезает по времени (с фазовым сдвигом)");
   private final FloatSetting field0836 = new FloatSetting(
         "swordtrail.mesh.pulsespeed", 2.0F, 0.3F, 6.0F, 0.1F, () -> this.field0970.method0492() && this.field0875.method0492()
      )
      .method1007("Pulse Speed")
      .method0210("Pulsation frequency (Hz)")
      .method2130("Частота пульсации (Гц)");
   private final BooleanSetting field0914 = new BooleanSetting("swordtrail.arc", false)
      .method1007("Arc Trail")
      .method0210("Glowing ribbon along the tip trajectory")
      .method2130("Светящаяся лента вдоль траектории кончика");
   private final FloatSetting field1341 = new FloatSetting("swordtrail.arc.length", 20.0F, 5.0F, 40.0F, 1.0F, this.field0914::method0492)
      .method1007("Arc Length")
      .method0210("Segments of trajectory to render")
      .method2130("Сегментов траектории для рендера");
   private final FloatSetting field1302 = new FloatSetting("swordtrail.arc.width", 0.15F, 0.05F, 0.5F, 0.01F, this.field0914::method0492)
      .method1007("Arc Width")
      .method0210("Ribbon width in blocks")
      .method2130("Ширина ленты в блоках");
   private final ColorSetting field1374 = new ColorSetting("swordtrail.arc.start", 120, 220, 255, 255, this.field0914::method0492)
      .method1007("Arc Start Color")
      .method0210("Color at the tip end of the ribbon")
      .method2130("Цвет у головы ленты");
   private final ColorSetting field0391 = new ColorSetting("swordtrail.arc.end", 120, 220, 255, 0, this.field0914::method0492)
      .method1007("Arc End Color")
      .method0210("Color at the tail end of the ribbon")
      .method2130("Цвет у хвоста ленты");
   private final EnumSetting<SwordTrail.GradientMode> field0359 = new EnumSetting<>(
         "swordtrail.arc.gradient", SwordTrail.GradientMode.field0120, this.field0914::method0492
      )
      .method1007("Arc Gradient Mode")
      .method0210("Color mode")
      .method2130("Режим окраски");
   private final EnumSetting<SwordTrail.FadeMode> field0429 = new EnumSetting<>(
         "swordtrail.arc.fade", SwordTrail.FadeMode.field0119, this.field0914::method0492
      )
      .method1007("Arc Fade Curve")
      .method0210("Alpha falloff curve along the ribbon")
      .method2130("Кривая затухания прозрачности по ленте");
   private final BooleanSetting field0259 = new BooleanSetting("swordtrail.particle", false)
      .method1007("Particle Shatter")
      .method0210("Glow particles spawned along the swing with physics")
      .method2130("Светящиеся частицы по траектории удара с физикой");
   private final FloatSetting field0234 = new FloatSetting("swordtrail.particle.rate", 5.0F, 1.0F, 20.0F, 1.0F, this.field0259::method0492)
      .method1007("Particle Rate")
      .method0210("Particles spawned per tick of swing")
      .method2130("Частиц за тик свинга");
   private final FloatSetting field0295 = new FloatSetting("swordtrail.particle.lifetime", 15.0F, 5.0F, 40.0F, 1.0F, this.field0259::method0492)
      .method1007("Particle Lifetime")
      .method0210("Ticks before particle dies")
      .method2130("Тиков жизни частицы");
   private final ColorSetting field0527 = new ColorSetting("swordtrail.particle.color", 255, 220, 140, 200, this.field0259::method0492)
      .method1007("Particle Color")
      .method0210("Particle tint")
      .method2130("Цвет частиц");
   private final FloatSetting field0506 = new FloatSetting("swordtrail.particle.size", 0.05F, 0.02F, 0.2F, 0.005F, this.field0259::method0492)
      .method1007("Particle Size")
      .method0210("Particle size in blocks")
      .method2130("Размер частиц в блоках");
   private final FloatSetting field0552 = new FloatSetting("swordtrail.particle.spread", 15.0F, 0.0F, 45.0F, 1.0F, this.field0259::method0492)
      .method1007("Particle Spread")
      .method0210("Cone half-angle in degrees")
      .method2130("Полу-угол конуса разлёта, градусы");
   private final FloatSetting field1676 = new FloatSetting("swordtrail.particle.gravity", 0.02F, 0.0F, 0.2F, 0.005F, this.field0259::method0492)
      .method1007("Particle Gravity")
      .method0210("Downward pull per tick")
      .method2130("Ускорение вниз за тик");
   private final BooleanSetting field1659 = new BooleanSetting("swordtrail.particle.glowtex", true, this.field0259::method0492)
      .method1007("Glow Texture")
      .method0210("Use glow.png as particle sprite")
      .method2130("Использовать glow.png как спрайт частицы");
   private final SwordTrailBuffer field1694 = new SwordTrailBuffer();
   private final SwordTrailGlow field1594 = new SwordTrailGlow();
   private final List<SwordTrailAnimation> field1585 = new ArrayList<>();
   private float field1601 = 0.0F;
   private boolean field1762 = false;
   private int field1740 = 0;

   public SwordTrail() {
      super("SwordTrail", ModuleCategory.field1004, "Arc, afterimage and particle trails for swings");
      this.method1013("Эффекты следа при ударе: дуга, призраки и частицы");
   }

   public SwordTrailBuffer method1712() {
      return this.field1694;
   }

   public boolean method1692() {
      return this.field1762;
   }

   public boolean method1755() {
      return this.field0034.method0492();
   }

   public boolean method2030() {
      return this.field0751 && this.field0970.method0492() && this.method2278();
   }

   public float method2001() {
      return this.field1716.method0492();
   }

   public boolean method2044() {
      return this.field1141.method0492();
   }

   public boolean method0472() {
      return this.field1093.method0492();
   }

   public Color method0453() {
      return this.field1203.method1726();
   }

   public boolean method0480() {
      return this.field0751 && this.field0914.method0492() && this.method2278();
   }

   public int method0400() {
      return this.field1341.method0492().intValue();
   }

   public float method0393() {
      return this.field1302.method0492();
   }

   public Color method0407() {
      return this.field1374.method1726();
   }

   public Color method0518() {
      return this.field0391.method1726();
   }

   public SwordTrail.GradientMode method0514() {
      return this.field0359.method0492();
   }

   public SwordTrail.FadeMode method0525() {
      return this.field0429.method0492();
   }

   public boolean method2247() {
      return this.field0751 && this.field0259.method0492() && this.method2278();
   }

   public int method2240() {
      return this.field0234.method0492().intValue();
   }

   public int method2248() {
      return this.field0295.method0492().intValue();
   }

   public Color method2205() {
      return this.field0527.method1726();
   }

   public float method2200() {
      return this.field0506.method0492();
   }

   public float method2209() {
      return this.field0552.method0492();
   }

   public float method2273() {
      return this.field1676.method0492();
   }

   public boolean method2272() {
      return this.field1659.method0492();
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field1694.method0578();
      this.field1585.clear();
      this.field1740 = 0;
      this.field1601 = 0.0F;
      this.field1762 = false;
   }

   @Override
   public void method2078() {
      super.method2078();
      this.field1694.method0578();
      this.field1594.method0025();
      this.field1585.clear();
   }

   private boolean method1241(class_1799 var1) {
      if (var1 != null && !var1.method_7960()) {
         return switch ((SwordTrail.ItemFilter)this.field1448.method0492()) {
            case field0694 -> false;
            case field0118 -> var1.method_7909() instanceof class_1829;
            case field1489 -> var1.method_7909() instanceof class_1829 || var1.method_7909() instanceof class_1743 || var1.method_7909() instanceof class_1766;
            case field1018 -> true;
         };
      } else {
         return this.field1448.method0492() == SwordTrail.ItemFilter.field1018;
      }
   }

   public boolean method2278() {
      if (method1974()) {
         return false;
      } else {
         return !this.field0751 ? false : this.method1241(field0796.field_1724.method_6047());
      }
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!this.method2278()) {
         this.field1762 = false;
         this.method1896();
      } else {
         float var2 = field0796.field_1724.method_6055(1.0F);
         this.field1762 = field0796.field_1724.field_6279 > 0 || var2 > 0.001F;
         if (this.field1762) {
            this.field1694.method0827(this.field1694.method1187(field0796.field_1724, 1.0F));
            if (this.field0970.method0492()) {
               int var3 = Math.max(1, this.field0190.method0492().intValue());
               if (this.field1740 <= 0) {
                  this.field1585.add(new SwordTrailAnimation(var2, Math.max(2, this.field0470.method0492().intValue())));
                  this.field1740 = var3;
               } else {
                  this.field1740--;
               }
            }
         } else {
            this.field1740 = 0;
         }

         this.method1896();
         if (field0796.field_1687 != null) {
            this.field1694.method0782(field0796.field_1687.method_8510(), 60L);
         }

         this.field1594.method0578();
         this.field1601 = var2;
      }
   }

   private void method1896() {
      Iterator var1 = this.field1585.iterator();

      while (var1.hasNext()) {
         SwordTrailAnimation var2 = var1.next();
         var2.field0004++;
         if (var2.method0579()) {
            var1.remove();
         }
      }
   }

   public List<SwordTrailAnimation> method1924() {
      return this.field1585;
   }

   public float method1919() {
      return this.field1627.method0492();
   }

   public float method1925() {
      return this.field1553.method0492();
   }

   @EventHandler
   public void onRenderWorld(GlowRenderEvent var1) {
      if (this.method2278()) {
         SwordTrailTransform.method1452(var1.method1808());
         this.field1594.method0665(var1.method1603());
      }
   }

   public enum ItemFilter implements DisplayNamed {
      field0694("None"),
      field0118("Swords Only"),
      field1489("Tools"),
      field1018("Any");

      private final String field0791;

      ItemFilter(String var3) {
         this.field0791 = var3;
      }

      @Override
      public String method0557() {
         return this.field0791;
      }
   }

   public enum FadeMode implements DisplayNamed {
      field0695("Linear"),
      field0119("EaseOut");

      private final String field1504;

      FadeMode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }

   public enum GradientMode implements DisplayNamed {
      field0696("Solid"),
      field0120("Gradient"),
      field1490("Rainbow");

      private final String field1030;

      GradientMode(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }
}
