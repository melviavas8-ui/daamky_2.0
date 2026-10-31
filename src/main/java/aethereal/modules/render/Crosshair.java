package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10142;
import net.minecraft.class_10149;
import net.minecraft.class_10156;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_4587;
import net.minecraft.class_5944;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;

public class Crosshair extends Module {
   private static final class_10156 field0146 = new class_10156(ResourceHelper.method1012("border_circular"), class_290.field_1576, class_10149.field_53930);
   private final EnumSetting<Crosshair.Style> field1448 = new EnumSetting<>("crosshair.style", Crosshair.Style.field0621)
      .method1007("Style")
      .method0210("Crosshair shape style")
      .method2130("Стиль прицела");
   private final FloatSetting field0985 = new FloatSetting(
         "crosshair.radius", 4.5F, 1.0F, 30.0F, 0.5F, () -> this.field1448.method0492() == Crosshair.Style.field0621
      )
      .method1007("Radius")
      .method0210("Crosshair circle radius")
      .method2130("Радиус");
   private final FloatSetting field0190 = new FloatSetting("crosshair.thickness", 0.1F, 0.1F, 10.0F, 0.1F)
      .method1007("Thickness")
      .method0210("Crosshair ring/line thickness")
      .method2130("Толщина");
   private final FloatSetting field0470 = new FloatSetting(
         "crosshair.length", 4.5F, 1.0F, 30.0F, 0.5F, () -> this.field1448.method0492() == Crosshair.Style.field0052
      )
      .method1007("Length")
      .method0210("Cross arm length")
      .method2130("Длина");
   private final FloatSetting field1627 = new FloatSetting(
         "crosshair.gap", 1.5F, 0.0F, 15.0F, 0.5F, () -> this.field1448.method0492() == Crosshair.Style.field0052
      )
      .method1007("Gap")
      .method0210("Gap from center")
      .method2130("Отступ от центра");
   private final ColorSetting field1550 = new ColorSetting("crosshair.color", 255, 139, 241, 255)
      .method1882()
      .method1007("Color")
      .method0210("Crosshair color")
      .method2130("Цвет прицела");
   private final BooleanSetting field1709 = new BooleanSetting("crosshair.dynamic", false)
      .method1007("Dynamic")
      .method0210("Crosshair reacts to camera and player movement")
      .method2130("Реагировать на движения игрока");
   private float field1136 = 0.0F;
   private float field1087 = 0.0F;
   private float field1196 = 0.0F;
   private float field0871 = 0.0F;
   private boolean field0845 = true;
   private float field0910 = 0.0F;
   private float field1331 = 0.0F;
   private float field1292 = 0.0F;

   public Crosshair() {
      super("Crosshair", ModuleCategory.field1004, "Customizes the crosshair appearance");
      this.method1013("Позволяет сделать свой прицел");
   }

   @EventHandler
   public void onRender2D(HudRenderEvent var1) {
      if (!method1974()) {
         class_4587 var2 = var1.method1806().method_51448();
         float var3 = field0796.field_1724.method_36454();
         float var4 = field0796.field_1724.method_36455();
         if (this.field0845) {
            this.field1196 = var3;
            this.field0871 = var4;
            this.field0845 = false;
         }

         if (this.field1709.method0492()) {
            float var5 = this.field1196 - var3;
            float var6 = this.field0871 - var4;

            while (var5 > 180.0F) {
               var5 -= 360.0F;
            }

            while (var5 < -180.0F) {
               var5 += 360.0F;
            }

            float var7 = var5 * 2.0F;
            float var8 = var6 * 2.0F;
            float var9 = (float)field0796.field_1724.method_18798().field_1352;
            float var10 = (float)field0796.field_1724.method_18798().field_1351;
            float var11 = (float)field0796.field_1724.method_18798().field_1350;
            this.field0910 = this.field0910 + (var9 - this.field0910) * 0.15F;
            this.field1331 = this.field1331 + (var10 - this.field1331) * 0.15F;
            this.field1292 = this.field1292 + (var11 - this.field1292) * 0.15F;
            float var12 = (float)Math.toRadians(field0796.field_1724.method_36454());
            float var13 = (float)(-this.field0910 * Math.sin(var12) + this.field1292 * Math.cos(var12));
            float var14 = (float)(this.field0910 * Math.cos(var12) + this.field1292 * Math.sin(var12));
            var7 += var14 * 10.0F;
            var8 += var13 * 10.0F;
            var8 -= this.field1331 * 8.0F;
            this.field1136 = this.field1136 + (var7 - this.field1136) * 0.05F;
            this.field1087 = this.field1087 + (var8 - this.field1087) * 0.05F;
            if (Math.abs(this.field1136) < 0.01F) {
               this.field1136 = 0.0F;
            }

            if (Math.abs(this.field1087) < 0.01F) {
               this.field1087 = 0.0F;
            }
         } else {
            this.field1136 *= 0.85F;
            this.field1087 *= 0.85F;
         }

         this.field1196 = var3;
         this.field0871 = var4;
         float var15 = ScreenLayoutHelper.method2047() / 2.0F + this.field1136;
         float var16 = ScreenLayoutHelper.method1762() / 2.0F + this.field1087;
         switch ((Crosshair.Style)this.field1448.method0492()) {
            case field0621:
               RenderSystem.enableBlend();
               RenderSystem.blendFuncSeparate(770, 1, 0, 1);
               RenderSystem.disableCull();
               RenderSystem.depthMask(false);
               this.method1471(var2, var15, var16, this.field0985.method0492(), this.field0190.method0492(), this.field1550.method1726());
               RenderSystem.depthMask(true);
               RenderSystem.enableCull();
               RenderSystem.disableBlend();
               RenderSystem.defaultBlendFunc();
               break;
            case field0052:
               RenderSystem.enableBlend();
               RenderSystem.blendFuncSeparate(770, 1, 0, 1);
               RenderSystem.disableCull();
               RenderSystem.depthMask(false);
               this.method1463(
                  var2, var15, var16, this.field0470.method0492(), this.field1627.method0492(), this.field0190.method0492(), this.field1550.method1726()
               );
               RenderSystem.depthMask(true);
               RenderSystem.enableCull();
               RenderSystem.disableBlend();
               RenderSystem.defaultBlendFunc();
         }
      }
   }

   private void method1471(class_4587 var1, float var2, float var3, float var4, float var5, Color var6) {
      float var7 = var4 * 2.0F;
      float var8 = var2 - var4;
      float var9 = var3 - var4;
      float var10 = var7 / 2.0F - 1.0F;
      class_5944 var11 = RenderSystem.setShader(field0146);
      if (var11 != null) {
         var11.method_34582("Size").method_1255(var7, var7);
         var11.method_34582("Radius").method_35657(var10, var10, var10, var10);
         var11.method_34582("Thickness").method_1251(var5);
         var11.method_34582("Smoothness").method_1255(1.0F, 1.0F);
         Matrix4f var12 = var1.method_23760().method_23761();
         int var13 = var6.getRGB();
         class_287 var14 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1576);
         var14.method_22918(var12, var8, var9, 0.0F).method_39415(var13);
         var14.method_22918(var12, var8, var9 + var7, 0.0F).method_39415(var13);
         var14.method_22918(var12, var8 + var7, var9 + var7, 0.0F).method_39415(var13);
         var14.method_22918(var12, var8 + var7, var9, 0.0F).method_39415(var13);
         class_286.method_43433(var14.method_60800());
      }
   }

   private void method1463(class_4587 var1, float var2, float var3, float var4, float var5, float var6, Color var7) {
      boolean var8 = this.field1136 == 0.0F && this.field1087 == 0.0F;
      float var9 = var8 ? Math.round(var2) : var2;
      float var10 = var8 ? Math.round(var3) : var3;
      var6 = Math.max(var6, 1.0F);
      float var11 = var6 / 2.0F;
      int var12 = var7.getRGB();
      Matrix4f var13 = var1.method_23760().method_23761();
      RenderSystem.setShader(class_10142.field_53876);
      class_287 var14 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1576);
      this.method1384(var14, var13, var9 - var11, var10 - var5 - var4, var6, var4, var12);
      this.method1384(var14, var13, var9 - var11, var10 + var5, var6, var4, var12);
      this.method1384(var14, var13, var9 - var5 - var4, var10 - var11, var4, var6, var12);
      this.method1384(var14, var13, var9 + var5, var10 - var11, var4, var6, var12);
      class_286.method_43433(var14.method_60800());
   }

   private void method1384(class_287 var1, Matrix4f var2, float var3, float var4, float var5, float var6, int var7) {
      var1.method_22918(var2, var3, var4, 0.0F).method_39415(var7);
      var1.method_22918(var2, var3, var4 + var6, 0.0F).method_39415(var7);
      var1.method_22918(var2, var3 + var5, var4 + var6, 0.0F).method_39415(var7);
      var1.method_22918(var2, var3 + var5, var4, 0.0F).method_39415(var7);
   }

   public enum Style implements DisplayNamed {
      field0621("Circle"),
      field0052("Cross");

      private final String field1504;

      Style(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }
}
