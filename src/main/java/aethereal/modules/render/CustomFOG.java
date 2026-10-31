package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10142;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;

public class CustomFOG extends Module {
   private static final class_2960 field0160 = class_2960.method_60655("daamky", "textures/glow.png");
   private final FloatSetting field1450 = new FloatSetting("customfog.distance", 80.0F, 10.0F, 255.0F, 5.0F)
      .method1007("Fog Distance")
      .method0210("Fog render distance in blocks")
      .method2130("Дальность отрисовки");
   private final ColorSetting field0978 = new ColorSetting("customfog.color", 200, 200, 255, 255)
      .method1882()
      .method1007("Fog Color")
      .method0210("Custom fog color")
      .method2130("Цвет тумана");
   private final FloatSetting field0190 = new FloatSetting("customfog.density", 0.3F, 0.05F, 1.0F, 0.05F)
      .method1007("Density")
      .method0210("Density of glowing fog orbs")
      .method2130("Плотность орбиков в тумане");
   private final List<CustomFOG.FogState> field0488 = new ArrayList<>();
   private boolean field1653 = false;

   public CustomFOG() {
      super("CustomFOG", ModuleCategory.field1004, "Controls fog rendering distance and color");
      this.method1013("Управляет дальностью и цветом тумана");
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field1653 = false;
      this.field0488.clear();
   }

   @Override
   public void method2078() {
      super.method2078();
      this.field0488.clear();
      this.field1653 = false;
   }

   @EventHandler
   public void onFog(FogRenderEvent var1) {
      if (!method1974()) {
         Color var2 = this.method1726();
         var1.method0665(this.field1450.method0492());
         var1.method0729(var2.getRGB());
         var1.method1570(true);
      }
   }

   @EventHandler
   public void onRender3D(WorldRenderEvent.GamePass var1) {
      if (!method1974()) {
         float var2 = this.field1450.method0492();
         if (!this.field1653) {
            this.method0665(var2);
            this.field1653 = true;
         }

         this.method1454(var1.method1629(), var2);
      }
   }

   private void method0665(float var1) {
      this.field0488.clear();
      Random var2 = new Random(42L);
      int var3 = 80;

      for (int var4 = 0; var4 < var3; var4++) {
         float var5 = var1 * 0.2F;
         float var6 = var1 * 0.95F;
         float var7 = var5 + var2.nextFloat() * (var6 - var5);
         float var8 = var2.nextFloat() * 6.2832F;
         float var9 = (var2.nextFloat() - 0.4F) * var1 * 0.4F;
         float var10 = var1 * (0.3F + var2.nextFloat() * 0.5F);
         CustomFOG.FogState var11 = new CustomFOG.FogState();
         var11.field0566 = (float)Math.sin(var8) * var7;
         var11.field0003 = var9;
         var11.field1410 = (float)Math.cos(var8) * var7;
         var11.field0957 = var10;
         var11.field0758 = (var7 - var5) / (var6 - var5);
         this.field0488.add(var11);
      }
   }

   private void method1454(class_4587 var1, float var2) {
      Color var3 = this.method1726();
      int var4 = var3.getRed();
      int var5 = var3.getGreen();
      int var6 = var3.getBlue();
      float var7 = this.field0190.method0492();
      RenderSystem.setShader(class_10142.field_53880);
      RenderSystem.setShaderTexture(0, field0160);
      RenderSystem.enableBlend();
      RenderSystem.blendFuncSeparate(770, 1, 0, 1);
      RenderSystem.disableCull();
      RenderSystem.enableDepthTest();
      RenderSystem.depthMask(false);
      class_287 var8 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1575);
      boolean var9 = false;

      for (CustomFOG.FogState var11 : this.field0488) {
         float var12 = var7 * (0.03F + var11.field0758 * var11.field0758 * 0.12F);
         int var13 = class_3532.method_15340((int)(var12 * 255.0F), 0, 255);
         if (var13 > 1) {
            int var14 = var13 << 24 | var4 << 16 | var5 << 8 | var6;
            var1.method_22903();
            var1.method_46416(var11.field0566, var11.field0003, var11.field1410);
            var1.method_22907(field0796.field_1773.method_19418().method_23767());
            float var15 = var11.field0957 * 0.5F;
            Matrix4f var16 = var1.method_23760().method_23761();
            var8.method_22918(var16, -var15, -var15, 0.0F).method_22913(0.0F, 0.0F).method_39415(var14);
            var8.method_22918(var16, -var15, var15, 0.0F).method_22913(0.0F, 1.0F).method_39415(var14);
            var8.method_22918(var16, var15, var15, 0.0F).method_22913(1.0F, 1.0F).method_39415(var14);
            var8.method_22918(var16, var15, -var15, 0.0F).method_22913(1.0F, 0.0F).method_39415(var14);
            var1.method_22909();
            var9 = true;
         }
      }

      if (var9) {
         class_286.method_43433(var8.method_60800());
      }

      RenderSystem.enableDepthTest();
      RenderSystem.depthMask(true);
      RenderSystem.disableBlend();
      RenderSystem.blendFunc(770, 771);
      RenderSystem.enableCull();
   }

   private Color method1726() {
      return this.field0978.method1726();
   }

   private static class FogState {
      float field0566;
      float field0003;
      float field1410;
      float field0957;
      float field0758;
   }
}
