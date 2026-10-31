package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_10149;
import net.minecraft.class_10156;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_5944;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;

public record GlassBorderRenderCommand(RenderSize size, CornerRadius radius, QuadColor color, float thickness, float tintAlpha) implements RenderCommand {
   private static final class_10156 SHADER_KEY = new class_10156(ResourceHelper.method1012("glass_border"), class_290.field_1576, class_10149.field_53930);

   @Override
   public void method1553(Matrix4f var1, float var2, float var3, float var4) {
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableCull();
      float var5 = this.size.method0530();
      float var6 = this.size.method0002();
      class_5944 var7 = RenderSystem.setShader(SHADER_KEY);
      if (var7 == null) {
         RenderSystem.enableCull();
         RenderSystem.disableBlend();
      } else {
         var7.method_34582("Size").method_1255(var5, var6);
         var7.method_34582("Radius").method_35657(this.radius.method0530(), this.radius.method0002(), this.radius.method2047(), this.radius.method1762());
         var7.method_34582("Thickness").method_1251(this.thickness);
         var7.method_34582("TintAlpha").method_1251(this.tintAlpha);
         class_287 var8 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1576);
         var8.method_22918(var1, var2, var3, var4).method_39415(this.color.method0531());
         var8.method_22918(var1, var2, var3 + var6, var4).method_39415(this.color.method0003());
         var8.method_22918(var1, var2 + var5, var3 + var6, var4).method_39415(this.color.method2048());
         var8.method_22918(var1, var2 + var5, var3, var4).method_39415(this.color.method1763());
         class_286.method_43433(var8.method_60800());
         RenderSystem.enableCull();
         RenderSystem.disableBlend();
      }
   }

   public RenderSize method0549() {
      return this.size;
   }

   public CornerRadius method0007() {
      return this.radius;
   }

   public QuadColor method2061() {
      return this.color;
   }

   public float method1762() {
      return this.thickness;
   }

   public float method1603() {
      return this.tintAlpha;
   }
}
