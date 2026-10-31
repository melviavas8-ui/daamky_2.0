package aethereal;

import java.awt.Color;
import meteordevelopment.orbit.EventHandler;

public class ItemChams extends Module {
   private final OutlineShaderRenderer field1710 = new OutlineShaderRenderer();
   public final EnumSetting<ItemChams.RenderMode> field0058 = new EnumSetting<>("itemchams.shape", ItemChams.RenderMode.field1467)
      .method1007("Shape")
      .method0210("The portions of the effect that will be rendered")
      .method2130("Тип отрисовки");
   public final EnumSetting<ItemChams.RenderMode> field1448 = new EnumSetting<>("itemchams.mode", ItemChams.RenderMode.field0084)
      .method1007("Mode")
      .method0210("The shader algorithm used for rendering")
      .method2130("Мод отрисовки");
   public final FloatSetting field0985 = new FloatSetting(
         "itemchams.glowstrength", 6.0F, 1.0F, 20.0F, 1.0F, () -> this.field1448.method0492() == ItemChams.RenderMode.field0084
      )
      .method1007("Glow Strength")
      .method0210("The strength of the glow halo")
      .method2130("Сила");
   public final FloatSetting field0190 = new FloatSetting(
         "itemchams.glowmultiplier", 1.0F, 0.1F, 3.0F, 0.05F, () -> this.field1448.method0492() == ItemChams.RenderMode.field0084
      )
      .method1007("Glow Multiplier")
      .method0210("Brightness multiplier on top of the glow")
      .method2130("Множитель яркости");
   public final FloatSetting field0470 = new FloatSetting(
         "itemchams.glowquality", 10.0F, 1.0F, 10.0F, 1.0F, () -> this.field1448.method0492() == ItemChams.RenderMode.field0084
      )
      .method1007("Glow Quality")
      .method0210("Sample quality of the glow halo (higher = smoother + slower)")
      .method2130("Качество семплинга свечения (выше = плавнее, но медленнее)");
   public final ColorSetting field1623 = new ColorSetting("itemchams.color", 255, 255, 255, 255)
      .method1882()
      .method1007("Color")
      .method0210("Base shader color")
      .method2130("Основной цвет");
   public final BooleanSetting field1544 = new BooleanSetting("itemchams.optimize", true, () -> this.field1448.method0492() == ItemChams.RenderMode.field0084)
      .method1007("Optimize")
      .method0210("Use cheap edge sampling + early-out blur. Disable for the original full-quality blur (slower but smoother gradient).")
      .method2130("Оптимизация шейдера (быстрее, чуть упрощённый внутренний glow)");

   public ItemChams() {
      super("ItemChams", ModuleCategory.field1004, "Applies a Solid or Glow shader to the held hand viewmodel");
      this.method1013("Применяет шейдер на руки");
   }

   @EventHandler
   public void onRenderShader(RenderShaderEvent var1) {
      if (this.method2195()) {
         if (field0796.field_1724 != null && field0796.field_1687 != null) {
            this.field1710.method0578();
         }
      }
   }

   @EventHandler
   public void onRenderHand(RenderHandEvent var1) {
      if (this.method2195()) {
         if (field0796.field_1724 != null && field0796.field_1687 != null) {
            var1.method1516(this.field1710.method1517(var1.method1809(), this.field1623.method1726()));
         }
      }
   }

   @EventHandler
   public void onRenderHand$POST(RenderHandEvent.Pre var1) {
      if (this.method2195()) {
         if (field0796.field_1724 != null && field0796.field_1687 != null) {
            this.field1710.method2058().method0578();
         }
      }
   }

   @EventHandler
   public void onRenderShader$POST(RenderShaderEvent.Pre var1) {
      if (this.method2195()) {
         if (field0796.field_1724 != null && field0796.field_1687 != null) {
            this.method1735();
         }
      }
   }

   private void method1735() {
      Color var1 = this.field1623.method1726();
      int var2 = 0;
      float var3 = 1.0F;
      float var4 = 10.0F;
      float var5 = 0.01F;
      int var6 = 3;
      int var7 = this.field1544.method0492() ? 1 : 0;
      if (this.field1448.method0492() == ItemChams.RenderMode.field0084) {
         int var8 = this.field0058.method0492() == ItemChams.RenderMode.field0656 ? 0 : 2;
         float var9 = this.field0058.method0492() == ItemChams.RenderMode.field0083 ? 0.0F : var1.getAlpha() / 255.0F;
         this.field1710
            .method0743(
               var8,
               this.field0985.method0492().intValue(),
               this.field0190.method0492(),
               this.field0470.method0492().intValue(),
               var9,
               var2,
               var3,
               var4,
               var5,
               var6,
               var7
            );
      } else {
         int var10 = switch ((ItemChams.RenderMode)this.field0058.method0492()) {
            case field0656 -> 0;
            case field0083 -> 1;
            case field1467 -> 2;
         };
         float var11 = var1.getAlpha() / 255.0F;
         this.field1710.method0735(var10, var11, var2, var3, var4, var5, var6);
      }
   }

   public enum Shape implements DisplayNamed {
      field0656("Fill"),
      field0083("Outline"),
      field1467("Both");

      private final String field1030;

      Shape(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }

   public enum RenderMode implements DisplayNamed {
      field0657("Solid"),
      field0084("Glow");

      private final String field1504;

      RenderMode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }
}
