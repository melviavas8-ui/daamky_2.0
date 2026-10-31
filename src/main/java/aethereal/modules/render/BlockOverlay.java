package aethereal;

import java.awt.Color;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_4587;
import net.minecraft.class_239.class_240;

public class BlockOverlay extends Module {
   private final EnumSetting<BlockOverlay.RenderMode> field0058 = new EnumSetting<>("blockoverlay.mode", BlockOverlay.RenderMode.field0597)
      .method1007("Mode")
      .method0210("Rendering style")
      .method2130("Стиль отрисовки");
   private final ColorSetting field1443 = new ColorSetting(
         "blockoverlay.color", 74, 214, 160, 180, () -> this.field0058.method0492() != BlockOverlay.RenderMode.field0969
      )
      .method1882()
      .method1007("Color")
      .method0210("Main overlay color")
      .method2130("Основной цвет");
   private final BooleanSetting field0970 = new BooleanSetting(
         "blockoverlay.grid", false, () -> this.field0058.method0492() != BlockOverlay.RenderMode.field0969
      )
      .method1007("Grid")
      .method0210("Draw grid lines on block faces")
      .method2130("Сетки на гранях");
   private final FloatSetting field0190 = new FloatSetting(
         "blockoverlay.gridStep",
         4.0F,
         2.0F,
         16.0F,
         1.0F,
         () -> this.field0970.method0492() && this.field0058.method0492() != BlockOverlay.RenderMode.field0969
      )
      .method1007("Grid Cells")
      .method0210("Number of grid cells per face")
      .method2130("Количество ячеек сетки");
   private final EnumSetting<BlockShaderRenderer.ShaderType> field0469 = new EnumSetting<>(
         "blockoverlay.shadertype", BlockShaderRenderer.ShaderType.field0615, () -> this.field0058.method0492() == BlockOverlay.RenderMode.field0969
      )
      .method1007("Shader Type")
      .method0210("Which shader effect to use")
      .method2130("Какой шейдерный эффект использовать");
   private final FloatSetting field1627 = new FloatSetting("blockoverlay.animspeed", 15.0F, 10.0F, 40.0F, 1.0F)
      .method1007("Transition Speed")
      .method0210("How fast the overlay slides between blocks")
      .method2130("Скорость анимации перехода");
   private final BlockShaderRenderer field1546 = new BlockShaderRenderer();
   private class_238 field1732;
   private long field1138;

   public BlockOverlay() {
      super("BlockOverlay", ModuleCategory.field1004, "Customizes block selection overlay");
      this.method1013("Улучшает визуальное отображение обводки блока при наводке");
      this.method0213("B");
   }

   @Override
   public void method2078() {
      super.method2078();
      this.field1732 = null;
      this.field1138 = 0L;
      this.field1546.method0578();
   }

   @EventHandler
   public void onRender3DWorld(WorldRenderEvent.WorldPass var1) {
      if (!method1974()) {
         class_238 var2 = this.method1733();
         class_238 var3 = this.method1282(var2);
         if (var3 != null) {
            BlockOverlay.RenderMode var4 = this.field0058.method0492();
            if (var4 != BlockOverlay.RenderMode.field0969) {
               class_4587 var5 = new class_4587();
               Color var6 = this.field1443.method1726();
               if (var4 == BlockOverlay.RenderMode.field0033 || var4 == BlockOverlay.RenderMode.field1431) {
                  int var7 = Math.max(20, var6.getAlpha() / 3);
                  Color var8 = new Color(var6.getRed(), var6.getGreen(), var6.getBlue(), var7);
                  WorldRenderHelper.method1498(var5, var3, var8);
               }

               if (var4 == BlockOverlay.RenderMode.field0597 || var4 == BlockOverlay.RenderMode.field1431) {
                  WorldRenderHelper.method2173(var5, var3, var6);
               }

               if (this.field0970.method0492()) {
                  this.method1498(var5, var3, var6);
               }
            }
         }
      }
   }

   @EventHandler
   public void onRender3DGame(WorldRenderEvent.GamePass var1) {
      if (!method1974()) {
         if (this.field0058.method0492() == BlockOverlay.RenderMode.field0969) {
            if (this.field1732 != null) {
               float var2 = (float)System.nanoTime() / 1.0E9F * 1.5F;
               Color var3 = ThemeColorManager.method1908().method2063();
               this.field1546.method1285(this.field1732, var3, var2, 2.0F, this.field0469.method0492());
            }
         }
      }
   }

   private class_238 method1733() {
      if (field0796.field_1765 instanceof class_3965 var1) {
         if (var1.method_17783() != class_240.field_1332) {
            return null;
         }

         class_2338 var4 = var1.method_17777();
         class_265 var3 = field0796.field_1687.method_8320(var4).method_26218(field0796.field_1687, var4);
         return var3.method_1110() ? null : var3.method_1107().method_996(var4);
      } else {
         return null;
      }
   }

   private class_238 method1282(class_238 var1) {
      long var2 = System.nanoTime();
      float var4 = this.field1138 == 0L ? 0.016666668F : Math.min(0.5F, (float)(var2 - this.field1138) / 1.0E9F);
      this.field1138 = var2;
      if (var1 == null) {
         this.field1732 = null;
         return null;
      } else if (this.field1732 == null) {
         this.field1732 = var1;
         return this.field1732;
      } else {
         float var5 = 1.0F - (float)Math.exp(-this.field1627.method0492() * var4);
         var5 = class_3532.method_15363(var5, 0.0F, 1.0F);
         this.field1732 = new class_238(
            class_3532.method_16436(var5, this.field1732.field_1323, var1.field_1323),
            class_3532.method_16436(var5, this.field1732.field_1322, var1.field_1322),
            class_3532.method_16436(var5, this.field1732.field_1321, var1.field_1321),
            class_3532.method_16436(var5, this.field1732.field_1320, var1.field_1320),
            class_3532.method_16436(var5, this.field1732.field_1325, var1.field_1325),
            class_3532.method_16436(var5, this.field1732.field_1324, var1.field_1324)
         );
         return this.field1732;
      }
   }

   private void method1498(class_4587 var1, class_238 var2, Color var3) {
      int var4 = this.field0190.method0492().intValue();
      if (var4 >= 2) {
         double var5 = (var2.field_1320 - var2.field_1323) / var4;
         double var7 = (var2.field_1325 - var2.field_1322) / var4;
         double var9 = (var2.field_1324 - var2.field_1321) / var4;
         Color var11 = new Color(var3.getRed(), var3.getGreen(), var3.getBlue(), Math.max(40, var3.getAlpha() / 2));

         for (int var12 = 1; var12 < var4; var12++) {
            double var13 = var2.field_1323 + var5 * var12;
            double var15 = var2.field_1322 + var7 * var12;
            double var17 = var2.field_1321 + var9 * var12;
            WorldRenderHelper.method1507(
               var1, new class_243(var13, var2.field_1325, var2.field_1321), new class_243(var13, var2.field_1325, var2.field_1324), var11
            );
            WorldRenderHelper.method1507(
               var1, new class_243(var2.field_1323, var2.field_1325, var17), new class_243(var2.field_1320, var2.field_1325, var17), var11
            );
            WorldRenderHelper.method1507(
               var1, new class_243(var13, var2.field_1322, var2.field_1321), new class_243(var13, var2.field_1322, var2.field_1324), var11
            );
            WorldRenderHelper.method1507(
               var1, new class_243(var2.field_1323, var2.field_1322, var17), new class_243(var2.field_1320, var2.field_1322, var17), var11
            );
            WorldRenderHelper.method1507(
               var1, new class_243(var13, var2.field_1322, var2.field_1321), new class_243(var13, var2.field_1325, var2.field_1321), var11
            );
            WorldRenderHelper.method1507(
               var1, new class_243(var2.field_1323, var15, var2.field_1321), new class_243(var2.field_1320, var15, var2.field_1321), var11
            );
            WorldRenderHelper.method1507(
               var1, new class_243(var13, var2.field_1322, var2.field_1324), new class_243(var13, var2.field_1325, var2.field_1324), var11
            );
            WorldRenderHelper.method1507(
               var1, new class_243(var2.field_1323, var15, var2.field_1324), new class_243(var2.field_1320, var15, var2.field_1324), var11
            );
            WorldRenderHelper.method1507(
               var1, new class_243(var2.field_1323, var15, var2.field_1321), new class_243(var2.field_1323, var15, var2.field_1324), var11
            );
            WorldRenderHelper.method1507(
               var1, new class_243(var2.field_1323, var2.field_1322, var17), new class_243(var2.field_1323, var2.field_1325, var17), var11
            );
            WorldRenderHelper.method1507(
               var1, new class_243(var2.field_1320, var15, var2.field_1321), new class_243(var2.field_1320, var15, var2.field_1324), var11
            );
            WorldRenderHelper.method1507(
               var1, new class_243(var2.field_1320, var2.field_1322, var17), new class_243(var2.field_1320, var2.field_1325, var17), var11
            );
         }
      }
   }

   public enum RenderMode implements DisplayNamed {
      field0597("Outline"),
      field0033("Fill"),
      field1431("Both"),
      field0969("Shader");

      private final String field0791;

      RenderMode(String var3) {
         this.field0791 = var3;
      }

      @Override
      public String method0557() {
         return this.field0791;
      }
   }
}
